package fixture.complex

import dev.slimevr.fbscodegen.runtime.FlatBufferReader
import dev.slimevr.fbscodegen.runtime.FlatBufferWriter
import dev.slimevr.fbscodegen.runtime.readFlatBufferString
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.collections.List

public enum class TestEnum(
  public val `value`: UByte,
) {
  A(0.toUByte()),
  B(1.toUByte()),
  C(2.toUByte()),
  ;

  public companion object {
    public fun fromValue(`value`: UByte): TestEnum? = entries.firstOrNull { it.value == value }
  }
}

public data class TestStruct(
  public val a: Int,
  public val b: Float,
) : TestUnion {
  public fun encode(builder: FlatBufferWriter): Int {
    builder.prep(4, 8)
    var written = 0
    builder.pad(0 - written)
    builder.putFloat(b)
    written = 4
    builder.pad(4 - written)
    builder.putInt(a)
    written = 8
    return builder.offset()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, offset: Int): TestStruct = TestStruct(a = bb.getInt(offset + 0), b = bb.getFloat(offset + 4))
  }
}

public data class TestTable(
  public val name: String? = null,
) : TestUnion {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_name = name?.let { builder.createString(it) }

    builder.startTable(1)
    __off_name?.let { builder.addOffset(0, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): TestTable {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_name = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0

      return TestTable(
              name = if (__offset_name != 0) readFlatBufferString(bb, tableOffset + __offset_name) else null
          )
    }
  }
}

public sealed interface TestUnion {
  public companion object {
    public fun decode(
      type: Byte,
      bb: FlatBufferReader,
      offset: Int,
    ): TestUnion? = when (type.toInt()) {
      1 -> TestStruct.decode(bb, offset)
      2 -> TestTable.decode(bb, offset)
      else -> null
    }

    public fun typeIndex(`value`: TestUnion): Byte = when (value) {
      is TestStruct -> 1
      is TestTable -> 2
    }

    public fun encode(`value`: TestUnion, builder: FlatBufferWriter): Int = when (value) {
      is TestStruct -> value.encode(builder)
      is TestTable -> value.encode(builder)
    }
  }
}

public data class ComplexRoot(
  public val singleEnum: TestEnum? = null,
  public val optionalEnum: TestEnum? = null,
  public val explicitEnum: TestEnum = TestEnum.B,
  public val singleUnion: TestUnion? = null,
  public val enumVector: List<TestEnum>? = null,
) {
  public fun encode(builder: FlatBufferWriter): Int {
    val __off_singleUnion = singleUnion?.let { TestUnion.encode(it, builder) }
    val __type_singleUnion = singleUnion?.let { TestUnion.typeIndex(it) } ?: 0.toByte()
    val __off_enumVector = enumVector?.let { builder.createByteVector(it.map { e -> e.value.toByte() }.toByteArray()) }

    builder.startTable(6)
    if (singleEnum != null) { builder.forceDefaults(true); builder.addByte(0, singleEnum.value.toByte(), 0); builder.forceDefaults(false) }
    if (optionalEnum != null) { builder.forceDefaults(true); builder.addByte(1, optionalEnum.value.toByte(), 0); builder.forceDefaults(false) }
    builder.addByte(2, explicitEnum.value.toByte(), 1)
    builder.addByte(3, __type_singleUnion, 0)
    __off_singleUnion?.let { builder.addOffset(4, it, 0) }
    __off_enumVector?.let { builder.addOffset(5, it, 0) }
    return builder.endTable()
  }

  public companion object {
    public fun decode(bb: FlatBufferReader, tableOffset: Int): ComplexRoot {
      val vtableOffset = tableOffset - bb.getInt(tableOffset)
      val vtableSize = bb.getShort(vtableOffset).toInt()

      val __offset_singleEnum = if (vtableSize > 4) bb.getShort(vtableOffset + 4).toInt() else 0
      val __offset_optionalEnum = if (vtableSize > 6) bb.getShort(vtableOffset + 6).toInt() else 0
      val __offset_explicitEnum = if (vtableSize > 8) bb.getShort(vtableOffset + 8).toInt() else 0
      val __type_singleUnion = if (vtableSize > 10 && bb.getShort(vtableOffset + 10).toInt() != 0) bb.get(tableOffset + bb.getShort(vtableOffset + 10).toInt()) else 0
      val __offset_singleUnion = if (vtableSize > 12) bb.getShort(vtableOffset + 12).toInt() else 0
      val __offset_enumVector = if (vtableSize > 14) bb.getShort(vtableOffset + 14).toInt() else 0

      return ComplexRoot(
              singleEnum = if (__offset_singleEnum != 0) TestEnum.fromValue(bb.get(tableOffset + __offset_singleEnum).toUByte()) else null,
              optionalEnum = if (__offset_optionalEnum != 0) TestEnum.fromValue(bb.get(tableOffset + __offset_optionalEnum).toUByte()) else null,
              explicitEnum = if (__offset_explicitEnum != 0) TestEnum.fromValue(bb.get(tableOffset + __offset_explicitEnum).toUByte()) ?: TestEnum.B else TestEnum.B,
              singleUnion = if (__offset_singleUnion != 0) TestUnion.decode(__type_singleUnion, bb, tableOffset + __offset_singleUnion + bb.getInt(tableOffset + __offset_singleUnion)) else null,
              enumVector = if (__offset_enumVector != 0) { val vecOff = tableOffset + __offset_enumVector + bb.getInt(tableOffset + __offset_enumVector); val len = bb.getInt(vecOff); (0 until len).mapNotNull { i -> TestEnum.fromValue(bb.get(vecOff + 4 + i * 1).toUByte()) } } else null
          )
    }

    public fun fromByteBuffer(bb: FlatBufferReader): ComplexRoot {
      val root = bb.getInt(0) + 0
      return decode(bb, root)
    }
  }
}
