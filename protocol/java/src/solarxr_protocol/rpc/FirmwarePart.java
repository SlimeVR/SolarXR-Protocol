// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class FirmwarePart extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_22_10_26(); }
  public static FirmwarePart getRootAsFirmwarePart(ByteBuffer _bb) { return getRootAsFirmwarePart(_bb, new FirmwarePart()); }
  public static FirmwarePart getRootAsFirmwarePart(ByteBuffer _bb, FirmwarePart obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public FirmwarePart __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  /**
   * Url of the firmware bin to download
   */
  public String url() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer urlAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public ByteBuffer urlInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 4, 1); }
  /**
   * Offset of the firmware, used when flashing to the mcu, it indicates where to write this file in memory
   * Will be ignored in the case of OTA flashing
   */
  public long offset() { int o = __offset(6); return o != 0 ? (long)bb.getInt(o + bb_pos) & 0xFFFFFFFFL : 0L; }

  public static int createFirmwarePart(FlatBufferBuilder builder,
      int urlOffset,
      long offset) {
    builder.startTable(2);
    FirmwarePart.addOffset(builder, offset);
    FirmwarePart.addUrl(builder, urlOffset);
    return FirmwarePart.endFirmwarePart(builder);
  }

  public static void startFirmwarePart(FlatBufferBuilder builder) { builder.startTable(2); }
  public static void addUrl(FlatBufferBuilder builder, int urlOffset) { builder.addOffset(0, urlOffset, 0); }
  public static void addOffset(FlatBufferBuilder builder, long offset) { builder.addInt(1, (int) offset, (int) 0L); }
  public static int endFirmwarePart(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public FirmwarePart get(int j) { return get(new FirmwarePart(), j); }
    public FirmwarePart get(FirmwarePart obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public FirmwarePartT unpack() {
    FirmwarePartT _o = new FirmwarePartT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(FirmwarePartT _o) {
    String _oUrl = url();
    _o.setUrl(_oUrl);
    long _oOffset = offset();
    _o.setOffset(_oOffset);
  }
  public static int pack(FlatBufferBuilder builder, FirmwarePartT _o) {
    if (_o == null) return 0;
    int _url = _o.getUrl() == null ? 0 : builder.createString(_o.getUrl());
    return createFirmwarePart(
      builder,
      _url,
      _o.getOffset());
  }
}

