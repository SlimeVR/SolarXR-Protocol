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
  public val enabled: Boolean = false,
  public val portIn: UShort = 0.toUShort(),
  public val portOut: UShort = 0.toUShort(),
  public val address: String? = null,
  public val anchorHip: Boolean = false,
  public val mirrorTracking: Boolean = false,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_address = address?.let { builder.createString(it) }

    builder.startTable(6)
    builder.addBoolean(0, enabled, false)
    builder.addShort(1, portIn.toShort(), 0)
    builder.addShort(2, portOut.toShort(), 0)
    __off_address?.let { builder.addOffset(3, it, 0) }
    builder.addBoolean(4, anchorHip, false)
    builder.addBoolean(5, mirrorTracking, false)
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
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else false,
              portIn = if (__offset_portIn != 0) bb.getShort(tableOffset + __offset_portIn).toUShort() else 0.toUShort(),
              portOut = if (__offset_portOut != 0) bb.getShort(tableOffset + __offset_portOut).toUShort() else 0.toUShort(),
              address = if (__offset_address != 0) readFlatBufferString(bb, tableOffset + __offset_address) else null,
              anchorHip = if (__offset_anchorHip != 0) bb.get(tableOffset + __offset_anchorHip) != 0.toByte() else false,
              mirrorTracking = if (__offset_mirrorTracking != 0) bb.get(tableOffset + __offset_mirrorTracking) != 0.toByte() else false
          )
    }
  }
}

public data class ChangeVMCOSCSettingsRequest(
  public val enabled: Boolean = false,
  public val portIn: UShort = 0.toUShort(),
  public val portOut: UShort = 0.toUShort(),
  public val address: String? = null,
  public val anchorHip: Boolean = false,
  public val mirrorTracking: Boolean = false,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_address = address?.let { builder.createString(it) }

    builder.startTable(6)
    builder.addBoolean(0, enabled, false)
    builder.addShort(1, portIn.toShort(), 0)
    builder.addShort(2, portOut.toShort(), 0)
    __off_address?.let { builder.addOffset(3, it, 0) }
    builder.addBoolean(4, anchorHip, false)
    builder.addBoolean(5, mirrorTracking, false)
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
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else false,
              portIn = if (__offset_portIn != 0) bb.getShort(tableOffset + __offset_portIn).toUShort() else 0.toUShort(),
              portOut = if (__offset_portOut != 0) bb.getShort(tableOffset + __offset_portOut).toUShort() else 0.toUShort(),
              address = if (__offset_address != 0) readFlatBufferString(bb, tableOffset + __offset_address) else null,
              anchorHip = if (__offset_anchorHip != 0) bb.get(tableOffset + __offset_anchorHip) != 0.toByte() else false,
              mirrorTracking = if (__offset_mirrorTracking != 0) bb.get(tableOffset + __offset_mirrorTracking) != 0.toByte() else false
          )
    }
  }
}

public enum class VMCOSCInputState(
  public val `value`: UByte,
) {
  IDLE(0.toUByte()),
  LISTENING(1.toUByte()),
  ERROR(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): VMCOSCInputState? = entries.firstOrNull { it.value == value }
  }
}

public enum class VMCOSCOutputState(
  public val `value`: UByte,
) {
  IDLE(0.toUByte()),
  READY(1.toUByte()),
  ERROR(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): VMCOSCOutputState? = entries.firstOrNull { it.value == value }
  }
}

public enum class VMCOSCVrmState(
  public val `value`: UByte,
) {
  NONE(0.toUByte()),
  LOADED(1.toUByte()),
  ERROR(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): VMCOSCVrmState? = entries.firstOrNull { it.value == value }
  }
}

public class VMCOSCStatusRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VMCOSCStatusRequest = VMCOSCStatusRequest()
  }
}

public data class VMCOSCStatusChangeResponse(
  public val inputState: VMCOSCInputState = VMCOSCInputState.IDLE,
  public val inputPort: UShort? = null,
  public val inputError: String? = null,
  public val lastReceivedInputMillis: ULong? = null,
  public val outputState: VMCOSCOutputState = VMCOSCOutputState.IDLE,
  public val outputError: String? = null,
  public val targetAddress: String? = null,
  public val targetPort: UShort? = null,
  public val lastFrameSentMillis: ULong? = null,
  public val vrmState: VMCOSCVrmState = VMCOSCVrmState.NONE,
  public val vrmError: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_inputError = inputError?.let { builder.createString(it) }
    val __off_outputError = outputError?.let { builder.createString(it) }
    val __off_targetAddress = targetAddress?.let { builder.createString(it) }
    val __off_vrmError = vrmError?.let { builder.createString(it) }

    builder.startTable(11)
    builder.addByte(0, inputState.value.toByte(), 0)
    if (inputPort != null) { builder.forceDefaults(true); builder.addShort(1, inputPort.toShort(), 0); builder.forceDefaults(false) }
    __off_inputError?.let { builder.addOffset(2, it, 0) }
    if (lastReceivedInputMillis != null) { builder.forceDefaults(true); builder.addLong(3, lastReceivedInputMillis.toLong(), 0L); builder.forceDefaults(false) }
    builder.addByte(4, outputState.value.toByte(), 0)
    __off_outputError?.let { builder.addOffset(5, it, 0) }
    __off_targetAddress?.let { builder.addOffset(6, it, 0) }
    if (targetPort != null) { builder.forceDefaults(true); builder.addShort(7, targetPort.toShort(), 0); builder.forceDefaults(false) }
    if (lastFrameSentMillis != null) { builder.forceDefaults(true); builder.addLong(8, lastFrameSentMillis.toLong(), 0L); builder.forceDefaults(false) }
    builder.addByte(9, vrmState.value.toByte(), 0)
    __off_vrmError?.let { builder.addOffset(10, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): VMCOSCStatusChangeResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_inputState = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_inputPort = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_inputError = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_lastReceivedInputMillis = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_outputState = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_outputError = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_targetAddress = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_targetPort = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_lastFrameSentMillis = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_vrmState = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_vrmError = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0

      return VMCOSCStatusChangeResponse(
              inputState = if (__offset_inputState != 0) VMCOSCInputState.fromValue(bb.get(tableOffset + __offset_inputState).toUByte()) ?: VMCOSCInputState.IDLE else VMCOSCInputState.IDLE,
              inputPort = if (__offset_inputPort != 0) bb.getShort(tableOffset + __offset_inputPort).toUShort() else null,
              inputError = if (__offset_inputError != 0) readFlatBufferString(bb, tableOffset + __offset_inputError) else null,
              lastReceivedInputMillis = if (__offset_lastReceivedInputMillis != 0) bb.getLong(tableOffset + __offset_lastReceivedInputMillis).toULong() else null,
              outputState = if (__offset_outputState != 0) VMCOSCOutputState.fromValue(bb.get(tableOffset + __offset_outputState).toUByte()) ?: VMCOSCOutputState.IDLE else VMCOSCOutputState.IDLE,
              outputError = if (__offset_outputError != 0) readFlatBufferString(bb, tableOffset + __offset_outputError) else null,
              targetAddress = if (__offset_targetAddress != 0) readFlatBufferString(bb, tableOffset + __offset_targetAddress) else null,
              targetPort = if (__offset_targetPort != 0) bb.getShort(tableOffset + __offset_targetPort).toUShort() else null,
              lastFrameSentMillis = if (__offset_lastFrameSentMillis != 0) bb.getLong(tableOffset + __offset_lastFrameSentMillis).toULong() else null,
              vrmState = if (__offset_vrmState != 0) VMCOSCVrmState.fromValue(bb.get(tableOffset + __offset_vrmState).toUByte()) ?: VMCOSCVrmState.NONE else VMCOSCVrmState.NONE,
              vrmError = if (__offset_vrmError != 0) readFlatBufferString(bb, tableOffset + __offset_vrmError) else null
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
