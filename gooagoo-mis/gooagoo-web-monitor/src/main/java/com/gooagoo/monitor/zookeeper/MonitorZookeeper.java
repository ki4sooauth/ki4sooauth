package com.gooagoo.monitor.zookeeper;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;

import com.gooagoo.common.zookeeper.AbstractZooKeeper;

public class MonitorZookeeper extends AbstractZooKeeper
{
    public MonitorZookeeper()
    {
        super("task.zk.goo.com");
    }

    /**
     * 列出节点下的子节点，不监听
     * @param path  节点路径
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public List<String> getChild(String path) throws KeeperException, InterruptedException
    {
        return this.zooKeeper.getChildren(path, false);
    }

    /**
     * 获取节点数据，不监听
     * @param path  节点路径
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     * @throws UnsupportedEncodingException 
     */
    public String getData(String path) throws KeeperException, InterruptedException, UnsupportedEncodingException
    {
        byte[] bb = this.zooKeeper.getData(path, false, null);
        if (bb == null)
        {
            return null;
        }
        else
        {
            return new String(bb, CHARACTER_SET_ENCODING);
        }
    }

    @Override
    public void processWatcher(WatchedEvent arg0)
    {
    }

}
