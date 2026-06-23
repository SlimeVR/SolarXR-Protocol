package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.collections.List
import solarxr_protocol.datatypes.BodyPart

public enum class SkeletonBone(
  public val `value`: UByte,
) {
  NONE(0.toUByte()),
  HEAD(1.toUByte()),
  NECK(2.toUByte()),
  CHEST(3.toUByte()),
  CHEST_OFFSET(4.toUByte()),
  WAIST(5.toUByte()),
  HIP(6.toUByte()),
  HIP_OFFSET(7.toUByte()),
  HIPS_WIDTH(8.toUByte()),
  UPPER_LEG(9.toUByte()),
  LOWER_LEG(10.toUByte()),
  FOOT_LENGTH(11.toUByte()),
  FOOT_SHIFT(12.toUByte()),
  SKELETON_OFFSET(13.toUByte()),
  SHOULDERS_DISTANCE(14.toUByte()),
  SHOULDERS_WIDTH(15.toUByte()),
  UPPER_ARM(16.toUByte()),
  LOWER_ARM(17.toUByte()),
  HAND_Y(18.toUByte()),
  HAND_Z(19.toUByte()),
  ELBOW_OFFSET(20.toUByte()),
  UPPER_CHEST(21.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): SkeletonBone? = entries.firstOrNull { it.value == value }
  }
}

public data class SkeletonPart(
  public val bone: SkeletonBone? = null,
  public val `value`: Float? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (bone != null) { builder.forceDefaults(true); builder.addByte(0, bone.value.toByte(), 0); builder.forceDefaults(false) }
    if (value != null) { builder.forceDefaults(true); builder.addFloat(1, value, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SkeletonPart {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bone = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_value = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return SkeletonPart(
              bone = if (__offset_bone != 0) SkeletonBone.fromValue(bb.get(tableOffset + __offset_bone).toUByte()) else null,
              value = if (__offset_value != 0) bb.getFloat(tableOffset + __offset_value) else null
          )
    }
  }
}

public class SkeletonConfigRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SkeletonConfigRequest = SkeletonConfigRequest()
  }
}

public data class SkeletonConfigResponse(
  public val skeletonParts: List<SkeletonPart>? = null,
  public val userHeight: Float? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_skeletonParts = skeletonParts?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(2)
    __off_skeletonParts?.let { builder.addOffset(0, it, 0) }
    if (userHeight != null) { builder.forceDefaults(true); builder.addFloat(1, userHeight, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SkeletonConfigResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_skeletonParts = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_userHeight = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return SkeletonConfigResponse(
              skeletonParts = if (__offset_skeletonParts != 0) { val vecOff = tableOffset + __offset_skeletonParts + bb.getInt(tableOffset + __offset_skeletonParts); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) SkeletonPart.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null,
              userHeight = if (__offset_userHeight != 0) bb.getFloat(tableOffset + __offset_userHeight) else null
          )
    }
  }
}

public class SkeletonResetAllRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SkeletonResetAllRequest = SkeletonResetAllRequest()
  }
}

public data class ChangeSkeletonConfigRequest(
  public val bone: SkeletonBone? = null,
  public val `value`: Float? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (bone != null) { builder.forceDefaults(true); builder.addByte(0, bone.value.toByte(), 0); builder.forceDefaults(false) }
    if (value != null) { builder.forceDefaults(true); builder.addFloat(1, value, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeSkeletonConfigRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bone = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_value = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return ChangeSkeletonConfigRequest(
              bone = if (__offset_bone != 0) SkeletonBone.fromValue(bb.get(tableOffset + __offset_bone).toUByte()) else null,
              value = if (__offset_value != 0) bb.getFloat(tableOffset + __offset_value) else null
          )
    }
  }
}

/**
 * Makes a temporary change to legtweaks. This is not saved to disk, and can be
 * cleared with `LegTweaksTmpClear`
 */
public data class LegTweaksTmpChange(
  public val floorClip: Boolean? = null,
  public val skatingCorrection: Boolean? = null,
  public val toeSnap: Boolean? = null,
  public val footPlant: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(4)
    if (floorClip != null) { builder.forceDefaults(true); builder.addBoolean(0, floorClip, false); builder.forceDefaults(false) }
    if (skatingCorrection != null) { builder.forceDefaults(true); builder.addBoolean(1, skatingCorrection, false); builder.forceDefaults(false) }
    if (toeSnap != null) { builder.forceDefaults(true); builder.addBoolean(2, toeSnap, false); builder.forceDefaults(false) }
    if (footPlant != null) { builder.forceDefaults(true); builder.addBoolean(3, footPlant, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): LegTweaksTmpChange {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_floorClip = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_skatingCorrection = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_toeSnap = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_footPlant = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return LegTweaksTmpChange(
              floorClip = if (__offset_floorClip != 0) bb.get(tableOffset + __offset_floorClip) != 0.toByte() else null,
              skatingCorrection = if (__offset_skatingCorrection != 0) bb.get(tableOffset + __offset_skatingCorrection) != 0.toByte() else null,
              toeSnap = if (__offset_toeSnap != 0) bb.get(tableOffset + __offset_toeSnap) != 0.toByte() else null,
              footPlant = if (__offset_footPlant != 0) bb.get(tableOffset + __offset_footPlant) != 0.toByte() else null
          )
    }
  }
}

/**
 * Clears the legtweaks temporary state back to what the config has.
 * Setting a field to `true` will reset that field.
 */
public data class LegTweaksTmpClear(
  public val floorClip: Boolean = false,
  public val skatingCorrection: Boolean = false,
  public val toeSnap: Boolean = false,
  public val footPlant: Boolean = false,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(4)
    builder.addBoolean(0, floorClip, false)
    builder.addBoolean(1, skatingCorrection, false)
    builder.addBoolean(2, toeSnap, false)
    builder.addBoolean(3, footPlant, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): LegTweaksTmpClear {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_floorClip = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_skatingCorrection = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_toeSnap = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_footPlant = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return LegTweaksTmpClear(
              floorClip = if (__offset_floorClip != 0) bb.get(tableOffset + __offset_floorClip) != 0.toByte() else false,
              skatingCorrection = if (__offset_skatingCorrection != 0) bb.get(tableOffset + __offset_skatingCorrection) != 0.toByte() else false,
              toeSnap = if (__offset_toeSnap != 0) bb.get(tableOffset + __offset_toeSnap) != 0.toByte() else false,
              footPlant = if (__offset_footPlant != 0) bb.get(tableOffset + __offset_footPlant) != 0.toByte() else false
          )
    }
  }
}

public data class SetPauseTrackingRequest(
  public val pauseTracking: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (pauseTracking != null) { builder.forceDefaults(true); builder.addBoolean(0, pauseTracking, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SetPauseTrackingRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_pauseTracking = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return SetPauseTrackingRequest(
              pauseTracking = if (__offset_pauseTracking != 0) bb.get(tableOffset + __offset_pauseTracking) != 0.toByte() else null
          )
    }
  }
}

/**
 * Requests the current state of tracking pause
 */
public class TrackingPauseStateRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackingPauseStateRequest = TrackingPauseStateRequest()
  }
}

public data class TrackingPauseStateResponse(
  public val trackingPaused: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (trackingPaused != null) { builder.forceDefaults(true); builder.addBoolean(0, trackingPaused, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TrackingPauseStateResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_trackingPaused = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TrackingPauseStateResponse(
              trackingPaused = if (__offset_trackingPaused != 0) bb.get(tableOffset + __offset_trackingPaused) != 0.toByte() else null
          )
    }
  }
}

/**
 * Toggles for the skeletal model.
 */
public data class SkeletonToggles(
  public val forceArmsFromHmd: Boolean? = null,
  public val floorClip: Boolean? = null,
  public val skatingCorrection: Boolean? = null,
  public val toeSnap: Boolean? = null,
  public val footPlant: Boolean? = null,
  public val selfLocalization: Boolean? = null,
  public val usePosition: Boolean? = null,
  public val enforceConstraints: Boolean? = null,
  public val correctConstraints: Boolean? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(9)
    if (forceArmsFromHmd != null) { builder.forceDefaults(true); builder.addBoolean(0, forceArmsFromHmd, false); builder.forceDefaults(false) }
    if (floorClip != null) { builder.forceDefaults(true); builder.addBoolean(1, floorClip, false); builder.forceDefaults(false) }
    if (skatingCorrection != null) { builder.forceDefaults(true); builder.addBoolean(2, skatingCorrection, false); builder.forceDefaults(false) }
    if (toeSnap != null) { builder.forceDefaults(true); builder.addBoolean(3, toeSnap, false); builder.forceDefaults(false) }
    if (footPlant != null) { builder.forceDefaults(true); builder.addBoolean(4, footPlant, false); builder.forceDefaults(false) }
    if (selfLocalization != null) { builder.forceDefaults(true); builder.addBoolean(5, selfLocalization, false); builder.forceDefaults(false) }
    if (usePosition != null) { builder.forceDefaults(true); builder.addBoolean(6, usePosition, false); builder.forceDefaults(false) }
    if (enforceConstraints != null) { builder.forceDefaults(true); builder.addBoolean(7, enforceConstraints, false); builder.forceDefaults(false) }
    if (correctConstraints != null) { builder.forceDefaults(true); builder.addBoolean(8, correctConstraints, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SkeletonToggles {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_forceArmsFromHmd = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_floorClip = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_skatingCorrection = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_toeSnap = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_footPlant = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_selfLocalization = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_usePosition = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_enforceConstraints = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_correctConstraints = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0

      return SkeletonToggles(
              forceArmsFromHmd = if (__offset_forceArmsFromHmd != 0) bb.get(tableOffset + __offset_forceArmsFromHmd) != 0.toByte() else null,
              floorClip = if (__offset_floorClip != 0) bb.get(tableOffset + __offset_floorClip) != 0.toByte() else null,
              skatingCorrection = if (__offset_skatingCorrection != 0) bb.get(tableOffset + __offset_skatingCorrection) != 0.toByte() else null,
              toeSnap = if (__offset_toeSnap != 0) bb.get(tableOffset + __offset_toeSnap) != 0.toByte() else null,
              footPlant = if (__offset_footPlant != 0) bb.get(tableOffset + __offset_footPlant) != 0.toByte() else null,
              selfLocalization = if (__offset_selfLocalization != 0) bb.get(tableOffset + __offset_selfLocalization) != 0.toByte() else null,
              usePosition = if (__offset_usePosition != 0) bb.get(tableOffset + __offset_usePosition) != 0.toByte() else null,
              enforceConstraints = if (__offset_enforceConstraints != 0) bb.get(tableOffset + __offset_enforceConstraints) != 0.toByte() else null,
              correctConstraints = if (__offset_correctConstraints != 0) bb.get(tableOffset + __offset_correctConstraints) != 0.toByte() else null
          )
    }
  }
}

/**
 * Ratios for the skeletal model. Accepted values for them range from 0 to 1
 */
public data class SkeletonRatios(
  public val imputeSpineFromUpperLower: Float? = null,
  public val imputeSpineCurvature: Float? = null,
  public val interpHipLegs: Float? = null,
  public val interpKneeTrackerAnkle: Float? = null,
  public val interpKneeAnkle: Float? = null,
  public val skatingCorrectionStrength: Float? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(6)
    if (imputeSpineFromUpperLower != null) { builder.forceDefaults(true); builder.addFloat(0, imputeSpineFromUpperLower, 0.0); builder.forceDefaults(false) }
    if (imputeSpineCurvature != null) { builder.forceDefaults(true); builder.addFloat(1, imputeSpineCurvature, 0.0); builder.forceDefaults(false) }
    if (interpHipLegs != null) { builder.forceDefaults(true); builder.addFloat(2, interpHipLegs, 0.0); builder.forceDefaults(false) }
    if (interpKneeTrackerAnkle != null) { builder.forceDefaults(true); builder.addFloat(3, interpKneeTrackerAnkle, 0.0); builder.forceDefaults(false) }
    if (interpKneeAnkle != null) { builder.forceDefaults(true); builder.addFloat(4, interpKneeAnkle, 0.0); builder.forceDefaults(false) }
    if (skatingCorrectionStrength != null) { builder.forceDefaults(true); builder.addFloat(5, skatingCorrectionStrength, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SkeletonRatios {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_imputeSpineFromUpperLower = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_imputeSpineCurvature = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_interpHipLegs = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_interpKneeTrackerAnkle = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_interpKneeAnkle = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_skatingCorrectionStrength = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0

      return SkeletonRatios(
              imputeSpineFromUpperLower = if (__offset_imputeSpineFromUpperLower != 0) bb.getFloat(tableOffset + __offset_imputeSpineFromUpperLower) else null,
              imputeSpineCurvature = if (__offset_imputeSpineCurvature != 0) bb.getFloat(tableOffset + __offset_imputeSpineCurvature) else null,
              interpHipLegs = if (__offset_interpHipLegs != 0) bb.getFloat(tableOffset + __offset_interpHipLegs) else null,
              interpKneeTrackerAnkle = if (__offset_interpKneeTrackerAnkle != 0) bb.getFloat(tableOffset + __offset_interpKneeTrackerAnkle) else null,
              interpKneeAnkle = if (__offset_interpKneeAnkle != 0) bb.getFloat(tableOffset + __offset_interpKneeAnkle) else null,
              skatingCorrectionStrength = if (__offset_skatingCorrectionStrength != 0) bb.getFloat(tableOffset + __offset_skatingCorrectionStrength) else null
          )
    }
  }
}

public enum class FilteringType(
  public val `value`: UByte,
) {
  NONE(0.toUByte()),
  SMOOTHING(1.toUByte()),
  PREDICTION(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): FilteringType? = entries.firstOrNull { it.value == value }
  }
}

/**
 * Filtering (e.g smoothing) applied to the skeleton's movements
 */
public data class SkeletonFiltering(
  public val type: FilteringType? = null,
  public val amount: Float? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (type != null) { builder.forceDefaults(true); builder.addByte(0, type.value.toByte(), 0); builder.forceDefaults(false) }
    if (amount != null) { builder.forceDefaults(true); builder.addFloat(1, amount, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SkeletonFiltering {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_type = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_amount = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return SkeletonFiltering(
              type = if (__offset_type != 0) FilteringType.fromValue(bb.get(tableOffset + __offset_type).toUByte()) else null,
              amount = if (__offset_amount != 0) bb.getFloat(tableOffset + __offset_amount) else null
          )
    }
  }
}

/**
 * Data used to compute the skeleton's height.
 */
public data class SkeletonHeight(
  public val hmdHeight: Float? = null,
  public val floorHeight: Float? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    if (hmdHeight != null) { builder.forceDefaults(true); builder.addFloat(0, hmdHeight, 0.0); builder.forceDefaults(false) }
    if (floorHeight != null) { builder.forceDefaults(true); builder.addFloat(1, floorHeight, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SkeletonHeight {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_hmdHeight = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_floorHeight = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return SkeletonHeight(
              hmdHeight = if (__offset_hmdHeight != 0) bb.getFloat(tableOffset + __offset_hmdHeight) else null,
              floorHeight = if (__offset_floorHeight != 0) bb.getFloat(tableOffset + __offset_floorHeight) else null
          )
    }
  }
}

public class SkeletonSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SkeletonSettingsRequest = SkeletonSettingsRequest()
  }
}

public data class SkeletonSettingsResponse(
  public val toggles: SkeletonToggles? = null,
  public val ratios: SkeletonRatios? = null,
  public val filtering: SkeletonFiltering? = null,
  public val skeletonHeight: SkeletonHeight? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_toggles = toggles?.encode(builder)
    val __off_ratios = ratios?.encode(builder)
    val __off_filtering = filtering?.encode(builder)
    val __off_skeletonHeight = skeletonHeight?.encode(builder)

    builder.startTable(4)
    __off_toggles?.let { builder.addOffset(0, it, 0) }
    __off_ratios?.let { builder.addOffset(1, it, 0) }
    __off_filtering?.let { builder.addOffset(2, it, 0) }
    __off_skeletonHeight?.let { builder.addOffset(3, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): SkeletonSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_toggles = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_ratios = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_filtering = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_skeletonHeight = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return SkeletonSettingsResponse(
              toggles = if (__offset_toggles != 0) SkeletonToggles.decode(bb, tableOffset + __offset_toggles + bb.getInt(tableOffset + __offset_toggles)) else null,
              ratios = if (__offset_ratios != 0) SkeletonRatios.decode(bb, tableOffset + __offset_ratios + bb.getInt(tableOffset + __offset_ratios)) else null,
              filtering = if (__offset_filtering != 0) SkeletonFiltering.decode(bb, tableOffset + __offset_filtering + bb.getInt(tableOffset + __offset_filtering)) else null,
              skeletonHeight = if (__offset_skeletonHeight != 0) SkeletonHeight.decode(bb, tableOffset + __offset_skeletonHeight + bb.getInt(tableOffset + __offset_skeletonHeight)) else null
          )
    }
  }
}

public data class ChangeSkeletonSettingsRequest(
  public val toggles: SkeletonToggles? = null,
  public val ratios: SkeletonRatios? = null,
  public val filtering: SkeletonFiltering? = null,
  public val skeletonHeight: SkeletonHeight? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_toggles = toggles?.encode(builder)
    val __off_ratios = ratios?.encode(builder)
    val __off_filtering = filtering?.encode(builder)
    val __off_skeletonHeight = skeletonHeight?.encode(builder)

    builder.startTable(4)
    __off_toggles?.let { builder.addOffset(0, it, 0) }
    __off_ratios?.let { builder.addOffset(1, it, 0) }
    __off_filtering?.let { builder.addOffset(2, it, 0) }
    __off_skeletonHeight?.let { builder.addOffset(3, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeSkeletonSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_toggles = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_ratios = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_filtering = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_skeletonHeight = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return ChangeSkeletonSettingsRequest(
              toggles = if (__offset_toggles != 0) SkeletonToggles.decode(bb, tableOffset + __offset_toggles + bb.getInt(tableOffset + __offset_toggles)) else null,
              ratios = if (__offset_ratios != 0) SkeletonRatios.decode(bb, tableOffset + __offset_ratios + bb.getInt(tableOffset + __offset_ratios)) else null,
              filtering = if (__offset_filtering != 0) SkeletonFiltering.decode(bb, tableOffset + __offset_filtering + bb.getInt(tableOffset + __offset_filtering)) else null,
              skeletonHeight = if (__offset_skeletonHeight != 0) SkeletonHeight.decode(bb, tableOffset + __offset_skeletonHeight + bb.getInt(tableOffset + __offset_skeletonHeight)) else null
          )
    }
  }
}

public class OutputTrackersSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OutputTrackersSettingsRequest = OutputTrackersSettingsRequest()
  }
}

public data class OutputTrackersSettingsResponse(
  public val automaticTrackerToggle: Boolean? = null,
  public val trackers: List<BodyPart>? = null,
  public val sendDerivedVelocity: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackers = trackers?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }

    builder.startTable(3)
    if (automaticTrackerToggle != null) { builder.forceDefaults(true); builder.addBoolean(0, automaticTrackerToggle, false); builder.forceDefaults(false) }
    __off_trackers?.let { builder.addOffset(1, it, 0) }
    if (sendDerivedVelocity != null) { builder.forceDefaults(true); builder.addBoolean(2, sendDerivedVelocity, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OutputTrackersSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_automaticTrackerToggle = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_trackers = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_sendDerivedVelocity = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return OutputTrackersSettingsResponse(
              automaticTrackerToggle = if (__offset_automaticTrackerToggle != 0) bb.get(tableOffset + __offset_automaticTrackerToggle) != 0.toByte() else null,
              trackers = if (__offset_trackers != 0) { val vecOff = tableOffset + __offset_trackers + bb.getInt(tableOffset + __offset_trackers); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> BodyPart.fromValue(bb.get(vecOff + 4 + i * 1).toUByte()) } } else null,
              sendDerivedVelocity = if (__offset_sendDerivedVelocity != 0) bb.get(tableOffset + __offset_sendDerivedVelocity) != 0.toByte() else null
          )
    }
  }
}

public data class ChangeOutputTrackersSettingsRequest(
  public val automaticTrackerToggle: Boolean? = null,
  public val trackers: List<BodyPart>? = null,
  public val sendDerivedVelocity: Boolean? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackers = trackers?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }

    builder.startTable(3)
    if (automaticTrackerToggle != null) { builder.forceDefaults(true); builder.addBoolean(0, automaticTrackerToggle, false); builder.forceDefaults(false) }
    __off_trackers?.let { builder.addOffset(1, it, 0) }
    if (sendDerivedVelocity != null) { builder.forceDefaults(true); builder.addBoolean(2, sendDerivedVelocity, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeOutputTrackersSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_automaticTrackerToggle = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_trackers = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_sendDerivedVelocity = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return ChangeOutputTrackersSettingsRequest(
              automaticTrackerToggle = if (__offset_automaticTrackerToggle != 0) bb.get(tableOffset + __offset_automaticTrackerToggle) != 0.toByte() else null,
              trackers = if (__offset_trackers != 0) { val vecOff = tableOffset + __offset_trackers + bb.getInt(tableOffset + __offset_trackers); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> BodyPart.fromValue(bb.get(vecOff + 4 + i * 1).toUByte()) } } else null,
              sendDerivedVelocity = if (__offset_sendDerivedVelocity != 0) bb.get(tableOffset + __offset_sendDerivedVelocity) != 0.toByte() else null
          )
    }
  }
}
