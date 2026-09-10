package dev.slimevr.fbscodegen.runtime

/**
 * Common interface for reading from a FlatBuffer.
 * This abstracts away platform-specific buffer types like java.nio.ByteBuffer.
 */
interface FlatBufferReader {
    fun get(offset: Int): Byte
    fun getShort(offset: Int): Short
    fun getInt(offset: Int): Int
    fun getLong(offset: Int): Long
    fun getFloat(offset: Int): Float
    fun getDouble(offset: Int): Double
}

/**
 * Common interface for writing to a FlatBuffer.
 * This abstracts away the FlatBufferBuilder implementation.
 */
interface FlatBufferWriter {
    fun startTable(numFields: Int)
    fun endTable(): Int
    fun finish(rootOffset: Int)
    fun createString(s: String): Int
    fun addOffset(slot: Int, offset: Int, default: Int)
    fun addByte(slot: Int, value: Byte, default: Int)
    fun addShort(slot: Int, value: Short, default: Int)
    fun addInt(slot: Int, value: Int, default: Int)
    fun addLong(slot: Int, value: Long, default: Long)
    fun addFloat(slot: Int, value: Float, default: Double)
    fun addDouble(slot: Int, value: Double, default: Double)
    fun addBoolean(slot: Int, value: Boolean, default: Boolean)
    fun addStruct(slot: Int, offset: Int, default: Int)
    
    fun prep(size: Int, additionalBytes: Int)
    fun pad(count: Int)
    fun putByte(value: Byte)
    fun putShort(value: Short)
    fun putInt(value: Int)
    fun putLong(value: Long)
    fun putFloat(value: Float)
    fun putDouble(value: Double)
    fun offset(): Int
    
    fun startVector(elemSize: Int, numElems: Int, alignment: Int)
    fun endVector(): Int
    fun createByteVector(bytes: ByteArray): Int
    fun createVectorOfTables(offsets: IntArray): Int
    
    fun forceDefaults(force: Boolean)
}
