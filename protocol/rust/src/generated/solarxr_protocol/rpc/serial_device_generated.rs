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
pub enum SerialDeviceOffset {}
#[derive(Copy, Clone, PartialEq)]

pub struct SerialDevice<'a> {
  pub _tab: flatbuffers::Table<'a>,
}

impl<'a> flatbuffers::Follow<'a> for SerialDevice<'a> {
  type Inner = SerialDevice<'a>;
  #[inline]
  unsafe fn follow(buf: &'a [u8], loc: usize) -> Self::Inner {
    Self { _tab: flatbuffers::Table::new(buf, loc) }
  }
}

impl<'a> SerialDevice<'a> {
  pub const VT_PORT: flatbuffers::VOffsetT = 4;
  pub const VT_NAME: flatbuffers::VOffsetT = 6;

  #[inline]
  pub unsafe fn init_from_table(table: flatbuffers::Table<'a>) -> Self {
    SerialDevice { _tab: table }
  }
  #[allow(unused_mut)]
  pub fn create<'bldr: 'args, 'args: 'mut_bldr, 'mut_bldr>(
    _fbb: &'mut_bldr mut flatbuffers::FlatBufferBuilder<'bldr>,
    args: &'args SerialDeviceArgs<'args>
  ) -> flatbuffers::WIPOffset<SerialDevice<'bldr>> {
    let mut builder = SerialDeviceBuilder::new(_fbb);
    if let Some(x) = args.name { builder.add_name(x); }
    if let Some(x) = args.port { builder.add_port(x); }
    builder.finish()
  }


  #[inline]
  pub fn port(&self) -> Option<&'a str> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<flatbuffers::ForwardsUOffset<&str>>(SerialDevice::VT_PORT, None)}
  }
  #[inline]
  pub fn name(&self) -> Option<&'a str> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<flatbuffers::ForwardsUOffset<&str>>(SerialDevice::VT_NAME, None)}
  }
}

impl flatbuffers::Verifiable for SerialDevice<'_> {
  #[inline]
  fn run_verifier(
    v: &mut flatbuffers::Verifier, pos: usize
  ) -> Result<(), flatbuffers::InvalidFlatbuffer> {
    use self::flatbuffers::Verifiable;
    v.visit_table(pos)?
     .visit_field::<flatbuffers::ForwardsUOffset<&str>>("port", Self::VT_PORT, false)?
     .visit_field::<flatbuffers::ForwardsUOffset<&str>>("name", Self::VT_NAME, false)?
     .finish();
    Ok(())
  }
}
pub struct SerialDeviceArgs<'a> {
    pub port: Option<flatbuffers::WIPOffset<&'a str>>,
    pub name: Option<flatbuffers::WIPOffset<&'a str>>,
}
impl<'a> Default for SerialDeviceArgs<'a> {
  #[inline]
  fn default() -> Self {
    SerialDeviceArgs {
      port: None,
      name: None,
    }
  }
}

pub struct SerialDeviceBuilder<'a: 'b, 'b> {
  fbb_: &'b mut flatbuffers::FlatBufferBuilder<'a>,
  start_: flatbuffers::WIPOffset<flatbuffers::TableUnfinishedWIPOffset>,
}
impl<'a: 'b, 'b> SerialDeviceBuilder<'a, 'b> {
  #[inline]
  pub fn add_port(&mut self, port: flatbuffers::WIPOffset<&'b  str>) {
    self.fbb_.push_slot_always::<flatbuffers::WIPOffset<_>>(SerialDevice::VT_PORT, port);
  }
  #[inline]
  pub fn add_name(&mut self, name: flatbuffers::WIPOffset<&'b  str>) {
    self.fbb_.push_slot_always::<flatbuffers::WIPOffset<_>>(SerialDevice::VT_NAME, name);
  }
  #[inline]
  pub fn new(_fbb: &'b mut flatbuffers::FlatBufferBuilder<'a>) -> SerialDeviceBuilder<'a, 'b> {
    let start = _fbb.start_table();
    SerialDeviceBuilder {
      fbb_: _fbb,
      start_: start,
    }
  }
  #[inline]
  pub fn finish(self) -> flatbuffers::WIPOffset<SerialDevice<'a>> {
    let o = self.fbb_.end_table(self.start_);
    flatbuffers::WIPOffset::new(o.value())
  }
}

impl core::fmt::Debug for SerialDevice<'_> {
  fn fmt(&self, f: &mut core::fmt::Formatter<'_>) -> core::fmt::Result {
    let mut ds = f.debug_struct("SerialDevice");
      ds.field("port", &self.port());
      ds.field("name", &self.name());
      ds.finish()
  }
}
