package solarxr_protocol.rpc.settings

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Float
import kotlin.Int

/**
 * Settings for the skeletal model that are toggles.
 */
public data class ModelToggles(
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
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ModelToggles {
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

      return ModelToggles(
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
 * Settings for the skeletal model that are ratios.
 * These values range from 0 to 1.
 */
public data class ModelRatios(
  public val imputeSpineFromTopDown: Float? = null,
  public val imputeSpineCurvature: Float? = null,
  public val interpHipLegs: Float? = null,
  public val interpKneeTrackerAnkle: Float? = null,
  public val interpKneeAnkle: Float? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(5)
    if (imputeSpineFromTopDown != null) { builder.forceDefaults(true); builder.addFloat(0, imputeSpineFromTopDown, 0.0); builder.forceDefaults(false) }
    if (imputeSpineCurvature != null) { builder.forceDefaults(true); builder.addFloat(1, imputeSpineCurvature, 0.0); builder.forceDefaults(false) }
    if (interpHipLegs != null) { builder.forceDefaults(true); builder.addFloat(2, interpHipLegs, 0.0); builder.forceDefaults(false) }
    if (interpKneeTrackerAnkle != null) { builder.forceDefaults(true); builder.addFloat(3, interpKneeTrackerAnkle, 0.0); builder.forceDefaults(false) }
    if (interpKneeAnkle != null) { builder.forceDefaults(true); builder.addFloat(4, interpKneeAnkle, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ModelRatios {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_imputeSpineFromTopDown = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_imputeSpineCurvature = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_interpHipLegs = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_interpKneeTrackerAnkle = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_interpKneeAnkle = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return ModelRatios(
              imputeSpineFromTopDown = if (__offset_imputeSpineFromTopDown != 0) bb.getFloat(tableOffset + __offset_imputeSpineFromTopDown) else null,
              imputeSpineCurvature = if (__offset_imputeSpineCurvature != 0) bb.getFloat(tableOffset + __offset_imputeSpineCurvature) else null,
              interpHipLegs = if (__offset_interpHipLegs != 0) bb.getFloat(tableOffset + __offset_interpHipLegs) else null,
              interpKneeTrackerAnkle = if (__offset_interpKneeTrackerAnkle != 0) bb.getFloat(tableOffset + __offset_interpKneeTrackerAnkle) else null,
              interpKneeAnkle = if (__offset_interpKneeAnkle != 0) bb.getFloat(tableOffset + __offset_interpKneeAnkle) else null
          )
    }
  }
}

public data class LegTweaksSettings(
  public val correctionStrength: Float? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (correctionStrength != null) { builder.forceDefaults(true); builder.addFloat(0, correctionStrength, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): LegTweaksSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_correctionStrength = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return LegTweaksSettings(
              correctionStrength = if (__offset_correctionStrength != 0) bb.getFloat(tableOffset + __offset_correctionStrength) else null
          )
    }
  }
}

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

/**
 * Settings for the skeletal model.
 */
public data class ModelSettings(
  public val toggles: ModelToggles? = null,
  public val ratios: ModelRatios? = null,
  public val legTweaks: LegTweaksSettings? = null,
  public val skeletonHeight: SkeletonHeight? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_toggles = toggles?.encode(builder)
    val __off_ratios = ratios?.encode(builder)
    val __off_legTweaks = legTweaks?.encode(builder)
    val __off_skeletonHeight = skeletonHeight?.encode(builder)

    builder.startTable(4)
    __off_toggles?.let { builder.addOffset(0, it, 0) }
    __off_ratios?.let { builder.addOffset(1, it, 0) }
    __off_legTweaks?.let { builder.addOffset(2, it, 0) }
    __off_skeletonHeight?.let { builder.addOffset(3, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ModelSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_toggles = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_ratios = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_legTweaks = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_skeletonHeight = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return ModelSettings(
              toggles = if (__offset_toggles != 0) ModelToggles.decode(bb, tableOffset + __offset_toggles + bb.getInt(tableOffset + __offset_toggles)) else null,
              ratios = if (__offset_ratios != 0) ModelRatios.decode(bb, tableOffset + __offset_ratios + bb.getInt(tableOffset + __offset_ratios)) else null,
              legTweaks = if (__offset_legTweaks != 0) LegTweaksSettings.decode(bb, tableOffset + __offset_legTweaks + bb.getInt(tableOffset + __offset_legTweaks)) else null,
              skeletonHeight = if (__offset_skeletonHeight != 0) SkeletonHeight.decode(bb, tableOffset + __offset_skeletonHeight + bb.getInt(tableOffset + __offset_skeletonHeight)) else null
          )
    }
  }
}
