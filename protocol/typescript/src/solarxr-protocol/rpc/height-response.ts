// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';



/**
 * Returns the current min and max positional tracker heights
 */
export class HeightResponse implements flatbuffers.IUnpackableObject<HeightResponseT> {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
  __init(i:number, bb:flatbuffers.ByteBuffer):HeightResponse {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsHeightResponse(bb:flatbuffers.ByteBuffer, obj?:HeightResponse):HeightResponse {
  return (obj || new HeightResponse()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsHeightResponse(bb:flatbuffers.ByteBuffer, obj?:HeightResponse):HeightResponse {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new HeightResponse()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

minHeight():number {
  const offset = this.bb!.__offset(this.bb_pos, 4);
  return offset ? this.bb!.readFloat32(this.bb_pos + offset) : 0.0;
}

maxHeight():number {
  const offset = this.bb!.__offset(this.bb_pos, 6);
  return offset ? this.bb!.readFloat32(this.bb_pos + offset) : 0.0;
}

static startHeightResponse(builder:flatbuffers.Builder) {
  builder.startObject(2);
}

static addMinHeight(builder:flatbuffers.Builder, minHeight:number) {
  builder.addFieldFloat32(0, minHeight, 0.0);
}

static addMaxHeight(builder:flatbuffers.Builder, maxHeight:number) {
  builder.addFieldFloat32(1, maxHeight, 0.0);
}

static endHeightResponse(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}

static createHeightResponse(builder:flatbuffers.Builder, minHeight:number, maxHeight:number):flatbuffers.Offset {
  HeightResponse.startHeightResponse(builder);
  HeightResponse.addMinHeight(builder, minHeight);
  HeightResponse.addMaxHeight(builder, maxHeight);
  return HeightResponse.endHeightResponse(builder);
}

unpack(): HeightResponseT {
  return new HeightResponseT(
    this.minHeight(),
    this.maxHeight()
  );
}


unpackTo(_o: HeightResponseT): void {
  _o.minHeight = this.minHeight();
  _o.maxHeight = this.maxHeight();
}
}

export class HeightResponseT implements flatbuffers.IGeneratedObject {
constructor(
  public minHeight: number = 0.0,
  public maxHeight: number = 0.0
){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  return HeightResponse.createHeightResponse(builder,
    this.minHeight,
    this.maxHeight
  );
}
}
