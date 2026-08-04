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
      28 -> StayAlignedHideCorrectionRequest.decode(bb, offset)
      29 -> StayAlignedHideCorrectionResponse.decode(bb, offset)
      30 -> ChangeStayAlignedHideCorrectionRequest.decode(bb, offset)
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
      58 -> ServerInfosRequest.decode(bb, offset)
      59 -> ServerInfosResponse.decode(bb, offset)
      60 -> LegTweaksTmpChange.decode(bb, offset)
      61 -> LegTweaksTmpClear.decode(bb, offset)
      62 -> TapDetectionSetupNotification.decode(bb, offset)
      63 -> SetPauseTrackingRequest.decode(bb, offset)
      64 -> ClearMountingResetRequest.decode(bb, offset)
      65 -> AutoBoneApplyRequest.decode(bb, offset)
      66 -> AutoBoneStopRecordingRequest.decode(bb, offset)
      67 -> AutoBoneCancelRecordingRequest.decode(bb, offset)
      68 -> SaveFileNotification.decode(bb, offset)
      69 -> TrackingPauseStateRequest.decode(bb, offset)
      70 -> TrackingPauseStateResponse.decode(bb, offset)
      71 -> SerialTrackerGetWifiScanRequest.decode(bb, offset)
      72 -> UnknownDeviceHandshakeNotification.decode(bb, offset)
      73 -> AddUnknownDeviceRequest.decode(bb, offset)
      74 -> ForgetDeviceRequest.decode(bb, offset)
      75 -> FirmwareUpdateRequest.decode(bb, offset)
      76 -> FirmwareUpdateStatusResponse.decode(bb, offset)
      77 -> FirmwareUpdateStopQueuesRequest.decode(bb, offset)
      78 -> SettingsResetRequest.decode(bb, offset)
      79 -> MagToggleRequest.decode(bb, offset)
      80 -> MagToggleResponse.decode(bb, offset)
      81 -> ChangeMagToggleRequest.decode(bb, offset)
      82 -> RecordBVHStatusRequest.decode(bb, offset)
      83 -> VRCConfigStateRequest.decode(bb, offset)
      84 -> VRCConfigStateChangeResponse.decode(bb, offset)
      85 -> EnableStayAlignedRequest.decode(bb, offset)
      86 -> DetectStayAlignedRelaxedPoseRequest.decode(bb, offset)
      87 -> ResetStayAlignedRelaxedPoseRequest.decode(bb, offset)
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
      else -> null
    }

    public fun typeIndex(`value`: RpcMessage): Byte = when (value) {
      is HeartbeatRequest -> 1
      is HeartbeatResponse -> 2
      is ResetRequest -> 3
      is ResetResponse -> 4
      is AssignTrackerRequest -> 5
      is VMCOSCSettingsRequest -> 6
      is VMCOSCSettingsResponse -> 7
      is ChangeVMCOSCSettingsRequest -> 8
      is VRMSettingsRequest -> 9
      is VRMSettingsResponse -> 10
      is ChangeVRMSettingsRequest -> 11
      is SkeletonSettingsRequest -> 12
      is SkeletonSettingsResponse -> 13
      is ChangeSkeletonSettingsRequest -> 14
      is UserHeightRequest -> 15
      is UserHeightResponse -> 16
      is ChangeUserHeightRequest -> 17
      is TapDetectionSettingsRequest -> 18
      is TapDetectionSettingsResponse -> 19
      is ChangeTapDetectionSettingsRequest -> 20
      is TapDetectionSetupModeRequest -> 21
      is ResetsSettingsRequest -> 22
      is ResetsSettingsResponse -> 23
      is ChangeResetsSettingsRequest -> 24
      is StayAlignedSettingsRequest -> 25
      is StayAlignedSettingsResponse -> 26
      is ChangeStayAlignedSettingsRequest -> 27
      is StayAlignedHideCorrectionRequest -> 28
      is StayAlignedHideCorrectionResponse -> 29
      is ChangeStayAlignedHideCorrectionRequest -> 30
      is HIDSettingsRequest -> 31
      is HIDSettingsResponse -> 32
      is ChangeHIDSettingsRequest -> 33
      is RecordBVHRequest -> 34
      is RecordBVHStatus -> 35
      is SkeletonProportionsRequest -> 36
      is ChangeSkeletonProportionsRequest -> 37
      is SkeletonProportionsResetAllRequest -> 38
      is SkeletonProportionsResponse -> 39
      is OpenSerialRequest -> 40
      is CloseSerialRequest -> 41
      is SerialUpdateResponse -> 42
      is AutoBoneProcessRequest -> 43
      is AutoBoneProcessStatusResponse -> 44
      is AutoBoneEpochResponse -> 45
      is OverlayDisplayModeRequest -> 46
      is OverlayDisplayModeChangeRequest -> 47
      is OverlayDisplayModeResponse -> 48
      is SerialTrackerRebootRequest -> 49
      is SerialTrackerGetInfoRequest -> 50
      is SerialTrackerFactoryResetRequest -> 51
      is SerialDevicesRequest -> 52
      is SerialDevicesResponse -> 53
      is NewSerialDeviceResponse -> 54
      is StartWifiProvisioningRequest -> 55
      is StopWifiProvisioningRequest -> 56
      is WifiProvisioningStatusResponse -> 57
      is ServerInfosRequest -> 58
      is ServerInfosResponse -> 59
      is LegTweaksTmpChange -> 60
      is LegTweaksTmpClear -> 61
      is TapDetectionSetupNotification -> 62
      is SetPauseTrackingRequest -> 63
      is ClearMountingResetRequest -> 64
      is AutoBoneApplyRequest -> 65
      is AutoBoneStopRecordingRequest -> 66
      is AutoBoneCancelRecordingRequest -> 67
      is SaveFileNotification -> 68
      is TrackingPauseStateRequest -> 69
      is TrackingPauseStateResponse -> 70
      is SerialTrackerGetWifiScanRequest -> 71
      is UnknownDeviceHandshakeNotification -> 72
      is AddUnknownDeviceRequest -> 73
      is ForgetDeviceRequest -> 74
      is FirmwareUpdateRequest -> 75
      is FirmwareUpdateStatusResponse -> 76
      is FirmwareUpdateStopQueuesRequest -> 77
      is SettingsResetRequest -> 78
      is MagToggleRequest -> 79
      is MagToggleResponse -> 80
      is ChangeMagToggleRequest -> 81
      is RecordBVHStatusRequest -> 82
      is VRCConfigStateRequest -> 83
      is VRCConfigStateChangeResponse -> 84
      is EnableStayAlignedRequest -> 85
      is DetectStayAlignedRelaxedPoseRequest -> 86
      is ResetStayAlignedRelaxedPoseRequest -> 87
      is SerialTrackerCustomCommandRequest -> 88
      is VRCConfigSettingToggleMute -> 89
      is TrackingChecklistRequest -> 90
      is TrackingChecklistResponse -> 91
      is IgnoreTrackingChecklistStepRequest -> 92
      is StartUserHeightCalibration -> 93
      is CancelUserHeightCalibration -> 94
      is UserHeightRecordingStatusResponse -> 95
      is VRCOSCSettingsRequest -> 96
      is VRCOSCSettingsResponse -> 97
      is ChangeVRCOSCSettingsRequest -> 98
      is VRCOSCStatusRequest -> 99
      is VRCOSCStatusChangeResponse -> 100
      is KeybindRequest -> 101
      is ChangeKeybindRequest -> 102
      is KeybindResponse -> 103
      is InstalledInfoRequest -> 104
      is InstalledInfoResponse -> 105
      is OpenKeybindSettingsRequest -> 106
      is OpenKeybindSettingsResponse -> 107
      is EnableSteamVRDriverRequest -> 108
      is SetKeybindRecordingRequest -> 109
      is KeybindActivatedResponse -> 110
      is BoneRoutingSettingsRequest -> 111
      is BoneRoutingSettingsResponse -> 112
      is ChangeBoneRoutingSettingsRequest -> 113
      is DriverSettingsRequest -> 114
      is DriverSettingsResponse -> 115
      is ChangeDriverSettingsRequest -> 116
      is VMCOSCStatusRequest -> 117
      is VMCOSCStatusChangeResponse -> 118
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
      is StayAlignedHideCorrectionRequest -> value.encode(builder)
      is StayAlignedHideCorrectionResponse -> value.encode(builder)
      is ChangeStayAlignedHideCorrectionRequest -> value.encode(builder)
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
      is VMCOSCStatusRequest -> value.encode(builder)
      is VMCOSCStatusChangeResponse -> value.encode(builder)
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
