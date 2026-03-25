package solarxr_protocol.data_feed.server

import com.google.flatbuffers.FlatBufferBuilder
import java.nio.ByteBuffer
import kotlin.Boolean
import kotlin.Int

data class ServerGuards(
  val candomounting: Boolean = false,
  val candoyawreset: Boolean = false,
  val candouserheightcalibration: Boolean = false,
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(3)
    builder.addBoolean(0, candomounting, false)
    builder.addBoolean(1, candoyawreset, false)
    builder.addBoolean(2, candouserheightcalibration, false)
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
              candomounting = if (__offset_candomounting != 0) bb.get(tableOffset + __offset_candomounting) != 0.toByte() else false,
              candoyawreset = if (__offset_candoyawreset != 0) bb.get(tableOffset + __offset_candoyawreset) != 0.toByte() else false,
              candouserheightcalibration = if (__offset_candouserheightcalibration != 0) bb.get(tableOffset + __offset_candouserheightcalibration) != 0.toByte() else false
          )
    }
  }
}
