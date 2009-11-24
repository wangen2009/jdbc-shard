package cn.org.rapid_framework.shard;

import java.util.Set;

import javax.sql.DataSource;


/**
 * 
 * ���һ��Shard
 * 
 * @author <a href="mailto:kerrigan@alibaba-inc.com">Argan Wang</a>
 */
public interface Shard {
    DataSource getDataSource();
    
    /**
     * @return the ids of the virtual shards that are mapped to this physical shard.
     * The returned Set is unmodifiable.
     */
    Set<ShardId> getShardIds();
}
