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

    @Test
    fun `fails loud on the (key) attribute instead of silently ignoring it`() {
        val schema = Schema(
            namespace = "test",
            includes = emptyList(),
            declarations = listOf(
                TableDecl(
                    name = "Root",
                    fields = listOf(
                        Field("value", ScalarType(ScalarKind.INT32), key = true),
                    ),
                ),
            ),
        )

        val error = assertFailsWith<IllegalArgumentException> {
            Generator(listOf(schema)).generate()
        }
        assertTrue(error.message.orEmpty().contains("key"))
    }

    @Test
    fun `fails loud when two union members alias the same underlying type`() {
        val schema = Schema(
            namespace = "test",
            includes = emptyList(),
            declarations = listOf(
                TableDecl(name = "Marker", fields = listOf(Field("x", ScalarType(ScalarKind.INT32)))),
                UnionDecl(
                    name = "Waypoints",
                    variants = listOf(UnionVariant("Start", "Marker"), UnionVariant("End", "Marker")),
                ),
            ),
        )

        val error = assertFailsWith<IllegalArgumentException> {
            Generator(listOf(schema)).generate()
        }
        assertTrue(error.message.orEmpty().contains("alias the same type"))
    }

    @Test
    fun `fails loud when table field ids are not contiguous from zero`() {
        val schema = Schema(
            namespace = "test",
            includes = emptyList(),
            declarations = listOf(
                TableDecl(
                    name = "Root",
                    fields = listOf(
                        Field("a", ScalarType(ScalarKind.INT32), id = 0),
                        Field("b", ScalarType(ScalarKind.INT32), id = 2),
                    ),
                ),
            ),
        )

        val error = assertFailsWith<IllegalArgumentException> {
            Generator(listOf(schema)).generate()
        }
        assertTrue(error.message.orEmpty().contains("contiguous"))
    }
}
