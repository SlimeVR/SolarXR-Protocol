package solarxr_protocol.driver_protocol

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.collections.List
import solarxr_protocol.datatypes.BodyPart
import solarxr_protocol.datatypes.Bone
import solarxr_protocol.datatypes.BoneMask
import solarxr_protocol.datatypes.TrackerStatus
import solarxr_protocol.datatypes.math.Quat
import solarxr_protocol.datatypes.math.Vec3f

public enum class HandshakeStatus(
  public val `value`: UByte,
) {
  ACCEPTED(0.toUByte()),
  /**
   * The driver name is blank.
   */
  REJECTED_UNNAMED(1.toUByte()),
  /**
   * Another driver with the same name is already connected.
   */
  REJECTED_DUPLICATE(2.toUByte()),
  /**
   * Driver is disabled by the user.
   */
  REJECTED_DISABLED(3.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): HandshakeStatus? = entries.firstOrNull { it.value == value }
  }
}

/**
 * Signals that you may send a HandshakeRequest to initiate driver communication.
 */
public class HandshakeAvailable : DriverMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): HandshakeAvailable = HandshakeAvailable()
  }
}

/**
 * Request to initiate driver communication with the server.
 */
public data class HandshakeRequest(
  public val driverName: String,
  public val boneMask: BoneMask? = null,
) : DriverMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_driverName = driverName?.let { builder.createString(it) }
    val __off_boneMask = boneMask?.encode(builder)

    builder.startTable(2)
    __off_driverName?.let { builder.addOffset(0, it, 0) }
    __off_boneMask?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): HandshakeRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_driverName = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_boneMask = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return HandshakeRequest(
              driverName = if (__offset_driverName != 0) readFlatBufferString(bb, tableOffset + __offset_driverName) else error("Table field 'driver_name' is required but missing"),
              boneMask = if (__offset_boneMask != 0) BoneMask.decode(bb, tableOffset + __offset_boneMask + bb.getInt(tableOffset + __offset_boneMask)) else null
          )
    }
  }
}

/**
 * Response to a HandshakeRequest. You may receive this message after the initial handshake if the server wishes to
 * stop communication with your driver for whatever reason, e.g. the user has disabled the driver in settings.
 */
public data class HandshakeResponse(
  public val status: HandshakeStatus = HandshakeStatus.ACCEPTED,
) : DriverMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addByte(0, status.value.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): HandshakeResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_status = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return HandshakeResponse(
              status = if (__offset_status != 0) HandshakeStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) ?: HandshakeStatus.ACCEPTED else HandshakeStatus.ACCEPTED
          )
    }
  }
}

public enum class AddTrackerStatus(
  public val `value`: UByte,
) {
  /**
   * The tracker has been created successfully, tracker_id is valid.
   */
  CREATED(0.toUByte()),
  /**
   * A tracker matching the hardware identifier already exists, tracker_id is valid.
   */
  ALREADY_EXISTS(1.toUByte()),
  /**
   * Not allowed to create the tracker, tracker_id should not be read.
   */
  ERROR(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): AddTrackerStatus? = entries.firstOrNull { it.value == value }
  }
}

/**
 * Request to add a tracker. You must have successfully completed a handshake for this to succeed.
 * The server will reply with an AddTrackerResponse.
 */
public data class AddTrackerRequest(
  public val hardwareIdentifier: String,
  public val displayName: String? = null,
  public val manufacturer: String? = null,
  public val bodyPart: BodyPart = BodyPart.NONE,
) : DriverMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_hardwareIdentifier = hardwareIdentifier?.let { builder.createString(it) }
    val __off_displayName = displayName?.let { builder.createString(it) }
    val __off_manufacturer = manufacturer?.let { builder.createString(it) }

    builder.startTable(4)
    __off_hardwareIdentifier?.let { builder.addOffset(0, it, 0) }
    __off_displayName?.let { builder.addOffset(1, it, 0) }
    __off_manufacturer?.let { builder.addOffset(2, it, 0) }
    builder.addByte(3, bodyPart.value.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): AddTrackerRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_hardwareIdentifier = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_displayName = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_manufacturer = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_bodyPart = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return AddTrackerRequest(
              hardwareIdentifier = if (__offset_hardwareIdentifier != 0) readFlatBufferString(bb, tableOffset + __offset_hardwareIdentifier) else error("Table field 'hardware_identifier' is required but missing"),
              displayName = if (__offset_displayName != 0) readFlatBufferString(bb, tableOffset + __offset_displayName) else null,
              manufacturer = if (__offset_manufacturer != 0) readFlatBufferString(bb, tableOffset + __offset_manufacturer) else null,
              bodyPart = if (__offset_bodyPart != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_bodyPart).toUByte()) ?: BodyPart.NONE else BodyPart.NONE
          )
    }
  }
}

public data class AddTrackerResponse(
  public val status: AddTrackerStatus = AddTrackerStatus.CREATED,
  public val trackerId: UShort = 0.toUShort(),
) : DriverMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    builder.addByte(0, status.value.toByte(), 0)
    builder.addShort(1, trackerId.toShort(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): AddTrackerResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_status = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_trackerId = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return AddTrackerResponse(
              status = if (__offset_status != 0) AddTrackerStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) ?: AddTrackerStatus.CREATED else AddTrackerStatus.CREATED,
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else 0.toUShort()
          )
    }
  }
}

/**
 * Update the status of a created tracker. Will be ignored if you have not successfully completed a handshake.
 */
public data class UpdateTrackerStatus(
  public val trackerId: UShort = 0.toUShort(),
  public val status: TrackerStatus = TrackerStatus.NONE,
) : DriverMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    builder.addShort(0, trackerId.toShort(), 0)
    builder.addByte(1, status.value.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): UpdateTrackerStatus {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_status = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return UpdateTrackerStatus(
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else 0.toUShort(),
              status = if (__offset_status != 0) TrackerStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) ?: TrackerStatus.NONE else TrackerStatus.NONE
          )
    }
  }
}

/**
 * Update the battery information of a created tracker. If this is never sent, it is assumed the tracker does not
 * report battery information.
 * Will be ignored if you have not successfully completed a handshake.
 */
public data class UpdateTrackerBattery(
  public val trackerId: UShort = 0.toUShort(),
  public val batteryLevel: UByte = 0.toUByte(),
  public val charging: Boolean = false,
) : DriverMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(3)
    builder.addShort(0, trackerId.toShort(), 0)
    builder.addByte(1, batteryLevel.toByte(), 0)
    builder.addBoolean(2, charging, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): UpdateTrackerBattery {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_batteryLevel = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_charging = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return UpdateTrackerBattery(
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else 0.toUShort(),
              batteryLevel = if (__offset_batteryLevel != 0) bb.get(tableOffset + __offset_batteryLevel).toUByte() else 0.toUByte(),
              charging = if (__offset_charging != 0) bb.get(tableOffset + __offset_charging) != 0.toByte() else false
          )
    }
  }
}

/**
 * Update the rotation, position, angular velocity, and/or linear velocity of a created tracker.
 * Will be ignored if you have not successfully completed a handshake.
 */
public data class UpdateTrackerPosition(
  public val trackerId: UShort = 0.toUShort(),
  public val rotation: Quat? = null,
  public val position: Vec3f? = null,
  public val angularVelocity: Vec3f? = null,
  public val linearVelocity: Vec3f? = null,
) : DriverMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(5)
    builder.addShort(0, trackerId.toShort(), 0)
    rotation?.let { builder.addStruct(1, it.encode(builder), 0) }
    position?.let { builder.addStruct(2, it.encode(builder), 0) }
    angularVelocity?.let { builder.addStruct(3, it.encode(builder), 0) }
    linearVelocity?.let { builder.addStruct(4, it.encode(builder), 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): UpdateTrackerPosition {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_rotation = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_position = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_angularVelocity = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_linearVelocity = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return UpdateTrackerPosition(
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else 0.toUShort(),
              rotation = if (__offset_rotation != 0) Quat.decode(bb, tableOffset + __offset_rotation) else null,
              position = if (__offset_position != 0) Vec3f.decode(bb, tableOffset + __offset_position) else null,
              angularVelocity = if (__offset_angularVelocity != 0) Vec3f.decode(bb, tableOffset + __offset_angularVelocity) else null,
              linearVelocity = if (__offset_linearVelocity != 0) Vec3f.decode(bb, tableOffset + __offset_linearVelocity) else null
          )
    }
  }
}

/**
 * The full skeleton is always provided in case a driver must always expose the full body skeleton, possibly alongside
 * individual trackers. If you need to expose individual trackers controlled by the enabled trackers, you must perform
 * the filtering yourself.
 */
public data class SkeletonUpdate(
  public val bones: List<Bone>? = null,
) : DriverMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_bones = bones?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(1)
    __off_bones?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SkeletonUpdate {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bones = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return SkeletonUpdate(
              bones = if (__offset_bones != 0) { val vecOff = tableOffset + __offset_bones + bb.getInt(tableOffset + __offset_bones); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) Bone.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

/**
 * The battery information for the tracker associated with this bone has changed. This event will not be sent if the
 * associated tracker does not transmit battery information.
 */
public data class BoneBatteryUpdate(
  public val bone: BodyPart = BodyPart.NONE,
  public val batteryLevel: UByte = 0.toUByte(),
  public val charging: Boolean = false,
) : DriverMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(3)
    builder.addByte(0, bone.value.toByte(), 0)
    builder.addByte(1, batteryLevel.toByte(), 0)
    builder.addBoolean(2, charging, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): BoneBatteryUpdate {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bone = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_batteryLevel = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_charging = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return BoneBatteryUpdate(
              bone = if (__offset_bone != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_bone).toUByte()) ?: BodyPart.NONE else BodyPart.NONE,
              batteryLevel = if (__offset_batteryLevel != 0) bb.get(tableOffset + __offset_batteryLevel).toUByte() else 0.toUByte(),
              charging = if (__offset_charging != 0) bb.get(tableOffset + __offset_charging) != 0.toByte() else false
          )
    }
  }
}

public sealed interface DriverMessage {
  public companion object {
    public fun decode(
      type: UByte,
      bb: FlatBufferReader,
      offset: Int,
    ): DriverMessage? = when (type.toInt()) {
      1 -> HandshakeAvailable.decode(bb, offset)
      2 -> HandshakeRequest.decode(bb, offset)
      3 -> HandshakeResponse.decode(bb, offset)
      4 -> AddTrackerRequest.decode(bb, offset)
      5 -> AddTrackerResponse.decode(bb, offset)
      6 -> UpdateTrackerStatus.decode(bb, offset)
      7 -> UpdateTrackerBattery.decode(bb, offset)
      8 -> UpdateTrackerPosition.decode(bb, offset)
      9 -> SkeletonUpdate.decode(bb, offset)
      10 -> BoneBatteryUpdate.decode(bb, offset)
      else -> null
    }

    public fun typeIndex(`value`: DriverMessage): UByte = when (value) {
      is HandshakeAvailable -> 1.toUByte()
      is HandshakeRequest -> 2.toUByte()
      is HandshakeResponse -> 3.toUByte()
      is AddTrackerRequest -> 4.toUByte()
      is AddTrackerResponse -> 5.toUByte()
      is UpdateTrackerStatus -> 6.toUByte()
      is UpdateTrackerBattery -> 7.toUByte()
      is UpdateTrackerPosition -> 8.toUByte()
      is SkeletonUpdate -> 9.toUByte()
      is BoneBatteryUpdate -> 10.toUByte()
    }

    public fun encode(`value`: DriverMessage, builder: FlatBufferWriter): Int = when (value) {
      is HandshakeAvailable -> value.encode(builder)
      is HandshakeRequest -> value.encode(builder)
      is HandshakeResponse -> value.encode(builder)
      is AddTrackerRequest -> value.encode(builder)
      is AddTrackerResponse -> value.encode(builder)
      is UpdateTrackerStatus -> value.encode(builder)
      is UpdateTrackerBattery -> value.encode(builder)
      is UpdateTrackerPosition -> value.encode(builder)
      is SkeletonUpdate -> value.encode(builder)
      is BoneBatteryUpdate -> value.encode(builder)
    }
  }
}

public data class DriverMessageHeader(
  public val txId: UInt = 0u,
  public val replyTo: UInt = 0u,
  public val message: DriverMessage? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_message = message?.let { DriverMessage.encode(it, builder) }
    val __type_message = message?.let { DriverMessage.typeIndex(it) } ?: 0.toUByte()

    builder.startTable(4)
    builder.addInt(0, txId.toInt(), 0)
    builder.addInt(1, replyTo.toInt(), 0)
    builder.addByte(2, __type_message.toByte(), 0)
    __off_message?.let { builder.addOffset(3, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): DriverMessageHeader {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_txId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_replyTo = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __type_message = if (vtableSize > 8 && bb.getShort(vtableOffset + 8).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 8).toInt()).toUByte() else 0.toUByte()
      val __offset_message = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return DriverMessageHeader(
              txId = if (__offset_txId != 0) bb.getInt(tableOffset + __offset_txId).toUInt() else 0u,
              replyTo = if (__offset_replyTo != 0) bb.getInt(tableOffset + __offset_replyTo).toUInt() else 0u,
              message = if (__offset_message != 0) DriverMessage.decode(__type_message, bb, tableOffset + __offset_message + bb.getInt(tableOffset + __offset_message)) else null
          )
    }
  }
}
