// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';



/**
 * Sends a Reboot to the currently over the Serial Montior connected Tracker
 */
export class SerialTrackerRebootRequest {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
__init(i:number, bb:flatbuffers.ByteBuffer):SerialTrackerRebootRequest {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsSerialTrackerRebootRequest(bb:flatbuffers.ByteBuffer, obj?:SerialTrackerRebootRequest):SerialTrackerRebootRequest {
  return (obj || new SerialTrackerRebootRequest()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsSerialTrackerRebootRequest(bb:flatbuffers.ByteBuffer, obj?:SerialTrackerRebootRequest):SerialTrackerRebootRequest {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new SerialTrackerRebootRequest()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static startSerialTrackerRebootRequest(builder:flatbuffers.Builder) {
  builder.startObject(0);
}

static endSerialTrackerRebootRequest(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}

static createSerialTrackerRebootRequest(builder:flatbuffers.Builder):flatbuffers.Offset {
  SerialTrackerRebootRequest.startSerialTrackerRebootRequest(builder);
  return SerialTrackerRebootRequest.endSerialTrackerRebootRequest(builder);
}

unpack(): SerialTrackerRebootRequestT {
  return new SerialTrackerRebootRequestT();
}


unpackTo(_o: SerialTrackerRebootRequestT): void {}
}

export class SerialTrackerRebootRequestT {
constructor(){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  return SerialTrackerRebootRequest.createSerialTrackerRebootRequest(builder);
}
}
