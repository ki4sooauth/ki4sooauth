package com.gooagoo.analysis.init;

import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;

import com.gooagoo.common.constants.ZookeeperConstants;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.DataUtils;
import com.gooagoo.common.zookeeper.AbstractZooKeeper;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.marketing.RuleResult;

public class RuleZookeeper extends AbstractZooKeeper
{

    public RuleZookeeper()
    {
        super();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void processWatcher(WatchedEvent watchedEvent)
    {
        try
        {

            if ((watchedEvent.getState() == KeeperState.SyncConnected && watchedEvent.getType() == EventType.None) || (watchedEvent.getPath() == null && watchedEvent.getState() == KeeperState.Expired))
            {
                this.init();
            }
            if (watchedEvent.getPath() != null && watchedEvent.getState() == KeeperState.SyncConnected && watchedEvent.getType() == EventType.NodeDataChanged)
            {
                byte[] data = this.zooKeeper.getData(watchedEvent.getPath(), true, null);
                if (watchedEvent.getPath().equals(ZookeeperConstants.getDataPathByKey("ruleInfoCache")))
                {
                    PretreatmentRule.setPretreatmentRule((List<RuleInfo>) DataUtils.unserialize(data));
                    MatchRule.setMatchRule((List<RuleInfo>) DataUtils.unserialize(data));
                }
                else if (watchedEvent.getPath().equals(ZookeeperConstants.getDataPathByKey("ruleResultCache")))
                {
                    ResultRule.setRuleResult((List<RuleResult>) DataUtils.unserialize(data));
                }
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("ZooKeeper监听异常", e);
            this.close();
        }
    }

    @SuppressWarnings("unchecked")
    public void init() throws KeeperException, InterruptedException
    {
        byte[] data = this.zooKeeper.getData(ZookeeperConstants.getDataPathByKey("ruleInfoCache"), true, null);
        List<RuleInfo> ruleInfoList = (List<RuleInfo>) DataUtils.unserialize(data);
        data = this.zooKeeper.getData(ZookeeperConstants.getDataPathByKey("ruleResultCache"), true, null);
        List<RuleResult> ruleResultList = (List<RuleResult>) DataUtils.unserialize(data);
        PretreatmentRule.setPretreatmentRule(ruleInfoList);
        MatchRule.setMatchRule(ruleInfoList);
        ResultRule.setRuleResult(ruleResultList);
    }

    public static void main(String[] args) throws KeeperException, InterruptedException
    {
        RuleZookeeper zk = new RuleZookeeper();
        zk.init();
        zk.close();
    }
}
