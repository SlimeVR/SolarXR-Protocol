package dev.slimevr.fbscodegen

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy

/** Metadata about a FlatBuffers scalar type: its Kotlin representation and FlatBufferWriter/Reader API names. */
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
    val zeroBuilder: String,
)

enum class ScalarKind {
    BOOL,
    INT8, INT16, INT32, INT64,
    UINT8, UINT16, UINT32, UINT64,
    FLOAT32, FLOAT64,
    STRING;

    internal val info: ScalarInfo
        get() = when (this) {
            BOOL -> ScalarInfo(1, 1, BOOLEAN, "get", "addBoolean", "putByte", zeroKotlin = "false", zeroBuilder = "false")
            INT8 -> ScalarInfo(1, 1, BYTE, "get", "addByte", "putByte", zeroKotlin = "0", zeroBuilder = "0")
            UINT8 -> ScalarInfo(1, 1, U_BYTE, "get", "addByte", "putByte", ".toUByte()", ".toByte()", "0.toUByte()", "0")
            INT16 -> ScalarInfo(2, 2, SHORT, "getShort", "addShort", "putShort", zeroKotlin = "0", zeroBuilder = "0")
            UINT16 -> ScalarInfo(2, 2, U_SHORT, "getShort", "addShort", "putShort", ".toUShort()", ".toShort()", "0.toUShort()", "0")
            INT32 -> ScalarInfo(4, 4, INT, "getInt", "addInt", "putInt", zeroKotlin = "0", zeroBuilder = "0")
            UINT32 -> ScalarInfo(4, 4, U_INT, "getInt", "addInt", "putInt", ".toUInt()", ".toInt()", "0u", "0")
            INT64 -> ScalarInfo(8, 8, LONG, "getLong", "addLong", "putLong", zeroKotlin = "0L", zeroBuilder = "0L")
            UINT64 -> ScalarInfo(8, 8, U_LONG, "getLong", "addLong", "putLong", ".toULong()", ".toLong()", "0uL", "0L")
            FLOAT32 -> ScalarInfo(4, 4, FLOAT, "getFloat", "addFloat", "putFloat", zeroKotlin = "0.0f", zeroBuilder = "0.0")
            FLOAT64 -> ScalarInfo(8, 8, DOUBLE, "getDouble", "addDouble", "putDouble", zeroKotlin = "0.0", zeroBuilder = "0.0")
            STRING -> ScalarInfo(4, 4, STRING_TYPE, "getInt", "addOffset", "putInt", zeroKotlin = "null", zeroBuilder = "0")
        }

    internal fun toKotlinLiteral(raw: String?): String {
        val v = raw ?: return info.zeroKotlin
        if (v == "null") return info.zeroKotlin
        return when (this) {
            INT64 -> if (v.endsWith("L")) v else "${v}L"
            UINT8 -> "${v}.toUByte()"
            UINT16 -> "${v}.toUShort()"
            UINT32 -> if (v.endsWith("u")) v else "${v}u"
            UINT64 -> if (v.endsWith("uL")) v else "${v}uL"
            FLOAT32 -> if (v.endsWith("f")) v else "${v}f"
            STRING -> "null"
            else -> v
        }
    }

    internal fun toBuilderLiteral(raw: String?): String {
        val v = raw ?: return info.zeroBuilder
        if (v == "null") return info.zeroBuilder
        return when (this) {
            INT64 -> if (v.endsWith("L")) v else "${v}L"
            UINT32 -> "${v}u.toInt()"
            UINT64 -> "${v}uL.toLong()"
            STRING -> "0"
            else -> v
        }
    }

    /** The value expression to hand to `FlatBufferWriter.put*` when writing this scalar inline (struct field or vector element). */
    internal fun vectorWriteValue(valueExpr: String): CodeBlock = when (this) {
        BOOL -> CodeBlock.of("if ($valueExpr) 1.toByte() else 0.toByte()")
        else -> CodeBlock.of("$valueExpr${info.writeConv}")
    }
}

// kotlinpoet's STRING clashes with the ScalarKind.STRING enum constant above.
private val STRING_TYPE = ClassName("kotlin", "String")

sealed interface Type {
    fun toKotlinType(symbols: SymbolTable, schema: Schema, nullable: Boolean = false): TypeName {
        val base = when (this) {
            is ScalarType -> kind.info.kotlinType
            is RefType -> symbols.resolve(name, schema).let { ClassName(it.schema.namespace, it.decl.name) }
            is VectorType -> LIST.parameterizedBy(element.toKotlinType(symbols, schema, false))
            is ArrayType -> LIST.parameterizedBy(element.toKotlinType(symbols, schema, false))
        }
        return if (nullable) base.copy(nullable = true) else base
    }
}

data class ScalarType(val kind: ScalarKind) : Type

data class RefType(val name: String) : Type

data class VectorType(val element: Type) : Type

/** Fixed-length inline array, struct fields only (`v:[float:3]`). */
data class ArrayType(val element: Type, val size: Int) : Type

data class Field(
    val name: String,
    val type: Type,
    val defaultValue: String? = null,
    val deprecated: Boolean = false,
    val required: Boolean = false,
    /** Explicit vtable field id from `(id: n)`; null means declaration order decides the slot. */
    val id: Int? = null,
    val key: Boolean = false,
    /** `(force_align: n)`, meaningful on vector fields only. */
    val forceAlign: Int? = null,
    val comments: List<String> = emptyList(),
) {
    fun isNullable(symbols: SymbolTable, schema: Schema): Boolean {
        if (required) return false
        // Only an explicit `= null` (the optional-scalar syntax) makes a field nullable.
        // A scalar/enum field with no default at all still isn't nullable. like flatc, it
        // gets an implicit default (zero, or the enum's first value) and is always "present".
        if (defaultValue == "null") return true
        return when (val t = type) {
            is ScalarType -> t.kind == ScalarKind.STRING
            is RefType -> symbols.resolve(t.name, schema).decl !is EnumDecl
            is VectorType -> true
            is ArrayType -> error("Field '$name' declares a fixed-size array outside of a struct; arrays are only valid in struct fields")
        }
    }

    fun kotlinDefault(symbols: SymbolTable, schema: Schema): String {
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

    fun builderDefault(symbols: SymbolTable, schema: Schema): String = when (val t = type) {
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

    /** Deprecated fields stay in the generated Kotlin type (so existing callers keep compiling) but are inert on the wire. */
    fun deprecatedAnnotation(): AnnotationSpec? =
        if (!deprecated) null
        else AnnotationSpec.builder(Deprecated::class)
            .addMember("%S", "FlatBuffers field `$name` is deprecated.")
            .build()
}

data class EnumDeclValue(
    val name: String,
    val value: Long?,
    val comments: List<String> = emptyList(),
)

sealed interface Decl {
    val name: String
    val comments: List<String>
}

data class StructDecl(
    override val name: String,
    val fields: List<Field>,
    /** `(force_align: n)`, must be >= the struct's natural alignment. */
    val forceAlign: Int? = null,
    override val comments: List<String> = emptyList(),
) : Decl

data class TableDecl(
    override val name: String,
    val fields: List<Field>,
    val rootType: Boolean = false,
    override val comments: List<String> = emptyList(),
) : Decl

data class EnumDecl(
    override val name: String,
    val baseType: ScalarKind,
    val values: List<EnumDeclValue>,
    val bitFlags: Boolean = false,
    override val comments: List<String> = emptyList(),
) : Decl

/** One union member. [alias] is the member's declared name (`Start` in `Start:MarkerPosition`); defaults to the type's simple name. */
data class UnionVariant(val alias: String, val typeRef: String)

data class UnionDecl(
    override val name: String,
    val variants: List<UnionVariant>,
    override val comments: List<String> = emptyList(),
) : Decl

data class Schema(
    val namespace: String,
    val includes: List<String>,
    val declarations: List<Decl>,
    val fileIdentifier: String? = null,
    val fileName: String = "Generated",
)

data class ResolvedDecl(
    val schema: Schema,
    val decl: Decl,
)

class SymbolTable(val schemas: List<Schema>) {
    private val decls = schemas.flatMap { schema ->
        schema.declarations.map { decl -> (schema.namespace to decl.name) to ResolvedDecl(schema, decl) }
    }.toMap()

    fun resolve(ref: String, context: Schema): ResolvedDecl {
        val simple = ref.substringAfterLast('.')
        val qualifiedNamespace = if (ref.contains('.')) ref.substringBeforeLast('.') else null

        if (qualifiedNamespace != null) {
            return decls[qualifiedNamespace to simple]
                ?: error("Unknown type reference '$ref' in ${context.namespace}")
        }

        // Try context namespace first
        decls[context.namespace to simple]?.let { return it }

        // Fallback to searching all (might be ambiguous)
        val matches = decls.filter { it.key.second == simple }.values.toList()
        return when (matches.size) {
            1 -> matches.single()
            0 -> error("Unknown type reference '$ref' in ${context.namespace}")
            else -> error("Ambiguous type reference '$ref' in ${context.namespace}: ${matches.joinToString { it.schema.namespace + "." + it.decl.name }}")
        }
    }
}
