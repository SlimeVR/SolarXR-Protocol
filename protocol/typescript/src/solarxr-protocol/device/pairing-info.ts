// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';



export class PairingInfo {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
__init(i:number, bb:flatbuffers.ByteBuffer):PairingInfo {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsPairingInfo(bb:flatbuffers.ByteBuffer, obj?:PairingInfo):PairingInfo {
  return (obj || new PairingInfo()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsPairingInfo(bb:flatbuffers.ByteBuffer, obj?:PairingInfo):PairingInfo {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new PairingInfo()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

paired():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 4);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

static startPairingInfo(builder:flatbuffers.Builder) {
  builder.startObject(1);
}

static addPaired(builder:flatbuffers.Builder, paired:boolean) {
  builder.addFieldInt8(0, +paired, +false);
}

static endPairingInfo(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}

static createPairingInfo(builder:flatbuffers.Builder, paired:boolean):flatbuffers.Offset {
  PairingInfo.startPairingInfo(builder);
  PairingInfo.addPaired(builder, paired);
  return PairingInfo.endPairingInfo(builder);
}

unpack(): PairingInfoT {
  return new PairingInfoT(
    this.paired()
  );
}


unpackTo(_o: PairingInfoT): void {
  _o.paired = this.paired();
}
}

export class PairingInfoT {
constructor(
  public paired: boolean = false
){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  return PairingInfo.createPairingInfo(builder,
    this.paired
  );
}
}
