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
pub enum FirmwareUpdateStatusResponseOffset {}
#[derive(Copy, Clone, PartialEq)]

pub struct FirmwareUpdateStatusResponse<'a> {
  pub _tab: flatbuffers::Table<'a>,
}

impl<'a> flatbuffers::Follow<'a> for FirmwareUpdateStatusResponse<'a> {
  type Inner = FirmwareUpdateStatusResponse<'a>;
  #[inline]
  unsafe fn follow(buf: &'a [u8], loc: usize) -> Self::Inner {
    Self { _tab: flatbuffers::Table::new(buf, loc) }
  }
}

impl<'a> FirmwareUpdateStatusResponse<'a> {
  pub const VT_DEVICE_ID_TYPE: flatbuffers::VOffsetT = 4;
  pub const VT_DEVICE_ID: flatbuffers::VOffsetT = 6;
  pub const VT_STATUS: flatbuffers::VOffsetT = 8;
  pub const VT_PROGRESS: flatbuffers::VOffsetT = 10;

  #[inline]
  pub unsafe fn init_from_table(table: flatbuffers::Table<'a>) -> Self {
    FirmwareUpdateStatusResponse { _tab: table }
  }
  #[allow(unused_mut)]
  pub fn create<'bldr: 'args, 'args: 'mut_bldr, 'mut_bldr>(
    _fbb: &'mut_bldr mut flatbuffers::FlatBufferBuilder<'bldr>,
    args: &'args FirmwareUpdateStatusResponseArgs
  ) -> flatbuffers::WIPOffset<FirmwareUpdateStatusResponse<'bldr>> {
    let mut builder = FirmwareUpdateStatusResponseBuilder::new(_fbb);
    if let Some(x) = args.device_id { builder.add_device_id(x); }
    builder.add_progress(args.progress);
    builder.add_status(args.status);
    builder.add_device_id_type(args.device_id_type);
    builder.finish()
  }


  #[inline]
  pub fn device_id_type(&self) -> FirmwareUpdateDeviceId {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<FirmwareUpdateDeviceId>(FirmwareUpdateStatusResponse::VT_DEVICE_ID_TYPE, Some(FirmwareUpdateDeviceId::NONE)).unwrap()}
  }
  #[inline]
  pub fn device_id(&self) -> Option<flatbuffers::Table<'a>> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<flatbuffers::ForwardsUOffset<flatbuffers::Table<'a>>>(FirmwareUpdateStatusResponse::VT_DEVICE_ID, None)}
  }
  #[inline]
  pub fn status(&self) -> FirmwareUpdateStatus {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<FirmwareUpdateStatus>(FirmwareUpdateStatusResponse::VT_STATUS, Some(FirmwareUpdateStatus::DOWNLOADING)).unwrap()}
  }
  /// from 0 to 100
  #[inline]
  pub fn progress(&self) -> i8 {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<i8>(FirmwareUpdateStatusResponse::VT_PROGRESS, Some(0)).unwrap()}
  }
  #[inline]
  #[allow(non_snake_case)]
  pub fn device_id_as_solarxr_protocol_datatypes_device_id_table(&self) -> Option<super::datatypes::DeviceIdTable<'a>> {
    if self.device_id_type() == FirmwareUpdateDeviceId::solarxr_protocol_datatypes_DeviceIdTable {
      self.device_id().map(|t| {
       // Safety:
       // Created from a valid Table for this object
       // Which contains a valid union in this slot
       unsafe { super::datatypes::DeviceIdTable::init_from_table(t) }
     })
    } else {
      None
    }
  }

  #[inline]
  #[allow(non_snake_case)]
  pub fn device_id_as_serial_device_port(&self) -> Option<SerialDevicePort<'a>> {
    if self.device_id_type() == FirmwareUpdateDeviceId::SerialDevicePort {
      self.device_id().map(|t| {
       // Safety:
       // Created from a valid Table for this object
       // Which contains a valid union in this slot
       unsafe { SerialDevicePort::init_from_table(t) }
     })
    } else {
      None
    }
  }

}

impl flatbuffers::Verifiable for FirmwareUpdateStatusResponse<'_> {
  #[inline]
  fn run_verifier(
    v: &mut flatbuffers::Verifier, pos: usize
  ) -> Result<(), flatbuffers::InvalidFlatbuffer> {
    use self::flatbuffers::Verifiable;
    v.visit_table(pos)?
     .visit_union::<FirmwareUpdateDeviceId, _>("device_id_type", Self::VT_DEVICE_ID_TYPE, "device_id", Self::VT_DEVICE_ID, false, |key, v, pos| {
        match key {
          FirmwareUpdateDeviceId::solarxr_protocol_datatypes_DeviceIdTable => v.verify_union_variant::<flatbuffers::ForwardsUOffset<super::datatypes::DeviceIdTable>>("FirmwareUpdateDeviceId::solarxr_protocol_datatypes_DeviceIdTable", pos),
          FirmwareUpdateDeviceId::SerialDevicePort => v.verify_union_variant::<flatbuffers::ForwardsUOffset<SerialDevicePort>>("FirmwareUpdateDeviceId::SerialDevicePort", pos),
          _ => Ok(()),
        }
     })?
     .visit_field::<FirmwareUpdateStatus>("status", Self::VT_STATUS, false)?
     .visit_field::<i8>("progress", Self::VT_PROGRESS, false)?
     .finish();
    Ok(())
  }
}
pub struct FirmwareUpdateStatusResponseArgs {
    pub device_id_type: FirmwareUpdateDeviceId,
    pub device_id: Option<flatbuffers::WIPOffset<flatbuffers::UnionWIPOffset>>,
    pub status: FirmwareUpdateStatus,
    pub progress: i8,
}
impl<'a> Default for FirmwareUpdateStatusResponseArgs {
  #[inline]
  fn default() -> Self {
    FirmwareUpdateStatusResponseArgs {
      device_id_type: FirmwareUpdateDeviceId::NONE,
      device_id: None,
      status: FirmwareUpdateStatus::DOWNLOADING,
      progress: 0,
    }
  }
}

pub struct FirmwareUpdateStatusResponseBuilder<'a: 'b, 'b> {
  fbb_: &'b mut flatbuffers::FlatBufferBuilder<'a>,
  start_: flatbuffers::WIPOffset<flatbuffers::TableUnfinishedWIPOffset>,
}
impl<'a: 'b, 'b> FirmwareUpdateStatusResponseBuilder<'a, 'b> {
  #[inline]
  pub fn add_device_id_type(&mut self, device_id_type: FirmwareUpdateDeviceId) {
    self.fbb_.push_slot::<FirmwareUpdateDeviceId>(FirmwareUpdateStatusResponse::VT_DEVICE_ID_TYPE, device_id_type, FirmwareUpdateDeviceId::NONE);
  }
  #[inline]
  pub fn add_device_id(&mut self, device_id: flatbuffers::WIPOffset<flatbuffers::UnionWIPOffset>) {
    self.fbb_.push_slot_always::<flatbuffers::WIPOffset<_>>(FirmwareUpdateStatusResponse::VT_DEVICE_ID, device_id);
  }
  #[inline]
  pub fn add_status(&mut self, status: FirmwareUpdateStatus) {
    self.fbb_.push_slot::<FirmwareUpdateStatus>(FirmwareUpdateStatusResponse::VT_STATUS, status, FirmwareUpdateStatus::DOWNLOADING);
  }
  #[inline]
  pub fn add_progress(&mut self, progress: i8) {
    self.fbb_.push_slot::<i8>(FirmwareUpdateStatusResponse::VT_PROGRESS, progress, 0);
  }
  #[inline]
  pub fn new(_fbb: &'b mut flatbuffers::FlatBufferBuilder<'a>) -> FirmwareUpdateStatusResponseBuilder<'a, 'b> {
    let start = _fbb.start_table();
    FirmwareUpdateStatusResponseBuilder {
      fbb_: _fbb,
      start_: start,
    }
  }
  #[inline]
  pub fn finish(self) -> flatbuffers::WIPOffset<FirmwareUpdateStatusResponse<'a>> {
    let o = self.fbb_.end_table(self.start_);
    flatbuffers::WIPOffset::new(o.value())
  }
}

impl core::fmt::Debug for FirmwareUpdateStatusResponse<'_> {
  fn fmt(&self, f: &mut core::fmt::Formatter<'_>) -> core::fmt::Result {
    let mut ds = f.debug_struct("FirmwareUpdateStatusResponse");
      ds.field("device_id_type", &self.device_id_type());
      match self.device_id_type() {
        FirmwareUpdateDeviceId::solarxr_protocol_datatypes_DeviceIdTable => {
          if let Some(x) = self.device_id_as_solarxr_protocol_datatypes_device_id_table() {
            ds.field("device_id", &x)
          } else {
            ds.field("device_id", &"InvalidFlatbuffer: Union discriminant does not match value.")
          }
        },
        FirmwareUpdateDeviceId::SerialDevicePort => {
          if let Some(x) = self.device_id_as_serial_device_port() {
            ds.field("device_id", &x)
          } else {
            ds.field("device_id", &"InvalidFlatbuffer: Union discriminant does not match value.")
          }
        },
        _ => {
          let x: Option<()> = None;
          ds.field("device_id", &x)
        },
      };
      ds.field("status", &self.status());
      ds.field("progress", &self.progress());
      ds.finish()
  }
}
