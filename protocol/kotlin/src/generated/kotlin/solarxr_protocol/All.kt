package solarxr_protocol

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import solarxr_protocol.connection.ConnectionMessageHeader
import solarxr_protocol.data_feed.DataFeedMessageHeader
import solarxr_protocol.driver_protocol.DriverMessageHeader
import solarxr_protocol.rpc.RpcMessageHeader

/**
 * MessageBundle contains all of the messages for the data feed system and the
 * rpc system that will be sent in one buffer.
 */
public data class MessageBundle(
  public val dataFeedMsgs: List<DataFeedMessageHeader>? = null,
  public val rpcMsgs: List<RpcMessageHeader>? = null,
  public val driverMsgs: List<DriverMessageHeader>? = null,
  public val connectionMsgs: List<ConnectionMessageHeader>? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_dataFeedMsgs = dataFeedMsgs?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }
    val __off_rpcMsgs = rpcMsgs?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }
    val __off_driverMsgs = driverMsgs?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }
    val __off_connectionMsgs = connectionMsgs?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(4)
    __off_dataFeedMsgs?.let { builder.addOffset(0, it, 0) }
    __off_rpcMsgs?.let { builder.addOffset(1, it, 0) }
    __off_driverMsgs?.let { builder.addOffset(2, it, 0) }
    __off_connectionMsgs?.let { builder.addOffset(3, it, 0) }
    return builder.endTable()
  }

  public fun finish(builder: FlatBufferWriter) {
    builder.finish(encode(builder), FILE_IDENTIFIER)
  }

  public companion object {
    public const val FILE_IDENTIFIER: String = "SXMB"

    public fun decode(bb: FlatBufferReader, tableOffset: Int): MessageBundle {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_dataFeedMsgs = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_rpcMsgs = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_driverMsgs = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_connectionMsgs = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return MessageBundle(
              dataFeedMsgs = if (__offset_dataFeedMsgs != 0) { val vecOff = tableOffset + __offset_dataFeedMsgs + bb.getInt(tableOffset + __offset_dataFeedMsgs); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) DataFeedMessageHeader.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null,
              rpcMsgs = if (__offset_rpcMsgs != 0) { val vecOff = tableOffset + __offset_rpcMsgs + bb.getInt(tableOffset + __offset_rpcMsgs); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) RpcMessageHeader.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null,
              driverMsgs = if (__offset_driverMsgs != 0) { val vecOff = tableOffset + __offset_driverMsgs + bb.getInt(tableOffset + __offset_driverMsgs); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) DriverMessageHeader.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null,
              connectionMsgs = if (__offset_connectionMsgs != 0) { val vecOff = tableOffset + __offset_connectionMsgs + bb.getInt(tableOffset + __offset_connectionMsgs); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) ConnectionMessageHeader.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }

    public fun hasIdentifier(bb: FlatBufferReader): Boolean = bb.get(4) == 83.toByte() && bb.get(5) == 88.toByte() && bb.get(6) == 77.toByte() && bb.get(7) == 66.toByte()

    public fun fromByteBuffer(bb: FlatBufferReader): MessageBundle {
      val root = bb.getInt(0) + 0
      return decode(bb, root)
    }
  }
}
