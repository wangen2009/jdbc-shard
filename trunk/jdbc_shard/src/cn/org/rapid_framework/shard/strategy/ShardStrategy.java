package cn.org.rapid_framework.shard.strategy;

import cn.org.rapid_framework.shard.strategy.access.ShardAccessStrategy;
import cn.org.rapid_framework.shard.strategy.selection.ShardSelectionStrategy;


public interface ShardStrategy {

    /**
     * ȷ����ǰ��ִ��(��ɾ�Ĳ�)ʱҪ������һ��shard
     * @return
     */
    ShardSelectionStrategy getShardSelectionStrategy();
    
//    ShardResolutionStrategy getShardResolutionStrategy();
    /**
     * ȷ����ѯ�����shardʱ�������ֲ��ԣ��ǲ������ʻ���˳�����
     * @return
     */
    ShardAccessStrategy getShardAccessStrategy(); 
}
