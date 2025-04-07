// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

/**
 * Trackers with error state
 */
@SuppressWarnings("unused")
public final class StatusTrackerError extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_22_10_26(); }
  public static StatusTrackerError getRootAsStatusTrackerError(ByteBuffer _bb) { return getRootAsStatusTrackerError(_bb, new StatusTrackerError()); }
  public static StatusTrackerError getRootAsStatusTrackerError(ByteBuffer _bb, StatusTrackerError obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public StatusTrackerError __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public solarxr_protocol.datatypes.TrackerId trackersId(int j) { return trackersId(new solarxr_protocol.datatypes.TrackerId(), j); }
  public solarxr_protocol.datatypes.TrackerId trackersId(solarxr_protocol.datatypes.TrackerId obj, int j) { int o = __offset(4); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int trackersIdLength() { int o = __offset(4); return o != 0 ? __vector_len(o) : 0; }
  public solarxr_protocol.datatypes.TrackerId.Vector trackersIdVector() { return trackersIdVector(new solarxr_protocol.datatypes.TrackerId.Vector()); }
  public solarxr_protocol.datatypes.TrackerId.Vector trackersIdVector(solarxr_protocol.datatypes.TrackerId.Vector obj) { int o = __offset(4); return o != 0 ? obj.__assign(__vector(o), 4, bb) : null; }

  public static int createStatusTrackerError(FlatBufferBuilder builder,
      int trackersIdOffset) {
    builder.startTable(1);
    StatusTrackerError.addTrackersId(builder, trackersIdOffset);
    return StatusTrackerError.endStatusTrackerError(builder);
  }

  public static void startStatusTrackerError(FlatBufferBuilder builder) { builder.startTable(1); }
  public static void addTrackersId(FlatBufferBuilder builder, int trackersIdOffset) { builder.addOffset(0, trackersIdOffset, 0); }
  public static int createTrackersIdVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startTrackersIdVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static int endStatusTrackerError(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public StatusTrackerError get(int j) { return get(new StatusTrackerError(), j); }
    public StatusTrackerError get(StatusTrackerError obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public StatusTrackerErrorT unpack() {
    StatusTrackerErrorT _o = new StatusTrackerErrorT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(StatusTrackerErrorT _o) {
    solarxr_protocol.datatypes.TrackerIdT[] _oTrackersId = new solarxr_protocol.datatypes.TrackerIdT[trackersIdLength()];
    for (int _j = 0; _j < trackersIdLength(); ++_j) {_oTrackersId[_j] = (trackersId(_j) != null ? trackersId(_j).unpack() : null);}
    _o.setTrackersId(_oTrackersId);
  }
  public static int pack(FlatBufferBuilder builder, StatusTrackerErrorT _o) {
    if (_o == null) return 0;
    int _trackersId = 0;
    if (_o.getTrackersId() != null) {
      int[] __trackersId = new int[_o.getTrackersId().length];
      int _j = 0;
      for (solarxr_protocol.datatypes.TrackerIdT _e : _o.getTrackersId()) { __trackersId[_j] = solarxr_protocol.datatypes.TrackerId.pack(builder, _e); _j++;}
      _trackersId = createTrackersIdVector(builder, __trackersId);
    }
    return createStatusTrackerError(
      builder,
      _trackersId);
  }
}

