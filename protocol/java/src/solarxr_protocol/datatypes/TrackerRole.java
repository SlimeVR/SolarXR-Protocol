// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.datatypes;

/**
 * Possible tracker roles
 * They're not perfect match for SteamVR tracker roles,
 * because we support more possible roles. Host can
 * chose how to map it to their supported role.
 */
@SuppressWarnings("unused")
public final class TrackerRole {
  private TrackerRole() { }
  public static final int NONE = 0;
  public static final int WAIST = 1;
  public static final int LEFT_FOOT = 2;
  public static final int RIGHT_FOOT = 3;
  public static final int CHEST = 4;
  public static final int LEFT_KNEE = 5;
  public static final int RIGHT_KNEE = 6;
  public static final int LEFT_ELBOW = 7;
  public static final int RIGHT_ELBOW = 8;
  public static final int LEFT_SHOULDER = 9;
  public static final int RIGHT_SHOULDER = 10;
  public static final int LEFT_HAND = 11;
  public static final int RIGHT_HAND = 12;
  public static final int LEFT_CONTROLLER = 13;
  public static final int RIGHT_CONTROLLER = 14;
  public static final int HEAD = 15;
  public static final int NECK = 16;
  public static final int CAMERA = 17;
  public static final int KEYBOARD = 18;
  public static final int HMD = 19;
  public static final int BEACON = 20;
  public static final int GENERIC_CONTROLLER = 21;

  public static final String[] names = { "NONE", "WAIST", "LEFT_FOOT", "RIGHT_FOOT", "CHEST", "LEFT_KNEE", "RIGHT_KNEE", "LEFT_ELBOW", "RIGHT_ELBOW", "LEFT_SHOULDER", "RIGHT_SHOULDER", "LEFT_HAND", "RIGHT_HAND", "LEFT_CONTROLLER", "RIGHT_CONTROLLER", "HEAD", "NECK", "CAMERA", "KEYBOARD", "HMD", "BEACON", "GENERIC_CONTROLLER", };

  public static String name(int e) { return names[e]; }
}

