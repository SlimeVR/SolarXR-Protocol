package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.collections.List

public enum class AutoBoneProcessType(
  public val `value`: UByte,
) {
  NONE(0.toUByte()),
  RECORD(1.toUByte()),
  SAVE(2.toUByte()),
  PROCESS(3.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): AutoBoneProcessType? = entries.firstOrNull { it.value == value }
  }
}

public data class AutoBoneProcessRequest(
  public val processType: AutoBoneProcessType? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(1)
    if (processType != null) { builder.forceDefaults(true); builder.addByte(0, processType.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): AutoBoneProcessRequest {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_processType = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return AutoBoneProcessRequest(
              processType = if (__offset_processType != 0) AutoBoneProcessType.fromValue(bb.get(tableOffset + __offset_processType).toUByte()) else null
          )
    }
  }
}

public data class AutoBoneProcessStatusResponse(
  public val processType: AutoBoneProcessType? = null,
  public val current: UInt? = null,
  public val total: UInt? = null,
  public val completed: Boolean? = null,
  public val success: Boolean? = null,
  public val eta: Float? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(6)
    if (processType != null) { builder.forceDefaults(true); builder.addByte(0, processType.value.toByte(), 0); builder.forceDefaults(false) }
    if (current != null) { builder.forceDefaults(true); builder.addInt(1, current.toInt(), 0); builder.forceDefaults(false) }
    if (total != null) { builder.forceDefaults(true); builder.addInt(2, total.toInt(), 0); builder.forceDefaults(false) }
    if (completed != null) { builder.forceDefaults(true); builder.addBoolean(3, completed, false); builder.forceDefaults(false) }
    if (success != null) { builder.forceDefaults(true); builder.addBoolean(4, success, false); builder.forceDefaults(false) }
    if (eta != null) { builder.forceDefaults(true); builder.addFloat(5, eta, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): AutoBoneProcessStatusResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_processType = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_current = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_total = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_completed = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_success = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_eta = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0

      return AutoBoneProcessStatusResponse(
              processType = if (__offset_processType != 0) AutoBoneProcessType.fromValue(bb.get(tableOffset + __offset_processType).toUByte()) else null,
              current = if (__offset_current != 0) bb.getInt(tableOffset + __offset_current).toUInt() else null,
              total = if (__offset_total != 0) bb.getInt(tableOffset + __offset_total).toUInt() else null,
              completed = if (__offset_completed != 0) bb.get(tableOffset + __offset_completed) != 0.toByte() else null,
              success = if (__offset_success != 0) bb.get(tableOffset + __offset_success) != 0.toByte() else null,
              eta = if (__offset_eta != 0) bb.getFloat(tableOffset + __offset_eta) else null
          )
    }
  }
}

public data class AutoBoneEpochResponse(
  public val currentEpoch: UInt? = null,
  public val totalEpochs: UInt? = null,
  public val epochError: Float? = null,
  public val adjustedSkeletonParts: List<SkeletonPart>? = null,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_adjustedSkeletonParts = adjustedSkeletonParts?.let { builder.createVectorOfTables(it.map { e -> e.encode(builder) }.toIntArray()) }

    builder.startTable(4)
    if (currentEpoch != null) { builder.forceDefaults(true); builder.addInt(0, currentEpoch.toInt(), 0); builder.forceDefaults(false) }
    if (totalEpochs != null) { builder.forceDefaults(true); builder.addInt(1, totalEpochs.toInt(), 0); builder.forceDefaults(false) }
    if (epochError != null) { builder.forceDefaults(true); builder.addFloat(2, epochError, 0.0); builder.forceDefaults(false) }
    __off_adjustedSkeletonParts?.let { builder.addOffset(3, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): AutoBoneEpochResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_currentEpoch = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_totalEpochs = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_epochError = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_adjustedSkeletonParts = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0

      return AutoBoneEpochResponse(
              currentEpoch = if (__offset_currentEpoch != 0) bb.getInt(tableOffset + __offset_currentEpoch).toUInt() else null,
              totalEpochs = if (__offset_totalEpochs != 0) bb.getInt(tableOffset + __offset_totalEpochs).toUInt() else null,
              epochError = if (__offset_epochError != 0) bb.getFloat(tableOffset + __offset_epochError) else null,
              adjustedSkeletonParts = if (__offset_adjustedSkeletonParts != 0) { val vecOff = tableOffset + __offset_adjustedSkeletonParts + bb.getInt(tableOffset + __offset_adjustedSkeletonParts); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> if (bb.getInt(vecOff + 4 + i * 4) != 0) SkeletonPart.decode(bb, vecOff + 4 + i * 4 + bb.getInt(vecOff + 4 + i * 4)) else null } } else null
          )
    }
  }
}

/**
 * Applies the estimated proportions
 */
public class AutoBoneApplyRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): AutoBoneApplyRequest = AutoBoneApplyRequest()
  }
}

/**
 * Stops the current recording, using it as far as it has been recorded
 */
public class AutoBoneStopRecordingRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): AutoBoneStopRecordingRequest = AutoBoneStopRecordingRequest()
  }
}

/**
 * Cancels the current recording, aborting the process and discarding the data
 */
public class AutoBoneCancelRecordingRequest : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): AutoBoneCancelRecordingRequest = AutoBoneCancelRecordingRequest()
  }
}
