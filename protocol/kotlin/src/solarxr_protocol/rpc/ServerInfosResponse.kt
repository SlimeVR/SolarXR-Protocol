// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

/**
 * Holds the Server information, this is a basic table holding various information about the currently running server
 * like its local ip address (useful for standalone users so they can specify the ip of the server more easily) and any more
 * infos we might want to add in the future. (like java version, working dir, server version ....)
 * This only holds the local ip for now. But there will be other information added as we chose to display them on the gui for instance
 */
@Suppress("unused")
class ServerInfosResponse : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : ServerInfosResponse {
        __init(_i, _bb)
        return this
    }
    val localIp : String?
        get() {
            val o = __offset(4)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val localIpAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(4, 1)
    fun localIpInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 4, 1)
    companion object {
        @JvmStatic
        fun validateVersion() = Constants.FLATBUFFERS_22_10_26()
        @JvmStatic
        fun getRootAsServerInfosResponse(_bb: ByteBuffer): ServerInfosResponse = getRootAsServerInfosResponse(_bb, ServerInfosResponse())
        @JvmStatic
        fun getRootAsServerInfosResponse(_bb: ByteBuffer, obj: ServerInfosResponse): ServerInfosResponse {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        @JvmStatic
        fun createServerInfosResponse(builder: FlatBufferBuilder, localIpOffset: Int) : Int {
            builder.startTable(1)
            addLocalIp(builder, localIpOffset)
            return endServerInfosResponse(builder)
        }
        @JvmStatic
        fun startServerInfosResponse(builder: FlatBufferBuilder) = builder.startTable(1)
        @JvmStatic
        fun addLocalIp(builder: FlatBufferBuilder, localIp: Int) = builder.addOffset(0, localIp, 0)
        @JvmStatic
        fun endServerInfosResponse(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
