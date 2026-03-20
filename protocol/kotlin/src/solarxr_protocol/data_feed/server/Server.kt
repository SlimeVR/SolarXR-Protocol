package solarxr_protocol.data_feed.server

import com.google.flatbuffers.FlatBufferBuilder
import java.nio.ByteBuffer
import kotlin.Boolean
import kotlin.Int

data class ServerGuards(
  val candomounting: Boolean? = null,
  val candoyawreset: Boolean? = null,
  val candouserheightcalibration: Boolean? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(3)
    candomounting?.let { builder.addBoolean(0, it, false) }
    candoyawreset?.let { builder.addBoolean(1, it, false) }
    candouserheightcalibration?.let { builder.addBoolean(2, it, false) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): ServerGuards {
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
