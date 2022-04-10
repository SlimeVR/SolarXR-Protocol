// automatically generated by the FlatBuffers compiler, do not modify

package slimevr_protocol.data_feed.device_data;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

/**
 * Describes all possible information about a hardware device. For example, a
 * vive tracker is a  single hardware device, and a slime tracker with two
 * extensions is a single hardware device but two trackers.
 */
@SuppressWarnings("unused")
public final class DeviceData extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_2_0_0(); }
  public static DeviceData getRootAsDeviceData(ByteBuffer _bb) { return getRootAsDeviceData(_bb, new DeviceData()); }
  public static DeviceData getRootAsDeviceData(ByteBuffer _bb, DeviceData obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public DeviceData __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public slimevr_protocol.datatypes.DeviceId id() { return id(new slimevr_protocol.datatypes.DeviceId()); }
  public slimevr_protocol.datatypes.DeviceId id(slimevr_protocol.datatypes.DeviceId obj) { int o = __offset(4); return o != 0 ? obj.__assign(o + bb_pos, bb) : null; }
  /**
   * The dynamically changeable name of the device. This might be set by the
   * user to help them remember which tracker is which.
   */
  public String customName() { int o = __offset(6); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer customNameAsByteBuffer() { return __vector_as_bytebuffer(6, 1); }
  public ByteBuffer customNameInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 6, 1); }
  /**
   * Mostly-static info about the device hardware
   */
  public slimevr_protocol.datatypes.hardware_info.HardwareInfo hardwareInfo() { return hardwareInfo(new slimevr_protocol.datatypes.hardware_info.HardwareInfo()); }
  public slimevr_protocol.datatypes.hardware_info.HardwareInfo hardwareInfo(slimevr_protocol.datatypes.hardware_info.HardwareInfo obj) { int o = __offset(8); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }
  /**
   * General info about the status of the device
   */
  public slimevr_protocol.datatypes.hardware_info.HardwareStatus hardwareStatus() { return hardwareStatus(new slimevr_protocol.datatypes.hardware_info.HardwareStatus()); }
  public slimevr_protocol.datatypes.hardware_info.HardwareStatus hardwareStatus(slimevr_protocol.datatypes.hardware_info.HardwareStatus obj) { int o = __offset(10); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }
  /**
   * Info about all trackers attached to this device
   */
  public slimevr_protocol.data_feed.tracker.TrackerInfo trackers(int j) { return trackers(new slimevr_protocol.data_feed.tracker.TrackerInfo(), j); }
  public slimevr_protocol.data_feed.tracker.TrackerInfo trackers(slimevr_protocol.data_feed.tracker.TrackerInfo obj, int j) { int o = __offset(12); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int trackersLength() { int o = __offset(12); return o != 0 ? __vector_len(o) : 0; }
  public slimevr_protocol.data_feed.tracker.TrackerInfo.Vector trackersVector() { return trackersVector(new slimevr_protocol.data_feed.tracker.TrackerInfo.Vector()); }
  public slimevr_protocol.data_feed.tracker.TrackerInfo.Vector trackersVector(slimevr_protocol.data_feed.tracker.TrackerInfo.Vector obj) { int o = __offset(12); return o != 0 ? obj.__assign(__vector(o), 4, bb) : null; }

  public static void startDeviceData(FlatBufferBuilder builder) { builder.startTable(5); }
  public static void addId(FlatBufferBuilder builder, int idOffset) { builder.addStruct(0, idOffset, 0); }
  public static void addCustomName(FlatBufferBuilder builder, int customNameOffset) { builder.addOffset(1, customNameOffset, 0); }
  public static void addHardwareInfo(FlatBufferBuilder builder, int hardwareInfoOffset) { builder.addOffset(2, hardwareInfoOffset, 0); }
  public static void addHardwareStatus(FlatBufferBuilder builder, int hardwareStatusOffset) { builder.addOffset(3, hardwareStatusOffset, 0); }
  public static void addTrackers(FlatBufferBuilder builder, int trackersOffset) { builder.addOffset(4, trackersOffset, 0); }
  public static int createTrackersVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startTrackersVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static int endDeviceData(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public DeviceData get(int j) { return get(new DeviceData(), j); }
    public DeviceData get(DeviceData obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public DeviceDataT unpack() {
    DeviceDataT _o = new DeviceDataT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(DeviceDataT _o) {
    if (id() != null) id().unpackTo(_o.getId());
    else _o.setId(null);
    String _oCustomName = customName();
    _o.setCustomName(_oCustomName);
    if (hardwareInfo() != null) _o.setHardwareInfo(hardwareInfo().unpack());
    else _o.setHardwareInfo(null);
    if (hardwareStatus() != null) _o.setHardwareStatus(hardwareStatus().unpack());
    else _o.setHardwareStatus(null);
    slimevr_protocol.data_feed.tracker.TrackerInfoT[] _oTrackers = new slimevr_protocol.data_feed.tracker.TrackerInfoT[trackersLength()];
    for (int _j = 0; _j < trackersLength(); ++_j) {_oTrackers[_j] = (trackers(_j) != null ? trackers(_j).unpack() : null);}
    _o.setTrackers(_oTrackers);
  }
  public static int pack(FlatBufferBuilder builder, DeviceDataT _o) {
    if (_o == null) return 0;
    int _customName = _o.getCustomName() == null ? 0 : builder.createString(_o.getCustomName());
    int _hardware_info = _o.getHardwareInfo() == null ? 0 : slimevr_protocol.datatypes.hardware_info.HardwareInfo.pack(builder, _o.getHardwareInfo());
    int _hardware_status = _o.getHardwareStatus() == null ? 0 : slimevr_protocol.datatypes.hardware_info.HardwareStatus.pack(builder, _o.getHardwareStatus());
    int _trackers = 0;
    if (_o.getTrackers() != null) {
      int[] __trackers = new int[_o.getTrackers().length];
      int _j = 0;
      for (slimevr_protocol.data_feed.tracker.TrackerInfoT _e : _o.getTrackers()) { __trackers[_j] = slimevr_protocol.data_feed.tracker.TrackerInfo.pack(builder, _e); _j++;}
      _trackers = createTrackersVector(builder, __trackers);
    }
    startDeviceData(builder);
    addId(builder, slimevr_protocol.datatypes.DeviceId.pack(builder, _o.getId()));
    addCustomName(builder, _customName);
    addHardwareInfo(builder, _hardware_info);
    addHardwareStatus(builder, _hardware_status);
    addTrackers(builder, _trackers);
    return endDeviceData(builder);
  }
}

