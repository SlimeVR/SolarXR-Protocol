// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc;

import com.google.flatbuffers.FlatBufferBuilder;

public class FlightListExtraDataUnion {
  private byte type;
  private Object value;

  public byte getType() { return type; }

  public void setType(byte type) { this.type = type; }

  public Object getValue() { return value; }

  public void setValue(Object value) { this.value = value; }

  public FlightListExtraDataUnion() {
    this.type = FlightListExtraData.NONE;
    this.value = null;
  }

  public solarxr_protocol.rpc.FlightListTrackerResetT asFlightListTrackerReset() { return (solarxr_protocol.rpc.FlightListTrackerResetT) value; }
  public solarxr_protocol.rpc.FlightListTrackerErrorT asFlightListTrackerError() { return (solarxr_protocol.rpc.FlightListTrackerErrorT) value; }
  public solarxr_protocol.rpc.FlightListSteamVRDisconnectedT asFlightListSteamVRDisconnected() { return (solarxr_protocol.rpc.FlightListSteamVRDisconnectedT) value; }
  public solarxr_protocol.rpc.FlightListUnassignedHMDT asFlightListUnassignedHMD() { return (solarxr_protocol.rpc.FlightListUnassignedHMDT) value; }
  public solarxr_protocol.rpc.FlightListNeedCalibrationT asFlightListNeedCalibration() { return (solarxr_protocol.rpc.FlightListNeedCalibrationT) value; }

  public static int pack(FlatBufferBuilder builder, FlightListExtraDataUnion _o) {
    switch (_o.type) {
      case FlightListExtraData.FlightListTrackerReset: return solarxr_protocol.rpc.FlightListTrackerReset.pack(builder, _o.asFlightListTrackerReset());
      case FlightListExtraData.FlightListTrackerError: return solarxr_protocol.rpc.FlightListTrackerError.pack(builder, _o.asFlightListTrackerError());
      case FlightListExtraData.FlightListSteamVRDisconnected: return solarxr_protocol.rpc.FlightListSteamVRDisconnected.pack(builder, _o.asFlightListSteamVRDisconnected());
      case FlightListExtraData.FlightListUnassignedHMD: return solarxr_protocol.rpc.FlightListUnassignedHMD.pack(builder, _o.asFlightListUnassignedHMD());
      case FlightListExtraData.FlightListNeedCalibration: return solarxr_protocol.rpc.FlightListNeedCalibration.pack(builder, _o.asFlightListNeedCalibration());
      default: return 0;
    }
  }
}

