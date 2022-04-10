// automatically generated by the FlatBuffers compiler, do not modify

package slimevr_protocol.data_feed.tracker;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class TrackerDataComponentW extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_2_0_0(); }
  public static TrackerDataComponentW getRootAsTrackerDataComponentW(ByteBuffer _bb) { return getRootAsTrackerDataComponentW(_bb, new TrackerDataComponentW()); }
  public static TrackerDataComponentW getRootAsTrackerDataComponentW(ByteBuffer _bb, TrackerDataComponentW obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public TrackerDataComponentW __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public byte uType() { int o = __offset(4); return o != 0 ? bb.get(o + bb_pos) : 0; }
  public Table u(Table obj) { int o = __offset(6); return o != 0 ? __union(obj, o + bb_pos) : null; }

  public static int createTrackerDataComponentW(FlatBufferBuilder builder,
      byte uType,
      int uOffset) {
    builder.startTable(2);
    TrackerDataComponentW.addU(builder, uOffset);
    TrackerDataComponentW.addUType(builder, uType);
    return TrackerDataComponentW.endTrackerDataComponentW(builder);
  }

  public static void startTrackerDataComponentW(FlatBufferBuilder builder) { builder.startTable(2); }
  public static void addUType(FlatBufferBuilder builder, byte uType) { builder.addByte(0, uType, 0); }
  public static void addU(FlatBufferBuilder builder, int uOffset) { builder.addOffset(1, uOffset, 0); }
  public static int endTrackerDataComponentW(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public TrackerDataComponentW get(int j) { return get(new TrackerDataComponentW(), j); }
    public TrackerDataComponentW get(TrackerDataComponentW obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public TrackerDataComponentWT unpack() {
    TrackerDataComponentWT _o = new TrackerDataComponentWT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(TrackerDataComponentWT _o) {
    slimevr_protocol.data_feed.tracker.TrackerDataComponentUnion _oU = new slimevr_protocol.data_feed.tracker.TrackerDataComponentUnion();
    byte _oUType = uType();
    _oU.setType(_oUType);
    Table _oUValue;
    switch (_oUType) {
      default: break;
    }
    _o.setU(_oU);
  }
  public static int pack(FlatBufferBuilder builder, TrackerDataComponentWT _o) {
    if (_o == null) return 0;
    byte _uType = _o.getU() == null ? slimevr_protocol.data_feed.tracker.TrackerDataComponent.NONE : _o.getU().getType();
    int _u = _o.getU() == null ? 0 : slimevr_protocol.data_feed.tracker.TrackerDataComponentUnion.pack(builder, _o.getU());
    return createTrackerDataComponentW(
      builder,
      _uType,
      _u);
  }
}

