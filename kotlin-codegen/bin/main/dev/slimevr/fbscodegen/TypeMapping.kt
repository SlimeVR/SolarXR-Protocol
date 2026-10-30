package dev.slimevr.fbscodegen

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy

/**
 * Metadata about a FlatBuffers scalar type.
 */
internal data class ScalarInfo(
    val size: Int,
    val alignment: Int = size,
    val kotlinType: TypeName,
    val bbGetter: String,
    val adder: String,
    val putter: String,
    val readConv: String = "",
    val writeConv: String = "",
    val zeroKotlin: String,
    val zeroBuilder: String
)

internal val ScalarKind.info: ScalarInfo get() = when (this) {
    ScalarKind.BOOL -> ScalarInfo(1, 1, BOOLEAN, "get", "addBoolean", "putByte", zeroKotlin = "false", zeroBuilder = "false")
    ScalarKind.INT8 -> ScalarInfo(1, 1, BYTE, "get", "addByte", "putByte", zeroKotlin = "0", zeroBuilder = "0")
    ScalarKind.UINT8 -> ScalarInfo(1, 1, U_BYTE, "get", "addByte", "putByte", ".toUByte()", ".toByte()", "0.toUByte()", "0")
    ScalarKind.INT16 -> ScalarInfo(2, 2, SHORT, "getShort", "addShort", "putShort", zeroKotlin = "0", zeroBuilder = "0")
    ScalarKind.UINT16 -> ScalarInfo(2, 2, U_SHORT, "getShort", "addShort", "putShort", ".toUShort()", ".toShort()", "0.toUShort()", "0")
    ScalarKind.INT32 -> ScalarInfo(4, 4, INT, "getInt", "addInt", "putInt", zeroKotlin = "0", zeroBuilder = "0")
    ScalarKind.UINT32 -> ScalarInfo(4, 4, U_INT, "getInt", "addInt", "putInt", ".toUInt()", ".toInt()", "0u", "0")
    ScalarKind.INT64 -> ScalarInfo(8, 8, LONG, "getLong", "addLong", "putLong", zeroKotlin = "0L", zeroBuilder = "0L")
    ScalarKind.UINT64 -> ScalarInfo(8, 8, U_LONG, "getLong", "addLong", "putLong", ".toULong()", ".toLong()", "0uL", "0L")
    ScalarKind.FLOAT32 -> ScalarInfo(4, 4, FLOAT, "getFloat", "addFloat", "putFloat", zeroKotlin = "0.0f", zeroBuilder = "0.0")
    ScalarKind.FLOAT64 -> ScalarInfo(8, 8, DOUBLE, "getDouble", "addDouble", "putDouble", zeroKotlin = "0.0", zeroBuilder = "0.0")
    ScalarKind.STRING -> ScalarInfo(4, 4, STRING, "getInt", "addOffset", "putInt", zeroKotlin = "null", zeroBuilder = "0")
}

// ── Type Extensions ─────────────────────────────────────────────────────────

internal fun Type.toKotlinType(symbols: SymbolTable, schema: Schema, nullable: Boolean = false): TypeName {
    val base = when (this) {
        is ScalarType -> kind.info.kotlinType
        is RefType -> symbols.resolve(name, schema).let { ClassName(it.schema.namespace, it.decl.name) }
        is VectorType -> LIST.parameterizedBy(element.toKotlinType(symbols, schema, false))
    }
    return if (nullable) base.copy(nullable = true) else base
}

// ── Field Extensions ────────────────────────────────────────────────────────

internal fun Field.isNullable(symbols: SymbolTable, schema: Schema): Boolean {
    if (defaultValue == "null" || defaultValue == null) return true
    return when (val t = type) {
        is ScalarType -> t.kind == ScalarKind.STRING
        is RefType -> symbols.resolve(t.name, schema).decl !is EnumDecl
        is VectorType -> true
    }
}

internal fun Field.kotlinDefault(symbols: SymbolTable, schema: Schema): String {
    if (isNullable(symbols, schema)) return "null"
    return when (val t = type) {
        is ScalarType -> t.kind.toKotlinLiteral(defaultValue)
        is RefType -> {
            val res = symbols.resolve(t.name, schema)
            val decl = res.decl as? EnumDecl ?: return "null"
            val variant = defaultValue ?: decl.values.first().name
            "${decl.name}.$variant"
        }
        else -> "null"
    }
}

internal fun Field.builderDefault(symbols: SymbolTable, schema: Schema): String = when (val t = type) {
    is ScalarType -> t.kind.toBuilderLiteral(defaultValue)
    is RefType -> {
        val decl = symbols.resolve(t.name, schema).decl as? EnumDecl ?: return "0"
        val variantName = defaultValue ?: decl.values.first().name
        val variantValue = decl.values.find { it.name == variantName }?.value
            ?: decl.values.indexOfFirst { it.name == variantName }.toLong().takeIf { it != -1L }
            ?: 0L
        decl.baseType.toBuilderLiteral(variantValue.toString())
    }
    else -> "0"
}

// ── Literal Helpers ─────────────────────────────────────────────────────────

private fun ScalarKind.toKotlinLiteral(raw: String?): String {
    val v = raw ?: return info.zeroKotlin
    if (v == "null") return info.zeroKotlin
    return when (this) {
        ScalarKind.INT64 -> if (v.endsWith("L")) v else "${v}L"
        ScalarKind.UINT8 -> "${v}.toUByte()"
        ScalarKind.UINT16 -> "${v}.toUShort()"
        ScalarKind.UINT32 -> if (v.endsWith("u")) v else "${v}u"
        ScalarKind.UINT64 -> if (v.endsWith("uL")) v else "${v}uL"
        ScalarKind.FLOAT32 -> if (v.endsWith("f")) v else "${v}f"
        ScalarKind.STRING -> "null"
        else -> v
    }
}

private fun ScalarKind.toBuilderLiteral(raw: String?): String {
    val v = raw ?: return info.zeroBuilder
    if (v == "null") return info.zeroBuilder
    return when (this) {
        ScalarKind.INT64 -> if (v.endsWith("L")) v else "${v}L"
        ScalarKind.UINT32 -> "${v}u.toInt()"
        ScalarKind.UINT64 -> "${v}uL.toLong()"
        ScalarKind.STRING -> "0"
        else -> v
    }
}

internal fun Field.deprecatedAnnotation(): AnnotationSpec? =
    if (!deprecated) null
    else AnnotationSpec.builder(Deprecated::class)
        .addMember("%S", "FlatBuffers field `$name` is deprecated.")
        .build()

internal val readFlatBufferString = MemberName("dev.slimevr.fbscodegen.runtime", "readFlatBufferString")
