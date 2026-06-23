package solarxr_protocol.data_feed.server

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Int

public data class ServerGuards(
  public val canDoMounting: Boolean? = null,
  public val canDoYawReset: Boolean? = null,
  public val canDoUserHeightCalibration: Boolean? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(3)
    if (canDoMounting != null) { builder.forceDefaults(true); builder.addBoolean(0, canDoMounting, false); builder.forceDefaults(false) }
    if (canDoYawReset != null) { builder.forceDefaults(true); builder.addBoolean(1, canDoYawReset, false); builder.forceDefaults(false) }
    if (canDoUserHeightCalibration != null) { builder.forceDefaults(true); builder.addBoolean(2, canDoUserHeightCalibration, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ServerGuards {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_canDoMounting = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_canDoYawReset = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_canDoUserHeightCalibration = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return ServerGuards(
              canDoMounting = if (__offset_canDoMounting != 0) bb.get(tableOffset + __offset_canDoMounting) != 0.toByte() else null,
              canDoYawReset = if (__offset_canDoYawReset != 0) bb.get(tableOffset + __offset_canDoYawReset) != 0.toByte() else null,
              canDoUserHeightCalibration = if (__offset_canDoUserHeightCalibration != 0) bb.get(tableOffset + __offset_canDoUserHeightCalibration) != 0.toByte() else null
          )
    }
  }
}
