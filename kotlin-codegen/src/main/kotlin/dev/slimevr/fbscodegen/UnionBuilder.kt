package dev.slimevr.fbscodegen

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.INT
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.U_BYTE

internal fun buildUnionType(generator: Generator, decl: UnionDecl, schema: Schema): TypeSpec {
    val selfClass = ClassName(schema.namespace, decl.name)

    val resolvedTypes = decl.variants.map { generator.resolveRefTypeName(it.typeRef, schema) }
    val duplicate = resolvedTypes.groupBy { it }.entries.firstOrNull { it.value.size > 1 }
    require(duplicate == null) {
        "Union '${decl.name}': multiple members alias the same type (${duplicate?.key}); " +
            "this codegen distinguishes union members by Kotlin type and cannot support that"
    }

    val decodeFun = FunSpec.builder("decode")
        .addParameter("type", U_BYTE)
        .addParameter("bb", generator.flatBufferReader)
        .addParameter("offset", INT)
        .returns(selfClass.copy(nullable = true))
        .apply {
            beginControlFlow("return when (type.toInt())")
            decl.variants.forEachIndexed { i, variant ->
                addStatement("%L -> %T.decode(bb, offset)", i + 1, generator.resolveRefTypeName(variant.typeRef, schema))
            }
            addStatement("else -> null")
            endControlFlow()
        }
        .build()

    val allVariantsInSamePackage = decl.variants.all { variant ->
        generator.resolveRefTypeName(variant.typeRef, schema).packageName == schema.namespace
    }

    val typeIndexFun = FunSpec.builder("typeIndex")
        .addParameter("value", selfClass)
        .returns(U_BYTE)
        .apply {
            beginControlFlow("return when (value)")
            decl.variants.forEachIndexed { i, variant ->
                addStatement("is %T -> %L.toUByte()", generator.resolveRefTypeName(variant.typeRef, schema), i + 1)
            }
            if (!allVariantsInSamePackage) addStatement("else -> 0.toUByte()")
            endControlFlow()
        }
        .build()

    val encodeFun = FunSpec.builder("encode")
        .addParameter("value", selfClass)
        .addParameter("builder", generator.flatBufferWriter)
        .returns(INT)
        .apply {
            beginControlFlow("return when (value)")
            decl.variants.forEach { variant ->
                addStatement("is %T -> value.encode(builder)", generator.resolveRefTypeName(variant.typeRef, schema))
            }
            if (!allVariantsInSamePackage) addStatement("else -> 0")
            endControlFlow()
        }
        .build()
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
