// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class TapDetectionSettings extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_22_10_26(); }
  public static TapDetectionSettings getRootAsTapDetectionSettings(ByteBuffer _bb) { return getRootAsTapDetectionSettings(_bb, new TapDetectionSettings()); }
  public static TapDetectionSettings getRootAsTapDetectionSettings(ByteBuffer _bb, TapDetectionSettings obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public TapDetectionSettings __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public boolean hasTapResetDelay() { return 0 != __offset(4); }
  public float tapResetDelay() { int o = __offset(4); return o != 0 ? bb.getFloat(o + bb_pos) : 0f; }
  public boolean hasTapResetEnabled() { return 0 != __offset(6); }
  public boolean tapResetEnabled() { int o = __offset(6); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  public boolean hasTapQuickResetEnabled() { return 0 != __offset(8); }
  public boolean tapQuickResetEnabled() { int o = __offset(8); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  public boolean hasTapMountingResetEnabled() { return 0 != __offset(10); }
  public boolean tapMountingResetEnabled() { int o = __offset(10); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }

  public static int createTapDetectionSettings(FlatBufferBuilder builder,
      float tapResetDelay,
      boolean tapResetEnabled,
      boolean tapQuickResetEnabled,
      boolean tapMountingResetEnabled) {
    builder.startTable(4);
    TapDetectionSettings.addTapResetDelay(builder, tapResetDelay);
    TapDetectionSettings.addTapMountingResetEnabled(builder, tapMountingResetEnabled);
    TapDetectionSettings.addTapQuickResetEnabled(builder, tapQuickResetEnabled);
    TapDetectionSettings.addTapResetEnabled(builder, tapResetEnabled);
    return TapDetectionSettings.endTapDetectionSettings(builder);
  }

  public static void startTapDetectionSettings(FlatBufferBuilder builder) { builder.startTable(4); }
  public static void addTapResetDelay(FlatBufferBuilder builder, float tapResetDelay) { builder.addFloat(0, tapResetDelay, 0f); }
  public static void addTapResetEnabled(FlatBufferBuilder builder, boolean tapResetEnabled) { builder.addBoolean(1, tapResetEnabled, false); }
  public static void addTapQuickResetEnabled(FlatBufferBuilder builder, boolean tapQuickResetEnabled) { builder.addBoolean(2, tapQuickResetEnabled, false); }
  public static void addTapMountingResetEnabled(FlatBufferBuilder builder, boolean tapMountingResetEnabled) { builder.addBoolean(3, tapMountingResetEnabled, false); }
  public static int endTapDetectionSettings(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public TapDetectionSettings get(int j) { return get(new TapDetectionSettings(), j); }
    public TapDetectionSettings get(TapDetectionSettings obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public TapDetectionSettingsT unpack() {
    TapDetectionSettingsT _o = new TapDetectionSettingsT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(TapDetectionSettingsT _o) {
    Float _oTapResetDelay = hasTapResetDelay() ? tapResetDelay() : null;
    _o.setTapResetDelay(_oTapResetDelay);
    Boolean _oTapResetEnabled = hasTapResetEnabled() ? tapResetEnabled() : null;
    _o.setTapResetEnabled(_oTapResetEnabled);
    Boolean _oTapQuickResetEnabled = hasTapQuickResetEnabled() ? tapQuickResetEnabled() : null;
    _o.setTapQuickResetEnabled(_oTapQuickResetEnabled);
    Boolean _oTapMountingResetEnabled = hasTapMountingResetEnabled() ? tapMountingResetEnabled() : null;
    _o.setTapMountingResetEnabled(_oTapMountingResetEnabled);
  }
  public static int pack(FlatBufferBuilder builder, TapDetectionSettingsT _o) {
    if (_o == null) return 0;
    return createTapDetectionSettings(
      builder,
      _o.getTapResetDelay(),
      _o.getTapResetEnabled(),
      _o.getTapQuickResetEnabled(),
      _o.getTapMountingResetEnabled());
  }
}

