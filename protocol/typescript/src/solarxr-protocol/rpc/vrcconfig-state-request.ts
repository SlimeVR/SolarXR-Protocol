// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';



export class VRCConfigStateRequest implements flatbuffers.IUnpackableObject<VRCConfigStateRequestT> {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
  __init(i:number, bb:flatbuffers.ByteBuffer):VRCConfigStateRequest {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsVRCConfigStateRequest(bb:flatbuffers.ByteBuffer, obj?:VRCConfigStateRequest):VRCConfigStateRequest {
  return (obj || new VRCConfigStateRequest()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsVRCConfigStateRequest(bb:flatbuffers.ByteBuffer, obj?:VRCConfigStateRequest):VRCConfigStateRequest {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new VRCConfigStateRequest()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static startVRCConfigStateRequest(builder:flatbuffers.Builder) {
  builder.startObject(0);
}

static endVRCConfigStateRequest(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}

static createVRCConfigStateRequest(builder:flatbuffers.Builder):flatbuffers.Offset {
  VRCConfigStateRequest.startVRCConfigStateRequest(builder);
  return VRCConfigStateRequest.endVRCConfigStateRequest(builder);
}

unpack(): VRCConfigStateRequestT {
  return new VRCConfigStateRequestT();
}


unpackTo(_o: VRCConfigStateRequestT): void {}
}

export class VRCConfigStateRequestT implements flatbuffers.IGeneratedObject {
constructor(){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  return VRCConfigStateRequest.createVRCConfigStateRequest(builder);
}
}
