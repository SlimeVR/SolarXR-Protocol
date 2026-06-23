package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Int
import kotlin.String
import kotlin.UByte

public data class StartWifiProvisioningRequest(
  public val ssid: String? = null,
  public val password: String? = null,
  public val port: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_ssid = ssid?.let { builder.createString(it) }
    val __off_password = password?.let { builder.createString(it) }
    val __off_port = port?.let { builder.createString(it) }

    builder.startTable(3)
    __off_ssid?.let { builder.addOffset(0, it, 0) }
    __off_password?.let { builder.addOffset(1, it, 0) }
    __off_port?.let { builder.addOffset(2, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StartWifiProvisioningRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_ssid = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_password = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_port = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return StartWifiProvisioningRequest(
              ssid = if (__offset_ssid != 0) readFlatBufferString(bb, tableOffset + __offset_ssid) else null,
              password = if (__offset_password != 0) readFlatBufferString(bb, tableOffset + __offset_password) else null,
              port = if (__offset_port != 0) readFlatBufferString(bb, tableOffset + __offset_port) else null
          )
    }
  }
}

public class StopWifiProvisioningRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StopWifiProvisioningRequest = StopWifiProvisioningRequest()
  }
}

public enum class WifiProvisioningStatus(
  public val `value`: UByte,
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

  public companion object {
    public fun fromValue(`value`: UByte): WifiProvisioningStatus? = entries.firstOrNull { it.value == value }
  }
}

public data class WifiProvisioningStatusResponse(
  public val status: WifiProvisioningStatus? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (status != null) { builder.forceDefaults(true); builder.addByte(0, status.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): WifiProvisioningStatusResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_status = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return WifiProvisioningStatusResponse(
              status = if (__offset_status != 0) WifiProvisioningStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) else null
          )
    }
  }
}
