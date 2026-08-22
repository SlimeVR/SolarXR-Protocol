package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Byte
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.collections.List

public data class StartWifiProvisioningRequest(
  public val ssid: String? = null,
  public val password: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_ssid = ssid?.let { builder.createString(it) }
    val __off_password = password?.let { builder.createString(it) }

    builder.startTable(2)
    __off_ssid?.let { builder.addOffset(0, it, 0) }
    __off_password?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StartWifiProvisioningRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_ssid = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_password = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return StartWifiProvisioningRequest(
              ssid = if (__offset_ssid != 0) readFlatBufferString(bb, tableOffset + __offset_ssid) else null,
              password = if (__offset_password != 0) readFlatBufferString(bb, tableOffset + __offset_password) else null
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

public class StartWifiScanRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StartWifiScanRequest = StartWifiScanRequest()
  }
}

public class StopWifiScanRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StopWifiScanRequest = StopWifiScanRequest()
  }
}

public enum class WifiAuthMode(
  public val `value`: UByte,
) {
  OPEN(0.toUByte()),
  WEP(1.toUByte()),
  WPA_PSK(2.toUByte()),
  WPA2_PSK(3.toUByte()),
  WPA_WPA2_PSK(4.toUByte()),
  WPA2_ENTERPRISE(5.toUByte()),
  WPA3_PSK(6.toUByte()),
  WPA2_WPA3_PSK(7.toUByte()),
  WAPI_PSK(8.toUByte()),
  WPA3_ENT_192(9.toUByte()),
  UNKNOWN(10.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): WifiAuthMode? = entries.firstOrNull { it.value == value }
  }
}

public data class WifiNetwork(
  public val ssid: String? = null,
  public val rssi: Byte? = null,
  public val authMode: WifiAuthMode? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_ssid = ssid?.let { builder.createString(it) }

    builder.startTable(3)
    __off_ssid?.let { builder.addOffset(0, it, 0) }
    if (rssi != null) { builder.forceDefaults(true); builder.addByte(1, rssi, 0); builder.forceDefaults(false) }
    if (authMode != null) { builder.forceDefaults(true); builder.addByte(2, authMode.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): WifiNetwork {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_ssid = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_rssi = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_authMode = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return WifiNetwork(
              ssid = if (__offset_ssid != 0) readFlatBufferString(bb, tableOffset + __offset_ssid) else null,
              rssi = if (__offset_rssi != 0) bb.get(tableOffset + __offset_rssi) else null,
              authMode = if (__offset_authMode != 0) WifiAuthMode.fromValue(bb.get(tableOffset + __offset_authMode).toUByte()) else null
          )
    }
  }
}

public enum class WifiScanStatus(
  public val `value`: UByte,
) {
  NONE(0.toUByte()),
  SERIAL_INIT(1.toUByte()),
  SCANNING(2.toUByte()),
  RESULTS(3.toUByte()),
  UNSUPPORTED(4.toUByte()),
  CONNECTION_ERROR(5.toUByte()),
  NO_SERIAL_LOGS_ERROR(6.toUByte()),
  NO_SERIAL_DEVICE_FOUND(7.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): WifiScanStatus? = entries.firstOrNull { it.value == value }
  }
}

public data class WifiScanStatusResponse(
  public val status: WifiScanStatus? = null,
  public val networks: List<WifiNetwork>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_networks = networks?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(2)
    if (status != null) { builder.forceDefaults(true); builder.addByte(0, status.value.toByte(), 0); builder.forceDefaults(false) }
    __off_networks?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): WifiScanStatusResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_status = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_networks = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return WifiScanStatusResponse(
              status = if (__offset_status != 0) WifiScanStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) else null,
              networks = if (__offset_networks != 0) { val vecOff = tableOffset + __offset_networks + bb.getInt(tableOffset + __offset_networks); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) WifiNetwork.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

public enum class TrackerProvisioningStatus(
  public val `value`: UByte,
) {
  SERIAL_INIT(0.toUByte()),
  OBTAINING_MAC_ADDRESS(1.toUByte()),
  PROVISIONING(2.toUByte()),
  CONNECTING(3.toUByte()),
  CONNECTION_ERROR(4.toUByte()),
  LOOKING_FOR_SERVER(5.toUByte()),
  COULD_NOT_FIND_SERVER(6.toUByte()),
  DONE(7.toUByte()),
  NO_SERIAL_LOGS_ERROR(8.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): TrackerProvisioningStatus? = entries.firstOrNull { it.value == value }
  }
}

public data class TrackerProvisioningState(
  public val port: String? = null,
  public val macAddress: String? = null,
  public val status: TrackerProvisioningStatus? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_port = port?.let { builder.createString(it) }
    val __off_macAddress = macAddress?.let { builder.createString(it) }

    builder.startTable(3)
    __off_port?.let { builder.addOffset(0, it, 0) }
    __off_macAddress?.let { builder.addOffset(1, it, 0) }
    if (status != null) { builder.forceDefaults(true); builder.addByte(2, status.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackerProvisioningState {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_port = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_macAddress = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_status = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return TrackerProvisioningState(
              port = if (__offset_port != 0) readFlatBufferString(bb, tableOffset + __offset_port) else null,
              macAddress = if (__offset_macAddress != 0) readFlatBufferString(bb, tableOffset + __offset_macAddress) else null,
              status = if (__offset_status != 0) TrackerProvisioningStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) else null
          )
    }
  }
}

public data class WifiProvisioningStatusResponse(
  public val trackers: List<TrackerProvisioningState>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackers = trackers?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(1)
    __off_trackers?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): WifiProvisioningStatusResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackers = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return WifiProvisioningStatusResponse(
              trackers = if (__offset_trackers != 0) { val vecOff = tableOffset + __offset_trackers + bb.getInt(tableOffset + __offset_trackers); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) TrackerProvisioningState.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}
