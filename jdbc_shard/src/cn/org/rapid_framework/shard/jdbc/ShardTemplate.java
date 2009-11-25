package cn.org.rapid_framework.shard.jdbc;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.org.rapid_framework.shard.Shard;
import cn.org.rapid_framework.shard.ShardConfig;
import cn.org.rapid_framework.shard.strategy.ShardStrategy;
import cn.org.rapid_framework.shard.strategy.exit.ConcatListExitStrategy;
import cn.org.rapid_framework.shard.strategy.exit.ExitOperationsCollector;

public class ShardTemplate {
    private ShardStrategy shardStrategy;
    private JdbcTemplate  jdbcTemplate;
    private ShardConfig   shardConfig;
    
	public int insert(Serializable obj,ShardCallback callback) {
		Shard shard = getShardForNewObject(obj);
		return (Integer)callback.doInShard(shard);
	}
	
	public int delete(Serializable obj,ShardCallback callback){
		Shard shard = getShardFromObject(obj);
		return (Integer)callback.doInShard(shard);
	}
	
	public int update(Serializable obj,ShardCallback callback){
		Shard shard = getShardFromObject(obj);
		return (Integer)callback.doInShard(shard);
	}

	public Object get(Serializable obj,ShardCallback callback) {
		Shard shard = getShardFromObject(obj);
		return (Integer)callback.doInShard(shard);
	}
	
	public List query(Serializable obj,ExitOperationsCollector exitOperationsCollector){
		List shards = getShardsForQuery(obj);
		shardStrategy.getShardAccessStrategy().apply(shards, operation, new ConcatListExitStrategy(), exitOperationsCollector);
		return null;
	}
	
	private List getShardsForQuery(Serializable obj) {
		return null;
	}

	private Shard getShardForNewObject(Object obj) {
		return null;
	}
	
	private Shard getShardFromObject(Object obj) {
		return null;
	}

}
