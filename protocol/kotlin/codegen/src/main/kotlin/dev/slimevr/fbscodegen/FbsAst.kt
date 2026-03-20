package dev.slimevr.fbscodegen

// ── Scalar types ────────────────────────────────────────────────────────────

enum class ScalarKind {
    BOOL,
    INT8, INT16, INT32, INT64,
    UINT8, UINT16, UINT32, UINT64,
    FLOAT32, FLOAT64,
    STRING,
}

// ── Field types ──────────────────────────────────────────────────────────────

sealed interface FbsType

data class ScalarType(val kind: ScalarKind) : FbsType

/** A reference to a named type (struct/table/enum/union), possibly in another namespace. */
data class RefType(val name: String) : FbsType

data class VectorType(val element: FbsType) : FbsType

// ── Declarations ─────────────────────────────────────────────────────────────

data class FbsField(
    val name: String,
    val type: FbsType,
    val defaultValue: String? = null,
    val deprecated: Boolean = false,
    val comments: List<String> = emptyList(),
)

data class FbsEnumValue(
    val name: String,
    val value: Long?,
    val comments: List<String> = emptyList(),
)

sealed interface FbsDecl {
    val name: String
    val comments: List<String>
}

data class FbsStruct(
    override val name: String,
    val fields: List<FbsField>,
    override val comments: List<String> = emptyList(),
) : FbsDecl

data class FbsTable(
    override val name: String,
    val fields: List<FbsField>,
    val rootType: Boolean = false,
    override val comments: List<String> = emptyList(),
) : FbsDecl

data class FbsEnum(
    override val name: String,
    val baseType: ScalarKind,
    val values: List<FbsEnumValue>,
    override val comments: List<String> = emptyList(),
) : FbsDecl

data class FbsUnion(
    override val name: String,
    /** Each variant is a type reference (NONE is implicit at index 0). */
    val variants: List<String>,
    override val comments: List<String> = emptyList(),
) : FbsDecl

// ── Schema file ───────────────────────────────────────────────────────────────

data class FbsSchema(
    val namespace: String,
    val includes: List<String>,
    val declarations: List<FbsDecl>,
    val fileIdentifier: String? = null,
    /** Base name of the source .fbs file (no extension), used for the output file name. */
    val fileName: String = "Generated",
)