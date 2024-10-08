// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
class SteamVRTrackersSetting : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : SteamVRTrackersSetting {
        __init(_i, _bb)
        return this
    }
    val waist : Boolean
        get() {
            val o = __offset(4)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val chest : Boolean
        get() {
            val o = __offset(6)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val automaticTrackerToggle : Boolean
        get() {
            val o = __offset(16)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val leftFoot : Boolean
        get() {
            val o = __offset(18)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val rightFoot : Boolean
        get() {
            val o = __offset(20)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val leftKnee : Boolean
        get() {
            val o = __offset(22)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val rightKnee : Boolean
        get() {
            val o = __offset(24)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val leftElbow : Boolean
        get() {
            val o = __offset(26)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val rightElbow : Boolean
        get() {
            val o = __offset(28)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val leftHand : Boolean
        get() {
            val o = __offset(30)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val rightHand : Boolean
        get() {
            val o = __offset(32)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    companion object {
        @JvmStatic
        fun validateVersion() = Constants.FLATBUFFERS_22_10_26()
        @JvmStatic
        fun getRootAsSteamVRTrackersSetting(_bb: ByteBuffer): SteamVRTrackersSetting = getRootAsSteamVRTrackersSetting(_bb, SteamVRTrackersSetting())
        @JvmStatic
        fun getRootAsSteamVRTrackersSetting(_bb: ByteBuffer, obj: SteamVRTrackersSetting): SteamVRTrackersSetting {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        @JvmStatic
        fun createSteamVRTrackersSetting(builder: FlatBufferBuilder, waist: Boolean, chest: Boolean, automaticTrackerToggle: Boolean, leftFoot: Boolean, rightFoot: Boolean, leftKnee: Boolean, rightKnee: Boolean, leftElbow: Boolean, rightElbow: Boolean, leftHand: Boolean, rightHand: Boolean) : Int {
            builder.startTable(15)
            addRightHand(builder, rightHand)
            addLeftHand(builder, leftHand)
            addRightElbow(builder, rightElbow)
            addLeftElbow(builder, leftElbow)
            addRightKnee(builder, rightKnee)
            addLeftKnee(builder, leftKnee)
            addRightFoot(builder, rightFoot)
            addLeftFoot(builder, leftFoot)
            addAutomaticTrackerToggle(builder, automaticTrackerToggle)
            addChest(builder, chest)
            addWaist(builder, waist)
            return endSteamVRTrackersSetting(builder)
        }
        @JvmStatic
        fun startSteamVRTrackersSetting(builder: FlatBufferBuilder) = builder.startTable(15)
        @JvmStatic
        fun addWaist(builder: FlatBufferBuilder, waist: Boolean) = builder.addBoolean(0, waist, false)
        @JvmStatic
        fun addChest(builder: FlatBufferBuilder, chest: Boolean) = builder.addBoolean(1, chest, false)
        @JvmStatic
        fun addAutomaticTrackerToggle(builder: FlatBufferBuilder, automaticTrackerToggle: Boolean) = builder.addBoolean(6, automaticTrackerToggle, false)
        @JvmStatic
        fun addLeftFoot(builder: FlatBufferBuilder, leftFoot: Boolean) = builder.addBoolean(7, leftFoot, false)
        @JvmStatic
        fun addRightFoot(builder: FlatBufferBuilder, rightFoot: Boolean) = builder.addBoolean(8, rightFoot, false)
        @JvmStatic
        fun addLeftKnee(builder: FlatBufferBuilder, leftKnee: Boolean) = builder.addBoolean(9, leftKnee, false)
        @JvmStatic
        fun addRightKnee(builder: FlatBufferBuilder, rightKnee: Boolean) = builder.addBoolean(10, rightKnee, false)
        @JvmStatic
        fun addLeftElbow(builder: FlatBufferBuilder, leftElbow: Boolean) = builder.addBoolean(11, leftElbow, false)
        @JvmStatic
        fun addRightElbow(builder: FlatBufferBuilder, rightElbow: Boolean) = builder.addBoolean(12, rightElbow, false)
        @JvmStatic
        fun addLeftHand(builder: FlatBufferBuilder, leftHand: Boolean) = builder.addBoolean(13, leftHand, false)
        @JvmStatic
        fun addRightHand(builder: FlatBufferBuilder, rightHand: Boolean) = builder.addBoolean(14, rightHand, false)
        @JvmStatic
        fun endSteamVRTrackersSetting(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
