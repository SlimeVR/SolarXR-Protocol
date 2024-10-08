// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.data_feed.device_data;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

/**
 * A mask of values to be reported in subsequent DeviceStatus. Values set to `false`
 * or `null` will not reported. By default, all fields are false/null.
 *
 * If you set a value to `true`, it is not guaranteed that the sender actually has
 * such a value to send. In this case, they will probably send `null`, and the receiver
 * has the choice to disconnect due to missing data.
 */
@SuppressWarnings("unused")
public final class DeviceDataMask extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_22_10_26(); }
  public static DeviceDataMask getRootAsDeviceDataMask(ByteBuffer _bb) { return getRootAsDeviceDataMask(_bb, new DeviceDataMask()); }
  public static DeviceDataMask getRootAsDeviceDataMask(ByteBuffer _bb, DeviceDataMask obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public DeviceDataMask __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  /**
   * Which tracker data should be sent in this data feed
   */
  public solarxr_protocol.data_feed.tracker.TrackerDataMask trackerData() { return trackerData(new solarxr_protocol.data_feed.tracker.TrackerDataMask()); }
  public solarxr_protocol.data_feed.tracker.TrackerDataMask trackerData(solarxr_protocol.data_feed.tracker.TrackerDataMask obj) { int o = __offset(4); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }
  /**
   * true if device data should be sent in this data feed
   */
  public boolean deviceData() { int o = __offset(6); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }

  public static int createDeviceDataMask(FlatBufferBuilder builder,
      int trackerDataOffset,
      boolean deviceData) {
    builder.startTable(2);
    DeviceDataMask.addTrackerData(builder, trackerDataOffset);
    DeviceDataMask.addDeviceData(builder, deviceData);
    return DeviceDataMask.endDeviceDataMask(builder);
  }

  public static void startDeviceDataMask(FlatBufferBuilder builder) { builder.startTable(2); }
  public static void addTrackerData(FlatBufferBuilder builder, int trackerDataOffset) { builder.addOffset(0, trackerDataOffset, 0); }
  public static void addDeviceData(FlatBufferBuilder builder, boolean deviceData) { builder.addBoolean(1, deviceData, false); }
  public static int endDeviceDataMask(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public DeviceDataMask get(int j) { return get(new DeviceDataMask(), j); }
    public DeviceDataMask get(DeviceDataMask obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public DeviceDataMaskT unpack() {
    DeviceDataMaskT _o = new DeviceDataMaskT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(DeviceDataMaskT _o) {
    if (trackerData() != null) _o.setTrackerData(trackerData().unpack());
    else _o.setTrackerData(null);
    boolean _oDeviceData = deviceData();
    _o.setDeviceData(_oDeviceData);
  }
  public static int pack(FlatBufferBuilder builder, DeviceDataMaskT _o) {
    if (_o == null) return 0;
    int _trackerData = _o.getTrackerData() == null ? 0 : solarxr_protocol.data_feed.tracker.TrackerDataMask.pack(builder, _o.getTrackerData());
    return createDeviceDataMask(
      builder,
      _trackerData,
      _o.getDeviceData());
  }
}

