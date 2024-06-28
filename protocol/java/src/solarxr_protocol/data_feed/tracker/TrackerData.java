// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.data_feed.tracker;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

/**
 * Describes all possible information about a tracker. A tracker is anything that
 * provides kinematic data about a particular body part.
 *
 * Trackers may be synthetic/computed or instead part of an actual hardware device.
 * There can be multiple trackers per hardware device.
 */
@SuppressWarnings("unused")
public final class TrackerData extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_22_10_26(); }
  public static TrackerData getRootAsTrackerData(ByteBuffer _bb) { return getRootAsTrackerData(_bb, new TrackerData()); }
  public static TrackerData getRootAsTrackerData(ByteBuffer _bb, TrackerData obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public TrackerData __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public solarxr_protocol.datatypes.TrackerId trackerId() { return trackerId(new solarxr_protocol.datatypes.TrackerId()); }
  public solarxr_protocol.datatypes.TrackerId trackerId(solarxr_protocol.datatypes.TrackerId obj) { int o = __offset(4); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }
  public solarxr_protocol.data_feed.tracker.TrackerInfo info() { return info(new solarxr_protocol.data_feed.tracker.TrackerInfo()); }
  public solarxr_protocol.data_feed.tracker.TrackerInfo info(solarxr_protocol.data_feed.tracker.TrackerInfo obj) { int o = __offset(6); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }
  public int status() { int o = __offset(8); return o != 0 ? bb.get(o + bb_pos) & 0xFF : 0; }
  /**
   * Sensor rotation after fusion
   */
  public solarxr_protocol.datatypes.math.Quat rotation() { return rotation(new solarxr_protocol.datatypes.math.Quat()); }
  public solarxr_protocol.datatypes.math.Quat rotation(solarxr_protocol.datatypes.math.Quat obj) { int o = __offset(10); return o != 0 ? obj.__assign(o + bb_pos, bb) : null; }
  /**
   * Position, in meters
   */
  public solarxr_protocol.datatypes.math.Vec3f position() { return position(new solarxr_protocol.datatypes.math.Vec3f()); }
  public solarxr_protocol.datatypes.math.Vec3f position(solarxr_protocol.datatypes.math.Vec3f obj) { int o = __offset(12); return o != 0 ? obj.__assign(o + bb_pos, bb) : null; }
  /**
   * Raw angular velocity, in euler angles, rad/s
   */
  public solarxr_protocol.datatypes.math.Vec3f rawAngularVelocity() { return rawAngularVelocity(new solarxr_protocol.datatypes.math.Vec3f()); }
  public solarxr_protocol.datatypes.math.Vec3f rawAngularVelocity(solarxr_protocol.datatypes.math.Vec3f obj) { int o = __offset(14); return o != 0 ? obj.__assign(o + bb_pos, bb) : null; }
  /**
   * Raw acceleration, in m/s^2
   */
  public solarxr_protocol.datatypes.math.Vec3f rawAcceleration() { return rawAcceleration(new solarxr_protocol.datatypes.math.Vec3f()); }
  public solarxr_protocol.datatypes.math.Vec3f rawAcceleration(solarxr_protocol.datatypes.math.Vec3f obj) { int o = __offset(16); return o != 0 ? obj.__assign(o + bb_pos, bb) : null; }
  /**
   * Temperature, in degrees celsius
   */
  public solarxr_protocol.datatypes.Temperature temp() { return temp(new solarxr_protocol.datatypes.Temperature()); }
  public solarxr_protocol.datatypes.Temperature temp(solarxr_protocol.datatypes.Temperature obj) { int o = __offset(18); return o != 0 ? obj.__assign(o + bb_pos, bb) : null; }
  /**
   * Acceleration without gravity, in m/s^2
   */
  public solarxr_protocol.datatypes.math.Vec3f linearAcceleration() { return linearAcceleration(new solarxr_protocol.datatypes.math.Vec3f()); }
  public solarxr_protocol.datatypes.math.Vec3f linearAcceleration(solarxr_protocol.datatypes.math.Vec3f obj) { int o = __offset(20); return o != 0 ? obj.__assign(o + bb_pos, bb) : null; }
  /**
   * Reference-adjusted rotation for IMU-only trackers (VR HMD yaw is used as a reset reference).
   * In other words, a rotation that is aligned to a reliable source of rotation ((0, VR HMD YAW, 0)),
   * triggered after user input (using reset buttons).
   * This is a SlimeVR-specific field and computed exclusively by SlimeVR server.
   * Includes: mounting orientation, full, quick and mounting reset adjustments.
   * This rotation can be used to reconstruct a skeleton pose using forward kinematics.
   */
  public solarxr_protocol.datatypes.math.Quat rotationReferenceAdjusted() { return rotationReferenceAdjusted(new solarxr_protocol.datatypes.math.Quat()); }
  public solarxr_protocol.datatypes.math.Quat rotationReferenceAdjusted(solarxr_protocol.datatypes.math.Quat obj) { int o = __offset(22); return o != 0 ? obj.__assign(o + bb_pos, bb) : null; }
  /**
   * Zero-reference-adjusted rotation for IMU-only trackers (identity quaternion is used as a reset reference).
   * In other words, a rotation that is aligned to a zero vector ((0, 0, 0)) by
   * inverting the current rotation, triggered after user input (using reset buttons).
   * This is a SlimeVR-specific field and computed exclusively by SlimeVR server.
   * Includes: only full and quick reset adjustments.
   * This rotation can be used in visualizations for IMU debugging.
   */
  public solarxr_protocol.datatypes.math.Quat rotationIdentityAdjusted() { return rotationIdentityAdjusted(new solarxr_protocol.datatypes.math.Quat()); }
  public solarxr_protocol.datatypes.math.Quat rotationIdentityAdjusted(solarxr_protocol.datatypes.math.Quat obj) { int o = __offset(24); return o != 0 ? obj.__assign(o + bb_pos, bb) : null; }
  /**
   * Data ticks per second, processed by SlimeVR server
   */
  public boolean hasTps() { return 0 != __offset(26); }
  public int tps() { int o = __offset(26); return o != 0 ? bb.getShort(o + bb_pos) & 0xFFFF : 0; }

  public static void startTrackerData(FlatBufferBuilder builder) { builder.startTable(12); }
  public static void addTrackerId(FlatBufferBuilder builder, int trackerIdOffset) { builder.addOffset(0, trackerIdOffset, 0); }
  public static void addInfo(FlatBufferBuilder builder, int infoOffset) { builder.addOffset(1, infoOffset, 0); }
  public static void addStatus(FlatBufferBuilder builder, int status) { builder.addByte(2, (byte) status, (byte) 0); }
  public static void addRotation(FlatBufferBuilder builder, int rotationOffset) { builder.addStruct(3, rotationOffset, 0); }
  public static void addPosition(FlatBufferBuilder builder, int positionOffset) { builder.addStruct(4, positionOffset, 0); }
  public static void addRawAngularVelocity(FlatBufferBuilder builder, int rawAngularVelocityOffset) { builder.addStruct(5, rawAngularVelocityOffset, 0); }
  public static void addRawAcceleration(FlatBufferBuilder builder, int rawAccelerationOffset) { builder.addStruct(6, rawAccelerationOffset, 0); }
  public static void addTemp(FlatBufferBuilder builder, int tempOffset) { builder.addStruct(7, tempOffset, 0); }
  public static void addLinearAcceleration(FlatBufferBuilder builder, int linearAccelerationOffset) { builder.addStruct(8, linearAccelerationOffset, 0); }
  public static void addRotationReferenceAdjusted(FlatBufferBuilder builder, int rotationReferenceAdjustedOffset) { builder.addStruct(9, rotationReferenceAdjustedOffset, 0); }
  public static void addRotationIdentityAdjusted(FlatBufferBuilder builder, int rotationIdentityAdjustedOffset) { builder.addStruct(10, rotationIdentityAdjustedOffset, 0); }
  public static void addTps(FlatBufferBuilder builder, int tps) { builder.addShort(11, (short) tps, (short) 0); }
  public static int endTrackerData(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public TrackerData get(int j) { return get(new TrackerData(), j); }
    public TrackerData get(TrackerData obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public TrackerDataT unpack() {
    TrackerDataT _o = new TrackerDataT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(TrackerDataT _o) {
    if (trackerId() != null) _o.setTrackerId(trackerId().unpack());
    else _o.setTrackerId(null);
    if (info() != null) _o.setInfo(info().unpack());
    else _o.setInfo(null);
    int _oStatus = status();
    _o.setStatus(_oStatus);
    if (rotation() != null) rotation().unpackTo(_o.getRotation());
    else _o.setRotation(null);
    if (position() != null) position().unpackTo(_o.getPosition());
    else _o.setPosition(null);
    if (rawAngularVelocity() != null) rawAngularVelocity().unpackTo(_o.getRawAngularVelocity());
    else _o.setRawAngularVelocity(null);
    if (rawAcceleration() != null) rawAcceleration().unpackTo(_o.getRawAcceleration());
    else _o.setRawAcceleration(null);
    if (temp() != null) temp().unpackTo(_o.getTemp());
    else _o.setTemp(null);
    if (linearAcceleration() != null) linearAcceleration().unpackTo(_o.getLinearAcceleration());
    else _o.setLinearAcceleration(null);
    if (rotationReferenceAdjusted() != null) rotationReferenceAdjusted().unpackTo(_o.getRotationReferenceAdjusted());
    else _o.setRotationReferenceAdjusted(null);
    if (rotationIdentityAdjusted() != null) rotationIdentityAdjusted().unpackTo(_o.getRotationIdentityAdjusted());
    else _o.setRotationIdentityAdjusted(null);
    Integer _oTps = hasTps() ? tps() : null;
    _o.setTps(_oTps);
  }
  public static int pack(FlatBufferBuilder builder, TrackerDataT _o) {
    if (_o == null) return 0;
    int _trackerId = _o.getTrackerId() == null ? 0 : solarxr_protocol.datatypes.TrackerId.pack(builder, _o.getTrackerId());
    int _info = _o.getInfo() == null ? 0 : solarxr_protocol.data_feed.tracker.TrackerInfo.pack(builder, _o.getInfo());
    startTrackerData(builder);
    addTrackerId(builder, _trackerId);
    addInfo(builder, _info);
    addStatus(builder, _o.getStatus());
    addRotation(builder, solarxr_protocol.datatypes.math.Quat.pack(builder, _o.getRotation()));
    addPosition(builder, solarxr_protocol.datatypes.math.Vec3f.pack(builder, _o.getPosition()));
    addRawAngularVelocity(builder, solarxr_protocol.datatypes.math.Vec3f.pack(builder, _o.getRawAngularVelocity()));
    addRawAcceleration(builder, solarxr_protocol.datatypes.math.Vec3f.pack(builder, _o.getRawAcceleration()));
    addTemp(builder, solarxr_protocol.datatypes.Temperature.pack(builder, _o.getTemp()));
    addLinearAcceleration(builder, solarxr_protocol.datatypes.math.Vec3f.pack(builder, _o.getLinearAcceleration()));
    addRotationReferenceAdjusted(builder, solarxr_protocol.datatypes.math.Quat.pack(builder, _o.getRotationReferenceAdjusted()));
    addRotationIdentityAdjusted(builder, solarxr_protocol.datatypes.math.Quat.pack(builder, _o.getRotationIdentityAdjusted()));
    if (_o.getTps() != null) { addTps(builder, _o.getTps()); }
    return endTrackerData(builder);
  }
}

