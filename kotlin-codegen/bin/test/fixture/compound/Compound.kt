package fixture.compound

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import fixture.scalars.AllScalarStruct
import fixture.scalars.DefaultScalars
import fixture.scalars.OptionalScalars
import kotlin.Boolean
import kotlin.Byte
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Short
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.collections.List

public data class ScalarVectors(
  public val bools: List<Boolean>? = null,
  public val i8s: List<Byte>? = null,
  public val u8s: List<UByte>? = null,
  public val i16s: List<Short>? = null,
  public val u16s: List<UShort>? = null,
  public val i32s: List<Int>? = null,
  public val u32s: List<UInt>? = null,
  public val i64s: List<Long>? = null,
  public val u64s: List<ULong>? = null,
  public val f32s: List<Float>? = null,
  public val f64s: List<Double>? = null,
  public val names: List<String>? = null,
  public val structs: List<AllScalarStruct>? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_bools = bools?.let { run { val values = it; builder.startVector(1, values.size, 1); for (value in values.asReversed()) builder.putByte(if (value) 1.toByte() else 0.toByte()); builder.endVector() } }
    val __off_i8s = i8s?.let { builder.createByteVector(it.map { b -> b }.toByteArray()) }
    val __off_u8s = u8s?.let { builder.createByteVector(it.map { b -> b.toByte() }.toByteArray()) }
    val __off_i16s = i16s?.let { run { val values = it; builder.startVector(2, values.size, 2); for (value in values.asReversed()) builder.putShort(value); builder.endVector() } }
    val __off_u16s = u16s?.let { run { val values = it; builder.startVector(2, values.size, 2); for (value in values.asReversed()) builder.putShort(value.toShort()); builder.endVector() } }
    val __off_i32s = i32s?.let { run { val values = it; builder.startVector(4, values.size, 4); for (value in values.asReversed()) builder.putInt(value); builder.endVector() } }
    val __off_u32s = u32s?.let { run { val values = it; builder.startVector(4, values.size, 4); for (value in values.asReversed()) builder.putInt(value.toInt()); builder.endVector() } }
    val __off_i64s = i64s?.let { run { val values = it; builder.startVector(8, values.size, 8); for (value in values.asReversed()) builder.putLong(value); builder.endVector() } }
    val __off_u64s = u64s?.let { run { val values = it; builder.startVector(8, values.size, 8); for (value in values.asReversed()) builder.putLong(value.toLong()); builder.endVector() } }
    val __off_f32s = f32s?.let { run { val values = it; builder.startVector(4, values.size, 4); for (value in values.asReversed()) builder.putFloat(value); builder.endVector() } }
    val __off_f64s = f64s?.let { run { val values = it; builder.startVector(8, values.size, 8); for (value in values.asReversed()) builder.putDouble(value); builder.endVector() } }
    val __off_names = names?.let { builder.createVectorOfTables(it.map { s -> builder.createString(s) }.toIntArray()) }
    val __off_structs = structs?.let { run { val values = it; builder.startVector(48, values.size, 8); for (value in values.asReversed()) value.encode(builder); builder.endVector() } }

    builder.startTable(13)
    __off_bools?.let { builder.addOffset(0, it, 0) }
    __off_i8s?.let { builder.addOffset(1, it, 0) }
    __off_u8s?.let { builder.addOffset(2, it, 0) }
    __off_i16s?.let { builder.addOffset(3, it, 0) }
    __off_u16s?.let { builder.addOffset(4, it, 0) }
    __off_i32s?.let { builder.addOffset(5, it, 0) }
    __off_u32s?.let { builder.addOffset(6, it, 0) }
    __off_i64s?.let { builder.addOffset(7, it, 0) }
    __off_u64s?.let { builder.addOffset(8, it, 0) }
    __off_f32s?.let { builder.addOffset(9, it, 0) }
    __off_f64s?.let { builder.addOffset(10, it, 0) }
    __off_names?.let { builder.addOffset(11, it, 0) }
    __off_structs?.let { builder.addOffset(12, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ScalarVectors {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_bools = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_i8s = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_u8s = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_i16s = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_u16s = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_i32s = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0
      val __offset_u32s = if (vtableSize > 16) bb.getShort(vtableOffset + 16).toInt() else 0
      val __offset_i64s = if (vtableSize > 18) bb.getShort(vtableOffset + 18).toInt() else 0
      val __offset_u64s = if (vtableSize > 20) bb.getShort(vtableOffset + 20).toInt() else 0
      val __offset_f32s = if (vtableSize > 22) bb.getShort(vtableOffset + 22).toInt() else 0
      val __offset_f64s = if (vtableSize > 24) bb.getShort(vtableOffset + 24).toInt() else 0
      val __offset_names = if (vtableSize > 26) bb.getShort(vtableOffset + 26).toInt() else 0
      val __offset_structs = if (vtableSize > 28) bb.getShort(vtableOffset + 28).toInt() else 0

      return ScalarVectors(
              bools = if (__offset_bools != 0) { val vecOff = tableOffset + __offset_bools + bb.getInt(tableOffset + __offset_bools); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> bb.get(vecOff + 4 + i * 1) != 0.toByte() } } else null,
              i8s = if (__offset_i8s != 0) { val vecOff = tableOffset + __offset_i8s + bb.getInt(tableOffset + __offset_i8s); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> bb.get(vecOff + 4 + i * 1) } } else null,
              u8s = if (__offset_u8s != 0) { val vecOff = tableOffset + __offset_u8s + bb.getInt(tableOffset + __offset_u8s); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> bb.get(vecOff + 4 + i * 1).toUByte() } } else null,
              i16s = if (__offset_i16s != 0) { val vecOff = tableOffset + __offset_i16s + bb.getInt(tableOffset + __offset_i16s); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> bb.getShort(vecOff + 4 + i * 2) } } else null,
              u16s = if (__offset_u16s != 0) { val vecOff = tableOffset + __offset_u16s + bb.getInt(tableOffset + __offset_u16s); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> bb.getShort(vecOff + 4 + i * 2).toUShort() } } else null,
              i32s = if (__offset_i32s != 0) { val vecOff = tableOffset + __offset_i32s + bb.getInt(tableOffset + __offset_i32s); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> bb.getInt(vecOff + 4 + i * 4) } } else null,
              u32s = if (__offset_u32s != 0) { val vecOff = tableOffset + __offset_u32s + bb.getInt(tableOffset + __offset_u32s); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> bb.getInt(vecOff + 4 + i * 4).toUInt() } } else null,
              i64s = if (__offset_i64s != 0) { val vecOff = tableOffset + __offset_i64s + bb.getInt(tableOffset + __offset_i64s); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> bb.getLong(vecOff + 4 + i * 8) } } else null,
              u64s = if (__offset_u64s != 0) { val vecOff = tableOffset + __offset_u64s + bb.getInt(tableOffset + __offset_u64s); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> bb.getLong(vecOff + 4 + i * 8).toULong() } } else null,
              f32s = if (__offset_f32s != 0) { val vecOff = tableOffset + __offset_f32s + bb.getInt(tableOffset + __offset_f32s); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> bb.getFloat(vecOff + 4 + i * 4) } } else null,
              f64s = if (__offset_f64s != 0) { val vecOff = tableOffset + __offset_f64s + bb.getInt(tableOffset + __offset_f64s); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> bb.getDouble(vecOff + 4 + i * 8) } } else null,
              names = if (__offset_names != 0) { val vecOff = tableOffset + __offset_names + bb.getInt(tableOffset + __offset_names); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> readFlatBufferString(bb, vecOff + 4 + i * 4) } } else null,
              structs = if (__offset_structs != 0) { val vecOff = tableOffset + __offset_structs + bb.getInt(tableOffset + __offset_structs); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> AllScalarStruct.decode(bb, vecOff + 4 + i * 48) } } else null
          )
    }
  }
}

public data class NestedStruct(
  public val prefix: UByte,
  public val `inner`: AllScalarStruct,
  public val suffix: Short,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.prep(8, 64)
    var written = 0
    builder.pad(6 - written)
    builder.putShort(suffix)
    written = 8
    builder.pad(8 - written)
    inner.encode(builder)
    written = 56
    builder.pad(63 - written)
    builder.putByte(prefix.toByte())
    written = 64
    return builder.offset()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, offset: Int): NestedStruct = NestedStruct(prefix = bb.get(offset + 0).toUByte(), inner = AllScalarStruct.decode(bb, offset + 8), suffix = bb.getShort(offset + 56))
  }
}

public data class RootTable(
  public val inlineStruct: AllScalarStruct? = null,
  public val nestedStruct: NestedStruct? = null,
  public val optionalScalars: OptionalScalars? = null,
  public val defaultScalars: DefaultScalars? = null,
  public val vectors: ScalarVectors? = null,
  public val label: String? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_optionalScalars = optionalScalars?.encode(builder)
    val __off_defaultScalars = defaultScalars?.encode(builder)
    val __off_vectors = vectors?.encode(builder)
    val __off_label = label?.let { builder.createString(it) }

    builder.startTable(6)
    inlineStruct?.let { builder.addStruct(0, it.encode(builder), 0) }
    nestedStruct?.let { builder.addStruct(1, it.encode(builder), 0) }
    __off_optionalScalars?.let { builder.addOffset(2, it, 0) }
    __off_defaultScalars?.let { builder.addOffset(3, it, 0) }
    __off_vectors?.let { builder.addOffset(4, it, 0) }
    __off_label?.let { builder.addOffset(5, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): RootTable {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_inlineStruct = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_nestedStruct = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_optionalScalars = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __offset_defaultScalars = if (vtableSize > 10) bb.getShort(vtableOffset + 10).toInt() else 0
      val __offset_vectors = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_label = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0

      return RootTable(
              inlineStruct = if (__offset_inlineStruct != 0) AllScalarStruct.decode(bb, tableOffset + __offset_inlineStruct) else null,
              nestedStruct = if (__offset_nestedStruct != 0) NestedStruct.decode(bb, tableOffset + __offset_nestedStruct) else null,
              optionalScalars = if (__offset_optionalScalars != 0) OptionalScalars.decode(bb, tableOffset + __offset_optionalScalars + bb.getInt(tableOffset + __offset_optionalScalars)) else null,
              defaultScalars = if (__offset_defaultScalars != 0) DefaultScalars.decode(bb, tableOffset + __offset_defaultScalars + bb.getInt(tableOffset + __offset_defaultScalars)) else null,
              vectors = if (__offset_vectors != 0) ScalarVectors.decode(bb, tableOffset + __offset_vectors + bb.getInt(tableOffset + __offset_vectors)) else null,
              label = if (__offset_label != 0) readFlatBufferString(bb, tableOffset + __offset_label) else null
          )
    }

    public fun fromByteBuffer(bb: FlatBufferReader): RootTable {
      val root = bb.getInt(0) + 0
      return decode(bb, root)
    }
  }
}
