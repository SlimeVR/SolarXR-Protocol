// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
class SerialDevicePort : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : SerialDevicePort {
        __init(_i, _bb)
        return this
    }
    val port : String?
        get() {
            val o = __offset(4)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val portAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(4, 1)
    fun portInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 4, 1)
    companion object {
        @JvmStatic
        fun validateVersion() = Constants.FLATBUFFERS_22_10_26()
        @JvmStatic
        fun getRootAsSerialDevicePort(_bb: ByteBuffer): SerialDevicePort = getRootAsSerialDevicePort(_bb, SerialDevicePort())
        @JvmStatic
        fun getRootAsSerialDevicePort(_bb: ByteBuffer, obj: SerialDevicePort): SerialDevicePort {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        @JvmStatic
        fun createSerialDevicePort(builder: FlatBufferBuilder, portOffset: Int) : Int {
            builder.startTable(1)
            addPort(builder, portOffset)
            return endSerialDevicePort(builder)
        }
        @JvmStatic
        fun startSerialDevicePort(builder: FlatBufferBuilder) = builder.startTable(1)
        @JvmStatic
        fun addPort(builder: FlatBufferBuilder, port: Int) = builder.addOffset(0, port, 0)
        @JvmStatic
        fun endSerialDevicePort(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
