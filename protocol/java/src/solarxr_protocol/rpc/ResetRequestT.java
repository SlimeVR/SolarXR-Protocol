// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

public class ResetRequestT {
  private int resetType;
  private int[] bodyParts;

  public int getResetType() { return resetType; }

  public void setResetType(int resetType) { this.resetType = resetType; }

  public int[] getBodyParts() { return bodyParts; }

  public void setBodyParts(int[] bodyParts) { this.bodyParts = bodyParts; }


  public ResetRequestT() {
    this.resetType = 0;
    this.bodyParts = null;
  }
}

