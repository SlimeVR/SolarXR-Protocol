package solarxr_protocol.pub_sub

import com.google.flatbuffers.FlatBufferBuilder
import java.nio.ByteBuffer
import kotlin.Byte
import kotlin.Int
import kotlin.String
import kotlin.UShort

/**
 * A `TopicId` identifies an application-specific category of data. Because it
 * is application-specific, it is up to the application within the specified
 * organization to define its semantics/meaning.
 *
 * For example, "bob" may have an "overlay" app with a "settings" topic for controlling
 * the overlay visibility and other settings, as well as a "video feed" topic for
 * allowing other applications to display video data in a wrist mounted window in VR.
 */
data class TopicId(
  val organization: String? = null,
  val appName: String? = null,
  val topic: String? = null,
) : Topic {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_organization = organization?.let { builder.createString(it) }
    val __off_appName = appName?.let { builder.createString(it) }
    val __off_topic = topic?.let { builder.createString(it) }

    builder.startTable(3)
    __off_organization?.let { builder.addOffset(0, it, 0) }
    __off_appName?.let { builder.addOffset(1, it, 0) }
    __off_topic?.let { builder.addOffset(2, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): TopicId {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_organization = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_appName = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_topic = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return TopicId(
              organization = if (__offset_organization != 0) { val strOff = tableOffset + __offset_organization + bb.getInt(tableOffset + __offset_organization); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              appName = if (__offset_appName != 0) { val strOff = tableOffset + __offset_appName + bb.getInt(tableOffset + __offset_appName); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              topic = if (__offset_topic != 0) { val strOff = tableOffset + __offset_topic + bb.getInt(tableOffset + __offset_topic); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null
          )
    }
  }
}

/**
 * A handle for the topic, allows referencing a topic without sending a huge
 * `TopicId`.
 */
data class TopicHandle(
  val id: UShort? = null,
) : Topic {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(1)
    id?.let { builder.addShort(0, it.toShort(), 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): TopicHandle {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_id = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TopicHandle(
              id = if (__offset_id != 0) bb.getShort(tableOffset + __offset_id).toUShort() else null
          )
    }
  }
}

sealed interface Topic {
  companion object {
    fun decode(
      type: Byte,
      bb: ByteBuffer,
      offset: Int,
    ): Topic? = when (type.toInt()) {
      1 -> TopicHandle.decode(bb, offset)
      2 -> TopicId.decode(bb, offset)
      else -> null
    }

    fun typeIndex(`value`: Topic): Byte = when (value) {
      is TopicHandle -> 1
      is TopicId -> 2
      else -> 0
    }

    fun encode(`value`: Topic, builder: FlatBufferBuilder): Int = when (value) {
      is TopicHandle -> value.encode(builder)
      is TopicId -> value.encode(builder)
      else -> 0
    }
  }
}

/**
 * Response for `TopicHandleRequest` or `SubscriptionRequest`.
 */
data class TopicMapping(
  val id: TopicId? = null,
  val handle: TopicHandle? = null,
) : PubSubUnion {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_id = id?.encode(builder)
    val __off_handle = handle?.encode(builder)

    builder.startTable(2)
    __off_id?.let { builder.addOffset(0, it, 0) }
    __off_handle?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): TopicMapping {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_id = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_handle = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return TopicMapping(
              id = if (__offset_id != 0) solarxr_protocol.pub_sub.TopicId.decode(bb, tableOffset + __offset_id + bb.getInt(tableOffset + __offset_id)) else null,
              handle = if (__offset_handle != 0) solarxr_protocol.pub_sub.TopicHandle.decode(bb, tableOffset + __offset_handle + bb.getInt(tableOffset + __offset_handle)) else null
          )
    }
  }
}

/**
 * Request to get the `FeatureHandle` from a `FeatureId`. This is useful for reducing
 * bandwidth, since `FeatureId` can be large.
 */
data class TopicHandleRequest(
  val id: TopicId? = null,
) : PubSubUnion {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_id = id?.encode(builder)

    builder.startTable(1)
    __off_id?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): TopicHandleRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_id = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TopicHandleRequest(
              id = if (__offset_id != 0) solarxr_protocol.pub_sub.TopicId.decode(bb, tableOffset + __offset_id + bb.getInt(tableOffset + __offset_id)) else null
          )
    }
  }
}

/**
 * Requests a subscription to `topic`. Replies with a `TopicMapping`.
 */
data class SubscriptionRequest(
  val topic: Topic? = null,
) : PubSubUnion {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_topic = topic?.let { Topic.encode(it, builder) }
    val __type_topic = topic?.let { Topic.typeIndex(it) } ?: 0.toByte()

    builder.startTable(2)
    builder.addByte(0, __type_topic, 0)
    __off_topic?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SubscriptionRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __type_topic = if (vtableSize > 4 && bb.getShort(vtableOffset + 4).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 4).toInt()) else 0
      val __offset_topic = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return SubscriptionRequest(
              topic = if (__offset_topic != 0) solarxr_protocol.pub_sub.Topic.decode(__type_topic, bb, tableOffset + __offset_topic + bb.getInt(tableOffset + __offset_topic)) else null
          )
    }
  }
}
