package cn.org.rapid_framework.shard;

import javax.sql.DataSource;


/**
 * 
 * 
 */
public interface Shard {
    DataSource getDataSource();
    
    /**
     * @return the ids of the virtual shards that are mapped to this physical shard.
     * The returned Set is unmodifiable.
     */
    ShardId getShardId();
}
