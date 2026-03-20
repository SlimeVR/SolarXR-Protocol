package solarxr_protocol.data_feed.stay_aligned

import com.google.flatbuffers.FlatBufferBuilder
import java.nio.ByteBuffer
import kotlin.Boolean
import kotlin.Float
import kotlin.Int

data class StayAlignedPose(
  val upperLegAngleInDeg: Float? = null,
  val lowerLegAngleInDeg: Float? = null,
  val footAngleInDeg: Float? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(3)
    upperLegAngleInDeg?.let { builder.addFloat(0, it, 0.0) }
    lowerLegAngleInDeg?.let { builder.addFloat(1, it, 0.0) }
    footAngleInDeg?.let { builder.addFloat(2, it, 0.0) }
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
              upperLegAngleInDeg = if (__offset_upperLegAngleInDeg != 0) bb.getFloat(tableOffset + __offset_upperLegAngleInDeg) else null,
              lowerLegAngleInDeg = if (__offset_lowerLegAngleInDeg != 0) bb.getFloat(tableOffset + __offset_lowerLegAngleInDeg) else null,
              footAngleInDeg = if (__offset_footAngleInDeg != 0) bb.getFloat(tableOffset + __offset_footAngleInDeg) else null
          )
    }
  }
}

data class StayAlignedTracker(
  val yawCorrectionInDeg: Float? = null,
  val lockedErrorInDeg: Float? = null,
  val centerErrorInDeg: Float? = null,
  val neighborErrorInDeg: Float? = null,
  val locked: Boolean? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(5)
    yawCorrectionInDeg?.let { builder.addFloat(0, it, 0.0) }
    lockedErrorInDeg?.let { builder.addFloat(1, it, 0.0) }
    centerErrorInDeg?.let { builder.addFloat(2, it, 0.0) }
    neighborErrorInDeg?.let { builder.addFloat(3, it, 0.0) }
    locked?.let { builder.addBoolean(4, it, false) }
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
              yawCorrectionInDeg = if (__offset_yawCorrectionInDeg != 0) bb.getFloat(tableOffset + __offset_yawCorrectionInDeg) else null,
              lockedErrorInDeg = if (__offset_lockedErrorInDeg != 0) bb.getFloat(tableOffset + __offset_lockedErrorInDeg) else null,
              centerErrorInDeg = if (__offset_centerErrorInDeg != 0) bb.getFloat(tableOffset + __offset_centerErrorInDeg) else null,
              neighborErrorInDeg = if (__offset_neighborErrorInDeg != 0) bb.getFloat(tableOffset + __offset_neighborErrorInDeg) else null,
              locked = if (__offset_locked != 0) bb.get(tableOffset + __offset_locked) != 0.toByte() else null
          )
    }
  }
}
