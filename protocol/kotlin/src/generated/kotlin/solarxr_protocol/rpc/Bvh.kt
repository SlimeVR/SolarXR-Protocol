package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Boolean
import kotlin.Int
import kotlin.String

public data class RecordBVHRequest(
  public val stop: Boolean? = null,
  public val path: String? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_path = path?.let { builder.createString(it) }

    builder.startTable(2)
    if (stop != null) { builder.forceDefaults(true); builder.addBoolean(0, stop, false); builder.forceDefaults(false) }
    __off_path?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): RecordBVHRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_stop = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_path = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return RecordBVHRequest(
              stop = if (__offset_stop != 0) bb.get(tableOffset + __offset_stop) != 0.toByte() else null,
              path = if (__offset_path != 0) readFlatBufferString(bb, tableOffset + __offset_path) else null
          )
    }
  }
}

public data class RecordBVHStatus(
  public val recording: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (recording != null) { builder.forceDefaults(true); builder.addBoolean(0, recording, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): RecordBVHStatus {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_recording = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return RecordBVHStatus(
              recording = if (__offset_recording != 0) bb.get(tableOffset + __offset_recording) != 0.toByte() else null
          )
    }
  }
}

public class RecordBVHStatusRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): RecordBVHStatusRequest = RecordBVHStatusRequest()
  }
}
