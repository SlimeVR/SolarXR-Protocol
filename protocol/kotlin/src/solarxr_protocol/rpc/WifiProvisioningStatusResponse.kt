// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
class WifiProvisioningStatusResponse : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : WifiProvisioningStatusResponse {
        __init(_i, _bb)
        return this
    }
    val status : UByte
        get() {
            val o = __offset(4)
            return if(o != 0) bb.get(o + bb_pos).toUByte() else 0u
        }
    companion object {
        @JvmStatic
        fun validateVersion() = Constants.FLATBUFFERS_22_10_26()
        @JvmStatic
        fun getRootAsWifiProvisioningStatusResponse(_bb: ByteBuffer): WifiProvisioningStatusResponse = getRootAsWifiProvisioningStatusResponse(_bb, WifiProvisioningStatusResponse())
        @JvmStatic
        fun getRootAsWifiProvisioningStatusResponse(_bb: ByteBuffer, obj: WifiProvisioningStatusResponse): WifiProvisioningStatusResponse {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        @JvmStatic
        fun createWifiProvisioningStatusResponse(builder: FlatBufferBuilder, status: UByte) : Int {
            builder.startTable(1)
            addStatus(builder, status)
            return endWifiProvisioningStatusResponse(builder)
        }
        @JvmStatic
        fun startWifiProvisioningStatusResponse(builder: FlatBufferBuilder) = builder.startTable(1)
        @JvmStatic
        fun addStatus(builder: FlatBufferBuilder, status: UByte) = builder.addByte(0, status.toByte(), 0)
        @JvmStatic
        fun endWifiProvisioningStatusResponse(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
