package cn.org.rapid_framework.shard.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.org.rapid_framework.shard.Shard;
import cn.org.rapid_framework.shard.ShardConfig;
import cn.org.rapid_framework.shard.ShardId;
import cn.org.rapid_framework.shard.strategy.ShardStrategy;

/**
 * 为jdbc提供sharding支持，目前不支持transaction
 * 
 * 目前不支持求平均数，group by等需要所有节点支持的操作
 * 
 * 推荐使用时能将每次查询只分布在唯一的节点
 * 
 * @author <a href="mailto:kerrigan@alibaba-inc.com">Argan Wang</a>
 * 
 */
public class ShardedSqlMapClientDAOSupport extends ShardedJdbcDaoSupport {

    private ShardStrategy shardStrategy;
    private JdbcTemplate  jdbcTemplate;
    private ShardConfig   shardConfig;

//    /**
//     * Return the SqlMapClientTemplate for this DAO, pre-initialized with the
//     * SqlMapClient or set explicitly.
//     */
//    public final Operations getSqlMapClientTemplate(ShardResolutionStrategyData data) {
//        List<ShardId> shardIds = this.shardStrategy.getShardResolutionStrategy()
//                .selectShardIdsFromShardResolutionStrategyData(data);
//        List<Shard> shards = selectShardsByShardIds(shardIds);
//        if (shards.size() <= 0) {
//            throw new RuntimeException("No shard can be selected to execute.");
//        }
//        return new ShardedSqlMapClientTemplate(this.shardStrategy.getShardAccessStrategy(), shards, this.sqlMapClient);
//    }

    private List<Shard> selectShardsByShardIds(List<ShardId> shardIds) {
        List<Shard> list = new ArrayList<Shard>(this.shardConfig.getAllShards().size());
        for (Shard shard : this.shardConfig.getAllShards()) {
            for (ShardId shardId : shardIds) {
                if (shard.getShardIds().contains(shardId) && list.contains(shard) == false) {
                    list.add(shard);
                }
            }
        }
        if (list.size() > 0) {
            if (logger.isDebugEnabled()) {
                logger.debug(String.format("selected shards : %s ", list.toString()));
            }
        } else {
            if (this.shardConfig.getDefaultShard() != null) {
                list.add(this.shardConfig.getDefaultShard());

                if (logger.isDebugEnabled()) {
                    logger.debug("No shard selected ,use defaultShard.");
                }
            } else {
                logger.error("No shard selected and no defaultShard configed.");
            }
        }
        return list;
    }

    protected final void checkDaoConfig() {
        if (this.shardConfig == null) {
            throw new RuntimeException("No shard config specified.");
        }
        for (Shard shard : this.shardConfig.getAllShards()) {
            if (shard.getDataSource() == null) {
                throw new RuntimeException("No dataSource configured for shard.");
            }
        }
    }

    public List<Shard> getShards() {
        return this.shardConfig.getAllShards();
    }

    public void setShardConfig(ShardConfig shardConfig) {
        this.shardConfig = shardConfig;
    }

    public void setShardStrategy(ShardStrategy shardStrategy) {
        this.shardStrategy = shardStrategy;
    }

}
