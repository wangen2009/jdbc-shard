package cn.org.rapid_framework.shard.jdbc;

import cn.org.rapid_framework.shard.Shard;

public interface ShardCallback {
	
	public Object doInShard(Shard shard);
	
}
