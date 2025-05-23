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
pub enum VRCConfigValidityOffset {}
#[derive(Copy, Clone, PartialEq)]

pub struct VRCConfigValidity<'a> {
  pub _tab: flatbuffers::Table<'a>,
}

impl<'a> flatbuffers::Follow<'a> for VRCConfigValidity<'a> {
  type Inner = VRCConfigValidity<'a>;
  #[inline]
  unsafe fn follow(buf: &'a [u8], loc: usize) -> Self::Inner {
    Self { _tab: flatbuffers::Table::new(buf, loc) }
  }
}

impl<'a> VRCConfigValidity<'a> {
  pub const VT_LEGACY_MODE_OK: flatbuffers::VOffsetT = 4;
  pub const VT_SHOULDER_TRACKING_OK: flatbuffers::VOffsetT = 6;
  pub const VT_USER_HEIGHT_OK: flatbuffers::VOffsetT = 8;
  pub const VT_CALIBRATION_RANGE_OK: flatbuffers::VOffsetT = 10;
  pub const VT_CALIBRATION_VISUALS_OK: flatbuffers::VOffsetT = 12;
  pub const VT_TRACKER_MODEL_OK: flatbuffers::VOffsetT = 14;
  pub const VT_SPINE_MODE_OK: flatbuffers::VOffsetT = 16;
  pub const VT_AVATAR_MEASUREMENT_TYPE_OK: flatbuffers::VOffsetT = 18;
  pub const VT_SHOULDER_WIDTH_COMPENSATION_OK: flatbuffers::VOffsetT = 20;

  #[inline]
  pub unsafe fn init_from_table(table: flatbuffers::Table<'a>) -> Self {
    VRCConfigValidity { _tab: table }
  }
  #[allow(unused_mut)]
  pub fn create<'bldr: 'args, 'args: 'mut_bldr, 'mut_bldr>(
    _fbb: &'mut_bldr mut flatbuffers::FlatBufferBuilder<'bldr>,
    args: &'args VRCConfigValidityArgs
  ) -> flatbuffers::WIPOffset<VRCConfigValidity<'bldr>> {
    let mut builder = VRCConfigValidityBuilder::new(_fbb);
    builder.add_shoulder_width_compensation_ok(args.shoulder_width_compensation_ok);
    builder.add_avatar_measurement_type_ok(args.avatar_measurement_type_ok);
    builder.add_spine_mode_ok(args.spine_mode_ok);
    builder.add_tracker_model_ok(args.tracker_model_ok);
    builder.add_calibration_visuals_ok(args.calibration_visuals_ok);
    builder.add_calibration_range_ok(args.calibration_range_ok);
    builder.add_user_height_ok(args.user_height_ok);
    builder.add_shoulder_tracking_ok(args.shoulder_tracking_ok);
    builder.add_legacy_mode_ok(args.legacy_mode_ok);
    builder.finish()
  }


  #[inline]
  pub fn legacy_mode_ok(&self) -> bool {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(VRCConfigValidity::VT_LEGACY_MODE_OK, Some(false)).unwrap()}
  }
  #[inline]
  pub fn shoulder_tracking_ok(&self) -> bool {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(VRCConfigValidity::VT_SHOULDER_TRACKING_OK, Some(false)).unwrap()}
  }
  #[inline]
  pub fn user_height_ok(&self) -> bool {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(VRCConfigValidity::VT_USER_HEIGHT_OK, Some(false)).unwrap()}
  }
  #[inline]
  pub fn calibration_range_ok(&self) -> bool {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(VRCConfigValidity::VT_CALIBRATION_RANGE_OK, Some(false)).unwrap()}
  }
  #[inline]
  pub fn calibration_visuals_ok(&self) -> bool {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(VRCConfigValidity::VT_CALIBRATION_VISUALS_OK, Some(false)).unwrap()}
  }
  #[inline]
  pub fn tracker_model_ok(&self) -> bool {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(VRCConfigValidity::VT_TRACKER_MODEL_OK, Some(false)).unwrap()}
  }
  #[inline]
  pub fn spine_mode_ok(&self) -> bool {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(VRCConfigValidity::VT_SPINE_MODE_OK, Some(false)).unwrap()}
  }
  #[inline]
  pub fn avatar_measurement_type_ok(&self) -> bool {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(VRCConfigValidity::VT_AVATAR_MEASUREMENT_TYPE_OK, Some(false)).unwrap()}
  }
  #[inline]
  pub fn shoulder_width_compensation_ok(&self) -> bool {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(VRCConfigValidity::VT_SHOULDER_WIDTH_COMPENSATION_OK, Some(false)).unwrap()}
  }
}

impl flatbuffers::Verifiable for VRCConfigValidity<'_> {
  #[inline]
  fn run_verifier(
    v: &mut flatbuffers::Verifier, pos: usize
  ) -> Result<(), flatbuffers::InvalidFlatbuffer> {
    use self::flatbuffers::Verifiable;
    v.visit_table(pos)?
     .visit_field::<bool>("legacy_mode_ok", Self::VT_LEGACY_MODE_OK, false)?
     .visit_field::<bool>("shoulder_tracking_ok", Self::VT_SHOULDER_TRACKING_OK, false)?
     .visit_field::<bool>("user_height_ok", Self::VT_USER_HEIGHT_OK, false)?
     .visit_field::<bool>("calibration_range_ok", Self::VT_CALIBRATION_RANGE_OK, false)?
     .visit_field::<bool>("calibration_visuals_ok", Self::VT_CALIBRATION_VISUALS_OK, false)?
     .visit_field::<bool>("tracker_model_ok", Self::VT_TRACKER_MODEL_OK, false)?
     .visit_field::<bool>("spine_mode_ok", Self::VT_SPINE_MODE_OK, false)?
     .visit_field::<bool>("avatar_measurement_type_ok", Self::VT_AVATAR_MEASUREMENT_TYPE_OK, false)?
     .visit_field::<bool>("shoulder_width_compensation_ok", Self::VT_SHOULDER_WIDTH_COMPENSATION_OK, false)?
     .finish();
    Ok(())
  }
}
pub struct VRCConfigValidityArgs {
    pub legacy_mode_ok: bool,
    pub shoulder_tracking_ok: bool,
    pub user_height_ok: bool,
    pub calibration_range_ok: bool,
    pub calibration_visuals_ok: bool,
    pub tracker_model_ok: bool,
    pub spine_mode_ok: bool,
    pub avatar_measurement_type_ok: bool,
    pub shoulder_width_compensation_ok: bool,
}
impl<'a> Default for VRCConfigValidityArgs {
  #[inline]
  fn default() -> Self {
    VRCConfigValidityArgs {
      legacy_mode_ok: false,
      shoulder_tracking_ok: false,
      user_height_ok: false,
      calibration_range_ok: false,
      calibration_visuals_ok: false,
      tracker_model_ok: false,
      spine_mode_ok: false,
      avatar_measurement_type_ok: false,
      shoulder_width_compensation_ok: false,
    }
  }
}

pub struct VRCConfigValidityBuilder<'a: 'b, 'b> {
  fbb_: &'b mut flatbuffers::FlatBufferBuilder<'a>,
  start_: flatbuffers::WIPOffset<flatbuffers::TableUnfinishedWIPOffset>,
}
impl<'a: 'b, 'b> VRCConfigValidityBuilder<'a, 'b> {
  #[inline]
  pub fn add_legacy_mode_ok(&mut self, legacy_mode_ok: bool) {
    self.fbb_.push_slot::<bool>(VRCConfigValidity::VT_LEGACY_MODE_OK, legacy_mode_ok, false);
  }
  #[inline]
  pub fn add_shoulder_tracking_ok(&mut self, shoulder_tracking_ok: bool) {
    self.fbb_.push_slot::<bool>(VRCConfigValidity::VT_SHOULDER_TRACKING_OK, shoulder_tracking_ok, false);
  }
  #[inline]
  pub fn add_user_height_ok(&mut self, user_height_ok: bool) {
    self.fbb_.push_slot::<bool>(VRCConfigValidity::VT_USER_HEIGHT_OK, user_height_ok, false);
  }
  #[inline]
  pub fn add_calibration_range_ok(&mut self, calibration_range_ok: bool) {
    self.fbb_.push_slot::<bool>(VRCConfigValidity::VT_CALIBRATION_RANGE_OK, calibration_range_ok, false);
  }
  #[inline]
  pub fn add_calibration_visuals_ok(&mut self, calibration_visuals_ok: bool) {
    self.fbb_.push_slot::<bool>(VRCConfigValidity::VT_CALIBRATION_VISUALS_OK, calibration_visuals_ok, false);
  }
  #[inline]
  pub fn add_tracker_model_ok(&mut self, tracker_model_ok: bool) {
    self.fbb_.push_slot::<bool>(VRCConfigValidity::VT_TRACKER_MODEL_OK, tracker_model_ok, false);
  }
  #[inline]
  pub fn add_spine_mode_ok(&mut self, spine_mode_ok: bool) {
    self.fbb_.push_slot::<bool>(VRCConfigValidity::VT_SPINE_MODE_OK, spine_mode_ok, false);
  }
  #[inline]
  pub fn add_avatar_measurement_type_ok(&mut self, avatar_measurement_type_ok: bool) {
    self.fbb_.push_slot::<bool>(VRCConfigValidity::VT_AVATAR_MEASUREMENT_TYPE_OK, avatar_measurement_type_ok, false);
  }
  #[inline]
  pub fn add_shoulder_width_compensation_ok(&mut self, shoulder_width_compensation_ok: bool) {
    self.fbb_.push_slot::<bool>(VRCConfigValidity::VT_SHOULDER_WIDTH_COMPENSATION_OK, shoulder_width_compensation_ok, false);
  }
  #[inline]
  pub fn new(_fbb: &'b mut flatbuffers::FlatBufferBuilder<'a>) -> VRCConfigValidityBuilder<'a, 'b> {
    let start = _fbb.start_table();
    VRCConfigValidityBuilder {
      fbb_: _fbb,
      start_: start,
    }
  }
  #[inline]
  pub fn finish(self) -> flatbuffers::WIPOffset<VRCConfigValidity<'a>> {
    let o = self.fbb_.end_table(self.start_);
    flatbuffers::WIPOffset::new(o.value())
  }
}

impl core::fmt::Debug for VRCConfigValidity<'_> {
  fn fmt(&self, f: &mut core::fmt::Formatter<'_>) -> core::fmt::Result {
    let mut ds = f.debug_struct("VRCConfigValidity");
      ds.field("legacy_mode_ok", &self.legacy_mode_ok());
      ds.field("shoulder_tracking_ok", &self.shoulder_tracking_ok());
      ds.field("user_height_ok", &self.user_height_ok());
      ds.field("calibration_range_ok", &self.calibration_range_ok());
      ds.field("calibration_visuals_ok", &self.calibration_visuals_ok());
      ds.field("tracker_model_ok", &self.tracker_model_ok());
      ds.field("spine_mode_ok", &self.spine_mode_ok());
      ds.field("avatar_measurement_type_ok", &self.avatar_measurement_type_ok());
      ds.field("shoulder_width_compensation_ok", &self.shoulder_width_compensation_ok());
      ds.finish()
  }
}
