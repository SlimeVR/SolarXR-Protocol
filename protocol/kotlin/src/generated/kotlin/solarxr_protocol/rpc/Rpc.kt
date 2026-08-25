package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.collections.List

public sealed interface RpcMessage {
  public companion object {
    public fun decode(
      type: UByte,
      bb: FlatBufferReader,
      offset: Int,
    ): RpcMessage? = when (type.toInt()) {
      1 -> HeartbeatRequest.decode(bb, offset)
      2 -> HeartbeatResponse.decode(bb, offset)
      3 -> ResetRequest.decode(bb, offset)
      4 -> ResetResponse.decode(bb, offset)
      5 -> AssignTrackerRequest.decode(bb, offset)
      6 -> VMCOSCSettingsRequest.decode(bb, offset)
      7 -> VMCOSCSettingsResponse.decode(bb, offset)
      8 -> ChangeVMCOSCSettingsRequest.decode(bb, offset)
      9 -> VRMSettingsRequest.decode(bb, offset)
      10 -> VRMSettingsResponse.decode(bb, offset)
      11 -> ChangeVRMSettingsRequest.decode(bb, offset)
      12 -> SkeletonSettingsRequest.decode(bb, offset)
      13 -> SkeletonSettingsResponse.decode(bb, offset)
      14 -> ChangeSkeletonSettingsRequest.decode(bb, offset)
      15 -> UserHeightRequest.decode(bb, offset)
      16 -> UserHeightResponse.decode(bb, offset)
      17 -> ChangeUserHeightRequest.decode(bb, offset)
      18 -> TapDetectionSettingsRequest.decode(bb, offset)
      19 -> TapDetectionSettingsResponse.decode(bb, offset)
      20 -> ChangeTapDetectionSettingsRequest.decode(bb, offset)
      21 -> TapDetectionSetupModeRequest.decode(bb, offset)
      22 -> ResetsSettingsRequest.decode(bb, offset)
      23 -> ResetsSettingsResponse.decode(bb, offset)
      24 -> ChangeResetsSettingsRequest.decode(bb, offset)
      25 -> StayAlignedSettingsRequest.decode(bb, offset)
      26 -> StayAlignedSettingsResponse.decode(bb, offset)
      27 -> ChangeStayAlignedSettingsRequest.decode(bb, offset)
      28 -> ChangeStayAlignedEnabledRequest.decode(bb, offset)
      29 -> DetectStayAlignedRelaxedPoseRequest.decode(bb, offset)
      30 -> ResetStayAlignedRelaxedPoseRequest.decode(bb, offset)
      31 -> HIDSettingsRequest.decode(bb, offset)
      32 -> HIDSettingsResponse.decode(bb, offset)
      33 -> ChangeHIDSettingsRequest.decode(bb, offset)
      34 -> RecordBVHRequest.decode(bb, offset)
      35 -> RecordBVHStatus.decode(bb, offset)
      36 -> SkeletonProportionsRequest.decode(bb, offset)
      37 -> ChangeSkeletonProportionsRequest.decode(bb, offset)
      38 -> SkeletonProportionsResetAllRequest.decode(bb, offset)
      39 -> SkeletonProportionsResponse.decode(bb, offset)
      40 -> OpenSerialRequest.decode(bb, offset)
      41 -> CloseSerialRequest.decode(bb, offset)
      42 -> SerialUpdateResponse.decode(bb, offset)
      43 -> AutoBoneProcessRequest.decode(bb, offset)
      44 -> AutoBoneProcessStatusResponse.decode(bb, offset)
      45 -> AutoBoneEpochResponse.decode(bb, offset)
      46 -> OverlayDisplayModeRequest.decode(bb, offset)
      47 -> OverlayDisplayModeChangeRequest.decode(bb, offset)
      48 -> OverlayDisplayModeResponse.decode(bb, offset)
      49 -> SerialTrackerRebootRequest.decode(bb, offset)
      50 -> SerialTrackerGetInfoRequest.decode(bb, offset)
      51 -> SerialTrackerFactoryResetRequest.decode(bb, offset)
      52 -> SerialDevicesRequest.decode(bb, offset)
      53 -> SerialDevicesResponse.decode(bb, offset)
      54 -> NewSerialDeviceResponse.decode(bb, offset)
      55 -> StartWifiProvisioningRequest.decode(bb, offset)
      56 -> StopWifiProvisioningRequest.decode(bb, offset)
      57 -> WifiProvisioningStatusResponse.decode(bb, offset)
      58 -> StartWifiScanRequest.decode(bb, offset)
      59 -> StopWifiScanRequest.decode(bb, offset)
      60 -> WifiScanStatusResponse.decode(bb, offset)
      61 -> ServerInfosRequest.decode(bb, offset)
      62 -> ServerInfosResponse.decode(bb, offset)
      63 -> LegTweaksTmpChange.decode(bb, offset)
      64 -> LegTweaksTmpClear.decode(bb, offset)
      65 -> TapDetectionSetupNotification.decode(bb, offset)
      66 -> SetPauseTrackingRequest.decode(bb, offset)
      67 -> ClearMountingResetRequest.decode(bb, offset)
      68 -> AutoBoneApplyRequest.decode(bb, offset)
      69 -> AutoBoneStopRecordingRequest.decode(bb, offset)
      70 -> AutoBoneCancelRecordingRequest.decode(bb, offset)
      71 -> SaveFileNotification.decode(bb, offset)
      72 -> TrackingPauseStateRequest.decode(bb, offset)
      73 -> TrackingPauseStateResponse.decode(bb, offset)
      74 -> SerialTrackerGetWifiScanRequest.decode(bb, offset)
      75 -> UnknownDeviceHandshakeNotification.decode(bb, offset)
      76 -> AddUnknownDeviceRequest.decode(bb, offset)
      77 -> ForgetDeviceRequest.decode(bb, offset)
      78 -> FirmwareUpdateRequest.decode(bb, offset)
      79 -> FirmwareUpdateStatusResponse.decode(bb, offset)
      80 -> FirmwareUpdateStopQueuesRequest.decode(bb, offset)
      81 -> SettingsResetRequest.decode(bb, offset)
      82 -> MagToggleRequest.decode(bb, offset)
      83 -> MagToggleResponse.decode(bb, offset)
      84 -> ChangeMagToggleRequest.decode(bb, offset)
      85 -> RecordBVHStatusRequest.decode(bb, offset)
      86 -> VRCConfigStateRequest.decode(bb, offset)
      87 -> VRCConfigStateChangeResponse.decode(bb, offset)
      88 -> SerialTrackerCustomCommandRequest.decode(bb, offset)
      89 -> VRCConfigSettingToggleMute.decode(bb, offset)
      90 -> TrackingChecklistRequest.decode(bb, offset)
      91 -> TrackingChecklistResponse.decode(bb, offset)
      92 -> IgnoreTrackingChecklistStepRequest.decode(bb, offset)
      93 -> StartUserHeightCalibration.decode(bb, offset)
      94 -> CancelUserHeightCalibration.decode(bb, offset)
      95 -> UserHeightRecordingStatusResponse.decode(bb, offset)
      96 -> VRCOSCSettingsRequest.decode(bb, offset)
      97 -> VRCOSCSettingsResponse.decode(bb, offset)
      98 -> ChangeVRCOSCSettingsRequest.decode(bb, offset)
      99 -> VRCOSCStatusRequest.decode(bb, offset)
      100 -> VRCOSCStatusChangeResponse.decode(bb, offset)
      101 -> KeybindRequest.decode(bb, offset)
      102 -> ChangeKeybindRequest.decode(bb, offset)
      103 -> KeybindResponse.decode(bb, offset)
      104 -> InstalledInfoRequest.decode(bb, offset)
      105 -> InstalledInfoResponse.decode(bb, offset)
      106 -> OpenKeybindSettingsRequest.decode(bb, offset)
      107 -> OpenKeybindSettingsResponse.decode(bb, offset)
      108 -> EnableSteamVRDriverRequest.decode(bb, offset)
      109 -> SetKeybindRecordingRequest.decode(bb, offset)
      110 -> KeybindActivatedResponse.decode(bb, offset)
      111 -> BoneRoutingSettingsRequest.decode(bb, offset)
      112 -> BoneRoutingSettingsResponse.decode(bb, offset)
      113 -> ChangeBoneRoutingSettingsRequest.decode(bb, offset)
      114 -> DriverSettingsRequest.decode(bb, offset)
      115 -> DriverSettingsResponse.decode(bb, offset)
      116 -> ChangeDriverSettingsRequest.decode(bb, offset)
      117 -> VMCOSCStatusRequest.decode(bb, offset)
      118 -> VMCOSCStatusChangeResponse.decode(bb, offset)
      119 -> DriverStatusRequest.decode(bb, offset)
      120 -> DriverStatusChangeResponse.decode(bb, offset)
      121 -> ChangeDongleSettingsRequest.decode(bb, offset)
      122 -> TimeoutSettingsRequest.decode(bb, offset)
      123 -> TimeoutSettingsResponse.decode(bb, offset)
      124 -> ChangeTimeoutSettingsRequest.decode(bb, offset)
      125 -> StartTelemetryRequest.decode(bb, offset)
      126 -> StopTelemetryRequest.decode(bb, offset)
      127 -> TelemetryUpdateResponse.decode(bb, offset)
      128 -> TelemetryGapResponse.decode(bb, offset)
      else -> null
    }

    public fun typeIndex(`value`: RpcMessage): UByte = when (value) {
      is HeartbeatRequest -> 1.toUByte()
      is HeartbeatResponse -> 2.toUByte()
      is ResetRequest -> 3.toUByte()
      is ResetResponse -> 4.toUByte()
      is AssignTrackerRequest -> 5.toUByte()
      is VMCOSCSettingsRequest -> 6.toUByte()
      is VMCOSCSettingsResponse -> 7.toUByte()
      is ChangeVMCOSCSettingsRequest -> 8.toUByte()
      is VRMSettingsRequest -> 9.toUByte()
      is VRMSettingsResponse -> 10.toUByte()
      is ChangeVRMSettingsRequest -> 11.toUByte()
      is SkeletonSettingsRequest -> 12.toUByte()
      is SkeletonSettingsResponse -> 13.toUByte()
      is ChangeSkeletonSettingsRequest -> 14.toUByte()
      is UserHeightRequest -> 15.toUByte()
      is UserHeightResponse -> 16.toUByte()
      is ChangeUserHeightRequest -> 17.toUByte()
      is TapDetectionSettingsRequest -> 18.toUByte()
      is TapDetectionSettingsResponse -> 19.toUByte()
      is ChangeTapDetectionSettingsRequest -> 20.toUByte()
      is TapDetectionSetupModeRequest -> 21.toUByte()
      is ResetsSettingsRequest -> 22.toUByte()
      is ResetsSettingsResponse -> 23.toUByte()
      is ChangeResetsSettingsRequest -> 24.toUByte()
      is StayAlignedSettingsRequest -> 25.toUByte()
      is StayAlignedSettingsResponse -> 26.toUByte()
      is ChangeStayAlignedSettingsRequest -> 27.toUByte()
      is ChangeStayAlignedEnabledRequest -> 28.toUByte()
      is DetectStayAlignedRelaxedPoseRequest -> 29.toUByte()
      is ResetStayAlignedRelaxedPoseRequest -> 30.toUByte()
      is HIDSettingsRequest -> 31.toUByte()
      is HIDSettingsResponse -> 32.toUByte()
      is ChangeHIDSettingsRequest -> 33.toUByte()
      is RecordBVHRequest -> 34.toUByte()
      is RecordBVHStatus -> 35.toUByte()
      is SkeletonProportionsRequest -> 36.toUByte()
      is ChangeSkeletonProportionsRequest -> 37.toUByte()
      is SkeletonProportionsResetAllRequest -> 38.toUByte()
      is SkeletonProportionsResponse -> 39.toUByte()
      is OpenSerialRequest -> 40.toUByte()
      is CloseSerialRequest -> 41.toUByte()
      is SerialUpdateResponse -> 42.toUByte()
      is AutoBoneProcessRequest -> 43.toUByte()
      is AutoBoneProcessStatusResponse -> 44.toUByte()
      is AutoBoneEpochResponse -> 45.toUByte()
      is OverlayDisplayModeRequest -> 46.toUByte()
      is OverlayDisplayModeChangeRequest -> 47.toUByte()
      is OverlayDisplayModeResponse -> 48.toUByte()
      is SerialTrackerRebootRequest -> 49.toUByte()
      is SerialTrackerGetInfoRequest -> 50.toUByte()
      is SerialTrackerFactoryResetRequest -> 51.toUByte()
      is SerialDevicesRequest -> 52.toUByte()
      is SerialDevicesResponse -> 53.toUByte()
      is NewSerialDeviceResponse -> 54.toUByte()
      is StartWifiProvisioningRequest -> 55.toUByte()
      is StopWifiProvisioningRequest -> 56.toUByte()
      is WifiProvisioningStatusResponse -> 57.toUByte()
      is StartWifiScanRequest -> 58.toUByte()
      is StopWifiScanRequest -> 59.toUByte()
      is WifiScanStatusResponse -> 60.toUByte()
      is ServerInfosRequest -> 61.toUByte()
      is ServerInfosResponse -> 62.toUByte()
      is LegTweaksTmpChange -> 63.toUByte()
      is LegTweaksTmpClear -> 64.toUByte()
      is TapDetectionSetupNotification -> 65.toUByte()
      is SetPauseTrackingRequest -> 66.toUByte()
      is ClearMountingResetRequest -> 67.toUByte()
      is AutoBoneApplyRequest -> 68.toUByte()
      is AutoBoneStopRecordingRequest -> 69.toUByte()
      is AutoBoneCancelRecordingRequest -> 70.toUByte()
      is SaveFileNotification -> 71.toUByte()
      is TrackingPauseStateRequest -> 72.toUByte()
      is TrackingPauseStateResponse -> 73.toUByte()
      is SerialTrackerGetWifiScanRequest -> 74.toUByte()
      is UnknownDeviceHandshakeNotification -> 75.toUByte()
      is AddUnknownDeviceRequest -> 76.toUByte()
      is ForgetDeviceRequest -> 77.toUByte()
      is FirmwareUpdateRequest -> 78.toUByte()
      is FirmwareUpdateStatusResponse -> 79.toUByte()
      is FirmwareUpdateStopQueuesRequest -> 80.toUByte()
      is SettingsResetRequest -> 81.toUByte()
      is MagToggleRequest -> 82.toUByte()
      is MagToggleResponse -> 83.toUByte()
      is ChangeMagToggleRequest -> 84.toUByte()
      is RecordBVHStatusRequest -> 85.toUByte()
      is VRCConfigStateRequest -> 86.toUByte()
      is VRCConfigStateChangeResponse -> 87.toUByte()
      is SerialTrackerCustomCommandRequest -> 88.toUByte()
      is VRCConfigSettingToggleMute -> 89.toUByte()
      is TrackingChecklistRequest -> 90.toUByte()
      is TrackingChecklistResponse -> 91.toUByte()
      is IgnoreTrackingChecklistStepRequest -> 92.toUByte()
      is StartUserHeightCalibration -> 93.toUByte()
      is CancelUserHeightCalibration -> 94.toUByte()
      is UserHeightRecordingStatusResponse -> 95.toUByte()
      is VRCOSCSettingsRequest -> 96.toUByte()
      is VRCOSCSettingsResponse -> 97.toUByte()
      is ChangeVRCOSCSettingsRequest -> 98.toUByte()
      is VRCOSCStatusRequest -> 99.toUByte()
      is VRCOSCStatusChangeResponse -> 100.toUByte()
      is KeybindRequest -> 101.toUByte()
      is ChangeKeybindRequest -> 102.toUByte()
      is KeybindResponse -> 103.toUByte()
      is InstalledInfoRequest -> 104.toUByte()
      is InstalledInfoResponse -> 105.toUByte()
      is OpenKeybindSettingsRequest -> 106.toUByte()
      is OpenKeybindSettingsResponse -> 107.toUByte()
      is EnableSteamVRDriverRequest -> 108.toUByte()
      is SetKeybindRecordingRequest -> 109.toUByte()
      is KeybindActivatedResponse -> 110.toUByte()
      is BoneRoutingSettingsRequest -> 111.toUByte()
      is BoneRoutingSettingsResponse -> 112.toUByte()
      is ChangeBoneRoutingSettingsRequest -> 113.toUByte()
      is DriverSettingsRequest -> 114.toUByte()
      is DriverSettingsResponse -> 115.toUByte()
      is ChangeDriverSettingsRequest -> 116.toUByte()
      is VMCOSCStatusRequest -> 117.toUByte()
      is VMCOSCStatusChangeResponse -> 118.toUByte()
      is DriverStatusRequest -> 119.toUByte()
      is DriverStatusChangeResponse -> 120.toUByte()
      is ChangeDongleSettingsRequest -> 121.toUByte()
      is TimeoutSettingsRequest -> 122.toUByte()
      is TimeoutSettingsResponse -> 123.toUByte()
      is ChangeTimeoutSettingsRequest -> 124.toUByte()
      is StartTelemetryRequest -> 125.toUByte()
      is StopTelemetryRequest -> 126.toUByte()
      is TelemetryUpdateResponse -> 127.toUByte()
      is TelemetryGapResponse -> 128.toUByte()
    }

    public fun encode(`value`: RpcMessage, builder: FlatBufferWriter): Int = when (value) {
      is HeartbeatRequest -> value.encode(builder)
      is HeartbeatResponse -> value.encode(builder)
      is ResetRequest -> value.encode(builder)
      is ResetResponse -> value.encode(builder)
      is AssignTrackerRequest -> value.encode(builder)
      is VMCOSCSettingsRequest -> value.encode(builder)
      is VMCOSCSettingsResponse -> value.encode(builder)
      is ChangeVMCOSCSettingsRequest -> value.encode(builder)
      is VRMSettingsRequest -> value.encode(builder)
      is VRMSettingsResponse -> value.encode(builder)
      is ChangeVRMSettingsRequest -> value.encode(builder)
      is SkeletonSettingsRequest -> value.encode(builder)
      is SkeletonSettingsResponse -> value.encode(builder)
      is ChangeSkeletonSettingsRequest -> value.encode(builder)
      is UserHeightRequest -> value.encode(builder)
      is UserHeightResponse -> value.encode(builder)
      is ChangeUserHeightRequest -> value.encode(builder)
      is TapDetectionSettingsRequest -> value.encode(builder)
      is TapDetectionSettingsResponse -> value.encode(builder)
      is ChangeTapDetectionSettingsRequest -> value.encode(builder)
      is TapDetectionSetupModeRequest -> value.encode(builder)
      is ResetsSettingsRequest -> value.encode(builder)
      is ResetsSettingsResponse -> value.encode(builder)
      is ChangeResetsSettingsRequest -> value.encode(builder)
      is StayAlignedSettingsRequest -> value.encode(builder)
      is StayAlignedSettingsResponse -> value.encode(builder)
      is ChangeStayAlignedSettingsRequest -> value.encode(builder)
      is ChangeStayAlignedEnabledRequest -> value.encode(builder)
      is DetectStayAlignedRelaxedPoseRequest -> value.encode(builder)
      is ResetStayAlignedRelaxedPoseRequest -> value.encode(builder)
      is HIDSettingsRequest -> value.encode(builder)
      is HIDSettingsResponse -> value.encode(builder)
      is ChangeHIDSettingsRequest -> value.encode(builder)
      is RecordBVHRequest -> value.encode(builder)
      is RecordBVHStatus -> value.encode(builder)
      is SkeletonProportionsRequest -> value.encode(builder)
      is ChangeSkeletonProportionsRequest -> value.encode(builder)
      is SkeletonProportionsResetAllRequest -> value.encode(builder)
      is SkeletonProportionsResponse -> value.encode(builder)
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
      is StartWifiScanRequest -> value.encode(builder)
      is StopWifiScanRequest -> value.encode(builder)
      is WifiScanStatusResponse -> value.encode(builder)
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
      is OpenKeybindSettingsRequest -> value.encode(builder)
      is OpenKeybindSettingsResponse -> value.encode(builder)
      is EnableSteamVRDriverRequest -> value.encode(builder)
      is SetKeybindRecordingRequest -> value.encode(builder)
      is KeybindActivatedResponse -> value.encode(builder)
      is BoneRoutingSettingsRequest -> value.encode(builder)
      is BoneRoutingSettingsResponse -> value.encode(builder)
      is ChangeBoneRoutingSettingsRequest -> value.encode(builder)
      is DriverSettingsRequest -> value.encode(builder)
      is DriverSettingsResponse -> value.encode(builder)
      is ChangeDriverSettingsRequest -> value.encode(builder)
      is VMCOSCStatusRequest -> value.encode(builder)
      is VMCOSCStatusChangeResponse -> value.encode(builder)
      is DriverStatusRequest -> value.encode(builder)
      is DriverStatusChangeResponse -> value.encode(builder)
      is ChangeDongleSettingsRequest -> value.encode(builder)
      is TimeoutSettingsRequest -> value.encode(builder)
      is TimeoutSettingsResponse -> value.encode(builder)
      is ChangeTimeoutSettingsRequest -> value.encode(builder)
      is StartTelemetryRequest -> value.encode(builder)
      is StopTelemetryRequest -> value.encode(builder)
      is TelemetryUpdateResponse -> value.encode(builder)
      is TelemetryGapResponse -> value.encode(builder)
    }
  }
}

public data class RpcMessageHeader(
  public val txId: UInt = 0u,
  public val replyTo: UInt = 0u,
  public val message: RpcMessage? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_message = message?.let { RpcMessage.encode(it, builder) }
    val __type_message = message?.let { RpcMessage.typeIndex(it) } ?: 0.toUByte()

    builder.startTable(4)
    builder.addInt(0, txId.toInt(), 0)
    builder.addInt(1, replyTo.toInt(), 0)
    builder.addByte(2, __type_message.toByte(), 0)
    __off_message?.let { builder.addOffset(3, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): RpcMessageHeader {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_txId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_replyTo = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __type_message = if (vtableSize > 8 && bb.getShort(vtableOffset + 8).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 8).toInt()).toUByte() else 0.toUByte()
      val __offset_message = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return RpcMessageHeader(
              txId = if (__offset_txId != 0) bb.getInt(tableOffset + __offset_txId).toUInt() else 0u,
              replyTo = if (__offset_replyTo != 0) bb.getInt(tableOffset + __offset_replyTo).toUInt() else 0u,
              message = if (__offset_message != 0) RpcMessage.decode(__type_message, bb, tableOffset + __offset_message + bb.getInt(tableOffset + __offset_message)) else null
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

/**
 * Resets the server settings
 */
public class SettingsResetRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SettingsResetRequest = SettingsResetRequest()
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
  public val isUdevInstalled: Boolean = false,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addBoolean(0, isUdevInstalled, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): InstalledInfoResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_isUdevInstalled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return InstalledInfoResponse(
              isUdevInstalled = if (__offset_isUdevInstalled != 0) bb.get(tableOffset + __offset_isUdevInstalled) != 0.toByte() else false
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
