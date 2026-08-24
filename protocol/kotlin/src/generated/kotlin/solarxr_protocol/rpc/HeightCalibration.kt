package solarxr_protocol.rpc

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Float
import kotlin.Int
import kotlin.UByte

public class StartUserHeightCalibration : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): StartUserHeightCalibration = StartUserHeightCalibration()
  }
}

public class CancelUserHeightCalibration : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.startTable(0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): CancelUserHeightCalibration = CancelUserHeightCalibration()
  }
}

public enum class UserHeightCalibrationStatus(
  public val `value`: UByte,
) {
  NONE(0.toUByte()),
  RECORDING_FLOOR(1.toUByte()),
  WAITING_FOR_CONTROLLER_PITCH(2.toUByte()),
  WAITING_FOR_RISE(3.toUByte()),
  WAITING_FOR_FW_LOOK(4.toUByte()),
  RECORDING_HEIGHT(5.toUByte()),
  DONE(6.toUByte()),
  ERROR_TOO_HIGH(7.toUByte()),
  ERROR_TOO_SMALL(8.toUByte()),
  ERROR_TIMEOUT(9.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): UserHeightCalibrationStatus? = entries.firstOrNull { it.value == value }
  }
}

public data class UserHeightRecordingStatusResponse(
  public val hmdHeight: Float = 0.0f,
  public val status: UserHeightCalibrationStatus = UserHeightCalibrationStatus.NONE,
) : RpcMessage {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(2)
    builder.addFloat(0, hmdHeight, 0.0)
    builder.addByte(1, status.value.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): UserHeightRecordingStatusResponse {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_hmdHeight = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_status = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0

      return UserHeightRecordingStatusResponse(
              hmdHeight = if (__offset_hmdHeight != 0) bb.getFloat(tableOffset + __offset_hmdHeight) else 0.0f,
              status = if (__offset_status != 0) UserHeightCalibrationStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) ?: UserHeightCalibrationStatus.NONE else UserHeightCalibrationStatus.NONE
          )
    }
  }
}
