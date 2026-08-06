package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Int
import kotlin.UByte

public class DriverSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): DriverSettingsRequest = DriverSettingsRequest()
  }
}

public data class DriverSettingsResponse(
  public val sendDerivedVelocity: Boolean? = null,
  public val enabled: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (sendDerivedVelocity != null) { builder.forceDefaults(true); builder.addBoolean(0, sendDerivedVelocity, false); builder.forceDefaults(false) }
    if (enabled != null) { builder.forceDefaults(true); builder.addBoolean(1, enabled, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): DriverSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_sendDerivedVelocity = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_enabled = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return DriverSettingsResponse(
              sendDerivedVelocity = if (__offset_sendDerivedVelocity != 0) bb.get(tableOffset + __offset_sendDerivedVelocity) != 0.toByte() else null,
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else null
          )
    }
  }
}

public data class ChangeDriverSettingsRequest(
  public val sendDerivedVelocity: Boolean? = null,
  public val enabled: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (sendDerivedVelocity != null) { builder.forceDefaults(true); builder.addBoolean(0, sendDerivedVelocity, false); builder.forceDefaults(false) }
    if (enabled != null) { builder.forceDefaults(true); builder.addBoolean(1, enabled, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeDriverSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_sendDerivedVelocity = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_enabled = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return ChangeDriverSettingsRequest(
              sendDerivedVelocity = if (__offset_sendDerivedVelocity != 0) bb.get(tableOffset + __offset_sendDerivedVelocity) != 0.toByte() else null,
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else null
          )
    }
  }
}

public enum class DriverConnectionState(
  public val `value`: UByte,
) {
  UNSUPPORTED(0.toUByte()),
  DISABLED(1.toUByte()),
  WAITING(2.toUByte()),
  CONNECTED(3.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): DriverConnectionState? = entries.firstOrNull { it.value == value }
  }
}

public class DriverStatusRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): DriverStatusRequest = DriverStatusRequest()
  }
}

public data class DriverStatusChangeResponse(
  public val state: DriverConnectionState? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (state != null) { builder.forceDefaults(true); builder.addByte(0, state.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): DriverStatusChangeResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_state = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return DriverStatusChangeResponse(
              state = if (__offset_state != 0) DriverConnectionState.fromValue(bb.get(tableOffset + __offset_state).toUByte()) else null
          )
    }
  }
}
