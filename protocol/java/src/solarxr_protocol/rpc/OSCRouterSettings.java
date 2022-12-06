// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class OSCRouterSettings extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_22_10_26(); }
  public static OSCRouterSettings getRootAsOSCRouterSettings(ByteBuffer _bb) { return getRootAsOSCRouterSettings(_bb, new OSCRouterSettings()); }
  public static OSCRouterSettings getRootAsOSCRouterSettings(ByteBuffer _bb, OSCRouterSettings obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public OSCRouterSettings __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public boolean enabled() { int o = __offset(4); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  public int portIn() { int o = __offset(6); return o != 0 ? bb.getShort(o + bb_pos) & 0xFFFF : 0; }
  public int portOut() { int o = __offset(8); return o != 0 ? bb.getShort(o + bb_pos) & 0xFFFF : 0; }
  public String address() { int o = __offset(10); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer addressAsByteBuffer() { return __vector_as_bytebuffer(10, 1); }
  public ByteBuffer addressInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 10, 1); }

  public static int createOSCRouterSettings(FlatBufferBuilder builder,
      boolean enabled,
      int portIn,
      int portOut,
      int addressOffset) {
    builder.startTable(4);
    OSCRouterSettings.addAddress(builder, addressOffset);
    OSCRouterSettings.addPortOut(builder, portOut);
    OSCRouterSettings.addPortIn(builder, portIn);
    OSCRouterSettings.addEnabled(builder, enabled);
    return OSCRouterSettings.endOSCRouterSettings(builder);
  }

  public static void startOSCRouterSettings(FlatBufferBuilder builder) { builder.startTable(4); }
  public static void addEnabled(FlatBufferBuilder builder, boolean enabled) { builder.addBoolean(0, enabled, false); }
  public static void addPortIn(FlatBufferBuilder builder, int portIn) { builder.addShort(1, (short) portIn, (short) 0); }
  public static void addPortOut(FlatBufferBuilder builder, int portOut) { builder.addShort(2, (short) portOut, (short) 0); }
  public static void addAddress(FlatBufferBuilder builder, int addressOffset) { builder.addOffset(3, addressOffset, 0); }
  public static int endOSCRouterSettings(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public OSCRouterSettings get(int j) { return get(new OSCRouterSettings(), j); }
    public OSCRouterSettings get(OSCRouterSettings obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public OSCRouterSettingsT unpack() {
    OSCRouterSettingsT _o = new OSCRouterSettingsT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(OSCRouterSettingsT _o) {
    boolean _oEnabled = enabled();
    _o.setEnabled(_oEnabled);
    int _oPortIn = portIn();
    _o.setPortIn(_oPortIn);
    int _oPortOut = portOut();
    _o.setPortOut(_oPortOut);
    String _oAddress = address();
    _o.setAddress(_oAddress);
  }
  public static int pack(FlatBufferBuilder builder, OSCRouterSettingsT _o) {
    if (_o == null) return 0;
    int _address = _o.getAddress() == null ? 0 : builder.createString(_o.getAddress());
    return createOSCRouterSettings(
      builder,
      _o.getEnabled(),
      _o.getPortIn(),
      _o.getPortOut(),
      _address);
  }
}
