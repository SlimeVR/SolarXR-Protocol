// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

/**
 * Makes a temporary change to legtweaks. This is not saved to disk, and can be
 * cleared with `LegTweaksTmpClear`
 */
@Suppress("unused")
class LegTweaksTmpChange : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : LegTweaksTmpChange {
        __init(_i, _bb)
        return this
    }
    val floorClip : Boolean?
        get() {
            val o = __offset(4)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else null
        }
    val skatingCorrection : Boolean?
        get() {
            val o = __offset(6)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else null
        }
    val toeSnap : Boolean?
        get() {
            val o = __offset(8)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else null
        }
    val footPlant : Boolean?
        get() {
            val o = __offset(10)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else null
        }
    companion object {
        @JvmStatic
        fun validateVersion() = Constants.FLATBUFFERS_22_10_26()
        @JvmStatic
        fun getRootAsLegTweaksTmpChange(_bb: ByteBuffer): LegTweaksTmpChange = getRootAsLegTweaksTmpChange(_bb, LegTweaksTmpChange())
        @JvmStatic
        fun getRootAsLegTweaksTmpChange(_bb: ByteBuffer, obj: LegTweaksTmpChange): LegTweaksTmpChange {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        @JvmStatic
        fun createLegTweaksTmpChange(builder: FlatBufferBuilder, floorClip: Boolean?, skatingCorrection: Boolean?, toeSnap: Boolean?, footPlant: Boolean?) : Int {
            builder.startTable(4)
            footPlant?.run { addFootPlant(builder, footPlant) }
            toeSnap?.run { addToeSnap(builder, toeSnap) }
            skatingCorrection?.run { addSkatingCorrection(builder, skatingCorrection) }
            floorClip?.run { addFloorClip(builder, floorClip) }
            return endLegTweaksTmpChange(builder)
        }
        @JvmStatic
        fun startLegTweaksTmpChange(builder: FlatBufferBuilder) = builder.startTable(4)
        @JvmStatic
        fun addFloorClip(builder: FlatBufferBuilder, floorClip: Boolean) = builder.addBoolean(0, floorClip, false)
        @JvmStatic
        fun addSkatingCorrection(builder: FlatBufferBuilder, skatingCorrection: Boolean) = builder.addBoolean(1, skatingCorrection, false)
        @JvmStatic
        fun addToeSnap(builder: FlatBufferBuilder, toeSnap: Boolean) = builder.addBoolean(2, toeSnap, false)
        @JvmStatic
        fun addFootPlant(builder: FlatBufferBuilder, footPlant: Boolean) = builder.addBoolean(3, footPlant, false)
        @JvmStatic
        fun endLegTweaksTmpChange(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
