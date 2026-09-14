package solarxr_protocol.datatypes

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.collections.List

/**
 * General purpose logging datatype
 */
public data class LogData(
  public val message: String? = null,
  public val `data`: List<UByte>? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_message = message?.let { builder.createString(it) }
    val __off_data = data?.let { builder.createByteVector(it.map { b -> b.toByte() }.toByteArray()) }

    builder.startTable(2)
    __off_message?.let { builder.addOffset(0, it, 0) }
    __off_data?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): LogData {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_message = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_data = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return LogData(
              message = if (__offset_message != 0) readFlatBufferString(bb, tableOffset + __offset_message) else null,
              data = if (__offset_data != 0) { val vecOff = tableOffset + __offset_data + bb.getInt(tableOffset + __offset_data); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> bb.get(vecOff + 4 + i * 1).toUByte() } } else null
          )
    }
  }
}

/**
 * A list of error codes for error conditions on the device
 */
public enum class FirmwareErrorCode(
  public val `value`: UByte,
) {
  Other(0.toUByte()),
  Disconnected(1.toUByte()),
  Occluded(2.toUByte()),
  ImuError(3.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): FirmwareErrorCode? = entries.firstOrNull { it.value == value }
  }
}

public enum class TrackerStatus(
  public val `value`: UByte,
) {
  NONE(0.toUByte()),
  DISCONNECTED(1.toUByte()),
  OK(2.toUByte()),
  BUSY(3.toUByte()),
  ERROR(4.toUByte()),
  OCCLUDED(5.toUByte()),
  TIMED_OUT(6.toUByte()),
  SLEEPING(7.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): TrackerStatus? = entries.firstOrNull { it.value == value }
  }
}

public enum class MagnetometerStatus(
  public val `value`: UByte,
) {
  NOT_SUPPORTED(0.toUByte()),
  DISABLED(1.toUByte()),
  ENABLED(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): MagnetometerStatus? = entries.firstOrNull { it.value == value }
  }
}

public enum class MountingMethod(
  public val `value`: UByte,
) {
  MANUAL(0.toUByte()),
  POSE(1.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): MountingMethod? = entries.firstOrNull { it.value == value }
  }
}

public enum class DeviceOrigin(
  public val `value`: UByte,
) {
  NONE(0.toUByte()),
  DRIVER(1.toUByte()),
  UDP(2.toUByte()),
  HID(3.toUByte()),
  VRC(4.toUByte()),
  VMC(5.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): DeviceOrigin? = entries.firstOrNull { it.value == value }
  }
}
