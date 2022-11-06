// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.pub_sub;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

/**
 * Response for `TopicHandleRequest` or `SubscriptionRequest`
 */
@SuppressWarnings("unused")
public final class TopicMapping extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_2_0_0(); }
  public static TopicMapping getRootAsTopicMapping(ByteBuffer _bb) { return getRootAsTopicMapping(_bb, new TopicMapping()); }
  public static TopicMapping getRootAsTopicMapping(ByteBuffer _bb, TopicMapping obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public TopicMapping __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public solarxr_protocol.pub_sub.TopicId id() { return id(new solarxr_protocol.pub_sub.TopicId()); }
  public solarxr_protocol.pub_sub.TopicId id(solarxr_protocol.pub_sub.TopicId obj) { int o = __offset(4); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }
  public solarxr_protocol.pub_sub.TopicHandle handle() { return handle(new solarxr_protocol.pub_sub.TopicHandle()); }
  public solarxr_protocol.pub_sub.TopicHandle handle(solarxr_protocol.pub_sub.TopicHandle obj) { int o = __offset(6); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }

  public static int createTopicMapping(FlatBufferBuilder builder,
      int idOffset,
      int handleOffset) {
    builder.startTable(2);
    TopicMapping.addHandle(builder, handleOffset);
    TopicMapping.addId(builder, idOffset);
    return TopicMapping.endTopicMapping(builder);
  }

  public static void startTopicMapping(FlatBufferBuilder builder) { builder.startTable(2); }
  public static void addId(FlatBufferBuilder builder, int idOffset) { builder.addOffset(0, idOffset, 0); }
  public static void addHandle(FlatBufferBuilder builder, int handleOffset) { builder.addOffset(1, handleOffset, 0); }
  public static int endTopicMapping(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public TopicMapping get(int j) { return get(new TopicMapping(), j); }
    public TopicMapping get(TopicMapping obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public TopicMappingT unpack() {
    TopicMappingT _o = new TopicMappingT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(TopicMappingT _o) {
    if (id() != null) _o.setId(id().unpack());
    else _o.setId(null);
    if (handle() != null) _o.setHandle(handle().unpack());
    else _o.setHandle(null);
  }
  public static int pack(FlatBufferBuilder builder, TopicMappingT _o) {
    if (_o == null) return 0;
    int _id = _o.getId() == null ? 0 : solarxr_protocol.pub_sub.TopicId.pack(builder, _o.getId());
    int _handle = _o.getHandle() == null ? 0 : solarxr_protocol.pub_sub.TopicHandle.pack(builder, _o.getHandle());
    return createTopicMapping(
      builder,
      _id,
      _handle);
  }
}

