// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc

@Suppress("unused")
class VRCSpineMode private constructor() {
    companion object {
        const val UNKNOWN: UByte = 0u
        const val LOCKHIP: UByte = 1u
        const val LOCKHEAD: UByte = 2u
        const val LOCKBOTH: UByte = 3u
        val names : Array<String> = arrayOf("UNKNOWN", "LOCK_HIP", "LOCK_HEAD", "LOCK_BOTH")
        @JvmStatic
        fun name(e: Int) : String = names[e]
    }
}
