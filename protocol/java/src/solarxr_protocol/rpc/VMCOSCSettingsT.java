// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

public class VMCOSCSettingsT {
  private solarxr_protocol.rpc.OSCSettingsT oscSettings;
  private String vrmJson;
  private boolean anchorHip;

  public solarxr_protocol.rpc.OSCSettingsT getOscSettings() { return oscSettings; }

  public void setOscSettings(solarxr_protocol.rpc.OSCSettingsT oscSettings) { this.oscSettings = oscSettings; }

  public String getVrmJson() { return vrmJson; }

  public void setVrmJson(String vrmJson) { this.vrmJson = vrmJson; }

  public boolean getAnchorHip() { return anchorHip; }

  public void setAnchorHip(boolean anchorHip) { this.anchorHip = anchorHip; }


  public VMCOSCSettingsT() {
    this.oscSettings = null;
    this.vrmJson = null;
    this.anchorHip = false;
  }
}

