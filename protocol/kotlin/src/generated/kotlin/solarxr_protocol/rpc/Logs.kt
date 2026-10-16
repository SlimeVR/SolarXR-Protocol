package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.ULong
import kotlin.collections.List

public enum class LogSource(
  public val `value`: UByte,
) {
  SLIMEVR_SERVER(0.toUByte()),
  OPENVR_DRIVER(1.toUByte()),
  BINDINGS_PROVIDER(2.toUByte()),
  /**
   * Never sent by the server, the GUI adds its own logs
   */
  GUI(3.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): LogSource? = entries.firstOrNull { it.value == value }
  }
}

public enum class LogLevel(
  public val `value`: UByte,
) {
  TRACE(0.toUByte()),
  DEBUG(1.toUByte()),
  INFO(2.toUByte()),
  WARN(3.toUByte()),
  ERROR(4.toUByte()),
  FATAL(5.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): LogLevel? = entries.firstOrNull { it.value == value }
  }
}

public data class LogEvent(
  public val source: LogSource = LogSource.SLIMEVR_SERVER,
  public val timeMs: ULong = 0uL,
  public val level: LogLevel = LogLevel.TRACE,
  public val logger: String? = null,
  public val message: String? = null,
  public val stackTrace: String? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_logger = logger?.let { builder.createString(it) }
    val __off_message = message?.let { builder.createString(it) }
    val __off_stackTrace = stackTrace?.let { builder.createString(it) }

    builder.startTable(6)
    builder.addByte(0, source.value.toByte(), 0)
    builder.addLong(1, timeMs.toLong(), 0L)
    builder.addByte(2, level.value.toByte(), 0)
    __off_logger?.let { builder.addOffset(3, it, 0) }
    __off_message?.let { builder.addOffset(4, it, 0) }
    __off_stackTrace?.let { builder.addOffset(5, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): LogEvent {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_source = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_timeMs = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_level = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_logger = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_message = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_stackTrace = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0

      return LogEvent(
              source = if (__offset_source != 0) LogSource.fromValue(bb.get(tableOffset + __offset_source).toUByte()) ?: LogSource.SLIMEVR_SERVER else LogSource.SLIMEVR_SERVER,
              timeMs = if (__offset_timeMs != 0) bb.getLong(tableOffset + __offset_timeMs).toULong() else 0uL,
              level = if (__offset_level != 0) LogLevel.fromValue(bb.get(tableOffset + __offset_level).toUByte()) ?: LogLevel.TRACE else LogLevel.TRACE,
              logger = if (__offset_logger != 0) readFlatBufferString(bb, tableOffset + __offset_logger) else null,
              message = if (__offset_message != 0) readFlatBufferString(bb, tableOffset + __offset_message) else null,
              stackTrace = if (__offset_stackTrace != 0) readFlatBufferString(bb, tableOffset + __offset_stackTrace) else null
          )
    }
  }
}

public data class LogSourceInfo(
  public val source: LogSource = LogSource.SLIMEVR_SERVER,
  public val live: Boolean = false,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    builder.addByte(0, source.value.toByte(), 0)
    builder.addBoolean(1, live, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): LogSourceInfo {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_source = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_live = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return LogSourceInfo(
              source = if (__offset_source != 0) LogSource.fromValue(bb.get(tableOffset + __offset_source).toUByte()) ?: LogSource.SLIMEVR_SERVER else LogSource.SLIMEVR_SERVER,
              live = if (__offset_live != 0) bb.get(tableOffset + __offset_live) != 0.toByte() else false
          )
    }
  }
}

public data class LogStreamRequest(
  public val sources: List<LogSource>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_sources = sources?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }

    builder.startTable(1)
    __off_sources?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): LogStreamRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_sources = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return LogStreamRequest(
              sources = if (__offset_sources != 0) { val vecOff = tableOffset + __offset_sources + bb.getInt(tableOffset + __offset_sources); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> LogSource.fromValue(bb.get(vecOff + 4 + i * 1).toUByte()) } } else null
          )
    }
  }
}

public data class LogStreamResponse(
  public val events: List<LogEvent>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_events = events?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(1)
    __off_events?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): LogStreamResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_events = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return LogStreamResponse(
              events = if (__offset_events != 0) { val vecOff = tableOffset + __offset_events + bb.getInt(tableOffset + __offset_events); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) LogEvent.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

public data class LogFile(
  public val source: LogSource = LogSource.SLIMEVR_SERVER,
  public val name: String? = null,
  public val size: ULong = 0uL,
  public val modifiedMs: ULong = 0uL,
  public val current: Boolean = false,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_name = name?.let { builder.createString(it) }

    builder.startTable(5)
    builder.addByte(0, source.value.toByte(), 0)
    __off_name?.let { builder.addOffset(1, it, 0) }
    builder.addLong(2, size.toLong(), 0L)
    builder.addLong(3, modifiedMs.toLong(), 0L)
    builder.addBoolean(4, current, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): LogFile {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_source = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_name = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_size = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_modifiedMs = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_current = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return LogFile(
              source = if (__offset_source != 0) LogSource.fromValue(bb.get(tableOffset + __offset_source).toUByte()) ?: LogSource.SLIMEVR_SERVER else LogSource.SLIMEVR_SERVER,
              name = if (__offset_name != 0) readFlatBufferString(bb, tableOffset + __offset_name) else null,
              size = if (__offset_size != 0) bb.getLong(tableOffset + __offset_size).toULong() else 0uL,
              modifiedMs = if (__offset_modifiedMs != 0) bb.getLong(tableOffset + __offset_modifiedMs).toULong() else 0uL,
              current = if (__offset_current != 0) bb.get(tableOffset + __offset_current) != 0.toByte() else false
          )
    }
  }
}

public class LogsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): LogsRequest = LogsRequest()
  }
}

public data class LogsResponse(
  public val sources: List<LogSourceInfo>? = null,
  public val files: List<LogFile>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_sources = sources?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }
    val __off_files = files?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(2)
    __off_sources?.let { builder.addOffset(0, it, 0) }
    __off_files?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): LogsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_sources = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_files = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return LogsResponse(
              sources = if (__offset_sources != 0) { val vecOff = tableOffset + __offset_sources + bb.getInt(tableOffset + __offset_sources); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) LogSourceInfo.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null,
              files = if (__offset_files != 0) { val vecOff = tableOffset + __offset_files + bb.getInt(tableOffset + __offset_files); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) LogFile.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

public data class LogFileChunkRequest(
  public val source: LogSource = LogSource.SLIMEVR_SERVER,
  public val name: String? = null,
  public val offset: ULong = 0uL,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_name = name?.let { builder.createString(it) }

    builder.startTable(3)
    builder.addByte(0, source.value.toByte(), 0)
    __off_name?.let { builder.addOffset(1, it, 0) }
    builder.addLong(2, offset.toLong(), 0L)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): LogFileChunkRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_source = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_name = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_offset = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return LogFileChunkRequest(
              source = if (__offset_source != 0) LogSource.fromValue(bb.get(tableOffset + __offset_source).toUByte()) ?: LogSource.SLIMEVR_SERVER else LogSource.SLIMEVR_SERVER,
              name = if (__offset_name != 0) readFlatBufferString(bb, tableOffset + __offset_name) else null,
              offset = if (__offset_offset != 0) bb.getLong(tableOffset + __offset_offset).toULong() else 0uL
          )
    }
  }
}

public data class LogFileChunkResponse(
  public val source: LogSource = LogSource.SLIMEVR_SERVER,
  public val name: String? = null,
  public val offset: ULong = 0uL,
  public val `data`: List<UByte>? = null,
  public val eof: Boolean = false,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_name = name?.let { builder.createString(it) }
    val __off_data = data?.let { builder.createByteVector(it.map { b -> b.toByte() }.toByteArray()) }

    builder.startTable(5)
    builder.addByte(0, source.value.toByte(), 0)
    __off_name?.let { builder.addOffset(1, it, 0) }
    builder.addLong(2, offset.toLong(), 0L)
    __off_data?.let { builder.addOffset(3, it, 0) }
    builder.addBoolean(4, eof, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): LogFileChunkResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_source = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_name = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_offset = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_data = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_eof = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return LogFileChunkResponse(
              source = if (__offset_source != 0) LogSource.fromValue(bb.get(tableOffset + __offset_source).toUByte()) ?: LogSource.SLIMEVR_SERVER else LogSource.SLIMEVR_SERVER,
              name = if (__offset_name != 0) readFlatBufferString(bb, tableOffset + __offset_name) else null,
              offset = if (__offset_offset != 0) bb.getLong(tableOffset + __offset_offset).toULong() else 0uL,
              data = if (__offset_data != 0) { val vecOff = tableOffset + __offset_data + bb.getInt(tableOffset + __offset_data); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> bb.get(vecOff + 4 + i * 1).toUByte() } } else null,
              eof = if (__offset_eof != 0) bb.get(tableOffset + __offset_eof) != 0.toByte() else false
          )
    }
  }
}
