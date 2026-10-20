package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Int
import kotlin.collections.List
import solarxr_protocol.datatypes.BodyPart

/**
 * One set of alternatives. Satisfied as soon as any member of it is assigned.
 */
public data class BodyPartRequirement(
  public val anyOf: List<BodyPart>? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_anyOf = anyOf?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }

    builder.startTable(1)
    __off_anyOf?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): BodyPartRequirement {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_anyOf = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return BodyPartRequirement(
              anyOf = if (__offset_anyOf != 0) { val vecOff = tableOffset + __offset_anyOf + bb.getInt(tableOffset + __offset_anyOf); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> BodyPart.fromValue(bb.get(vecOff + 4 + i * 1).toUByte()) } } else null
          )
    }
  }
}

/**
 * What a body part needs assigned around it for a tracker on it to track well.
 * Derived from the skeleton hierarchy and the processors that impute missing bones.
 */
public data class BodyPartPrerequisites(
  public val bodyPart: BodyPart = BodyPart.NONE,
  public val requires: List<BodyPartRequirement>? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_requires = requires?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(2)
    builder.addByte(0, bodyPart.value.toByte(), 0)
    __off_requires?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): BodyPartPrerequisites {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bodyPart = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_requires = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return BodyPartPrerequisites(
              bodyPart = if (__offset_bodyPart != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_bodyPart).toUByte()) ?: BodyPart.NONE else BodyPart.NONE,
              requires = if (__offset_requires != 0) { val vecOff = tableOffset + __offset_requires + bb.getInt(tableOffset + __offset_requires); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) BodyPartRequirement.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

public class BodyPartPrerequisitesRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): BodyPartPrerequisitesRequest = BodyPartPrerequisitesRequest()
  }
}

public data class BodyPartPrerequisitesResponse(
  public val parts: List<BodyPartPrerequisites>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_parts = parts?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(1)
    __off_parts?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): BodyPartPrerequisitesResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_parts = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return BodyPartPrerequisitesResponse(
              parts = if (__offset_parts != 0) { val vecOff = tableOffset + __offset_parts + bb.getInt(tableOffset + __offset_parts); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) BodyPartPrerequisites.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}
