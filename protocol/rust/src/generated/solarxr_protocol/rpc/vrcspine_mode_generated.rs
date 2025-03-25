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
#[deprecated(since = "2.0.0", note = "Use associated constants instead. This will no longer be generated in 2021.")]
pub const ENUM_MIN_VRCSPINE_MODE: u8 = 0;
#[deprecated(since = "2.0.0", note = "Use associated constants instead. This will no longer be generated in 2021.")]
pub const ENUM_MAX_VRCSPINE_MODE: u8 = 3;
#[deprecated(since = "2.0.0", note = "Use associated constants instead. This will no longer be generated in 2021.")]
#[allow(non_camel_case_types)]
pub const ENUM_VALUES_VRCSPINE_MODE: [VRCSpineMode; 4] = [
  VRCSpineMode::UNKNOWN,
  VRCSpineMode::LOCK_HIP,
  VRCSpineMode::LOCK_HEAD,
  VRCSpineMode::LOCK_BOTH,
];

#[derive(Clone, Copy, PartialEq, Eq, PartialOrd, Ord, Hash, Default)]
#[repr(transparent)]
pub struct VRCSpineMode(pub u8);
#[allow(non_upper_case_globals)]
impl VRCSpineMode {
  pub const UNKNOWN: Self = Self(0);
  pub const LOCK_HIP: Self = Self(1);
  pub const LOCK_HEAD: Self = Self(2);
  pub const LOCK_BOTH: Self = Self(3);

  pub const ENUM_MIN: u8 = 0;
  pub const ENUM_MAX: u8 = 3;
  pub const ENUM_VALUES: &'static [Self] = &[
    Self::UNKNOWN,
    Self::LOCK_HIP,
    Self::LOCK_HEAD,
    Self::LOCK_BOTH,
  ];
  /// Returns the variant's name or "" if unknown.
  pub fn variant_name(self) -> Option<&'static str> {
    match self {
      Self::UNKNOWN => Some("UNKNOWN"),
      Self::LOCK_HIP => Some("LOCK_HIP"),
      Self::LOCK_HEAD => Some("LOCK_HEAD"),
      Self::LOCK_BOTH => Some("LOCK_BOTH"),
      _ => None,
    }
  }
}
impl core::fmt::Debug for VRCSpineMode {
  fn fmt(&self, f: &mut core::fmt::Formatter) -> core::fmt::Result {
    if let Some(name) = self.variant_name() {
      f.write_str(name)
    } else {
      f.write_fmt(format_args!("<UNKNOWN {:?}>", self.0))
    }
  }
}
impl<'a> flatbuffers::Follow<'a> for VRCSpineMode {
  type Inner = Self;
  #[inline]
  unsafe fn follow(buf: &'a [u8], loc: usize) -> Self::Inner {
    let b = flatbuffers::read_scalar_at::<u8>(buf, loc);
    Self(b)
  }
}

impl flatbuffers::Push for VRCSpineMode {
    type Output = VRCSpineMode;
    #[inline]
    unsafe fn push(&self, dst: &mut [u8], _written_len: usize) {
        flatbuffers::emplace_scalar::<u8>(dst, self.0);
    }
}

impl flatbuffers::EndianScalar for VRCSpineMode {
  type Scalar = u8;
  #[inline]
  fn to_little_endian(self) -> u8 {
    self.0.to_le()
  }
  #[inline]
  #[allow(clippy::wrong_self_convention)]
  fn from_little_endian(v: u8) -> Self {
    let b = u8::from_le(v);
    Self(b)
  }
}

impl<'a> flatbuffers::Verifiable for VRCSpineMode {
  #[inline]
  fn run_verifier(
    v: &mut flatbuffers::Verifier, pos: usize
  ) -> Result<(), flatbuffers::InvalidFlatbuffer> {
    use self::flatbuffers::Verifiable;
    u8::run_verifier(v, pos)
  }
}

impl flatbuffers::SimpleToVerifyInSlice for VRCSpineMode {}
