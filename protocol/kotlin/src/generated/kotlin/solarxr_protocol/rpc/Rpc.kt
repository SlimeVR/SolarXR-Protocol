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
      6 -> ResetTrackerAssignments.decode(bb, offset)
      7 -> VMCOSCSettingsRequest.decode(bb, offset)
      8 -> VMCOSCSettingsResponse.decode(bb, offset)
      9 -> ChangeVMCOSCSettingsRequest.decode(bb, offset)
      10 -> VRMSettingsRequest.decode(bb, offset)
      11 -> VRMSettingsResponse.decode(bb, offset)
      12 -> ChangeVRMSettingsRequest.decode(bb, offset)
      13 -> SkeletonSettingsRequest.decode(bb, offset)
      14 -> SkeletonSettingsResponse.decode(bb, offset)
      15 -> ChangeSkeletonSettingsRequest.decode(bb, offset)
      16 -> UserHeightRequest.decode(bb, offset)
      17 -> UserHeightResponse.decode(bb, offset)
      18 -> ChangeUserHeightRequest.decode(bb, offset)
      19 -> TapDetectionSettingsRequest.decode(bb, offset)
      20 -> TapDetectionSettingsResponse.decode(bb, offset)
      21 -> ChangeTapDetectionSettingsRequest.decode(bb, offset)
      22 -> TapDetectionSetupModeRequest.decode(bb, offset)
      23 -> ResetsSettingsRequest.decode(bb, offset)
      24 -> ResetsSettingsResponse.decode(bb, offset)
      25 -> ChangeResetsSettingsRequest.decode(bb, offset)
      26 -> StayAlignedSettingsRequest.decode(bb, offset)
      27 -> StayAlignedSettingsResponse.decode(bb, offset)
      28 -> ChangeStayAlignedSettingsRequest.decode(bb, offset)
      29 -> ChangeStayAlignedEnabledRequest.decode(bb, offset)
      30 -> DetectStayAlignedRelaxedPoseRequest.decode(bb, offset)
      31 -> ResetStayAlignedRelaxedPoseRequest.decode(bb, offset)
      32 -> HIDSettingsRequest.decode(bb, offset)
      33 -> HIDSettingsResponse.decode(bb, offset)
      34 -> ChangeHIDSettingsRequest.decode(bb, offset)
      35 -> RecordBVHRequest.decode(bb, offset)
      36 -> RecordBVHStatus.decode(bb, offset)
      37 -> SkeletonProportionsRequest.decode(bb, offset)
      38 -> ChangeSkeletonProportionsRequest.decode(bb, offset)
      39 -> SkeletonProportionsResetAllRequest.decode(bb, offset)
      40 -> SkeletonProportionsResponse.decode(bb, offset)
      41 -> OpenSerialRequest.decode(bb, offset)
      42 -> CloseSerialRequest.decode(bb, offset)
      43 -> SerialUpdateResponse.decode(bb, offset)
      44 -> AutoBoneProcessRequest.decode(bb, offset)
      45 -> AutoBoneProcessStatusResponse.decode(bb, offset)
      46 -> AutoBoneEpochResponse.decode(bb, offset)
      47 -> OverlayDisplayModeRequest.decode(bb, offset)
      48 -> OverlayDisplayModeChangeRequest.decode(bb, offset)
      49 -> OverlayDisplayModeResponse.decode(bb, offset)
      50 -> SerialTrackerRebootRequest.decode(bb, offset)
      51 -> SerialTrackerGetInfoRequest.decode(bb, offset)
      52 -> SerialTrackerFactoryResetRequest.decode(bb, offset)
      53 -> SerialDevicesRequest.decode(bb, offset)
      54 -> SerialDevicesResponse.decode(bb, offset)
      55 -> NewSerialDeviceResponse.decode(bb, offset)
      56 -> StartWifiProvisioningRequest.decode(bb, offset)
      57 -> StopWifiProvisioningRequest.decode(bb, offset)
      58 -> WifiProvisioningStatusResponse.decode(bb, offset)
      59 -> StartWifiScanRequest.decode(bb, offset)
      60 -> StopWifiScanRequest.decode(bb, offset)
      61 -> WifiScanStatusResponse.decode(bb, offset)
      62 -> ServerInfosRequest.decode(bb, offset)
      63 -> ServerInfosResponse.decode(bb, offset)
      64 -> LegTweaksTmpChange.decode(bb, offset)
      65 -> LegTweaksTmpClear.decode(bb, offset)
      66 -> TapDetectionSetupNotification.decode(bb, offset)
      67 -> SetPauseTrackingRequest.decode(bb, offset)
      68 -> ClearMountingResetRequest.decode(bb, offset)
      69 -> AutoBoneApplyRequest.decode(bb, offset)
      70 -> AutoBoneStopRecordingRequest.decode(bb, offset)
      71 -> AutoBoneCancelRecordingRequest.decode(bb, offset)
      72 -> SaveFileNotification.decode(bb, offset)
      73 -> TrackingPauseStateRequest.decode(bb, offset)
      74 -> TrackingPauseStateResponse.decode(bb, offset)
      75 -> SerialTrackerGetWifiScanRequest.decode(bb, offset)
      76 -> UnknownDeviceHandshakeNotification.decode(bb, offset)
      77 -> AddUnknownDeviceRequest.decode(bb, offset)
      78 -> ForgetDeviceRequest.decode(bb, offset)
      79 -> FirmwareUpdateRequest.decode(bb, offset)
      80 -> FirmwareUpdateStatusResponse.decode(bb, offset)
      81 -> FirmwareUpdateStopQueuesRequest.decode(bb, offset)
      82 -> SettingsResetRequest.decode(bb, offset)
      83 -> MagToggleRequest.decode(bb, offset)
      84 -> MagToggleResponse.decode(bb, offset)
      85 -> ChangeMagToggleRequest.decode(bb, offset)
      86 -> RecordBVHStatusRequest.decode(bb, offset)
      87 -> VRCConfigStateRequest.decode(bb, offset)
      88 -> VRCConfigStateChangeResponse.decode(bb, offset)
      89 -> SerialTrackerCustomCommandRequest.decode(bb, offset)
      90 -> VRCConfigSettingToggleMute.decode(bb, offset)
      91 -> TrackingChecklistRequest.decode(bb, offset)
      92 -> TrackingChecklistResponse.decode(bb, offset)
      93 -> IgnoreTrackingChecklistStepRequest.decode(bb, offset)
      94 -> StartUserHeightCalibration.decode(bb, offset)
      95 -> CancelUserHeightCalibration.decode(bb, offset)
      96 -> UserHeightRecordingStatusResponse.decode(bb, offset)
      97 -> VRCOSCSettingsRequest.decode(bb, offset)
      98 -> VRCOSCSettingsResponse.decode(bb, offset)
      99 -> ChangeVRCOSCSettingsRequest.decode(bb, offset)
      100 -> VRCOSCStatusRequest.decode(bb, offset)
      101 -> VRCOSCStatusChangeResponse.decode(bb, offset)
      102 -> KeybindRequest.decode(bb, offset)
      103 -> ChangeKeybindRequest.decode(bb, offset)
      104 -> KeybindResponse.decode(bb, offset)
      105 -> InstalledInfoRequest.decode(bb, offset)
      106 -> InstalledInfoResponse.decode(bb, offset)
      107 -> OpenKeybindSettingsRequest.decode(bb, offset)
      108 -> OpenKeybindSettingsResponse.decode(bb, offset)
      109 -> EnableSteamVRDriverRequest.decode(bb, offset)
      110 -> SetKeybindRecordingRequest.decode(bb, offset)
      111 -> KeybindActivatedResponse.decode(bb, offset)
      112 -> BoneRoutingSettingsRequest.decode(bb, offset)
      113 -> BoneRoutingSettingsResponse.decode(bb, offset)
      114 -> ChangeBoneRoutingSettingsRequest.decode(bb, offset)
      115 -> DriverSettingsRequest.decode(bb, offset)
      116 -> DriverSettingsResponse.decode(bb, offset)
      117 -> ChangeDriverSettingsRequest.decode(bb, offset)
      118 -> VMCOSCStatusRequest.decode(bb, offset)
      119 -> VMCOSCStatusChangeResponse.decode(bb, offset)
      120 -> DriverStatusRequest.decode(bb, offset)
      121 -> DriverStatusChangeResponse.decode(bb, offset)
      122 -> ChangeDongleSettingsRequest.decode(bb, offset)
      123 -> TimeoutSettingsRequest.decode(bb, offset)
      124 -> TimeoutSettingsResponse.decode(bb, offset)
      125 -> ChangeTimeoutSettingsRequest.decode(bb, offset)
      126 -> StartTelemetryRequest.decode(bb, offset)
      127 -> StopTelemetryRequest.decode(bb, offset)
      128 -> TelemetryUpdateResponse.decode(bb, offset)
      129 -> TelemetryGapResponse.decode(bb, offset)
      else -> null
    }

    public fun typeIndex(`value`: RpcMessage): UByte = when (value) {
      is HeartbeatRequest -> 1.toUByte()
      is HeartbeatResponse -> 2.toUByte()
      is ResetRequest -> 3.toUByte()
      is ResetResponse -> 4.toUByte()
      is AssignTrackerRequest -> 5.toUByte()
      is ResetTrackerAssignments -> 6.toUByte()
      is VMCOSCSettingsRequest -> 7.toUByte()
      is VMCOSCSettingsResponse -> 8.toUByte()
      is ChangeVMCOSCSettingsRequest -> 9.toUByte()
      is VRMSettingsRequest -> 10.toUByte()
      is VRMSettingsResponse -> 11.toUByte()
      is ChangeVRMSettingsRequest -> 12.toUByte()
      is SkeletonSettingsRequest -> 13.toUByte()
      is SkeletonSettingsResponse -> 14.toUByte()
      is ChangeSkeletonSettingsRequest -> 15.toUByte()
      is UserHeightRequest -> 16.toUByte()
      is UserHeightResponse -> 17.toUByte()
      is ChangeUserHeightRequest -> 18.toUByte()
      is TapDetectionSettingsRequest -> 19.toUByte()
      is TapDetectionSettingsResponse -> 20.toUByte()
      is ChangeTapDetectionSettingsRequest -> 21.toUByte()
      is TapDetectionSetupModeRequest -> 22.toUByte()
      is ResetsSettingsRequest -> 23.toUByte()
      is ResetsSettingsResponse -> 24.toUByte()
      is ChangeResetsSettingsRequest -> 25.toUByte()
      is StayAlignedSettingsRequest -> 26.toUByte()
      is StayAlignedSettingsResponse -> 27.toUByte()
      is ChangeStayAlignedSettingsRequest -> 28.toUByte()
      is ChangeStayAlignedEnabledRequest -> 29.toUByte()
      is DetectStayAlignedRelaxedPoseRequest -> 30.toUByte()
      is ResetStayAlignedRelaxedPoseRequest -> 31.toUByte()
      is HIDSettingsRequest -> 32.toUByte()
      is HIDSettingsResponse -> 33.toUByte()
      is ChangeHIDSettingsRequest -> 34.toUByte()
      is RecordBVHRequest -> 35.toUByte()
      is RecordBVHStatus -> 36.toUByte()
      is SkeletonProportionsRequest -> 37.toUByte()
      is ChangeSkeletonProportionsRequest -> 38.toUByte()
      is SkeletonProportionsResetAllRequest -> 39.toUByte()
      is SkeletonProportionsResponse -> 40.toUByte()
      is OpenSerialRequest -> 41.toUByte()
      is CloseSerialRequest -> 42.toUByte()
      is SerialUpdateResponse -> 43.toUByte()
      is AutoBoneProcessRequest -> 44.toUByte()
      is AutoBoneProcessStatusResponse -> 45.toUByte()
      is AutoBoneEpochResponse -> 46.toUByte()
      is OverlayDisplayModeRequest -> 47.toUByte()
      is OverlayDisplayModeChangeRequest -> 48.toUByte()
      is OverlayDisplayModeResponse -> 49.toUByte()
      is SerialTrackerRebootRequest -> 50.toUByte()
      is SerialTrackerGetInfoRequest -> 51.toUByte()
      is SerialTrackerFactoryResetRequest -> 52.toUByte()
      is SerialDevicesRequest -> 53.toUByte()
      is SerialDevicesResponse -> 54.toUByte()
      is NewSerialDeviceResponse -> 55.toUByte()
      is StartWifiProvisioningRequest -> 56.toUByte()
      is StopWifiProvisioningRequest -> 57.toUByte()
      is WifiProvisioningStatusResponse -> 58.toUByte()
      is StartWifiScanRequest -> 59.toUByte()
      is StopWifiScanRequest -> 60.toUByte()
      is WifiScanStatusResponse -> 61.toUByte()
      is ServerInfosRequest -> 62.toUByte()
      is ServerInfosResponse -> 63.toUByte()
      is LegTweaksTmpChange -> 64.toUByte()
      is LegTweaksTmpClear -> 65.toUByte()
      is TapDetectionSetupNotification -> 66.toUByte()
      is SetPauseTrackingRequest -> 67.toUByte()
      is ClearMountingResetRequest -> 68.toUByte()
      is AutoBoneApplyRequest -> 69.toUByte()
      is AutoBoneStopRecordingRequest -> 70.toUByte()
      is AutoBoneCancelRecordingRequest -> 71.toUByte()
      is SaveFileNotification -> 72.toUByte()
      is TrackingPauseStateRequest -> 73.toUByte()
      is TrackingPauseStateResponse -> 74.toUByte()
      is SerialTrackerGetWifiScanRequest -> 75.toUByte()
      is UnknownDeviceHandshakeNotification -> 76.toUByte()
      is AddUnknownDeviceRequest -> 77.toUByte()
      is ForgetDeviceRequest -> 78.toUByte()
      is FirmwareUpdateRequest -> 79.toUByte()
      is FirmwareUpdateStatusResponse -> 80.toUByte()
      is FirmwareUpdateStopQueuesRequest -> 81.toUByte()
      is SettingsResetRequest -> 82.toUByte()
      is MagToggleRequest -> 83.toUByte()
      is MagToggleResponse -> 84.toUByte()
      is ChangeMagToggleRequest -> 85.toUByte()
      is RecordBVHStatusRequest -> 86.toUByte()
      is VRCConfigStateRequest -> 87.toUByte()
      is VRCConfigStateChangeResponse -> 88.toUByte()
      is SerialTrackerCustomCommandRequest -> 89.toUByte()
      is VRCConfigSettingToggleMute -> 90.toUByte()
      is TrackingChecklistRequest -> 91.toUByte()
      is TrackingChecklistResponse -> 92.toUByte()
      is IgnoreTrackingChecklistStepRequest -> 93.toUByte()
      is StartUserHeightCalibration -> 94.toUByte()
      is CancelUserHeightCalibration -> 95.toUByte()
      is UserHeightRecordingStatusResponse -> 96.toUByte()
      is VRCOSCSettingsRequest -> 97.toUByte()
      is VRCOSCSettingsResponse -> 98.toUByte()
      is ChangeVRCOSCSettingsRequest -> 99.toUByte()
      is VRCOSCStatusRequest -> 100.toUByte()
      is VRCOSCStatusChangeResponse -> 101.toUByte()
      is KeybindRequest -> 102.toUByte()
      is ChangeKeybindRequest -> 103.toUByte()
      is KeybindResponse -> 104.toUByte()
      is InstalledInfoRequest -> 105.toUByte()
      is InstalledInfoResponse -> 106.toUByte()
      is OpenKeybindSettingsRequest -> 107.toUByte()
      is OpenKeybindSettingsResponse -> 108.toUByte()
      is EnableSteamVRDriverRequest -> 109.toUByte()
      is SetKeybindRecordingRequest -> 110.toUByte()
      is KeybindActivatedResponse -> 111.toUByte()
      is BoneRoutingSettingsRequest -> 112.toUByte()
      is BoneRoutingSettingsResponse -> 113.toUByte()
      is ChangeBoneRoutingSettingsRequest -> 114.toUByte()
      is DriverSettingsRequest -> 115.toUByte()
      is DriverSettingsResponse -> 116.toUByte()
      is ChangeDriverSettingsRequest -> 117.toUByte()
      is VMCOSCStatusRequest -> 118.toUByte()
      is VMCOSCStatusChangeResponse -> 119.toUByte()
      is DriverStatusRequest -> 120.toUByte()
      is DriverStatusChangeResponse -> 121.toUByte()
      is ChangeDongleSettingsRequest -> 122.toUByte()
      is TimeoutSettingsRequest -> 123.toUByte()
      is TimeoutSettingsResponse -> 124.toUByte()
      is ChangeTimeoutSettingsRequest -> 125.toUByte()
      is StartTelemetryRequest -> 126.toUByte()
      is StopTelemetryRequest -> 127.toUByte()
      is TelemetryUpdateResponse -> 128.toUByte()
      is TelemetryGapResponse -> 129.toUByte()
    }

    public fun encode(`value`: RpcMessage, builder: FlatBufferWriter): Int = when (value) {
      is HeartbeatRequest -> value.encode(builder)
      is HeartbeatResponse -> value.encode(builder)
      is ResetRequest -> value.encode(builder)
      is ResetResponse -> value.encode(builder)
      is AssignTrackerRequest -> value.encode(builder)
      is ResetTrackerAssignments -> value.encode(builder)
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
