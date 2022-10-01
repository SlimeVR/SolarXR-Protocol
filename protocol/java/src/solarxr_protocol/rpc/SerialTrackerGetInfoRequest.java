// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

/**
 * Sends the GET INFO cmd to the currently over the Serial Montior connected Tracker
 */
@SuppressWarnings("unused")
public final class SerialTrackerGetInfoRequest extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_2_0_0(); }
  public static SerialTrackerGetInfoRequest getRootAsSerialTrackerGetInfoRequest(ByteBuffer _bb) { return getRootAsSerialTrackerGetInfoRequest(_bb, new SerialTrackerGetInfoRequest()); }
  public static SerialTrackerGetInfoRequest getRootAsSerialTrackerGetInfoRequest(ByteBuffer _bb, SerialTrackerGetInfoRequest obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public SerialTrackerGetInfoRequest __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }


  public static void startSerialTrackerGetInfoRequest(FlatBufferBuilder builder) { builder.startTable(0); }
  public static int endSerialTrackerGetInfoRequest(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public SerialTrackerGetInfoRequest get(int j) { return get(new SerialTrackerGetInfoRequest(), j); }
    public SerialTrackerGetInfoRequest get(SerialTrackerGetInfoRequest obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public SerialTrackerGetInfoRequestT unpack() {
    SerialTrackerGetInfoRequestT _o = new SerialTrackerGetInfoRequestT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(SerialTrackerGetInfoRequestT _o) {
  }
  public static int pack(FlatBufferBuilder builder, SerialTrackerGetInfoRequestT _o) {
    if (_o == null) return 0;
    startSerialTrackerGetInfoRequest(builder);
    return endSerialTrackerGetInfoRequest(builder);
  }
}

