package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Boolean
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.collections.List
import solarxr_protocol.datatypes.BodyPart
import solarxr_protocol.datatypes.TransactionId
import solarxr_protocol.datatypes.math.Quat
import solarxr_protocol.rpc.settings.FilteringSettings
import solarxr_protocol.rpc.settings.LegTweaksSettings
import solarxr_protocol.rpc.settings.ModelRatios
import solarxr_protocol.rpc.settings.ModelToggles
import solarxr_protocol.rpc.settings.SkeletonHeight

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
      6 -> OutputTrackersSettingsRequest.decode(bb, offset)
      7 -> OutputTrackersSettingsResponse.decode(bb, offset)
      8 -> ChangeOutputTrackersSettingsRequest.decode(bb, offset)
      9 -> VMCOSCSettingsRequest.decode(bb, offset)
      10 -> VMCOSCSettingsResponse.decode(bb, offset)
      11 -> ChangeVMCOSCSettingsRequest.decode(bb, offset)
      12 -> VRMSettingsRequest.decode(bb, offset)
      13 -> VRMSettingsResponse.decode(bb, offset)
      14 -> ChangeVRMSettingsRequest.decode(bb, offset)
      15 -> ModelSettingsRequest.decode(bb, offset)
      16 -> ModelSettingsResponse.decode(bb, offset)
      17 -> ChangeModelSettingsRequest.decode(bb, offset)
      18 -> TapDetectionSettingsRequest.decode(bb, offset)
      19 -> TapDetectionSettingsResponse.decode(bb, offset)
      20 -> ChangeTapDetectionSettingsRequest.decode(bb, offset)
      21 -> ResetsSettingsRequest.decode(bb, offset)
      22 -> ResetsSettingsResponse.decode(bb, offset)
      23 -> ChangeResetsSettingsRequest.decode(bb, offset)
      24 -> StayAlignedSettingsRequest.decode(bb, offset)
      25 -> StayAlignedSettingsResponse.decode(bb, offset)
      26 -> ChangeStayAlignedSettingsRequest.decode(bb, offset)
      27 -> HIDSettingsRequest.decode(bb, offset)
      28 -> HIDSettingsResponse.decode(bb, offset)
      29 -> ChangeHIDSettingsRequest.decode(bb, offset)
      30 -> RecordBVHRequest.decode(bb, offset)
      31 -> RecordBVHStatus.decode(bb, offset)
      32 -> SkeletonConfigRequest.decode(bb, offset)
      33 -> ChangeSkeletonConfigRequest.decode(bb, offset)
      34 -> SkeletonResetAllRequest.decode(bb, offset)
      35 -> SkeletonConfigResponse.decode(bb, offset)
      36 -> OpenSerialRequest.decode(bb, offset)
      37 -> CloseSerialRequest.decode(bb, offset)
      38 -> SerialUpdateResponse.decode(bb, offset)
      39 -> AutoBoneProcessRequest.decode(bb, offset)
      40 -> AutoBoneProcessStatusResponse.decode(bb, offset)
      41 -> AutoBoneEpochResponse.decode(bb, offset)
      42 -> OverlayDisplayModeRequest.decode(bb, offset)
      43 -> OverlayDisplayModeChangeRequest.decode(bb, offset)
      44 -> OverlayDisplayModeResponse.decode(bb, offset)
      45 -> SerialTrackerRebootRequest.decode(bb, offset)
      46 -> SerialTrackerGetInfoRequest.decode(bb, offset)
      47 -> SerialTrackerFactoryResetRequest.decode(bb, offset)
      48 -> SerialDevicesRequest.decode(bb, offset)
      49 -> SerialDevicesResponse.decode(bb, offset)
      50 -> NewSerialDeviceResponse.decode(bb, offset)
      51 -> StartWifiProvisioningRequest.decode(bb, offset)
      52 -> StopWifiProvisioningRequest.decode(bb, offset)
      53 -> WifiProvisioningStatusResponse.decode(bb, offset)
      54 -> ServerInfosRequest.decode(bb, offset)
      55 -> ServerInfosResponse.decode(bb, offset)
      56 -> LegTweaksTmpChange.decode(bb, offset)
      57 -> LegTweaksTmpClear.decode(bb, offset)
      58 -> TapDetectionSetupNotification.decode(bb, offset)
      59 -> SetPauseTrackingRequest.decode(bb, offset)
      60 -> ClearMountingResetRequest.decode(bb, offset)
      61 -> AutoBoneApplyRequest.decode(bb, offset)
      62 -> AutoBoneStopRecordingRequest.decode(bb, offset)
      63 -> AutoBoneCancelRecordingRequest.decode(bb, offset)
      64 -> SaveFileNotification.decode(bb, offset)
      65 -> TrackingPauseStateRequest.decode(bb, offset)
      66 -> TrackingPauseStateResponse.decode(bb, offset)
      67 -> SerialTrackerGetWifiScanRequest.decode(bb, offset)
      68 -> UnknownDeviceHandshakeNotification.decode(bb, offset)
      69 -> AddUnknownDeviceRequest.decode(bb, offset)
      70 -> ForgetDeviceRequest.decode(bb, offset)
      71 -> FirmwareUpdateRequest.decode(bb, offset)
      72 -> FirmwareUpdateStatusResponse.decode(bb, offset)
      73 -> FirmwareUpdateStopQueuesRequest.decode(bb, offset)
      74 -> SettingsResetRequest.decode(bb, offset)
      75 -> MagToggleRequest.decode(bb, offset)
      76 -> MagToggleResponse.decode(bb, offset)
      77 -> ChangeMagToggleRequest.decode(bb, offset)
      78 -> RecordBVHStatusRequest.decode(bb, offset)
      79 -> VRCConfigStateRequest.decode(bb, offset)
      80 -> VRCConfigStateChangeResponse.decode(bb, offset)
      81 -> EnableStayAlignedRequest.decode(bb, offset)
      82 -> DetectStayAlignedRelaxedPoseRequest.decode(bb, offset)
      83 -> ResetStayAlignedRelaxedPoseRequest.decode(bb, offset)
      84 -> SerialTrackerCustomCommandRequest.decode(bb, offset)
      85 -> VRCConfigSettingToggleMute.decode(bb, offset)
      86 -> TrackingChecklistRequest.decode(bb, offset)
      87 -> TrackingChecklistResponse.decode(bb, offset)
      88 -> IgnoreTrackingChecklistStepRequest.decode(bb, offset)
      89 -> StartUserHeightCalibration.decode(bb, offset)
      90 -> CancelUserHeightCalibration.decode(bb, offset)
      91 -> UserHeightRecordingStatusResponse.decode(bb, offset)
      92 -> VRCOSCSettingsRequest.decode(bb, offset)
      93 -> VRCOSCSettingsResponse.decode(bb, offset)
      94 -> ChangeVRCOSCSettingsRequest.decode(bb, offset)
      95 -> VRCOSCStatusRequest.decode(bb, offset)
      96 -> VRCOSCStatusChangeResponse.decode(bb, offset)
      97 -> KeybindRequest.decode(bb, offset)
      98 -> ChangeKeybindRequest.decode(bb, offset)
      99 -> KeybindResponse.decode(bb, offset)
      100 -> InstalledInfoRequest.decode(bb, offset)
      101 -> InstalledInfoResponse.decode(bb, offset)
      102 -> OpenUriRequest.decode(bb, offset)
      103 -> OpenUriResponse.decode(bb, offset)
      104 -> EnableSteamVRDriverRequest.decode(bb, offset)
      else -> null
    }

    public fun typeIndex(`value`: RpcMessage): Byte = when (value) {
      is HeartbeatRequest -> 1
      is HeartbeatResponse -> 2
      is ResetRequest -> 3
      is ResetResponse -> 4
      is AssignTrackerRequest -> 5
      is OutputTrackersSettingsRequest -> 6
      is OutputTrackersSettingsResponse -> 7
      is ChangeOutputTrackersSettingsRequest -> 8
      is VMCOSCSettingsRequest -> 9
      is VMCOSCSettingsResponse -> 10
      is ChangeVMCOSCSettingsRequest -> 11
      is VRMSettingsRequest -> 12
      is VRMSettingsResponse -> 13
      is ChangeVRMSettingsRequest -> 14
      is ModelSettingsRequest -> 15
      is ModelSettingsResponse -> 16
      is ChangeModelSettingsRequest -> 17
      is TapDetectionSettingsRequest -> 18
      is TapDetectionSettingsResponse -> 19
      is ChangeTapDetectionSettingsRequest -> 20
      is ResetsSettingsRequest -> 21
      is ResetsSettingsResponse -> 22
      is ChangeResetsSettingsRequest -> 23
      is StayAlignedSettingsRequest -> 24
      is StayAlignedSettingsResponse -> 25
      is ChangeStayAlignedSettingsRequest -> 26
      is HIDSettingsRequest -> 27
      is HIDSettingsResponse -> 28
      is ChangeHIDSettingsRequest -> 29
      is RecordBVHRequest -> 30
      is RecordBVHStatus -> 31
      is SkeletonConfigRequest -> 32
      is ChangeSkeletonConfigRequest -> 33
      is SkeletonResetAllRequest -> 34
      is SkeletonConfigResponse -> 35
      is OpenSerialRequest -> 36
      is CloseSerialRequest -> 37
      is SerialUpdateResponse -> 38
      is AutoBoneProcessRequest -> 39
      is AutoBoneProcessStatusResponse -> 40
      is AutoBoneEpochResponse -> 41
      is OverlayDisplayModeRequest -> 42
      is OverlayDisplayModeChangeRequest -> 43
      is OverlayDisplayModeResponse -> 44
      is SerialTrackerRebootRequest -> 45
      is SerialTrackerGetInfoRequest -> 46
      is SerialTrackerFactoryResetRequest -> 47
      is SerialDevicesRequest -> 48
      is SerialDevicesResponse -> 49
      is NewSerialDeviceResponse -> 50
      is StartWifiProvisioningRequest -> 51
      is StopWifiProvisioningRequest -> 52
      is WifiProvisioningStatusResponse -> 53
      is ServerInfosRequest -> 54
      is ServerInfosResponse -> 55
      is LegTweaksTmpChange -> 56
      is LegTweaksTmpClear -> 57
      is TapDetectionSetupNotification -> 58
      is SetPauseTrackingRequest -> 59
      is ClearMountingResetRequest -> 60
      is AutoBoneApplyRequest -> 61
      is AutoBoneStopRecordingRequest -> 62
      is AutoBoneCancelRecordingRequest -> 63
      is SaveFileNotification -> 64
      is TrackingPauseStateRequest -> 65
      is TrackingPauseStateResponse -> 66
      is SerialTrackerGetWifiScanRequest -> 67
      is UnknownDeviceHandshakeNotification -> 68
      is AddUnknownDeviceRequest -> 69
      is ForgetDeviceRequest -> 70
      is FirmwareUpdateRequest -> 71
      is FirmwareUpdateStatusResponse -> 72
      is FirmwareUpdateStopQueuesRequest -> 73
      is SettingsResetRequest -> 74
      is MagToggleRequest -> 75
      is MagToggleResponse -> 76
      is ChangeMagToggleRequest -> 77
      is RecordBVHStatusRequest -> 78
      is VRCConfigStateRequest -> 79
      is VRCConfigStateChangeResponse -> 80
      is EnableStayAlignedRequest -> 81
      is DetectStayAlignedRelaxedPoseRequest -> 82
      is ResetStayAlignedRelaxedPoseRequest -> 83
      is SerialTrackerCustomCommandRequest -> 84
      is VRCConfigSettingToggleMute -> 85
      is TrackingChecklistRequest -> 86
      is TrackingChecklistResponse -> 87
      is IgnoreTrackingChecklistStepRequest -> 88
      is StartUserHeightCalibration -> 89
      is CancelUserHeightCalibration -> 90
      is UserHeightRecordingStatusResponse -> 91
      is VRCOSCSettingsRequest -> 92
      is VRCOSCSettingsResponse -> 93
      is ChangeVRCOSCSettingsRequest -> 94
      is VRCOSCStatusRequest -> 95
      is VRCOSCStatusChangeResponse -> 96
      is KeybindRequest -> 97
      is ChangeKeybindRequest -> 98
      is KeybindResponse -> 99
      is InstalledInfoRequest -> 100
      is InstalledInfoResponse -> 101
      is OpenUriRequest -> 102
      is OpenUriResponse -> 103
      is EnableSteamVRDriverRequest -> 104
    }

    public fun encode(`value`: RpcMessage, builder: FlatBufferWriter): Int = when (value) {
      is HeartbeatRequest -> value.encode(builder)
      is HeartbeatResponse -> value.encode(builder)
      is ResetRequest -> value.encode(builder)
      is ResetResponse -> value.encode(builder)
      is AssignTrackerRequest -> value.encode(builder)
      is OutputTrackersSettingsRequest -> value.encode(builder)
      is OutputTrackersSettingsResponse -> value.encode(builder)
      is ChangeOutputTrackersSettingsRequest -> value.encode(builder)
      is VMCOSCSettingsRequest -> value.encode(builder)
      is VMCOSCSettingsResponse -> value.encode(builder)
      is ChangeVMCOSCSettingsRequest -> value.encode(builder)
      is VRMSettingsRequest -> value.encode(builder)
      is VRMSettingsResponse -> value.encode(builder)
      is ChangeVRMSettingsRequest -> value.encode(builder)
      is ModelSettingsRequest -> value.encode(builder)
      is ModelSettingsResponse -> value.encode(builder)
      is ChangeModelSettingsRequest -> value.encode(builder)
      is TapDetectionSettingsRequest -> value.encode(builder)
      is TapDetectionSettingsResponse -> value.encode(builder)
      is ChangeTapDetectionSettingsRequest -> value.encode(builder)
      is ResetsSettingsRequest -> value.encode(builder)
      is ResetsSettingsResponse -> value.encode(builder)
      is ChangeResetsSettingsRequest -> value.encode(builder)
      is StayAlignedSettingsRequest -> value.encode(builder)
      is StayAlignedSettingsResponse -> value.encode(builder)
      is ChangeStayAlignedSettingsRequest -> value.encode(builder)
      is HIDSettingsRequest -> value.encode(builder)
      is HIDSettingsResponse -> value.encode(builder)
      is ChangeHIDSettingsRequest -> value.encode(builder)
      is RecordBVHRequest -> value.encode(builder)
      is RecordBVHStatus -> value.encode(builder)
      is SkeletonConfigRequest -> value.encode(builder)
      is ChangeSkeletonConfigRequest -> value.encode(builder)
      is SkeletonResetAllRequest -> value.encode(builder)
      is SkeletonConfigResponse -> value.encode(builder)
      is OpenSerialRequest -> value.encode(builder)
      is CloseSerialRequest -> value.encode(builder)
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
      is ClearMountingResetRequest -> value.encode(builder)
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

/**
 * Requests specified keybind eg. FULL_RESET -> KeybindResponse sends the keybind back to gui
 */
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

/**
 * Returns keybinds for displaying in gui
 */
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
  public val isUdevInstalled: Boolean? = null,
  public val isWayland: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (isUdevInstalled != null) { builder.forceDefaults(true); builder.addBoolean(0, isUdevInstalled, false); builder.forceDefaults(false) }
    if (isWayland != null) { builder.forceDefaults(true); builder.addBoolean(1, isWayland, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): InstalledInfoResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_isUdevInstalled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_isWayland = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return InstalledInfoResponse(
              isUdevInstalled = if (__offset_isUdevInstalled != 0) bb.get(tableOffset + __offset_isUdevInstalled) != 0.toByte() else null,
              isWayland = if (__offset_isWayland != 0) bb.get(tableOffset + __offset_isWayland) != 0.toByte() else null
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

public data class AssignTrackerRequest(
  public val trackerId: UShort? = null,
  public val bodyPosition: BodyPart? = null,
  public val mountingOrientation: Quat? = null,
  public val displayName: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_displayName = displayName?.let { builder.createString(it) }

    builder.startTable(4)
    if (trackerId != null) { builder.forceDefaults(true); builder.addShort(0, trackerId.toShort(), 0); builder.forceDefaults(false) }
    if (bodyPosition != null) { builder.forceDefaults(true); builder.addByte(1, bodyPosition.value.toByte(), 0); builder.forceDefaults(false) }
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
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else null,
              bodyPosition = if (__offset_bodyPosition != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_bodyPosition).toUByte()) else null,
              mountingOrientation = if (__offset_mountingOrientation != 0) Quat.decode(bb, tableOffset + __offset_mountingOrientation) else null,
              displayName = if (__offset_displayName != 0) readFlatBufferString(bb, tableOffset + __offset_displayName) else null
          )
    }
  }
}

public class OutputTrackersSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OutputTrackersSettingsRequest = OutputTrackersSettingsRequest()
  }
}

public data class OutputTrackersSettingsResponse(
  public val automaticTrackerToggle: Boolean? = null,
  public val trackers: List<BodyPart>? = null,
  public val sendDerivedVelocity: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackers = trackers?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }

    builder.startTable(3)
    if (automaticTrackerToggle != null) { builder.forceDefaults(true); builder.addBoolean(0, automaticTrackerToggle, false); builder.forceDefaults(false) }
    __off_trackers?.let { builder.addOffset(1, it, 0) }
    if (sendDerivedVelocity != null) { builder.forceDefaults(true); builder.addBoolean(2, sendDerivedVelocity, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OutputTrackersSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_automaticTrackerToggle = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_trackers = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_sendDerivedVelocity = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return OutputTrackersSettingsResponse(
              automaticTrackerToggle = if (__offset_automaticTrackerToggle != 0) bb.get(tableOffset + __offset_automaticTrackerToggle) != 0.toByte() else null,
              trackers = if (__offset_trackers != 0) { val vecOff = tableOffset + __offset_trackers + bb.getInt(tableOffset + __offset_trackers); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> BodyPart.fromValue(bb.get(vecOff + 4 + i * 1).toUByte()) } } else null,
              sendDerivedVelocity = if (__offset_sendDerivedVelocity != 0) bb.get(tableOffset + __offset_sendDerivedVelocity) != 0.toByte() else null
          )
    }
  }
}

public data class ChangeOutputTrackersSettingsRequest(
  public val automaticTrackerToggle: Boolean? = null,
  public val trackers: List<BodyPart>? = null,
  public val sendDerivedVelocity: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackers = trackers?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }

    builder.startTable(3)
    if (automaticTrackerToggle != null) { builder.forceDefaults(true); builder.addBoolean(0, automaticTrackerToggle, false); builder.forceDefaults(false) }
    __off_trackers?.let { builder.addOffset(1, it, 0) }
    if (sendDerivedVelocity != null) { builder.forceDefaults(true); builder.addBoolean(2, sendDerivedVelocity, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeOutputTrackersSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_automaticTrackerToggle = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_trackers = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_sendDerivedVelocity = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return ChangeOutputTrackersSettingsRequest(
              automaticTrackerToggle = if (__offset_automaticTrackerToggle != 0) bb.get(tableOffset + __offset_automaticTrackerToggle) != 0.toByte() else null,
              trackers = if (__offset_trackers != 0) { val vecOff = tableOffset + __offset_trackers + bb.getInt(tableOffset + __offset_trackers); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> BodyPart.fromValue(bb.get(vecOff + 4 + i * 1).toUByte()) } } else null,
              sendDerivedVelocity = if (__offset_sendDerivedVelocity != 0) bb.get(tableOffset + __offset_sendDerivedVelocity) != 0.toByte() else null
          )
    }
  }
}

public class VMCOSCSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VMCOSCSettingsRequest = VMCOSCSettingsRequest()
  }
}

public data class VMCOSCSettingsResponse(
  public val enabled: Boolean? = null,
  public val portIn: UShort? = null,
  public val portOut: UShort? = null,
  public val address: String? = null,
  public val anchorHip: Boolean? = null,
  public val mirrorTracking: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_address = address?.let { builder.createString(it) }

    builder.startTable(6)
    if (enabled != null) { builder.forceDefaults(true); builder.addBoolean(0, enabled, false); builder.forceDefaults(false) }
    if (portIn != null) { builder.forceDefaults(true); builder.addShort(1, portIn.toShort(), 0); builder.forceDefaults(false) }
    if (portOut != null) { builder.forceDefaults(true); builder.addShort(2, portOut.toShort(), 0); builder.forceDefaults(false) }
    __off_address?.let { builder.addOffset(3, it, 0) }
    if (anchorHip != null) { builder.forceDefaults(true); builder.addBoolean(4, anchorHip, false); builder.forceDefaults(false) }
    if (mirrorTracking != null) { builder.forceDefaults(true); builder.addBoolean(5, mirrorTracking, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VMCOSCSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_portIn = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_portOut = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_address = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_anchorHip = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_mirrorTracking = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0

      return VMCOSCSettingsResponse(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else null,
              portIn = if (__offset_portIn != 0) bb.getShort(tableOffset + __offset_portIn).toUShort() else null,
              portOut = if (__offset_portOut != 0) bb.getShort(tableOffset + __offset_portOut).toUShort() else null,
              address = if (__offset_address != 0) readFlatBufferString(bb, tableOffset + __offset_address) else null,
              anchorHip = if (__offset_anchorHip != 0) bb.get(tableOffset + __offset_anchorHip) != 0.toByte() else null,
              mirrorTracking = if (__offset_mirrorTracking != 0) bb.get(tableOffset + __offset_mirrorTracking) != 0.toByte() else null
          )
    }
  }
}

public data class ChangeVMCOSCSettingsRequest(
  public val enabled: Boolean? = null,
  public val portIn: UShort? = null,
  public val portOut: UShort? = null,
  public val address: String? = null,
  public val anchorHip: Boolean? = null,
  public val mirrorTracking: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_address = address?.let { builder.createString(it) }

    builder.startTable(6)
    if (enabled != null) { builder.forceDefaults(true); builder.addBoolean(0, enabled, false); builder.forceDefaults(false) }
    if (portIn != null) { builder.forceDefaults(true); builder.addShort(1, portIn.toShort(), 0); builder.forceDefaults(false) }
    if (portOut != null) { builder.forceDefaults(true); builder.addShort(2, portOut.toShort(), 0); builder.forceDefaults(false) }
    __off_address?.let { builder.addOffset(3, it, 0) }
    if (anchorHip != null) { builder.forceDefaults(true); builder.addBoolean(4, anchorHip, false); builder.forceDefaults(false) }
    if (mirrorTracking != null) { builder.forceDefaults(true); builder.addBoolean(5, mirrorTracking, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeVMCOSCSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_portIn = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_portOut = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_address = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_anchorHip = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_mirrorTracking = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0

      return ChangeVMCOSCSettingsRequest(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else null,
              portIn = if (__offset_portIn != 0) bb.getShort(tableOffset + __offset_portIn).toUShort() else null,
              portOut = if (__offset_portOut != 0) bb.getShort(tableOffset + __offset_portOut).toUShort() else null,
              address = if (__offset_address != 0) readFlatBufferString(bb, tableOffset + __offset_address) else null,
              anchorHip = if (__offset_anchorHip != 0) bb.get(tableOffset + __offset_anchorHip) != 0.toByte() else null,
              mirrorTracking = if (__offset_mirrorTracking != 0) bb.get(tableOffset + __offset_mirrorTracking) != 0.toByte() else null
          )
    }
  }
}

public class VRMSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VRMSettingsRequest = VRMSettingsRequest()
  }
}

public data class VRMSettingsResponse(
  public val vrmJson: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_vrmJson = vrmJson?.let { builder.createString(it) }

    builder.startTable(1)
    __off_vrmJson?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VRMSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_vrmJson = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return VRMSettingsResponse(
              vrmJson = if (__offset_vrmJson != 0) readFlatBufferString(bb, tableOffset + __offset_vrmJson) else null
          )
    }
  }
}

public data class ChangeVRMSettingsRequest(
  public val vrmJson: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_vrmJson = vrmJson?.let { builder.createString(it) }

    builder.startTable(1)
    __off_vrmJson?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeVRMSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_vrmJson = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ChangeVRMSettingsRequest(
              vrmJson = if (__offset_vrmJson != 0) readFlatBufferString(bb, tableOffset + __offset_vrmJson) else null
          )
    }
  }
}

public class ModelSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ModelSettingsRequest = ModelSettingsRequest()
  }
}

public data class ModelSettingsResponse(
  public val toggles: ModelToggles? = null,
  public val ratios: ModelRatios? = null,
  public val legTweaks: LegTweaksSettings? = null,
  public val skeletonHeight: SkeletonHeight? = null,
  public val filtering: FilteringSettings? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_toggles = toggles?.encode(builder)
    val __off_ratios = ratios?.encode(builder)
    val __off_legTweaks = legTweaks?.encode(builder)
    val __off_skeletonHeight = skeletonHeight?.encode(builder)
    val __off_filtering = filtering?.encode(builder)

    builder.startTable(5)
    __off_toggles?.let { builder.addOffset(0, it, 0) }
    __off_ratios?.let { builder.addOffset(1, it, 0) }
    __off_legTweaks?.let { builder.addOffset(2, it, 0) }
    __off_skeletonHeight?.let { builder.addOffset(3, it, 0) }
    __off_filtering?.let { builder.addOffset(4, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ModelSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_toggles = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_ratios = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_legTweaks = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_skeletonHeight = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_filtering = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return ModelSettingsResponse(
              toggles = if (__offset_toggles != 0) ModelToggles.decode(bb, tableOffset + __offset_toggles + bb.getInt(tableOffset + __offset_toggles)) else null,
              ratios = if (__offset_ratios != 0) ModelRatios.decode(bb, tableOffset + __offset_ratios + bb.getInt(tableOffset + __offset_ratios)) else null,
              legTweaks = if (__offset_legTweaks != 0) LegTweaksSettings.decode(bb, tableOffset + __offset_legTweaks + bb.getInt(tableOffset + __offset_legTweaks)) else null,
              skeletonHeight = if (__offset_skeletonHeight != 0) SkeletonHeight.decode(bb, tableOffset + __offset_skeletonHeight + bb.getInt(tableOffset + __offset_skeletonHeight)) else null,
              filtering = if (__offset_filtering != 0) FilteringSettings.decode(bb, tableOffset + __offset_filtering + bb.getInt(tableOffset + __offset_filtering)) else null
          )
    }
  }
}

public data class ChangeModelSettingsRequest(
  public val toggles: ModelToggles? = null,
  public val ratios: ModelRatios? = null,
  public val legTweaks: LegTweaksSettings? = null,
  public val skeletonHeight: SkeletonHeight? = null,
  public val filtering: FilteringSettings? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_toggles = toggles?.encode(builder)
    val __off_ratios = ratios?.encode(builder)
    val __off_legTweaks = legTweaks?.encode(builder)
    val __off_skeletonHeight = skeletonHeight?.encode(builder)
    val __off_filtering = filtering?.encode(builder)

    builder.startTable(5)
    __off_toggles?.let { builder.addOffset(0, it, 0) }
    __off_ratios?.let { builder.addOffset(1, it, 0) }
    __off_legTweaks?.let { builder.addOffset(2, it, 0) }
    __off_skeletonHeight?.let { builder.addOffset(3, it, 0) }
    __off_filtering?.let { builder.addOffset(4, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeModelSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_toggles = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_ratios = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_legTweaks = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_skeletonHeight = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_filtering = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return ChangeModelSettingsRequest(
              toggles = if (__offset_toggles != 0) ModelToggles.decode(bb, tableOffset + __offset_toggles + bb.getInt(tableOffset + __offset_toggles)) else null,
              ratios = if (__offset_ratios != 0) ModelRatios.decode(bb, tableOffset + __offset_ratios + bb.getInt(tableOffset + __offset_ratios)) else null,
              legTweaks = if (__offset_legTweaks != 0) LegTweaksSettings.decode(bb, tableOffset + __offset_legTweaks + bb.getInt(tableOffset + __offset_legTweaks)) else null,
              skeletonHeight = if (__offset_skeletonHeight != 0) SkeletonHeight.decode(bb, tableOffset + __offset_skeletonHeight + bb.getInt(tableOffset + __offset_skeletonHeight)) else null,
              filtering = if (__offset_filtering != 0) FilteringSettings.decode(bb, tableOffset + __offset_filtering + bb.getInt(tableOffset + __offset_filtering)) else null
          )
    }
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
  public val setupMode: Boolean? = null,
  public val numberTrackersOverThreshold: UByte? = null,
  public val yawResetTracker: BodyPart? = null,
  public val fullResetTracker: BodyPart? = null,
  public val mountingResetTracker: BodyPart? = null,
) : RpcMessage {
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
      val __offset_setupMode = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_numberTrackersOverThreshold = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_yawResetTracker = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0
      val __offset_fullResetTracker = if (vtableSize > 28) bb.getShort(vtableOffset + 28).toInt() else 0
      val __offset_mountingResetTracker = if (vtableSize > 30) bb.getShort(vtableOffset + 30).toInt() else 0

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
              setupMode = if (__offset_setupMode != 0) bb.get(tableOffset + __offset_setupMode) != 0.toByte() else null,
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
  public val setupMode: Boolean? = null,
  public val numberTrackersOverThreshold: UByte? = null,
  public val yawResetTracker: BodyPart? = null,
  public val fullResetTracker: BodyPart? = null,
  public val mountingResetTracker: BodyPart? = null,
) : RpcMessage {
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
      val __offset_setupMode = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_numberTrackersOverThreshold = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_yawResetTracker = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0
      val __offset_fullResetTracker = if (vtableSize > 28) bb.getShort(vtableOffset + 28).toInt() else 0
      val __offset_mountingResetTracker = if (vtableSize > 30) bb.getShort(vtableOffset + 30).toInt() else 0

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
  public val enabled: Boolean? = null,
  public val hideYawCorrection: Boolean? = null,
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
  public val setupComplete: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(15)
    if (enabled != null) { builder.forceDefaults(true); builder.addBoolean(0, enabled, false); builder.forceDefaults(false) }
    if (hideYawCorrection != null) { builder.forceDefaults(true); builder.addBoolean(1, hideYawCorrection, false); builder.forceDefaults(false) }
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
    if (setupComplete != null) { builder.forceDefaults(true); builder.addBoolean(14, setupComplete, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StayAlignedSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_hideYawCorrection = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
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
      val __offset_setupComplete = if (vtableSize > 32) bb.getShort(vtableOffset + 32).toInt() else 0

      return StayAlignedSettingsResponse(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else null,
              hideYawCorrection = if (__offset_hideYawCorrection != 0) bb.get(tableOffset + __offset_hideYawCorrection) != 0.toByte() else null,
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
              flatFootAngle = if (__offset_flatFootAngle != 0) bb.getFloat(tableOffset + __offset_flatFootAngle) else null,
              setupComplete = if (__offset_setupComplete != 0) bb.get(tableOffset + __offset_setupComplete) != 0.toByte() else null
          )
    }
  }
}

public data class ChangeStayAlignedSettingsRequest(
  public val enabled: Boolean? = null,
  public val hideYawCorrection: Boolean? = null,
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
  public val setupComplete: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(15)
    if (enabled != null) { builder.forceDefaults(true); builder.addBoolean(0, enabled, false); builder.forceDefaults(false) }
    if (hideYawCorrection != null) { builder.forceDefaults(true); builder.addBoolean(1, hideYawCorrection, false); builder.forceDefaults(false) }
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
    if (setupComplete != null) { builder.forceDefaults(true); builder.addBoolean(14, setupComplete, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeStayAlignedSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_hideYawCorrection = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
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
      val __offset_setupComplete = if (vtableSize > 32) bb.getShort(vtableOffset + 32).toInt() else 0

      return ChangeStayAlignedSettingsRequest(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else null,
              hideYawCorrection = if (__offset_hideYawCorrection != 0) bb.get(tableOffset + __offset_hideYawCorrection) != 0.toByte() else null,
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
              flatFootAngle = if (__offset_flatFootAngle != 0) bb.getFloat(tableOffset + __offset_flatFootAngle) else null,
              setupComplete = if (__offset_setupComplete != 0) bb.get(tableOffset + __offset_setupComplete) != 0.toByte() else null
          )
    }
  }
}

public class HIDSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): HIDSettingsRequest = HIDSettingsRequest()
  }
}

public data class HIDSettingsResponse(
  public val trackersOverHid: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (trackersOverHid != null) { builder.forceDefaults(true); builder.addBoolean(0, trackersOverHid, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): HIDSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackersOverHid = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return HIDSettingsResponse(
              trackersOverHid = if (__offset_trackersOverHid != 0) bb.get(tableOffset + __offset_trackersOverHid) != 0.toByte() else null
          )
    }
  }
}

public data class ChangeHIDSettingsRequest(
  public val trackersOverHid: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (trackersOverHid != null) { builder.forceDefaults(true); builder.addBoolean(0, trackersOverHid, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeHIDSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackersOverHid = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ChangeHIDSettingsRequest(
              trackersOverHid = if (__offset_trackersOverHid != 0) bb.get(tableOffset + __offset_trackersOverHid) != 0.toByte() else null
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
  public val enabled: Boolean? = null,
  public val manualNetwork: VRCOSCNetworkSettings? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_manualNetwork = manualNetwork?.encode(builder)

    builder.startTable(2)
    if (enabled != null) { builder.forceDefaults(true); builder.addBoolean(0, enabled, false); builder.forceDefaults(false) }
    __off_manualNetwork?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VRCOSCSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_manualNetwork = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return VRCOSCSettingsResponse(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else null,
              manualNetwork = if (__offset_manualNetwork != 0) VRCOSCNetworkSettings.decode(bb, tableOffset + __offset_manualNetwork + bb.getInt(tableOffset + __offset_manualNetwork)) else null
          )
    }
  }
}

public data class ChangeVRCOSCSettingsRequest(
  public val enabled: Boolean? = null,
  public val manualNetwork: VRCOSCNetworkSettings? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_manualNetwork = manualNetwork?.encode(builder)

    builder.startTable(2)
    if (enabled != null) { builder.forceDefaults(true); builder.addBoolean(0, enabled, false); builder.forceDefaults(false) }
    __off_manualNetwork?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeVRCOSCSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_manualNetwork = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return ChangeVRCOSCSettingsRequest(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else null,
              manualNetwork = if (__offset_manualNetwork != 0) VRCOSCNetworkSettings.decode(bb, tableOffset + __offset_manualNetwork + bb.getInt(tableOffset + __offset_manualNetwork)) else null
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
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_inputError = inputError?.let { builder.createString(it) }
    val __off_outputError = outputError?.let { builder.createString(it) }
    val __off_targetAddress = targetAddress?.let { builder.createString(it) }
    val __off_oscqueryError = oscqueryError?.let { builder.createString(it) }
    val __off_discoveredTargets = discoveredTargets?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(15)
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
              discoveredTargets = if (__offset_discoveredTargets != 0) { val vecOff = tableOffset + __offset_discoveredTargets + bb.getInt(tableOffset + __offset_discoveredTargets); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) VRCOSCDiscoveredTarget.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

/**
 * See TapDetectionSettingsResponse::setup_mode
 */
public data class TapDetectionSetupNotification(
  public val trackerId: UShort? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (trackerId != null) { builder.forceDefaults(true); builder.addShort(0, trackerId.toShort(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TapDetectionSetupNotification {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TapDetectionSetupNotification(
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else null
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
  public val current: UInt? = null,
  public val total: UInt? = null,
  public val completed: Boolean? = null,
  public val success: Boolean? = null,
  public val eta: Float? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(6)
    if (processType != null) { builder.forceDefaults(true); builder.addByte(0, processType.value.toByte(), 0); builder.forceDefaults(false) }
    if (current != null) { builder.forceDefaults(true); builder.addInt(1, current.toInt(), 0); builder.forceDefaults(false) }
    if (total != null) { builder.forceDefaults(true); builder.addInt(2, total.toInt(), 0); builder.forceDefaults(false) }
    if (completed != null) { builder.forceDefaults(true); builder.addBoolean(3, completed, false); builder.forceDefaults(false) }
    if (success != null) { builder.forceDefaults(true); builder.addBoolean(4, success, false); builder.forceDefaults(false) }
    if (eta != null) { builder.forceDefaults(true); builder.addFloat(5, eta, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): AutoBoneProcessStatusResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_processType = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_current = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_total = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_completed = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_success = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_eta = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0

      return AutoBoneProcessStatusResponse(
              processType = if (__offset_processType != 0) AutoBoneProcessType.fromValue(bb.get(tableOffset + __offset_processType).toUByte()) else null,
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
  public val localIp: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_localIp = localIp?.let { builder.createString(it) }

    builder.startTable(1)
    __off_localIp?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ServerInfosResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_localIp = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ServerInfosResponse(
              localIp = if (__offset_localIp != 0) readFlatBufferString(bb, tableOffset + __offset_localIp) else null
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

public data class SetPauseTrackingRequest(
  public val pauseTracking: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (pauseTracking != null) { builder.forceDefaults(true); builder.addBoolean(0, pauseTracking, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SetPauseTrackingRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_pauseTracking = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return SetPauseTrackingRequest(
              pauseTracking = if (__offset_pauseTracking != 0) bb.get(tableOffset + __offset_pauseTracking) != 0.toByte() else null
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
  DOCUMENTS(0.toUByte()),
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
  public val extension: String? = null,
  public val expectedDir: ComputerDirectory? = null,
  public val expectedFilename: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_data = data?.let { builder.createByteVector(it.map { b -> b.toByte() }.toByteArray()) }
    val __off_mimeType = mimeType?.let { builder.createString(it) }
    val __off_extension = extension?.let { builder.createString(it) }
    val __off_expectedFilename = expectedFilename?.let { builder.createString(it) }

    builder.startTable(5)
    __off_data?.let { builder.addOffset(0, it, 0) }
    __off_mimeType?.let { builder.addOffset(1, it, 0) }
    __off_extension?.let { builder.addOffset(2, it, 0) }
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
      val __offset_extension = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_expectedDir = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_expectedFilename = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return SaveFileNotification(
              data = if (__offset_data != 0) { val vecOff = tableOffset + __offset_data + bb.getInt(tableOffset + __offset_data); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> bb.get(vecOff + 4 + i * 1).toUByte() } } else null,
              mimeType = if (__offset_mimeType != 0) readFlatBufferString(bb, tableOffset + __offset_mimeType) else null,
              extension = if (__offset_extension != 0) readFlatBufferString(bb, tableOffset + __offset_extension) else null,
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
  /**
   * The update process completed with success
   */
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

public data class FirmwareDeviceIdTable(
  public val id: UShort? = null,
) : FirmwareUpdateDeviceId {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (id != null) { builder.forceDefaults(true); builder.addShort(0, id.toShort(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): FirmwareDeviceIdTable {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_id = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return FirmwareDeviceIdTable(
              id = if (__offset_id != 0) bb.getShort(tableOffset + __offset_id).toUShort() else null
          )
    }
  }
}

public sealed interface FirmwareUpdateDeviceId {
  public companion object {
    public fun decode(
      type: Byte,
      bb: FlatBufferReader,
      offset: Int,
    ): FirmwareUpdateDeviceId? = when (type.toInt()) {
      1 -> FirmwareDeviceIdTable.decode(bb, offset)
      2 -> SerialDevicePort.decode(bb, offset)
      else -> null
    }

    public fun typeIndex(`value`: FirmwareUpdateDeviceId): Byte = when (value) {
      is FirmwareDeviceIdTable -> 1
      is SerialDevicePort -> 2
    }

    public fun encode(`value`: FirmwareUpdateDeviceId, builder: FlatBufferWriter): Int = when (value) {
      is FirmwareDeviceIdTable -> value.encode(builder)
      is SerialDevicePort -> value.encode(builder)
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
  public val deviceId: UShort? = null,
  public val firmwarePart: FirmwarePart? = null,
) : FirmwareUpdateMethod {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_firmwarePart = firmwarePart?.encode(builder)

    builder.startTable(2)
    if (deviceId != null) { builder.forceDefaults(true); builder.addShort(0, deviceId.toShort(), 0); builder.forceDefaults(false) }
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
              deviceId = if (__offset_deviceId != 0) bb.getShort(tableOffset + __offset_deviceId).toUShort() else null,
              firmwarePart = if (__offset_firmwarePart != 0) FirmwarePart.decode(bb, tableOffset + __offset_firmwarePart + bb.getInt(tableOffset + __offset_firmwarePart)) else null
          )
    }
  }
}

public data class SerialFirmwareUpdate(
  public val deviceId: SerialDevicePort? = null,
  public val needManualReboot: Boolean? = null,
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
    if (needManualReboot != null) { builder.forceDefaults(true); builder.addBoolean(1, needManualReboot, false); builder.forceDefaults(false) }
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
      val __offset_needManualReboot = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_ssid = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_password = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_firmwarePart = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return SerialFirmwareUpdate(
              deviceId = if (__offset_deviceId != 0) SerialDevicePort.decode(bb, tableOffset + __offset_deviceId + bb.getInt(tableOffset + __offset_deviceId)) else null,
              needManualReboot = if (__offset_needManualReboot != 0) bb.get(tableOffset + __offset_needManualReboot) != 0.toByte() else null,
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
  public val trackingPaused: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (trackingPaused != null) { builder.forceDefaults(true); builder.addBoolean(0, trackingPaused, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackingPauseStateResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackingPaused = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TrackingPauseStateResponse(
              trackingPaused = if (__offset_trackingPaused != 0) bb.get(tableOffset + __offset_trackingPaused) != 0.toByte() else null
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
  public val trackerId: UShort? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (trackerId != null) { builder.forceDefaults(true); builder.addShort(0, trackerId.toShort(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): MagToggleRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return MagToggleRequest(
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else null
          )
    }
  }
}

/**
 * If no tracker ID is given, it's the setting for every tracker/device
 */
public data class MagToggleResponse(
  public val trackerId: UShort? = null,
  public val enable: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (trackerId != null) { builder.forceDefaults(true); builder.addShort(0, trackerId.toShort(), 0); builder.forceDefaults(false) }
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
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else null,
              enable = if (__offset_enable != 0) bb.get(tableOffset + __offset_enable) != 0.toByte() else null
          )
    }
  }
}

/**
 * If no tracker ID is given, it's the setting for every tracker/device
 */
public data class ChangeMagToggleRequest(
  public val trackerId: UShort? = null,
  public val enable: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (trackerId != null) { builder.forceDefaults(true); builder.addShort(0, trackerId.toShort(), 0); builder.forceDefaults(false) }
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
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else null,
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
  public val trackerId: UShort? = null,
) : TrackingChecklistExtraData {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (trackerId != null) { builder.forceDefaults(true); builder.addShort(0, trackerId.toShort(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackingChecklistUnassignedHMD {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TrackingChecklistUnassignedHMD(
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else null
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
  public val hmdHeight: Float? = null,
  public val status: UserHeightCalibrationStatus? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (hmdHeight != null) { builder.forceDefaults(true); builder.addFloat(0, hmdHeight, 0.0); builder.forceDefaults(false) }
    if (status != null) { builder.forceDefaults(true); builder.addByte(1, status.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): UserHeightRecordingStatusResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_hmdHeight = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_status = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return UserHeightRecordingStatusResponse(
              hmdHeight = if (__offset_hmdHeight != 0) bb.getFloat(tableOffset + __offset_hmdHeight) else null,
              status = if (__offset_status != 0) UserHeightCalibrationStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) else null
          )
    }
  }
}
