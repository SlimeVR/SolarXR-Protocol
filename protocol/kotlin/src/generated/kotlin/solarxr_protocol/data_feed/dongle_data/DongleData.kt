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
  NONE(0.toUByte()),
  DISCONNECTED(1.toUByte()),
  CONNECTED(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): DongleStatus? = entries.firstOrNull { it.value == value }
  }
}

public data class DongleDataMask(
  public val displayName: Boolean = false,
  public val customName: Boolean = false,
  public val hardwareRevision: Boolean = false,
  public val model: Boolean = false,
  public val manufacturer: Boolean = false,
  public val firmwareVersion: Boolean = false,
  public val firmwareDate: Boolean = false,
  public val hardwareAddress: Boolean = false,
  public val boardType: Boolean = false,
  public val devicesIds: Boolean = false,
  public val status: Boolean = false,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(11)
    builder.addBoolean(0, displayName, false)
    builder.addBoolean(1, customName, false)
    builder.addBoolean(2, hardwareRevision, false)
    builder.addBoolean(3, model, false)
    builder.addBoolean(4, manufacturer, false)
    builder.addBoolean(5, firmwareVersion, false)
    builder.addBoolean(6, firmwareDate, false)
    builder.addBoolean(7, hardwareAddress, false)
    builder.addBoolean(8, boardType, false)
    builder.addBoolean(9, devicesIds, false)
    builder.addBoolean(10, status, false)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): DongleDataMask {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_displayName = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_customName = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_hardwareRevision = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_model = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_manufacturer = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_firmwareVersion = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_firmwareDate = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_hardwareAddress = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_boardType = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_devicesIds = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_status = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0

      return DongleDataMask(
              displayName = if (__offset_displayName != 0) bb.get(tableOffset + __offset_displayName) != 0.toByte() else false,
              customName = if (__offset_customName != 0) bb.get(tableOffset + __offset_customName) != 0.toByte() else false,
              hardwareRevision = if (__offset_hardwareRevision != 0) bb.get(tableOffset + __offset_hardwareRevision) != 0.toByte() else false,
              model = if (__offset_model != 0) bb.get(tableOffset + __offset_model) != 0.toByte() else false,
              manufacturer = if (__offset_manufacturer != 0) bb.get(tableOffset + __offset_manufacturer) != 0.toByte() else false,
              firmwareVersion = if (__offset_firmwareVersion != 0) bb.get(tableOffset + __offset_firmwareVersion) != 0.toByte() else false,
              firmwareDate = if (__offset_firmwareDate != 0) bb.get(tableOffset + __offset_firmwareDate) != 0.toByte() else false,
              hardwareAddress = if (__offset_hardwareAddress != 0) bb.get(tableOffset + __offset_hardwareAddress) != 0.toByte() else false,
              boardType = if (__offset_boardType != 0) bb.get(tableOffset + __offset_boardType) != 0.toByte() else false,
              devicesIds = if (__offset_devicesIds != 0) bb.get(tableOffset + __offset_devicesIds) != 0.toByte() else false,
              status = if (__offset_status != 0) bb.get(tableOffset + __offset_status) != 0.toByte() else false
          )
    }
  }
}

public data class DongleData(
  public val id: UShort = 0.toUShort(),
  public val displayName: String? = null,
  public val customName: String? = null,
  public val hardwareRevision: String? = null,
  public val model: String? = null,
  public val manufacturer: String? = null,
  public val firmwareVersion: String? = null,
  public val firmwareDate: String? = null,
  public val hardwareAddress: HardwareAddress? = null,
  public val boardType: String? = null,
  public val devicesIds: List<UShort>? = null,
  public val status: DongleStatus = DongleStatus.NONE,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_displayName = displayName?.let { builder.createString(it) }
    val __off_customName = customName?.let { builder.createString(it) }
    val __off_hardwareRevision = hardwareRevision?.let { builder.createString(it) }
    val __off_model = model?.let { builder.createString(it) }
    val __off_manufacturer = manufacturer?.let { builder.createString(it) }
    val __off_firmwareVersion = firmwareVersion?.let { builder.createString(it) }
    val __off_firmwareDate = firmwareDate?.let { builder.createString(it) }
    val __off_boardType = boardType?.let { builder.createString(it) }
    val __off_devicesIds = devicesIds?.let { run { val values = it; builder.startVector(2, values.size, 2); for (value in values.asReversed()) builder.putShort(value.toShort()); builder.endVector() } }

    builder.startTable(12)
    builder.addShort(0, id.toShort(), 0)
    __off_displayName?.let { builder.addOffset(1, it, 0) }
    __off_customName?.let { builder.addOffset(2, it, 0) }
    __off_hardwareRevision?.let { builder.addOffset(3, it, 0) }
    __off_model?.let { builder.addOffset(4, it, 0) }
    __off_manufacturer?.let { builder.addOffset(5, it, 0) }
    __off_firmwareVersion?.let { builder.addOffset(6, it, 0) }
    __off_firmwareDate?.let { builder.addOffset(7, it, 0) }
    hardwareAddress?.let { builder.addStruct(8, it.encode(builder), 0) }
    __off_boardType?.let { builder.addOffset(9, it, 0) }
    __off_devicesIds?.let { builder.addOffset(10, it, 0) }
    builder.addByte(11, status.value.toByte(), 0)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): DongleData {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_id = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_displayName = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_customName = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_hardwareRevision = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_model = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_manufacturer = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_firmwareVersion = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_firmwareDate = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_hardwareAddress = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_boardType = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_devicesIds = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_status = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0

      return DongleData(
              id = if (__offset_id != 0) bb.getShort(tableOffset + __offset_id).toUShort() else 0.toUShort(),
              displayName = if (__offset_displayName != 0) readFlatBufferString(bb, tableOffset + __offset_displayName) else null,
              customName = if (__offset_customName != 0) readFlatBufferString(bb, tableOffset + __offset_customName) else null,
              hardwareRevision = if (__offset_hardwareRevision != 0) readFlatBufferString(bb, tableOffset + __offset_hardwareRevision) else null,
              model = if (__offset_model != 0) readFlatBufferString(bb, tableOffset + __offset_model) else null,
              manufacturer = if (__offset_manufacturer != 0) readFlatBufferString(bb, tableOffset + __offset_manufacturer) else null,
              firmwareVersion = if (__offset_firmwareVersion != 0) readFlatBufferString(bb, tableOffset + __offset_firmwareVersion) else null,
              firmwareDate = if (__offset_firmwareDate != 0) readFlatBufferString(bb, tableOffset + __offset_firmwareDate) else null,
              hardwareAddress = if (__offset_hardwareAddress != 0) HardwareAddress.decode(bb, tableOffset + __offset_hardwareAddress) else null,
              boardType = if (__offset_boardType != 0) readFlatBufferString(bb, tableOffset + __offset_boardType) else null,
              devicesIds = if (__offset_devicesIds != 0) { val vecOff = tableOffset + __offset_devicesIds + bb.getInt(tableOffset + __offset_devicesIds); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> bb.getShort(vecOff + 4 + i * 2).toUShort() } } else null,
              status = if (__offset_status != 0) DongleStatus.fromValue(bb.get(tableOffset + __offset_status).toUByte()) ?: DongleStatus.NONE else DongleStatus.NONE
          )
    }
  }
}
