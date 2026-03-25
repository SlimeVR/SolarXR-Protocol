package solarxr_protocol.data_feed

import com.google.flatbuffers.FlatBufferBuilder
import java.nio.ByteBuffer
import kotlin.Boolean
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UShort
import kotlin.collections.List
import solarxr_protocol.data_feed.device_data.DeviceData
import solarxr_protocol.data_feed.device_data.DeviceDataMask
import solarxr_protocol.data_feed.server.ServerGuards
import solarxr_protocol.data_feed.stay_aligned.StayAlignedPose
import solarxr_protocol.data_feed.tracker.TrackerData
import solarxr_protocol.data_feed.tracker.TrackerDataMask

sealed interface DataFeedMessage {
  companion object {
    fun decode(
      type: Byte,
      bb: ByteBuffer,
      offset: Int,
    ): DataFeedMessage? = when (type.toInt()) {
      1 -> PollDataFeed.decode(bb, offset)
      2 -> StartDataFeed.decode(bb, offset)
      3 -> DataFeedUpdate.decode(bb, offset)
      4 -> DataFeedConfig.decode(bb, offset)
      else -> null
    }

    fun typeIndex(`value`: DataFeedMessage): Byte = when (value) {
      is PollDataFeed -> 1
      is StartDataFeed -> 2
      is DataFeedUpdate -> 3
      is DataFeedConfig -> 4
      else -> 0
    }

    fun encode(`value`: DataFeedMessage, builder: FlatBufferBuilder): Int = when (value) {
      is PollDataFeed -> value.encode(builder)
      is StartDataFeed -> value.encode(builder)
      is DataFeedUpdate -> value.encode(builder)
      is DataFeedConfig -> value.encode(builder)
      else -> 0
    }
  }
}

data class DataFeedMessageHeader(
  val message: DataFeedMessage? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_message = message?.let { DataFeedMessage.encode(it, builder) }
    val __type_message = message?.let { DataFeedMessage.typeIndex(it) } ?: 0.toByte()

    builder.startTable(2)
    builder.addByte(0, __type_message, 0)
    __off_message?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): DataFeedMessageHeader {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __type_message = if (vtableSize > 4 && bb.getShort(vtableOffset + 4).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 4).toInt()) else 0
      val __offset_message = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return DataFeedMessageHeader(
              message = if (__offset_message != 0) solarxr_protocol.data_feed.DataFeedMessage.decode(__type_message, bb, tableOffset + __offset_message + bb.getInt(tableOffset + __offset_message)) else null
          )
    }
  }
}

/**
 * Requests for a single `Update` to be sent. This is helpful when getting
 * initial info about the device.
 */
data class PollDataFeed(
  val config: DataFeedConfig? = null,
) : DataFeedMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_config = config?.encode(builder)

    builder.startTable(1)
    __off_config?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): PollDataFeed {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_config = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return PollDataFeed(
              config = if (__offset_config != 0) solarxr_protocol.data_feed.DataFeedConfig.decode(bb, tableOffset + __offset_config + bb.getInt(tableOffset + __offset_config)) else null
          )
    }
  }
}

/**
 * Requests for the other party to send `data_feeds`.
 * For example, GUI requests for position data to be sent from server.
 *
 * When sending a new `StartFeed`, the old data feeds should stop being sent.
 * We still support multiple data feeds at the same time, because `data_feeds`
 * is a list.
 *
 * Multiple data feeds are useful to get data at different frequencies.
 */
data class StartDataFeed(
  val dataFeeds: List<DataFeedConfig>? = null,
) : DataFeedMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_dataFeeds = dataFeeds?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(1)
    __off_dataFeeds?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): StartDataFeed {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_dataFeeds = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StartDataFeed(
              dataFeeds = if (__offset_dataFeeds != 0) { val vecOff = tableOffset + __offset_dataFeeds + bb.getInt(tableOffset + __offset_dataFeeds); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.data_feed.DataFeedConfig.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) } } else null
          )
    }
  }
}

/**
 * All of the data components related to a single data feed. A data feed is comprised
 * of device data, and tracker data.
 *
 * A data feed might send data only when it changes/updates, and we should make no
 * assumptions that the data is actually delivered. If you want to guarantee
 * delivery and avoid dropped observations of data (such as a user-initiated
 * button press), it is better to use the RPC system.
 */
data class DataFeedUpdate(
  val devices: List<DeviceData>? = null,
  val syntheticTrackers: List<TrackerData>? = null,
  val bones: List<Bone>? = null,
  val stayAlignedPose: StayAlignedPose? = null,
  val index: UByte = 0.toUByte(),
  val serverGuards: ServerGuards? = null,
) : DataFeedMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_devices = devices?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }
    val __off_syntheticTrackers = syntheticTrackers?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }
    val __off_bones = bones?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }
    val __off_stayAlignedPose = stayAlignedPose?.encode(builder)
    val __off_serverGuards = serverGuards?.encode(builder)

    builder.startTable(6)
    __off_devices?.let { builder.addOffset(0, it, 0) }
    __off_syntheticTrackers?.let { builder.addOffset(1, it, 0) }
    __off_bones?.let { builder.addOffset(2, it, 0) }
    __off_stayAlignedPose?.let { builder.addOffset(3, it, 0) }
    builder.addByte(4, index.toByte(), 0)
    __off_serverGuards?.let { builder.addOffset(5, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): DataFeedUpdate {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_devices = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_syntheticTrackers = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_bones = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_stayAlignedPose = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_index = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_serverGuards = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0

      return DataFeedUpdate(
              devices = if (__offset_devices != 0) { val vecOff = tableOffset + __offset_devices + bb.getInt(tableOffset + __offset_devices); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.data_feed.device_data.DeviceData.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) } } else null,
              syntheticTrackers = if (__offset_syntheticTrackers != 0) { val vecOff = tableOffset + __offset_syntheticTrackers + bb.getInt(tableOffset + __offset_syntheticTrackers); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.data_feed.tracker.TrackerData.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) } } else null,
              bones = if (__offset_bones != 0) { val vecOff = tableOffset + __offset_bones + bb.getInt(tableOffset + __offset_bones); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.data_feed.Bone.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) } } else null,
              stayAlignedPose = if (__offset_stayAlignedPose != 0) solarxr_protocol.data_feed.stay_aligned.StayAlignedPose.decode(bb, tableOffset + __offset_stayAlignedPose + bb.getInt(tableOffset + __offset_stayAlignedPose)) else null,
              index = if (__offset_index != 0) bb.get(tableOffset + __offset_index).toUByte() else 0.toUByte(),
              serverGuards = if (__offset_serverGuards != 0) solarxr_protocol.data_feed.server.ServerGuards.decode(bb, tableOffset + __offset_serverGuards + bb.getInt(tableOffset + __offset_serverGuards)) else null
          )
    }
  }
}

/**
 * All information related to the configuration of a data feed. This may be sent
 * as part of a `StartFeed`.
 */
data class DataFeedConfig(
  val minimumTimeSinceLast: UShort = 0.toUShort(),
  val dataMask: DeviceDataMask? = null,
  val syntheticTrackersMask: TrackerDataMask? = null,
  val boneMask: Boolean = false,
  val stayAlignedPoseMask: Boolean = false,
  val serverGuardsMask: Boolean = false,
) : DataFeedMessage {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_dataMask = dataMask?.encode(builder)
    val __off_syntheticTrackersMask = syntheticTrackersMask?.encode(builder)

    builder.startTable(6)
    builder.addShort(0, minimumTimeSinceLast.toShort(), 0)
    __off_dataMask?.let { builder.addOffset(1, it, 0) }
    __off_syntheticTrackersMask?.let { builder.addOffset(2, it, 0) }
    builder.addBoolean(3, boneMask, false)
    builder.addBoolean(4, stayAlignedPoseMask, false)
    builder.addBoolean(5, serverGuardsMask, false)
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): DataFeedConfig {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_minimumTimeSinceLast = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_dataMask = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_syntheticTrackersMask = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_boneMask = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_stayAlignedPoseMask = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_serverGuardsMask = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0

      return DataFeedConfig(
              minimumTimeSinceLast = if (__offset_minimumTimeSinceLast != 0) bb.getShort(tableOffset + __offset_minimumTimeSinceLast).toUShort() else 0.toUShort(),
              dataMask = if (__offset_dataMask != 0) solarxr_protocol.data_feed.device_data.DeviceDataMask.decode(bb, tableOffset + __offset_dataMask + bb.getInt(tableOffset + __offset_dataMask)) else null,
              syntheticTrackersMask = if (__offset_syntheticTrackersMask != 0) solarxr_protocol.data_feed.tracker.TrackerDataMask.decode(bb, tableOffset + __offset_syntheticTrackersMask + bb.getInt(tableOffset + __offset_syntheticTrackersMask)) else null,
              boneMask = if (__offset_boneMask != 0) bb.get(tableOffset + __offset_boneMask) != 0.toByte() else false,
              stayAlignedPoseMask = if (__offset_stayAlignedPoseMask != 0) bb.get(tableOffset + __offset_stayAlignedPoseMask) != 0.toByte() else false,
              serverGuardsMask = if (__offset_serverGuardsMask != 0) bb.get(tableOffset + __offset_serverGuardsMask) != 0.toByte() else false
          )
    }
  }
}
