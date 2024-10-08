// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';



/**
 * Sends the GET WIFISCAN cmd to the current tracker on the serial monitor
 */
export class SerialTrackerGetWifiScanRequest implements flatbuffers.IUnpackableObject<SerialTrackerGetWifiScanRequestT> {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
  __init(i:number, bb:flatbuffers.ByteBuffer):SerialTrackerGetWifiScanRequest {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsSerialTrackerGetWifiScanRequest(bb:flatbuffers.ByteBuffer, obj?:SerialTrackerGetWifiScanRequest):SerialTrackerGetWifiScanRequest {
  return (obj || new SerialTrackerGetWifiScanRequest()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsSerialTrackerGetWifiScanRequest(bb:flatbuffers.ByteBuffer, obj?:SerialTrackerGetWifiScanRequest):SerialTrackerGetWifiScanRequest {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new SerialTrackerGetWifiScanRequest()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static startSerialTrackerGetWifiScanRequest(builder:flatbuffers.Builder) {
  builder.startObject(0);
}

static endSerialTrackerGetWifiScanRequest(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}

static createSerialTrackerGetWifiScanRequest(builder:flatbuffers.Builder):flatbuffers.Offset {
  SerialTrackerGetWifiScanRequest.startSerialTrackerGetWifiScanRequest(builder);
  return SerialTrackerGetWifiScanRequest.endSerialTrackerGetWifiScanRequest(builder);
}

unpack(): SerialTrackerGetWifiScanRequestT {
  return new SerialTrackerGetWifiScanRequestT();
}


unpackTo(_o: SerialTrackerGetWifiScanRequestT): void {}
}

export class SerialTrackerGetWifiScanRequestT implements flatbuffers.IGeneratedObject {
constructor(){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  return SerialTrackerGetWifiScanRequest.createSerialTrackerGetWifiScanRequest(builder);
}
}
