package com.gooagoo.common.monitor;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;

import com.gooagoo.common.constants.ZookeeperConstants;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.HostUtils;
import com.gooagoo.common.zookeeper.AbstractZooKeeper;

public class MonitorUtils
{
    private String name = "mis";
    private String version = "mis";
    private MonitorZK zk = new MonitorZK("task.zk.goo.com");
    private String hostAddress = HostUtils.getHostAddress();

    public MonitorUtils(String name, String version)
    {
        this.name = name;
        this.version = version;
    }

    private class MonitorZK extends AbstractZooKeeper
    {
        MonitorZK(String host)
        {
            super(host);
        }

        @Override
        public void processWatcher(WatchedEvent arg0)
        {
            if (arg0.getState() == KeeperState.Disconnected || (arg0.getPath() == null && arg0.getState() == KeeperState.Expired))
            {
                GooagooLog.info("到【" + this.host + "】的连接已断开或已过期，进入重连状态");
                this.close();
                try
                {
                    this.connect();
                    MonitorUtils.this.monitorStart();
                }
                catch (Exception e)
                {
                    GooagooLog.error("重连异常", e);
                }
            }
        }

    }

    public void monitorStart()
    {
        try
        {
            String temp = ZookeeperConstants.APPLICATION_PATH;
            if (this.zk.zooKeeper.exists(temp, false) == null)
            {
                this.zk.zooKeeper.create(temp, null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            String result = this.zk.zooKeeper.create(temp + "/0", (this.name + "^" + this.hostAddress + "^" + this.version).getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            GooagooLog.info(result);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            countDownLatch.await();
        }
        catch (Exception e)
        {
            GooagooLog.error("启动监控异常", e);
        }
    }
}
