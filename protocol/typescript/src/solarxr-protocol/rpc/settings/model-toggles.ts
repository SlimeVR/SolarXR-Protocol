// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';



/**
 * Settings for the skeletal model that are toggles.
 */
export class ModelToggles implements flatbuffers.IUnpackableObject<ModelTogglesT> {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
  __init(i:number, bb:flatbuffers.ByteBuffer):ModelToggles {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsModelToggles(bb:flatbuffers.ByteBuffer, obj?:ModelToggles):ModelToggles {
  return (obj || new ModelToggles()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsModelToggles(bb:flatbuffers.ByteBuffer, obj?:ModelToggles):ModelToggles {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new ModelToggles()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

extendedSpine():boolean|null {
  const offset = this.bb!.__offset(this.bb_pos, 4);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : null;
}

extendedPelvis():boolean|null {
  const offset = this.bb!.__offset(this.bb_pos, 6);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : null;
}

extendedKnee():boolean|null {
  const offset = this.bb!.__offset(this.bb_pos, 8);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : null;
}

forceArmsFromHmd():boolean|null {
  const offset = this.bb!.__offset(this.bb_pos, 10);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : null;
}

floorClip():boolean|null {
  const offset = this.bb!.__offset(this.bb_pos, 12);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : null;
}

skatingCorrection():boolean|null {
  const offset = this.bb!.__offset(this.bb_pos, 14);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : null;
}

viveEmulation():boolean|null {
  const offset = this.bb!.__offset(this.bb_pos, 16);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : null;
}

toeSnap():boolean|null {
  const offset = this.bb!.__offset(this.bb_pos, 18);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : null;
}

footPlant():boolean|null {
  const offset = this.bb!.__offset(this.bb_pos, 20);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : null;
}

selfLocalization():boolean|null {
  const offset = this.bb!.__offset(this.bb_pos, 22);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : null;
}

static startModelToggles(builder:flatbuffers.Builder) {
  builder.startObject(10);
}

static addExtendedSpine(builder:flatbuffers.Builder, extendedSpine:boolean) {
  builder.addFieldInt8(0, +extendedSpine, 0);
}

static addExtendedPelvis(builder:flatbuffers.Builder, extendedPelvis:boolean) {
  builder.addFieldInt8(1, +extendedPelvis, 0);
}

static addExtendedKnee(builder:flatbuffers.Builder, extendedKnee:boolean) {
  builder.addFieldInt8(2, +extendedKnee, 0);
}

static addForceArmsFromHmd(builder:flatbuffers.Builder, forceArmsFromHmd:boolean) {
  builder.addFieldInt8(3, +forceArmsFromHmd, 0);
}

static addFloorClip(builder:flatbuffers.Builder, floorClip:boolean) {
  builder.addFieldInt8(4, +floorClip, 0);
}

static addSkatingCorrection(builder:flatbuffers.Builder, skatingCorrection:boolean) {
  builder.addFieldInt8(5, +skatingCorrection, 0);
}

static addViveEmulation(builder:flatbuffers.Builder, viveEmulation:boolean) {
  builder.addFieldInt8(6, +viveEmulation, 0);
}

static addToeSnap(builder:flatbuffers.Builder, toeSnap:boolean) {
  builder.addFieldInt8(7, +toeSnap, 0);
}

static addFootPlant(builder:flatbuffers.Builder, footPlant:boolean) {
  builder.addFieldInt8(8, +footPlant, 0);
}

static addSelfLocalization(builder:flatbuffers.Builder, selfLocalization:boolean) {
  builder.addFieldInt8(9, +selfLocalization, 0);
}

static endModelToggles(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}

static createModelToggles(builder:flatbuffers.Builder, extendedSpine:boolean|null, extendedPelvis:boolean|null, extendedKnee:boolean|null, forceArmsFromHmd:boolean|null, floorClip:boolean|null, skatingCorrection:boolean|null, viveEmulation:boolean|null, toeSnap:boolean|null, footPlant:boolean|null, selfLocalization:boolean|null):flatbuffers.Offset {
  ModelToggles.startModelToggles(builder);
  if (extendedSpine !== null)
    ModelToggles.addExtendedSpine(builder, extendedSpine);
  if (extendedPelvis !== null)
    ModelToggles.addExtendedPelvis(builder, extendedPelvis);
  if (extendedKnee !== null)
    ModelToggles.addExtendedKnee(builder, extendedKnee);
  if (forceArmsFromHmd !== null)
    ModelToggles.addForceArmsFromHmd(builder, forceArmsFromHmd);
  if (floorClip !== null)
    ModelToggles.addFloorClip(builder, floorClip);
  if (skatingCorrection !== null)
    ModelToggles.addSkatingCorrection(builder, skatingCorrection);
  if (viveEmulation !== null)
    ModelToggles.addViveEmulation(builder, viveEmulation);
  if (toeSnap !== null)
    ModelToggles.addToeSnap(builder, toeSnap);
  if (footPlant !== null)
    ModelToggles.addFootPlant(builder, footPlant);
  if (selfLocalization !== null)
    ModelToggles.addSelfLocalization(builder, selfLocalization);
  return ModelToggles.endModelToggles(builder);
}

unpack(): ModelTogglesT {
  return new ModelTogglesT(
    this.extendedSpine(),
    this.extendedPelvis(),
    this.extendedKnee(),
    this.forceArmsFromHmd(),
    this.floorClip(),
    this.skatingCorrection(),
    this.viveEmulation(),
    this.toeSnap(),
    this.footPlant(),
    this.selfLocalization()
  );
}


unpackTo(_o: ModelTogglesT): void {
  _o.extendedSpine = this.extendedSpine();
  _o.extendedPelvis = this.extendedPelvis();
  _o.extendedKnee = this.extendedKnee();
  _o.forceArmsFromHmd = this.forceArmsFromHmd();
  _o.floorClip = this.floorClip();
  _o.skatingCorrection = this.skatingCorrection();
  _o.viveEmulation = this.viveEmulation();
  _o.toeSnap = this.toeSnap();
  _o.footPlant = this.footPlant();
  _o.selfLocalization = this.selfLocalization();
}
}

export class ModelTogglesT implements flatbuffers.IGeneratedObject {
constructor(
  public extendedSpine: boolean|null = null,
  public extendedPelvis: boolean|null = null,
  public extendedKnee: boolean|null = null,
  public forceArmsFromHmd: boolean|null = null,
  public floorClip: boolean|null = null,
  public skatingCorrection: boolean|null = null,
  public viveEmulation: boolean|null = null,
  public toeSnap: boolean|null = null,
  public footPlant: boolean|null = null,
  public selfLocalization: boolean|null = null
){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  return ModelToggles.createModelToggles(builder,
    this.extendedSpine,
    this.extendedPelvis,
    this.extendedKnee,
    this.forceArmsFromHmd,
    this.floorClip,
    this.skatingCorrection,
    this.viveEmulation,
    this.toeSnap,
    this.footPlant,
    this.selfLocalization
  );
}
}
