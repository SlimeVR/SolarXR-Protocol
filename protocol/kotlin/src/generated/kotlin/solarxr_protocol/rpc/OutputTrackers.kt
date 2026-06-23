package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Int
import kotlin.collections.List
import solarxr_protocol.datatypes.BodyPart

public class OutputTrackersSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OutputTrackersSettingsRequest = OutputTrackersSettingsRequest()
  }
}

public data class OutputTrackersSettingsResponse(
  public val automaticTrackerToggle: Boolean? = null,
  public val trackers: List<BodyPart>? = null,
  public val sendDerivedVelocity: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackers = trackers?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }

    builder.startTable(3)
    if (automaticTrackerToggle != null) { builder.forceDefaults(true); builder.addBoolean(0, automaticTrackerToggle, false); builder.forceDefaults(false) }
    __off_trackers?.let { builder.addOffset(1, it, 0) }
    if (sendDerivedVelocity != null) { builder.forceDefaults(true); builder.addBoolean(2, sendDerivedVelocity, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OutputTrackersSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_automaticTrackerToggle = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_trackers = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_sendDerivedVelocity = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return OutputTrackersSettingsResponse(
              automaticTrackerToggle = if (__offset_automaticTrackerToggle != 0) bb.get(tableOffset + __offset_automaticTrackerToggle) != 0.toByte() else null,
              trackers = if (__offset_trackers != 0) { val vecOff = tableOffset + __offset_trackers + bb.getInt(tableOffset + __offset_trackers); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> BodyPart.fromValue(bb.get(vecOff + 4 + i * 1).toUByte()) } } else null,
              sendDerivedVelocity = if (__offset_sendDerivedVelocity != 0) bb.get(tableOffset + __offset_sendDerivedVelocity) != 0.toByte() else null
          )
    }
  }
}

public data class ChangeOutputTrackersSettingsRequest(
  public val automaticTrackerToggle: Boolean? = null,
  public val trackers: List<BodyPart>? = null,
  public val sendDerivedVelocity: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackers = trackers?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }

    builder.startTable(3)
    if (automaticTrackerToggle != null) { builder.forceDefaults(true); builder.addBoolean(0, automaticTrackerToggle, false); builder.forceDefaults(false) }
    __off_trackers?.let { builder.addOffset(1, it, 0) }
    if (sendDerivedVelocity != null) { builder.forceDefaults(true); builder.addBoolean(2, sendDerivedVelocity, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeOutputTrackersSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_automaticTrackerToggle = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_trackers = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_sendDerivedVelocity = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return ChangeOutputTrackersSettingsRequest(
              automaticTrackerToggle = if (__offset_automaticTrackerToggle != 0) bb.get(tableOffset + __offset_automaticTrackerToggle) != 0.toByte() else null,
              trackers = if (__offset_trackers != 0) { val vecOff = tableOffset + __offset_trackers + bb.getInt(tableOffset + __offset_trackers); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> BodyPart.fromValue(bb.get(vecOff + 4 + i * 1).toUByte()) } } else null,
              sendDerivedVelocity = if (__offset_sendDerivedVelocity != 0) bb.get(tableOffset + __offset_sendDerivedVelocity) != 0.toByte() else null
          )
    }
  }
}
