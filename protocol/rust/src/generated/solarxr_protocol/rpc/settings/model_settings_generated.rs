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
pub enum ModelSettingsOffset {}
#[derive(Copy, Clone, PartialEq)]

/// Settings for the skeletal model.
pub struct ModelSettings<'a> {
  pub _tab: flatbuffers::Table<'a>,
}

impl<'a> flatbuffers::Follow<'a> for ModelSettings<'a> {
  type Inner = ModelSettings<'a>;
  #[inline]
  fn follow(buf: &'a [u8], loc: usize) -> Self::Inner {
    Self { _tab: flatbuffers::Table { buf, loc } }
  }
}

impl<'a> ModelSettings<'a> {
  pub const VT_TOGGLES: flatbuffers::VOffsetT = 4;
  pub const VT_RATIOS: flatbuffers::VOffsetT = 6;

  #[inline]
  pub fn init_from_table(table: flatbuffers::Table<'a>) -> Self {
    ModelSettings { _tab: table }
  }
  #[allow(unused_mut)]
  pub fn create<'bldr: 'args, 'args: 'mut_bldr, 'mut_bldr>(
    _fbb: &'mut_bldr mut flatbuffers::FlatBufferBuilder<'bldr>,
    args: &'args ModelSettingsArgs<'args>
  ) -> flatbuffers::WIPOffset<ModelSettings<'bldr>> {
    let mut builder = ModelSettingsBuilder::new(_fbb);
    if let Some(x) = args.ratios { builder.add_ratios(x); }
    if let Some(x) = args.toggles { builder.add_toggles(x); }
    builder.finish()
  }


  #[inline]
  pub fn toggles(&self) -> Option<ModelToggles<'a>> {
    self._tab.get::<flatbuffers::ForwardsUOffset<ModelToggles>>(ModelSettings::VT_TOGGLES, None)
  }
  #[inline]
  pub fn ratios(&self) -> Option<ModelRatios<'a>> {
    self._tab.get::<flatbuffers::ForwardsUOffset<ModelRatios>>(ModelSettings::VT_RATIOS, None)
  }
}

impl flatbuffers::Verifiable for ModelSettings<'_> {
  #[inline]
  fn run_verifier(
    v: &mut flatbuffers::Verifier, pos: usize
  ) -> Result<(), flatbuffers::InvalidFlatbuffer> {
    use self::flatbuffers::Verifiable;
    v.visit_table(pos)?
     .visit_field::<flatbuffers::ForwardsUOffset<ModelToggles>>("toggles", Self::VT_TOGGLES, false)?
     .visit_field::<flatbuffers::ForwardsUOffset<ModelRatios>>("ratios", Self::VT_RATIOS, false)?
     .finish();
    Ok(())
  }
}
pub struct ModelSettingsArgs<'a> {
    pub toggles: Option<flatbuffers::WIPOffset<ModelToggles<'a>>>,
    pub ratios: Option<flatbuffers::WIPOffset<ModelRatios<'a>>>,
}
impl<'a> Default for ModelSettingsArgs<'a> {
  #[inline]
  fn default() -> Self {
    ModelSettingsArgs {
      toggles: None,
      ratios: None,
    }
  }
}

pub struct ModelSettingsBuilder<'a: 'b, 'b> {
  fbb_: &'b mut flatbuffers::FlatBufferBuilder<'a>,
  start_: flatbuffers::WIPOffset<flatbuffers::TableUnfinishedWIPOffset>,
}
impl<'a: 'b, 'b> ModelSettingsBuilder<'a, 'b> {
  #[inline]
  pub fn add_toggles(&mut self, toggles: flatbuffers::WIPOffset<ModelToggles<'b >>) {
    self.fbb_.push_slot_always::<flatbuffers::WIPOffset<ModelToggles>>(ModelSettings::VT_TOGGLES, toggles);
  }
  #[inline]
  pub fn add_ratios(&mut self, ratios: flatbuffers::WIPOffset<ModelRatios<'b >>) {
    self.fbb_.push_slot_always::<flatbuffers::WIPOffset<ModelRatios>>(ModelSettings::VT_RATIOS, ratios);
  }
  #[inline]
  pub fn new(_fbb: &'b mut flatbuffers::FlatBufferBuilder<'a>) -> ModelSettingsBuilder<'a, 'b> {
    let start = _fbb.start_table();
    ModelSettingsBuilder {
      fbb_: _fbb,
      start_: start,
    }
  }
  #[inline]
  pub fn finish(self) -> flatbuffers::WIPOffset<ModelSettings<'a>> {
    let o = self.fbb_.end_table(self.start_);
    flatbuffers::WIPOffset::new(o.value())
  }
}

impl core::fmt::Debug for ModelSettings<'_> {
  fn fmt(&self, f: &mut core::fmt::Formatter<'_>) -> core::fmt::Result {
    let mut ds = f.debug_struct("ModelSettings");
      ds.field("toggles", &self.toggles());
      ds.field("ratios", &self.ratios());
      ds.finish()
  }
}
