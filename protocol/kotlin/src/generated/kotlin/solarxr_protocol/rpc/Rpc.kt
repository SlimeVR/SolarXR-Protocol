package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Boolean
import kotlin.Byte
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.collections.List

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
      15 -> SkeletonSettingsRequest.decode(bb, offset)
      16 -> SkeletonSettingsResponse.decode(bb, offset)
      17 -> ChangeSkeletonSettingsRequest.decode(bb, offset)
      18 -> UserHeightRequest.decode(bb, offset)
      19 -> UserHeightResponse.decode(bb, offset)
      20 -> ChangeUserHeightRequest.decode(bb, offset)
      21 -> TapDetectionSettingsRequest.decode(bb, offset)
      22 -> TapDetectionSettingsResponse.decode(bb, offset)
      23 -> ChangeTapDetectionSettingsRequest.decode(bb, offset)
      24 -> TapDetectionSetupModeRequest.decode(bb, offset)
      25 -> ResetsSettingsRequest.decode(bb, offset)
      26 -> ResetsSettingsResponse.decode(bb, offset)
      27 -> ChangeResetsSettingsRequest.decode(bb, offset)
      28 -> StayAlignedSettingsRequest.decode(bb, offset)
      29 -> StayAlignedSettingsResponse.decode(bb, offset)
      30 -> ChangeStayAlignedSettingsRequest.decode(bb, offset)
      31 -> CompleteStayAlignedResponse.decode(bb, offset)
      32 -> StayAlignedHideCorrectionRequest.decode(bb, offset)
      33 -> HIDSettingsRequest.decode(bb, offset)
      34 -> HIDSettingsResponse.decode(bb, offset)
      35 -> ChangeHIDSettingsRequest.decode(bb, offset)
      36 -> RecordBVHRequest.decode(bb, offset)
      37 -> RecordBVHStatus.decode(bb, offset)
      38 -> SkeletonProportionsRequest.decode(bb, offset)
      39 -> ChangeSkeletonProportionsRequest.decode(bb, offset)
      40 -> SkeletonProportionsResetAllRequest.decode(bb, offset)
      41 -> SkeletonProportionsResponse.decode(bb, offset)
      42 -> OpenSerialRequest.decode(bb, offset)
      43 -> CloseSerialRequest.decode(bb, offset)
      44 -> SerialUpdateResponse.decode(bb, offset)
      45 -> AutoBoneProcessRequest.decode(bb, offset)
      46 -> AutoBoneProcessStatusResponse.decode(bb, offset)
      47 -> AutoBoneEpochResponse.decode(bb, offset)
      48 -> OverlayDisplayModeRequest.decode(bb, offset)
      49 -> OverlayDisplayModeChangeRequest.decode(bb, offset)
      50 -> OverlayDisplayModeResponse.decode(bb, offset)
      51 -> SerialTrackerRebootRequest.decode(bb, offset)
      52 -> SerialTrackerGetInfoRequest.decode(bb, offset)
      53 -> SerialTrackerFactoryResetRequest.decode(bb, offset)
      54 -> SerialDevicesRequest.decode(bb, offset)
      55 -> SerialDevicesResponse.decode(bb, offset)
      56 -> NewSerialDeviceResponse.decode(bb, offset)
      57 -> StartWifiProvisioningRequest.decode(bb, offset)
      58 -> StopWifiProvisioningRequest.decode(bb, offset)
      59 -> WifiProvisioningStatusResponse.decode(bb, offset)
      60 -> ServerInfosRequest.decode(bb, offset)
      61 -> ServerInfosResponse.decode(bb, offset)
      62 -> LegTweaksTmpChange.decode(bb, offset)
      63 -> LegTweaksTmpClear.decode(bb, offset)
      64 -> TapDetectionSetupNotification.decode(bb, offset)
      65 -> SetPauseTrackingRequest.decode(bb, offset)
      66 -> ClearMountingResetRequest.decode(bb, offset)
      67 -> AutoBoneApplyRequest.decode(bb, offset)
      68 -> AutoBoneStopRecordingRequest.decode(bb, offset)
      69 -> AutoBoneCancelRecordingRequest.decode(bb, offset)
      70 -> SaveFileNotification.decode(bb, offset)
      71 -> TrackingPauseStateRequest.decode(bb, offset)
      72 -> TrackingPauseStateResponse.decode(bb, offset)
      73 -> SerialTrackerGetWifiScanRequest.decode(bb, offset)
      74 -> UnknownDeviceHandshakeNotification.decode(bb, offset)
      75 -> AddUnknownDeviceRequest.decode(bb, offset)
      76 -> ForgetDeviceRequest.decode(bb, offset)
      77 -> FirmwareUpdateRequest.decode(bb, offset)
      78 -> FirmwareUpdateStatusResponse.decode(bb, offset)
      79 -> FirmwareUpdateStopQueuesRequest.decode(bb, offset)
      80 -> SettingsResetRequest.decode(bb, offset)
      81 -> MagToggleRequest.decode(bb, offset)
      82 -> MagToggleResponse.decode(bb, offset)
      83 -> ChangeMagToggleRequest.decode(bb, offset)
      84 -> RecordBVHStatusRequest.decode(bb, offset)
      85 -> VRCConfigStateRequest.decode(bb, offset)
      86 -> VRCConfigStateChangeResponse.decode(bb, offset)
      87 -> EnableStayAlignedRequest.decode(bb, offset)
      88 -> DetectStayAlignedRelaxedPoseRequest.decode(bb, offset)
      89 -> ResetStayAlignedRelaxedPoseRequest.decode(bb, offset)
      90 -> SerialTrackerCustomCommandRequest.decode(bb, offset)
      91 -> VRCConfigSettingToggleMute.decode(bb, offset)
      92 -> TrackingChecklistRequest.decode(bb, offset)
      93 -> TrackingChecklistResponse.decode(bb, offset)
      94 -> IgnoreTrackingChecklistStepRequest.decode(bb, offset)
      95 -> StartUserHeightCalibration.decode(bb, offset)
      96 -> CancelUserHeightCalibration.decode(bb, offset)
      97 -> UserHeightRecordingStatusResponse.decode(bb, offset)
      98 -> VRCOSCSettingsRequest.decode(bb, offset)
      99 -> VRCOSCSettingsResponse.decode(bb, offset)
      100 -> ChangeVRCOSCSettingsRequest.decode(bb, offset)
      101 -> VRCOSCStatusRequest.decode(bb, offset)
      102 -> VRCOSCStatusChangeResponse.decode(bb, offset)
      103 -> KeybindRequest.decode(bb, offset)
      104 -> ChangeKeybindRequest.decode(bb, offset)
      105 -> KeybindResponse.decode(bb, offset)
      106 -> InstalledInfoRequest.decode(bb, offset)
      107 -> InstalledInfoResponse.decode(bb, offset)
      108 -> OpenKeybindSettingsRequest.decode(bb, offset)
      109 -> OpenKeybindSettingsResponse.decode(bb, offset)
      110 -> EnableSteamVRDriverRequest.decode(bb, offset)
      111 -> SetKeybindRecordingRequest.decode(bb, offset)
      112 -> KeybindActivatedResponse.decode(bb, offset)
      113 -> BoneRoutingSettingsRequest.decode(bb, offset)
      114 -> BoneRoutingSettingsResponse.decode(bb, offset)
      115 -> ChangeBoneRoutingSettingsRequest.decode(bb, offset)
      116 -> DriverSettingsRequest.decode(bb, offset)
      117 -> DriverSettingsResponse.decode(bb, offset)
      118 -> ChangeDriverSettingsRequest.decode(bb, offset)
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
      is SkeletonSettingsRequest -> 15
      is SkeletonSettingsResponse -> 16
      is ChangeSkeletonSettingsRequest -> 17
      is UserHeightRequest -> 18
      is UserHeightResponse -> 19
      is ChangeUserHeightRequest -> 20
      is TapDetectionSettingsRequest -> 21
      is TapDetectionSettingsResponse -> 22
      is ChangeTapDetectionSettingsRequest -> 23
      is TapDetectionSetupModeRequest -> 24
      is ResetsSettingsRequest -> 25
      is ResetsSettingsResponse -> 26
      is ChangeResetsSettingsRequest -> 27
      is StayAlignedSettingsRequest -> 28
      is StayAlignedSettingsResponse -> 29
      is ChangeStayAlignedSettingsRequest -> 30
      is CompleteStayAlignedResponse -> 31
      is StayAlignedHideCorrectionRequest -> 32
      is HIDSettingsRequest -> 33
      is HIDSettingsResponse -> 34
      is ChangeHIDSettingsRequest -> 35
      is RecordBVHRequest -> 36
      is RecordBVHStatus -> 37
      is SkeletonProportionsRequest -> 38
      is ChangeSkeletonProportionsRequest -> 39
      is SkeletonProportionsResetAllRequest -> 40
      is SkeletonProportionsResponse -> 41
      is OpenSerialRequest -> 42
      is CloseSerialRequest -> 43
      is SerialUpdateResponse -> 44
      is AutoBoneProcessRequest -> 45
      is AutoBoneProcessStatusResponse -> 46
      is AutoBoneEpochResponse -> 47
      is OverlayDisplayModeRequest -> 48
      is OverlayDisplayModeChangeRequest -> 49
      is OverlayDisplayModeResponse -> 50
      is SerialTrackerRebootRequest -> 51
      is SerialTrackerGetInfoRequest -> 52
      is SerialTrackerFactoryResetRequest -> 53
      is SerialDevicesRequest -> 54
      is SerialDevicesResponse -> 55
      is NewSerialDeviceResponse -> 56
      is StartWifiProvisioningRequest -> 57
      is StopWifiProvisioningRequest -> 58
      is WifiProvisioningStatusResponse -> 59
      is ServerInfosRequest -> 60
      is ServerInfosResponse -> 61
      is LegTweaksTmpChange -> 62
      is LegTweaksTmpClear -> 63
      is TapDetectionSetupNotification -> 64
      is SetPauseTrackingRequest -> 65
      is ClearMountingResetRequest -> 66
      is AutoBoneApplyRequest -> 67
      is AutoBoneStopRecordingRequest -> 68
      is AutoBoneCancelRecordingRequest -> 69
      is SaveFileNotification -> 70
      is TrackingPauseStateRequest -> 71
      is TrackingPauseStateResponse -> 72
      is SerialTrackerGetWifiScanRequest -> 73
      is UnknownDeviceHandshakeNotification -> 74
      is AddUnknownDeviceRequest -> 75
      is ForgetDeviceRequest -> 76
      is FirmwareUpdateRequest -> 77
      is FirmwareUpdateStatusResponse -> 78
      is FirmwareUpdateStopQueuesRequest -> 79
      is SettingsResetRequest -> 80
      is MagToggleRequest -> 81
      is MagToggleResponse -> 82
      is ChangeMagToggleRequest -> 83
      is RecordBVHStatusRequest -> 84
      is VRCConfigStateRequest -> 85
      is VRCConfigStateChangeResponse -> 86
      is EnableStayAlignedRequest -> 87
      is DetectStayAlignedRelaxedPoseRequest -> 88
      is ResetStayAlignedRelaxedPoseRequest -> 89
      is SerialTrackerCustomCommandRequest -> 90
      is VRCConfigSettingToggleMute -> 91
      is TrackingChecklistRequest -> 92
      is TrackingChecklistResponse -> 93
      is IgnoreTrackingChecklistStepRequest -> 94
      is StartUserHeightCalibration -> 95
      is CancelUserHeightCalibration -> 96
      is UserHeightRecordingStatusResponse -> 97
      is VRCOSCSettingsRequest -> 98
      is VRCOSCSettingsResponse -> 99
      is ChangeVRCOSCSettingsRequest -> 100
      is VRCOSCStatusRequest -> 101
      is VRCOSCStatusChangeResponse -> 102
      is KeybindRequest -> 103
      is ChangeKeybindRequest -> 104
      is KeybindResponse -> 105
      is InstalledInfoRequest -> 106
      is InstalledInfoResponse -> 107
      is OpenKeybindSettingsRequest -> 108
      is OpenKeybindSettingsResponse -> 109
      is EnableSteamVRDriverRequest -> 110
      is SetKeybindRecordingRequest -> 111
      is KeybindActivatedResponse -> 112
      is BoneRoutingSettingsRequest -> 113
      is BoneRoutingSettingsResponse -> 114
      is ChangeBoneRoutingSettingsRequest -> 115
      is DriverSettingsRequest -> 116
      is DriverSettingsResponse -> 117
      is ChangeDriverSettingsRequest -> 118
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
      is CompleteStayAlignedResponse -> value.encode(builder)
      is StayAlignedHideCorrectionRequest -> value.encode(builder)
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
    }
  }
}

public data class RpcMessageHeader(
  public val txId: UInt? = null,
  public val message: RpcMessage? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_message = message?.let { RpcMessage.encode(it, builder) }
    val __type_message = message?.let { RpcMessage.typeIndex(it) } ?: 0.toByte()

    builder.startTable(3)
    if (txId != null) { builder.forceDefaults(true); builder.addInt(0, txId.toInt(), 0); builder.forceDefaults(false) }
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
              txId = if (__offset_txId != 0) bb.getInt(tableOffset + __offset_txId).toUInt() else null,
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
  public val isUdevInstalled: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (isUdevInstalled != null) { builder.forceDefaults(true); builder.addBoolean(0, isUdevInstalled, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): InstalledInfoResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_isUdevInstalled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return InstalledInfoResponse(
              isUdevInstalled = if (__offset_isUdevInstalled != 0) bb.get(tableOffset + __offset_isUdevInstalled) != 0.toByte() else null
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
