package dev.slimevr.fbscodegen

enum class ScalarKind {
    BOOL,
    INT8, INT16, INT32, INT64,
    UINT8, UINT16, UINT32, UINT64,
    FLOAT32, FLOAT64,
    STRING,
}

sealed interface Type

data class ScalarType(val kind: ScalarKind) : Type

data class RefType(val name: String) : Type

data class VectorType(val element: Type) : Type

data class Field(
    val name: String,
    val type: Type,
    val defaultValue: String? = null,
    val deprecated: Boolean = false,
    val comments: List<String> = emptyList(),
)

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
    override val comments: List<String> = emptyList(),
) : Decl

data class UnionDecl(
    override val name: String,
    val variants: List<String>,
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

