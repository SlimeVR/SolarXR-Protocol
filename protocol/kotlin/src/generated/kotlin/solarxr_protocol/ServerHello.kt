package solarxr_protocol

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt

public enum class HelloStatus(
  public val `value`: UByte,
) {
  ACCEPTED(0.toUByte()),
  REJECTED_UNSUPPORTED_VERSION(1.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): HelloStatus? = entries.firstOrNull { it.value == value }
  }
}

/**
 * Reply to ClientHello. The fields and enum values in this standalone root
 * are frozen once published.
 */
public data class ServerHello(
  public val status: HelloStatus = HelloStatus.ACCEPTED,
  public val protocolVersion: UInt = 0u,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    builder.addByte(0, status.value.toByte(), 0)
    builder.addInt(1, protocolVersion.toInt(), 0)
    return builder.endTable()
  }

  public fun finish(builder: FlatBufferWriter) {
    builder.finish(encode(builder), FILE_IDENTIFIER)
  }

  public companion object {
    public const val FILE_IDENTIFIER: String = "SXSH"

    public fun decode(bb: FlatBufferReader, tableOffset: Int): ServerHello {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_status = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_protocolVersion = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return ServerHello(
              status = if (__offset_status != 0) HelloStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) ?: HelloStatus.ACCEPTED else HelloStatus.ACCEPTED,
              protocolVersion = if (__offset_protocolVersion != 0) bb.getInt(tableOffset + __offset_protocolVersion).toUInt() else 0u
          )
    }

    public fun hasIdentifier(bb: FlatBufferReader): Boolean = bb.get(4) == 83.toByte() && bb.get(5) == 88.toByte() && bb.get(6) == 83.toByte() && bb.get(7) == 72.toByte()

    public fun fromByteBuffer(bb: FlatBufferReader): ServerHello {
      val root = bb.getInt(0) + 0
      return decode(bb, root)
    }
  }
}
