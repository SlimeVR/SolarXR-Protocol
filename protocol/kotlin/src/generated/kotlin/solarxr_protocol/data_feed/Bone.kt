package solarxr_protocol.data_feed

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Float
import kotlin.Int
import solarxr_protocol.datatypes.BodyPart
import solarxr_protocol.datatypes.math.Quat
import solarxr_protocol.datatypes.math.Vec3f

public data class Bone(
  public val bodyPart: BodyPart? = null,
  public val rotationG: Quat? = null,
  public val boneLength: Float? = null,
  public val headPositionG: Vec3f? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(4)
    if (bodyPart != null) { builder.forceDefaults(true); builder.addByte(0, bodyPart.value.toByte(), 0); builder.forceDefaults(false) }
    rotationG?.let { builder.addStruct(1, it.encode(builder), 0) }
    if (boneLength != null) { builder.forceDefaults(true); builder.addFloat(2, boneLength, 0.0); builder.forceDefaults(false) }
    headPositionG?.let { builder.addStruct(3, it.encode(builder), 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): Bone {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bodyPart = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_rotationG = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_boneLength = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_headPositionG = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return Bone(
              bodyPart = if (__offset_bodyPart != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_bodyPart).toUByte()) else null,
              rotationG = if (__offset_rotationG != 0) Quat.decode(bb, tableOffset + __offset_rotationG) else null,
              boneLength = if (__offset_boneLength != 0) bb.getFloat(tableOffset + __offset_boneLength) else null,
              headPositionG = if (__offset_headPositionG != 0) Vec3f.decode(bb, tableOffset + __offset_headPositionG) else null
          )
    }
  }
}
