package solarxr_protocol.data_feed.server

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Int

/**
 * Contains various of flags / guards that inform the GUI
 * about possible actions or blocked states.
 * The idea is to have one source of truth for all these rules
 * that are spread accross the GUI.
 */
public data class ServerGuards(
  public val canDoMountingReset: Boolean = false,
  public val canDoYawReset: Boolean = false,
  public val canDoUserHeightCalibration: Boolean = false,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(3)
    builder.addBoolean(0, canDoMountingReset, false)
    builder.addBoolean(1, canDoYawReset, false)
    builder.addBoolean(2, canDoUserHeightCalibration, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ServerGuards {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_canDoMountingReset = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_canDoYawReset = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_canDoUserHeightCalibration = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return ServerGuards(
              canDoMountingReset = if (__offset_canDoMountingReset != 0) bb.get(tableOffset + __offset_canDoMountingReset) != 0.toByte() else false,
              canDoYawReset = if (__offset_canDoYawReset != 0) bb.get(tableOffset + __offset_canDoYawReset) != 0.toByte() else false,
              canDoUserHeightCalibration = if (__offset_canDoUserHeightCalibration != 0) bb.get(tableOffset + __offset_canDoUserHeightCalibration) != 0.toByte() else false
          )
    }
  }
}
