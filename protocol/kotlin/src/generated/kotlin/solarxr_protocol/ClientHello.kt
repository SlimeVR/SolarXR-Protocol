package solarxr_protocol

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.UInt

/**
 * Sent as the first frame on a SolarXR connection. This root is deliberately
 * separate from MessageBundle so a receiver can reject an incompatible peer
 * before accepting application messages.
 */
public data class ClientHello(
  public val protocolVersion: UInt = 0u,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addInt(0, protocolVersion.toInt(), 0)
    return builder.endTable()
  }

  public fun finish(builder: FlatBufferWriter) {
    builder.finish(encode(builder), FILE_IDENTIFIER)
  }

  public companion object {
    public const val FILE_IDENTIFIER: String = "SXCH"

    public fun decode(bb: FlatBufferReader, tableOffset: Int): ClientHello {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_protocolVersion = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ClientHello(
              protocolVersion = if (__offset_protocolVersion != 0) bb.getInt(tableOffset + __offset_protocolVersion).toUInt() else 0u
          )
    }

    public fun hasIdentifier(bb: FlatBufferReader): Boolean = bb.get(4) == 83.toByte() && bb.get(5) == 88.toByte() && bb.get(6) == 67.toByte() && bb.get(7) == 72.toByte()

    public fun fromByteBuffer(bb: FlatBufferReader): ClientHello {
      val root = bb.getInt(0) + 0
      return decode(bb, root)
    }
  }
}
