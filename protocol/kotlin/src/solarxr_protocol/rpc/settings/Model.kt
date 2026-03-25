package solarxr_protocol.rpc.settings

import com.google.flatbuffers.FlatBufferBuilder
import java.nio.ByteBuffer
import kotlin.Boolean
import kotlin.Float
import kotlin.Int

/**
 * Settings for the skeletal model that are toggles.
 */
data class ModelToggles(
  val extendedSpine: Boolean? = null,
  val extendedPelvis: Boolean? = null,
  val extendedKnee: Boolean? = null,
  val forceArmsFromHmd: Boolean? = null,
  val floorClip: Boolean? = null,
  val skatingCorrection: Boolean? = null,
  val viveEmulation: Boolean? = null,
  val toeSnap: Boolean? = null,
  val footPlant: Boolean? = null,
  val selfLocalization: Boolean? = null,
  val usePosition: Boolean? = null,
  val enforceConstraints: Boolean? = null,
  val correctConstraints: Boolean? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(13)
    if (extendedSpine != null) { builder.forceDefaults(true); builder.addBoolean(0, extendedSpine, false); builder.forceDefaults(false) }
    if (extendedPelvis != null) { builder.forceDefaults(true); builder.addBoolean(1, extendedPelvis, false); builder.forceDefaults(false) }
    if (extendedKnee != null) { builder.forceDefaults(true); builder.addBoolean(2, extendedKnee, false); builder.forceDefaults(false) }
    if (forceArmsFromHmd != null) { builder.forceDefaults(true); builder.addBoolean(3, forceArmsFromHmd, false); builder.forceDefaults(false) }
    if (floorClip != null) { builder.forceDefaults(true); builder.addBoolean(4, floorClip, false); builder.forceDefaults(false) }
    if (skatingCorrection != null) { builder.forceDefaults(true); builder.addBoolean(5, skatingCorrection, false); builder.forceDefaults(false) }
    if (viveEmulation != null) { builder.forceDefaults(true); builder.addBoolean(6, viveEmulation, false); builder.forceDefaults(false) }
    if (toeSnap != null) { builder.forceDefaults(true); builder.addBoolean(7, toeSnap, false); builder.forceDefaults(false) }
    if (footPlant != null) { builder.forceDefaults(true); builder.addBoolean(8, footPlant, false); builder.forceDefaults(false) }
    if (selfLocalization != null) { builder.forceDefaults(true); builder.addBoolean(9, selfLocalization, false); builder.forceDefaults(false) }
    if (usePosition != null) { builder.forceDefaults(true); builder.addBoolean(10, usePosition, false); builder.forceDefaults(false) }
    if (enforceConstraints != null) { builder.forceDefaults(true); builder.addBoolean(11, enforceConstraints, false); builder.forceDefaults(false) }
    if (correctConstraints != null) { builder.forceDefaults(true); builder.addBoolean(12, correctConstraints, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): ModelToggles {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_extendedSpine = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_extendedPelvis = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_extendedKnee = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_forceArmsFromHmd = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_floorClip = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_skatingCorrection = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_viveEmulation = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_toeSnap = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_footPlant = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_selfLocalization = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_usePosition = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_enforceConstraints = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0
      val __offset_correctConstraints = if (vtableSize > 28) bb.getShort(vtableOffset + 28).toInt() else 0

      return ModelToggles(
              extendedSpine = if (__offset_extendedSpine != 0) bb.get(tableOffset + __offset_extendedSpine) != 0.toByte() else null,
              extendedPelvis = if (__offset_extendedPelvis != 0) bb.get(tableOffset + __offset_extendedPelvis) != 0.toByte() else null,
              extendedKnee = if (__offset_extendedKnee != 0) bb.get(tableOffset + __offset_extendedKnee) != 0.toByte() else null,
              forceArmsFromHmd = if (__offset_forceArmsFromHmd != 0) bb.get(tableOffset + __offset_forceArmsFromHmd) != 0.toByte() else null,
              floorClip = if (__offset_floorClip != 0) bb.get(tableOffset + __offset_floorClip) != 0.toByte() else null,
              skatingCorrection = if (__offset_skatingCorrection != 0) bb.get(tableOffset + __offset_skatingCorrection) != 0.toByte() else null,
              viveEmulation = if (__offset_viveEmulation != 0) bb.get(tableOffset + __offset_viveEmulation) != 0.toByte() else null,
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
data class ModelRatios(
  val imputeWaistFromChestHip: Float? = null,
  val imputeWaistFromChestLegs: Float? = null,
  val imputeHipFromChestLegs: Float? = null,
  val imputeHipFromWaistLegs: Float? = null,
  val interpHipLegs: Float? = null,
  val interpKneeTrackerAnkle: Float? = null,
  val interpKneeAnkle: Float? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(7)
    if (imputeWaistFromChestHip != null) { builder.forceDefaults(true); builder.addFloat(0, imputeWaistFromChestHip, 0.0); builder.forceDefaults(false) }
    if (imputeWaistFromChestLegs != null) { builder.forceDefaults(true); builder.addFloat(1, imputeWaistFromChestLegs, 0.0); builder.forceDefaults(false) }
    if (imputeHipFromChestLegs != null) { builder.forceDefaults(true); builder.addFloat(2, imputeHipFromChestLegs, 0.0); builder.forceDefaults(false) }
    if (imputeHipFromWaistLegs != null) { builder.forceDefaults(true); builder.addFloat(3, imputeHipFromWaistLegs, 0.0); builder.forceDefaults(false) }
    if (interpHipLegs != null) { builder.forceDefaults(true); builder.addFloat(4, interpHipLegs, 0.0); builder.forceDefaults(false) }
    if (interpKneeTrackerAnkle != null) { builder.forceDefaults(true); builder.addFloat(5, interpKneeTrackerAnkle, 0.0); builder.forceDefaults(false) }
    if (interpKneeAnkle != null) { builder.forceDefaults(true); builder.addFloat(6, interpKneeAnkle, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): ModelRatios {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_imputeWaistFromChestHip = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_imputeWaistFromChestLegs = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_imputeHipFromChestLegs = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_imputeHipFromWaistLegs = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_interpHipLegs = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_interpKneeTrackerAnkle = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_interpKneeAnkle = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0

      return ModelRatios(
              imputeWaistFromChestHip = if (__offset_imputeWaistFromChestHip != 0) bb.getFloat(tableOffset + __offset_imputeWaistFromChestHip) else null,
              imputeWaistFromChestLegs = if (__offset_imputeWaistFromChestLegs != 0) bb.getFloat(tableOffset + __offset_imputeWaistFromChestLegs) else null,
              imputeHipFromChestLegs = if (__offset_imputeHipFromChestLegs != 0) bb.getFloat(tableOffset + __offset_imputeHipFromChestLegs) else null,
              imputeHipFromWaistLegs = if (__offset_imputeHipFromWaistLegs != 0) bb.getFloat(tableOffset + __offset_imputeHipFromWaistLegs) else null,
              interpHipLegs = if (__offset_interpHipLegs != 0) bb.getFloat(tableOffset + __offset_interpHipLegs) else null,
              interpKneeTrackerAnkle = if (__offset_interpKneeTrackerAnkle != 0) bb.getFloat(tableOffset + __offset_interpKneeTrackerAnkle) else null,
              interpKneeAnkle = if (__offset_interpKneeAnkle != 0) bb.getFloat(tableOffset + __offset_interpKneeAnkle) else null
          )
    }
  }
}

data class LegTweaksSettings(
  val correctionStrength: Float? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(1)
    if (correctionStrength != null) { builder.forceDefaults(true); builder.addFloat(0, correctionStrength, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): LegTweaksSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_correctionStrength = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return LegTweaksSettings(
              correctionStrength = if (__offset_correctionStrength != 0) bb.getFloat(tableOffset + __offset_correctionStrength) else null
          )
    }
  }
}

data class SkeletonHeight(
  val hmdHeight: Float? = null,
  val floorHeight: Float? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(2)
    if (hmdHeight != null) { builder.forceDefaults(true); builder.addFloat(0, hmdHeight, 0.0); builder.forceDefaults(false) }
    if (floorHeight != null) { builder.forceDefaults(true); builder.addFloat(1, floorHeight, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): SkeletonHeight {
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
data class ModelSettings(
  val toggles: ModelToggles? = null,
  val ratios: ModelRatios? = null,
  val legTweaks: LegTweaksSettings? = null,
  val skeletonHeight: SkeletonHeight? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {
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

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): ModelSettings {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_toggles = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_ratios = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_legTweaks = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_skeletonHeight = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return ModelSettings(
              toggles = if (__offset_toggles != 0) solarxr_protocol.rpc.settings.ModelToggles.decode(bb, tableOffset + __offset_toggles + bb.getInt(tableOffset + __offset_toggles)) else null,
              ratios = if (__offset_ratios != 0) solarxr_protocol.rpc.settings.ModelRatios.decode(bb, tableOffset + __offset_ratios + bb.getInt(tableOffset + __offset_ratios)) else null,
              legTweaks = if (__offset_legTweaks != 0) solarxr_protocol.rpc.settings.LegTweaksSettings.decode(bb, tableOffset + __offset_legTweaks + bb.getInt(tableOffset + __offset_legTweaks)) else null,
              skeletonHeight = if (__offset_skeletonHeight != 0) solarxr_protocol.rpc.settings.SkeletonHeight.decode(bb, tableOffset + __offset_skeletonHeight + bb.getInt(tableOffset + __offset_skeletonHeight)) else null
          )
    }
  }
}
