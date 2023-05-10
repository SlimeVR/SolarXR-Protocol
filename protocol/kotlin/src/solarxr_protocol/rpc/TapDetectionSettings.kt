// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
class TapDetectionSettings : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : TapDetectionSettings {
        __init(_i, _bb)
        return this
    }
    val fullResetDelay : Float?
        get() {
            val o = __offset(4)
            return if(o != 0) bb.getFloat(o + bb_pos) else null
        }
    val fullResetEnabled : Boolean?
        get() {
            val o = __offset(6)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else null
        }
    val fullResetTaps : UByte?
        get() {
            val o = __offset(8)
            return if(o != 0) bb.get(o + bb_pos).toUByte() else null
        }
    val yawResetDelay : Float?
        get() {
            val o = __offset(10)
            return if(o != 0) bb.getFloat(o + bb_pos) else null
        }
    val yawResetEnabled : Boolean?
        get() {
            val o = __offset(12)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else null
        }
    val yawResetTaps : UByte?
        get() {
            val o = __offset(14)
            return if(o != 0) bb.get(o + bb_pos).toUByte() else null
        }
    val mountingResetDelay : Float?
        get() {
            val o = __offset(16)
            return if(o != 0) bb.getFloat(o + bb_pos) else null
        }
    val mountingResetEnabled : Boolean?
        get() {
            val o = __offset(18)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else null
        }
    val mountingResetTaps : UByte?
        get() {
            val o = __offset(20)
            return if(o != 0) bb.get(o + bb_pos).toUByte() else null
        }
    /**
     * Iff true, disables reset behavior of tap detection and sends a TapDetectionSetupResponse,
     * each time 2 taps are detected on any tracker
     */
    val setupMode : Boolean?
        get() {
            val o = __offset(22)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else null
        }
    companion object {
        @JvmStatic
        fun validateVersion() = Constants.FLATBUFFERS_22_10_26()
        @JvmStatic
        fun getRootAsTapDetectionSettings(_bb: ByteBuffer): TapDetectionSettings = getRootAsTapDetectionSettings(_bb, TapDetectionSettings())
        @JvmStatic
        fun getRootAsTapDetectionSettings(_bb: ByteBuffer, obj: TapDetectionSettings): TapDetectionSettings {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        @JvmStatic
        fun createTapDetectionSettings(builder: FlatBufferBuilder, fullResetDelay: Float?, fullResetEnabled: Boolean?, fullResetTaps: UByte?, yawResetDelay: Float?, yawResetEnabled: Boolean?, yawResetTaps: UByte?, mountingResetDelay: Float?, mountingResetEnabled: Boolean?, mountingResetTaps: UByte?, setupMode: Boolean?) : Int {
            builder.startTable(10)
            mountingResetDelay?.run { addMountingResetDelay(builder, mountingResetDelay) }
            yawResetDelay?.run { addYawResetDelay(builder, yawResetDelay) }
            fullResetDelay?.run { addFullResetDelay(builder, fullResetDelay) }
            setupMode?.run { addSetupMode(builder, setupMode) }
            mountingResetTaps?.run { addMountingResetTaps(builder, mountingResetTaps) }
            mountingResetEnabled?.run { addMountingResetEnabled(builder, mountingResetEnabled) }
            yawResetTaps?.run { addYawResetTaps(builder, yawResetTaps) }
            yawResetEnabled?.run { addYawResetEnabled(builder, yawResetEnabled) }
            fullResetTaps?.run { addFullResetTaps(builder, fullResetTaps) }
            fullResetEnabled?.run { addFullResetEnabled(builder, fullResetEnabled) }
            return endTapDetectionSettings(builder)
        }
        @JvmStatic
        fun startTapDetectionSettings(builder: FlatBufferBuilder) = builder.startTable(10)
        @JvmStatic
        fun addFullResetDelay(builder: FlatBufferBuilder, fullResetDelay: Float) = builder.addFloat(0, fullResetDelay, 0.0)
        @JvmStatic
        fun addFullResetEnabled(builder: FlatBufferBuilder, fullResetEnabled: Boolean) = builder.addBoolean(1, fullResetEnabled, false)
        @JvmStatic
        fun addFullResetTaps(builder: FlatBufferBuilder, fullResetTaps: UByte) = builder.addByte(2, fullResetTaps.toByte(), 0)
        @JvmStatic
        fun addYawResetDelay(builder: FlatBufferBuilder, yawResetDelay: Float) = builder.addFloat(3, yawResetDelay, 0.0)
        @JvmStatic
        fun addYawResetEnabled(builder: FlatBufferBuilder, yawResetEnabled: Boolean) = builder.addBoolean(4, yawResetEnabled, false)
        @JvmStatic
        fun addYawResetTaps(builder: FlatBufferBuilder, yawResetTaps: UByte) = builder.addByte(5, yawResetTaps.toByte(), 0)
        @JvmStatic
        fun addMountingResetDelay(builder: FlatBufferBuilder, mountingResetDelay: Float) = builder.addFloat(6, mountingResetDelay, 0.0)
        @JvmStatic
        fun addMountingResetEnabled(builder: FlatBufferBuilder, mountingResetEnabled: Boolean) = builder.addBoolean(7, mountingResetEnabled, false)
        @JvmStatic
        fun addMountingResetTaps(builder: FlatBufferBuilder, mountingResetTaps: UByte) = builder.addByte(8, mountingResetTaps.toByte(), 0)
        @JvmStatic
        fun addSetupMode(builder: FlatBufferBuilder, setupMode: Boolean) = builder.addBoolean(9, setupMode, false)
        @JvmStatic
        fun endTapDetectionSettings(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
