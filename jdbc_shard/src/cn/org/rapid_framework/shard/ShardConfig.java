package cn.org.rapid_framework.shard;

import java.util.List;

/**
 * Config infomation about sharding
 */
public interface ShardConfig {
    List<Shard> getAllShards();

    Shard getDefaultShard();
}
