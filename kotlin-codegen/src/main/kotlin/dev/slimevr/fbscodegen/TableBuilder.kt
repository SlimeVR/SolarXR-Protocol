package dev.slimevr.fbscodegen

import com.squareup.kotlinpoet.*

internal fun buildTableType(generator: Generator, decl: TableDecl, schema: Schema): TypeSpec {
    val selfClass = TypeSpec.classBuilder(decl.name)
        .addKdoc(decl.comments.joinToString("\n"))
        .apply {
            if (decl.fields.isNotEmpty()) addModifiers(KModifier.DATA)
            generator.unionMembers(schema, decl.name)?.forEach { addSuperinterface(it) }
        }

    if (decl.fields.isNotEmpty()) {
        val ctor = FunSpec.constructorBuilder()
        val symbols = generator.symbolTable
        decl.fields.forEach { f ->
            val kt = f.type.toKotlinType(symbols, schema, nullable = f.isNullable(symbols, schema))
            // required fields have no default in the schema and no natural non-null placeholder
            // for non-scalar types (tables/vectors/strings), so callers must always supply one.
            ctor.addParameter(
                ParameterSpec.builder(snakeToCamel(f.name), kt)
                    .apply {
                        f.deprecatedAnnotation()?.let { addAnnotation(it) }
                        if (!f.required) defaultValue(f.kotlinDefault(symbols, schema))
                    }
                    .build()
            )
            selfClass.addProperty(
                PropertySpec.builder(snakeToCamel(f.name), kt)
                    .initializer(snakeToCamel(f.name))
                    .build()
            )
        }
        selfClass.primaryConstructor(ctor.build())
    }
    selfClass.addFunction(buildTableEncode(generator, decl, schema))
    selfClass.addType(buildTableCompanion(generator, decl, schema))
    return selfClass.build()
}

internal fun buildTableCompanion(generator: Generator, decl: TableDecl, schema: Schema): TypeSpec {
    val selfClass = ClassName("", decl.name)
    val layouts = buildFieldLayouts(generator, decl, schema)
    val symbols = generator.symbolTable

    val decodeFun = FunSpec.builder("decode")
        .addParameter("bb", generator.flatBufferReader)
        .addParameter("tableOffset", INT)
        .returns(selfClass)
        .apply {
            if (layouts.isEmpty()) {
                addStatement("return %T()", selfClass)
            } else {
                // Deprecated fields are inert: never read from the buffer, always their default.
                val probedLayouts = layouts.filterNot { it.field.deprecated }
                if (probedLayouts.isNotEmpty()) {
                    addStatement("val vtableOffset = tableOffset - bb.getInt(tableOffset)")
                    addStatement("val vtableSize = bb.getShort(vtableOffset).toInt()")
                    addCode("\n")

                    probedLayouts.forEach { layout ->
                        val p = layout.propName
                        if (layout.isUnion) {
                            val ts = layout.typeSlotByte
                            val ds = layout.dataSlotByte
                            addStatement(
                                "val __type_$p = if (vtableSize > %L && bb.getShort(vtableOffset + %L).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + %L).toInt()) else 0",
                                ts, ts, ts
                            )
                            addStatement(
                                "val __offset_$p = if (vtableSize > %L) bb.getShort(vtableOffset + %L).toInt() else 0",
                                ds, ds
                            )
                        } else {
                            val ds = layout.dataSlotByte
                            addStatement(
                                "val __offset_$p = if (vtableSize > %L) bb.getShort(vtableOffset + %L).toInt() else 0",
                                ds, ds
                            )
                        }
                    }
                    addCode("\n")
                }

                val fieldExprs = CodeBlock.builder()
                layouts.forEachIndexed { i, layout ->
                    if (layout.field.deprecated) {
                        fieldExprs.add("    ${layout.propName} = ${layout.field.kotlinDefault(symbols, schema)}")
                    } else {
                        fieldExprs.add("    ${layout.propName} = %L", tableFieldDecodeExpr(generator, layout, schema))
                    }
                    if (i < layouts.size - 1) fieldExprs.add(",\n")
                }
                addStatement("return %T(\n%L\n)", selfClass, fieldExprs.build())
            }
        }
        .build()

    val companionBuilder = TypeSpec.companionObjectBuilder().addFunction(decodeFun)
    if (decl.rootType) {
        companionBuilder.addFunction(
            FunSpec.builder("fromByteBuffer")
                .addParameter("bb", generator.flatBufferReader)
                .returns(selfClass)
                .addStatement("val root = bb.getInt(0) + 0")
                .addStatement("return decode(bb, root)")
                .build()
        )
    }
    return companionBuilder.build()
}

internal fun buildTableEncode(generator: Generator, decl: TableDecl, schema: Schema): FunSpec {
    val layouts = buildFieldLayouts(generator, decl, schema)
    val visibleLayouts = layouts.filterNot { it.field.deprecated }
    // Deprecated fields keep reserving vtable slots (spec: accessors go away, the slot doesn't).
    val totalSlots = layouts.sumOf { if (it.isUnion) 2 else 1 }
    val symbols = generator.symbolTable

    return FunSpec.builder("encode")
        .addParameter("builder", generator.flatBufferWriter)
        .returns(INT)
        .apply {
            visibleLayouts.forEach { layout ->
                val p = layout.propName
                val f = layout.field
                when (val type = f.type) {
                    is RefType -> if (layout.isUnion) {
                        val typeName = generator.resolveRefTypeName(type.name, schema)
                        addStatement("val __off_$p = $p?.let { %T.encode(it, builder) }", typeName)
                        addStatement("val __type_$p = $p?.let { %T.typeIndex(it) } ?: 0.toByte()", typeName)
                    } else {
                        when (generator.resolveDecl(type.name, schema)) {
                            is EnumDecl -> {}
                            is StructDecl -> {}
                            else -> addStatement("val __off_$p = $p?.encode(builder)")
                        }
                    }
                    is VectorType ->
                        addStatement("val __off_$p = $p?.let { %L }", vectorEncodeExpr(generator, type, schema, f.forceAlign))
                    is ScalarType -> if (type.kind == ScalarKind.STRING) {
                        addStatement("val __off_$p = $p?.let { builder.createString(it) }")
                    }
                    is ArrayType -> error("Arrays are only valid in struct fields: ${f.name}")
                }
            }
            if (visibleLayouts.isNotEmpty()) addCode("\n")
            addStatement("builder.startTable(%L)", totalSlots)

            visibleLayouts.forEach { layout ->
                val p = layout.propName
                val f = layout.field
                val slot = layout.slotIndex
                when (val type = f.type) {
                    is RefType -> if (layout.isUnion) {
                        addStatement("builder.addByte(%L, __type_$p, 0)", slot)
                        addStatement("__off_$p?.let { builder.addOffset(%L, it, 0) }", slot + 1)
                    } else when (val refDecl = generator.resolveDecl(type.name, schema)) {
                        is EnumDecl -> {
                            val info = refDecl.baseType.info
                            val default = f.builderDefault(symbols, schema)
                            when {
                                f.isNullable(symbols, schema) ->
                                    addStatement("if ($p != null) { builder.forceDefaults(true); builder.%L(%L, $p.value%L, %L); builder.forceDefaults(false) }", info.adder, slot, info.writeConv, info.zeroBuilder)
                                // required: always write, even if the value equals the natural default,
                                // since decode has no fallback to fall back to for a required field.
                                f.required ->
                                    addStatement("builder.forceDefaults(true); builder.%L(%L, $p.value%L, %L); builder.forceDefaults(false)", info.adder, slot, info.writeConv, info.zeroBuilder)
                                else ->
                                    addStatement("builder.%L(%L, $p.value%L, $default)", info.adder, slot, info.writeConv)
                            }
                        }
                        is StructDecl ->
                            addStatement("$p?.let { builder.addStruct(%L, it.encode(builder), 0) }", slot)
                        else ->
                            addStatement("__off_$p?.let { builder.addOffset(%L, it, 0) }", slot)
                    }
                    is VectorType ->
                        addStatement("__off_$p?.let { builder.addOffset(%L, it, 0) }", slot)
                    is ScalarType -> when (type.kind) {
                        ScalarKind.STRING ->
                            addStatement("__off_$p?.let { builder.addOffset(%L, it, 0) }", slot)
                        ScalarKind.BOOL -> when {
                            f.isNullable(symbols, schema) ->
                                addStatement("if ($p != null) { builder.forceDefaults(true); builder.addBoolean(%L, $p, false); builder.forceDefaults(false) }", slot)
                            f.required ->
                                addStatement("builder.forceDefaults(true); builder.addBoolean(%L, $p, false); builder.forceDefaults(false)", slot)
                            else ->
                                addStatement("builder.addBoolean(%L, $p, %L)", slot, f.builderDefault(symbols, schema))
                        }
                        else -> {
                            val info = type.kind.info
                            val default = f.builderDefault(symbols, schema)
                            when {
                                f.isNullable(symbols, schema) ->
                                    addStatement("if ($p != null) { builder.forceDefaults(true); builder.%L(%L, $p%L, %L); builder.forceDefaults(false) }", info.adder, slot, info.writeConv, info.zeroBuilder)
                                f.required ->
                                    addStatement("builder.forceDefaults(true); builder.%L(%L, $p%L, %L); builder.forceDefaults(false)", info.adder, slot, info.writeConv, info.zeroBuilder)
                                else ->
                                    addStatement("builder.%L(%L, $p%L, %L)", info.adder, slot, info.writeConv, default)
                            }
                        }
                    }
                    is ArrayType -> error("Arrays are only valid in struct fields: ${f.name}")
                }
            }
            addStatement("return builder.endTable()")
        }
        .build()
}

internal fun tableFieldDecodeExpr(generator: Generator, layout: TableFieldLayout, schema: Schema): CodeBlock {
    val f = layout.field
    val p = layout.propName
    val symbols = generator.symbolTable
    val off = "__offset_$p"
    val abs = "tableOffset + $off"
    val fallback = if (f.required) "error(\"Table field '${f.name}' is required but missing\")" else f.kotlinDefault(symbols, schema)

    if (layout.isUnion) {
        val typeName = when (val type = f.type) {
            is RefType -> generator.resolveRefTypeName(type.name, schema)
            else -> error("Union field must be a reference type: ${f.name}")
        }
        return CodeBlock.of("if ($off != 0) %T.decode(__type_$p, bb, $abs + bb.getInt($abs)) else $fallback", typeName)
    }

    return when (val t = f.type) {
        is ScalarType -> scalarTableReadExpr(generator, t.kind, off, abs, fallback)
        is RefType -> when (val decl = generator.resolveDecl(t.name, schema)) {
            is EnumDecl -> {
                val info = decl.baseType.info
                val typeName = generator.resolveRefTypeName(t.name, schema)
                val nullable = f.isNullable(symbols, schema)
                if (nullable) {
                    CodeBlock.of("if ($off != 0) %T.fromValue(bb.${info.bbGetter}($abs)${info.readConv}) else $fallback", typeName)
                } else {
                    CodeBlock.of("if ($off != 0) %T.fromValue(bb.${info.bbGetter}($abs)${info.readConv}) ?: %L else %L", typeName, fallback, fallback)
                }
            }
            is StructDecl ->
                CodeBlock.of("if ($off != 0) %T.decode(bb, $abs) else $fallback", generator.resolveRefTypeName(t.name, schema))
            else ->
                CodeBlock.of("if ($off != 0) %T.decode(bb, $abs + bb.getInt($abs)) else $fallback", generator.resolveRefTypeName(t.name, schema))
        }
        is VectorType -> {
            val elem = t.element
            CodeBlock.of("if ($off != 0) { val vecOff = $abs + bb.getInt($abs); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> %L } } else $fallback", vectorElemReadExpr(generator, elem, schema, "vecOff + 4 + i * ${vectorElemSize(generator, elem, schema)}"))
        }
        is ArrayType -> error("Arrays are only valid in struct fields: ${f.name}")
    }
}

/**
 * Assigns vtable slots. If any field declares an explicit `(id: n)`, all fields must
 * (spec: ids are all-or-nothing) and slots follow id order instead of declaration order;
 * a union's implicit type slot takes `id - 1` for its declared value id. Ids (including the
 * implicit type slot of a union) must form a contiguous range starting at 0. Deprecated
 * fields still consume a slot to keep later fields' positions stable across schema versions.
 */
private fun buildFieldLayouts(generator: Generator, decl: TableDecl, schema: Schema): List<TableFieldLayout> {
    data class Prelim(val field: Field, val propName: String, val isUnion: Boolean)

    val prelim = decl.fields.map { f ->
        require(!f.key) { "Table '${decl.name}' field '${f.name}': (key) is not supported by this codegen (would require sorted-vector/binary-search codegen)" }
        val isUnion = f.type is RefType && generator.resolveDecl((f.type as RefType).name, schema) is UnionDecl
        Prelim(f, snakeToCamel(f.name), isUnion)
    }

    val explicitIdCount = prelim.count { it.field.id != null }
    require(explicitIdCount == 0 || explicitIdCount == prelim.size) {
        "Table '${decl.name}': either all fields must declare (id: n) or none may"
    }

    val valueIds = if (explicitIdCount == 0) {
        var next = 0
        prelim.map { p -> (if (p.isUnion) next + 1 else next).also { next += if (p.isUnion) 2 else 1 } }
    } else {
        prelim.map { requireNotNull(it.field.id) }
    }

    val usedIds = prelim.indices.flatMap { i -> if (prelim[i].isUnion) listOf(valueIds[i] - 1, valueIds[i]) else listOf(valueIds[i]) }
    require(usedIds.sorted() == usedIds.indices.toList()) {
        "Table '${decl.name}': field ids must form a contiguous range starting at 0 (got ${usedIds.sorted()})"
    }

    return prelim.mapIndexed { i, p ->
        val valueId = valueIds[i]
        if (p.isUnion) {
            val typeId = valueId - 1
            TableFieldLayout(p.field, p.propName, 4 + typeId * 2, 4 + valueId * 2, typeId, true)
        } else {
            TableFieldLayout(p.field, p.propName, -1, 4 + valueId * 2, valueId, false)
        }
    }
}

internal data class TableFieldLayout(
    val field: Field,
    val propName: String,
    val typeSlotByte: Int,
    val dataSlotByte: Int,
    val slotIndex: Int,
    val isUnion: Boolean,
)

private fun scalarTableReadExpr(generator: Generator, kind: ScalarKind, off: String, abs: String, absent: String): CodeBlock {
    val info = kind.info
    return when (kind) {
        ScalarKind.BOOL -> CodeBlock.of("if ($off != 0) bb.get($abs) != 0.toByte() else $absent")
        ScalarKind.STRING -> CodeBlock.of("if ($off != 0) %M(bb, $abs) else $absent", generator.readFlatBufferString)
        else -> CodeBlock.of("if ($off != 0) bb.${info.bbGetter}($abs)${info.readConv} else $absent")
    }
}

private fun vectorElemReadExpr(generator: Generator, elem: Type, schema: Schema, absExpr: String): CodeBlock = when (elem) {
    is ScalarType -> {
        val info = elem.kind.info
        when (elem.kind) {
            ScalarKind.BOOL -> CodeBlock.of("bb.get($absExpr) != 0.toByte()")
            ScalarKind.STRING -> CodeBlock.of("%M(bb, $absExpr)", generator.readFlatBufferString)
            else -> CodeBlock.of("bb.${info.bbGetter}($absExpr)${info.readConv}")
        }
    }
    is RefType -> when (val refDecl = generator.resolveDecl(elem.name, schema)) {
        is EnumDecl -> {
            val info = refDecl.baseType.info
            CodeBlock.of("%T.fromValue(bb.${info.bbGetter}($absExpr)${info.readConv})", generator.resolveRefTypeName(elem.name, schema))
        }
        is StructDecl -> CodeBlock.of("%T.decode(bb, $absExpr)", generator.resolveRefTypeName(elem.name, schema))
        else -> {
            val typeName = generator.resolveRefTypeName(elem.name, schema)
            CodeBlock.of("if (bb.getInt($absExpr) != 0) %T.decode(bb, $absExpr + bb.getInt($absExpr)) else null", typeName)
        }
    }
    is VectorType -> error("nested vectors not supported")
    is ArrayType -> error("Arrays are not valid vector elements")
}

private fun vectorElemSize(generator: Generator, elem: Type, schema: Schema? = null): Int = when (elem) {
    is ScalarType -> elem.kind.info.size
    is RefType -> when (val refDecl = if (schema != null) generator.resolveDecl(elem.name, schema) else null) {
        is EnumDecl -> refDecl.baseType.info.size
        is StructDecl -> requireStructLayout(generator, refDecl, requireNotNull(schema)).size
        else -> 4
    }
    else -> 4
}

private fun vectorEncodeExpr(generator: Generator, type: VectorType, schema: Schema, forceAlign: Int?): CodeBlock {
	return when (val elem = type.element) {
        is ScalarType -> when (elem.kind) {
            ScalarKind.STRING ->
                CodeBlock.of("builder.createVectorOfTables(it.map { s -> builder.createString(s) }.toIntArray())")
            ScalarKind.INT8, ScalarKind.UINT8 ->
                CodeBlock.of("builder.createByteVector(it.map { b -> b${elem.kind.info.writeConv} }.toByteArray())")
            else -> vectorScalarEncodeExpr(elem.kind, "it", forceAlign)
        }
        is RefType -> when (val refDecl = generator.resolveDecl(elem.name, schema)) {
            is EnumDecl -> {
                when (refDecl.baseType) {
                    ScalarKind.INT8, ScalarKind.UINT8 ->
                        CodeBlock.of("builder.createByteVector(it.map { e -> e.value${refDecl.baseType.info.writeConv} }.toByteArray())")
                    else -> vectorScalarEncodeExpr(refDecl.baseType, "it.map { e -> e.value }", forceAlign)
                }
            }
            is StructDecl -> vectorStructEncodeExpr(generator, refDecl, schema, forceAlign)
            else -> CodeBlock.of("builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray())")
        }
        is VectorType -> error("nested vectors not supported")
        is ArrayType -> error("Arrays are not valid vector elements")
    }
}

private fun vectorScalarEncodeExpr(kind: ScalarKind, valuesExpr: String, forceAlign: Int?): CodeBlock {
    val info = kind.info
    val alignment = requireValidForceAlign(forceAlign, info.alignment)
    val valueExpr = kind.vectorWriteValue("value")
    return CodeBlock.builder()
        .add("run { val values = $valuesExpr; ")
        .add("builder.startVector(%L, values.size, %L); ", info.size, alignment)
        .add("for (value in values.asReversed()) builder.%L(%L); ", info.putter, valueExpr)
        .add("builder.endVector() }")
        .build()
}

private fun vectorStructEncodeExpr(generator: Generator, decl: StructDecl, schema: Schema, forceAlign: Int?): CodeBlock {
    val layout = requireStructLayout(generator, decl, schema)
    val alignment = requireValidForceAlign(forceAlign, layout.alignment)
    return CodeBlock.of("run { val values = it; builder.startVector(%L, values.size, %L); for (value in values.asReversed()) value.encode(builder); builder.endVector() }", layout.size, alignment)
}

private fun requireValidForceAlign(forceAlign: Int?, natural: Int): Int {
    if (forceAlign == null) return natural
    require(forceAlign >= natural && (forceAlign and (forceAlign - 1)) == 0) {
        "force_align must be a power of two >= the natural alignment ($natural), got $forceAlign"
    }
    return forceAlign
}
