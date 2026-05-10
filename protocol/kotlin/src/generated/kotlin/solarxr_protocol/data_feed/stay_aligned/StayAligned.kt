package solarxr_protocol.data_feed.stay_aligned

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Float
import kotlin.Int

public data class StayAlignedPose(
  public val upperLegAngleInDeg: Float? = null,
  public val lowerLegAngleInDeg: Float? = null,
  public val footAngleInDeg: Float? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(3)
    if (upperLegAngleInDeg != null) { builder.forceDefaults(true); builder.addFloat(0, upperLegAngleInDeg, 0.0); builder.forceDefaults(false) }
    if (lowerLegAngleInDeg != null) { builder.forceDefaults(true); builder.addFloat(1, lowerLegAngleInDeg, 0.0); builder.forceDefaults(false) }
    if (footAngleInDeg != null) { builder.forceDefaults(true); builder.addFloat(2, footAngleInDeg, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StayAlignedPose {
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

public data class StayAlignedTracker(
  public val yawCorrectionInDeg: Float? = null,
  public val lockedErrorInDeg: Float? = null,
  public val centerErrorInDeg: Float? = null,
  public val neighborErrorInDeg: Float? = null,
  public val locked: Boolean? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(5)
    if (yawCorrectionInDeg != null) { builder.forceDefaults(true); builder.addFloat(0, yawCorrectionInDeg, 0.0); builder.forceDefaults(false) }
    if (lockedErrorInDeg != null) { builder.forceDefaults(true); builder.addFloat(1, lockedErrorInDeg, 0.0); builder.forceDefaults(false) }
    if (centerErrorInDeg != null) { builder.forceDefaults(true); builder.addFloat(2, centerErrorInDeg, 0.0); builder.forceDefaults(false) }
    if (neighborErrorInDeg != null) { builder.forceDefaults(true); builder.addFloat(3, neighborErrorInDeg, 0.0); builder.forceDefaults(false) }
    if (locked != null) { builder.forceDefaults(true); builder.addBoolean(4, locked, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StayAlignedTracker {
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
