package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.UByte

public enum class StayAlignedRelaxedPose(
  public val `value`: UByte,
) {
  STANDING(0.toUByte()),
  SITTING(1.toUByte()),
  FLAT(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): StayAlignedRelaxedPose? = entries.firstOrNull { it.value == value }
  }
}

public data class DetectStayAlignedRelaxedPoseRequest(
  public val pose: StayAlignedRelaxedPose? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (pose != null) { builder.forceDefaults(true); builder.addByte(0, pose.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): DetectStayAlignedRelaxedPoseRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_pose = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return DetectStayAlignedRelaxedPoseRequest(
              pose = if (__offset_pose != 0) StayAlignedRelaxedPose.fromValue(bb.get(tableOffset + __offset_pose).toUByte()) else null
          )
    }
  }
}

public data class ResetStayAlignedRelaxedPoseRequest(
  public val pose: StayAlignedRelaxedPose? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (pose != null) { builder.forceDefaults(true); builder.addByte(0, pose.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ResetStayAlignedRelaxedPoseRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_pose = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ResetStayAlignedRelaxedPoseRequest(
              pose = if (__offset_pose != 0) StayAlignedRelaxedPose.fromValue(bb.get(tableOffset + __offset_pose).toUByte()) else null
          )
    }
  }
}

public class StayAlignedSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StayAlignedSettingsRequest = StayAlignedSettingsRequest()
  }
}

public data class StayAlignedSettingsResponse(
  public val setupComplete: Boolean? = null,
  public val enabled: Boolean? = null,
  public val standingEnabled: Boolean? = null,
  public val standingUpperLegAngle: Float? = null,
  public val standingLowerLegAngle: Float? = null,
  public val standingFootAngle: Float? = null,
  public val sittingEnabled: Boolean? = null,
  public val sittingUpperLegAngle: Float? = null,
  public val sittingLowerLegAngle: Float? = null,
  public val sittingFootAngle: Float? = null,
  public val flatEnabled: Boolean? = null,
  public val flatUpperLegAngle: Float? = null,
  public val flatLowerLegAngle: Float? = null,
  public val flatFootAngle: Float? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(14)
    if (setupComplete != null) { builder.forceDefaults(true); builder.addBoolean(0, setupComplete, false); builder.forceDefaults(false) }
    if (enabled != null) { builder.forceDefaults(true); builder.addBoolean(1, enabled, false); builder.forceDefaults(false) }
    if (standingEnabled != null) { builder.forceDefaults(true); builder.addBoolean(2, standingEnabled, false); builder.forceDefaults(false) }
    if (standingUpperLegAngle != null) { builder.forceDefaults(true); builder.addFloat(3, standingUpperLegAngle, 0.0); builder.forceDefaults(false) }
    if (standingLowerLegAngle != null) { builder.forceDefaults(true); builder.addFloat(4, standingLowerLegAngle, 0.0); builder.forceDefaults(false) }
    if (standingFootAngle != null) { builder.forceDefaults(true); builder.addFloat(5, standingFootAngle, 0.0); builder.forceDefaults(false) }
    if (sittingEnabled != null) { builder.forceDefaults(true); builder.addBoolean(6, sittingEnabled, false); builder.forceDefaults(false) }
    if (sittingUpperLegAngle != null) { builder.forceDefaults(true); builder.addFloat(7, sittingUpperLegAngle, 0.0); builder.forceDefaults(false) }
    if (sittingLowerLegAngle != null) { builder.forceDefaults(true); builder.addFloat(8, sittingLowerLegAngle, 0.0); builder.forceDefaults(false) }
    if (sittingFootAngle != null) { builder.forceDefaults(true); builder.addFloat(9, sittingFootAngle, 0.0); builder.forceDefaults(false) }
    if (flatEnabled != null) { builder.forceDefaults(true); builder.addBoolean(10, flatEnabled, false); builder.forceDefaults(false) }
    if (flatUpperLegAngle != null) { builder.forceDefaults(true); builder.addFloat(11, flatUpperLegAngle, 0.0); builder.forceDefaults(false) }
    if (flatLowerLegAngle != null) { builder.forceDefaults(true); builder.addFloat(12, flatLowerLegAngle, 0.0); builder.forceDefaults(false) }
    if (flatFootAngle != null) { builder.forceDefaults(true); builder.addFloat(13, flatFootAngle, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StayAlignedSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_setupComplete = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_enabled = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_standingEnabled = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_standingUpperLegAngle = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_standingLowerLegAngle = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_standingFootAngle = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_sittingEnabled = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_sittingUpperLegAngle = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_sittingLowerLegAngle = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_sittingFootAngle = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_flatEnabled = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_flatUpperLegAngle = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0
      val __offset_flatLowerLegAngle = if (vtableSize > 28) bb.getShort(vtableOffset + 28).toInt() else 0
      val __offset_flatFootAngle = if (vtableSize > 30) bb.getShort(vtableOffset + 30).toInt() else 0

      return StayAlignedSettingsResponse(
              setupComplete = if (__offset_setupComplete != 0) bb.get(tableOffset + __offset_setupComplete) != 0.toByte() else null,
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else null,
              standingEnabled = if (__offset_standingEnabled != 0) bb.get(tableOffset + __offset_standingEnabled) != 0.toByte() else null,
              standingUpperLegAngle = if (__offset_standingUpperLegAngle != 0) bb.getFloat(tableOffset + __offset_standingUpperLegAngle) else null,
              standingLowerLegAngle = if (__offset_standingLowerLegAngle != 0) bb.getFloat(tableOffset + __offset_standingLowerLegAngle) else null,
              standingFootAngle = if (__offset_standingFootAngle != 0) bb.getFloat(tableOffset + __offset_standingFootAngle) else null,
              sittingEnabled = if (__offset_sittingEnabled != 0) bb.get(tableOffset + __offset_sittingEnabled) != 0.toByte() else null,
              sittingUpperLegAngle = if (__offset_sittingUpperLegAngle != 0) bb.getFloat(tableOffset + __offset_sittingUpperLegAngle) else null,
              sittingLowerLegAngle = if (__offset_sittingLowerLegAngle != 0) bb.getFloat(tableOffset + __offset_sittingLowerLegAngle) else null,
              sittingFootAngle = if (__offset_sittingFootAngle != 0) bb.getFloat(tableOffset + __offset_sittingFootAngle) else null,
              flatEnabled = if (__offset_flatEnabled != 0) bb.get(tableOffset + __offset_flatEnabled) != 0.toByte() else null,
              flatUpperLegAngle = if (__offset_flatUpperLegAngle != 0) bb.getFloat(tableOffset + __offset_flatUpperLegAngle) else null,
              flatLowerLegAngle = if (__offset_flatLowerLegAngle != 0) bb.getFloat(tableOffset + __offset_flatLowerLegAngle) else null,
              flatFootAngle = if (__offset_flatFootAngle != 0) bb.getFloat(tableOffset + __offset_flatFootAngle) else null
          )
    }
  }
}

public data class ChangeStayAlignedSettingsRequest(
  public val enabled: Boolean? = null,
  public val standingEnabled: Boolean? = null,
  public val sittingEnabled: Boolean? = null,
  public val flatEnabled: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(4)
    if (enabled != null) { builder.forceDefaults(true); builder.addBoolean(0, enabled, false); builder.forceDefaults(false) }
    if (standingEnabled != null) { builder.forceDefaults(true); builder.addBoolean(1, standingEnabled, false); builder.forceDefaults(false) }
    if (sittingEnabled != null) { builder.forceDefaults(true); builder.addBoolean(2, sittingEnabled, false); builder.forceDefaults(false) }
    if (flatEnabled != null) { builder.forceDefaults(true); builder.addBoolean(3, flatEnabled, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeStayAlignedSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_standingEnabled = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_sittingEnabled = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_flatEnabled = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return ChangeStayAlignedSettingsRequest(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else null,
              standingEnabled = if (__offset_standingEnabled != 0) bb.get(tableOffset + __offset_standingEnabled) != 0.toByte() else null,
              sittingEnabled = if (__offset_sittingEnabled != 0) bb.get(tableOffset + __offset_sittingEnabled) != 0.toByte() else null,
              flatEnabled = if (__offset_flatEnabled != 0) bb.get(tableOffset + __offset_flatEnabled) != 0.toByte() else null
          )
    }
  }
}

public data class ChangeStayAlignedEnabledRequest(
  public val enabled: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (enabled != null) { builder.forceDefaults(true); builder.addBoolean(0, enabled, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeStayAlignedEnabledRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ChangeStayAlignedEnabledRequest(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else null
          )
    }
  }
}

public class StayAlignedHideCorrectionRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StayAlignedHideCorrectionRequest = StayAlignedHideCorrectionRequest()
  }
}

public data class StayAlignedHideCorrectionResponse(
  public val hideCorrection: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (hideCorrection != null) { builder.forceDefaults(true); builder.addBoolean(0, hideCorrection, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StayAlignedHideCorrectionResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_hideCorrection = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StayAlignedHideCorrectionResponse(
              hideCorrection = if (__offset_hideCorrection != 0) bb.get(tableOffset + __offset_hideCorrection) != 0.toByte() else null
          )
    }
  }
}

public data class ChangeStayAlignedHideCorrectionRequest(
  public val hideCorrection: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (hideCorrection != null) { builder.forceDefaults(true); builder.addBoolean(0, hideCorrection, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeStayAlignedHideCorrectionRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_hideCorrection = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ChangeStayAlignedHideCorrectionRequest(
              hideCorrection = if (__offset_hideCorrection != 0) bb.get(tableOffset + __offset_hideCorrection) != 0.toByte() else null
          )
    }
  }
}
