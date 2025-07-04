// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class RecordBVHRequest extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_22_10_26(); }
  public static RecordBVHRequest getRootAsRecordBVHRequest(ByteBuffer _bb) { return getRootAsRecordBVHRequest(_bb, new RecordBVHRequest()); }
  public static RecordBVHRequest getRootAsRecordBVHRequest(ByteBuffer _bb, RecordBVHRequest obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public RecordBVHRequest __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public boolean stop() { int o = __offset(4); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  /**
   * Path sent when starting the recording, if null the recording won't happen.
   * Has different behavior depending if its a file path or a directory path.
   */
  public String path() { int o = __offset(6); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer pathAsByteBuffer() { return __vector_as_bytebuffer(6, 1); }
  public ByteBuffer pathInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 6, 1); }

  public static int createRecordBVHRequest(FlatBufferBuilder builder,
      boolean stop,
      int pathOffset) {
    builder.startTable(2);
    RecordBVHRequest.addPath(builder, pathOffset);
    RecordBVHRequest.addStop(builder, stop);
    return RecordBVHRequest.endRecordBVHRequest(builder);
  }

  public static void startRecordBVHRequest(FlatBufferBuilder builder) { builder.startTable(2); }
  public static void addStop(FlatBufferBuilder builder, boolean stop) { builder.addBoolean(0, stop, false); }
  public static void addPath(FlatBufferBuilder builder, int pathOffset) { builder.addOffset(1, pathOffset, 0); }
  public static int endRecordBVHRequest(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public RecordBVHRequest get(int j) { return get(new RecordBVHRequest(), j); }
    public RecordBVHRequest get(RecordBVHRequest obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public RecordBVHRequestT unpack() {
    RecordBVHRequestT _o = new RecordBVHRequestT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(RecordBVHRequestT _o) {
    boolean _oStop = stop();
    _o.setStop(_oStop);
    String _oPath = path();
    _o.setPath(_oPath);
  }
  public static int pack(FlatBufferBuilder builder, RecordBVHRequestT _o) {
    if (_o == null) return 0;
    int _path = _o.getPath() == null ? 0 : builder.createString(_o.getPath());
    return createRecordBVHRequest(
      builder,
      _o.getStop(),
      _path);
  }
}

