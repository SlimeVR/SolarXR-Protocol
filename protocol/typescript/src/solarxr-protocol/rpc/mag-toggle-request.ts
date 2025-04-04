// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';

import { TrackerId, TrackerIdT } from '../../solarxr-protocol/datatypes/tracker-id.js';


/**
 * If no tracker ID is given, it's the setting for every tracker/device
 */
export class MagToggleRequest implements flatbuffers.IUnpackableObject<MagToggleRequestT> {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
  __init(i:number, bb:flatbuffers.ByteBuffer):MagToggleRequest {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsMagToggleRequest(bb:flatbuffers.ByteBuffer, obj?:MagToggleRequest):MagToggleRequest {
  return (obj || new MagToggleRequest()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsMagToggleRequest(bb:flatbuffers.ByteBuffer, obj?:MagToggleRequest):MagToggleRequest {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new MagToggleRequest()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

trackerId(obj?:TrackerId):TrackerId|null {
  const offset = this.bb!.__offset(this.bb_pos, 4);
  return offset ? (obj || new TrackerId()).__init(this.bb!.__indirect(this.bb_pos + offset), this.bb!) : null;
}

static startMagToggleRequest(builder:flatbuffers.Builder) {
  builder.startObject(1);
}

static addTrackerId(builder:flatbuffers.Builder, trackerIdOffset:flatbuffers.Offset) {
  builder.addFieldOffset(0, trackerIdOffset, 0);
}

static endMagToggleRequest(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}

static createMagToggleRequest(builder:flatbuffers.Builder, trackerIdOffset:flatbuffers.Offset):flatbuffers.Offset {
  MagToggleRequest.startMagToggleRequest(builder);
  MagToggleRequest.addTrackerId(builder, trackerIdOffset);
  return MagToggleRequest.endMagToggleRequest(builder);
}

unpack(): MagToggleRequestT {
  return new MagToggleRequestT(
    (this.trackerId() !== null ? this.trackerId()!.unpack() : null)
  );
}


unpackTo(_o: MagToggleRequestT): void {
  _o.trackerId = (this.trackerId() !== null ? this.trackerId()!.unpack() : null);
}
}

export class MagToggleRequestT implements flatbuffers.IGeneratedObject {
constructor(
  public trackerId: TrackerIdT|null = null
){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  const trackerId = (this.trackerId !== null ? this.trackerId!.pack(builder) : 0);

  return MagToggleRequest.createMagToggleRequest(builder,
    trackerId
  );
}
}
