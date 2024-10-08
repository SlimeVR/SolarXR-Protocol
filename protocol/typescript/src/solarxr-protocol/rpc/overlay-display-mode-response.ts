// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';



/**
 * The current state of the overlay's display mode.
 */
export class OverlayDisplayModeResponse implements flatbuffers.IUnpackableObject<OverlayDisplayModeResponseT> {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
  __init(i:number, bb:flatbuffers.ByteBuffer):OverlayDisplayModeResponse {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsOverlayDisplayModeResponse(bb:flatbuffers.ByteBuffer, obj?:OverlayDisplayModeResponse):OverlayDisplayModeResponse {
  return (obj || new OverlayDisplayModeResponse()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsOverlayDisplayModeResponse(bb:flatbuffers.ByteBuffer, obj?:OverlayDisplayModeResponse):OverlayDisplayModeResponse {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new OverlayDisplayModeResponse()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

isVisible():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 4);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

isMirrored():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 6);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

static startOverlayDisplayModeResponse(builder:flatbuffers.Builder) {
  builder.startObject(2);
}

static addIsVisible(builder:flatbuffers.Builder, isVisible:boolean) {
  builder.addFieldInt8(0, +isVisible, +false);
}

static addIsMirrored(builder:flatbuffers.Builder, isMirrored:boolean) {
  builder.addFieldInt8(1, +isMirrored, +false);
}

static endOverlayDisplayModeResponse(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}

static createOverlayDisplayModeResponse(builder:flatbuffers.Builder, isVisible:boolean, isMirrored:boolean):flatbuffers.Offset {
  OverlayDisplayModeResponse.startOverlayDisplayModeResponse(builder);
  OverlayDisplayModeResponse.addIsVisible(builder, isVisible);
  OverlayDisplayModeResponse.addIsMirrored(builder, isMirrored);
  return OverlayDisplayModeResponse.endOverlayDisplayModeResponse(builder);
}

unpack(): OverlayDisplayModeResponseT {
  return new OverlayDisplayModeResponseT(
    this.isVisible(),
    this.isMirrored()
  );
}


unpackTo(_o: OverlayDisplayModeResponseT): void {
  _o.isVisible = this.isVisible();
  _o.isMirrored = this.isMirrored();
}
}

export class OverlayDisplayModeResponseT implements flatbuffers.IGeneratedObject {
constructor(
  public isVisible: boolean = false,
  public isMirrored: boolean = false
){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  return OverlayDisplayModeResponse.createOverlayDisplayModeResponse(builder,
    this.isVisible,
    this.isMirrored
  );
}
}
