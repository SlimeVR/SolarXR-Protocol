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
            val default = f.kotlinDefault(symbols, schema)
            val deprecated = f.deprecatedAnnotation()
            ctor.addParameter(
                ParameterSpec.builder(snakeToCamel(f.name), kt)
                    .apply { if (deprecated != null) addAnnotation(deprecated) }
                    .defaultValue(default)
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

    val decodeFun = FunSpec.builder("decode")
        .addParameter("bb", generator.flatBufferReader)
        .addParameter("tableOffset", INT)
        .returns(selfClass)
        .apply {
            if (layouts.isEmpty()) {
                addStatement("return %T()", selfClass)
            } else {
                addStatement("val vtableOffset = tableOffset - bb.getInt(tableOffset)")
                addStatement("val vtableSize = bb.getShort(vtableOffset).toInt()")
                addCode("\n")

                layouts.forEach { layout ->
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

                val fieldExprs = CodeBlock.builder()
                layouts.forEachIndexed { i, layout ->
                    fieldExprs.add("    ${layout.propName} = %L", tableFieldDecodeExpr(generator, layout, schema))
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
    val totalSlots = layouts.sumOf { if (it.isUnion) 2 else 1 }
    val symbols = generator.symbolTable

    return FunSpec.builder("encode")
        .addParameter("builder", generator.flatBufferWriter)
        .returns(INT)
        .apply {
            layouts.forEach { layout ->
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
                        addStatement("val __off_$p = $p?.let { %L }", vectorEncodeExpr(generator, type, schema))
                    is ScalarType -> if (type.kind == ScalarKind.STRING) {
                        addStatement("val __off_$p = $p?.let { builder.createString(it) }")
                    }
                }
            }
            if (layouts.isNotEmpty()) addCode("\n")
            addStatement("builder.startTable(%L)", totalSlots)

            layouts.forEach { layout ->
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
                            if (f.isNullable(symbols, schema)) {
                                addStatement("if ($p != null) { builder.forceDefaults(true); builder.%L(%L, $p.value%L, %L); builder.forceDefaults(false) }", info.adder, slot, info.writeConv, info.zeroBuilder)
                            } else {
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
                        ScalarKind.BOOL -> if (f.isNullable(symbols, schema)) {
                            addStatement("if ($p != null) { builder.forceDefaults(true); builder.addBoolean(%L, $p, false); builder.forceDefaults(false) }", slot)
                        } else {
                            addStatement("builder.addBoolean(%L, $p, %L)", slot, f.builderDefault(symbols, schema))
                        }
                        else -> {
                            val info = type.kind.info
                            val default = f.builderDefault(symbols, schema)
                            if (f.isNullable(symbols, schema)) {
                                addStatement("if ($p != null) { builder.forceDefaults(true); builder.%L(%L, $p%L, %L); builder.forceDefaults(false) }", info.adder, slot, info.writeConv, info.zeroBuilder)
                            } else {
                                addStatement("builder.%L(%L, $p%L, %L)", info.adder, slot, info.writeConv, default)
                            }
                        }
                    }
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

    if (layout.isUnion) {
        val typeName = when (val type = f.type) {
            is RefType -> generator.resolveRefTypeName(type.name, schema)
            else -> error("Union field must be a reference type: ${f.name}")
        }
        return CodeBlock.of("if ($off != 0) %T.decode(__type_$p, bb, $abs + bb.getInt($abs)) else null", typeName)
    }

    return when (val t = f.type) {
        is ScalarType -> scalarTableReadExpr(t.kind, off, abs, f.kotlinDefault(symbols, schema))
        is RefType -> when (val decl = generator.resolveDecl(t.name, schema)) {
            is EnumDecl -> {
                val info = decl.baseType.info
                val typeName = generator.resolveRefTypeName(t.name, schema)
                val nullable = f.isNullable(symbols, schema)
                val absent = f.kotlinDefault(symbols, schema)
                if (nullable) {
                    CodeBlock.of("if ($off != 0) %T.fromValue(bb.${info.bbGetter}($abs)${info.readConv}) else $absent", typeName)
                } else {
                    CodeBlock.of("if ($off != 0) %T.fromValue(bb.${info.bbGetter}($abs)${info.readConv}) ?: %L else %L", typeName, absent, absent)
                }
            }
            is StructDecl ->
                CodeBlock.of("if ($off != 0) %T.decode(bb, $abs) else null", generator.resolveRefTypeName(t.name, schema))
            else ->
                CodeBlock.of("if ($off != 0) %T.decode(bb, $abs + bb.getInt($abs)) else null", generator.resolveRefTypeName(t.name, schema))
        }
        is VectorType -> {
            val elem = t.element
            CodeBlock.of("if ($off != 0) { val vecOff = $abs + bb.getInt($abs); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> %L } } else null", vectorElemReadExpr(generator, elem, schema, "vecOff + 4 + i * ${vectorElemSize(generator, elem, schema)}"))
        }
    }
}

private fun buildFieldLayouts(generator: Generator, decl: TableDecl, schema: Schema): List<TableFieldLayout> {
    val layouts = mutableListOf<TableFieldLayout>()
    var slotByte = 4
    var slotIndex = 0
    decl.fields.forEach { f ->
        val propName = snakeToCamel(f.name)
        when (val type = f.type) {
            is RefType -> if (generator.resolveDecl(type.name, schema) is UnionDecl) {
                layouts += TableFieldLayout(f, propName, slotByte, slotByte + 2, slotIndex, true)
                slotByte += 4
                slotIndex += 2
            } else {
                layouts += TableFieldLayout(f, propName, -1, slotByte, slotIndex, false)
                slotByte += 2
                slotIndex += 1
            }
            else -> {
                layouts += TableFieldLayout(f, propName, -1, slotByte, slotIndex, false)
                slotByte += 2
                slotIndex += 1
            }
        }
    }
    return layouts
}

internal data class TableFieldLayout(
    val field: Field,
    val propName: String,
    val typeSlotByte: Int,
    val dataSlotByte: Int,
    val slotIndex: Int,
    val isUnion: Boolean,
)

private fun scalarTableReadExpr(kind: ScalarKind, off: String, abs: String, absent: String): CodeBlock {
    val info = kind.info
    return when (kind) {
        ScalarKind.BOOL -> CodeBlock.of("if ($off != 0) bb.get($abs) != 0.toByte() else $absent")
        ScalarKind.STRING -> CodeBlock.of("if ($off != 0) %M(bb, $abs) else null", readFlatBufferString)
        else -> CodeBlock.of("if ($off != 0) bb.${info.bbGetter}($abs)${info.readConv} else $absent")
    }
}

private fun vectorElemReadExpr(generator: Generator, elem: Type, schema: Schema, absExpr: String): CodeBlock = when (elem) {
    is ScalarType -> {
        val info = elem.kind.info
        when (elem.kind) {
            ScalarKind.BOOL -> CodeBlock.of("bb.get($absExpr) != 0.toByte()")
            ScalarKind.STRING -> CodeBlock.of("%M(bb, $absExpr)", readFlatBufferString)
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
    is VectorType -> "error(\"nested vectors not supported\")".let { CodeBlock.of(it) }
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

private fun vectorEncodeExpr(generator: Generator, type: VectorType, schema: Schema): CodeBlock {
    val elem = type.element
    return when (elem) {
        is ScalarType -> when (elem.kind) {
            ScalarKind.STRING ->
                CodeBlock.of("builder.createVectorOfTables(it.map { s -> builder.createString(s) }.toIntArray())")
            ScalarKind.INT8, ScalarKind.UINT8 ->
                CodeBlock.of("builder.createByteVector(it.map { b -> b${elem.kind.info.writeConv} }.toByteArray())")
            else -> vectorScalarEncodeExpr(elem.kind, "it")
        }
        is RefType -> when (val refDecl = generator.resolveDecl(elem.name, schema)) {
            is EnumDecl -> {
                when (refDecl.baseType) {
                    ScalarKind.INT8, ScalarKind.UINT8 ->
                        CodeBlock.of("builder.createByteVector(it.map { e -> e.value${refDecl.baseType.info.writeConv} }.toByteArray())")
                    else -> vectorScalarEncodeExpr(refDecl.baseType, "it.map { e -> e.value }")
                }
            }
            is StructDecl -> vectorStructEncodeExpr(generator, refDecl, schema)
            else -> CodeBlock.of("builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray())")
        }
        is VectorType -> "error(\"nested vectors not supported\")".let { CodeBlock.of(it) }
    }
}

private fun vectorScalarEncodeExpr(kind: ScalarKind, valuesExpr: String): CodeBlock {
    val info = kind.info
    val valueExpr = scalarVectorWriteValue("value", kind)
    return CodeBlock.builder()
        .add("run { val values = $valuesExpr; ")
        .add("builder.startVector(%L, values.size, %L); ", info.size, info.alignment)
        .add("for (value in values.asReversed()) builder.%L(%L); ", info.putter, valueExpr)
        .add("builder.endVector() }")
        .build()
}

private fun vectorStructEncodeExpr(generator: Generator, decl: StructDecl, schema: Schema): CodeBlock {
    val layout = requireStructLayout(generator, decl, schema)
    return CodeBlock.of("run { val values = it; builder.startVector(%L, values.size, %L); for (value in values.asReversed()) value.encode(builder); builder.endVector() }", layout.size, layout.alignment)
}

private fun scalarVectorWriteValue(valueExpr: String, kind: ScalarKind): CodeBlock = when (kind) {
    ScalarKind.BOOL -> CodeBlock.of("if ($valueExpr) 1.toByte() else 0.toByte()")
    else -> CodeBlock.of("$valueExpr${kind.info.writeConv}")
}
