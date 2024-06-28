// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.datatypes

/**
 * Used for filtering tracker rotations in software
 */
@Suppress("unused")
class FilteringType private constructor() {
    companion object {
        const val NONE: UByte = 0u
        const val SMOOTHING: UByte = 1u
        const val PREDICTION: UByte = 2u
        val names : Array<String> = arrayOf("NONE", "SMOOTHING", "PREDICTION")
        @JvmStatic
        fun name(e: Int) : String = names[e]
    }
}
