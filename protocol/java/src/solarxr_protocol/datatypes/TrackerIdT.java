// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.datatypes;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

public class TrackerIdT {
  private solarxr_protocol.datatypes.DeviceIdT deviceId;
  private int trackerNum;

  public solarxr_protocol.datatypes.DeviceIdT getDeviceId() { return deviceId; }

  public void setDeviceId(solarxr_protocol.datatypes.DeviceIdT deviceId) { this.deviceId = deviceId; }

  public int getTrackerNum() { return trackerNum; }

  public void setTrackerNum(int trackerNum) { this.trackerNum = trackerNum; }


  public TrackerIdT() {
    this.deviceId = new solarxr_protocol.datatypes.DeviceIdT();
    this.trackerNum = 0;
  }
}

