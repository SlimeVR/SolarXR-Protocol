package solarxr_protocol.data_feed.device_data

import com.google.flatbuffers.FlatBufferBuilder
import java.nio.ByteBuffer
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import solarxr_protocol.data_feed.tracker.TrackerData
import solarxr_protocol.data_feed.tracker.TrackerDataMask
import solarxr_protocol.datatypes.DeviceId
import solarxr_protocol.datatypes.hardware_info.HardwareInfo
import solarxr_protocol.datatypes.hardware_info.HardwareStatus

/**
 * A mask of values to be reported in subsequent DeviceStatus. Values set to `false`
 * or `null` will not reported. By default, all fields are false/null.
 *
 * If you set a value to `true`, it is not guaranteed that the sender actually has
 * such a value to send. In this case, they will probably send `null`, and the receiver
 * has the choice to disconnect due to missing data.
 */
data class DeviceDataMask(
  val trackerData: TrackerDataMask? = null,
  val deviceData: Boolean = false,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_trackerData = trackerData?.encode(builder)

    builder.startTable(2)
    __off_trackerData?.let { builder.addOffset(0, it, 0) }
    builder.addBoolean(1, deviceData, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): DeviceDataMask {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerData = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_deviceData = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return DeviceDataMask(
              trackerData = if (__offset_trackerData != 0) solarxr_protocol.data_feed.tracker.TrackerDataMask.decode(bb, tableOffset + __offset_trackerData + bb.getInt(tableOffset + __offset_trackerData)) else null,
              deviceData = if (__offset_deviceData != 0) bb.get(tableOffset + __offset_deviceData) != 0.toByte() else false
          )
    }
  }
}

/**
 * Describes all possible information about a hardware device. For example, a
 * vive tracker is a  single hardware device, and a slime tracker with two
 * extensions is a single hardware device but two trackers.
 */
data class DeviceData(
  val id: DeviceId? = null,
  val customName: String? = null,
  val hardwareInfo: HardwareInfo? = null,
  val hardwareStatus: HardwareStatus? = null,
  val trackers: List<TrackerData>? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_customName = customName?.let { builder.createString(it) }
    val __off_hardwareInfo = hardwareInfo?.encode(builder)
    val __off_hardwareStatus = hardwareStatus?.encode(builder)
    val __off_trackers = trackers?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(5)
    id?.let { builder.addStruct(0, it.encode(builder), 0) }
    __off_customName?.let { builder.addOffset(1, it, 0) }
    __off_hardwareInfo?.let { builder.addOffset(2, it, 0) }
    __off_hardwareStatus?.let { builder.addOffset(3, it, 0) }
    __off_trackers?.let { builder.addOffset(4, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): DeviceData {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_id = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_customName = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_hardwareInfo = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_hardwareStatus = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_trackers = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return DeviceData(
              id = if (__offset_id != 0) solarxr_protocol.datatypes.DeviceId.decode(bb, tableOffset + __offset_id) else null,
              customName = if (__offset_customName != 0) { val strOff = tableOffset + __offset_customName + bb.getInt(tableOffset + __offset_customName); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              hardwareInfo = if (__offset_hardwareInfo != 0) solarxr_protocol.datatypes.hardware_info.HardwareInfo.decode(bb, tableOffset + __offset_hardwareInfo + bb.getInt(tableOffset + __offset_hardwareInfo)) else null,
              hardwareStatus = if (__offset_hardwareStatus != 0) solarxr_protocol.datatypes.hardware_info.HardwareStatus.decode(bb, tableOffset + __offset_hardwareStatus + bb.getInt(tableOffset + __offset_hardwareStatus)) else null,
              trackers = if (__offset_trackers != 0) { val vecOff = tableOffset + __offset_trackers + bb.getInt(tableOffset + __offset_trackers); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.data_feed.tracker.TrackerData.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) } } else null
          )
    }
  }
}
