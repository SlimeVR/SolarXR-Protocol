package dev.slimevr.fbscodegen

import com.squareup.kotlinpoet.ClassName

internal fun Generator.resolveDecl(ref: String, schema: Schema): Decl =
    symbolTable.resolve(ref, schema).decl

internal fun Generator.resolveRefTypeName(ref: String, schema: Schema): ClassName {
    val (resolvedSchema, decl) = symbolTable.resolve(ref, schema)
    return ClassName(resolvedSchema.namespace, decl.name)
}

internal fun Generator.resolveSchema(ref: String, currentSchema: Schema): Schema =
    symbolTable.resolve(ref, currentSchema).schema

internal fun alignTo(value: Int, alignment: Int): Int =
    ((value + alignment - 1) / alignment) * alignment

internal fun snakeToCamel(name: String): String =
    name.split('_').mapIndexed { index, part ->
        if (index == 0) part.lowercase() else part.replaceFirstChar { it.uppercase() }
    }.joinToString("")
