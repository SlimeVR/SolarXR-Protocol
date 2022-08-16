// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class FilteringSettings extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_2_0_0(); }
  public static FilteringSettings getRootAsFilteringSettings(ByteBuffer _bb) { return getRootAsFilteringSettings(_bb, new FilteringSettings()); }
  public static FilteringSettings getRootAsFilteringSettings(ByteBuffer _bb, FilteringSettings obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public FilteringSettings __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public int type() { int o = __offset(4); return o != 0 ? bb.get(o + bb_pos) & 0xFF : 0; }
  public int amount() { int o = __offset(6); return o != 0 ? bb.get(o + bb_pos) & 0xFF : 0; }
  public int buffer() { int o = __offset(8); return o != 0 ? bb.get(o + bb_pos) & 0xFF : 0; }

  public static int createFilteringSettings(FlatBufferBuilder builder,
      int type,
      int amount,
      int buffer) {
    builder.startTable(3);
    FilteringSettings.addBuffer(builder, buffer);
    FilteringSettings.addAmount(builder, amount);
    FilteringSettings.addType(builder, type);
    return FilteringSettings.endFilteringSettings(builder);
  }

  public static void startFilteringSettings(FlatBufferBuilder builder) { builder.startTable(3); }
  public static void addType(FlatBufferBuilder builder, int type) { builder.addByte(0, (byte) type, (byte) 0); }
  public static void addAmount(FlatBufferBuilder builder, int amount) { builder.addByte(1, (byte) amount, (byte) 0); }
  public static void addBuffer(FlatBufferBuilder builder, int buffer) { builder.addByte(2, (byte) buffer, (byte) 0); }
  public static int endFilteringSettings(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public FilteringSettings get(int j) { return get(new FilteringSettings(), j); }
    public FilteringSettings get(FilteringSettings obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public FilteringSettingsT unpack() {
    FilteringSettingsT _o = new FilteringSettingsT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(FilteringSettingsT _o) {
    int _oType = type();
    _o.setType(_oType);
    int _oAmount = amount();
    _o.setAmount(_oAmount);
    int _oBuffer = buffer();
    _o.setBuffer(_oBuffer);
  }
  public static int pack(FlatBufferBuilder builder, FilteringSettingsT _o) {
    if (_o == null) return 0;
    return createFilteringSettings(
      builder,
      _o.getType(),
      _o.getAmount(),
      _o.getBuffer());
  }
}

