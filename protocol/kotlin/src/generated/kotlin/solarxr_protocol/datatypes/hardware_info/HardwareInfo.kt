package solarxr_protocol.datatypes.hardware_info

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Short
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import solarxr_protocol.datatypes.FirmwareErrorCode
import solarxr_protocol.datatypes.LogData

public enum class McuType(
  public val `value`: UShort,
) {
  UNKNOWN(0.toUShort()),
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

  public companion object {
    public fun fromValue(`value`: UShort): McuType? = entries.firstOrNull { it.value == value }
  }
}

public enum class ImuType(
  public val `value`: UShort,
) {
  UNKNOWN(0.toUShort()),
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
  ICM55686(19.toUShort()),
  DEV_RESERVED(250.toUShort()),
  ;

  public companion object {
    public fun fromValue(`value`: UShort): ImuType? = entries.firstOrNull { it.value == value }
  }
}

public enum class BoardType(
  public val `value`: UShort,
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

  public companion object {
    public fun fromValue(`value`: UShort): BoardType? = entries.firstOrNull { it.value == value }
  }
}

/**
 * What kind of data the tracker supports. The received data gets transformed into a Quaternion rotation in any case.
 */
public enum class TrackerDataType(
  public val `value`: UByte,
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

  public companion object {
    public fun fromValue(`value`: UByte): TrackerDataType? = entries.firstOrNull { it.value == value }
  }
}

/**
 * A MAC address or a bluetooth address, or some other uniquely identifying address
 * associated with the endpoint that we are communicating with. If it doesn't take
 * up the full set of bytes, it is aligned towards the least significant bits.
 */
public data class HardwareAddress(
  public val addr: ULong,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.prep(8, 8)
    var written = 0
    builder.pad(0 - written)
    builder.putLong(addr.toLong())
    written = 8
    return builder.offset()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, offset: Int): HardwareAddress = HardwareAddress(addr = bb.getLong(offset + 0).toULong())
  }
}

/**
 * Mostly static info about the device's hardware/firmware.
 */
public data class HardwareInfo(
  public val mcuId: McuType = McuType.UNKNOWN,
  public val displayName: String? = null,
  public val model: String? = null,
  public val manufacturer: String? = null,
  public val hardwareRevision: String? = null,
  public val firmwareVersion: String? = null,
  public val hardwareAddress: HardwareAddress? = null,
  public val ipAddress: UInt = 0u,
  public val boardType: String? = null,
  public val officialBoardType: BoardType = BoardType.UNKNOWN,
  public val hardwareIdentifier: String? = null,
  public val networkProtocolVersion: UShort? = null,
  public val firmwareDate: String? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_displayName = displayName?.let { builder.createString(it) }
    val __off_model = model?.let { builder.createString(it) }
    val __off_manufacturer = manufacturer?.let { builder.createString(it) }
    val __off_hardwareRevision = hardwareRevision?.let { builder.createString(it) }
    val __off_firmwareVersion = firmwareVersion?.let { builder.createString(it) }
    val __off_boardType = boardType?.let { builder.createString(it) }
    val __off_hardwareIdentifier = hardwareIdentifier?.let { builder.createString(it) }
    val __off_firmwareDate = firmwareDate?.let { builder.createString(it) }

    builder.startTable(13)
    builder.addShort(0, mcuId.value.toShort(), 0)
    __off_displayName?.let { builder.addOffset(1, it, 0) }
    __off_model?.let { builder.addOffset(2, it, 0) }
    __off_manufacturer?.let { builder.addOffset(3, it, 0) }
    __off_hardwareRevision?.let { builder.addOffset(4, it, 0) }
    __off_firmwareVersion?.let { builder.addOffset(5, it, 0) }
    hardwareAddress?.let { builder.addStruct(6, it.encode(builder), 0) }
    builder.addInt(7, ipAddress.toInt(), 0)
    __off_boardType?.let { builder.addOffset(8, it, 0) }
    builder.addShort(9, officialBoardType.value.toShort(), 0)
    __off_hardwareIdentifier?.let { builder.addOffset(10, it, 0) }
    if (networkProtocolVersion != null) { builder.forceDefaults(true); builder.addShort(11, networkProtocolVersion.toShort(), 0); builder.forceDefaults(false) }
    __off_firmwareDate?.let { builder.addOffset(12, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): HardwareInfo {
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
              mcuId = if (__offset_mcuId != 0) McuType.fromValue(bb.getShort(tableOffset + __offset_mcuId).toUShort()) ?: McuType.UNKNOWN else McuType.UNKNOWN,
              displayName = if (__offset_displayName != 0) readFlatBufferString(bb, tableOffset + __offset_displayName) else null,
              model = if (__offset_model != 0) readFlatBufferString(bb, tableOffset + __offset_model) else null,
              manufacturer = if (__offset_manufacturer != 0) readFlatBufferString(bb, tableOffset + __offset_manufacturer) else null,
              hardwareRevision = if (__offset_hardwareRevision != 0) readFlatBufferString(bb, tableOffset + __offset_hardwareRevision) else null,
              firmwareVersion = if (__offset_firmwareVersion != 0) readFlatBufferString(bb, tableOffset + __offset_firmwareVersion) else null,
              hardwareAddress = if (__offset_hardwareAddress != 0) HardwareAddress.decode(bb, tableOffset + __offset_hardwareAddress) else null,
              ipAddress = if (__offset_ipAddress != 0) bb.getInt(tableOffset + __offset_ipAddress).toUInt() else 0u,
              boardType = if (__offset_boardType != 0) readFlatBufferString(bb, tableOffset + __offset_boardType) else null,
              officialBoardType = if (__offset_officialBoardType != 0) BoardType.fromValue(bb.getShort(tableOffset + __offset_officialBoardType).toUShort()) ?: BoardType.UNKNOWN else BoardType.UNKNOWN,
              hardwareIdentifier = if (__offset_hardwareIdentifier != 0) readFlatBufferString(bb, tableOffset + __offset_hardwareIdentifier) else null,
              networkProtocolVersion = if (__offset_networkProtocolVersion != 0) bb.getShort(tableOffset + __offset_networkProtocolVersion).toUShort() else null,
              firmwareDate = if (__offset_firmwareDate != 0) readFlatBufferString(bb, tableOffset + __offset_firmwareDate) else null
          )
    }
  }
}

/**
 * Mostly-dynamic status info about a tracked device's firmware
 */
public data class HardwareStatus(
  public val errorStatus: FirmwareErrorCode? = null,
  public val ping: UShort? = null,
  public val rssi: Short? = null,
  public val rssiMin: Short? = null,
  public val rssiMax: Short? = null,
  public val mcuTemp: Float? = null,
  public val batteryVoltage: Float? = null,
  public val batteryPctEstimate: UByte? = null,
  public val logData: LogData? = null,
  public val packetLoss: Float? = null,
  public val packetsLost: Int? = null,
  public val packetsReceived: Int? = null,
  public val batteryRuntimeEstimate: Long? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_logData = logData?.encode(builder)

    builder.startTable(13)
    if (errorStatus != null) { builder.forceDefaults(true); builder.addByte(0, errorStatus.value.toByte(), 0); builder.forceDefaults(false) }
    if (ping != null) { builder.forceDefaults(true); builder.addShort(1, ping.toShort(), 0); builder.forceDefaults(false) }
    if (rssi != null) { builder.forceDefaults(true); builder.addShort(2, rssi, 0); builder.forceDefaults(false) }
    if (rssiMin != null) { builder.forceDefaults(true); builder.addShort(3, rssiMin, 0); builder.forceDefaults(false) }
    if (rssiMax != null) { builder.forceDefaults(true); builder.addShort(4, rssiMax, 0); builder.forceDefaults(false) }
    if (mcuTemp != null) { builder.forceDefaults(true); builder.addFloat(5, mcuTemp, 0.0); builder.forceDefaults(false) }
    if (batteryVoltage != null) { builder.forceDefaults(true); builder.addFloat(6, batteryVoltage, 0.0); builder.forceDefaults(false) }
    if (batteryPctEstimate != null) { builder.forceDefaults(true); builder.addByte(7, batteryPctEstimate.toByte(), 0); builder.forceDefaults(false) }
    __off_logData?.let { builder.addOffset(8, it, 0) }
    if (packetLoss != null) { builder.forceDefaults(true); builder.addFloat(9, packetLoss, 0.0); builder.forceDefaults(false) }
    if (packetsLost != null) { builder.forceDefaults(true); builder.addInt(10, packetsLost, 0); builder.forceDefaults(false) }
    if (packetsReceived != null) { builder.forceDefaults(true); builder.addInt(11, packetsReceived, 0); builder.forceDefaults(false) }
    if (batteryRuntimeEstimate != null) { builder.forceDefaults(true); builder.addLong(12, batteryRuntimeEstimate, 0L); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): HardwareStatus {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_errorStatus = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_ping = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_rssi = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_rssiMin = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_rssiMax = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_mcuTemp = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_batteryVoltage = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_batteryPctEstimate = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_logData = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_packetLoss = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_packetsLost = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_packetsReceived = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0
      val __offset_batteryRuntimeEstimate = if (vtableSize > 28) bb.getShort(vtableOffset + 28).toInt() else 0

      return HardwareStatus(
              errorStatus = if (__offset_errorStatus != 0) FirmwareErrorCode.fromValue(bb.get(tableOffset + __offset_errorStatus).toUByte()) else null,
              ping = if (__offset_ping != 0) bb.getShort(tableOffset + __offset_ping).toUShort() else null,
              rssi = if (__offset_rssi != 0) bb.getShort(tableOffset + __offset_rssi) else null,
              rssiMin = if (__offset_rssiMin != 0) bb.getShort(tableOffset + __offset_rssiMin) else null,
              rssiMax = if (__offset_rssiMax != 0) bb.getShort(tableOffset + __offset_rssiMax) else null,
              mcuTemp = if (__offset_mcuTemp != 0) bb.getFloat(tableOffset + __offset_mcuTemp) else null,
              batteryVoltage = if (__offset_batteryVoltage != 0) bb.getFloat(tableOffset + __offset_batteryVoltage) else null,
              batteryPctEstimate = if (__offset_batteryPctEstimate != 0) bb.get(tableOffset + __offset_batteryPctEstimate).toUByte() else null,
              logData = if (__offset_logData != 0) LogData.decode(bb, tableOffset + __offset_logData + bb.getInt(tableOffset + __offset_logData)) else null,
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
public data class FirmwareStatusMask(
  public val errorStatus: Boolean = false,
  public val tps: Boolean = false,
  public val ping: Boolean = false,
  public val rssi: Boolean = false,
  public val mcuTemp: Boolean = false,
  public val batteryVoltage: Boolean = false,
  public val batteryPctEstimate: Boolean = false,
  public val batteryRuntimeEstimate: Boolean = false,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(8)
    builder.addBoolean(0, errorStatus, false)
    builder.addBoolean(1, tps, false)
    builder.addBoolean(2, ping, false)
    builder.addBoolean(3, rssi, false)
    builder.addBoolean(4, mcuTemp, false)
    builder.addBoolean(5, batteryVoltage, false)
    builder.addBoolean(6, batteryPctEstimate, false)
    builder.addBoolean(7, batteryRuntimeEstimate, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): FirmwareStatusMask {
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
              errorStatus = if (__offset_errorStatus != 0) bb.get(tableOffset + __offset_errorStatus) != 0.toByte() else false,
              tps = if (__offset_tps != 0) bb.get(tableOffset + __offset_tps) != 0.toByte() else false,
              ping = if (__offset_ping != 0) bb.get(tableOffset + __offset_ping) != 0.toByte() else false,
              rssi = if (__offset_rssi != 0) bb.get(tableOffset + __offset_rssi) != 0.toByte() else false,
              mcuTemp = if (__offset_mcuTemp != 0) bb.get(tableOffset + __offset_mcuTemp) != 0.toByte() else false,
              batteryVoltage = if (__offset_batteryVoltage != 0) bb.get(tableOffset + __offset_batteryVoltage) != 0.toByte() else false,
              batteryPctEstimate = if (__offset_batteryPctEstimate != 0) bb.get(tableOffset + __offset_batteryPctEstimate) != 0.toByte() else false,
              batteryRuntimeEstimate = if (__offset_batteryRuntimeEstimate != 0) bb.get(tableOffset + __offset_batteryRuntimeEstimate) != 0.toByte() else false
          )
    }
  }
}
