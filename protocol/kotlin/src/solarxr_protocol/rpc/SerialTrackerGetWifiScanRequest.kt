// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

/**
 * Sends the GET WIFISCAN cmd to the current tracker on the serial monitor
 */
@Suppress("unused")
class SerialTrackerGetWifiScanRequest : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : SerialTrackerGetWifiScanRequest {
        __init(_i, _bb)
        return this
    }
    companion object {
        @JvmStatic
        fun validateVersion() = Constants.FLATBUFFERS_22_10_26()
        @JvmStatic
        fun getRootAsSerialTrackerGetWifiScanRequest(_bb: ByteBuffer): SerialTrackerGetWifiScanRequest = getRootAsSerialTrackerGetWifiScanRequest(_bb, SerialTrackerGetWifiScanRequest())
        @JvmStatic
        fun getRootAsSerialTrackerGetWifiScanRequest(_bb: ByteBuffer, obj: SerialTrackerGetWifiScanRequest): SerialTrackerGetWifiScanRequest {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        @JvmStatic
        fun startSerialTrackerGetWifiScanRequest(builder: FlatBufferBuilder) = builder.startTable(0)
        @JvmStatic
        fun endSerialTrackerGetWifiScanRequest(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
