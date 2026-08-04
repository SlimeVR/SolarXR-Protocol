package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Int
import kotlin.UByte
import kotlin.collections.List
import solarxr_protocol.datatypes.BodyPart

/**
 * An output that bone data can be routed to.
 */
public enum class RoutingOutput(
  public val `value`: UByte,
) {
  /**
   * Whatever is connected over the driver IPC: SteamVR or Monado, treated the same.
   */
  DRIVER(0.toUByte()),
  VRC_OSC(1.toUByte()),
  VMC(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): RoutingOutput? = entries.firstOrNull { it.value == value }
  }
}

/**
 * Where a single bone's data goes. Identical in both directions, so the change
 * request and the response carry the exact same shape.
 */
public data class BoneRoute(
  public val bone: BodyPart? = null,
  public val outputs: List<RoutingOutput>? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_outputs = outputs?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }

    builder.startTable(2)
    if (bone != null) { builder.forceDefaults(true); builder.addByte(0, bone.value.toByte(), 0); builder.forceDefaults(false) }
    __off_outputs?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): BoneRoute {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bone = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_outputs = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return BoneRoute(
              bone = if (__offset_bone != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_bone).toUByte()) else null,
              outputs = if (__offset_outputs != 0) { val vecOff = tableOffset + __offset_outputs + bb.getInt(tableOffset + __offset_outputs); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> RoutingOutput.fromValue(bb.get(vecOff + 4 + i * 1).toUByte()) } } else null
          )
    }
  }
}

public enum class RoutingOutputState(
  public val `value`: UByte,
) {
  /**
   * Does not exist on this platform, for example the driver on Android.
   */
  UNSUPPORTED(0.toUByte()),
  /**
   * Switched off in its own config, or no driver is connected.
   */
  INACTIVE(1.toUByte()),
  /**
   * Known to be reaching something: a driver is connected, or a target was found.
   */
  ACTIVE(2.toUByte()),
  /**
   * Switched on, but nothing confirms anything is listening. Routed to all the
   * same, so the bones are already in place once something does listen.
   */
  ENABLED(3.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): RoutingOutputState? = entries.firstOrNull { it.value == value }
  }
}

/**
 * Per output, response only.
 */
public data class RoutingOutputStatus(
  public val output: RoutingOutput? = null,
  public val accepts: List<BodyPart>? = null,
  public val requires: List<BodyPart>? = null,
  public val conflicts: List<RoutingOutput>? = null,
  public val state: RoutingOutputState? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_accepts = accepts?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }
    val __off_requires = requires?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }
    val __off_conflicts = conflicts?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }

    builder.startTable(5)
    if (output != null) { builder.forceDefaults(true); builder.addByte(0, output.value.toByte(), 0); builder.forceDefaults(false) }
    __off_accepts?.let { builder.addOffset(1, it, 0) }
    __off_requires?.let { builder.addOffset(2, it, 0) }
    __off_conflicts?.let { builder.addOffset(3, it, 0) }
    if (state != null) { builder.forceDefaults(true); builder.addByte(4, state.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): RoutingOutputStatus {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_output = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_accepts = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_requires = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_conflicts = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_state = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return RoutingOutputStatus(
              output = if (__offset_output != 0) RoutingOutput.fromValue(bb.get(tableOffset + __offset_output).toUByte()) else null,
              accepts = if (__offset_accepts != 0) { val vecOff = tableOffset + __offset_accepts + bb.getInt(tableOffset + __offset_accepts); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> BodyPart.fromValue(bb.get(vecOff + 4 + i * 1).toUByte()) } } else null,
              requires = if (__offset_requires != 0) { val vecOff = tableOffset + __offset_requires + bb.getInt(tableOffset + __offset_requires); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> BodyPart.fromValue(bb.get(vecOff + 4 + i * 1).toUByte()) } } else null,
              conflicts = if (__offset_conflicts != 0) { val vecOff = tableOffset + __offset_conflicts + bb.getInt(tableOffset + __offset_conflicts); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> RoutingOutput.fromValue(bb.get(vecOff + 4 + i * 1).toUByte()) } } else null,
              state = if (__offset_state != 0) RoutingOutputState.fromValue(bb.get(tableOffset + __offset_state).toUByte()) else null
          )
    }
  }
}

public class BoneRoutingSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): BoneRoutingSettingsRequest = BoneRoutingSettingsRequest()
  }
}

public data class BoneRoutingSettingsResponse(
  public val automatic: Boolean? = null,
  public val routes: List<BoneRoute>? = null,
  public val outputs: List<RoutingOutputStatus>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_routes = routes?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }
    val __off_outputs = outputs?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(3)
    if (automatic != null) { builder.forceDefaults(true); builder.addBoolean(0, automatic, false); builder.forceDefaults(false) }
    __off_routes?.let { builder.addOffset(1, it, 0) }
    __off_outputs?.let { builder.addOffset(2, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): BoneRoutingSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_automatic = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_routes = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_outputs = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return BoneRoutingSettingsResponse(
              automatic = if (__offset_automatic != 0) bb.get(tableOffset + __offset_automatic) != 0.toByte() else null,
              routes = if (__offset_routes != 0) { val vecOff = tableOffset + __offset_routes + bb.getInt(tableOffset + __offset_routes); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) BoneRoute.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null,
              outputs = if (__offset_outputs != 0) { val vecOff = tableOffset + __offset_outputs + bb.getInt(tableOffset + __offset_outputs); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) RoutingOutputStatus.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

public data class ChangeBoneRoutingSettingsRequest(
  public val automatic: Boolean? = null,
  public val routes: List<BoneRoute>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_routes = routes?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(2)
    if (automatic != null) { builder.forceDefaults(true); builder.addBoolean(0, automatic, false); builder.forceDefaults(false) }
    __off_routes?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeBoneRoutingSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_automatic = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_routes = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return ChangeBoneRoutingSettingsRequest(
              automatic = if (__offset_automatic != 0) bb.get(tableOffset + __offset_automatic) != 0.toByte() else null,
              routes = if (__offset_routes != 0) { val vecOff = tableOffset + __offset_routes + bb.getInt(tableOffset + __offset_routes); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) BoneRoute.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}
