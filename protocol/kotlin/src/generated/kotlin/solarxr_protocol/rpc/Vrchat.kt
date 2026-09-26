package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.collections.List

public enum class VRCTrackerModel(
  public val `value`: UByte,
) {
  UNKNOWN(0.toUByte()),
  SPHERE(1.toUByte()),
  SYSTEM(2.toUByte()),
  BOX(3.toUByte()),
  AXIS(4.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): VRCTrackerModel? = entries.firstOrNull { it.value == value }
  }
}

public enum class VRCSpineMode(
  public val `value`: UByte,
) {
  UNKNOWN(0.toUByte()),
  LOCK_HIP(1.toUByte()),
  LOCK_HEAD(2.toUByte()),
  LOCK_BOTH(3.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): VRCSpineMode? = entries.firstOrNull { it.value == value }
  }
}

public enum class VRCAvatarMeasurementType(
  public val `value`: UByte,
) {
  UNKNOWN(0.toUByte()),
  HEIGHT(1.toUByte()),
  ARM_SPAN(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): VRCAvatarMeasurementType? = entries.firstOrNull { it.value == value }
  }
}

public data class VRCConfigValidity(
  public val legacyModeOk: Boolean = false,
  public val shoulderTrackingOk: Boolean = false,
  public val userHeightOk: Boolean = false,
  public val calibrationRangeOk: Boolean = false,
  public val calibrationVisualsOk: Boolean = false,
  public val trackerModelOk: Boolean = false,
  public val spineModeOk: Boolean = false,
  public val avatarMeasurementTypeOk: Boolean = false,
  public val shoulderWidthCompensationOk: Boolean = false,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(9)
    builder.addBoolean(0, legacyModeOk, false)
    builder.addBoolean(1, shoulderTrackingOk, false)
    builder.addBoolean(2, userHeightOk, false)
    builder.addBoolean(3, calibrationRangeOk, false)
    builder.addBoolean(4, calibrationVisualsOk, false)
    builder.addBoolean(5, trackerModelOk, false)
    builder.addBoolean(6, spineModeOk, false)
    builder.addBoolean(7, avatarMeasurementTypeOk, false)
    builder.addBoolean(8, shoulderWidthCompensationOk, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VRCConfigValidity {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_legacyModeOk = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_shoulderTrackingOk = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_userHeightOk = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_calibrationRangeOk = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_calibrationVisualsOk = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_trackerModelOk = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_spineModeOk = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_avatarMeasurementTypeOk = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_shoulderWidthCompensationOk = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0

      return VRCConfigValidity(
              legacyModeOk = if (__offset_legacyModeOk != 0) bb.get(tableOffset + __offset_legacyModeOk) != 0.toByte() else false,
              shoulderTrackingOk = if (__offset_shoulderTrackingOk != 0) bb.get(tableOffset + __offset_shoulderTrackingOk) != 0.toByte() else false,
              userHeightOk = if (__offset_userHeightOk != 0) bb.get(tableOffset + __offset_userHeightOk) != 0.toByte() else false,
              calibrationRangeOk = if (__offset_calibrationRangeOk != 0) bb.get(tableOffset + __offset_calibrationRangeOk) != 0.toByte() else false,
              calibrationVisualsOk = if (__offset_calibrationVisualsOk != 0) bb.get(tableOffset + __offset_calibrationVisualsOk) != 0.toByte() else false,
              trackerModelOk = if (__offset_trackerModelOk != 0) bb.get(tableOffset + __offset_trackerModelOk) != 0.toByte() else false,
              spineModeOk = if (__offset_spineModeOk != 0) bb.get(tableOffset + __offset_spineModeOk) != 0.toByte() else false,
              avatarMeasurementTypeOk = if (__offset_avatarMeasurementTypeOk != 0) bb.get(tableOffset + __offset_avatarMeasurementTypeOk) != 0.toByte() else false,
              shoulderWidthCompensationOk = if (__offset_shoulderWidthCompensationOk != 0) bb.get(tableOffset + __offset_shoulderWidthCompensationOk) != 0.toByte() else false
          )
    }
  }
}

public data class VRCConfigValues(
  public val legacyMode: Boolean = false,
  public val shoulderTrackingDisabled: Boolean = false,
  public val userHeight: Float = 0.0f,
  public val calibrationRange: Float = 0.0f,
  public val calibrationVisuals: Boolean = false,
  public val trackerModel: VRCTrackerModel = VRCTrackerModel.UNKNOWN,
  public val spineMode: VRCSpineMode = VRCSpineMode.UNKNOWN,
  public val avatarMeasurementType: VRCAvatarMeasurementType = VRCAvatarMeasurementType.UNKNOWN,
  public val shoulderWidthCompensation: Boolean = false,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(9)
    builder.addBoolean(0, legacyMode, false)
    builder.addBoolean(1, shoulderTrackingDisabled, false)
    builder.addFloat(2, userHeight, 0.0)
    builder.addFloat(3, calibrationRange, 0.0)
    builder.addBoolean(4, calibrationVisuals, false)
    builder.addByte(5, trackerModel.value.toByte(), 0)
    builder.addByte(6, spineMode.value.toByte(), 0)
    builder.addByte(7, avatarMeasurementType.value.toByte(), 0)
    builder.addBoolean(8, shoulderWidthCompensation, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VRCConfigValues {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_legacyMode = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_shoulderTrackingDisabled = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_userHeight = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_calibrationRange = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_calibrationVisuals = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_trackerModel = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_spineMode = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_avatarMeasurementType = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_shoulderWidthCompensation = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0

      return VRCConfigValues(
              legacyMode = if (__offset_legacyMode != 0) bb.get(tableOffset + __offset_legacyMode) != 0.toByte() else false,
              shoulderTrackingDisabled = if (__offset_shoulderTrackingDisabled != 0) bb.get(tableOffset + __offset_shoulderTrackingDisabled) != 0.toByte() else false,
              userHeight = if (__offset_userHeight != 0) bb.getFloat(tableOffset + __offset_userHeight) else 0.0f,
              calibrationRange = if (__offset_calibrationRange != 0) bb.getFloat(tableOffset + __offset_calibrationRange) else 0.0f,
              calibrationVisuals = if (__offset_calibrationVisuals != 0) bb.get(tableOffset + __offset_calibrationVisuals) != 0.toByte() else false,
              trackerModel = if (__offset_trackerModel != 0) VRCTrackerModel.fromValue(bb.get(tableOffset + __offset_trackerModel).toUByte()) ?: VRCTrackerModel.UNKNOWN else VRCTrackerModel.UNKNOWN,
              spineMode = if (__offset_spineMode != 0) VRCSpineMode.fromValue(bb.get(tableOffset + __offset_spineMode).toUByte()) ?: VRCSpineMode.UNKNOWN else VRCSpineMode.UNKNOWN,
              avatarMeasurementType = if (__offset_avatarMeasurementType != 0) VRCAvatarMeasurementType.fromValue(bb.get(tableOffset + __offset_avatarMeasurementType).toUByte()) ?: VRCAvatarMeasurementType.UNKNOWN else VRCAvatarMeasurementType.UNKNOWN,
              shoulderWidthCompensation = if (__offset_shoulderWidthCompensation != 0) bb.get(tableOffset + __offset_shoulderWidthCompensation) != 0.toByte() else false
          )
    }
  }
}

public data class VRCConfigRecommendedValues(
  public val legacyMode: Boolean = false,
  public val shoulderTrackingDisabled: Boolean = false,
  public val userHeight: Float = 0.0f,
  public val calibrationRange: Float = 0.0f,
  public val calibrationVisuals: Boolean = false,
  public val trackerModel: VRCTrackerModel = VRCTrackerModel.UNKNOWN,
  public val spineMode: List<VRCSpineMode>? = null,
  public val avatarMeasurementType: VRCAvatarMeasurementType = VRCAvatarMeasurementType.UNKNOWN,
  public val shoulderWidthCompensation: Boolean = false,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_spineMode = spineMode?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }

    builder.startTable(9)
    builder.addBoolean(0, legacyMode, false)
    builder.addBoolean(1, shoulderTrackingDisabled, false)
    builder.addFloat(2, userHeight, 0.0)
    builder.addFloat(3, calibrationRange, 0.0)
    builder.addBoolean(4, calibrationVisuals, false)
    builder.addByte(5, trackerModel.value.toByte(), 0)
    __off_spineMode?.let { builder.addOffset(6, it, 0) }
    builder.addByte(7, avatarMeasurementType.value.toByte(), 0)
    builder.addBoolean(8, shoulderWidthCompensation, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VRCConfigRecommendedValues {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_legacyMode = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_shoulderTrackingDisabled = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_userHeight = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_calibrationRange = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_calibrationVisuals = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_trackerModel = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_spineMode = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_avatarMeasurementType = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_shoulderWidthCompensation = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0

      return VRCConfigRecommendedValues(
              legacyMode = if (__offset_legacyMode != 0) bb.get(tableOffset + __offset_legacyMode) != 0.toByte() else false,
              shoulderTrackingDisabled = if (__offset_shoulderTrackingDisabled != 0) bb.get(tableOffset + __offset_shoulderTrackingDisabled) != 0.toByte() else false,
              userHeight = if (__offset_userHeight != 0) bb.getFloat(tableOffset + __offset_userHeight) else 0.0f,
              calibrationRange = if (__offset_calibrationRange != 0) bb.getFloat(tableOffset + __offset_calibrationRange) else 0.0f,
              calibrationVisuals = if (__offset_calibrationVisuals != 0) bb.get(tableOffset + __offset_calibrationVisuals) != 0.toByte() else false,
              trackerModel = if (__offset_trackerModel != 0) VRCTrackerModel.fromValue(bb.get(tableOffset + __offset_trackerModel).toUByte()) ?: VRCTrackerModel.UNKNOWN else VRCTrackerModel.UNKNOWN,
              spineMode = if (__offset_spineMode != 0) { val vecOff = tableOffset + __offset_spineMode + bb.getInt(tableOffset + __offset_spineMode); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> VRCSpineMode.fromValue(bb.get(vecOff + 4 + i * 1).toUByte()) } } else null,
              avatarMeasurementType = if (__offset_avatarMeasurementType != 0) VRCAvatarMeasurementType.fromValue(bb.get(tableOffset + __offset_avatarMeasurementType).toUByte()) ?: VRCAvatarMeasurementType.UNKNOWN else VRCAvatarMeasurementType.UNKNOWN,
              shoulderWidthCompensation = if (__offset_shoulderWidthCompensation != 0) bb.get(tableOffset + __offset_shoulderWidthCompensation) != 0.toByte() else false
          )
    }
  }
}

public class VRCConfigStateRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VRCConfigStateRequest = VRCConfigStateRequest()
  }
}

/**
 * Sent every time the vrchat config state gets updated
 * used to display vrchat missconfig settings to the user
 */
public data class VRCConfigStateChangeResponse(
  public val isSupported: Boolean = false,
  public val validity: VRCConfigValidity? = null,
  public val state: VRCConfigValues? = null,
  public val recommended: VRCConfigRecommendedValues? = null,
  public val muted: List<String>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_validity = validity?.encode(builder)
    val __off_state = state?.encode(builder)
    val __off_recommended = recommended?.encode(builder)
    val __off_muted = muted?.let { builder.createVectorOfTables(it.map { s -> builder.createString(s) }.toIntArray()) }

    builder.startTable(5)
    builder.addBoolean(0, isSupported, false)
    __off_validity?.let { builder.addOffset(1, it, 0) }
    __off_state?.let { builder.addOffset(2, it, 0) }
    __off_recommended?.let { builder.addOffset(3, it, 0) }
    __off_muted?.let { builder.addOffset(4, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VRCConfigStateChangeResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_isSupported = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_validity = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_state = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_recommended = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_muted = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return VRCConfigStateChangeResponse(
              isSupported = if (__offset_isSupported != 0) bb.get(tableOffset + __offset_isSupported) != 0.toByte() else false,
              validity = if (__offset_validity != 0) VRCConfigValidity.decode(bb, tableOffset + __offset_validity + bb.getInt(tableOffset + __offset_validity)) else null,
              state = if (__offset_state != 0) VRCConfigValues.decode(bb, tableOffset + __offset_state + bb.getInt(tableOffset + __offset_state)) else null,
              recommended = if (__offset_recommended != 0) VRCConfigRecommendedValues.decode(bb, tableOffset + __offset_recommended + bb.getInt(tableOffset + __offset_recommended)) else null,
              muted = if (__offset_muted != 0) { val vecOff = tableOffset + __offset_muted + bb.getInt(tableOffset + __offset_muted); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> readFlatBufferString(bb, vecOff + 4 + i * 4) } } else null
          )
    }
  }
}

public data class VRCConfigSettingToggleMute(
  public val key: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_key = key?.let { builder.createString(it) }

    builder.startTable(1)
    __off_key?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VRCConfigSettingToggleMute {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_key = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return VRCConfigSettingToggleMute(
              key = if (__offset_key != 0) readFlatBufferString(bb, tableOffset + __offset_key) else null
          )
    }
  }
}
