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
  public val enabled: Boolean = false,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addBoolean(0, enabled, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): DriverSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return DriverSettingsResponse(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else false
          )
    }
  }
}

public data class ChangeDriverSettingsRequest(
  public val enabled: Boolean = false,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addBoolean(0, enabled, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeDriverSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ChangeDriverSettingsRequest(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else false
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
  public val state: DriverConnectionState = DriverConnectionState.UNSUPPORTED,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addByte(0, state.value.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): DriverStatusChangeResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_state = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return DriverStatusChangeResponse(
              state = if (__offset_state != 0) DriverConnectionState.fromValue(bb.get(tableOffset + __offset_state).toUByte()) ?: DriverConnectionState.UNSUPPORTED else DriverConnectionState.UNSUPPORTED
          )
    }
  }
}
