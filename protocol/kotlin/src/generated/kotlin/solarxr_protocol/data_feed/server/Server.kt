package solarxr_protocol.data_feed.server

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Int

public data class ServerGuards(
  public val candomounting: Boolean? = null,
  public val candoyawreset: Boolean? = null,
  public val candouserheightcalibration: Boolean? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(3)
    if (candomounting != null) { builder.forceDefaults(true); builder.addBoolean(0, candomounting, false); builder.forceDefaults(false) }
    if (candoyawreset != null) { builder.forceDefaults(true); builder.addBoolean(1, candoyawreset, false); builder.forceDefaults(false) }
    if (candouserheightcalibration != null) { builder.forceDefaults(true); builder.addBoolean(2, candouserheightcalibration, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ServerGuards {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_candomounting = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_candoyawreset = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_candouserheightcalibration = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return ServerGuards(
              candomounting = if (__offset_candomounting != 0) bb.get(tableOffset + __offset_candomounting) != 0.toByte() else null,
              candoyawreset = if (__offset_candoyawreset != 0) bb.get(tableOffset + __offset_candoyawreset) != 0.toByte() else null,
              candouserheightcalibration = if (__offset_candouserheightcalibration != 0) bb.get(tableOffset + __offset_candouserheightcalibration) != 0.toByte() else null
          )
    }
  }
}
