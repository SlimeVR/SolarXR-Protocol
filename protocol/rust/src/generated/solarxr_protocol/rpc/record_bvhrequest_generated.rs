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
pub enum RecordBVHRequestOffset {}
#[derive(Copy, Clone, PartialEq)]

pub struct RecordBVHRequest<'a> {
  pub _tab: flatbuffers::Table<'a>,
}

impl<'a> flatbuffers::Follow<'a> for RecordBVHRequest<'a> {
  type Inner = RecordBVHRequest<'a>;
  #[inline]
  unsafe fn follow(buf: &'a [u8], loc: usize) -> Self::Inner {
    Self { _tab: flatbuffers::Table::new(buf, loc) }
  }
}

impl<'a> RecordBVHRequest<'a> {
  pub const VT_STOP: flatbuffers::VOffsetT = 4;
  pub const VT_PATH: flatbuffers::VOffsetT = 6;

  #[inline]
  pub unsafe fn init_from_table(table: flatbuffers::Table<'a>) -> Self {
    RecordBVHRequest { _tab: table }
  }
  #[allow(unused_mut)]
  pub fn create<'bldr: 'args, 'args: 'mut_bldr, 'mut_bldr>(
    _fbb: &'mut_bldr mut flatbuffers::FlatBufferBuilder<'bldr>,
    args: &'args RecordBVHRequestArgs<'args>
  ) -> flatbuffers::WIPOffset<RecordBVHRequest<'bldr>> {
    let mut builder = RecordBVHRequestBuilder::new(_fbb);
    if let Some(x) = args.path { builder.add_path(x); }
    builder.add_stop(args.stop);
    builder.finish()
  }


  #[inline]
  pub fn stop(&self) -> bool {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(RecordBVHRequest::VT_STOP, Some(false)).unwrap()}
  }
  /// Path sent when starting the recording, if null the recording won't happen.
  /// Has different behavior depending if its a file path or a directory path.
  #[inline]
  pub fn path(&self) -> Option<&'a str> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<flatbuffers::ForwardsUOffset<&str>>(RecordBVHRequest::VT_PATH, None)}
  }
}

impl flatbuffers::Verifiable for RecordBVHRequest<'_> {
  #[inline]
  fn run_verifier(
    v: &mut flatbuffers::Verifier, pos: usize
  ) -> Result<(), flatbuffers::InvalidFlatbuffer> {
    use self::flatbuffers::Verifiable;
    v.visit_table(pos)?
     .visit_field::<bool>("stop", Self::VT_STOP, false)?
     .visit_field::<flatbuffers::ForwardsUOffset<&str>>("path", Self::VT_PATH, false)?
     .finish();
    Ok(())
  }
}
pub struct RecordBVHRequestArgs<'a> {
    pub stop: bool,
    pub path: Option<flatbuffers::WIPOffset<&'a str>>,
}
impl<'a> Default for RecordBVHRequestArgs<'a> {
  #[inline]
  fn default() -> Self {
    RecordBVHRequestArgs {
      stop: false,
      path: None,
    }
  }
}

pub struct RecordBVHRequestBuilder<'a: 'b, 'b> {
  fbb_: &'b mut flatbuffers::FlatBufferBuilder<'a>,
  start_: flatbuffers::WIPOffset<flatbuffers::TableUnfinishedWIPOffset>,
}
impl<'a: 'b, 'b> RecordBVHRequestBuilder<'a, 'b> {
  #[inline]
  pub fn add_stop(&mut self, stop: bool) {
    self.fbb_.push_slot::<bool>(RecordBVHRequest::VT_STOP, stop, false);
  }
  #[inline]
  pub fn add_path(&mut self, path: flatbuffers::WIPOffset<&'b  str>) {
    self.fbb_.push_slot_always::<flatbuffers::WIPOffset<_>>(RecordBVHRequest::VT_PATH, path);
  }
  #[inline]
  pub fn new(_fbb: &'b mut flatbuffers::FlatBufferBuilder<'a>) -> RecordBVHRequestBuilder<'a, 'b> {
    let start = _fbb.start_table();
    RecordBVHRequestBuilder {
      fbb_: _fbb,
      start_: start,
    }
  }
  #[inline]
  pub fn finish(self) -> flatbuffers::WIPOffset<RecordBVHRequest<'a>> {
    let o = self.fbb_.end_table(self.start_);
    flatbuffers::WIPOffset::new(o.value())
  }
}

impl core::fmt::Debug for RecordBVHRequest<'_> {
  fn fmt(&self, f: &mut core::fmt::Formatter<'_>) -> core::fmt::Result {
    let mut ds = f.debug_struct("RecordBVHRequest");
      ds.field("stop", &self.stop());
      ds.field("path", &self.path());
      ds.finish()
  }
}
