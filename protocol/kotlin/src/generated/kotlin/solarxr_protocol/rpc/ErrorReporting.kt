package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Int
import kotlin.String
import kotlin.UByte

/**
 * Whether the user agreed to send error reports and diagnostics.
 * The server owns this value and every layer (server, gui, electron) follows it.
 */
public enum class ErrorReportingConsent(
  public val `value`: UByte,
) {
  UNDECIDED(0.toUByte()),
  ALLOWED(1.toUByte()),
  DENIED(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): ErrorReportingConsent? = entries.firstOrNull { it.value == value }
  }
}

public class ErrorReportingSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ErrorReportingSettingsRequest = ErrorReportingSettingsRequest()
  }
}

public data class ErrorReportingSettingsResponse(
  public val consent: ErrorReportingConsent = ErrorReportingConsent.UNDECIDED,
  public val userId: String? = null,
  public val sessionId: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_userId = userId?.let { builder.createString(it) }
    val __off_sessionId = sessionId?.let { builder.createString(it) }

    builder.startTable(3)
    builder.addByte(0, consent.value.toByte(), 0)
    __off_userId?.let { builder.addOffset(1, it, 0) }
    __off_sessionId?.let { builder.addOffset(2, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ErrorReportingSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_consent = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_userId = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_sessionId = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return ErrorReportingSettingsResponse(
              consent = if (__offset_consent != 0) ErrorReportingConsent.fromValue(bb.get(tableOffset + __offset_consent).toUByte()) ?: ErrorReportingConsent.UNDECIDED else ErrorReportingConsent.UNDECIDED,
              userId = if (__offset_userId != 0) readFlatBufferString(bb, tableOffset + __offset_userId) else null,
              sessionId = if (__offset_sessionId != 0) readFlatBufferString(bb, tableOffset + __offset_sessionId) else null
          )
    }
  }
}

public data class ChangeErrorReportingSettingsRequest(
  public val consent: ErrorReportingConsent = ErrorReportingConsent.UNDECIDED,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addByte(0, consent.value.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeErrorReportingSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_consent = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ChangeErrorReportingSettingsRequest(
              consent = if (__offset_consent != 0) ErrorReportingConsent.fromValue(bb.get(tableOffset + __offset_consent).toUByte()) ?: ErrorReportingConsent.UNDECIDED else ErrorReportingConsent.UNDECIDED
          )
    }
  }
}
