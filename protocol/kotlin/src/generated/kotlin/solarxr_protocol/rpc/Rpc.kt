package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Boolean
import kotlin.Byte
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.collections.List
import solarxr_protocol.datatypes.TransactionId

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
      is SkeletonSettingsRequest -> 15
      is SkeletonSettingsResponse -> 16
      is ChangeSkeletonSettingsRequest -> 17
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
      is SkeletonSettingsRequest -> value.encode(builder)
      is SkeletonSettingsResponse -> value.encode(builder)
      is ChangeSkeletonSettingsRequest -> value.encode(builder)
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
