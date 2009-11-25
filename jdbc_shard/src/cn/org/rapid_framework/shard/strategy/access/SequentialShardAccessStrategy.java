package cn.org.rapid_framework.shard.strategy.access;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.org.rapid_framework.shard.Shard;
import cn.org.rapid_framework.shard.strategy.exit.ExitOperationsCollector;
import cn.org.rapid_framework.shard.strategy.exit.ExitStrategy;



public class SequentialShardAccessStrategy implements ShardAccessStrategy {

    private final Log log = LogFactory.getLog(getClass());

    public <T> T apply(List<Shard> shards, ShardOperation operation, ExitStrategy<T> exitStrategy,ExitOperationsCollector exitOperationsCollector) {
        for (Shard shard : shards) {
            if (exitStrategy.addResult((T)operation.execute(shard), shard)) {
                if (log.isDebugEnabled()) {
                    log.debug(String.format("Short-circuiting operation %s after execution against shard %s", operation
                            .getOperationName(), shard));
                }
                break;
            }
        }
        return (T)exitStrategy.compileResults(exitOperationsCollector);
    }

    public Object apply(List<Shard> shards, ShardOperation operation, ExitStrategy exitStrategy) {
        if (log.isDebugEnabled()){
            log.debug(String.format("Executing %s on %d shards.",operation.getOperationName(),shards.size()));
        }
        return this.apply(shards, operation, exitStrategy, null);
    }


}
