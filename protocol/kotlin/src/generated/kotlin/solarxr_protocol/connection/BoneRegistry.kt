package solarxr_protocol.connection

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Int
import kotlin.String
import kotlin.UShort
import kotlin.collections.List

/**
 * Request the connection-wide bone registry. Send during configuration.
 * Required before this connection may send any message carrying a bone id.
 */
public class BoneRegistryRequest : ConnectionMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): BoneRegistryRequest = BoneRegistryRequest()
  }
}

public data class BoneDefinition(
  public val id: UShort = 0.toUShort(),
  public val key: String,
  public val displayName: String? = null,
  public val parent: UShort = 0.toUShort(),
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_key = key?.let { builder.createString(it) }
    val __off_displayName = displayName?.let { builder.createString(it) }

    builder.startTable(4)
    builder.addShort(0, id.toShort(), 0)
    __off_key?.let { builder.addOffset(1, it, 0) }
    __off_displayName?.let { builder.addOffset(2, it, 0) }
    builder.addShort(3, parent.toShort(), 0)
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

      return BoneDefinition(
              id = if (__offset_id != 0) bb.getShort(tableOffset + __offset_id).toUShort() else 0.toUShort(),
              key = if (__offset_key != 0) readFlatBufferString(bb, tableOffset + __offset_key) else error("Table field 'key' is required but missing"),
              displayName = if (__offset_displayName != 0) readFlatBufferString(bb, tableOffset + __offset_displayName) else null,
              parent = if (__offset_parent != 0) bb.getShort(tableOffset + __offset_parent).toUShort() else 0.toUShort()
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
