// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';

import { ArmsMountingResetMode } from '../../solarxr-protocol/rpc/arms-mounting-reset-mode.js';


export class ResetsSettings implements flatbuffers.IUnpackableObject<ResetsSettingsT> {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
  __init(i:number, bb:flatbuffers.ByteBuffer):ResetsSettings {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsResetsSettings(bb:flatbuffers.ByteBuffer, obj?:ResetsSettings):ResetsSettings {
  return (obj || new ResetsSettings()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsResetsSettings(bb:flatbuffers.ByteBuffer, obj?:ResetsSettings):ResetsSettings {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new ResetsSettings()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

armsMountingResetMode():ArmsMountingResetMode {
  const offset = this.bb!.__offset(this.bb_pos, 6);
  return offset ? this.bb!.readUint8(this.bb_pos + offset) : ArmsMountingResetMode.BACK;
}

yawResetSmoothTime():number {
  const offset = this.bb!.__offset(this.bb_pos, 8);
  return offset ? this.bb!.readFloat32(this.bb_pos + offset) : 0.0;
}

saveMountingReset():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 10);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

resetHmdPitch():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 12);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

static startResetsSettings(builder:flatbuffers.Builder) {
  builder.startObject(5);
}

static addArmsMountingResetMode(builder:flatbuffers.Builder, armsMountingResetMode:ArmsMountingResetMode) {
  builder.addFieldInt8(1, armsMountingResetMode, ArmsMountingResetMode.BACK);
}

static addYawResetSmoothTime(builder:flatbuffers.Builder, yawResetSmoothTime:number) {
  builder.addFieldFloat32(2, yawResetSmoothTime, 0.0);
}

static addSaveMountingReset(builder:flatbuffers.Builder, saveMountingReset:boolean) {
  builder.addFieldInt8(3, +saveMountingReset, +false);
}

static addResetHmdPitch(builder:flatbuffers.Builder, resetHmdPitch:boolean) {
  builder.addFieldInt8(4, +resetHmdPitch, +false);
}

static endResetsSettings(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}

static createResetsSettings(builder:flatbuffers.Builder, armsMountingResetMode:ArmsMountingResetMode, yawResetSmoothTime:number, saveMountingReset:boolean, resetHmdPitch:boolean):flatbuffers.Offset {
  ResetsSettings.startResetsSettings(builder);
  ResetsSettings.addArmsMountingResetMode(builder, armsMountingResetMode);
  ResetsSettings.addYawResetSmoothTime(builder, yawResetSmoothTime);
  ResetsSettings.addSaveMountingReset(builder, saveMountingReset);
  ResetsSettings.addResetHmdPitch(builder, resetHmdPitch);
  return ResetsSettings.endResetsSettings(builder);
}

unpack(): ResetsSettingsT {
  return new ResetsSettingsT(
    this.armsMountingResetMode(),
    this.yawResetSmoothTime(),
    this.saveMountingReset(),
    this.resetHmdPitch()
  );
}


unpackTo(_o: ResetsSettingsT): void {
  _o.armsMountingResetMode = this.armsMountingResetMode();
  _o.yawResetSmoothTime = this.yawResetSmoothTime();
  _o.saveMountingReset = this.saveMountingReset();
  _o.resetHmdPitch = this.resetHmdPitch();
}
}

export class ResetsSettingsT implements flatbuffers.IGeneratedObject {
constructor(
  public armsMountingResetMode: ArmsMountingResetMode = ArmsMountingResetMode.BACK,
  public yawResetSmoothTime: number = 0.0,
  public saveMountingReset: boolean = false,
  public resetHmdPitch: boolean = false
){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  return ResetsSettings.createResetsSettings(builder,
    this.armsMountingResetMode,
    this.yawResetSmoothTime,
    this.saveMountingReset,
    this.resetHmdPitch
  );
}
}
