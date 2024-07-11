// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';

import { TrackerId, TrackerIdT } from '../../solarxr-protocol/datatypes/tracker-id.js';


/**
 * If no tracker ID is given, it's the setting for every tracker/device
 */
export class ChangeMagToggleRequest implements flatbuffers.IUnpackableObject<ChangeMagToggleRequestT> {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
  __init(i:number, bb:flatbuffers.ByteBuffer):ChangeMagToggleRequest {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsChangeMagToggleRequest(bb:flatbuffers.ByteBuffer, obj?:ChangeMagToggleRequest):ChangeMagToggleRequest {
  return (obj || new ChangeMagToggleRequest()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsChangeMagToggleRequest(bb:flatbuffers.ByteBuffer, obj?:ChangeMagToggleRequest):ChangeMagToggleRequest {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new ChangeMagToggleRequest()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

trackerId(obj?:TrackerId):TrackerId|null {
  const offset = this.bb!.__offset(this.bb_pos, 4);
  return offset ? (obj || new TrackerId()).__init(this.bb!.__indirect(this.bb_pos + offset), this.bb!) : null;
}

enable():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 6);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

static startChangeMagToggleRequest(builder:flatbuffers.Builder) {
  builder.startObject(2);
}

static addTrackerId(builder:flatbuffers.Builder, trackerIdOffset:flatbuffers.Offset) {
  builder.addFieldOffset(0, trackerIdOffset, 0);
}

static addEnable(builder:flatbuffers.Builder, enable:boolean) {
  builder.addFieldInt8(1, +enable, +false);
}

static endChangeMagToggleRequest(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}

static createChangeMagToggleRequest(builder:flatbuffers.Builder, trackerIdOffset:flatbuffers.Offset, enable:boolean):flatbuffers.Offset {
  ChangeMagToggleRequest.startChangeMagToggleRequest(builder);
  ChangeMagToggleRequest.addTrackerId(builder, trackerIdOffset);
  ChangeMagToggleRequest.addEnable(builder, enable);
  return ChangeMagToggleRequest.endChangeMagToggleRequest(builder);
}

unpack(): ChangeMagToggleRequestT {
  return new ChangeMagToggleRequestT(
    (this.trackerId() !== null ? this.trackerId()!.unpack() : null),
    this.enable()
  );
}


unpackTo(_o: ChangeMagToggleRequestT): void {
  _o.trackerId = (this.trackerId() !== null ? this.trackerId()!.unpack() : null);
  _o.enable = this.enable();
}
}

export class ChangeMagToggleRequestT implements flatbuffers.IGeneratedObject {
constructor(
  public trackerId: TrackerIdT|null = null,
  public enable: boolean = false
){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  const trackerId = (this.trackerId !== null ? this.trackerId!.pack(builder) : 0);

  return ChangeMagToggleRequest.createChangeMagToggleRequest(builder,
    trackerId,
    this.enable
  );
}
}
