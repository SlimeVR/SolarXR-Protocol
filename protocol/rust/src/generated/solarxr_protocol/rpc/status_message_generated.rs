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
pub enum StatusMessageOffset {}
#[derive(Copy, Clone, PartialEq)]

/// An status is some kind of warning sent by the server, it's mainly made for
/// showing problems with the server and need attention from the user.
pub struct StatusMessage<'a> {
  pub _tab: flatbuffers::Table<'a>,
}

impl<'a> flatbuffers::Follow<'a> for StatusMessage<'a> {
  type Inner = StatusMessage<'a>;
  #[inline]
  unsafe fn follow(buf: &'a [u8], loc: usize) -> Self::Inner {
    Self { _tab: flatbuffers::Table::new(buf, loc) }
  }
}

impl<'a> StatusMessage<'a> {
  pub const VT_ID: flatbuffers::VOffsetT = 4;
  pub const VT_PRIORITIZED: flatbuffers::VOffsetT = 6;
  pub const VT_DATA_TYPE: flatbuffers::VOffsetT = 8;
  pub const VT_DATA: flatbuffers::VOffsetT = 10;

  #[inline]
  pub unsafe fn init_from_table(table: flatbuffers::Table<'a>) -> Self {
    StatusMessage { _tab: table }
  }
  #[allow(unused_mut)]
  pub fn create<'bldr: 'args, 'args: 'mut_bldr, 'mut_bldr>(
    _fbb: &'mut_bldr mut flatbuffers::FlatBufferBuilder<'bldr>,
    args: &'args StatusMessageArgs
  ) -> flatbuffers::WIPOffset<StatusMessage<'bldr>> {
    let mut builder = StatusMessageBuilder::new(_fbb);
    if let Some(x) = args.data { builder.add_data(x); }
    builder.add_id(args.id);
    builder.add_data_type(args.data_type);
    builder.add_prioritized(args.prioritized);
    builder.finish()
  }


  /// The status ID
  #[inline]
  pub fn id(&self) -> u32 {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<u32>(StatusMessage::VT_ID, Some(0)).unwrap()}
  }
  /// This should be prioritized in the GUI in some way if true
  #[inline]
  pub fn prioritized(&self) -> bool {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(StatusMessage::VT_PRIORITIZED, Some(false)).unwrap()}
  }
  #[inline]
  pub fn data_type(&self) -> StatusData {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<StatusData>(StatusMessage::VT_DATA_TYPE, Some(StatusData::NONE)).unwrap()}
  }
  #[inline]
  pub fn data(&self) -> Option<flatbuffers::Table<'a>> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<flatbuffers::ForwardsUOffset<flatbuffers::Table<'a>>>(StatusMessage::VT_DATA, None)}
  }
  #[inline]
  #[allow(non_snake_case)]
  pub fn data_as_status_tracker_reset(&self) -> Option<StatusTrackerReset<'a>> {
    if self.data_type() == StatusData::StatusTrackerReset {
      self.data().map(|t| {
       // Safety:
       // Created from a valid Table for this object
       // Which contains a valid union in this slot
       unsafe { StatusTrackerReset::init_from_table(t) }
     })
    } else {
      None
    }
  }

  #[inline]
  #[allow(non_snake_case)]
  pub fn data_as_status_tracker_error(&self) -> Option<StatusTrackerError<'a>> {
    if self.data_type() == StatusData::StatusTrackerError {
      self.data().map(|t| {
       // Safety:
       // Created from a valid Table for this object
       // Which contains a valid union in this slot
       unsafe { StatusTrackerError::init_from_table(t) }
     })
    } else {
      None
    }
  }

  #[inline]
  #[allow(non_snake_case)]
  pub fn data_as_status_steam_vrdisconnected(&self) -> Option<StatusSteamVRDisconnected<'a>> {
    if self.data_type() == StatusData::StatusSteamVRDisconnected {
      self.data().map(|t| {
       // Safety:
       // Created from a valid Table for this object
       // Which contains a valid union in this slot
       unsafe { StatusSteamVRDisconnected::init_from_table(t) }
     })
    } else {
      None
    }
  }

  #[inline]
  #[allow(non_snake_case)]
  pub fn data_as_status_unassigned_hmd(&self) -> Option<StatusUnassignedHMD<'a>> {
    if self.data_type() == StatusData::StatusUnassignedHMD {
      self.data().map(|t| {
       // Safety:
       // Created from a valid Table for this object
       // Which contains a valid union in this slot
       unsafe { StatusUnassignedHMD::init_from_table(t) }
     })
    } else {
      None
    }
  }

}

impl flatbuffers::Verifiable for StatusMessage<'_> {
  #[inline]
  fn run_verifier(
    v: &mut flatbuffers::Verifier, pos: usize
  ) -> Result<(), flatbuffers::InvalidFlatbuffer> {
    use self::flatbuffers::Verifiable;
    v.visit_table(pos)?
     .visit_field::<u32>("id", Self::VT_ID, false)?
     .visit_field::<bool>("prioritized", Self::VT_PRIORITIZED, false)?
     .visit_union::<StatusData, _>("data_type", Self::VT_DATA_TYPE, "data", Self::VT_DATA, false, |key, v, pos| {
        match key {
          StatusData::StatusTrackerReset => v.verify_union_variant::<flatbuffers::ForwardsUOffset<StatusTrackerReset>>("StatusData::StatusTrackerReset", pos),
          StatusData::StatusTrackerError => v.verify_union_variant::<flatbuffers::ForwardsUOffset<StatusTrackerError>>("StatusData::StatusTrackerError", pos),
          StatusData::StatusSteamVRDisconnected => v.verify_union_variant::<flatbuffers::ForwardsUOffset<StatusSteamVRDisconnected>>("StatusData::StatusSteamVRDisconnected", pos),
          StatusData::StatusUnassignedHMD => v.verify_union_variant::<flatbuffers::ForwardsUOffset<StatusUnassignedHMD>>("StatusData::StatusUnassignedHMD", pos),
          _ => Ok(()),
        }
     })?
     .finish();
    Ok(())
  }
}
pub struct StatusMessageArgs {
    pub id: u32,
    pub prioritized: bool,
    pub data_type: StatusData,
    pub data: Option<flatbuffers::WIPOffset<flatbuffers::UnionWIPOffset>>,
}
impl<'a> Default for StatusMessageArgs {
  #[inline]
  fn default() -> Self {
    StatusMessageArgs {
      id: 0,
      prioritized: false,
      data_type: StatusData::NONE,
      data: None,
    }
  }
}

pub struct StatusMessageBuilder<'a: 'b, 'b> {
  fbb_: &'b mut flatbuffers::FlatBufferBuilder<'a>,
  start_: flatbuffers::WIPOffset<flatbuffers::TableUnfinishedWIPOffset>,
}
impl<'a: 'b, 'b> StatusMessageBuilder<'a, 'b> {
  #[inline]
  pub fn add_id(&mut self, id: u32) {
    self.fbb_.push_slot::<u32>(StatusMessage::VT_ID, id, 0);
  }
  #[inline]
  pub fn add_prioritized(&mut self, prioritized: bool) {
    self.fbb_.push_slot::<bool>(StatusMessage::VT_PRIORITIZED, prioritized, false);
  }
  #[inline]
  pub fn add_data_type(&mut self, data_type: StatusData) {
    self.fbb_.push_slot::<StatusData>(StatusMessage::VT_DATA_TYPE, data_type, StatusData::NONE);
  }
  #[inline]
  pub fn add_data(&mut self, data: flatbuffers::WIPOffset<flatbuffers::UnionWIPOffset>) {
    self.fbb_.push_slot_always::<flatbuffers::WIPOffset<_>>(StatusMessage::VT_DATA, data);
  }
  #[inline]
  pub fn new(_fbb: &'b mut flatbuffers::FlatBufferBuilder<'a>) -> StatusMessageBuilder<'a, 'b> {
    let start = _fbb.start_table();
    StatusMessageBuilder {
      fbb_: _fbb,
      start_: start,
    }
  }
  #[inline]
  pub fn finish(self) -> flatbuffers::WIPOffset<StatusMessage<'a>> {
    let o = self.fbb_.end_table(self.start_);
    flatbuffers::WIPOffset::new(o.value())
  }
}

impl core::fmt::Debug for StatusMessage<'_> {
  fn fmt(&self, f: &mut core::fmt::Formatter<'_>) -> core::fmt::Result {
    let mut ds = f.debug_struct("StatusMessage");
      ds.field("id", &self.id());
      ds.field("prioritized", &self.prioritized());
      ds.field("data_type", &self.data_type());
      match self.data_type() {
        StatusData::StatusTrackerReset => {
          if let Some(x) = self.data_as_status_tracker_reset() {
            ds.field("data", &x)
          } else {
            ds.field("data", &"InvalidFlatbuffer: Union discriminant does not match value.")
          }
        },
        StatusData::StatusTrackerError => {
          if let Some(x) = self.data_as_status_tracker_error() {
            ds.field("data", &x)
          } else {
            ds.field("data", &"InvalidFlatbuffer: Union discriminant does not match value.")
          }
        },
        StatusData::StatusSteamVRDisconnected => {
          if let Some(x) = self.data_as_status_steam_vrdisconnected() {
            ds.field("data", &x)
          } else {
            ds.field("data", &"InvalidFlatbuffer: Union discriminant does not match value.")
          }
        },
        StatusData::StatusUnassignedHMD => {
          if let Some(x) = self.data_as_status_unassigned_hmd() {
            ds.field("data", &x)
          } else {
            ds.field("data", &"InvalidFlatbuffer: Union discriminant does not match value.")
          }
        },
        _ => {
          let x: Option<()> = None;
          ds.field("data", &x)
        },
      };
      ds.finish()
  }
}
