// automatically generated by the FlatBuffers compiler, do not modify
extern crate flatbuffers;
use std::mem;
use std::cmp::Ordering;
use self::flatbuffers::{EndianScalar, Follow};
use super::*;
pub enum AutoBoneEpochOffset {}
#[derive(Copy, Clone, PartialEq)]

pub struct AutoBoneEpoch<'a> {
  pub _tab: flatbuffers::Table<'a>,
}

impl<'a> flatbuffers::Follow<'a> for AutoBoneEpoch<'a> {
  type Inner = AutoBoneEpoch<'a>;
  #[inline]
  fn follow(buf: &'a [u8], loc: usize) -> Self::Inner {
    Self { _tab: flatbuffers::Table { buf, loc } }
  }
}

impl<'a> AutoBoneEpoch<'a> {
  pub const VT_CURRENT_EPOCH: flatbuffers::VOffsetT = 4;
  pub const VT_TOTAL_EPOCHS: flatbuffers::VOffsetT = 6;
  pub const VT_EPOCH_ERROR: flatbuffers::VOffsetT = 8;
  pub const VT_ADJUSTED_SKELETON_PARTS: flatbuffers::VOffsetT = 10;

  #[inline]
  pub fn init_from_table(table: flatbuffers::Table<'a>) -> Self {
    AutoBoneEpoch { _tab: table }
  }
  #[allow(unused_mut)]
  pub fn create<'bldr: 'args, 'args: 'mut_bldr, 'mut_bldr>(
    _fbb: &'mut_bldr mut flatbuffers::FlatBufferBuilder<'bldr>,
    args: &'args AutoBoneEpochArgs<'args>
  ) -> flatbuffers::WIPOffset<AutoBoneEpoch<'bldr>> {
    let mut builder = AutoBoneEpochBuilder::new(_fbb);
    if let Some(x) = args.adjusted_skeleton_parts { builder.add_adjusted_skeleton_parts(x); }
    builder.add_epoch_error(args.epoch_error);
    builder.add_total_epochs(args.total_epochs);
    builder.add_current_epoch(args.current_epoch);
    builder.finish()
  }


  #[inline]
  pub fn current_epoch(&self) -> u32 {
    self._tab.get::<u32>(AutoBoneEpoch::VT_CURRENT_EPOCH, Some(0)).unwrap()
  }
  #[inline]
  pub fn total_epochs(&self) -> u32 {
    self._tab.get::<u32>(AutoBoneEpoch::VT_TOTAL_EPOCHS, Some(0)).unwrap()
  }
  #[inline]
  pub fn epoch_error(&self) -> f32 {
    self._tab.get::<f32>(AutoBoneEpoch::VT_EPOCH_ERROR, Some(0.0)).unwrap()
  }
  #[inline]
  pub fn adjusted_skeleton_parts(&self) -> Option<flatbuffers::Vector<'a, flatbuffers::ForwardsUOffset<SkeletonPart<'a>>>> {
    self._tab.get::<flatbuffers::ForwardsUOffset<flatbuffers::Vector<'a, flatbuffers::ForwardsUOffset<SkeletonPart>>>>(AutoBoneEpoch::VT_ADJUSTED_SKELETON_PARTS, None)
  }
}

impl flatbuffers::Verifiable for AutoBoneEpoch<'_> {
  #[inline]
  fn run_verifier(
    v: &mut flatbuffers::Verifier, pos: usize
  ) -> Result<(), flatbuffers::InvalidFlatbuffer> {
    use self::flatbuffers::Verifiable;
    v.visit_table(pos)?
     .visit_field::<u32>("current_epoch", Self::VT_CURRENT_EPOCH, false)?
     .visit_field::<u32>("total_epochs", Self::VT_TOTAL_EPOCHS, false)?
     .visit_field::<f32>("epoch_error", Self::VT_EPOCH_ERROR, false)?
     .visit_field::<flatbuffers::ForwardsUOffset<flatbuffers::Vector<'_, flatbuffers::ForwardsUOffset<SkeletonPart>>>>("adjusted_skeleton_parts", Self::VT_ADJUSTED_SKELETON_PARTS, false)?
     .finish();
    Ok(())
  }
}
pub struct AutoBoneEpochArgs<'a> {
    pub current_epoch: u32,
    pub total_epochs: u32,
    pub epoch_error: f32,
    pub adjusted_skeleton_parts: Option<flatbuffers::WIPOffset<flatbuffers::Vector<'a, flatbuffers::ForwardsUOffset<SkeletonPart<'a>>>>>,
}
impl<'a> Default for AutoBoneEpochArgs<'a> {
  #[inline]
  fn default() -> Self {
    AutoBoneEpochArgs {
      current_epoch: 0,
      total_epochs: 0,
      epoch_error: 0.0,
      adjusted_skeleton_parts: None,
    }
  }
}

pub struct AutoBoneEpochBuilder<'a: 'b, 'b> {
  fbb_: &'b mut flatbuffers::FlatBufferBuilder<'a>,
  start_: flatbuffers::WIPOffset<flatbuffers::TableUnfinishedWIPOffset>,
}
impl<'a: 'b, 'b> AutoBoneEpochBuilder<'a, 'b> {
  #[inline]
  pub fn add_current_epoch(&mut self, current_epoch: u32) {
    self.fbb_.push_slot::<u32>(AutoBoneEpoch::VT_CURRENT_EPOCH, current_epoch, 0);
  }
  #[inline]
  pub fn add_total_epochs(&mut self, total_epochs: u32) {
    self.fbb_.push_slot::<u32>(AutoBoneEpoch::VT_TOTAL_EPOCHS, total_epochs, 0);
  }
  #[inline]
  pub fn add_epoch_error(&mut self, epoch_error: f32) {
    self.fbb_.push_slot::<f32>(AutoBoneEpoch::VT_EPOCH_ERROR, epoch_error, 0.0);
  }
  #[inline]
  pub fn add_adjusted_skeleton_parts(&mut self, adjusted_skeleton_parts: flatbuffers::WIPOffset<flatbuffers::Vector<'b , flatbuffers::ForwardsUOffset<SkeletonPart<'b >>>>) {
    self.fbb_.push_slot_always::<flatbuffers::WIPOffset<_>>(AutoBoneEpoch::VT_ADJUSTED_SKELETON_PARTS, adjusted_skeleton_parts);
  }
  #[inline]
  pub fn new(_fbb: &'b mut flatbuffers::FlatBufferBuilder<'a>) -> AutoBoneEpochBuilder<'a, 'b> {
    let start = _fbb.start_table();
    AutoBoneEpochBuilder {
      fbb_: _fbb,
      start_: start,
    }
  }
  #[inline]
  pub fn finish(self) -> flatbuffers::WIPOffset<AutoBoneEpoch<'a>> {
    let o = self.fbb_.end_table(self.start_);
    flatbuffers::WIPOffset::new(o.value())
  }
}

impl std::fmt::Debug for AutoBoneEpoch<'_> {
  fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
    let mut ds = f.debug_struct("AutoBoneEpoch");
      ds.field("current_epoch", &self.current_epoch());
      ds.field("total_epochs", &self.total_epochs());
      ds.field("epoch_error", &self.epoch_error());
      ds.field("adjusted_skeleton_parts", &self.adjusted_skeleton_parts());
      ds.finish()
  }
}