// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
class VRCConfigValues : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : VRCConfigValues {
        __init(_i, _bb)
        return this
    }
    val legacyMode : Boolean
        get() {
            val o = __offset(4)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val shoulderTrackingDisabled : Boolean
        get() {
            val o = __offset(6)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val userHeight : Float
        get() {
            val o = __offset(8)
            return if(o != 0) bb.getFloat(o + bb_pos) else 0.0f
        }
    val calibrationRange : Float
        get() {
            val o = __offset(10)
            return if(o != 0) bb.getFloat(o + bb_pos) else 0.0f
        }
    val calibrationVisuals : Boolean
        get() {
            val o = __offset(12)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val trackerModel : UByte
        get() {
            val o = __offset(14)
            return if(o != 0) bb.get(o + bb_pos).toUByte() else 0u
        }
    val spineMode : UByte
        get() {
            val o = __offset(16)
            return if(o != 0) bb.get(o + bb_pos).toUByte() else 0u
        }
    val avatarMeasurementType : UByte
        get() {
            val o = __offset(18)
            return if(o != 0) bb.get(o + bb_pos).toUByte() else 0u
        }
    val shoulderWidthCompensation : Boolean
        get() {
            val o = __offset(20)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    companion object {
        @JvmStatic
        fun validateVersion() = Constants.FLATBUFFERS_22_10_26()
        @JvmStatic
        fun getRootAsVRCConfigValues(_bb: ByteBuffer): VRCConfigValues = getRootAsVRCConfigValues(_bb, VRCConfigValues())
        @JvmStatic
        fun getRootAsVRCConfigValues(_bb: ByteBuffer, obj: VRCConfigValues): VRCConfigValues {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        @JvmStatic
        fun createVRCConfigValues(builder: FlatBufferBuilder, legacyMode: Boolean, shoulderTrackingDisabled: Boolean, userHeight: Float, calibrationRange: Float, calibrationVisuals: Boolean, trackerModel: UByte, spineMode: UByte, avatarMeasurementType: UByte, shoulderWidthCompensation: Boolean) : Int {
            builder.startTable(9)
            addCalibrationRange(builder, calibrationRange)
            addUserHeight(builder, userHeight)
            addShoulderWidthCompensation(builder, shoulderWidthCompensation)
            addAvatarMeasurementType(builder, avatarMeasurementType)
            addSpineMode(builder, spineMode)
            addTrackerModel(builder, trackerModel)
            addCalibrationVisuals(builder, calibrationVisuals)
            addShoulderTrackingDisabled(builder, shoulderTrackingDisabled)
            addLegacyMode(builder, legacyMode)
            return endVRCConfigValues(builder)
        }
        @JvmStatic
        fun startVRCConfigValues(builder: FlatBufferBuilder) = builder.startTable(9)
        @JvmStatic
        fun addLegacyMode(builder: FlatBufferBuilder, legacyMode: Boolean) = builder.addBoolean(0, legacyMode, false)
        @JvmStatic
        fun addShoulderTrackingDisabled(builder: FlatBufferBuilder, shoulderTrackingDisabled: Boolean) = builder.addBoolean(1, shoulderTrackingDisabled, false)
        @JvmStatic
        fun addUserHeight(builder: FlatBufferBuilder, userHeight: Float) = builder.addFloat(2, userHeight, 0.0)
        @JvmStatic
        fun addCalibrationRange(builder: FlatBufferBuilder, calibrationRange: Float) = builder.addFloat(3, calibrationRange, 0.0)
        @JvmStatic
        fun addCalibrationVisuals(builder: FlatBufferBuilder, calibrationVisuals: Boolean) = builder.addBoolean(4, calibrationVisuals, false)
        @JvmStatic
        fun addTrackerModel(builder: FlatBufferBuilder, trackerModel: UByte) = builder.addByte(5, trackerModel.toByte(), 0)
        @JvmStatic
        fun addSpineMode(builder: FlatBufferBuilder, spineMode: UByte) = builder.addByte(6, spineMode.toByte(), 0)
        @JvmStatic
        fun addAvatarMeasurementType(builder: FlatBufferBuilder, avatarMeasurementType: UByte) = builder.addByte(7, avatarMeasurementType.toByte(), 0)
        @JvmStatic
        fun addShoulderWidthCompensation(builder: FlatBufferBuilder, shoulderWidthCompensation: Boolean) = builder.addBoolean(8, shoulderWidthCompensation, false)
        @JvmStatic
        fun endVRCConfigValues(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
