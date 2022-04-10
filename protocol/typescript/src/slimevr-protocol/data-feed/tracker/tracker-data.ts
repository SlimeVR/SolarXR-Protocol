// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';

import { TrackerDataComponentW, TrackerDataComponentWT } from '../../../slimevr-protocol/data-feed/tracker/tracker-data-component-w';
import { TrackerId, TrackerIdT } from '../../../slimevr-protocol/datatypes/tracker-id';


/**
 * Describes all possible information about a tracker. A tracker is anything that
 * provides kinematic data about a particular body part.
 *
 * Trackers may be synthetic/computed or instead part of an actual hardware device.
 * There can be multiple trackers per hardware device.
 */
export class TrackerData {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
__init(i:number, bb:flatbuffers.ByteBuffer):TrackerData {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsTrackerData(bb:flatbuffers.ByteBuffer, obj?:TrackerData):TrackerData {
  return (obj || new TrackerData()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsTrackerData(bb:flatbuffers.ByteBuffer, obj?:TrackerData):TrackerData {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new TrackerData()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

trackerId(obj?:TrackerId):TrackerId|null {
  const offset = this.bb!.__offset(this.bb_pos, 4);
  return offset ? (obj || new TrackerId()).__init(this.bb!.__indirect(this.bb_pos + offset), this.bb!) : null;
}

data(index: number, obj?:TrackerDataComponentW):TrackerDataComponentW|null {
  const offset = this.bb!.__offset(this.bb_pos, 6);
  return offset ? (obj || new TrackerDataComponentW()).__init(this.bb!.__indirect(this.bb!.__vector(this.bb_pos + offset) + index * 4), this.bb!) : null;
}

dataLength():number {
  const offset = this.bb!.__offset(this.bb_pos, 6);
  return offset ? this.bb!.__vector_len(this.bb_pos + offset) : 0;
}

static startTrackerData(builder:flatbuffers.Builder) {
  builder.startObject(2);
}

static addTrackerId(builder:flatbuffers.Builder, trackerIdOffset:flatbuffers.Offset) {
  builder.addFieldOffset(0, trackerIdOffset, 0);
}

static addData(builder:flatbuffers.Builder, dataOffset:flatbuffers.Offset) {
  builder.addFieldOffset(1, dataOffset, 0);
}

static createDataVector(builder:flatbuffers.Builder, data:flatbuffers.Offset[]):flatbuffers.Offset {
  builder.startVector(4, data.length, 4);
  for (let i = data.length - 1; i >= 0; i--) {
    builder.addOffset(data[i]!);
  }
  return builder.endVector();
}

static startDataVector(builder:flatbuffers.Builder, numElems:number) {
  builder.startVector(4, numElems, 4);
}

static endTrackerData(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}

static createTrackerData(builder:flatbuffers.Builder, trackerIdOffset:flatbuffers.Offset, dataOffset:flatbuffers.Offset):flatbuffers.Offset {
  TrackerData.startTrackerData(builder);
  TrackerData.addTrackerId(builder, trackerIdOffset);
  TrackerData.addData(builder, dataOffset);
  return TrackerData.endTrackerData(builder);
}

unpack(): TrackerDataT {
  return new TrackerDataT(
    (this.trackerId() !== null ? this.trackerId()!.unpack() : null),
    this.bb!.createObjList(this.data.bind(this), this.dataLength())
  );
}


unpackTo(_o: TrackerDataT): void {
  _o.trackerId = (this.trackerId() !== null ? this.trackerId()!.unpack() : null);
  _o.data = this.bb!.createObjList(this.data.bind(this), this.dataLength());
}
}

export class TrackerDataT {
constructor(
  public trackerId: TrackerIdT|null = null,
  public data: (TrackerDataComponentWT)[] = []
){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  const trackerId = (this.trackerId !== null ? this.trackerId!.pack(builder) : 0);
  const data = TrackerData.createDataVector(builder, builder.createObjectOffsetList(this.data));

  return TrackerData.createTrackerData(builder,
    trackerId,
    data
  );
}
}
