package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Boolean
import kotlin.Byte
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.collections.List

public enum class FirmwareUpdateStatus(
  public val `value`: UByte,
) {
  /**
   * The server is downloading the firmware
   */
  DOWNLOADING(0.toUByte()),
  /**
   * The server is waiting for the tracker to be rebooted by the user
   * Note that is is not the same as REBOOTING
   */
  NEED_MANUAL_REBOOT(1.toUByte()),
  /**
   * The server tries to authenticate with the MCU
   */
  AUTHENTICATING(2.toUByte()),
  /**
   * The server is uploading the firmware to the Device
   */
  UPLOADING(3.toUByte()),
  /**
   * The serial flasher tries to sync with the MCU
   * You can use this event to prompt the user to press the boot btn
   */
  SYNCING_WITH_MCU(4.toUByte()),
  /**
   * The MCU is rebooting
   */
  REBOOTING(5.toUByte()),
  /**
   * The server is provisioning the tracker
   */
  PROVISIONING(6.toUByte()),
  /**
   * The update process completed with success
   */
  DONE(7.toUByte()),
  /**
   * Could not find the device
   */
  ERROR_DEVICE_NOT_FOUND(8.toUByte()),
  /**
   * The operation timed out, > 1min
   */
  ERROR_TIMEOUT(9.toUByte()),
  /**
   * The firmware download failed
   */
  ERROR_DOWNLOAD_FAILED(10.toUByte()),
  /**
   * The server could not authenticate with the MCU
   */
  ERROR_AUTHENTICATION_FAILED(11.toUByte()),
  /**
   * Could not upload the firmware to the MCU
   */
  ERROR_UPLOAD_FAILED(12.toUByte()),
  /**
   * The provision of the tracker failed, usually wifi credentials
   */
  ERROR_PROVISIONING_FAILED(13.toUByte()),
  /**
   * An unsupported Flashing method was used
   */
  ERROR_UNSUPPORTED_METHOD(14.toUByte()),
  ERROR_UNKNOWN(15.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): FirmwareUpdateStatus? = entries.firstOrNull { it.value == value }
  }
}

public data class SerialDevicePort(
  public val port: String? = null,
) : FirmwareUpdateDeviceId {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_port = port?.let { builder.createString(it) }

    builder.startTable(1)
    __off_port?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SerialDevicePort {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_port = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return SerialDevicePort(
              port = if (__offset_port != 0) readFlatBufferString(bb, tableOffset + __offset_port) else null
          )
    }
  }
}

public data class FirmwareDeviceIdTable(
  public val id: UShort? = null,
) : FirmwareUpdateDeviceId {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (id != null) { builder.forceDefaults(true); builder.addShort(0, id.toShort(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): FirmwareDeviceIdTable {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_id = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return FirmwareDeviceIdTable(
              id = if (__offset_id != 0) bb.getShort(tableOffset + __offset_id).toUShort() else null
          )
    }
  }
}

public sealed interface FirmwareUpdateDeviceId {
  public companion object {
    public fun decode(
      type: Byte,
      bb: FlatBufferReader,
      offset: Int,
    ): FirmwareUpdateDeviceId? = when (type.toInt()) {
      1 -> FirmwareDeviceIdTable.decode(bb, offset)
      2 -> SerialDevicePort.decode(bb, offset)
      else -> null
    }

    public fun typeIndex(`value`: FirmwareUpdateDeviceId): Byte = when (value) {
      is FirmwareDeviceIdTable -> 1
      is SerialDevicePort -> 2
    }

    public fun encode(`value`: FirmwareUpdateDeviceId, builder: FlatBufferWriter): Int = when (value) {
      is FirmwareDeviceIdTable -> value.encode(builder)
      is SerialDevicePort -> value.encode(builder)
    }
  }
}

public data class FirmwarePart(
  public val url: String? = null,
  public val offset: UInt? = null,
  public val digest: String? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_url = url?.let { builder.createString(it) }
    val __off_digest = digest?.let { builder.createString(it) }

    builder.startTable(3)
    __off_url?.let { builder.addOffset(0, it, 0) }
    if (offset != null) { builder.forceDefaults(true); builder.addInt(1, offset.toInt(), 0); builder.forceDefaults(false) }
    __off_digest?.let { builder.addOffset(2, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): FirmwarePart {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_url = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_offset = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_digest = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return FirmwarePart(
              url = if (__offset_url != 0) readFlatBufferString(bb, tableOffset + __offset_url) else null,
              offset = if (__offset_offset != 0) bb.getInt(tableOffset + __offset_offset).toUInt() else null,
              digest = if (__offset_digest != 0) readFlatBufferString(bb, tableOffset + __offset_digest) else null
          )
    }
  }
}

public sealed interface FirmwareUpdateMethod {
  public companion object {
    public fun decode(
      type: Byte,
      bb: FlatBufferReader,
      offset: Int,
    ): FirmwareUpdateMethod? = when (type.toInt()) {
      1 -> OTAFirmwareUpdate.decode(bb, offset)
      2 -> SerialFirmwareUpdate.decode(bb, offset)
      else -> null
    }

    public fun typeIndex(`value`: FirmwareUpdateMethod): Byte = when (value) {
      is OTAFirmwareUpdate -> 1
      is SerialFirmwareUpdate -> 2
    }

    public fun encode(`value`: FirmwareUpdateMethod, builder: FlatBufferWriter): Int = when (value) {
      is OTAFirmwareUpdate -> value.encode(builder)
      is SerialFirmwareUpdate -> value.encode(builder)
    }
  }
}

public data class FirmwareUpdateRequest(
  public val method: FirmwareUpdateMethod? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_method = method?.let { FirmwareUpdateMethod.encode(it, builder) }
    val __type_method = method?.let { FirmwareUpdateMethod.typeIndex(it) } ?: 0.toByte()

    builder.startTable(2)
    builder.addByte(0, __type_method, 0)
    __off_method?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): FirmwareUpdateRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __type_method = if (vtableSize > 4 && bb.getShort(vtableOffset + 4).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 4).toInt()) else 0
      val __offset_method = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return FirmwareUpdateRequest(
              method = if (__offset_method != 0) FirmwareUpdateMethod.decode(__type_method, bb, tableOffset + __offset_method + bb.getInt(tableOffset + __offset_method)) else null
          )
    }
  }
}

public data class OTAFirmwareUpdate(
  public val deviceId: UShort? = null,
  public val firmwarePart: FirmwarePart? = null,
) : FirmwareUpdateMethod {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_firmwarePart = firmwarePart?.encode(builder)

    builder.startTable(2)
    if (deviceId != null) { builder.forceDefaults(true); builder.addShort(0, deviceId.toShort(), 0); builder.forceDefaults(false) }
    __off_firmwarePart?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OTAFirmwareUpdate {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_deviceId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_firmwarePart = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return OTAFirmwareUpdate(
              deviceId = if (__offset_deviceId != 0) bb.getShort(tableOffset + __offset_deviceId).toUShort() else null,
              firmwarePart = if (__offset_firmwarePart != 0) FirmwarePart.decode(bb, tableOffset + __offset_firmwarePart + bb.getInt(tableOffset + __offset_firmwarePart)) else null
          )
    }
  }
}

public data class SerialFirmwareUpdate(
  public val deviceId: SerialDevicePort? = null,
  public val needManualReboot: Boolean? = null,
  public val ssid: String? = null,
  public val password: String? = null,
  public val firmwarePart: List<FirmwarePart>? = null,
) : FirmwareUpdateMethod {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_deviceId = deviceId?.encode(builder)
    val __off_ssid = ssid?.let { builder.createString(it) }
    val __off_password = password?.let { builder.createString(it) }
    val __off_firmwarePart = firmwarePart?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(5)
    __off_deviceId?.let { builder.addOffset(0, it, 0) }
    if (needManualReboot != null) { builder.forceDefaults(true); builder.addBoolean(1, needManualReboot, false); builder.forceDefaults(false) }
    __off_ssid?.let { builder.addOffset(2, it, 0) }
    __off_password?.let { builder.addOffset(3, it, 0) }
    __off_firmwarePart?.let { builder.addOffset(4, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SerialFirmwareUpdate {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_deviceId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_needManualReboot = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_ssid = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_password = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_firmwarePart = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return SerialFirmwareUpdate(
              deviceId = if (__offset_deviceId != 0) SerialDevicePort.decode(bb, tableOffset + __offset_deviceId + bb.getInt(tableOffset + __offset_deviceId)) else null,
              needManualReboot = if (__offset_needManualReboot != 0) bb.get(tableOffset + __offset_needManualReboot) != 0.toByte() else null,
              ssid = if (__offset_ssid != 0) readFlatBufferString(bb, tableOffset + __offset_ssid) else null,
              password = if (__offset_password != 0) readFlatBufferString(bb, tableOffset + __offset_password) else null,
              firmwarePart = if (__offset_firmwarePart != 0) { val vecOff = tableOffset + __offset_firmwarePart + bb.getInt(tableOffset + __offset_firmwarePart); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) FirmwarePart.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

public data class FirmwareUpdateStatusResponse(
  public val deviceId: FirmwareUpdateDeviceId? = null,
  public val status: FirmwareUpdateStatus? = null,
  public val progress: Byte? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_deviceId = deviceId?.let { FirmwareUpdateDeviceId.encode(it, builder) }
    val __type_deviceId = deviceId?.let { FirmwareUpdateDeviceId.typeIndex(it) } ?: 0.toByte()

    builder.startTable(4)
    builder.addByte(0, __type_deviceId, 0)
    __off_deviceId?.let { builder.addOffset(1, it, 0) }
    if (status != null) { builder.forceDefaults(true); builder.addByte(2, status.value.toByte(), 0); builder.forceDefaults(false) }
    if (progress != null) { builder.forceDefaults(true); builder.addByte(3, progress, 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): FirmwareUpdateStatusResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __type_deviceId = if (vtableSize > 4 && bb.getShort(vtableOffset + 4).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 4).toInt()) else 0
      val __offset_deviceId = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_status = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_progress = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return FirmwareUpdateStatusResponse(
              deviceId = if (__offset_deviceId != 0) FirmwareUpdateDeviceId.decode(__type_deviceId, bb, tableOffset + __offset_deviceId + bb.getInt(tableOffset + __offset_deviceId)) else null,
              status = if (__offset_status != 0) FirmwareUpdateStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) else null,
              progress = if (__offset_progress != 0) bb.get(tableOffset + __offset_progress) else null
          )
    }
  }
}

public class FirmwareUpdateStopQueuesRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): FirmwareUpdateStopQueuesRequest = FirmwareUpdateStopQueuesRequest()
  }
}
