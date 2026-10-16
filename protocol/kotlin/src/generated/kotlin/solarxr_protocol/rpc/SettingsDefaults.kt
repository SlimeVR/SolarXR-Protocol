package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Int

public class SettingsDefaultsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SettingsDefaultsRequest = SettingsDefaultsRequest()
  }
}

public data class SettingsDefaultsResponse(
  public val skeleton: SkeletonSettingsResponse? = null,
  public val resets: ResetsSettingsResponse? = null,
  public val stayAligned: StayAlignedSettingsResponse? = null,
  public val tapDetection: TapDetectionSettingsResponse? = null,
  public val timeout: TimeoutSettingsResponse? = null,
  public val hid: HIDSettingsResponse? = null,
  public val driver: DriverSettingsResponse? = null,
  public val vrcosc: VRCOSCSettingsResponse? = null,
  public val vmcosc: VMCOSCSettingsResponse? = null,
  public val vrm: VRMSettingsResponse? = null,
  public val boneRouting: BoneRoutingSettingsResponse? = null,
  public val errorReporting: ErrorReportingSettingsResponse? = null,
  public val mag: MagToggleResponse? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_skeleton = skeleton?.encode(builder)
    val __off_resets = resets?.encode(builder)
    val __off_stayAligned = stayAligned?.encode(builder)
    val __off_tapDetection = tapDetection?.encode(builder)
    val __off_timeout = timeout?.encode(builder)
    val __off_hid = hid?.encode(builder)
    val __off_driver = driver?.encode(builder)
    val __off_vrcosc = vrcosc?.encode(builder)
    val __off_vmcosc = vmcosc?.encode(builder)
    val __off_vrm = vrm?.encode(builder)
    val __off_boneRouting = boneRouting?.encode(builder)
    val __off_errorReporting = errorReporting?.encode(builder)
    val __off_mag = mag?.encode(builder)

    builder.startTable(13)
    __off_skeleton?.let { builder.addOffset(0, it, 0) }
    __off_resets?.let { builder.addOffset(1, it, 0) }
    __off_stayAligned?.let { builder.addOffset(2, it, 0) }
    __off_tapDetection?.let { builder.addOffset(3, it, 0) }
    __off_timeout?.let { builder.addOffset(4, it, 0) }
    __off_hid?.let { builder.addOffset(5, it, 0) }
    __off_driver?.let { builder.addOffset(6, it, 0) }
    __off_vrcosc?.let { builder.addOffset(7, it, 0) }
    __off_vmcosc?.let { builder.addOffset(8, it, 0) }
    __off_vrm?.let { builder.addOffset(9, it, 0) }
    __off_boneRouting?.let { builder.addOffset(10, it, 0) }
    __off_errorReporting?.let { builder.addOffset(11, it, 0) }
    __off_mag?.let { builder.addOffset(12, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SettingsDefaultsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_skeleton = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_resets = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_stayAligned = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_tapDetection = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_timeout = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_hid = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_driver = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_vrcosc = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_vmcosc = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_vrm = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_boneRouting = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_errorReporting = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0
      val __offset_mag = if (vtableSize > 28) bb.getShort(vtableOffset + 28).toInt() else 0

      return SettingsDefaultsResponse(
              skeleton = if (__offset_skeleton != 0) SkeletonSettingsResponse.decode(bb, tableOffset + __offset_skeleton + bb.getInt(tableOffset + __offset_skeleton)) else null,
              resets = if (__offset_resets != 0) ResetsSettingsResponse.decode(bb, tableOffset + __offset_resets + bb.getInt(tableOffset + __offset_resets)) else null,
              stayAligned = if (__offset_stayAligned != 0) StayAlignedSettingsResponse.decode(bb, tableOffset + __offset_stayAligned + bb.getInt(tableOffset + __offset_stayAligned)) else null,
              tapDetection = if (__offset_tapDetection != 0) TapDetectionSettingsResponse.decode(bb, tableOffset + __offset_tapDetection + bb.getInt(tableOffset + __offset_tapDetection)) else null,
              timeout = if (__offset_timeout != 0) TimeoutSettingsResponse.decode(bb, tableOffset + __offset_timeout + bb.getInt(tableOffset + __offset_timeout)) else null,
              hid = if (__offset_hid != 0) HIDSettingsResponse.decode(bb, tableOffset + __offset_hid + bb.getInt(tableOffset + __offset_hid)) else null,
              driver = if (__offset_driver != 0) DriverSettingsResponse.decode(bb, tableOffset + __offset_driver + bb.getInt(tableOffset + __offset_driver)) else null,
              vrcosc = if (__offset_vrcosc != 0) VRCOSCSettingsResponse.decode(bb, tableOffset + __offset_vrcosc + bb.getInt(tableOffset + __offset_vrcosc)) else null,
              vmcosc = if (__offset_vmcosc != 0) VMCOSCSettingsResponse.decode(bb, tableOffset + __offset_vmcosc + bb.getInt(tableOffset + __offset_vmcosc)) else null,
              vrm = if (__offset_vrm != 0) VRMSettingsResponse.decode(bb, tableOffset + __offset_vrm + bb.getInt(tableOffset + __offset_vrm)) else null,
              boneRouting = if (__offset_boneRouting != 0) BoneRoutingSettingsResponse.decode(bb, tableOffset + __offset_boneRouting + bb.getInt(tableOffset + __offset_boneRouting)) else null,
              errorReporting = if (__offset_errorReporting != 0) ErrorReportingSettingsResponse.decode(bb, tableOffset + __offset_errorReporting + bb.getInt(tableOffset + __offset_errorReporting)) else null,
              mag = if (__offset_mag != 0) MagToggleResponse.decode(bb, tableOffset + __offset_mag + bb.getInt(tableOffset + __offset_mag)) else null
          )
    }
  }
}
