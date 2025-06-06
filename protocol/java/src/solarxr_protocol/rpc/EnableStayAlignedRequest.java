// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class EnableStayAlignedRequest extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_22_10_26(); }
  public static EnableStayAlignedRequest getRootAsEnableStayAlignedRequest(ByteBuffer _bb) { return getRootAsEnableStayAlignedRequest(_bb, new EnableStayAlignedRequest()); }
  public static EnableStayAlignedRequest getRootAsEnableStayAlignedRequest(ByteBuffer _bb, EnableStayAlignedRequest obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public EnableStayAlignedRequest __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public boolean enable() { int o = __offset(4); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }

  public static int createEnableStayAlignedRequest(FlatBufferBuilder builder,
      boolean enable) {
    builder.startTable(1);
    EnableStayAlignedRequest.addEnable(builder, enable);
    return EnableStayAlignedRequest.endEnableStayAlignedRequest(builder);
  }

  public static void startEnableStayAlignedRequest(FlatBufferBuilder builder) { builder.startTable(1); }
  public static void addEnable(FlatBufferBuilder builder, boolean enable) { builder.addBoolean(0, enable, false); }
  public static int endEnableStayAlignedRequest(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public EnableStayAlignedRequest get(int j) { return get(new EnableStayAlignedRequest(), j); }
    public EnableStayAlignedRequest get(EnableStayAlignedRequest obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public EnableStayAlignedRequestT unpack() {
    EnableStayAlignedRequestT _o = new EnableStayAlignedRequestT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(EnableStayAlignedRequestT _o) {
    boolean _oEnable = enable();
    _o.setEnable(_oEnable);
  }
  public static int pack(FlatBufferBuilder builder, EnableStayAlignedRequestT _o) {
    if (_o == null) return 0;
    return createEnableStayAlignedRequest(
      builder,
      _o.getEnable());
  }
}

