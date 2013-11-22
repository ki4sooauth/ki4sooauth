package com.test;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;

import org.apache.zookeeper.KeeperException;

import com.gooagoo.batch.entry.BaseZkOperator;

public class Test
{

    public static void main(String[] args)
    {
        try
        {
            BaseZkOperator zk = new BaseZkOperator();
            printNode("/root", "", zk);
            zk.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void printNode(String path, String pre, BaseZkOperator zk) throws KeeperException, InterruptedException
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

    private static void deleteNode(String path, String pre, BaseZkOperator zk) throws KeeperException, InterruptedException, UnsupportedEncodingException
    {
        List<String> list = zk.getChild(path);
        if (list == null || list.size() == 0)
        {
            zk.delete(path);
            System.out.println(pre + path);
            return;
        }
        for (String string : list)
        {
            deleteNode(path + "/" + string, pre + "--", zk);
        }
        zk.delete(path);
        System.out.println(pre + path);
    }
}
