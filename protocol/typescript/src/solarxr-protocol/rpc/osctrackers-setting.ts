// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';



export class OSCTrackersSetting {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
__init(i:number, bb:flatbuffers.ByteBuffer):OSCTrackersSetting {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsOSCTrackersSetting(bb:flatbuffers.ByteBuffer, obj?:OSCTrackersSetting):OSCTrackersSetting {
  return (obj || new OSCTrackersSetting()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsOSCTrackersSetting(bb:flatbuffers.ByteBuffer, obj?:OSCTrackersSetting):OSCTrackersSetting {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new OSCTrackersSetting()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

head():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 4);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

chest():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 6);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

waist():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 8);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

legs():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 10);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

knees():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 12);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

elbows():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 14);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

hands():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 16);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

static startOSCTrackersSetting(builder:flatbuffers.Builder) {
  builder.startObject(7);
}

static addHead(builder:flatbuffers.Builder, head:boolean) {
  builder.addFieldInt8(0, +head, +false);
}

static addChest(builder:flatbuffers.Builder, chest:boolean) {
  builder.addFieldInt8(1, +chest, +false);
}

static addWaist(builder:flatbuffers.Builder, waist:boolean) {
  builder.addFieldInt8(2, +waist, +false);
}

static addLegs(builder:flatbuffers.Builder, legs:boolean) {
  builder.addFieldInt8(3, +legs, +false);
}

static addKnees(builder:flatbuffers.Builder, knees:boolean) {
  builder.addFieldInt8(4, +knees, +false);
}

static addElbows(builder:flatbuffers.Builder, elbows:boolean) {
  builder.addFieldInt8(5, +elbows, +false);
}

static addHands(builder:flatbuffers.Builder, hands:boolean) {
  builder.addFieldInt8(6, +hands, +false);
}

static endOSCTrackersSetting(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}

static createOSCTrackersSetting(builder:flatbuffers.Builder, head:boolean, chest:boolean, waist:boolean, legs:boolean, knees:boolean, elbows:boolean, hands:boolean):flatbuffers.Offset {
  OSCTrackersSetting.startOSCTrackersSetting(builder);
  OSCTrackersSetting.addHead(builder, head);
  OSCTrackersSetting.addChest(builder, chest);
  OSCTrackersSetting.addWaist(builder, waist);
  OSCTrackersSetting.addLegs(builder, legs);
  OSCTrackersSetting.addKnees(builder, knees);
  OSCTrackersSetting.addElbows(builder, elbows);
  OSCTrackersSetting.addHands(builder, hands);
  return OSCTrackersSetting.endOSCTrackersSetting(builder);
}

unpack(): OSCTrackersSettingT {
  return new OSCTrackersSettingT(
    this.head(),
    this.chest(),
    this.waist(),
    this.legs(),
    this.knees(),
    this.elbows(),
    this.hands()
  );
}


unpackTo(_o: OSCTrackersSettingT): void {
  _o.head = this.head();
  _o.chest = this.chest();
  _o.waist = this.waist();
  _o.legs = this.legs();
  _o.knees = this.knees();
  _o.elbows = this.elbows();
  _o.hands = this.hands();
}
}

export class OSCTrackersSettingT {
constructor(
  public head: boolean = false,
  public chest: boolean = false,
  public waist: boolean = false,
  public legs: boolean = false,
  public knees: boolean = false,
  public elbows: boolean = false,
  public hands: boolean = false
){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  return OSCTrackersSetting.createOSCTrackersSetting(builder,
    this.head,
    this.chest,
    this.waist,
    this.legs,
    this.knees,
    this.elbows,
    this.hands
  );
}
}
