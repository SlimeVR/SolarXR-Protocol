// automatically generated by the FlatBuffers compiler, do not modify

package slimevr_protocol.data_feed.tracker;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

/**
 * A mask of the different components in `TrackerComponent`
 */
@SuppressWarnings("unused")
public final class TrackerDataMask extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_2_0_0(); }
  public static TrackerDataMask getRootAsTrackerDataMask(ByteBuffer _bb) { return getRootAsTrackerDataMask(_bb, new TrackerDataMask()); }
  public static TrackerDataMask getRootAsTrackerDataMask(ByteBuffer _bb, TrackerDataMask obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public TrackerDataMask __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public boolean bodyPart() { int o = __offset(4); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  public boolean orientation() { int o = __offset(6); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  public boolean position() { int o = __offset(8); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  public boolean rawRotVel() { int o = __offset(10); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  public boolean rawTransAccel() { int o = __offset(12); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  public boolean temp() { int o = __offset(14); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  public boolean pollRate() { int o = __offset(16); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  public boolean mountingRotation() { int o = __offset(18); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }

  public static int createTrackerDataMask(FlatBufferBuilder builder,
      boolean bodyPart,
      boolean orientation,
      boolean position,
      boolean rawRotVel,
      boolean rawTransAccel,
      boolean temp,
      boolean pollRate,
      boolean mountingRotation) {
    builder.startTable(8);
    TrackerDataMask.addMountingRotation(builder, mountingRotation);
    TrackerDataMask.addPollRate(builder, pollRate);
    TrackerDataMask.addTemp(builder, temp);
    TrackerDataMask.addRawTransAccel(builder, rawTransAccel);
    TrackerDataMask.addRawRotVel(builder, rawRotVel);
    TrackerDataMask.addPosition(builder, position);
    TrackerDataMask.addOrientation(builder, orientation);
    TrackerDataMask.addBodyPart(builder, bodyPart);
    return TrackerDataMask.endTrackerDataMask(builder);
  }

  public static void startTrackerDataMask(FlatBufferBuilder builder) { builder.startTable(8); }
  public static void addBodyPart(FlatBufferBuilder builder, boolean bodyPart) { builder.addBoolean(0, bodyPart, false); }
  public static void addOrientation(FlatBufferBuilder builder, boolean orientation) { builder.addBoolean(1, orientation, false); }
  public static void addPosition(FlatBufferBuilder builder, boolean position) { builder.addBoolean(2, position, false); }
  public static void addRawRotVel(FlatBufferBuilder builder, boolean rawRotVel) { builder.addBoolean(3, rawRotVel, false); }
  public static void addRawTransAccel(FlatBufferBuilder builder, boolean rawTransAccel) { builder.addBoolean(4, rawTransAccel, false); }
  public static void addTemp(FlatBufferBuilder builder, boolean temp) { builder.addBoolean(5, temp, false); }
  public static void addPollRate(FlatBufferBuilder builder, boolean pollRate) { builder.addBoolean(6, pollRate, false); }
  public static void addMountingRotation(FlatBufferBuilder builder, boolean mountingRotation) { builder.addBoolean(7, mountingRotation, false); }
  public static int endTrackerDataMask(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public TrackerDataMask get(int j) { return get(new TrackerDataMask(), j); }
    public TrackerDataMask get(TrackerDataMask obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public TrackerDataMaskT unpack() {
    TrackerDataMaskT _o = new TrackerDataMaskT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(TrackerDataMaskT _o) {
    boolean _oBodyPart = bodyPart();
    _o.setBodyPart(_oBodyPart);
    boolean _oOrientation = orientation();
    _o.setOrientation(_oOrientation);
    boolean _oPosition = position();
    _o.setPosition(_oPosition);
    boolean _oRawRotVel = rawRotVel();
    _o.setRawRotVel(_oRawRotVel);
    boolean _oRawTransAccel = rawTransAccel();
    _o.setRawTransAccel(_oRawTransAccel);
    boolean _oTemp = temp();
    _o.setTemp(_oTemp);
    boolean _oPollRate = pollRate();
    _o.setPollRate(_oPollRate);
    boolean _oMountingRotation = mountingRotation();
    _o.setMountingRotation(_oMountingRotation);
  }
  public static int pack(FlatBufferBuilder builder, TrackerDataMaskT _o) {
    if (_o == null) return 0;
    return createTrackerDataMask(
      builder,
      _o.getBodyPart(),
      _o.getOrientation(),
      _o.getPosition(),
      _o.getRawRotVel(),
      _o.getRawTransAccel(),
      _o.getTemp(),
      _o.getPollRate(),
      _o.getMountingRotation());
  }
}

