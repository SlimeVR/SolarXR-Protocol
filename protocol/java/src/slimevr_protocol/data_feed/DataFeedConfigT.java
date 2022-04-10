// automatically generated by the FlatBuffers compiler, do not modify

package slimevr_protocol.data_feed;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

public class DataFeedConfigT {
  private int minimumTimeSinceLast;
  private slimevr_protocol.data_feed.device_data.DeviceDataMaskT dataMask;
  private boolean trackers;

  public int getMinimumTimeSinceLast() { return minimumTimeSinceLast; }

  public void setMinimumTimeSinceLast(int minimumTimeSinceLast) { this.minimumTimeSinceLast = minimumTimeSinceLast; }

  public slimevr_protocol.data_feed.device_data.DeviceDataMaskT getDataMask() { return dataMask; }

  public void setDataMask(slimevr_protocol.data_feed.device_data.DeviceDataMaskT dataMask) { this.dataMask = dataMask; }

  public boolean getTrackers() { return trackers; }

  public void setTrackers(boolean trackers) { this.trackers = trackers; }


  public DataFeedConfigT() {
    this.minimumTimeSinceLast = 0;
    this.dataMask = null;
    this.trackers = false;
  }
}

