package cn.org.rapid_framework.shard.strategy;

import org.isharding.shard.strategy.access.ShardAccessStrategy;
import org.isharding.shard.strategy.resolution.ShardResolutionStrategy;
import org.isharding.shard.strategy.selection.ShardSelectionStrategy;

public interface ShardStrategy {

    ShardSelectionStrategy getShardSelectionStrategy();
    
    /**
     * ȷ����ǰ��ִ��(��ɾ�Ĳ�)ʱҪ������һ��shard
     * @return
     */
    ShardResolutionStrategy getShardResolutionStrategy();
    /**
     * ȷ����ѯ�����shardʱ�������ֲ��ԣ��ǲ������ʻ���˳�����
     * @return
     */
    ShardAccessStrategy getShardAccessStrategy(); 
}
