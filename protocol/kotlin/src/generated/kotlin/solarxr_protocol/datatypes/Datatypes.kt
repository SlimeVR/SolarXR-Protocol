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
 * Different parts of the body. Maps to each possible bone in the skeleton.
 * These are *NOT* the trackers.
 */
public enum class BodyPart(
  public val `value`: UByte,
) {
  NONE(0.toUByte()),
  HEAD(1.toUByte()),
  NECK(2.toUByte()),
  UPPER_CHEST(3.toUByte()),
  CHEST(4.toUByte()),
  WAIST(5.toUByte()),
  HIP(6.toUByte()),
  LEFT_HIP(21.toUByte()),
  RIGHT_HIP(22.toUByte()),
  LEFT_UPPER_LEG(7.toUByte()),
  RIGHT_UPPER_LEG(8.toUByte()),
  LEFT_LOWER_LEG(9.toUByte()),
  RIGHT_LOWER_LEG(10.toUByte()),
  LEFT_FOOT(11.toUByte()),
  RIGHT_FOOT(12.toUByte()),
  LEFT_SHOULDER(19.toUByte()),
  RIGHT_SHOULDER(20.toUByte()),
  LEFT_UPPER_ARM(13.toUByte()),
  RIGHT_UPPER_ARM(14.toUByte()),
  LEFT_LOWER_ARM(15.toUByte()),
  RIGHT_LOWER_ARM(16.toUByte()),
  LEFT_HAND(17.toUByte()),
  RIGHT_HAND(18.toUByte()),
  LEFT_THUMB_METACARPAL(23.toUByte()),
  LEFT_THUMB_PROXIMAL(24.toUByte()),
  LEFT_THUMB_DISTAL(25.toUByte()),
  LEFT_INDEX_PROXIMAL(26.toUByte()),
  LEFT_INDEX_INTERMEDIATE(27.toUByte()),
  LEFT_INDEX_DISTAL(28.toUByte()),
  LEFT_MIDDLE_PROXIMAL(29.toUByte()),
  LEFT_MIDDLE_INTERMEDIATE(30.toUByte()),
  LEFT_MIDDLE_DISTAL(31.toUByte()),
  LEFT_RING_PROXIMAL(32.toUByte()),
  LEFT_RING_INTERMEDIATE(33.toUByte()),
  LEFT_RING_DISTAL(34.toUByte()),
  LEFT_LITTLE_PROXIMAL(35.toUByte()),
  LEFT_LITTLE_INTERMEDIATE(36.toUByte()),
  LEFT_LITTLE_DISTAL(37.toUByte()),
  RIGHT_THUMB_METACARPAL(38.toUByte()),
  RIGHT_THUMB_PROXIMAL(39.toUByte()),
  RIGHT_THUMB_DISTAL(40.toUByte()),
  RIGHT_INDEX_PROXIMAL(41.toUByte()),
  RIGHT_INDEX_INTERMEDIATE(42.toUByte()),
  RIGHT_INDEX_DISTAL(43.toUByte()),
  RIGHT_MIDDLE_PROXIMAL(44.toUByte()),
  RIGHT_MIDDLE_INTERMEDIATE(45.toUByte()),
  RIGHT_MIDDLE_DISTAL(46.toUByte()),
  RIGHT_RING_PROXIMAL(47.toUByte()),
  RIGHT_RING_INTERMEDIATE(48.toUByte()),
  RIGHT_RING_DISTAL(49.toUByte()),
  RIGHT_LITTLE_PROXIMAL(50.toUByte()),
  RIGHT_LITTLE_INTERMEDIATE(51.toUByte()),
  RIGHT_LITTLE_DISTAL(52.toUByte()),
  LEFT_ABDUCTOR_HALLUCIS(53.toUByte()),
  LEFT_FLEXOR_DIGITORUM_BREVIS(54.toUByte()),
  LEFT_ABDUCTOR_DIGITI_MINIMI(55.toUByte()),
  RIGHT_ABDUCTOR_HALLUCIS(56.toUByte()),
  RIGHT_FLEXOR_DIGITORUM_BREVIS(57.toUByte()),
  RIGHT_ABDUCTOR_DIGITI_MINIMI(58.toUByte()),
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
