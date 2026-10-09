package dev.slimevr.fbscodegen

import com.squareup.kotlinpoet.BYTE
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.INT
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.TypeSpec

internal fun buildUnionType(generator: Generator, decl: UnionDecl, schema: Schema): TypeSpec {
    val selfClass = ClassName(schema.namespace, decl.name)

    val decodeFun = FunSpec.builder("decode")
        .addParameter("type", BYTE)
        .addParameter("bb", generator.flatBufferReader)
        .addParameter("offset", INT)
        .returns(selfClass.copy(nullable = true))
        .apply {
            beginControlFlow("return when (type.toInt())")
            decl.variants.forEachIndexed { i, variantRef ->
                addStatement("%L -> %T.decode(bb, offset)", i + 1, generator.resolveRefTypeName(variantRef, schema))
            }
            addStatement("else -> null")
            endControlFlow()
        }
        .build()

    val allVariantsInSamePackage = decl.variants.all { variantRef ->
        generator.resolveRefTypeName(variantRef, schema).packageName == schema.namespace
    }

    val typeIndexFun = FunSpec.builder("typeIndex")
        .addParameter("value", selfClass)
        .returns(BYTE)
        .apply {
            beginControlFlow("return when (value)")
            decl.variants.forEachIndexed { i, variantRef ->
                addStatement("is %T -> %L", generator.resolveRefTypeName(variantRef, schema), i + 1)
            }
            if (!allVariantsInSamePackage) addStatement("else -> 0")
            endControlFlow()
        }
        .build()

    val encodeFun = FunSpec.builder("encode")
        .addParameter("value", selfClass)
        .addParameter("builder", generator.flatBufferWriter)
        .returns(INT)
        .apply {
            beginControlFlow("return when (value)")
            decl.variants.forEach { variantRef ->
                addStatement("is %T -> value.encode(builder)", generator.resolveRefTypeName(variantRef, schema))
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
