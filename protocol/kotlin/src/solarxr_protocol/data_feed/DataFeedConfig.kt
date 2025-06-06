// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.data_feed

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

/**
 * All information related to the configuration of a data feed. This may be sent
 * as part of a `StartFeed`.
 */
@Suppress("unused")
class DataFeedConfig : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : DataFeedConfig {
        __init(_i, _bb)
        return this
    }
    /**
     * Minimum delay in milliseconds between new data updates. This value will be
     * ignored when used for a `PollDataFeed`.
     */
    val minimumTimeSinceLast : UShort
        get() {
            val o = __offset(4)
            return if(o != 0) bb.getShort(o + bb_pos).toUShort() else 0u
        }
    val dataMask : solarxr_protocol.data_feed.device_data.DeviceDataMask? get() = dataMask(solarxr_protocol.data_feed.device_data.DeviceDataMask())
    fun dataMask(obj: solarxr_protocol.data_feed.device_data.DeviceDataMask) : solarxr_protocol.data_feed.device_data.DeviceDataMask? {
        val o = __offset(6)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val syntheticTrackersMask : solarxr_protocol.data_feed.tracker.TrackerDataMask? get() = syntheticTrackersMask(solarxr_protocol.data_feed.tracker.TrackerDataMask())
    fun syntheticTrackersMask(obj: solarxr_protocol.data_feed.tracker.TrackerDataMask) : solarxr_protocol.data_feed.tracker.TrackerDataMask? {
        val o = __offset(8)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val boneMask : Boolean
        get() {
            val o = __offset(10)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val stayAlignedPoseMask : Boolean
        get() {
            val o = __offset(12)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    companion object {
        @JvmStatic
        fun validateVersion() = Constants.FLATBUFFERS_22_10_26()
        @JvmStatic
        fun getRootAsDataFeedConfig(_bb: ByteBuffer): DataFeedConfig = getRootAsDataFeedConfig(_bb, DataFeedConfig())
        @JvmStatic
        fun getRootAsDataFeedConfig(_bb: ByteBuffer, obj: DataFeedConfig): DataFeedConfig {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        @JvmStatic
        fun createDataFeedConfig(builder: FlatBufferBuilder, minimumTimeSinceLast: UShort, dataMaskOffset: Int, syntheticTrackersMaskOffset: Int, boneMask: Boolean, stayAlignedPoseMask: Boolean) : Int {
            builder.startTable(5)
            addSyntheticTrackersMask(builder, syntheticTrackersMaskOffset)
            addDataMask(builder, dataMaskOffset)
            addMinimumTimeSinceLast(builder, minimumTimeSinceLast)
            addStayAlignedPoseMask(builder, stayAlignedPoseMask)
            addBoneMask(builder, boneMask)
            return endDataFeedConfig(builder)
        }
        @JvmStatic
        fun startDataFeedConfig(builder: FlatBufferBuilder) = builder.startTable(5)
        @JvmStatic
        fun addMinimumTimeSinceLast(builder: FlatBufferBuilder, minimumTimeSinceLast: UShort) = builder.addShort(0, minimumTimeSinceLast.toShort(), 0)
        @JvmStatic
        fun addDataMask(builder: FlatBufferBuilder, dataMask: Int) = builder.addOffset(1, dataMask, 0)
        @JvmStatic
        fun addSyntheticTrackersMask(builder: FlatBufferBuilder, syntheticTrackersMask: Int) = builder.addOffset(2, syntheticTrackersMask, 0)
        @JvmStatic
        fun addBoneMask(builder: FlatBufferBuilder, boneMask: Boolean) = builder.addBoolean(3, boneMask, false)
        @JvmStatic
        fun addStayAlignedPoseMask(builder: FlatBufferBuilder, stayAlignedPoseMask: Boolean) = builder.addBoolean(4, stayAlignedPoseMask, false)
        @JvmStatic
        fun endDataFeedConfig(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
