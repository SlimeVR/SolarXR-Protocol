package solarxr_protocol.data_feed.server

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Int
import kotlin.UByte

public enum class ResetAvailability(
  public val `value`: UByte,
) {
  AVAILABLE(0.toUByte()),
  NEEDS_FULL_RESET(1.toUByte()),
  NEEDS_POSITIONAL_HEAD(2.toUByte()),
  NO_TRACKERS(3.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): ResetAvailability? = entries.firstOrNull { it.value == value }
  }
}

/**
 * Contains various of flags / guards that inform the GUI
 * about possible actions or blocked states.
 * The idea is to have one source of truth for all these rules
 * that are spread accross the GUI.
 */
public data class ServerGuards(
  public val yawReset: ResetAvailability = ResetAvailability.AVAILABLE,
  public val mountingReset: ResetAvailability = ResetAvailability.AVAILABLE,
  public val canDoUserHeightCalibration: Boolean = false,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(3)
    builder.addByte(0, yawReset.value.toByte(), 0)
    builder.addByte(1, mountingReset.value.toByte(), 0)
    builder.addBoolean(2, canDoUserHeightCalibration, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ServerGuards {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_yawReset = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_mountingReset = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_canDoUserHeightCalibration = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return ServerGuards(
              yawReset = if (__offset_yawReset != 0) ResetAvailability.fromValue(bb.get(tableOffset + __offset_yawReset).toUByte()) ?: ResetAvailability.AVAILABLE else ResetAvailability.AVAILABLE,
              mountingReset = if (__offset_mountingReset != 0) ResetAvailability.fromValue(bb.get(tableOffset + __offset_mountingReset).toUByte()) ?: ResetAvailability.AVAILABLE else ResetAvailability.AVAILABLE,
              canDoUserHeightCalibration = if (__offset_canDoUserHeightCalibration != 0) bb.get(tableOffset + __offset_canDoUserHeightCalibration) != 0.toByte() else false
          )
    }
  }
}
