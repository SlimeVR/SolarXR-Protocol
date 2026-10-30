package dev.slimevr.fbscodegen

import com.squareup.kotlinpoet.*

internal fun buildStructType(generator: Generator, decl: StructDecl, schema: Schema): TypeSpec {
    val layout = requireStructLayout(generator, decl, schema)

    val decodeFun = FunSpec.builder("decode")
        .addParameter("bb", generator.flatBufferReader)
        .addParameter("offset", INT)
        .returns(ClassName("", decl.name))
        .apply {
            val args = CodeBlock.builder()
            layout.fields.forEachIndexed { i, fieldLayout ->
                val f = fieldLayout.field
                args.add("${snakeToCamel(f.name)} = %L", structFieldDecodeExpr(generator, f.type, schema, "offset + ${fieldLayout.offset}"))
                if (i < layout.fields.size - 1) args.add(", ")
            }
            addStatement("return %T(%L)", ClassName("", decl.name), args.build())
        }
        .build()

    val encodeFun = FunSpec.builder("encode")
        .addParameter("builder", generator.flatBufferWriter)
        .returns(INT)
        .apply {
            addStatement("builder.prep(%L, %L)", layout.alignment, layout.size)
            addStatement("var written = 0")
            layout.fields.asReversed().forEach { fieldLayout ->
                val target = layout.size - (fieldLayout.offset + fieldLayout.size)
                val name = snakeToCamel(fieldLayout.field.name)
                addStatement("builder.pad(%L - written)", target)
                addCode(structFieldEncodeBlock(generator, fieldLayout.field.type, schema, name))
                addStatement("written = %L", target + fieldLayout.size)
            }
            addStatement("return builder.offset()")
        }
        .build()

    val selfClass = TypeSpec.classBuilder(decl.name)
        .addKdoc(decl.comments.joinToString("\n"))
        .addModifiers(KModifier.DATA)
        .apply {
            generator.unionMembers(schema, decl.name)?.forEach { addSuperinterface(it) }
        }
    val ctor = FunSpec.constructorBuilder()
    decl.fields.forEach { f ->
        val kt = f.type.toKotlinType(generator.symbolTable, schema, nullable = false)
        ctor.addParameter(snakeToCamel(f.name), kt)
        selfClass.addProperty(
            PropertySpec.builder(snakeToCamel(f.name), kt)
                .initializer(snakeToCamel(f.name))
                .build()
        )
    }
    selfClass.primaryConstructor(ctor.build())
    selfClass.addFunction(encodeFun)
    selfClass.addType(TypeSpec.companionObjectBuilder().addFunction(decodeFun).build())
    return selfClass.build()
}

internal fun requireStructLayout(generator: Generator, decl: StructDecl, schema: Schema): StructLayout =
    generator.structLayouts.getOrPut(schema.namespace to decl.name) {
        var offset = 0
        var alignment = 1
        val fields = decl.fields.map { field ->
            val fieldAlignment = fixedInlineAlignment(generator, field.type, schema)
            val fieldSize = fixedInlineSize(generator, field.type, schema)
            alignment = maxOf(alignment, fieldAlignment)
            offset = alignTo(offset, fieldAlignment)
            StructFieldLayout(field, offset, fieldSize).also {
                offset += fieldSize
            }
        }
        val finalAlignment = decl.forceAlign?.also {
            require(it >= alignment && (it and (it - 1)) == 0) {
                "Struct '${decl.name}': force_align must be a power of two >= the natural alignment ($alignment), got $it"
            }
        } ?: alignment
        StructLayout(fields, alignTo(offset, finalAlignment), finalAlignment)
    }

private fun fixedInlineSize(generator: Generator, type: Type, schema: Schema): Int = when (type) {
    is ScalarType -> {
        require(type.kind != ScalarKind.STRING) { "Strings are not valid struct fields" }
        type.kind.info.size
    }
    is RefType -> when (val decl = generator.resolveDecl(type.name, schema)) {
        is EnumDecl -> decl.baseType.info.size
        is StructDecl -> requireStructLayout(generator, decl, generator.resolveSchema(type.name, schema)).size
        else -> error("Struct fields must be scalars, enums, or structs: ${type.name}")
    }
    is VectorType -> error("Vectors are not valid struct fields")
    is ArrayType -> fixedInlineSize(generator, type.element, schema) * type.size
}

private fun fixedInlineAlignment(generator: Generator, type: Type, schema: Schema): Int = when (type) {
    is ScalarType -> {
        require(type.kind != ScalarKind.STRING) { "Strings are not valid struct fields" }
        type.kind.info.alignment
    }
    is RefType -> when (val decl = generator.resolveDecl(type.name, schema)) {
        is EnumDecl -> decl.baseType.info.alignment
        is StructDecl -> requireStructLayout(generator, decl, generator.resolveSchema(type.name, schema)).alignment
        else -> error("Struct fields must be scalars, enums, or structs: ${type.name}")
    }
    is VectorType -> error("Vectors are not valid struct fields")
    is ArrayType -> fixedInlineAlignment(generator, type.element, schema)
}

private fun structFieldDecodeExpr(generator: Generator, type: Type, schema: Schema, absExpr: String): CodeBlock = when (type) {
    is ScalarType -> {
        if (type.kind == ScalarKind.BOOL) {
            CodeBlock.of("bb.get($absExpr) != 0.toByte()")
        } else {
            val info = type.kind.info
            CodeBlock.of("bb.${info.bbGetter}($absExpr)${info.readConv}")
        }
    }
    is RefType -> when (val decl = generator.resolveDecl(type.name, schema)) {
        is EnumDecl -> {
            val info = decl.baseType.info
            CodeBlock.of("%T.fromValue(bb.${info.bbGetter}($absExpr)${info.readConv})!!", generator.resolveRefTypeName(type.name, schema))
        }
        is StructDecl -> CodeBlock.of("%T.decode(bb, $absExpr)", generator.resolveRefTypeName(type.name, schema))
        else -> error("Struct fields must be scalars, enums, or structs: ${type.name}")
    }
    is VectorType -> error("Vectors are not valid struct fields")
    is ArrayType -> {
        val elemSize = fixedInlineSize(generator, type.element, schema)
        val elemExpr = structFieldDecodeExpr(generator, type.element, schema, "$absExpr + i * $elemSize")
        CodeBlock.of("(0 until %L).map { i -> %L }", type.size, elemExpr)
    }
}

private fun structFieldEncodeBlock(generator: Generator, type: Type, schema: Schema, valueExpr: String): CodeBlock = when (type) {
    is ScalarType -> {
        val info = type.kind.info
        CodeBlock.of("builder.%L(%L)\n", info.putter, type.kind.vectorWriteValue(valueExpr))
    }
    is RefType -> when (val decl = generator.resolveDecl(type.name, schema)) {
        is EnumDecl -> {
            val info = decl.baseType.info
            CodeBlock.of(
                "builder.%L(%L)\n",
                info.putter,
                decl.baseType.vectorWriteValue("$valueExpr.value")
            )
        }
        is StructDecl -> CodeBlock.of("%L.encode(builder)\n", valueExpr)
        else -> error("Struct fields must be scalars, enums, or structs: ${type.name}")
    }
    is VectorType -> error("Vectors are not valid struct fields")
    is ArrayType -> CodeBlock.builder()
        .add("run {\n")
        .indent()
        .add("val __values = %L\n", valueExpr)
        .add("require(__values.size == %L) { %S }\n", type.size, "expected ${type.size} elements")
        .add("for (value in __values.asReversed()) {\n")
        .indent()
        .add(structFieldEncodeBlock(generator, type.element, schema, "value"))
        .unindent()
        .add("}\n")
        .unindent()
        .add("}\n")
        .build()
}

internal data class StructFieldLayout(
    val field: Field,
    val offset: Int,
    val size: Int,
)

internal data class StructLayout(
    val fields: List<StructFieldLayout>,
    val size: Int,
    val alignment: Int,
)
