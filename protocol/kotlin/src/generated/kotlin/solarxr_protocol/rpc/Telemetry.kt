package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.collections.List

/**
 * Re-sending Start replaces the previous subscription. This is also how the GUI
 * changes which trackers it's monitoring, no separate config message.
 */
public data class StartTelemetryRequest(
  public val deviceIds: List<UShort>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_deviceIds = deviceIds?.let { run { val values = it; builder.startVector(2, values.size, 2); for (value in values.asReversed()) builder.putShort(value.toShort()); builder.endVector() } }

    builder.startTable(1)
    __off_deviceIds?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StartTelemetryRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_deviceIds = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StartTelemetryRequest(
              deviceIds = if (__offset_deviceIds != 0) { val vecOff = tableOffset + __offset_deviceIds + bb.getInt(tableOffset + __offset_deviceIds); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> bb.getShort(vecOff + 4 + i * 2).toUShort() } } else null
          )
    }
  }
}

public class StopTelemetryRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StopTelemetryRequest = StopTelemetryRequest()
  }
}

public data class TelemetrySample(
  public val deviceId: UShort = 0.toUShort(),
  public val time: ULong = 0uL,
  public val rssi: Short? = null,
  public val packetsLost: Int? = null,
  public val packetsReceived: Int? = null,
  public val rssiMin: Short? = null,
  public val rssiMax: Short? = null,
  public val packetLossPct: Float? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(8)
    builder.addShort(0, deviceId.toShort(), 0)
    builder.addLong(1, time.toLong(), 0L)
    if (rssi != null) { builder.forceDefaults(true); builder.addShort(2, rssi, 0); builder.forceDefaults(false) }
    if (packetsLost != null) { builder.forceDefaults(true); builder.addInt(3, packetsLost, 0); builder.forceDefaults(false) }
    if (packetsReceived != null) { builder.forceDefaults(true); builder.addInt(4, packetsReceived, 0); builder.forceDefaults(false) }
    if (rssiMin != null) { builder.forceDefaults(true); builder.addShort(5, rssiMin, 0); builder.forceDefaults(false) }
    if (rssiMax != null) { builder.forceDefaults(true); builder.addShort(6, rssiMax, 0); builder.forceDefaults(false) }
    if (packetLossPct != null) { builder.forceDefaults(true); builder.addFloat(7, packetLossPct, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TelemetrySample {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_deviceId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_time = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_rssi = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_packetsLost = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_packetsReceived = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_rssiMin = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_rssiMax = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_packetLossPct = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0

      return TelemetrySample(
              deviceId = if (__offset_deviceId != 0) bb.getShort(tableOffset + __offset_deviceId).toUShort() else 0.toUShort(),
              time = if (__offset_time != 0) bb.getLong(tableOffset + __offset_time).toULong() else 0uL,
              rssi = if (__offset_rssi != 0) bb.getShort(tableOffset + __offset_rssi) else null,
              packetsLost = if (__offset_packetsLost != 0) bb.getInt(tableOffset + __offset_packetsLost) else null,
              packetsReceived = if (__offset_packetsReceived != 0) bb.getInt(tableOffset + __offset_packetsReceived) else null,
              rssiMin = if (__offset_rssiMin != 0) bb.getShort(tableOffset + __offset_rssiMin) else null,
              rssiMax = if (__offset_rssiMax != 0) bb.getShort(tableOffset + __offset_rssiMax) else null,
              packetLossPct = if (__offset_packetLossPct != 0) bb.getFloat(tableOffset + __offset_packetLossPct) else null
          )
    }
  }
}

public data class TelemetryUpdateResponse(
  public val samples: List<TelemetrySample>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_samples = samples?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(1)
    __off_samples?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TelemetryUpdateResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_samples = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TelemetryUpdateResponse(
              samples = if (__offset_samples != 0) { val vecOff = tableOffset + __offset_samples + bb.getInt(tableOffset + __offset_samples); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) TelemetrySample.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

public data class TelemetryGapEvent(
  public val deviceId: UShort = 0.toUShort(),
  public val time: ULong = 0uL,
  public val durationMs: UInt = 0u,
  public val packetsLost: UInt = 0u,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(4)
    builder.addShort(0, deviceId.toShort(), 0)
    builder.addLong(1, time.toLong(), 0L)
    builder.addInt(2, durationMs.toInt(), 0)
    builder.addInt(3, packetsLost.toInt(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TelemetryGapEvent {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_deviceId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_time = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_durationMs = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_packetsLost = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return TelemetryGapEvent(
              deviceId = if (__offset_deviceId != 0) bb.getShort(tableOffset + __offset_deviceId).toUShort() else 0.toUShort(),
              time = if (__offset_time != 0) bb.getLong(tableOffset + __offset_time).toULong() else 0uL,
              durationMs = if (__offset_durationMs != 0) bb.getInt(tableOffset + __offset_durationMs).toUInt() else 0u,
              packetsLost = if (__offset_packetsLost != 0) bb.getInt(tableOffset + __offset_packetsLost).toUInt() else 0u
          )
    }
  }
}

public data class TelemetryGapResponse(
  public val events: List<TelemetryGapEvent>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_events = events?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(1)
    __off_events?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TelemetryGapResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_events = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TelemetryGapResponse(
              events = if (__offset_events != 0) { val vecOff = tableOffset + __offset_events + bb.getInt(tableOffset + __offset_events); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) TelemetryGapEvent.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}
