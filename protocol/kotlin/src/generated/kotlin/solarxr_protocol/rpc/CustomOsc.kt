package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UShort
import kotlin.collections.List

public enum class CustomOSCAxisSource(
  public val `value`: UByte,
) {
  POSITION_X(0.toUByte()),
  POSITION_Y(1.toUByte()),
  POSITION_Z(2.toUByte()),
  ROTATION_PITCH(3.toUByte()),
  ROTATION_YAW(4.toUByte()),
  ROTATION_ROLL(5.toUByte()),
  QUAT_X(6.toUByte()),
  QUAT_Y(7.toUByte()),
  QUAT_Z(8.toUByte()),
  QUAT_W(9.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): CustomOSCAxisSource? = entries.firstOrNull { it.value == value }
  }
}

public data class CustomOSCParamMapping(
  public val axis: CustomOSCAxisSource = CustomOSCAxisSource.POSITION_X,
  public val address: String? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_address = address?.let { builder.createString(it) }

    builder.startTable(2)
    builder.addByte(0, axis.value.toByte(), 0)
    __off_address?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): CustomOSCParamMapping {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_axis = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_address = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return CustomOSCParamMapping(
              axis = if (__offset_axis != 0) CustomOSCAxisSource.fromValue(bb.get(tableOffset + __offset_axis).toUByte()) ?: CustomOSCAxisSource.POSITION_X else CustomOSCAxisSource.POSITION_X,
              address = if (__offset_address != 0) readFlatBufferString(bb, tableOffset + __offset_address) else null
          )
    }
  }
}

public data class CustomOSCTrackerMapping(
  public val bodyPart: UByte = 0.toUByte(),
  public val params: List<CustomOSCParamMapping>? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_params = params?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(2)
    builder.addByte(0, bodyPart.toByte(), 0)
    __off_params?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): CustomOSCTrackerMapping {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bodyPart = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_params = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return CustomOSCTrackerMapping(
              bodyPart = if (__offset_bodyPart != 0) bb.get(tableOffset + __offset_bodyPart).toUByte() else 0.toUByte(),
              params = if (__offset_params != 0) { val vecOff = tableOffset + __offset_params + bb.getInt(tableOffset + __offset_params); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) CustomOSCParamMapping.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

public data class CustomOSCProfile(
  public val id: String? = null,
  public val name: String? = null,
  public val enabled: Boolean = false,
  public val address: String? = null,
  public val port: UShort = 0.toUShort(),
  public val trackers: List<CustomOSCTrackerMapping>? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_id = id?.let { builder.createString(it) }
    val __off_name = name?.let { builder.createString(it) }
    val __off_address = address?.let { builder.createString(it) }
    val __off_trackers = trackers?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(6)
    __off_id?.let { builder.addOffset(0, it, 0) }
    __off_name?.let { builder.addOffset(1, it, 0) }
    builder.addBoolean(2, enabled, false)
    __off_address?.let { builder.addOffset(3, it, 0) }
    builder.addShort(4, port.toShort(), 0)
    __off_trackers?.let { builder.addOffset(5, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): CustomOSCProfile {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_id = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_name = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_enabled = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_address = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_port = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_trackers = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0

      return CustomOSCProfile(
              id = if (__offset_id != 0) readFlatBufferString(bb, tableOffset + __offset_id) else null,
              name = if (__offset_name != 0) readFlatBufferString(bb, tableOffset + __offset_name) else null,
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else false,
              address = if (__offset_address != 0) readFlatBufferString(bb, tableOffset + __offset_address) else null,
              port = if (__offset_port != 0) bb.getShort(tableOffset + __offset_port).toUShort() else 0.toUShort(),
              trackers = if (__offset_trackers != 0) { val vecOff = tableOffset + __offset_trackers + bb.getInt(tableOffset + __offset_trackers); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) CustomOSCTrackerMapping.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

public class CustomOSCSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): CustomOSCSettingsRequest = CustomOSCSettingsRequest()
  }
}

public data class CustomOSCSettingsResponse(
  public val enabled: Boolean = false,
  public val profiles: List<CustomOSCProfile>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_profiles = profiles?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(2)
    builder.addBoolean(0, enabled, false)
    __off_profiles?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): CustomOSCSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_profiles = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return CustomOSCSettingsResponse(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else false,
              profiles = if (__offset_profiles != 0) { val vecOff = tableOffset + __offset_profiles + bb.getInt(tableOffset + __offset_profiles); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) CustomOSCProfile.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

public data class ChangeCustomOSCSettingsRequest(
  public val enabled: Boolean = false,
  public val profiles: List<CustomOSCProfile>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_profiles = profiles?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(2)
    builder.addBoolean(0, enabled, false)
    __off_profiles?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeCustomOSCSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_profiles = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return ChangeCustomOSCSettingsRequest(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else false,
              profiles = if (__offset_profiles != 0) { val vecOff = tableOffset + __offset_profiles + bb.getInt(tableOffset + __offset_profiles); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) CustomOSCProfile.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}
