// automatically generated by the FlatBuffers compiler, do not modify

import { AssignTrackerRequest, AssignTrackerRequestT } from '../../solarxr-protocol/rpc/assign-tracker-request';
import { AutoBoneEpochResponse, AutoBoneEpochResponseT } from '../../solarxr-protocol/rpc/auto-bone-epoch-response';
import { AutoBoneProcessRequest, AutoBoneProcessRequestT } from '../../solarxr-protocol/rpc/auto-bone-process-request';
import { AutoBoneProcessStatusResponse, AutoBoneProcessStatusResponseT } from '../../solarxr-protocol/rpc/auto-bone-process-status-response';
import { ChangeSettingsRequest, ChangeSettingsRequestT } from '../../solarxr-protocol/rpc/change-settings-request';
import { ChangeSkeletonConfigRequest, ChangeSkeletonConfigRequestT } from '../../solarxr-protocol/rpc/change-skeleton-config-request';
import { CloseSerialRequest, CloseSerialRequestT } from '../../solarxr-protocol/rpc/close-serial-request';
import { HeartbeatRequest, HeartbeatRequestT } from '../../solarxr-protocol/rpc/heartbeat-request';
import { HeartbeatResponse, HeartbeatResponseT } from '../../solarxr-protocol/rpc/heartbeat-response';
import { OpenSerialRequest, OpenSerialRequestT } from '../../solarxr-protocol/rpc/open-serial-request';
import { OverlayDisplayModeChangeRequest, OverlayDisplayModeChangeRequestT } from '../../solarxr-protocol/rpc/overlay-display-mode-change-request';
import { OverlayDisplayModeRequest, OverlayDisplayModeRequestT } from '../../solarxr-protocol/rpc/overlay-display-mode-request';
import { OverlayDisplayModeResponse, OverlayDisplayModeResponseT } from '../../solarxr-protocol/rpc/overlay-display-mode-response';
import { RecordBVHRequest, RecordBVHRequestT } from '../../solarxr-protocol/rpc/record-bvhrequest';
import { RecordBVHStatus, RecordBVHStatusT } from '../../solarxr-protocol/rpc/record-bvhstatus';
import { ResetRequest, ResetRequestT } from '../../solarxr-protocol/rpc/reset-request';
import { SerialTrackerFactoryResetRequest, SerialTrackerFactoryResetRequestT } from '../../solarxr-protocol/rpc/serial-tracker-factory-reset-request';
import { SerialTrackerGetInfoRequest, SerialTrackerGetInfoRequestT } from '../../solarxr-protocol/rpc/serial-tracker-get-info-request';
import { SerialTrackerRebootRequest, SerialTrackerRebootRequestT } from '../../solarxr-protocol/rpc/serial-tracker-reboot-request';
import { SerialUpdateResponse, SerialUpdateResponseT } from '../../solarxr-protocol/rpc/serial-update-response';
import { SetWifiRequest, SetWifiRequestT } from '../../solarxr-protocol/rpc/set-wifi-request';
import { SettingsRequest, SettingsRequestT } from '../../solarxr-protocol/rpc/settings-request';
import { SettingsResponse, SettingsResponseT } from '../../solarxr-protocol/rpc/settings-response';
import { SkeletonConfigRequest, SkeletonConfigRequestT } from '../../solarxr-protocol/rpc/skeleton-config-request';
import { SkeletonConfigResponse, SkeletonConfigResponseT } from '../../solarxr-protocol/rpc/skeleton-config-response';
import { SkeletonResetAllRequest, SkeletonResetAllRequestT } from '../../solarxr-protocol/rpc/skeleton-reset-all-request';


export enum RpcMessage{
  NONE = 0,
  HeartbeatRequest = 1,
  HeartbeatResponse = 2,
  ResetRequest = 3,
  AssignTrackerRequest = 4,
  SettingsRequest = 5,
  SettingsResponse = 6,
  ChangeSettingsRequest = 7,
  RecordBVHRequest = 8,
  RecordBVHStatus = 9,
  SkeletonConfigRequest = 10,
  ChangeSkeletonConfigRequest = 11,
  SkeletonResetAllRequest = 12,
  SkeletonConfigResponse = 13,
  OpenSerialRequest = 14,
  CloseSerialRequest = 15,
  SetWifiRequest = 16,
  SerialUpdateResponse = 17,
  AutoBoneProcessRequest = 18,
  AutoBoneProcessStatusResponse = 19,
  AutoBoneEpochResponse = 20,
  OverlayDisplayModeRequest = 21,
  OverlayDisplayModeChangeRequest = 22,
  OverlayDisplayModeResponse = 23,
  SerialTrackerRebootRequest = 24,
  SerialTrackerGetInfoRequest = 25,
  SerialTrackerFactoryResetRequest = 26
}

export function unionToRpcMessage(
  type: RpcMessage,
  accessor: (obj:AssignTrackerRequest|AutoBoneEpochResponse|AutoBoneProcessRequest|AutoBoneProcessStatusResponse|ChangeSettingsRequest|ChangeSkeletonConfigRequest|CloseSerialRequest|HeartbeatRequest|HeartbeatResponse|OpenSerialRequest|OverlayDisplayModeChangeRequest|OverlayDisplayModeRequest|OverlayDisplayModeResponse|RecordBVHRequest|RecordBVHStatus|ResetRequest|SerialTrackerFactoryResetRequest|SerialTrackerGetInfoRequest|SerialTrackerRebootRequest|SerialUpdateResponse|SetWifiRequest|SettingsRequest|SettingsResponse|SkeletonConfigRequest|SkeletonConfigResponse|SkeletonResetAllRequest) => AssignTrackerRequest|AutoBoneEpochResponse|AutoBoneProcessRequest|AutoBoneProcessStatusResponse|ChangeSettingsRequest|ChangeSkeletonConfigRequest|CloseSerialRequest|HeartbeatRequest|HeartbeatResponse|OpenSerialRequest|OverlayDisplayModeChangeRequest|OverlayDisplayModeRequest|OverlayDisplayModeResponse|RecordBVHRequest|RecordBVHStatus|ResetRequest|SerialTrackerFactoryResetRequest|SerialTrackerGetInfoRequest|SerialTrackerRebootRequest|SerialUpdateResponse|SetWifiRequest|SettingsRequest|SettingsResponse|SkeletonConfigRequest|SkeletonConfigResponse|SkeletonResetAllRequest|null
): AssignTrackerRequest|AutoBoneEpochResponse|AutoBoneProcessRequest|AutoBoneProcessStatusResponse|ChangeSettingsRequest|ChangeSkeletonConfigRequest|CloseSerialRequest|HeartbeatRequest|HeartbeatResponse|OpenSerialRequest|OverlayDisplayModeChangeRequest|OverlayDisplayModeRequest|OverlayDisplayModeResponse|RecordBVHRequest|RecordBVHStatus|ResetRequest|SerialTrackerFactoryResetRequest|SerialTrackerGetInfoRequest|SerialTrackerRebootRequest|SerialUpdateResponse|SetWifiRequest|SettingsRequest|SettingsResponse|SkeletonConfigRequest|SkeletonConfigResponse|SkeletonResetAllRequest|null {
  switch(RpcMessage[type]) {
    case 'NONE': return null; 
    case 'HeartbeatRequest': return accessor(new HeartbeatRequest())! as HeartbeatRequest;
    case 'HeartbeatResponse': return accessor(new HeartbeatResponse())! as HeartbeatResponse;
    case 'ResetRequest': return accessor(new ResetRequest())! as ResetRequest;
    case 'AssignTrackerRequest': return accessor(new AssignTrackerRequest())! as AssignTrackerRequest;
    case 'SettingsRequest': return accessor(new SettingsRequest())! as SettingsRequest;
    case 'SettingsResponse': return accessor(new SettingsResponse())! as SettingsResponse;
    case 'ChangeSettingsRequest': return accessor(new ChangeSettingsRequest())! as ChangeSettingsRequest;
    case 'RecordBVHRequest': return accessor(new RecordBVHRequest())! as RecordBVHRequest;
    case 'RecordBVHStatus': return accessor(new RecordBVHStatus())! as RecordBVHStatus;
    case 'SkeletonConfigRequest': return accessor(new SkeletonConfigRequest())! as SkeletonConfigRequest;
    case 'ChangeSkeletonConfigRequest': return accessor(new ChangeSkeletonConfigRequest())! as ChangeSkeletonConfigRequest;
    case 'SkeletonResetAllRequest': return accessor(new SkeletonResetAllRequest())! as SkeletonResetAllRequest;
    case 'SkeletonConfigResponse': return accessor(new SkeletonConfigResponse())! as SkeletonConfigResponse;
    case 'OpenSerialRequest': return accessor(new OpenSerialRequest())! as OpenSerialRequest;
    case 'CloseSerialRequest': return accessor(new CloseSerialRequest())! as CloseSerialRequest;
    case 'SetWifiRequest': return accessor(new SetWifiRequest())! as SetWifiRequest;
    case 'SerialUpdateResponse': return accessor(new SerialUpdateResponse())! as SerialUpdateResponse;
    case 'AutoBoneProcessRequest': return accessor(new AutoBoneProcessRequest())! as AutoBoneProcessRequest;
    case 'AutoBoneProcessStatusResponse': return accessor(new AutoBoneProcessStatusResponse())! as AutoBoneProcessStatusResponse;
    case 'AutoBoneEpochResponse': return accessor(new AutoBoneEpochResponse())! as AutoBoneEpochResponse;
    case 'OverlayDisplayModeRequest': return accessor(new OverlayDisplayModeRequest())! as OverlayDisplayModeRequest;
    case 'OverlayDisplayModeChangeRequest': return accessor(new OverlayDisplayModeChangeRequest())! as OverlayDisplayModeChangeRequest;
    case 'OverlayDisplayModeResponse': return accessor(new OverlayDisplayModeResponse())! as OverlayDisplayModeResponse;
    case 'SerialTrackerRebootRequest': return accessor(new SerialTrackerRebootRequest())! as SerialTrackerRebootRequest;
    case 'SerialTrackerGetInfoRequest': return accessor(new SerialTrackerGetInfoRequest())! as SerialTrackerGetInfoRequest;
    case 'SerialTrackerFactoryResetRequest': return accessor(new SerialTrackerFactoryResetRequest())! as SerialTrackerFactoryResetRequest;
    default: return null;
  }
}

export function unionListToRpcMessage(
  type: RpcMessage, 
  accessor: (index: number, obj:AssignTrackerRequest|AutoBoneEpochResponse|AutoBoneProcessRequest|AutoBoneProcessStatusResponse|ChangeSettingsRequest|ChangeSkeletonConfigRequest|CloseSerialRequest|HeartbeatRequest|HeartbeatResponse|OpenSerialRequest|OverlayDisplayModeChangeRequest|OverlayDisplayModeRequest|OverlayDisplayModeResponse|RecordBVHRequest|RecordBVHStatus|ResetRequest|SerialTrackerFactoryResetRequest|SerialTrackerGetInfoRequest|SerialTrackerRebootRequest|SerialUpdateResponse|SetWifiRequest|SettingsRequest|SettingsResponse|SkeletonConfigRequest|SkeletonConfigResponse|SkeletonResetAllRequest) => AssignTrackerRequest|AutoBoneEpochResponse|AutoBoneProcessRequest|AutoBoneProcessStatusResponse|ChangeSettingsRequest|ChangeSkeletonConfigRequest|CloseSerialRequest|HeartbeatRequest|HeartbeatResponse|OpenSerialRequest|OverlayDisplayModeChangeRequest|OverlayDisplayModeRequest|OverlayDisplayModeResponse|RecordBVHRequest|RecordBVHStatus|ResetRequest|SerialTrackerFactoryResetRequest|SerialTrackerGetInfoRequest|SerialTrackerRebootRequest|SerialUpdateResponse|SetWifiRequest|SettingsRequest|SettingsResponse|SkeletonConfigRequest|SkeletonConfigResponse|SkeletonResetAllRequest|null, 
  index: number
): AssignTrackerRequest|AutoBoneEpochResponse|AutoBoneProcessRequest|AutoBoneProcessStatusResponse|ChangeSettingsRequest|ChangeSkeletonConfigRequest|CloseSerialRequest|HeartbeatRequest|HeartbeatResponse|OpenSerialRequest|OverlayDisplayModeChangeRequest|OverlayDisplayModeRequest|OverlayDisplayModeResponse|RecordBVHRequest|RecordBVHStatus|ResetRequest|SerialTrackerFactoryResetRequest|SerialTrackerGetInfoRequest|SerialTrackerRebootRequest|SerialUpdateResponse|SetWifiRequest|SettingsRequest|SettingsResponse|SkeletonConfigRequest|SkeletonConfigResponse|SkeletonResetAllRequest|null {
  switch(RpcMessage[type]) {
    case 'NONE': return null; 
    case 'HeartbeatRequest': return accessor(index, new HeartbeatRequest())! as HeartbeatRequest;
    case 'HeartbeatResponse': return accessor(index, new HeartbeatResponse())! as HeartbeatResponse;
    case 'ResetRequest': return accessor(index, new ResetRequest())! as ResetRequest;
    case 'AssignTrackerRequest': return accessor(index, new AssignTrackerRequest())! as AssignTrackerRequest;
    case 'SettingsRequest': return accessor(index, new SettingsRequest())! as SettingsRequest;
    case 'SettingsResponse': return accessor(index, new SettingsResponse())! as SettingsResponse;
    case 'ChangeSettingsRequest': return accessor(index, new ChangeSettingsRequest())! as ChangeSettingsRequest;
    case 'RecordBVHRequest': return accessor(index, new RecordBVHRequest())! as RecordBVHRequest;
    case 'RecordBVHStatus': return accessor(index, new RecordBVHStatus())! as RecordBVHStatus;
    case 'SkeletonConfigRequest': return accessor(index, new SkeletonConfigRequest())! as SkeletonConfigRequest;
    case 'ChangeSkeletonConfigRequest': return accessor(index, new ChangeSkeletonConfigRequest())! as ChangeSkeletonConfigRequest;
    case 'SkeletonResetAllRequest': return accessor(index, new SkeletonResetAllRequest())! as SkeletonResetAllRequest;
    case 'SkeletonConfigResponse': return accessor(index, new SkeletonConfigResponse())! as SkeletonConfigResponse;
    case 'OpenSerialRequest': return accessor(index, new OpenSerialRequest())! as OpenSerialRequest;
    case 'CloseSerialRequest': return accessor(index, new CloseSerialRequest())! as CloseSerialRequest;
    case 'SetWifiRequest': return accessor(index, new SetWifiRequest())! as SetWifiRequest;
    case 'SerialUpdateResponse': return accessor(index, new SerialUpdateResponse())! as SerialUpdateResponse;
    case 'AutoBoneProcessRequest': return accessor(index, new AutoBoneProcessRequest())! as AutoBoneProcessRequest;
    case 'AutoBoneProcessStatusResponse': return accessor(index, new AutoBoneProcessStatusResponse())! as AutoBoneProcessStatusResponse;
    case 'AutoBoneEpochResponse': return accessor(index, new AutoBoneEpochResponse())! as AutoBoneEpochResponse;
    case 'OverlayDisplayModeRequest': return accessor(index, new OverlayDisplayModeRequest())! as OverlayDisplayModeRequest;
    case 'OverlayDisplayModeChangeRequest': return accessor(index, new OverlayDisplayModeChangeRequest())! as OverlayDisplayModeChangeRequest;
    case 'OverlayDisplayModeResponse': return accessor(index, new OverlayDisplayModeResponse())! as OverlayDisplayModeResponse;
    case 'SerialTrackerRebootRequest': return accessor(index, new SerialTrackerRebootRequest())! as SerialTrackerRebootRequest;
    case 'SerialTrackerGetInfoRequest': return accessor(index, new SerialTrackerGetInfoRequest())! as SerialTrackerGetInfoRequest;
    case 'SerialTrackerFactoryResetRequest': return accessor(index, new SerialTrackerFactoryResetRequest())! as SerialTrackerFactoryResetRequest;
    default: return null;
  }
}

