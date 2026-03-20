package solarxr_protocol

import com.google.flatbuffers.FlatBufferBuilder
import java.nio.ByteBuffer
import kotlin.Int
import kotlin.collections.List
import solarxr_protocol.data_feed.DataFeedMessageHeader
import solarxr_protocol.pub_sub.PubSubHeader
import solarxr_protocol.rpc.RpcMessageHeader

/**
 * MessageBundle contains all of the messages for the data feed system and the
 * rpc system that will be sent in one buffer.
 */
data class MessageBundle(
  val dataFeedMsgs: List<DataFeedMessageHeader>? = null,
  val rpcMsgs: List<RpcMessageHeader>? = null,
  val pubSubMsgs: List<PubSubHeader>? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_dataFeedMsgs = dataFeedMsgs?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }
    val __off_rpcMsgs = rpcMsgs?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }
    val __off_pubSubMsgs = pubSubMsgs?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(3)
    __off_dataFeedMsgs?.let { builder.addOffset(0, it, 0) }
    __off_rpcMsgs?.let { builder.addOffset(1, it, 0) }
    __off_pubSubMsgs?.let { builder.addOffset(2, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): MessageBundle {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_dataFeedMsgs = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_rpcMsgs = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_pubSubMsgs = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return MessageBundle(
              dataFeedMsgs = if (__offset_dataFeedMsgs != 0) { val vecOff = tableOffset + __offset_dataFeedMsgs + bb.getInt(tableOffset + __offset_dataFeedMsgs); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.data_feed.DataFeedMessageHeader.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) } } else null,
              rpcMsgs = if (__offset_rpcMsgs != 0) { val vecOff = tableOffset + __offset_rpcMsgs + bb.getInt(tableOffset + __offset_rpcMsgs); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.rpc.RpcMessageHeader.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) } } else null,
              pubSubMsgs = if (__offset_pubSubMsgs != 0) { val vecOff = tableOffset + __offset_pubSubMsgs + bb.getInt(tableOffset + __offset_pubSubMsgs); val len = bb.getInt(vecOff); (0 until len).map { i -> solarxr_protocol.pub_sub.PubSubHeader.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) } } else null
          )
    }

    fun fromByteBuffer(bb: ByteBuffer): MessageBundle {
      bb.order(java.nio.ByteOrder.LITTLE_ENDIAN)
      return decode(bb, bb.getInt(0))
    }
  }
}
