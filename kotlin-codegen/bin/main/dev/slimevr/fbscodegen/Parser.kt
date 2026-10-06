package dev.slimevr.fbscodegen


/**
 * Hand-written recursive-descent parser for the FlatBuffers IDL.
 *
 * Supported constructs:
 *   namespace, include, table, struct, enum, union, root_type, file_identifier,
 *   file_extension (parsed, no codegen effect), attribute (ignored), rpc_service
 *   (parsed and skipped, no codegen), field/struct/enum metadata blocks including
 *   deprecated, required, id, key, force_align, bit_flags; fixed-length struct
 *   arrays ([type:N]); aliased union members (Alias:Type).
 *
 * Metadata keys with no codegen effect on this binary-only generator (hash,
 * nested_flatbuffer, flexbuffer, original_order) parse without error but are
 * otherwise ignored.
 */
class Parser(private val src: String) {

    private var pos = 0

    // ── Public API ────────────────────────────────────────────────────────────

    fun parse(): Schema {
        var namespace = ""
        val includes = mutableListOf<String>()
        val decls = mutableListOf<Decl>()
        var rootType: String? = null
        var fileIdentifier: String? = null

        while (pos < src.length) {
            skipWhitespaceAndComments()
            if (pos >= src.length) break

            when (val kw = peekWord()) {
                "namespace" -> {
                    consume("namespace")
                    namespace = readUntilSemicolon().trim()
                    expect(';')
                }
                "include" -> {
                    consume("include")
                    skipWs()
                    val path = readStringLiteral()
                    skipWs()
                    expect(';')
                    includes += path
                }
                "table" -> decls += parseTable(popCommentBuffer())
                "struct" -> decls += parseStruct(popCommentBuffer())
                "enum" -> decls += parseEnum(popCommentBuffer())
                "union" -> decls += parseUnion(popCommentBuffer())
                "root_type" -> {
                    consume("root_type")
                    rootType = readUntilSemicolon().trim()
                    expect(';')
                }
                "file_identifier" -> {
                    consume("file_identifier")
                    skipWs()
                    fileIdentifier = readStringLiteral()
                    skipWs()
                    expect(';')
                }
                "file_extension" -> {
                    // parsed for spec conformance, not consumed by this codegen (binary output only)
                    consume("file_extension")
                    skipWs()
                    readStringLiteral()
                    skipWs()
                    expect(';')
                }
                "attribute" -> {
                    // ignore attribute declarations
                    skipUntil(';')
                    expect(';')
                }
                "rpc_service" -> {
                    // not supported by this codegen; parsed only so a schema declaring one doesn't fail to parse
                    consume("rpc_service")
                    skipWs()
                    readIdent()
                    skipWs()
                    expect('{')
                    skipUntil('}')
                    expect('}')
                    skipWs()
                    if (pos < src.length && src[pos] == ';') pos++
                }
                else -> error("Unexpected keyword '$kw' at pos $pos")
            }
            commentBuffer.clear()
        }

        // Mark root_type table
        val finalDecls = if (rootType != null) {
            decls.map {
                if (it is TableDecl && it.name == rootType) it.copy(rootType = true) else it
            }
        } else decls

        return Schema(namespace, includes, finalDecls, fileIdentifier)
    }

    // ── Comment buffer ────────────────────────────────────────────────────────

    private val commentBuffer = mutableListOf<String>()

    private fun popCommentBuffer(): List<String> {
        val result = commentBuffer.toList()
        commentBuffer.clear()
        return result
    }

    // ── Table / Struct ────────────────────────────────────────────────────────

    private fun parseTable(comments: List<String>): TableDecl {
        consume("table")
        skipWs()
        val name = readIdent()
        skipWs()
        // optional table-level metadata, e.g. (original_order); no effect on this codegen's layout
        if (pos < src.length && src[pos] == '(') readMetadata()
        skipWs()
        val fields = parseFieldBlock()
        return TableDecl(name, fields, comments = comments)
    }

    private fun parseStruct(comments: List<String>): StructDecl {
        consume("struct")
        skipWs()
        val name = readIdent()
        skipWs()
        var forceAlign: Int? = null
        if (pos < src.length && src[pos] == '(') {
            forceAlign = readMetadata()["force_align"]?.toInt()
        }
        skipWs()
        val fields = parseFieldBlock()
        return StructDecl(name, fields, forceAlign, comments)
    }

    private fun parseFieldBlock(): List<Field> {
        expect('{')
        val fields = mutableListOf<Field>()
        val localComments = mutableListOf<String>()
        while (true) {
            skipWhitespaceAndComments(localComments)
            if (pos >= src.length) break
            if (src[pos] == '}') { pos++; break }
            fields += parseField(localComments.toList())
            localComments.clear()
        }
        return fields
    }

    private fun parseField(comments: List<String>): Field {
        val name = readIdent()
        skipWs()
        expect(':')
        skipWs()
        val type = parseType()
        skipWs()

        var default: String? = null

        if (pos < src.length && src[pos] == '=') {
            pos++
            skipWs()
            default = readDefaultValue()
            skipWs()
        }

        var deprecated = false
        var required = false
        var id: Int? = null
        var key = false
        var forceAlign: Int? = null

        // Optional metadata block: (deprecated, required, id: n, key, force_align: n, ...)
        if (pos < src.length && src[pos] == '(') {
            val meta = readMetadata()
            deprecated = "deprecated" in meta
            required = "required" in meta
            id = meta["id"]?.toInt()
            key = "key" in meta
            forceAlign = meta["force_align"]?.toInt()
        }

        require(!(required && default != null)) {
            "Field '$name' cannot combine (required) with an explicit default value"
        }
        require(!(required && deprecated)) {
            "Field '$name' cannot be both (required) and (deprecated)"
        }

        skipWs()
        expect(';')
        return Field(name, type, default, deprecated, required, id, key, forceAlign, comments)
    }

    private fun parseType(): Type {
        if (pos < src.length && src[pos] == '[') {
            pos++
            skipWs()
            val elem = parseType()
            skipWs()
            // fixed-length array: [type:N] (struct fields only; enforced at codegen time)
            if (pos < src.length && src[pos] == ':') {
                pos++
                skipWs()
                val size = readLong().toInt()
                skipWs()
                expect(']')
                return ArrayType(elem, size)
            }
            expect(']')
            return VectorType(elem)
        }
        val name = readQualifiedIdent()
        return toScalarOrRef(name)
    }

    private fun toScalarOrRef(name: String): Type = when (name) {
        "bool" -> ScalarType(ScalarKind.BOOL)
        "int8", "byte" -> ScalarType(ScalarKind.INT8)
        "int16", "short" -> ScalarType(ScalarKind.INT16)
        "int32", "int" -> ScalarType(ScalarKind.INT32)
        "int64", "long" -> ScalarType(ScalarKind.INT64)
        "uint8", "ubyte" -> ScalarType(ScalarKind.UINT8)
        "uint16", "ushort" -> ScalarType(ScalarKind.UINT16)
        "uint32", "uint" -> ScalarType(ScalarKind.UINT32)
        "uint64", "ulong" -> ScalarType(ScalarKind.UINT64)
        "float32", "float" -> ScalarType(ScalarKind.FLOAT32)
        "float64", "double" -> ScalarType(ScalarKind.FLOAT64)
        "string" -> ScalarType(ScalarKind.STRING)
        else -> RefType(name)
    }

    // ── Enum ──────────────────────────────────────────────────────────────────

    private fun parseEnum(comments: List<String>): EnumDecl {
        consume("enum")
        skipWs()
        val name = readIdent()
        skipWs()
        expect(':')
        skipWs()
        val baseKind = parseEnumBaseType(readIdent())
        skipWs()
        var bitFlags = false
        if (pos < src.length && src[pos] == '(') {
            bitFlags = "bit_flags" in readMetadata()
        }
        skipWs()
        expect('{')
        val values = mutableListOf<EnumDeclValue>()
        val localComments = mutableListOf<String>()
        while (true) {
            skipWhitespaceAndComments(localComments)
            if (pos >= src.length) break
            if (src[pos] == '}') { pos++; break }
            val vName = readIdent()
            skipWs()
            var vValue: Long? = null
            if (pos < src.length && src[pos] == '=') {
                pos++
                skipWs()
                vValue = readLong()
                skipWs()
            }
            skipWs()
            // optional per-value metadata: (deprecated, ...)
            if (pos < src.length && src[pos] == '(') readMetadata()
            values += EnumDeclValue(vName, vValue, localComments.toList())
            localComments.clear()
            skipWs()
            // optional comma
            if (pos < src.length && src[pos] == ',') pos++
        }
        return EnumDecl(name, baseKind, values, bitFlags, comments)
    }

    // ── Union ─────────────────────────────────────────────────────────────────

    private fun parseUnion(comments: List<String>): UnionDecl {
        consume("union")
        skipWs()
        val name = readIdent()
        skipWs()
        expect('{')
        val variants = mutableListOf<UnionVariant>()
        while (true) {
            skipWhitespaceAndComments()
            if (pos >= src.length) break
            if (src[pos] == '}') { pos++; break }
            val first = readQualifiedIdent()
            skipWs()
            // aliased member: `Alias:Type`; unaliased members use the type's simple name as alias
            if (pos < src.length && src[pos] == ':') {
                pos++
                skipWs()
                val typeRef = readQualifiedIdent()
                variants += UnionVariant(first, typeRef)
            } else {
                variants += UnionVariant(first.substringAfterLast('.'), first)
            }
            skipWs()
            if (pos < src.length && src[pos] == ',') pos++
        }
        return UnionDecl(name, variants, comments)
    }

    private fun parseEnumBaseType(baseTypeName: String): ScalarKind = when (baseTypeName) {
        "int8", "byte" -> ScalarKind.INT8
        "int16", "short" -> ScalarKind.INT16
        "int32", "int" -> ScalarKind.INT32
        "int64", "long" -> ScalarKind.INT64
        "uint8", "ubyte" -> ScalarKind.UINT8
        "uint16", "ushort" -> ScalarKind.UINT16
        "uint32", "uint" -> ScalarKind.UINT32
        "uint64", "ulong" -> ScalarKind.UINT64
        else -> error("Unsupported enum base type '$baseTypeName' at pos $pos")
    }

    // ── Lexer helpers ─────────────────────────────────────────────────────────

    private fun skipWs() {
        while (pos < src.length && src[pos].isWhitespace()) pos++
    }

    private fun skipWhitespaceAndComments(accumulator: MutableList<String>? = null) {
        while (pos < src.length) {
            when {
                src[pos].isWhitespace() -> pos++
                src.startsWith("///", pos) -> {
                    pos += 3
                    val start = pos
                    while (pos < src.length && src[pos] != '\n') pos++
                    accumulator?.add(src.substring(start, pos).trim())
                        ?: commentBuffer.add(src.substring(start, pos).trim())
                }
                src.startsWith("//", pos) -> {
                    while (pos < src.length && src[pos] != '\n') pos++
                }
                src.startsWith("/*", pos) -> {
                    pos += 2
                    while (pos < src.length - 1 && !src.startsWith("*/", pos)) pos++
                    pos += 2
                }
                else -> break
            }
        }
    }

    private fun peekWord(): String {
        var i = pos
        while (i < src.length && (src[i].isLetterOrDigit() || src[i] == '_')) i++
        return src.substring(pos, i)
    }

    private fun consume(word: String) {
        require(src.startsWith(word, pos)) { "Expected '$word' at $pos, got '${src.substring(pos, minOf(pos + 20, src.length))}'" }
        pos += word.length
    }

    private fun expect(ch: Char) {
        skipWs()
        require(pos < src.length && src[pos] == ch) { "Expected '$ch' at $pos, got '${src.getOrNull(pos)}'" }
        pos++
    }

    private fun readIdent(): String {
        val start = pos
        while (pos < src.length && (src[pos].isLetterOrDigit() || src[pos] == '_')) pos++
        require(pos > start) { "Expected identifier at $pos" }
        return src.substring(start, pos)
    }

    private fun readQualifiedIdent(): String {
        val sb = StringBuilder(readIdent())
        while (pos < src.length && src[pos] == '.') {
            pos++
            sb.append('.')
            sb.append(readIdent())
        }
        return sb.toString()
    }

    private fun readUntilSemicolon(): String {
        val start = pos
        while (pos < src.length && src[pos] != ';') pos++
        return src.substring(start, pos)
    }

    private fun skipUntil(ch: Char) {
        while (pos < src.length && src[pos] != ch) pos++
    }

    private fun readStringLiteral(): String {
        expect('"')
        val start = pos
        while (pos < src.length && src[pos] != '"') pos++
        val s = src.substring(start, pos)
        pos++ // closing "
        return s
    }

    private fun readDefaultValue(): String {
        val start = pos
        while (pos < src.length && src[pos] != ';' && src[pos] != '(' && !src[pos].isWhitespace()) pos++
        return src.substring(start, pos)
    }

    /** Parses `(key, key: value, ...)`, returning each key mapped to its raw value text (or null if bare). */
    private fun readMetadata(): Map<String, String?> {
        expect('(')
        val result = mutableMapOf<String, String?>()
        while (pos < src.length && src[pos] != ')') {
            skipWs()
            if (src[pos] == ')') break
            val key = readIdent()
            skipWs()
            var value: String? = null
            if (pos < src.length && src[pos] == ':') {
                pos++
                skipWs()
                val start = pos
                while (pos < src.length && src[pos] != ',' && src[pos] != ')') pos++
                value = src.substring(start, pos).trim().removeSurrounding("\"")
            }
            result[key] = value
            skipWs()
            if (pos < src.length && src[pos] == ',') pos++
        }
        if (pos < src.length) pos++ // ')'
        return result
    }

    private fun readLong(): Long {
        val negative = pos < src.length && src[pos] == '-'
        if (negative) pos++
        val start = pos
        while (pos < src.length && src[pos].isDigit()) pos++
        val s = src.substring(start, pos)
        return if (negative) -s.toLong() else s.toLong()
    }
}
