package fixture.scalars

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import kotlin.Boolean
import kotlin.Byte
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort

public data class AllScalarStruct(
  public val b: Boolean,
  public val i8: Byte,
  public val u8: UByte,
  public val i16: Short,
  public val u16: UShort,
  public val i32: Int,
  public val u32: UInt,
  public val i64: Long,
  public val u64: ULong,
  public val f32: Float,
  public val f64: Double,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.prep(8, 48)
    var written = 0
    builder.pad(0 - written)
    builder.putDouble(f64)
    written = 8
    builder.pad(12 - written)
    builder.putFloat(f32)
    written = 16
    builder.pad(16 - written)
    builder.putLong(u64.toLong())
    written = 24
    builder.pad(24 - written)
    builder.putLong(i64)
    written = 32
    builder.pad(32 - written)
    builder.putInt(u32.toInt())
    written = 36
    builder.pad(36 - written)
    builder.putInt(i32)
    written = 40
    builder.pad(40 - written)
    builder.putShort(u16.toShort())
    written = 42
    builder.pad(42 - written)
    builder.putShort(i16)
    written = 44
    builder.pad(45 - written)
    builder.putByte(u8.toByte())
    written = 46
    builder.pad(46 - written)
    builder.putByte(i8)
    written = 47
    builder.pad(47 - written)
    builder.putByte(if (b) 1.toByte() else 0.toByte())
    written = 48
    return builder.offset()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, offset: Int): AllScalarStruct = AllScalarStruct(b = bb.get(offset + 0) != 0.toByte(), i8 = bb.get(offset + 1), u8 = bb.get(offset + 2).toUByte(), i16 = bb.getShort(offset + 4), u16 = bb.getShort(offset + 6).toUShort(), i32 = bb.getInt(offset + 8), u32 = bb.getInt(offset + 12).toUInt(), i64 = bb.getLong(offset + 16), u64 = bb.getLong(offset + 24).toULong(), f32 = bb.getFloat(offset + 32), f64 = bb.getDouble(offset + 40))
  }
}

public data class OptionalScalars(
  public val obool: Boolean? = null,
  public val oi8: Byte? = null,
  public val ou8: UByte? = null,
  public val oi16: Short? = null,
  public val ou16: UShort? = null,
  public val oi32: Int? = null,
  public val ou32: UInt? = null,
  public val oi64: Long? = null,
  public val ou64: ULong? = null,
  public val of32: Float? = null,
  public val of64: Double? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(11)
    if (obool != null) { builder.forceDefaults(true); builder.addBoolean(0, obool, false); builder.forceDefaults(false) }
    if (oi8 != null) { builder.forceDefaults(true); builder.addByte(1, oi8, 0); builder.forceDefaults(false) }
    if (ou8 != null) { builder.forceDefaults(true); builder.addByte(2, ou8.toByte(), 0); builder.forceDefaults(false) }
    if (oi16 != null) { builder.forceDefaults(true); builder.addShort(3, oi16, 0); builder.forceDefaults(false) }
    if (ou16 != null) { builder.forceDefaults(true); builder.addShort(4, ou16.toShort(), 0); builder.forceDefaults(false) }
    if (oi32 != null) { builder.forceDefaults(true); builder.addInt(5, oi32, 0); builder.forceDefaults(false) }
    if (ou32 != null) { builder.forceDefaults(true); builder.addInt(6, ou32.toInt(), 0); builder.forceDefaults(false) }
    if (oi64 != null) { builder.forceDefaults(true); builder.addLong(7, oi64, 0L); builder.forceDefaults(false) }
    if (ou64 != null) { builder.forceDefaults(true); builder.addLong(8, ou64.toLong(), 0L); builder.forceDefaults(false) }
    if (of32 != null) { builder.forceDefaults(true); builder.addFloat(9, of32, 0.0); builder.forceDefaults(false) }
    if (of64 != null) { builder.forceDefaults(true); builder.addDouble(10, of64, 0.0); builder.forceDefaults(false) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): OptionalScalars {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_obool = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_oi8 = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_ou8 = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_oi16 = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_ou16 = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_oi32 = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_ou32 = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_oi64 = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_ou64 = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_of32 = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_of64 = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0

      return OptionalScalars(
              obool = if (__offset_obool != 0) bb.get(tableOffset + __offset_obool) != 0.toByte() else null,
              oi8 = if (__offset_oi8 != 0) bb.get(tableOffset + __offset_oi8) else null,
              ou8 = if (__offset_ou8 != 0) bb.get(tableOffset + __offset_ou8).toUByte() else null,
              oi16 = if (__offset_oi16 != 0) bb.getShort(tableOffset + __offset_oi16) else null,
              ou16 = if (__offset_ou16 != 0) bb.getShort(tableOffset + __offset_ou16).toUShort() else null,
              oi32 = if (__offset_oi32 != 0) bb.getInt(tableOffset + __offset_oi32) else null,
              ou32 = if (__offset_ou32 != 0) bb.getInt(tableOffset + __offset_ou32).toUInt() else null,
              oi64 = if (__offset_oi64 != 0) bb.getLong(tableOffset + __offset_oi64) else null,
              ou64 = if (__offset_ou64 != 0) bb.getLong(tableOffset + __offset_ou64).toULong() else null,
              of32 = if (__offset_of32 != 0) bb.getFloat(tableOffset + __offset_of32) else null,
              of64 = if (__offset_of64 != 0) bb.getDouble(tableOffset + __offset_of64) else null
          )
    }
  }
}

public data class DefaultScalars(
  public val dbool: Boolean = true,
  public val di8: Byte = -12,
  public val du8: UByte = 250.toUByte(),
  public val di16: Short = -1234,
  public val du16: UShort = 65000.toUShort(),
  public val di32: Int = -12345678,
  public val du32: UInt = 4000000000u,
  public val di64: Long = -1234567890123L,
  public val du64: ULong = 9000000000000000000uL,
  public val df32: Float = 1.5f,
  public val df64: Double = -2.25,
) {
  public fun encode(builder: FlatBufferWriter): Int {

    builder.startTable(11)
    builder.addBoolean(0, dbool, true)
    builder.addByte(1, di8, -12)
    builder.addByte(2, du8.toByte(), 250)
    builder.addShort(3, di16, -1234)
    builder.addShort(4, du16.toShort(), 65000)
    builder.addInt(5, di32, -12345678)
    builder.addInt(6, du32.toInt(), 4000000000u.toInt())
    builder.addLong(7, di64, -1234567890123L)
    builder.addLong(8, du64.toLong(), 9000000000000000000uL.toLong())
    builder.addFloat(9, df32, 1.5)
    builder.addDouble(10, df64, -2.25)
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): DefaultScalars {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_dbool = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_di8 = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_du8 = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_di16 = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_du16 = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_di32 = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_du32 = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_di64 = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_du64 = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_df32 = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_df64 = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0

      return DefaultScalars(
              dbool = if (__offset_dbool != 0) bb.get(tableOffset + __offset_dbool) != 0.toByte() else true,
              di8 = if (__offset_di8 != 0) bb.get(tableOffset + __offset_di8) else -12,
              du8 = if (__offset_du8 != 0) bb.get(tableOffset + __offset_du8).toUByte() else 250.toUByte(),
              di16 = if (__offset_di16 != 0) bb.getShort(tableOffset + __offset_di16) else -1234,
              du16 = if (__offset_du16 != 0) bb.getShort(tableOffset + __offset_du16).toUShort() else 65000.toUShort(),
              di32 = if (__offset_di32 != 0) bb.getInt(tableOffset + __offset_di32) else -12345678,
              du32 = if (__offset_du32 != 0) bb.getInt(tableOffset + __offset_du32).toUInt() else 4000000000u,
              di64 = if (__offset_di64 != 0) bb.getLong(tableOffset + __offset_di64) else -1234567890123L,
              du64 = if (__offset_du64 != 0) bb.getLong(tableOffset + __offset_du64).toULong() else 9000000000000000000uL,
              df32 = if (__offset_df32 != 0) bb.getFloat(tableOffset + __offset_df32) else 1.5f,
              df64 = if (__offset_df64 != 0) bb.getDouble(tableOffset + __offset_df64) else -2.25
          )
    }
  }
}
