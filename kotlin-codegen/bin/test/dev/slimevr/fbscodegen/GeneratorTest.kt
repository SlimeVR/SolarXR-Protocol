package dev.slimevr.fbscodegen

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class GeneratorTest {
    @Test
    fun `fails on ambiguous unqualified type references`() {
        val schemaOne = Schema(
            namespace = "one",
            includes = emptyList(),
            declarations = listOf(
                StructDecl(
                    name = "Shared",
                    fields = listOf(
                        Field("value", ScalarType(ScalarKind.INT32)),
                    ),
                ),
            ),
        )

        val schemaTwo = Schema(
            namespace = "two",
            includes = emptyList(),
            declarations = listOf(
                StructDecl(
                    name = "Shared",
                    fields = listOf(
                        Field("value", ScalarType(ScalarKind.INT32)),
                    ),
                ),
            ),
        )

        val schemaThree = Schema(
            namespace = "three",
            includes = emptyList(),
            declarations = listOf(
                TableDecl(
                    name = "Root",
                    fields = listOf(
                        Field("shared", RefType("Shared")),
                    ),
                ),
            ),
        )

        val error = assertFailsWith<IllegalStateException> {
            Generator(listOf(schemaOne, schemaTwo, schemaThree)).generate()
        }

        assertTrue(error.message.orEmpty().contains("Ambiguous"))
    }
}
