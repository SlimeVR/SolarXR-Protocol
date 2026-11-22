package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.collections.List
import solarxr_protocol.datatypes.BodyPart

public enum class StayAlignedRelaxedPose(
  public val `value`: UByte,
) {
  UNKNOWN(0.toUByte()),
  STANDING(1.toUByte()),
  SITTING(2.toUByte()),
  FLAT(3.toUByte()),
  KNEELING(4.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): StayAlignedRelaxedPose? = entries.firstOrNull { it.value == value }
  }
}

/**
 * A relaxed pose of the user. Angles are the yaw of the upper legs, lower legs and
 * feet relative to the body, in degrees.
 */
public data class StayAlignedPose(
  public val pose: StayAlignedRelaxedPose = StayAlignedRelaxedPose.UNKNOWN,
  public val recorded: Boolean = false,
  public val hasDefault: Boolean = false,
  public val enabled: Boolean = false,
  public val upperLegAngle: Float = 0.0f,
  public val lowerLegAngle: Float = 0.0f,
  public val footAngle: Float = 0.0f,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(7)
    builder.addByte(0, pose.value.toByte(), 0)
    builder.addBoolean(1, recorded, false)
    builder.addBoolean(2, hasDefault, false)
    builder.addBoolean(3, enabled, false)
    builder.addFloat(4, upperLegAngle, 0.0)
    builder.addFloat(5, lowerLegAngle, 0.0)
    builder.addFloat(6, footAngle, 0.0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StayAlignedPose {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_pose = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_recorded = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_hasDefault = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_enabled = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_upperLegAngle = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_lowerLegAngle = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_footAngle = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0

      return StayAlignedPose(
              pose = if (__offset_pose != 0) StayAlignedRelaxedPose.fromValue(bb.get(tableOffset + __offset_pose).toUByte()) ?: StayAlignedRelaxedPose.UNKNOWN else StayAlignedRelaxedPose.UNKNOWN,
              recorded = if (__offset_recorded != 0) bb.get(tableOffset + __offset_recorded) != 0.toByte() else false,
              hasDefault = if (__offset_hasDefault != 0) bb.get(tableOffset + __offset_hasDefault) != 0.toByte() else false,
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else false,
              upperLegAngle = if (__offset_upperLegAngle != 0) bb.getFloat(tableOffset + __offset_upperLegAngle) else 0.0f,
              lowerLegAngle = if (__offset_lowerLegAngle != 0) bb.getFloat(tableOffset + __offset_lowerLegAngle) else 0.0f,
              footAngle = if (__offset_footAngle != 0) bb.getFloat(tableOffset + __offset_footAngle) else 0.0f
          )
    }
  }
}

public data class StayAlignedPoseToggle(
  public val pose: StayAlignedRelaxedPose = StayAlignedRelaxedPose.UNKNOWN,
  public val enabled: Boolean = false,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    builder.addByte(0, pose.value.toByte(), 0)
    builder.addBoolean(1, enabled, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StayAlignedPoseToggle {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_pose = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_enabled = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return StayAlignedPoseToggle(
              pose = if (__offset_pose != 0) StayAlignedRelaxedPose.fromValue(bb.get(tableOffset + __offset_pose).toUByte()) ?: StayAlignedRelaxedPose.UNKNOWN else StayAlignedRelaxedPose.UNKNOWN,
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else false
          )
    }
  }
}

public data class ResetStayAlignedRelaxedPoseRequest(
  public val pose: StayAlignedRelaxedPose = StayAlignedRelaxedPose.UNKNOWN,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addByte(0, pose.value.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ResetStayAlignedRelaxedPoseRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_pose = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return ResetStayAlignedRelaxedPoseRequest(
              pose = if (__offset_pose != 0) StayAlignedRelaxedPose.fromValue(bb.get(tableOffset + __offset_pose).toUByte()) ?: StayAlignedRelaxedPose.UNKNOWN else StayAlignedRelaxedPose.UNKNOWN
          )
    }
  }
}

public class StayAlignedSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StayAlignedSettingsRequest = StayAlignedSettingsRequest()
  }
}

public data class StayAlignedSettingsResponse(
  public val enabled: Boolean = false,
  public val poses: List<StayAlignedPose>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_poses = poses?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(2)
    builder.addBoolean(0, enabled, false)
    __off_poses?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StayAlignedSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_poses = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return StayAlignedSettingsResponse(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else false,
              poses = if (__offset_poses != 0) { val vecOff = tableOffset + __offset_poses + bb.getInt(tableOffset + __offset_poses); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) StayAlignedPose.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

public data class ChangeStayAlignedSettingsRequest(
  public val enabled: Boolean = false,
  public val poseToggles: List<StayAlignedPoseToggle>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_poseToggles = poseToggles?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(2)
    builder.addBoolean(0, enabled, false)
    __off_poseToggles?.let { builder.addOffset(1, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeStayAlignedSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_poseToggles = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return ChangeStayAlignedSettingsRequest(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else false,
              poseToggles = if (__offset_poseToggles != 0) { val vecOff = tableOffset + __offset_poseToggles + bb.getInt(tableOffset + __offset_poseToggles); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) StayAlignedPoseToggle.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

public data class StartStayAlignedPoseRecordingRequest(
  public val pose: StayAlignedRelaxedPose = StayAlignedRelaxedPose.UNKNOWN,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addByte(0, pose.value.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StartStayAlignedPoseRecordingRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_pose = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StartStayAlignedPoseRecordingRequest(
              pose = if (__offset_pose != 0) StayAlignedRelaxedPose.fromValue(bb.get(tableOffset + __offset_pose).toUByte()) ?: StayAlignedRelaxedPose.UNKNOWN else StayAlignedRelaxedPose.UNKNOWN
          )
    }
  }
}

public class CancelStayAlignedPoseRecordingRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): CancelStayAlignedPoseRecordingRequest = CancelStayAlignedPoseRecordingRequest()
  }
}

/**
 * The parts of the body Stay Aligned reads. The upper body is any of the upper body
 * trackers, the rest are single trackers.
 */
public enum class StayAlignedPart(
  public val `value`: UByte,
) {
  UPPER_BODY(0.toUByte()),
  LEFT_UPPER_LEG(1.toUByte()),
  RIGHT_UPPER_LEG(2.toUByte()),
  LEFT_LOWER_LEG(3.toUByte()),
  RIGHT_LOWER_LEG(4.toUByte()),
  LEFT_FOOT(5.toUByte()),
  RIGHT_FOOT(6.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): StayAlignedPart? = entries.firstOrNull { it.value == value }
  }
}

public enum class StayAlignedRecordingTrackerState(
  public val `value`: UByte,
) {
  STILL(0.toUByte()),
  MOVING(1.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): StayAlignedRecordingTrackerState? = entries.firstOrNull { it.value == value }
  }
}

public enum class StayAlignedPoseRecordingFailure(
  public val `value`: UByte,
) {
  NONE(0.toUByte()),
  NOT_STILL(1.toUByte()),
  WRONG_POSE(2.toUByte()),
  POSITION_UNKNOWN(3.toUByte()),
  MISSING_TRACKERS(4.toUByte()),
  NOT_CALIBRATED(5.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): StayAlignedPoseRecordingFailure? = entries.firstOrNull { it.value == value }
  }
}

public data class StayAlignedRecordingTracker(
  public val part: StayAlignedPart = StayAlignedPart.UPPER_BODY,
  public val state: StayAlignedRecordingTrackerState = StayAlignedRecordingTrackerState.STILL,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    builder.addByte(0, part.value.toByte(), 0)
    builder.addByte(1, state.value.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StayAlignedRecordingTracker {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_part = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_state = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return StayAlignedRecordingTracker(
              part = if (__offset_part != 0) StayAlignedPart.fromValue(bb.get(tableOffset + __offset_part).toUByte()) ?: StayAlignedPart.UPPER_BODY else StayAlignedPart.UPPER_BODY,
              state = if (__offset_state != 0) StayAlignedRecordingTrackerState.fromValue(bb.get(tableOffset + __offset_state).toUByte()) ?: StayAlignedRecordingTrackerState.STILL else StayAlignedRecordingTrackerState.STILL
          )
    }
  }
}

public enum class StayAlignedPoseRecordingLifecycle(
  public val `value`: UByte,
) {
  RUNNING(0.toUByte()),
  DONE(1.toUByte()),
  CANCELED(2.toUByte()),
  FAILED(3.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): StayAlignedPoseRecordingLifecycle? = entries.firstOrNull { it.value == value }
  }
}

public data class StayAlignedPoseCountdown(
  public val progress: Int = 0,
  public val duration: Int = 0,
) : StayAlignedPoseRecordingDetail {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    builder.addInt(0, progress, 0)
    builder.addInt(1, duration, 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StayAlignedPoseCountdown {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_progress = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_duration = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return StayAlignedPoseCountdown(
              progress = if (__offset_progress != 0) bb.getInt(tableOffset + __offset_progress) else 0,
              duration = if (__offset_duration != 0) bb.getInt(tableOffset + __offset_duration) else 0
          )
    }
  }
}

public data class StayAlignedPoseWaiting(
  public val progress: Int = 0,
  public val duration: Int = 0,
  public val detectedPose: StayAlignedRelaxedPose = StayAlignedRelaxedPose.UNKNOWN,
  public val trackers: List<StayAlignedRecordingTracker>? = null,
) : StayAlignedPoseRecordingDetail {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_trackers = trackers?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(4)
    builder.addInt(0, progress, 0)
    builder.addInt(1, duration, 0)
    builder.addByte(2, detectedPose.value.toByte(), 0)
    __off_trackers?.let { builder.addOffset(3, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StayAlignedPoseWaiting {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_progress = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_duration = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_detectedPose = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_trackers = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return StayAlignedPoseWaiting(
              progress = if (__offset_progress != 0) bb.getInt(tableOffset + __offset_progress) else 0,
              duration = if (__offset_duration != 0) bb.getInt(tableOffset + __offset_duration) else 0,
              detectedPose = if (__offset_detectedPose != 0) StayAlignedRelaxedPose.fromValue(bb.get(tableOffset + __offset_detectedPose).toUByte()) ?: StayAlignedRelaxedPose.UNKNOWN else StayAlignedRelaxedPose.UNKNOWN,
              trackers = if (__offset_trackers != 0) { val vecOff = tableOffset + __offset_trackers + bb.getInt(tableOffset + __offset_trackers); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) StayAlignedRecordingTracker.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

public sealed interface StayAlignedPoseRecordingDetail {
  public companion object {
    public fun decode(
      type: UByte,
      bb: FlatBufferReader,
      offset: Int,
    ): StayAlignedPoseRecordingDetail? = when (type.toInt()) {
      1 -> StayAlignedPoseCountdown.decode(bb, offset)
      2 -> StayAlignedPoseWaiting.decode(bb, offset)
      else -> null
    }

    public fun typeIndex(`value`: StayAlignedPoseRecordingDetail): UByte = when (value) {
      is StayAlignedPoseCountdown -> 1.toUByte()
      is StayAlignedPoseWaiting -> 2.toUByte()
    }

    public fun encode(`value`: StayAlignedPoseRecordingDetail, builder: FlatBufferWriter): Int = when (value) {
      is StayAlignedPoseCountdown -> value.encode(builder)
      is StayAlignedPoseWaiting -> value.encode(builder)
    }
  }
}

public data class StayAlignedPoseRecordingStatusResponse(
  public val pose: StayAlignedRelaxedPose = StayAlignedRelaxedPose.UNKNOWN,
  public val lifecycle:
      StayAlignedPoseRecordingLifecycle = StayAlignedPoseRecordingLifecycle.RUNNING,
  public val detail: StayAlignedPoseRecordingDetail? = null,
  public val failure: StayAlignedPoseRecordingFailure = StayAlignedPoseRecordingFailure.NONE,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_detail = detail?.let { StayAlignedPoseRecordingDetail.encode(it, builder) }
    val __type_detail = detail?.let { StayAlignedPoseRecordingDetail.typeIndex(it) } ?: 0.toUByte()

    builder.startTable(5)
    builder.addByte(0, pose.value.toByte(), 0)
    builder.addByte(1, lifecycle.value.toByte(), 0)
    builder.addByte(2, __type_detail.toByte(), 0)
    __off_detail?.let { builder.addOffset(3, it, 0) }
    builder.addByte(4, failure.value.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StayAlignedPoseRecordingStatusResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_pose = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_lifecycle = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __type_detail = if (vtableSize > 8 && bb.getShort(vtableOffset + 8).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 8).toInt()).toUByte() else 0.toUByte()
      val __offset_detail = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_failure = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return StayAlignedPoseRecordingStatusResponse(
              pose = if (__offset_pose != 0) StayAlignedRelaxedPose.fromValue(bb.get(tableOffset + __offset_pose).toUByte()) ?: StayAlignedRelaxedPose.UNKNOWN else StayAlignedRelaxedPose.UNKNOWN,
              lifecycle = if (__offset_lifecycle != 0) StayAlignedPoseRecordingLifecycle.fromValue(bb.get(tableOffset + __offset_lifecycle).toUByte()) ?: StayAlignedPoseRecordingLifecycle.RUNNING else StayAlignedPoseRecordingLifecycle.RUNNING,
              detail = if (__offset_detail != 0) StayAlignedPoseRecordingDetail.decode(__type_detail, bb, tableOffset + __offset_detail + bb.getInt(tableOffset + __offset_detail)) else null,
              failure = if (__offset_failure != 0) StayAlignedPoseRecordingFailure.fromValue(bb.get(tableOffset + __offset_failure).toUByte()) ?: StayAlignedPoseRecordingFailure.NONE else StayAlignedPoseRecordingFailure.NONE
          )
    }
  }
}

public class StartStayAlignedStatusRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StartStayAlignedStatusRequest = StartStayAlignedStatusRequest()
  }
}

public class StopStayAlignedStatusRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StopStayAlignedStatusRequest = StopStayAlignedStatusRequest()
  }
}

public enum class StayAlignedPoseState(
  public val `value`: UByte,
) {
  NOT_RECORDED(0.toUByte()),
  DISABLED(1.toUByte()),
  ENABLED(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): StayAlignedPoseState? = entries.firstOrNull { it.value == value }
  }
}

public data class StayAlignedDetectedPoseState(
  public val pose: StayAlignedRelaxedPose = StayAlignedRelaxedPose.UNKNOWN,
  public val state: StayAlignedPoseState = StayAlignedPoseState.NOT_RECORDED,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    builder.addByte(0, pose.value.toByte(), 0)
    builder.addByte(1, state.value.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StayAlignedDetectedPoseState {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_pose = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_state = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return StayAlignedDetectedPoseState(
              pose = if (__offset_pose != 0) StayAlignedRelaxedPose.fromValue(bb.get(tableOffset + __offset_pose).toUByte()) ?: StayAlignedRelaxedPose.UNKNOWN else StayAlignedRelaxedPose.UNKNOWN,
              state = if (__offset_state != 0) StayAlignedPoseState.fromValue(bb.get(tableOffset + __offset_state).toUByte()) ?: StayAlignedPoseState.NOT_RECORDED else StayAlignedPoseState.NOT_RECORDED
          )
    }
  }
}

public data class StayAlignedTrackerCorrection(
  public val bodyPart: BodyPart = BodyPart.NONE,
  public val degrees: Float = 0.0f,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    builder.addByte(0, bodyPart.value.toByte(), 0)
    builder.addFloat(1, degrees, 0.0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StayAlignedTrackerCorrection {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bodyPart = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_degrees = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return StayAlignedTrackerCorrection(
              bodyPart = if (__offset_bodyPart != 0) BodyPart.fromValue(bb.get(tableOffset + __offset_bodyPart).toUByte()) ?: BodyPart.NONE else BodyPart.NONE,
              degrees = if (__offset_degrees != 0) bb.getFloat(tableOffset + __offset_degrees) else 0.0f
          )
    }
  }
}

public data class StayAlignedStatusResponse(
  public val enabled: Boolean = false,
  public val detectedPose: StayAlignedDetectedPoseState? = null,
  public val missingParts: List<StayAlignedPart>? = null,
  public val largestCorrection: StayAlignedTrackerCorrection? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_detectedPose = detectedPose?.encode(builder)
    val __off_missingParts = missingParts?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }
    val __off_largestCorrection = largestCorrection?.encode(builder)

    builder.startTable(4)
    builder.addBoolean(0, enabled, false)
    __off_detectedPose?.let { builder.addOffset(1, it, 0) }
    __off_missingParts?.let { builder.addOffset(2, it, 0) }
    __off_largestCorrection?.let { builder.addOffset(3, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StayAlignedStatusResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_enabled = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_detectedPose = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_missingParts = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_largestCorrection = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return StayAlignedStatusResponse(
              enabled = if (__offset_enabled != 0) bb.get(tableOffset + __offset_enabled) != 0.toByte() else false,
              detectedPose = if (__offset_detectedPose != 0) StayAlignedDetectedPoseState.decode(bb, tableOffset + __offset_detectedPose + bb.getInt(tableOffset + __offset_detectedPose)) else null,
              missingParts = if (__offset_missingParts != 0) { val vecOff = tableOffset + __offset_missingParts + bb.getInt(tableOffset + __offset_missingParts); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> StayAlignedPart.fromValue(bb.get(vecOff + 4 + i * 1).toUByte()) } } else null,
              largestCorrection = if (__offset_largestCorrection != 0) StayAlignedTrackerCorrection.decode(bb, tableOffset + __offset_largestCorrection + bb.getInt(tableOffset + __offset_largestCorrection)) else null
          )
    }
  }
}
