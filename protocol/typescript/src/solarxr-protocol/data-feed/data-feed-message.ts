// automatically generated by the FlatBuffers compiler, do not modify

import { DataFeedConfig, DataFeedConfigT } from '../../solarxr-protocol/data-feed/data-feed-config.js';
import { DataFeedUpdate, DataFeedUpdateT } from '../../solarxr-protocol/data-feed/data-feed-update.js';
import { PollDataFeed, PollDataFeedT } from '../../solarxr-protocol/data-feed/poll-data-feed.js';
import { StartDataFeed, StartDataFeedT } from '../../solarxr-protocol/data-feed/start-data-feed.js';


export enum DataFeedMessage {
  NONE = 0,
  PollDataFeed = 1,
  StartDataFeed = 2,
  DataFeedUpdate = 3,
  DataFeedConfig = 4
}

export function unionToDataFeedMessage(
  type: DataFeedMessage,
  accessor: (obj:DataFeedConfig|DataFeedUpdate|PollDataFeed|StartDataFeed) => DataFeedConfig|DataFeedUpdate|PollDataFeed|StartDataFeed|null
): DataFeedConfig|DataFeedUpdate|PollDataFeed|StartDataFeed|null {
  switch(DataFeedMessage[type]) {
    case 'NONE': return null; 
    case 'PollDataFeed': return accessor(new PollDataFeed())! as PollDataFeed;
    case 'StartDataFeed': return accessor(new StartDataFeed())! as StartDataFeed;
    case 'DataFeedUpdate': return accessor(new DataFeedUpdate())! as DataFeedUpdate;
    case 'DataFeedConfig': return accessor(new DataFeedConfig())! as DataFeedConfig;
    default: return null;
  }
}

export function unionListToDataFeedMessage(
  type: DataFeedMessage, 
  accessor: (index: number, obj:DataFeedConfig|DataFeedUpdate|PollDataFeed|StartDataFeed) => DataFeedConfig|DataFeedUpdate|PollDataFeed|StartDataFeed|null, 
  index: number
): DataFeedConfig|DataFeedUpdate|PollDataFeed|StartDataFeed|null {
  switch(DataFeedMessage[type]) {
    case 'NONE': return null; 
    case 'PollDataFeed': return accessor(index, new PollDataFeed())! as PollDataFeed;
    case 'StartDataFeed': return accessor(index, new StartDataFeed())! as StartDataFeed;
    case 'DataFeedUpdate': return accessor(index, new DataFeedUpdate())! as DataFeedUpdate;
    case 'DataFeedConfig': return accessor(index, new DataFeedConfig())! as DataFeedConfig;
    default: return null;
  }
}
