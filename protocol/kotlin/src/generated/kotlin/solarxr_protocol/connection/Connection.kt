package solarxr_protocol.connection

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort

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
 * First message on a connection. It opens the configuration phase, in which the
 * client sends its requests for optional features before ConfigurationDone.
 */
public data class ClientHello(
  public val protocolVersion: UInt = 0u,
) : ConnectionMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addInt(0, protocolVersion.toInt(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ClientHello {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_protocolVersion = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ClientHello(
              protocolVersion = if (__offset_protocolVersion != 0) bb.getInt(tableOffset + __offset_protocolVersion).toUInt() else 0u
          )
    }
  }
}

/**
 * After a connection server reply with its status and if it accepted the connection
 */
public data class ServerHello(
  public val status: HelloStatus = HelloStatus.ACCEPTED,
  public val protocolVersion: UInt = 0u,
) : ConnectionMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    builder.addByte(0, status.value.toByte(), 0)
    builder.addInt(1, protocolVersion.toInt(), 0)
    return builder.endTable()
  }

  public companion object {
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
  }
}

/**
 * Ends one peer's half of the configuration phase, and is required from both: the
 * client sends it after its last request, the server after its last answer and only
 * once it has seen the client's. Until a peer sends it, it may spread configuration
 * over further bundles. Application messages flow once both peers have sent it.
 */
public class ConfigurationDone : ConnectionMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ConfigurationDone = ConfigurationDone()
  }
}

public data class UnknownBoneError(
  public val boneId: UShort = 0.toUShort(),
) : ConnectionErrorData {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addShort(0, boneId.toShort(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): UnknownBoneError {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_boneId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return UnknownBoneError(
              boneId = if (__offset_boneId != 0) bb.getShort(tableOffset + __offset_boneId).toUShort() else 0.toUShort()
          )
    }
  }
}

public class InvalidRegistryError : ConnectionErrorData {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): InvalidRegistryError = InvalidRegistryError()
  }
}

public class InitializationRequiredError : ConnectionErrorData {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): InitializationRequiredError = InitializationRequiredError()
  }
}

/**
 * A message used something this connection never requested during configuration.
 */
public class MissingRequestError : ConnectionErrorData {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): MissingRequestError = MissingRequestError()
  }
}

/**
 * A request made during configuration that this peer does not implement.
 */
public class UnsupportedRequestError : ConnectionErrorData {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): UnsupportedRequestError = UnsupportedRequestError()
  }
}

public sealed interface ConnectionErrorData {
  public companion object {
    public fun decode(
      type: UByte,
      bb: FlatBufferReader,
      offset: Int,
    ): ConnectionErrorData? = when (type.toInt()) {
      1 -> UnknownBoneError.decode(bb, offset)
      2 -> InvalidRegistryError.decode(bb, offset)
      3 -> InitializationRequiredError.decode(bb, offset)
      4 -> MissingRequestError.decode(bb, offset)
      5 -> UnsupportedRequestError.decode(bb, offset)
      else -> null
    }

    public fun typeIndex(`value`: ConnectionErrorData): UByte = when (value) {
      is UnknownBoneError -> 1.toUByte()
      is InvalidRegistryError -> 2.toUByte()
      is InitializationRequiredError -> 3.toUByte()
      is MissingRequestError -> 4.toUByte()
      is UnsupportedRequestError -> 5.toUByte()
    }

    public fun encode(`value`: ConnectionErrorData, builder: FlatBufferWriter): Int = when (value) {
      is UnknownBoneError -> value.encode(builder)
      is InvalidRegistryError -> value.encode(builder)
      is InitializationRequiredError -> value.encode(builder)
      is MissingRequestError -> value.encode(builder)
      is UnsupportedRequestError -> value.encode(builder)
    }
  }
}

public data class ConnectionError(
  public val message: String? = null,
  public val `data`: ConnectionErrorData? = null,
) : ConnectionMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_message = message?.let { builder.createString(it) }
    val __off_data = data?.let { ConnectionErrorData.encode(it, builder) }
    val __type_data = data?.let { ConnectionErrorData.typeIndex(it) } ?: 0.toUByte()

    builder.startTable(3)
    __off_message?.let { builder.addOffset(0, it, 0) }
    builder.addByte(1, __type_data.toByte(), 0)
    __off_data?.let { builder.addOffset(2, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ConnectionError {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_message = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __type_data = if (vtableSize > 6 && bb.getShort(vtableOffset + 6).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 6).toInt()).toUByte() else 0.toUByte()
      val __offset_data = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return ConnectionError(
              message = if (__offset_message != 0) readFlatBufferString(bb, tableOffset + __offset_message) else null,
              data = if (__offset_data != 0) ConnectionErrorData.decode(__type_data, bb, tableOffset + __offset_data + bb.getInt(tableOffset + __offset_data)) else null
          )
    }
  }
}

public sealed interface ConnectionMessage {
  public companion object {
    public fun decode(
      type: UByte,
      bb: FlatBufferReader,
      offset: Int,
    ): ConnectionMessage? = when (type.toInt()) {
      1 -> ClientHello.decode(bb, offset)
      2 -> ServerHello.decode(bb, offset)
      3 -> ConfigurationDone.decode(bb, offset)
      4 -> ConnectionError.decode(bb, offset)
      5 -> BoneRegistryRequest.decode(bb, offset)
      6 -> BoneRegistry.decode(bb, offset)
      else -> null
    }

    public fun typeIndex(`value`: ConnectionMessage): UByte = when (value) {
      is ClientHello -> 1.toUByte()
      is ServerHello -> 2.toUByte()
      is ConfigurationDone -> 3.toUByte()
      is ConnectionError -> 4.toUByte()
      is BoneRegistryRequest -> 5.toUByte()
      is BoneRegistry -> 6.toUByte()
    }

    public fun encode(`value`: ConnectionMessage, builder: FlatBufferWriter): Int = when (value) {
      is ClientHello -> value.encode(builder)
      is ServerHello -> value.encode(builder)
      is ConfigurationDone -> value.encode(builder)
      is ConnectionError -> value.encode(builder)
      is BoneRegistryRequest -> value.encode(builder)
      is BoneRegistry -> value.encode(builder)
    }
  }
}

public data class ConnectionMessageHeader(
  public val message: ConnectionMessage? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_message = message?.let { ConnectionMessage.encode(it, builder) }
    val __type_message = message?.let { ConnectionMessage.typeIndex(it) } ?: 0.toUByte()

    builder.startTable(2)
    builder.addByte(0, __type_message.toByte(), 0)
    __off_message?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ConnectionMessageHeader {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __type_message = if (vtableSize > 4 && bb.getShort(vtableOffset + 4).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 4).toInt()).toUByte() else 0.toUByte()
      val __offset_message = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return ConnectionMessageHeader(
              message = if (__offset_message != 0) ConnectionMessage.decode(__type_message, bb, tableOffset + __offset_message + bb.getInt(tableOffset + __offset_message)) else null
          )
    }
  }
}
