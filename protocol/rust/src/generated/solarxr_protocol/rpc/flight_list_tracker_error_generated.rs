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
pub enum FlightListTrackerErrorOffset {}
#[derive(Copy, Clone, PartialEq)]

/// Trackers with error state
pub struct FlightListTrackerError<'a> {
  pub _tab: flatbuffers::Table<'a>,
}

impl<'a> flatbuffers::Follow<'a> for FlightListTrackerError<'a> {
  type Inner = FlightListTrackerError<'a>;
  #[inline]
  unsafe fn follow(buf: &'a [u8], loc: usize) -> Self::Inner {
    Self { _tab: flatbuffers::Table::new(buf, loc) }
  }
}

impl<'a> FlightListTrackerError<'a> {
  pub const VT_TRACKERS_ID: flatbuffers::VOffsetT = 4;

  #[inline]
  pub unsafe fn init_from_table(table: flatbuffers::Table<'a>) -> Self {
    FlightListTrackerError { _tab: table }
  }
  #[allow(unused_mut)]
  pub fn create<'bldr: 'args, 'args: 'mut_bldr, 'mut_bldr>(
    _fbb: &'mut_bldr mut flatbuffers::FlatBufferBuilder<'bldr>,
    args: &'args FlightListTrackerErrorArgs<'args>
  ) -> flatbuffers::WIPOffset<FlightListTrackerError<'bldr>> {
    let mut builder = FlightListTrackerErrorBuilder::new(_fbb);
    if let Some(x) = args.trackers_id { builder.add_trackers_id(x); }
    builder.finish()
  }


  #[inline]
  pub fn trackers_id(&self) -> Option<flatbuffers::Vector<'a, flatbuffers::ForwardsUOffset<super::datatypes::TrackerId<'a>>>> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<flatbuffers::ForwardsUOffset<flatbuffers::Vector<'a, flatbuffers::ForwardsUOffset<super::datatypes::TrackerId>>>>(FlightListTrackerError::VT_TRACKERS_ID, None)}
  }
}

impl flatbuffers::Verifiable for FlightListTrackerError<'_> {
  #[inline]
  fn run_verifier(
    v: &mut flatbuffers::Verifier, pos: usize
  ) -> Result<(), flatbuffers::InvalidFlatbuffer> {
    use self::flatbuffers::Verifiable;
    v.visit_table(pos)?
     .visit_field::<flatbuffers::ForwardsUOffset<flatbuffers::Vector<'_, flatbuffers::ForwardsUOffset<super::datatypes::TrackerId>>>>("trackers_id", Self::VT_TRACKERS_ID, false)?
     .finish();
    Ok(())
  }
}
pub struct FlightListTrackerErrorArgs<'a> {
    pub trackers_id: Option<flatbuffers::WIPOffset<flatbuffers::Vector<'a, flatbuffers::ForwardsUOffset<super::datatypes::TrackerId<'a>>>>>,
}
impl<'a> Default for FlightListTrackerErrorArgs<'a> {
  #[inline]
  fn default() -> Self {
    FlightListTrackerErrorArgs {
      trackers_id: None,
    }
  }
}

pub struct FlightListTrackerErrorBuilder<'a: 'b, 'b> {
  fbb_: &'b mut flatbuffers::FlatBufferBuilder<'a>,
  start_: flatbuffers::WIPOffset<flatbuffers::TableUnfinishedWIPOffset>,
}
impl<'a: 'b, 'b> FlightListTrackerErrorBuilder<'a, 'b> {
  #[inline]
  pub fn add_trackers_id(&mut self, trackers_id: flatbuffers::WIPOffset<flatbuffers::Vector<'b , flatbuffers::ForwardsUOffset<super::datatypes::TrackerId<'b >>>>) {
    self.fbb_.push_slot_always::<flatbuffers::WIPOffset<_>>(FlightListTrackerError::VT_TRACKERS_ID, trackers_id);
  }
  #[inline]
  pub fn new(_fbb: &'b mut flatbuffers::FlatBufferBuilder<'a>) -> FlightListTrackerErrorBuilder<'a, 'b> {
    let start = _fbb.start_table();
    FlightListTrackerErrorBuilder {
      fbb_: _fbb,
      start_: start,
    }
  }
  #[inline]
  pub fn finish(self) -> flatbuffers::WIPOffset<FlightListTrackerError<'a>> {
    let o = self.fbb_.end_table(self.start_);
    flatbuffers::WIPOffset::new(o.value())
  }
}

impl core::fmt::Debug for FlightListTrackerError<'_> {
  fn fmt(&self, f: &mut core::fmt::Formatter<'_>) -> core::fmt::Result {
    let mut ds = f.debug_struct("FlightListTrackerError");
      ds.field("trackers_id", &self.trackers_id());
      ds.finish()
  }
}
