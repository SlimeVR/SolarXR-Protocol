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
import solarxr_protocol.datatypes.TrackerActionMethod
import solarxr_protocol.datatypes.math.Quat
import solarxr_protocol.datatypes.math.Vec3f

public data class UpdateTrackerRequest(
  public val trackerId: UShort = 0.toUShort(),
  public val bodyPosition: BodyPart = BodyPart.NONE,
  public val mountingOrientation: Quat? = null,
  public val displayName: String? = null,
  public val boneOffset: Vec3f? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_displayName = displayName?.let { builder.createString(it) }

    builder.startTable(5)
    builder.addShort(0, trackerId.toShort(), 0)
    builder.addByte(1, bodyPosition.value.toByte(), 0)
    mountingOrientation?.let { builder.addStruct(2, it.encode(builder), 0) }
    __off_displayName?.let { builder.addOffset(3, it, 0) }
    boneOffset?.let { builder.addStruct(4, it.encode(builder), 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): UpdateTrackerRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_bodyPosition = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_mountingOrientation = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_displayName = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_boneOffset = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return UpdateTrackerRequest(
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else 0.toUShort(),
              bodyPosition = if (__offset_bodyPosition != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_bodyPosition).toUByte()) ?: BodyPart.NONE else BodyPart.NONE,
              mountingOrientation = if (__offset_mountingOrientation != 0) Quat.decode(bb, tableOffset + __offset_mountingOrientation) else null,
              displayName = if (__offset_displayName != 0) readFlatBufferString(bb, tableOffset + __offset_displayName) else null,
              boneOffset = if (__offset_boneOffset != 0) Vec3f.decode(bb, tableOffset + __offset_boneOffset) else null
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

public data class TrackerActionSettings(
  public val enabled: Boolean = false,
  public val delay: Float = 0.0f,
  public val bodyPart: BodyPart = BodyPart.NONE,
  public val method: TrackerActionMethod = TrackerActionMethod.TAP,
  public val taps: UByte = 0.toUByte(),
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(5)
    builder.addBoolean(0, enabled, false)
    builder.addFloat(1, delay, 0.0)
    builder.addByte(2, bodyPart.value.toByte(), 0)
    builder.addByte(3, method.value.toByte(), 0)
    builder.addByte(4, taps.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackerActionSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_delay = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_bodyPart = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_method = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_taps = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return TrackerActionSettings(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else false,
              delay = if (__offset_delay != 0) bb.getFloat(tableOffset + __offset_delay) else 0.0f,
              bodyPart = if (__offset_bodyPart != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_bodyPart).toUByte()) ?: BodyPart.NONE else BodyPart.NONE,
              method = if (__offset_method != 0) TrackerActionMethod.fromValue(bb.get(tableOffset + __offset_method).toUByte()) ?: TrackerActionMethod.TAP else TrackerActionMethod.TAP,
              taps = if (__offset_taps != 0) bb.get(tableOffset + __offset_taps).toUByte() else 0.toUByte()
          )
    }
  }
}

public class TrackerActionSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackerActionSettingsRequest = TrackerActionSettingsRequest()
  }
}

public data class TrackerActionSettingsResponse(
  public val fullResetAction: TrackerActionSettings? = null,
  public val yawResetAction: TrackerActionSettings? = null,
  public val mountingResetAction: TrackerActionSettings? = null,
  public val tapsTrackersOverThreshold: UByte = 0.toUByte(),
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_fullResetAction = fullResetAction?.encode(builder)
    val __off_yawResetAction = yawResetAction?.encode(builder)
    val __off_mountingResetAction = mountingResetAction?.encode(builder)

    builder.startTable(4)
    __off_fullResetAction?.let { builder.addOffset(0, it, 0) }
    __off_yawResetAction?.let { builder.addOffset(1, it, 0) }
    __off_mountingResetAction?.let { builder.addOffset(2, it, 0) }
    builder.addByte(3, tapsTrackersOverThreshold.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackerActionSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_fullResetAction = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_yawResetAction = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_mountingResetAction = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_tapsTrackersOverThreshold = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return TrackerActionSettingsResponse(
              fullResetAction = if (__offset_fullResetAction != 0) TrackerActionSettings.decode(bb, tableOffset + __offset_fullResetAction + bb.getInt(tableOffset + __offset_fullResetAction)) else null,
              yawResetAction = if (__offset_yawResetAction != 0) TrackerActionSettings.decode(bb, tableOffset + __offset_yawResetAction + bb.getInt(tableOffset + __offset_yawResetAction)) else null,
              mountingResetAction = if (__offset_mountingResetAction != 0) TrackerActionSettings.decode(bb, tableOffset + __offset_mountingResetAction + bb.getInt(tableOffset + __offset_mountingResetAction)) else null,
              tapsTrackersOverThreshold = if (__offset_tapsTrackersOverThreshold != 0) bb.get(tableOffset + __offset_tapsTrackersOverThreshold).toUByte() else 0.toUByte()
          )
    }
  }
}

public data class ChangeTrackerActionSettingsRequest(
  public val fullResetAction: TrackerActionSettings? = null,
  public val yawResetAction: TrackerActionSettings? = null,
  public val mountingResetAction: TrackerActionSettings? = null,
  public val tapsTrackersOverThreshold: UByte = 0.toUByte(),
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_fullResetAction = fullResetAction?.encode(builder)
    val __off_yawResetAction = yawResetAction?.encode(builder)
    val __off_mountingResetAction = mountingResetAction?.encode(builder)

    builder.startTable(4)
    __off_fullResetAction?.let { builder.addOffset(0, it, 0) }
    __off_yawResetAction?.let { builder.addOffset(1, it, 0) }
    __off_mountingResetAction?.let { builder.addOffset(2, it, 0) }
    builder.addByte(3, tapsTrackersOverThreshold.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeTrackerActionSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_fullResetAction = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_yawResetAction = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_mountingResetAction = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_tapsTrackersOverThreshold = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return ChangeTrackerActionSettingsRequest(
              fullResetAction = if (__offset_fullResetAction != 0) TrackerActionSettings.decode(bb, tableOffset + __offset_fullResetAction + bb.getInt(tableOffset + __offset_fullResetAction)) else null,
              yawResetAction = if (__offset_yawResetAction != 0) TrackerActionSettings.decode(bb, tableOffset + __offset_yawResetAction + bb.getInt(tableOffset + __offset_yawResetAction)) else null,
              mountingResetAction = if (__offset_mountingResetAction != 0) TrackerActionSettings.decode(bb, tableOffset + __offset_mountingResetAction + bb.getInt(tableOffset + __offset_mountingResetAction)) else null,
              tapsTrackersOverThreshold = if (__offset_tapsTrackersOverThreshold != 0) bb.get(tableOffset + __offset_tapsTrackersOverThreshold).toUByte() else 0.toUByte()
          )
    }
  }
}

/**
 * Sets the TrackerAction setup mode.
 */
public data class TrackerActionSetupModeRequest(
  public val setupMode: Boolean = false,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addBoolean(0, setupMode, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackerActionSetupModeRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_setupMode = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TrackerActionSetupModeRequest(
              setupMode = if (__offset_setupMode != 0) bb.get(tableOffset + __offset_setupMode) != 0.toByte() else false
          )
    }
  }
}

/**
 * Indicates which tracker got triggered by TrackerAction while setup mode is enabled
 */
public data class TrackerActionSetupNotification(
  public val trackerId: UShort = 0.toUShort(),
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addShort(0, trackerId.toShort(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackerActionSetupNotification {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TrackerActionSetupNotification(
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
