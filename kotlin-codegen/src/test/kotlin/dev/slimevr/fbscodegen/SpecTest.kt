package dev.slimevr.fbscodegen

import com.google.flatbuffers.FlatBufferBuilder
import dev.slimevr.fbscodegen.runtime.JvmFlatBufferReader
import dev.slimevr.fbscodegen.runtime.JvmFlatBufferWriter
import fixture.spec.*
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertIs
import kotlin.test.assertTrue

class SpecTest {

    private fun <T> roundTrip(encode: (JvmFlatBufferWriter) -> Int, decode: (JvmFlatBufferReader) -> T): T {
        val builder = FlatBufferBuilder(0)
        builder.finish(encode(JvmFlatBufferWriter(builder)))
        val bb = builder.dataBuffer().duplicate().order(ByteOrder.LITTLE_ENDIAN)
        return decode(JvmFlatBufferReader(bb))
    }

    @Test
    fun `required fields round trip including natural-zero values`() {
        val value = RequiredTest(
            reqInt = 0,
            reqString = "",
            reqTable = RequiredTarget(label = "x"),
            reqVector = emptyList(),
        )
        val decoded = roundTrip({ w -> value.encode(w) }, { r -> RequiredTest.decode(r, r.getInt(0)) })
        assertEquals(value, decoded)
    }

    @Test
    fun `missing required field throws on decode instead of silently defaulting`() {
        val builder = FlatBufferBuilder(0)
        builder.startTable(4)
        val off = builder.endTable()
        builder.finish(off)
        val bb = builder.dataBuffer().duplicate().order(ByteOrder.LITTLE_ENDIAN)
        val reader = JvmFlatBufferReader(bb)

        val error = assertFailsWith<IllegalStateException> {
            RequiredTest.decode(reader, reader.getInt(0))
        }
        assertTrue(error.message.orEmpty().contains("required"))
    }

    @Test
    fun `explicit field ids control vtable layout, not declaration order`() {
        // a is declared second but has id 0; b is declared first but has id 1.
        val builder = FlatBufferBuilder(0)
        builder.startTable(2)
        builder.addInt(0, 100, 0)
        builder.addInt(1, 200, 0)
        val off = builder.endTable()
        builder.finish(off)
        val bb = builder.dataBuffer().duplicate().order(ByteOrder.LITTLE_ENDIAN)
        val reader = JvmFlatBufferReader(bb)

        val decoded = ExplicitIdTest.decode(reader, reader.getInt(0))
        assertEquals(100, decoded.a)
        assertEquals(200, decoded.b)
    }

    @Test
    fun `explicit field ids round trip through our own encode`() {
        val value = ExplicitIdTest(a = 7, b = 9)
        val decoded = roundTrip({ w -> value.encode(w) }, { r -> ExplicitIdTest.decode(r, r.getInt(0)) })
        assertEquals(value, decoded)
    }

    @Test
    fun `union field id offsets the implicit type slot by one`() {
        val builder = FlatBufferBuilder(0)
        builder.startTable(1)
        builder.addInt(0, 55, 0)
        val targetOff = builder.endTable()

        builder.startTable(3)
        builder.addInt(0, 42, 0) // tag, id 0
        builder.addByte(1, 1, 0) // union type slot, id 1 (= value id 2, minus 1)
        builder.addOffset(2, targetOff, 0) // union value slot, id 2
        val off = builder.endTable()
        builder.finish(off)
        val bb = builder.dataBuffer().duplicate().order(ByteOrder.LITTLE_ENDIAN)
        val reader = JvmFlatBufferReader(bb)

        val decoded = IdUnionTest.decode(reader, reader.getInt(0))
        assertEquals(42, decoded.tag)
        val value = assertIs<IdUnionTarget>(decoded.value)
        assertEquals(55, value.v)
    }

    @Test
    fun `deprecated field keeps its vtable slot reserved so later fields stay stable`() {
        // Simulates an old producer that still writes to the deprecated slot.
        val builder = FlatBufferBuilder(0)
        builder.startTable(3)
        builder.addInt(0, 111, 0) // a
        builder.addInt(1, 999, 0) // old_field
        builder.addInt(2, 222, 0) // b
        val off = builder.endTable()
        builder.finish(off)
        val bb = builder.dataBuffer().duplicate().order(ByteOrder.LITTLE_ENDIAN)
        val reader = JvmFlatBufferReader(bb)

        val decoded = DeprecationTest.decode(reader, reader.getInt(0))
        assertEquals(111, decoded.a)
        assertEquals(222, decoded.b)
    }

    @Test
    fun `deprecated field is always its default regardless of what was written`() {
        val builder = FlatBufferBuilder(0)
        builder.startTable(3)
        builder.addInt(0, 1, 0)
        builder.addInt(1, 999, 0) // old_field: written, but must never surface
        builder.addInt(2, 2, 0)
        val off = builder.endTable()
        builder.finish(off)
        val bb = builder.dataBuffer().duplicate().order(ByteOrder.LITTLE_ENDIAN)
        val reader = JvmFlatBufferReader(bb)

        val decoded = DeprecationTest.decode(reader, reader.getInt(0))
        // old_field has no explicit schema default, so its inert value is the implicit zero.
        assertEquals(0, decoded.oldField)
    }

    @Test
    fun `deprecated field is never written by our own encode`() {
        @Suppress("DEPRECATION")
        val value = DeprecationTest(a = 1, oldField = 12345, b = 2)
        val decoded = roundTrip({ w -> value.encode(w) }, { r -> DeprecationTest.decode(r, r.getInt(0)) })
        assertEquals(1, decoded.a)
        assertEquals(2, decoded.b)
        assertEquals(0, decoded.oldField)
    }

    @Test
    fun `bit_flags enum values are powers of two`() {
        assertEquals(1.toUByte(), ColorFlags.Red.value)
        assertEquals(2.toUByte(), ColorFlags.Green.value)
        assertEquals(4.toUByte(), ColorFlags.Blue.value)
    }

    @Test
    fun `fixed-size struct array round trips`() {
        val value = FixedArrayTest(data = FixedArrayStruct(values = listOf(1, 2, 3)))
        val decoded = roundTrip({ w -> value.encode(w) }, { r -> FixedArrayTest.decode(r, r.getInt(0)) })
        assertEquals(value, decoded)
    }

    @Test
    fun `fixed-size struct array rejects the wrong element count at encode time`() {
        val value = FixedArrayTest(data = FixedArrayStruct(values = listOf(1, 2)))
        assertFailsWith<IllegalArgumentException> {
            value.encode(JvmFlatBufferWriter(FlatBufferBuilder(0)))
        }
    }

    @Test
    fun `force_align struct round trips`() {
        val value = AlignedStructTest(data = AlignedStruct(a = 1.toUByte(), b = 2.toUByte()))
        val decoded = roundTrip({ w -> value.encode(w) }, { r -> AlignedStructTest.decode(r, r.getInt(0)) })
        assertEquals(value, decoded)
    }

    @Test
    fun `aliased union members round trip`() {
        val value = AliasedUnionTest(value = AliasB(y = 3))
        val decoded = roundTrip({ w -> value.encode(w) }, { r -> AliasedUnionTest.decode(r, r.getInt(0)) })
        assertEquals(value, decoded)
    }
}
