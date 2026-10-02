package dev.slimevr.fbscodegen.runtime

fun readFlatBufferString(bb: FlatBufferReader, offset: Int): String {
    val stringOffset = offset + bb.getInt(offset)
    val length = bb.getInt(stringOffset)
    val bytes = ByteArray(length)
    for (i in 0 until length) {
        bytes[i] = bb.get(stringOffset + 4 + i)
    }
    return bytes.decodeToString()
}
