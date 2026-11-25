package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Int

/**
 * Requests the current state of `OverlayDisplayModeResponse`.
 */
public class OverlayDisplayModeRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OverlayDisplayModeRequest = OverlayDisplayModeRequest()
  }
}

/**
 * Changes the state of the overlay's display mode.
 */
public data class OverlayDisplayModeChangeRequest(
  public val isVisible: Boolean? = null,
  public val isMirrored: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (isVisible != null) { builder.forceDefaults(true); builder.addBoolean(0, isVisible, false); builder.forceDefaults(false) }
    if (isMirrored != null) { builder.forceDefaults(true); builder.addBoolean(1, isMirrored, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OverlayDisplayModeChangeRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_isVisible = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_isMirrored = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return OverlayDisplayModeChangeRequest(
              isVisible = if (__offset_isVisible != 0) bb.get(tableOffset + __offset_isVisible) != 0.toByte() else null,
              isMirrored = if (__offset_isMirrored != 0) bb.get(tableOffset + __offset_isMirrored) != 0.toByte() else null
          )
    }
  }
}

/**
 * The current state of the overlay's display mode.
 */
public data class OverlayDisplayModeResponse(
  public val isVisible: Boolean = false,
  public val isMirrored: Boolean = false,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    builder.addBoolean(0, isVisible, false)
    builder.addBoolean(1, isMirrored, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OverlayDisplayModeResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_isVisible = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_isMirrored = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return OverlayDisplayModeResponse(
              isVisible = if (__offset_isVisible != 0) bb.get(tableOffset + __offset_isVisible) != 0.toByte() else false,
              isMirrored = if (__offset_isMirrored != 0) bb.get(tableOffset + __offset_isMirrored) != 0.toByte() else false
          )
    }
  }
}
