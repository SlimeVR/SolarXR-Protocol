package solarxr_protocol.pub_sub

import com.google.flatbuffers.FlatBufferBuilder
import java.nio.ByteBuffer
import kotlin.Byte
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import solarxr_protocol.datatypes.Bytes
import solarxr_protocol.datatypes.StringTable

sealed interface PubSubUnion {
  companion object {
    fun decode(
      type: Byte,
      bb: ByteBuffer,
      offset: Int,
    ): PubSubUnion? = when (type.toInt()) {
      1 -> Message.decode(bb, offset)
      2 -> SubscriptionRequest.decode(bb, offset)
      3 -> TopicHandleRequest.decode(bb, offset)
      4 -> TopicMapping.decode(bb, offset)
      else -> null
    }

    fun typeIndex(`value`: PubSubUnion): Byte = when (value) {
      is Message -> 1
      is SubscriptionRequest -> 2
      is TopicHandleRequest -> 3
      is TopicMapping -> 4
      else -> 0
    }

    fun encode(`value`: PubSubUnion, builder: FlatBufferBuilder): Int = when (value) {
      is Message -> value.encode(builder)
      is SubscriptionRequest -> value.encode(builder)
      is TopicHandleRequest -> value.encode(builder)
      is TopicMapping -> value.encode(builder)
      else -> 0
    }
  }
}

data class PubSubHeader(
  val u: PubSubUnion? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_u = u?.let { PubSubUnion.encode(it, builder) }
    val __type_u = u?.let { PubSubUnion.typeIndex(it) } ?: 0.toByte()

    builder.startTable(2)
    builder.addByte(0, __type_u, 0)
    __off_u?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): PubSubHeader {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __type_u = if (vtableSize > 4 && bb.getShort(vtableOffset + 4).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 4).toInt()) else 0
      val __offset_u = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return PubSubHeader(
              u = if (__offset_u != 0) solarxr_protocol.pub_sub.PubSubUnion.decode(__type_u, bb, tableOffset + __offset_u + bb.getInt(tableOffset + __offset_u)) else null
          )
    }
  }
}

interface Payload {
  companion object {
    fun decode(
      type: Byte,
      bb: ByteBuffer,
      offset: Int,
    ): Payload? = when (type.toInt()) {
      1 -> StringTable.decode(bb, offset)
      2 -> Bytes.decode(bb, offset)
      3 -> KeyValues.decode(bb, offset)
      else -> null
    }

    fun typeIndex(`value`: Payload): Byte = when (value) {
      is StringTable -> 1
      is Bytes -> 2
      is KeyValues -> 3
      else -> 0
    }

    fun encode(`value`: Payload, builder: FlatBufferBuilder): Int = when (value) {
      is StringTable -> value.encode(builder)
      is Bytes -> value.encode(builder)
      is KeyValues -> value.encode(builder)
      else -> 0
    }
  }
}

/**
 * Data that is sent from publishers to subscribers
 */
data class Message(
  val topic: Topic? = null,
  val payload: Payload? = null,
) : PubSubUnion {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_topic = topic?.let { Topic.encode(it, builder) }
    val __type_topic = topic?.let { Topic.typeIndex(it) } ?: 0.toByte()
    val __off_payload = payload?.let { Payload.encode(it, builder) }
    val __type_payload = payload?.let { Payload.typeIndex(it) } ?: 0.toByte()

    builder.startTable(4)
    builder.addByte(0, __type_topic, 0)
    __off_topic?.let { builder.addOffset(1, it, 0) }
    builder.addByte(2, __type_payload, 0)
    __off_payload?.let { builder.addOffset(3, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): Message {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __type_topic = if (vtableSize > 4 && bb.getShort(vtableOffset + 4).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 4).toInt()) else 0
      val __offset_topic = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __type_payload = if (vtableSize > 8 && bb.getShort(vtableOffset + 8).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 8).toInt()) else 0
      val __offset_payload = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return Message(
              topic = if (__offset_topic != 0) solarxr_protocol.pub_sub.Topic.decode(__type_topic, bb, tableOffset + __offset_topic + bb.getInt(tableOffset + __offset_topic)) else null,
              payload = if (__offset_payload != 0) solarxr_protocol.pub_sub.Payload.decode(__type_payload, bb, tableOffset + __offset_payload + bb.getInt(tableOffset + __offset_payload)) else null
          )
    }
  }
}

data class KeyValues(
  val keys: List<String>? = null,
  val values: List<String>? = null,
) : Payload {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_keys = keys?.let { builder.createVectorOfTables(it.map { s -> builder.createString(s) }.toIntArray()) }
    val __off_values = values?.let { builder.createVectorOfTables(it.map { s -> builder.createString(s) }.toIntArray()) }

    builder.startTable(2)
    __off_keys?.let { builder.addOffset(0, it, 0) }
    __off_values?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): KeyValues {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_keys = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_values = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return KeyValues(
              keys = if (__offset_keys != 0) { val vecOff = tableOffset + __offset_keys + bb.getInt(tableOffset + __offset_keys); val len = bb.getInt(vecOff); (0 until len).map { i -> bb.getInt(vecOff + 4 + i * 4).let { strOff -> val len = bb.getInt(vecOff + 4 + i * 4 + strOff); ByteArray(len).also { bb.position(vecOff + 4 + i * 4 + strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } } } else null,
              values = if (__offset_values != 0) { val vecOff = tableOffset + __offset_values + bb.getInt(tableOffset + __offset_values); val len = bb.getInt(vecOff); (0 until len).map { i -> bb.getInt(vecOff + 4 + i * 4).let { strOff -> val len = bb.getInt(vecOff + 4 + i * 4 + strOff); ByteArray(len).also { bb.position(vecOff + 4 + i * 4 + strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } } } else null
          )
    }
  }
}
