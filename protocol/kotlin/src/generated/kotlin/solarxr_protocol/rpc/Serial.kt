package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UShort
import kotlin.collections.List

public enum class SerialDeviceType(
  public val `value`: UByte,
) {
  /**
   * A USB serial port whose vendor and product id are not recognized
   */
  UNKNOWN(0.toUByte()),
  ESP_TRACKER(1.toUByte()),
  HID_RECEIVER(2.toUByte()),
  HID_TRACKER(3.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): SerialDeviceType? = entries.firstOrNull { it.value == value }
  }
}

/**
 * State of the console the server keeps on a serial port
 */
public enum class SerialConsoleStatus(
  public val `value`: UByte,
) {
  /**
   * The port is open and logs are streaming
   */
  OPEN(0.toUByte()),
  /**
   * The port is not present, the console resumes when it appears
   */
  WAITING(1.toUByte()),
  /**
   * The port is in use by a firmware flash, the console resumes afterwards
   */
  BUSY(2.toUByte()),
  /**
   * The port is present and the server is opening it
   */
  OPENING(3.toUByte()),
  /**
   * The port is present but could not be opened
   */
  OPEN_FAILED(4.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): SerialConsoleStatus? = entries.firstOrNull { it.value == value }
  }
}

public data class SerialDevice(
  public val port: String? = null,
  public val name: String? = null,
  public val type: SerialDeviceType = SerialDeviceType.UNKNOWN,
  public val vendorId: UShort = 0.toUShort(),
  public val productId: UShort = 0.toUShort(),
  public val serialNumber: String? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_port = port?.let { builder.createString(it) }
    val __off_name = name?.let { builder.createString(it) }
    val __off_serialNumber = serialNumber?.let { builder.createString(it) }

    builder.startTable(6)
    __off_port?.let { builder.addOffset(0, it, 0) }
    __off_name?.let { builder.addOffset(1, it, 0) }
    builder.addByte(2, type.value.toByte(), 0)
    builder.addShort(3, vendorId.toShort(), 0)
    builder.addShort(4, productId.toShort(), 0)
    __off_serialNumber?.let { builder.addOffset(5, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SerialDevice {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_port = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_name = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_type = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_vendorId = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_productId = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_serialNumber = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0

      return SerialDevice(
              port = if (__offset_port != 0) readFlatBufferString(bb, tableOffset + __offset_port) else null,
              name = if (__offset_name != 0) readFlatBufferString(bb, tableOffset + __offset_name) else null,
              type = if (__offset_type != 0) SerialDeviceType.fromValue(bb.get(tableOffset + __offset_type).toUByte()) ?: SerialDeviceType.UNKNOWN else SerialDeviceType.UNKNOWN,
              vendorId = if (__offset_vendorId != 0) bb.getShort(tableOffset + __offset_vendorId).toUShort() else 0.toUShort(),
              productId = if (__offset_productId != 0) bb.getShort(tableOffset + __offset_productId).toUShort() else 0.toUShort(),
              serialNumber = if (__offset_serialNumber != 0) readFlatBufferString(bb, tableOffset + __offset_serialNumber) else null
          )
    }
  }
}

public data class OpenSerialRequest(
  public val port: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_port = port?.let { builder.createString(it) }

    builder.startTable(1)
    __off_port?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OpenSerialRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_port = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return OpenSerialRequest(
              port = if (__offset_port != 0) readFlatBufferString(bb, tableOffset + __offset_port) else null
          )
    }
  }
}

public class CloseSerialRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): CloseSerialRequest = CloseSerialRequest()
  }
}

public data class SerialUpdateResponse(
  public val status: SerialConsoleStatus = SerialConsoleStatus.OPEN,
  public val device: SerialDevice? = null,
  public val log: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_device = device?.encode(builder)
    val __off_log = log?.let { builder.createString(it) }

    builder.startTable(3)
    builder.addByte(0, status.value.toByte(), 0)
    __off_device?.let { builder.addOffset(1, it, 0) }
    __off_log?.let { builder.addOffset(2, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SerialUpdateResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_status = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_device = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_log = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return SerialUpdateResponse(
              status = if (__offset_status != 0) SerialConsoleStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) ?: SerialConsoleStatus.OPEN else SerialConsoleStatus.OPEN,
              device = if (__offset_device != 0) SerialDevice.decode(bb, tableOffset + __offset_device + bb.getInt(tableOffset + __offset_device)) else null,
              log = if (__offset_log != 0) readFlatBufferString(bb, tableOffset + __offset_log) else null
          )
    }
  }
}

/**
 * Reboots the tracker connected to the serial monitor
 */
public class SerialTrackerRebootRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SerialTrackerRebootRequest = SerialTrackerRebootRequest()
  }
}

/**
 * Sends the GET INFO cmd to the current tracker on the serial monitor
 */
public class SerialTrackerGetInfoRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SerialTrackerGetInfoRequest = SerialTrackerGetInfoRequest()
  }
}

/**
 * Sends the FRST cmd to the currently connected Tracker over the Serial Monitor
 */
public class SerialTrackerFactoryResetRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SerialTrackerFactoryResetRequest = SerialTrackerFactoryResetRequest()
  }
}

/**
 * Sends a custom cmd to the currently connected Tracker over the Serial Monitor
 */
public data class SerialTrackerCustomCommandRequest(
  public val command: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_command = command?.let { builder.createString(it) }

    builder.startTable(1)
    __off_command?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SerialTrackerCustomCommandRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_command = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return SerialTrackerCustomCommandRequest(
              command = if (__offset_command != 0) readFlatBufferString(bb, tableOffset + __offset_command) else null
          )
    }
  }
}

public class SerialDevicesRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SerialDevicesRequest = SerialDevicesRequest()
  }
}

public data class SerialDevicesResponse(
  public val devices: List<SerialDevice>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_devices = devices?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(1)
    __off_devices?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SerialDevicesResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_devices = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return SerialDevicesResponse(
              devices = if (__offset_devices != 0) { val vecOff = tableOffset + __offset_devices + bb.getInt(tableOffset + __offset_devices); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) SerialDevice.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

/**
 * Sends the GET WIFISCAN cmd to the current tracker on the serial monitor
 */
public class SerialTrackerGetWifiScanRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SerialTrackerGetWifiScanRequest = SerialTrackerGetWifiScanRequest()
  }
}

public class HIDSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): HIDSettingsRequest = HIDSettingsRequest()
  }
}

public data class HIDSettingsResponse(
  public val trackersOverHid: Boolean = false,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addBoolean(0, trackersOverHid, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): HIDSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackersOverHid = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return HIDSettingsResponse(
              trackersOverHid = if (__offset_trackersOverHid != 0) bb.get(tableOffset + __offset_trackersOverHid) != 0.toByte() else false
          )
    }
  }
}

public data class ChangeHIDSettingsRequest(
  public val trackersOverHid: Boolean = false,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addBoolean(0, trackersOverHid, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeHIDSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackersOverHid = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ChangeHIDSettingsRequest(
              trackersOverHid = if (__offset_trackersOverHid != 0) bb.get(tableOffset + __offset_trackersOverHid) != 0.toByte() else false
          )
    }
  }
}
