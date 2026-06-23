package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.UShort

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
