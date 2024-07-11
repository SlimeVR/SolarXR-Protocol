// automatically generated by the FlatBuffers compiler, do not modify

import { AddUnknownDeviceRequest, AddUnknownDeviceRequestT } from '../../solarxr-protocol/rpc/add-unknown-device-request.js';
import { AssignTrackerRequest, AssignTrackerRequestT } from '../../solarxr-protocol/rpc/assign-tracker-request.js';
import { AutoBoneApplyRequest, AutoBoneApplyRequestT } from '../../solarxr-protocol/rpc/auto-bone-apply-request.js';
import { AutoBoneCancelRecordingRequest, AutoBoneCancelRecordingRequestT } from '../../solarxr-protocol/rpc/auto-bone-cancel-recording-request.js';
import { AutoBoneEpochResponse, AutoBoneEpochResponseT } from '../../solarxr-protocol/rpc/auto-bone-epoch-response.js';
import { AutoBoneProcessRequest, AutoBoneProcessRequestT } from '../../solarxr-protocol/rpc/auto-bone-process-request.js';
import { AutoBoneProcessStatusResponse, AutoBoneProcessStatusResponseT } from '../../solarxr-protocol/rpc/auto-bone-process-status-response.js';
import { AutoBoneStopRecordingRequest, AutoBoneStopRecordingRequestT } from '../../solarxr-protocol/rpc/auto-bone-stop-recording-request.js';
import { ChangeMagToggleRequest, ChangeMagToggleRequestT } from '../../solarxr-protocol/rpc/change-mag-toggle-request.js';
import { ChangeSettingsRequest, ChangeSettingsRequestT } from '../../solarxr-protocol/rpc/change-settings-request.js';
import { ChangeSkeletonConfigRequest, ChangeSkeletonConfigRequestT } from '../../solarxr-protocol/rpc/change-skeleton-config-request.js';
import { ClearDriftCompensationRequest, ClearDriftCompensationRequestT } from '../../solarxr-protocol/rpc/clear-drift-compensation-request.js';
import { ClearMountingResetRequest, ClearMountingResetRequestT } from '../../solarxr-protocol/rpc/clear-mounting-reset-request.js';
import { CloseSerialRequest, CloseSerialRequestT } from '../../solarxr-protocol/rpc/close-serial-request.js';
import { ForgetDeviceRequest, ForgetDeviceRequestT } from '../../solarxr-protocol/rpc/forget-device-request.js';
import { HeartbeatRequest, HeartbeatRequestT } from '../../solarxr-protocol/rpc/heartbeat-request.js';
import { HeartbeatResponse, HeartbeatResponseT } from '../../solarxr-protocol/rpc/heartbeat-response.js';
import { HeightRequest, HeightRequestT } from '../../solarxr-protocol/rpc/height-request.js';
import { HeightResponse, HeightResponseT } from '../../solarxr-protocol/rpc/height-response.js';
import { LegTweaksTmpChange, LegTweaksTmpChangeT } from '../../solarxr-protocol/rpc/leg-tweaks-tmp-change.js';
import { LegTweaksTmpClear, LegTweaksTmpClearT } from '../../solarxr-protocol/rpc/leg-tweaks-tmp-clear.js';
import { MagToggleRequest, MagToggleRequestT } from '../../solarxr-protocol/rpc/mag-toggle-request.js';
import { MagToggleResponse, MagToggleResponseT } from '../../solarxr-protocol/rpc/mag-toggle-response.js';
import { NewSerialDeviceResponse, NewSerialDeviceResponseT } from '../../solarxr-protocol/rpc/new-serial-device-response.js';
import { OpenSerialRequest, OpenSerialRequestT } from '../../solarxr-protocol/rpc/open-serial-request.js';
import { OverlayDisplayModeChangeRequest, OverlayDisplayModeChangeRequestT } from '../../solarxr-protocol/rpc/overlay-display-mode-change-request.js';
import { OverlayDisplayModeRequest, OverlayDisplayModeRequestT } from '../../solarxr-protocol/rpc/overlay-display-mode-request.js';
import { OverlayDisplayModeResponse, OverlayDisplayModeResponseT } from '../../solarxr-protocol/rpc/overlay-display-mode-response.js';
import { RecordBVHRequest, RecordBVHRequestT } from '../../solarxr-protocol/rpc/record-bvhrequest.js';
import { RecordBVHStatus, RecordBVHStatusT } from '../../solarxr-protocol/rpc/record-bvhstatus.js';
import { ResetRequest, ResetRequestT } from '../../solarxr-protocol/rpc/reset-request.js';
import { ResetResponse, ResetResponseT } from '../../solarxr-protocol/rpc/reset-response.js';
import { SaveFileNotification, SaveFileNotificationT } from '../../solarxr-protocol/rpc/save-file-notification.js';
import { SerialDevicesRequest, SerialDevicesRequestT } from '../../solarxr-protocol/rpc/serial-devices-request.js';
import { SerialDevicesResponse, SerialDevicesResponseT } from '../../solarxr-protocol/rpc/serial-devices-response.js';
import { SerialTrackerFactoryResetRequest, SerialTrackerFactoryResetRequestT } from '../../solarxr-protocol/rpc/serial-tracker-factory-reset-request.js';
import { SerialTrackerGetInfoRequest, SerialTrackerGetInfoRequestT } from '../../solarxr-protocol/rpc/serial-tracker-get-info-request.js';
import { SerialTrackerGetWifiScanRequest, SerialTrackerGetWifiScanRequestT } from '../../solarxr-protocol/rpc/serial-tracker-get-wifi-scan-request.js';
import { SerialTrackerRebootRequest, SerialTrackerRebootRequestT } from '../../solarxr-protocol/rpc/serial-tracker-reboot-request.js';
import { SerialUpdateResponse, SerialUpdateResponseT } from '../../solarxr-protocol/rpc/serial-update-response.js';
import { ServerInfosRequest, ServerInfosRequestT } from '../../solarxr-protocol/rpc/server-infos-request.js';
import { ServerInfosResponse, ServerInfosResponseT } from '../../solarxr-protocol/rpc/server-infos-response.js';
import { SetPauseTrackingRequest, SetPauseTrackingRequestT } from '../../solarxr-protocol/rpc/set-pause-tracking-request.js';
import { SetWifiRequest, SetWifiRequestT } from '../../solarxr-protocol/rpc/set-wifi-request.js';
import { SettingsRequest, SettingsRequestT } from '../../solarxr-protocol/rpc/settings-request.js';
import { SettingsResponse, SettingsResponseT } from '../../solarxr-protocol/rpc/settings-response.js';
import { SkeletonConfigRequest, SkeletonConfigRequestT } from '../../solarxr-protocol/rpc/skeleton-config-request.js';
import { SkeletonConfigResponse, SkeletonConfigResponseT } from '../../solarxr-protocol/rpc/skeleton-config-response.js';
import { SkeletonResetAllRequest, SkeletonResetAllRequestT } from '../../solarxr-protocol/rpc/skeleton-reset-all-request.js';
import { StartWifiProvisioningRequest, StartWifiProvisioningRequestT } from '../../solarxr-protocol/rpc/start-wifi-provisioning-request.js';
import { StatusSystemFixed, StatusSystemFixedT } from '../../solarxr-protocol/rpc/status-system-fixed.js';
import { StatusSystemRequest, StatusSystemRequestT } from '../../solarxr-protocol/rpc/status-system-request.js';
import { StatusSystemResponse, StatusSystemResponseT } from '../../solarxr-protocol/rpc/status-system-response.js';
import { StatusSystemUpdate, StatusSystemUpdateT } from '../../solarxr-protocol/rpc/status-system-update.js';
import { StopWifiProvisioningRequest, StopWifiProvisioningRequestT } from '../../solarxr-protocol/rpc/stop-wifi-provisioning-request.js';
import { TapDetectionSetupNotification, TapDetectionSetupNotificationT } from '../../solarxr-protocol/rpc/tap-detection-setup-notification.js';
import { TrackingPauseStateRequest, TrackingPauseStateRequestT } from '../../solarxr-protocol/rpc/tracking-pause-state-request.js';
import { TrackingPauseStateResponse, TrackingPauseStateResponseT } from '../../solarxr-protocol/rpc/tracking-pause-state-response.js';
import { UnknownDeviceHandshakeNotification, UnknownDeviceHandshakeNotificationT } from '../../solarxr-protocol/rpc/unknown-device-handshake-notification.js';
import { WifiProvisioningStatusResponse, WifiProvisioningStatusResponseT } from '../../solarxr-protocol/rpc/wifi-provisioning-status-response.js';


export enum RpcMessage {
  NONE = 0,
  HeartbeatRequest = 1,
  HeartbeatResponse = 2,
  ResetRequest = 3,
  ResetResponse = 4,
  AssignTrackerRequest = 5,
  SettingsRequest = 6,
  SettingsResponse = 7,
  ChangeSettingsRequest = 8,
  ClearDriftCompensationRequest = 9,
  RecordBVHRequest = 10,
  RecordBVHStatus = 11,
  SkeletonConfigRequest = 12,
  ChangeSkeletonConfigRequest = 13,
  SkeletonResetAllRequest = 14,
  SkeletonConfigResponse = 15,
  OpenSerialRequest = 16,
  CloseSerialRequest = 17,
  SetWifiRequest = 18,
  SerialUpdateResponse = 19,
  AutoBoneProcessRequest = 20,
  AutoBoneProcessStatusResponse = 21,
  AutoBoneEpochResponse = 22,
  OverlayDisplayModeRequest = 23,
  OverlayDisplayModeChangeRequest = 24,
  OverlayDisplayModeResponse = 25,
  SerialTrackerRebootRequest = 26,
  SerialTrackerGetInfoRequest = 27,
  SerialTrackerFactoryResetRequest = 28,
  SerialDevicesRequest = 29,
  SerialDevicesResponse = 30,
  NewSerialDeviceResponse = 31,
  StartWifiProvisioningRequest = 32,
  StopWifiProvisioningRequest = 33,
  WifiProvisioningStatusResponse = 34,
  ServerInfosRequest = 35,
  ServerInfosResponse = 36,
  LegTweaksTmpChange = 37,
  LegTweaksTmpClear = 38,
  TapDetectionSetupNotification = 39,
  SetPauseTrackingRequest = 40,
  StatusSystemRequest = 41,
  StatusSystemResponse = 42,
  StatusSystemUpdate = 43,
  StatusSystemFixed = 44,
  ClearMountingResetRequest = 45,
  HeightRequest = 46,
  HeightResponse = 47,
  AutoBoneApplyRequest = 48,
  AutoBoneStopRecordingRequest = 49,
  AutoBoneCancelRecordingRequest = 50,
  SaveFileNotification = 51,
  TrackingPauseStateRequest = 52,
  TrackingPauseStateResponse = 53,
  SerialTrackerGetWifiScanRequest = 54,
  UnknownDeviceHandshakeNotification = 55,
  AddUnknownDeviceRequest = 56,
  ForgetDeviceRequest = 57,
  MagToggleRequest = 58,
  MagToggleResponse = 59,
  ChangeMagToggleRequest = 60
}

export function unionToRpcMessage(
  type: RpcMessage,
  accessor: (obj:AddUnknownDeviceRequest|AssignTrackerRequest|AutoBoneApplyRequest|AutoBoneCancelRecordingRequest|AutoBoneEpochResponse|AutoBoneProcessRequest|AutoBoneProcessStatusResponse|AutoBoneStopRecordingRequest|ChangeMagToggleRequest|ChangeSettingsRequest|ChangeSkeletonConfigRequest|ClearDriftCompensationRequest|ClearMountingResetRequest|CloseSerialRequest|ForgetDeviceRequest|HeartbeatRequest|HeartbeatResponse|HeightRequest|HeightResponse|LegTweaksTmpChange|LegTweaksTmpClear|MagToggleRequest|MagToggleResponse|NewSerialDeviceResponse|OpenSerialRequest|OverlayDisplayModeChangeRequest|OverlayDisplayModeRequest|OverlayDisplayModeResponse|RecordBVHRequest|RecordBVHStatus|ResetRequest|ResetResponse|SaveFileNotification|SerialDevicesRequest|SerialDevicesResponse|SerialTrackerFactoryResetRequest|SerialTrackerGetInfoRequest|SerialTrackerGetWifiScanRequest|SerialTrackerRebootRequest|SerialUpdateResponse|ServerInfosRequest|ServerInfosResponse|SetPauseTrackingRequest|SetWifiRequest|SettingsRequest|SettingsResponse|SkeletonConfigRequest|SkeletonConfigResponse|SkeletonResetAllRequest|StartWifiProvisioningRequest|StatusSystemFixed|StatusSystemRequest|StatusSystemResponse|StatusSystemUpdate|StopWifiProvisioningRequest|TapDetectionSetupNotification|TrackingPauseStateRequest|TrackingPauseStateResponse|UnknownDeviceHandshakeNotification|WifiProvisioningStatusResponse) => AddUnknownDeviceRequest|AssignTrackerRequest|AutoBoneApplyRequest|AutoBoneCancelRecordingRequest|AutoBoneEpochResponse|AutoBoneProcessRequest|AutoBoneProcessStatusResponse|AutoBoneStopRecordingRequest|ChangeMagToggleRequest|ChangeSettingsRequest|ChangeSkeletonConfigRequest|ClearDriftCompensationRequest|ClearMountingResetRequest|CloseSerialRequest|ForgetDeviceRequest|HeartbeatRequest|HeartbeatResponse|HeightRequest|HeightResponse|LegTweaksTmpChange|LegTweaksTmpClear|MagToggleRequest|MagToggleResponse|NewSerialDeviceResponse|OpenSerialRequest|OverlayDisplayModeChangeRequest|OverlayDisplayModeRequest|OverlayDisplayModeResponse|RecordBVHRequest|RecordBVHStatus|ResetRequest|ResetResponse|SaveFileNotification|SerialDevicesRequest|SerialDevicesResponse|SerialTrackerFactoryResetRequest|SerialTrackerGetInfoRequest|SerialTrackerGetWifiScanRequest|SerialTrackerRebootRequest|SerialUpdateResponse|ServerInfosRequest|ServerInfosResponse|SetPauseTrackingRequest|SetWifiRequest|SettingsRequest|SettingsResponse|SkeletonConfigRequest|SkeletonConfigResponse|SkeletonResetAllRequest|StartWifiProvisioningRequest|StatusSystemFixed|StatusSystemRequest|StatusSystemResponse|StatusSystemUpdate|StopWifiProvisioningRequest|TapDetectionSetupNotification|TrackingPauseStateRequest|TrackingPauseStateResponse|UnknownDeviceHandshakeNotification|WifiProvisioningStatusResponse|null
): AddUnknownDeviceRequest|AssignTrackerRequest|AutoBoneApplyRequest|AutoBoneCancelRecordingRequest|AutoBoneEpochResponse|AutoBoneProcessRequest|AutoBoneProcessStatusResponse|AutoBoneStopRecordingRequest|ChangeMagToggleRequest|ChangeSettingsRequest|ChangeSkeletonConfigRequest|ClearDriftCompensationRequest|ClearMountingResetRequest|CloseSerialRequest|ForgetDeviceRequest|HeartbeatRequest|HeartbeatResponse|HeightRequest|HeightResponse|LegTweaksTmpChange|LegTweaksTmpClear|MagToggleRequest|MagToggleResponse|NewSerialDeviceResponse|OpenSerialRequest|OverlayDisplayModeChangeRequest|OverlayDisplayModeRequest|OverlayDisplayModeResponse|RecordBVHRequest|RecordBVHStatus|ResetRequest|ResetResponse|SaveFileNotification|SerialDevicesRequest|SerialDevicesResponse|SerialTrackerFactoryResetRequest|SerialTrackerGetInfoRequest|SerialTrackerGetWifiScanRequest|SerialTrackerRebootRequest|SerialUpdateResponse|ServerInfosRequest|ServerInfosResponse|SetPauseTrackingRequest|SetWifiRequest|SettingsRequest|SettingsResponse|SkeletonConfigRequest|SkeletonConfigResponse|SkeletonResetAllRequest|StartWifiProvisioningRequest|StatusSystemFixed|StatusSystemRequest|StatusSystemResponse|StatusSystemUpdate|StopWifiProvisioningRequest|TapDetectionSetupNotification|TrackingPauseStateRequest|TrackingPauseStateResponse|UnknownDeviceHandshakeNotification|WifiProvisioningStatusResponse|null {
  switch(RpcMessage[type]) {
    case 'NONE': return null; 
    case 'HeartbeatRequest': return accessor(new HeartbeatRequest())! as HeartbeatRequest;
    case 'HeartbeatResponse': return accessor(new HeartbeatResponse())! as HeartbeatResponse;
    case 'ResetRequest': return accessor(new ResetRequest())! as ResetRequest;
    case 'ResetResponse': return accessor(new ResetResponse())! as ResetResponse;
    case 'AssignTrackerRequest': return accessor(new AssignTrackerRequest())! as AssignTrackerRequest;
    case 'SettingsRequest': return accessor(new SettingsRequest())! as SettingsRequest;
    case 'SettingsResponse': return accessor(new SettingsResponse())! as SettingsResponse;
    case 'ChangeSettingsRequest': return accessor(new ChangeSettingsRequest())! as ChangeSettingsRequest;
    case 'ClearDriftCompensationRequest': return accessor(new ClearDriftCompensationRequest())! as ClearDriftCompensationRequest;
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
    case 'SerialDevicesRequest': return accessor(new SerialDevicesRequest())! as SerialDevicesRequest;
    case 'SerialDevicesResponse': return accessor(new SerialDevicesResponse())! as SerialDevicesResponse;
    case 'NewSerialDeviceResponse': return accessor(new NewSerialDeviceResponse())! as NewSerialDeviceResponse;
    case 'StartWifiProvisioningRequest': return accessor(new StartWifiProvisioningRequest())! as StartWifiProvisioningRequest;
    case 'StopWifiProvisioningRequest': return accessor(new StopWifiProvisioningRequest())! as StopWifiProvisioningRequest;
    case 'WifiProvisioningStatusResponse': return accessor(new WifiProvisioningStatusResponse())! as WifiProvisioningStatusResponse;
    case 'ServerInfosRequest': return accessor(new ServerInfosRequest())! as ServerInfosRequest;
    case 'ServerInfosResponse': return accessor(new ServerInfosResponse())! as ServerInfosResponse;
    case 'LegTweaksTmpChange': return accessor(new LegTweaksTmpChange())! as LegTweaksTmpChange;
    case 'LegTweaksTmpClear': return accessor(new LegTweaksTmpClear())! as LegTweaksTmpClear;
    case 'TapDetectionSetupNotification': return accessor(new TapDetectionSetupNotification())! as TapDetectionSetupNotification;
    case 'SetPauseTrackingRequest': return accessor(new SetPauseTrackingRequest())! as SetPauseTrackingRequest;
    case 'StatusSystemRequest': return accessor(new StatusSystemRequest())! as StatusSystemRequest;
    case 'StatusSystemResponse': return accessor(new StatusSystemResponse())! as StatusSystemResponse;
    case 'StatusSystemUpdate': return accessor(new StatusSystemUpdate())! as StatusSystemUpdate;
    case 'StatusSystemFixed': return accessor(new StatusSystemFixed())! as StatusSystemFixed;
    case 'ClearMountingResetRequest': return accessor(new ClearMountingResetRequest())! as ClearMountingResetRequest;
    case 'HeightRequest': return accessor(new HeightRequest())! as HeightRequest;
    case 'HeightResponse': return accessor(new HeightResponse())! as HeightResponse;
    case 'AutoBoneApplyRequest': return accessor(new AutoBoneApplyRequest())! as AutoBoneApplyRequest;
    case 'AutoBoneStopRecordingRequest': return accessor(new AutoBoneStopRecordingRequest())! as AutoBoneStopRecordingRequest;
    case 'AutoBoneCancelRecordingRequest': return accessor(new AutoBoneCancelRecordingRequest())! as AutoBoneCancelRecordingRequest;
    case 'SaveFileNotification': return accessor(new SaveFileNotification())! as SaveFileNotification;
    case 'TrackingPauseStateRequest': return accessor(new TrackingPauseStateRequest())! as TrackingPauseStateRequest;
    case 'TrackingPauseStateResponse': return accessor(new TrackingPauseStateResponse())! as TrackingPauseStateResponse;
    case 'SerialTrackerGetWifiScanRequest': return accessor(new SerialTrackerGetWifiScanRequest())! as SerialTrackerGetWifiScanRequest;
    case 'UnknownDeviceHandshakeNotification': return accessor(new UnknownDeviceHandshakeNotification())! as UnknownDeviceHandshakeNotification;
    case 'AddUnknownDeviceRequest': return accessor(new AddUnknownDeviceRequest())! as AddUnknownDeviceRequest;
    case 'ForgetDeviceRequest': return accessor(new ForgetDeviceRequest())! as ForgetDeviceRequest;
    case 'MagToggleRequest': return accessor(new MagToggleRequest())! as MagToggleRequest;
    case 'MagToggleResponse': return accessor(new MagToggleResponse())! as MagToggleResponse;
    case 'ChangeMagToggleRequest': return accessor(new ChangeMagToggleRequest())! as ChangeMagToggleRequest;
    default: return null;
  }
}

export function unionListToRpcMessage(
  type: RpcMessage, 
  accessor: (index: number, obj:AddUnknownDeviceRequest|AssignTrackerRequest|AutoBoneApplyRequest|AutoBoneCancelRecordingRequest|AutoBoneEpochResponse|AutoBoneProcessRequest|AutoBoneProcessStatusResponse|AutoBoneStopRecordingRequest|ChangeMagToggleRequest|ChangeSettingsRequest|ChangeSkeletonConfigRequest|ClearDriftCompensationRequest|ClearMountingResetRequest|CloseSerialRequest|ForgetDeviceRequest|HeartbeatRequest|HeartbeatResponse|HeightRequest|HeightResponse|LegTweaksTmpChange|LegTweaksTmpClear|MagToggleRequest|MagToggleResponse|NewSerialDeviceResponse|OpenSerialRequest|OverlayDisplayModeChangeRequest|OverlayDisplayModeRequest|OverlayDisplayModeResponse|RecordBVHRequest|RecordBVHStatus|ResetRequest|ResetResponse|SaveFileNotification|SerialDevicesRequest|SerialDevicesResponse|SerialTrackerFactoryResetRequest|SerialTrackerGetInfoRequest|SerialTrackerGetWifiScanRequest|SerialTrackerRebootRequest|SerialUpdateResponse|ServerInfosRequest|ServerInfosResponse|SetPauseTrackingRequest|SetWifiRequest|SettingsRequest|SettingsResponse|SkeletonConfigRequest|SkeletonConfigResponse|SkeletonResetAllRequest|StartWifiProvisioningRequest|StatusSystemFixed|StatusSystemRequest|StatusSystemResponse|StatusSystemUpdate|StopWifiProvisioningRequest|TapDetectionSetupNotification|TrackingPauseStateRequest|TrackingPauseStateResponse|UnknownDeviceHandshakeNotification|WifiProvisioningStatusResponse) => AddUnknownDeviceRequest|AssignTrackerRequest|AutoBoneApplyRequest|AutoBoneCancelRecordingRequest|AutoBoneEpochResponse|AutoBoneProcessRequest|AutoBoneProcessStatusResponse|AutoBoneStopRecordingRequest|ChangeMagToggleRequest|ChangeSettingsRequest|ChangeSkeletonConfigRequest|ClearDriftCompensationRequest|ClearMountingResetRequest|CloseSerialRequest|ForgetDeviceRequest|HeartbeatRequest|HeartbeatResponse|HeightRequest|HeightResponse|LegTweaksTmpChange|LegTweaksTmpClear|MagToggleRequest|MagToggleResponse|NewSerialDeviceResponse|OpenSerialRequest|OverlayDisplayModeChangeRequest|OverlayDisplayModeRequest|OverlayDisplayModeResponse|RecordBVHRequest|RecordBVHStatus|ResetRequest|ResetResponse|SaveFileNotification|SerialDevicesRequest|SerialDevicesResponse|SerialTrackerFactoryResetRequest|SerialTrackerGetInfoRequest|SerialTrackerGetWifiScanRequest|SerialTrackerRebootRequest|SerialUpdateResponse|ServerInfosRequest|ServerInfosResponse|SetPauseTrackingRequest|SetWifiRequest|SettingsRequest|SettingsResponse|SkeletonConfigRequest|SkeletonConfigResponse|SkeletonResetAllRequest|StartWifiProvisioningRequest|StatusSystemFixed|StatusSystemRequest|StatusSystemResponse|StatusSystemUpdate|StopWifiProvisioningRequest|TapDetectionSetupNotification|TrackingPauseStateRequest|TrackingPauseStateResponse|UnknownDeviceHandshakeNotification|WifiProvisioningStatusResponse|null, 
  index: number
): AddUnknownDeviceRequest|AssignTrackerRequest|AutoBoneApplyRequest|AutoBoneCancelRecordingRequest|AutoBoneEpochResponse|AutoBoneProcessRequest|AutoBoneProcessStatusResponse|AutoBoneStopRecordingRequest|ChangeMagToggleRequest|ChangeSettingsRequest|ChangeSkeletonConfigRequest|ClearDriftCompensationRequest|ClearMountingResetRequest|CloseSerialRequest|ForgetDeviceRequest|HeartbeatRequest|HeartbeatResponse|HeightRequest|HeightResponse|LegTweaksTmpChange|LegTweaksTmpClear|MagToggleRequest|MagToggleResponse|NewSerialDeviceResponse|OpenSerialRequest|OverlayDisplayModeChangeRequest|OverlayDisplayModeRequest|OverlayDisplayModeResponse|RecordBVHRequest|RecordBVHStatus|ResetRequest|ResetResponse|SaveFileNotification|SerialDevicesRequest|SerialDevicesResponse|SerialTrackerFactoryResetRequest|SerialTrackerGetInfoRequest|SerialTrackerGetWifiScanRequest|SerialTrackerRebootRequest|SerialUpdateResponse|ServerInfosRequest|ServerInfosResponse|SetPauseTrackingRequest|SetWifiRequest|SettingsRequest|SettingsResponse|SkeletonConfigRequest|SkeletonConfigResponse|SkeletonResetAllRequest|StartWifiProvisioningRequest|StatusSystemFixed|StatusSystemRequest|StatusSystemResponse|StatusSystemUpdate|StopWifiProvisioningRequest|TapDetectionSetupNotification|TrackingPauseStateRequest|TrackingPauseStateResponse|UnknownDeviceHandshakeNotification|WifiProvisioningStatusResponse|null {
  switch(RpcMessage[type]) {
    case 'NONE': return null; 
    case 'HeartbeatRequest': return accessor(index, new HeartbeatRequest())! as HeartbeatRequest;
    case 'HeartbeatResponse': return accessor(index, new HeartbeatResponse())! as HeartbeatResponse;
    case 'ResetRequest': return accessor(index, new ResetRequest())! as ResetRequest;
    case 'ResetResponse': return accessor(index, new ResetResponse())! as ResetResponse;
    case 'AssignTrackerRequest': return accessor(index, new AssignTrackerRequest())! as AssignTrackerRequest;
    case 'SettingsRequest': return accessor(index, new SettingsRequest())! as SettingsRequest;
    case 'SettingsResponse': return accessor(index, new SettingsResponse())! as SettingsResponse;
    case 'ChangeSettingsRequest': return accessor(index, new ChangeSettingsRequest())! as ChangeSettingsRequest;
    case 'ClearDriftCompensationRequest': return accessor(index, new ClearDriftCompensationRequest())! as ClearDriftCompensationRequest;
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
    case 'SerialDevicesRequest': return accessor(index, new SerialDevicesRequest())! as SerialDevicesRequest;
    case 'SerialDevicesResponse': return accessor(index, new SerialDevicesResponse())! as SerialDevicesResponse;
    case 'NewSerialDeviceResponse': return accessor(index, new NewSerialDeviceResponse())! as NewSerialDeviceResponse;
    case 'StartWifiProvisioningRequest': return accessor(index, new StartWifiProvisioningRequest())! as StartWifiProvisioningRequest;
    case 'StopWifiProvisioningRequest': return accessor(index, new StopWifiProvisioningRequest())! as StopWifiProvisioningRequest;
    case 'WifiProvisioningStatusResponse': return accessor(index, new WifiProvisioningStatusResponse())! as WifiProvisioningStatusResponse;
    case 'ServerInfosRequest': return accessor(index, new ServerInfosRequest())! as ServerInfosRequest;
    case 'ServerInfosResponse': return accessor(index, new ServerInfosResponse())! as ServerInfosResponse;
    case 'LegTweaksTmpChange': return accessor(index, new LegTweaksTmpChange())! as LegTweaksTmpChange;
    case 'LegTweaksTmpClear': return accessor(index, new LegTweaksTmpClear())! as LegTweaksTmpClear;
    case 'TapDetectionSetupNotification': return accessor(index, new TapDetectionSetupNotification())! as TapDetectionSetupNotification;
    case 'SetPauseTrackingRequest': return accessor(index, new SetPauseTrackingRequest())! as SetPauseTrackingRequest;
    case 'StatusSystemRequest': return accessor(index, new StatusSystemRequest())! as StatusSystemRequest;
    case 'StatusSystemResponse': return accessor(index, new StatusSystemResponse())! as StatusSystemResponse;
    case 'StatusSystemUpdate': return accessor(index, new StatusSystemUpdate())! as StatusSystemUpdate;
    case 'StatusSystemFixed': return accessor(index, new StatusSystemFixed())! as StatusSystemFixed;
    case 'ClearMountingResetRequest': return accessor(index, new ClearMountingResetRequest())! as ClearMountingResetRequest;
    case 'HeightRequest': return accessor(index, new HeightRequest())! as HeightRequest;
    case 'HeightResponse': return accessor(index, new HeightResponse())! as HeightResponse;
    case 'AutoBoneApplyRequest': return accessor(index, new AutoBoneApplyRequest())! as AutoBoneApplyRequest;
    case 'AutoBoneStopRecordingRequest': return accessor(index, new AutoBoneStopRecordingRequest())! as AutoBoneStopRecordingRequest;
    case 'AutoBoneCancelRecordingRequest': return accessor(index, new AutoBoneCancelRecordingRequest())! as AutoBoneCancelRecordingRequest;
    case 'SaveFileNotification': return accessor(index, new SaveFileNotification())! as SaveFileNotification;
    case 'TrackingPauseStateRequest': return accessor(index, new TrackingPauseStateRequest())! as TrackingPauseStateRequest;
    case 'TrackingPauseStateResponse': return accessor(index, new TrackingPauseStateResponse())! as TrackingPauseStateResponse;
    case 'SerialTrackerGetWifiScanRequest': return accessor(index, new SerialTrackerGetWifiScanRequest())! as SerialTrackerGetWifiScanRequest;
    case 'UnknownDeviceHandshakeNotification': return accessor(index, new UnknownDeviceHandshakeNotification())! as UnknownDeviceHandshakeNotification;
    case 'AddUnknownDeviceRequest': return accessor(index, new AddUnknownDeviceRequest())! as AddUnknownDeviceRequest;
    case 'ForgetDeviceRequest': return accessor(index, new ForgetDeviceRequest())! as ForgetDeviceRequest;
    case 'MagToggleRequest': return accessor(index, new MagToggleRequest())! as MagToggleRequest;
    case 'MagToggleResponse': return accessor(index, new MagToggleResponse())! as MagToggleResponse;
    case 'ChangeMagToggleRequest': return accessor(index, new ChangeMagToggleRequest())! as ChangeMagToggleRequest;
    default: return null;
  }
}
