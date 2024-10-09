// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';



/**
 * When an status is fixed and it's removed, it's ID is sent
 */
export class StatusSystemFixed implements flatbuffers.IUnpackableObject<StatusSystemFixedT> {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
  __init(i:number, bb:flatbuffers.ByteBuffer):StatusSystemFixed {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsStatusSystemFixed(bb:flatbuffers.ByteBuffer, obj?:StatusSystemFixed):StatusSystemFixed {
  return (obj || new StatusSystemFixed()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsStatusSystemFixed(bb:flatbuffers.ByteBuffer, obj?:StatusSystemFixed):StatusSystemFixed {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new StatusSystemFixed()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

fixedStatusId():number {
  const offset = this.bb!.__offset(this.bb_pos, 4);
  return offset ? this.bb!.readUint32(this.bb_pos + offset) : 0;
}

static startStatusSystemFixed(builder:flatbuffers.Builder) {
  builder.startObject(1);
}

static addFixedStatusId(builder:flatbuffers.Builder, fixedStatusId:number) {
  builder.addFieldInt32(0, fixedStatusId, 0);
}

static endStatusSystemFixed(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}

static createStatusSystemFixed(builder:flatbuffers.Builder, fixedStatusId:number):flatbuffers.Offset {
  StatusSystemFixed.startStatusSystemFixed(builder);
  StatusSystemFixed.addFixedStatusId(builder, fixedStatusId);
  return StatusSystemFixed.endStatusSystemFixed(builder);
}

unpack(): StatusSystemFixedT {
  return new StatusSystemFixedT(
    this.fixedStatusId()
  );
}


unpackTo(_o: StatusSystemFixedT): void {
  _o.fixedStatusId = this.fixedStatusId();
}
}

export class StatusSystemFixedT implements flatbuffers.IGeneratedObject {
constructor(
  public fixedStatusId: number = 0
){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  return StatusSystemFixed.createStatusSystemFixed(builder,
    this.fixedStatusId
  );
}
}
