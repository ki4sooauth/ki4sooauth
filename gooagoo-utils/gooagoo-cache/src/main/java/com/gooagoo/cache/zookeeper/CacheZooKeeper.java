package com.gooagoo.cache.zookeeper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import com.gooagoo.cache.CacheLoad;
import com.gooagoo.cache.log.CacheLog;
import com.gooagoo.cache.utils.CacheUtils;

public class CacheZooKeeper implements Watcher
{
    private static final int SESSION_TIME = 2000;
    private static final String host = "cache.zk.goo.com";
    protected ZooKeeper zooKeeper;
    protected CountDownLatch countDownLatch = new CountDownLatch(1);

    public void connect() throws IOException, InterruptedException
    {
        this.zooKeeper = new ZooKeeper(host, SESSION_TIME, this);
        this.countDownLatch.await();
    }

    public void close() throws InterruptedException
    {
        this.zooKeeper.close();
    }

    @Override
    public void process(WatchedEvent arg0)
    {
        CacheLog.info("监听到【" + host + "】：" + arg0.getPath() + "^" + arg0.getState() + "^" + arg0.getType());
        if (arg0.getState() == KeeperState.SyncConnected && this.countDownLatch.getCount() == 1)
        {
            this.countDownLatch.countDown();
        }
        if (arg0.getPath() == null && arg0.getState() == KeeperState.Expired)
        {
            try
            {
                CacheLog.info("到【" + host + "】的连接已过期");
                this.close();
                this.connect();
                this.init();
            }
            catch (Exception e)
            {
                CacheLog.error("重连异常", e);
            }
        }
        String path = arg0.getPath();
        try
        {
            if (path != null && arg0.getState() == KeeperState.SyncConnected && arg0.getType() == EventType.NodeDataChanged)
            {
                CacheLog.debug("节点[" + path + "]的数据有更新");
                CacheLoad.load(path, this.zooKeeper.getData(path, true, null));
            }
        }
        catch (Exception e)
        {
            CacheLog.error("处理节点失败" + path, e);
        }
    }

    public static Map<String, String> version = new HashMap<String, String>();

    /**
     * 结构：
     * root/areaCache/version
     * root/areaCache/data
     */

    /**
     * 初始化
     * @throws InterruptedException 
     * @throws KeeperException 
     * @throws UnsupportedEncodingException 
     */
    public void init() throws KeeperException, InterruptedException, UnsupportedEncodingException
    {
        ResourceBundle rb = ResourceBundle.getBundle("cacheConfig");
        Enumeration<String> en = rb.getKeys();
        String key = null;
        while (en.hasMoreElements())
        {
            String string = en.nextElement();
            key = lowerFirstLetter(string);
            if ("Y".equals(rb.getString(string)))
            {
                //读取数据
                CacheLoad.load(key, CacheUtils.unserialize(this.zooKeeper.getData("/root/cache/" + key + "/data", true, null)));
            }
        }
    }

    /**
     * 首字母小写
     * @param src   字符串
     * @return      首字母小写后的字符串
     */
    private static String lowerFirstLetter(String src)
    {
        return src.substring(0, 1).toLowerCase() + src.substring(1);
    }

    /**
     * 创建节点
     * @param path
     * @param data
     * @throws KeeperException
     * @throws InterruptedException
     */

    public void create(String path, byte[] data) throws KeeperException, InterruptedException
    {
        /** 
         * 此处采用的是CreateMode是PERSISTENT  表示The znode will not be automatically deleted upon client's disconnect. 
         * EPHEMERAL 表示The znode will be deleted upon the client's disconnect. 
         */
        this.zooKeeper.create(path, data, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    /**
     * 获取节点数据
     * @param path  节点路径
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     * @throws UnsupportedEncodingException 
     */
    public String getData(String path) throws KeeperException, InterruptedException, UnsupportedEncodingException
    {
        byte[] bb = this.zooKeeper.getData(path, true, null);
        if (bb == null)
        {
            return null;
        }
        else
        {
            return new String(bb, "utf-8");
        }
    }

    public Stat exists(String path) throws KeeperException, InterruptedException
    {
        return this.zooKeeper.exists(path, false);
    }

    public List<String> getChild(String path) throws KeeperException, InterruptedException
    {
        return this.zooKeeper.getChildren(path, false);
    }
}
