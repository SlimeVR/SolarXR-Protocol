// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.data_feed;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class Bone extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_22_10_26(); }
  public static Bone getRootAsBone(ByteBuffer _bb) { return getRootAsBone(_bb, new Bone()); }
  public static Bone getRootAsBone(ByteBuffer _bb, Bone obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public Bone __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public int bodyPart() { int o = __offset(4); return o != 0 ? bb.get(o + bb_pos) & 0xFF : 0; }
  /**
   * The global rotation of the bone.
   *
   * Note that the identity rotation is where a bone's tail is towards -y (assuming
   * the head of the bone is the origin)
   */
  public solarxr_protocol.datatypes.math.Quat rotationG() { return rotationG(new solarxr_protocol.datatypes.math.Quat()); }
  public solarxr_protocol.datatypes.math.Quat rotationG(solarxr_protocol.datatypes.math.Quat obj) { int o = __offset(6); return o != 0 ? obj.__assign(o + bb_pos, bb) : null; }
  public float boneLength() { int o = __offset(8); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }
  /**
   * The global position of the head of this bone.
   *
   * The head of a bone is joint/node of the bone touching the parent bone. The
   * parent is defined as the bone closer to the HMD.
   */
  public solarxr_protocol.datatypes.math.Vec3f headPositionG() { return headPositionG(new solarxr_protocol.datatypes.math.Vec3f()); }
  public solarxr_protocol.datatypes.math.Vec3f headPositionG(solarxr_protocol.datatypes.math.Vec3f obj) { int o = __offset(10); return o != 0 ? obj.__assign(o + bb_pos, bb) : null; }

  public static void startBone(FlatBufferBuilder builder) { builder.startTable(4); }
  public static void addBodyPart(FlatBufferBuilder builder, int bodyPart) { builder.addByte(0, (byte) bodyPart, (byte) 0); }
  public static void addRotationG(FlatBufferBuilder builder, int rotationGOffset) { builder.addStruct(1, rotationGOffset, 0); }
  public static void addBoneLength(FlatBufferBuilder builder, float boneLength) { builder.addFloat(2, boneLength, 0.0f); }
  public static void addHeadPositionG(FlatBufferBuilder builder, int headPositionGOffset) { builder.addStruct(3, headPositionGOffset, 0); }
  public static int endBone(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public Bone get(int j) { return get(new Bone(), j); }
    public Bone get(Bone obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public BoneT unpack() {
    BoneT _o = new BoneT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(BoneT _o) {
    int _oBodyPart = bodyPart();
    _o.setBodyPart(_oBodyPart);
    if (rotationG() != null) rotationG().unpackTo(_o.getRotationG());
    else _o.setRotationG(null);
    float _oBoneLength = boneLength();
    _o.setBoneLength(_oBoneLength);
    if (headPositionG() != null) headPositionG().unpackTo(_o.getHeadPositionG());
    else _o.setHeadPositionG(null);
  }
  public static int pack(FlatBufferBuilder builder, BoneT _o) {
    if (_o == null) return 0;
    startBone(builder);
    addBodyPart(builder, _o.getBodyPart());
    addRotationG(builder, solarxr_protocol.datatypes.math.Quat.pack(builder, _o.getRotationG()));
    addBoneLength(builder, _o.getBoneLength());
    addHeadPositionG(builder, solarxr_protocol.datatypes.math.Vec3f.pack(builder, _o.getHeadPositionG()));
    return endBone(builder);
  }
}

