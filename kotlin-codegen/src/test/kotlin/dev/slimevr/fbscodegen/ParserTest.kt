package dev.slimevr.fbscodegen

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class ParserTest {
    @Test
    fun `parses enum bit_flags metadata`() {
        val schema = Parser(
            """
            namespace test;
            enum Flags : ubyte (bit_flags) {
                Red,
                Green,
                Blue,
            }
            """.trimIndent()
        ).parse()

        val decl = schema.declarations.single() as EnumDecl
        assertTrue(decl.bitFlags)
    }

    @Test
    fun `parses file_extension without error`() {
        val schema = Parser(
            """
            namespace test;
            file_extension "dat";
            table Foo { x: int32; }
            """.trimIndent()
        ).parse()

        assertEquals(1, schema.declarations.size)
    }

    @Test
    fun `parses rpc_service without error`() {
        val schema = Parser(
            """
            namespace test;
            table Req { x: int32; }
            table Resp { y: int32; }
            rpc_service MyService {
                Call(Req):Resp;
            }
            table AfterService { z: int32; }
            """.trimIndent()
        ).parse()

        assertEquals(3, schema.declarations.size)
        assertEquals("AfterService", schema.declarations.last().name)
    }

    @Test
    fun `parses aliased union members`() {
        val schema = Parser(
            """
            namespace test;
            table Marker { x: int32; }
            union Waypoints { Start:Marker, End:Marker }
            """.trimIndent()
        ).parse()

        val decl = schema.declarations.filterIsInstance<UnionDecl>().single()
        assertEquals(listOf(UnionVariant("Start", "Marker"), UnionVariant("End", "Marker")), decl.variants)
    }

    @Test
    fun `parses unaliased union members using the type's simple name`() {
        val schema = Parser(
            """
            namespace test;
            table Marker { x: int32; }
            union Waypoints { Marker }
            """.trimIndent()
        ).parse()

        val decl = schema.declarations.filterIsInstance<UnionDecl>().single()
        assertEquals(listOf(UnionVariant("Marker", "Marker")), decl.variants)
    }

    @Test
    fun `parses fixed-size struct arrays`() {
        val schema = Parser(
            """
            namespace test;
            struct Foo { values: [int32:3]; }
            """.trimIndent()
        ).parse()

        val field = (schema.declarations.single() as StructDecl).fields.single()
        assertEquals(ArrayType(ScalarType(ScalarKind.INT32), 3), field.type)
    }

    @Test
    fun `parses field metadata for required, id, key and force_align`() {
        val schema = Parser(
            """
            namespace test;
            table Foo {
                a: int32 (required);
                b: int32 (id: 3);
                c: int32 (key);
                d: [int32] (force_align: 16);
            }
            """.trimIndent()
        ).parse()

        val fields = (schema.declarations.single() as TableDecl).fields
        assertTrue(fields[0].required)
        assertEquals(3, fields[1].id)
        assertTrue(fields[2].key)
        assertEquals(16, fields[3].forceAlign)
    }

    @Test
    fun `rejects required field with an explicit default`() {
        assertFailsWith<IllegalArgumentException> {
            Parser(
                """
                namespace test;
                table Foo { a: int32 = 5 (required); }
                """.trimIndent()
            ).parse()
        }
    }
}
