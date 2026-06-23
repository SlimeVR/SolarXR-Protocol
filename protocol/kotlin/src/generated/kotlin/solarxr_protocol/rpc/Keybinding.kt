package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.collections.List

public enum class KeybindId(
  public val `value`: UByte,
) {
  FULL_RESET(0.toUByte()),
  YAW_RESET(1.toUByte()),
  MOUNTING_RESET(2.toUByte()),
  PAUSE_TRACKING(3.toUByte()),
  FEET_MOUNTING_RESET(4.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): KeybindId? = entries.firstOrNull { it.value == value }
  }
}

public data class Keybind(
  public val keybindId: KeybindId? = null,
  public val keybindNameId: String? = null,
  public val keybindValue: String? = null,
  public val keybindDelay: Float? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_keybindNameId = keybindNameId?.let { builder.createString(it) }
    val __off_keybindValue = keybindValue?.let { builder.createString(it) }

    builder.startTable(4)
    if (keybindId != null) { builder.forceDefaults(true); builder.addByte(0, keybindId.value.toByte(), 0); builder.forceDefaults(false) }
    __off_keybindNameId?.let { builder.addOffset(1, it, 0) }
    __off_keybindValue?.let { builder.addOffset(2, it, 0) }
    if (keybindDelay != null) { builder.forceDefaults(true); builder.addFloat(3, keybindDelay, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): Keybind {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_keybindId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_keybindNameId = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_keybindValue = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_keybindDelay = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return Keybind(
              keybindId = if (__offset_keybindId != 0) KeybindId.fromValue(bb.get(tableOffset + __offset_keybindId).toUByte()) else null,
              keybindNameId = if (__offset_keybindNameId != 0) readFlatBufferString(bb, tableOffset + __offset_keybindNameId) else null,
              keybindValue = if (__offset_keybindValue != 0) readFlatBufferString(bb, tableOffset + __offset_keybindValue) else null,
              keybindDelay = if (__offset_keybindDelay != 0) bb.getFloat(tableOffset + __offset_keybindDelay) else null
          )
    }
  }
}

/**
 * Requests specified keybind eg. FULL_RESET -> KeybindResponse sends the keybind back to gui
 */
public data class KeybindRequest(
  public val keybindId: KeybindId? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (keybindId != null) { builder.forceDefaults(true); builder.addByte(0, keybindId.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): KeybindRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_keybindId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return KeybindRequest(
              keybindId = if (__offset_keybindId != 0) KeybindId.fromValue(bb.get(tableOffset + __offset_keybindId).toUByte()) else null
          )
    }
  }
}

/**
 * Returns keybinds for displaying in gui
 */
public data class KeybindResponse(
  public val keybind: List<Keybind>? = null,
  public val defaultKeybinds: List<Keybind>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_keybind = keybind?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }
    val __off_defaultKeybinds = defaultKeybinds?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(2)
    __off_keybind?.let { builder.addOffset(0, it, 0) }
    __off_defaultKeybinds?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): KeybindResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_keybind = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_defaultKeybinds = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return KeybindResponse(
              keybind = if (__offset_keybind != 0) { val vecOff = tableOffset + __offset_keybind + bb.getInt(tableOffset + __offset_keybind); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) Keybind.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null,
              defaultKeybinds = if (__offset_defaultKeybinds != 0) { val vecOff = tableOffset + __offset_defaultKeybinds + bb.getInt(tableOffset + __offset_defaultKeybinds); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) Keybind.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

public data class ChangeKeybindRequest(
  public val keybind: Keybind? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_keybind = keybind?.encode(builder)

    builder.startTable(1)
    __off_keybind?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeKeybindRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_keybind = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ChangeKeybindRequest(
              keybind = if (__offset_keybind != 0) Keybind.decode(bb, tableOffset + __offset_keybind + bb.getInt(tableOffset + __offset_keybind)) else null
          )
    }
  }
}
