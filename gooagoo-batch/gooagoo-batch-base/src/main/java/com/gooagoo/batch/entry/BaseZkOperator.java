package com.gooagoo.batch.entry;

import java.io.UnsupportedEncodingException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;

import com.gooagoo.batch.zookeeper.BatchZkOperator;
import com.gooagoo.common.constants.ZookeeperConstants;

public class BaseZkOperator extends BatchZkOperator
{

    public BaseZkOperator()
    {
        super();
    }

    public BaseZkOperator(String host)
    {
        super(host);
    }

    @Override
    public Stat exists(String path) throws KeeperException, InterruptedException
    {
        return this.zooKeeper.exists(path, null);
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

    public String getVersion(String key) throws UnsupportedEncodingException, KeeperException, InterruptedException
    {
        return this.getData(ZookeeperConstants.getVersionPathByKey(key), false);
    }

    public void setData(String key, String version, String data) throws UnsupportedEncodingException, KeeperException, InterruptedException
    {
        this.setData(ZookeeperConstants.getVersionPathByKey(key), version);
        this.setData(ZookeeperConstants.getDataPathByKey(key), data);
    }

    public void setData(String key, String version, byte[] data) throws UnsupportedEncodingException, KeeperException, InterruptedException
    {
        this.setData(ZookeeperConstants.getVersionPathByKey(key), version);
        this.setData(ZookeeperConstants.getDataPathByKey(key), data);
    }

    public void setData(String path, byte[] data) throws KeeperException, InterruptedException, UnsupportedEncodingException
    {
        this.zooKeeper.setData(path, data, -1);
    }

    /**
     * 获取节点数据
     * @param path  节点路径
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     * @throws UnsupportedEncodingException 
     */
    public String getData(String path, boolean flag) throws KeeperException, InterruptedException, UnsupportedEncodingException
    {
        byte[] bb = this.zooKeeper.getData(path, flag, null);
        if (bb == null)
        {
            return null;
        }
        else
        {
            return new String(bb, CHARACTER_SET_ENCODING);
        }
    }
}
