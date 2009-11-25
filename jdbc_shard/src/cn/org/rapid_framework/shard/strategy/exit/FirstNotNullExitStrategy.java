package cn.org.rapid_framework.shard.strategy.exit;

import cn.org.rapid_framework.shard.Shard;


/**
 * ��ȡ��һ����null������˳����ԣ���Ҫ������shars�в�ѯһ����¼��ʹ��
 * @author <a href="mailto:kerrigan@alibaba-inc.com">Argan Wang</a>
 *
 */
public class FirstNotNullExitStrategy implements ExitStrategy {

    private Object result;

    public boolean addResult(Object result, Shard shard) {
        if (result != null) {
            this.result = result;
            return true;
        }
        return false;
    }

    public Object compileResults(ExitOperationsCollector exitOperationsCollector) {
        return this.result;
    }

}
