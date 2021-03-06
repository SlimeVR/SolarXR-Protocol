// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';

import { DataFeedMessageHeader, DataFeedMessageHeaderT } from '../solarxr-protocol/data-feed/data-feed-message-header';
import { RpcMessageHeader, RpcMessageHeaderT } from '../solarxr-protocol/rpc/rpc-message-header';


/**
 * MessageBundle contains all of the messages for the data feed system and the
 * rpc system that will be sent in one buffer.
 */
export class MessageBundle {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
__init(i:number, bb:flatbuffers.ByteBuffer):MessageBundle {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsMessageBundle(bb:flatbuffers.ByteBuffer, obj?:MessageBundle):MessageBundle {
  return (obj || new MessageBundle()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsMessageBundle(bb:flatbuffers.ByteBuffer, obj?:MessageBundle):MessageBundle {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new MessageBundle()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

dataFeedMsgs(index: number, obj?:DataFeedMessageHeader):DataFeedMessageHeader|null {
  const offset = this.bb!.__offset(this.bb_pos, 4);
  return offset ? (obj || new DataFeedMessageHeader()).__init(this.bb!.__indirect(this.bb!.__vector(this.bb_pos + offset) + index * 4), this.bb!) : null;
}

dataFeedMsgsLength():number {
  const offset = this.bb!.__offset(this.bb_pos, 4);
  return offset ? this.bb!.__vector_len(this.bb_pos + offset) : 0;
}

rpcMsgs(index: number, obj?:RpcMessageHeader):RpcMessageHeader|null {
  const offset = this.bb!.__offset(this.bb_pos, 6);
  return offset ? (obj || new RpcMessageHeader()).__init(this.bb!.__indirect(this.bb!.__vector(this.bb_pos + offset) + index * 4), this.bb!) : null;
}

rpcMsgsLength():number {
  const offset = this.bb!.__offset(this.bb_pos, 6);
  return offset ? this.bb!.__vector_len(this.bb_pos + offset) : 0;
}

static startMessageBundle(builder:flatbuffers.Builder) {
  builder.startObject(2);
}

static addDataFeedMsgs(builder:flatbuffers.Builder, dataFeedMsgsOffset:flatbuffers.Offset) {
  builder.addFieldOffset(0, dataFeedMsgsOffset, 0);
}

static createDataFeedMsgsVector(builder:flatbuffers.Builder, data:flatbuffers.Offset[]):flatbuffers.Offset {
  builder.startVector(4, data.length, 4);
  for (let i = data.length - 1; i >= 0; i--) {
    builder.addOffset(data[i]!);
  }
  return builder.endVector();
}

static startDataFeedMsgsVector(builder:flatbuffers.Builder, numElems:number) {
  builder.startVector(4, numElems, 4);
}

static addRpcMsgs(builder:flatbuffers.Builder, rpcMsgsOffset:flatbuffers.Offset) {
  builder.addFieldOffset(1, rpcMsgsOffset, 0);
}

static createRpcMsgsVector(builder:flatbuffers.Builder, data:flatbuffers.Offset[]):flatbuffers.Offset {
  builder.startVector(4, data.length, 4);
  for (let i = data.length - 1; i >= 0; i--) {
    builder.addOffset(data[i]!);
  }
  return builder.endVector();
}

static startRpcMsgsVector(builder:flatbuffers.Builder, numElems:number) {
  builder.startVector(4, numElems, 4);
}

static endMessageBundle(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}

static createMessageBundle(builder:flatbuffers.Builder, dataFeedMsgsOffset:flatbuffers.Offset, rpcMsgsOffset:flatbuffers.Offset):flatbuffers.Offset {
  MessageBundle.startMessageBundle(builder);
  MessageBundle.addDataFeedMsgs(builder, dataFeedMsgsOffset);
  MessageBundle.addRpcMsgs(builder, rpcMsgsOffset);
  return MessageBundle.endMessageBundle(builder);
}

unpack(): MessageBundleT {
  return new MessageBundleT(
    this.bb!.createObjList(this.dataFeedMsgs.bind(this), this.dataFeedMsgsLength()),
    this.bb!.createObjList(this.rpcMsgs.bind(this), this.rpcMsgsLength())
  );
}


unpackTo(_o: MessageBundleT): void {
  _o.dataFeedMsgs = this.bb!.createObjList(this.dataFeedMsgs.bind(this), this.dataFeedMsgsLength());
  _o.rpcMsgs = this.bb!.createObjList(this.rpcMsgs.bind(this), this.rpcMsgsLength());
}
}

export class MessageBundleT {
constructor(
  public dataFeedMsgs: (DataFeedMessageHeaderT)[] = [],
  public rpcMsgs: (RpcMessageHeaderT)[] = []
){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  const dataFeedMsgs = MessageBundle.createDataFeedMsgsVector(builder, builder.createObjectOffsetList(this.dataFeedMsgs));
  const rpcMsgs = MessageBundle.createRpcMsgsVector(builder, builder.createObjectOffsetList(this.rpcMsgs));

  return MessageBundle.createMessageBundle(builder,
    dataFeedMsgs,
    rpcMsgs
  );
}
}
