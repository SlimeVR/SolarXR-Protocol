// automatically generated by the FlatBuffers compiler, do not modify
extern crate alloc;
extern crate flatbuffers;
use alloc::boxed::Box;
use alloc::string::{String, ToString};
use alloc::vec::Vec;
use core::mem;
use core::cmp::Ordering;
use self::flatbuffers::{EndianScalar, Follow};
use super::*;
// struct Vec3f, aligned to 4
#[repr(transparent)]
#[derive(Clone, Copy, PartialEq)]
pub struct Vec3f(pub [u8; 12]);
impl Default for Vec3f { 
  fn default() -> Self { 
    Self([0; 12])
  }
}
impl core::fmt::Debug for Vec3f {
  fn fmt(&self, f: &mut core::fmt::Formatter) -> core::fmt::Result {
    f.debug_struct("Vec3f")
      .field("x", &self.x())
      .field("y", &self.y())
      .field("z", &self.z())
      .finish()
  }
}

impl flatbuffers::SimpleToVerifyInSlice for Vec3f {}
impl flatbuffers::SafeSliceAccess for Vec3f {}
impl<'a> flatbuffers::Follow<'a> for Vec3f {
  type Inner = &'a Vec3f;
  #[inline]
  fn follow(buf: &'a [u8], loc: usize) -> Self::Inner {
    <&'a Vec3f>::follow(buf, loc)
  }
}
impl<'a> flatbuffers::Follow<'a> for &'a Vec3f {
  type Inner = &'a Vec3f;
  #[inline]
  fn follow(buf: &'a [u8], loc: usize) -> Self::Inner {
    flatbuffers::follow_cast_ref::<Vec3f>(buf, loc)
  }
}
impl<'b> flatbuffers::Push for Vec3f {
    type Output = Vec3f;
    #[inline]
    fn push(&self, dst: &mut [u8], _rest: &[u8]) {
        let src = unsafe {
            ::core::slice::from_raw_parts(self as *const Vec3f as *const u8, Self::size())
        };
        dst.copy_from_slice(src);
    }
}
impl<'b> flatbuffers::Push for &'b Vec3f {
    type Output = Vec3f;

    #[inline]
    fn push(&self, dst: &mut [u8], _rest: &[u8]) {
        let src = unsafe {
            ::core::slice::from_raw_parts(*self as *const Vec3f as *const u8, Self::size())
        };
        dst.copy_from_slice(src);
    }
}

impl<'a> flatbuffers::Verifiable for Vec3f {
  #[inline]
  fn run_verifier(
    v: &mut flatbuffers::Verifier, pos: usize
  ) -> Result<(), flatbuffers::InvalidFlatbuffer> {
    use self::flatbuffers::Verifiable;
    v.in_buffer::<Self>(pos)
  }
}

impl<'a> Vec3f {
  #[allow(clippy::too_many_arguments)]
  pub fn new(
    x: f32,
    y: f32,
    z: f32,
  ) -> Self {
    let mut s = Self([0; 12]);
    s.set_x(x);
    s.set_y(y);
    s.set_z(z);
    s
  }

  pub fn x(&self) -> f32 {
    let mut mem = core::mem::MaybeUninit::<f32>::uninit();
    unsafe {
      core::ptr::copy_nonoverlapping(
        self.0[0..].as_ptr(),
        mem.as_mut_ptr() as *mut u8,
        core::mem::size_of::<f32>(),
      );
      mem.assume_init()
    }.from_little_endian()
  }

  pub fn set_x(&mut self, x: f32) {
    let x_le = x.to_little_endian();
    unsafe {
      core::ptr::copy_nonoverlapping(
        &x_le as *const f32 as *const u8,
        self.0[0..].as_mut_ptr(),
        core::mem::size_of::<f32>(),
      );
    }
  }

  pub fn y(&self) -> f32 {
    let mut mem = core::mem::MaybeUninit::<f32>::uninit();
    unsafe {
      core::ptr::copy_nonoverlapping(
        self.0[4..].as_ptr(),
        mem.as_mut_ptr() as *mut u8,
        core::mem::size_of::<f32>(),
      );
      mem.assume_init()
    }.from_little_endian()
  }

  pub fn set_y(&mut self, x: f32) {
    let x_le = x.to_little_endian();
    unsafe {
      core::ptr::copy_nonoverlapping(
        &x_le as *const f32 as *const u8,
        self.0[4..].as_mut_ptr(),
        core::mem::size_of::<f32>(),
      );
    }
  }

  pub fn z(&self) -> f32 {
    let mut mem = core::mem::MaybeUninit::<f32>::uninit();
    unsafe {
      core::ptr::copy_nonoverlapping(
        self.0[8..].as_ptr(),
        mem.as_mut_ptr() as *mut u8,
        core::mem::size_of::<f32>(),
      );
      mem.assume_init()
    }.from_little_endian()
  }

  pub fn set_z(&mut self, x: f32) {
    let x_le = x.to_little_endian();
    unsafe {
      core::ptr::copy_nonoverlapping(
        &x_le as *const f32 as *const u8,
        self.0[8..].as_mut_ptr(),
        core::mem::size_of::<f32>(),
      );
    }
  }

}

