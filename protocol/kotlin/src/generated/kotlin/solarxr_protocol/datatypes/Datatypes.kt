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

/**
 * Different parts of the body. Maps to each possible non-tracker bone in the skeleton.
 * These are *NOT* the trackers.
 */
public enum class BodyPart(
  public val `value`: UByte,
) {
  NONE(0.toUByte()),
  HEAD(1.toUByte()),
  NECK(2.toUByte()),
  CHEST(3.toUByte()),
  WAIST(4.toUByte()),
  HIP(5.toUByte()),
  LEFT_UPPER_LEG(6.toUByte()),
  RIGHT_UPPER_LEG(7.toUByte()),
  LEFT_LOWER_LEG(8.toUByte()),
  RIGHT_LOWER_LEG(9.toUByte()),
  LEFT_FOOT(10.toUByte()),
  RIGHT_FOOT(11.toUByte()),
  LEFT_LOWER_ARM(14.toUByte()),
  RIGHT_LOWER_ARM(15.toUByte()),
  LEFT_UPPER_ARM(16.toUByte()),
  RIGHT_UPPER_ARM(17.toUByte()),
  LEFT_HAND(18.toUByte()),
  RIGHT_HAND(19.toUByte()),
  LEFT_SHOULDER(20.toUByte()),
  RIGHT_SHOULDER(21.toUByte()),
  UPPER_CHEST(22.toUByte()),
  LEFT_HIP(23.toUByte()),
  RIGHT_HIP(24.toUByte()),
  LEFT_THUMB_METACARPAL(25.toUByte()),
  LEFT_THUMB_PROXIMAL(26.toUByte()),
  LEFT_THUMB_DISTAL(27.toUByte()),
  LEFT_INDEX_PROXIMAL(28.toUByte()),
  LEFT_INDEX_INTERMEDIATE(29.toUByte()),
  LEFT_INDEX_DISTAL(30.toUByte()),
  LEFT_MIDDLE_PROXIMAL(31.toUByte()),
  LEFT_MIDDLE_INTERMEDIATE(32.toUByte()),
  LEFT_MIDDLE_DISTAL(33.toUByte()),
  LEFT_RING_PROXIMAL(34.toUByte()),
  LEFT_RING_INTERMEDIATE(35.toUByte()),
  LEFT_RING_DISTAL(36.toUByte()),
  LEFT_LITTLE_PROXIMAL(37.toUByte()),
  LEFT_LITTLE_INTERMEDIATE(38.toUByte()),
  LEFT_LITTLE_DISTAL(39.toUByte()),
  RIGHT_THUMB_METACARPAL(40.toUByte()),
  RIGHT_THUMB_PROXIMAL(41.toUByte()),
  RIGHT_THUMB_DISTAL(42.toUByte()),
  RIGHT_INDEX_PROXIMAL(43.toUByte()),
  RIGHT_INDEX_INTERMEDIATE(44.toUByte()),
  RIGHT_INDEX_DISTAL(45.toUByte()),
  RIGHT_MIDDLE_PROXIMAL(46.toUByte()),
  RIGHT_MIDDLE_INTERMEDIATE(47.toUByte()),
  RIGHT_MIDDLE_DISTAL(48.toUByte()),
  RIGHT_RING_PROXIMAL(49.toUByte()),
  RIGHT_RING_INTERMEDIATE(50.toUByte()),
  RIGHT_RING_DISTAL(51.toUByte()),
  RIGHT_LITTLE_PROXIMAL(52.toUByte()),
  RIGHT_LITTLE_INTERMEDIATE(53.toUByte()),
  RIGHT_LITTLE_DISTAL(54.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): BodyPart? = entries.firstOrNull { it.value == value }
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
