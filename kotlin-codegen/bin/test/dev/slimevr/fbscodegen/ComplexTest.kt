package dev.slimevr.fbscodegen

import com.google.flatbuffers.FlatBufferBuilder
import dev.slimevr.fbscodegen.runtime.JvmFlatBufferReader
import dev.slimevr.fbscodegen.runtime.JvmFlatBufferWriter
import fixture.complex.*
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class ComplexTest {

    @Test
    fun `round trips enums and unions`() {
        val root = ComplexRoot(
            singleEnum = TestEnum.B,
            optionalEnum = TestEnum.C,
            explicitEnum = TestEnum.A,
            singleUnion = TestStruct(a = 42, b = 3.14f),
            enumVector = listOf(TestEnum.A, TestEnum.B, TestEnum.C)
        )

        val decoded = encodeDecode(root)
        assertEquals(root, decoded)
    }

    @Test
    fun `handles nullable enums and empty vectors`() {
        val root = ComplexRoot(
            optionalEnum = null,
            explicitEnum = TestEnum.B, // non-nullable because explicit default
            singleUnion = null,
            enumVector = null
        )

        val decoded = encodeDecode(root)
        assertEquals(root, decoded)
        assertEquals(TestEnum.A, decoded.singleEnum)
        assertNull(decoded.optionalEnum)
        assertEquals(TestEnum.B, decoded.explicitEnum)
        assertNull(decoded.singleUnion)
        assertNull(decoded.enumVector)
    }

    @Test
    fun `handles unknown enum values by falling back to default or filtering vector elements`() {
        // Manually build a buffer with an invalid enum value (e.g., 99)
        val builder = FlatBufferBuilder(0)

        // Add an enum vector [0, 99, 1] - MUST be done before starting the table
        val vOff = run {
            builder.startVector(1, 3, 1)
            builder.putByte(1.toByte())
            builder.putByte(99.toByte())
            builder.putByte(0.toByte())
            builder.endVector()
        }

        // ComplexRoot layout:
        // 0: singleEnum (1 byte)
        // 1: optionalEnum (1 byte)
        // 2: explicitEnum (1 byte)
        // 3: singleUnion type (1 byte)
        // 4: singleUnion data (offset)
        // 5: enumVector (offset)

        builder.startTable(6)

        // Add singleEnum = 99
        builder.forceDefaults(true)
        builder.addByte(0, 99.toByte(), 0)
        builder.forceDefaults(false)

        builder.addOffset(5, vOff, 0)

        val rootOff = builder.endTable()
        builder.finish(rootOff)

        val bb = builder.dataBuffer().duplicate().order(ByteOrder.LITTLE_ENDIAN)
        val decoded = ComplexRoot.fromByteBuffer(JvmFlatBufferReader(bb))

        // singleEnum is non-nullable (no explicit default), so an invalid on-wire byte falls
        // back to the implicit default (the enum's first value) rather than surfacing as null.
        assertEquals(TestEnum.A, decoded.singleEnum)

        // enumVector should be [A, B] because 99 was filtered out by mapNotNull
        assertEquals(listOf(TestEnum.A, TestEnum.B), decoded.enumVector)
    }

    private fun encodeDecode(root: ComplexRoot): ComplexRoot {
        val builder = FlatBufferBuilder(0)
        builder.finish(root.encode(JvmFlatBufferWriter(builder)))
        val bb = builder.dataBuffer().duplicate().order(ByteOrder.LITTLE_ENDIAN)
        return ComplexRoot.fromByteBuffer(JvmFlatBufferReader(bb))
    }
}
