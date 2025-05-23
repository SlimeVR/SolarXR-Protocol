// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';

import { StayAlignedTracker, StayAlignedTrackerT } from '../../../solarxr-protocol/data-feed/stay-aligned/stay-aligned-tracker.js';
import { TrackerInfo, TrackerInfoT } from '../../../solarxr-protocol/data-feed/tracker/tracker-info.js';
import { Temperature, TemperatureT } from '../../../solarxr-protocol/datatypes/temperature.js';
import { TrackerId, TrackerIdT } from '../../../solarxr-protocol/datatypes/tracker-id.js';
import { TrackerStatus } from '../../../solarxr-protocol/datatypes/tracker-status.js';
import { Quat, QuatT } from '../../../solarxr-protocol/datatypes/math/quat.js';
import { Vec3f, Vec3fT } from '../../../solarxr-protocol/datatypes/math/vec3f.js';


/**
 * Describes all possible information about a tracker. A tracker is anything that
 * provides kinematic data about a particular body part.
 *
 * Trackers may be synthetic/computed or instead part of an actual hardware device.
 * There can be multiple trackers per hardware device.
 */
export class TrackerData implements flatbuffers.IUnpackableObject<TrackerDataT> {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
  __init(i:number, bb:flatbuffers.ByteBuffer):TrackerData {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsTrackerData(bb:flatbuffers.ByteBuffer, obj?:TrackerData):TrackerData {
  return (obj || new TrackerData()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsTrackerData(bb:flatbuffers.ByteBuffer, obj?:TrackerData):TrackerData {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new TrackerData()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

trackerId(obj?:TrackerId):TrackerId|null {
  const offset = this.bb!.__offset(this.bb_pos, 4);
  return offset ? (obj || new TrackerId()).__init(this.bb!.__indirect(this.bb_pos + offset), this.bb!) : null;
}

info(obj?:TrackerInfo):TrackerInfo|null {
  const offset = this.bb!.__offset(this.bb_pos, 6);
  return offset ? (obj || new TrackerInfo()).__init(this.bb!.__indirect(this.bb_pos + offset), this.bb!) : null;
}

status():TrackerStatus {
  const offset = this.bb!.__offset(this.bb_pos, 8);
  return offset ? this.bb!.readUint8(this.bb_pos + offset) : TrackerStatus.NONE;
}

/**
 * Sensor rotation after fusion
 */
rotation(obj?:Quat):Quat|null {
  const offset = this.bb!.__offset(this.bb_pos, 10);
  return offset ? (obj || new Quat()).__init(this.bb_pos + offset, this.bb!) : null;
}

/**
 * Position, in meters
 */
position(obj?:Vec3f):Vec3f|null {
  const offset = this.bb!.__offset(this.bb_pos, 12);
  return offset ? (obj || new Vec3f()).__init(this.bb_pos + offset, this.bb!) : null;
}

/**
 * Raw angular velocity, in euler angles, rad/s
 */
rawAngularVelocity(obj?:Vec3f):Vec3f|null {
  const offset = this.bb!.__offset(this.bb_pos, 14);
  return offset ? (obj || new Vec3f()).__init(this.bb_pos + offset, this.bb!) : null;
}

/**
 * Raw acceleration, in m/s^2
 */
rawAcceleration(obj?:Vec3f):Vec3f|null {
  const offset = this.bb!.__offset(this.bb_pos, 16);
  return offset ? (obj || new Vec3f()).__init(this.bb_pos + offset, this.bb!) : null;
}

/**
 * Temperature, in degrees celsius
 */
temp(obj?:Temperature):Temperature|null {
  const offset = this.bb!.__offset(this.bb_pos, 18);
  return offset ? (obj || new Temperature()).__init(this.bb_pos + offset, this.bb!) : null;
}

/**
 * Acceleration without gravity, in m/s^2
 */
linearAcceleration(obj?:Vec3f):Vec3f|null {
  const offset = this.bb!.__offset(this.bb_pos, 20);
  return offset ? (obj || new Vec3f()).__init(this.bb_pos + offset, this.bb!) : null;
}

/**
 * Reference-adjusted rotation for IMU-only trackers (VR HMD yaw is used as a reset reference).
 * In other words, a rotation that is aligned to a reliable source of rotation ((0, VR HMD YAW, 0)),
 * triggered after user input (using reset buttons).
 * This is a SlimeVR-specific field and computed exclusively by SlimeVR server.
 * Includes: mounting orientation, full, quick and mounting reset adjustments.
 * This rotation can be used to reconstruct a skeleton pose using forward kinematics.
 */
rotationReferenceAdjusted(obj?:Quat):Quat|null {
  const offset = this.bb!.__offset(this.bb_pos, 22);
  return offset ? (obj || new Quat()).__init(this.bb_pos + offset, this.bb!) : null;
}

/**
 * Zero-reference-adjusted rotation for IMU-only trackers (identity quaternion is used as a reset reference).
 * In other words, a rotation that is aligned to a zero vector ((0, 0, 0)) by
 * inverting the current rotation, triggered after user input (using reset buttons).
 * This is a SlimeVR-specific field and computed exclusively by SlimeVR server.
 * Includes: only full and quick reset adjustments.
 * This rotation can be used in visualizations for IMU debugging.
 */
rotationIdentityAdjusted(obj?:Quat):Quat|null {
  const offset = this.bb!.__offset(this.bb_pos, 24);
  return offset ? (obj || new Quat()).__init(this.bb_pos + offset, this.bb!) : null;
}

/**
 * Data ticks per second, processed by SlimeVR server
 */
tps():number|null {
  const offset = this.bb!.__offset(this.bb_pos, 26);
  return offset ? this.bb!.readUint16(this.bb_pos + offset) : null;
}

/**
 * Magnetic field vector, in mGauss
 */
rawMagneticVector(obj?:Vec3f):Vec3f|null {
  const offset = this.bb!.__offset(this.bb_pos, 28);
  return offset ? (obj || new Vec3f()).__init(this.bb_pos + offset, this.bb!) : null;
}

/**
 * Stay Aligned
 */
stayAligned(obj?:StayAlignedTracker):StayAlignedTracker|null {
  const offset = this.bb!.__offset(this.bb_pos, 30);
  return offset ? (obj || new StayAlignedTracker()).__init(this.bb!.__indirect(this.bb_pos + offset), this.bb!) : null;
}

static startTrackerData(builder:flatbuffers.Builder) {
  builder.startObject(14);
}

static addTrackerId(builder:flatbuffers.Builder, trackerIdOffset:flatbuffers.Offset) {
  builder.addFieldOffset(0, trackerIdOffset, 0);
}

static addInfo(builder:flatbuffers.Builder, infoOffset:flatbuffers.Offset) {
  builder.addFieldOffset(1, infoOffset, 0);
}

static addStatus(builder:flatbuffers.Builder, status:TrackerStatus) {
  builder.addFieldInt8(2, status, TrackerStatus.NONE);
}

static addRotation(builder:flatbuffers.Builder, rotationOffset:flatbuffers.Offset) {
  builder.addFieldStruct(3, rotationOffset, 0);
}

static addPosition(builder:flatbuffers.Builder, positionOffset:flatbuffers.Offset) {
  builder.addFieldStruct(4, positionOffset, 0);
}

static addRawAngularVelocity(builder:flatbuffers.Builder, rawAngularVelocityOffset:flatbuffers.Offset) {
  builder.addFieldStruct(5, rawAngularVelocityOffset, 0);
}

static addRawAcceleration(builder:flatbuffers.Builder, rawAccelerationOffset:flatbuffers.Offset) {
  builder.addFieldStruct(6, rawAccelerationOffset, 0);
}

static addTemp(builder:flatbuffers.Builder, tempOffset:flatbuffers.Offset) {
  builder.addFieldStruct(7, tempOffset, 0);
}

static addLinearAcceleration(builder:flatbuffers.Builder, linearAccelerationOffset:flatbuffers.Offset) {
  builder.addFieldStruct(8, linearAccelerationOffset, 0);
}

static addRotationReferenceAdjusted(builder:flatbuffers.Builder, rotationReferenceAdjustedOffset:flatbuffers.Offset) {
  builder.addFieldStruct(9, rotationReferenceAdjustedOffset, 0);
}

static addRotationIdentityAdjusted(builder:flatbuffers.Builder, rotationIdentityAdjustedOffset:flatbuffers.Offset) {
  builder.addFieldStruct(10, rotationIdentityAdjustedOffset, 0);
}

static addTps(builder:flatbuffers.Builder, tps:number) {
  builder.addFieldInt16(11, tps, 0);
}

static addRawMagneticVector(builder:flatbuffers.Builder, rawMagneticVectorOffset:flatbuffers.Offset) {
  builder.addFieldStruct(12, rawMagneticVectorOffset, 0);
}

static addStayAligned(builder:flatbuffers.Builder, stayAlignedOffset:flatbuffers.Offset) {
  builder.addFieldOffset(13, stayAlignedOffset, 0);
}

static endTrackerData(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}


unpack(): TrackerDataT {
  return new TrackerDataT(
    (this.trackerId() !== null ? this.trackerId()!.unpack() : null),
    (this.info() !== null ? this.info()!.unpack() : null),
    this.status(),
    (this.rotation() !== null ? this.rotation()!.unpack() : null),
    (this.position() !== null ? this.position()!.unpack() : null),
    (this.rawAngularVelocity() !== null ? this.rawAngularVelocity()!.unpack() : null),
    (this.rawAcceleration() !== null ? this.rawAcceleration()!.unpack() : null),
    (this.temp() !== null ? this.temp()!.unpack() : null),
    (this.linearAcceleration() !== null ? this.linearAcceleration()!.unpack() : null),
    (this.rotationReferenceAdjusted() !== null ? this.rotationReferenceAdjusted()!.unpack() : null),
    (this.rotationIdentityAdjusted() !== null ? this.rotationIdentityAdjusted()!.unpack() : null),
    this.tps(),
    (this.rawMagneticVector() !== null ? this.rawMagneticVector()!.unpack() : null),
    (this.stayAligned() !== null ? this.stayAligned()!.unpack() : null)
  );
}


unpackTo(_o: TrackerDataT): void {
  _o.trackerId = (this.trackerId() !== null ? this.trackerId()!.unpack() : null);
  _o.info = (this.info() !== null ? this.info()!.unpack() : null);
  _o.status = this.status();
  _o.rotation = (this.rotation() !== null ? this.rotation()!.unpack() : null);
  _o.position = (this.position() !== null ? this.position()!.unpack() : null);
  _o.rawAngularVelocity = (this.rawAngularVelocity() !== null ? this.rawAngularVelocity()!.unpack() : null);
  _o.rawAcceleration = (this.rawAcceleration() !== null ? this.rawAcceleration()!.unpack() : null);
  _o.temp = (this.temp() !== null ? this.temp()!.unpack() : null);
  _o.linearAcceleration = (this.linearAcceleration() !== null ? this.linearAcceleration()!.unpack() : null);
  _o.rotationReferenceAdjusted = (this.rotationReferenceAdjusted() !== null ? this.rotationReferenceAdjusted()!.unpack() : null);
  _o.rotationIdentityAdjusted = (this.rotationIdentityAdjusted() !== null ? this.rotationIdentityAdjusted()!.unpack() : null);
  _o.tps = this.tps();
  _o.rawMagneticVector = (this.rawMagneticVector() !== null ? this.rawMagneticVector()!.unpack() : null);
  _o.stayAligned = (this.stayAligned() !== null ? this.stayAligned()!.unpack() : null);
}
}

export class TrackerDataT implements flatbuffers.IGeneratedObject {
constructor(
  public trackerId: TrackerIdT|null = null,
  public info: TrackerInfoT|null = null,
  public status: TrackerStatus = TrackerStatus.NONE,
  public rotation: QuatT|null = null,
  public position: Vec3fT|null = null,
  public rawAngularVelocity: Vec3fT|null = null,
  public rawAcceleration: Vec3fT|null = null,
  public temp: TemperatureT|null = null,
  public linearAcceleration: Vec3fT|null = null,
  public rotationReferenceAdjusted: QuatT|null = null,
  public rotationIdentityAdjusted: QuatT|null = null,
  public tps: number|null = null,
  public rawMagneticVector: Vec3fT|null = null,
  public stayAligned: StayAlignedTrackerT|null = null
){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  const trackerId = (this.trackerId !== null ? this.trackerId!.pack(builder) : 0);
  const info = (this.info !== null ? this.info!.pack(builder) : 0);
  const stayAligned = (this.stayAligned !== null ? this.stayAligned!.pack(builder) : 0);

  TrackerData.startTrackerData(builder);
  TrackerData.addTrackerId(builder, trackerId);
  TrackerData.addInfo(builder, info);
  TrackerData.addStatus(builder, this.status);
  TrackerData.addRotation(builder, (this.rotation !== null ? this.rotation!.pack(builder) : 0));
  TrackerData.addPosition(builder, (this.position !== null ? this.position!.pack(builder) : 0));
  TrackerData.addRawAngularVelocity(builder, (this.rawAngularVelocity !== null ? this.rawAngularVelocity!.pack(builder) : 0));
  TrackerData.addRawAcceleration(builder, (this.rawAcceleration !== null ? this.rawAcceleration!.pack(builder) : 0));
  TrackerData.addTemp(builder, (this.temp !== null ? this.temp!.pack(builder) : 0));
  TrackerData.addLinearAcceleration(builder, (this.linearAcceleration !== null ? this.linearAcceleration!.pack(builder) : 0));
  TrackerData.addRotationReferenceAdjusted(builder, (this.rotationReferenceAdjusted !== null ? this.rotationReferenceAdjusted!.pack(builder) : 0));
  TrackerData.addRotationIdentityAdjusted(builder, (this.rotationIdentityAdjusted !== null ? this.rotationIdentityAdjusted!.pack(builder) : 0));
  if (this.tps !== null)
    TrackerData.addTps(builder, this.tps);
  TrackerData.addRawMagneticVector(builder, (this.rawMagneticVector !== null ? this.rawMagneticVector!.pack(builder) : 0));
  TrackerData.addStayAligned(builder, stayAligned);

  return TrackerData.endTrackerData(builder);
}
}
