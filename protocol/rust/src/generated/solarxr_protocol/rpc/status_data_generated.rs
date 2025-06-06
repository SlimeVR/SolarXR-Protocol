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
pub const ENUM_MIN_STATUS_DATA: u8 = 0;
#[deprecated(since = "2.0.0", note = "Use associated constants instead. This will no longer be generated in 2021.")]
pub const ENUM_MAX_STATUS_DATA: u8 = 5;
#[deprecated(since = "2.0.0", note = "Use associated constants instead. This will no longer be generated in 2021.")]
#[allow(non_camel_case_types)]
pub const ENUM_VALUES_STATUS_DATA: [StatusData; 6] = [
  StatusData::NONE,
  StatusData::StatusTrackerReset,
  StatusData::StatusTrackerError,
  StatusData::StatusSteamVRDisconnected,
  StatusData::StatusUnassignedHMD,
  StatusData::StatusPublicNetwork,
];

#[derive(Clone, Copy, PartialEq, Eq, PartialOrd, Ord, Hash, Default)]
#[repr(transparent)]
pub struct StatusData(pub u8);
#[allow(non_upper_case_globals)]
impl StatusData {
  pub const NONE: Self = Self(0);
  pub const StatusTrackerReset: Self = Self(1);
  pub const StatusTrackerError: Self = Self(2);
  pub const StatusSteamVRDisconnected: Self = Self(3);
  pub const StatusUnassignedHMD: Self = Self(4);
  pub const StatusPublicNetwork: Self = Self(5);

  pub const ENUM_MIN: u8 = 0;
  pub const ENUM_MAX: u8 = 5;
  pub const ENUM_VALUES: &'static [Self] = &[
    Self::NONE,
    Self::StatusTrackerReset,
    Self::StatusTrackerError,
    Self::StatusSteamVRDisconnected,
    Self::StatusUnassignedHMD,
    Self::StatusPublicNetwork,
  ];
  /// Returns the variant's name or "" if unknown.
  pub fn variant_name(self) -> Option<&'static str> {
    match self {
      Self::NONE => Some("NONE"),
      Self::StatusTrackerReset => Some("StatusTrackerReset"),
      Self::StatusTrackerError => Some("StatusTrackerError"),
      Self::StatusSteamVRDisconnected => Some("StatusSteamVRDisconnected"),
      Self::StatusUnassignedHMD => Some("StatusUnassignedHMD"),
      Self::StatusPublicNetwork => Some("StatusPublicNetwork"),
      _ => None,
    }
  }
}
impl core::fmt::Debug for StatusData {
  fn fmt(&self, f: &mut core::fmt::Formatter) -> core::fmt::Result {
    if let Some(name) = self.variant_name() {
      f.write_str(name)
    } else {
      f.write_fmt(format_args!("<UNKNOWN {:?}>", self.0))
    }
  }
}
impl<'a> flatbuffers::Follow<'a> for StatusData {
  type Inner = Self;
  #[inline]
  unsafe fn follow(buf: &'a [u8], loc: usize) -> Self::Inner {
    let b = flatbuffers::read_scalar_at::<u8>(buf, loc);
    Self(b)
  }
}

impl flatbuffers::Push for StatusData {
    type Output = StatusData;
    #[inline]
    unsafe fn push(&self, dst: &mut [u8], _written_len: usize) {
        flatbuffers::emplace_scalar::<u8>(dst, self.0);
    }
}

impl flatbuffers::EndianScalar for StatusData {
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

impl<'a> flatbuffers::Verifiable for StatusData {
  #[inline]
  fn run_verifier(
    v: &mut flatbuffers::Verifier, pos: usize
  ) -> Result<(), flatbuffers::InvalidFlatbuffer> {
    use self::flatbuffers::Verifiable;
    u8::run_verifier(v, pos)
  }
}

impl flatbuffers::SimpleToVerifyInSlice for StatusData {}
pub struct StatusDataUnionTableOffset {}

