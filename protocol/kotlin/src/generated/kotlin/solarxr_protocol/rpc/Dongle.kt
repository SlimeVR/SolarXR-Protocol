package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Int
import kotlin.String
import kotlin.UShort

public data class ChangeDongleSettingsRequest(
  public val dongleId: UShort = 0.toUShort(),
  public val displayName: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_displayName = displayName?.let { builder.createString(it) }

    builder.startTable(2)
    builder.addShort(0, dongleId.toShort(), 0)
    __off_displayName?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeDongleSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_dongleId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_displayName = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return ChangeDongleSettingsRequest(
              dongleId = if (__offset_dongleId != 0) bb.getShort(tableOffset + __offset_dongleId).toUShort() else 0.toUShort(),
              displayName = if (__offset_displayName != 0) readFlatBufferString(bb, tableOffset + __offset_displayName) else null
          )
    }
  }
}
