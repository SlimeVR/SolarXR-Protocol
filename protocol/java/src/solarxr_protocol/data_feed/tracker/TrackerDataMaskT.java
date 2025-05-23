// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.data_feed.tracker;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

public class TrackerDataMaskT {
  private boolean info;
  private boolean status;
  private boolean rotation;
  private boolean position;
  private boolean rawAngularVelocity;
  private boolean rawAcceleration;
  private boolean temp;
  private boolean linearAcceleration;
  private boolean rotationReferenceAdjusted;
  private boolean rotationIdentityAdjusted;
  private boolean tps;
  private boolean rawMagneticVector;
  private boolean stayAligned;

  public boolean getInfo() { return info; }

  public void setInfo(boolean info) { this.info = info; }

  public boolean getStatus() { return status; }

  public void setStatus(boolean status) { this.status = status; }

  public boolean getRotation() { return rotation; }

  public void setRotation(boolean rotation) { this.rotation = rotation; }

  public boolean getPosition() { return position; }

  public void setPosition(boolean position) { this.position = position; }

  public boolean getRawAngularVelocity() { return rawAngularVelocity; }

  public void setRawAngularVelocity(boolean rawAngularVelocity) { this.rawAngularVelocity = rawAngularVelocity; }

  public boolean getRawAcceleration() { return rawAcceleration; }

  public void setRawAcceleration(boolean rawAcceleration) { this.rawAcceleration = rawAcceleration; }

  public boolean getTemp() { return temp; }

  public void setTemp(boolean temp) { this.temp = temp; }

  public boolean getLinearAcceleration() { return linearAcceleration; }

  public void setLinearAcceleration(boolean linearAcceleration) { this.linearAcceleration = linearAcceleration; }

  public boolean getRotationReferenceAdjusted() { return rotationReferenceAdjusted; }

  public void setRotationReferenceAdjusted(boolean rotationReferenceAdjusted) { this.rotationReferenceAdjusted = rotationReferenceAdjusted; }

  public boolean getRotationIdentityAdjusted() { return rotationIdentityAdjusted; }

  public void setRotationIdentityAdjusted(boolean rotationIdentityAdjusted) { this.rotationIdentityAdjusted = rotationIdentityAdjusted; }

  public boolean getTps() { return tps; }

  public void setTps(boolean tps) { this.tps = tps; }

  public boolean getRawMagneticVector() { return rawMagneticVector; }

  public void setRawMagneticVector(boolean rawMagneticVector) { this.rawMagneticVector = rawMagneticVector; }

  public boolean getStayAligned() { return stayAligned; }

  public void setStayAligned(boolean stayAligned) { this.stayAligned = stayAligned; }


  public TrackerDataMaskT() {
    this.info = false;
    this.status = false;
    this.rotation = false;
    this.position = false;
    this.rawAngularVelocity = false;
    this.rawAcceleration = false;
    this.temp = false;
    this.linearAcceleration = false;
    this.rotationReferenceAdjusted = false;
    this.rotationIdentityAdjusted = false;
    this.tps = false;
    this.rawMagneticVector = false;
    this.stayAligned = false;
  }
}

