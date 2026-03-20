package solarxr_protocol.datatypes.hardware_info

import com.google.flatbuffers.FlatBufferBuilder
import java.nio.ByteBuffer
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Short
import kotlin.String
import kotlin.UByte
import kotlin.ULong
import kotlin.UShort
import solarxr_protocol.datatypes.FirmwareErrorCode
import solarxr_protocol.datatypes.Ipv4Address
import solarxr_protocol.datatypes.LogData

enum class McuType(
  val `value`: UShort,
) {
  Other(0.toUShort()),
  ESP8266(1.toUShort()),
  ESP32(2.toUShort()),
  OWOTRACK_ANDROID(3.toUShort()),
  WRANGLER(4.toUShort()),
  OWOTRACK_IOS(5.toUShort()),
  ESP32_C3(6.toUShort()),
  MOCOPI(7.toUShort()),
  HARITORA(8.toUShort()),
  NRF52(9.toUShort()),
  NRF54L(10.toUShort()),
  DEV_RESERVED(250.toUShort()),
  ;

  companion object {
    fun fromValue(`value`: UShort): McuType? = entries.firstOrNull { it.value == value }
  }
}

enum class ImuType(
  val `value`: UShort,
) {
  Other(0.toUShort()),
  MPU9250(1.toUShort()),
  MPU6500(2.toUShort()),
  BNO080(3.toUShort()),
  BNO085(4.toUShort()),
  BNO055(5.toUShort()),
  MPU6050(6.toUShort()),
  BNO086(7.toUShort()),
  BMI160(8.toUShort()),
  ICM20948(9.toUShort()),
  ICM42688(10.toUShort()),
  BMI270(11.toUShort()),
  LSM6DS3TRC(12.toUShort()),
  LSM6DSV(13.toUShort()),
  LSM6DSO(14.toUShort()),
  LSM6DSR(15.toUShort()),
  ICM45686(16.toUShort()),
  ICM45605(17.toUShort()),
  ADC_RESISTANCE(18.toUShort()),
  DEV_RESERVED(250.toUShort()),
  ;

  companion object {
    fun fromValue(`value`: UShort): ImuType? = entries.firstOrNull { it.value == value }
  }
}

enum class BoardType(
  val `value`: UShort,
) {
  UNKNOWN(0.toUShort()),
  SLIMEVR_LEGACY(1.toUShort()),
  SLIMEVR_DEV(2.toUShort()),
  NODEMCU(3.toUShort()),
  CUSTOM(4.toUShort()),
  WROOM32(5.toUShort()),
  WEMOSD1MINI(6.toUShort()),
  TTGO_TBASE(7.toUShort()),
  ESP01(8.toUShort()),
  SLIMEVR(9.toUShort()),
  LOLIN_C3_MINI(10.toUShort()),
  BEETLE32C3(11.toUShort()),
  ESP32C3DEVKITM1(12.toUShort()),
  OWOTRACK(13.toUShort()),
  WRANGLER(14.toUShort()),
  MOCOPI(15.toUShort()),
  WEMOSWROOM02(16.toUShort()),
  XIAO_ESP32C3(17.toUShort()),
  HARITORA(18.toUShort()),
  ESP32C6DEVKITC1(19.toUShort()),
  GLOVE_IMU_SLIMEVR_DEV(20.toUShort()),
  GESTURES(21.toUShort()),
  SLIMEVR_V1_2(22.toUShort()),
  ESP32S3_SUPERMINI(23.toUShort()),
  GENERIC_NRF(24.toUShort()),
  SLIMEVR_BUTTERFLY_DEV(25.toUShort()),
  SLIMEVR_BUTTERFLY(26.toUShort()),
  DEV_RESERVED(250.toUShort()),
  ;

  companion object {
    fun fromValue(`value`: UShort): BoardType? = entries.firstOrNull { it.value == value }
  }
}

/**
 * What kind of data the tracker supports.The received data gets computed into a Quaternion rotation in any case.
 */
enum class TrackerDataType(
  val `value`: UByte,
) {
  /**
   * Rotation (e.g: IMUs or computed rotations in firmware)
   */
  ROTATION(0.toUByte()),
  /**
   * Flex resistance (e.g: raw data from flex sensors or unscaled angle on a single axis)
   */
  FLEX_RESISTANCE(1.toUByte()),
  /**
   * Flex angle (e.g: computed angle from flex sensors or angle on a single axis)
   */
  FLEX_ANGLE(2.toUByte()),
  ;

  companion object {
    fun fromValue(`value`: UByte): TrackerDataType? = entries.firstOrNull { it.value == value }
  }
}

/**
 * A MAC address or a bluetooth address, or some other uniquely identifying address
 * associated with the endpoint that we are communicating with. If it doesn't take
 * up the full set of bytes, it is aligned towards the least significant bits.
 */
data class HardwareAddress(
  val addr: ULong,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    builder.prep(8, 8)
    builder.putLong(addr.toLong())
    return builder.offset()
  }

  companion object {
    fun decode(bb: ByteBuffer, offset: Int): HardwareAddress = HardwareAddress(addr = bb.getLong(offset + 0).toULong())
  }
}

/**
 * Mostly static info about the device's hardware/firmware.
 */
data class HardwareInfo(
  val mcuId: McuType? = null,
  val displayName: String? = null,
  val model: String? = null,
  val manufacturer: String? = null,
  val hardwareRevision: String? = null,
  val firmwareVersion: String? = null,
  val hardwareAddress: HardwareAddress? = null,
  val ipAddress: Ipv4Address? = null,
  val boardType: String? = null,
  val officialBoardType: BoardType? = null,
  val hardwareIdentifier: String? = null,
  val networkProtocolVersion: UShort? = null,
  val firmwareDate: String? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_displayName = displayName?.let { builder.createString(it) }
    val __off_model = model?.let { builder.createString(it) }
    val __off_manufacturer = manufacturer?.let { builder.createString(it) }
    val __off_hardwareRevision = hardwareRevision?.let { builder.createString(it) }
    val __off_firmwareVersion = firmwareVersion?.let { builder.createString(it) }
    val __off_boardType = boardType?.let { builder.createString(it) }
    val __off_hardwareIdentifier = hardwareIdentifier?.let { builder.createString(it) }
    val __off_firmwareDate = firmwareDate?.let { builder.createString(it) }

    builder.startTable(13)
    mcuId?.let { builder.addShort(0, it.value.toShort(), 0) }
    __off_displayName?.let { builder.addOffset(1, it, 0) }
    __off_model?.let { builder.addOffset(2, it, 0) }
    __off_manufacturer?.let { builder.addOffset(3, it, 0) }
    __off_hardwareRevision?.let { builder.addOffset(4, it, 0) }
    __off_firmwareVersion?.let { builder.addOffset(5, it, 0) }
    hardwareAddress?.let { builder.addStruct(6, it.encode(builder), 0) }
    ipAddress?.let { builder.addStruct(7, it.encode(builder), 0) }
    __off_boardType?.let { builder.addOffset(8, it, 0) }
    officialBoardType?.let { builder.addShort(9, it.value.toShort(), 0) }
    __off_hardwareIdentifier?.let { builder.addOffset(10, it, 0) }
    networkProtocolVersion?.let { builder.addShort(11, it.toShort(), 0) }
    __off_firmwareDate?.let { builder.addOffset(12, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): HardwareInfo {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_mcuId = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_displayName = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_model = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_manufacturer = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_hardwareRevision = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_firmwareVersion = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_hardwareAddress = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_ipAddress = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_boardType = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_officialBoardType = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_hardwareIdentifier = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_networkProtocolVersion = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0
      val __offset_firmwareDate = if (vtableSize > 28) bb.getShort(vtableOffset + 28).toInt() else 0

      return HardwareInfo(
              mcuId = if (__offset_mcuId != 0) solarxr_protocol.datatypes.hardware_info.McuType.fromValue(bb.getShort(tableOffset + __offset_mcuId).toUShort()) else null,
              displayName = if (__offset_displayName != 0) { val strOff = tableOffset + __offset_displayName + bb.getInt(tableOffset + __offset_displayName); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              model = if (__offset_model != 0) { val strOff = tableOffset + __offset_model + bb.getInt(tableOffset + __offset_model); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              manufacturer = if (__offset_manufacturer != 0) { val strOff = tableOffset + __offset_manufacturer + bb.getInt(tableOffset + __offset_manufacturer); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              hardwareRevision = if (__offset_hardwareRevision != 0) { val strOff = tableOffset + __offset_hardwareRevision + bb.getInt(tableOffset + __offset_hardwareRevision); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              firmwareVersion = if (__offset_firmwareVersion != 0) { val strOff = tableOffset + __offset_firmwareVersion + bb.getInt(tableOffset + __offset_firmwareVersion); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              hardwareAddress = if (__offset_hardwareAddress != 0) solarxr_protocol.datatypes.hardware_info.HardwareAddress.decode(bb, tableOffset + __offset_hardwareAddress) else null,
              ipAddress = if (__offset_ipAddress != 0) solarxr_protocol.datatypes.Ipv4Address.decode(bb, tableOffset + __offset_ipAddress) else null,
              boardType = if (__offset_boardType != 0) { val strOff = tableOffset + __offset_boardType + bb.getInt(tableOffset + __offset_boardType); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              officialBoardType = if (__offset_officialBoardType != 0) solarxr_protocol.datatypes.hardware_info.BoardType.fromValue(bb.getShort(tableOffset + __offset_officialBoardType).toUShort()) else null,
              hardwareIdentifier = if (__offset_hardwareIdentifier != 0) { val strOff = tableOffset + __offset_hardwareIdentifier + bb.getInt(tableOffset + __offset_hardwareIdentifier); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null,
              networkProtocolVersion = if (__offset_networkProtocolVersion != 0) bb.getShort(tableOffset + __offset_networkProtocolVersion).toUShort() else null,
              firmwareDate = if (__offset_firmwareDate != 0) { val strOff = tableOffset + __offset_firmwareDate + bb.getInt(tableOffset + __offset_firmwareDate); val len = bb.getInt(strOff); ByteArray(len).also { bb.position(strOff + 4); bb.get(it) }.toString(Charsets.UTF_8) } else null
          )
    }
  }
}

/**
 * Mostly-dynamic status info about a tracked device's firmware
 */
data class HardwareStatus(
  val errorStatus: FirmwareErrorCode? = null,
  val tps: UByte? = null,
  val ping: UShort? = null,
  val rssi: Short? = null,
  val mcuTemp: Float? = null,
  val batteryVoltage: Float? = null,
  val batteryPctEstimate: UByte? = null,
  val logData: LogData? = null,
  val packetLoss: Float? = null,
  val packetsLost: Int? = null,
  val packetsReceived: Int? = null,
  val batteryRuntimeEstimate: Long? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {
    val __off_logData = logData?.encode(builder)

    builder.startTable(12)
    errorStatus?.let { builder.addByte(0, it.value.toByte(), 0) }
    tps?.let { builder.addByte(1, it.toByte(), 0) }
    ping?.let { builder.addShort(2, it.toShort(), 0) }
    rssi?.let { builder.addShort(3, it, 0) }
    mcuTemp?.let { builder.addFloat(4, it, 0.0) }
    batteryVoltage?.let { builder.addFloat(5, it, 0.0) }
    batteryPctEstimate?.let { builder.addByte(6, it.toByte(), 0) }
    __off_logData?.let { builder.addOffset(7, it, 0) }
    packetLoss?.let { builder.addFloat(8, it, 0.0) }
    packetsLost?.let { builder.addInt(9, it, 0) }
    packetsReceived?.let { builder.addInt(10, it, 0) }
    batteryRuntimeEstimate?.let { builder.addLong(11, it, 0) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): HardwareStatus {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_errorStatus = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_tps = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_ping = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_rssi = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_mcuTemp = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_batteryVoltage = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_batteryPctEstimate = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_logData = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_packetLoss = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_packetsLost = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_packetsReceived = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_batteryRuntimeEstimate = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0

      return HardwareStatus(
              errorStatus = if (__offset_errorStatus != 0) solarxr_protocol.datatypes.FirmwareErrorCode.fromValue(bb.get(tableOffset + __offset_errorStatus).toUByte()) else null,
              tps = if (__offset_tps != 0) bb.get(tableOffset + __offset_tps).toUByte() else null,
              ping = if (__offset_ping != 0) bb.getShort(tableOffset + __offset_ping).toUShort() else null,
              rssi = if (__offset_rssi != 0) bb.getShort(tableOffset + __offset_rssi) else null,
              mcuTemp = if (__offset_mcuTemp != 0) bb.getFloat(tableOffset + __offset_mcuTemp) else null,
              batteryVoltage = if (__offset_batteryVoltage != 0) bb.getFloat(tableOffset + __offset_batteryVoltage) else null,
              batteryPctEstimate = if (__offset_batteryPctEstimate != 0) bb.get(tableOffset + __offset_batteryPctEstimate).toUByte() else null,
              logData = if (__offset_logData != 0) solarxr_protocol.datatypes.LogData.decode(bb, tableOffset + __offset_logData + bb.getInt(tableOffset + __offset_logData)) else null,
              packetLoss = if (__offset_packetLoss != 0) bb.getFloat(tableOffset + __offset_packetLoss) else null,
              packetsLost = if (__offset_packetsLost != 0) bb.getInt(tableOffset + __offset_packetsLost) else null,
              packetsReceived = if (__offset_packetsReceived != 0) bb.getInt(tableOffset + __offset_packetsReceived) else null,
              batteryRuntimeEstimate = if (__offset_batteryRuntimeEstimate != 0) bb.getLong(tableOffset + __offset_batteryRuntimeEstimate) else null
          )
    }
  }
}

/**
 * A mask of the data in `FirmwareStatus`
 */
data class FirmwareStatusMask(
  val errorStatus: Boolean? = null,
  val tps: Boolean? = null,
  val ping: Boolean? = null,
  val rssi: Boolean? = null,
  val mcuTemp: Boolean? = null,
  val batteryVoltage: Boolean? = null,
  val batteryPctEstimate: Boolean? = null,
  val batteryRuntimeEstimate: Boolean? = null,
) {
  fun encode(builder: FlatBufferBuilder): Int {

    builder.startTable(8)
    errorStatus?.let { builder.addBoolean(0, it, false) }
    tps?.let { builder.addBoolean(1, it, false) }
    ping?.let { builder.addBoolean(2, it, false) }
    rssi?.let { builder.addBoolean(3, it, false) }
    mcuTemp?.let { builder.addBoolean(4, it, false) }
    batteryVoltage?.let { builder.addBoolean(5, it, false) }
    batteryPctEstimate?.let { builder.addBoolean(6, it, false) }
    batteryRuntimeEstimate?.let { builder.addBoolean(7, it, false) }
    return builder.endTable()
  }

  companion object {
    fun decode(bb: ByteBuffer, tableOffset: Int): FirmwareStatusMask {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_errorStatus = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_tps = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_ping = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_rssi = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_mcuTemp = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_batteryVoltage = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_batteryPctEstimate = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_batteryRuntimeEstimate = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0

      return FirmwareStatusMask(
              errorStatus = if (__offset_errorStatus != 0) bb.get(tableOffset + __offset_errorStatus) != 0.toByte() else null,
              tps = if (__offset_tps != 0) bb.get(tableOffset + __offset_tps) != 0.toByte() else null,
              ping = if (__offset_ping != 0) bb.get(tableOffset + __offset_ping) != 0.toByte() else null,
              rssi = if (__offset_rssi != 0) bb.get(tableOffset + __offset_rssi) != 0.toByte() else null,
              mcuTemp = if (__offset_mcuTemp != 0) bb.get(tableOffset + __offset_mcuTemp) != 0.toByte() else null,
              batteryVoltage = if (__offset_batteryVoltage != 0) bb.get(tableOffset + __offset_batteryVoltage) != 0.toByte() else null,
              batteryPctEstimate = if (__offset_batteryPctEstimate != 0) bb.get(tableOffset + __offset_batteryPctEstimate) != 0.toByte() else null,
              batteryRuntimeEstimate = if (__offset_batteryRuntimeEstimate != 0) bb.get(tableOffset + __offset_batteryRuntimeEstimate) != 0.toByte() else null
          )
    }
  }
}
