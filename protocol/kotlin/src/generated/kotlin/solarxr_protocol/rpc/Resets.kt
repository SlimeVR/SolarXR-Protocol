package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.collections.List
import solarxr_protocol.datatypes.BodyPart

public enum class ResetType(
  public val `value`: UByte,
) {
  /**
   * Resets the yaw (horizontal) axis
   */
  Yaw(0.toUByte()),
  /**
   * Resets all axes
   */
  Full(1.toUByte()),
  /**
   * Second pose for calibrating mounting rotation
   */
  Mounting(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): ResetType? = entries.firstOrNull { it.value == value }
  }
}

public enum class ResetStatus(
  public val `value`: UByte,
) {
  Started(0.toUByte()),
  Finished(1.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): ResetStatus? = entries.firstOrNull { it.value == value }
  }
}

public data class ResetRequest(
  public val resetType: ResetType? = null,
  public val bodyParts: List<BodyPart>? = null,
  public val delay: Float? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_bodyParts = bodyParts?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }

    builder.startTable(3)
    if (resetType != null) { builder.forceDefaults(true); builder.addByte(0, resetType.value.toByte(), 0); builder.forceDefaults(false) }
    __off_bodyParts?.let { builder.addOffset(1, it, 0) }
    if (delay != null) { builder.forceDefaults(true); builder.addFloat(2, delay, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ResetRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_resetType = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_bodyParts = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_delay = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return ResetRequest(
              resetType = if (__offset_resetType != 0) ResetType.fromValue(bb.get(tableOffset + __offset_resetType).toUByte()) else null,
              bodyParts = if (__offset_bodyParts != 0) { val vecOff = tableOffset + __offset_bodyParts + bb.getInt(tableOffset + __offset_bodyParts); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> BodyPart.fromValue(bb.get(vecOff + 4 + i * 1).toUByte()) } } else null,
              delay = if (__offset_delay != 0) bb.getFloat(tableOffset + __offset_delay) else null
          )
    }
  }
}

public data class ResetResponse(
  public val resetType: ResetType? = null,
  public val status: ResetStatus? = null,
  public val bodyParts: List<BodyPart>? = null,
  public val progress: Int? = null,
  public val duration: Int? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_bodyParts = bodyParts?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }

    builder.startTable(5)
    if (resetType != null) { builder.forceDefaults(true); builder.addByte(0, resetType.value.toByte(), 0); builder.forceDefaults(false) }
    if (status != null) { builder.forceDefaults(true); builder.addByte(1, status.value.toByte(), 0); builder.forceDefaults(false) }
    __off_bodyParts?.let { builder.addOffset(2, it, 0) }
    if (progress != null) { builder.forceDefaults(true); builder.addInt(3, progress, 0); builder.forceDefaults(false) }
    if (duration != null) { builder.forceDefaults(true); builder.addInt(4, duration, 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ResetResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_resetType = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_status = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_bodyParts = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_progress = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_duration = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return ResetResponse(
              resetType = if (__offset_resetType != 0) ResetType.fromValue(bb.get(tableOffset + __offset_resetType).toUByte()) else null,
              status = if (__offset_status != 0) ResetStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) else null,
              bodyParts = if (__offset_bodyParts != 0) { val vecOff = tableOffset + __offset_bodyParts + bb.getInt(tableOffset + __offset_bodyParts); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> BodyPart.fromValue(bb.get(vecOff + 4 + i * 1).toUByte()) } } else null,
              progress = if (__offset_progress != 0) bb.getInt(tableOffset + __offset_progress) else null,
              duration = if (__offset_duration != 0) bb.getInt(tableOffset + __offset_duration) else null
          )
    }
  }
}

/**
 * Clears mounting reset data, defaulting to the manually set mounting orientations
 */
public class ClearMountingResetRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ClearMountingResetRequest = ClearMountingResetRequest()
  }
}

public enum class ArmsMountingResetMode(
  public val `value`: UByte,
) {
  /**
   * Upper arm going back and forearm going forward
   */
  BACK(0.toUByte()),
  /**
   * Arms going forward
   */
  FORWARD(1.toUByte()),
  /**
   * Arms going up to the sides into a t-pose
   */
  T_POSE_UP(2.toUByte()),
  /**
   * Arms going down to the sides from a t-pose
   */
  T_POSE_DOWN(3.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): ArmsMountingResetMode? = entries.firstOrNull { it.value == value }
  }
}

public class ResetsSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ResetsSettingsRequest = ResetsSettingsRequest()
  }
}

public data class ResetsSettingsResponse(
  public val resetMountingFeet: Boolean? = null,
  public val armsMountingResetMode: ArmsMountingResetMode? = null,
  public val yawResetSmoothTime: Float? = null,
  public val saveMountingReset: Boolean? = null,
  public val resetHmdPitch: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(5)
    if (resetMountingFeet != null) { builder.forceDefaults(true); builder.addBoolean(0, resetMountingFeet, false); builder.forceDefaults(false) }
    if (armsMountingResetMode != null) { builder.forceDefaults(true); builder.addByte(1, armsMountingResetMode.value.toByte(), 0); builder.forceDefaults(false) }
    if (yawResetSmoothTime != null) { builder.forceDefaults(true); builder.addFloat(2, yawResetSmoothTime, 0.0); builder.forceDefaults(false) }
    if (saveMountingReset != null) { builder.forceDefaults(true); builder.addBoolean(3, saveMountingReset, false); builder.forceDefaults(false) }
    if (resetHmdPitch != null) { builder.forceDefaults(true); builder.addBoolean(4, resetHmdPitch, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ResetsSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_resetMountingFeet = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_armsMountingResetMode = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_yawResetSmoothTime = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_saveMountingReset = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_resetHmdPitch = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return ResetsSettingsResponse(
              resetMountingFeet = if (__offset_resetMountingFeet != 0) bb.get(tableOffset + __offset_resetMountingFeet) != 0.toByte() else null,
              armsMountingResetMode = if (__offset_armsMountingResetMode != 0) ArmsMountingResetMode.fromValue(bb.get(tableOffset + __offset_armsMountingResetMode).toUByte()) else null,
              yawResetSmoothTime = if (__offset_yawResetSmoothTime != 0) bb.getFloat(tableOffset + __offset_yawResetSmoothTime) else null,
              saveMountingReset = if (__offset_saveMountingReset != 0) bb.get(tableOffset + __offset_saveMountingReset) != 0.toByte() else null,
              resetHmdPitch = if (__offset_resetHmdPitch != 0) bb.get(tableOffset + __offset_resetHmdPitch) != 0.toByte() else null
          )
    }
  }
}

public data class ChangeResetsSettingsRequest(
  public val resetMountingFeet: Boolean? = null,
  public val armsMountingResetMode: ArmsMountingResetMode? = null,
  public val yawResetSmoothTime: Float? = null,
  public val saveMountingReset: Boolean? = null,
  public val resetHmdPitch: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(5)
    if (resetMountingFeet != null) { builder.forceDefaults(true); builder.addBoolean(0, resetMountingFeet, false); builder.forceDefaults(false) }
    if (armsMountingResetMode != null) { builder.forceDefaults(true); builder.addByte(1, armsMountingResetMode.value.toByte(), 0); builder.forceDefaults(false) }
    if (yawResetSmoothTime != null) { builder.forceDefaults(true); builder.addFloat(2, yawResetSmoothTime, 0.0); builder.forceDefaults(false) }
    if (saveMountingReset != null) { builder.forceDefaults(true); builder.addBoolean(3, saveMountingReset, false); builder.forceDefaults(false) }
    if (resetHmdPitch != null) { builder.forceDefaults(true); builder.addBoolean(4, resetHmdPitch, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeResetsSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_resetMountingFeet = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_armsMountingResetMode = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_yawResetSmoothTime = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_saveMountingReset = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_resetHmdPitch = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return ChangeResetsSettingsRequest(
              resetMountingFeet = if (__offset_resetMountingFeet != 0) bb.get(tableOffset + __offset_resetMountingFeet) != 0.toByte() else null,
              armsMountingResetMode = if (__offset_armsMountingResetMode != 0) ArmsMountingResetMode.fromValue(bb.get(tableOffset + __offset_armsMountingResetMode).toUByte()) else null,
              yawResetSmoothTime = if (__offset_yawResetSmoothTime != 0) bb.getFloat(tableOffset + __offset_yawResetSmoothTime) else null,
              saveMountingReset = if (__offset_saveMountingReset != 0) bb.get(tableOffset + __offset_saveMountingReset) != 0.toByte() else null,
              resetHmdPitch = if (__offset_resetHmdPitch != 0) bb.get(tableOffset + __offset_resetHmdPitch) != 0.toByte() else null
          )
    }
  }
}
