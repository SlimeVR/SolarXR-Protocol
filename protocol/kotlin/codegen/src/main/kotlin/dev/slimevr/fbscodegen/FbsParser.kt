package dev.slimevr.fbscodegen

/**
 * Hand-written recursive-descent parser for a subset of the FlatBuffers IDL.
 *
 * Supported constructs:
 *   namespace, include, table, struct, enum, union,
 *   root_type, file_identifier, attribute (ignored)
 */
class FbsParser(private val src: String) {

    private var pos = 0

    // ── Public API ────────────────────────────────────────────────────────────

    fun parse(): FbsSchema {
        var namespace = ""
        val includes = mutableListOf<String>()
        val decls = mutableListOf<FbsDecl>()
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
                "attribute" -> {
                    // ignore attribute declarations
                    skipUntil(';')
                    expect(';')
                }
                else -> error("Unexpected keyword '$kw' at pos $pos")
            }
            commentBuffer.clear()
        }

        // Mark root_type table
        val finalDecls = if (rootType != null) {
            decls.map {
                if (it is FbsTable && it.name == rootType) it.copy(rootType = true) else it
            }
        } else decls

        return FbsSchema(namespace, includes, finalDecls, fileIdentifier)
    }

    // ── Comment buffer ────────────────────────────────────────────────────────

    private val commentBuffer = mutableListOf<String>()

    private fun popCommentBuffer(): List<String> {
        val result = commentBuffer.toList()
        commentBuffer.clear()
        return result
    }

    // ── Table / Struct ────────────────────────────────────────────────────────

    private fun parseTable(comments: List<String>): FbsTable {
        consume("table")
        skipWs()
        val name = readIdent()
        skipWs()
        // optional table-level metadata: (deprecated, ...)
        if (pos < src.length && src[pos] == '(') readMetadata()
        skipWs()
        val fields = parseFieldBlock()
        return FbsTable(name, fields, comments = comments)
    }

    private fun parseStruct(comments: List<String>): FbsStruct {
        consume("struct")
        skipWs()
        val name = readIdent()
        skipWs()
        // optional struct-level metadata
        if (pos < src.length && src[pos] == '(') readMetadata()
        skipWs()
        val fields = parseFieldBlock()
        return FbsStruct(name, fields, comments)
    }

    private fun parseFieldBlock(): List<FbsField> {
        expect('{')
        val fields = mutableListOf<FbsField>()
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

    private fun parseField(comments: List<String>): FbsField {
        val name = readIdent()
        skipWs()
        expect(':')
        skipWs()
        val type = parseType()
        skipWs()

        var default: String? = null
        var deprecated = false

        if (pos < src.length && src[pos] == '=') {
            pos++
            skipWs()
            default = readDefaultValue()
            skipWs()
        }

        // Optional metadata block: (deprecated, ...)
        if (pos < src.length && src[pos] == '(') {
            val meta = readMetadata()
            if ("deprecated" in meta) deprecated = true
        }

        skipWs()
        expect(';')
        return FbsField(name, type, default, deprecated, comments)
    }

    private fun parseType(): FbsType {
        if (pos < src.length && src[pos] == '[') {
            pos++
            skipWs()
            val elem = parseType()
            skipWs()
            expect(']')
            return VectorType(elem)
        }
        val name = readQualifiedIdent()
        return toScalarOrRef(name)
    }

    private fun toScalarOrRef(name: String): FbsType = when (name) {
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

    private fun parseEnum(comments: List<String>): FbsEnum {
        consume("enum")
        skipWs()
        val name = readIdent()
        skipWs()
        expect(':')
        skipWs()
        val baseTypeName = readIdent()
        val baseKind = when (baseTypeName) {
            "int8", "byte" -> ScalarKind.INT8
            "int16", "short" -> ScalarKind.INT16
            "int32", "int" -> ScalarKind.INT32
            "int64", "long" -> ScalarKind.INT64
            "uint8", "ubyte" -> ScalarKind.UINT8
            "uint16", "ushort" -> ScalarKind.UINT16
            "uint32", "uint" -> ScalarKind.UINT32
            "uint64", "ulong" -> ScalarKind.UINT64
            else -> ScalarKind.INT32
        }
        skipWs()
        expect('{')
        val values = mutableListOf<FbsEnumValue>()
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
            values += FbsEnumValue(vName, vValue, localComments.toList())
            localComments.clear()
            skipWs()
            // optional comma
            if (pos < src.length && src[pos] == ',') pos++
        }
        return FbsEnum(name, baseKind, values, comments)
    }

    // ── Union ─────────────────────────────────────────────────────────────────

    private fun parseUnion(comments: List<String>): FbsUnion {
        consume("union")
        skipWs()
        val name = readIdent()
        skipWs()
        expect('{')
        val variants = mutableListOf<String>()
        while (true) {
            skipWhitespaceAndComments()
            if (pos >= src.length) break
            if (src[pos] == '}') { pos++; break }
            variants += readQualifiedIdent()
            skipWs()
            if (pos < src.length && src[pos] == ',') pos++
        }
        return FbsUnion(name, variants, comments)
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

    private fun readMetadata(): Set<String> {
        expect('(')
        val result = mutableSetOf<String>()
        while (pos < src.length && src[pos] != ')') {
            skipWs()
            if (src[pos] == ')') break
            val key = readIdent()
            result += key
            skipWs()
            if (pos < src.length && src[pos] == ':') {
                pos++
                skipWs()
                // skip value
                while (pos < src.length && src[pos] != ',' && src[pos] != ')') pos++
            }
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