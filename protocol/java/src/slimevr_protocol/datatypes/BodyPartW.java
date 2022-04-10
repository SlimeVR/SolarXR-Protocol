// automatically generated by the FlatBuffers compiler, do not modify

package slimevr_protocol.datatypes;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

/**
 * Wraps `BodyPart`
 */
@SuppressWarnings("unused")
public final class BodyPartW extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_2_0_0(); }
  public static BodyPartW getRootAsBodyPartW(ByteBuffer _bb) { return getRootAsBodyPartW(_bb, new BodyPartW()); }
  public static BodyPartW getRootAsBodyPartW(ByteBuffer _bb, BodyPartW obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public BodyPartW __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public int e() { int o = __offset(4); return o != 0 ? bb.get(o + bb_pos) & 0xFF : 0; }

  public static int createBodyPartW(FlatBufferBuilder builder,
      int e) {
    builder.startTable(1);
    BodyPartW.addE(builder, e);
    return BodyPartW.endBodyPartW(builder);
  }

  public static void startBodyPartW(FlatBufferBuilder builder) { builder.startTable(1); }
  public static void addE(FlatBufferBuilder builder, int e) { builder.addByte(0, (byte) e, (byte) 0); }
  public static int endBodyPartW(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public BodyPartW get(int j) { return get(new BodyPartW(), j); }
    public BodyPartW get(BodyPartW obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public BodyPartWT unpack() {
    BodyPartWT _o = new BodyPartWT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(BodyPartWT _o) {
    int _oE = e();
    _o.setE(_oE);
  }
  public static int pack(FlatBufferBuilder builder, BodyPartWT _o) {
    if (_o == null) return 0;
    return createBodyPartW(
      builder,
      _o.getE());
  }
}

