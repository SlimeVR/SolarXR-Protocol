// automatically generated by the FlatBuffers compiler, do not modify
extern crate flatbuffers;
use std::mem;
use std::cmp::Ordering;
use self::flatbuffers::{EndianScalar, Follow};
use super::*;
pub enum DataFeedMessageHeaderOffset {}
#[derive(Copy, Clone, PartialEq)]

pub struct DataFeedMessageHeader<'a> {
  pub _tab: flatbuffers::Table<'a>,
}

impl<'a> flatbuffers::Follow<'a> for DataFeedMessageHeader<'a> {
  type Inner = DataFeedMessageHeader<'a>;
  #[inline]
  fn follow(buf: &'a [u8], loc: usize) -> Self::Inner {
    Self { _tab: flatbuffers::Table { buf, loc } }
  }
}

impl<'a> DataFeedMessageHeader<'a> {
  pub const VT_MESSAGE_TYPE: flatbuffers::VOffsetT = 4;
  pub const VT_MESSAGE: flatbuffers::VOffsetT = 6;

  #[inline]
  pub fn init_from_table(table: flatbuffers::Table<'a>) -> Self {
    DataFeedMessageHeader { _tab: table }
  }
  #[allow(unused_mut)]
  pub fn create<'bldr: 'args, 'args: 'mut_bldr, 'mut_bldr>(
    _fbb: &'mut_bldr mut flatbuffers::FlatBufferBuilder<'bldr>,
    args: &'args DataFeedMessageHeaderArgs
  ) -> flatbuffers::WIPOffset<DataFeedMessageHeader<'bldr>> {
    let mut builder = DataFeedMessageHeaderBuilder::new(_fbb);
    if let Some(x) = args.message { builder.add_message(x); }
    builder.add_message_type(args.message_type);
    builder.finish()
  }


  #[inline]
  pub fn message_type(&self) -> DataFeedMessage {
    self._tab.get::<DataFeedMessage>(DataFeedMessageHeader::VT_MESSAGE_TYPE, Some(DataFeedMessage::NONE)).unwrap()
  }
  #[inline]
  pub fn message(&self) -> Option<flatbuffers::Table<'a>> {
    self._tab.get::<flatbuffers::ForwardsUOffset<flatbuffers::Table<'a>>>(DataFeedMessageHeader::VT_MESSAGE, None)
  }
  #[inline]
  #[allow(non_snake_case)]
  pub fn message_as_poll_data_feed(&self) -> Option<PollDataFeed<'a>> {
    if self.message_type() == DataFeedMessage::PollDataFeed {
      self.message().map(PollDataFeed::init_from_table)
    } else {
      None
    }
  }

  #[inline]
  #[allow(non_snake_case)]
  pub fn message_as_start_data_feed(&self) -> Option<StartDataFeed<'a>> {
    if self.message_type() == DataFeedMessage::StartDataFeed {
      self.message().map(StartDataFeed::init_from_table)
    } else {
      None
    }
  }

  #[inline]
  #[allow(non_snake_case)]
  pub fn message_as_data_feed_update(&self) -> Option<DataFeedUpdate<'a>> {
    if self.message_type() == DataFeedMessage::DataFeedUpdate {
      self.message().map(DataFeedUpdate::init_from_table)
    } else {
      None
    }
  }

  #[inline]
  #[allow(non_snake_case)]
  pub fn message_as_data_feed_config(&self) -> Option<DataFeedConfig<'a>> {
    if self.message_type() == DataFeedMessage::DataFeedConfig {
      self.message().map(DataFeedConfig::init_from_table)
    } else {
      None
    }
  }

}

impl flatbuffers::Verifiable for DataFeedMessageHeader<'_> {
  #[inline]
  fn run_verifier(
    v: &mut flatbuffers::Verifier, pos: usize
  ) -> Result<(), flatbuffers::InvalidFlatbuffer> {
    use self::flatbuffers::Verifiable;
    v.visit_table(pos)?
     .visit_union::<DataFeedMessage, _>("message_type", Self::VT_MESSAGE_TYPE, "message", Self::VT_MESSAGE, false, |key, v, pos| {
        match key {
          DataFeedMessage::PollDataFeed => v.verify_union_variant::<flatbuffers::ForwardsUOffset<PollDataFeed>>("DataFeedMessage::PollDataFeed", pos),
          DataFeedMessage::StartDataFeed => v.verify_union_variant::<flatbuffers::ForwardsUOffset<StartDataFeed>>("DataFeedMessage::StartDataFeed", pos),
          DataFeedMessage::DataFeedUpdate => v.verify_union_variant::<flatbuffers::ForwardsUOffset<DataFeedUpdate>>("DataFeedMessage::DataFeedUpdate", pos),
          DataFeedMessage::DataFeedConfig => v.verify_union_variant::<flatbuffers::ForwardsUOffset<DataFeedConfig>>("DataFeedMessage::DataFeedConfig", pos),
          _ => Ok(()),
        }
     })?
     .finish();
    Ok(())
  }
}
pub struct DataFeedMessageHeaderArgs {
    pub message_type: DataFeedMessage,
    pub message: Option<flatbuffers::WIPOffset<flatbuffers::UnionWIPOffset>>,
}
impl<'a> Default for DataFeedMessageHeaderArgs {
  #[inline]
  fn default() -> Self {
    DataFeedMessageHeaderArgs {
      message_type: DataFeedMessage::NONE,
      message: None,
    }
  }
}

pub struct DataFeedMessageHeaderBuilder<'a: 'b, 'b> {
  fbb_: &'b mut flatbuffers::FlatBufferBuilder<'a>,
  start_: flatbuffers::WIPOffset<flatbuffers::TableUnfinishedWIPOffset>,
}
impl<'a: 'b, 'b> DataFeedMessageHeaderBuilder<'a, 'b> {
  #[inline]
  pub fn add_message_type(&mut self, message_type: DataFeedMessage) {
    self.fbb_.push_slot::<DataFeedMessage>(DataFeedMessageHeader::VT_MESSAGE_TYPE, message_type, DataFeedMessage::NONE);
  }
  #[inline]
  pub fn add_message(&mut self, message: flatbuffers::WIPOffset<flatbuffers::UnionWIPOffset>) {
    self.fbb_.push_slot_always::<flatbuffers::WIPOffset<_>>(DataFeedMessageHeader::VT_MESSAGE, message);
  }
  #[inline]
  pub fn new(_fbb: &'b mut flatbuffers::FlatBufferBuilder<'a>) -> DataFeedMessageHeaderBuilder<'a, 'b> {
    let start = _fbb.start_table();
    DataFeedMessageHeaderBuilder {
      fbb_: _fbb,
      start_: start,
    }
  }
  #[inline]
  pub fn finish(self) -> flatbuffers::WIPOffset<DataFeedMessageHeader<'a>> {
    let o = self.fbb_.end_table(self.start_);
    flatbuffers::WIPOffset::new(o.value())
  }
}

impl std::fmt::Debug for DataFeedMessageHeader<'_> {
  fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
    let mut ds = f.debug_struct("DataFeedMessageHeader");
      ds.field("message_type", &self.message_type());
      match self.message_type() {
        DataFeedMessage::PollDataFeed => {
          if let Some(x) = self.message_as_poll_data_feed() {
            ds.field("message", &x)
          } else {
            ds.field("message", &"InvalidFlatbuffer: Union discriminant does not match value.")
          }
        },
        DataFeedMessage::StartDataFeed => {
          if let Some(x) = self.message_as_start_data_feed() {
            ds.field("message", &x)
          } else {
            ds.field("message", &"InvalidFlatbuffer: Union discriminant does not match value.")
          }
        },
        DataFeedMessage::DataFeedUpdate => {
          if let Some(x) = self.message_as_data_feed_update() {
            ds.field("message", &x)
          } else {
            ds.field("message", &"InvalidFlatbuffer: Union discriminant does not match value.")
          }
        },
        DataFeedMessage::DataFeedConfig => {
          if let Some(x) = self.message_as_data_feed_config() {
            ds.field("message", &x)
          } else {
            ds.field("message", &"InvalidFlatbuffer: Union discriminant does not match value.")
          }
        },
        _ => {
          let x: Option<()> = None;
          ds.field("message", &x)
        },
      };
      ds.finish()
  }
}