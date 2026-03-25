package solarxr_protocol.datatypes

import com.google.flatbuffers.FlatBufferBuilder
import java.nio.ByteBuffer
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.collections.List
import solarxr_protocol.pub_sub.Payload
import solarxr_protocol.rpc.FirmwareUpdateDeviceId

/**
 * Frequency as 32 bit float
 */
data class HzF32(
  val f: Float,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.prep(4, 4)
    builder.putFloat(f)
    return builder.offset()
  }

  companion object {
    fun decode(bb: ByteBuffer, offset: Int): HzF32 = HzF32(f = bb.getFloat(offset + 0))
  }
}

data class TransactionId(
  val id: UInt,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.prep(4, 4)
    builder.putInt(id.toInt())
    return builder.offset()
  }

  companion object {
    fun decode(bb: ByteBuffer, offset: Int): TransactionId = TransactionId(id = bb.getInt(offset + 0).toUInt())
  }
}

/**
 * A unique ID for the device. IDs are not guaranteed to be the same after
 * the connection is terminated.
 */
data class DeviceId(
  val id: UByte,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.prep(1, 1)
    builder.putByte(id.toByte())
    return builder.offset()
  }

  companion object {
    fun decode(bb: ByteBuffer, offset: Int): DeviceId = DeviceId(id = bb.get(offset + 0).toUByte())
  }
}

/**
 * To be used inside unions
 */
data class DeviceIdTable(
  val id: DeviceId? = null,
) : FirmwareUpdateDeviceId {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(1)
    id?.let { builder.addStruct(0, it.encode(builder), 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): DeviceIdTable {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_id = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return DeviceIdTable(
              id = if (__offset_id != 0) solarxr_protocol.datatypes.DeviceId.decode(bb, tableOffset + __offset_id) else null
          )
    }
  }
}

data class TrackerId(
  val deviceId: DeviceId? = null,
  val trackerNum: UByte = 0.toUByte(),
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(2)
    deviceId?.let { builder.addStruct(0, it.encode(builder), 0) }
    builder.addByte(1, trackerNum.toByte(), 0)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): TrackerId {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_deviceId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_trackerNum = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return TrackerId(
              deviceId = if (__offset_deviceId != 0) solarxr_protocol.datatypes.DeviceId.decode(bb, tableOffset + __offset_deviceId) else null,
              trackerNum = if (__offset_trackerNum != 0) bb.get(tableOffset + __offset_trackerNum).toUByte() else 0.toUByte()
          )
    }
  }
}

/**
 * General purpose logging datatype
 */
data class LogData(
  val message: String? = null,
  val `data`: List<UByte>? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_message = message?.let { builder.createString(it) }
    val __off_data = data?.let { builder.createByteVector(it.map { b -> b.toByte() }.toByteArray()) }

    builder.startTable(2)
    __off_message?.let { builder.addOffset(0, it, 0) }
    __off_data?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): LogData {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_message = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_data = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return LogData(
              message = if (__offset_message != 0) { val strOff = tableOffset + __offset_message + bb.getInt(tableOffset + __offset_message); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              data = if (__offset_data != 0) { val vecOff = tableOffset + __offset_data + bb.getInt(tableOffset + __offset_data); val len = bb.getInt(vecOff); (0 until len).map { i -> bb.get(vecOff + 4 + i * 1).toUByte() } } else null
          )
    }
  }
}

/**
 * A list of error codes for error conditions on the device
 */
enum class FirmwareErrorCode(
  val `value`: UByte,
) {
  Other(0.toUByte()),
  Disconnected(1.toUByte()),
  Occluded(2.toUByte()),
  ImuError(3.toUByte()),
  ;

  companion object {
    fun fromValue(`value`: UByte): FirmwareErrorCode? = entries.firstOrNull { it.value == value }
  }
}

/**
 * Used for filtering tracker rotations in software
 */
enum class FilteringType(
  val `value`: UByte,
) {
  NONE(0.toUByte()),
  SMOOTHING(1.toUByte()),
  PREDICTION(2.toUByte()),
  ;

  companion object {
    fun fromValue(`value`: UByte): FilteringType? = entries.firstOrNull { it.value == value }
  }
}

/**
 * Possible tracker roles
 * They're not perfect match for SteamVR tracker roles,
 * because we support more possible roles. Host can
 * chose how to map it to their supported role.
 */
enum class TrackerRole(
  val `value`: UByte,
) {
  NONE(0.toUByte()),
  WAIST(1.toUByte()),
  LEFT_FOOT(2.toUByte()),
  RIGHT_FOOT(3.toUByte()),
  CHEST(4.toUByte()),
  LEFT_KNEE(5.toUByte()),
  RIGHT_KNEE(6.toUByte()),
  LEFT_ELBOW(7.toUByte()),
  RIGHT_ELBOW(8.toUByte()),
  LEFT_SHOULDER(9.toUByte()),
  RIGHT_SHOULDER(10.toUByte()),
  LEFT_HAND(11.toUByte()),
  RIGHT_HAND(12.toUByte()),
  LEFT_CONTROLLER(13.toUByte()),
  RIGHT_CONTROLLER(14.toUByte()),
  HEAD(15.toUByte()),
  NECK(16.toUByte()),
  CAMERA(17.toUByte()),
  KEYBOARD(18.toUByte()),
  HMD(19.toUByte()),
  BEACON(20.toUByte()),
  GENERIC_CONTROLLER(21.toUByte()),
  ;

  companion object {
    fun fromValue(`value`: UByte): TrackerRole? = entries.firstOrNull { it.value == value }
  }
}

/**
 * Different parts of the body. Maps to each possible non-tracker bone in the skeleton.
 * These are *NOT* the trackers.
 */
enum class BodyPart(
  val `value`: UByte,
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

  companion object {
    fun fromValue(`value`: UByte): BodyPart? = entries.firstOrNull { it.value == value }
  }
}

enum class TrackerStatus(
  val `value`: UByte,
) {
  NONE(0.toUByte()),
  DISCONNECTED(1.toUByte()),
  OK(2.toUByte()),
  BUSY(3.toUByte()),
  ERROR(4.toUByte()),
  OCCLUDED(5.toUByte()),
  TIMED_OUT(6.toUByte()),
  ;

  companion object {
    fun fromValue(`value`: UByte): TrackerStatus? = entries.firstOrNull { it.value == value }
  }
}

/**
 * Temperature in degrees celsius
 */
data class Temperature(
  val temp: Float,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.prep(4, 4)
    builder.putFloat(temp)
    return builder.offset()
  }

  companion object {
    fun decode(bb: ByteBuffer, offset: Int): Temperature = Temperature(temp = bb.getFloat(offset + 0))
  }
}

/**
 * The 4 bytes of an ip address are stored in 32 bits in big endian order.
 * We will switch over to fixed size arrays when they are supported better.
 */
data class Ipv4Address(
  val addr: UInt,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.prep(4, 4)
    builder.putInt(addr.toInt())
    return builder.offset()
  }

  companion object {
    fun decode(bb: ByteBuffer, offset: Int): Ipv4Address = Ipv4Address(addr = bb.getInt(offset + 0).toUInt())
  }
}

data class Bytes(
  val b: List<UByte>? = null,
) : Payload {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_b = b?.let { builder.createByteVector(it.map { b -> b.toByte() }.toByteArray()) }

    builder.startTable(1)
    __off_b?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): Bytes {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_b = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return Bytes(
              b = if (__offset_b != 0) { val vecOff = tableOffset + __offset_b + bb.getInt(tableOffset + __offset_b); val len = bb.getInt(vecOff); (0 until len).map { i -> bb.get(vecOff + 4 + i * 1).toUByte() } } else null
          )
    }
  }
}

data class StringTable(
  val s: String? = null,
) : Payload {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_s = s?.let { builder.createString(it) }

    builder.startTable(1)
    __off_s?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): StringTable {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_s = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StringTable(
              s = if (__offset_s != 0) { val strOff = tableOffset + __offset_s + bb.getInt(tableOffset + __offset_s); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null
          )
    }
  }
}

enum class MagnetometerStatus(
  val `value`: UByte,
) {
  NOT_SUPPORTED(0.toUByte()),
  DISABLED(1.toUByte()),
  ENABLED(2.toUByte()),
  ;

  companion object {
    fun fromValue(`value`: UByte): MagnetometerStatus? = entries.firstOrNull { it.value == value }
  }
}
