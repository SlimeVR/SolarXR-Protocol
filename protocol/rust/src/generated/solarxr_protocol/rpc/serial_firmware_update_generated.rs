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
pub enum SerialFirmwareUpdateOffset {}
#[derive(Copy, Clone, PartialEq)]

pub struct SerialFirmwareUpdate<'a> {
  pub _tab: flatbuffers::Table<'a>,
}

impl<'a> flatbuffers::Follow<'a> for SerialFirmwareUpdate<'a> {
  type Inner = SerialFirmwareUpdate<'a>;
  #[inline]
  unsafe fn follow(buf: &'a [u8], loc: usize) -> Self::Inner {
    Self { _tab: flatbuffers::Table::new(buf, loc) }
  }
}

impl<'a> SerialFirmwareUpdate<'a> {
  pub const VT_DEVICE_ID: flatbuffers::VOffsetT = 4;
  pub const VT_NEEDMANUALREBOOT: flatbuffers::VOffsetT = 6;
  pub const VT_SSID: flatbuffers::VOffsetT = 8;
  pub const VT_PASSWORD: flatbuffers::VOffsetT = 10;
  pub const VT_FIRMWARE_PART: flatbuffers::VOffsetT = 12;

  #[inline]
  pub unsafe fn init_from_table(table: flatbuffers::Table<'a>) -> Self {
    SerialFirmwareUpdate { _tab: table }
  }
  #[allow(unused_mut)]
  pub fn create<'bldr: 'args, 'args: 'mut_bldr, 'mut_bldr>(
    _fbb: &'mut_bldr mut flatbuffers::FlatBufferBuilder<'bldr>,
    args: &'args SerialFirmwareUpdateArgs<'args>
  ) -> flatbuffers::WIPOffset<SerialFirmwareUpdate<'bldr>> {
    let mut builder = SerialFirmwareUpdateBuilder::new(_fbb);
    if let Some(x) = args.firmware_part { builder.add_firmware_part(x); }
    if let Some(x) = args.password { builder.add_password(x); }
    if let Some(x) = args.ssid { builder.add_ssid(x); }
    if let Some(x) = args.device_id { builder.add_device_id(x); }
    builder.add_needManualReboot(args.needManualReboot);
    builder.finish()
  }


  /// id of the device, this refer to a serial port id
  #[inline]
  pub fn device_id(&self) -> Option<SerialDevicePort<'a>> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<flatbuffers::ForwardsUOffset<SerialDevicePort>>(SerialFirmwareUpdate::VT_DEVICE_ID, None)}
  }
  /// Will make the server ask for the tracker to be manually rebooted by the user
  /// after the tracker is done flashing
  #[inline]
  pub fn needManualReboot(&self) -> bool {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<bool>(SerialFirmwareUpdate::VT_NEEDMANUALREBOOT, Some(false)).unwrap()}
  }
  /// Credentials to provision after the flashing
  /// Only used with Serial flashing, because OTA is already connected to the wifi
  #[inline]
  pub fn ssid(&self) -> Option<&'a str> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<flatbuffers::ForwardsUOffset<&str>>(SerialFirmwareUpdate::VT_SSID, None)}
  }
  #[inline]
  pub fn password(&self) -> Option<&'a str> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<flatbuffers::ForwardsUOffset<&str>>(SerialFirmwareUpdate::VT_PASSWORD, None)}
  }
  /// A list of urls and offsets of the different firmware files to flash
  #[inline]
  pub fn firmware_part(&self) -> Option<flatbuffers::Vector<'a, flatbuffers::ForwardsUOffset<FirmwarePart<'a>>>> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<flatbuffers::ForwardsUOffset<flatbuffers::Vector<'a, flatbuffers::ForwardsUOffset<FirmwarePart>>>>(SerialFirmwareUpdate::VT_FIRMWARE_PART, None)}
  }
}

impl flatbuffers::Verifiable for SerialFirmwareUpdate<'_> {
  #[inline]
  fn run_verifier(
    v: &mut flatbuffers::Verifier, pos: usize
  ) -> Result<(), flatbuffers::InvalidFlatbuffer> {
    use self::flatbuffers::Verifiable;
    v.visit_table(pos)?
     .visit_field::<flatbuffers::ForwardsUOffset<SerialDevicePort>>("device_id", Self::VT_DEVICE_ID, false)?
     .visit_field::<bool>("needManualReboot", Self::VT_NEEDMANUALREBOOT, false)?
     .visit_field::<flatbuffers::ForwardsUOffset<&str>>("ssid", Self::VT_SSID, false)?
     .visit_field::<flatbuffers::ForwardsUOffset<&str>>("password", Self::VT_PASSWORD, false)?
     .visit_field::<flatbuffers::ForwardsUOffset<flatbuffers::Vector<'_, flatbuffers::ForwardsUOffset<FirmwarePart>>>>("firmware_part", Self::VT_FIRMWARE_PART, false)?
     .finish();
    Ok(())
  }
}
pub struct SerialFirmwareUpdateArgs<'a> {
    pub device_id: Option<flatbuffers::WIPOffset<SerialDevicePort<'a>>>,
    pub needManualReboot: bool,
    pub ssid: Option<flatbuffers::WIPOffset<&'a str>>,
    pub password: Option<flatbuffers::WIPOffset<&'a str>>,
    pub firmware_part: Option<flatbuffers::WIPOffset<flatbuffers::Vector<'a, flatbuffers::ForwardsUOffset<FirmwarePart<'a>>>>>,
}
impl<'a> Default for SerialFirmwareUpdateArgs<'a> {
  #[inline]
  fn default() -> Self {
    SerialFirmwareUpdateArgs {
      device_id: None,
      needManualReboot: false,
      ssid: None,
      password: None,
      firmware_part: None,
    }
  }
}

pub struct SerialFirmwareUpdateBuilder<'a: 'b, 'b> {
  fbb_: &'b mut flatbuffers::FlatBufferBuilder<'a>,
  start_: flatbuffers::WIPOffset<flatbuffers::TableUnfinishedWIPOffset>,
}
impl<'a: 'b, 'b> SerialFirmwareUpdateBuilder<'a, 'b> {
  #[inline]
  pub fn add_device_id(&mut self, device_id: flatbuffers::WIPOffset<SerialDevicePort<'b >>) {
    self.fbb_.push_slot_always::<flatbuffers::WIPOffset<SerialDevicePort>>(SerialFirmwareUpdate::VT_DEVICE_ID, device_id);
  }
  #[inline]
  pub fn add_needManualReboot(&mut self, needManualReboot: bool) {
    self.fbb_.push_slot::<bool>(SerialFirmwareUpdate::VT_NEEDMANUALREBOOT, needManualReboot, false);
  }
  #[inline]
  pub fn add_ssid(&mut self, ssid: flatbuffers::WIPOffset<&'b  str>) {
    self.fbb_.push_slot_always::<flatbuffers::WIPOffset<_>>(SerialFirmwareUpdate::VT_SSID, ssid);
  }
  #[inline]
  pub fn add_password(&mut self, password: flatbuffers::WIPOffset<&'b  str>) {
    self.fbb_.push_slot_always::<flatbuffers::WIPOffset<_>>(SerialFirmwareUpdate::VT_PASSWORD, password);
  }
  #[inline]
  pub fn add_firmware_part(&mut self, firmware_part: flatbuffers::WIPOffset<flatbuffers::Vector<'b , flatbuffers::ForwardsUOffset<FirmwarePart<'b >>>>) {
    self.fbb_.push_slot_always::<flatbuffers::WIPOffset<_>>(SerialFirmwareUpdate::VT_FIRMWARE_PART, firmware_part);
  }
  #[inline]
  pub fn new(_fbb: &'b mut flatbuffers::FlatBufferBuilder<'a>) -> SerialFirmwareUpdateBuilder<'a, 'b> {
    let start = _fbb.start_table();
    SerialFirmwareUpdateBuilder {
      fbb_: _fbb,
      start_: start,
    }
  }
  #[inline]
  pub fn finish(self) -> flatbuffers::WIPOffset<SerialFirmwareUpdate<'a>> {
    let o = self.fbb_.end_table(self.start_);
    flatbuffers::WIPOffset::new(o.value())
  }
}

impl core::fmt::Debug for SerialFirmwareUpdate<'_> {
  fn fmt(&self, f: &mut core::fmt::Formatter<'_>) -> core::fmt::Result {
    let mut ds = f.debug_struct("SerialFirmwareUpdate");
      ds.field("device_id", &self.device_id());
      ds.field("needManualReboot", &self.needManualReboot());
      ds.field("ssid", &self.ssid());
      ds.field("password", &self.password());
      ds.field("firmware_part", &self.firmware_part());
      ds.finish()
  }
}
