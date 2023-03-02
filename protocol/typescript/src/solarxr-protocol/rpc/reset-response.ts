// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';

import { ResetStatus } from '../../solarxr-protocol/rpc/reset-status.js';
import { ResetType } from '../../solarxr-protocol/rpc/reset-type.js';


export class ResetResponse implements flatbuffers.IUnpackableObject<ResetResponseT> {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
  __init(i:number, bb:flatbuffers.ByteBuffer):ResetResponse {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsResetResponse(bb:flatbuffers.ByteBuffer, obj?:ResetResponse):ResetResponse {
  return (obj || new ResetResponse()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsResetResponse(bb:flatbuffers.ByteBuffer, obj?:ResetResponse):ResetResponse {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new ResetResponse()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

resetType():ResetType {
  const offset = this.bb!.__offset(this.bb_pos, 4);
  return offset ? this.bb!.readUint8(this.bb_pos + offset) : ResetType.Yaw;
}

status():ResetStatus {
  const offset = this.bb!.__offset(this.bb_pos, 6);
  return offset ? this.bb!.readUint8(this.bb_pos + offset) : ResetStatus.STARTED;
}

static startResetResponse(builder:flatbuffers.Builder) {
  builder.startObject(2);
}

static addResetType(builder:flatbuffers.Builder, resetType:ResetType) {
  builder.addFieldInt8(0, resetType, ResetType.Yaw);
}

static addStatus(builder:flatbuffers.Builder, status:ResetStatus) {
  builder.addFieldInt8(1, status, ResetStatus.STARTED);
}

static endResetResponse(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}

static createResetResponse(builder:flatbuffers.Builder, resetType:ResetType, status:ResetStatus):flatbuffers.Offset {
  ResetResponse.startResetResponse(builder);
  ResetResponse.addResetType(builder, resetType);
  ResetResponse.addStatus(builder, status);
  return ResetResponse.endResetResponse(builder);
}

unpack(): ResetResponseT {
  return new ResetResponseT(
    this.resetType(),
    this.status()
  );
}


unpackTo(_o: ResetResponseT): void {
  _o.resetType = this.resetType();
  _o.status = this.status();
}
}

export class ResetResponseT implements flatbuffers.IGeneratedObject {
constructor(
  public resetType: ResetType = ResetType.Yaw,
  public status: ResetStatus = ResetStatus.STARTED
){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  return ResetResponse.createResetResponse(builder,
    this.resetType,
    this.status
  );
}
}
