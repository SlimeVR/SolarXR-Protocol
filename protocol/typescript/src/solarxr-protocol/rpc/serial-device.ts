// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';



export class SerialDevice implements flatbuffers.IUnpackableObject<SerialDeviceT> {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
  __init(i:number, bb:flatbuffers.ByteBuffer):SerialDevice {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsSerialDevice(bb:flatbuffers.ByteBuffer, obj?:SerialDevice):SerialDevice {
  return (obj || new SerialDevice()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsSerialDevice(bb:flatbuffers.ByteBuffer, obj?:SerialDevice):SerialDevice {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new SerialDevice()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

port():string|null
port(optionalEncoding:flatbuffers.Encoding):string|Uint8Array|null
port(optionalEncoding?:any):string|Uint8Array|null {
  const offset = this.bb!.__offset(this.bb_pos, 4);
  return offset ? this.bb!.__string(this.bb_pos + offset, optionalEncoding) : null;
}

name():string|null
name(optionalEncoding:flatbuffers.Encoding):string|Uint8Array|null
name(optionalEncoding?:any):string|Uint8Array|null {
  const offset = this.bb!.__offset(this.bb_pos, 6);
  return offset ? this.bb!.__string(this.bb_pos + offset, optionalEncoding) : null;
}

static startSerialDevice(builder:flatbuffers.Builder) {
  builder.startObject(2);
}

static addPort(builder:flatbuffers.Builder, portOffset:flatbuffers.Offset) {
  builder.addFieldOffset(0, portOffset, 0);
}

static addName(builder:flatbuffers.Builder, nameOffset:flatbuffers.Offset) {
  builder.addFieldOffset(1, nameOffset, 0);
}

static endSerialDevice(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}

static createSerialDevice(builder:flatbuffers.Builder, portOffset:flatbuffers.Offset, nameOffset:flatbuffers.Offset):flatbuffers.Offset {
  SerialDevice.startSerialDevice(builder);
  SerialDevice.addPort(builder, portOffset);
  SerialDevice.addName(builder, nameOffset);
  return SerialDevice.endSerialDevice(builder);
}

unpack(): SerialDeviceT {
  return new SerialDeviceT(
    this.port(),
    this.name()
  );
}


unpackTo(_o: SerialDeviceT): void {
  _o.port = this.port();
  _o.name = this.name();
}
}

export class SerialDeviceT implements flatbuffers.IGeneratedObject {
constructor(
  public port: string|Uint8Array|null = null,
  public name: string|Uint8Array|null = null
){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  const port = (this.port !== null ? builder.createString(this.port!) : 0);
  const name = (this.name !== null ? builder.createString(this.name!) : 0);

  return SerialDevice.createSerialDevice(builder,
    port,
    name
  );
}
}
