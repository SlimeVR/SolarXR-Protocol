package solarxr_protocol.data_feed.stay_aligned

import com.google.flatbuffers.FlatBufferBuilder
import java.nio.ByteBuffer
import kotlin.Boolean
import kotlin.Float
import kotlin.Int

data class StayAlignedPose(
  val upperLegAngleInDeg: Float = 0.0f,
  val lowerLegAngleInDeg: Float = 0.0f,
  val footAngleInDeg: Float = 0.0f,
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(3)
    builder.addFloat(0, upperLegAngleInDeg, 0.0)
    builder.addFloat(1, lowerLegAngleInDeg, 0.0)
    builder.addFloat(2, footAngleInDeg, 0.0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): StayAlignedPose {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_upperLegAngleInDeg = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_lowerLegAngleInDeg = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_footAngleInDeg = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return StayAlignedPose(
              upperLegAngleInDeg = if (__offset_upperLegAngleInDeg != 0) bb.getFloat(tableOffset + __offset_upperLegAngleInDeg) else 0.0f,
              lowerLegAngleInDeg = if (__offset_lowerLegAngleInDeg != 0) bb.getFloat(tableOffset + __offset_lowerLegAngleInDeg) else 0.0f,
              footAngleInDeg = if (__offset_footAngleInDeg != 0) bb.getFloat(tableOffset + __offset_footAngleInDeg) else 0.0f
          )
    }
  }
}

data class StayAlignedTracker(
  val yawCorrectionInDeg: Float = 0.0f,
  val lockedErrorInDeg: Float = 0.0f,
  val centerErrorInDeg: Float = 0.0f,
  val neighborErrorInDeg: Float = 0.0f,
  val locked: Boolean = false,
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(5)
    builder.addFloat(0, yawCorrectionInDeg, 0.0)
    builder.addFloat(1, lockedErrorInDeg, 0.0)
    builder.addFloat(2, centerErrorInDeg, 0.0)
    builder.addFloat(3, neighborErrorInDeg, 0.0)
    builder.addBoolean(4, locked, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): StayAlignedTracker {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_yawCorrectionInDeg = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_lockedErrorInDeg = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_centerErrorInDeg = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_neighborErrorInDeg = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_locked = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return StayAlignedTracker(
              yawCorrectionInDeg = if (__offset_yawCorrectionInDeg != 0) bb.getFloat(tableOffset + __offset_yawCorrectionInDeg) else 0.0f,
              lockedErrorInDeg = if (__offset_lockedErrorInDeg != 0) bb.getFloat(tableOffset + __offset_lockedErrorInDeg) else 0.0f,
              centerErrorInDeg = if (__offset_centerErrorInDeg != 0) bb.getFloat(tableOffset + __offset_centerErrorInDeg) else 0.0f,
              neighborErrorInDeg = if (__offset_neighborErrorInDeg != 0) bb.getFloat(tableOffset + __offset_neighborErrorInDeg) else 0.0f,
              locked = if (__offset_locked != 0) bb.get(tableOffset + __offset_locked) != 0.toByte() else false
          )
    }
  }
}
