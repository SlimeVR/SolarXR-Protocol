// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';



export class RecordBVHStatusRequest implements flatbuffers.IUnpackableObject<RecordBVHStatusRequestT> {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
  __init(i:number, bb:flatbuffers.ByteBuffer):RecordBVHStatusRequest {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsRecordBVHStatusRequest(bb:flatbuffers.ByteBuffer, obj?:RecordBVHStatusRequest):RecordBVHStatusRequest {
  return (obj || new RecordBVHStatusRequest()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsRecordBVHStatusRequest(bb:flatbuffers.ByteBuffer, obj?:RecordBVHStatusRequest):RecordBVHStatusRequest {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new RecordBVHStatusRequest()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static startRecordBVHStatusRequest(builder:flatbuffers.Builder) {
  builder.startObject(0);
}

static endRecordBVHStatusRequest(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}

static createRecordBVHStatusRequest(builder:flatbuffers.Builder):flatbuffers.Offset {
  RecordBVHStatusRequest.startRecordBVHStatusRequest(builder);
  return RecordBVHStatusRequest.endRecordBVHStatusRequest(builder);
}

unpack(): RecordBVHStatusRequestT {
  return new RecordBVHStatusRequestT();
}


unpackTo(_o: RecordBVHStatusRequestT): void {}
}

export class RecordBVHStatusRequestT implements flatbuffers.IGeneratedObject {
constructor(){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  return RecordBVHStatusRequest.createRecordBVHStatusRequest(builder);
}
}
