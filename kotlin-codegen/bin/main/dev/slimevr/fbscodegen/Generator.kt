package dev.slimevr.fbscodegen

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec

class Generator(
    internal val allSchemas: List<Schema>,
) {
    internal val symbolTable = SymbolTable(allSchemas)
    internal val flatBufferWriter = ClassName("dev.slimevr.fbscodegen.runtime", "FlatBufferWriter")
    internal val flatBufferReader = ClassName("dev.slimevr.fbscodegen.runtime", "FlatBufferReader")
    internal val structLayouts = mutableMapOf<Pair<String, String>, StructLayout>()

    private val unionMemberships: Map<Pair<String, String>, List<ClassName>> by lazy {
        val map = mutableMapOf<Pair<String, String>, MutableList<ClassName>>()
        allSchemas.forEach { schema ->
            schema.declarations.filterIsInstance<UnionDecl>().forEach { union ->
                val unionClass = ClassName(schema.namespace, union.name)
                union.variants.forEach { variantRef ->
                    val resolved = symbolTable.resolve(variantRef, schema)
                    map.getOrPut(resolved.schema.namespace to resolved.decl.name) { mutableListOf() } += unionClass
                }
            }
        }
        map
    }

    fun generate(): List<FileSpec> = allSchemas.map { schema ->
        val file = FileSpec.builder(schema.namespace, snakeToCamel(schema.fileName).replaceFirstChar { it.uppercase() })
        schema.declarations.forEach { decl ->
            when (decl) {
                is EnumDecl -> file.addType(buildEnumType(decl))
                is StructDecl -> file.addType(buildStructType(this, decl, schema))
                is TableDecl -> file.addType(buildTableType(this, decl, schema))
                is UnionDecl -> file.addType(buildUnionType(this, decl, schema))
            }
        }
        file.build()
    }

    internal fun unionMembers(schema: Schema, name: String): List<ClassName>? =
        unionMemberships[schema.namespace to name]
}
