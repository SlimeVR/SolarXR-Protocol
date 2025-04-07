// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';

import { FlightListExtraData, unionToFlightListExtraData, unionListToFlightListExtraData } from '../../solarxr-protocol/rpc/flight-list-extra-data.js';
import { FlightListNeedCalibration, FlightListNeedCalibrationT } from '../../solarxr-protocol/rpc/flight-list-need-calibration.js';
import { FlightListStepId } from '../../solarxr-protocol/rpc/flight-list-step-id.js';
import { FlightListStepVisibility } from '../../solarxr-protocol/rpc/flight-list-step-visibility.js';
import { StatusSteamVRDisconnected, StatusSteamVRDisconnectedT } from '../../solarxr-protocol/rpc/status-steam-vrdisconnected.js';
import { StatusTrackerError, StatusTrackerErrorT } from '../../solarxr-protocol/rpc/status-tracker-error.js';
import { StatusTrackerReset, StatusTrackerResetT } from '../../solarxr-protocol/rpc/status-tracker-reset.js';
import { StatusUnassignedHMD, StatusUnassignedHMDT } from '../../solarxr-protocol/rpc/status-unassigned-hmd.js';


export class FlightListStep implements flatbuffers.IUnpackableObject<FlightListStepT> {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
  __init(i:number, bb:flatbuffers.ByteBuffer):FlightListStep {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsFlightListStep(bb:flatbuffers.ByteBuffer, obj?:FlightListStep):FlightListStep {
  return (obj || new FlightListStep()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsFlightListStep(bb:flatbuffers.ByteBuffer, obj?:FlightListStep):FlightListStep {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new FlightListStep()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

id():FlightListStepId {
  const offset = this.bb!.__offset(this.bb_pos, 4);
  return offset ? this.bb!.readUint8(this.bb_pos + offset) : FlightListStepId.UNKNOWN;
}

valid():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 6);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

visibility():FlightListStepVisibility {
  const offset = this.bb!.__offset(this.bb_pos, 8);
  return offset ? this.bb!.readUint8(this.bb_pos + offset) : FlightListStepVisibility.ALWAYS;
}

optional():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 10);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

ignorable():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 12);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

extraDataType():FlightListExtraData {
  const offset = this.bb!.__offset(this.bb_pos, 14);
  return offset ? this.bb!.readUint8(this.bb_pos + offset) : FlightListExtraData.NONE;
}

extraData<T extends flatbuffers.Table>(obj:any):any|null {
  const offset = this.bb!.__offset(this.bb_pos, 16);
  return offset ? this.bb!.__union(obj, this.bb_pos + offset) : null;
}

static startFlightListStep(builder:flatbuffers.Builder) {
  builder.startObject(7);
}

static addId(builder:flatbuffers.Builder, id:FlightListStepId) {
  builder.addFieldInt8(0, id, FlightListStepId.UNKNOWN);
}

static addValid(builder:flatbuffers.Builder, valid:boolean) {
  builder.addFieldInt8(1, +valid, +false);
}

static addVisibility(builder:flatbuffers.Builder, visibility:FlightListStepVisibility) {
  builder.addFieldInt8(2, visibility, FlightListStepVisibility.ALWAYS);
}

static addOptional(builder:flatbuffers.Builder, optional:boolean) {
  builder.addFieldInt8(3, +optional, +false);
}

static addIgnorable(builder:flatbuffers.Builder, ignorable:boolean) {
  builder.addFieldInt8(4, +ignorable, +false);
}

static addExtraDataType(builder:flatbuffers.Builder, extraDataType:FlightListExtraData) {
  builder.addFieldInt8(5, extraDataType, FlightListExtraData.NONE);
}

static addExtraData(builder:flatbuffers.Builder, extraDataOffset:flatbuffers.Offset) {
  builder.addFieldOffset(6, extraDataOffset, 0);
}

static endFlightListStep(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}

static createFlightListStep(builder:flatbuffers.Builder, id:FlightListStepId, valid:boolean, visibility:FlightListStepVisibility, optional:boolean, ignorable:boolean, extraDataType:FlightListExtraData, extraDataOffset:flatbuffers.Offset):flatbuffers.Offset {
  FlightListStep.startFlightListStep(builder);
  FlightListStep.addId(builder, id);
  FlightListStep.addValid(builder, valid);
  FlightListStep.addVisibility(builder, visibility);
  FlightListStep.addOptional(builder, optional);
  FlightListStep.addIgnorable(builder, ignorable);
  FlightListStep.addExtraDataType(builder, extraDataType);
  FlightListStep.addExtraData(builder, extraDataOffset);
  return FlightListStep.endFlightListStep(builder);
}

unpack(): FlightListStepT {
  return new FlightListStepT(
    this.id(),
    this.valid(),
    this.visibility(),
    this.optional(),
    this.ignorable(),
    this.extraDataType(),
    (() => {
      const temp = unionToFlightListExtraData(this.extraDataType(), this.extraData.bind(this));
      if(temp === null) { return null; }
      return temp.unpack()
  })()
  );
}


unpackTo(_o: FlightListStepT): void {
  _o.id = this.id();
  _o.valid = this.valid();
  _o.visibility = this.visibility();
  _o.optional = this.optional();
  _o.ignorable = this.ignorable();
  _o.extraDataType = this.extraDataType();
  _o.extraData = (() => {
      const temp = unionToFlightListExtraData(this.extraDataType(), this.extraData.bind(this));
      if(temp === null) { return null; }
      return temp.unpack()
  })();
}
}

export class FlightListStepT implements flatbuffers.IGeneratedObject {
constructor(
  public id: FlightListStepId = FlightListStepId.UNKNOWN,
  public valid: boolean = false,
  public visibility: FlightListStepVisibility = FlightListStepVisibility.ALWAYS,
  public optional: boolean = false,
  public ignorable: boolean = false,
  public extraDataType: FlightListExtraData = FlightListExtraData.NONE,
  public extraData: FlightListNeedCalibrationT|StatusSteamVRDisconnectedT|StatusTrackerErrorT|StatusTrackerResetT|StatusUnassignedHMDT|null = null
){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  const extraData = builder.createObjectOffset(this.extraData);

  return FlightListStep.createFlightListStep(builder,
    this.id,
    this.valid,
    this.visibility,
    this.optional,
    this.ignorable,
    this.extraDataType,
    extraData
  );
}
}
