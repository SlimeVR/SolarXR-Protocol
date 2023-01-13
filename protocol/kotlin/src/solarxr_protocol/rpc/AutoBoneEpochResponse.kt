// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
class AutoBoneEpochResponse : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : AutoBoneEpochResponse {
        __init(_i, _bb)
        return this
    }
    val currentEpoch : UInt
        get() {
            val o = __offset(4)
            return if(o != 0) bb.getInt(o + bb_pos).toUInt() else 0u
        }
    val totalEpochs : UInt
        get() {
            val o = __offset(6)
            return if(o != 0) bb.getInt(o + bb_pos).toUInt() else 0u
        }
    val epochError : Float
        get() {
            val o = __offset(8)
            return if(o != 0) bb.getFloat(o + bb_pos) else 0.0f
        }
    fun adjustedSkeletonParts(j: Int) : solarxr_protocol.rpc.SkeletonPart? = adjustedSkeletonParts(solarxr_protocol.rpc.SkeletonPart(), j)
    fun adjustedSkeletonParts(obj: solarxr_protocol.rpc.SkeletonPart, j: Int) : solarxr_protocol.rpc.SkeletonPart? {
        val o = __offset(10)
        return if (o != 0) {
            obj.__assign(__indirect(__vector(o) + j * 4), bb)
        } else {
            null
        }
    }
    val adjustedSkeletonPartsLength : Int
        get() {
            val o = __offset(10); return if (o != 0) __vector_len(o) else 0
        }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_10_26()
        fun getRootAsAutoBoneEpochResponse(_bb: ByteBuffer): AutoBoneEpochResponse = getRootAsAutoBoneEpochResponse(_bb, AutoBoneEpochResponse())
        fun getRootAsAutoBoneEpochResponse(_bb: ByteBuffer, obj: AutoBoneEpochResponse): AutoBoneEpochResponse {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createAutoBoneEpochResponse(builder: FlatBufferBuilder, currentEpoch: UInt, totalEpochs: UInt, epochError: Float, adjustedSkeletonPartsOffset: Int) : Int {
            builder.startTable(4)
            addAdjustedSkeletonParts(builder, adjustedSkeletonPartsOffset)
            addEpochError(builder, epochError)
            addTotalEpochs(builder, totalEpochs)
            addCurrentEpoch(builder, currentEpoch)
            return endAutoBoneEpochResponse(builder)
        }
        fun startAutoBoneEpochResponse(builder: FlatBufferBuilder) = builder.startTable(4)
        fun addCurrentEpoch(builder: FlatBufferBuilder, currentEpoch: UInt) = builder.addInt(0, currentEpoch.toInt(), 0)
        fun addTotalEpochs(builder: FlatBufferBuilder, totalEpochs: UInt) = builder.addInt(1, totalEpochs.toInt(), 0)
        fun addEpochError(builder: FlatBufferBuilder, epochError: Float) = builder.addFloat(2, epochError, 0.0)
        fun addAdjustedSkeletonParts(builder: FlatBufferBuilder, adjustedSkeletonParts: Int) = builder.addOffset(3, adjustedSkeletonParts, 0)
        fun createAdjustedSkeletonPartsVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addOffset(data[i])
            }
            return builder.endVector()
        }
        fun startAdjustedSkeletonPartsVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun endAutoBoneEpochResponse(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}