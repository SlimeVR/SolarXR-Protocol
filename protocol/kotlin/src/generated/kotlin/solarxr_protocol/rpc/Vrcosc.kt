package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.ULong
import kotlin.UShort
import kotlin.collections.List

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
  public val useManualNetwork: Boolean? = null,
  public val portIn: UShort? = null,
  public val portOut: UShort? = null,
  public val address: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_address = address?.let { builder.createString(it) }

    builder.startTable(5)
    if (enabled != null) { builder.forceDefaults(true); builder.addBoolean(0, enabled, false); builder.forceDefaults(false) }
    if (useManualNetwork != null) { builder.forceDefaults(true); builder.addBoolean(1, useManualNetwork, false); builder.forceDefaults(false) }
    if (portIn != null) { builder.forceDefaults(true); builder.addShort(2, portIn.toShort(), 0); builder.forceDefaults(false) }
    if (portOut != null) { builder.forceDefaults(true); builder.addShort(3, portOut.toShort(), 0); builder.forceDefaults(false) }
    __off_address?.let { builder.addOffset(4, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VRCOSCSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_useManualNetwork = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_portIn = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_portOut = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_address = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return VRCOSCSettingsResponse(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else null,
              useManualNetwork = if (__offset_useManualNetwork != 0) bb.get(tableOffset + __offset_useManualNetwork) != 0.toByte() else null,
              portIn = if (__offset_portIn != 0) bb.getShort(tableOffset + __offset_portIn).toUShort() else null,
              portOut = if (__offset_portOut != 0) bb.getShort(tableOffset + __offset_portOut).toUShort() else null,
              address = if (__offset_address != 0) readFlatBufferString(bb, tableOffset + __offset_address) else null
          )
    }
  }
}

public data class ChangeVRCOSCSettingsRequest(
  public val enabled: Boolean? = null,
  public val useManualNetwork: Boolean? = null,
  public val portIn: UShort? = null,
  public val portOut: UShort? = null,
  public val address: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_address = address?.let { builder.createString(it) }

    builder.startTable(5)
    if (enabled != null) { builder.forceDefaults(true); builder.addBoolean(0, enabled, false); builder.forceDefaults(false) }
    if (useManualNetwork != null) { builder.forceDefaults(true); builder.addBoolean(1, useManualNetwork, false); builder.forceDefaults(false) }
    if (portIn != null) { builder.forceDefaults(true); builder.addShort(2, portIn.toShort(), 0); builder.forceDefaults(false) }
    if (portOut != null) { builder.forceDefaults(true); builder.addShort(3, portOut.toShort(), 0); builder.forceDefaults(false) }
    __off_address?.let { builder.addOffset(4, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeVRCOSCSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_useManualNetwork = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_portIn = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_portOut = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_address = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return ChangeVRCOSCSettingsRequest(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else null,
              useManualNetwork = if (__offset_useManualNetwork != 0) bb.get(tableOffset + __offset_useManualNetwork) != 0.toByte() else null,
              portIn = if (__offset_portIn != 0) bb.getShort(tableOffset + __offset_portIn).toUShort() else null,
              portOut = if (__offset_portOut != 0) bb.getShort(tableOffset + __offset_portOut).toUShort() else null,
              address = if (__offset_address != 0) readFlatBufferString(bb, tableOffset + __offset_address) else null
          )
    }
  }
}
