package solarxr_protocol.data_feed

import com.google.flatbuffers.FlatBufferBuilder
import java.nio.ByteBuffer
import kotlin.Float
import kotlin.Int
import solarxr_protocol.datatypes.BodyPart
import solarxr_protocol.datatypes.math.Quat
import solarxr_protocol.datatypes.math.Vec3f

data class Bone(
  val bodyPart: BodyPart? = null,
  val rotationG: Quat? = null,
  val boneLength: Float = 0.0f,
  val headPositionG: Vec3f? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(4)
    bodyPart?.let { builder.addByte(0, it.value.toByte(), 0) }
    rotationG?.let { builder.addStruct(1, it.encode(builder), 0) }
    builder.addFloat(2, boneLength, 0.0)
    headPositionG?.let { builder.addStruct(3, it.encode(builder), 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): Bone {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bodyPart = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_rotationG = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_boneLength = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_headPositionG = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return Bone(
              bodyPart = if (__offset_bodyPart != 0) solarxr_protocol.datatypes.BodyPart.fromValue(bb.get(tableOffset + __offset_bodyPart).toUByte()) else null,
              rotationG = if (__offset_rotationG != 0) solarxr_protocol.datatypes.math.Quat.decode(bb, tableOffset + __offset_rotationG) else null,
              boneLength = if (__offset_boneLength != 0) bb.getFloat(tableOffset + __offset_boneLength) else 0.0f,
              headPositionG = if (__offset_headPositionG != 0) solarxr_protocol.datatypes.math.Vec3f.decode(bb, tableOffset + __offset_headPositionG) else null
          )
    }
  }
}
