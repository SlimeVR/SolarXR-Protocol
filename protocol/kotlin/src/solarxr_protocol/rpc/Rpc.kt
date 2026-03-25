package solarxr_protocol.rpc

import com.google.flatbuffers.FlatBufferBuilder
import java.nio.ByteBuffer
import kotlin.Boolean
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.UByte
import kotlin.UInt
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

sealed interface RpcMessage {
  companion object {
    fun decode(
      type: Byte,
      bb: ByteBuffer,
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
      else -> null
    }

    fun typeIndex(`value`: RpcMessage): Byte = when (value) {
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
      else -> 0
    }

    fun encode(`value`: RpcMessage, builder: FlatBufferBuilder): Int = when (value) {
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
      else -> 0
    }
  }
}

data class RpcMessageHeader(
  val txId: TransactionId? = null,
  val message: RpcMessage? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_message = message?.let { RpcMessage.encode(it, builder) }
    val __type_message = message?.let { RpcMessage.typeIndex(it) } ?: 0.toByte()

    builder.startTable(3)
    txId?.let { builder.addStruct(0, it.encode(builder), 0) }
    builder.addByte(1, __type_message, 0)
    __off_message?.let { builder.addOffset(2, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): RpcMessageHeader {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_txId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __type_message = if (vtableSize > 6 && bb.getShort(vtableOffset + 6).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 6).toInt()) else 0
      val __offset_message = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return RpcMessageHeader(
              txId = if (__offset_txId != 0) solarxr_protocol.datatypes.TransactionId.decode(bb, tableOffset + __offset_txId) else null,
              message = if (__offset_message != 0) solarxr_protocol.rpc.RpcMessage.decode(__type_message, bb, tableOffset + __offset_message + bb.getInt(tableOffset + __offset_message)) else null
          )
    }
  }
}

class HeartbeatRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): HeartbeatRequest = HeartbeatRequest()
  }
}

class HeartbeatResponse : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): HeartbeatResponse = HeartbeatResponse()
  }
}

enum class ResetType(
  val `value`: UByte,
) {
  Yaw(0.toUByte()),
  Full(1.toUByte()),
  /**
   * Second pose for calibrating mounting rotation
   */
  Mounting(2.toUByte()),
  ;

  companion object {
    fun fromValue(`value`: UByte): ResetType? = entries.firstOrNull { it.value == value }
  }
}

enum class ResetStatus(
  val `value`: UByte,
) {
  STARTED(0.toUByte()),
  FINISHED(1.toUByte()),
  ;

  companion object {
    fun fromValue(`value`: UByte): ResetStatus? = entries.firstOrNull { it.value == value }
  }
}

data class ResetRequest(
  val resetType: ResetType? = null,
  val bodyParts: List<BodyPart>? = null,
  val delay: Float? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_bodyParts = bodyParts?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }

    builder.startTable(3)
    resetType?.let { builder.addByte(0, it.value.toByte(), 0) }
    __off_bodyParts?.let { builder.addOffset(1, it, 0) }
    if (delay != null) { builder.forceDefaults(true); builder.addFloat(2, delay, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): ResetRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_resetType = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_bodyParts = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_delay = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return ResetRequest(
              resetType = if (__offset_resetType != 0) solarxr_protocol.rpc.ResetType.fromValue(bb.get(tableOffset + __offset_resetType).toUByte()) else null,
              bodyParts = if (__offset_bodyParts != 0) { val vecOff = tableOffset + __offset_bodyParts + bb.getInt(tableOffset + __offset_bodyParts); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.datatypes.BodyPart.fromValue(bb.get(vecOff + 4 + i * 1).toUByte())!! } } else null,
              delay = if (__offset_delay != 0) bb.getFloat(tableOffset + __offset_delay) else null
          )
    }
  }
}

data class ResetResponse(
  val resetType: ResetType? = null,
  val status: ResetStatus? = null,
  val bodyParts: List<BodyPart>? = null,
  val progress: Int = 0,
  val duration: Int = 0,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_bodyParts = bodyParts?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }

    builder.startTable(5)
    resetType?.let { builder.addByte(0, it.value.toByte(), 0) }
    status?.let { builder.addByte(1, it.value.toByte(), 0) }
    __off_bodyParts?.let { builder.addOffset(2, it, 0) }
    builder.addInt(3, progress, 0)
    builder.addInt(4, duration, 0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): ResetResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_resetType = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_status = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_bodyParts = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_progress = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_duration = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return ResetResponse(
              resetType = if (__offset_resetType != 0) solarxr_protocol.rpc.ResetType.fromValue(bb.get(tableOffset + __offset_resetType).toUByte()) else null,
              status = if (__offset_status != 0) solarxr_protocol.rpc.ResetStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) else null,
              bodyParts = if (__offset_bodyParts != 0) { val vecOff = tableOffset + __offset_bodyParts + bb.getInt(tableOffset + __offset_bodyParts); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.datatypes.BodyPart.fromValue(bb.get(vecOff + 4 + i * 1).toUByte())!! } } else null,
              progress = if (__offset_progress != 0) bb.getInt(tableOffset + __offset_progress) else 0,
              duration = if (__offset_duration != 0) bb.getInt(tableOffset + __offset_duration) else 0
          )
    }
  }
}

data class AssignTrackerRequest(
  val trackerId: TrackerId? = null,
  val bodyPosition: BodyPart? = null,
  val mountingOrientation: Quat? = null,
  val displayName: String? = null,
  val allowDriftCompensation: Boolean = false,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_trackerId = trackerId?.encode(builder)
    val __off_displayName = displayName?.let { builder.createString(it) }

    builder.startTable(5)
    __off_trackerId?.let { builder.addOffset(0, it, 0) }
    bodyPosition?.let { builder.addByte(1, it.value.toByte(), 0) }
    mountingOrientation?.let { builder.addStruct(2, it.encode(builder), 0) }
    __off_displayName?.let { builder.addOffset(3, it, 0) }
    builder.addBoolean(4, allowDriftCompensation, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): AssignTrackerRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_bodyPosition = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_mountingOrientation = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_displayName = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_allowDriftCompensation = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return AssignTrackerRequest(
              trackerId = if (__offset_trackerId != 0) solarxr_protocol.datatypes.TrackerId.decode(bb, tableOffset + __offset_trackerId + bb.getInt(tableOffset + __offset_trackerId)) else null,
              bodyPosition = if (__offset_bodyPosition != 0) solarxr_protocol.datatypes.BodyPart.fromValue(bb.get(tableOffset + __offset_bodyPosition).toUByte()) else null,
              mountingOrientation = if (__offset_mountingOrientation != 0) solarxr_protocol.datatypes.math.Quat.decode(bb, tableOffset + __offset_mountingOrientation) else null,
              displayName = if (__offset_displayName != 0) { val strOff = tableOffset + __offset_displayName + bb.getInt(tableOffset + __offset_displayName); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              allowDriftCompensation = if (__offset_allowDriftCompensation != 0) bb.get(tableOffset + __offset_allowDriftCompensation) != 0.toByte() else false
          )
    }
  }
}

class ClearDriftCompensationRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): ClearDriftCompensationRequest = ClearDriftCompensationRequest()
  }
}

class SettingsRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SettingsRequest = SettingsRequest()
  }
}

data class SettingsResponse(
  val steamVrTrackers: SteamVRTrackersSetting? = null,
  val filtering: FilteringSettings? = null,
  val driftCompensation: DriftCompensationSettings? = null,
  val oscRouter: OSCRouterSettings? = null,
  val vrcOsc: VRCOSCSettings? = null,
  val vmcOsc: VMCOSCSettings? = null,
  val modelSettings: ModelSettings? = null,
  val tapDetectionSettings: TapDetectionSettings? = null,
  val autoBoneSettings: AutoBoneSettings? = null,
  val resetsSettings: ResetsSettings? = null,
  val stayAligned: StayAlignedSettings? = null,
  val hidSettings: HIDSettings? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
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

    builder.startTable(12)
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
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SettingsResponse {
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

      return SettingsResponse(
              steamVrTrackers = if (__offset_steamVrTrackers != 0) solarxr_protocol.rpc.SteamVRTrackersSetting.decode(bb, tableOffset + __offset_steamVrTrackers + bb.getInt(tableOffset + __offset_steamVrTrackers)) else null,
              filtering = if (__offset_filtering != 0) solarxr_protocol.rpc.FilteringSettings.decode(bb, tableOffset + __offset_filtering + bb.getInt(tableOffset + __offset_filtering)) else null,
              driftCompensation = if (__offset_driftCompensation != 0) solarxr_protocol.rpc.DriftCompensationSettings.decode(bb, tableOffset + __offset_driftCompensation + bb.getInt(tableOffset + __offset_driftCompensation)) else null,
              oscRouter = if (__offset_oscRouter != 0) solarxr_protocol.rpc.OSCRouterSettings.decode(bb, tableOffset + __offset_oscRouter + bb.getInt(tableOffset + __offset_oscRouter)) else null,
              vrcOsc = if (__offset_vrcOsc != 0) solarxr_protocol.rpc.VRCOSCSettings.decode(bb, tableOffset + __offset_vrcOsc + bb.getInt(tableOffset + __offset_vrcOsc)) else null,
              vmcOsc = if (__offset_vmcOsc != 0) solarxr_protocol.rpc.VMCOSCSettings.decode(bb, tableOffset + __offset_vmcOsc + bb.getInt(tableOffset + __offset_vmcOsc)) else null,
              modelSettings = if (__offset_modelSettings != 0) solarxr_protocol.rpc.settings.ModelSettings.decode(bb, tableOffset + __offset_modelSettings + bb.getInt(tableOffset + __offset_modelSettings)) else null,
              tapDetectionSettings = if (__offset_tapDetectionSettings != 0) solarxr_protocol.rpc.TapDetectionSettings.decode(bb, tableOffset + __offset_tapDetectionSettings + bb.getInt(tableOffset + __offset_tapDetectionSettings)) else null,
              autoBoneSettings = if (__offset_autoBoneSettings != 0) solarxr_protocol.rpc.AutoBoneSettings.decode(bb, tableOffset + __offset_autoBoneSettings + bb.getInt(tableOffset + __offset_autoBoneSettings)) else null,
              resetsSettings = if (__offset_resetsSettings != 0) solarxr_protocol.rpc.ResetsSettings.decode(bb, tableOffset + __offset_resetsSettings + bb.getInt(tableOffset + __offset_resetsSettings)) else null,
              stayAligned = if (__offset_stayAligned != 0) solarxr_protocol.rpc.StayAlignedSettings.decode(bb, tableOffset + __offset_stayAligned + bb.getInt(tableOffset + __offset_stayAligned)) else null,
              hidSettings = if (__offset_hidSettings != 0) solarxr_protocol.rpc.HIDSettings.decode(bb, tableOffset + __offset_hidSettings + bb.getInt(tableOffset + __offset_hidSettings)) else null
          )
    }
  }
}

data class ChangeSettingsRequest(
  val steamVrTrackers: SteamVRTrackersSetting? = null,
  val filtering: FilteringSettings? = null,
  val driftCompensation: DriftCompensationSettings? = null,
  val oscRouter: OSCRouterSettings? = null,
  val vrcOsc: VRCOSCSettings? = null,
  val vmcOsc: VMCOSCSettings? = null,
  val modelSettings: ModelSettings? = null,
  val tapDetectionSettings: TapDetectionSettings? = null,
  val autoBoneSettings: AutoBoneSettings? = null,
  val resetsSettings: ResetsSettings? = null,
  val stayAligned: StayAlignedSettings? = null,
  val hidSettings: HIDSettings? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
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

    builder.startTable(12)
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
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): ChangeSettingsRequest {
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

      return ChangeSettingsRequest(
              steamVrTrackers = if (__offset_steamVrTrackers != 0) solarxr_protocol.rpc.SteamVRTrackersSetting.decode(bb, tableOffset + __offset_steamVrTrackers + bb.getInt(tableOffset + __offset_steamVrTrackers)) else null,
              filtering = if (__offset_filtering != 0) solarxr_protocol.rpc.FilteringSettings.decode(bb, tableOffset + __offset_filtering + bb.getInt(tableOffset + __offset_filtering)) else null,
              driftCompensation = if (__offset_driftCompensation != 0) solarxr_protocol.rpc.DriftCompensationSettings.decode(bb, tableOffset + __offset_driftCompensation + bb.getInt(tableOffset + __offset_driftCompensation)) else null,
              oscRouter = if (__offset_oscRouter != 0) solarxr_protocol.rpc.OSCRouterSettings.decode(bb, tableOffset + __offset_oscRouter + bb.getInt(tableOffset + __offset_oscRouter)) else null,
              vrcOsc = if (__offset_vrcOsc != 0) solarxr_protocol.rpc.VRCOSCSettings.decode(bb, tableOffset + __offset_vrcOsc + bb.getInt(tableOffset + __offset_vrcOsc)) else null,
              vmcOsc = if (__offset_vmcOsc != 0) solarxr_protocol.rpc.VMCOSCSettings.decode(bb, tableOffset + __offset_vmcOsc + bb.getInt(tableOffset + __offset_vmcOsc)) else null,
              modelSettings = if (__offset_modelSettings != 0) solarxr_protocol.rpc.settings.ModelSettings.decode(bb, tableOffset + __offset_modelSettings + bb.getInt(tableOffset + __offset_modelSettings)) else null,
              tapDetectionSettings = if (__offset_tapDetectionSettings != 0) solarxr_protocol.rpc.TapDetectionSettings.decode(bb, tableOffset + __offset_tapDetectionSettings + bb.getInt(tableOffset + __offset_tapDetectionSettings)) else null,
              autoBoneSettings = if (__offset_autoBoneSettings != 0) solarxr_protocol.rpc.AutoBoneSettings.decode(bb, tableOffset + __offset_autoBoneSettings + bb.getInt(tableOffset + __offset_autoBoneSettings)) else null,
              resetsSettings = if (__offset_resetsSettings != 0) solarxr_protocol.rpc.ResetsSettings.decode(bb, tableOffset + __offset_resetsSettings + bb.getInt(tableOffset + __offset_resetsSettings)) else null,
              stayAligned = if (__offset_stayAligned != 0) solarxr_protocol.rpc.StayAlignedSettings.decode(bb, tableOffset + __offset_stayAligned + bb.getInt(tableOffset + __offset_stayAligned)) else null,
              hidSettings = if (__offset_hidSettings != 0) solarxr_protocol.rpc.HIDSettings.decode(bb, tableOffset + __offset_hidSettings + bb.getInt(tableOffset + __offset_hidSettings)) else null
          )
    }
  }
}

data class SteamVRTrackersSetting(
  val waist: Boolean = false,
  val chest: Boolean = false,
  val feet: Boolean = false,
  val knees: Boolean = false,
  val elbows: Boolean = false,
  val hands: Boolean = false,
  val automatictrackertoggle: Boolean = false,
  val leftFoot: Boolean = false,
  val rightFoot: Boolean = false,
  val leftKnee: Boolean = false,
  val rightKnee: Boolean = false,
  val leftElbow: Boolean = false,
  val rightElbow: Boolean = false,
  val leftHand: Boolean = false,
  val rightHand: Boolean = false,
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(15)
    builder.addBoolean(0, waist, false)
    builder.addBoolean(1, chest, false)
    builder.addBoolean(2, feet, false)
    builder.addBoolean(3, knees, false)
    builder.addBoolean(4, elbows, false)
    builder.addBoolean(5, hands, false)
    builder.addBoolean(6, automatictrackertoggle, false)
    builder.addBoolean(7, leftFoot, false)
    builder.addBoolean(8, rightFoot, false)
    builder.addBoolean(9, leftKnee, false)
    builder.addBoolean(10, rightKnee, false)
    builder.addBoolean(11, leftElbow, false)
    builder.addBoolean(12, rightElbow, false)
    builder.addBoolean(13, leftHand, false)
    builder.addBoolean(14, rightHand, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SteamVRTrackersSetting {
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
              waist = if (__offset_waist != 0) bb.get(tableOffset + __offset_waist) != 0.toByte() else false,
              chest = if (__offset_chest != 0) bb.get(tableOffset + __offset_chest) != 0.toByte() else false,
              feet = if (__offset_feet != 0) bb.get(tableOffset + __offset_feet) != 0.toByte() else false,
              knees = if (__offset_knees != 0) bb.get(tableOffset + __offset_knees) != 0.toByte() else false,
              elbows = if (__offset_elbows != 0) bb.get(tableOffset + __offset_elbows) != 0.toByte() else false,
              hands = if (__offset_hands != 0) bb.get(tableOffset + __offset_hands) != 0.toByte() else false,
              automatictrackertoggle = if (__offset_automatictrackertoggle != 0) bb.get(tableOffset + __offset_automatictrackertoggle) != 0.toByte() else false,
              leftFoot = if (__offset_leftFoot != 0) bb.get(tableOffset + __offset_leftFoot) != 0.toByte() else false,
              rightFoot = if (__offset_rightFoot != 0) bb.get(tableOffset + __offset_rightFoot) != 0.toByte() else false,
              leftKnee = if (__offset_leftKnee != 0) bb.get(tableOffset + __offset_leftKnee) != 0.toByte() else false,
              rightKnee = if (__offset_rightKnee != 0) bb.get(tableOffset + __offset_rightKnee) != 0.toByte() else false,
              leftElbow = if (__offset_leftElbow != 0) bb.get(tableOffset + __offset_leftElbow) != 0.toByte() else false,
              rightElbow = if (__offset_rightElbow != 0) bb.get(tableOffset + __offset_rightElbow) != 0.toByte() else false,
              leftHand = if (__offset_leftHand != 0) bb.get(tableOffset + __offset_leftHand) != 0.toByte() else false,
              rightHand = if (__offset_rightHand != 0) bb.get(tableOffset + __offset_rightHand) != 0.toByte() else false
          )
    }
  }
}

data class FilteringSettings(
  val type: FilteringType? = null,
  val amount: Float = 0.0f,
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(2)
    type?.let { builder.addByte(0, it.value.toByte(), 0) }
    builder.addFloat(1, amount, 0.0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): FilteringSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_type = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_amount = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return FilteringSettings(
              type = if (__offset_type != 0) solarxr_protocol.datatypes.FilteringType.fromValue(bb.get(tableOffset + __offset_type).toUByte()) else null,
              amount = if (__offset_amount != 0) bb.getFloat(tableOffset + __offset_amount) else 0.0f
          )
    }
  }
}

/**
 * Settings related to IMU yaw drift compensation
 */
data class DriftCompensationSettings(
  val enabled: Boolean = false,
  val prediction: Boolean = false,
  val amount: Float = 0.0f,
  val maxResets: UShort = 0.toUShort(),
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(4)
    builder.addBoolean(0, enabled, false)
    builder.addBoolean(1, prediction, false)
    builder.addFloat(2, amount, 0.0)
    builder.addShort(3, maxResets.toShort(), 0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): DriftCompensationSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_prediction = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_amount = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_maxResets = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return DriftCompensationSettings(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else false,
              prediction = if (__offset_prediction != 0) bb.get(tableOffset + __offset_prediction) != 0.toByte() else false,
              amount = if (__offset_amount != 0) bb.getFloat(tableOffset + __offset_amount) else 0.0f,
              maxResets = if (__offset_maxResets != 0) bb.getShort(tableOffset + __offset_maxResets).toUShort() else 0.toUShort()
          )
    }
  }
}

/**
 * OSC router forwards messages it receives, to allow the usage of multiple OSC programs for the same app.
 */
data class OSCRouterSettings(
  val oscSettings: OSCSettings? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_oscSettings = oscSettings?.encode(builder)

    builder.startTable(1)
    __off_oscSettings?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): OSCRouterSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_oscSettings = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return OSCRouterSettings(
              oscSettings = if (__offset_oscSettings != 0) solarxr_protocol.rpc.OSCSettings.decode(bb, tableOffset + __offset_oscSettings + bb.getInt(tableOffset + __offset_oscSettings)) else null
          )
    }
  }
}

/**
 * OSC Settings specific to VRChat
 */
data class VRCOSCSettings(
  val oscSettings: OSCSettings? = null,
  val trackers: OSCTrackersSetting? = null,
  val oscqueryEnabled: Boolean = false,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_oscSettings = oscSettings?.encode(builder)
    val __off_trackers = trackers?.encode(builder)

    builder.startTable(3)
    __off_oscSettings?.let { builder.addOffset(0, it, 0) }
    __off_trackers?.let { builder.addOffset(1, it, 0) }
    builder.addBoolean(2, oscqueryEnabled, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): VRCOSCSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_oscSettings = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_trackers = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_oscqueryEnabled = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return VRCOSCSettings(
              oscSettings = if (__offset_oscSettings != 0) solarxr_protocol.rpc.OSCSettings.decode(bb, tableOffset + __offset_oscSettings + bb.getInt(tableOffset + __offset_oscSettings)) else null,
              trackers = if (__offset_trackers != 0) solarxr_protocol.rpc.OSCTrackersSetting.decode(bb, tableOffset + __offset_trackers + bb.getInt(tableOffset + __offset_trackers)) else null,
              oscqueryEnabled = if (__offset_oscqueryEnabled != 0) bb.get(tableOffset + __offset_oscqueryEnabled) != 0.toByte() else false
          )
    }
  }
}

/**
 * OSC Settings specific to VMC
 */
data class VMCOSCSettings(
  val oscSettings: OSCSettings? = null,
  val vrmJson: String? = null,
  val anchorHip: Boolean = false,
  val mirrorTracking: Boolean = false,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_oscSettings = oscSettings?.encode(builder)
    val __off_vrmJson = vrmJson?.let { builder.createString(it) }

    builder.startTable(4)
    __off_oscSettings?.let { builder.addOffset(0, it, 0) }
    __off_vrmJson?.let { builder.addOffset(1, it, 0) }
    builder.addBoolean(2, anchorHip, false)
    builder.addBoolean(3, mirrorTracking, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): VMCOSCSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_oscSettings = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_vrmJson = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_anchorHip = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_mirrorTracking = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return VMCOSCSettings(
              oscSettings = if (__offset_oscSettings != 0) solarxr_protocol.rpc.OSCSettings.decode(bb, tableOffset + __offset_oscSettings + bb.getInt(tableOffset + __offset_oscSettings)) else null,
              vrmJson = if (__offset_vrmJson != 0) { val strOff = tableOffset + __offset_vrmJson + bb.getInt(tableOffset + __offset_vrmJson); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              anchorHip = if (__offset_anchorHip != 0) bb.get(tableOffset + __offset_anchorHip) != 0.toByte() else false,
              mirrorTracking = if (__offset_mirrorTracking != 0) bb.get(tableOffset + __offset_mirrorTracking) != 0.toByte() else false
          )
    }
  }
}

/**
 * OSC Settings that are used in *any* osc application.
 */
data class OSCSettings(
  val enabled: Boolean = false,
  val portIn: UShort = 0.toUShort(),
  val portOut: UShort = 0.toUShort(),
  val address: String? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_address = address?.let { builder.createString(it) }

    builder.startTable(4)
    builder.addBoolean(0, enabled, false)
    builder.addShort(1, portIn.toShort(), 0)
    builder.addShort(2, portOut.toShort(), 0)
    __off_address?.let { builder.addOffset(3, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): OSCSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_portIn = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_portOut = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_address = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return OSCSettings(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else false,
              portIn = if (__offset_portIn != 0) bb.getShort(tableOffset + __offset_portIn).toUShort() else 0.toUShort(),
              portOut = if (__offset_portOut != 0) bb.getShort(tableOffset + __offset_portOut).toUShort() else 0.toUShort(),
              address = if (__offset_address != 0) { val strOff = tableOffset + __offset_address + bb.getInt(tableOffset + __offset_address); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null
          )
    }
  }
}

data class OSCTrackersSetting(
  val head: Boolean = false,
  val chest: Boolean = false,
  val waist: Boolean = false,
  val knees: Boolean = false,
  val feet: Boolean = false,
  val elbows: Boolean = false,
  val hands: Boolean = false,
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(7)
    builder.addBoolean(0, head, false)
    builder.addBoolean(1, chest, false)
    builder.addBoolean(2, waist, false)
    builder.addBoolean(3, knees, false)
    builder.addBoolean(4, feet, false)
    builder.addBoolean(5, elbows, false)
    builder.addBoolean(6, hands, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): OSCTrackersSetting {
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
              head = if (__offset_head != 0) bb.get(tableOffset + __offset_head) != 0.toByte() else false,
              chest = if (__offset_chest != 0) bb.get(tableOffset + __offset_chest) != 0.toByte() else false,
              waist = if (__offset_waist != 0) bb.get(tableOffset + __offset_waist) != 0.toByte() else false,
              knees = if (__offset_knees != 0) bb.get(tableOffset + __offset_knees) != 0.toByte() else false,
              feet = if (__offset_feet != 0) bb.get(tableOffset + __offset_feet) != 0.toByte() else false,
              elbows = if (__offset_elbows != 0) bb.get(tableOffset + __offset_elbows) != 0.toByte() else false,
              hands = if (__offset_hands != 0) bb.get(tableOffset + __offset_hands) != 0.toByte() else false
          )
    }
  }
}

data class TapDetectionSettings(
  val fullResetDelay: Float? = null,
  val fullResetEnabled: Boolean? = null,
  val fullResetTaps: UByte? = null,
  val yawResetDelay: Float? = null,
  val yawResetEnabled: Boolean? = null,
  val yawResetTaps: UByte? = null,
  val mountingResetDelay: Float? = null,
  val mountingResetEnabled: Boolean? = null,
  val mountingResetTaps: UByte? = null,
  val setupMode: Boolean? = null,
  val numberTrackersOverThreshold: UByte? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(11)
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
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): TapDetectionSettings {
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
              numberTrackersOverThreshold = if (__offset_numberTrackersOverThreshold != 0) bb.get(tableOffset + __offset_numberTrackersOverThreshold).toUByte() else null
          )
    }
  }
}

enum class ArmsMountingResetMode(
  val `value`: UByte,
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

  companion object {
    fun fromValue(`value`: UByte): ArmsMountingResetMode? = entries.firstOrNull { it.value == value }
  }
}

data class ResetsSettings(
  val resetMountingFeet: Boolean = false,
  val armsMountingResetMode: ArmsMountingResetMode? = null,
  val yawResetSmoothTime: Float = 0.0f,
  val saveMountingReset: Boolean = false,
  val resetHmdPitch: Boolean = false,
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(5)
    builder.addBoolean(0, resetMountingFeet, false)
    armsMountingResetMode?.let { builder.addByte(1, it.value.toByte(), 0) }
    builder.addFloat(2, yawResetSmoothTime, 0.0)
    builder.addBoolean(3, saveMountingReset, false)
    builder.addBoolean(4, resetHmdPitch, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): ResetsSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_resetMountingFeet = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_armsMountingResetMode = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_yawResetSmoothTime = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_saveMountingReset = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_resetHmdPitch = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return ResetsSettings(
              resetMountingFeet = if (__offset_resetMountingFeet != 0) bb.get(tableOffset + __offset_resetMountingFeet) != 0.toByte() else false,
              armsMountingResetMode = if (__offset_armsMountingResetMode != 0) solarxr_protocol.rpc.ArmsMountingResetMode.fromValue(bb.get(tableOffset + __offset_armsMountingResetMode).toUByte()) else null,
              yawResetSmoothTime = if (__offset_yawResetSmoothTime != 0) bb.getFloat(tableOffset + __offset_yawResetSmoothTime) else 0.0f,
              saveMountingReset = if (__offset_saveMountingReset != 0) bb.get(tableOffset + __offset_saveMountingReset) != 0.toByte() else false,
              resetHmdPitch = if (__offset_resetHmdPitch != 0) bb.get(tableOffset + __offset_resetHmdPitch) != 0.toByte() else false
          )
    }
  }
}

data class StayAlignedSettings(
  val enabled: Boolean = false,
  val extrayawcorrection: Boolean = false,
  val hideyawcorrection: Boolean = false,
  val standingenabled: Boolean = false,
  val standingupperlegangle: Float = 0.0f,
  val standinglowerlegangle: Float = 0.0f,
  val standingfootangle: Float = 0.0f,
  val sittingenabled: Boolean = false,
  val sittingupperlegangle: Float = 0.0f,
  val sittinglowerlegangle: Float = 0.0f,
  val sittingfootangle: Float = 0.0f,
  val flatenabled: Boolean = false,
  val flatupperlegangle: Float = 0.0f,
  val flatlowerlegangle: Float = 0.0f,
  val flatfootangle: Float = 0.0f,
  val setupcomplete: Boolean = false,
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(16)
    builder.addBoolean(0, enabled, false)
    builder.addBoolean(1, extrayawcorrection, false)
    builder.addBoolean(2, hideyawcorrection, false)
    builder.addBoolean(3, standingenabled, false)
    builder.addFloat(4, standingupperlegangle, 0.0)
    builder.addFloat(5, standinglowerlegangle, 0.0)
    builder.addFloat(6, standingfootangle, 0.0)
    builder.addBoolean(7, sittingenabled, false)
    builder.addFloat(8, sittingupperlegangle, 0.0)
    builder.addFloat(9, sittinglowerlegangle, 0.0)
    builder.addFloat(10, sittingfootangle, 0.0)
    builder.addBoolean(11, flatenabled, false)
    builder.addFloat(12, flatupperlegangle, 0.0)
    builder.addFloat(13, flatlowerlegangle, 0.0)
    builder.addFloat(14, flatfootangle, 0.0)
    builder.addBoolean(15, setupcomplete, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): StayAlignedSettings {
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
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else false,
              extrayawcorrection = if (__offset_extrayawcorrection != 0) bb.get(tableOffset + __offset_extrayawcorrection) != 0.toByte() else false,
              hideyawcorrection = if (__offset_hideyawcorrection != 0) bb.get(tableOffset + __offset_hideyawcorrection) != 0.toByte() else false,
              standingenabled = if (__offset_standingenabled != 0) bb.get(tableOffset + __offset_standingenabled) != 0.toByte() else false,
              standingupperlegangle = if (__offset_standingupperlegangle != 0) bb.getFloat(tableOffset + __offset_standingupperlegangle) else 0.0f,
              standinglowerlegangle = if (__offset_standinglowerlegangle != 0) bb.getFloat(tableOffset + __offset_standinglowerlegangle) else 0.0f,
              standingfootangle = if (__offset_standingfootangle != 0) bb.getFloat(tableOffset + __offset_standingfootangle) else 0.0f,
              sittingenabled = if (__offset_sittingenabled != 0) bb.get(tableOffset + __offset_sittingenabled) != 0.toByte() else false,
              sittingupperlegangle = if (__offset_sittingupperlegangle != 0) bb.getFloat(tableOffset + __offset_sittingupperlegangle) else 0.0f,
              sittinglowerlegangle = if (__offset_sittinglowerlegangle != 0) bb.getFloat(tableOffset + __offset_sittinglowerlegangle) else 0.0f,
              sittingfootangle = if (__offset_sittingfootangle != 0) bb.getFloat(tableOffset + __offset_sittingfootangle) else 0.0f,
              flatenabled = if (__offset_flatenabled != 0) bb.get(tableOffset + __offset_flatenabled) != 0.toByte() else false,
              flatupperlegangle = if (__offset_flatupperlegangle != 0) bb.getFloat(tableOffset + __offset_flatupperlegangle) else 0.0f,
              flatlowerlegangle = if (__offset_flatlowerlegangle != 0) bb.getFloat(tableOffset + __offset_flatlowerlegangle) else 0.0f,
              flatfootangle = if (__offset_flatfootangle != 0) bb.getFloat(tableOffset + __offset_flatfootangle) else 0.0f,
              setupcomplete = if (__offset_setupcomplete != 0) bb.get(tableOffset + __offset_setupcomplete) != 0.toByte() else false
          )
    }
  }
}

data class HIDSettings(
  val trackersoverhid: Boolean = false,
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(1)
    builder.addBoolean(0, trackersoverhid, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): HIDSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackersoverhid = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return HIDSettings(
              trackersoverhid = if (__offset_trackersoverhid != 0) bb.get(tableOffset + __offset_trackersoverhid) != 0.toByte() else false
          )
    }
  }
}

/**
 * See TapDetectionSettings::setup_mode
 */
data class TapDetectionSetupNotification(
  val trackerId: TrackerId? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_trackerId = trackerId?.encode(builder)

    builder.startTable(1)
    __off_trackerId?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): TapDetectionSetupNotification {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TapDetectionSetupNotification(
              trackerId = if (__offset_trackerId != 0) solarxr_protocol.datatypes.TrackerId.decode(bb, tableOffset + __offset_trackerId + bb.getInt(tableOffset + __offset_trackerId)) else null
          )
    }
  }
}

data class RecordBVHRequest(
  val stop: Boolean = false,
  val path: String? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_path = path?.let { builder.createString(it) }

    builder.startTable(2)
    builder.addBoolean(0, stop, false)
    __off_path?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): RecordBVHRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_stop = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_path = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return RecordBVHRequest(
              stop = if (__offset_stop != 0) bb.get(tableOffset + __offset_stop) != 0.toByte() else false,
              path = if (__offset_path != 0) { val strOff = tableOffset + __offset_path + bb.getInt(tableOffset + __offset_path); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null
          )
    }
  }
}

data class RecordBVHStatus(
  val recording: Boolean = false,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(1)
    builder.addBoolean(0, recording, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): RecordBVHStatus {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_recording = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return RecordBVHStatus(
              recording = if (__offset_recording != 0) bb.get(tableOffset + __offset_recording) != 0.toByte() else false
          )
    }
  }
}

class RecordBVHStatusRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): RecordBVHStatusRequest = RecordBVHStatusRequest()
  }
}

enum class SkeletonBone(
  val `value`: UByte,
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

  companion object {
    fun fromValue(`value`: UByte): SkeletonBone? = entries.firstOrNull { it.value == value }
  }
}

data class SkeletonPart(
  val bone: SkeletonBone? = null,
  val `value`: Float = 0.0f,
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(2)
    bone?.let { builder.addByte(0, it.value.toByte(), 0) }
    builder.addFloat(1, value, 0.0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SkeletonPart {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bone = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_value = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return SkeletonPart(
              bone = if (__offset_bone != 0) solarxr_protocol.rpc.SkeletonBone.fromValue(bb.get(tableOffset + __offset_bone).toUByte()) else null,
              value = if (__offset_value != 0) bb.getFloat(tableOffset + __offset_value) else 0.0f
          )
    }
  }
}

class SkeletonConfigRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SkeletonConfigRequest = SkeletonConfigRequest()
  }
}

data class SkeletonConfigResponse(
  val skeletonParts: List<SkeletonPart>? = null,
  val userHeight: Float = 0.0f,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_skeletonParts = skeletonParts?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(2)
    __off_skeletonParts?.let { builder.addOffset(0, it, 0) }
    builder.addFloat(1, userHeight, 0.0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SkeletonConfigResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_skeletonParts = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_userHeight = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return SkeletonConfigResponse(
              skeletonParts = if (__offset_skeletonParts != 0) { val vecOff = tableOffset + __offset_skeletonParts + bb.getInt(tableOffset + __offset_skeletonParts); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.rpc.SkeletonPart.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) } } else null,
              userHeight = if (__offset_userHeight != 0) bb.getFloat(tableOffset + __offset_userHeight) else 0.0f
          )
    }
  }
}

class SkeletonResetAllRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SkeletonResetAllRequest = SkeletonResetAllRequest()
  }
}

data class ChangeSkeletonConfigRequest(
  val bone: SkeletonBone? = null,
  val `value`: Float = 0.0f,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(2)
    bone?.let { builder.addByte(0, it.value.toByte(), 0) }
    builder.addFloat(1, value, 0.0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): ChangeSkeletonConfigRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bone = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_value = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return ChangeSkeletonConfigRequest(
              bone = if (__offset_bone != 0) solarxr_protocol.rpc.SkeletonBone.fromValue(bb.get(tableOffset + __offset_bone).toUByte()) else null,
              value = if (__offset_value != 0) bb.getFloat(tableOffset + __offset_value) else 0.0f
          )
    }
  }
}

data class SerialDevice(
  val port: String? = null,
  val name: String? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_port = port?.let { builder.createString(it) }
    val __off_name = name?.let { builder.createString(it) }

    builder.startTable(2)
    __off_port?.let { builder.addOffset(0, it, 0) }
    __off_name?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SerialDevice {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_port = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_name = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return SerialDevice(
              port = if (__offset_port != 0) { val strOff = tableOffset + __offset_port + bb.getInt(tableOffset + __offset_port); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              name = if (__offset_name != 0) { val strOff = tableOffset + __offset_name + bb.getInt(tableOffset + __offset_name); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null
          )
    }
  }
}

data class OpenSerialRequest(
  val auto: Boolean = false,
  val port: String? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_port = port?.let { builder.createString(it) }

    builder.startTable(2)
    builder.addBoolean(0, auto, false)
    __off_port?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): OpenSerialRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_auto = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_port = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return OpenSerialRequest(
              auto = if (__offset_auto != 0) bb.get(tableOffset + __offset_auto) != 0.toByte() else false,
              port = if (__offset_port != 0) { val strOff = tableOffset + __offset_port + bb.getInt(tableOffset + __offset_port); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null
          )
    }
  }
}

class CloseSerialRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): CloseSerialRequest = CloseSerialRequest()
  }
}

data class SetWifiRequest(
  val ssid: String? = null,
  val password: String? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_ssid = ssid?.let { builder.createString(it) }
    val __off_password = password?.let { builder.createString(it) }

    builder.startTable(2)
    __off_ssid?.let { builder.addOffset(0, it, 0) }
    __off_password?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SetWifiRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_ssid = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_password = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return SetWifiRequest(
              ssid = if (__offset_ssid != 0) { val strOff = tableOffset + __offset_ssid + bb.getInt(tableOffset + __offset_ssid); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              password = if (__offset_password != 0) { val strOff = tableOffset + __offset_password + bb.getInt(tableOffset + __offset_password); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null
          )
    }
  }
}

data class SerialUpdateResponse(
  val log: String? = null,
  val closed: Boolean = false,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_log = log?.let { builder.createString(it) }

    builder.startTable(2)
    __off_log?.let { builder.addOffset(0, it, 0) }
    builder.addBoolean(1, closed, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SerialUpdateResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_log = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_closed = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return SerialUpdateResponse(
              log = if (__offset_log != 0) { val strOff = tableOffset + __offset_log + bb.getInt(tableOffset + __offset_log); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              closed = if (__offset_closed != 0) bb.get(tableOffset + __offset_closed) != 0.toByte() else false
          )
    }
  }
}

/**
 * Reboots the tracker connected to the serial monitor
 */
class SerialTrackerRebootRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SerialTrackerRebootRequest = SerialTrackerRebootRequest()
  }
}

/**
 * Sends the GET INFO cmd to the current tracker on the serial monitor
 */
class SerialTrackerGetInfoRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SerialTrackerGetInfoRequest = SerialTrackerGetInfoRequest()
  }
}

/**
 * Sends the FRST cmd to the currently connected Tracker over the Serial Monitor
 */
class SerialTrackerFactoryResetRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SerialTrackerFactoryResetRequest = SerialTrackerFactoryResetRequest()
  }
}

/**
 * Sends a custom cmd to the currently connected Tracker over the Serial Monitor
 */
data class SerialTrackerCustomCommandRequest(
  val command: String? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_command = command?.let { builder.createString(it) }

    builder.startTable(1)
    __off_command?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SerialTrackerCustomCommandRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_command = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return SerialTrackerCustomCommandRequest(
              command = if (__offset_command != 0) { val strOff = tableOffset + __offset_command + bb.getInt(tableOffset + __offset_command); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null
          )
    }
  }
}

class SerialDevicesRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SerialDevicesRequest = SerialDevicesRequest()
  }
}

data class SerialDevicesResponse(
  val devices: List<SerialDevice>? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_devices = devices?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(1)
    __off_devices?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SerialDevicesResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_devices = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return SerialDevicesResponse(
              devices = if (__offset_devices != 0) { val vecOff = tableOffset + __offset_devices + bb.getInt(tableOffset + __offset_devices); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.rpc.SerialDevice.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) } } else null
          )
    }
  }
}

data class NewSerialDeviceResponse(
  val device: SerialDevice? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_device = device?.encode(builder)

    builder.startTable(1)
    __off_device?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): NewSerialDeviceResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_device = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return NewSerialDeviceResponse(
              device = if (__offset_device != 0) solarxr_protocol.rpc.SerialDevice.decode(bb, tableOffset + __offset_device + bb.getInt(tableOffset + __offset_device)) else null
          )
    }
  }
}

data class StartWifiProvisioningRequest(
  val ssid: String? = null,
  val password: String? = null,
  val port: String? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_ssid = ssid?.let { builder.createString(it) }
    val __off_password = password?.let { builder.createString(it) }
    val __off_port = port?.let { builder.createString(it) }

    builder.startTable(3)
    __off_ssid?.let { builder.addOffset(0, it, 0) }
    __off_password?.let { builder.addOffset(1, it, 0) }
    __off_port?.let { builder.addOffset(2, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): StartWifiProvisioningRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_ssid = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_password = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_port = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return StartWifiProvisioningRequest(
              ssid = if (__offset_ssid != 0) { val strOff = tableOffset + __offset_ssid + bb.getInt(tableOffset + __offset_ssid); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              password = if (__offset_password != 0) { val strOff = tableOffset + __offset_password + bb.getInt(tableOffset + __offset_password); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              port = if (__offset_port != 0) { val strOff = tableOffset + __offset_port + bb.getInt(tableOffset + __offset_port); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null
          )
    }
  }
}

class StopWifiProvisioningRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): StopWifiProvisioningRequest = StopWifiProvisioningRequest()
  }
}

enum class WifiProvisioningStatus(
  val `value`: UByte,
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

  companion object {
    fun fromValue(`value`: UByte): WifiProvisioningStatus? = entries.firstOrNull { it.value == value }
  }
}

data class WifiProvisioningStatusResponse(
  val status: WifiProvisioningStatus? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(1)
    status?.let { builder.addByte(0, it.value.toByte(), 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): WifiProvisioningStatusResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_status = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return WifiProvisioningStatusResponse(
              status = if (__offset_status != 0) solarxr_protocol.rpc.WifiProvisioningStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) else null
          )
    }
  }
}

enum class AutoBoneProcessType(
  val `value`: UByte,
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

  companion object {
    fun fromValue(`value`: UByte): AutoBoneProcessType? = entries.firstOrNull { it.value == value }
  }
}

data class AutoBoneProcessRequest(
  val processType: AutoBoneProcessType? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(1)
    processType?.let { builder.addByte(0, it.value.toByte(), 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): AutoBoneProcessRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_processType = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return AutoBoneProcessRequest(
              processType = if (__offset_processType != 0) solarxr_protocol.rpc.AutoBoneProcessType.fromValue(bb.get(tableOffset + __offset_processType).toUByte()) else null
          )
    }
  }
}

data class AutoBoneProcessStatusResponse(
  val processType: AutoBoneProcessType? = null,
  val message: String? = null,
  val current: UInt = 0u,
  val total: UInt = 0u,
  val completed: Boolean = false,
  val success: Boolean = false,
  val eta: Float = 0.0f,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_message = message?.let { builder.createString(it) }

    builder.startTable(7)
    processType?.let { builder.addByte(0, it.value.toByte(), 0) }
    __off_message?.let { builder.addOffset(1, it, 0) }
    builder.addInt(2, current.toInt(), 0)
    builder.addInt(3, total.toInt(), 0)
    builder.addBoolean(4, completed, false)
    builder.addBoolean(5, success, false)
    builder.addFloat(6, eta, 0.0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): AutoBoneProcessStatusResponse {
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
              processType = if (__offset_processType != 0) solarxr_protocol.rpc.AutoBoneProcessType.fromValue(bb.get(tableOffset + __offset_processType).toUByte()) else null,
              message = if (__offset_message != 0) { val strOff = tableOffset + __offset_message + bb.getInt(tableOffset + __offset_message); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              current = if (__offset_current != 0) bb.getInt(tableOffset + __offset_current).toUInt() else 0u,
              total = if (__offset_total != 0) bb.getInt(tableOffset + __offset_total).toUInt() else 0u,
              completed = if (__offset_completed != 0) bb.get(tableOffset + __offset_completed) != 0.toByte() else false,
              success = if (__offset_success != 0) bb.get(tableOffset + __offset_success) != 0.toByte() else false,
              eta = if (__offset_eta != 0) bb.getFloat(tableOffset + __offset_eta) else 0.0f
          )
    }
  }
}

data class AutoBoneEpochResponse(
  val currentEpoch: UInt = 0u,
  val totalEpochs: UInt = 0u,
  val epochError: Float = 0.0f,
  val adjustedSkeletonParts: List<SkeletonPart>? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_adjustedSkeletonParts = adjustedSkeletonParts?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(4)
    builder.addInt(0, currentEpoch.toInt(), 0)
    builder.addInt(1, totalEpochs.toInt(), 0)
    builder.addFloat(2, epochError, 0.0)
    __off_adjustedSkeletonParts?.let { builder.addOffset(3, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): AutoBoneEpochResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_currentEpoch = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_totalEpochs = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_epochError = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_adjustedSkeletonParts = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return AutoBoneEpochResponse(
              currentEpoch = if (__offset_currentEpoch != 0) bb.getInt(tableOffset + __offset_currentEpoch).toUInt() else 0u,
              totalEpochs = if (__offset_totalEpochs != 0) bb.getInt(tableOffset + __offset_totalEpochs).toUInt() else 0u,
              epochError = if (__offset_epochError != 0) bb.getFloat(tableOffset + __offset_epochError) else 0.0f,
              adjustedSkeletonParts = if (__offset_adjustedSkeletonParts != 0) { val vecOff = tableOffset + __offset_adjustedSkeletonParts + bb.getInt(tableOffset + __offset_adjustedSkeletonParts); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.rpc.SkeletonPart.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) } } else null
          )
    }
  }
}

/**
 * https://github.com/SlimeVR/SlimeVR-Server/blob/v0.8.3/server/src/main/java/dev/slimevr/config/AutoBoneConfig.kt
 */
data class AutoBoneSettings(
  val cursorIncrement: Int? = null,
  val minDataDistance: Int? = null,
  val maxDataDistance: Int? = null,
  val numEpochs: Int? = null,
  val printEveryNumEpochs: Int? = null,
  val initialAdjustRate: Float? = null,
  val adjustRateDecay: Float? = null,
  val slideErrorFactor: Float? = null,
  val offsetSlideErrorFactor: Float? = null,
  val footHeightOffsetErrorFactor: Float? = null,
  val bodyProportionErrorFactor: Float? = null,
  val heightErrorFactor: Float? = null,
  val positionErrorFactor: Float? = null,
  val positionOffsetErrorFactor: Float? = null,
  val calcInitError: Boolean? = null,
  val randomizeFrameOrder: Boolean? = null,
  val scaleEachStep: Boolean? = null,
  val sampleCount: Int? = null,
  val sampleRateMs: Long? = null,
  val saveRecordings: Boolean? = null,
  val useSkeletonHeight: Boolean? = null,
  val randSeed: Long? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {

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
    if (sampleRateMs != null) { builder.forceDefaults(true); builder.addLong(18, sampleRateMs, 0); builder.forceDefaults(false) }
    if (saveRecordings != null) { builder.forceDefaults(true); builder.addBoolean(19, saveRecordings, false); builder.forceDefaults(false) }
    if (useSkeletonHeight != null) { builder.forceDefaults(true); builder.addBoolean(20, useSkeletonHeight, false); builder.forceDefaults(false) }
    if (randSeed != null) { builder.forceDefaults(true); builder.addLong(21, randSeed, 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): AutoBoneSettings {
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

class HeightRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): HeightRequest = HeightRequest()
  }
}

/**
 * Returns the current min and max positional tracker heights
 */
data class HeightResponse(
  val minHeight: Float = 0.0f,
  val maxHeight: Float = 0.0f,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(2)
    builder.addFloat(0, minHeight, 0.0)
    builder.addFloat(1, maxHeight, 0.0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): HeightResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_minHeight = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_maxHeight = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return HeightResponse(
              minHeight = if (__offset_minHeight != 0) bb.getFloat(tableOffset + __offset_minHeight) else 0.0f,
              maxHeight = if (__offset_maxHeight != 0) bb.getFloat(tableOffset + __offset_maxHeight) else 0.0f
          )
    }
  }
}

/**
 * Applies the estimated proportions
 */
class AutoBoneApplyRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): AutoBoneApplyRequest = AutoBoneApplyRequest()
  }
}

/**
 * Stops the current recording, using it as far as it has been recorded
 */
class AutoBoneStopRecordingRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): AutoBoneStopRecordingRequest = AutoBoneStopRecordingRequest()
  }
}

/**
 * Cancels the current recording, aborting the process and discarding the data
 */
class AutoBoneCancelRecordingRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): AutoBoneCancelRecordingRequest = AutoBoneCancelRecordingRequest()
  }
}

/**
 * Requests the current state of `OverlayDisplayModeResponse`.
 */
class OverlayDisplayModeRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): OverlayDisplayModeRequest = OverlayDisplayModeRequest()
  }
}

/**
 * Changes the state of the overlay's display mode.
 */
data class OverlayDisplayModeChangeRequest(
  val isVisible: Boolean? = null,
  val isMirrored: Boolean? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(2)
    if (isVisible != null) { builder.forceDefaults(true); builder.addBoolean(0, isVisible, false); builder.forceDefaults(false) }
    if (isMirrored != null) { builder.forceDefaults(true); builder.addBoolean(1, isMirrored, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): OverlayDisplayModeChangeRequest {
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
data class OverlayDisplayModeResponse(
  val isVisible: Boolean = false,
  val isMirrored: Boolean = false,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(2)
    builder.addBoolean(0, isVisible, false)
    builder.addBoolean(1, isMirrored, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): OverlayDisplayModeResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_isVisible = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_isMirrored = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return OverlayDisplayModeResponse(
              isVisible = if (__offset_isVisible != 0) bb.get(tableOffset + __offset_isVisible) != 0.toByte() else false,
              isMirrored = if (__offset_isMirrored != 0) bb.get(tableOffset + __offset_isMirrored) != 0.toByte() else false
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
class ServerInfosRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): ServerInfosRequest = ServerInfosRequest()
  }
}

/**
 * Holds the Server information, this is a basic table holding various information about the currently running server
 * like its local ip address (useful for standalone users so they can specify the ip of the server more easily) and any more
 * infos we might want to add in the future. (like java version, working dir, server version ....)
 * This only holds the local ip for now. But there will be other information added as we chose to display them on the gui for instance
 */
data class ServerInfosResponse(
  val localip: String? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_localip = localip?.let { builder.createString(it) }

    builder.startTable(1)
    __off_localip?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): ServerInfosResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_localip = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ServerInfosResponse(
              localip = if (__offset_localip != 0) { val strOff = tableOffset + __offset_localip + bb.getInt(tableOffset + __offset_localip); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null
          )
    }
  }
}

/**
 * Makes a temporary change to legtweaks. This is not saved to disk, and can be
 * cleared with `LegTweaksTmpClear`
 */
data class LegTweaksTmpChange(
  val floorClip: Boolean? = null,
  val skatingCorrection: Boolean? = null,
  val toeSnap: Boolean? = null,
  val footPlant: Boolean? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(4)
    if (floorClip != null) { builder.forceDefaults(true); builder.addBoolean(0, floorClip, false); builder.forceDefaults(false) }
    if (skatingCorrection != null) { builder.forceDefaults(true); builder.addBoolean(1, skatingCorrection, false); builder.forceDefaults(false) }
    if (toeSnap != null) { builder.forceDefaults(true); builder.addBoolean(2, toeSnap, false); builder.forceDefaults(false) }
    if (footPlant != null) { builder.forceDefaults(true); builder.addBoolean(3, footPlant, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): LegTweaksTmpChange {
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
data class LegTweaksTmpClear(
  val floorClip: Boolean = false,
  val skatingCorrection: Boolean = false,
  val toeSnap: Boolean = false,
  val footPlant: Boolean = false,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(4)
    builder.addBoolean(0, floorClip, false)
    builder.addBoolean(1, skatingCorrection, false)
    builder.addBoolean(2, toeSnap, false)
    builder.addBoolean(3, footPlant, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): LegTweaksTmpClear {
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

sealed interface StatusData {
  companion object {
    fun decode(
      type: Byte,
      bb: ByteBuffer,
      offset: Int,
    ): StatusData? = when (type.toInt()) {
      1 -> StatusTrackerReset.decode(bb, offset)
      2 -> StatusTrackerError.decode(bb, offset)
      3 -> StatusSteamVRDisconnected.decode(bb, offset)
      4 -> StatusUnassignedHMD.decode(bb, offset)
      5 -> StatusPublicNetwork.decode(bb, offset)
      else -> null
    }

    fun typeIndex(`value`: StatusData): Byte = when (value) {
      is StatusTrackerReset -> 1
      is StatusTrackerError -> 2
      is StatusSteamVRDisconnected -> 3
      is StatusUnassignedHMD -> 4
      is StatusPublicNetwork -> 5
      else -> 0
    }

    fun encode(`value`: StatusData, builder: FlatBufferBuilder): Int = when (value) {
      is StatusTrackerReset -> value.encode(builder)
      is StatusTrackerError -> value.encode(builder)
      is StatusSteamVRDisconnected -> value.encode(builder)
      is StatusUnassignedHMD -> value.encode(builder)
      is StatusPublicNetwork -> value.encode(builder)
      else -> 0
    }
  }
}

/**
 * Tracker requires full reset
 */
data class StatusTrackerReset(
  val trackerId: List<TrackerId>? = null,
) : StatusData {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_trackerId = trackerId?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(1)
    __off_trackerId?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): StatusTrackerReset {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StatusTrackerReset(
              trackerId = if (__offset_trackerId != 0) { val vecOff = tableOffset + __offset_trackerId + bb.getInt(tableOffset + __offset_trackerId); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.datatypes.TrackerId.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) } } else null
          )
    }
  }
}

/**
 * Trackers with error state
 */
data class StatusTrackerError(
  val trackerId: List<TrackerId>? = null,
) : StatusData {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_trackerId = trackerId?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(1)
    __off_trackerId?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): StatusTrackerError {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StatusTrackerError(
              trackerId = if (__offset_trackerId != 0) { val vecOff = tableOffset + __offset_trackerId + bb.getInt(tableOffset + __offset_trackerId); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.datatypes.TrackerId.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) } } else null
          )
    }
  }
}

/**
 * SteamVR bridge is disconnected
 */
data class StatusSteamVRDisconnected(
  val bridgeSettingsName: String? = null,
) : StatusData {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_bridgeSettingsName = bridgeSettingsName?.let { builder.createString(it) }

    builder.startTable(1)
    __off_bridgeSettingsName?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): StatusSteamVRDisconnected {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bridgeSettingsName = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StatusSteamVRDisconnected(
              bridgeSettingsName = if (__offset_bridgeSettingsName != 0) { val strOff = tableOffset + __offset_bridgeSettingsName + bb.getInt(tableOffset + __offset_bridgeSettingsName); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null
          )
    }
  }
}

/**
 * There is an available HMD tracker and it's not assigned to head
 */
data class StatusUnassignedHMD(
  val trackerId: TrackerId? = null,
) : StatusData {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_trackerId = trackerId?.encode(builder)

    builder.startTable(1)
    __off_trackerId?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): StatusUnassignedHMD {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StatusUnassignedHMD(
              trackerId = if (__offset_trackerId != 0) solarxr_protocol.datatypes.TrackerId.decode(bb, tableOffset + __offset_trackerId + bb.getInt(tableOffset + __offset_trackerId)) else null
          )
    }
  }
}

/**
 * Request current statuses that we have
 */
class StatusSystemRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): StatusSystemRequest = StatusSystemRequest()
  }
}

/**
 * Response containing all current valid statuses
 */
data class StatusSystemResponse(
  val currentStatuses: List<StatusMessage>? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_currentStatuses = currentStatuses?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(1)
    __off_currentStatuses?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): StatusSystemResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_currentStatuses = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StatusSystemResponse(
              currentStatuses = if (__offset_currentStatuses != 0) { val vecOff = tableOffset + __offset_currentStatuses + bb.getInt(tableOffset + __offset_currentStatuses); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.rpc.StatusMessage.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) } } else null
          )
    }
  }
}

/**
 * When a new status appears, it's sent alone
 */
data class StatusSystemUpdate(
  val newStatus: StatusMessage? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_newStatus = newStatus?.encode(builder)

    builder.startTable(1)
    __off_newStatus?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): StatusSystemUpdate {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_newStatus = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StatusSystemUpdate(
              newStatus = if (__offset_newStatus != 0) solarxr_protocol.rpc.StatusMessage.decode(bb, tableOffset + __offset_newStatus + bb.getInt(tableOffset + __offset_newStatus)) else null
          )
    }
  }
}

/**
 * When an status is fixed and it's removed, it's ID is sent
 */
data class StatusSystemFixed(
  val fixedStatusId: UInt = 0u,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(1)
    builder.addInt(0, fixedStatusId.toInt(), 0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): StatusSystemFixed {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_fixedStatusId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StatusSystemFixed(
              fixedStatusId = if (__offset_fixedStatusId != 0) bb.getInt(tableOffset + __offset_fixedStatusId).toUInt() else 0u
          )
    }
  }
}

/**
 * When the server detects a public network profile
 */
data class StatusPublicNetwork(
  val adapters: List<String>? = null,
) : StatusData {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_adapters = adapters?.let { builder.createVectorOfTables(it.map { s -> builder.createString(s) }.toIntArray()) }

    builder.startTable(1)
    __off_adapters?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): StatusPublicNetwork {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_adapters = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StatusPublicNetwork(
              adapters = if (__offset_adapters != 0) { val vecOff = tableOffset + __offset_adapters + bb.getInt(tableOffset + __offset_adapters); val len = bb.getInt(vecOff); (0 until len).map { i -> bb.getInt(vecOff + 4 + i * 4).let { strOff -> val len = bb.getInt(vecOff + 4 + i * 4 + strOff); ByteArray(len).also { bb.position(vecOff + 4 + i * 4 + strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } } } else null
          )
    }
  }
}

/**
 * An status is some kind of warning sent by the server, it's mainly made for
 * showing problems with the server and need attention from the user.
 */
data class StatusMessage(
  val id: UInt = 0u,
  val prioritized: Boolean = false,
  val `data`: StatusData? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_data = data?.let { StatusData.encode(it, builder) }
    val __type_data = data?.let { StatusData.typeIndex(it) } ?: 0.toByte()

    builder.startTable(4)
    builder.addInt(0, id.toInt(), 0)
    builder.addBoolean(1, prioritized, false)
    builder.addByte(2, __type_data, 0)
    __off_data?.let { builder.addOffset(3, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): StatusMessage {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_id = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_prioritized = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __type_data = if (vtableSize > 8 && bb.getShort(vtableOffset + 8).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 8).toInt()) else 0
      val __offset_data = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return StatusMessage(
              id = if (__offset_id != 0) bb.getInt(tableOffset + __offset_id).toUInt() else 0u,
              prioritized = if (__offset_prioritized != 0) bb.get(tableOffset + __offset_prioritized) != 0.toByte() else false,
              data = if (__offset_data != 0) solarxr_protocol.rpc.StatusData.decode(__type_data, bb, tableOffset + __offset_data + bb.getInt(tableOffset + __offset_data)) else null
          )
    }
  }
}

data class SetPauseTrackingRequest(
  val pausetracking: Boolean = false,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(1)
    builder.addBoolean(0, pausetracking, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SetPauseTrackingRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_pausetracking = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return SetPauseTrackingRequest(
              pausetracking = if (__offset_pausetracking != 0) bb.get(tableOffset + __offset_pausetracking) != 0.toByte() else false
          )
    }
  }
}

/**
 * Clears mounting reset data, defaulting to the manually set mounting orientations
 */
class ClearMountingResetRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): ClearMountingResetRequest = ClearMountingResetRequest()
  }
}

/**
 * Common folders often used in computers for storing files
 */
enum class ComputerDirectory(
  val `value`: UByte,
) {
  Documents(0.toUByte()),
  ;

  companion object {
    fun fromValue(`value`: UByte): ComputerDirectory? = entries.firstOrNull { it.value == value }
  }
}

/**
 * Used for the server to save a file and have it prompt in the user side
 */
data class SaveFileNotification(
  val `data`: List<UByte>? = null,
  val mimeType: String? = null,
  val fileExtension: String? = null,
  val expectedDir: ComputerDirectory? = null,
  val expectedFilename: String? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_data = data?.let { builder.createByteVector(it.map { b -> b.toByte() }.toByteArray()) }
    val __off_mimeType = mimeType?.let { builder.createString(it) }
    val __off_fileExtension = fileExtension?.let { builder.createString(it) }
    val __off_expectedFilename = expectedFilename?.let { builder.createString(it) }

    builder.startTable(5)
    __off_data?.let { builder.addOffset(0, it, 0) }
    __off_mimeType?.let { builder.addOffset(1, it, 0) }
    __off_fileExtension?.let { builder.addOffset(2, it, 0) }
    expectedDir?.let { builder.addByte(3, it.value.toByte(), 0) }
    __off_expectedFilename?.let { builder.addOffset(4, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SaveFileNotification {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_data = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_mimeType = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_fileExtension = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_expectedDir = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_expectedFilename = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return SaveFileNotification(
              data = if (__offset_data != 0) { val vecOff = tableOffset + __offset_data + bb.getInt(tableOffset + __offset_data); val len = bb.getInt(vecOff); (0 until len).map { i -> bb.get(vecOff + 4 + i * 1).toUByte() } } else null,
              mimeType = if (__offset_mimeType != 0) { val strOff = tableOffset + __offset_mimeType + bb.getInt(tableOffset + __offset_mimeType); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              fileExtension = if (__offset_fileExtension != 0) { val strOff = tableOffset + __offset_fileExtension + bb.getInt(tableOffset + __offset_fileExtension); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              expectedDir = if (__offset_expectedDir != 0) solarxr_protocol.rpc.ComputerDirectory.fromValue(bb.get(tableOffset + __offset_expectedDir).toUByte()) else null,
              expectedFilename = if (__offset_expectedFilename != 0) { val strOff = tableOffset + __offset_expectedFilename + bb.getInt(tableOffset + __offset_expectedFilename); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null
          )
    }
  }
}

enum class FirmwareUpdateStatus(
  val `value`: UByte,
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

  companion object {
    fun fromValue(`value`: UByte): FirmwareUpdateStatus? = entries.firstOrNull { it.value == value }
  }
}

data class SerialDevicePort(
  val port: String? = null,
) : FirmwareUpdateDeviceId {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_port = port?.let { builder.createString(it) }

    builder.startTable(1)
    __off_port?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SerialDevicePort {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_port = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return SerialDevicePort(
              port = if (__offset_port != 0) { val strOff = tableOffset + __offset_port + bb.getInt(tableOffset + __offset_port); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null
          )
    }
  }
}

interface FirmwareUpdateDeviceId {
  companion object {
    fun decode(
      type: Byte,
      bb: ByteBuffer,
      offset: Int,
    ): FirmwareUpdateDeviceId? = when (type.toInt()) {
      1 -> DeviceIdTable.decode(bb, offset)
      2 -> SerialDevicePort.decode(bb, offset)
      else -> null
    }

    fun typeIndex(`value`: FirmwareUpdateDeviceId): Byte = when (value) {
      is DeviceIdTable -> 1
      is SerialDevicePort -> 2
      else -> 0
    }

    fun encode(`value`: FirmwareUpdateDeviceId, builder: FlatBufferBuilder): Int = when (value) {
      is DeviceIdTable -> value.encode(builder)
      is SerialDevicePort -> value.encode(builder)
      else -> 0
    }
  }
}

data class FirmwarePart(
  val url: String? = null,
  val offset: UInt = 0u,
  val digest: String? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_url = url?.let { builder.createString(it) }
    val __off_digest = digest?.let { builder.createString(it) }

    builder.startTable(3)
    __off_url?.let { builder.addOffset(0, it, 0) }
    builder.addInt(1, offset.toInt(), 0)
    __off_digest?.let { builder.addOffset(2, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): FirmwarePart {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_url = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_offset = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_digest = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return FirmwarePart(
              url = if (__offset_url != 0) { val strOff = tableOffset + __offset_url + bb.getInt(tableOffset + __offset_url); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              offset = if (__offset_offset != 0) bb.getInt(tableOffset + __offset_offset).toUInt() else 0u,
              digest = if (__offset_digest != 0) { val strOff = tableOffset + __offset_digest + bb.getInt(tableOffset + __offset_digest); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null
          )
    }
  }
}

sealed interface FirmwareUpdateMethod {
  companion object {
    fun decode(
      type: Byte,
      bb: ByteBuffer,
      offset: Int,
    ): FirmwareUpdateMethod? = when (type.toInt()) {
      1 -> OTAFirmwareUpdate.decode(bb, offset)
      2 -> SerialFirmwareUpdate.decode(bb, offset)
      else -> null
    }

    fun typeIndex(`value`: FirmwareUpdateMethod): Byte = when (value) {
      is OTAFirmwareUpdate -> 1
      is SerialFirmwareUpdate -> 2
      else -> 0
    }

    fun encode(`value`: FirmwareUpdateMethod, builder: FlatBufferBuilder): Int = when (value) {
      is OTAFirmwareUpdate -> value.encode(builder)
      is SerialFirmwareUpdate -> value.encode(builder)
      else -> 0
    }
  }
}

data class FirmwareUpdateRequest(
  val method: FirmwareUpdateMethod? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_method = method?.let { FirmwareUpdateMethod.encode(it, builder) }
    val __type_method = method?.let { FirmwareUpdateMethod.typeIndex(it) } ?: 0.toByte()

    builder.startTable(2)
    builder.addByte(0, __type_method, 0)
    __off_method?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): FirmwareUpdateRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __type_method = if (vtableSize > 4 && bb.getShort(vtableOffset + 4).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 4).toInt()) else 0
      val __offset_method = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return FirmwareUpdateRequest(
              method = if (__offset_method != 0) solarxr_protocol.rpc.FirmwareUpdateMethod.decode(__type_method, bb, tableOffset + __offset_method + bb.getInt(tableOffset + __offset_method)) else null
          )
    }
  }
}

data class OTAFirmwareUpdate(
  val deviceId: DeviceId? = null,
  val firmwarePart: FirmwarePart? = null,
) : FirmwareUpdateMethod {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_firmwarePart = firmwarePart?.encode(builder)

    builder.startTable(2)
    deviceId?.let { builder.addStruct(0, it.encode(builder), 0) }
    __off_firmwarePart?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): OTAFirmwareUpdate {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_deviceId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_firmwarePart = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return OTAFirmwareUpdate(
              deviceId = if (__offset_deviceId != 0) solarxr_protocol.datatypes.DeviceId.decode(bb, tableOffset + __offset_deviceId) else null,
              firmwarePart = if (__offset_firmwarePart != 0) solarxr_protocol.rpc.FirmwarePart.decode(bb, tableOffset + __offset_firmwarePart + bb.getInt(tableOffset + __offset_firmwarePart)) else null
          )
    }
  }
}

data class SerialFirmwareUpdate(
  val deviceId: SerialDevicePort? = null,
  val needmanualreboot: Boolean = false,
  val ssid: String? = null,
  val password: String? = null,
  val firmwarePart: List<FirmwarePart>? = null,
) : FirmwareUpdateMethod {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_deviceId = deviceId?.encode(builder)
    val __off_ssid = ssid?.let { builder.createString(it) }
    val __off_password = password?.let { builder.createString(it) }
    val __off_firmwarePart = firmwarePart?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(5)
    __off_deviceId?.let { builder.addOffset(0, it, 0) }
    builder.addBoolean(1, needmanualreboot, false)
    __off_ssid?.let { builder.addOffset(2, it, 0) }
    __off_password?.let { builder.addOffset(3, it, 0) }
    __off_firmwarePart?.let { builder.addOffset(4, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SerialFirmwareUpdate {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_deviceId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_needmanualreboot = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_ssid = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_password = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_firmwarePart = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return SerialFirmwareUpdate(
              deviceId = if (__offset_deviceId != 0) solarxr_protocol.rpc.SerialDevicePort.decode(bb, tableOffset + __offset_deviceId + bb.getInt(tableOffset + __offset_deviceId)) else null,
              needmanualreboot = if (__offset_needmanualreboot != 0) bb.get(tableOffset + __offset_needmanualreboot) != 0.toByte() else false,
              ssid = if (__offset_ssid != 0) { val strOff = tableOffset + __offset_ssid + bb.getInt(tableOffset + __offset_ssid); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              password = if (__offset_password != 0) { val strOff = tableOffset + __offset_password + bb.getInt(tableOffset + __offset_password); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              firmwarePart = if (__offset_firmwarePart != 0) { val vecOff = tableOffset + __offset_firmwarePart + bb.getInt(tableOffset + __offset_firmwarePart); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.rpc.FirmwarePart.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) } } else null
          )
    }
  }
}

data class FirmwareUpdateStatusResponse(
  val deviceId: FirmwareUpdateDeviceId? = null,
  val status: FirmwareUpdateStatus? = null,
  val progress: Byte = 0,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_deviceId = deviceId?.let { FirmwareUpdateDeviceId.encode(it, builder) }
    val __type_deviceId = deviceId?.let { FirmwareUpdateDeviceId.typeIndex(it) } ?: 0.toByte()

    builder.startTable(4)
    builder.addByte(0, __type_deviceId, 0)
    __off_deviceId?.let { builder.addOffset(1, it, 0) }
    status?.let { builder.addByte(2, it.value.toByte(), 0) }
    builder.addByte(3, progress, 0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): FirmwareUpdateStatusResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __type_deviceId = if (vtableSize > 4 && bb.getShort(vtableOffset + 4).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 4).toInt()) else 0
      val __offset_deviceId = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_status = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_progress = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return FirmwareUpdateStatusResponse(
              deviceId = if (__offset_deviceId != 0) solarxr_protocol.rpc.FirmwareUpdateDeviceId.decode(__type_deviceId, bb, tableOffset + __offset_deviceId + bb.getInt(tableOffset + __offset_deviceId)) else null,
              status = if (__offset_status != 0) solarxr_protocol.rpc.FirmwareUpdateStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) else null,
              progress = if (__offset_progress != 0) bb.get(tableOffset + __offset_progress) else 0
          )
    }
  }
}

class FirmwareUpdateStopQueuesRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): FirmwareUpdateStopQueuesRequest = FirmwareUpdateStopQueuesRequest()
  }
}

/**
 * Requests the current state of tracking pause
 */
class TrackingPauseStateRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): TrackingPauseStateRequest = TrackingPauseStateRequest()
  }
}

data class TrackingPauseStateResponse(
  val trackingpaused: Boolean = false,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(1)
    builder.addBoolean(0, trackingpaused, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): TrackingPauseStateResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackingpaused = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TrackingPauseStateResponse(
              trackingpaused = if (__offset_trackingpaused != 0) bb.get(tableOffset + __offset_trackingpaused) != 0.toByte() else false
          )
    }
  }
}

/**
 * Sends the GET WIFISCAN cmd to the current tracker on the serial monitor
 */
class SerialTrackerGetWifiScanRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SerialTrackerGetWifiScanRequest = SerialTrackerGetWifiScanRequest()
  }
}

/**
 * Server notifies connection of an unknown device.
 * If the notification is no longer sent, it means the device connected to another
 * server, got connected to this server or it was turned off.
 */
data class UnknownDeviceHandshakeNotification(
  val macAddress: String? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_macAddress = macAddress?.let { builder.createString(it) }

    builder.startTable(1)
    __off_macAddress?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): UnknownDeviceHandshakeNotification {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_macAddress = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return UnknownDeviceHandshakeNotification(
              macAddress = if (__offset_macAddress != 0) { val strOff = tableOffset + __offset_macAddress + bb.getInt(tableOffset + __offset_macAddress); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null
          )
    }
  }
}

data class AddUnknownDeviceRequest(
  val macAddress: String? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_macAddress = macAddress?.let { builder.createString(it) }

    builder.startTable(1)
    __off_macAddress?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): AddUnknownDeviceRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_macAddress = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return AddUnknownDeviceRequest(
              macAddress = if (__offset_macAddress != 0) { val strOff = tableOffset + __offset_macAddress + bb.getInt(tableOffset + __offset_macAddress); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null
          )
    }
  }
}

data class ForgetDeviceRequest(
  val macAddress: String? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_macAddress = macAddress?.let { builder.createString(it) }

    builder.startTable(1)
    __off_macAddress?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): ForgetDeviceRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_macAddress = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ForgetDeviceRequest(
              macAddress = if (__offset_macAddress != 0) { val strOff = tableOffset + __offset_macAddress + bb.getInt(tableOffset + __offset_macAddress); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null
          )
    }
  }
}

class SettingsResetRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SettingsResetRequest = SettingsResetRequest()
  }
}

/**
 * If no tracker ID is given, it's the setting for every tracker/device
 */
data class MagToggleRequest(
  val trackerId: TrackerId? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_trackerId = trackerId?.encode(builder)

    builder.startTable(1)
    __off_trackerId?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): MagToggleRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return MagToggleRequest(
              trackerId = if (__offset_trackerId != 0) solarxr_protocol.datatypes.TrackerId.decode(bb, tableOffset + __offset_trackerId + bb.getInt(tableOffset + __offset_trackerId)) else null
          )
    }
  }
}

/**
 * If no tracker ID is given, it's the setting for every tracker/device
 */
data class MagToggleResponse(
  val trackerId: TrackerId? = null,
  val enable: Boolean = false,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_trackerId = trackerId?.encode(builder)

    builder.startTable(2)
    __off_trackerId?.let { builder.addOffset(0, it, 0) }
    builder.addBoolean(1, enable, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): MagToggleResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_enable = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return MagToggleResponse(
              trackerId = if (__offset_trackerId != 0) solarxr_protocol.datatypes.TrackerId.decode(bb, tableOffset + __offset_trackerId + bb.getInt(tableOffset + __offset_trackerId)) else null,
              enable = if (__offset_enable != 0) bb.get(tableOffset + __offset_enable) != 0.toByte() else false
          )
    }
  }
}

/**
 * If no tracker ID is given, it's the setting for every tracker/device
 */
data class ChangeMagToggleRequest(
  val trackerId: TrackerId? = null,
  val enable: Boolean = false,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_trackerId = trackerId?.encode(builder)

    builder.startTable(2)
    __off_trackerId?.let { builder.addOffset(0, it, 0) }
    builder.addBoolean(1, enable, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): ChangeMagToggleRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_enable = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return ChangeMagToggleRequest(
              trackerId = if (__offset_trackerId != 0) solarxr_protocol.datatypes.TrackerId.decode(bb, tableOffset + __offset_trackerId + bb.getInt(tableOffset + __offset_trackerId)) else null,
              enable = if (__offset_enable != 0) bb.get(tableOffset + __offset_enable) != 0.toByte() else false
          )
    }
  }
}

enum class VRCTrackerModel(
  val `value`: UByte,
) {
  UNKNOWN(0.toUByte()),
  SPHERE(1.toUByte()),
  SYSTEM(2.toUByte()),
  BOX(3.toUByte()),
  AXIS(4.toUByte()),
  ;

  companion object {
    fun fromValue(`value`: UByte): VRCTrackerModel? = entries.firstOrNull { it.value == value }
  }
}

enum class VRCSpineMode(
  val `value`: UByte,
) {
  UNKNOWN(0.toUByte()),
  LOCK_HIP(1.toUByte()),
  LOCK_HEAD(2.toUByte()),
  LOCK_BOTH(3.toUByte()),
  ;

  companion object {
    fun fromValue(`value`: UByte): VRCSpineMode? = entries.firstOrNull { it.value == value }
  }
}

enum class VRCAvatarMeasurementType(
  val `value`: UByte,
) {
  UNKNOWN(0.toUByte()),
  HEIGHT(1.toUByte()),
  ARM_SPAN(2.toUByte()),
  ;

  companion object {
    fun fromValue(`value`: UByte): VRCAvatarMeasurementType? = entries.firstOrNull { it.value == value }
  }
}

data class VRCConfigValidity(
  val legacyModeOk: Boolean = false,
  val shoulderTrackingOk: Boolean = false,
  val userHeightOk: Boolean = false,
  val calibrationRangeOk: Boolean = false,
  val calibrationVisualsOk: Boolean = false,
  val trackerModelOk: Boolean = false,
  val spineModeOk: Boolean = false,
  val avatarMeasurementTypeOk: Boolean = false,
  val shoulderWidthCompensationOk: Boolean = false,
) {
  fun encode(builder: FlatBufferBuilder): Int {

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

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): VRCConfigValidity {
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

data class VRCConfigValues(
  val legacyMode: Boolean = false,
  val shoulderTrackingDisabled: Boolean = false,
  val userHeight: Float = 0.0f,
  val calibrationRange: Float = 0.0f,
  val calibrationVisuals: Boolean = false,
  val trackerModel: VRCTrackerModel? = null,
  val spineMode: VRCSpineMode? = null,
  val avatarMeasurementType: VRCAvatarMeasurementType? = null,
  val shoulderWidthCompensation: Boolean = false,
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(9)
    builder.addBoolean(0, legacyMode, false)
    builder.addBoolean(1, shoulderTrackingDisabled, false)
    builder.addFloat(2, userHeight, 0.0)
    builder.addFloat(3, calibrationRange, 0.0)
    builder.addBoolean(4, calibrationVisuals, false)
    trackerModel?.let { builder.addByte(5, it.value.toByte(), 0) }
    spineMode?.let { builder.addByte(6, it.value.toByte(), 0) }
    avatarMeasurementType?.let { builder.addByte(7, it.value.toByte(), 0) }
    builder.addBoolean(8, shoulderWidthCompensation, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): VRCConfigValues {
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
              trackerModel = if (__offset_trackerModel != 0) solarxr_protocol.rpc.VRCTrackerModel.fromValue(bb.get(tableOffset + __offset_trackerModel).toUByte()) else null,
              spineMode = if (__offset_spineMode != 0) solarxr_protocol.rpc.VRCSpineMode.fromValue(bb.get(tableOffset + __offset_spineMode).toUByte()) else null,
              avatarMeasurementType = if (__offset_avatarMeasurementType != 0) solarxr_protocol.rpc.VRCAvatarMeasurementType.fromValue(bb.get(tableOffset + __offset_avatarMeasurementType).toUByte()) else null,
              shoulderWidthCompensation = if (__offset_shoulderWidthCompensation != 0) bb.get(tableOffset + __offset_shoulderWidthCompensation) != 0.toByte() else false
          )
    }
  }
}

data class VRCConfigRecommendedValues(
  val legacyMode: Boolean = false,
  val shoulderTrackingDisabled: Boolean = false,
  val userHeight: Float = 0.0f,
  val calibrationRange: Float = 0.0f,
  val calibrationVisuals: Boolean = false,
  val trackerModel: VRCTrackerModel? = null,
  val spineMode: List<VRCSpineMode>? = null,
  val avatarMeasurementType: VRCAvatarMeasurementType? = null,
  val shoulderWidthCompensation: Boolean = false,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_spineMode = spineMode?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }

    builder.startTable(9)
    builder.addBoolean(0, legacyMode, false)
    builder.addBoolean(1, shoulderTrackingDisabled, false)
    builder.addFloat(2, userHeight, 0.0)
    builder.addFloat(3, calibrationRange, 0.0)
    builder.addBoolean(4, calibrationVisuals, false)
    trackerModel?.let { builder.addByte(5, it.value.toByte(), 0) }
    __off_spineMode?.let { builder.addOffset(6, it, 0) }
    avatarMeasurementType?.let { builder.addByte(7, it.value.toByte(), 0) }
    builder.addBoolean(8, shoulderWidthCompensation, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): VRCConfigRecommendedValues {
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
              trackerModel = if (__offset_trackerModel != 0) solarxr_protocol.rpc.VRCTrackerModel.fromValue(bb.get(tableOffset + __offset_trackerModel).toUByte()) else null,
              spineMode = if (__offset_spineMode != 0) { val vecOff = tableOffset + __offset_spineMode + bb.getInt(tableOffset + __offset_spineMode); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.rpc.VRCSpineMode.fromValue(bb.get(vecOff + 4 + i * 1).toUByte())!! } } else null,
              avatarMeasurementType = if (__offset_avatarMeasurementType != 0) solarxr_protocol.rpc.VRCAvatarMeasurementType.fromValue(bb.get(tableOffset + __offset_avatarMeasurementType).toUByte()) else null,
              shoulderWidthCompensation = if (__offset_shoulderWidthCompensation != 0) bb.get(tableOffset + __offset_shoulderWidthCompensation) != 0.toByte() else false
          )
    }
  }
}

class VRCConfigStateRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): VRCConfigStateRequest = VRCConfigStateRequest()
  }
}

/**
 * Sent every time the vrchat config state gets updated
 * used to display vrchat missconfig settings to the user
 */
data class VRCConfigStateChangeResponse(
  val isSupported: Boolean = false,
  val validity: VRCConfigValidity? = null,
  val state: VRCConfigValues? = null,
  val recommended: VRCConfigRecommendedValues? = null,
  val muted: List<String>? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
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

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): VRCConfigStateChangeResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_isSupported = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_validity = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_state = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_recommended = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_muted = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return VRCConfigStateChangeResponse(
              isSupported = if (__offset_isSupported != 0) bb.get(tableOffset + __offset_isSupported) != 0.toByte() else false,
              validity = if (__offset_validity != 0) solarxr_protocol.rpc.VRCConfigValidity.decode(bb, tableOffset + __offset_validity + bb.getInt(tableOffset + __offset_validity)) else null,
              state = if (__offset_state != 0) solarxr_protocol.rpc.VRCConfigValues.decode(bb, tableOffset + __offset_state + bb.getInt(tableOffset + __offset_state)) else null,
              recommended = if (__offset_recommended != 0) solarxr_protocol.rpc.VRCConfigRecommendedValues.decode(bb, tableOffset + __offset_recommended + bb.getInt(tableOffset + __offset_recommended)) else null,
              muted = if (__offset_muted != 0) { val vecOff = tableOffset + __offset_muted + bb.getInt(tableOffset + __offset_muted); val len = bb.getInt(vecOff); (0 until len).map { i -> bb.getInt(vecOff + 4 + i * 4).let { strOff -> val len = bb.getInt(vecOff + 4 + i * 4 + strOff); ByteArray(len).also { bb.position(vecOff + 4 + i * 4 + strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } } } else null
          )
    }
  }
}

data class VRCConfigSettingToggleMute(
  val key: String? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_key = key?.let { builder.createString(it) }

    builder.startTable(1)
    __off_key?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): VRCConfigSettingToggleMute {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_key = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return VRCConfigSettingToggleMute(
              key = if (__offset_key != 0) { val strOff = tableOffset + __offset_key + bb.getInt(tableOffset + __offset_key); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null
          )
    }
  }
}

enum class TrackingChecklistStepId(
  val `value`: UByte,
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
  ;

  companion object {
    fun fromValue(`value`: UByte): TrackingChecklistStepId? = entries.firstOrNull { it.value == value }
  }
}

enum class TrackingChecklistStepVisibility(
  val `value`: UByte,
) {
  ALWAYS(0.toUByte()),
  WHEN_INVALID(1.toUByte()),
  ;

  companion object {
    fun fromValue(`value`: UByte): TrackingChecklistStepVisibility? = entries.firstOrNull { it.value == value }
  }
}

/**
 * Trackers that need a reset
 */
data class TrackingChecklistTrackerReset(
  val trackersId: List<TrackerId>? = null,
) : TrackingChecklistExtraData {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_trackersId = trackersId?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(1)
    __off_trackersId?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): TrackingChecklistTrackerReset {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackersId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TrackingChecklistTrackerReset(
              trackersId = if (__offset_trackersId != 0) { val vecOff = tableOffset + __offset_trackersId + bb.getInt(tableOffset + __offset_trackersId); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.datatypes.TrackerId.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) } } else null
          )
    }
  }
}

/**
 * Trackers with error state
 */
data class TrackingChecklistTrackerError(
  val trackersId: List<TrackerId>? = null,
) : TrackingChecklistExtraData {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_trackersId = trackersId?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(1)
    __off_trackersId?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): TrackingChecklistTrackerError {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackersId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TrackingChecklistTrackerError(
              trackersId = if (__offset_trackersId != 0) { val vecOff = tableOffset + __offset_trackersId + bb.getInt(tableOffset + __offset_trackersId); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.datatypes.TrackerId.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) } } else null
          )
    }
  }
}

data class TrackingChecklistNeedCalibration(
  val trackersId: List<TrackerId>? = null,
) : TrackingChecklistExtraData {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_trackersId = trackersId?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(1)
    __off_trackersId?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): TrackingChecklistNeedCalibration {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackersId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TrackingChecklistNeedCalibration(
              trackersId = if (__offset_trackersId != 0) { val vecOff = tableOffset + __offset_trackersId + bb.getInt(tableOffset + __offset_trackersId); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.datatypes.TrackerId.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) } } else null
          )
    }
  }
}

data class TrackingChecklistSteamVRDisconnected(
  val bridgeSettingsName: String? = null,
) : TrackingChecklistExtraData {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_bridgeSettingsName = bridgeSettingsName?.let { builder.createString(it) }

    builder.startTable(1)
    __off_bridgeSettingsName?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): TrackingChecklistSteamVRDisconnected {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bridgeSettingsName = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TrackingChecklistSteamVRDisconnected(
              bridgeSettingsName = if (__offset_bridgeSettingsName != 0) { val strOff = tableOffset + __offset_bridgeSettingsName + bb.getInt(tableOffset + __offset_bridgeSettingsName); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null
          )
    }
  }
}

data class TrackingChecklistUnassignedHMD(
  val trackerId: TrackerId? = null,
) : TrackingChecklistExtraData {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_trackerId = trackerId?.encode(builder)

    builder.startTable(1)
    __off_trackerId?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): TrackingChecklistUnassignedHMD {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TrackingChecklistUnassignedHMD(
              trackerId = if (__offset_trackerId != 0) solarxr_protocol.datatypes.TrackerId.decode(bb, tableOffset + __offset_trackerId + bb.getInt(tableOffset + __offset_trackerId)) else null
          )
    }
  }
}

data class TrackingChecklistPublicNetworks(
  val adapters: List<String>? = null,
) : TrackingChecklistExtraData {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_adapters = adapters?.let { builder.createVectorOfTables(it.map { s -> builder.createString(s) }.toIntArray()) }

    builder.startTable(1)
    __off_adapters?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): TrackingChecklistPublicNetworks {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_adapters = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TrackingChecklistPublicNetworks(
              adapters = if (__offset_adapters != 0) { val vecOff = tableOffset + __offset_adapters + bb.getInt(tableOffset + __offset_adapters); val len = bb.getInt(vecOff); (0 until len).map { i -> bb.getInt(vecOff + 4 + i * 4).let { strOff -> val len = bb.getInt(vecOff + 4 + i * 4 + strOff); ByteArray(len).also { bb.position(vecOff + 4 + i * 4 + strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } } } else null
          )
    }
  }
}

sealed interface TrackingChecklistExtraData {
  companion object {
    fun decode(
      type: Byte,
      bb: ByteBuffer,
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

    fun typeIndex(`value`: TrackingChecklistExtraData): Byte = when (value) {
      is TrackingChecklistTrackerReset -> 1
      is TrackingChecklistTrackerError -> 2
      is TrackingChecklistSteamVRDisconnected -> 3
      is TrackingChecklistUnassignedHMD -> 4
      is TrackingChecklistNeedCalibration -> 5
      is TrackingChecklistPublicNetworks -> 6
      else -> 0
    }

    fun encode(`value`: TrackingChecklistExtraData, builder: FlatBufferBuilder): Int = when (value) {
      is TrackingChecklistTrackerReset -> value.encode(builder)
      is TrackingChecklistTrackerError -> value.encode(builder)
      is TrackingChecklistSteamVRDisconnected -> value.encode(builder)
      is TrackingChecklistUnassignedHMD -> value.encode(builder)
      is TrackingChecklistNeedCalibration -> value.encode(builder)
      is TrackingChecklistPublicNetworks -> value.encode(builder)
      else -> 0
    }
  }
}

data class TrackingChecklistStep(
  val id: TrackingChecklistStepId? = null,
  val valid: Boolean = false,
  val enabled: Boolean = false,
  val visibility: TrackingChecklistStepVisibility? = null,
  val optional: Boolean = false,
  val ignorable: Boolean = false,
  val extraData: TrackingChecklistExtraData? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_extraData = extraData?.let { TrackingChecklistExtraData.encode(it, builder) }
    val __type_extraData = extraData?.let { TrackingChecklistExtraData.typeIndex(it) } ?: 0.toByte()

    builder.startTable(8)
    id?.let { builder.addByte(0, it.value.toByte(), 0) }
    builder.addBoolean(1, valid, false)
    builder.addBoolean(2, enabled, false)
    visibility?.let { builder.addByte(3, it.value.toByte(), 0) }
    builder.addBoolean(4, optional, false)
    builder.addBoolean(5, ignorable, false)
    builder.addByte(6, __type_extraData, 0)
    __off_extraData?.let { builder.addOffset(7, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): TrackingChecklistStep {
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
              id = if (__offset_id != 0) solarxr_protocol.rpc.TrackingChecklistStepId.fromValue(bb.get(tableOffset + __offset_id).toUByte()) else null,
              valid = if (__offset_valid != 0) bb.get(tableOffset + __offset_valid) != 0.toByte() else false,
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else false,
              visibility = if (__offset_visibility != 0) solarxr_protocol.rpc.TrackingChecklistStepVisibility.fromValue(bb.get(tableOffset + __offset_visibility).toUByte()) else null,
              optional = if (__offset_optional != 0) bb.get(tableOffset + __offset_optional) != 0.toByte() else false,
              ignorable = if (__offset_ignorable != 0) bb.get(tableOffset + __offset_ignorable) != 0.toByte() else false,
              extraData = if (__offset_extraData != 0) solarxr_protocol.rpc.TrackingChecklistExtraData.decode(__type_extraData, bb, tableOffset + __offset_extraData + bb.getInt(tableOffset + __offset_extraData)) else null
          )
    }
  }
}

class TrackingChecklistRequest : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): TrackingChecklistRequest = TrackingChecklistRequest()
  }
}

data class TrackingChecklistResponse(
  val steps: List<TrackingChecklistStep>? = null,
  val ignoredSteps: List<TrackingChecklistStepId>? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_steps = steps?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }
    val __off_ignoredSteps = ignoredSteps?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }

    builder.startTable(2)
    __off_steps?.let { builder.addOffset(0, it, 0) }
    __off_ignoredSteps?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): TrackingChecklistResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_steps = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_ignoredSteps = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return TrackingChecklistResponse(
              steps = if (__offset_steps != 0) { val vecOff = tableOffset + __offset_steps + bb.getInt(tableOffset + __offset_steps); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.rpc.TrackingChecklistStep.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) } } else null,
              ignoredSteps = if (__offset_ignoredSteps != 0) { val vecOff = tableOffset + __offset_ignoredSteps + bb.getInt(tableOffset + __offset_ignoredSteps); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.rpc.TrackingChecklistStepId.fromValue(bb.get(vecOff + 4 + i * 1).toUByte())!! } } else null
          )
    }
  }
}

data class IgnoreTrackingChecklistStepRequest(
  val stepId: TrackingChecklistStepId? = null,
  val ignore: Boolean = false,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(2)
    stepId?.let { builder.addByte(0, it.value.toByte(), 0) }
    builder.addBoolean(1, ignore, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): IgnoreTrackingChecklistStepRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_stepId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_ignore = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return IgnoreTrackingChecklistStepRequest(
              stepId = if (__offset_stepId != 0) solarxr_protocol.rpc.TrackingChecklistStepId.fromValue(bb.get(tableOffset + __offset_stepId).toUByte()) else null,
              ignore = if (__offset_ignore != 0) bb.get(tableOffset + __offset_ignore) != 0.toByte() else false
          )
    }
  }
}

data class EnableStayAlignedRequest(
  val enable: Boolean = false,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(1)
    builder.addBoolean(0, enable, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): EnableStayAlignedRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enable = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return EnableStayAlignedRequest(
              enable = if (__offset_enable != 0) bb.get(tableOffset + __offset_enable) != 0.toByte() else false
          )
    }
  }
}

enum class StayAlignedRelaxedPose(
  val `value`: UByte,
) {
  STANDING(0.toUByte()),
  SITTING(1.toUByte()),
  FLAT(2.toUByte()),
  ;

  companion object {
    fun fromValue(`value`: UByte): StayAlignedRelaxedPose? = entries.firstOrNull { it.value == value }
  }
}

data class DetectStayAlignedRelaxedPoseRequest(
  val pose: StayAlignedRelaxedPose? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(1)
    pose?.let { builder.addByte(0, it.value.toByte(), 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): DetectStayAlignedRelaxedPoseRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_pose = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return DetectStayAlignedRelaxedPoseRequest(
              pose = if (__offset_pose != 0) solarxr_protocol.rpc.StayAlignedRelaxedPose.fromValue(bb.get(tableOffset + __offset_pose).toUByte()) else null
          )
    }
  }
}

data class ResetStayAlignedRelaxedPoseRequest(
  val pose: StayAlignedRelaxedPose? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(1)
    pose?.let { builder.addByte(0, it.value.toByte(), 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): ResetStayAlignedRelaxedPoseRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_pose = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ResetStayAlignedRelaxedPoseRequest(
              pose = if (__offset_pose != 0) solarxr_protocol.rpc.StayAlignedRelaxedPose.fromValue(bb.get(tableOffset + __offset_pose).toUByte()) else null
          )
    }
  }
}

class StartUserHeightCalibration : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): StartUserHeightCalibration = StartUserHeightCalibration()
  }
}

class CancelUserHeightCalibration : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): CancelUserHeightCalibration = CancelUserHeightCalibration()
  }
}

enum class UserHeightCalibrationStatus(
  val `value`: UByte,
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

  companion object {
    fun fromValue(`value`: UByte): UserHeightCalibrationStatus? = entries.firstOrNull { it.value == value }
  }
}

data class UserHeightRecordingStatusResponse(
  val hmdheight: Float = 0.0f,
  val status: UserHeightCalibrationStatus? = null,
) : RpcMessage {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(2)
    builder.addFloat(0, hmdheight, 0.0)
    status?.let { builder.addByte(1, it.value.toByte(), 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): UserHeightRecordingStatusResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_hmdheight = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_status = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return UserHeightRecordingStatusResponse(
              hmdheight = if (__offset_hmdheight != 0) bb.getFloat(tableOffset + __offset_hmdheight) else 0.0f,
              status = if (__offset_status != 0) solarxr_protocol.rpc.UserHeightCalibrationStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) else null
          )
    }
  }
}
