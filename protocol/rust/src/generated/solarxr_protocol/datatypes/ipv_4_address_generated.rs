// automatically generated by the FlatBuffers compiler, do not modify
// @generated
extern crate alloc;
extern crate flatbuffers;
use alloc::boxed::Box;
use alloc::string::{String, ToString};
use alloc::vec::Vec;
use core::mem;
use core::cmp::Ordering;
use self::flatbuffers::{EndianScalar, Follow};
use super::*;
/// The 4 bytes of an ip address are stored in 32 bits in big endian order.
/// We will switch over to fixed size arrays when they are supported better.
// struct Ipv4Address, aligned to 4
#[repr(transparent)]
#[derive(Clone, Copy, PartialEq)]
pub struct Ipv4Address(pub [u8; 4]);
impl Default for Ipv4Address { 
  fn default() -> Self { 
    Self([0; 4])
  }
}
impl core::fmt::Debug for Ipv4Address {
  fn fmt(&self, f: &mut core::fmt::Formatter) -> core::fmt::Result {
    f.debug_struct("Ipv4Address")
      .field("addr", &self.addr())
      .finish()
  }
}

impl flatbuffers::SimpleToVerifyInSlice for Ipv4Address {}
impl<'a> flatbuffers::Follow<'a> for Ipv4Address {
  type Inner = &'a Ipv4Address;
  #[inline]
  unsafe fn follow(buf: &'a [u8], loc: usize) -> Self::Inner {
    <&'a Ipv4Address>::follow(buf, loc)
  }
}
impl<'a> flatbuffers::Follow<'a> for &'a Ipv4Address {
  type Inner = &'a Ipv4Address;
  #[inline]
  unsafe fn follow(buf: &'a [u8], loc: usize) -> Self::Inner {
    flatbuffers::follow_cast_ref::<Ipv4Address>(buf, loc)
  }
}
impl<'b> flatbuffers::Push for Ipv4Address {
    type Output = Ipv4Address;
    #[inline]
    unsafe fn push(&self, dst: &mut [u8], _written_len: usize) {
        let src = ::core::slice::from_raw_parts(self as *const Ipv4Address as *const u8, Self::size());
        dst.copy_from_slice(src);
    }
}

impl<'a> flatbuffers::Verifiable for Ipv4Address {
  #[inline]
  fn run_verifier(
    v: &mut flatbuffers::Verifier, pos: usize
  ) -> Result<(), flatbuffers::InvalidFlatbuffer> {
    use self::flatbuffers::Verifiable;
    v.in_buffer::<Self>(pos)
  }
}

impl<'a> Ipv4Address {
  #[allow(clippy::too_many_arguments)]
  pub fn new(
    addr: u32,
  ) -> Self {
    let mut s = Self([0; 4]);
    s.set_addr(addr);
    s
  }

  pub fn addr(&self) -> u32 {
    let mut mem = core::mem::MaybeUninit::<<u32 as EndianScalar>::Scalar>::uninit();
    // Safety:
    // Created from a valid Table for this object
    // Which contains a valid value in this slot
    EndianScalar::from_little_endian(unsafe {
      core::ptr::copy_nonoverlapping(
        self.0[0..].as_ptr(),
        mem.as_mut_ptr() as *mut u8,
        core::mem::size_of::<<u32 as EndianScalar>::Scalar>(),
      );
      mem.assume_init()
    })
  }

  pub fn set_addr(&mut self, x: u32) {
    let x_le = x.to_little_endian();
    // Safety:
    // Created from a valid Table for this object
    // Which contains a valid value in this slot
    unsafe {
      core::ptr::copy_nonoverlapping(
        &x_le as *const _ as *const u8,
        self.0[0..].as_mut_ptr(),
        core::mem::size_of::<<u32 as EndianScalar>::Scalar>(),
      );
    }
  }

}

