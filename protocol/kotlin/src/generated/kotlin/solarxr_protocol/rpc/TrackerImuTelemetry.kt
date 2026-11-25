package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Int
import kotlin.ULong
import kotlin.UShort
import kotlin.collections.List
import solarxr_protocol.datatypes.math.Quat
import solarxr_protocol.datatypes.math.Vec3f

public data class StartTrackerImuTelemetryRequest(
  public val trackerId: UShort = 0.toUShort(),
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addShort(0, trackerId.toShort(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StartTrackerImuTelemetryRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StartTrackerImuTelemetryRequest(
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else 0.toUShort()
          )
    }
  }
}

public class StopTrackerImuTelemetryRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StopTrackerImuTelemetryRequest = StopTrackerImuTelemetryRequest()
  }
}

public data class TrackerImuSample(
  public val time: ULong = 0uL,
  public val rawRotation: Quat? = null,
  public val rotation: Quat? = null,
  public val rawAcceleration: Vec3f? = null,
  public val linearAcceleration: Vec3f? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(5)
    builder.addLong(0, time.toLong(), 0L)
    rawRotation?.let { builder.addStruct(1, it.encode(builder), 0) }
    rotation?.let { builder.addStruct(2, it.encode(builder), 0) }
    rawAcceleration?.let { builder.addStruct(3, it.encode(builder), 0) }
    linearAcceleration?.let { builder.addStruct(4, it.encode(builder), 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackerImuSample {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_time = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_rawRotation = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_rotation = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_rawAcceleration = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_linearAcceleration = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return TrackerImuSample(
              time = if (__offset_time != 0) bb.getLong(tableOffset + __offset_time).toULong() else 0uL,
              rawRotation = if (__offset_rawRotation != 0) Quat.decode(bb, tableOffset + __offset_rawRotation) else null,
              rotation = if (__offset_rotation != 0) Quat.decode(bb, tableOffset + __offset_rotation) else null,
              rawAcceleration = if (__offset_rawAcceleration != 0) Vec3f.decode(bb, tableOffset + __offset_rawAcceleration) else null,
              linearAcceleration = if (__offset_linearAcceleration != 0) Vec3f.decode(bb, tableOffset + __offset_linearAcceleration) else null
          )
    }
  }
}

public data class TrackerImuTelemetryResponse(
  public val trackerId: UShort = 0.toUShort(),
  public val samples: List<TrackerImuSample>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_samples = samples?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(2)
    builder.addShort(0, trackerId.toShort(), 0)
    __off_samples?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackerImuTelemetryResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_samples = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return TrackerImuTelemetryResponse(
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else 0.toUShort(),
              samples = if (__offset_samples != 0) { val vecOff = tableOffset + __offset_samples + bb.getInt(tableOffset + __offset_samples); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) TrackerImuSample.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}
