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
pub enum OSCRouterSettingsOffset {}
#[derive(Copy, Clone, PartialEq)]

pub struct OSCRouterSettings<'a> {
  pub _tab: flatbuffers::Table<'a>,
}

impl<'a> flatbuffers::Follow<'a> for OSCRouterSettings<'a> {
  type Inner = OSCRouterSettings<'a>;
  #[inline]
  unsafe fn follow(buf: &'a [u8], loc: usize) -> Self::Inner {
    Self { _tab: flatbuffers::Table::new(buf, loc) }
  }
}

impl<'a> OSCRouterSettings<'a> {
  pub const VT_ENABLED: flatbuffers::VOffsetT = 4;
  pub const VT_PORTIN: flatbuffers::VOffsetT = 6;
  pub const VT_PORTOUT: flatbuffers::VOffsetT = 8;
  pub const VT_ADDRESS: flatbuffers::VOffsetT = 10;

  #[inline]
  pub unsafe fn init_from_table(table: flatbuffers::Table<'a>) -> Self {
    OSCRouterSettings { _tab: table }
  }
  #[allow(unused_mut)]
  pub fn create<'bldr: 'args, 'args: 'mut_bldr, 'mut_bldr>(
    _fbb: &'mut_bldr mut flatbuffers::FlatBufferBuilder<'bldr>,
    args: &'args OSCRouterSettingsArgs<'args>
  ) -> flatbuffers::WIPOffset<OSCRouterSettings<'bldr>> {
    let mut builder = OSCRouterSettingsBuilder::new(_fbb);
    if let Some(x) = args.address { builder.add_address(x); }
    builder.add_portOut(args.portOut);
    builder.add_portIn(args.portIn);
    builder.add_enabled(args.enabled);
    builder.finish()
  }


  #[inline]
  pub fn enabled(&self) -> bool {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(OSCRouterSettings::VT_ENABLED, Some(false)).unwrap()}
  }
  #[inline]
  pub fn portIn(&self) -> u16 {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<u16>(OSCRouterSettings::VT_PORTIN, Some(0)).unwrap()}
  }
  #[inline]
  pub fn portOut(&self) -> u16 {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<u16>(OSCRouterSettings::VT_PORTOUT, Some(0)).unwrap()}
  }
  #[inline]
  pub fn address(&self) -> Option<&'a str> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<flatbuffers::ForwardsUOffset<&str>>(OSCRouterSettings::VT_ADDRESS, None)}
  }
}

impl flatbuffers::Verifiable for OSCRouterSettings<'_> {
  #[inline]
  fn run_verifier(
    v: &mut flatbuffers::Verifier, pos: usize
  ) -> Result<(), flatbuffers::InvalidFlatbuffer> {
    use self::flatbuffers::Verifiable;
    v.visit_table(pos)?
     .visit_field::<bool>("enabled", Self::VT_ENABLED, false)?
     .visit_field::<u16>("portIn", Self::VT_PORTIN, false)?
     .visit_field::<u16>("portOut", Self::VT_PORTOUT, false)?
     .visit_field::<flatbuffers::ForwardsUOffset<&str>>("address", Self::VT_ADDRESS, false)?
     .finish();
    Ok(())
  }
}
pub struct OSCRouterSettingsArgs<'a> {
    pub enabled: bool,
    pub portIn: u16,
    pub portOut: u16,
    pub address: Option<flatbuffers::WIPOffset<&'a str>>,
}
impl<'a> Default for OSCRouterSettingsArgs<'a> {
  #[inline]
  fn default() -> Self {
    OSCRouterSettingsArgs {
      enabled: false,
      portIn: 0,
      portOut: 0,
      address: None,
    }
  }
}

pub struct OSCRouterSettingsBuilder<'a: 'b, 'b> {
  fbb_: &'b mut flatbuffers::FlatBufferBuilder<'a>,
  start_: flatbuffers::WIPOffset<flatbuffers::TableUnfinishedWIPOffset>,
}
impl<'a: 'b, 'b> OSCRouterSettingsBuilder<'a, 'b> {
  #[inline]
  pub fn add_enabled(&mut self, enabled: bool) {
    self.fbb_.push_slot::<bool>(OSCRouterSettings::VT_ENABLED, enabled, false);
  }
  #[inline]
  pub fn add_portIn(&mut self, portIn: u16) {
    self.fbb_.push_slot::<u16>(OSCRouterSettings::VT_PORTIN, portIn, 0);
  }
  #[inline]
  pub fn add_portOut(&mut self, portOut: u16) {
    self.fbb_.push_slot::<u16>(OSCRouterSettings::VT_PORTOUT, portOut, 0);
  }
  #[inline]
  pub fn add_address(&mut self, address: flatbuffers::WIPOffset<&'b  str>) {
    self.fbb_.push_slot_always::<flatbuffers::WIPOffset<_>>(OSCRouterSettings::VT_ADDRESS, address);
  }
  #[inline]
  pub fn new(_fbb: &'b mut flatbuffers::FlatBufferBuilder<'a>) -> OSCRouterSettingsBuilder<'a, 'b> {
    let start = _fbb.start_table();
    OSCRouterSettingsBuilder {
      fbb_: _fbb,
      start_: start,
    }
  }
  #[inline]
  pub fn finish(self) -> flatbuffers::WIPOffset<OSCRouterSettings<'a>> {
    let o = self.fbb_.end_table(self.start_);
    flatbuffers::WIPOffset::new(o.value())
  }
}

impl core::fmt::Debug for OSCRouterSettings<'_> {
  fn fmt(&self, f: &mut core::fmt::Formatter<'_>) -> core::fmt::Result {
    let mut ds = f.debug_struct("OSCRouterSettings");
      ds.field("enabled", &self.enabled());
      ds.field("portIn", &self.portIn());
      ds.field("portOut", &self.portOut());
      ds.field("address", &self.address());
      ds.finish()
  }
}