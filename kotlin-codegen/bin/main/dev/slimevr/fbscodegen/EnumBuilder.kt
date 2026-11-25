package dev.slimevr.fbscodegen

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec

internal fun buildEnumType(decl: EnumDecl): TypeSpec {
    val enumClass = ClassName("", decl.name)
    val valueType = decl.baseType.info.kotlinType

    val builder = TypeSpec.enumBuilder(decl.name)
        .addKdoc(decl.comments.joinToString("\n"))
        .primaryConstructor(
            FunSpec.constructorBuilder().addParameter("value", valueType).build()
        )
        .addProperty(PropertySpec.builder("value", valueType).initializer("value").build())

    var nextValue = 0L
    decl.values.forEach { v ->
        val actualValue = v.value ?: nextValue
        nextValue = actualValue + 1
        val literal = when (decl.baseType) {
            ScalarKind.UINT8 -> "${actualValue}.toUByte()"
            ScalarKind.UINT16 -> "${actualValue}.toUShort()"
            ScalarKind.UINT32 -> "${actualValue}u"
            ScalarKind.UINT64 -> "${actualValue}uL"
            ScalarKind.INT64 -> "${actualValue}L"
            else -> "$actualValue"
        }
        builder.addEnumConstant(
            v.name,
            TypeSpec.anonymousClassBuilder()
                .addKdoc(v.comments.joinToString("\n"))
                .addSuperclassConstructorParameter(literal)
                .build()
        )
    }
    builder.addType(
        TypeSpec.companionObjectBuilder()
            .addFunction(
                FunSpec.builder("fromValue")
                    .addParameter("value", valueType)
                    .returns(enumClass.copy(nullable = true))
                    .addStatement("return entries.firstOrNull { it.value == value }")
                    .build()
            )
            .build()
    )
    return builder.build()
}
