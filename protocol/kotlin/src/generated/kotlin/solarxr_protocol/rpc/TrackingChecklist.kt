package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UShort
import kotlin.collections.List

public enum class TrackingChecklistStepId(
  public val `value`: UByte,
) {
  UNKNOWN(0.toUByte()),
  TRACKERS_REST_CALIBRATION(1.toUByte()),
  FULL_RESET(2.toUByte()),
  VRCHAT_SETTINGS(3.toUByte()),
  STEAMVR_DISCONNECTED(4.toUByte()),
  UNASSIGNED_HMD(5.toUByte()),
  TRACKER_ERROR(6.toUByte()),
  NETWORK_PROFILE_PUBLIC(7.toUByte()),
  MOUNTING_CALIBRATION(8.toUByte()),
  FEET_MOUNTING_CALIBRATION(9.toUByte()),
  STAY_ALIGNED_CONFIGURED(10.toUByte()),
  STEAMVR_HANDS_ENABLED(11.toUByte()),
  STANDABLE_INSTALLED(12.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): TrackingChecklistStepId? = entries.firstOrNull { it.value == value }
  }
}

public enum class TrackingChecklistStepVisibility(
  public val `value`: UByte,
) {
  ALWAYS(0.toUByte()),
  WHEN_INVALID(1.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): TrackingChecklistStepVisibility? = entries.firstOrNull { it.value == value }
  }
}

/**
 * Trackers that need a reset
 */
public data class TrackingChecklistTrackerReset(
  public val trackersId: List<UShort>? = null,
) : TrackingChecklistExtraData {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackersId = trackersId?.let { run { val values = it; builder.startVector(2, values.size, 2); for (value in values.asReversed()) builder.putShort(value.toShort()); builder.endVector() } }

    builder.startTable(1)
    __off_trackersId?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackingChecklistTrackerReset {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackersId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TrackingChecklistTrackerReset(
              trackersId = if (__offset_trackersId != 0) { val vecOff = tableOffset + __offset_trackersId + bb.getInt(tableOffset + __offset_trackersId); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> bb.getShort(vecOff + 4 + i * 2).toUShort() } } else null
          )
    }
  }
}

/**
 * Trackers with error state
 */
public data class TrackingChecklistTrackerError(
  public val trackersId: List<UShort>? = null,
) : TrackingChecklistExtraData {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackersId = trackersId?.let { run { val values = it; builder.startVector(2, values.size, 2); for (value in values.asReversed()) builder.putShort(value.toShort()); builder.endVector() } }

    builder.startTable(1)
    __off_trackersId?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackingChecklistTrackerError {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackersId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TrackingChecklistTrackerError(
              trackersId = if (__offset_trackersId != 0) { val vecOff = tableOffset + __offset_trackersId + bb.getInt(tableOffset + __offset_trackersId); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> bb.getShort(vecOff + 4 + i * 2).toUShort() } } else null
          )
    }
  }
}

public data class TrackingChecklistNeedCalibration(
  public val trackersId: List<UShort>? = null,
) : TrackingChecklistExtraData {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackersId = trackersId?.let { run { val values = it; builder.startVector(2, values.size, 2); for (value in values.asReversed()) builder.putShort(value.toShort()); builder.endVector() } }

    builder.startTable(1)
    __off_trackersId?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackingChecklistNeedCalibration {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackersId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TrackingChecklistNeedCalibration(
              trackersId = if (__offset_trackersId != 0) { val vecOff = tableOffset + __offset_trackersId + bb.getInt(tableOffset + __offset_trackersId); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> bb.getShort(vecOff + 4 + i * 2).toUShort() } } else null
          )
    }
  }
}

public data class TrackingChecklistSteamVRDisconnected(
  public val bridgeSettingsName: String? = null,
  public val driverInstalled: Boolean = false,
  public val driverBlockedBySafeMode: Boolean = false,
  public val driverEnabled: Boolean = false,
) : TrackingChecklistExtraData {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_bridgeSettingsName = bridgeSettingsName?.let { builder.createString(it) }

    builder.startTable(4)
    __off_bridgeSettingsName?.let { builder.addOffset(0, it, 0) }
    builder.addBoolean(1, driverInstalled, false)
    builder.addBoolean(2, driverBlockedBySafeMode, false)
    builder.addBoolean(3, driverEnabled, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackingChecklistSteamVRDisconnected {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bridgeSettingsName = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_driverInstalled = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_driverBlockedBySafeMode = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_driverEnabled = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return TrackingChecklistSteamVRDisconnected(
              bridgeSettingsName = if (__offset_bridgeSettingsName != 0) readFlatBufferString(bb, tableOffset + __offset_bridgeSettingsName) else null,
              driverInstalled = if (__offset_driverInstalled != 0) bb.get(tableOffset + __offset_driverInstalled) != 0.toByte() else false,
              driverBlockedBySafeMode = if (__offset_driverBlockedBySafeMode != 0) bb.get(tableOffset + __offset_driverBlockedBySafeMode) != 0.toByte() else false,
              driverEnabled = if (__offset_driverEnabled != 0) bb.get(tableOffset + __offset_driverEnabled) != 0.toByte() else false
          )
    }
  }
}

public class EnableSteamVRDriverRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): EnableSteamVRDriverRequest = EnableSteamVRDriverRequest()
  }
}

public data class TrackingChecklistUnassignedHMD(
  public val trackerId: UShort = 0.toUShort(),
) : TrackingChecklistExtraData {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addShort(0, trackerId.toShort(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackingChecklistUnassignedHMD {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TrackingChecklistUnassignedHMD(
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else 0.toUShort()
          )
    }
  }
}

public data class TrackingChecklistPublicNetworks(
  public val adapters: List<String>? = null,
) : TrackingChecklistExtraData {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_adapters = adapters?.let { builder.createVectorOfTables(it.map { s -> builder.createString(s) }.toIntArray()) }

    builder.startTable(1)
    __off_adapters?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackingChecklistPublicNetworks {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_adapters = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TrackingChecklistPublicNetworks(
              adapters = if (__offset_adapters != 0) { val vecOff = tableOffset + __offset_adapters + bb.getInt(tableOffset + __offset_adapters); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> readFlatBufferString(bb, vecOff + 4 + i * 4) } } else null
          )
    }
  }
}

public sealed interface TrackingChecklistExtraData {
  public companion object {
    public fun decode(
      type: UByte,
      bb: FlatBufferReader,
      offset: Int,
    ): TrackingChecklistExtraData? = when (type.toInt()) {
      1 -> TrackingChecklistTrackerReset.decode(bb, offset)
      2 -> TrackingChecklistTrackerError.decode(bb, offset)
      3 -> TrackingChecklistSteamVRDisconnected.decode(bb, offset)
      4 -> TrackingChecklistUnassignedHMD.decode(bb, offset)
      5 -> TrackingChecklistNeedCalibration.decode(bb, offset)
      6 -> TrackingChecklistPublicNetworks.decode(bb, offset)
      else -> null
    }

    public fun typeIndex(`value`: TrackingChecklistExtraData): UByte = when (value) {
      is TrackingChecklistTrackerReset -> 1.toUByte()
      is TrackingChecklistTrackerError -> 2.toUByte()
      is TrackingChecklistSteamVRDisconnected -> 3.toUByte()
      is TrackingChecklistUnassignedHMD -> 4.toUByte()
      is TrackingChecklistNeedCalibration -> 5.toUByte()
      is TrackingChecklistPublicNetworks -> 6.toUByte()
    }

    public fun encode(`value`: TrackingChecklistExtraData, builder: FlatBufferWriter): Int = when (value) {
      is TrackingChecklistTrackerReset -> value.encode(builder)
      is TrackingChecklistTrackerError -> value.encode(builder)
      is TrackingChecklistSteamVRDisconnected -> value.encode(builder)
      is TrackingChecklistUnassignedHMD -> value.encode(builder)
      is TrackingChecklistNeedCalibration -> value.encode(builder)
      is TrackingChecklistPublicNetworks -> value.encode(builder)
    }
  }
}

public data class TrackingChecklistStep(
  public val id: TrackingChecklistStepId = TrackingChecklistStepId.UNKNOWN,
  public val valid: Boolean = false,
  public val enabled: Boolean = false,
  public val visibility: TrackingChecklistStepVisibility = TrackingChecklistStepVisibility.ALWAYS,
  public val optional: Boolean = false,
  public val ignorable: Boolean = false,
  public val extraData: TrackingChecklistExtraData? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_extraData = extraData?.let { TrackingChecklistExtraData.encode(it, builder) }
    val __type_extraData = extraData?.let { TrackingChecklistExtraData.typeIndex(it) } ?: 0.toUByte()

    builder.startTable(8)
    builder.addByte(0, id.value.toByte(), 0)
    builder.addBoolean(1, valid, false)
    builder.addBoolean(2, enabled, false)
    builder.addByte(3, visibility.value.toByte(), 0)
    builder.addBoolean(4, optional, false)
    builder.addBoolean(5, ignorable, false)
    builder.addByte(6, __type_extraData.toByte(), 0)
    __off_extraData?.let { builder.addOffset(7, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackingChecklistStep {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_id = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_valid = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_enabled = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_visibility = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_optional = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_ignorable = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __type_extraData = if (vtableSize > 16 && bb.getShort(vtableOffset + 16).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 16).toInt()).toUByte() else 0.toUByte()
      val __offset_extraData = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0

      return TrackingChecklistStep(
              id = if (__offset_id != 0) TrackingChecklistStepId.fromValue(bb.get(tableOffset + __offset_id).toUByte()) ?: TrackingChecklistStepId.UNKNOWN else TrackingChecklistStepId.UNKNOWN,
              valid = if (__offset_valid != 0) bb.get(tableOffset + __offset_valid) != 0.toByte() else false,
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else false,
              visibility = if (__offset_visibility != 0) TrackingChecklistStepVisibility.fromValue(bb.get(tableOffset + __offset_visibility).toUByte()) ?: TrackingChecklistStepVisibility.ALWAYS else TrackingChecklistStepVisibility.ALWAYS,
              optional = if (__offset_optional != 0) bb.get(tableOffset + __offset_optional) != 0.toByte() else false,
              ignorable = if (__offset_ignorable != 0) bb.get(tableOffset + __offset_ignorable) != 0.toByte() else false,
              extraData = if (__offset_extraData != 0) TrackingChecklistExtraData.decode(__type_extraData, bb, tableOffset + __offset_extraData + bb.getInt(tableOffset + __offset_extraData)) else null
          )
    }
  }
}

public class TrackingChecklistRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackingChecklistRequest = TrackingChecklistRequest()
  }
}

public data class TrackingChecklistResponse(
  public val steps: List<TrackingChecklistStep>? = null,
  public val ignoredSteps: List<TrackingChecklistStepId>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_steps = steps?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }
    val __off_ignoredSteps = ignoredSteps?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }

    builder.startTable(2)
    __off_steps?.let { builder.addOffset(0, it, 0) }
    __off_ignoredSteps?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackingChecklistResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_steps = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_ignoredSteps = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return TrackingChecklistResponse(
              steps = if (__offset_steps != 0) { val vecOff = tableOffset + __offset_steps + bb.getInt(tableOffset + __offset_steps); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) TrackingChecklistStep.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null,
              ignoredSteps = if (__offset_ignoredSteps != 0) { val vecOff = tableOffset + __offset_ignoredSteps + bb.getInt(tableOffset + __offset_ignoredSteps); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> TrackingChecklistStepId.fromValue(bb.get(vecOff + 4 + i * 1).toUByte()) } } else null
          )
    }
  }
}

public data class IgnoreTrackingChecklistStepRequest(
  public val stepId: TrackingChecklistStepId = TrackingChecklistStepId.UNKNOWN,
  public val ignore: Boolean = false,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    builder.addByte(0, stepId.value.toByte(), 0)
    builder.addBoolean(1, ignore, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): IgnoreTrackingChecklistStepRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_stepId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_ignore = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return IgnoreTrackingChecklistStepRequest(
              stepId = if (__offset_stepId != 0) TrackingChecklistStepId.fromValue(bb.get(tableOffset + __offset_stepId).toUByte()) ?: TrackingChecklistStepId.UNKNOWN else TrackingChecklistStepId.UNKNOWN,
              ignore = if (__offset_ignore != 0) bb.get(tableOffset + __offset_ignore) != 0.toByte() else false
          )
    }
  }
}
