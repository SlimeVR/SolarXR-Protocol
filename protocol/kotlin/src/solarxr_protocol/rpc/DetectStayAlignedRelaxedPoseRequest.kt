// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
class DetectStayAlignedRelaxedPoseRequest : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : DetectStayAlignedRelaxedPoseRequest {
        __init(_i, _bb)
        return this
    }
    val pose : UByte
        get() {
            val o = __offset(4)
            return if(o != 0) bb.get(o + bb_pos).toUByte() else 0u
        }
    companion object {
        @JvmStatic
        fun validateVersion() = Constants.FLATBUFFERS_22_10_26()
        @JvmStatic
        fun getRootAsDetectStayAlignedRelaxedPoseRequest(_bb: ByteBuffer): DetectStayAlignedRelaxedPoseRequest = getRootAsDetectStayAlignedRelaxedPoseRequest(_bb, DetectStayAlignedRelaxedPoseRequest())
        @JvmStatic
        fun getRootAsDetectStayAlignedRelaxedPoseRequest(_bb: ByteBuffer, obj: DetectStayAlignedRelaxedPoseRequest): DetectStayAlignedRelaxedPoseRequest {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        @JvmStatic
        fun createDetectStayAlignedRelaxedPoseRequest(builder: FlatBufferBuilder, pose: UByte) : Int {
            builder.startTable(1)
            addPose(builder, pose)
            return endDetectStayAlignedRelaxedPoseRequest(builder)
        }
        @JvmStatic
        fun startDetectStayAlignedRelaxedPoseRequest(builder: FlatBufferBuilder) = builder.startTable(1)
        @JvmStatic
        fun addPose(builder: FlatBufferBuilder, pose: UByte) = builder.addByte(0, pose.toByte(), 0)
        @JvmStatic
        fun endDetectStayAlignedRelaxedPoseRequest(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
