package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UShort
import solarxr_protocol.datatypes.BodyPart
import solarxr_protocol.datatypes.math.Quat

public data class AssignTrackerRequest(
  public val trackerId: UShort = 0.toUShort(),
  public val bodyPosition: BodyPart = BodyPart.NONE,
  public val mountingOrientation: Quat? = null,
  public val displayName: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_displayName = displayName?.let { builder.createString(it) }

    builder.startTable(4)
    builder.addShort(0, trackerId.toShort(), 0)
    builder.addByte(1, bodyPosition.value.toByte(), 0)
    mountingOrientation?.let { builder.addStruct(2, it.encode(builder), 0) }
    __off_displayName?.let { builder.addOffset(3, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): AssignTrackerRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_bodyPosition = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_mountingOrientation = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_displayName = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return AssignTrackerRequest(
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else 0.toUShort(),
              bodyPosition = if (__offset_bodyPosition != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_bodyPosition).toUByte()) ?: BodyPart.NONE else BodyPart.NONE,
              mountingOrientation = if (__offset_mountingOrientation != 0) Quat.decode(bb, tableOffset + __offset_mountingOrientation) else null,
              displayName = if (__offset_displayName != 0) readFlatBufferString(bb, tableOffset + __offset_displayName) else null
          )
    }
  }
}

public class ResetTrackerAssignments : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ResetTrackerAssignments = ResetTrackerAssignments()
  }
}

public class TapDetectionSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TapDetectionSettingsRequest = TapDetectionSettingsRequest()
  }
}

public data class TapDetectionSettingsResponse(
  public val fullResetDelay: Float? = null,
  public val fullResetEnabled: Boolean? = null,
  public val fullResetTaps: UByte? = null,
  public val yawResetDelay: Float? = null,
  public val yawResetEnabled: Boolean? = null,
  public val yawResetTaps: UByte? = null,
  public val mountingResetDelay: Float? = null,
  public val mountingResetEnabled: Boolean? = null,
  public val mountingResetTaps: UByte? = null,
  public val numberTrackersOverThreshold: UByte? = null,
  public val yawResetTracker: BodyPart? = null,
  public val fullResetTracker: BodyPart? = null,
  public val mountingResetTracker: BodyPart? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(13)
    if (fullResetDelay != null) { builder.forceDefaults(true); builder.addFloat(0, fullResetDelay, 0.0); builder.forceDefaults(false) }
    if (fullResetEnabled != null) { builder.forceDefaults(true); builder.addBoolean(1, fullResetEnabled, false); builder.forceDefaults(false) }
    if (fullResetTaps != null) { builder.forceDefaults(true); builder.addByte(2, fullResetTaps.toByte(), 0); builder.forceDefaults(false) }
    if (yawResetDelay != null) { builder.forceDefaults(true); builder.addFloat(3, yawResetDelay, 0.0); builder.forceDefaults(false) }
    if (yawResetEnabled != null) { builder.forceDefaults(true); builder.addBoolean(4, yawResetEnabled, false); builder.forceDefaults(false) }
    if (yawResetTaps != null) { builder.forceDefaults(true); builder.addByte(5, yawResetTaps.toByte(), 0); builder.forceDefaults(false) }
    if (mountingResetDelay != null) { builder.forceDefaults(true); builder.addFloat(6, mountingResetDelay, 0.0); builder.forceDefaults(false) }
    if (mountingResetEnabled != null) { builder.forceDefaults(true); builder.addBoolean(7, mountingResetEnabled, false); builder.forceDefaults(false) }
    if (mountingResetTaps != null) { builder.forceDefaults(true); builder.addByte(8, mountingResetTaps.toByte(), 0); builder.forceDefaults(false) }
    if (numberTrackersOverThreshold != null) { builder.forceDefaults(true); builder.addByte(9, numberTrackersOverThreshold.toByte(), 0); builder.forceDefaults(false) }
    if (yawResetTracker != null) { builder.forceDefaults(true); builder.addByte(10, yawResetTracker.value.toByte(), 0); builder.forceDefaults(false) }
    if (fullResetTracker != null) { builder.forceDefaults(true); builder.addByte(11, fullResetTracker.value.toByte(), 0); builder.forceDefaults(false) }
    if (mountingResetTracker != null) { builder.forceDefaults(true); builder.addByte(12, mountingResetTracker.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TapDetectionSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_fullResetDelay = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_fullResetEnabled = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_fullResetTaps = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_yawResetDelay = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_yawResetEnabled = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_yawResetTaps = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_mountingResetDelay = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_mountingResetEnabled = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_mountingResetTaps = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_numberTrackersOverThreshold = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_yawResetTracker = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_fullResetTracker = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0
      val __offset_mountingResetTracker = if (vtableSize > 28) bb.getShort(vtableOffset + 28).toInt() else 0

      return TapDetectionSettingsResponse(
              fullResetDelay = if (__offset_fullResetDelay != 0) bb.getFloat(tableOffset + __offset_fullResetDelay) else null,
              fullResetEnabled = if (__offset_fullResetEnabled != 0) bb.get(tableOffset + __offset_fullResetEnabled) != 0.toByte() else null,
              fullResetTaps = if (__offset_fullResetTaps != 0) bb.get(tableOffset + __offset_fullResetTaps).toUByte() else null,
              yawResetDelay = if (__offset_yawResetDelay != 0) bb.getFloat(tableOffset + __offset_yawResetDelay) else null,
              yawResetEnabled = if (__offset_yawResetEnabled != 0) bb.get(tableOffset + __offset_yawResetEnabled) != 0.toByte() else null,
              yawResetTaps = if (__offset_yawResetTaps != 0) bb.get(tableOffset + __offset_yawResetTaps).toUByte() else null,
              mountingResetDelay = if (__offset_mountingResetDelay != 0) bb.getFloat(tableOffset + __offset_mountingResetDelay) else null,
              mountingResetEnabled = if (__offset_mountingResetEnabled != 0) bb.get(tableOffset + __offset_mountingResetEnabled) != 0.toByte() else null,
              mountingResetTaps = if (__offset_mountingResetTaps != 0) bb.get(tableOffset + __offset_mountingResetTaps).toUByte() else null,
              numberTrackersOverThreshold = if (__offset_numberTrackersOverThreshold != 0) bb.get(tableOffset + __offset_numberTrackersOverThreshold).toUByte() else null,
              yawResetTracker = if (__offset_yawResetTracker != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_yawResetTracker).toUByte()) else null,
              fullResetTracker = if (__offset_fullResetTracker != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_fullResetTracker).toUByte()) else null,
              mountingResetTracker = if (__offset_mountingResetTracker != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_mountingResetTracker).toUByte()) else null
          )
    }
  }
}

public data class ChangeTapDetectionSettingsRequest(
  public val fullResetDelay: Float? = null,
  public val fullResetEnabled: Boolean? = null,
  public val fullResetTaps: UByte? = null,
  public val yawResetDelay: Float? = null,
  public val yawResetEnabled: Boolean? = null,
  public val yawResetTaps: UByte? = null,
  public val mountingResetDelay: Float? = null,
  public val mountingResetEnabled: Boolean? = null,
  public val mountingResetTaps: UByte? = null,
  public val numberTrackersOverThreshold: UByte? = null,
  public val yawResetTracker: BodyPart? = null,
  public val fullResetTracker: BodyPart? = null,
  public val mountingResetTracker: BodyPart? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(13)
    if (fullResetDelay != null) { builder.forceDefaults(true); builder.addFloat(0, fullResetDelay, 0.0); builder.forceDefaults(false) }
    if (fullResetEnabled != null) { builder.forceDefaults(true); builder.addBoolean(1, fullResetEnabled, false); builder.forceDefaults(false) }
    if (fullResetTaps != null) { builder.forceDefaults(true); builder.addByte(2, fullResetTaps.toByte(), 0); builder.forceDefaults(false) }
    if (yawResetDelay != null) { builder.forceDefaults(true); builder.addFloat(3, yawResetDelay, 0.0); builder.forceDefaults(false) }
    if (yawResetEnabled != null) { builder.forceDefaults(true); builder.addBoolean(4, yawResetEnabled, false); builder.forceDefaults(false) }
    if (yawResetTaps != null) { builder.forceDefaults(true); builder.addByte(5, yawResetTaps.toByte(), 0); builder.forceDefaults(false) }
    if (mountingResetDelay != null) { builder.forceDefaults(true); builder.addFloat(6, mountingResetDelay, 0.0); builder.forceDefaults(false) }
    if (mountingResetEnabled != null) { builder.forceDefaults(true); builder.addBoolean(7, mountingResetEnabled, false); builder.forceDefaults(false) }
    if (mountingResetTaps != null) { builder.forceDefaults(true); builder.addByte(8, mountingResetTaps.toByte(), 0); builder.forceDefaults(false) }
    if (numberTrackersOverThreshold != null) { builder.forceDefaults(true); builder.addByte(9, numberTrackersOverThreshold.toByte(), 0); builder.forceDefaults(false) }
    if (yawResetTracker != null) { builder.forceDefaults(true); builder.addByte(10, yawResetTracker.value.toByte(), 0); builder.forceDefaults(false) }
    if (fullResetTracker != null) { builder.forceDefaults(true); builder.addByte(11, fullResetTracker.value.toByte(), 0); builder.forceDefaults(false) }
    if (mountingResetTracker != null) { builder.forceDefaults(true); builder.addByte(12, mountingResetTracker.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeTapDetectionSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_fullResetDelay = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_fullResetEnabled = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_fullResetTaps = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_yawResetDelay = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_yawResetEnabled = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_yawResetTaps = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_mountingResetDelay = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_mountingResetEnabled = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_mountingResetTaps = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_numberTrackersOverThreshold = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_yawResetTracker = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_fullResetTracker = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0
      val __offset_mountingResetTracker = if (vtableSize > 28) bb.getShort(vtableOffset + 28).toInt() else 0

      return ChangeTapDetectionSettingsRequest(
              fullResetDelay = if (__offset_fullResetDelay != 0) bb.getFloat(tableOffset + __offset_fullResetDelay) else null,
              fullResetEnabled = if (__offset_fullResetEnabled != 0) bb.get(tableOffset + __offset_fullResetEnabled) != 0.toByte() else null,
              fullResetTaps = if (__offset_fullResetTaps != 0) bb.get(tableOffset + __offset_fullResetTaps).toUByte() else null,
              yawResetDelay = if (__offset_yawResetDelay != 0) bb.getFloat(tableOffset + __offset_yawResetDelay) else null,
              yawResetEnabled = if (__offset_yawResetEnabled != 0) bb.get(tableOffset + __offset_yawResetEnabled) != 0.toByte() else null,
              yawResetTaps = if (__offset_yawResetTaps != 0) bb.get(tableOffset + __offset_yawResetTaps).toUByte() else null,
              mountingResetDelay = if (__offset_mountingResetDelay != 0) bb.getFloat(tableOffset + __offset_mountingResetDelay) else null,
              mountingResetEnabled = if (__offset_mountingResetEnabled != 0) bb.get(tableOffset + __offset_mountingResetEnabled) != 0.toByte() else null,
              mountingResetTaps = if (__offset_mountingResetTaps != 0) bb.get(tableOffset + __offset_mountingResetTaps).toUByte() else null,
              numberTrackersOverThreshold = if (__offset_numberTrackersOverThreshold != 0) bb.get(tableOffset + __offset_numberTrackersOverThreshold).toUByte() else null,
              yawResetTracker = if (__offset_yawResetTracker != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_yawResetTracker).toUByte()) else null,
              fullResetTracker = if (__offset_fullResetTracker != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_fullResetTracker).toUByte()) else null,
              mountingResetTracker = if (__offset_mountingResetTracker != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_mountingResetTracker).toUByte()) else null
          )
    }
  }
}

/**
 * Sets the TapDetection setup mode.
 */
public data class TapDetectionSetupModeRequest(
  public val setupMode: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (setupMode != null) { builder.forceDefaults(true); builder.addBoolean(0, setupMode, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TapDetectionSetupModeRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_setupMode = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TapDetectionSetupModeRequest(
              setupMode = if (__offset_setupMode != 0) bb.get(tableOffset + __offset_setupMode) != 0.toByte() else null
          )
    }
  }
}

/**
 * Indicates which tracker got triggered by TapDetection while setup mode is enabled
 */
public data class TapDetectionSetupNotification(
  public val trackerId: UShort = 0.toUShort(),
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addShort(0, trackerId.toShort(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TapDetectionSetupNotification {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TapDetectionSetupNotification(
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else 0.toUShort()
          )
    }
  }
}

/**
 * If no tracker ID is given, it's the setting for every tracker/device
 */
public data class MagToggleRequest(
  public val trackerId: UShort = 0.toUShort(),
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addShort(0, trackerId.toShort(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): MagToggleRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return MagToggleRequest(
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else 0.toUShort()
          )
    }
  }
}

/**
 * If no tracker ID is given, it's the setting for every tracker/device
 */
public data class MagToggleResponse(
  public val trackerId: UShort = 0.toUShort(),
  public val enable: Boolean = false,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    builder.addShort(0, trackerId.toShort(), 0)
    builder.addBoolean(1, enable, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): MagToggleResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_enable = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return MagToggleResponse(
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else 0.toUShort(),
              enable = if (__offset_enable != 0) bb.get(tableOffset + __offset_enable) != 0.toByte() else false
          )
    }
  }
}

/**
 * If no tracker ID is given, it's the setting for every tracker/device
 */
public data class ChangeMagToggleRequest(
  public val trackerId: UShort = 0.toUShort(),
  public val enable: Boolean = false,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    builder.addShort(0, trackerId.toShort(), 0)
    builder.addBoolean(1, enable, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeMagToggleRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_enable = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return ChangeMagToggleRequest(
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else 0.toUShort(),
              enable = if (__offset_enable != 0) bb.get(tableOffset + __offset_enable) != 0.toByte() else false
          )
    }
  }
}

public class TimeoutSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TimeoutSettingsRequest = TimeoutSettingsRequest()
  }
}

public data class TimeoutSettingsResponse(
  public val delay: Float = 0.0f,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addFloat(0, delay, 0.0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TimeoutSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_delay = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TimeoutSettingsResponse(
              delay = if (__offset_delay != 0) bb.getFloat(tableOffset + __offset_delay) else 0.0f
          )
    }
  }
}

public data class ChangeTimeoutSettingsRequest(
  public val delay: Float = 0.0f,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addFloat(0, delay, 0.0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeTimeoutSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_delay = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ChangeTimeoutSettingsRequest(
              delay = if (__offset_delay != 0) bb.getFloat(tableOffset + __offset_delay) else 0.0f
          )
    }
  }
}
