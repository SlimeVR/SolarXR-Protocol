package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Boolean
import kotlin.Byte
import kotlin.Deprecated
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.collections.List
import solarxr_protocol.datatypes.BodyPart
import solarxr_protocol.datatypes.DeviceId
import solarxr_protocol.datatypes.DeviceIdTable
import solarxr_protocol.datatypes.FilteringType
import solarxr_protocol.datatypes.TrackerId
import solarxr_protocol.datatypes.TransactionId
import solarxr_protocol.datatypes.math.Quat
import solarxr_protocol.rpc.settings.ModelSettings

public sealed interface RpcMessage {
  public companion object {
    public fun decode(
      type: Byte,
      bb: FlatBufferReader,
      offset: Int,
    ): RpcMessage? = when (type.toInt()) {
      1 -> HeartbeatRequest.decode(bb, offset)
      2 -> HeartbeatResponse.decode(bb, offset)
      3 -> ResetRequest.decode(bb, offset)
      4 -> ResetResponse.decode(bb, offset)
      5 -> AssignTrackerRequest.decode(bb, offset)
      6 -> SettingsRequest.decode(bb, offset)
      7 -> SettingsResponse.decode(bb, offset)
      8 -> ChangeSettingsRequest.decode(bb, offset)
      9 -> ClearDriftCompensationRequest.decode(bb, offset)
      10 -> RecordBVHRequest.decode(bb, offset)
      11 -> RecordBVHStatus.decode(bb, offset)
      12 -> SkeletonConfigRequest.decode(bb, offset)
      13 -> ChangeSkeletonConfigRequest.decode(bb, offset)
      14 -> SkeletonResetAllRequest.decode(bb, offset)
      15 -> SkeletonConfigResponse.decode(bb, offset)
      16 -> OpenSerialRequest.decode(bb, offset)
      17 -> CloseSerialRequest.decode(bb, offset)
      18 -> SetWifiRequest.decode(bb, offset)
      19 -> SerialUpdateResponse.decode(bb, offset)
      20 -> AutoBoneProcessRequest.decode(bb, offset)
      21 -> AutoBoneProcessStatusResponse.decode(bb, offset)
      22 -> AutoBoneEpochResponse.decode(bb, offset)
      23 -> OverlayDisplayModeRequest.decode(bb, offset)
      24 -> OverlayDisplayModeChangeRequest.decode(bb, offset)
      25 -> OverlayDisplayModeResponse.decode(bb, offset)
      26 -> SerialTrackerRebootRequest.decode(bb, offset)
      27 -> SerialTrackerGetInfoRequest.decode(bb, offset)
      28 -> SerialTrackerFactoryResetRequest.decode(bb, offset)
      29 -> SerialDevicesRequest.decode(bb, offset)
      30 -> SerialDevicesResponse.decode(bb, offset)
      31 -> NewSerialDeviceResponse.decode(bb, offset)
      32 -> StartWifiProvisioningRequest.decode(bb, offset)
      33 -> StopWifiProvisioningRequest.decode(bb, offset)
      34 -> WifiProvisioningStatusResponse.decode(bb, offset)
      35 -> ServerInfosRequest.decode(bb, offset)
      36 -> ServerInfosResponse.decode(bb, offset)
      37 -> LegTweaksTmpChange.decode(bb, offset)
      38 -> LegTweaksTmpClear.decode(bb, offset)
      39 -> TapDetectionSetupNotification.decode(bb, offset)
      40 -> SetPauseTrackingRequest.decode(bb, offset)
      41 -> StatusSystemRequest.decode(bb, offset)
      42 -> StatusSystemResponse.decode(bb, offset)
      43 -> StatusSystemUpdate.decode(bb, offset)
      44 -> StatusSystemFixed.decode(bb, offset)
      45 -> ClearMountingResetRequest.decode(bb, offset)
      46 -> HeightRequest.decode(bb, offset)
      47 -> HeightResponse.decode(bb, offset)
      48 -> AutoBoneApplyRequest.decode(bb, offset)
      49 -> AutoBoneStopRecordingRequest.decode(bb, offset)
      50 -> AutoBoneCancelRecordingRequest.decode(bb, offset)
      51 -> SaveFileNotification.decode(bb, offset)
      52 -> TrackingPauseStateRequest.decode(bb, offset)
      53 -> TrackingPauseStateResponse.decode(bb, offset)
      54 -> SerialTrackerGetWifiScanRequest.decode(bb, offset)
      55 -> UnknownDeviceHandshakeNotification.decode(bb, offset)
      56 -> AddUnknownDeviceRequest.decode(bb, offset)
      57 -> ForgetDeviceRequest.decode(bb, offset)
      58 -> FirmwareUpdateRequest.decode(bb, offset)
      59 -> FirmwareUpdateStatusResponse.decode(bb, offset)
      60 -> FirmwareUpdateStopQueuesRequest.decode(bb, offset)
      61 -> SettingsResetRequest.decode(bb, offset)
      62 -> MagToggleRequest.decode(bb, offset)
      63 -> MagToggleResponse.decode(bb, offset)
      64 -> ChangeMagToggleRequest.decode(bb, offset)
      65 -> RecordBVHStatusRequest.decode(bb, offset)
      66 -> VRCConfigStateRequest.decode(bb, offset)
      67 -> VRCConfigStateChangeResponse.decode(bb, offset)
      68 -> EnableStayAlignedRequest.decode(bb, offset)
      69 -> DetectStayAlignedRelaxedPoseRequest.decode(bb, offset)
      70 -> ResetStayAlignedRelaxedPoseRequest.decode(bb, offset)
      71 -> SerialTrackerCustomCommandRequest.decode(bb, offset)
      72 -> VRCConfigSettingToggleMute.decode(bb, offset)
      73 -> TrackingChecklistRequest.decode(bb, offset)
      74 -> TrackingChecklistResponse.decode(bb, offset)
      75 -> IgnoreTrackingChecklistStepRequest.decode(bb, offset)
      76 -> StartUserHeightCalibration.decode(bb, offset)
      77 -> CancelUserHeightCalibration.decode(bb, offset)
      78 -> UserHeightRecordingStatusResponse.decode(bb, offset)
      79 -> VRCOSCSettingsRequest.decode(bb, offset)
      80 -> VRCOSCSettingsResponse.decode(bb, offset)
      81 -> ChangeVRCOSCSettingsRequest.decode(bb, offset)
      82 -> VRCOSCStatusRequest.decode(bb, offset)
      83 -> VRCOSCStatusChangeResponse.decode(bb, offset)
      84 -> KeybindRequest.decode(bb, offset)
      85 -> ChangeKeybindRequest.decode(bb, offset)
      86 -> KeybindResponse.decode(bb, offset)
      87 -> InstalledInfoRequest.decode(bb, offset)
      88 -> InstalledInfoResponse.decode(bb, offset)
      89 -> OpenUriRequest.decode(bb, offset)
      90 -> OpenUriResponse.decode(bb, offset)
      91 -> EnableSteamVRDriverRequest.decode(bb, offset)
      else -> null
    }

    public fun typeIndex(`value`: RpcMessage): Byte = when (value) {
      is HeartbeatRequest -> 1
      is HeartbeatResponse -> 2
      is ResetRequest -> 3
      is ResetResponse -> 4
      is AssignTrackerRequest -> 5
      is SettingsRequest -> 6
      is SettingsResponse -> 7
      is ChangeSettingsRequest -> 8
      is ClearDriftCompensationRequest -> 9
      is RecordBVHRequest -> 10
      is RecordBVHStatus -> 11
      is SkeletonConfigRequest -> 12
      is ChangeSkeletonConfigRequest -> 13
      is SkeletonResetAllRequest -> 14
      is SkeletonConfigResponse -> 15
      is OpenSerialRequest -> 16
      is CloseSerialRequest -> 17
      is SetWifiRequest -> 18
      is SerialUpdateResponse -> 19
      is AutoBoneProcessRequest -> 20
      is AutoBoneProcessStatusResponse -> 21
      is AutoBoneEpochResponse -> 22
      is OverlayDisplayModeRequest -> 23
      is OverlayDisplayModeChangeRequest -> 24
      is OverlayDisplayModeResponse -> 25
      is SerialTrackerRebootRequest -> 26
      is SerialTrackerGetInfoRequest -> 27
      is SerialTrackerFactoryResetRequest -> 28
      is SerialDevicesRequest -> 29
      is SerialDevicesResponse -> 30
      is NewSerialDeviceResponse -> 31
      is StartWifiProvisioningRequest -> 32
      is StopWifiProvisioningRequest -> 33
      is WifiProvisioningStatusResponse -> 34
      is ServerInfosRequest -> 35
      is ServerInfosResponse -> 36
      is LegTweaksTmpChange -> 37
      is LegTweaksTmpClear -> 38
      is TapDetectionSetupNotification -> 39
      is SetPauseTrackingRequest -> 40
      is StatusSystemRequest -> 41
      is StatusSystemResponse -> 42
      is StatusSystemUpdate -> 43
      is StatusSystemFixed -> 44
      is ClearMountingResetRequest -> 45
      is HeightRequest -> 46
      is HeightResponse -> 47
      is AutoBoneApplyRequest -> 48
      is AutoBoneStopRecordingRequest -> 49
      is AutoBoneCancelRecordingRequest -> 50
      is SaveFileNotification -> 51
      is TrackingPauseStateRequest -> 52
      is TrackingPauseStateResponse -> 53
      is SerialTrackerGetWifiScanRequest -> 54
      is UnknownDeviceHandshakeNotification -> 55
      is AddUnknownDeviceRequest -> 56
      is ForgetDeviceRequest -> 57
      is FirmwareUpdateRequest -> 58
      is FirmwareUpdateStatusResponse -> 59
      is FirmwareUpdateStopQueuesRequest -> 60
      is SettingsResetRequest -> 61
      is MagToggleRequest -> 62
      is MagToggleResponse -> 63
      is ChangeMagToggleRequest -> 64
      is RecordBVHStatusRequest -> 65
      is VRCConfigStateRequest -> 66
      is VRCConfigStateChangeResponse -> 67
      is EnableStayAlignedRequest -> 68
      is DetectStayAlignedRelaxedPoseRequest -> 69
      is ResetStayAlignedRelaxedPoseRequest -> 70
      is SerialTrackerCustomCommandRequest -> 71
      is VRCConfigSettingToggleMute -> 72
      is TrackingChecklistRequest -> 73
      is TrackingChecklistResponse -> 74
      is IgnoreTrackingChecklistStepRequest -> 75
      is StartUserHeightCalibration -> 76
      is CancelUserHeightCalibration -> 77
      is UserHeightRecordingStatusResponse -> 78
      is VRCOSCSettingsRequest -> 79
      is VRCOSCSettingsResponse -> 80
      is ChangeVRCOSCSettingsRequest -> 81
      is VRCOSCStatusRequest -> 82
      is VRCOSCStatusChangeResponse -> 83
      is KeybindRequest -> 84
      is ChangeKeybindRequest -> 85
      is KeybindResponse -> 86
      is InstalledInfoRequest -> 87
      is InstalledInfoResponse -> 88
      is OpenUriRequest -> 89
      is OpenUriResponse -> 90
      is EnableSteamVRDriverRequest -> 91
    }

    public fun encode(`value`: RpcMessage, builder: FlatBufferWriter): Int = when (value) {
      is HeartbeatRequest -> value.encode(builder)
      is HeartbeatResponse -> value.encode(builder)
      is ResetRequest -> value.encode(builder)
      is ResetResponse -> value.encode(builder)
      is AssignTrackerRequest -> value.encode(builder)
      is SettingsRequest -> value.encode(builder)
      is SettingsResponse -> value.encode(builder)
      is ChangeSettingsRequest -> value.encode(builder)
      is ClearDriftCompensationRequest -> value.encode(builder)
      is RecordBVHRequest -> value.encode(builder)
      is RecordBVHStatus -> value.encode(builder)
      is SkeletonConfigRequest -> value.encode(builder)
      is ChangeSkeletonConfigRequest -> value.encode(builder)
      is SkeletonResetAllRequest -> value.encode(builder)
      is SkeletonConfigResponse -> value.encode(builder)
      is OpenSerialRequest -> value.encode(builder)
      is CloseSerialRequest -> value.encode(builder)
      is SetWifiRequest -> value.encode(builder)
      is SerialUpdateResponse -> value.encode(builder)
      is AutoBoneProcessRequest -> value.encode(builder)
      is AutoBoneProcessStatusResponse -> value.encode(builder)
      is AutoBoneEpochResponse -> value.encode(builder)
      is OverlayDisplayModeRequest -> value.encode(builder)
      is OverlayDisplayModeChangeRequest -> value.encode(builder)
      is OverlayDisplayModeResponse -> value.encode(builder)
      is SerialTrackerRebootRequest -> value.encode(builder)
      is SerialTrackerGetInfoRequest -> value.encode(builder)
      is SerialTrackerFactoryResetRequest -> value.encode(builder)
      is SerialDevicesRequest -> value.encode(builder)
      is SerialDevicesResponse -> value.encode(builder)
      is NewSerialDeviceResponse -> value.encode(builder)
      is StartWifiProvisioningRequest -> value.encode(builder)
      is StopWifiProvisioningRequest -> value.encode(builder)
      is WifiProvisioningStatusResponse -> value.encode(builder)
      is ServerInfosRequest -> value.encode(builder)
      is ServerInfosResponse -> value.encode(builder)
      is LegTweaksTmpChange -> value.encode(builder)
      is LegTweaksTmpClear -> value.encode(builder)
      is TapDetectionSetupNotification -> value.encode(builder)
      is SetPauseTrackingRequest -> value.encode(builder)
      is StatusSystemRequest -> value.encode(builder)
      is StatusSystemResponse -> value.encode(builder)
      is StatusSystemUpdate -> value.encode(builder)
      is StatusSystemFixed -> value.encode(builder)
      is ClearMountingResetRequest -> value.encode(builder)
      is HeightRequest -> value.encode(builder)
      is HeightResponse -> value.encode(builder)
      is AutoBoneApplyRequest -> value.encode(builder)
      is AutoBoneStopRecordingRequest -> value.encode(builder)
      is AutoBoneCancelRecordingRequest -> value.encode(builder)
      is SaveFileNotification -> value.encode(builder)
      is TrackingPauseStateRequest -> value.encode(builder)
      is TrackingPauseStateResponse -> value.encode(builder)
      is SerialTrackerGetWifiScanRequest -> value.encode(builder)
      is UnknownDeviceHandshakeNotification -> value.encode(builder)
      is AddUnknownDeviceRequest -> value.encode(builder)
      is ForgetDeviceRequest -> value.encode(builder)
      is FirmwareUpdateRequest -> value.encode(builder)
      is FirmwareUpdateStatusResponse -> value.encode(builder)
      is FirmwareUpdateStopQueuesRequest -> value.encode(builder)
      is SettingsResetRequest -> value.encode(builder)
      is MagToggleRequest -> value.encode(builder)
      is MagToggleResponse -> value.encode(builder)
      is ChangeMagToggleRequest -> value.encode(builder)
      is RecordBVHStatusRequest -> value.encode(builder)
      is VRCConfigStateRequest -> value.encode(builder)
      is VRCConfigStateChangeResponse -> value.encode(builder)
      is EnableStayAlignedRequest -> value.encode(builder)
      is DetectStayAlignedRelaxedPoseRequest -> value.encode(builder)
      is ResetStayAlignedRelaxedPoseRequest -> value.encode(builder)
      is SerialTrackerCustomCommandRequest -> value.encode(builder)
      is VRCConfigSettingToggleMute -> value.encode(builder)
      is TrackingChecklistRequest -> value.encode(builder)
      is TrackingChecklistResponse -> value.encode(builder)
      is IgnoreTrackingChecklistStepRequest -> value.encode(builder)
      is StartUserHeightCalibration -> value.encode(builder)
      is CancelUserHeightCalibration -> value.encode(builder)
      is UserHeightRecordingStatusResponse -> value.encode(builder)
      is VRCOSCSettingsRequest -> value.encode(builder)
      is VRCOSCSettingsResponse -> value.encode(builder)
      is ChangeVRCOSCSettingsRequest -> value.encode(builder)
      is VRCOSCStatusRequest -> value.encode(builder)
      is VRCOSCStatusChangeResponse -> value.encode(builder)
      is KeybindRequest -> value.encode(builder)
      is ChangeKeybindRequest -> value.encode(builder)
      is KeybindResponse -> value.encode(builder)
      is InstalledInfoRequest -> value.encode(builder)
      is InstalledInfoResponse -> value.encode(builder)
      is OpenUriRequest -> value.encode(builder)
      is OpenUriResponse -> value.encode(builder)
      is EnableSteamVRDriverRequest -> value.encode(builder)
    }
  }
}

public enum class KeybindId(
  public val `value`: UByte,
) {
  FULL_RESET(0.toUByte()),
  YAW_RESET(1.toUByte()),
  MOUNTING_RESET(2.toUByte()),
  PAUSE_TRACKING(3.toUByte()),
  FEET_MOUNTING_RESET(4.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): KeybindId? = entries.firstOrNull { it.value == value }
  }
}

public data class Keybind(
  public val keybindId: KeybindId? = null,
  public val keybindNameId: String? = null,
  public val keybindValue: String? = null,
  public val keybindDelay: Float? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_keybindNameId = keybindNameId?.let { builder.createString(it) }
    val __off_keybindValue = keybindValue?.let { builder.createString(it) }

    builder.startTable(4)
    if (keybindId != null) { builder.forceDefaults(true); builder.addByte(0, keybindId.value.toByte(), 0); builder.forceDefaults(false) }
    __off_keybindNameId?.let { builder.addOffset(1, it, 0) }
    __off_keybindValue?.let { builder.addOffset(2, it, 0) }
    if (keybindDelay != null) { builder.forceDefaults(true); builder.addFloat(3, keybindDelay, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): Keybind {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_keybindId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_keybindNameId = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_keybindValue = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_keybindDelay = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return Keybind(
              keybindId = if (__offset_keybindId != 0) KeybindId.fromValue(bb.get(tableOffset + __offset_keybindId).toUByte()) else null,
              keybindNameId = if (__offset_keybindNameId != 0) readFlatBufferString(bb, tableOffset + __offset_keybindNameId) else null,
              keybindValue = if (__offset_keybindValue != 0) readFlatBufferString(bb, tableOffset + __offset_keybindValue) else null,
              keybindDelay = if (__offset_keybindDelay != 0) bb.getFloat(tableOffset + __offset_keybindDelay) else null
          )
    }
  }
}

public data class KeybindRequest(
  public val keybindId: KeybindId? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (keybindId != null) { builder.forceDefaults(true); builder.addByte(0, keybindId.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): KeybindRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_keybindId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return KeybindRequest(
              keybindId = if (__offset_keybindId != 0) KeybindId.fromValue(bb.get(tableOffset + __offset_keybindId).toUByte()) else null
          )
    }
  }
}

public data class KeybindResponse(
  public val keybind: List<Keybind>? = null,
  public val defaultKeybinds: List<Keybind>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_keybind = keybind?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }
    val __off_defaultKeybinds = defaultKeybinds?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(2)
    __off_keybind?.let { builder.addOffset(0, it, 0) }
    __off_defaultKeybinds?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): KeybindResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_keybind = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_defaultKeybinds = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return KeybindResponse(
              keybind = if (__offset_keybind != 0) { val vecOff = tableOffset + __offset_keybind + bb.getInt(tableOffset + __offset_keybind); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) Keybind.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null,
              defaultKeybinds = if (__offset_defaultKeybinds != 0) { val vecOff = tableOffset + __offset_defaultKeybinds + bb.getInt(tableOffset + __offset_defaultKeybinds); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) Keybind.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

public data class ChangeKeybindRequest(
  public val keybind: Keybind? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_keybind = keybind?.encode(builder)

    builder.startTable(1)
    __off_keybind?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeKeybindRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_keybind = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ChangeKeybindRequest(
              keybind = if (__offset_keybind != 0) Keybind.decode(bb, tableOffset + __offset_keybind + bb.getInt(tableOffset + __offset_keybind)) else null
          )
    }
  }
}

public class OpenUriRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OpenUriRequest = OpenUriRequest()
  }
}

public data class OpenUriResponse(
  public val success: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (success != null) { builder.forceDefaults(true); builder.addBoolean(0, success, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OpenUriResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_success = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return OpenUriResponse(
              success = if (__offset_success != 0) bb.get(tableOffset + __offset_success) != 0.toByte() else null
          )
    }
  }
}

public data class RpcMessageHeader(
  public val txId: TransactionId? = null,
  public val message: RpcMessage? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_message = message?.let { RpcMessage.encode(it, builder) }
    val __type_message = message?.let { RpcMessage.typeIndex(it) } ?: 0.toByte()

    builder.startTable(3)
    txId?.let { builder.addStruct(0, it.encode(builder), 0) }
    builder.addByte(1, __type_message, 0)
    __off_message?.let { builder.addOffset(2, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): RpcMessageHeader {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_txId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __type_message = if (vtableSize > 6 && bb.getShort(vtableOffset + 6).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 6).toInt()) else 0
      val __offset_message = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return RpcMessageHeader(
              txId = if (__offset_txId != 0) TransactionId.decode(bb, tableOffset + __offset_txId) else null,
              message = if (__offset_message != 0) RpcMessage.decode(__type_message, bb, tableOffset + __offset_message + bb.getInt(tableOffset + __offset_message)) else null
          )
    }
  }
}

public class InstalledInfoRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): InstalledInfoRequest = InstalledInfoRequest()
  }
}

public data class InstalledInfoResponse(
  public val isudevinstalled: Boolean? = null,
  public val iswayland: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (isudevinstalled != null) { builder.forceDefaults(true); builder.addBoolean(0, isudevinstalled, false); builder.forceDefaults(false) }
    if (iswayland != null) { builder.forceDefaults(true); builder.addBoolean(1, iswayland, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): InstalledInfoResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_isudevinstalled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_iswayland = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return InstalledInfoResponse(
              isudevinstalled = if (__offset_isudevinstalled != 0) bb.get(tableOffset + __offset_isudevinstalled) != 0.toByte() else null,
              iswayland = if (__offset_iswayland != 0) bb.get(tableOffset + __offset_iswayland) != 0.toByte() else null
          )
    }
  }
}

public class HeartbeatRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): HeartbeatRequest = HeartbeatRequest()
  }
}

public class HeartbeatResponse : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): HeartbeatResponse = HeartbeatResponse()
  }
}

public enum class ResetType(
  public val `value`: UByte,
) {
  Yaw(0.toUByte()),
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
  STARTED(0.toUByte()),
  FINISHED(1.toUByte()),
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

public data class AssignTrackerRequest(
  public val trackerId: TrackerId? = null,
  public val bodyPosition: BodyPart? = null,
  public val mountingOrientation: Quat? = null,
  public val displayName: String? = null,
  public val allowDriftCompensation: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackerId = trackerId?.encode(builder)
    val __off_displayName = displayName?.let { builder.createString(it) }

    builder.startTable(5)
    __off_trackerId?.let { builder.addOffset(0, it, 0) }
    if (bodyPosition != null) { builder.forceDefaults(true); builder.addByte(1, bodyPosition.value.toByte(), 0); builder.forceDefaults(false) }
    mountingOrientation?.let { builder.addStruct(2, it.encode(builder), 0) }
    __off_displayName?.let { builder.addOffset(3, it, 0) }
    if (allowDriftCompensation != null) { builder.forceDefaults(true); builder.addBoolean(4, allowDriftCompensation, false); builder.forceDefaults(false) }
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
      val __offset_allowDriftCompensation = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return AssignTrackerRequest(
              trackerId = if (__offset_trackerId != 0) TrackerId.decode(bb, tableOffset + __offset_trackerId + bb.getInt(tableOffset + __offset_trackerId)) else null,
              bodyPosition = if (__offset_bodyPosition != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_bodyPosition).toUByte()) else null,
              mountingOrientation = if (__offset_mountingOrientation != 0) Quat.decode(bb, tableOffset + __offset_mountingOrientation) else null,
              displayName = if (__offset_displayName != 0) readFlatBufferString(bb, tableOffset + __offset_displayName) else null,
              allowDriftCompensation = if (__offset_allowDriftCompensation != 0) bb.get(tableOffset + __offset_allowDriftCompensation) != 0.toByte() else null
          )
    }
  }
}

public class ClearDriftCompensationRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ClearDriftCompensationRequest = ClearDriftCompensationRequest()
  }
}

public class SettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SettingsRequest = SettingsRequest()
  }
}

public data class SettingsResponse(
  public val steamVrTrackers: SteamVRTrackersSetting? = null,
  public val filtering: FilteringSettings? = null,
  public val driftCompensation: DriftCompensationSettings? = null,
  public val oscRouter: OSCRouterSettings? = null,
  public val vrcOsc: VRCOSCSettings? = null,
  public val vmcOsc: VMCOSCSettings? = null,
  public val modelSettings: ModelSettings? = null,
  public val tapDetectionSettings: TapDetectionSettings? = null,
  public val autoBoneSettings: AutoBoneSettings? = null,
  public val resetsSettings: ResetsSettings? = null,
  public val stayAligned: StayAlignedSettings? = null,
  public val hidSettings: HIDSettings? = null,
  public val timeout: TimeoutSettings? = null,
  public val velocitySettings: VelocitySettings? = null,
  public val vrm: VRMSettings? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_steamVrTrackers = steamVrTrackers?.encode(builder)
    val __off_filtering = filtering?.encode(builder)
    val __off_driftCompensation = driftCompensation?.encode(builder)
    val __off_oscRouter = oscRouter?.encode(builder)
    val __off_vrcOsc = vrcOsc?.encode(builder)
    val __off_vmcOsc = vmcOsc?.encode(builder)
    val __off_modelSettings = modelSettings?.encode(builder)
    val __off_tapDetectionSettings = tapDetectionSettings?.encode(builder)
    val __off_autoBoneSettings = autoBoneSettings?.encode(builder)
    val __off_resetsSettings = resetsSettings?.encode(builder)
    val __off_stayAligned = stayAligned?.encode(builder)
    val __off_hidSettings = hidSettings?.encode(builder)
    val __off_timeout = timeout?.encode(builder)
    val __off_velocitySettings = velocitySettings?.encode(builder)
    val __off_vrm = vrm?.encode(builder)

    builder.startTable(15)
    __off_steamVrTrackers?.let { builder.addOffset(0, it, 0) }
    __off_filtering?.let { builder.addOffset(1, it, 0) }
    __off_driftCompensation?.let { builder.addOffset(2, it, 0) }
    __off_oscRouter?.let { builder.addOffset(3, it, 0) }
    __off_vrcOsc?.let { builder.addOffset(4, it, 0) }
    __off_vmcOsc?.let { builder.addOffset(5, it, 0) }
    __off_modelSettings?.let { builder.addOffset(6, it, 0) }
    __off_tapDetectionSettings?.let { builder.addOffset(7, it, 0) }
    __off_autoBoneSettings?.let { builder.addOffset(8, it, 0) }
    __off_resetsSettings?.let { builder.addOffset(9, it, 0) }
    __off_stayAligned?.let { builder.addOffset(10, it, 0) }
    __off_hidSettings?.let { builder.addOffset(11, it, 0) }
    __off_timeout?.let { builder.addOffset(12, it, 0) }
    __off_velocitySettings?.let { builder.addOffset(13, it, 0) }
    __off_vrm?.let { builder.addOffset(14, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_steamVrTrackers = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_filtering = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_driftCompensation = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_oscRouter = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_vrcOsc = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_vmcOsc = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_modelSettings = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_tapDetectionSettings = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_autoBoneSettings = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_resetsSettings = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_stayAligned = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_hidSettings = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0
      val __offset_timeout = if (vtableSize > 28) bb.getShort(vtableOffset + 28).toInt() else 0
      val __offset_velocitySettings = if (vtableSize > 30) bb.getShort(vtableOffset + 30).toInt() else 0
      val __offset_vrm = if (vtableSize > 32) bb.getShort(vtableOffset + 32).toInt() else 0

      return SettingsResponse(
              steamVrTrackers = if (__offset_steamVrTrackers != 0) SteamVRTrackersSetting.decode(bb, tableOffset + __offset_steamVrTrackers + bb.getInt(tableOffset + __offset_steamVrTrackers)) else null,
              filtering = if (__offset_filtering != 0) FilteringSettings.decode(bb, tableOffset + __offset_filtering + bb.getInt(tableOffset + __offset_filtering)) else null,
              driftCompensation = if (__offset_driftCompensation != 0) DriftCompensationSettings.decode(bb, tableOffset + __offset_driftCompensation + bb.getInt(tableOffset + __offset_driftCompensation)) else null,
              oscRouter = if (__offset_oscRouter != 0) OSCRouterSettings.decode(bb, tableOffset + __offset_oscRouter + bb.getInt(tableOffset + __offset_oscRouter)) else null,
              vrcOsc = if (__offset_vrcOsc != 0) VRCOSCSettings.decode(bb, tableOffset + __offset_vrcOsc + bb.getInt(tableOffset + __offset_vrcOsc)) else null,
              vmcOsc = if (__offset_vmcOsc != 0) VMCOSCSettings.decode(bb, tableOffset + __offset_vmcOsc + bb.getInt(tableOffset + __offset_vmcOsc)) else null,
              modelSettings = if (__offset_modelSettings != 0) ModelSettings.decode(bb, tableOffset + __offset_modelSettings + bb.getInt(tableOffset + __offset_modelSettings)) else null,
              tapDetectionSettings = if (__offset_tapDetectionSettings != 0) TapDetectionSettings.decode(bb, tableOffset + __offset_tapDetectionSettings + bb.getInt(tableOffset + __offset_tapDetectionSettings)) else null,
              autoBoneSettings = if (__offset_autoBoneSettings != 0) AutoBoneSettings.decode(bb, tableOffset + __offset_autoBoneSettings + bb.getInt(tableOffset + __offset_autoBoneSettings)) else null,
              resetsSettings = if (__offset_resetsSettings != 0) ResetsSettings.decode(bb, tableOffset + __offset_resetsSettings + bb.getInt(tableOffset + __offset_resetsSettings)) else null,
              stayAligned = if (__offset_stayAligned != 0) StayAlignedSettings.decode(bb, tableOffset + __offset_stayAligned + bb.getInt(tableOffset + __offset_stayAligned)) else null,
              hidSettings = if (__offset_hidSettings != 0) HIDSettings.decode(bb, tableOffset + __offset_hidSettings + bb.getInt(tableOffset + __offset_hidSettings)) else null,
              timeout = if (__offset_timeout != 0) TimeoutSettings.decode(bb, tableOffset + __offset_timeout + bb.getInt(tableOffset + __offset_timeout)) else null,
              velocitySettings = if (__offset_velocitySettings != 0) VelocitySettings.decode(bb, tableOffset + __offset_velocitySettings + bb.getInt(tableOffset + __offset_velocitySettings)) else null,
              vrm = if (__offset_vrm != 0) VRMSettings.decode(bb, tableOffset + __offset_vrm + bb.getInt(tableOffset + __offset_vrm)) else null
          )
    }
  }
}

public data class ChangeSettingsRequest(
  public val steamVrTrackers: SteamVRTrackersSetting? = null,
  public val filtering: FilteringSettings? = null,
  public val driftCompensation: DriftCompensationSettings? = null,
  public val oscRouter: OSCRouterSettings? = null,
  public val vrcOsc: VRCOSCSettings? = null,
  public val vmcOsc: VMCOSCSettings? = null,
  public val modelSettings: ModelSettings? = null,
  public val tapDetectionSettings: TapDetectionSettings? = null,
  public val autoBoneSettings: AutoBoneSettings? = null,
  public val resetsSettings: ResetsSettings? = null,
  public val stayAligned: StayAlignedSettings? = null,
  public val hidSettings: HIDSettings? = null,
  public val timeout: TimeoutSettings? = null,
  public val velocitySettings: VelocitySettings? = null,
  public val vrm: VRMSettings? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_steamVrTrackers = steamVrTrackers?.encode(builder)
    val __off_filtering = filtering?.encode(builder)
    val __off_driftCompensation = driftCompensation?.encode(builder)
    val __off_oscRouter = oscRouter?.encode(builder)
    val __off_vrcOsc = vrcOsc?.encode(builder)
    val __off_vmcOsc = vmcOsc?.encode(builder)
    val __off_modelSettings = modelSettings?.encode(builder)
    val __off_tapDetectionSettings = tapDetectionSettings?.encode(builder)
    val __off_autoBoneSettings = autoBoneSettings?.encode(builder)
    val __off_resetsSettings = resetsSettings?.encode(builder)
    val __off_stayAligned = stayAligned?.encode(builder)
    val __off_hidSettings = hidSettings?.encode(builder)
    val __off_timeout = timeout?.encode(builder)
    val __off_velocitySettings = velocitySettings?.encode(builder)
    val __off_vrm = vrm?.encode(builder)

    builder.startTable(15)
    __off_steamVrTrackers?.let { builder.addOffset(0, it, 0) }
    __off_filtering?.let { builder.addOffset(1, it, 0) }
    __off_driftCompensation?.let { builder.addOffset(2, it, 0) }
    __off_oscRouter?.let { builder.addOffset(3, it, 0) }
    __off_vrcOsc?.let { builder.addOffset(4, it, 0) }
    __off_vmcOsc?.let { builder.addOffset(5, it, 0) }
    __off_modelSettings?.let { builder.addOffset(6, it, 0) }
    __off_tapDetectionSettings?.let { builder.addOffset(7, it, 0) }
    __off_autoBoneSettings?.let { builder.addOffset(8, it, 0) }
    __off_resetsSettings?.let { builder.addOffset(9, it, 0) }
    __off_stayAligned?.let { builder.addOffset(10, it, 0) }
    __off_hidSettings?.let { builder.addOffset(11, it, 0) }
    __off_timeout?.let { builder.addOffset(12, it, 0) }
    __off_velocitySettings?.let { builder.addOffset(13, it, 0) }
    __off_vrm?.let { builder.addOffset(14, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_steamVrTrackers = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_filtering = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_driftCompensation = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_oscRouter = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_vrcOsc = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_vmcOsc = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_modelSettings = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_tapDetectionSettings = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_autoBoneSettings = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_resetsSettings = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_stayAligned = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_hidSettings = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0
      val __offset_timeout = if (vtableSize > 28) bb.getShort(vtableOffset + 28).toInt() else 0
      val __offset_velocitySettings = if (vtableSize > 30) bb.getShort(vtableOffset + 30).toInt() else 0
      val __offset_vrm = if (vtableSize > 32) bb.getShort(vtableOffset + 32).toInt() else 0

      return ChangeSettingsRequest(
              steamVrTrackers = if (__offset_steamVrTrackers != 0) SteamVRTrackersSetting.decode(bb, tableOffset + __offset_steamVrTrackers + bb.getInt(tableOffset + __offset_steamVrTrackers)) else null,
              filtering = if (__offset_filtering != 0) FilteringSettings.decode(bb, tableOffset + __offset_filtering + bb.getInt(tableOffset + __offset_filtering)) else null,
              driftCompensation = if (__offset_driftCompensation != 0) DriftCompensationSettings.decode(bb, tableOffset + __offset_driftCompensation + bb.getInt(tableOffset + __offset_driftCompensation)) else null,
              oscRouter = if (__offset_oscRouter != 0) OSCRouterSettings.decode(bb, tableOffset + __offset_oscRouter + bb.getInt(tableOffset + __offset_oscRouter)) else null,
              vrcOsc = if (__offset_vrcOsc != 0) VRCOSCSettings.decode(bb, tableOffset + __offset_vrcOsc + bb.getInt(tableOffset + __offset_vrcOsc)) else null,
              vmcOsc = if (__offset_vmcOsc != 0) VMCOSCSettings.decode(bb, tableOffset + __offset_vmcOsc + bb.getInt(tableOffset + __offset_vmcOsc)) else null,
              modelSettings = if (__offset_modelSettings != 0) ModelSettings.decode(bb, tableOffset + __offset_modelSettings + bb.getInt(tableOffset + __offset_modelSettings)) else null,
              tapDetectionSettings = if (__offset_tapDetectionSettings != 0) TapDetectionSettings.decode(bb, tableOffset + __offset_tapDetectionSettings + bb.getInt(tableOffset + __offset_tapDetectionSettings)) else null,
              autoBoneSettings = if (__offset_autoBoneSettings != 0) AutoBoneSettings.decode(bb, tableOffset + __offset_autoBoneSettings + bb.getInt(tableOffset + __offset_autoBoneSettings)) else null,
              resetsSettings = if (__offset_resetsSettings != 0) ResetsSettings.decode(bb, tableOffset + __offset_resetsSettings + bb.getInt(tableOffset + __offset_resetsSettings)) else null,
              stayAligned = if (__offset_stayAligned != 0) StayAlignedSettings.decode(bb, tableOffset + __offset_stayAligned + bb.getInt(tableOffset + __offset_stayAligned)) else null,
              hidSettings = if (__offset_hidSettings != 0) HIDSettings.decode(bb, tableOffset + __offset_hidSettings + bb.getInt(tableOffset + __offset_hidSettings)) else null,
              timeout = if (__offset_timeout != 0) TimeoutSettings.decode(bb, tableOffset + __offset_timeout + bb.getInt(tableOffset + __offset_timeout)) else null,
              velocitySettings = if (__offset_velocitySettings != 0) VelocitySettings.decode(bb, tableOffset + __offset_velocitySettings + bb.getInt(tableOffset + __offset_velocitySettings)) else null,
              vrm = if (__offset_vrm != 0) VRMSettings.decode(bb, tableOffset + __offset_vrm + bb.getInt(tableOffset + __offset_vrm)) else null
          )
    }
  }
}

public data class SteamVRTrackersSetting(
  public val waist: Boolean? = null,
  public val chest: Boolean? = null,
  @Deprecated("FlatBuffers field `feet` is deprecated.")
  public val feet: Boolean? = null,
  @Deprecated("FlatBuffers field `knees` is deprecated.")
  public val knees: Boolean? = null,
  @Deprecated("FlatBuffers field `elbows` is deprecated.")
  public val elbows: Boolean? = null,
  @Deprecated("FlatBuffers field `hands` is deprecated.")
  public val hands: Boolean? = null,
  public val automatictrackertoggle: Boolean? = null,
  public val leftFoot: Boolean? = null,
  public val rightFoot: Boolean? = null,
  public val leftKnee: Boolean? = null,
  public val rightKnee: Boolean? = null,
  public val leftElbow: Boolean? = null,
  public val rightElbow: Boolean? = null,
  public val leftHand: Boolean? = null,
  public val rightHand: Boolean? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(15)
    if (waist != null) { builder.forceDefaults(true); builder.addBoolean(0, waist, false); builder.forceDefaults(false) }
    if (chest != null) { builder.forceDefaults(true); builder.addBoolean(1, chest, false); builder.forceDefaults(false) }
    if (feet != null) { builder.forceDefaults(true); builder.addBoolean(2, feet, false); builder.forceDefaults(false) }
    if (knees != null) { builder.forceDefaults(true); builder.addBoolean(3, knees, false); builder.forceDefaults(false) }
    if (elbows != null) { builder.forceDefaults(true); builder.addBoolean(4, elbows, false); builder.forceDefaults(false) }
    if (hands != null) { builder.forceDefaults(true); builder.addBoolean(5, hands, false); builder.forceDefaults(false) }
    if (automatictrackertoggle != null) { builder.forceDefaults(true); builder.addBoolean(6, automatictrackertoggle, false); builder.forceDefaults(false) }
    if (leftFoot != null) { builder.forceDefaults(true); builder.addBoolean(7, leftFoot, false); builder.forceDefaults(false) }
    if (rightFoot != null) { builder.forceDefaults(true); builder.addBoolean(8, rightFoot, false); builder.forceDefaults(false) }
    if (leftKnee != null) { builder.forceDefaults(true); builder.addBoolean(9, leftKnee, false); builder.forceDefaults(false) }
    if (rightKnee != null) { builder.forceDefaults(true); builder.addBoolean(10, rightKnee, false); builder.forceDefaults(false) }
    if (leftElbow != null) { builder.forceDefaults(true); builder.addBoolean(11, leftElbow, false); builder.forceDefaults(false) }
    if (rightElbow != null) { builder.forceDefaults(true); builder.addBoolean(12, rightElbow, false); builder.forceDefaults(false) }
    if (leftHand != null) { builder.forceDefaults(true); builder.addBoolean(13, leftHand, false); builder.forceDefaults(false) }
    if (rightHand != null) { builder.forceDefaults(true); builder.addBoolean(14, rightHand, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SteamVRTrackersSetting {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_waist = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_chest = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_feet = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_knees = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_elbows = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_hands = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_automatictrackertoggle = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_leftFoot = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_rightFoot = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_leftKnee = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_rightKnee = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_leftElbow = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0
      val __offset_rightElbow = if (vtableSize > 28) bb.getShort(vtableOffset + 28).toInt() else 0
      val __offset_leftHand = if (vtableSize > 30) bb.getShort(vtableOffset + 30).toInt() else 0
      val __offset_rightHand = if (vtableSize > 32) bb.getShort(vtableOffset + 32).toInt() else 0

      return SteamVRTrackersSetting(
              waist = if (__offset_waist != 0) bb.get(tableOffset + __offset_waist) != 0.toByte() else null,
              chest = if (__offset_chest != 0) bb.get(tableOffset + __offset_chest) != 0.toByte() else null,
              feet = if (__offset_feet != 0) bb.get(tableOffset + __offset_feet) != 0.toByte() else null,
              knees = if (__offset_knees != 0) bb.get(tableOffset + __offset_knees) != 0.toByte() else null,
              elbows = if (__offset_elbows != 0) bb.get(tableOffset + __offset_elbows) != 0.toByte() else null,
              hands = if (__offset_hands != 0) bb.get(tableOffset + __offset_hands) != 0.toByte() else null,
              automatictrackertoggle = if (__offset_automatictrackertoggle != 0) bb.get(tableOffset + __offset_automatictrackertoggle) != 0.toByte() else null,
              leftFoot = if (__offset_leftFoot != 0) bb.get(tableOffset + __offset_leftFoot) != 0.toByte() else null,
              rightFoot = if (__offset_rightFoot != 0) bb.get(tableOffset + __offset_rightFoot) != 0.toByte() else null,
              leftKnee = if (__offset_leftKnee != 0) bb.get(tableOffset + __offset_leftKnee) != 0.toByte() else null,
              rightKnee = if (__offset_rightKnee != 0) bb.get(tableOffset + __offset_rightKnee) != 0.toByte() else null,
              leftElbow = if (__offset_leftElbow != 0) bb.get(tableOffset + __offset_leftElbow) != 0.toByte() else null,
              rightElbow = if (__offset_rightElbow != 0) bb.get(tableOffset + __offset_rightElbow) != 0.toByte() else null,
              leftHand = if (__offset_leftHand != 0) bb.get(tableOffset + __offset_leftHand) != 0.toByte() else null,
              rightHand = if (__offset_rightHand != 0) bb.get(tableOffset + __offset_rightHand) != 0.toByte() else null
          )
    }
  }
}

public data class FilteringSettings(
  public val type: FilteringType? = null,
  public val amount: Float? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (type != null) { builder.forceDefaults(true); builder.addByte(0, type.value.toByte(), 0); builder.forceDefaults(false) }
    if (amount != null) { builder.forceDefaults(true); builder.addFloat(1, amount, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): FilteringSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_type = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_amount = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return FilteringSettings(
              type = if (__offset_type != 0) FilteringType.fromValue(bb.get(tableOffset + __offset_type).toUByte()) else null,
              amount = if (__offset_amount != 0) bb.getFloat(tableOffset + __offset_amount) else null
          )
    }
  }
}

/**
 * Settings related to IMU yaw drift compensation
 */
public data class DriftCompensationSettings(
  public val enabled: Boolean? = null,
  public val prediction: Boolean? = null,
  public val amount: Float? = null,
  public val maxResets: UShort? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(4)
    if (enabled != null) { builder.forceDefaults(true); builder.addBoolean(0, enabled, false); builder.forceDefaults(false) }
    if (prediction != null) { builder.forceDefaults(true); builder.addBoolean(1, prediction, false); builder.forceDefaults(false) }
    if (amount != null) { builder.forceDefaults(true); builder.addFloat(2, amount, 0.0); builder.forceDefaults(false) }
    if (maxResets != null) { builder.forceDefaults(true); builder.addShort(3, maxResets.toShort(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): DriftCompensationSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_prediction = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_amount = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_maxResets = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return DriftCompensationSettings(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else null,
              prediction = if (__offset_prediction != 0) bb.get(tableOffset + __offset_prediction) != 0.toByte() else null,
              amount = if (__offset_amount != 0) bb.getFloat(tableOffset + __offset_amount) else null,
              maxResets = if (__offset_maxResets != 0) bb.getShort(tableOffset + __offset_maxResets).toUShort() else null
          )
    }
  }
}

/**
 * OSC router forwards messages it receives, to allow the usage of multiple OSC programs for the same app.
 */
public data class OSCRouterSettings(
  public val oscSettings: OSCSettings? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_oscSettings = oscSettings?.encode(builder)

    builder.startTable(1)
    __off_oscSettings?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OSCRouterSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_oscSettings = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return OSCRouterSettings(
              oscSettings = if (__offset_oscSettings != 0) OSCSettings.decode(bb, tableOffset + __offset_oscSettings + bb.getInt(tableOffset + __offset_oscSettings)) else null
          )
    }
  }
}

/**
 * OSC Settings specific to VRChat
 */
public data class VRCOSCSettings(
  @Deprecated("FlatBuffers field `osc_settings` is deprecated.")
  public val oscSettings: OSCSettings? = null,
  public val trackers: OSCTrackersSetting? = null,
  @Deprecated("FlatBuffers field `oscquery_enabled` is deprecated.")
  public val oscqueryEnabled: Boolean? = null,
  public val enabled: Boolean? = null,
  public val manualNetwork: VRCOSCNetworkSettings? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_oscSettings = oscSettings?.encode(builder)
    val __off_trackers = trackers?.encode(builder)
    val __off_manualNetwork = manualNetwork?.encode(builder)

    builder.startTable(5)
    __off_oscSettings?.let { builder.addOffset(0, it, 0) }
    __off_trackers?.let { builder.addOffset(1, it, 0) }
    if (oscqueryEnabled != null) { builder.forceDefaults(true); builder.addBoolean(2, oscqueryEnabled, false); builder.forceDefaults(false) }
    if (enabled != null) { builder.forceDefaults(true); builder.addBoolean(3, enabled, false); builder.forceDefaults(false) }
    __off_manualNetwork?.let { builder.addOffset(4, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VRCOSCSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_oscSettings = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_trackers = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_oscqueryEnabled = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_enabled = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_manualNetwork = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return VRCOSCSettings(
              oscSettings = if (__offset_oscSettings != 0) OSCSettings.decode(bb, tableOffset + __offset_oscSettings + bb.getInt(tableOffset + __offset_oscSettings)) else null,
              trackers = if (__offset_trackers != 0) OSCTrackersSetting.decode(bb, tableOffset + __offset_trackers + bb.getInt(tableOffset + __offset_trackers)) else null,
              oscqueryEnabled = if (__offset_oscqueryEnabled != 0) bb.get(tableOffset + __offset_oscqueryEnabled) != 0.toByte() else null,
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else null,
              manualNetwork = if (__offset_manualNetwork != 0) VRCOSCNetworkSettings.decode(bb, tableOffset + __offset_manualNetwork + bb.getInt(tableOffset + __offset_manualNetwork)) else null
          )
    }
  }
}

public class VRCOSCSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VRCOSCSettingsRequest = VRCOSCSettingsRequest()
  }
}

public data class VRCOSCSettingsResponse(
  public val settings: VRCOSCSettings? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_settings = settings?.encode(builder)

    builder.startTable(1)
    __off_settings?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VRCOSCSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_settings = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return VRCOSCSettingsResponse(
              settings = if (__offset_settings != 0) VRCOSCSettings.decode(bb, tableOffset + __offset_settings + bb.getInt(tableOffset + __offset_settings)) else null
          )
    }
  }
}

public data class ChangeVRCOSCSettingsRequest(
  public val settings: VRCOSCSettings? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_settings = settings?.encode(builder)

    builder.startTable(1)
    __off_settings?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeVRCOSCSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_settings = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ChangeVRCOSCSettingsRequest(
              settings = if (__offset_settings != 0) VRCOSCSettings.decode(bb, tableOffset + __offset_settings + bb.getInt(tableOffset + __offset_settings)) else null
          )
    }
  }
}

public data class VRCOSCNetworkSettings(
  public val portIn: UShort? = null,
  public val portOut: UShort? = null,
  public val address: String? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_address = address?.let { builder.createString(it) }

    builder.startTable(3)
    if (portIn != null) { builder.forceDefaults(true); builder.addShort(0, portIn.toShort(), 0); builder.forceDefaults(false) }
    if (portOut != null) { builder.forceDefaults(true); builder.addShort(1, portOut.toShort(), 0); builder.forceDefaults(false) }
    __off_address?.let { builder.addOffset(2, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VRCOSCNetworkSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_portIn = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_portOut = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_address = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return VRCOSCNetworkSettings(
              portIn = if (__offset_portIn != 0) bb.getShort(tableOffset + __offset_portIn).toUShort() else null,
              portOut = if (__offset_portOut != 0) bb.getShort(tableOffset + __offset_portOut).toUShort() else null,
              address = if (__offset_address != 0) readFlatBufferString(bb, tableOffset + __offset_address) else null
          )
    }
  }
}

public data class VRCOSCDiscoveredTarget(
  public val name: String? = null,
  public val address: String? = null,
  public val portOut: UShort? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_name = name?.let { builder.createString(it) }
    val __off_address = address?.let { builder.createString(it) }

    builder.startTable(3)
    __off_name?.let { builder.addOffset(0, it, 0) }
    __off_address?.let { builder.addOffset(1, it, 0) }
    if (portOut != null) { builder.forceDefaults(true); builder.addShort(2, portOut.toShort(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VRCOSCDiscoveredTarget {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_name = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_address = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_portOut = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return VRCOSCDiscoveredTarget(
              name = if (__offset_name != 0) readFlatBufferString(bb, tableOffset + __offset_name) else null,
              address = if (__offset_address != 0) readFlatBufferString(bb, tableOffset + __offset_address) else null,
              portOut = if (__offset_portOut != 0) bb.getShort(tableOffset + __offset_portOut).toUShort() else null
          )
    }
  }
}

public enum class VRCOSCInputState(
  public val `value`: UByte,
) {
  IDLE(0.toUByte()),
  LISTENING(1.toUByte()),
  ERROR(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): VRCOSCInputState? = entries.firstOrNull { it.value == value }
  }
}

public enum class VRCOSCOutputState(
  public val `value`: UByte,
) {
  IDLE(0.toUByte()),
  READY(1.toUByte()),
  ERROR(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): VRCOSCOutputState? = entries.firstOrNull { it.value == value }
  }
}

public enum class VRCOSCTargetSource(
  public val `value`: UByte,
) {
  NONE(0.toUByte()),
  MANUAL(1.toUByte()),
  DISCOVERED(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): VRCOSCTargetSource? = entries.firstOrNull { it.value == value }
  }
}

public enum class VRCOSCOscQueryState(
  public val `value`: UByte,
) {
  DISABLED(0.toUByte()),
  SEARCHING(1.toUByte()),
  FOUND(2.toUByte()),
  ERROR(3.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): VRCOSCOscQueryState? = entries.firstOrNull { it.value == value }
  }
}

public class VRCOSCStatusRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VRCOSCStatusRequest = VRCOSCStatusRequest()
  }
}

public data class VRCOSCStatusChangeResponse(
  public val enabled: Boolean? = null,
  public val inputState: VRCOSCInputState? = null,
  public val inputPort: UShort? = null,
  public val inputError: String? = null,
  public val lastReceivedInputMillis: ULong? = null,
  public val outputState: VRCOSCOutputState? = null,
  public val outputError: String? = null,
  public val targetAddress: String? = null,
  public val targetPort: UShort? = null,
  public val targetSource: VRCOSCTargetSource? = null,
  public val lastFrameSentMillis: ULong? = null,
  public val oscqueryState: VRCOSCOscQueryState? = null,
  public val oscqueryAdvertisedPort: UShort? = null,
  public val oscqueryError: String? = null,
  public val discoveredTargets: List<VRCOSCDiscoveredTarget>? = null,
  @Deprecated("FlatBuffers field `input_listening` is deprecated.")
  public val inputListening: Boolean? = null,
  @Deprecated("FlatBuffers field `output_available` is deprecated.")
  public val outputAvailable: Boolean? = null,
  @Deprecated("FlatBuffers field `oscquery_discovered` is deprecated.")
  public val oscqueryDiscovered: Boolean? = null,
  @Deprecated("FlatBuffers field `last_error` is deprecated.")
  public val lastError: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_inputError = inputError?.let { builder.createString(it) }
    val __off_outputError = outputError?.let { builder.createString(it) }
    val __off_targetAddress = targetAddress?.let { builder.createString(it) }
    val __off_oscqueryError = oscqueryError?.let { builder.createString(it) }
    val __off_discoveredTargets = discoveredTargets?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }
    val __off_lastError = lastError?.let { builder.createString(it) }

    builder.startTable(19)
    if (enabled != null) { builder.forceDefaults(true); builder.addBoolean(0, enabled, false); builder.forceDefaults(false) }
    if (inputState != null) { builder.forceDefaults(true); builder.addByte(1, inputState.value.toByte(), 0); builder.forceDefaults(false) }
    if (inputPort != null) { builder.forceDefaults(true); builder.addShort(2, inputPort.toShort(), 0); builder.forceDefaults(false) }
    __off_inputError?.let { builder.addOffset(3, it, 0) }
    if (lastReceivedInputMillis != null) { builder.forceDefaults(true); builder.addLong(4, lastReceivedInputMillis.toLong(), 0L); builder.forceDefaults(false) }
    if (outputState != null) { builder.forceDefaults(true); builder.addByte(5, outputState.value.toByte(), 0); builder.forceDefaults(false) }
    __off_outputError?.let { builder.addOffset(6, it, 0) }
    __off_targetAddress?.let { builder.addOffset(7, it, 0) }
    if (targetPort != null) { builder.forceDefaults(true); builder.addShort(8, targetPort.toShort(), 0); builder.forceDefaults(false) }
    if (targetSource != null) { builder.forceDefaults(true); builder.addByte(9, targetSource.value.toByte(), 0); builder.forceDefaults(false) }
    if (lastFrameSentMillis != null) { builder.forceDefaults(true); builder.addLong(10, lastFrameSentMillis.toLong(), 0L); builder.forceDefaults(false) }
    if (oscqueryState != null) { builder.forceDefaults(true); builder.addByte(11, oscqueryState.value.toByte(), 0); builder.forceDefaults(false) }
    if (oscqueryAdvertisedPort != null) { builder.forceDefaults(true); builder.addShort(12, oscqueryAdvertisedPort.toShort(), 0); builder.forceDefaults(false) }
    __off_oscqueryError?.let { builder.addOffset(13, it, 0) }
    __off_discoveredTargets?.let { builder.addOffset(14, it, 0) }
    if (inputListening != null) { builder.forceDefaults(true); builder.addBoolean(15, inputListening, false); builder.forceDefaults(false) }
    if (outputAvailable != null) { builder.forceDefaults(true); builder.addBoolean(16, outputAvailable, false); builder.forceDefaults(false) }
    if (oscqueryDiscovered != null) { builder.forceDefaults(true); builder.addBoolean(17, oscqueryDiscovered, false); builder.forceDefaults(false) }
    __off_lastError?.let { builder.addOffset(18, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VRCOSCStatusChangeResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_inputState = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_inputPort = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_inputError = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_lastReceivedInputMillis = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_outputState = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_outputError = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_targetAddress = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_targetPort = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_targetSource = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_lastFrameSentMillis = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_oscqueryState = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0
      val __offset_oscqueryAdvertisedPort = if (vtableSize > 28) bb.getShort(vtableOffset + 28).toInt() else 0
      val __offset_oscqueryError = if (vtableSize > 30) bb.getShort(vtableOffset + 30).toInt() else 0
      val __offset_discoveredTargets = if (vtableSize > 32) bb.getShort(vtableOffset + 32).toInt() else 0
      val __offset_inputListening = if (vtableSize > 34) bb.getShort(vtableOffset + 34).toInt() else 0
      val __offset_outputAvailable = if (vtableSize > 36) bb.getShort(vtableOffset + 36).toInt() else 0
      val __offset_oscqueryDiscovered = if (vtableSize > 38) bb.getShort(vtableOffset + 38).toInt() else 0
      val __offset_lastError = if (vtableSize > 40) bb.getShort(vtableOffset + 40).toInt() else 0

      return VRCOSCStatusChangeResponse(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else null,
              inputState = if (__offset_inputState != 0) VRCOSCInputState.fromValue(bb.get(tableOffset + __offset_inputState).toUByte()) else null,
              inputPort = if (__offset_inputPort != 0) bb.getShort(tableOffset + __offset_inputPort).toUShort() else null,
              inputError = if (__offset_inputError != 0) readFlatBufferString(bb, tableOffset + __offset_inputError) else null,
              lastReceivedInputMillis = if (__offset_lastReceivedInputMillis != 0) bb.getLong(tableOffset + __offset_lastReceivedInputMillis).toULong() else null,
              outputState = if (__offset_outputState != 0) VRCOSCOutputState.fromValue(bb.get(tableOffset + __offset_outputState).toUByte()) else null,
              outputError = if (__offset_outputError != 0) readFlatBufferString(bb, tableOffset + __offset_outputError) else null,
              targetAddress = if (__offset_targetAddress != 0) readFlatBufferString(bb, tableOffset + __offset_targetAddress) else null,
              targetPort = if (__offset_targetPort != 0) bb.getShort(tableOffset + __offset_targetPort).toUShort() else null,
              targetSource = if (__offset_targetSource != 0) VRCOSCTargetSource.fromValue(bb.get(tableOffset + __offset_targetSource).toUByte()) else null,
              lastFrameSentMillis = if (__offset_lastFrameSentMillis != 0) bb.getLong(tableOffset + __offset_lastFrameSentMillis).toULong() else null,
              oscqueryState = if (__offset_oscqueryState != 0) VRCOSCOscQueryState.fromValue(bb.get(tableOffset + __offset_oscqueryState).toUByte()) else null,
              oscqueryAdvertisedPort = if (__offset_oscqueryAdvertisedPort != 0) bb.getShort(tableOffset + __offset_oscqueryAdvertisedPort).toUShort() else null,
              oscqueryError = if (__offset_oscqueryError != 0) readFlatBufferString(bb, tableOffset + __offset_oscqueryError) else null,
              discoveredTargets = if (__offset_discoveredTargets != 0) { val vecOff = tableOffset + __offset_discoveredTargets + bb.getInt(tableOffset + __offset_discoveredTargets); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) VRCOSCDiscoveredTarget.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null,
              inputListening = if (__offset_inputListening != 0) bb.get(tableOffset + __offset_inputListening) != 0.toByte() else null,
              outputAvailable = if (__offset_outputAvailable != 0) bb.get(tableOffset + __offset_outputAvailable) != 0.toByte() else null,
              oscqueryDiscovered = if (__offset_oscqueryDiscovered != 0) bb.get(tableOffset + __offset_oscqueryDiscovered) != 0.toByte() else null,
              lastError = if (__offset_lastError != 0) readFlatBufferString(bb, tableOffset + __offset_lastError) else null
          )
    }
  }
}

/**
 * OSC Settings specific to VMC
 */
public data class VMCOSCSettings(
  public val oscSettings: OSCSettings? = null,
  @Deprecated("FlatBuffers field `vrm_json` is deprecated.")
  public val vrmJson: String? = null,
  public val anchorHip: Boolean? = null,
  public val mirrorTracking: Boolean? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_oscSettings = oscSettings?.encode(builder)
    val __off_vrmJson = vrmJson?.let { builder.createString(it) }

    builder.startTable(4)
    __off_oscSettings?.let { builder.addOffset(0, it, 0) }
    __off_vrmJson?.let { builder.addOffset(1, it, 0) }
    if (anchorHip != null) { builder.forceDefaults(true); builder.addBoolean(2, anchorHip, false); builder.forceDefaults(false) }
    if (mirrorTracking != null) { builder.forceDefaults(true); builder.addBoolean(3, mirrorTracking, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VMCOSCSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_oscSettings = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_vrmJson = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_anchorHip = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_mirrorTracking = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return VMCOSCSettings(
              oscSettings = if (__offset_oscSettings != 0) OSCSettings.decode(bb, tableOffset + __offset_oscSettings + bb.getInt(tableOffset + __offset_oscSettings)) else null,
              vrmJson = if (__offset_vrmJson != 0) readFlatBufferString(bb, tableOffset + __offset_vrmJson) else null,
              anchorHip = if (__offset_anchorHip != 0) bb.get(tableOffset + __offset_anchorHip) != 0.toByte() else null,
              mirrorTracking = if (__offset_mirrorTracking != 0) bb.get(tableOffset + __offset_mirrorTracking) != 0.toByte() else null
          )
    }
  }
}

/**
 * VRM Settings for rescaling to avatar-scale
 */
public data class VRMSettings(
  public val vrmJson: String? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_vrmJson = vrmJson?.let { builder.createString(it) }

    builder.startTable(1)
    __off_vrmJson?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VRMSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_vrmJson = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return VRMSettings(
              vrmJson = if (__offset_vrmJson != 0) readFlatBufferString(bb, tableOffset + __offset_vrmJson) else null
          )
    }
  }
}

/**
 * OSC Settings that are used in *any* osc application.
 */
public data class OSCSettings(
  public val enabled: Boolean? = null,
  public val portIn: UShort? = null,
  public val portOut: UShort? = null,
  public val address: String? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_address = address?.let { builder.createString(it) }

    builder.startTable(4)
    if (enabled != null) { builder.forceDefaults(true); builder.addBoolean(0, enabled, false); builder.forceDefaults(false) }
    if (portIn != null) { builder.forceDefaults(true); builder.addShort(1, portIn.toShort(), 0); builder.forceDefaults(false) }
    if (portOut != null) { builder.forceDefaults(true); builder.addShort(2, portOut.toShort(), 0); builder.forceDefaults(false) }
    __off_address?.let { builder.addOffset(3, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OSCSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_portIn = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_portOut = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_address = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return OSCSettings(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else null,
              portIn = if (__offset_portIn != 0) bb.getShort(tableOffset + __offset_portIn).toUShort() else null,
              portOut = if (__offset_portOut != 0) bb.getShort(tableOffset + __offset_portOut).toUShort() else null,
              address = if (__offset_address != 0) readFlatBufferString(bb, tableOffset + __offset_address) else null
          )
    }
  }
}

public data class OSCTrackersSetting(
  public val head: Boolean? = null,
  public val chest: Boolean? = null,
  public val waist: Boolean? = null,
  public val knees: Boolean? = null,
  public val feet: Boolean? = null,
  public val elbows: Boolean? = null,
  public val hands: Boolean? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(7)
    if (head != null) { builder.forceDefaults(true); builder.addBoolean(0, head, false); builder.forceDefaults(false) }
    if (chest != null) { builder.forceDefaults(true); builder.addBoolean(1, chest, false); builder.forceDefaults(false) }
    if (waist != null) { builder.forceDefaults(true); builder.addBoolean(2, waist, false); builder.forceDefaults(false) }
    if (knees != null) { builder.forceDefaults(true); builder.addBoolean(3, knees, false); builder.forceDefaults(false) }
    if (feet != null) { builder.forceDefaults(true); builder.addBoolean(4, feet, false); builder.forceDefaults(false) }
    if (elbows != null) { builder.forceDefaults(true); builder.addBoolean(5, elbows, false); builder.forceDefaults(false) }
    if (hands != null) { builder.forceDefaults(true); builder.addBoolean(6, hands, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OSCTrackersSetting {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_head = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_chest = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_waist = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_knees = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_feet = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_elbows = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_hands = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0

      return OSCTrackersSetting(
              head = if (__offset_head != 0) bb.get(tableOffset + __offset_head) != 0.toByte() else null,
              chest = if (__offset_chest != 0) bb.get(tableOffset + __offset_chest) != 0.toByte() else null,
              waist = if (__offset_waist != 0) bb.get(tableOffset + __offset_waist) != 0.toByte() else null,
              knees = if (__offset_knees != 0) bb.get(tableOffset + __offset_knees) != 0.toByte() else null,
              feet = if (__offset_feet != 0) bb.get(tableOffset + __offset_feet) != 0.toByte() else null,
              elbows = if (__offset_elbows != 0) bb.get(tableOffset + __offset_elbows) != 0.toByte() else null,
              hands = if (__offset_hands != 0) bb.get(tableOffset + __offset_hands) != 0.toByte() else null
          )
    }
  }
}

public data class TapDetectionSettings(
  public val fullResetDelay: Float? = null,
  public val fullResetEnabled: Boolean? = null,
  public val fullResetTaps: UByte? = null,
  public val yawResetDelay: Float? = null,
  public val yawResetEnabled: Boolean? = null,
  public val yawResetTaps: UByte? = null,
  public val mountingResetDelay: Float? = null,
  public val mountingResetEnabled: Boolean? = null,
  public val mountingResetTaps: UByte? = null,
  public val setupMode: Boolean? = null,
  public val numberTrackersOverThreshold: UByte? = null,
  public val yawResetTracker: BodyPart? = null,
  public val fullResetTracker: BodyPart? = null,
  public val mountingResetTracker: BodyPart? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(14)
    if (fullResetDelay != null) { builder.forceDefaults(true); builder.addFloat(0, fullResetDelay, 0.0); builder.forceDefaults(false) }
    if (fullResetEnabled != null) { builder.forceDefaults(true); builder.addBoolean(1, fullResetEnabled, false); builder.forceDefaults(false) }
    if (fullResetTaps != null) { builder.forceDefaults(true); builder.addByte(2, fullResetTaps.toByte(), 0); builder.forceDefaults(false) }
    if (yawResetDelay != null) { builder.forceDefaults(true); builder.addFloat(3, yawResetDelay, 0.0); builder.forceDefaults(false) }
    if (yawResetEnabled != null) { builder.forceDefaults(true); builder.addBoolean(4, yawResetEnabled, false); builder.forceDefaults(false) }
    if (yawResetTaps != null) { builder.forceDefaults(true); builder.addByte(5, yawResetTaps.toByte(), 0); builder.forceDefaults(false) }
    if (mountingResetDelay != null) { builder.forceDefaults(true); builder.addFloat(6, mountingResetDelay, 0.0); builder.forceDefaults(false) }
    if (mountingResetEnabled != null) { builder.forceDefaults(true); builder.addBoolean(7, mountingResetEnabled, false); builder.forceDefaults(false) }
    if (mountingResetTaps != null) { builder.forceDefaults(true); builder.addByte(8, mountingResetTaps.toByte(), 0); builder.forceDefaults(false) }
    if (setupMode != null) { builder.forceDefaults(true); builder.addBoolean(9, setupMode, false); builder.forceDefaults(false) }
    if (numberTrackersOverThreshold != null) { builder.forceDefaults(true); builder.addByte(10, numberTrackersOverThreshold.toByte(), 0); builder.forceDefaults(false) }
    if (yawResetTracker != null) { builder.forceDefaults(true); builder.addByte(11, yawResetTracker.value.toByte(), 0); builder.forceDefaults(false) }
    if (fullResetTracker != null) { builder.forceDefaults(true); builder.addByte(12, fullResetTracker.value.toByte(), 0); builder.forceDefaults(false) }
    if (mountingResetTracker != null) { builder.forceDefaults(true); builder.addByte(13, mountingResetTracker.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TapDetectionSettings {
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
      val __offset_setupMode = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_numberTrackersOverThreshold = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_yawResetTracker = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0
      val __offset_fullResetTracker = if (vtableSize > 28) bb.getShort(vtableOffset + 28).toInt() else 0
      val __offset_mountingResetTracker = if (vtableSize > 30) bb.getShort(vtableOffset + 30).toInt() else 0

      return TapDetectionSettings(
              fullResetDelay = if (__offset_fullResetDelay != 0) bb.getFloat(tableOffset + __offset_fullResetDelay) else null,
              fullResetEnabled = if (__offset_fullResetEnabled != 0) bb.get(tableOffset + __offset_fullResetEnabled) != 0.toByte() else null,
              fullResetTaps = if (__offset_fullResetTaps != 0) bb.get(tableOffset + __offset_fullResetTaps).toUByte() else null,
              yawResetDelay = if (__offset_yawResetDelay != 0) bb.getFloat(tableOffset + __offset_yawResetDelay) else null,
              yawResetEnabled = if (__offset_yawResetEnabled != 0) bb.get(tableOffset + __offset_yawResetEnabled) != 0.toByte() else null,
              yawResetTaps = if (__offset_yawResetTaps != 0) bb.get(tableOffset + __offset_yawResetTaps).toUByte() else null,
              mountingResetDelay = if (__offset_mountingResetDelay != 0) bb.getFloat(tableOffset + __offset_mountingResetDelay) else null,
              mountingResetEnabled = if (__offset_mountingResetEnabled != 0) bb.get(tableOffset + __offset_mountingResetEnabled) != 0.toByte() else null,
              mountingResetTaps = if (__offset_mountingResetTaps != 0) bb.get(tableOffset + __offset_mountingResetTaps).toUByte() else null,
              setupMode = if (__offset_setupMode != 0) bb.get(tableOffset + __offset_setupMode) != 0.toByte() else null,
              numberTrackersOverThreshold = if (__offset_numberTrackersOverThreshold != 0) bb.get(tableOffset + __offset_numberTrackersOverThreshold).toUByte() else null,
              yawResetTracker = if (__offset_yawResetTracker != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_yawResetTracker).toUByte()) else null,
              fullResetTracker = if (__offset_fullResetTracker != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_fullResetTracker).toUByte()) else null,
              mountingResetTracker = if (__offset_mountingResetTracker != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_mountingResetTracker).toUByte()) else null
          )
    }
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
   * Arms going up to the sides into a tpose
   */
  TPOSE_UP(2.toUByte()),
  /**
   * Arms going down to the sides from a tpose
   */
  TPOSE_DOWN(3.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): ArmsMountingResetMode? = entries.firstOrNull { it.value == value }
  }
}

public data class ResetsSettings(
  public val resetMountingFeet: Boolean? = null,
  public val armsMountingResetMode: ArmsMountingResetMode? = null,
  public val yawResetSmoothTime: Float? = null,
  public val saveMountingReset: Boolean? = null,
  public val resetHmdPitch: Boolean? = null,
) {
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
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ResetsSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_resetMountingFeet = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_armsMountingResetMode = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_yawResetSmoothTime = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_saveMountingReset = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_resetHmdPitch = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return ResetsSettings(
              resetMountingFeet = if (__offset_resetMountingFeet != 0) bb.get(tableOffset + __offset_resetMountingFeet) != 0.toByte() else null,
              armsMountingResetMode = if (__offset_armsMountingResetMode != 0) ArmsMountingResetMode.fromValue(bb.get(tableOffset + __offset_armsMountingResetMode).toUByte()) else null,
              yawResetSmoothTime = if (__offset_yawResetSmoothTime != 0) bb.getFloat(tableOffset + __offset_yawResetSmoothTime) else null,
              saveMountingReset = if (__offset_saveMountingReset != 0) bb.get(tableOffset + __offset_saveMountingReset) != 0.toByte() else null,
              resetHmdPitch = if (__offset_resetHmdPitch != 0) bb.get(tableOffset + __offset_resetHmdPitch) != 0.toByte() else null
          )
    }
  }
}

public data class StayAlignedSettings(
  public val enabled: Boolean? = null,
  public val extrayawcorrection: Boolean? = null,
  public val hideyawcorrection: Boolean? = null,
  public val standingenabled: Boolean? = null,
  public val standingupperlegangle: Float? = null,
  public val standinglowerlegangle: Float? = null,
  public val standingfootangle: Float? = null,
  public val sittingenabled: Boolean? = null,
  public val sittingupperlegangle: Float? = null,
  public val sittinglowerlegangle: Float? = null,
  public val sittingfootangle: Float? = null,
  public val flatenabled: Boolean? = null,
  public val flatupperlegangle: Float? = null,
  public val flatlowerlegangle: Float? = null,
  public val flatfootangle: Float? = null,
  public val setupcomplete: Boolean? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(16)
    if (enabled != null) { builder.forceDefaults(true); builder.addBoolean(0, enabled, false); builder.forceDefaults(false) }
    if (extrayawcorrection != null) { builder.forceDefaults(true); builder.addBoolean(1, extrayawcorrection, false); builder.forceDefaults(false) }
    if (hideyawcorrection != null) { builder.forceDefaults(true); builder.addBoolean(2, hideyawcorrection, false); builder.forceDefaults(false) }
    if (standingenabled != null) { builder.forceDefaults(true); builder.addBoolean(3, standingenabled, false); builder.forceDefaults(false) }
    if (standingupperlegangle != null) { builder.forceDefaults(true); builder.addFloat(4, standingupperlegangle, 0.0); builder.forceDefaults(false) }
    if (standinglowerlegangle != null) { builder.forceDefaults(true); builder.addFloat(5, standinglowerlegangle, 0.0); builder.forceDefaults(false) }
    if (standingfootangle != null) { builder.forceDefaults(true); builder.addFloat(6, standingfootangle, 0.0); builder.forceDefaults(false) }
    if (sittingenabled != null) { builder.forceDefaults(true); builder.addBoolean(7, sittingenabled, false); builder.forceDefaults(false) }
    if (sittingupperlegangle != null) { builder.forceDefaults(true); builder.addFloat(8, sittingupperlegangle, 0.0); builder.forceDefaults(false) }
    if (sittinglowerlegangle != null) { builder.forceDefaults(true); builder.addFloat(9, sittinglowerlegangle, 0.0); builder.forceDefaults(false) }
    if (sittingfootangle != null) { builder.forceDefaults(true); builder.addFloat(10, sittingfootangle, 0.0); builder.forceDefaults(false) }
    if (flatenabled != null) { builder.forceDefaults(true); builder.addBoolean(11, flatenabled, false); builder.forceDefaults(false) }
    if (flatupperlegangle != null) { builder.forceDefaults(true); builder.addFloat(12, flatupperlegangle, 0.0); builder.forceDefaults(false) }
    if (flatlowerlegangle != null) { builder.forceDefaults(true); builder.addFloat(13, flatlowerlegangle, 0.0); builder.forceDefaults(false) }
    if (flatfootangle != null) { builder.forceDefaults(true); builder.addFloat(14, flatfootangle, 0.0); builder.forceDefaults(false) }
    if (setupcomplete != null) { builder.forceDefaults(true); builder.addBoolean(15, setupcomplete, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StayAlignedSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_extrayawcorrection = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_hideyawcorrection = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_standingenabled = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_standingupperlegangle = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_standinglowerlegangle = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_standingfootangle = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_sittingenabled = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_sittingupperlegangle = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_sittinglowerlegangle = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_sittingfootangle = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_flatenabled = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0
      val __offset_flatupperlegangle = if (vtableSize > 28) bb.getShort(vtableOffset + 28).toInt() else 0
      val __offset_flatlowerlegangle = if (vtableSize > 30) bb.getShort(vtableOffset + 30).toInt() else 0
      val __offset_flatfootangle = if (vtableSize > 32) bb.getShort(vtableOffset + 32).toInt() else 0
      val __offset_setupcomplete = if (vtableSize > 34) bb.getShort(vtableOffset + 34).toInt() else 0

      return StayAlignedSettings(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else null,
              extrayawcorrection = if (__offset_extrayawcorrection != 0) bb.get(tableOffset + __offset_extrayawcorrection) != 0.toByte() else null,
              hideyawcorrection = if (__offset_hideyawcorrection != 0) bb.get(tableOffset + __offset_hideyawcorrection) != 0.toByte() else null,
              standingenabled = if (__offset_standingenabled != 0) bb.get(tableOffset + __offset_standingenabled) != 0.toByte() else null,
              standingupperlegangle = if (__offset_standingupperlegangle != 0) bb.getFloat(tableOffset + __offset_standingupperlegangle) else null,
              standinglowerlegangle = if (__offset_standinglowerlegangle != 0) bb.getFloat(tableOffset + __offset_standinglowerlegangle) else null,
              standingfootangle = if (__offset_standingfootangle != 0) bb.getFloat(tableOffset + __offset_standingfootangle) else null,
              sittingenabled = if (__offset_sittingenabled != 0) bb.get(tableOffset + __offset_sittingenabled) != 0.toByte() else null,
              sittingupperlegangle = if (__offset_sittingupperlegangle != 0) bb.getFloat(tableOffset + __offset_sittingupperlegangle) else null,
              sittinglowerlegangle = if (__offset_sittinglowerlegangle != 0) bb.getFloat(tableOffset + __offset_sittinglowerlegangle) else null,
              sittingfootangle = if (__offset_sittingfootangle != 0) bb.getFloat(tableOffset + __offset_sittingfootangle) else null,
              flatenabled = if (__offset_flatenabled != 0) bb.get(tableOffset + __offset_flatenabled) != 0.toByte() else null,
              flatupperlegangle = if (__offset_flatupperlegangle != 0) bb.getFloat(tableOffset + __offset_flatupperlegangle) else null,
              flatlowerlegangle = if (__offset_flatlowerlegangle != 0) bb.getFloat(tableOffset + __offset_flatlowerlegangle) else null,
              flatfootangle = if (__offset_flatfootangle != 0) bb.getFloat(tableOffset + __offset_flatfootangle) else null,
              setupcomplete = if (__offset_setupcomplete != 0) bb.get(tableOffset + __offset_setupcomplete) != 0.toByte() else null
          )
    }
  }
}

public data class HIDSettings(
  public val trackersoverhid: Boolean? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (trackersoverhid != null) { builder.forceDefaults(true); builder.addBoolean(0, trackersoverhid, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): HIDSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackersoverhid = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return HIDSettings(
              trackersoverhid = if (__offset_trackersoverhid != 0) bb.get(tableOffset + __offset_trackersoverhid) != 0.toByte() else null
          )
    }
  }
}

public data class TimeoutSettings(
  public val duration: Float? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (duration != null) { builder.forceDefaults(true); builder.addFloat(0, duration, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TimeoutSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_duration = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TimeoutSettings(
              duration = if (__offset_duration != 0) bb.getFloat(tableOffset + __offset_duration) else null
          )
    }
  }
}

public data class VelocitySettings(
  public val sendDerivedVelocity: Boolean? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (sendDerivedVelocity != null) { builder.forceDefaults(true); builder.addBoolean(0, sendDerivedVelocity, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VelocitySettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_sendDerivedVelocity = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return VelocitySettings(
              sendDerivedVelocity = if (__offset_sendDerivedVelocity != 0) bb.get(tableOffset + __offset_sendDerivedVelocity) != 0.toByte() else null
          )
    }
  }
}

/**
 * See TapDetectionSettings::setup_mode
 */
public data class TapDetectionSetupNotification(
  public val trackerId: TrackerId? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackerId = trackerId?.encode(builder)

    builder.startTable(1)
    __off_trackerId?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TapDetectionSetupNotification {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TapDetectionSetupNotification(
              trackerId = if (__offset_trackerId != 0) TrackerId.decode(bb, tableOffset + __offset_trackerId + bb.getInt(tableOffset + __offset_trackerId)) else null
          )
    }
  }
}

public data class RecordBVHRequest(
  public val stop: Boolean? = null,
  public val path: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_path = path?.let { builder.createString(it) }

    builder.startTable(2)
    if (stop != null) { builder.forceDefaults(true); builder.addBoolean(0, stop, false); builder.forceDefaults(false) }
    __off_path?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): RecordBVHRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_stop = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_path = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return RecordBVHRequest(
              stop = if (__offset_stop != 0) bb.get(tableOffset + __offset_stop) != 0.toByte() else null,
              path = if (__offset_path != 0) readFlatBufferString(bb, tableOffset + __offset_path) else null
          )
    }
  }
}

public data class RecordBVHStatus(
  public val recording: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (recording != null) { builder.forceDefaults(true); builder.addBoolean(0, recording, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): RecordBVHStatus {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_recording = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return RecordBVHStatus(
              recording = if (__offset_recording != 0) bb.get(tableOffset + __offset_recording) != 0.toByte() else null
          )
    }
  }
}

public class RecordBVHStatusRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): RecordBVHStatusRequest = RecordBVHStatusRequest()
  }
}

public enum class SkeletonBone(
  public val `value`: UByte,
) {
  NONE(0.toUByte()),
  HEAD(1.toUByte()),
  NECK(2.toUByte()),
  CHEST(3.toUByte()),
  CHEST_OFFSET(4.toUByte()),
  WAIST(5.toUByte()),
  HIP(6.toUByte()),
  HIP_OFFSET(7.toUByte()),
  HIPS_WIDTH(8.toUByte()),
  UPPER_LEG(9.toUByte()),
  LOWER_LEG(10.toUByte()),
  FOOT_LENGTH(11.toUByte()),
  FOOT_SHIFT(12.toUByte()),
  SKELETON_OFFSET(13.toUByte()),
  SHOULDERS_DISTANCE(14.toUByte()),
  SHOULDERS_WIDTH(15.toUByte()),
  UPPER_ARM(16.toUByte()),
  LOWER_ARM(17.toUByte()),
  HAND_Y(18.toUByte()),
  HAND_Z(19.toUByte()),
  ELBOW_OFFSET(20.toUByte()),
  UPPER_CHEST(21.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): SkeletonBone? = entries.firstOrNull { it.value == value }
  }
}

public data class SkeletonPart(
  public val bone: SkeletonBone? = null,
  public val `value`: Float? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (bone != null) { builder.forceDefaults(true); builder.addByte(0, bone.value.toByte(), 0); builder.forceDefaults(false) }
    if (value != null) { builder.forceDefaults(true); builder.addFloat(1, value, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SkeletonPart {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bone = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_value = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return SkeletonPart(
              bone = if (__offset_bone != 0) SkeletonBone.fromValue(bb.get(tableOffset + __offset_bone).toUByte()) else null,
              value = if (__offset_value != 0) bb.getFloat(tableOffset + __offset_value) else null
          )
    }
  }
}

public class SkeletonConfigRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SkeletonConfigRequest = SkeletonConfigRequest()
  }
}

public data class SkeletonConfigResponse(
  public val skeletonParts: List<SkeletonPart>? = null,
  public val userHeight: Float? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_skeletonParts = skeletonParts?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(2)
    __off_skeletonParts?.let { builder.addOffset(0, it, 0) }
    if (userHeight != null) { builder.forceDefaults(true); builder.addFloat(1, userHeight, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SkeletonConfigResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_skeletonParts = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_userHeight = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return SkeletonConfigResponse(
              skeletonParts = if (__offset_skeletonParts != 0) { val vecOff = tableOffset + __offset_skeletonParts + bb.getInt(tableOffset + __offset_skeletonParts); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) SkeletonPart.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null,
              userHeight = if (__offset_userHeight != 0) bb.getFloat(tableOffset + __offset_userHeight) else null
          )
    }
  }
}

public class SkeletonResetAllRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SkeletonResetAllRequest = SkeletonResetAllRequest()
  }
}

public data class ChangeSkeletonConfigRequest(
  public val bone: SkeletonBone? = null,
  public val `value`: Float? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (bone != null) { builder.forceDefaults(true); builder.addByte(0, bone.value.toByte(), 0); builder.forceDefaults(false) }
    if (value != null) { builder.forceDefaults(true); builder.addFloat(1, value, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeSkeletonConfigRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bone = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_value = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return ChangeSkeletonConfigRequest(
              bone = if (__offset_bone != 0) SkeletonBone.fromValue(bb.get(tableOffset + __offset_bone).toUByte()) else null,
              value = if (__offset_value != 0) bb.getFloat(tableOffset + __offset_value) else null
          )
    }
  }
}

public enum class SerialDeviceType(
  public val `value`: UByte,
) {
  ESP_TRACKER(0.toUByte()),
  HID_RECEIVER(1.toUByte()),
  HID_TRACKER(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): SerialDeviceType? = entries.firstOrNull { it.value == value }
  }
}

public data class SerialDevice(
  public val port: String? = null,
  public val name: String? = null,
  public val type: SerialDeviceType? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_port = port?.let { builder.createString(it) }
    val __off_name = name?.let { builder.createString(it) }

    builder.startTable(3)
    __off_port?.let { builder.addOffset(0, it, 0) }
    __off_name?.let { builder.addOffset(1, it, 0) }
    if (type != null) { builder.forceDefaults(true); builder.addByte(2, type.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SerialDevice {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_port = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_name = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_type = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return SerialDevice(
              port = if (__offset_port != 0) readFlatBufferString(bb, tableOffset + __offset_port) else null,
              name = if (__offset_name != 0) readFlatBufferString(bb, tableOffset + __offset_name) else null,
              type = if (__offset_type != 0) SerialDeviceType.fromValue(bb.get(tableOffset + __offset_type).toUByte()) else null
          )
    }
  }
}

public data class OpenSerialRequest(
  public val auto: Boolean? = null,
  public val port: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_port = port?.let { builder.createString(it) }

    builder.startTable(2)
    if (auto != null) { builder.forceDefaults(true); builder.addBoolean(0, auto, false); builder.forceDefaults(false) }
    __off_port?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OpenSerialRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_auto = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_port = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return OpenSerialRequest(
              auto = if (__offset_auto != 0) bb.get(tableOffset + __offset_auto) != 0.toByte() else null,
              port = if (__offset_port != 0) readFlatBufferString(bb, tableOffset + __offset_port) else null
          )
    }
  }
}

public class CloseSerialRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): CloseSerialRequest = CloseSerialRequest()
  }
}

public data class SetWifiRequest(
  public val ssid: String? = null,
  public val password: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_ssid = ssid?.let { builder.createString(it) }
    val __off_password = password?.let { builder.createString(it) }

    builder.startTable(2)
    __off_ssid?.let { builder.addOffset(0, it, 0) }
    __off_password?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SetWifiRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_ssid = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_password = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return SetWifiRequest(
              ssid = if (__offset_ssid != 0) readFlatBufferString(bb, tableOffset + __offset_ssid) else null,
              password = if (__offset_password != 0) readFlatBufferString(bb, tableOffset + __offset_password) else null
          )
    }
  }
}

public data class SerialUpdateResponse(
  public val log: String? = null,
  public val closed: Boolean? = null,
  public val device: SerialDevice? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_log = log?.let { builder.createString(it) }
    val __off_device = device?.encode(builder)

    builder.startTable(3)
    __off_log?.let { builder.addOffset(0, it, 0) }
    if (closed != null) { builder.forceDefaults(true); builder.addBoolean(1, closed, false); builder.forceDefaults(false) }
    __off_device?.let { builder.addOffset(2, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SerialUpdateResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_log = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_closed = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_device = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return SerialUpdateResponse(
              log = if (__offset_log != 0) readFlatBufferString(bb, tableOffset + __offset_log) else null,
              closed = if (__offset_closed != 0) bb.get(tableOffset + __offset_closed) != 0.toByte() else null,
              device = if (__offset_device != 0) SerialDevice.decode(bb, tableOffset + __offset_device + bb.getInt(tableOffset + __offset_device)) else null
          )
    }
  }
}

/**
 * Reboots the tracker connected to the serial monitor
 */
public class SerialTrackerRebootRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SerialTrackerRebootRequest = SerialTrackerRebootRequest()
  }
}

/**
 * Sends the GET INFO cmd to the current tracker on the serial monitor
 */
public class SerialTrackerGetInfoRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SerialTrackerGetInfoRequest = SerialTrackerGetInfoRequest()
  }
}

/**
 * Sends the FRST cmd to the currently connected Tracker over the Serial Monitor
 */
public class SerialTrackerFactoryResetRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SerialTrackerFactoryResetRequest = SerialTrackerFactoryResetRequest()
  }
}

/**
 * Sends a custom cmd to the currently connected Tracker over the Serial Monitor
 */
public data class SerialTrackerCustomCommandRequest(
  public val command: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_command = command?.let { builder.createString(it) }

    builder.startTable(1)
    __off_command?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SerialTrackerCustomCommandRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_command = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return SerialTrackerCustomCommandRequest(
              command = if (__offset_command != 0) readFlatBufferString(bb, tableOffset + __offset_command) else null
          )
    }
  }
}

public class SerialDevicesRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SerialDevicesRequest = SerialDevicesRequest()
  }
}

public data class SerialDevicesResponse(
  public val devices: List<SerialDevice>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_devices = devices?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(1)
    __off_devices?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SerialDevicesResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_devices = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return SerialDevicesResponse(
              devices = if (__offset_devices != 0) { val vecOff = tableOffset + __offset_devices + bb.getInt(tableOffset + __offset_devices); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) SerialDevice.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

public data class NewSerialDeviceResponse(
  public val device: SerialDevice? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_device = device?.encode(builder)

    builder.startTable(1)
    __off_device?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): NewSerialDeviceResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_device = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return NewSerialDeviceResponse(
              device = if (__offset_device != 0) SerialDevice.decode(bb, tableOffset + __offset_device + bb.getInt(tableOffset + __offset_device)) else null
          )
    }
  }
}

public data class StartWifiProvisioningRequest(
  public val ssid: String? = null,
  public val password: String? = null,
  public val port: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_ssid = ssid?.let { builder.createString(it) }
    val __off_password = password?.let { builder.createString(it) }
    val __off_port = port?.let { builder.createString(it) }

    builder.startTable(3)
    __off_ssid?.let { builder.addOffset(0, it, 0) }
    __off_password?.let { builder.addOffset(1, it, 0) }
    __off_port?.let { builder.addOffset(2, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StartWifiProvisioningRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_ssid = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_password = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_port = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return StartWifiProvisioningRequest(
              ssid = if (__offset_ssid != 0) readFlatBufferString(bb, tableOffset + __offset_ssid) else null,
              password = if (__offset_password != 0) readFlatBufferString(bb, tableOffset + __offset_password) else null,
              port = if (__offset_port != 0) readFlatBufferString(bb, tableOffset + __offset_port) else null
          )
    }
  }
}

public class StopWifiProvisioningRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StopWifiProvisioningRequest = StopWifiProvisioningRequest()
  }
}

public enum class WifiProvisioningStatus(
  public val `value`: UByte,
) {
  NONE(0.toUByte()),
  SERIAL_INIT(1.toUByte()),
  PROVISIONING(2.toUByte()),
  CONNECTING(3.toUByte()),
  CONNECTION_ERROR(4.toUByte()),
  LOOKING_FOR_SERVER(5.toUByte()),
  COULD_NOT_FIND_SERVER(6.toUByte()),
  DONE(7.toUByte()),
  OBTAINING_MAC_ADDRESS(8.toUByte()),
  NO_SERIAL_LOGS_ERROR(9.toUByte()),
  NO_SERIAL_DEVICE_FOUND(10.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): WifiProvisioningStatus? = entries.firstOrNull { it.value == value }
  }
}

public data class WifiProvisioningStatusResponse(
  public val status: WifiProvisioningStatus? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (status != null) { builder.forceDefaults(true); builder.addByte(0, status.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): WifiProvisioningStatusResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_status = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return WifiProvisioningStatusResponse(
              status = if (__offset_status != 0) WifiProvisioningStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) else null
          )
    }
  }
}

public enum class AutoBoneProcessType(
  public val `value`: UByte,
) {
  NONE(0.toUByte()),
  RECORD(1.toUByte()),
  SAVE(2.toUByte()),
  PROCESS(3.toUByte()),
  /**
   * @deprecated
   * Use AutoBoneApplyRequest instead
   */
  APPLY(4.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): AutoBoneProcessType? = entries.firstOrNull { it.value == value }
  }
}

public data class AutoBoneProcessRequest(
  public val processType: AutoBoneProcessType? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (processType != null) { builder.forceDefaults(true); builder.addByte(0, processType.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): AutoBoneProcessRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_processType = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return AutoBoneProcessRequest(
              processType = if (__offset_processType != 0) AutoBoneProcessType.fromValue(bb.get(tableOffset + __offset_processType).toUByte()) else null
          )
    }
  }
}

public data class AutoBoneProcessStatusResponse(
  public val processType: AutoBoneProcessType? = null,
  @Deprecated("FlatBuffers field `message` is deprecated.")
  public val message: String? = null,
  public val current: UInt? = null,
  public val total: UInt? = null,
  public val completed: Boolean? = null,
  public val success: Boolean? = null,
  public val eta: Float? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_message = message?.let { builder.createString(it) }

    builder.startTable(7)
    if (processType != null) { builder.forceDefaults(true); builder.addByte(0, processType.value.toByte(), 0); builder.forceDefaults(false) }
    __off_message?.let { builder.addOffset(1, it, 0) }
    if (current != null) { builder.forceDefaults(true); builder.addInt(2, current.toInt(), 0); builder.forceDefaults(false) }
    if (total != null) { builder.forceDefaults(true); builder.addInt(3, total.toInt(), 0); builder.forceDefaults(false) }
    if (completed != null) { builder.forceDefaults(true); builder.addBoolean(4, completed, false); builder.forceDefaults(false) }
    if (success != null) { builder.forceDefaults(true); builder.addBoolean(5, success, false); builder.forceDefaults(false) }
    if (eta != null) { builder.forceDefaults(true); builder.addFloat(6, eta, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): AutoBoneProcessStatusResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_processType = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_message = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_current = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_total = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_completed = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_success = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_eta = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0

      return AutoBoneProcessStatusResponse(
              processType = if (__offset_processType != 0) AutoBoneProcessType.fromValue(bb.get(tableOffset + __offset_processType).toUByte()) else null,
              message = if (__offset_message != 0) readFlatBufferString(bb, tableOffset + __offset_message) else null,
              current = if (__offset_current != 0) bb.getInt(tableOffset + __offset_current).toUInt() else null,
              total = if (__offset_total != 0) bb.getInt(tableOffset + __offset_total).toUInt() else null,
              completed = if (__offset_completed != 0) bb.get(tableOffset + __offset_completed) != 0.toByte() else null,
              success = if (__offset_success != 0) bb.get(tableOffset + __offset_success) != 0.toByte() else null,
              eta = if (__offset_eta != 0) bb.getFloat(tableOffset + __offset_eta) else null
          )
    }
  }
}

public data class AutoBoneEpochResponse(
  public val currentEpoch: UInt? = null,
  public val totalEpochs: UInt? = null,
  public val epochError: Float? = null,
  public val adjustedSkeletonParts: List<SkeletonPart>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_adjustedSkeletonParts = adjustedSkeletonParts?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(4)
    if (currentEpoch != null) { builder.forceDefaults(true); builder.addInt(0, currentEpoch.toInt(), 0); builder.forceDefaults(false) }
    if (totalEpochs != null) { builder.forceDefaults(true); builder.addInt(1, totalEpochs.toInt(), 0); builder.forceDefaults(false) }
    if (epochError != null) { builder.forceDefaults(true); builder.addFloat(2, epochError, 0.0); builder.forceDefaults(false) }
    __off_adjustedSkeletonParts?.let { builder.addOffset(3, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): AutoBoneEpochResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_currentEpoch = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_totalEpochs = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_epochError = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_adjustedSkeletonParts = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return AutoBoneEpochResponse(
              currentEpoch = if (__offset_currentEpoch != 0) bb.getInt(tableOffset + __offset_currentEpoch).toUInt() else null,
              totalEpochs = if (__offset_totalEpochs != 0) bb.getInt(tableOffset + __offset_totalEpochs).toUInt() else null,
              epochError = if (__offset_epochError != 0) bb.getFloat(tableOffset + __offset_epochError) else null,
              adjustedSkeletonParts = if (__offset_adjustedSkeletonParts != 0) { val vecOff = tableOffset + __offset_adjustedSkeletonParts + bb.getInt(tableOffset + __offset_adjustedSkeletonParts); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) SkeletonPart.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

/**
 * https://github.com/SlimeVR/SlimeVR-Server/blob/v0.8.3/server/src/main/java/dev/slimevr/config/AutoBoneConfig.kt
 */
public data class AutoBoneSettings(
  public val cursorIncrement: Int? = null,
  public val minDataDistance: Int? = null,
  public val maxDataDistance: Int? = null,
  public val numEpochs: Int? = null,
  public val printEveryNumEpochs: Int? = null,
  public val initialAdjustRate: Float? = null,
  public val adjustRateDecay: Float? = null,
  public val slideErrorFactor: Float? = null,
  public val offsetSlideErrorFactor: Float? = null,
  public val footHeightOffsetErrorFactor: Float? = null,
  public val bodyProportionErrorFactor: Float? = null,
  public val heightErrorFactor: Float? = null,
  public val positionErrorFactor: Float? = null,
  public val positionOffsetErrorFactor: Float? = null,
  public val calcInitError: Boolean? = null,
  public val randomizeFrameOrder: Boolean? = null,
  public val scaleEachStep: Boolean? = null,
  public val sampleCount: Int? = null,
  public val sampleRateMs: Long? = null,
  public val saveRecordings: Boolean? = null,
  public val useSkeletonHeight: Boolean? = null,
  public val randSeed: Long? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(22)
    if (cursorIncrement != null) { builder.forceDefaults(true); builder.addInt(0, cursorIncrement, 0); builder.forceDefaults(false) }
    if (minDataDistance != null) { builder.forceDefaults(true); builder.addInt(1, minDataDistance, 0); builder.forceDefaults(false) }
    if (maxDataDistance != null) { builder.forceDefaults(true); builder.addInt(2, maxDataDistance, 0); builder.forceDefaults(false) }
    if (numEpochs != null) { builder.forceDefaults(true); builder.addInt(3, numEpochs, 0); builder.forceDefaults(false) }
    if (printEveryNumEpochs != null) { builder.forceDefaults(true); builder.addInt(4, printEveryNumEpochs, 0); builder.forceDefaults(false) }
    if (initialAdjustRate != null) { builder.forceDefaults(true); builder.addFloat(5, initialAdjustRate, 0.0); builder.forceDefaults(false) }
    if (adjustRateDecay != null) { builder.forceDefaults(true); builder.addFloat(6, adjustRateDecay, 0.0); builder.forceDefaults(false) }
    if (slideErrorFactor != null) { builder.forceDefaults(true); builder.addFloat(7, slideErrorFactor, 0.0); builder.forceDefaults(false) }
    if (offsetSlideErrorFactor != null) { builder.forceDefaults(true); builder.addFloat(8, offsetSlideErrorFactor, 0.0); builder.forceDefaults(false) }
    if (footHeightOffsetErrorFactor != null) { builder.forceDefaults(true); builder.addFloat(9, footHeightOffsetErrorFactor, 0.0); builder.forceDefaults(false) }
    if (bodyProportionErrorFactor != null) { builder.forceDefaults(true); builder.addFloat(10, bodyProportionErrorFactor, 0.0); builder.forceDefaults(false) }
    if (heightErrorFactor != null) { builder.forceDefaults(true); builder.addFloat(11, heightErrorFactor, 0.0); builder.forceDefaults(false) }
    if (positionErrorFactor != null) { builder.forceDefaults(true); builder.addFloat(12, positionErrorFactor, 0.0); builder.forceDefaults(false) }
    if (positionOffsetErrorFactor != null) { builder.forceDefaults(true); builder.addFloat(13, positionOffsetErrorFactor, 0.0); builder.forceDefaults(false) }
    if (calcInitError != null) { builder.forceDefaults(true); builder.addBoolean(14, calcInitError, false); builder.forceDefaults(false) }
    if (randomizeFrameOrder != null) { builder.forceDefaults(true); builder.addBoolean(15, randomizeFrameOrder, false); builder.forceDefaults(false) }
    if (scaleEachStep != null) { builder.forceDefaults(true); builder.addBoolean(16, scaleEachStep, false); builder.forceDefaults(false) }
    if (sampleCount != null) { builder.forceDefaults(true); builder.addInt(17, sampleCount, 0); builder.forceDefaults(false) }
    if (sampleRateMs != null) { builder.forceDefaults(true); builder.addLong(18, sampleRateMs, 0L); builder.forceDefaults(false) }
    if (saveRecordings != null) { builder.forceDefaults(true); builder.addBoolean(19, saveRecordings, false); builder.forceDefaults(false) }
    if (useSkeletonHeight != null) { builder.forceDefaults(true); builder.addBoolean(20, useSkeletonHeight, false); builder.forceDefaults(false) }
    if (randSeed != null) { builder.forceDefaults(true); builder.addLong(21, randSeed, 0L); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): AutoBoneSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_cursorIncrement = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_minDataDistance = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_maxDataDistance = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_numEpochs = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_printEveryNumEpochs = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_initialAdjustRate = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_adjustRateDecay = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_slideErrorFactor = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_offsetSlideErrorFactor = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_footHeightOffsetErrorFactor = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_bodyProportionErrorFactor = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_heightErrorFactor = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0
      val __offset_positionErrorFactor = if (vtableSize > 28) bb.getShort(vtableOffset + 28).toInt() else 0
      val __offset_positionOffsetErrorFactor = if (vtableSize > 30) bb.getShort(vtableOffset + 30).toInt() else 0
      val __offset_calcInitError = if (vtableSize > 32) bb.getShort(vtableOffset + 32).toInt() else 0
      val __offset_randomizeFrameOrder = if (vtableSize > 34) bb.getShort(vtableOffset + 34).toInt() else 0
      val __offset_scaleEachStep = if (vtableSize > 36) bb.getShort(vtableOffset + 36).toInt() else 0
      val __offset_sampleCount = if (vtableSize > 38) bb.getShort(vtableOffset + 38).toInt() else 0
      val __offset_sampleRateMs = if (vtableSize > 40) bb.getShort(vtableOffset + 40).toInt() else 0
      val __offset_saveRecordings = if (vtableSize > 42) bb.getShort(vtableOffset + 42).toInt() else 0
      val __offset_useSkeletonHeight = if (vtableSize > 44) bb.getShort(vtableOffset + 44).toInt() else 0
      val __offset_randSeed = if (vtableSize > 46) bb.getShort(vtableOffset + 46).toInt() else 0

      return AutoBoneSettings(
              cursorIncrement = if (__offset_cursorIncrement != 0) bb.getInt(tableOffset + __offset_cursorIncrement) else null,
              minDataDistance = if (__offset_minDataDistance != 0) bb.getInt(tableOffset + __offset_minDataDistance) else null,
              maxDataDistance = if (__offset_maxDataDistance != 0) bb.getInt(tableOffset + __offset_maxDataDistance) else null,
              numEpochs = if (__offset_numEpochs != 0) bb.getInt(tableOffset + __offset_numEpochs) else null,
              printEveryNumEpochs = if (__offset_printEveryNumEpochs != 0) bb.getInt(tableOffset + __offset_printEveryNumEpochs) else null,
              initialAdjustRate = if (__offset_initialAdjustRate != 0) bb.getFloat(tableOffset + __offset_initialAdjustRate) else null,
              adjustRateDecay = if (__offset_adjustRateDecay != 0) bb.getFloat(tableOffset + __offset_adjustRateDecay) else null,
              slideErrorFactor = if (__offset_slideErrorFactor != 0) bb.getFloat(tableOffset + __offset_slideErrorFactor) else null,
              offsetSlideErrorFactor = if (__offset_offsetSlideErrorFactor != 0) bb.getFloat(tableOffset + __offset_offsetSlideErrorFactor) else null,
              footHeightOffsetErrorFactor = if (__offset_footHeightOffsetErrorFactor != 0) bb.getFloat(tableOffset + __offset_footHeightOffsetErrorFactor) else null,
              bodyProportionErrorFactor = if (__offset_bodyProportionErrorFactor != 0) bb.getFloat(tableOffset + __offset_bodyProportionErrorFactor) else null,
              heightErrorFactor = if (__offset_heightErrorFactor != 0) bb.getFloat(tableOffset + __offset_heightErrorFactor) else null,
              positionErrorFactor = if (__offset_positionErrorFactor != 0) bb.getFloat(tableOffset + __offset_positionErrorFactor) else null,
              positionOffsetErrorFactor = if (__offset_positionOffsetErrorFactor != 0) bb.getFloat(tableOffset + __offset_positionOffsetErrorFactor) else null,
              calcInitError = if (__offset_calcInitError != 0) bb.get(tableOffset + __offset_calcInitError) != 0.toByte() else null,
              randomizeFrameOrder = if (__offset_randomizeFrameOrder != 0) bb.get(tableOffset + __offset_randomizeFrameOrder) != 0.toByte() else null,
              scaleEachStep = if (__offset_scaleEachStep != 0) bb.get(tableOffset + __offset_scaleEachStep) != 0.toByte() else null,
              sampleCount = if (__offset_sampleCount != 0) bb.getInt(tableOffset + __offset_sampleCount) else null,
              sampleRateMs = if (__offset_sampleRateMs != 0) bb.getLong(tableOffset + __offset_sampleRateMs) else null,
              saveRecordings = if (__offset_saveRecordings != 0) bb.get(tableOffset + __offset_saveRecordings) != 0.toByte() else null,
              useSkeletonHeight = if (__offset_useSkeletonHeight != 0) bb.get(tableOffset + __offset_useSkeletonHeight) != 0.toByte() else null,
              randSeed = if (__offset_randSeed != 0) bb.getLong(tableOffset + __offset_randSeed) else null
          )
    }
  }
}

public class HeightRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): HeightRequest = HeightRequest()
  }
}

/**
 * Returns the current min and max positional tracker heights
 */
public data class HeightResponse(
  public val minHeight: Float? = null,
  public val maxHeight: Float? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (minHeight != null) { builder.forceDefaults(true); builder.addFloat(0, minHeight, 0.0); builder.forceDefaults(false) }
    if (maxHeight != null) { builder.forceDefaults(true); builder.addFloat(1, maxHeight, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): HeightResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_minHeight = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_maxHeight = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return HeightResponse(
              minHeight = if (__offset_minHeight != 0) bb.getFloat(tableOffset + __offset_minHeight) else null,
              maxHeight = if (__offset_maxHeight != 0) bb.getFloat(tableOffset + __offset_maxHeight) else null
          )
    }
  }
}

/**
 * Applies the estimated proportions
 */
public class AutoBoneApplyRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): AutoBoneApplyRequest = AutoBoneApplyRequest()
  }
}

/**
 * Stops the current recording, using it as far as it has been recorded
 */
public class AutoBoneStopRecordingRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): AutoBoneStopRecordingRequest = AutoBoneStopRecordingRequest()
  }
}

/**
 * Cancels the current recording, aborting the process and discarding the data
 */
public class AutoBoneCancelRecordingRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): AutoBoneCancelRecordingRequest = AutoBoneCancelRecordingRequest()
  }
}

/**
 * Requests the current state of `OverlayDisplayModeResponse`.
 */
public class OverlayDisplayModeRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OverlayDisplayModeRequest = OverlayDisplayModeRequest()
  }
}

/**
 * Changes the state of the overlay's display mode.
 */
public data class OverlayDisplayModeChangeRequest(
  public val isVisible: Boolean? = null,
  public val isMirrored: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (isVisible != null) { builder.forceDefaults(true); builder.addBoolean(0, isVisible, false); builder.forceDefaults(false) }
    if (isMirrored != null) { builder.forceDefaults(true); builder.addBoolean(1, isMirrored, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OverlayDisplayModeChangeRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_isVisible = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_isMirrored = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return OverlayDisplayModeChangeRequest(
              isVisible = if (__offset_isVisible != 0) bb.get(tableOffset + __offset_isVisible) != 0.toByte() else null,
              isMirrored = if (__offset_isMirrored != 0) bb.get(tableOffset + __offset_isMirrored) != 0.toByte() else null
          )
    }
  }
}

/**
 * The current state of the overlay's display mode.
 */
public data class OverlayDisplayModeResponse(
  public val isVisible: Boolean? = null,
  public val isMirrored: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (isVisible != null) { builder.forceDefaults(true); builder.addBoolean(0, isVisible, false); builder.forceDefaults(false) }
    if (isMirrored != null) { builder.forceDefaults(true); builder.addBoolean(1, isMirrored, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OverlayDisplayModeResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_isVisible = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_isMirrored = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return OverlayDisplayModeResponse(
              isVisible = if (__offset_isVisible != 0) bb.get(tableOffset + __offset_isVisible) != 0.toByte() else null,
              isMirrored = if (__offset_isMirrored != 0) bb.get(tableOffset + __offset_isMirrored) != 0.toByte() else null
          )
    }
  }
}

/**
 * Allows to ask generic infos about the server,
 * like the local ip address, the version of the server, the java version,
 * the current working dir and other information we might want to show in the gui
 * for information/debug purposes
 */
public class ServerInfosRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ServerInfosRequest = ServerInfosRequest()
  }
}

/**
 * Holds the Server information, this is a basic table holding various information about the currently running server
 * like its local ip address (useful for standalone users so they can specify the ip of the server more easily) and any more
 * infos we might want to add in the future. (like java version, working dir, server version ....)
 * This only holds the local ip for now. But there will be other information added as we chose to display them on the gui for instance
 */
public data class ServerInfosResponse(
  public val localip: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_localip = localip?.let { builder.createString(it) }

    builder.startTable(1)
    __off_localip?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ServerInfosResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_localip = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ServerInfosResponse(
              localip = if (__offset_localip != 0) readFlatBufferString(bb, tableOffset + __offset_localip) else null
          )
    }
  }
}

/**
 * Makes a temporary change to legtweaks. This is not saved to disk, and can be
 * cleared with `LegTweaksTmpClear`
 */
public data class LegTweaksTmpChange(
  public val floorClip: Boolean? = null,
  public val skatingCorrection: Boolean? = null,
  public val toeSnap: Boolean? = null,
  public val footPlant: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(4)
    if (floorClip != null) { builder.forceDefaults(true); builder.addBoolean(0, floorClip, false); builder.forceDefaults(false) }
    if (skatingCorrection != null) { builder.forceDefaults(true); builder.addBoolean(1, skatingCorrection, false); builder.forceDefaults(false) }
    if (toeSnap != null) { builder.forceDefaults(true); builder.addBoolean(2, toeSnap, false); builder.forceDefaults(false) }
    if (footPlant != null) { builder.forceDefaults(true); builder.addBoolean(3, footPlant, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): LegTweaksTmpChange {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_floorClip = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_skatingCorrection = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_toeSnap = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_footPlant = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return LegTweaksTmpChange(
              floorClip = if (__offset_floorClip != 0) bb.get(tableOffset + __offset_floorClip) != 0.toByte() else null,
              skatingCorrection = if (__offset_skatingCorrection != 0) bb.get(tableOffset + __offset_skatingCorrection) != 0.toByte() else null,
              toeSnap = if (__offset_toeSnap != 0) bb.get(tableOffset + __offset_toeSnap) != 0.toByte() else null,
              footPlant = if (__offset_footPlant != 0) bb.get(tableOffset + __offset_footPlant) != 0.toByte() else null
          )
    }
  }
}

/**
 * Clears the legtweaks temporary state back to what the config has.
 * Setting a field to `true` will reset that field.
 */
public data class LegTweaksTmpClear(
  public val floorClip: Boolean = false,
  public val skatingCorrection: Boolean = false,
  public val toeSnap: Boolean = false,
  public val footPlant: Boolean = false,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(4)
    builder.addBoolean(0, floorClip, false)
    builder.addBoolean(1, skatingCorrection, false)
    builder.addBoolean(2, toeSnap, false)
    builder.addBoolean(3, footPlant, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): LegTweaksTmpClear {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_floorClip = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_skatingCorrection = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_toeSnap = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_footPlant = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return LegTweaksTmpClear(
              floorClip = if (__offset_floorClip != 0) bb.get(tableOffset + __offset_floorClip) != 0.toByte() else false,
              skatingCorrection = if (__offset_skatingCorrection != 0) bb.get(tableOffset + __offset_skatingCorrection) != 0.toByte() else false,
              toeSnap = if (__offset_toeSnap != 0) bb.get(tableOffset + __offset_toeSnap) != 0.toByte() else false,
              footPlant = if (__offset_footPlant != 0) bb.get(tableOffset + __offset_footPlant) != 0.toByte() else false
          )
    }
  }
}

public sealed interface StatusData {
  public companion object {
    public fun decode(
      type: Byte,
      bb: FlatBufferReader,
      offset: Int,
    ): StatusData? = when (type.toInt()) {
      1 -> StatusTrackerReset.decode(bb, offset)
      2 -> StatusTrackerError.decode(bb, offset)
      3 -> StatusSteamVRDisconnected.decode(bb, offset)
      4 -> StatusUnassignedHMD.decode(bb, offset)
      5 -> StatusPublicNetwork.decode(bb, offset)
      else -> null
    }

    public fun typeIndex(`value`: StatusData): Byte = when (value) {
      is StatusTrackerReset -> 1
      is StatusTrackerError -> 2
      is StatusSteamVRDisconnected -> 3
      is StatusUnassignedHMD -> 4
      is StatusPublicNetwork -> 5
    }

    public fun encode(`value`: StatusData, builder: FlatBufferWriter): Int = when (value) {
      is StatusTrackerReset -> value.encode(builder)
      is StatusTrackerError -> value.encode(builder)
      is StatusSteamVRDisconnected -> value.encode(builder)
      is StatusUnassignedHMD -> value.encode(builder)
      is StatusPublicNetwork -> value.encode(builder)
    }
  }
}

/**
 * Tracker requires full reset
 */
public data class StatusTrackerReset(
  public val trackerId: List<TrackerId>? = null,
) : StatusData {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackerId = trackerId?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(1)
    __off_trackerId?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StatusTrackerReset {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StatusTrackerReset(
              trackerId = if (__offset_trackerId != 0) { val vecOff = tableOffset + __offset_trackerId + bb.getInt(tableOffset + __offset_trackerId); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) TrackerId.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

/**
 * Trackers with error state
 */
public data class StatusTrackerError(
  public val trackerId: List<TrackerId>? = null,
) : StatusData {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackerId = trackerId?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(1)
    __off_trackerId?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StatusTrackerError {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StatusTrackerError(
              trackerId = if (__offset_trackerId != 0) { val vecOff = tableOffset + __offset_trackerId + bb.getInt(tableOffset + __offset_trackerId); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) TrackerId.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

/**
 * SteamVR bridge is disconnected
 */
public data class StatusSteamVRDisconnected(
  public val bridgeSettingsName: String? = null,
) : StatusData {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_bridgeSettingsName = bridgeSettingsName?.let { builder.createString(it) }

    builder.startTable(1)
    __off_bridgeSettingsName?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StatusSteamVRDisconnected {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bridgeSettingsName = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StatusSteamVRDisconnected(
              bridgeSettingsName = if (__offset_bridgeSettingsName != 0) readFlatBufferString(bb, tableOffset + __offset_bridgeSettingsName) else null
          )
    }
  }
}

/**
 * There is an available HMD tracker and it's not assigned to head
 */
public data class StatusUnassignedHMD(
  public val trackerId: TrackerId? = null,
) : StatusData {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackerId = trackerId?.encode(builder)

    builder.startTable(1)
    __off_trackerId?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StatusUnassignedHMD {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StatusUnassignedHMD(
              trackerId = if (__offset_trackerId != 0) TrackerId.decode(bb, tableOffset + __offset_trackerId + bb.getInt(tableOffset + __offset_trackerId)) else null
          )
    }
  }
}

/**
 * Request current statuses that we have
 */
public class StatusSystemRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StatusSystemRequest = StatusSystemRequest()
  }
}

/**
 * Response containing all current valid statuses
 */
public data class StatusSystemResponse(
  public val currentStatuses: List<StatusMessage>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_currentStatuses = currentStatuses?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(1)
    __off_currentStatuses?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StatusSystemResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_currentStatuses = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StatusSystemResponse(
              currentStatuses = if (__offset_currentStatuses != 0) { val vecOff = tableOffset + __offset_currentStatuses + bb.getInt(tableOffset + __offset_currentStatuses); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) StatusMessage.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

/**
 * When a new status appears, it's sent alone
 */
public data class StatusSystemUpdate(
  public val newStatus: StatusMessage? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_newStatus = newStatus?.encode(builder)

    builder.startTable(1)
    __off_newStatus?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StatusSystemUpdate {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_newStatus = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StatusSystemUpdate(
              newStatus = if (__offset_newStatus != 0) StatusMessage.decode(bb, tableOffset + __offset_newStatus + bb.getInt(tableOffset + __offset_newStatus)) else null
          )
    }
  }
}

/**
 * When an status is fixed and it's removed, it's ID is sent
 */
public data class StatusSystemFixed(
  public val fixedStatusId: UInt? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (fixedStatusId != null) { builder.forceDefaults(true); builder.addInt(0, fixedStatusId.toInt(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StatusSystemFixed {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_fixedStatusId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StatusSystemFixed(
              fixedStatusId = if (__offset_fixedStatusId != 0) bb.getInt(tableOffset + __offset_fixedStatusId).toUInt() else null
          )
    }
  }
}

/**
 * When the server detects a public network profile
 */
public data class StatusPublicNetwork(
  public val adapters: List<String>? = null,
) : StatusData {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_adapters = adapters?.let { builder.createVectorOfTables(it.map { s -> builder.createString(s) }.toIntArray()) }

    builder.startTable(1)
    __off_adapters?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StatusPublicNetwork {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_adapters = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StatusPublicNetwork(
              adapters = if (__offset_adapters != 0) { val vecOff = tableOffset + __offset_adapters + bb.getInt(tableOffset + __offset_adapters); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> readFlatBufferString(bb, vecOff + 4 + i * 4) } } else null
          )
    }
  }
}

/**
 * An status is some kind of warning sent by the server, it's mainly made for
 * showing problems with the server and need attention from the user.
 */
public data class StatusMessage(
  public val id: UInt? = null,
  public val prioritized: Boolean = false,
  public val `data`: StatusData? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_data = data?.let { StatusData.encode(it, builder) }
    val __type_data = data?.let { StatusData.typeIndex(it) } ?: 0.toByte()

    builder.startTable(4)
    if (id != null) { builder.forceDefaults(true); builder.addInt(0, id.toInt(), 0); builder.forceDefaults(false) }
    builder.addBoolean(1, prioritized, false)
    builder.addByte(2, __type_data, 0)
    __off_data?.let { builder.addOffset(3, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StatusMessage {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_id = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_prioritized = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __type_data = if (vtableSize > 8 && bb.getShort(vtableOffset + 8).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 8).toInt()) else 0
      val __offset_data = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return StatusMessage(
              id = if (__offset_id != 0) bb.getInt(tableOffset + __offset_id).toUInt() else null,
              prioritized = if (__offset_prioritized != 0) bb.get(tableOffset + __offset_prioritized) != 0.toByte() else false,
              data = if (__offset_data != 0) StatusData.decode(__type_data, bb, tableOffset + __offset_data + bb.getInt(tableOffset + __offset_data)) else null
          )
    }
  }
}

public data class SetPauseTrackingRequest(
  public val pausetracking: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (pausetracking != null) { builder.forceDefaults(true); builder.addBoolean(0, pausetracking, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SetPauseTrackingRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_pausetracking = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return SetPauseTrackingRequest(
              pausetracking = if (__offset_pausetracking != 0) bb.get(tableOffset + __offset_pausetracking) != 0.toByte() else null
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

/**
 * Common folders often used in computers for storing files
 */
public enum class ComputerDirectory(
  public val `value`: UByte,
) {
  Documents(0.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): ComputerDirectory? = entries.firstOrNull { it.value == value }
  }
}

/**
 * Used for the server to save a file and have it prompt in the user side
 */
public data class SaveFileNotification(
  public val `data`: List<UByte>? = null,
  public val mimeType: String? = null,
  public val fileExtension: String? = null,
  public val expectedDir: ComputerDirectory? = null,
  public val expectedFilename: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_data = data?.let { builder.createByteVector(it.map { b -> b.toByte() }.toByteArray()) }
    val __off_mimeType = mimeType?.let { builder.createString(it) }
    val __off_fileExtension = fileExtension?.let { builder.createString(it) }
    val __off_expectedFilename = expectedFilename?.let { builder.createString(it) }

    builder.startTable(5)
    __off_data?.let { builder.addOffset(0, it, 0) }
    __off_mimeType?.let { builder.addOffset(1, it, 0) }
    __off_fileExtension?.let { builder.addOffset(2, it, 0) }
    if (expectedDir != null) { builder.forceDefaults(true); builder.addByte(3, expectedDir.value.toByte(), 0); builder.forceDefaults(false) }
    __off_expectedFilename?.let { builder.addOffset(4, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SaveFileNotification {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_data = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_mimeType = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_fileExtension = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_expectedDir = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_expectedFilename = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return SaveFileNotification(
              data = if (__offset_data != 0) { val vecOff = tableOffset + __offset_data + bb.getInt(tableOffset + __offset_data); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> bb.get(vecOff + 4 + i * 1).toUByte() } } else null,
              mimeType = if (__offset_mimeType != 0) readFlatBufferString(bb, tableOffset + __offset_mimeType) else null,
              fileExtension = if (__offset_fileExtension != 0) readFlatBufferString(bb, tableOffset + __offset_fileExtension) else null,
              expectedDir = if (__offset_expectedDir != 0) ComputerDirectory.fromValue(bb.get(tableOffset + __offset_expectedDir).toUByte()) else null,
              expectedFilename = if (__offset_expectedFilename != 0) readFlatBufferString(bb, tableOffset + __offset_expectedFilename) else null
          )
    }
  }
}

public enum class FirmwareUpdateStatus(
  public val `value`: UByte,
) {
  /**
   * The server is downloading the firmware
   */
  DOWNLOADING(0.toUByte()),
  /**
   * The server is waiting for the tracker to be rebooted by the user
   * Note that is is not the same as REBOOTING
   */
  NEED_MANUAL_REBOOT(1.toUByte()),
  /**
   * The server tries to authenticate with the MCU
   */
  AUTHENTICATING(2.toUByte()),
  /**
   * The server is uploading the firmware to the Device
   */
  UPLOADING(3.toUByte()),
  /**
   * The serial flasher tries to sync with the MCU
   * You can use this event to prompt the user to press the boot btn
   */
  SYNCING_WITH_MCU(4.toUByte()),
  /**
   * The MCU is rebooting
   */
  REBOOTING(5.toUByte()),
  /**
   * The server is provisioning the tracker
   */
  PROVISIONING(6.toUByte()),
  DONE(7.toUByte()),
  /**
   * Could not find the device
   */
  ERROR_DEVICE_NOT_FOUND(8.toUByte()),
  /**
   * The operation timed out, > 1min
   */
  ERROR_TIMEOUT(9.toUByte()),
  /**
   * The firmware download failed
   */
  ERROR_DOWNLOAD_FAILED(10.toUByte()),
  /**
   * The server could not authenticate with the MCU
   */
  ERROR_AUTHENTICATION_FAILED(11.toUByte()),
  /**
   * Could not upload the firmware to the MCU
   */
  ERROR_UPLOAD_FAILED(12.toUByte()),
  /**
   * The provision of the tracker failed, usually wifi credentials
   */
  ERROR_PROVISIONING_FAILED(13.toUByte()),
  /**
   * An unsupported Flashing method was used
   */
  ERROR_UNSUPPORTED_METHOD(14.toUByte()),
  ERROR_UNKNOWN(15.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): FirmwareUpdateStatus? = entries.firstOrNull { it.value == value }
  }
}

public data class SerialDevicePort(
  public val port: String? = null,
) : FirmwareUpdateDeviceId {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_port = port?.let { builder.createString(it) }

    builder.startTable(1)
    __off_port?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SerialDevicePort {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_port = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return SerialDevicePort(
              port = if (__offset_port != 0) readFlatBufferString(bb, tableOffset + __offset_port) else null
          )
    }
  }
}

public interface FirmwareUpdateDeviceId {
  public companion object {
    public fun decode(
      type: Byte,
      bb: FlatBufferReader,
      offset: Int,
    ): FirmwareUpdateDeviceId? = when (type.toInt()) {
      1 -> DeviceIdTable.decode(bb, offset)
      2 -> SerialDevicePort.decode(bb, offset)
      else -> null
    }

    public fun typeIndex(`value`: FirmwareUpdateDeviceId): Byte = when (value) {
      is DeviceIdTable -> 1
      is SerialDevicePort -> 2
      else -> 0
    }

    public fun encode(`value`: FirmwareUpdateDeviceId, builder: FlatBufferWriter): Int = when (value) {
      is DeviceIdTable -> value.encode(builder)
      is SerialDevicePort -> value.encode(builder)
      else -> 0
    }
  }
}

public data class FirmwarePart(
  public val url: String? = null,
  public val offset: UInt? = null,
  public val digest: String? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_url = url?.let { builder.createString(it) }
    val __off_digest = digest?.let { builder.createString(it) }

    builder.startTable(3)
    __off_url?.let { builder.addOffset(0, it, 0) }
    if (offset != null) { builder.forceDefaults(true); builder.addInt(1, offset.toInt(), 0); builder.forceDefaults(false) }
    __off_digest?.let { builder.addOffset(2, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): FirmwarePart {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_url = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_offset = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_digest = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return FirmwarePart(
              url = if (__offset_url != 0) readFlatBufferString(bb, tableOffset + __offset_url) else null,
              offset = if (__offset_offset != 0) bb.getInt(tableOffset + __offset_offset).toUInt() else null,
              digest = if (__offset_digest != 0) readFlatBufferString(bb, tableOffset + __offset_digest) else null
          )
    }
  }
}

public sealed interface FirmwareUpdateMethod {
  public companion object {
    public fun decode(
      type: Byte,
      bb: FlatBufferReader,
      offset: Int,
    ): FirmwareUpdateMethod? = when (type.toInt()) {
      1 -> OTAFirmwareUpdate.decode(bb, offset)
      2 -> SerialFirmwareUpdate.decode(bb, offset)
      else -> null
    }

    public fun typeIndex(`value`: FirmwareUpdateMethod): Byte = when (value) {
      is OTAFirmwareUpdate -> 1
      is SerialFirmwareUpdate -> 2
    }

    public fun encode(`value`: FirmwareUpdateMethod, builder: FlatBufferWriter): Int = when (value) {
      is OTAFirmwareUpdate -> value.encode(builder)
      is SerialFirmwareUpdate -> value.encode(builder)
    }
  }
}

public data class FirmwareUpdateRequest(
  public val method: FirmwareUpdateMethod? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_method = method?.let { FirmwareUpdateMethod.encode(it, builder) }
    val __type_method = method?.let { FirmwareUpdateMethod.typeIndex(it) } ?: 0.toByte()

    builder.startTable(2)
    builder.addByte(0, __type_method, 0)
    __off_method?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): FirmwareUpdateRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __type_method = if (vtableSize > 4 && bb.getShort(vtableOffset + 4).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 4).toInt()) else 0
      val __offset_method = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return FirmwareUpdateRequest(
              method = if (__offset_method != 0) FirmwareUpdateMethod.decode(__type_method, bb, tableOffset + __offset_method + bb.getInt(tableOffset + __offset_method)) else null
          )
    }
  }
}

public data class OTAFirmwareUpdate(
  public val deviceId: DeviceId? = null,
  public val firmwarePart: FirmwarePart? = null,
) : FirmwareUpdateMethod {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_firmwarePart = firmwarePart?.encode(builder)

    builder.startTable(2)
    deviceId?.let { builder.addStruct(0, it.encode(builder), 0) }
    __off_firmwarePart?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OTAFirmwareUpdate {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_deviceId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_firmwarePart = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return OTAFirmwareUpdate(
              deviceId = if (__offset_deviceId != 0) DeviceId.decode(bb, tableOffset + __offset_deviceId) else null,
              firmwarePart = if (__offset_firmwarePart != 0) FirmwarePart.decode(bb, tableOffset + __offset_firmwarePart + bb.getInt(tableOffset + __offset_firmwarePart)) else null
          )
    }
  }
}

public data class SerialFirmwareUpdate(
  public val deviceId: SerialDevicePort? = null,
  public val needmanualreboot: Boolean? = null,
  public val ssid: String? = null,
  public val password: String? = null,
  public val firmwarePart: List<FirmwarePart>? = null,
) : FirmwareUpdateMethod {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_deviceId = deviceId?.encode(builder)
    val __off_ssid = ssid?.let { builder.createString(it) }
    val __off_password = password?.let { builder.createString(it) }
    val __off_firmwarePart = firmwarePart?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(5)
    __off_deviceId?.let { builder.addOffset(0, it, 0) }
    if (needmanualreboot != null) { builder.forceDefaults(true); builder.addBoolean(1, needmanualreboot, false); builder.forceDefaults(false) }
    __off_ssid?.let { builder.addOffset(2, it, 0) }
    __off_password?.let { builder.addOffset(3, it, 0) }
    __off_firmwarePart?.let { builder.addOffset(4, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SerialFirmwareUpdate {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_deviceId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_needmanualreboot = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_ssid = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_password = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_firmwarePart = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return SerialFirmwareUpdate(
              deviceId = if (__offset_deviceId != 0) SerialDevicePort.decode(bb, tableOffset + __offset_deviceId + bb.getInt(tableOffset + __offset_deviceId)) else null,
              needmanualreboot = if (__offset_needmanualreboot != 0) bb.get(tableOffset + __offset_needmanualreboot) != 0.toByte() else null,
              ssid = if (__offset_ssid != 0) readFlatBufferString(bb, tableOffset + __offset_ssid) else null,
              password = if (__offset_password != 0) readFlatBufferString(bb, tableOffset + __offset_password) else null,
              firmwarePart = if (__offset_firmwarePart != 0) { val vecOff = tableOffset + __offset_firmwarePart + bb.getInt(tableOffset + __offset_firmwarePart); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) FirmwarePart.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

public data class FirmwareUpdateStatusResponse(
  public val deviceId: FirmwareUpdateDeviceId? = null,
  public val status: FirmwareUpdateStatus? = null,
  public val progress: Byte? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_deviceId = deviceId?.let { FirmwareUpdateDeviceId.encode(it, builder) }
    val __type_deviceId = deviceId?.let { FirmwareUpdateDeviceId.typeIndex(it) } ?: 0.toByte()

    builder.startTable(4)
    builder.addByte(0, __type_deviceId, 0)
    __off_deviceId?.let { builder.addOffset(1, it, 0) }
    if (status != null) { builder.forceDefaults(true); builder.addByte(2, status.value.toByte(), 0); builder.forceDefaults(false) }
    if (progress != null) { builder.forceDefaults(true); builder.addByte(3, progress, 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): FirmwareUpdateStatusResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __type_deviceId = if (vtableSize > 4 && bb.getShort(vtableOffset + 4).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 4).toInt()) else 0
      val __offset_deviceId = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_status = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_progress = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return FirmwareUpdateStatusResponse(
              deviceId = if (__offset_deviceId != 0) FirmwareUpdateDeviceId.decode(__type_deviceId, bb, tableOffset + __offset_deviceId + bb.getInt(tableOffset + __offset_deviceId)) else null,
              status = if (__offset_status != 0) FirmwareUpdateStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) else null,
              progress = if (__offset_progress != 0) bb.get(tableOffset + __offset_progress) else null
          )
    }
  }
}

public class FirmwareUpdateStopQueuesRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): FirmwareUpdateStopQueuesRequest = FirmwareUpdateStopQueuesRequest()
  }
}

/**
 * Requests the current state of tracking pause
 */
public class TrackingPauseStateRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackingPauseStateRequest = TrackingPauseStateRequest()
  }
}

public data class TrackingPauseStateResponse(
  public val trackingpaused: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (trackingpaused != null) { builder.forceDefaults(true); builder.addBoolean(0, trackingpaused, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackingPauseStateResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackingpaused = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TrackingPauseStateResponse(
              trackingpaused = if (__offset_trackingpaused != 0) bb.get(tableOffset + __offset_trackingpaused) != 0.toByte() else null
          )
    }
  }
}

/**
 * Sends the GET WIFISCAN cmd to the current tracker on the serial monitor
 */
public class SerialTrackerGetWifiScanRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SerialTrackerGetWifiScanRequest = SerialTrackerGetWifiScanRequest()
  }
}

/**
 * Server notifies connection of an unknown device.
 * If the notification is no longer sent, it means the device connected to another
 * server, got connected to this server or it was turned off.
 */
public data class UnknownDeviceHandshakeNotification(
  public val macAddress: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_macAddress = macAddress?.let { builder.createString(it) }

    builder.startTable(1)
    __off_macAddress?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): UnknownDeviceHandshakeNotification {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_macAddress = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return UnknownDeviceHandshakeNotification(
              macAddress = if (__offset_macAddress != 0) readFlatBufferString(bb, tableOffset + __offset_macAddress) else null
          )
    }
  }
}

public data class AddUnknownDeviceRequest(
  public val macAddress: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_macAddress = macAddress?.let { builder.createString(it) }

    builder.startTable(1)
    __off_macAddress?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): AddUnknownDeviceRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_macAddress = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return AddUnknownDeviceRequest(
              macAddress = if (__offset_macAddress != 0) readFlatBufferString(bb, tableOffset + __offset_macAddress) else null
          )
    }
  }
}

public data class ForgetDeviceRequest(
  public val macAddress: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_macAddress = macAddress?.let { builder.createString(it) }

    builder.startTable(1)
    __off_macAddress?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ForgetDeviceRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_macAddress = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ForgetDeviceRequest(
              macAddress = if (__offset_macAddress != 0) readFlatBufferString(bb, tableOffset + __offset_macAddress) else null
          )
    }
  }
}

public class SettingsResetRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SettingsResetRequest = SettingsResetRequest()
  }
}

/**
 * If no tracker ID is given, it's the setting for every tracker/device
 */
public data class MagToggleRequest(
  public val trackerId: TrackerId? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackerId = trackerId?.encode(builder)

    builder.startTable(1)
    __off_trackerId?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): MagToggleRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return MagToggleRequest(
              trackerId = if (__offset_trackerId != 0) TrackerId.decode(bb, tableOffset + __offset_trackerId + bb.getInt(tableOffset + __offset_trackerId)) else null
          )
    }
  }
}

/**
 * If no tracker ID is given, it's the setting for every tracker/device
 */
public data class MagToggleResponse(
  public val trackerId: TrackerId? = null,
  public val enable: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackerId = trackerId?.encode(builder)

    builder.startTable(2)
    __off_trackerId?.let { builder.addOffset(0, it, 0) }
    if (enable != null) { builder.forceDefaults(true); builder.addBoolean(1, enable, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): MagToggleResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_enable = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return MagToggleResponse(
              trackerId = if (__offset_trackerId != 0) TrackerId.decode(bb, tableOffset + __offset_trackerId + bb.getInt(tableOffset + __offset_trackerId)) else null,
              enable = if (__offset_enable != 0) bb.get(tableOffset + __offset_enable) != 0.toByte() else null
          )
    }
  }
}

/**
 * If no tracker ID is given, it's the setting for every tracker/device
 */
public data class ChangeMagToggleRequest(
  public val trackerId: TrackerId? = null,
  public val enable: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackerId = trackerId?.encode(builder)

    builder.startTable(2)
    __off_trackerId?.let { builder.addOffset(0, it, 0) }
    if (enable != null) { builder.forceDefaults(true); builder.addBoolean(1, enable, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeMagToggleRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_enable = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return ChangeMagToggleRequest(
              trackerId = if (__offset_trackerId != 0) TrackerId.decode(bb, tableOffset + __offset_trackerId + bb.getInt(tableOffset + __offset_trackerId)) else null,
              enable = if (__offset_enable != 0) bb.get(tableOffset + __offset_enable) != 0.toByte() else null
          )
    }
  }
}

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
  public val legacyModeOk: Boolean? = null,
  public val shoulderTrackingOk: Boolean? = null,
  public val userHeightOk: Boolean? = null,
  public val calibrationRangeOk: Boolean? = null,
  public val calibrationVisualsOk: Boolean? = null,
  public val trackerModelOk: Boolean? = null,
  public val spineModeOk: Boolean? = null,
  public val avatarMeasurementTypeOk: Boolean? = null,
  public val shoulderWidthCompensationOk: Boolean? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(9)
    if (legacyModeOk != null) { builder.forceDefaults(true); builder.addBoolean(0, legacyModeOk, false); builder.forceDefaults(false) }
    if (shoulderTrackingOk != null) { builder.forceDefaults(true); builder.addBoolean(1, shoulderTrackingOk, false); builder.forceDefaults(false) }
    if (userHeightOk != null) { builder.forceDefaults(true); builder.addBoolean(2, userHeightOk, false); builder.forceDefaults(false) }
    if (calibrationRangeOk != null) { builder.forceDefaults(true); builder.addBoolean(3, calibrationRangeOk, false); builder.forceDefaults(false) }
    if (calibrationVisualsOk != null) { builder.forceDefaults(true); builder.addBoolean(4, calibrationVisualsOk, false); builder.forceDefaults(false) }
    if (trackerModelOk != null) { builder.forceDefaults(true); builder.addBoolean(5, trackerModelOk, false); builder.forceDefaults(false) }
    if (spineModeOk != null) { builder.forceDefaults(true); builder.addBoolean(6, spineModeOk, false); builder.forceDefaults(false) }
    if (avatarMeasurementTypeOk != null) { builder.forceDefaults(true); builder.addBoolean(7, avatarMeasurementTypeOk, false); builder.forceDefaults(false) }
    if (shoulderWidthCompensationOk != null) { builder.forceDefaults(true); builder.addBoolean(8, shoulderWidthCompensationOk, false); builder.forceDefaults(false) }
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
              legacyModeOk = if (__offset_legacyModeOk != 0) bb.get(tableOffset + __offset_legacyModeOk) != 0.toByte() else null,
              shoulderTrackingOk = if (__offset_shoulderTrackingOk != 0) bb.get(tableOffset + __offset_shoulderTrackingOk) != 0.toByte() else null,
              userHeightOk = if (__offset_userHeightOk != 0) bb.get(tableOffset + __offset_userHeightOk) != 0.toByte() else null,
              calibrationRangeOk = if (__offset_calibrationRangeOk != 0) bb.get(tableOffset + __offset_calibrationRangeOk) != 0.toByte() else null,
              calibrationVisualsOk = if (__offset_calibrationVisualsOk != 0) bb.get(tableOffset + __offset_calibrationVisualsOk) != 0.toByte() else null,
              trackerModelOk = if (__offset_trackerModelOk != 0) bb.get(tableOffset + __offset_trackerModelOk) != 0.toByte() else null,
              spineModeOk = if (__offset_spineModeOk != 0) bb.get(tableOffset + __offset_spineModeOk) != 0.toByte() else null,
              avatarMeasurementTypeOk = if (__offset_avatarMeasurementTypeOk != 0) bb.get(tableOffset + __offset_avatarMeasurementTypeOk) != 0.toByte() else null,
              shoulderWidthCompensationOk = if (__offset_shoulderWidthCompensationOk != 0) bb.get(tableOffset + __offset_shoulderWidthCompensationOk) != 0.toByte() else null
          )
    }
  }
}

public data class VRCConfigValues(
  public val legacyMode: Boolean? = null,
  public val shoulderTrackingDisabled: Boolean? = null,
  public val userHeight: Float? = null,
  public val calibrationRange: Float? = null,
  public val calibrationVisuals: Boolean? = null,
  public val trackerModel: VRCTrackerModel? = null,
  public val spineMode: VRCSpineMode? = null,
  public val avatarMeasurementType: VRCAvatarMeasurementType? = null,
  public val shoulderWidthCompensation: Boolean? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(9)
    if (legacyMode != null) { builder.forceDefaults(true); builder.addBoolean(0, legacyMode, false); builder.forceDefaults(false) }
    if (shoulderTrackingDisabled != null) { builder.forceDefaults(true); builder.addBoolean(1, shoulderTrackingDisabled, false); builder.forceDefaults(false) }
    if (userHeight != null) { builder.forceDefaults(true); builder.addFloat(2, userHeight, 0.0); builder.forceDefaults(false) }
    if (calibrationRange != null) { builder.forceDefaults(true); builder.addFloat(3, calibrationRange, 0.0); builder.forceDefaults(false) }
    if (calibrationVisuals != null) { builder.forceDefaults(true); builder.addBoolean(4, calibrationVisuals, false); builder.forceDefaults(false) }
    if (trackerModel != null) { builder.forceDefaults(true); builder.addByte(5, trackerModel.value.toByte(), 0); builder.forceDefaults(false) }
    if (spineMode != null) { builder.forceDefaults(true); builder.addByte(6, spineMode.value.toByte(), 0); builder.forceDefaults(false) }
    if (avatarMeasurementType != null) { builder.forceDefaults(true); builder.addByte(7, avatarMeasurementType.value.toByte(), 0); builder.forceDefaults(false) }
    if (shoulderWidthCompensation != null) { builder.forceDefaults(true); builder.addBoolean(8, shoulderWidthCompensation, false); builder.forceDefaults(false) }
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
              legacyMode = if (__offset_legacyMode != 0) bb.get(tableOffset + __offset_legacyMode) != 0.toByte() else null,
              shoulderTrackingDisabled = if (__offset_shoulderTrackingDisabled != 0) bb.get(tableOffset + __offset_shoulderTrackingDisabled) != 0.toByte() else null,
              userHeight = if (__offset_userHeight != 0) bb.getFloat(tableOffset + __offset_userHeight) else null,
              calibrationRange = if (__offset_calibrationRange != 0) bb.getFloat(tableOffset + __offset_calibrationRange) else null,
              calibrationVisuals = if (__offset_calibrationVisuals != 0) bb.get(tableOffset + __offset_calibrationVisuals) != 0.toByte() else null,
              trackerModel = if (__offset_trackerModel != 0) VRCTrackerModel.fromValue(bb.get(tableOffset + __offset_trackerModel).toUByte()) else null,
              spineMode = if (__offset_spineMode != 0) VRCSpineMode.fromValue(bb.get(tableOffset + __offset_spineMode).toUByte()) else null,
              avatarMeasurementType = if (__offset_avatarMeasurementType != 0) VRCAvatarMeasurementType.fromValue(bb.get(tableOffset + __offset_avatarMeasurementType).toUByte()) else null,
              shoulderWidthCompensation = if (__offset_shoulderWidthCompensation != 0) bb.get(tableOffset + __offset_shoulderWidthCompensation) != 0.toByte() else null
          )
    }
  }
}

public data class VRCConfigRecommendedValues(
  public val legacyMode: Boolean? = null,
  public val shoulderTrackingDisabled: Boolean? = null,
  public val userHeight: Float? = null,
  public val calibrationRange: Float? = null,
  public val calibrationVisuals: Boolean? = null,
  public val trackerModel: VRCTrackerModel? = null,
  public val spineMode: List<VRCSpineMode>? = null,
  public val avatarMeasurementType: VRCAvatarMeasurementType? = null,
  public val shoulderWidthCompensation: Boolean? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_spineMode = spineMode?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }

    builder.startTable(9)
    if (legacyMode != null) { builder.forceDefaults(true); builder.addBoolean(0, legacyMode, false); builder.forceDefaults(false) }
    if (shoulderTrackingDisabled != null) { builder.forceDefaults(true); builder.addBoolean(1, shoulderTrackingDisabled, false); builder.forceDefaults(false) }
    if (userHeight != null) { builder.forceDefaults(true); builder.addFloat(2, userHeight, 0.0); builder.forceDefaults(false) }
    if (calibrationRange != null) { builder.forceDefaults(true); builder.addFloat(3, calibrationRange, 0.0); builder.forceDefaults(false) }
    if (calibrationVisuals != null) { builder.forceDefaults(true); builder.addBoolean(4, calibrationVisuals, false); builder.forceDefaults(false) }
    if (trackerModel != null) { builder.forceDefaults(true); builder.addByte(5, trackerModel.value.toByte(), 0); builder.forceDefaults(false) }
    __off_spineMode?.let { builder.addOffset(6, it, 0) }
    if (avatarMeasurementType != null) { builder.forceDefaults(true); builder.addByte(7, avatarMeasurementType.value.toByte(), 0); builder.forceDefaults(false) }
    if (shoulderWidthCompensation != null) { builder.forceDefaults(true); builder.addBoolean(8, shoulderWidthCompensation, false); builder.forceDefaults(false) }
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
              legacyMode = if (__offset_legacyMode != 0) bb.get(tableOffset + __offset_legacyMode) != 0.toByte() else null,
              shoulderTrackingDisabled = if (__offset_shoulderTrackingDisabled != 0) bb.get(tableOffset + __offset_shoulderTrackingDisabled) != 0.toByte() else null,
              userHeight = if (__offset_userHeight != 0) bb.getFloat(tableOffset + __offset_userHeight) else null,
              calibrationRange = if (__offset_calibrationRange != 0) bb.getFloat(tableOffset + __offset_calibrationRange) else null,
              calibrationVisuals = if (__offset_calibrationVisuals != 0) bb.get(tableOffset + __offset_calibrationVisuals) != 0.toByte() else null,
              trackerModel = if (__offset_trackerModel != 0) VRCTrackerModel.fromValue(bb.get(tableOffset + __offset_trackerModel).toUByte()) else null,
              spineMode = if (__offset_spineMode != 0) { val vecOff = tableOffset + __offset_spineMode + bb.getInt(tableOffset + __offset_spineMode); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> VRCSpineMode.fromValue(bb.get(vecOff + 4 + i * 1).toUByte()) } } else null,
              avatarMeasurementType = if (__offset_avatarMeasurementType != 0) VRCAvatarMeasurementType.fromValue(bb.get(tableOffset + __offset_avatarMeasurementType).toUByte()) else null,
              shoulderWidthCompensation = if (__offset_shoulderWidthCompensation != 0) bb.get(tableOffset + __offset_shoulderWidthCompensation) != 0.toByte() else null
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
  public val isSupported: Boolean? = null,
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
    if (isSupported != null) { builder.forceDefaults(true); builder.addBoolean(0, isSupported, false); builder.forceDefaults(false) }
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
              isSupported = if (__offset_isSupported != 0) bb.get(tableOffset + __offset_isSupported) != 0.toByte() else null,
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
  public val trackersId: List<TrackerId>? = null,
) : TrackingChecklistExtraData {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackersId = trackersId?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

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
              trackersId = if (__offset_trackersId != 0) { val vecOff = tableOffset + __offset_trackersId + bb.getInt(tableOffset + __offset_trackersId); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) TrackerId.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

/**
 * Trackers with error state
 */
public data class TrackingChecklistTrackerError(
  public val trackersId: List<TrackerId>? = null,
) : TrackingChecklistExtraData {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackersId = trackersId?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

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
              trackersId = if (__offset_trackersId != 0) { val vecOff = tableOffset + __offset_trackersId + bb.getInt(tableOffset + __offset_trackersId); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) TrackerId.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

public data class TrackingChecklistNeedCalibration(
  public val trackersId: List<TrackerId>? = null,
) : TrackingChecklistExtraData {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackersId = trackersId?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

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
              trackersId = if (__offset_trackersId != 0) { val vecOff = tableOffset + __offset_trackersId + bb.getInt(tableOffset + __offset_trackersId); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) TrackerId.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

public data class TrackingChecklistSteamVRDisconnected(
  public val bridgeSettingsName: String? = null,
  public val driverInstalled: Boolean? = null,
  public val driverBlockedBySafeMode: Boolean? = null,
  public val driverEnabled: Boolean? = null,
) : TrackingChecklistExtraData {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_bridgeSettingsName = bridgeSettingsName?.let { builder.createString(it) }

    builder.startTable(4)
    __off_bridgeSettingsName?.let { builder.addOffset(0, it, 0) }
    if (driverInstalled != null) { builder.forceDefaults(true); builder.addBoolean(1, driverInstalled, false); builder.forceDefaults(false) }
    if (driverBlockedBySafeMode != null) { builder.forceDefaults(true); builder.addBoolean(2, driverBlockedBySafeMode, false); builder.forceDefaults(false) }
    if (driverEnabled != null) { builder.forceDefaults(true); builder.addBoolean(3, driverEnabled, false); builder.forceDefaults(false) }
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
              driverInstalled = if (__offset_driverInstalled != 0) bb.get(tableOffset + __offset_driverInstalled) != 0.toByte() else null,
              driverBlockedBySafeMode = if (__offset_driverBlockedBySafeMode != 0) bb.get(tableOffset + __offset_driverBlockedBySafeMode) != 0.toByte() else null,
              driverEnabled = if (__offset_driverEnabled != 0) bb.get(tableOffset + __offset_driverEnabled) != 0.toByte() else null
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
  public val trackerId: TrackerId? = null,
) : TrackingChecklistExtraData {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackerId = trackerId?.encode(builder)

    builder.startTable(1)
    __off_trackerId?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackingChecklistUnassignedHMD {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TrackingChecklistUnassignedHMD(
              trackerId = if (__offset_trackerId != 0) TrackerId.decode(bb, tableOffset + __offset_trackerId + bb.getInt(tableOffset + __offset_trackerId)) else null
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
      type: Byte,
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

    public fun typeIndex(`value`: TrackingChecklistExtraData): Byte = when (value) {
      is TrackingChecklistTrackerReset -> 1
      is TrackingChecklistTrackerError -> 2
      is TrackingChecklistSteamVRDisconnected -> 3
      is TrackingChecklistUnassignedHMD -> 4
      is TrackingChecklistNeedCalibration -> 5
      is TrackingChecklistPublicNetworks -> 6
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
  public val id: TrackingChecklistStepId? = null,
  public val valid: Boolean? = null,
  public val enabled: Boolean? = null,
  public val visibility: TrackingChecklistStepVisibility? = null,
  public val optional: Boolean? = null,
  public val ignorable: Boolean? = null,
  public val extraData: TrackingChecklistExtraData? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_extraData = extraData?.let { TrackingChecklistExtraData.encode(it, builder) }
    val __type_extraData = extraData?.let { TrackingChecklistExtraData.typeIndex(it) } ?: 0.toByte()

    builder.startTable(8)
    if (id != null) { builder.forceDefaults(true); builder.addByte(0, id.value.toByte(), 0); builder.forceDefaults(false) }
    if (valid != null) { builder.forceDefaults(true); builder.addBoolean(1, valid, false); builder.forceDefaults(false) }
    if (enabled != null) { builder.forceDefaults(true); builder.addBoolean(2, enabled, false); builder.forceDefaults(false) }
    if (visibility != null) { builder.forceDefaults(true); builder.addByte(3, visibility.value.toByte(), 0); builder.forceDefaults(false) }
    if (optional != null) { builder.forceDefaults(true); builder.addBoolean(4, optional, false); builder.forceDefaults(false) }
    if (ignorable != null) { builder.forceDefaults(true); builder.addBoolean(5, ignorable, false); builder.forceDefaults(false) }
    builder.addByte(6, __type_extraData, 0)
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
      val __type_extraData = if (vtableSize > 16 && bb.getShort(vtableOffset + 16).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 16).toInt()) else 0
      val __offset_extraData = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0

      return TrackingChecklistStep(
              id = if (__offset_id != 0) TrackingChecklistStepId.fromValue(bb.get(tableOffset + __offset_id).toUByte()) else null,
              valid = if (__offset_valid != 0) bb.get(tableOffset + __offset_valid) != 0.toByte() else null,
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else null,
              visibility = if (__offset_visibility != 0) TrackingChecklistStepVisibility.fromValue(bb.get(tableOffset + __offset_visibility).toUByte()) else null,
              optional = if (__offset_optional != 0) bb.get(tableOffset + __offset_optional) != 0.toByte() else null,
              ignorable = if (__offset_ignorable != 0) bb.get(tableOffset + __offset_ignorable) != 0.toByte() else null,
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
  public val stepId: TrackingChecklistStepId? = null,
  public val ignore: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (stepId != null) { builder.forceDefaults(true); builder.addByte(0, stepId.value.toByte(), 0); builder.forceDefaults(false) }
    if (ignore != null) { builder.forceDefaults(true); builder.addBoolean(1, ignore, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): IgnoreTrackingChecklistStepRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_stepId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_ignore = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return IgnoreTrackingChecklistStepRequest(
              stepId = if (__offset_stepId != 0) TrackingChecklistStepId.fromValue(bb.get(tableOffset + __offset_stepId).toUByte()) else null,
              ignore = if (__offset_ignore != 0) bb.get(tableOffset + __offset_ignore) != 0.toByte() else null
          )
    }
  }
}

public data class EnableStayAlignedRequest(
  public val enable: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (enable != null) { builder.forceDefaults(true); builder.addBoolean(0, enable, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): EnableStayAlignedRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enable = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return EnableStayAlignedRequest(
              enable = if (__offset_enable != 0) bb.get(tableOffset + __offset_enable) != 0.toByte() else null
          )
    }
  }
}

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

public class StartUserHeightCalibration : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StartUserHeightCalibration = StartUserHeightCalibration()
  }
}

public class CancelUserHeightCalibration : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): CancelUserHeightCalibration = CancelUserHeightCalibration()
  }
}

public enum class UserHeightCalibrationStatus(
  public val `value`: UByte,
) {
  NONE(0.toUByte()),
  RECORDING_FLOOR(1.toUByte()),
  WAITING_FOR_CONTROLLER_PITCH(2.toUByte()),
  WAITING_FOR_RISE(3.toUByte()),
  WAITING_FOR_FW_LOOK(4.toUByte()),
  RECORDING_HEIGHT(5.toUByte()),
  DONE(6.toUByte()),
  ERROR_TOO_HIGH(7.toUByte()),
  ERROR_TOO_SMALL(8.toUByte()),
  ERROR_TIMEOUT(9.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): UserHeightCalibrationStatus? = entries.firstOrNull { it.value == value }
  }
}

public data class UserHeightRecordingStatusResponse(
  public val hmdheight: Float? = null,
  public val status: UserHeightCalibrationStatus? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (hmdheight != null) { builder.forceDefaults(true); builder.addFloat(0, hmdheight, 0.0); builder.forceDefaults(false) }
    if (status != null) { builder.forceDefaults(true); builder.addByte(1, status.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): UserHeightRecordingStatusResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_hmdheight = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_status = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return UserHeightRecordingStatusResponse(
              hmdheight = if (__offset_hmdheight != 0) bb.getFloat(tableOffset + __offset_hmdheight) else null,
              status = if (__offset_status != 0) UserHeightCalibrationStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) else null
          )
    }
  }
}
