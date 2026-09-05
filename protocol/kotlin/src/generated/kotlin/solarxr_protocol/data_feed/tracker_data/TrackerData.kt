package solarxr_protocol.data_feed.tracker_data

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UShort
import solarxr_protocol.datatypes.BodyPart
import solarxr_protocol.datatypes.DeviceOrigin
import solarxr_protocol.datatypes.MagnetometerStatus
import solarxr_protocol.datatypes.MountingMethod
import solarxr_protocol.datatypes.TrackerStatus
import solarxr_protocol.datatypes.hardware_info.ImuType
import solarxr_protocol.datatypes.hardware_info.TrackerDataType
import solarxr_protocol.datatypes.math.Quat
import solarxr_protocol.datatypes.math.Vec3f

/**
 * Describes all possible information about a tracker. A tracker is anything that
 * provides kinematic data about a particular body part.
 *
 * There can be multiple trackers per hardware device.
 */
public data class TrackerData(
  public val deviceId: UShort = 0.toUShort(),
  public val trackerId: UShort = 0.toUShort(),
  public val info: TrackerInfo? = null,
  public val status: TrackerStatus = TrackerStatus.NONE,
  public val rotation: Quat? = null,
  public val position: Vec3f? = null,
  public val rawAngularVelocity: Vec3f? = null,
  public val rawAcceleration: Vec3f? = null,
  public val temp: Float? = null,
  public val linearAcceleration: Vec3f? = null,
  public val rotationReferenceAdjusted: Quat? = null,
  public val rotationIdentityAdjusted: Quat? = null,
  public val tps: UShort? = null,
  public val rawMagneticVector: Vec3f? = null,
  public val stayAligned: StayAlignedTracker? = null,
  public val origin: DeviceOrigin = DeviceOrigin.NONE,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_info = info?.encode(builder)
    val __off_stayAligned = stayAligned?.encode(builder)

    builder.startTable(16)
    builder.addShort(0, deviceId.toShort(), 0)
    builder.addShort(1, trackerId.toShort(), 0)
    __off_info?.let { builder.addOffset(2, it, 0) }
    builder.addByte(3, status.value.toByte(), 0)
    rotation?.let { builder.addStruct(4, it.encode(builder), 0) }
    position?.let { builder.addStruct(5, it.encode(builder), 0) }
    rawAngularVelocity?.let { builder.addStruct(6, it.encode(builder), 0) }
    rawAcceleration?.let { builder.addStruct(7, it.encode(builder), 0) }
    if (temp != null) { builder.forceDefaults(true); builder.addFloat(8, temp, 0.0); builder.forceDefaults(false) }
    linearAcceleration?.let { builder.addStruct(9, it.encode(builder), 0) }
    rotationReferenceAdjusted?.let { builder.addStruct(10, it.encode(builder), 0) }
    rotationIdentityAdjusted?.let { builder.addStruct(11, it.encode(builder), 0) }
    if (tps != null) { builder.forceDefaults(true); builder.addShort(12, tps.toShort(), 0); builder.forceDefaults(false) }
    rawMagneticVector?.let { builder.addStruct(13, it.encode(builder), 0) }
    __off_stayAligned?.let { builder.addOffset(14, it, 0) }
    builder.addByte(15, origin.value.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackerData {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_deviceId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_trackerId = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_info = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_status = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_rotation = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_position = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_rawAngularVelocity = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_rawAcceleration = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_temp = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_linearAcceleration = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_rotationReferenceAdjusted = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_rotationIdentityAdjusted = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0
      val __offset_tps = if (vtableSize > 28) bb.getShort(vtableOffset + 28).toInt() else 0
      val __offset_rawMagneticVector = if (vtableSize > 30) bb.getShort(vtableOffset + 30).toInt() else 0
      val __offset_stayAligned = if (vtableSize > 32) bb.getShort(vtableOffset + 32).toInt() else 0
      val __offset_origin = if (vtableSize > 34) bb.getShort(vtableOffset + 34).toInt() else 0

      return TrackerData(
              deviceId = if (__offset_deviceId != 0) bb.getShort(tableOffset + __offset_deviceId).toUShort() else 0.toUShort(),
              trackerId = if (__offset_trackerId != 0) bb.getShort(tableOffset + __offset_trackerId).toUShort() else 0.toUShort(),
              info = if (__offset_info != 0) TrackerInfo.decode(bb, tableOffset + __offset_info + bb.getInt(tableOffset + __offset_info)) else null,
              status = if (__offset_status != 0) TrackerStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) ?: TrackerStatus.NONE else TrackerStatus.NONE,
              rotation = if (__offset_rotation != 0) Quat.decode(bb, tableOffset + __offset_rotation) else null,
              position = if (__offset_position != 0) Vec3f.decode(bb, tableOffset + __offset_position) else null,
              rawAngularVelocity = if (__offset_rawAngularVelocity != 0) Vec3f.decode(bb, tableOffset + __offset_rawAngularVelocity) else null,
              rawAcceleration = if (__offset_rawAcceleration != 0) Vec3f.decode(bb, tableOffset + __offset_rawAcceleration) else null,
              temp = if (__offset_temp != 0) bb.getFloat(tableOffset + __offset_temp) else null,
              linearAcceleration = if (__offset_linearAcceleration != 0) Vec3f.decode(bb, tableOffset + __offset_linearAcceleration) else null,
              rotationReferenceAdjusted = if (__offset_rotationReferenceAdjusted != 0) Quat.decode(bb, tableOffset + __offset_rotationReferenceAdjusted) else null,
              rotationIdentityAdjusted = if (__offset_rotationIdentityAdjusted != 0) Quat.decode(bb, tableOffset + __offset_rotationIdentityAdjusted) else null,
              tps = if (__offset_tps != 0) bb.getShort(tableOffset + __offset_tps).toUShort() else null,
              rawMagneticVector = if (__offset_rawMagneticVector != 0) Vec3f.decode(bb, tableOffset + __offset_rawMagneticVector) else null,
              stayAligned = if (__offset_stayAligned != 0) StayAlignedTracker.decode(bb, tableOffset + __offset_stayAligned + bb.getInt(tableOffset + __offset_stayAligned)) else null,
              origin = if (__offset_origin != 0) DeviceOrigin.fromValue(bb.get(tableOffset + __offset_origin).toUByte()) ?: DeviceOrigin.NONE else DeviceOrigin.NONE
          )
    }
  }
}

/**
 * A mask of the different components in `TrackerComponent`
 */
public data class TrackerDataMask(
  public val info: Boolean = false,
  public val status: Boolean = false,
  public val rotation: Boolean = false,
  public val position: Boolean = false,
  public val rawAngularVelocity: Boolean = false,
  public val rawAcceleration: Boolean = false,
  public val temp: Boolean = false,
  public val linearAcceleration: Boolean = false,
  public val rotationReferenceAdjusted: Boolean = false,
  public val rotationIdentityAdjusted: Boolean = false,
  public val tps: Boolean = false,
  public val rawMagneticVector: Boolean = false,
  public val stayAligned: Boolean = false,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(13)
    builder.addBoolean(0, info, false)
    builder.addBoolean(1, status, false)
    builder.addBoolean(2, rotation, false)
    builder.addBoolean(3, position, false)
    builder.addBoolean(4, rawAngularVelocity, false)
    builder.addBoolean(5, rawAcceleration, false)
    builder.addBoolean(6, temp, false)
    builder.addBoolean(7, linearAcceleration, false)
    builder.addBoolean(8, rotationReferenceAdjusted, false)
    builder.addBoolean(9, rotationIdentityAdjusted, false)
    builder.addBoolean(10, tps, false)
    builder.addBoolean(11, rawMagneticVector, false)
    builder.addBoolean(12, stayAligned, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackerDataMask {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_info = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_status = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_rotation = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_position = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_rawAngularVelocity = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_rawAcceleration = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_temp = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_linearAcceleration = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_rotationReferenceAdjusted = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_rotationIdentityAdjusted = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_tps = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_rawMagneticVector = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0
      val __offset_stayAligned = if (vtableSize > 28) bb.getShort(vtableOffset + 28).toInt() else 0

      return TrackerDataMask(
              info = if (__offset_info != 0) bb.get(tableOffset + __offset_info) != 0.toByte() else false,
              status = if (__offset_status != 0) bb.get(tableOffset + __offset_status) != 0.toByte() else false,
              rotation = if (__offset_rotation != 0) bb.get(tableOffset + __offset_rotation) != 0.toByte() else false,
              position = if (__offset_position != 0) bb.get(tableOffset + __offset_position) != 0.toByte() else false,
              rawAngularVelocity = if (__offset_rawAngularVelocity != 0) bb.get(tableOffset + __offset_rawAngularVelocity) != 0.toByte() else false,
              rawAcceleration = if (__offset_rawAcceleration != 0) bb.get(tableOffset + __offset_rawAcceleration) != 0.toByte() else false,
              temp = if (__offset_temp != 0) bb.get(tableOffset + __offset_temp) != 0.toByte() else false,
              linearAcceleration = if (__offset_linearAcceleration != 0) bb.get(tableOffset + __offset_linearAcceleration) != 0.toByte() else false,
              rotationReferenceAdjusted = if (__offset_rotationReferenceAdjusted != 0) bb.get(tableOffset + __offset_rotationReferenceAdjusted) != 0.toByte() else false,
              rotationIdentityAdjusted = if (__offset_rotationIdentityAdjusted != 0) bb.get(tableOffset + __offset_rotationIdentityAdjusted) != 0.toByte() else false,
              tps = if (__offset_tps != 0) bb.get(tableOffset + __offset_tps) != 0.toByte() else false,
              rawMagneticVector = if (__offset_rawMagneticVector != 0) bb.get(tableOffset + __offset_rawMagneticVector) != 0.toByte() else false,
              stayAligned = if (__offset_stayAligned != 0) bb.get(tableOffset + __offset_stayAligned) != 0.toByte() else false
          )
    }
  }
}

/**
 * Static description of a tracker
 */
public data class TrackerInfo(
  public val isImu: Boolean = false,
  public val imuType: ImuType = ImuType.UNKNOWN,
  public val bodyPart: BodyPart = BodyPart.NONE,
  public val mountingOrientation: Quat? = null,
  public val displayName: String? = null,
  public val customName: String? = null,
  public val lastMountingMethod: MountingMethod = MountingMethod.MANUAL,
  public val magnetometer: MagnetometerStatus = MagnetometerStatus.NOT_SUPPORTED,
  public val dataType: TrackerDataType = TrackerDataType.ROTATION,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_displayName = displayName?.let { builder.createString(it) }
    val __off_customName = customName?.let { builder.createString(it) }

    builder.startTable(9)
    builder.addBoolean(0, isImu, false)
    builder.addShort(1, imuType.value.toShort(), 0)
    builder.addByte(2, bodyPart.value.toByte(), 0)
    mountingOrientation?.let { builder.addStruct(3, it.encode(builder), 0) }
    __off_displayName?.let { builder.addOffset(4, it, 0) }
    __off_customName?.let { builder.addOffset(5, it, 0) }
    builder.addByte(6, lastMountingMethod.value.toByte(), 0)
    builder.addByte(7, magnetometer.value.toByte(), 0)
    builder.addByte(8, dataType.value.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackerInfo {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_isImu = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_imuType = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_bodyPart = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_mountingOrientation = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_displayName = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_customName = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_lastMountingMethod = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_magnetometer = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_dataType = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0

      return TrackerInfo(
              isImu = if (__offset_isImu != 0) bb.get(tableOffset + __offset_isImu) != 0.toByte() else false,
              imuType = if (__offset_imuType != 0) ImuType.fromValue(bb.getShort(tableOffset + __offset_imuType).toUShort()) ?: ImuType.UNKNOWN else ImuType.UNKNOWN,
              bodyPart = if (__offset_bodyPart != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_bodyPart).toUByte()) ?: BodyPart.NONE else BodyPart.NONE,
              mountingOrientation = if (__offset_mountingOrientation != 0) Quat.decode(bb, tableOffset + __offset_mountingOrientation) else null,
              displayName = if (__offset_displayName != 0) readFlatBufferString(bb, tableOffset + __offset_displayName) else null,
              customName = if (__offset_customName != 0) readFlatBufferString(bb, tableOffset + __offset_customName) else null,
              lastMountingMethod = if (__offset_lastMountingMethod != 0) MountingMethod.fromValue(bb.get(tableOffset + __offset_lastMountingMethod).toUByte()) ?: MountingMethod.MANUAL else MountingMethod.MANUAL,
              magnetometer = if (__offset_magnetometer != 0) MagnetometerStatus.fromValue(bb.get(tableOffset + __offset_magnetometer).toUByte()) ?: MagnetometerStatus.NOT_SUPPORTED else MagnetometerStatus.NOT_SUPPORTED,
              dataType = if (__offset_dataType != 0) TrackerDataType.fromValue(bb.get(tableOffset + __offset_dataType).toUByte()) ?: TrackerDataType.ROTATION else TrackerDataType.ROTATION
          )
    }
  }
}

public data class StayAlignedTracker(
  public val yawCorrectionInDeg: Float = 0.0f,
  public val locked: Boolean = false,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    builder.addFloat(0, yawCorrectionInDeg, 0.0)
    builder.addBoolean(1, locked, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StayAlignedTracker {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_yawCorrectionInDeg = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_locked = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return StayAlignedTracker(
              yawCorrectionInDeg = if (__offset_yawCorrectionInDeg != 0) bb.getFloat(tableOffset + __offset_yawCorrectionInDeg) else 0.0f,
              locked = if (__offset_locked != 0) bb.get(tableOffset + __offset_locked) != 0.toByte() else false
          )
    }
  }
}
