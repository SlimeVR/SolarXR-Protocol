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
pub enum SettingsResponseOffset {}
#[derive(Copy, Clone, PartialEq)]

pub struct SettingsResponse<'a> {
  pub _tab: flatbuffers::Table<'a>,
}

impl<'a> flatbuffers::Follow<'a> for SettingsResponse<'a> {
  type Inner = SettingsResponse<'a>;
  #[inline]
  fn follow(buf: &'a [u8], loc: usize) -> Self::Inner {
    Self { _tab: flatbuffers::Table { buf, loc } }
  }
}

impl<'a> SettingsResponse<'a> {
  pub const VT_STEAM_VR_TRACKERS: flatbuffers::VOffsetT = 4;
  pub const VT_FILTERING: flatbuffers::VOffsetT = 6;
  pub const VT_OSC: flatbuffers::VOffsetT = 8;
  pub const VT_MODEL_SETTINGS: flatbuffers::VOffsetT = 10;

  #[inline]
  pub fn init_from_table(table: flatbuffers::Table<'a>) -> Self {
    SettingsResponse { _tab: table }
  }
  #[allow(unused_mut)]
  pub fn create<'bldr: 'args, 'args: 'mut_bldr, 'mut_bldr>(
    _fbb: &'mut_bldr mut flatbuffers::FlatBufferBuilder<'bldr>,
    args: &'args SettingsResponseArgs<'args>
  ) -> flatbuffers::WIPOffset<SettingsResponse<'bldr>> {
    let mut builder = SettingsResponseBuilder::new(_fbb);
    if let Some(x) = args.model_settings { builder.add_model_settings(x); }
    if let Some(x) = args.osc { builder.add_osc(x); }
    if let Some(x) = args.filtering { builder.add_filtering(x); }
    if let Some(x) = args.steam_vr_trackers { builder.add_steam_vr_trackers(x); }
    builder.finish()
  }


  #[inline]
  pub fn steam_vr_trackers(&self) -> Option<SteamVRTrackersSetting<'a>> {
    self._tab.get::<flatbuffers::ForwardsUOffset<SteamVRTrackersSetting>>(SettingsResponse::VT_STEAM_VR_TRACKERS, None)
  }
  #[inline]
  pub fn filtering(&self) -> Option<FilteringSettings<'a>> {
    self._tab.get::<flatbuffers::ForwardsUOffset<FilteringSettings>>(SettingsResponse::VT_FILTERING, None)
  }
  #[inline]
  pub fn osc(&self) -> Option<OSCSettings<'a>> {
    self._tab.get::<flatbuffers::ForwardsUOffset<OSCSettings>>(SettingsResponse::VT_OSC, None)
  }
  #[inline]
  pub fn model_settings(&self) -> Option<settings::ModelSettings<'a>> {
    self._tab.get::<flatbuffers::ForwardsUOffset<settings::ModelSettings>>(SettingsResponse::VT_MODEL_SETTINGS, None)
  }
}

impl flatbuffers::Verifiable for SettingsResponse<'_> {
  #[inline]
  fn run_verifier(
    v: &mut flatbuffers::Verifier, pos: usize
  ) -> Result<(), flatbuffers::InvalidFlatbuffer> {
    use self::flatbuffers::Verifiable;
    v.visit_table(pos)?
     .visit_field::<flatbuffers::ForwardsUOffset<SteamVRTrackersSetting>>("steam_vr_trackers", Self::VT_STEAM_VR_TRACKERS, false)?
     .visit_field::<flatbuffers::ForwardsUOffset<FilteringSettings>>("filtering", Self::VT_FILTERING, false)?
     .visit_field::<flatbuffers::ForwardsUOffset<OSCSettings>>("osc", Self::VT_OSC, false)?
     .visit_field::<flatbuffers::ForwardsUOffset<settings::ModelSettings>>("model_settings", Self::VT_MODEL_SETTINGS, false)?
     .finish();
    Ok(())
  }
}
pub struct SettingsResponseArgs<'a> {
    pub steam_vr_trackers: Option<flatbuffers::WIPOffset<SteamVRTrackersSetting<'a>>>,
    pub filtering: Option<flatbuffers::WIPOffset<FilteringSettings<'a>>>,
    pub osc: Option<flatbuffers::WIPOffset<OSCSettings<'a>>>,
    pub model_settings: Option<flatbuffers::WIPOffset<settings::ModelSettings<'a>>>,
}
impl<'a> Default for SettingsResponseArgs<'a> {
  #[inline]
  fn default() -> Self {
    SettingsResponseArgs {
      steam_vr_trackers: None,
      filtering: None,
      osc: None,
      model_settings: None,
    }
  }
}

pub struct SettingsResponseBuilder<'a: 'b, 'b> {
  fbb_: &'b mut flatbuffers::FlatBufferBuilder<'a>,
  start_: flatbuffers::WIPOffset<flatbuffers::TableUnfinishedWIPOffset>,
}
impl<'a: 'b, 'b> SettingsResponseBuilder<'a, 'b> {
  #[inline]
  pub fn add_steam_vr_trackers(&mut self, steam_vr_trackers: flatbuffers::WIPOffset<SteamVRTrackersSetting<'b >>) {
    self.fbb_.push_slot_always::<flatbuffers::WIPOffset<SteamVRTrackersSetting>>(SettingsResponse::VT_STEAM_VR_TRACKERS, steam_vr_trackers);
  }
  #[inline]
  pub fn add_filtering(&mut self, filtering: flatbuffers::WIPOffset<FilteringSettings<'b >>) {
    self.fbb_.push_slot_always::<flatbuffers::WIPOffset<FilteringSettings>>(SettingsResponse::VT_FILTERING, filtering);
  }
  #[inline]
  pub fn add_osc(&mut self, osc: flatbuffers::WIPOffset<OSCSettings<'b >>) {
    self.fbb_.push_slot_always::<flatbuffers::WIPOffset<OSCSettings>>(SettingsResponse::VT_OSC, osc);
  }
  #[inline]
  pub fn add_model_settings(&mut self, model_settings: flatbuffers::WIPOffset<settings::ModelSettings<'b >>) {
    self.fbb_.push_slot_always::<flatbuffers::WIPOffset<settings::ModelSettings>>(SettingsResponse::VT_MODEL_SETTINGS, model_settings);
  }
  #[inline]
  pub fn new(_fbb: &'b mut flatbuffers::FlatBufferBuilder<'a>) -> SettingsResponseBuilder<'a, 'b> {
    let start = _fbb.start_table();
    SettingsResponseBuilder {
      fbb_: _fbb,
      start_: start,
    }
  }
  #[inline]
  pub fn finish(self) -> flatbuffers::WIPOffset<SettingsResponse<'a>> {
    let o = self.fbb_.end_table(self.start_);
    flatbuffers::WIPOffset::new(o.value())
  }
}

impl core::fmt::Debug for SettingsResponse<'_> {
  fn fmt(&self, f: &mut core::fmt::Formatter<'_>) -> core::fmt::Result {
    let mut ds = f.debug_struct("SettingsResponse");
      ds.field("steam_vr_trackers", &self.steam_vr_trackers());
      ds.field("filtering", &self.filtering());
      ds.field("osc", &self.osc());
      ds.field("model_settings", &self.model_settings());
      ds.finish()
  }
}
