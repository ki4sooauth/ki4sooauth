package com.gooagoo.batch.zookeeper;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;

import com.gooagoo.batch.BatchEntry;
import com.gooagoo.batch.GooagooJob;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.zookeeper.AbstractZooKeeper;

public class BatchZkOperator extends AbstractZooKeeper
{
    public BatchZkOperator()
    {
        super();
    }

    public BatchZkOperator(String host)
    {
        super(host);
    }

    @Override
    public void processWatcher(WatchedEvent arg0)
    {
        try
        {
            if (arg0.getState() == KeeperState.Disconnected)
            {
                GooagooJob.isConnected = false;
                GooagooLog.warn("【" + BatchEntry.ip + ":" + BatchEntry.alias + "】---到【" + this.host + "】的连接已断开");
                return;
            }
            if (arg0.getPath() == null && arg0.getState() == KeeperState.Expired)
            {
                GooagooLog.info("【" + BatchEntry.ip + ":" + BatchEntry.alias + "】---到【" + this.host + "】的连接已过期，进入重连状态");
                this.close();
                this.connect();
                BatchEntry.checkJob();
            }
            if (arg0.getState() == KeeperState.SyncConnected && !GooagooJob.isConnected)
            {
                GooagooJob.isConnected = true;
            }
            if (arg0.getPath() != null && arg0.getState() == KeeperState.SyncConnected)
            {
                this.exists(arg0.getPath());
                if (arg0.getType() == EventType.NodeChildrenChanged)
                {
                    List<String> list = this.getChild(arg0.getPath());
                    Collections.sort(list);
                    if (list != null && list.size() > 0)
                    {
                        String min = arg0.getPath() + "/" + list.get(0);
                        String cur = GooagooJob.getJob(arg0.getPath());
                        if (min.equals(cur))
                        {
                            GooagooJob.add(arg0.getPath(), true);
                            GooagooLog.info("【" + BatchEntry.ip + ":" + BatchEntry.alias + "】---服务器集群状态发生变化，本服务器为主任务执行服务器，主任务路径" + min);
                        }
                        else
                        {
                            GooagooJob.add(arg0.getPath(), false);
                            GooagooLog.info("【" + BatchEntry.ip + ":" + BatchEntry.alias + "】---服务器集群状态发生变化，本服务器为从任务执行服务器，从任务路径" + cur + "，主任务路径" + min);
                        }
                    }
                }
                else if (arg0.getType() == EventType.NodeDataChanged)
                {
                    GooagooLog.info("【" + BatchEntry.ip + ":" + BatchEntry.alias + "】---关闭服务器");
                    this.close();
                    System.exit(0);
                }
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("【" + BatchEntry.ip + ":" + BatchEntry.alias + "】---处理监听异常", e);
        }
    }

    /**
     * 创建临时自动编号节点
     * @param path  节点路径
     * @param data  要保存在节点中的数据
     * @throws KeeperException
     * @throws InterruptedException
     * @throws UnsupportedEncodingException 
     */

    public String createEphemeralSequentialPath(String path, String data) throws KeeperException, InterruptedException, UnsupportedEncodingException
    {
        return this.zooKeeper.create(path, data.getBytes(CHARACTER_SET_ENCODING), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
    }

    /**
     * 创建持久化的节点
     * @param path  节点路径
     * @param data  要保存在节点中的数据
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     * @throws UnsupportedEncodingException
     */
    public String createPersistentPath(String path, String data) throws KeeperException, InterruptedException, UnsupportedEncodingException
    {
        return this.zooKeeper.create(path, data.getBytes(CHARACTER_SET_ENCODING), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
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
            return new String(bb, CHARACTER_SET_ENCODING);
        }
    }

    /**
     * 
     * @param path
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public Stat exists(String path) throws KeeperException, InterruptedException
    {
        return this.zooKeeper.exists(path, true);
    }

    /**
     * 列出节点下的子节点，并设置继续监听
     * @param path  节点路径
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public List<String> getChild(String path) throws KeeperException, InterruptedException
    {
        return this.zooKeeper.getChildren(path, true);
    }

    /**
     * 给节点设置数据
     * @param path  节点路径
     * @param data  数据
     * @throws KeeperException
     * @throws InterruptedException
     * @throws UnsupportedEncodingException
     */
    public void setData(String path, String data) throws KeeperException, InterruptedException, UnsupportedEncodingException
    {
        this.zooKeeper.setData(path, data.getBytes(CHARACTER_SET_ENCODING), -1);
    }

    /**
     * 删除节点
     * @param path  节点路径
     * @throws KeeperException
     * @throws InterruptedException
     * @throws UnsupportedEncodingException
     */
    public void delete(String path) throws KeeperException, InterruptedException, UnsupportedEncodingException
    {
        this.zooKeeper.delete(path, -1);
    }
}
