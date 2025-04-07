// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc

@Suppress("unused")
class FlightListExtraData private constructor() {
    companion object {
        const val NONE: UByte = 0u
        const val StatusTrackerReset: UByte = 1u
        const val StatusTrackerError: UByte = 2u
        const val StatusSteamVRDisconnected: UByte = 3u
        const val StatusUnassignedHMD: UByte = 4u
        const val FlightListNeedCalibration: UByte = 5u
        val names : Array<String> = arrayOf("NONE", "StatusTrackerReset", "StatusTrackerError", "StatusSteamVRDisconnected", "StatusUnassignedHMD", "FlightListNeedCalibration")
        @JvmStatic
        fun name(e: Int) : String = names[e]
    }
}
