package solarxr_protocol.driver_protocol

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Boolean
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import solarxr_protocol.datatypes.BodyPart
import solarxr_protocol.datatypes.TrackerStatus
import solarxr_protocol.datatypes.math.Quat
import solarxr_protocol.datatypes.math.Vec3f

public enum class DriverHandshakeStatus(
  public val `value`: UByte,
) {
  ACCEPTED(0.toUByte()),
  REJECTED_DUPLICATE(1.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): DriverHandshakeStatus? = entries.firstOrNull { it.value == value }
  }
}

public data class InboundHandshakeRequest(
  public val driverName: String? = null,
) : DriverMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_driverName = driverName?.let { builder.createString(it) }

    builder.startTable(1)
    __off_driverName?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): InboundHandshakeRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_driverName = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return InboundHandshakeRequest(
              driverName = if (__offset_driverName != 0) readFlatBufferString(bb, tableOffset + __offset_driverName) else null
          )
    }
  }
}

public data class InboundHandshakeResponse(
  public val status: DriverHandshakeStatus? = null,
) : DriverMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (status != null) { builder.forceDefaults(true); builder.addByte(0, status.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): InboundHandshakeResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_status = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return InboundHandshakeResponse(
              status = if (__offset_status != 0) DriverHandshakeStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) else null
          )
    }
  }
}

public enum class AddTrackerStatus(
  public val `value`: UByte,
) {
  CREATED(0.toUByte()),
  ALREADY_EXISTS(1.toUByte()),
  ERROR(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): AddTrackerStatus? = entries.firstOrNull { it.value == value }
  }
}

public data class InboundAddTrackerRequest(
  public val hardwareId: String? = null,
  public val displayName: String? = null,
  public val manufacturer: String? = null,
  public val bodyPart: BodyPart? = null,
) : DriverMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_hardwareId = hardwareId?.let { builder.createString(it) }
    val __off_displayName = displayName?.let { builder.createString(it) }
    val __off_manufacturer = manufacturer?.let { builder.createString(it) }

    builder.startTable(4)
    __off_hardwareId?.let { builder.addOffset(0, it, 0) }
    __off_displayName?.let { builder.addOffset(1, it, 0) }
    __off_manufacturer?.let { builder.addOffset(2, it, 0) }
    if (bodyPart != null) { builder.forceDefaults(true); builder.addByte(3, bodyPart.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): InboundAddTrackerRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_hardwareId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_displayName = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_manufacturer = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_bodyPart = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return InboundAddTrackerRequest(
              hardwareId = if (__offset_hardwareId != 0) readFlatBufferString(bb, tableOffset + __offset_hardwareId) else null,
              displayName = if (__offset_displayName != 0) readFlatBufferString(bb, tableOffset + __offset_displayName) else null,
              manufacturer = if (__offset_manufacturer != 0) readFlatBufferString(bb, tableOffset + __offset_manufacturer) else null,
              bodyPart = if (__offset_bodyPart != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_bodyPart).toUByte()) else null
          )
    }
  }
}

public data class InboundAddTrackerResponse(
  public val status: AddTrackerStatus? = null,
  public val trackerId: UShort? = null,
) : DriverMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (status != null) { builder.forceDefaults(true); builder.addByte(0, status.value.toByte(), 0); builder.forceDefaults(false) }
    if (trackerId != null) { builder.forceDefaults(true); builder.addShort(1, trackerId.toShort(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): InboundAddTrackerResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_status = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_trackerId = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return InboundAddTrackerResponse(
              status = if (__offset_status != 0) AddTrackerStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) else null,
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else null
          )
    }
  }
}

public data class InboundTrackerStatusNotification(
  public val trackerId: UShort? = null,
  public val status: TrackerStatus? = null,
) : DriverMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (trackerId != null) { builder.forceDefaults(true); builder.addShort(0, trackerId.toShort(), 0); builder.forceDefaults(false) }
    if (status != null) { builder.forceDefaults(true); builder.addByte(1, status.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): InboundTrackerStatusNotification {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_status = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return InboundTrackerStatusNotification(
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else null,
              status = if (__offset_status != 0) TrackerStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) else null
          )
    }
  }
}

public data class InboundBatteryNotification(
  public val trackerId: UShort? = null,
  public val batteryLevel: Float? = null,
  public val charging: Boolean? = null,
) : DriverMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(3)
    if (trackerId != null) { builder.forceDefaults(true); builder.addShort(0, trackerId.toShort(), 0); builder.forceDefaults(false) }
    if (batteryLevel != null) { builder.forceDefaults(true); builder.addFloat(1, batteryLevel, 0.0); builder.forceDefaults(false) }
    if (charging != null) { builder.forceDefaults(true); builder.addBoolean(2, charging, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): InboundBatteryNotification {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_batteryLevel = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_charging = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return InboundBatteryNotification(
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else null,
              batteryLevel = if (__offset_batteryLevel != 0) bb.getFloat(tableOffset + __offset_batteryLevel) else null,
              charging = if (__offset_charging != 0) bb.get(tableOffset + __offset_charging) != 0.toByte() else null
          )
    }
  }
}

public data class InboundTrackerPositionNotification(
  public val trackerId: UShort? = null,
  public val rotation: Quat? = null,
  public val position: Vec3f? = null,
  public val velocity: Vec3f? = null,
) : DriverMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(4)
    if (trackerId != null) { builder.forceDefaults(true); builder.addShort(0, trackerId.toShort(), 0); builder.forceDefaults(false) }
    rotation?.let { builder.addStruct(1, it.encode(builder), 0) }
    position?.let { builder.addStruct(2, it.encode(builder), 0) }
    velocity?.let { builder.addStruct(3, it.encode(builder), 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): InboundTrackerPositionNotification {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_rotation = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_position = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_velocity = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return InboundTrackerPositionNotification(
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else null,
              rotation = if (__offset_rotation != 0) Quat.decode(bb, tableOffset + __offset_rotation) else null,
              position = if (__offset_position != 0) Vec3f.decode(bb, tableOffset + __offset_position) else null,
              velocity = if (__offset_velocity != 0) Vec3f.decode(bb, tableOffset + __offset_velocity) else null
          )
    }
  }
}

public data class OutboundAddTrackerRequest(
  public val trackerId: UShort? = null,
  public val bodyPart: BodyPart? = null,
) : DriverMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (trackerId != null) { builder.forceDefaults(true); builder.addShort(0, trackerId.toShort(), 0); builder.forceDefaults(false) }
    if (bodyPart != null) { builder.forceDefaults(true); builder.addByte(1, bodyPart.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OutboundAddTrackerRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_bodyPart = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return OutboundAddTrackerRequest(
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else null,
              bodyPart = if (__offset_bodyPart != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_bodyPart).toUByte()) else null
          )
    }
  }
}

public data class OutboundAddTrackerResponse(
  public val status: AddTrackerStatus? = null,
) : DriverMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (status != null) { builder.forceDefaults(true); builder.addByte(0, status.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OutboundAddTrackerResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_status = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return OutboundAddTrackerResponse(
              status = if (__offset_status != 0) AddTrackerStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) else null
          )
    }
  }
}

public data class OutboundTrackerStatusNotification(
  public val trackerId: UShort? = null,
  public val status: TrackerStatus? = null,
  public val batteryLevel: Float? = null,
  public val charging: Boolean? = null,
) : DriverMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(4)
    if (trackerId != null) { builder.forceDefaults(true); builder.addShort(0, trackerId.toShort(), 0); builder.forceDefaults(false) }
    if (status != null) { builder.forceDefaults(true); builder.addByte(1, status.value.toByte(), 0); builder.forceDefaults(false) }
    if (batteryLevel != null) { builder.forceDefaults(true); builder.addFloat(2, batteryLevel, 0.0); builder.forceDefaults(false) }
    if (charging != null) { builder.forceDefaults(true); builder.addBoolean(3, charging, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OutboundTrackerStatusNotification {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_status = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_batteryLevel = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_charging = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return OutboundTrackerStatusNotification(
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else null,
              status = if (__offset_status != 0) TrackerStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) else null,
              batteryLevel = if (__offset_batteryLevel != 0) bb.getFloat(tableOffset + __offset_batteryLevel) else null,
              charging = if (__offset_charging != 0) bb.get(tableOffset + __offset_charging) != 0.toByte() else null
          )
    }
  }
}

public data class OutboundTrackerPositionNotification(
  public val trackerId: UShort? = null,
  public val rotation: Quat? = null,
  public val position: Vec3f? = null,
  public val velocity: Vec3f? = null,
) : DriverMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(4)
    if (trackerId != null) { builder.forceDefaults(true); builder.addShort(0, trackerId.toShort(), 0); builder.forceDefaults(false) }
    rotation?.let { builder.addStruct(1, it.encode(builder), 0) }
    position?.let { builder.addStruct(2, it.encode(builder), 0) }
    velocity?.let { builder.addStruct(3, it.encode(builder), 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OutboundTrackerPositionNotification {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_rotation = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_position = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_velocity = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return OutboundTrackerPositionNotification(
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else null,
              rotation = if (__offset_rotation != 0) Quat.decode(bb, tableOffset + __offset_rotation) else null,
              position = if (__offset_position != 0) Vec3f.decode(bb, tableOffset + __offset_position) else null,
              velocity = if (__offset_velocity != 0) Vec3f.decode(bb, tableOffset + __offset_velocity) else null
          )
    }
  }
}

public sealed interface DriverMessage {
  public companion object {
    public fun decode(
      type: Byte,
      bb: FlatBufferReader,
      offset: Int,
    ): DriverMessage? = when (type.toInt()) {
      1 -> InboundHandshakeRequest.decode(bb, offset)
      2 -> InboundHandshakeResponse.decode(bb, offset)
      3 -> InboundAddTrackerRequest.decode(bb, offset)
      4 -> InboundAddTrackerResponse.decode(bb, offset)
      5 -> InboundTrackerStatusNotification.decode(bb, offset)
      6 -> InboundBatteryNotification.decode(bb, offset)
      7 -> InboundTrackerPositionNotification.decode(bb, offset)
      8 -> OutboundAddTrackerRequest.decode(bb, offset)
      9 -> OutboundAddTrackerResponse.decode(bb, offset)
      10 -> OutboundTrackerStatusNotification.decode(bb, offset)
      11 -> OutboundTrackerPositionNotification.decode(bb, offset)
      else -> null
    }

    public fun typeIndex(`value`: DriverMessage): Byte = when (value) {
      is InboundHandshakeRequest -> 1
      is InboundHandshakeResponse -> 2
      is InboundAddTrackerRequest -> 3
      is InboundAddTrackerResponse -> 4
      is InboundTrackerStatusNotification -> 5
      is InboundBatteryNotification -> 6
      is InboundTrackerPositionNotification -> 7
      is OutboundAddTrackerRequest -> 8
      is OutboundAddTrackerResponse -> 9
      is OutboundTrackerStatusNotification -> 10
      is OutboundTrackerPositionNotification -> 11
    }

    public fun encode(`value`: DriverMessage, builder: FlatBufferWriter): Int = when (value) {
      is InboundHandshakeRequest -> value.encode(builder)
      is InboundHandshakeResponse -> value.encode(builder)
      is InboundAddTrackerRequest -> value.encode(builder)
      is InboundAddTrackerResponse -> value.encode(builder)
      is InboundTrackerStatusNotification -> value.encode(builder)
      is InboundBatteryNotification -> value.encode(builder)
      is InboundTrackerPositionNotification -> value.encode(builder)
      is OutboundAddTrackerRequest -> value.encode(builder)
      is OutboundAddTrackerResponse -> value.encode(builder)
      is OutboundTrackerStatusNotification -> value.encode(builder)
      is OutboundTrackerPositionNotification -> value.encode(builder)
    }
  }
}

public data class DriverMessageHeader(
  public val txId: UInt? = null,
  public val replyTo: UInt? = null,
  public val message: DriverMessage? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_message = message?.let { DriverMessage.encode(it, builder) }
    val __type_message = message?.let { DriverMessage.typeIndex(it) } ?: 0.toByte()

    builder.startTable(4)
    if (txId != null) { builder.forceDefaults(true); builder.addInt(0, txId.toInt(), 0); builder.forceDefaults(false) }
    if (replyTo != null) { builder.forceDefaults(true); builder.addInt(1, replyTo.toInt(), 0); builder.forceDefaults(false) }
    builder.addByte(2, __type_message, 0)
    __off_message?.let { builder.addOffset(3, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): DriverMessageHeader {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_txId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_replyTo = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __type_message = if (vtableSize > 8 && bb.getShort(vtableOffset + 8).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 8).toInt()) else 0
      val __offset_message = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return DriverMessageHeader(
              txId = if (__offset_txId != 0) bb.getInt(tableOffset + __offset_txId).toUInt() else null,
              replyTo = if (__offset_replyTo != 0) bb.getInt(tableOffset + __offset_replyTo).toUInt() else null,
              message = if (__offset_message != 0) DriverMessage.decode(__type_message, bb, tableOffset + __offset_message + bb.getInt(tableOffset + __offset_message)) else null
          )
    }
  }
}
