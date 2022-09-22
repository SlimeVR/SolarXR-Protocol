// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.device;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class PairingResponse extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_2_0_0(); }
  public static PairingResponse getRootAsPairingResponse(ByteBuffer _bb) { return getRootAsPairingResponse(_bb, new PairingResponse()); }
  public static PairingResponse getRootAsPairingResponse(ByteBuffer _bb, PairingResponse obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public PairingResponse __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public String error() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer errorAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public ByteBuffer errorInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 4, 1); }

  public static int createPairingResponse(FlatBufferBuilder builder,
      int errorOffset) {
    builder.startTable(1);
    PairingResponse.addError(builder, errorOffset);
    return PairingResponse.endPairingResponse(builder);
  }

  public static void startPairingResponse(FlatBufferBuilder builder) { builder.startTable(1); }
  public static void addError(FlatBufferBuilder builder, int errorOffset) { builder.addOffset(0, errorOffset, 0); }
  public static int endPairingResponse(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public PairingResponse get(int j) { return get(new PairingResponse(), j); }
    public PairingResponse get(PairingResponse obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public PairingResponseT unpack() {
    PairingResponseT _o = new PairingResponseT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(PairingResponseT _o) {
    String _oError = error();
    _o.setError(_oError);
  }
  public static int pack(FlatBufferBuilder builder, PairingResponseT _o) {
    if (_o == null) return 0;
    int _error = _o.getError() == null ? 0 : builder.createString(_o.getError());
    return createPairingResponse(
      builder,
      _error);
  }
}

