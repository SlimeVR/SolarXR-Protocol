package solarxr_protocol.datatypes.math

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Float
import kotlin.Int

public data class Quat(
  public val x: Float,
  public val y: Float,
  public val z: Float,
  public val w: Float,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.prep(4, 16)
    var written = 0
    builder.pad(0 - written)
    builder.putFloat(w)
    written = 4
    builder.pad(4 - written)
    builder.putFloat(z)
    written = 8
    builder.pad(8 - written)
    builder.putFloat(y)
    written = 12
    builder.pad(12 - written)
    builder.putFloat(x)
    written = 16
    return builder.offset()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, offset: Int): Quat = Quat(x = bb.getFloat(offset + 0), y = bb.getFloat(offset + 4), z = bb.getFloat(offset + 8), w = bb.getFloat(offset + 12))
  }
}

public data class Vec3f(
  public val x: Float,
  public val y: Float,
  public val z: Float,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.prep(4, 12)
    var written = 0
    builder.pad(0 - written)
    builder.putFloat(z)
    written = 4
    builder.pad(4 - written)
    builder.putFloat(y)
    written = 8
    builder.pad(8 - written)
    builder.putFloat(x)
    written = 12
    return builder.offset()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, offset: Int): Vec3f = Vec3f(x = bb.getFloat(offset + 0), y = bb.getFloat(offset + 4), z = bb.getFloat(offset + 8))
  }
}
