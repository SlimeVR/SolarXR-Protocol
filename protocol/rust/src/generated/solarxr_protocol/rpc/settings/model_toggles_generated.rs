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
pub enum ModelTogglesOffset {}
#[derive(Copy, Clone, PartialEq)]

/// Settings for the skeletal model that are toggles.
pub struct ModelToggles<'a> {
  pub _tab: flatbuffers::Table<'a>,
}

impl<'a> flatbuffers::Follow<'a> for ModelToggles<'a> {
  type Inner = ModelToggles<'a>;
  #[inline]
  unsafe fn follow(buf: &'a [u8], loc: usize) -> Self::Inner {
    Self { _tab: flatbuffers::Table::new(buf, loc) }
  }
}

impl<'a> ModelToggles<'a> {
  pub const VT_EXTENDED_SPINE: flatbuffers::VOffsetT = 4;
  pub const VT_EXTENDED_PELVIS: flatbuffers::VOffsetT = 6;
  pub const VT_EXTENDED_KNEE: flatbuffers::VOffsetT = 8;
  pub const VT_FORCE_ARMS_FROM_HMD: flatbuffers::VOffsetT = 10;
  pub const VT_FLOOR_CLIP: flatbuffers::VOffsetT = 12;
  pub const VT_SKATING_CORRECTION: flatbuffers::VOffsetT = 14;
  pub const VT_VIVE_EMULATION: flatbuffers::VOffsetT = 16;
  pub const VT_TOE_SNAP: flatbuffers::VOffsetT = 18;
  pub const VT_FOOT_PLANT: flatbuffers::VOffsetT = 20;
  pub const VT_SELF_LOCALIZATION: flatbuffers::VOffsetT = 22;

  #[inline]
  pub unsafe fn init_from_table(table: flatbuffers::Table<'a>) -> Self {
    ModelToggles { _tab: table }
  }
  #[allow(unused_mut)]
  pub fn create<'bldr: 'args, 'args: 'mut_bldr, 'mut_bldr>(
    _fbb: &'mut_bldr mut flatbuffers::FlatBufferBuilder<'bldr>,
    args: &'args ModelTogglesArgs
  ) -> flatbuffers::WIPOffset<ModelToggles<'bldr>> {
    let mut builder = ModelTogglesBuilder::new(_fbb);
    if let Some(x) = args.self_localization { builder.add_self_localization(x); }
    if let Some(x) = args.foot_plant { builder.add_foot_plant(x); }
    if let Some(x) = args.toe_snap { builder.add_toe_snap(x); }
    if let Some(x) = args.vive_emulation { builder.add_vive_emulation(x); }
    if let Some(x) = args.skating_correction { builder.add_skating_correction(x); }
    if let Some(x) = args.floor_clip { builder.add_floor_clip(x); }
    if let Some(x) = args.force_arms_from_hmd { builder.add_force_arms_from_hmd(x); }
    if let Some(x) = args.extended_knee { builder.add_extended_knee(x); }
    if let Some(x) = args.extended_pelvis { builder.add_extended_pelvis(x); }
    if let Some(x) = args.extended_spine { builder.add_extended_spine(x); }
    builder.finish()
  }


  #[inline]
  pub fn extended_spine(&self) -> Option<bool> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(ModelToggles::VT_EXTENDED_SPINE, None)}
  }
  #[inline]
  pub fn extended_pelvis(&self) -> Option<bool> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(ModelToggles::VT_EXTENDED_PELVIS, None)}
  }
  #[inline]
  pub fn extended_knee(&self) -> Option<bool> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(ModelToggles::VT_EXTENDED_KNEE, None)}
  }
  #[inline]
  pub fn force_arms_from_hmd(&self) -> Option<bool> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(ModelToggles::VT_FORCE_ARMS_FROM_HMD, None)}
  }
  #[inline]
  pub fn floor_clip(&self) -> Option<bool> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(ModelToggles::VT_FLOOR_CLIP, None)}
  }
  #[inline]
  pub fn skating_correction(&self) -> Option<bool> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(ModelToggles::VT_SKATING_CORRECTION, None)}
  }
  #[inline]
  pub fn vive_emulation(&self) -> Option<bool> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(ModelToggles::VT_VIVE_EMULATION, None)}
  }
  #[inline]
  pub fn toe_snap(&self) -> Option<bool> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(ModelToggles::VT_TOE_SNAP, None)}
  }
  #[inline]
  pub fn foot_plant(&self) -> Option<bool> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(ModelToggles::VT_FOOT_PLANT, None)}
  }
  #[inline]
  pub fn self_localization(&self) -> Option<bool> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(ModelToggles::VT_SELF_LOCALIZATION, None)}
  }
}

impl flatbuffers::Verifiable for ModelToggles<'_> {
  #[inline]
  fn run_verifier(
    v: &mut flatbuffers::Verifier, pos: usize
  ) -> Result<(), flatbuffers::InvalidFlatbuffer> {
    use self::flatbuffers::Verifiable;
    v.visit_table(pos)?
     .visit_field::<bool>("extended_spine", Self::VT_EXTENDED_SPINE, false)?
     .visit_field::<bool>("extended_pelvis", Self::VT_EXTENDED_PELVIS, false)?
     .visit_field::<bool>("extended_knee", Self::VT_EXTENDED_KNEE, false)?
     .visit_field::<bool>("force_arms_from_hmd", Self::VT_FORCE_ARMS_FROM_HMD, false)?
     .visit_field::<bool>("floor_clip", Self::VT_FLOOR_CLIP, false)?
     .visit_field::<bool>("skating_correction", Self::VT_SKATING_CORRECTION, false)?
     .visit_field::<bool>("vive_emulation", Self::VT_VIVE_EMULATION, false)?
     .visit_field::<bool>("toe_snap", Self::VT_TOE_SNAP, false)?
     .visit_field::<bool>("foot_plant", Self::VT_FOOT_PLANT, false)?
     .visit_field::<bool>("self_localization", Self::VT_SELF_LOCALIZATION, false)?
     .finish();
    Ok(())
  }
}
pub struct ModelTogglesArgs {
    pub extended_spine: Option<bool>,
    pub extended_pelvis: Option<bool>,
    pub extended_knee: Option<bool>,
    pub force_arms_from_hmd: Option<bool>,
    pub floor_clip: Option<bool>,
    pub skating_correction: Option<bool>,
    pub vive_emulation: Option<bool>,
    pub toe_snap: Option<bool>,
    pub foot_plant: Option<bool>,
    pub self_localization: Option<bool>,
}
impl<'a> Default for ModelTogglesArgs {
  #[inline]
  fn default() -> Self {
    ModelTogglesArgs {
      extended_spine: None,
      extended_pelvis: None,
      extended_knee: None,
      force_arms_from_hmd: None,
      floor_clip: None,
      skating_correction: None,
      vive_emulation: None,
      toe_snap: None,
      foot_plant: None,
      self_localization: None,
    }
  }
}

pub struct ModelTogglesBuilder<'a: 'b, 'b> {
  fbb_: &'b mut flatbuffers::FlatBufferBuilder<'a>,
  start_: flatbuffers::WIPOffset<flatbuffers::TableUnfinishedWIPOffset>,
}
impl<'a: 'b, 'b> ModelTogglesBuilder<'a, 'b> {
  #[inline]
  pub fn add_extended_spine(&mut self, extended_spine: bool) {
    self.fbb_.push_slot_always::<bool>(ModelToggles::VT_EXTENDED_SPINE, extended_spine);
  }
  #[inline]
  pub fn add_extended_pelvis(&mut self, extended_pelvis: bool) {
    self.fbb_.push_slot_always::<bool>(ModelToggles::VT_EXTENDED_PELVIS, extended_pelvis);
  }
  #[inline]
  pub fn add_extended_knee(&mut self, extended_knee: bool) {
    self.fbb_.push_slot_always::<bool>(ModelToggles::VT_EXTENDED_KNEE, extended_knee);
  }
  #[inline]
  pub fn add_force_arms_from_hmd(&mut self, force_arms_from_hmd: bool) {
    self.fbb_.push_slot_always::<bool>(ModelToggles::VT_FORCE_ARMS_FROM_HMD, force_arms_from_hmd);
  }
  #[inline]
  pub fn add_floor_clip(&mut self, floor_clip: bool) {
    self.fbb_.push_slot_always::<bool>(ModelToggles::VT_FLOOR_CLIP, floor_clip);
  }
  #[inline]
  pub fn add_skating_correction(&mut self, skating_correction: bool) {
    self.fbb_.push_slot_always::<bool>(ModelToggles::VT_SKATING_CORRECTION, skating_correction);
  }
  #[inline]
  pub fn add_vive_emulation(&mut self, vive_emulation: bool) {
    self.fbb_.push_slot_always::<bool>(ModelToggles::VT_VIVE_EMULATION, vive_emulation);
  }
  #[inline]
  pub fn add_toe_snap(&mut self, toe_snap: bool) {
    self.fbb_.push_slot_always::<bool>(ModelToggles::VT_TOE_SNAP, toe_snap);
  }
  #[inline]
  pub fn add_foot_plant(&mut self, foot_plant: bool) {
    self.fbb_.push_slot_always::<bool>(ModelToggles::VT_FOOT_PLANT, foot_plant);
  }
  #[inline]
  pub fn add_self_localization(&mut self, self_localization: bool) {
    self.fbb_.push_slot_always::<bool>(ModelToggles::VT_SELF_LOCALIZATION, self_localization);
  }
  #[inline]
  pub fn new(_fbb: &'b mut flatbuffers::FlatBufferBuilder<'a>) -> ModelTogglesBuilder<'a, 'b> {
    let start = _fbb.start_table();
    ModelTogglesBuilder {
      fbb_: _fbb,
      start_: start,
    }
  }
  #[inline]
  pub fn finish(self) -> flatbuffers::WIPOffset<ModelToggles<'a>> {
    let o = self.fbb_.end_table(self.start_);
    flatbuffers::WIPOffset::new(o.value())
  }
}

impl core::fmt::Debug for ModelToggles<'_> {
  fn fmt(&self, f: &mut core::fmt::Formatter<'_>) -> core::fmt::Result {
    let mut ds = f.debug_struct("ModelToggles");
      ds.field("extended_spine", &self.extended_spine());
      ds.field("extended_pelvis", &self.extended_pelvis());
      ds.field("extended_knee", &self.extended_knee());
      ds.field("force_arms_from_hmd", &self.force_arms_from_hmd());
      ds.field("floor_clip", &self.floor_clip());
      ds.field("skating_correction", &self.skating_correction());
      ds.field("vive_emulation", &self.vive_emulation());
      ds.field("toe_snap", &self.toe_snap());
      ds.field("foot_plant", &self.foot_plant());
      ds.field("self_localization", &self.self_localization());
      ds.finish()
  }
}
