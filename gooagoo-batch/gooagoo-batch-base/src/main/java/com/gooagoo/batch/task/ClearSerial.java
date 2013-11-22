package com.gooagoo.batch.task;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.springframework.stereotype.Service;

import com.gooagoo.batch.zookeeper.BatchZkOperator;
import com.gooagoo.common.constants.ZookeeperConstants;
import com.gooagoo.common.log.GooagooLog;

@Service
public class ClearSerial
{

    public void run()
    {
        BatchZkOperator zk = null;
        try
        {
            zk = new BatchZkOperator("serial.zk.goo.com");
            clearSerial(zk);
        }
        catch (Exception e)
        {
            GooagooLog.error("清理序列号异常", e);
        }
        finally
        {
            zk.close();
        }
    }

    private static void clearSerial(BatchZkOperator zk) throws KeeperException, InterruptedException, UnsupportedEncodingException
    {
        //清除根目录
        List<String> list = zk.zooKeeper.getChildren(ZookeeperConstants.SERIAL_PATH, false);
        Collections.sort(list);
        for (String string : list)
        {
            if (ZookeeperConstants.getSerialKey().contains(string))
            {
                continue;
            }
            else
            {
                deleteNode(ZookeeperConstants.SERIAL_PATH + "/" + string, zk);
            }
        }
        //清除最大节点外的所有节点
        for (String string : ZookeeperConstants.getSerialNode())
        {
            clearOhter(string, zk);
        }
    }

    private static void clearOhter(String path, BatchZkOperator zk) throws KeeperException, InterruptedException, UnsupportedEncodingException
    {
        List<String> list = zk.zooKeeper.getChildren(path, false);
        Collections.sort(list);
        for (int i = 0; i < list.size() - 1; i++)
        {
            deleteNode(path + "/" + list.get(i), zk);
        }
        String temp = path + "/" + list.get(list.size() - 1);
        list.clear();
        list = zk.zooKeeper.getChildren(temp, false);
        if (list != null && list.size() > 1)
        {
            clearOhter(temp, zk);
        }
    }

    private static void deleteNode(String path, BatchZkOperator zk) throws KeeperException, InterruptedException, UnsupportedEncodingException
    {
        List<String> list = zk.zooKeeper.getChildren(path, false);
        Collections.sort(list);
        if (list == null || list.size() == 0)
        {
            zk.delete(path);
            GooagooLog.info("删除节点" + path);
            return;
        }
        for (String string : list)
        {
            deleteNode(path + "/" + string, zk);
        }
        zk.delete(path);
        GooagooLog.info("删除节点" + path);
    }

    public static void main(String[] args)
    {
        ClearSerial clearSerial = new ClearSerial();
        clearSerial.run();
    }
}
