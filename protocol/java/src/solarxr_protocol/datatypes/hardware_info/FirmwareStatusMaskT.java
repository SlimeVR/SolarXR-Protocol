// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.datatypes.hardware_info;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

public class FirmwareStatusMaskT {
  private boolean errorStatus;
  private boolean tps;
  private boolean ping;
  private boolean rssi;
  private boolean mcuTemp;
  private boolean batteryVoltage;
  private boolean batteryPctEstimate;

  public boolean getErrorStatus() { return errorStatus; }

  public void setErrorStatus(boolean errorStatus) { this.errorStatus = errorStatus; }

  public boolean getTps() { return tps; }

  public void setTps(boolean tps) { this.tps = tps; }

  public boolean getPing() { return ping; }

  public void setPing(boolean ping) { this.ping = ping; }

  public boolean getRssi() { return rssi; }

  public void setRssi(boolean rssi) { this.rssi = rssi; }

  public boolean getMcuTemp() { return mcuTemp; }

  public void setMcuTemp(boolean mcuTemp) { this.mcuTemp = mcuTemp; }

  public boolean getBatteryVoltage() { return batteryVoltage; }

  public void setBatteryVoltage(boolean batteryVoltage) { this.batteryVoltage = batteryVoltage; }

  public boolean getBatteryPctEstimate() { return batteryPctEstimate; }

  public void setBatteryPctEstimate(boolean batteryPctEstimate) { this.batteryPctEstimate = batteryPctEstimate; }


  public FirmwareStatusMaskT() {
    this.errorStatus = false;
    this.tps = false;
    this.ping = false;
    this.rssi = false;
    this.mcuTemp = false;
    this.batteryVoltage = false;
    this.batteryPctEstimate = false;
  }
}
