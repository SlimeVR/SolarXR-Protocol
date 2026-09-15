package solarxr_protocol.connection

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UShort
import kotlin.collections.List
import solarxr_protocol.datatypes.BodyPart

public data class BoneDefinition(
  public val id: UShort = 0.toUShort(),
  public val key: String,
  public val displayName: String? = null,
  public val parent: UShort = 0.toUShort(),
  public val standardBodyPart: BodyPart? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_key = key?.let { builder.createString(it) }
    val __off_displayName = displayName?.let { builder.createString(it) }

    builder.startTable(5)
    builder.addShort(0, id.toShort(), 0)
    __off_key?.let { builder.addOffset(1, it, 0) }
    __off_displayName?.let { builder.addOffset(2, it, 0) }
    builder.addShort(3, parent.toShort(), 0)
    if (standardBodyPart != null) { builder.forceDefaults(true); builder.addByte(4, standardBodyPart.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): BoneDefinition {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_id = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_key = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_displayName = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_parent = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_standardBodyPart = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return BoneDefinition(
              id = if (__offset_id != 0) bb.getShort(tableOffset + __offset_id).toUShort() else 0.toUShort(),
              key = if (__offset_key != 0) readFlatBufferString(bb, tableOffset + __offset_key) else error("Table field 'key' is required but missing"),
              displayName = if (__offset_displayName != 0) readFlatBufferString(bb, tableOffset + __offset_displayName) else null,
              parent = if (__offset_parent != 0) bb.getShort(tableOffset + __offset_parent).toUShort() else 0.toUShort(),
              standardBodyPart = if (__offset_standardBodyPart != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_standardBodyPart).toUByte()) else null
          )
    }
  }
}

/**
 * Authoritative, connection-wide bone identity and hierarchy: a flat list where
 * each definition names its own parent. IDs are compact registry-local handles;
 * persist keys and resolve them after reconnecting.
 */
public data class BoneRegistry(
  public val bones: List<BoneDefinition>,
) : ConnectionMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_bones = bones?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(1)
    __off_bones?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): BoneRegistry {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bones = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return BoneRegistry(
              bones = if (__offset_bones != 0) { val vecOff = tableOffset + __offset_bones + bb.getInt(tableOffset + __offset_bones); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) BoneDefinition.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else error("Table field 'bones' is required but missing")
          )
    }
  }
}

public class FinishConfiguration : ConnectionMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): FinishConfiguration = FinishConfiguration()
  }
}

public class ConfigurationAcknowledged : ConnectionMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ConfigurationAcknowledged = ConfigurationAcknowledged()
  }
}

public enum class ConnectionErrorCode(
  public val `value`: UByte,
) {
  UNKNOWN_BONE(0.toUByte()),
  INVALID_REGISTRY(1.toUByte()),
  INITIALIZATION_REQUIRED(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): ConnectionErrorCode? = entries.firstOrNull { it.value == value }
  }
}

public data class ConnectionError(
  public val code: ConnectionErrorCode = ConnectionErrorCode.UNKNOWN_BONE,
  public val message: String? = null,
  public val boneId: UShort = 0.toUShort(),
) : ConnectionMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_message = message?.let { builder.createString(it) }

    builder.startTable(3)
    builder.addByte(0, code.value.toByte(), 0)
    __off_message?.let { builder.addOffset(1, it, 0) }
    builder.addShort(2, boneId.toShort(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ConnectionError {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_code = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_message = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_boneId = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return ConnectionError(
              code = if (__offset_code != 0) ConnectionErrorCode.fromValue(bb.get(tableOffset + __offset_code).toUByte()) ?: ConnectionErrorCode.UNKNOWN_BONE else ConnectionErrorCode.UNKNOWN_BONE,
              message = if (__offset_message != 0) readFlatBufferString(bb, tableOffset + __offset_message) else null,
              boneId = if (__offset_boneId != 0) bb.getShort(tableOffset + __offset_boneId).toUShort() else 0.toUShort()
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
      1 -> BoneRegistry.decode(bb, offset)
      2 -> FinishConfiguration.decode(bb, offset)
      3 -> ConfigurationAcknowledged.decode(bb, offset)
      4 -> ConnectionError.decode(bb, offset)
      else -> null
    }

    public fun typeIndex(`value`: ConnectionMessage): UByte = when (value) {
      is BoneRegistry -> 1.toUByte()
      is FinishConfiguration -> 2.toUByte()
      is ConfigurationAcknowledged -> 3.toUByte()
      is ConnectionError -> 4.toUByte()
    }

    public fun encode(`value`: ConnectionMessage, builder: FlatBufferWriter): Int = when (value) {
      is BoneRegistry -> value.encode(builder)
      is FinishConfiguration -> value.encode(builder)
      is ConfigurationAcknowledged -> value.encode(builder)
      is ConnectionError -> value.encode(builder)
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
