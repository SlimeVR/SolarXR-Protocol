package solarxr_protocol.datatypes

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import solarxr_protocol.datatypes.math.Quat
import solarxr_protocol.datatypes.math.Vec3f

/**
 * Unless specified otherwise, bone data is global (relative to the world, not to another bone).
 */
public data class Bone(
  public val bodyPart: BodyPart = BodyPart.NONE,
  public val boneLength: Float = 0.0f,
  public val rotation: Quat? = null,
  public val orientation: Quat? = null,
  public val headPosition: Vec3f? = null,
  public val tailPosition: Vec3f? = null,
  public val linearVelocity: Vec3f? = null,
  public val angularVelocity: Vec3f? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(8)
    builder.addByte(0, bodyPart.value.toByte(), 0)
    builder.addFloat(1, boneLength, 0.0)
    rotation?.let { builder.addStruct(2, it.encode(builder), 0) }
    orientation?.let { builder.addStruct(3, it.encode(builder), 0) }
    headPosition?.let { builder.addStruct(4, it.encode(builder), 0) }
    tailPosition?.let { builder.addStruct(5, it.encode(builder), 0) }
    linearVelocity?.let { builder.addStruct(6, it.encode(builder), 0) }
    angularVelocity?.let { builder.addStruct(7, it.encode(builder), 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): Bone {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bodyPart = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_boneLength = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_rotation = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_orientation = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_headPosition = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_tailPosition = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_linearVelocity = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_angularVelocity = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0

      return Bone(
              bodyPart = if (__offset_bodyPart != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_bodyPart).toUByte()) ?: BodyPart.NONE else BodyPart.NONE,
              boneLength = if (__offset_boneLength != 0) bb.getFloat(tableOffset + __offset_boneLength) else 0.0f,
              rotation = if (__offset_rotation != 0) Quat.decode(bb, tableOffset + __offset_rotation) else null,
              orientation = if (__offset_orientation != 0) Quat.decode(bb, tableOffset + __offset_orientation) else null,
              headPosition = if (__offset_headPosition != 0) Vec3f.decode(bb, tableOffset + __offset_headPosition) else null,
              tailPosition = if (__offset_tailPosition != 0) Vec3f.decode(bb, tableOffset + __offset_tailPosition) else null,
              linearVelocity = if (__offset_linearVelocity != 0) Vec3f.decode(bb, tableOffset + __offset_linearVelocity) else null,
              angularVelocity = if (__offset_angularVelocity != 0) Vec3f.decode(bb, tableOffset + __offset_angularVelocity) else null
          )
    }
  }
}

public data class BoneMask(
  public val bodyPart: Boolean = false,
  public val boneLength: Boolean = false,
  public val rotation: Boolean = false,
  public val orientation: Boolean = false,
  public val headPosition: Boolean = false,
  public val tailPosition: Boolean = false,
  public val linearVelocity: Boolean = false,
  public val angularVelocity: Boolean = false,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(8)
    builder.addBoolean(0, bodyPart, false)
    builder.addBoolean(1, boneLength, false)
    builder.addBoolean(2, rotation, false)
    builder.addBoolean(3, orientation, false)
    builder.addBoolean(4, headPosition, false)
    builder.addBoolean(5, tailPosition, false)
    builder.addBoolean(6, linearVelocity, false)
    builder.addBoolean(7, angularVelocity, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): BoneMask {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bodyPart = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_boneLength = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_rotation = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_orientation = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_headPosition = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_tailPosition = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_linearVelocity = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_angularVelocity = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0

      return BoneMask(
              bodyPart = if (__offset_bodyPart != 0) bb.get(tableOffset + __offset_bodyPart) != 0.toByte() else false,
              boneLength = if (__offset_boneLength != 0) bb.get(tableOffset + __offset_boneLength) != 0.toByte() else false,
              rotation = if (__offset_rotation != 0) bb.get(tableOffset + __offset_rotation) != 0.toByte() else false,
              orientation = if (__offset_orientation != 0) bb.get(tableOffset + __offset_orientation) != 0.toByte() else false,
              headPosition = if (__offset_headPosition != 0) bb.get(tableOffset + __offset_headPosition) != 0.toByte() else false,
              tailPosition = if (__offset_tailPosition != 0) bb.get(tableOffset + __offset_tailPosition) != 0.toByte() else false,
              linearVelocity = if (__offset_linearVelocity != 0) bb.get(tableOffset + __offset_linearVelocity) != 0.toByte() else false,
              angularVelocity = if (__offset_angularVelocity != 0) bb.get(tableOffset + __offset_angularVelocity) != 0.toByte() else false
          )
    }
  }
}
