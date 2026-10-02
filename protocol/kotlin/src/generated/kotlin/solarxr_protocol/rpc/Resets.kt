package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.collections.List
import solarxr_protocol.datatypes.BodyPart
import solarxr_protocol.datatypes.MountingMethod

public enum class ResetType(
  public val `value`: UByte,
) {
  /**
   * Resets the yaw (horizontal) axis
   */
  YAW(0.toUByte()),
  /**
   * Resets all axes
   */
  FULL(1.toUByte()),
  /**
   * Calibrates the mounting rotation with the configured MountingMethod
   */
  MOUNTING(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): ResetType? = entries.firstOrNull { it.value == value }
  }
}

public data class ResetRequest(
  public val resetType: ResetType = ResetType.YAW,
  public val bodyParts: List<BodyPart>? = null,
  public val delay: Float? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_bodyParts = bodyParts?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }

    builder.startTable(3)
    builder.addByte(0, resetType.value.toByte(), 0)
    __off_bodyParts?.let { builder.addOffset(1, it, 0) }
    if (delay != null) { builder.forceDefaults(true); builder.addFloat(2, delay, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ResetRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_resetType = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_bodyParts = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_delay = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0

      return ResetRequest(
              resetType = if (__offset_resetType != 0) ResetType.fromValue(bb.get(tableOffset + __offset_resetType).toUByte()) ?: ResetType.YAW else ResetType.YAW,
              bodyParts = if (__offset_bodyParts != 0) { val vecOff = tableOffset + __offset_bodyParts + bb.getInt(tableOffset + __offset_bodyParts); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> BodyPart.fromValue(bb.get(vecOff + 4 + i * 1).toUByte()) } } else null,
              delay = if (__offset_delay != 0) bb.getFloat(tableOffset + __offset_delay) else null
          )
    }
  }
}

public enum class ResetLifecycle(
  public val `value`: UByte,
) {
  RUNNING(0.toUByte()),
  DONE(1.toUByte()),
  CANCELED(2.toUByte()),
  FAILED(3.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): ResetLifecycle? = entries.firstOrNull { it.value == value }
  }
}

/**
 * A reset that runs after a delay (full, yaw and pose mounting)
 */
public data class CountdownDetail(
  public val progress: Int = 0,
  public val duration: Int = 0,
) : ResetDetail {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    builder.addInt(0, progress, 0)
    builder.addInt(1, duration, 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): CountdownDetail {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_progress = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_duration = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return CountdownDetail(
              progress = if (__offset_progress != 0) bb.getInt(tableOffset + __offset_progress) else 0,
              duration = if (__offset_duration != 0) bb.getInt(tableOffset + __offset_duration) else 0
          )
    }
  }
}

public enum class StepMountingStatus(
  public val `value`: UByte,
) {
  WAITING_FOR_MOVEMENT(0.toUByte()),
  RECORDING(1.toUByte()),
  PROCESSING(2.toUByte()),
  ERROR_NO_DATA(3.toUByte()),
  ERROR_TIMEOUT(4.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): StepMountingStatus? = entries.firstOrNull { it.value == value }
  }
}

/**
 * A step mounting session
 */
public data class StepMountingDetail(
  public val status: StepMountingStatus = StepMountingStatus.WAITING_FOR_MOVEMENT,
) : ResetDetail {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    builder.addByte(0, status.value.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StepMountingDetail {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_status = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return StepMountingDetail(
              status = if (__offset_status != 0) StepMountingStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) ?: StepMountingStatus.WAITING_FOR_MOVEMENT else StepMountingStatus.WAITING_FOR_MOVEMENT
          )
    }
  }
}

public sealed interface ResetDetail {
  public companion object {
    public fun decode(
      type: UByte,
      bb: FlatBufferReader,
      offset: Int,
    ): ResetDetail? = when (type.toInt()) {
      1 -> CountdownDetail.decode(bb, offset)
      2 -> StepMountingDetail.decode(bb, offset)
      else -> null
    }

    public fun typeIndex(`value`: ResetDetail): UByte = when (value) {
      is CountdownDetail -> 1.toUByte()
      is StepMountingDetail -> 2.toUByte()
    }

    public fun encode(`value`: ResetDetail, builder: FlatBufferWriter): Int = when (value) {
      is CountdownDetail -> value.encode(builder)
      is StepMountingDetail -> value.encode(builder)
    }
  }
}

public data class ResetStatusResponse(
  public val resetType: ResetType = ResetType.YAW,
  public val lifecycle: ResetLifecycle = ResetLifecycle.RUNNING,
  public val bodyParts: List<BodyPart>? = null,
  public val detail: ResetDetail? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_bodyParts = bodyParts?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }
    val __off_detail = detail?.let { ResetDetail.encode(it, builder) }
    val __type_detail = detail?.let { ResetDetail.typeIndex(it) } ?: 0.toUByte()

    builder.startTable(5)
    builder.addByte(0, resetType.value.toByte(), 0)
    builder.addByte(1, lifecycle.value.toByte(), 0)
    __off_bodyParts?.let { builder.addOffset(2, it, 0) }
    builder.addByte(3, __type_detail.toByte(), 0)
    __off_detail?.let { builder.addOffset(4, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ResetStatusResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_resetType = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_lifecycle = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_bodyParts = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __type_detail = if (vtableSize > 10 && bb.getShort(vtableOffset + 10).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 10).toInt()).toUByte() else 0.toUByte()
      val __offset_detail = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0

      return ResetStatusResponse(
              resetType = if (__offset_resetType != 0) ResetType.fromValue(bb.get(tableOffset + __offset_resetType).toUByte()) ?: ResetType.YAW else ResetType.YAW,
              lifecycle = if (__offset_lifecycle != 0) ResetLifecycle.fromValue(bb.get(tableOffset + __offset_lifecycle).toUByte()) ?: ResetLifecycle.RUNNING else ResetLifecycle.RUNNING,
              bodyParts = if (__offset_bodyParts != 0) { val vecOff = tableOffset + __offset_bodyParts + bb.getInt(tableOffset + __offset_bodyParts); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> BodyPart.fromValue(bb.get(vecOff + 4 + i * 1).toUByte()) } } else null,
              detail = if (__offset_detail != 0) ResetDetail.decode(__type_detail, bb, tableOffset + __offset_detail + bb.getInt(tableOffset + __offset_detail)) else null
          )
    }
  }
}

/**
 * Cancels the running reset, if any
 */
public class CancelResetRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): CancelResetRequest = CancelResetRequest()
  }
}

/**
 * Clears mounting reset data, defaulting to the manually set mounting orientations
 */
public class ClearMountingResetRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ClearMountingResetRequest = ClearMountingResetRequest()
  }
}

public enum class ArmsMountingResetMode(
  public val `value`: UByte,
) {
  /**
   * Upper arm going back and forearm going forward.
   */
  BACK(0.toUByte()),
  /**
   * Arms going forward.
   */
  FORWARD(1.toUByte()),
  /**
   * Arms going in T-pose.
   */
  SIDE(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): ArmsMountingResetMode? = entries.firstOrNull { it.value == value }
  }
}

public class ResetsSettingsRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ResetsSettingsRequest = ResetsSettingsRequest()
  }
}

public data class ResetsSettingsResponse(
  public val resetMountingFeet: Boolean = false,
  public val armsMountingResetMode: ArmsMountingResetMode = ArmsMountingResetMode.BACK,
  public val yawResetSmoothTime: Float = 0.0f,
  public val saveMountingReset: Boolean = false,
  public val resetReliableReferenceAttitude: Boolean = false,
  public val mountingMethod: MountingMethod = MountingMethod.UNKNOWN,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(6)
    builder.addBoolean(0, resetMountingFeet, false)
    builder.addByte(1, armsMountingResetMode.value.toByte(), 0)
    builder.addFloat(2, yawResetSmoothTime, 0.0)
    builder.addBoolean(3, saveMountingReset, false)
    builder.addBoolean(4, resetReliableReferenceAttitude, false)
    builder.addByte(5, mountingMethod.value.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ResetsSettingsResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_resetMountingFeet = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_armsMountingResetMode = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_yawResetSmoothTime = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_saveMountingReset = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_resetReliableReferenceAttitude = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_mountingMethod = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0

      return ResetsSettingsResponse(
              resetMountingFeet = if (__offset_resetMountingFeet != 0) bb.get(tableOffset + __offset_resetMountingFeet) != 0.toByte() else false,
              armsMountingResetMode = if (__offset_armsMountingResetMode != 0) ArmsMountingResetMode.fromValue(bb.get(tableOffset + __offset_armsMountingResetMode).toUByte()) ?: ArmsMountingResetMode.BACK else ArmsMountingResetMode.BACK,
              yawResetSmoothTime = if (__offset_yawResetSmoothTime != 0) bb.getFloat(tableOffset + __offset_yawResetSmoothTime) else 0.0f,
              saveMountingReset = if (__offset_saveMountingReset != 0) bb.get(tableOffset + __offset_saveMountingReset) != 0.toByte() else false,
              resetReliableReferenceAttitude = if (__offset_resetReliableReferenceAttitude != 0) bb.get(tableOffset + __offset_resetReliableReferenceAttitude) != 0.toByte() else false,
              mountingMethod = if (__offset_mountingMethod != 0) MountingMethod.fromValue(bb.get(tableOffset + __offset_mountingMethod).toUByte()) ?: MountingMethod.UNKNOWN else MountingMethod.UNKNOWN
          )
    }
  }
}

public data class ChangeResetsSettingsRequest(
  public val resetMountingFeet: Boolean = false,
  public val armsMountingResetMode: ArmsMountingResetMode = ArmsMountingResetMode.BACK,
  public val yawResetSmoothTime: Float = 0.0f,
  public val saveMountingReset: Boolean = false,
  public val resetReliableReferenceAttitude: Boolean = false,
  public val mountingMethod: MountingMethod = MountingMethod.UNKNOWN,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(6)
    builder.addBoolean(0, resetMountingFeet, false)
    builder.addByte(1, armsMountingResetMode.value.toByte(), 0)
    builder.addFloat(2, yawResetSmoothTime, 0.0)
    builder.addBoolean(3, saveMountingReset, false)
    builder.addBoolean(4, resetReliableReferenceAttitude, false)
    builder.addByte(5, mountingMethod.value.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ChangeResetsSettingsRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_resetMountingFeet = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_armsMountingResetMode = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_yawResetSmoothTime = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_saveMountingReset = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_resetReliableReferenceAttitude = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_mountingMethod = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0

      return ChangeResetsSettingsRequest(
              resetMountingFeet = if (__offset_resetMountingFeet != 0) bb.get(tableOffset + __offset_resetMountingFeet) != 0.toByte() else false,
              armsMountingResetMode = if (__offset_armsMountingResetMode != 0) ArmsMountingResetMode.fromValue(bb.get(tableOffset + __offset_armsMountingResetMode).toUByte()) ?: ArmsMountingResetMode.BACK else ArmsMountingResetMode.BACK,
              yawResetSmoothTime = if (__offset_yawResetSmoothTime != 0) bb.getFloat(tableOffset + __offset_yawResetSmoothTime) else 0.0f,
              saveMountingReset = if (__offset_saveMountingReset != 0) bb.get(tableOffset + __offset_saveMountingReset) != 0.toByte() else false,
              resetReliableReferenceAttitude = if (__offset_resetReliableReferenceAttitude != 0) bb.get(tableOffset + __offset_resetReliableReferenceAttitude) != 0.toByte() else false,
              mountingMethod = if (__offset_mountingMethod != 0) MountingMethod.fromValue(bb.get(tableOffset + __offset_mountingMethod).toUByte()) ?: MountingMethod.UNKNOWN else MountingMethod.UNKNOWN
          )
    }
  }
}
