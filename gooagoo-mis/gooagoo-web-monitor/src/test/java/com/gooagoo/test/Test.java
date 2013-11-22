package com.gooagoo.test;

import java.util.Collections;
import java.util.List;

import org.apache.zookeeper.KeeperException;

import com.gooagoo.common.constants.ZookeeperConstants;
import com.gooagoo.monitor.zookeeper.MonitorZookeeper;

public class Test
{

    public static void main(String[] args)
    {
        try
        {
            MonitorZookeeper zookeeper = new MonitorZookeeper();
            //            printNode("/root/application", "", zookeeper);
            //            zookeeper.close();
            List<String> list = zookeeper.getChild(ZookeeperConstants.APPLICATION_PATH + "/core");
            for (String string : list)
            {
                System.out.println(string);
                System.out.println(zookeeper.getData(ZookeeperConstants.APPLICATION_PATH + "/core/" + string));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void printNode(String path, String pre, MonitorZookeeper zk) throws KeeperException, InterruptedException
    {
        List<String> list = zk.getChild(path);
        Collections.sort(list);
        if (list == null || list.size() == 0)
        {
            return;
        }
        for (String string : list)
        {
            System.out.println(pre + path + "/" + string);
            printNode(path + "/" + string, pre + "--", zk);
        }
    }
}
