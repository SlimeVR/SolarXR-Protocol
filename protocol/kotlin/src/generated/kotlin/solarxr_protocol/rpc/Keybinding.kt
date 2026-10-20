package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.collections.List

public enum class KeybindId(
  public val `value`: UByte,
) {
  NONE(0.toUByte()),
  FULL_RESET(1.toUByte()),
  YAW_RESET(2.toUByte()),
  MOUNTING_RESET(3.toUByte()),
  PAUSE_TRACKING(4.toUByte()),
  FEET_MOUNTING_RESET(5.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): KeybindId? = entries.firstOrNull { it.value == value }
  }
}

public data class Keybind(
  public val keybindId: KeybindId = KeybindId.NONE,
  public val keybindNameId: String? = null,
  public val keybindValue: String? = null,
  public val keybindDelay: Float = 0.0f,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_keybindNameId = keybindNameId?.let { builder.createString(it) }
    val __off_keybindValue = keybindValue?.let { builder.createString(it) }

    builder.startTable(4)
    builder.addByte(0, keybindId.value.toByte(), 0)
    __off_keybindNameId?.let { builder.addOffset(1, it, 0) }
    __off_keybindValue?.let { builder.addOffset(2, it, 0) }
    builder.addFloat(3, keybindDelay, 0.0)
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
              keybindId = if (__offset_keybindId != 0) KeybindId.fromValue(bb.get(tableOffset + __offset_keybindId).toUByte()) ?: KeybindId.NONE else KeybindId.NONE,
              keybindNameId = if (__offset_keybindNameId != 0) readFlatBufferString(bb, tableOffset + __offset_keybindNameId) else null,
              keybindValue = if (__offset_keybindValue != 0) readFlatBufferString(bb, tableOffset + __offset_keybindValue) else null,
              keybindDelay = if (__offset_keybindDelay != 0) bb.getFloat(tableOffset + __offset_keybindDelay) else 0.0f
          )
    }
  }
}

/**
 * Requests specified keybind eg. FULL_RESET -> KeybindResponse sends the keybind back to gui
 */
public data class KeybindRequest(
  public val keybindId: KeybindId = KeybindId.NONE,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addByte(0, keybindId.value.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): KeybindRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_keybindId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return KeybindRequest(
              keybindId = if (__offset_keybindId != 0) KeybindId.fromValue(bb.get(tableOffset + __offset_keybindId).toUByte()) ?: KeybindId.NONE else KeybindId.NONE
          )
    }
  }
}

/**
 * How global keybinds are handled on the platform the server runs on
 */
public enum class KeybindSupport(
  public val `value`: UByte,
) {
  /**
   * Global keybinds are not available at all (eg. macOS)
   */
  UNSUPPORTED(0.toUByte()),
  /**
   * The compositor owns the bindings, so the user rebinds them from the system settings (eg. KDE)
   */
  SYSTEM_MANAGED(1.toUByte()),
  /**
   * The server applies keybind changes itself, so the gui can offer a full editor (eg. Windows, GNOME)
   */
  APP_MANAGED(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): KeybindSupport? = entries.firstOrNull { it.value == value }
  }
}

/**
 * Returns keybinds for displaying in gui
 */
public data class KeybindResponse(
  public val keybind: List<Keybind>? = null,
  public val defaultKeybinds: List<Keybind>? = null,
  public val support: KeybindSupport = KeybindSupport.UNSUPPORTED,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_keybind = keybind?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }
    val __off_defaultKeybinds = defaultKeybinds?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(3)
    __off_keybind?.let { builder.addOffset(0, it, 0) }
    __off_defaultKeybinds?.let { builder.addOffset(1, it, 0) }
    builder.addByte(2, support.value.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): KeybindResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_keybind = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_defaultKeybinds = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_support = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return KeybindResponse(
              keybind = if (__offset_keybind != 0) { val vecOff = tableOffset + __offset_keybind + bb.getInt(tableOffset + __offset_keybind); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) Keybind.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null,
              defaultKeybinds = if (__offset_defaultKeybinds != 0) { val vecOff = tableOffset + __offset_defaultKeybinds + bb.getInt(tableOffset + __offset_defaultKeybinds); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) Keybind.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null,
              support = if (__offset_support != 0) KeybindSupport.fromValue(bb.get(tableOffset + __offset_support).toUByte()) ?: KeybindSupport.UNSUPPORTED else KeybindSupport.UNSUPPORTED
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

/**
 * Opens the system settings page where the compositor's global shortcuts are configured.
 * Only meaningful when KeybindSupport is SYSTEM_MANAGED.
 */
public class OpenKeybindSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OpenKeybindSettingsRequest = OpenKeybindSettingsRequest()
  }
}

public data class OpenKeybindSettingsResponse(
  public val success: Boolean = false,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addBoolean(0, success, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OpenKeybindSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_success = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return OpenKeybindSettingsResponse(
              success = if (__offset_success != 0) bb.get(tableOffset + __offset_success) != 0.toByte() else false
          )
    }
  }
}

/**
 * Tells the server the gui keybind recorder is open, so the server suppresses keybind
 * actions and instead reports which keybind was pressed (see KeybindActivatedResponse).
 * This lets the gui detect a combo already grabbed by the compositor, which never reaches
 * the web view as a keypress.
 */
public data class SetKeybindRecordingRequest(
  public val recording: Boolean = false,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addBoolean(0, recording, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SetKeybindRecordingRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_recording = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return SetKeybindRecordingRequest(
              recording = if (__offset_recording != 0) bb.get(tableOffset + __offset_recording) != 0.toByte() else false
          )
    }
  }
}

/**
 * Sent while recording when a keybind fires, so the gui can flag the combo as already used.
 */
public data class KeybindActivatedResponse(
  public val keybindId: KeybindId = KeybindId.NONE,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addByte(0, keybindId.value.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): KeybindActivatedResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_keybindId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return KeybindActivatedResponse(
              keybindId = if (__offset_keybindId != 0) KeybindId.fromValue(bb.get(tableOffset + __offset_keybindId).toUByte()) ?: KeybindId.NONE else KeybindId.NONE
          )
    }
  }
}
