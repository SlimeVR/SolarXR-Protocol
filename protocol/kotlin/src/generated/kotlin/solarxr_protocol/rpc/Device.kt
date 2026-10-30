package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.collections.List
import solarxr_protocol.datatypes.hardware_info.BoardType
import solarxr_protocol.datatypes.hardware_info.McuType

public enum class UnknownDeviceStatus(
  public val `value`: UByte,
) {
  /**
   * Handshaking but not on the allowed list.
   */
  WAITING(1.toUByte()),
  /**
   * Allowed, waiting for its next handshake to connect.
   */
  ADDING(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): UnknownDeviceStatus? = entries.firstOrNull { it.value == value }
  }
}

public data class UnknownDevice(
  public val hardwareId: String? = null,
  public val ipAddress: UInt = 0u,
  public val boardType: BoardType = BoardType.UNKNOWN,
  public val mcuType: McuType = McuType.UNKNOWN,
  public val firmwareVersion: String? = null,
  public val status: UnknownDeviceStatus = UnknownDeviceStatus.WAITING,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_hardwareId = hardwareId?.let { builder.createString(it) }
    val __off_firmwareVersion = firmwareVersion?.let { builder.createString(it) }

    builder.startTable(6)
    __off_hardwareId?.let { builder.addOffset(0, it, 0) }
    builder.addInt(1, ipAddress.toInt(), 0)
    builder.addShort(2, boardType.value.toShort(), 0)
    builder.addShort(3, mcuType.value.toShort(), 0)
    __off_firmwareVersion?.let { builder.addOffset(4, it, 0) }
    builder.addByte(5, status.value.toByte(), 1)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): UnknownDevice {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_hardwareId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_ipAddress = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_boardType = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_mcuType = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_firmwareVersion = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_status = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0

      return UnknownDevice(
              hardwareId = if (__offset_hardwareId != 0) readFlatBufferString(bb, tableOffset + __offset_hardwareId) else null,
              ipAddress = if (__offset_ipAddress != 0) bb.getInt(tableOffset + __offset_ipAddress).toUInt() else 0u,
              boardType = if (__offset_boardType != 0) BoardType.fromValue(bb.getShort(tableOffset + __offset_boardType).toUShort()) ?: BoardType.UNKNOWN else BoardType.UNKNOWN,
              mcuType = if (__offset_mcuType != 0) McuType.fromValue(bb.getShort(tableOffset + __offset_mcuType).toUShort()) ?: McuType.UNKNOWN else McuType.UNKNOWN,
              firmwareVersion = if (__offset_firmwareVersion != 0) readFlatBufferString(bb, tableOffset + __offset_firmwareVersion) else null,
              status = if (__offset_status != 0) UnknownDeviceStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) ?: UnknownDeviceStatus.WAITING else UnknownDeviceStatus.WAITING
          )
    }
  }
}

public data class UnknownDevicesResponse(
  public val devices: List<UnknownDevice>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_devices = devices?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(1)
    __off_devices?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): UnknownDevicesResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_devices = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return UnknownDevicesResponse(
              devices = if (__offset_devices != 0) { val vecOff = tableOffset + __offset_devices + bb.getInt(tableOffset + __offset_devices); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) UnknownDevice.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

public data class IgnoreUnknownDeviceRequest(
  public val hardwareId: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_hardwareId = hardwareId?.let { builder.createString(it) }

    builder.startTable(1)
    __off_hardwareId?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): IgnoreUnknownDeviceRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_hardwareId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return IgnoreUnknownDeviceRequest(
              hardwareId = if (__offset_hardwareId != 0) readFlatBufferString(bb, tableOffset + __offset_hardwareId) else null
          )
    }
  }
}

public data class AddUnknownDeviceRequest(
  public val hardwareId: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_hardwareId = hardwareId?.let { builder.createString(it) }

    builder.startTable(1)
    __off_hardwareId?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): AddUnknownDeviceRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_hardwareId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return AddUnknownDeviceRequest(
              hardwareId = if (__offset_hardwareId != 0) readFlatBufferString(bb, tableOffset + __offset_hardwareId) else null
          )
    }
  }
}

public data class ForgetDeviceRequest(
  public val hardwareId: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_hardwareId = hardwareId?.let { builder.createString(it) }

    builder.startTable(1)
    __off_hardwareId?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ForgetDeviceRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_hardwareId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ForgetDeviceRequest(
              hardwareId = if (__offset_hardwareId != 0) readFlatBufferString(bb, tableOffset + __offset_hardwareId) else null
          )
    }
  }
}
