// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

/**
 * There is an available HMD tracker and it's not assigned to head
 */
@SuppressWarnings("unused")
public final class StatusUnassignedHMD extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_22_10_26(); }
  public static StatusUnassignedHMD getRootAsStatusUnassignedHMD(ByteBuffer _bb) { return getRootAsStatusUnassignedHMD(_bb, new StatusUnassignedHMD()); }
  public static StatusUnassignedHMD getRootAsStatusUnassignedHMD(ByteBuffer _bb, StatusUnassignedHMD obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public StatusUnassignedHMD __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public solarxr_protocol.datatypes.TrackerId trackerId() { return trackerId(new solarxr_protocol.datatypes.TrackerId()); }
  public solarxr_protocol.datatypes.TrackerId trackerId(solarxr_protocol.datatypes.TrackerId obj) { int o = __offset(4); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }

  public static int createStatusUnassignedHMD(FlatBufferBuilder builder,
      int trackerIdOffset) {
    builder.startTable(1);
    StatusUnassignedHMD.addTrackerId(builder, trackerIdOffset);
    return StatusUnassignedHMD.endStatusUnassignedHMD(builder);
  }

  public static void startStatusUnassignedHMD(FlatBufferBuilder builder) { builder.startTable(1); }
  public static void addTrackerId(FlatBufferBuilder builder, int trackerIdOffset) { builder.addOffset(0, trackerIdOffset, 0); }
  public static int endStatusUnassignedHMD(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public StatusUnassignedHMD get(int j) { return get(new StatusUnassignedHMD(), j); }
    public StatusUnassignedHMD get(StatusUnassignedHMD obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public StatusUnassignedHMDT unpack() {
    StatusUnassignedHMDT _o = new StatusUnassignedHMDT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(StatusUnassignedHMDT _o) {
    if (trackerId() != null) _o.setTrackerId(trackerId().unpack());
    else _o.setTrackerId(null);
  }
  public static int pack(FlatBufferBuilder builder, StatusUnassignedHMDT _o) {
    if (_o == null) return 0;
    int _trackerId = _o.getTrackerId() == null ? 0 : solarxr_protocol.datatypes.TrackerId.pack(builder, _o.getTrackerId());
    return createStatusUnassignedHMD(
      builder,
      _trackerId);
  }
}

