// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.datatypes.hardware_info;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

/**
 * A MAC address or a bluetooth address, or some other uniquely identifying address
 * associated with the endpoint that we are communicating with. If it doesn't take
 * up the full set of bytes, it is aligned towards the least significant bits.
 */
@SuppressWarnings("unused")
public final class HardwareAddress extends Struct {
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public HardwareAddress __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public long addr() { return bb.getLong(bb_pos + 0); }

  public static int createHardwareAddress(FlatBufferBuilder builder, long addr) {
    builder.prep(8, 8);
    builder.putLong(addr);
    return builder.offset();
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public HardwareAddress get(int j) { return get(new HardwareAddress(), j); }
    public HardwareAddress get(HardwareAddress obj, int j) {  return obj.__assign(__element(j), bb); }
  }
  public HardwareAddressT unpack() {
    HardwareAddressT _o = new HardwareAddressT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(HardwareAddressT _o) {
    long _oAddr = addr();
    _o.setAddr(_oAddr);
  }
  public static int pack(FlatBufferBuilder builder, HardwareAddressT _o) {
    if (_o == null) return 0;
    return createHardwareAddress(
      builder,
      _o.getAddr());
  }
}

