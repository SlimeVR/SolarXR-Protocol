package solarxr_protocol.datatypes.math

import com.google.flatbuffers.FlatBufferBuilder
import java.nio.ByteBuffer
import kotlin.Float
import kotlin.Int

data class Quat(
  val x: Float,
  val y: Float,
  val z: Float,
  val w: Float,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.prep(4, 16)
    builder.putFloat(w)
    builder.putFloat(z)
    builder.putFloat(y)
    builder.putFloat(x)
    return builder.offset()
  }

  companion object {
    fun decode(bb: ByteBuffer, offset: Int): Quat = Quat(x = bb.getFloat(offset + 0), y = bb.getFloat(offset + 4), z = bb.getFloat(offset + 8), w = bb.getFloat(offset + 12))
  }
}

data class Vec3f(
  val x: Float,
  val y: Float,
  val z: Float,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.prep(4, 12)
    builder.putFloat(z)
    builder.putFloat(y)
    builder.putFloat(x)
    return builder.offset()
  }

  companion object {
    fun decode(bb: ByteBuffer, offset: Int): Vec3f = Vec3f(x = bb.getFloat(offset + 0), y = bb.getFloat(offset + 4), z = bb.getFloat(offset + 8))
  }
}
