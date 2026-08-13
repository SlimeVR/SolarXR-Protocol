package solarxr_protocol.data_feed.dongle_data

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UShort
import kotlin.collections.List
import solarxr_protocol.datatypes.hardware_info.HardwareAddress

/**
 * A dongle stays known to the server once it has been seen, so that the devices
 * linked to it keep their association while it is unplugged.
 */
public enum class DongleStatus(
  public val `value`: UByte,
) {
  DISCONNECTED(0.toUByte()),
  CONNECTED(1.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): DongleStatus? = entries.firstOrNull { it.value == value }
  }
}

public data class DongleDataMask(
  public val displayName: Boolean? = null,
  public val hardwareRevision: Boolean? = null,
  public val model: Boolean? = null,
  public val manufacturer: Boolean? = null,
  public val firmwareVersion: Boolean? = null,
  public val firmwareDate: Boolean? = null,
  public val hardwareAddress: Boolean? = null,
  public val boardType: Boolean? = null,
  public val devicesIds: Boolean? = null,
  public val status: Boolean? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(10)
    if (displayName != null) { builder.forceDefaults(true); builder.addBoolean(0, displayName, false); builder.forceDefaults(false) }
    if (hardwareRevision != null) { builder.forceDefaults(true); builder.addBoolean(1, hardwareRevision, false); builder.forceDefaults(false) }
    if (model != null) { builder.forceDefaults(true); builder.addBoolean(2, model, false); builder.forceDefaults(false) }
    if (manufacturer != null) { builder.forceDefaults(true); builder.addBoolean(3, manufacturer, false); builder.forceDefaults(false) }
    if (firmwareVersion != null) { builder.forceDefaults(true); builder.addBoolean(4, firmwareVersion, false); builder.forceDefaults(false) }
    if (firmwareDate != null) { builder.forceDefaults(true); builder.addBoolean(5, firmwareDate, false); builder.forceDefaults(false) }
    if (hardwareAddress != null) { builder.forceDefaults(true); builder.addBoolean(6, hardwareAddress, false); builder.forceDefaults(false) }
    if (boardType != null) { builder.forceDefaults(true); builder.addBoolean(7, boardType, false); builder.forceDefaults(false) }
    if (devicesIds != null) { builder.forceDefaults(true); builder.addBoolean(8, devicesIds, false); builder.forceDefaults(false) }
    if (status != null) { builder.forceDefaults(true); builder.addBoolean(9, status, false); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): DongleDataMask {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_displayName = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_hardwareRevision = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_model = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_manufacturer = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_firmwareVersion = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_firmwareDate = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_hardwareAddress = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_boardType = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_devicesIds = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_status = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0

      return DongleDataMask(
              displayName = if (__offset_displayName != 0) bb.get(tableOffset + __offset_displayName) != 0.toByte() else null,
              hardwareRevision = if (__offset_hardwareRevision != 0) bb.get(tableOffset + __offset_hardwareRevision) != 0.toByte() else null,
              model = if (__offset_model != 0) bb.get(tableOffset + __offset_model) != 0.toByte() else null,
              manufacturer = if (__offset_manufacturer != 0) bb.get(tableOffset + __offset_manufacturer) != 0.toByte() else null,
              firmwareVersion = if (__offset_firmwareVersion != 0) bb.get(tableOffset + __offset_firmwareVersion) != 0.toByte() else null,
              firmwareDate = if (__offset_firmwareDate != 0) bb.get(tableOffset + __offset_firmwareDate) != 0.toByte() else null,
              hardwareAddress = if (__offset_hardwareAddress != 0) bb.get(tableOffset + __offset_hardwareAddress) != 0.toByte() else null,
              boardType = if (__offset_boardType != 0) bb.get(tableOffset + __offset_boardType) != 0.toByte() else null,
              devicesIds = if (__offset_devicesIds != 0) bb.get(tableOffset + __offset_devicesIds) != 0.toByte() else null,
              status = if (__offset_status != 0) bb.get(tableOffset + __offset_status) != 0.toByte() else null
          )
    }
  }
}

public data class DongleData(
  public val id: UShort? = null,
  public val displayName: String? = null,
  public val hardwareRevision: String? = null,
  public val model: String? = null,
  public val manufacturer: String? = null,
  public val firmwareVersion: String? = null,
  public val firmwareDate: String? = null,
  public val hardwareAddress: HardwareAddress? = null,
  public val boardType: String? = null,
  public val devicesIds: List<UShort>? = null,
  public val status: DongleStatus? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_displayName = displayName?.let { builder.createString(it) }
    val __off_hardwareRevision = hardwareRevision?.let { builder.createString(it) }
    val __off_model = model?.let { builder.createString(it) }
    val __off_manufacturer = manufacturer?.let { builder.createString(it) }
    val __off_firmwareVersion = firmwareVersion?.let { builder.createString(it) }
    val __off_firmwareDate = firmwareDate?.let { builder.createString(it) }
    val __off_boardType = boardType?.let { builder.createString(it) }
    val __off_devicesIds = devicesIds?.let { run { val values = it; builder.startVector(2, values.size, 2); for (value in values.asReversed()) builder.putShort(value.toShort()); builder.endVector() } }

    builder.startTable(11)
    if (id != null) { builder.forceDefaults(true); builder.addShort(0, id.toShort(), 0); builder.forceDefaults(false) }
    __off_displayName?.let { builder.addOffset(1, it, 0) }
    __off_hardwareRevision?.let { builder.addOffset(2, it, 0) }
    __off_model?.let { builder.addOffset(3, it, 0) }
    __off_manufacturer?.let { builder.addOffset(4, it, 0) }
    __off_firmwareVersion?.let { builder.addOffset(5, it, 0) }
    __off_firmwareDate?.let { builder.addOffset(6, it, 0) }
    hardwareAddress?.let { builder.addStruct(7, it.encode(builder), 0) }
    __off_boardType?.let { builder.addOffset(8, it, 0) }
    __off_devicesIds?.let { builder.addOffset(9, it, 0) }
    if (status != null) { builder.forceDefaults(true); builder.addByte(10, status.value.toByte(), 0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): DongleData {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_id = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_displayName = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_hardwareRevision = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_model = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_manufacturer = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_firmwareVersion = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_firmwareDate = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_hardwareAddress = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_boardType = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_devicesIds = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_status = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0

      return DongleData(
              id = if (__offset_id != 0) bb.getShort(tableOffset + __offset_id).toUShort() else null,
              displayName = if (__offset_displayName != 0) readFlatBufferString(bb, tableOffset + __offset_displayName) else null,
              hardwareRevision = if (__offset_hardwareRevision != 0) readFlatBufferString(bb, tableOffset + __offset_hardwareRevision) else null,
              model = if (__offset_model != 0) readFlatBufferString(bb, tableOffset + __offset_model) else null,
              manufacturer = if (__offset_manufacturer != 0) readFlatBufferString(bb, tableOffset + __offset_manufacturer) else null,
              firmwareVersion = if (__offset_firmwareVersion != 0) readFlatBufferString(bb, tableOffset + __offset_firmwareVersion) else null,
              firmwareDate = if (__offset_firmwareDate != 0) readFlatBufferString(bb, tableOffset + __offset_firmwareDate) else null,
              hardwareAddress = if (__offset_hardwareAddress != 0) HardwareAddress.decode(bb, tableOffset + __offset_hardwareAddress) else null,
              boardType = if (__offset_boardType != 0) readFlatBufferString(bb, tableOffset + __offset_boardType) else null,
              devicesIds = if (__offset_devicesIds != 0) { val vecOff = tableOffset + __offset_devicesIds + bb.getInt(tableOffset + __offset_devicesIds); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> bb.getShort(vecOff + 4 + i * 2).toUShort() } } else null,
              status = if (__offset_status != 0) DongleStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) else null
          )
    }
  }
}
