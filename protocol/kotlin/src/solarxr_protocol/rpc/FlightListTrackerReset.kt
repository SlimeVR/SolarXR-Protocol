// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

/**
 * Trackers that need a reset
 */
@Suppress("unused")
class FlightListTrackerReset : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : FlightListTrackerReset {
        __init(_i, _bb)
        return this
    }
    fun trackersId(j: Int) : solarxr_protocol.datatypes.TrackerId? = trackersId(solarxr_protocol.datatypes.TrackerId(), j)
    fun trackersId(obj: solarxr_protocol.datatypes.TrackerId, j: Int) : solarxr_protocol.datatypes.TrackerId? {
        val o = __offset(4)
        return if (o != 0) {
            obj.__assign(__indirect(__vector(o) + j * 4), bb)
        } else {
            null
        }
    }
    val trackersIdLength : Int
        get() {
            val o = __offset(4); return if (o != 0) __vector_len(o) else 0
        }
    companion object {
        @JvmStatic
        fun validateVersion() = Constants.FLATBUFFERS_22_10_26()
        @JvmStatic
        fun getRootAsFlightListTrackerReset(_bb: ByteBuffer): FlightListTrackerReset = getRootAsFlightListTrackerReset(_bb, FlightListTrackerReset())
        @JvmStatic
        fun getRootAsFlightListTrackerReset(_bb: ByteBuffer, obj: FlightListTrackerReset): FlightListTrackerReset {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        @JvmStatic
        fun createFlightListTrackerReset(builder: FlatBufferBuilder, trackersIdOffset: Int) : Int {
            builder.startTable(1)
            addTrackersId(builder, trackersIdOffset)
            return endFlightListTrackerReset(builder)
        }
        @JvmStatic
        fun startFlightListTrackerReset(builder: FlatBufferBuilder) = builder.startTable(1)
        @JvmStatic
        fun addTrackersId(builder: FlatBufferBuilder, trackersId: Int) = builder.addOffset(0, trackersId, 0)
        @JvmStatic
        fun createTrackersIdVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addOffset(data[i])
            }
            return builder.endVector()
        }
        @JvmStatic
        fun startTrackersIdVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        @JvmStatic
        fun endFlightListTrackerReset(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
