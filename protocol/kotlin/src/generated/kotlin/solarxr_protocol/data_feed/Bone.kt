package solarxr_protocol.data_feed

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import solarxr_protocol.datatypes.BodyPart
import solarxr_protocol.datatypes.math.Quat
import solarxr_protocol.datatypes.math.Vec3f

public data class Bone(
  public val bodyPart: BodyPart? = null,
  public val orientationG: Quat? = null,
  public val rotationG: Quat? = null,
  public val boneLength: Float? = null,
  public val headPositionG: Vec3f? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(5)
    if (bodyPart != null) { builder.forceDefaults(true); builder.addByte(0, bodyPart.value.toByte(), 0); builder.forceDefaults(false) }
    orientationG?.let { builder.addStruct(1, it.encode(builder), 0) }
    rotationG?.let { builder.addStruct(2, it.encode(builder), 0) }
    if (boneLength != null) { builder.forceDefaults(true); builder.addFloat(3, boneLength, 0.0); builder.forceDefaults(false) }
    headPositionG?.let { builder.addStruct(4, it.encode(builder), 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): Bone {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bodyPart = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_orientationG = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_rotationG = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_boneLength = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_headPositionG = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return Bone(
              bodyPart = if (__offset_bodyPart != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_bodyPart).toUByte()) else null,
              orientationG = if (__offset_orientationG != 0) Quat.decode(bb, tableOffset + __offset_orientationG) else null,
              rotationG = if (__offset_rotationG != 0) Quat.decode(bb, tableOffset + __offset_rotationG) else null,
              boneLength = if (__offset_boneLength != 0) bb.getFloat(tableOffset + __offset_boneLength) else null,
              headPositionG = if (__offset_headPositionG != 0) Vec3f.decode(bb, tableOffset + __offset_headPositionG) else null
          )
    }
  }
}

public data class BoneMask(
  public val bodyPart: Boolean? = null,
  public val orientationG: Boolean? = null,
  public val rotationG: Boolean? = null,
  public val boneLength: Boolean? = null,
  public val headPositionG: Boolean? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(5)
    if (bodyPart != null) { builder.forceDefaults(true); builder.addBoolean(0, bodyPart, false); builder.forceDefaults(false) }
    if (orientationG != null) { builder.forceDefaults(true); builder.addBoolean(1, orientationG, false); builder.forceDefaults(false) }
    if (rotationG != null) { builder.forceDefaults(true); builder.addBoolean(2, rotationG, false); builder.forceDefaults(false) }
    if (boneLength != null) { builder.forceDefaults(true); builder.addBoolean(3, boneLength, false); builder.forceDefaults(false) }
    if (headPositionG != null) { builder.forceDefaults(true); builder.addBoolean(4, headPositionG, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): BoneMask {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bodyPart = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_orientationG = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_rotationG = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_boneLength = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_headPositionG = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return BoneMask(
              bodyPart = if (__offset_bodyPart != 0) bb.get(tableOffset + __offset_bodyPart) != 0.toByte() else null,
              orientationG = if (__offset_orientationG != 0) bb.get(tableOffset + __offset_orientationG) != 0.toByte() else null,
              rotationG = if (__offset_rotationG != 0) bb.get(tableOffset + __offset_rotationG) != 0.toByte() else null,
              boneLength = if (__offset_boneLength != 0) bb.get(tableOffset + __offset_boneLength) != 0.toByte() else null,
              headPositionG = if (__offset_headPositionG != 0) bb.get(tableOffset + __offset_headPositionG) != 0.toByte() else null
          )
    }
  }
}
