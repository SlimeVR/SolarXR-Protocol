// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc

@Suppress("unused")
class RpcMessage private constructor() {
    companion object {
        const val NONE: UByte = 0u
        const val HeartbeatRequest: UByte = 1u
        const val HeartbeatResponse: UByte = 2u
        const val ResetRequest: UByte = 3u
        const val AssignTrackerRequest: UByte = 4u
        const val SettingsRequest: UByte = 5u
        const val SettingsResponse: UByte = 6u
        const val ChangeSettingsRequest: UByte = 7u
        const val ClearDriftCompensationRequest: UByte = 8u
        const val RecordBVHRequest: UByte = 9u
        const val RecordBVHStatus: UByte = 10u
        const val SkeletonConfigRequest: UByte = 11u
        const val ChangeSkeletonConfigRequest: UByte = 12u
        const val SkeletonResetAllRequest: UByte = 13u
        const val SkeletonConfigResponse: UByte = 14u
        const val OpenSerialRequest: UByte = 15u
        const val CloseSerialRequest: UByte = 16u
        const val SetWifiRequest: UByte = 17u
        const val SerialUpdateResponse: UByte = 18u
        const val AutoBoneProcessRequest: UByte = 19u
        const val AutoBoneProcessStatusResponse: UByte = 20u
        const val AutoBoneEpochResponse: UByte = 21u
        const val OverlayDisplayModeRequest: UByte = 22u
        const val OverlayDisplayModeChangeRequest: UByte = 23u
        const val OverlayDisplayModeResponse: UByte = 24u
        const val SerialTrackerRebootRequest: UByte = 25u
        const val SerialTrackerGetInfoRequest: UByte = 26u
        const val SerialTrackerFactoryResetRequest: UByte = 27u
        const val SerialDevicesRequest: UByte = 28u
        const val SerialDevicesResponse: UByte = 29u
        const val NewSerialDeviceResponse: UByte = 30u
        const val StartWifiProvisioningRequest: UByte = 31u
        const val StopWifiProvisioningRequest: UByte = 32u
        const val WifiProvisioningStatusResponse: UByte = 33u
        val names : Array<String> = arrayOf("NONE", "HeartbeatRequest", "HeartbeatResponse", "ResetRequest", "AssignTrackerRequest", "SettingsRequest", "SettingsResponse", "ChangeSettingsRequest", "ClearDriftCompensationRequest", "RecordBVHRequest", "RecordBVHStatus", "SkeletonConfigRequest", "ChangeSkeletonConfigRequest", "SkeletonResetAllRequest", "SkeletonConfigResponse", "OpenSerialRequest", "CloseSerialRequest", "SetWifiRequest", "SerialUpdateResponse", "AutoBoneProcessRequest", "AutoBoneProcessStatusResponse", "AutoBoneEpochResponse", "OverlayDisplayModeRequest", "OverlayDisplayModeChangeRequest", "OverlayDisplayModeResponse", "SerialTrackerRebootRequest", "SerialTrackerGetInfoRequest", "SerialTrackerFactoryResetRequest", "SerialDevicesRequest", "SerialDevicesResponse", "NewSerialDeviceResponse", "StartWifiProvisioningRequest", "StopWifiProvisioningRequest", "WifiProvisioningStatusResponse")
        @JvmStatic
        fun name(e: Int) : String = names[e]
    }
}
