package dev.slimevr.fbscodegen.runtime

import java.nio.ByteBuffer
import java.nio.ByteOrder

/**
 * JVM implementation of FlatBufferReader wrapping a ByteBuffer.
 * It ensures the buffer is in LITTLE_ENDIAN order.
 */
class JvmFlatBufferReader(private val bb: ByteBuffer) : FlatBufferReader {
    init {
        bb.order(ByteOrder.LITTLE_ENDIAN)
    }

    override fun get(offset: Int): Byte = bb.get(bb.position() + offset)
    override fun getShort(offset: Int): Short = bb.getShort(bb.position() + offset)
    override fun getInt(offset: Int): Int = bb.getInt(bb.position() + offset)
    override fun getLong(offset: Int): Long = bb.getLong(bb.position() + offset)
    override fun getFloat(offset: Int): Float = bb.getFloat(bb.position() + offset)
    override fun getDouble(offset: Int): Double = bb.getDouble(bb.position() + offset)
}

/**
 * JVM implementation of FlatBufferWriter wrapping a FlatBufferBuilder.
 */
class JvmFlatBufferWriter(private val builder: com.google.flatbuffers.FlatBufferBuilder) : FlatBufferWriter {
    override fun startTable(numFields: Int) = builder.startTable(numFields)
    override fun endTable(): Int = builder.endTable()
    override fun finish(rootOffset: Int) = builder.finish(rootOffset)
    override fun createString(s: String): Int = builder.createString(s)
    override fun addOffset(slot: Int, offset: Int, default: Int) = builder.addOffset(slot, offset, default)
    override fun addByte(slot: Int, value: Byte, default: Int) = builder.addByte(slot, value, default)
    override fun addShort(slot: Int, value: Short, default: Int) = builder.addShort(slot, value, default)
    override fun addInt(slot: Int, value: Int, default: Int) = builder.addInt(slot, value, default)
    override fun addLong(slot: Int, value: Long, default: Long) = builder.addLong(slot, value, default)
    override fun addFloat(slot: Int, value: Float, default: Double) = builder.addFloat(slot, value, default)
    override fun addDouble(slot: Int, value: Double, default: Double) = builder.addDouble(slot, value, default)
    override fun addBoolean(slot: Int, value: Boolean, default: Boolean) = builder.addBoolean(slot, value, default)
    override fun addStruct(slot: Int, offset: Int, default: Int) = builder.addStruct(slot, offset, default)
    
    override fun prep(size: Int, additionalBytes: Int) = builder.prep(size, additionalBytes)
    override fun pad(count: Int) = builder.pad(count)
    override fun putByte(value: Byte) = builder.putByte(value)
    override fun putShort(value: Short) = builder.putShort(value)
    override fun putInt(value: Int) = builder.putInt(value)
    override fun putLong(value: Long) = builder.putLong(value)
    override fun putFloat(value: Float) = builder.putFloat(value)
    override fun putDouble(value: Double) = builder.putDouble(value)
    override fun offset(): Int = builder.offset()
    
    override fun startVector(elemSize: Int, numElems: Int, alignment: Int) = builder.startVector(elemSize, numElems, alignment)
    override fun endVector(): Int = builder.endVector()
    override fun createByteVector(bytes: ByteArray): Int = builder.createByteVector(bytes)
    override fun createVectorOfTables(offsets: IntArray): Int = builder.createVectorOfTables(offsets)
    
    override fun forceDefaults(force: Boolean) { builder.forceDefaults(force) }
}
