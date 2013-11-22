package com.gooagoo.position.rule;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;

import com.gooagoo.common.zookeeper.AbstractZooKeeper;
import com.gooagoo.position.log.PositionEngineLog;

public class RuleZookeeper extends AbstractZooKeeper
{

    public RuleZookeeper(String host)
    {
        super(host);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void processWatcher(WatchedEvent arg0)
    {
        try
        {
            if (arg0.getPath() != null && arg0.getState() == KeeperState.SyncConnected)
            {
                if (arg0.getType() == EventType.NodeChildrenChanged)
                {
                    if ("".equals(arg0.getPath()))
                    {
                        byte[] data = this.zooKeeper.getData("", true, null);
                        DurationRule.readRule(new String(data));
                    }

                }
            }
        }
        catch (Exception e)
        {
            PositionEngineLog.error("处理监听异常", e);
        }
    }

}
