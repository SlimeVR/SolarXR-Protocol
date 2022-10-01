// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

/**
 * Sends the FRST cmd to the currently over the Serial Montior connected Tracker
 */
@SuppressWarnings("unused")
public final class SerialTrackerFactoryResetRequest extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_2_0_0(); }
  public static SerialTrackerFactoryResetRequest getRootAsSerialTrackerFactoryResetRequest(ByteBuffer _bb) { return getRootAsSerialTrackerFactoryResetRequest(_bb, new SerialTrackerFactoryResetRequest()); }
  public static SerialTrackerFactoryResetRequest getRootAsSerialTrackerFactoryResetRequest(ByteBuffer _bb, SerialTrackerFactoryResetRequest obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public SerialTrackerFactoryResetRequest __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }


  public static void startSerialTrackerFactoryResetRequest(FlatBufferBuilder builder) { builder.startTable(0); }
  public static int endSerialTrackerFactoryResetRequest(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public SerialTrackerFactoryResetRequest get(int j) { return get(new SerialTrackerFactoryResetRequest(), j); }
    public SerialTrackerFactoryResetRequest get(SerialTrackerFactoryResetRequest obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public SerialTrackerFactoryResetRequestT unpack() {
    SerialTrackerFactoryResetRequestT _o = new SerialTrackerFactoryResetRequestT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(SerialTrackerFactoryResetRequestT _o) {
  }
  public static int pack(FlatBufferBuilder builder, SerialTrackerFactoryResetRequestT _o) {
    if (_o == null) return 0;
    startSerialTrackerFactoryResetRequest(builder);
    return endSerialTrackerFactoryResetRequest(builder);
  }
}

