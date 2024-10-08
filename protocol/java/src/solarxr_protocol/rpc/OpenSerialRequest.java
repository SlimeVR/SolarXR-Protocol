// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class OpenSerialRequest extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_22_10_26(); }
  public static OpenSerialRequest getRootAsOpenSerialRequest(ByteBuffer _bb) { return getRootAsOpenSerialRequest(_bb, new OpenSerialRequest()); }
  public static OpenSerialRequest getRootAsOpenSerialRequest(ByteBuffer _bb, OpenSerialRequest obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public OpenSerialRequest __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  /**
   * Automatically pick the first serial device available
   */
  public boolean auto() { int o = __offset(4); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  public String port() { int o = __offset(6); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer portAsByteBuffer() { return __vector_as_bytebuffer(6, 1); }
  public ByteBuffer portInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 6, 1); }

  public static int createOpenSerialRequest(FlatBufferBuilder builder,
      boolean auto,
      int portOffset) {
    builder.startTable(2);
    OpenSerialRequest.addPort(builder, portOffset);
    OpenSerialRequest.addAuto(builder, auto);
    return OpenSerialRequest.endOpenSerialRequest(builder);
  }

  public static void startOpenSerialRequest(FlatBufferBuilder builder) { builder.startTable(2); }
  public static void addAuto(FlatBufferBuilder builder, boolean auto) { builder.addBoolean(0, auto, false); }
  public static void addPort(FlatBufferBuilder builder, int portOffset) { builder.addOffset(1, portOffset, 0); }
  public static int endOpenSerialRequest(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public OpenSerialRequest get(int j) { return get(new OpenSerialRequest(), j); }
    public OpenSerialRequest get(OpenSerialRequest obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public OpenSerialRequestT unpack() {
    OpenSerialRequestT _o = new OpenSerialRequestT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(OpenSerialRequestT _o) {
    boolean _oAuto = auto();
    _o.setAuto(_oAuto);
    String _oPort = port();
    _o.setPort(_oPort);
  }
  public static int pack(FlatBufferBuilder builder, OpenSerialRequestT _o) {
    if (_o == null) return 0;
    int _port = _o.getPort() == null ? 0 : builder.createString(_o.getPort());
    return createOpenSerialRequest(
      builder,
      _o.getAuto(),
      _port);
  }
}

