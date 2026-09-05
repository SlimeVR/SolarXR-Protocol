package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Int
import kotlin.String

/**
 * Server notifies connection of an unknown device.
 * If the notification is no longer sent, it means the device connected to another
 * server, got connected to this server or it was turned off.
 */
public data class UnknownDeviceHandshakeNotification(
  public val macAddress: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_macAddress = macAddress?.let { builder.createString(it) }

    builder.startTable(1)
    __off_macAddress?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): UnknownDeviceHandshakeNotification {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_macAddress = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return UnknownDeviceHandshakeNotification(
              macAddress = if (__offset_macAddress != 0) readFlatBufferString(bb, tableOffset + __offset_macAddress) else null
          )
    }
  }
}

public data class AddUnknownDeviceRequest(
  public val macAddress: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_macAddress = macAddress?.let { builder.createString(it) }

    builder.startTable(1)
    __off_macAddress?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): AddUnknownDeviceRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_macAddress = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return AddUnknownDeviceRequest(
              macAddress = if (__offset_macAddress != 0) readFlatBufferString(bb, tableOffset + __offset_macAddress) else null
          )
    }
  }
}

public data class ForgetDeviceRequest(
  public val macAddress: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_macAddress = macAddress?.let { builder.createString(it) }

    builder.startTable(1)
    __off_macAddress?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ForgetDeviceRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_macAddress = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ForgetDeviceRequest(
              macAddress = if (__offset_macAddress != 0) readFlatBufferString(bb, tableOffset + __offset_macAddress) else null
          )
    }
  }
}
