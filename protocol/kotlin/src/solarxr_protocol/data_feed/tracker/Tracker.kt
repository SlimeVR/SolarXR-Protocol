package solarxr_protocol.data_feed.tracker

import com.google.flatbuffers.FlatBufferBuilder
import java.nio.ByteBuffer
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
data class TrackerData(
  val trackerId: TrackerId? = null,
  val info: TrackerInfo? = null,
  val status: TrackerStatus? = null,
  val rotation: Quat? = null,
  val position: Vec3f? = null,
  val rawAngularVelocity: Vec3f? = null,
  val rawAcceleration: Vec3f? = null,
  val temp: Temperature? = null,
  val linearAcceleration: Vec3f? = null,
  val rotationReferenceAdjusted: Quat? = null,
  val rotationIdentityAdjusted: Quat? = null,
  val tps: UShort? = null,
  val rawMagneticVector: Vec3f? = null,
  val stayAligned: StayAlignedTracker? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_trackerId = trackerId?.encode(builder)
    val __off_info = info?.encode(builder)
    val __off_stayAligned = stayAligned?.encode(builder)

    builder.startTable(14)
    __off_trackerId?.let { builder.addOffset(0, it, 0) }
    __off_info?.let { builder.addOffset(1, it, 0) }
    status?.let { builder.addByte(2, it.value.toByte(), 0) }
    rotation?.let { builder.addStruct(3, it.encode(builder), 0) }
    position?.let { builder.addStruct(4, it.encode(builder), 0) }
    rawAngularVelocity?.let { builder.addStruct(5, it.encode(builder), 0) }
    rawAcceleration?.let { builder.addStruct(6, it.encode(builder), 0) }
    temp?.let { builder.addStruct(7, it.encode(builder), 0) }
    linearAcceleration?.let { builder.addStruct(8, it.encode(builder), 0) }
    rotationReferenceAdjusted?.let { builder.addStruct(9, it.encode(builder), 0) }
    rotationIdentityAdjusted?.let { builder.addStruct(10, it.encode(builder), 0) }
    tps?.let { builder.addShort(11, it.toShort(), 0) }
    rawMagneticVector?.let { builder.addStruct(12, it.encode(builder), 0) }
    __off_stayAligned?.let { builder.addOffset(13, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): TrackerData {
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
              trackerId = if (__offset_trackerId != 0) solarxr_protocol.datatypes.TrackerId.decode(bb, tableOffset + __offset_trackerId + bb.getInt(tableOffset + __offset_trackerId)) else null,
              info = if (__offset_info != 0) solarxr_protocol.data_feed.tracker.TrackerInfo.decode(bb, tableOffset + __offset_info + bb.getInt(tableOffset + __offset_info)) else null,
              status = if (__offset_status != 0) solarxr_protocol.datatypes.TrackerStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) else null,
              rotation = if (__offset_rotation != 0) solarxr_protocol.datatypes.math.Quat.decode(bb, tableOffset + __offset_rotation) else null,
              position = if (__offset_position != 0) solarxr_protocol.datatypes.math.Vec3f.decode(bb, tableOffset + __offset_position) else null,
              rawAngularVelocity = if (__offset_rawAngularVelocity != 0) solarxr_protocol.datatypes.math.Vec3f.decode(bb, tableOffset + __offset_rawAngularVelocity) else null,
              rawAcceleration = if (__offset_rawAcceleration != 0) solarxr_protocol.datatypes.math.Vec3f.decode(bb, tableOffset + __offset_rawAcceleration) else null,
              temp = if (__offset_temp != 0) solarxr_protocol.datatypes.Temperature.decode(bb, tableOffset + __offset_temp) else null,
              linearAcceleration = if (__offset_linearAcceleration != 0) solarxr_protocol.datatypes.math.Vec3f.decode(bb, tableOffset + __offset_linearAcceleration) else null,
              rotationReferenceAdjusted = if (__offset_rotationReferenceAdjusted != 0) solarxr_protocol.datatypes.math.Quat.decode(bb, tableOffset + __offset_rotationReferenceAdjusted) else null,
              rotationIdentityAdjusted = if (__offset_rotationIdentityAdjusted != 0) solarxr_protocol.datatypes.math.Quat.decode(bb, tableOffset + __offset_rotationIdentityAdjusted) else null,
              tps = if (__offset_tps != 0) bb.getShort(tableOffset + __offset_tps).toUShort() else null,
              rawMagneticVector = if (__offset_rawMagneticVector != 0) solarxr_protocol.datatypes.math.Vec3f.decode(bb, tableOffset + __offset_rawMagneticVector) else null,
              stayAligned = if (__offset_stayAligned != 0) solarxr_protocol.data_feed.stay_aligned.StayAlignedTracker.decode(bb, tableOffset + __offset_stayAligned + bb.getInt(tableOffset + __offset_stayAligned)) else null
          )
    }
  }
}

/**
 * A mask of the different components in `TrackerComponent`
 */
data class TrackerDataMask(
  val info: Boolean? = null,
  val status: Boolean? = null,
  val rotation: Boolean? = null,
  val position: Boolean? = null,
  val rawAngularVelocity: Boolean? = null,
  val rawAcceleration: Boolean? = null,
  val temp: Boolean? = null,
  val linearAcceleration: Boolean? = null,
  val rotationReferenceAdjusted: Boolean? = null,
  val rotationIdentityAdjusted: Boolean? = null,
  val tps: Boolean? = null,
  val rawMagneticVector: Boolean? = null,
  val stayAligned: Boolean? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(13)
    info?.let { builder.addBoolean(0, it, false) }
    status?.let { builder.addBoolean(1, it, false) }
    rotation?.let { builder.addBoolean(2, it, false) }
    position?.let { builder.addBoolean(3, it, false) }
    rawAngularVelocity?.let { builder.addBoolean(4, it, false) }
    rawAcceleration?.let { builder.addBoolean(5, it, false) }
    temp?.let { builder.addBoolean(6, it, false) }
    linearAcceleration?.let { builder.addBoolean(7, it, false) }
    rotationReferenceAdjusted?.let { builder.addBoolean(8, it, false) }
    rotationIdentityAdjusted?.let { builder.addBoolean(9, it, false) }
    tps?.let { builder.addBoolean(10, it, false) }
    rawMagneticVector?.let { builder.addBoolean(11, it, false) }
    stayAligned?.let { builder.addBoolean(12, it, false) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): TrackerDataMask {
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
data class TrackerInfo(
  val imuType: ImuType? = null,
  val bodyPart: BodyPart? = null,
  val pollRate: HzF32? = null,
  val mountingOrientation: Quat? = null,
  val editable: Boolean? = null,
  val isComputed: Boolean? = null,
  val isImu: Boolean? = null,
  val displayName: String? = null,
  val customName: String? = null,
  val allowDriftCompensation: Boolean? = null,
  val mountingResetOrientation: Quat? = null,
  val isHmd: Boolean? = null,
  val magnetometer: MagnetometerStatus? = null,
  val dataSupport: TrackerDataType? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_displayName = displayName?.let { builder.createString(it) }
    val __off_customName = customName?.let { builder.createString(it) }

    builder.startTable(14)
    imuType?.let { builder.addShort(0, it.value.toShort(), 0) }
    bodyPart?.let { builder.addByte(1, it.value.toByte(), 0) }
    pollRate?.let { builder.addStruct(2, it.encode(builder), 0) }
    mountingOrientation?.let { builder.addStruct(3, it.encode(builder), 0) }
    editable?.let { builder.addBoolean(4, it, false) }
    isComputed?.let { builder.addBoolean(5, it, false) }
    isImu?.let { builder.addBoolean(6, it, false) }
    __off_displayName?.let { builder.addOffset(7, it, 0) }
    __off_customName?.let { builder.addOffset(8, it, 0) }
    allowDriftCompensation?.let { builder.addBoolean(9, it, false) }
    mountingResetOrientation?.let { builder.addStruct(10, it.encode(builder), 0) }
    isHmd?.let { builder.addBoolean(11, it, false) }
    magnetometer?.let { builder.addByte(12, it.value.toByte(), 0) }
    dataSupport?.let { builder.addByte(13, it.value.toByte(), 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): TrackerInfo {
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
              imuType = if (__offset_imuType != 0) solarxr_protocol.datatypes.hardware_info.ImuType.fromValue(bb.getShort(tableOffset + __offset_imuType).toUShort()) else null,
              bodyPart = if (__offset_bodyPart != 0) solarxr_protocol.datatypes.BodyPart.fromValue(bb.get(tableOffset + __offset_bodyPart).toUByte()) else null,
              pollRate = if (__offset_pollRate != 0) solarxr_protocol.datatypes.HzF32.decode(bb, tableOffset + __offset_pollRate) else null,
              mountingOrientation = if (__offset_mountingOrientation != 0) solarxr_protocol.datatypes.math.Quat.decode(bb, tableOffset + __offset_mountingOrientation) else null,
              editable = if (__offset_editable != 0) bb.get(tableOffset + __offset_editable) != 0.toByte() else null,
              isComputed = if (__offset_isComputed != 0) bb.get(tableOffset + __offset_isComputed) != 0.toByte() else null,
              isImu = if (__offset_isImu != 0) bb.get(tableOffset + __offset_isImu) != 0.toByte() else null,
              displayName = if (__offset_displayName != 0) { val strOff = tableOffset + __offset_displayName + bb.getInt(tableOffset + __offset_displayName); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              customName = if (__offset_customName != 0) { val strOff = tableOffset + __offset_customName + bb.getInt(tableOffset + __offset_customName); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              allowDriftCompensation = if (__offset_allowDriftCompensation != 0) bb.get(tableOffset + __offset_allowDriftCompensation) != 0.toByte() else null,
              mountingResetOrientation = if (__offset_mountingResetOrientation != 0) solarxr_protocol.datatypes.math.Quat.decode(bb, tableOffset + __offset_mountingResetOrientation) else null,
              isHmd = if (__offset_isHmd != 0) bb.get(tableOffset + __offset_isHmd) != 0.toByte() else null,
              magnetometer = if (__offset_magnetometer != 0) solarxr_protocol.datatypes.MagnetometerStatus.fromValue(bb.get(tableOffset + __offset_magnetometer).toUByte()) else null,
              dataSupport = if (__offset_dataSupport != 0) solarxr_protocol.datatypes.hardware_info.TrackerDataType.fromValue(bb.get(tableOffset + __offset_dataSupport).toUByte()) else null
          )
    }
  }
}
