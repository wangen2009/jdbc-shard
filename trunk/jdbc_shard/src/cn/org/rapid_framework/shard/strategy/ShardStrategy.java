package cn.org.rapid_framework.shard.strategy;

import org.isharding.shard.strategy.access.ShardAccessStrategy;
import org.isharding.shard.strategy.resolution.ShardResolutionStrategy;
import org.isharding.shard.strategy.selection.ShardSelectionStrategy;

public interface ShardStrategy {

    ShardSelectionStrategy getShardSelectionStrategy();
    
    /**
     * 确定当前如执行(增删改查)时要访问那一个shard
     * @return
     */
    ShardResolutionStrategy getShardResolutionStrategy();
    /**
     * 确定查询或访问shard时采用那种策略，是并发访问还是顺序访问
     * @return
     */
    ShardAccessStrategy getShardAccessStrategy(); 
}
