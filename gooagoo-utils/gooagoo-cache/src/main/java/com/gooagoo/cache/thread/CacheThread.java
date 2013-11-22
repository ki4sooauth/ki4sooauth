package com.gooagoo.cache.thread;

import java.util.concurrent.CountDownLatch;

import com.gooagoo.cache.log.CacheLog;
import com.gooagoo.cache.zookeeper.CacheZooKeeper;

public class CacheThread extends Thread
{
    @Override
    public void run()
    {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try
        {
            CacheZooKeeper zk = new CacheZooKeeper();
            zk.connect();
            zk.init();
            countDownLatch.await();
            zk.close();
        }
        catch (Exception e)
        {
            CacheLog.error("加载缓存异常", e);
        }
    }
}
