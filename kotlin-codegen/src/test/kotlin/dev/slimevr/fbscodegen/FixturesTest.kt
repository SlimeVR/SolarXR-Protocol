package dev.slimevr.fbscodegen

import com.google.flatbuffers.FlatBufferBuilder
import dev.slimevr.fbscodegen.runtime.JvmFlatBufferReader
import dev.slimevr.fbscodegen.runtime.JvmFlatBufferWriter
import fixture.compound.NestedStruct
import fixture.compound.RootTable
import fixture.compound.ScalarVectors
import fixture.scalars.AllScalarStruct
import fixture.scalars.DefaultScalars
import fixture.scalars.OptionalScalars
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class FixturesTest {
    @Test
    fun `round trips all scalar kinds through compound schema`() {
        val scalarStruct = AllScalarStruct(
            b = true,
            i8 = (-128).toByte(),
            u8 = 255.toUByte(),
            i16 = (-32000).toShort(),
            u16 = 65000.toUShort(),
            i32 = -123456789,
            u32 = 4_000_000_000u,
            i64 = -9_876_543_210_123_456L,
            u64 = 18_000_000_000_000_000_000uL,
            f32 = 123.5f,
            f64 = -9876.125,
        )

        val root = RootTable(
            inlineStruct = scalarStruct,
            nestedStruct = NestedStruct(
                prefix = 7.toUByte(),
                inner = scalarStruct,
                suffix = (-123).toShort(),
            ),
            optionalScalars = OptionalScalars(
                obool = true,
                oi8 = (-7).toByte(),
                ou8 = 200.toUByte(),
                oi16 = (-1024).toShort(),
                ou16 = 2048.toUShort(),
                oi32 = -12345,
                ou32 = 54321u,
                oi64 = -999_999_999L,
                ou64 = 999_999_999uL,
                of32 = 6.25f,
                of64 = -8.5,
            ),
            defaultScalars = DefaultScalars(),
            vectors = ScalarVectors(
                bools = listOf(true, false, true),
                i8s = listOf((-128).toByte(), 0, 127),
                u8s = listOf(0.toUByte(), 1.toUByte(), 255.toUByte()),
                i16s = listOf((-32768).toShort(), 0, 32767.toShort()),
                u16s = listOf(0.toUShort(), 42.toUShort(), 65535.toUShort()),
                i32s = listOf(Int.MIN_VALUE, 0, Int.MAX_VALUE),
                u32s = listOf(0u, 1u, 4_000_000_000u),
                i64s = listOf(Long.MIN_VALUE, 0L, Long.MAX_VALUE),
                u64s = listOf(0uL, 1uL, ULong.MAX_VALUE),
                f32s = listOf(-1.25f, 0.0f, 3.5f),
                f64s = listOf(-1.25, 0.0, 3.5),
                names = listOf("alpha", "beta", "gamma"),
                structs = listOf(
                    scalarStruct,
                    scalarStruct.copy(
                        b = false,
                        i8 = 64,
                        u8 = 12.toUByte(),
                        i16 = 2048,
                        u16 = 4096.toUShort(),
                        i32 = 987654321,
                        u32 = 123u,
                        i64 = 42L,
                        u64 = 77uL,
                        f32 = -0.5f,
                        f64 = 0.25,
                    ),
                ),
            ),
            label = "scalar-root",
        )

        assertEquals(root, encodeDecodeWithNonZeroPosition(root))
    }

    @Test
    fun `preserves defaults and nullable scalar absence`() {
        val root = RootTable(
            inlineStruct = AllScalarStruct(
                b = false,
                i8 = 0,
                u8 = 0.toUByte(),
                i16 = 0,
                u16 = 0.toUShort(),
                i32 = 0,
                u32 = 0u,
                i64 = 0L,
                u64 = 0uL,
                f32 = 0.0f,
                f64 = 0.0,
            ),
            nestedStruct = NestedStruct(
                prefix = 0.toUByte(),
                inner = AllScalarStruct(
                    b = false,
                    i8 = 0,
                    u8 = 0.toUByte(),
                    i16 = 0,
                    u16 = 0.toUShort(),
                    i32 = 0,
                    u32 = 0u,
                    i64 = 0L,
                    u64 = 0uL,
                    f32 = 0.0f,
                    f64 = 0.0,
                ),
                suffix = 0,
            ),
            optionalScalars = OptionalScalars(),
            defaultScalars = DefaultScalars(),
            vectors = ScalarVectors(),
            label = "defaults",
        )

        val decoded = encodeDecodeWithNonZeroPosition(root)

        assertEquals(root, decoded)
        assertEquals(DefaultScalars(), decoded.defaultScalars)

        assertNull(decoded.optionalScalars?.obool)
        assertNull(decoded.optionalScalars?.oi8)
        assertNull(decoded.optionalScalars?.ou8)
        assertNull(decoded.optionalScalars?.oi16)
        assertNull(decoded.optionalScalars?.ou16)
        assertNull(decoded.optionalScalars?.oi32)
        assertNull(decoded.optionalScalars?.ou32)
        assertNull(decoded.optionalScalars?.oi64)
        assertNull(decoded.optionalScalars?.ou64)
        assertNull(decoded.optionalScalars?.of32)
        assertNull(decoded.optionalScalars?.of64)
    }

    private fun encodeDecodeWithNonZeroPosition(root: RootTable): RootTable {
        val builder = FlatBufferBuilder(0)
        builder.finish(root.encode(JvmFlatBufferWriter(builder)))
        val built = builder.dataBuffer().duplicate().order(ByteOrder.LITTLE_ENDIAN)

        val prefixed = ByteBuffer.allocate(built.remaining() + 8).order(ByteOrder.LITTLE_ENDIAN)
        prefixed.position(8)
        prefixed.put(built)
        prefixed.position(8)

        // For non-zero starting position, we slice the buffer so that get(0) is the start of the FlatBuffer
        val sliced = prefixed.slice().order(ByteOrder.LITTLE_ENDIAN)
        return RootTable.fromByteBuffer(JvmFlatBufferReader(sliced))
    }
}
