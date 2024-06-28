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
pub enum OSCTrackersSettingOffset {}
#[derive(Copy, Clone, PartialEq)]

pub struct OSCTrackersSetting<'a> {
  pub _tab: flatbuffers::Table<'a>,
}

impl<'a> flatbuffers::Follow<'a> for OSCTrackersSetting<'a> {
  type Inner = OSCTrackersSetting<'a>;
  #[inline]
  unsafe fn follow(buf: &'a [u8], loc: usize) -> Self::Inner {
    Self { _tab: flatbuffers::Table::new(buf, loc) }
  }
}

impl<'a> OSCTrackersSetting<'a> {
  pub const VT_HEAD: flatbuffers::VOffsetT = 4;
  pub const VT_CHEST: flatbuffers::VOffsetT = 6;
  pub const VT_WAIST: flatbuffers::VOffsetT = 8;
  pub const VT_KNEES: flatbuffers::VOffsetT = 10;
  pub const VT_FEET: flatbuffers::VOffsetT = 12;
  pub const VT_ELBOWS: flatbuffers::VOffsetT = 14;
  pub const VT_HANDS: flatbuffers::VOffsetT = 16;

  #[inline]
  pub unsafe fn init_from_table(table: flatbuffers::Table<'a>) -> Self {
    OSCTrackersSetting { _tab: table }
  }
  #[allow(unused_mut)]
  pub fn create<'bldr: 'args, 'args: 'mut_bldr, 'mut_bldr>(
    _fbb: &'mut_bldr mut flatbuffers::FlatBufferBuilder<'bldr>,
    args: &'args OSCTrackersSettingArgs
  ) -> flatbuffers::WIPOffset<OSCTrackersSetting<'bldr>> {
    let mut builder = OSCTrackersSettingBuilder::new(_fbb);
    builder.add_hands(args.hands);
    builder.add_elbows(args.elbows);
    builder.add_feet(args.feet);
    builder.add_knees(args.knees);
    builder.add_waist(args.waist);
    builder.add_chest(args.chest);
    builder.add_head(args.head);
    builder.finish()
  }


  #[inline]
  pub fn head(&self) -> bool {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(OSCTrackersSetting::VT_HEAD, Some(false)).unwrap()}
  }
  #[inline]
  pub fn chest(&self) -> bool {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(OSCTrackersSetting::VT_CHEST, Some(false)).unwrap()}
  }
  #[inline]
  pub fn waist(&self) -> bool {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(OSCTrackersSetting::VT_WAIST, Some(false)).unwrap()}
  }
  #[inline]
  pub fn knees(&self) -> bool {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(OSCTrackersSetting::VT_KNEES, Some(false)).unwrap()}
  }
  #[inline]
  pub fn feet(&self) -> bool {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(OSCTrackersSetting::VT_FEET, Some(false)).unwrap()}
  }
  #[inline]
  pub fn elbows(&self) -> bool {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(OSCTrackersSetting::VT_ELBOWS, Some(false)).unwrap()}
  }
  #[inline]
  pub fn hands(&self) -> bool {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(OSCTrackersSetting::VT_HANDS, Some(false)).unwrap()}
  }
}

impl flatbuffers::Verifiable for OSCTrackersSetting<'_> {
  #[inline]
  fn run_verifier(
    v: &mut flatbuffers::Verifier, pos: usize
  ) -> Result<(), flatbuffers::InvalidFlatbuffer> {
    use self::flatbuffers::Verifiable;
    v.visit_table(pos)?
     .visit_field::<bool>("head", Self::VT_HEAD, false)?
     .visit_field::<bool>("chest", Self::VT_CHEST, false)?
     .visit_field::<bool>("waist", Self::VT_WAIST, false)?
     .visit_field::<bool>("knees", Self::VT_KNEES, false)?
     .visit_field::<bool>("feet", Self::VT_FEET, false)?
     .visit_field::<bool>("elbows", Self::VT_ELBOWS, false)?
     .visit_field::<bool>("hands", Self::VT_HANDS, false)?
     .finish();
    Ok(())
  }
}
pub struct OSCTrackersSettingArgs {
    pub head: bool,
    pub chest: bool,
    pub waist: bool,
    pub knees: bool,
    pub feet: bool,
    pub elbows: bool,
    pub hands: bool,
}
impl<'a> Default for OSCTrackersSettingArgs {
  #[inline]
  fn default() -> Self {
    OSCTrackersSettingArgs {
      head: false,
      chest: false,
      waist: false,
      knees: false,
      feet: false,
      elbows: false,
      hands: false,
    }
  }
}

pub struct OSCTrackersSettingBuilder<'a: 'b, 'b> {
  fbb_: &'b mut flatbuffers::FlatBufferBuilder<'a>,
  start_: flatbuffers::WIPOffset<flatbuffers::TableUnfinishedWIPOffset>,
}
impl<'a: 'b, 'b> OSCTrackersSettingBuilder<'a, 'b> {
  #[inline]
  pub fn add_head(&mut self, head: bool) {
    self.fbb_.push_slot::<bool>(OSCTrackersSetting::VT_HEAD, head, false);
  }
  #[inline]
  pub fn add_chest(&mut self, chest: bool) {
    self.fbb_.push_slot::<bool>(OSCTrackersSetting::VT_CHEST, chest, false);
  }
  #[inline]
  pub fn add_waist(&mut self, waist: bool) {
    self.fbb_.push_slot::<bool>(OSCTrackersSetting::VT_WAIST, waist, false);
  }
  #[inline]
  pub fn add_knees(&mut self, knees: bool) {
    self.fbb_.push_slot::<bool>(OSCTrackersSetting::VT_KNEES, knees, false);
  }
  #[inline]
  pub fn add_feet(&mut self, feet: bool) {
    self.fbb_.push_slot::<bool>(OSCTrackersSetting::VT_FEET, feet, false);
  }
  #[inline]
  pub fn add_elbows(&mut self, elbows: bool) {
    self.fbb_.push_slot::<bool>(OSCTrackersSetting::VT_ELBOWS, elbows, false);
  }
  #[inline]
  pub fn add_hands(&mut self, hands: bool) {
    self.fbb_.push_slot::<bool>(OSCTrackersSetting::VT_HANDS, hands, false);
  }
  #[inline]
  pub fn new(_fbb: &'b mut flatbuffers::FlatBufferBuilder<'a>) -> OSCTrackersSettingBuilder<'a, 'b> {
    let start = _fbb.start_table();
    OSCTrackersSettingBuilder {
      fbb_: _fbb,
      start_: start,
    }
  }
  #[inline]
  pub fn finish(self) -> flatbuffers::WIPOffset<OSCTrackersSetting<'a>> {
    let o = self.fbb_.end_table(self.start_);
    flatbuffers::WIPOffset::new(o.value())
  }
}

impl core::fmt::Debug for OSCTrackersSetting<'_> {
  fn fmt(&self, f: &mut core::fmt::Formatter<'_>) -> core::fmt::Result {
    let mut ds = f.debug_struct("OSCTrackersSetting");
      ds.field("head", &self.head());
      ds.field("chest", &self.chest());
      ds.field("waist", &self.waist());
      ds.field("knees", &self.knees());
      ds.field("feet", &self.feet());
      ds.field("elbows", &self.elbows());
      ds.field("hands", &self.hands());
      ds.finish()
  }
}
