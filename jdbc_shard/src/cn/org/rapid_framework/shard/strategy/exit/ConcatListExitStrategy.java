package cn.org.rapid_framework.shard.strategy.exit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.org.rapid_framework.shard.Shard;


/**
 * ��List��������кϲ����˳�����
 * @author <a href="mailto:kerrigan@alibaba-inc.com">Argan Wang</a>
 *
 */
public class ConcatListExitStrategy implements ExitStrategy {
    @SuppressWarnings("unchecked")
    private Map<Shard, List> resultMap = new HashMap<Shard, List>();

    public ConcatListExitStrategy() {
    }

    @SuppressWarnings("unchecked")
    public boolean addResult(Object obj, Shard shard) {
        if (obj instanceof List) {
            this.resultMap.put(shard, (List) obj);
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public List compileResults(ExitOperationsCollector exitOperationsCollector) {
        List result = new ArrayList();
        for (List tmp : resultMap.values()) {
            result.addAll(tmp);
        }
        return result;
    }

}
