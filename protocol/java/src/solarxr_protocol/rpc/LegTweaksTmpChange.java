// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

/**
 * Makes a temporary change to legtweaks. This is not saved to disk, and can be
 * cleared with `LegTweaksTmpClear`
 */
@SuppressWarnings("unused")
public final class LegTweaksTmpChange extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_22_10_26(); }
  public static LegTweaksTmpChange getRootAsLegTweaksTmpChange(ByteBuffer _bb) { return getRootAsLegTweaksTmpChange(_bb, new LegTweaksTmpChange()); }
  public static LegTweaksTmpChange getRootAsLegTweaksTmpChange(ByteBuffer _bb, LegTweaksTmpChange obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public LegTweaksTmpChange __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public boolean hasFloorClip() { return 0 != __offset(4); }
  public boolean floorClip() { int o = __offset(4); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  public boolean hasSkatingCorrection() { return 0 != __offset(6); }
  public boolean skatingCorrection() { int o = __offset(6); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  public boolean hasToeSnap() { return 0 != __offset(8); }
  public boolean toeSnap() { int o = __offset(8); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  public boolean hasFootPlant() { return 0 != __offset(10); }
  public boolean footPlant() { int o = __offset(10); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }

  public static int createLegTweaksTmpChange(FlatBufferBuilder builder,
      boolean floorClip,
      boolean skatingCorrection,
      boolean toeSnap,
      boolean footPlant) {
    builder.startTable(4);
    LegTweaksTmpChange.addFootPlant(builder, footPlant);
    LegTweaksTmpChange.addToeSnap(builder, toeSnap);
    LegTweaksTmpChange.addSkatingCorrection(builder, skatingCorrection);
    LegTweaksTmpChange.addFloorClip(builder, floorClip);
    return LegTweaksTmpChange.endLegTweaksTmpChange(builder);
  }

  public static void startLegTweaksTmpChange(FlatBufferBuilder builder) { builder.startTable(4); }
  public static void addFloorClip(FlatBufferBuilder builder, boolean floorClip) { builder.addBoolean(0, floorClip, false); }
  public static void addSkatingCorrection(FlatBufferBuilder builder, boolean skatingCorrection) { builder.addBoolean(1, skatingCorrection, false); }
  public static void addToeSnap(FlatBufferBuilder builder, boolean toeSnap) { builder.addBoolean(2, toeSnap, false); }
  public static void addFootPlant(FlatBufferBuilder builder, boolean footPlant) { builder.addBoolean(3, footPlant, false); }
  public static int endLegTweaksTmpChange(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public LegTweaksTmpChange get(int j) { return get(new LegTweaksTmpChange(), j); }
    public LegTweaksTmpChange get(LegTweaksTmpChange obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public LegTweaksTmpChangeT unpack() {
    LegTweaksTmpChangeT _o = new LegTweaksTmpChangeT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(LegTweaksTmpChangeT _o) {
    Boolean _oFloorClip = hasFloorClip() ? floorClip() : null;
    _o.setFloorClip(_oFloorClip);
    Boolean _oSkatingCorrection = hasSkatingCorrection() ? skatingCorrection() : null;
    _o.setSkatingCorrection(_oSkatingCorrection);
    Boolean _oToeSnap = hasToeSnap() ? toeSnap() : null;
    _o.setToeSnap(_oToeSnap);
    Boolean _oFootPlant = hasFootPlant() ? footPlant() : null;
    _o.setFootPlant(_oFootPlant);
  }
  public static int pack(FlatBufferBuilder builder, LegTweaksTmpChangeT _o) {
    if (_o == null) return 0;
    return createLegTweaksTmpChange(
      builder,
      _o.getFloorClip(),
      _o.getSkatingCorrection(),
      _o.getToeSnap(),
      _o.getFootPlant());
  }
}

