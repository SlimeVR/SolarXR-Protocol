package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Int

public class DriverSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): DriverSettingsRequest = DriverSettingsRequest()
  }
}

public data class DriverSettingsResponse(
  public val sendDerivedVelocity: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (sendDerivedVelocity != null) { builder.forceDefaults(true); builder.addBoolean(0, sendDerivedVelocity, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): DriverSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_sendDerivedVelocity = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return DriverSettingsResponse(
              sendDerivedVelocity = if (__offset_sendDerivedVelocity != 0) bb.get(tableOffset + __offset_sendDerivedVelocity) != 0.toByte() else null
          )
    }
  }
}

public data class ChangeDriverSettingsRequest(
  public val sendDerivedVelocity: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (sendDerivedVelocity != null) { builder.forceDefaults(true); builder.addBoolean(0, sendDerivedVelocity, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeDriverSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_sendDerivedVelocity = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ChangeDriverSettingsRequest(
              sendDerivedVelocity = if (__offset_sendDerivedVelocity != 0) bb.get(tableOffset + __offset_sendDerivedVelocity) != 0.toByte() else null
          )
    }
  }
}
