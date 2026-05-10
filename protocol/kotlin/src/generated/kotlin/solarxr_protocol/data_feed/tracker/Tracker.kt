package solarxr_protocol.data_feed.tracker

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.UShort
import solarxr_protocol.data_feed.stay_aligned.StayAlignedTracker
import solarxr_protocol.datatypes.BodyPart
import solarxr_protocol.datatypes.HzF32
import solarxr_protocol.datatypes.MagnetometerStatus
import solarxr_protocol.datatypes.Temperature
import solarxr_protocol.datatypes.TrackerId
import solarxr_protocol.datatypes.TrackerStatus
import solarxr_protocol.datatypes.hardware_info.ImuType
import solarxr_protocol.datatypes.hardware_info.TrackerDataType
import solarxr_protocol.datatypes.math.Quat
import solarxr_protocol.datatypes.math.Vec3f

/**
 * Describes all possible information about a tracker. A tracker is anything that
 * provides kinematic data about a particular body part.
 *
 * Trackers may be synthetic/computed or instead part of an actual hardware device.
 * There can be multiple trackers per hardware device.
 */
public data class TrackerData(
  public val trackerId: TrackerId? = null,
  public val info: TrackerInfo? = null,
  public val status: TrackerStatus? = null,
  public val rotation: Quat? = null,
  public val position: Vec3f? = null,
  public val rawAngularVelocity: Vec3f? = null,
  public val rawAcceleration: Vec3f? = null,
  public val temp: Temperature? = null,
  public val linearAcceleration: Vec3f? = null,
  public val rotationReferenceAdjusted: Quat? = null,
  public val rotationIdentityAdjusted: Quat? = null,
  public val tps: UShort? = null,
  public val rawMagneticVector: Vec3f? = null,
  public val stayAligned: StayAlignedTracker? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackerId = trackerId?.encode(builder)
    val __off_info = info?.encode(builder)
    val __off_stayAligned = stayAligned?.encode(builder)

    builder.startTable(14)
    __off_trackerId?.let { builder.addOffset(0, it, 0) }
    __off_info?.let { builder.addOffset(1, it, 0) }
    if (status != null) { builder.forceDefaults(true); builder.addByte(2, status.value.toByte(), 0); builder.forceDefaults(false) }
    rotation?.let { builder.addStruct(3, it.encode(builder), 0) }
    position?.let { builder.addStruct(4, it.encode(builder), 0) }
    rawAngularVelocity?.let { builder.addStruct(5, it.encode(builder), 0) }
    rawAcceleration?.let { builder.addStruct(6, it.encode(builder), 0) }
    temp?.let { builder.addStruct(7, it.encode(builder), 0) }
    linearAcceleration?.let { builder.addStruct(8, it.encode(builder), 0) }
    rotationReferenceAdjusted?.let { builder.addStruct(9, it.encode(builder), 0) }
    rotationIdentityAdjusted?.let { builder.addStruct(10, it.encode(builder), 0) }
    if (tps != null) { builder.forceDefaults(true); builder.addShort(11, tps.toShort(), 0); builder.forceDefaults(false) }
    rawMagneticVector?.let { builder.addStruct(12, it.encode(builder), 0) }
    __off_stayAligned?.let { builder.addOffset(13, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackerData {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackerId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_info = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_status = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_rotation = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_position = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_rawAngularVelocity = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_rawAcceleration = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_temp = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_linearAcceleration = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_rotationReferenceAdjusted = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_rotationIdentityAdjusted = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_tps = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0
      val __offset_rawMagneticVector = if (vtableSize > 28) bb.getShort(vtableOffset + 28).toInt() else 0
      val __offset_stayAligned = if (vtableSize > 30) bb.getShort(vtableOffset + 30).toInt() else 0

      return TrackerData(
              trackerId = if (__offset_trackerId != 0) TrackerId.decode(bb, tableOffset + __offset_trackerId + bb.getInt(tableOffset + __offset_trackerId)) else null,
              info = if (__offset_info != 0) TrackerInfo.decode(bb, tableOffset + __offset_info + bb.getInt(tableOffset + __offset_info)) else null,
              status = if (__offset_status != 0) TrackerStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) else null,
              rotation = if (__offset_rotation != 0) Quat.decode(bb, tableOffset + __offset_rotation) else null,
              position = if (__offset_position != 0) Vec3f.decode(bb, tableOffset + __offset_position) else null,
              rawAngularVelocity = if (__offset_rawAngularVelocity != 0) Vec3f.decode(bb, tableOffset + __offset_rawAngularVelocity) else null,
              rawAcceleration = if (__offset_rawAcceleration != 0) Vec3f.decode(bb, tableOffset + __offset_rawAcceleration) else null,
              temp = if (__offset_temp != 0) Temperature.decode(bb, tableOffset + __offset_temp) else null,
              linearAcceleration = if (__offset_linearAcceleration != 0) Vec3f.decode(bb, tableOffset + __offset_linearAcceleration) else null,
              rotationReferenceAdjusted = if (__offset_rotationReferenceAdjusted != 0) Quat.decode(bb, tableOffset + __offset_rotationReferenceAdjusted) else null,
              rotationIdentityAdjusted = if (__offset_rotationIdentityAdjusted != 0) Quat.decode(bb, tableOffset + __offset_rotationIdentityAdjusted) else null,
              tps = if (__offset_tps != 0) bb.getShort(tableOffset + __offset_tps).toUShort() else null,
              rawMagneticVector = if (__offset_rawMagneticVector != 0) Vec3f.decode(bb, tableOffset + __offset_rawMagneticVector) else null,
              stayAligned = if (__offset_stayAligned != 0) StayAlignedTracker.decode(bb, tableOffset + __offset_stayAligned + bb.getInt(tableOffset + __offset_stayAligned)) else null
          )
    }
  }
}

/**
 * A mask of the different components in `TrackerComponent`
 */
public data class TrackerDataMask(
  public val info: Boolean? = null,
  public val status: Boolean? = null,
  public val rotation: Boolean? = null,
  public val position: Boolean? = null,
  public val rawAngularVelocity: Boolean? = null,
  public val rawAcceleration: Boolean? = null,
  public val temp: Boolean? = null,
  public val linearAcceleration: Boolean? = null,
  public val rotationReferenceAdjusted: Boolean? = null,
  public val rotationIdentityAdjusted: Boolean? = null,
  public val tps: Boolean? = null,
  public val rawMagneticVector: Boolean? = null,
  public val stayAligned: Boolean? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(13)
    if (info != null) { builder.forceDefaults(true); builder.addBoolean(0, info, false); builder.forceDefaults(false) }
    if (status != null) { builder.forceDefaults(true); builder.addBoolean(1, status, false); builder.forceDefaults(false) }
    if (rotation != null) { builder.forceDefaults(true); builder.addBoolean(2, rotation, false); builder.forceDefaults(false) }
    if (position != null) { builder.forceDefaults(true); builder.addBoolean(3, position, false); builder.forceDefaults(false) }
    if (rawAngularVelocity != null) { builder.forceDefaults(true); builder.addBoolean(4, rawAngularVelocity, false); builder.forceDefaults(false) }
    if (rawAcceleration != null) { builder.forceDefaults(true); builder.addBoolean(5, rawAcceleration, false); builder.forceDefaults(false) }
    if (temp != null) { builder.forceDefaults(true); builder.addBoolean(6, temp, false); builder.forceDefaults(false) }
    if (linearAcceleration != null) { builder.forceDefaults(true); builder.addBoolean(7, linearAcceleration, false); builder.forceDefaults(false) }
    if (rotationReferenceAdjusted != null) { builder.forceDefaults(true); builder.addBoolean(8, rotationReferenceAdjusted, false); builder.forceDefaults(false) }
    if (rotationIdentityAdjusted != null) { builder.forceDefaults(true); builder.addBoolean(9, rotationIdentityAdjusted, false); builder.forceDefaults(false) }
    if (tps != null) { builder.forceDefaults(true); builder.addBoolean(10, tps, false); builder.forceDefaults(false) }
    if (rawMagneticVector != null) { builder.forceDefaults(true); builder.addBoolean(11, rawMagneticVector, false); builder.forceDefaults(false) }
    if (stayAligned != null) { builder.forceDefaults(true); builder.addBoolean(12, stayAligned, false); builder.forceDefaults(false) }
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
              info = if (__offset_info != 0) bb.get(tableOffset + __offset_info) != 0.toByte() else null,
              status = if (__offset_status != 0) bb.get(tableOffset + __offset_status) != 0.toByte() else null,
              rotation = if (__offset_rotation != 0) bb.get(tableOffset + __offset_rotation) != 0.toByte() else null,
              position = if (__offset_position != 0) bb.get(tableOffset + __offset_position) != 0.toByte() else null,
              rawAngularVelocity = if (__offset_rawAngularVelocity != 0) bb.get(tableOffset + __offset_rawAngularVelocity) != 0.toByte() else null,
              rawAcceleration = if (__offset_rawAcceleration != 0) bb.get(tableOffset + __offset_rawAcceleration) != 0.toByte() else null,
              temp = if (__offset_temp != 0) bb.get(tableOffset + __offset_temp) != 0.toByte() else null,
              linearAcceleration = if (__offset_linearAcceleration != 0) bb.get(tableOffset + __offset_linearAcceleration) != 0.toByte() else null,
              rotationReferenceAdjusted = if (__offset_rotationReferenceAdjusted != 0) bb.get(tableOffset + __offset_rotationReferenceAdjusted) != 0.toByte() else null,
              rotationIdentityAdjusted = if (__offset_rotationIdentityAdjusted != 0) bb.get(tableOffset + __offset_rotationIdentityAdjusted) != 0.toByte() else null,
              tps = if (__offset_tps != 0) bb.get(tableOffset + __offset_tps) != 0.toByte() else null,
              rawMagneticVector = if (__offset_rawMagneticVector != 0) bb.get(tableOffset + __offset_rawMagneticVector) != 0.toByte() else null,
              stayAligned = if (__offset_stayAligned != 0) bb.get(tableOffset + __offset_stayAligned) != 0.toByte() else null
          )
    }
  }
}

/**
 * Static description of a tracker
 */
public data class TrackerInfo(
  public val imuType: ImuType? = null,
  public val bodyPart: BodyPart? = null,
  public val pollRate: HzF32? = null,
  public val mountingOrientation: Quat? = null,
  public val editable: Boolean? = null,
  public val isComputed: Boolean? = null,
  public val isImu: Boolean? = null,
  public val displayName: String? = null,
  public val customName: String? = null,
  public val allowDriftCompensation: Boolean? = null,
  public val mountingResetOrientation: Quat? = null,
  public val isHmd: Boolean? = null,
  public val magnetometer: MagnetometerStatus? = null,
  public val dataSupport: TrackerDataType? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_displayName = displayName?.let { builder.createString(it) }
    val __off_customName = customName?.let { builder.createString(it) }

    builder.startTable(14)
    if (imuType != null) { builder.forceDefaults(true); builder.addShort(0, imuType.value.toShort(), 0); builder.forceDefaults(false) }
    if (bodyPart != null) { builder.forceDefaults(true); builder.addByte(1, bodyPart.value.toByte(), 0); builder.forceDefaults(false) }
    pollRate?.let { builder.addStruct(2, it.encode(builder), 0) }
    mountingOrientation?.let { builder.addStruct(3, it.encode(builder), 0) }
    if (editable != null) { builder.forceDefaults(true); builder.addBoolean(4, editable, false); builder.forceDefaults(false) }
    if (isComputed != null) { builder.forceDefaults(true); builder.addBoolean(5, isComputed, false); builder.forceDefaults(false) }
    if (isImu != null) { builder.forceDefaults(true); builder.addBoolean(6, isImu, false); builder.forceDefaults(false) }
    __off_displayName?.let { builder.addOffset(7, it, 0) }
    __off_customName?.let { builder.addOffset(8, it, 0) }
    if (allowDriftCompensation != null) { builder.forceDefaults(true); builder.addBoolean(9, allowDriftCompensation, false); builder.forceDefaults(false) }
    mountingResetOrientation?.let { builder.addStruct(10, it.encode(builder), 0) }
    if (isHmd != null) { builder.forceDefaults(true); builder.addBoolean(11, isHmd, false); builder.forceDefaults(false) }
    if (magnetometer != null) { builder.forceDefaults(true); builder.addByte(12, magnetometer.value.toByte(), 0); builder.forceDefaults(false) }
    if (dataSupport != null) { builder.forceDefaults(true); builder.addByte(13, dataSupport.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackerInfo {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_imuType = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_bodyPart = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_pollRate = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_mountingOrientation = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_editable = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_isComputed = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_isImu = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_displayName = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_customName = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_allowDriftCompensation = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_mountingResetOrientation = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_isHmd = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0
      val __offset_magnetometer = if (vtableSize > 28) bb.getShort(vtableOffset + 28).toInt() else 0
      val __offset_dataSupport = if (vtableSize > 30) bb.getShort(vtableOffset + 30).toInt() else 0

      return TrackerInfo(
              imuType = if (__offset_imuType != 0) ImuType.fromValue(bb.getShort(tableOffset + __offset_imuType).toUShort()) else null,
              bodyPart = if (__offset_bodyPart != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_bodyPart).toUByte()) else null,
              pollRate = if (__offset_pollRate != 0) HzF32.decode(bb, tableOffset + __offset_pollRate) else null,
              mountingOrientation = if (__offset_mountingOrientation != 0) Quat.decode(bb, tableOffset + __offset_mountingOrientation) else null,
              editable = if (__offset_editable != 0) bb.get(tableOffset + __offset_editable) != 0.toByte() else null,
              isComputed = if (__offset_isComputed != 0) bb.get(tableOffset + __offset_isComputed) != 0.toByte() else null,
              isImu = if (__offset_isImu != 0) bb.get(tableOffset + __offset_isImu) != 0.toByte() else null,
              displayName = if (__offset_displayName != 0) readFlatBufferString(bb, tableOffset + __offset_displayName) else null,
              customName = if (__offset_customName != 0) readFlatBufferString(bb, tableOffset + __offset_customName) else null,
              allowDriftCompensation = if (__offset_allowDriftCompensation != 0) bb.get(tableOffset + __offset_allowDriftCompensation) != 0.toByte() else null,
              mountingResetOrientation = if (__offset_mountingResetOrientation != 0) Quat.decode(bb, tableOffset + __offset_mountingResetOrientation) else null,
              isHmd = if (__offset_isHmd != 0) bb.get(tableOffset + __offset_isHmd) != 0.toByte() else null,
              magnetometer = if (__offset_magnetometer != 0) MagnetometerStatus.fromValue(bb.get(tableOffset + __offset_magnetometer).toUByte()) else null,
              dataSupport = if (__offset_dataSupport != 0) TrackerDataType.fromValue(bb.get(tableOffset + __offset_dataSupport).toUByte()) else null
          )
    }
  }
}
