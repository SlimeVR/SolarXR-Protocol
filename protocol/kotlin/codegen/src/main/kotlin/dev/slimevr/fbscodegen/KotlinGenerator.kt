package dev.slimevr.fbscodegen

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy

/**
 * Generates idiomatic Kotlin wrappers over the raw FlatBuffers binary protocol.
 *
 * Design principles:
 *  - structs → `data class` with companion `decode(bb, offset)` and instance `encode(builder)`.
 *  - tables  → `data class` with nullable fields, companion `decode(bb, offset)`, instance `encode(builder)`.
 *  - enums   → `enum class` with numeric `value` + companion `fromValue`.
 *  - unions  → `sealed interface`; variant tables implement it directly.
 *              Companion has `decode(type, bb, offset)`, `encode(value, builder)`, `typeIndex(value)`.
 *
 * The generated code depends only on `com.google.flatbuffers:flatbuffers-java` and the Kotlin stdlib.
 */
class KotlinGenerator(
    private val allSchemas: List<FbsSchema>,
) {
    private val flatBufferBuilder = ClassName("com.google.flatbuffers", "FlatBufferBuilder")
    private val byteBuffer = ClassName("java.nio", "ByteBuffer")

    // ── Union membership pre-computation ─────────────────────────────────────

    /** (namespace, typeName) → sealed interface ClassNames the type must implement. */
    private val unionMemberships: Map<Pair<String, String>, List<ClassName>> by lazy {
        val map = mutableMapOf<Pair<String, String>, MutableList<ClassName>>()
        allSchemas.forEach { schema ->
            schema.declarations.filterIsInstance<FbsUnion>().forEach { union ->
                val unionClass = ClassName(schema.namespace, union.name)
                union.variants.forEach { variantRef ->
                    val simple = variantRef.substringAfterLast('.')
                    val ns = if (variantRef.contains('.')) variantRef.substringBeforeLast('.')
                    else allSchemas.firstOrNull { s -> s.declarations.any { it.name == simple } }?.namespace
                        ?: schema.namespace
                    map.getOrPut(ns to simple) { mutableListOf() } += unionClass
                }
            }
        }
        map
    }

    // ── Entry point ───────────────────────────────────────────────────────────

    fun generate(): List<FileSpec> = allSchemas.map { schema ->
        val file = FileSpec.builder(schema.namespace, snakeToCamel(schema.fileName).replaceFirstChar { it.uppercase() })
        schema.declarations.forEach { decl ->
            when (decl) {
                is FbsEnum -> file.addType(generateEnum(decl))
                is FbsStruct -> file.addType(generateStruct(decl, schema))
                is FbsTable -> file.addType(generateTable(decl, schema))
                is FbsUnion -> file.addType(generateUnion(decl, schema))
            }
        }
        file.build()
    }

    // ── Enum ──────────────────────────────────────────────────────────────────

    private fun generateEnum(decl: FbsEnum): TypeSpec {
        val enumClass = ClassName("", decl.name)
        val valueType = scalarKindToTypeName(decl.baseType)

        val builder = TypeSpec.enumBuilder(decl.name)
            .addKdoc(decl.comments.joinToString("\n"))
            .primaryConstructor(
                FunSpec.constructorBuilder().addParameter("value", valueType).build()
            )
            .addProperty(PropertySpec.builder("value", valueType).initializer("value").build())

        var nextValue = 0L
        decl.values.forEach { v ->
            val actualValue = v.value ?: nextValue
            nextValue = actualValue + 1
            val literal = when (decl.baseType) {
                ScalarKind.UINT8 -> "${actualValue}.toUByte()"
                ScalarKind.UINT16 -> "${actualValue}.toUShort()"
                ScalarKind.UINT32 -> "${actualValue}u"
                ScalarKind.UINT64 -> "${actualValue}uL"
                else -> "$actualValue"
            }
            builder.addEnumConstant(
                v.name,
                TypeSpec.anonymousClassBuilder()
                    .addKdoc(v.comments.joinToString("\n"))
                    .addSuperclassConstructorParameter(literal)
                    .build()
            )
        }
        builder.addType(
            TypeSpec.companionObjectBuilder()
                .addFunction(
                    FunSpec.builder("fromValue")
                        .addParameter("value", valueType)
                        .returns(enumClass.copy(nullable = true))
                        .addStatement("return entries.firstOrNull { it.value == value }")
                        .build()
                )
                .build()
        )
        return builder.build()
    }

    // ── Struct ────────────────────────────────────────────────────────────────

    private fun generateStruct(decl: FbsStruct, schema: FbsSchema): TypeSpec {
        data class FieldLayout(val field: FbsField, val offset: Int, val size: Int)
        val layout = mutableListOf<FieldLayout>()
        var currentOffset = 0
        decl.fields.forEach { f ->
            val size = structFieldSize(f.type)
            layout += FieldLayout(f, currentOffset, size)
            currentOffset += size
        }

        // companion decode
        val decodeFun = FunSpec.builder("decode")
            .addParameter("bb", byteBuffer)
            .addParameter("offset", INT)
            .returns(ClassName("", decl.name))
            .apply {
                val args = layout.joinToString(", ") { (f, off, _) ->
                    val getter = bbGetterForScalarKind(scalarKindOfStructField(f.type))
                    val conv = bbReadConversion(scalarKindOfStructField(f.type))
                    "${snakeToCamel(f.name)} = bb.$getter(offset + $off)$conv"
                }
                addStatement("return %T($args)", ClassName("", decl.name))
            }
            .build()

        // instance encode
        val encodeFun = FunSpec.builder("encode")
            .addParameter("builder", flatBufferBuilder)
            .returns(INT)
            .apply {
                addStatement("builder.prep(%L, %L)", layout.firstOrNull()?.size ?: 1, currentOffset)
                layout.reversed().forEach { (f, _, _) ->
                    val kind = scalarKindOfStructField(f.type)
                    val putter = bbPutterForScalarKind(kind)
                    val name = snakeToCamel(f.name)
                    val conv = fbWriteConversion(kind)
                    addStatement("builder.$putter($name$conv)")
                }
                addStatement("return builder.offset()")
            }
            .build()

        val selfClass = TypeSpec.classBuilder(decl.name)
            .addKdoc(decl.comments.joinToString("\n"))
            .addModifiers(KModifier.DATA)
            .apply {
                unionMemberships[schema.namespace to decl.name]?.forEach { addSuperinterface(it) }
            }
        val ctor = FunSpec.constructorBuilder()
        decl.fields.forEach { f ->
            val kt = fieldTypeToKotlin(f.type, schema, nullable = false)
            ctor.addParameter(snakeToCamel(f.name), kt)
            selfClass.addProperty(PropertySpec.builder(snakeToCamel(f.name), kt).initializer(snakeToCamel(f.name)).build())
        }
        selfClass.primaryConstructor(ctor.build())
        selfClass.addFunction(encodeFun)
        selfClass.addType(TypeSpec.companionObjectBuilder().addFunction(decodeFun).build())
        return selfClass.build()
    }

    // ── Table ─────────────────────────────────────────────────────────────────

    private fun generateTable(decl: FbsTable, schema: FbsSchema): TypeSpec {
        // data class requires at least one property; use plain class for empty tables
        val selfClass = TypeSpec.classBuilder(decl.name)
            .addKdoc(decl.comments.joinToString("\n"))
            .apply {
                if (decl.fields.isNotEmpty()) addModifiers(KModifier.DATA)
                unionMemberships[schema.namespace to decl.name]?.forEach { addSuperinterface(it) }
            }

        if (decl.fields.isNotEmpty()) {
            val ctor = FunSpec.constructorBuilder()
            decl.fields.forEach { f ->
                val kt = fieldTypeToKotlin(f.type, schema, nullable = true)
                ctor.addParameter(ParameterSpec.builder(snakeToCamel(f.name), kt).defaultValue("null").build())
                selfClass.addProperty(PropertySpec.builder(snakeToCamel(f.name), kt).initializer(snakeToCamel(f.name)).build())
            }
            selfClass.primaryConstructor(ctor.build())
        }
        selfClass.addFunction(generateTableEncode(decl, schema))
        selfClass.addType(generateTableCompanion(decl, schema))
        return selfClass.build()
    }

    // ── Table field layout ────────────────────────────────────────────────────

    private data class TableFieldLayout(
        val field: FbsField,
        val propName: String,
        /** vtable byte for the type-byte slot (unions only, else -1) */
        val typeSlotByte: Int,
        /** vtable byte for the data slot */
        val dataSlotByte: Int,
        /** slot index of the type slot (unions) or data slot (others), for startTable */
        val slotIndex: Int,
        val isUnion: Boolean,
    )

    private fun buildFieldLayouts(decl: FbsTable, schema: FbsSchema): List<TableFieldLayout> {
        val layouts = mutableListOf<TableFieldLayout>()
        var slotByte = 4
        var slotIndex = 0
        decl.fields.forEach { f ->
            val propName = snakeToCamel(f.name)
            val isUnion = f.type is RefType && resolveDecl((f.type as RefType).name, schema) is FbsUnion
            if (isUnion) {
                layouts += TableFieldLayout(f, propName, slotByte, slotByte + 2, slotIndex, true)
                slotByte += 4; slotIndex += 2
            } else {
                layouts += TableFieldLayout(f, propName, -1, slotByte, slotIndex, false)
                slotByte += 2; slotIndex += 1
            }
        }
        return layouts
    }

    // ── Table companion (decode + optional fromByteBuffer) ────────────────────

    private fun generateTableCompanion(decl: FbsTable, schema: FbsSchema): TypeSpec {
        val selfClass = ClassName("", decl.name)
        val layouts = buildFieldLayouts(decl, schema)
        val totalSlots = layouts.sumOf { if (it.isUnion) 2 else 1 }

        val decodeFun = FunSpec.builder("decode")
            .addParameter("bb", byteBuffer)
            .addParameter("tableOffset", INT)
            .returns(selfClass)
            .apply {
                if (layouts.isEmpty()) {
                    addStatement("return %T()", selfClass)
                } else {
                    addStatement("val vtableOffset = tableOffset - bb.getInt(tableOffset)")
                    addStatement("val vtableSize = bb.getShort(vtableOffset).toInt()")
                    addCode("\n")

                    // Emit vtable reads
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

                    // Return statement
                    val fieldExprs = layouts.joinToString(",\n") { layout ->
                        "    ${layout.propName} = ${tableFieldDecodeExpr(layout, schema)}"
                    }
                    addStatement("return %T(\n$fieldExprs\n)", selfClass)
                }
            }
            .build()

        val companionBuilder = TypeSpec.companionObjectBuilder().addFunction(decodeFun)
        if (decl.rootType) {
            companionBuilder.addFunction(
                FunSpec.builder("fromByteBuffer")
                    .addParameter("bb", byteBuffer)
                    .returns(selfClass)
                    .addStatement("bb.order(java.nio.ByteOrder.LITTLE_ENDIAN)")
                    .addStatement("return decode(bb, bb.getInt(0))")
                    .build()
            )
        }
        return companionBuilder.build()
    }

    private fun tableFieldDecodeExpr(layout: TableFieldLayout, schema: FbsSchema): String {
        val f = layout.field
        val p = layout.propName
        val off = "__offset_$p"
        val abs = "tableOffset + $off"

        if (layout.isUnion) {
            val typeName = resolveRefTypeName((f.type as RefType).name, schema)
            return "if ($off != 0) %T.decode(__type_$p, bb, $abs + bb.getInt($abs)) else null"
                .replace("%T", typeName.toString())
        }

        return when (val t = f.type) {
            is ScalarType -> scalarTableReadExpr(t.kind, off, abs)
            is RefType -> when (val decl = resolveDecl(t.name, schema)) {
                is FbsEnum -> {
                    val getter = bbGetterForScalarKind(decl.baseType)
                    val conv = bbReadConversion(decl.baseType)
                    val typeName = resolveRefTypeName(t.name, schema)
                    "if ($off != 0) $typeName.fromValue(bb.$getter($abs)$conv) else null"
                }
                is FbsStruct ->
                    "if ($off != 0) ${resolveRefTypeName(t.name, schema)}.decode(bb, $abs) else null"
                else ->
                    "if ($off != 0) ${resolveRefTypeName(t.name, schema)}.decode(bb, $abs + bb.getInt($abs)) else null"
            }
            is VectorType -> {
                val elem = t.element
                "if ($off != 0) { val vecOff = $abs + bb.getInt($abs); val len = bb.getInt(vecOff); (0 until len).map { i -> ${vectorElemReadExpr(elem, schema, "vecOff + 4 + i * ${vectorElemSize(elem, schema)}")} } } else null"
            }
        }
    }

    // ── Table encode (instance method) ────────────────────────────────────────

    private fun generateTableEncode(decl: FbsTable, schema: FbsSchema): FunSpec {
        val layouts = buildFieldLayouts(decl, schema)
        val totalSlots = layouts.sumOf { if (it.isUnion) 2 else 1 }

        return FunSpec.builder("encode")
            .addParameter("builder", flatBufferBuilder)
            .returns(INT)
            .apply {
                // Pre-encode non-inline fields (must happen BEFORE startTable)
                layouts.forEach { layout ->
                    val p = layout.propName
                    val f = layout.field
                    when {
                        layout.isUnion -> {
                            val typeName = resolveRefTypeName((f.type as RefType).name, schema)
                            addStatement("val __off_$p = $p?.let { %T.encode(it, builder) }", typeName)
                            addStatement("val __type_$p = $p?.let { %T.typeIndex(it) } ?: 0.toByte()", typeName)
                        }
                        f.type is RefType -> {
                            when (resolveDecl((f.type as RefType).name, schema)) {
                                is FbsEnum -> { /* inline scalar, no pre-encode */ }
                                is FbsStruct -> { /* structs must be encoded inline, not pre-encoded */ }
                                else -> addStatement("val __off_$p = $p?.encode(builder)")
                            }
                        }
                        f.type is VectorType ->
                            addStatement("val __off_$p = $p?.let { ${vectorEncodeExpr(f.type as VectorType, schema)} }")
                        f.type is ScalarType && (f.type as ScalarType).kind == ScalarKind.STRING ->
                            addStatement("val __off_$p = $p?.let { builder.createString(it) }")
                        else -> { /* other scalars inline */ }
                    }
                }
                if (layouts.isNotEmpty()) addCode("\n")
                addStatement("builder.startTable(%L)", totalSlots)

                layouts.forEach { layout ->
                    val p = layout.propName
                    val f = layout.field
                    val slot = layout.slotIndex
                    when {
                        layout.isUnion -> {
                            addStatement("builder.addByte(%L, __type_$p, 0)", slot)
                            addStatement("__off_$p?.let { builder.addOffset(%L, it, 0) }", slot + 1)
                        }
                        f.type is RefType -> when (val refDecl = resolveDecl((f.type as RefType).name, schema)) {
                            is FbsEnum -> {
                                val conv = fbWriteConversion(refDecl.baseType)
                                val adder = scalarAdder(refDecl.baseType)
                                addStatement("$p?.let { builder.$adder(%L, it.value$conv, 0) }", slot)
                            }
                            is FbsStruct ->
                                addStatement("$p?.let { builder.addStruct(%L, it.encode(builder), 0) }", slot)
                            else ->
                                addStatement("__off_$p?.let { builder.addOffset(%L, it, 0) }", slot)
                        }
                        f.type is VectorType ->
                            addStatement("__off_$p?.let { builder.addOffset(%L, it, 0) }", slot)
                        f.type is ScalarType -> when ((f.type as ScalarType).kind) {
                            ScalarKind.STRING ->
                                addStatement("__off_$p?.let { builder.addOffset(%L, it, 0) }", slot)
                            ScalarKind.BOOL ->
                                addStatement("$p?.let { builder.addBoolean(%L, it, false) }", slot)
                            else -> {
                                val kind = (f.type as ScalarType).kind
                                val adder = scalarAdder(kind)
                                val conv = fbWriteConversion(kind)
                                addStatement("$p?.let { builder.$adder(%L, it$conv, %L) }", slot, scalarDefault(kind))
                            }
                        }
                    }
                }
                addStatement("return builder.endTable()")
            }
            .build()
    }

    // ── Union → sealed interface ──────────────────────────────────────────────

    private fun generateUnion(decl: FbsUnion, schema: FbsSchema): TypeSpec {
        val selfClass = ClassName(schema.namespace, decl.name)

        val decodeFun = FunSpec.builder("decode")
            .addParameter("type", BYTE)
            .addParameter("bb", byteBuffer)
            .addParameter("offset", INT)
            .returns(selfClass.copy(nullable = true))
            .apply {
                beginControlFlow("return when (type.toInt())")
                decl.variants.forEachIndexed { i, variantRef ->
                    addStatement("%L -> %T.decode(bb, offset)", i + 1, resolveRefTypeName(variantRef, schema))
                }
                addStatement("else -> null")
                endControlFlow()
            }
            .build()

        val typeIndexFun = FunSpec.builder("typeIndex")
            .addParameter("value", selfClass)
            .returns(BYTE)
            .apply {
                beginControlFlow("return when (value)")
                decl.variants.forEachIndexed { i, variantRef ->
                    addStatement("is %T -> %L", resolveRefTypeName(variantRef, schema), i + 1)
                }
                // exhaustive (sealed), but add else for safety
                addStatement("else -> 0")
                endControlFlow()
            }
            .build()

        val encodeFun = FunSpec.builder("encode")
            .addParameter("value", selfClass)
            .addParameter("builder", flatBufferBuilder)
            .returns(INT)
            .apply {
                beginControlFlow("return when (value)")
                decl.variants.forEach { variantRef ->
                    addStatement("is %T -> value.encode(builder)", resolveRefTypeName(variantRef, schema))
                }
                addStatement("else -> 0")
                endControlFlow()
            }
            .build()

        // Sealed interfaces cannot be implemented across packages in Kotlin.
        // Only use sealed when all variants are in the same package as the union.
        val allVariantsInSamePackage = decl.variants.all { variantRef ->
            resolveRefTypeName(variantRef, schema).packageName == schema.namespace
        }
        val interfaceBuilder = TypeSpec.interfaceBuilder(decl.name)
            .addKdoc(decl.comments.joinToString("\n"))
        if (allVariantsInSamePackage) interfaceBuilder.addModifiers(KModifier.SEALED)

        return interfaceBuilder
            .addType(
                TypeSpec.companionObjectBuilder()
                    .addFunction(decodeFun)
                    .addFunction(typeIndexFun)
                    .addFunction(encodeFun)
                    .build()
            )
            .build()
    }

    // ── Type resolution ───────────────────────────────────────────────────────

    private fun resolveDecl(ref: String, schema: FbsSchema): FbsDecl? {
        val simple = ref.substringAfterLast('.')
        return if (ref.contains('.')) {
            val ns = ref.substringBeforeLast('.')
            allSchemas.firstOrNull { it.namespace == ns }?.declarations?.firstOrNull { it.name == simple }
        } else {
            allSchemas.flatMap { it.declarations }.firstOrNull { it.name == simple }
        }
    }

    private fun resolveRefTypeName(ref: String, schema: FbsSchema): ClassName {
        val simple = ref.substringAfterLast('.')
        if (!ref.contains('.')) {
            val ownerNs = allSchemas.firstOrNull { s -> s.declarations.any { it.name == simple } }?.namespace
                ?: schema.namespace
            return ClassName(ownerNs, simple)
        }
        val ns = ref.substringBeforeLast('.')
        val targetSchema = allSchemas.firstOrNull { it.namespace == ns }
            ?: return ClassName(ns, simple)
        return ClassName(targetSchema.namespace, simple)
    }

    private fun fieldTypeToKotlin(type: FbsType, schema: FbsSchema, nullable: Boolean): TypeName {
        val base: TypeName = when (type) {
            is ScalarType -> scalarKindToTypeName(type.kind)
            is RefType -> resolveRefTypeName(type.name, schema)
            is VectorType -> LIST.parameterizedBy(fieldTypeToKotlin(type.element, schema, false))
        }
        return if (nullable) base.copy(nullable = true) else base
    }

    private fun scalarKindToTypeName(kind: ScalarKind): TypeName = when (kind) {
        ScalarKind.BOOL -> BOOLEAN
        ScalarKind.INT8 -> BYTE
        ScalarKind.INT16 -> SHORT
        ScalarKind.INT32 -> INT
        ScalarKind.INT64 -> LONG
        ScalarKind.UINT8 -> U_BYTE
        ScalarKind.UINT16 -> U_SHORT
        ScalarKind.UINT32 -> U_INT
        ScalarKind.UINT64 -> U_LONG
        ScalarKind.FLOAT32 -> FLOAT
        ScalarKind.FLOAT64 -> DOUBLE
        ScalarKind.STRING -> STRING
    }

    // ── Scalar kind helpers ───────────────────────────────────────────────────

    /** For struct fields: maps a field FbsType to its scalar kind (only ScalarType is valid in structs). */
    private fun scalarKindOfStructField(type: FbsType): ScalarKind =
        (type as? ScalarType)?.kind ?: ScalarKind.INT32

    private fun bbGetterForScalarKind(kind: ScalarKind): String = when (kind) {
        ScalarKind.BOOL, ScalarKind.INT8, ScalarKind.UINT8 -> "get"
        ScalarKind.INT16, ScalarKind.UINT16 -> "getShort"
        ScalarKind.INT32, ScalarKind.UINT32 -> "getInt"
        ScalarKind.INT64, ScalarKind.UINT64 -> "getLong"
        ScalarKind.FLOAT32 -> "getFloat"
        ScalarKind.FLOAT64 -> "getDouble"
        ScalarKind.STRING -> "getInt"
    }

    private fun bbPutterForScalarKind(kind: ScalarKind): String = when (kind) {
        ScalarKind.BOOL, ScalarKind.INT8, ScalarKind.UINT8 -> "putByte"
        ScalarKind.INT16, ScalarKind.UINT16 -> "putShort"
        ScalarKind.INT32, ScalarKind.UINT32 -> "putInt"
        ScalarKind.INT64, ScalarKind.UINT64 -> "putLong"
        ScalarKind.FLOAT32 -> "putFloat"
        ScalarKind.FLOAT64 -> "putDouble"
        ScalarKind.STRING -> "putInt"
    }

    private fun bbReadConversion(kind: ScalarKind): String = when (kind) {
        ScalarKind.UINT8 -> ".toUByte()"
        ScalarKind.UINT16 -> ".toUShort()"
        ScalarKind.UINT32 -> ".toUInt()"
        ScalarKind.UINT64 -> ".toULong()"
        else -> ""
    }

    private fun fbWriteConversion(kind: ScalarKind): String = when (kind) {
        ScalarKind.UINT8 -> ".toByte()"
        ScalarKind.UINT16 -> ".toShort()"
        ScalarKind.UINT32 -> ".toInt()"
        ScalarKind.UINT64 -> ".toLong()"
        else -> ""
    }

    private fun structFieldSize(type: FbsType): Int = when (type) {
        is ScalarType -> when (type.kind) {
            ScalarKind.BOOL, ScalarKind.INT8, ScalarKind.UINT8 -> 1
            ScalarKind.INT16, ScalarKind.UINT16 -> 2
            ScalarKind.INT32, ScalarKind.UINT32, ScalarKind.FLOAT32 -> 4
            ScalarKind.INT64, ScalarKind.UINT64, ScalarKind.FLOAT64 -> 8
            ScalarKind.STRING -> 4
        }
        else -> 4
    }

    private fun scalarAdder(kind: ScalarKind): String = when (kind) {
        ScalarKind.BOOL -> "addBoolean"
        ScalarKind.INT8, ScalarKind.UINT8 -> "addByte"
        ScalarKind.INT16, ScalarKind.UINT16 -> "addShort"
        ScalarKind.INT32, ScalarKind.UINT32 -> "addInt"
        ScalarKind.INT64, ScalarKind.UINT64 -> "addLong"
        ScalarKind.FLOAT32 -> "addFloat"
        ScalarKind.FLOAT64 -> "addDouble"
        ScalarKind.STRING -> "addOffset"
    }

    private fun scalarDefault(kind: ScalarKind): String = when (kind) {
        ScalarKind.BOOL -> "false"
        ScalarKind.FLOAT32, ScalarKind.FLOAT64 -> "0.0"
        else -> "0"
    }

    // ── Read/write expressions ────────────────────────────────────────────────

    private fun scalarTableReadExpr(kind: ScalarKind, off: String, abs: String): String = when (kind) {
        ScalarKind.BOOL -> "if ($off != 0) bb.get($abs) != 0.toByte() else null"
        ScalarKind.INT8 -> "if ($off != 0) bb.get($abs) else null"
        ScalarKind.UINT8 -> "if ($off != 0) bb.get($abs).toUByte() else null"
        ScalarKind.INT16 -> "if ($off != 0) bb.getShort($abs) else null"
        ScalarKind.UINT16 -> "if ($off != 0) bb.getShort($abs).toUShort() else null"
        ScalarKind.INT32 -> "if ($off != 0) bb.getInt($abs) else null"
        ScalarKind.UINT32 -> "if ($off != 0) bb.getInt($abs).toUInt() else null"
        ScalarKind.INT64 -> "if ($off != 0) bb.getLong($abs) else null"
        ScalarKind.UINT64 -> "if ($off != 0) bb.getLong($abs).toULong() else null"
        ScalarKind.FLOAT32 -> "if ($off != 0) bb.getFloat($abs) else null"
        ScalarKind.FLOAT64 -> "if ($off != 0) bb.getDouble($abs) else null"
        ScalarKind.STRING ->
            "if ($off != 0) { val strOff = $abs + bb.getInt($abs); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null"
    }

    private fun vectorElemReadExpr(elem: FbsType, schema: FbsSchema, absExpr: String): String = when (elem) {
        is ScalarType -> when (elem.kind) {
            ScalarKind.BOOL -> "bb.get($absExpr) != 0.toByte()"
            ScalarKind.INT8 -> "bb.get($absExpr)"
            ScalarKind.UINT8 -> "bb.get($absExpr).toUByte()"
            ScalarKind.INT16 -> "bb.getShort($absExpr)"
            ScalarKind.UINT16 -> "bb.getShort($absExpr).toUShort()"
            ScalarKind.INT32 -> "bb.getInt($absExpr)"
            ScalarKind.UINT32 -> "bb.getInt($absExpr).toUInt()"
            ScalarKind.INT64 -> "bb.getLong($absExpr)"
            ScalarKind.UINT64 -> "bb.getLong($absExpr).toULong()"
            ScalarKind.FLOAT32 -> "bb.getFloat($absExpr)"
            ScalarKind.FLOAT64 -> "bb.getDouble($absExpr)"
            ScalarKind.STRING ->
                "bb.getInt($absExpr).let { strOff -> val len = bb.getInt($absExpr + strOff); ByteArray(len).also { bb.position($absExpr + strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) }"
        }
        is RefType -> when (val refDecl = resolveDecl(elem.name, schema)) {
            is FbsEnum -> {
                val getter = bbGetterForScalarKind(refDecl.baseType)
                val conv = bbReadConversion(refDecl.baseType)
                "${resolveRefTypeName(elem.name, schema)}.fromValue(bb.$getter($absExpr)$conv)!!"
            }
            is FbsStruct -> "${resolveRefTypeName(elem.name, schema)}.decode(bb, $absExpr)"
            else -> "${resolveRefTypeName(elem.name, schema)}.decode(bb, $absExpr + bb.getInt($absExpr))"
        }
        is VectorType -> "error(\"nested vectors not supported\")"
    }

    private fun vectorElemSize(elem: FbsType, schema: FbsSchema? = null): Int = when (elem) {
        is ScalarType -> structFieldSize(elem)
        is RefType -> when (val refDecl = if (schema != null) resolveDecl(elem.name, schema) else null) {
            is FbsEnum -> structFieldSize(ScalarType(refDecl.baseType))
            is FbsStruct -> refDecl.fields.sumOf { structFieldSize(it.type) }
            else -> 4 // table/union: stored as offset
        }
        else -> 4
    }

    private fun vectorEncodeExpr(type: VectorType, schema: FbsSchema): String {
        val elem = type.element
        return when (elem) {
            is ScalarType -> when (elem.kind) {
                ScalarKind.STRING ->
                    "builder.createVectorOfTables(it.map { s -> builder.createString(s) }.toIntArray())"
                ScalarKind.INT8, ScalarKind.UINT8 ->
                    "builder.createByteVector(it.map { b -> b${fbWriteConversion(elem.kind)} }.toByteArray())"
                else ->
                    "builder.createIntVector(it.map { e -> e${fbWriteConversion(elem.kind)} }.toIntArray())"
            }
            is RefType -> when (val refDecl = resolveDecl(elem.name, schema)) {
                is FbsEnum -> {
                    val conv = fbWriteConversion(refDecl.baseType)
                    when (refDecl.baseType) {
                        ScalarKind.INT8, ScalarKind.UINT8 ->
                            "builder.createByteVector(it.map { e -> e.value$conv }.toByteArray())"
                        else ->
                            "builder.createIntVector(it.map { e -> e.value$conv }.toIntArray())"
                    }
                }
                else -> "builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray())"
            }
            is VectorType -> "error(\"nested vectors not supported\")"
        }
    }

    // ── Naming ────────────────────────────────────────────────────────────────

    private fun snakeToCamel(name: String): String =
        name.split('_').mapIndexed { i, part ->
            if (i == 0) part.lowercase() else part.replaceFirstChar { it.uppercase() }
        }.joinToString("")
}