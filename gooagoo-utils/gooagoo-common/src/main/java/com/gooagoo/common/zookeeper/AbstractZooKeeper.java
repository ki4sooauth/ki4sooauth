package com.gooagoo.common.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

import com.gooagoo.common.log.GooagooLog;

public abstract class AbstractZooKeeper implements Watcher
{
    public static final int SESSION_TIME = 2000;
    public static final String CHARACTER_SET_ENCODING = "UTF-8";
    public String host = "cache.zk.goo.com";
    public ZooKeeper zooKeeper;
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public AbstractZooKeeper()
    {
        try
        {
            this.connect();
        }
        catch (Exception e)
        {
            GooagooLog.error("初始化到【" + this.host + "】的连接失败", e);
        }
    }

    public AbstractZooKeeper(String host)
    {
        this.host = host;
        try
        {
            this.connect();
        }
        catch (Exception e)
        {
            GooagooLog.error("初始化到【" + this.host + "】的连接失败", e);
        }
    }

    public void connect() throws IOException, InterruptedException
    {
        this.countDownLatch = new CountDownLatch(1);
        long start = System.currentTimeMillis();
        this.zooKeeper = new ZooKeeper(this.host, SESSION_TIME, this);
        this.countDownLatch.await();
        long end = System.currentTimeMillis();
        GooagooLog.info("建立到【" + this.host + "】的zookeeper连接，耗时" + (end - start) + "毫秒");
    }

    public void close()
    {
        try
        {
            if (this.zooKeeper != null)
            {
                this.zooKeeper.close();
                this.zooKeeper = null;
            }
            GooagooLog.info("关闭到【" + this.host + "】的zookeeper连接");
        }
        catch (Exception e)
        {
            GooagooLog.error("关闭到【" + this.host + "】的zookeeper连接异常", e);
        }
    }

    @Override
    public final void process(WatchedEvent arg0)
    {
        GooagooLog.info("监听到【" + this.host + "】：" + arg0.getPath() + "^" + arg0.getState() + "^" + arg0.getType());
        if (arg0.getState() == KeeperState.SyncConnected && this.countDownLatch.getCount() == 1)
        {
            this.countDownLatch.countDown();
        }
        this.processWatcher(arg0);
    }

    /**
     * 实现zookeeper的监听
     * @param arg0
     */
    public abstract void processWatcher(WatchedEvent arg0);
}
