package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.collections.List

public enum class ProfileKind(
  public val `value`: UByte,
) {
  /**
   * Not set, a request with this kind is rejected.
   */
  UNKNOWN(0.toUByte()),
  /**
   * The machine: trackers, outputs, resets, keybinds and every other setting.
   */
  SETTINGS(1.toUByte()),
  /**
   * The person: height and bone proportions.
   */
  USER(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): ProfileKind? = entries.firstOrNull { it.value == value }
  }
}

public enum class ProfileOperationStatus(
  public val `value`: UByte,
) {
  OK(0.toUByte()),
  /**
   * The request has no profile kind.
   */
  INVALID_KIND(1.toUByte()),
  /**
   * The name has characters that are not allowed, or is empty or too long.
   */
  INVALID_NAME(2.toUByte()),
  /**
   * A profile with this name already exists, names compare case-insensitively.
   */
  ALREADY_EXISTS(3.toUByte()),
  /**
   * No profile with this name exists.
   */
  NOT_FOUND(4.toUByte()),
  /**
   * The profile is in use (active), so the operation cannot be performed
   */
  IS_ACTIVE(5.toUByte()),
  /**
   * The server could not read or write the profile files.
   */
  FAILED(6.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): ProfileOperationStatus? = entries.firstOrNull { it.value == value }
  }
}

public data class ProfileList(
  public val active: String? = null,
  public val names: List<String>? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_active = active?.let { builder.createString(it) }
    val __off_names = names?.let { builder.createVectorOfTables(it.map { s -> builder.createString(s) }.toIntArray()) }

    builder.startTable(2)
    __off_active?.let { builder.addOffset(0, it, 0) }
    __off_names?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ProfileList {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_active = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_names = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return ProfileList(
              active = if (__offset_active != 0) readFlatBufferString(bb, tableOffset + __offset_active) else null,
              names = if (__offset_names != 0) { val vecOff = tableOffset + __offset_names + bb.getInt(tableOffset + __offset_names); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> readFlatBufferString(bb, vecOff + 4 + i * 4) } } else null
          )
    }
  }
}

public class ProfilesRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ProfilesRequest = ProfilesRequest()
  }
}

public data class ProfilesResponse(
  public val settings: ProfileList? = null,
  public val user: ProfileList? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_settings = settings?.encode(builder)
    val __off_user = user?.encode(builder)

    builder.startTable(2)
    __off_settings?.let { builder.addOffset(0, it, 0) }
    __off_user?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ProfilesResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_settings = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_user = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return ProfilesResponse(
              settings = if (__offset_settings != 0) ProfileList.decode(bb, tableOffset + __offset_settings + bb.getInt(tableOffset + __offset_settings)) else null,
              user = if (__offset_user != 0) ProfileList.decode(bb, tableOffset + __offset_user + bb.getInt(tableOffset + __offset_user)) else null
          )
    }
  }
}

public data class SwitchProfileRequest(
  public val kind: ProfileKind = ProfileKind.UNKNOWN,
  public val name: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_name = name?.let { builder.createString(it) }

    builder.startTable(2)
    builder.addByte(0, kind.value.toByte(), 0)
    __off_name?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SwitchProfileRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_kind = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_name = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return SwitchProfileRequest(
              kind = if (__offset_kind != 0) ProfileKind.fromValue(bb.get(tableOffset + __offset_kind).toUByte()) ?: ProfileKind.UNKNOWN else ProfileKind.UNKNOWN,
              name = if (__offset_name != 0) readFlatBufferString(bb, tableOffset + __offset_name) else null
          )
    }
  }
}

public data class CreateProfileRequest(
  public val kind: ProfileKind = ProfileKind.UNKNOWN,
  public val name: String? = null,
  public val copyFrom: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_name = name?.let { builder.createString(it) }
    val __off_copyFrom = copyFrom?.let { builder.createString(it) }

    builder.startTable(3)
    builder.addByte(0, kind.value.toByte(), 0)
    __off_name?.let { builder.addOffset(1, it, 0) }
    __off_copyFrom?.let { builder.addOffset(2, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): CreateProfileRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_kind = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_name = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_copyFrom = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return CreateProfileRequest(
              kind = if (__offset_kind != 0) ProfileKind.fromValue(bb.get(tableOffset + __offset_kind).toUByte()) ?: ProfileKind.UNKNOWN else ProfileKind.UNKNOWN,
              name = if (__offset_name != 0) readFlatBufferString(bb, tableOffset + __offset_name) else null,
              copyFrom = if (__offset_copyFrom != 0) readFlatBufferString(bb, tableOffset + __offset_copyFrom) else null
          )
    }
  }
}

public data class RenameProfileRequest(
  public val kind: ProfileKind = ProfileKind.UNKNOWN,
  public val name: String? = null,
  public val newName: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_name = name?.let { builder.createString(it) }
    val __off_newName = newName?.let { builder.createString(it) }

    builder.startTable(3)
    builder.addByte(0, kind.value.toByte(), 0)
    __off_name?.let { builder.addOffset(1, it, 0) }
    __off_newName?.let { builder.addOffset(2, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): RenameProfileRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_kind = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_name = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_newName = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return RenameProfileRequest(
              kind = if (__offset_kind != 0) ProfileKind.fromValue(bb.get(tableOffset + __offset_kind).toUByte()) ?: ProfileKind.UNKNOWN else ProfileKind.UNKNOWN,
              name = if (__offset_name != 0) readFlatBufferString(bb, tableOffset + __offset_name) else null,
              newName = if (__offset_newName != 0) readFlatBufferString(bb, tableOffset + __offset_newName) else null
          )
    }
  }
}

public data class DeleteProfileRequest(
  public val kind: ProfileKind = ProfileKind.UNKNOWN,
  public val name: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_name = name?.let { builder.createString(it) }

    builder.startTable(2)
    builder.addByte(0, kind.value.toByte(), 0)
    __off_name?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): DeleteProfileRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_kind = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_name = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return DeleteProfileRequest(
              kind = if (__offset_kind != 0) ProfileKind.fromValue(bb.get(tableOffset + __offset_kind).toUByte()) ?: ProfileKind.UNKNOWN else ProfileKind.UNKNOWN,
              name = if (__offset_name != 0) readFlatBufferString(bb, tableOffset + __offset_name) else null
          )
    }
  }
}

public data class ProfileOperationResponse(
  public val status: ProfileOperationStatus = ProfileOperationStatus.OK,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addByte(0, status.value.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ProfileOperationResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_status = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ProfileOperationResponse(
              status = if (__offset_status != 0) ProfileOperationStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) ?: ProfileOperationStatus.OK else ProfileOperationStatus.OK
          )
    }
  }
}
