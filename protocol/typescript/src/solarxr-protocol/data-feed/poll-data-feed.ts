// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';

import { DataFeedConfig, DataFeedConfigT } from '../../solarxr-protocol/data-feed/data-feed-config.js';


/**
 * Requests for a single `Update` to be sent. This is helpful when getting
 * initial info about the device.
 */
export class PollDataFeed implements flatbuffers.IUnpackableObject<PollDataFeedT> {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
  __init(i:number, bb:flatbuffers.ByteBuffer):PollDataFeed {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsPollDataFeed(bb:flatbuffers.ByteBuffer, obj?:PollDataFeed):PollDataFeed {
  return (obj || new PollDataFeed()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsPollDataFeed(bb:flatbuffers.ByteBuffer, obj?:PollDataFeed):PollDataFeed {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new PollDataFeed()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

config(obj?:DataFeedConfig):DataFeedConfig|null {
  const offset = this.bb!.__offset(this.bb_pos, 4);
  return offset ? (obj || new DataFeedConfig()).__init(this.bb!.__indirect(this.bb_pos + offset), this.bb!) : null;
}

static startPollDataFeed(builder:flatbuffers.Builder) {
  builder.startObject(1);
}

static addConfig(builder:flatbuffers.Builder, configOffset:flatbuffers.Offset) {
  builder.addFieldOffset(0, configOffset, 0);
}

static endPollDataFeed(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}

static createPollDataFeed(builder:flatbuffers.Builder, configOffset:flatbuffers.Offset):flatbuffers.Offset {
  PollDataFeed.startPollDataFeed(builder);
  PollDataFeed.addConfig(builder, configOffset);
  return PollDataFeed.endPollDataFeed(builder);
}

unpack(): PollDataFeedT {
  return new PollDataFeedT(
    (this.config() !== null ? this.config()!.unpack() : null)
  );
}


unpackTo(_o: PollDataFeedT): void {
  _o.config = (this.config() !== null ? this.config()!.unpack() : null);
}
}

export class PollDataFeedT implements flatbuffers.IGeneratedObject {
constructor(
  public config: DataFeedConfigT|null = null
){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  const config = (this.config !== null ? this.config!.pack(builder) : 0);

  return PollDataFeed.createPollDataFeed(builder,
    config
  );
}
}
