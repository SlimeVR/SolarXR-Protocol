// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc;

import com.google.flatbuffers.FlatBufferBuilder;

public class RpcMessageUnion {
  private byte type;
  private Object value;

  public byte getType() { return type; }

  public void setType(byte type) { this.type = type; }

  public Object getValue() { return value; }

  public void setValue(Object value) { this.value = value; }

  public RpcMessageUnion() {
    this.type = RpcMessage.NONE;
    this.value = null;
  }

  public solarxr_protocol.rpc.HeartbeatRequestT asHeartbeatRequest() { return (solarxr_protocol.rpc.HeartbeatRequestT) value; }
  public solarxr_protocol.rpc.HeartbeatResponseT asHeartbeatResponse() { return (solarxr_protocol.rpc.HeartbeatResponseT) value; }
  public solarxr_protocol.rpc.ResetRequestT asResetRequest() { return (solarxr_protocol.rpc.ResetRequestT) value; }
  public solarxr_protocol.rpc.ResetResponseT asResetResponse() { return (solarxr_protocol.rpc.ResetResponseT) value; }
  public solarxr_protocol.rpc.AssignTrackerRequestT asAssignTrackerRequest() { return (solarxr_protocol.rpc.AssignTrackerRequestT) value; }
  public solarxr_protocol.rpc.SettingsRequestT asSettingsRequest() { return (solarxr_protocol.rpc.SettingsRequestT) value; }
  public solarxr_protocol.rpc.SettingsResponseT asSettingsResponse() { return (solarxr_protocol.rpc.SettingsResponseT) value; }
  public solarxr_protocol.rpc.ChangeSettingsRequestT asChangeSettingsRequest() { return (solarxr_protocol.rpc.ChangeSettingsRequestT) value; }
  public solarxr_protocol.rpc.ClearDriftCompensationRequestT asClearDriftCompensationRequest() { return (solarxr_protocol.rpc.ClearDriftCompensationRequestT) value; }
  public solarxr_protocol.rpc.RecordBVHRequestT asRecordBVHRequest() { return (solarxr_protocol.rpc.RecordBVHRequestT) value; }
  public solarxr_protocol.rpc.RecordBVHStatusT asRecordBVHStatus() { return (solarxr_protocol.rpc.RecordBVHStatusT) value; }
  public solarxr_protocol.rpc.SkeletonConfigRequestT asSkeletonConfigRequest() { return (solarxr_protocol.rpc.SkeletonConfigRequestT) value; }
  public solarxr_protocol.rpc.ChangeSkeletonConfigRequestT asChangeSkeletonConfigRequest() { return (solarxr_protocol.rpc.ChangeSkeletonConfigRequestT) value; }
  public solarxr_protocol.rpc.SkeletonResetAllRequestT asSkeletonResetAllRequest() { return (solarxr_protocol.rpc.SkeletonResetAllRequestT) value; }
  public solarxr_protocol.rpc.SkeletonConfigResponseT asSkeletonConfigResponse() { return (solarxr_protocol.rpc.SkeletonConfigResponseT) value; }
  public solarxr_protocol.rpc.OpenSerialRequestT asOpenSerialRequest() { return (solarxr_protocol.rpc.OpenSerialRequestT) value; }
  public solarxr_protocol.rpc.CloseSerialRequestT asCloseSerialRequest() { return (solarxr_protocol.rpc.CloseSerialRequestT) value; }
  public solarxr_protocol.rpc.SetWifiRequestT asSetWifiRequest() { return (solarxr_protocol.rpc.SetWifiRequestT) value; }
  public solarxr_protocol.rpc.SerialUpdateResponseT asSerialUpdateResponse() { return (solarxr_protocol.rpc.SerialUpdateResponseT) value; }
  public solarxr_protocol.rpc.AutoBoneProcessRequestT asAutoBoneProcessRequest() { return (solarxr_protocol.rpc.AutoBoneProcessRequestT) value; }
  public solarxr_protocol.rpc.AutoBoneProcessStatusResponseT asAutoBoneProcessStatusResponse() { return (solarxr_protocol.rpc.AutoBoneProcessStatusResponseT) value; }
  public solarxr_protocol.rpc.AutoBoneEpochResponseT asAutoBoneEpochResponse() { return (solarxr_protocol.rpc.AutoBoneEpochResponseT) value; }
  public solarxr_protocol.rpc.OverlayDisplayModeRequestT asOverlayDisplayModeRequest() { return (solarxr_protocol.rpc.OverlayDisplayModeRequestT) value; }
  public solarxr_protocol.rpc.OverlayDisplayModeChangeRequestT asOverlayDisplayModeChangeRequest() { return (solarxr_protocol.rpc.OverlayDisplayModeChangeRequestT) value; }
  public solarxr_protocol.rpc.OverlayDisplayModeResponseT asOverlayDisplayModeResponse() { return (solarxr_protocol.rpc.OverlayDisplayModeResponseT) value; }
  public solarxr_protocol.rpc.SerialTrackerRebootRequestT asSerialTrackerRebootRequest() { return (solarxr_protocol.rpc.SerialTrackerRebootRequestT) value; }
  public solarxr_protocol.rpc.SerialTrackerGetInfoRequestT asSerialTrackerGetInfoRequest() { return (solarxr_protocol.rpc.SerialTrackerGetInfoRequestT) value; }
  public solarxr_protocol.rpc.SerialTrackerFactoryResetRequestT asSerialTrackerFactoryResetRequest() { return (solarxr_protocol.rpc.SerialTrackerFactoryResetRequestT) value; }
  public solarxr_protocol.rpc.SerialDevicesRequestT asSerialDevicesRequest() { return (solarxr_protocol.rpc.SerialDevicesRequestT) value; }
  public solarxr_protocol.rpc.SerialDevicesResponseT asSerialDevicesResponse() { return (solarxr_protocol.rpc.SerialDevicesResponseT) value; }
  public solarxr_protocol.rpc.NewSerialDeviceResponseT asNewSerialDeviceResponse() { return (solarxr_protocol.rpc.NewSerialDeviceResponseT) value; }
  public solarxr_protocol.rpc.StartWifiProvisioningRequestT asStartWifiProvisioningRequest() { return (solarxr_protocol.rpc.StartWifiProvisioningRequestT) value; }
  public solarxr_protocol.rpc.StopWifiProvisioningRequestT asStopWifiProvisioningRequest() { return (solarxr_protocol.rpc.StopWifiProvisioningRequestT) value; }
  public solarxr_protocol.rpc.WifiProvisioningStatusResponseT asWifiProvisioningStatusResponse() { return (solarxr_protocol.rpc.WifiProvisioningStatusResponseT) value; }
  public solarxr_protocol.rpc.ServerInfosRequestT asServerInfosRequest() { return (solarxr_protocol.rpc.ServerInfosRequestT) value; }
  public solarxr_protocol.rpc.ServerInfosResponseT asServerInfosResponse() { return (solarxr_protocol.rpc.ServerInfosResponseT) value; }
  public solarxr_protocol.rpc.LegTweaksTmpChangeT asLegTweaksTmpChange() { return (solarxr_protocol.rpc.LegTweaksTmpChangeT) value; }
  public solarxr_protocol.rpc.LegTweaksTmpClearT asLegTweaksTmpClear() { return (solarxr_protocol.rpc.LegTweaksTmpClearT) value; }
  public solarxr_protocol.rpc.TapDetectionSetupNotificationT asTapDetectionSetupNotification() { return (solarxr_protocol.rpc.TapDetectionSetupNotificationT) value; }
  public solarxr_protocol.rpc.SetPauseTrackingRequestT asSetPauseTrackingRequest() { return (solarxr_protocol.rpc.SetPauseTrackingRequestT) value; }
  public solarxr_protocol.rpc.StatusSystemRequestT asStatusSystemRequest() { return (solarxr_protocol.rpc.StatusSystemRequestT) value; }
  public solarxr_protocol.rpc.StatusSystemResponseT asStatusSystemResponse() { return (solarxr_protocol.rpc.StatusSystemResponseT) value; }
  public solarxr_protocol.rpc.StatusSystemUpdateT asStatusSystemUpdate() { return (solarxr_protocol.rpc.StatusSystemUpdateT) value; }
  public solarxr_protocol.rpc.StatusSystemFixedT asStatusSystemFixed() { return (solarxr_protocol.rpc.StatusSystemFixedT) value; }
  public solarxr_protocol.rpc.ClearMountingResetRequestT asClearMountingResetRequest() { return (solarxr_protocol.rpc.ClearMountingResetRequestT) value; }

  public static int pack(FlatBufferBuilder builder, RpcMessageUnion _o) {
    switch (_o.type) {
      case RpcMessage.HeartbeatRequest: return solarxr_protocol.rpc.HeartbeatRequest.pack(builder, _o.asHeartbeatRequest());
      case RpcMessage.HeartbeatResponse: return solarxr_protocol.rpc.HeartbeatResponse.pack(builder, _o.asHeartbeatResponse());
      case RpcMessage.ResetRequest: return solarxr_protocol.rpc.ResetRequest.pack(builder, _o.asResetRequest());
      case RpcMessage.ResetResponse: return solarxr_protocol.rpc.ResetResponse.pack(builder, _o.asResetResponse());
      case RpcMessage.AssignTrackerRequest: return solarxr_protocol.rpc.AssignTrackerRequest.pack(builder, _o.asAssignTrackerRequest());
      case RpcMessage.SettingsRequest: return solarxr_protocol.rpc.SettingsRequest.pack(builder, _o.asSettingsRequest());
      case RpcMessage.SettingsResponse: return solarxr_protocol.rpc.SettingsResponse.pack(builder, _o.asSettingsResponse());
      case RpcMessage.ChangeSettingsRequest: return solarxr_protocol.rpc.ChangeSettingsRequest.pack(builder, _o.asChangeSettingsRequest());
      case RpcMessage.ClearDriftCompensationRequest: return solarxr_protocol.rpc.ClearDriftCompensationRequest.pack(builder, _o.asClearDriftCompensationRequest());
      case RpcMessage.RecordBVHRequest: return solarxr_protocol.rpc.RecordBVHRequest.pack(builder, _o.asRecordBVHRequest());
      case RpcMessage.RecordBVHStatus: return solarxr_protocol.rpc.RecordBVHStatus.pack(builder, _o.asRecordBVHStatus());
      case RpcMessage.SkeletonConfigRequest: return solarxr_protocol.rpc.SkeletonConfigRequest.pack(builder, _o.asSkeletonConfigRequest());
      case RpcMessage.ChangeSkeletonConfigRequest: return solarxr_protocol.rpc.ChangeSkeletonConfigRequest.pack(builder, _o.asChangeSkeletonConfigRequest());
      case RpcMessage.SkeletonResetAllRequest: return solarxr_protocol.rpc.SkeletonResetAllRequest.pack(builder, _o.asSkeletonResetAllRequest());
      case RpcMessage.SkeletonConfigResponse: return solarxr_protocol.rpc.SkeletonConfigResponse.pack(builder, _o.asSkeletonConfigResponse());
      case RpcMessage.OpenSerialRequest: return solarxr_protocol.rpc.OpenSerialRequest.pack(builder, _o.asOpenSerialRequest());
      case RpcMessage.CloseSerialRequest: return solarxr_protocol.rpc.CloseSerialRequest.pack(builder, _o.asCloseSerialRequest());
      case RpcMessage.SetWifiRequest: return solarxr_protocol.rpc.SetWifiRequest.pack(builder, _o.asSetWifiRequest());
      case RpcMessage.SerialUpdateResponse: return solarxr_protocol.rpc.SerialUpdateResponse.pack(builder, _o.asSerialUpdateResponse());
      case RpcMessage.AutoBoneProcessRequest: return solarxr_protocol.rpc.AutoBoneProcessRequest.pack(builder, _o.asAutoBoneProcessRequest());
      case RpcMessage.AutoBoneProcessStatusResponse: return solarxr_protocol.rpc.AutoBoneProcessStatusResponse.pack(builder, _o.asAutoBoneProcessStatusResponse());
      case RpcMessage.AutoBoneEpochResponse: return solarxr_protocol.rpc.AutoBoneEpochResponse.pack(builder, _o.asAutoBoneEpochResponse());
      case RpcMessage.OverlayDisplayModeRequest: return solarxr_protocol.rpc.OverlayDisplayModeRequest.pack(builder, _o.asOverlayDisplayModeRequest());
      case RpcMessage.OverlayDisplayModeChangeRequest: return solarxr_protocol.rpc.OverlayDisplayModeChangeRequest.pack(builder, _o.asOverlayDisplayModeChangeRequest());
      case RpcMessage.OverlayDisplayModeResponse: return solarxr_protocol.rpc.OverlayDisplayModeResponse.pack(builder, _o.asOverlayDisplayModeResponse());
      case RpcMessage.SerialTrackerRebootRequest: return solarxr_protocol.rpc.SerialTrackerRebootRequest.pack(builder, _o.asSerialTrackerRebootRequest());
      case RpcMessage.SerialTrackerGetInfoRequest: return solarxr_protocol.rpc.SerialTrackerGetInfoRequest.pack(builder, _o.asSerialTrackerGetInfoRequest());
      case RpcMessage.SerialTrackerFactoryResetRequest: return solarxr_protocol.rpc.SerialTrackerFactoryResetRequest.pack(builder, _o.asSerialTrackerFactoryResetRequest());
      case RpcMessage.SerialDevicesRequest: return solarxr_protocol.rpc.SerialDevicesRequest.pack(builder, _o.asSerialDevicesRequest());
      case RpcMessage.SerialDevicesResponse: return solarxr_protocol.rpc.SerialDevicesResponse.pack(builder, _o.asSerialDevicesResponse());
      case RpcMessage.NewSerialDeviceResponse: return solarxr_protocol.rpc.NewSerialDeviceResponse.pack(builder, _o.asNewSerialDeviceResponse());
      case RpcMessage.StartWifiProvisioningRequest: return solarxr_protocol.rpc.StartWifiProvisioningRequest.pack(builder, _o.asStartWifiProvisioningRequest());
      case RpcMessage.StopWifiProvisioningRequest: return solarxr_protocol.rpc.StopWifiProvisioningRequest.pack(builder, _o.asStopWifiProvisioningRequest());
      case RpcMessage.WifiProvisioningStatusResponse: return solarxr_protocol.rpc.WifiProvisioningStatusResponse.pack(builder, _o.asWifiProvisioningStatusResponse());
      case RpcMessage.ServerInfosRequest: return solarxr_protocol.rpc.ServerInfosRequest.pack(builder, _o.asServerInfosRequest());
      case RpcMessage.ServerInfosResponse: return solarxr_protocol.rpc.ServerInfosResponse.pack(builder, _o.asServerInfosResponse());
      case RpcMessage.LegTweaksTmpChange: return solarxr_protocol.rpc.LegTweaksTmpChange.pack(builder, _o.asLegTweaksTmpChange());
      case RpcMessage.LegTweaksTmpClear: return solarxr_protocol.rpc.LegTweaksTmpClear.pack(builder, _o.asLegTweaksTmpClear());
      case RpcMessage.TapDetectionSetupNotification: return solarxr_protocol.rpc.TapDetectionSetupNotification.pack(builder, _o.asTapDetectionSetupNotification());
      case RpcMessage.SetPauseTrackingRequest: return solarxr_protocol.rpc.SetPauseTrackingRequest.pack(builder, _o.asSetPauseTrackingRequest());
      case RpcMessage.StatusSystemRequest: return solarxr_protocol.rpc.StatusSystemRequest.pack(builder, _o.asStatusSystemRequest());
      case RpcMessage.StatusSystemResponse: return solarxr_protocol.rpc.StatusSystemResponse.pack(builder, _o.asStatusSystemResponse());
      case RpcMessage.StatusSystemUpdate: return solarxr_protocol.rpc.StatusSystemUpdate.pack(builder, _o.asStatusSystemUpdate());
      case RpcMessage.StatusSystemFixed: return solarxr_protocol.rpc.StatusSystemFixed.pack(builder, _o.asStatusSystemFixed());
      case RpcMessage.ClearMountingResetRequest: return solarxr_protocol.rpc.ClearMountingResetRequest.pack(builder, _o.asClearMountingResetRequest());
      default: return 0;
    }
  }
}

