// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';

import { SkeletonBone } from '../../solarxr-protocol/rpc/skeleton-bone.js';


export class ChangeSkeletonConfigRequest implements flatbuffers.IUnpackableObject<ChangeSkeletonConfigRequestT> {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
  __init(i:number, bb:flatbuffers.ByteBuffer):ChangeSkeletonConfigRequest {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsChangeSkeletonConfigRequest(bb:flatbuffers.ByteBuffer, obj?:ChangeSkeletonConfigRequest):ChangeSkeletonConfigRequest {
  return (obj || new ChangeSkeletonConfigRequest()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsChangeSkeletonConfigRequest(bb:flatbuffers.ByteBuffer, obj?:ChangeSkeletonConfigRequest):ChangeSkeletonConfigRequest {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new ChangeSkeletonConfigRequest()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

bone():SkeletonBone {
  const offset = this.bb!.__offset(this.bb_pos, 4);
  return offset ? this.bb!.readUint8(this.bb_pos + offset) : SkeletonBone.NONE;
}

value():number {
  const offset = this.bb!.__offset(this.bb_pos, 6);
  return offset ? this.bb!.readFloat32(this.bb_pos + offset) : 0.0;
}

static startChangeSkeletonConfigRequest(builder:flatbuffers.Builder) {
  builder.startObject(2);
}

static addBone(builder:flatbuffers.Builder, bone:SkeletonBone) {
  builder.addFieldInt8(0, bone, SkeletonBone.NONE);
}

static addValue(builder:flatbuffers.Builder, value:number) {
  builder.addFieldFloat32(1, value, 0.0);
}

static endChangeSkeletonConfigRequest(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}

static createChangeSkeletonConfigRequest(builder:flatbuffers.Builder, bone:SkeletonBone, value:number):flatbuffers.Offset {
  ChangeSkeletonConfigRequest.startChangeSkeletonConfigRequest(builder);
  ChangeSkeletonConfigRequest.addBone(builder, bone);
  ChangeSkeletonConfigRequest.addValue(builder, value);
  return ChangeSkeletonConfigRequest.endChangeSkeletonConfigRequest(builder);
}

unpack(): ChangeSkeletonConfigRequestT {
  return new ChangeSkeletonConfigRequestT(
    this.bone(),
    this.value()
  );
}


unpackTo(_o: ChangeSkeletonConfigRequestT): void {
  _o.bone = this.bone();
  _o.value = this.value();
}
}

export class ChangeSkeletonConfigRequestT implements flatbuffers.IGeneratedObject {
constructor(
  public bone: SkeletonBone = SkeletonBone.NONE,
  public value: number = 0.0
){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  return ChangeSkeletonConfigRequest.createChangeSkeletonConfigRequest(builder,
    this.bone,
    this.value
  );
}
}
