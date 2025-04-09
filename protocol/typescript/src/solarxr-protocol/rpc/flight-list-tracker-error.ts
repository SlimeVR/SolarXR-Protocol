// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';

import { TrackerId, TrackerIdT } from '../../solarxr-protocol/datatypes/tracker-id.js';


/**
 * Trackers with error state
 */
export class FlightListTrackerError implements flatbuffers.IUnpackableObject<FlightListTrackerErrorT> {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
  __init(i:number, bb:flatbuffers.ByteBuffer):FlightListTrackerError {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsFlightListTrackerError(bb:flatbuffers.ByteBuffer, obj?:FlightListTrackerError):FlightListTrackerError {
  return (obj || new FlightListTrackerError()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsFlightListTrackerError(bb:flatbuffers.ByteBuffer, obj?:FlightListTrackerError):FlightListTrackerError {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new FlightListTrackerError()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

trackersId(index: number, obj?:TrackerId):TrackerId|null {
  const offset = this.bb!.__offset(this.bb_pos, 4);
  return offset ? (obj || new TrackerId()).__init(this.bb!.__indirect(this.bb!.__vector(this.bb_pos + offset) + index * 4), this.bb!) : null;
}

trackersIdLength():number {
  const offset = this.bb!.__offset(this.bb_pos, 4);
  return offset ? this.bb!.__vector_len(this.bb_pos + offset) : 0;
}

static startFlightListTrackerError(builder:flatbuffers.Builder) {
  builder.startObject(1);
}

static addTrackersId(builder:flatbuffers.Builder, trackersIdOffset:flatbuffers.Offset) {
  builder.addFieldOffset(0, trackersIdOffset, 0);
}

static createTrackersIdVector(builder:flatbuffers.Builder, data:flatbuffers.Offset[]):flatbuffers.Offset {
  builder.startVector(4, data.length, 4);
  for (let i = data.length - 1; i >= 0; i--) {
    builder.addOffset(data[i]!);
  }
  return builder.endVector();
}

static startTrackersIdVector(builder:flatbuffers.Builder, numElems:number) {
  builder.startVector(4, numElems, 4);
}

static endFlightListTrackerError(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}

static createFlightListTrackerError(builder:flatbuffers.Builder, trackersIdOffset:flatbuffers.Offset):flatbuffers.Offset {
  FlightListTrackerError.startFlightListTrackerError(builder);
  FlightListTrackerError.addTrackersId(builder, trackersIdOffset);
  return FlightListTrackerError.endFlightListTrackerError(builder);
}

unpack(): FlightListTrackerErrorT {
  return new FlightListTrackerErrorT(
    this.bb!.createObjList<TrackerId, TrackerIdT>(this.trackersId.bind(this), this.trackersIdLength())
  );
}


unpackTo(_o: FlightListTrackerErrorT): void {
  _o.trackersId = this.bb!.createObjList<TrackerId, TrackerIdT>(this.trackersId.bind(this), this.trackersIdLength());
}
}

export class FlightListTrackerErrorT implements flatbuffers.IGeneratedObject {
constructor(
  public trackersId: (TrackerIdT)[] = []
){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  const trackersId = FlightListTrackerError.createTrackersIdVector(builder, builder.createObjectOffsetList(this.trackersId));

  return FlightListTrackerError.createFlightListTrackerError(builder,
    trackersId
  );
}
}
