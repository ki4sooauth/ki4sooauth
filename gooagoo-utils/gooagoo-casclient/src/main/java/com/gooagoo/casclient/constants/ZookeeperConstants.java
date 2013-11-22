package com.gooagoo.casclient.constants;

import java.util.ArrayList;
import java.util.List;

import com.gooagoo.casclient.enums.ZKCache;
import com.gooagoo.casclient.enums.ZKSerial;

public final class ZookeeperConstants
{

    final public static String DOMAIN_PATH = "/root/domain";//域名
    final public static String CACHE_PATH = "/root/cache";//缓存
    final public static String TASK_PATH = "/root/task";//任务
    final public static String SERIAL_PATH = "/root/serial";//序列号

    final private static List<String> CACHE_KEY = new ArrayList<String>();
    final private static List<String> CACHE_DATA_NODE = new ArrayList<String>();
    final private static List<String> CACHE_VERSION_NODE = new ArrayList<String>();
    final private static List<String> CACHE_ALL_NODE = new ArrayList<String>();

    final private static List<String> SERIAL_KEY = new ArrayList<String>();
    final private static List<String> SERIAL_NODE = new ArrayList<String>();

    static
    {
        for (ZKCache zkCache : ZKCache.values())
        {
            CACHE_KEY.add(zkCache.toString());
        }

        CACHE_ALL_NODE.add("/root");
        CACHE_ALL_NODE.add(CACHE_PATH);

        for (String string : CACHE_KEY)
        {
            CACHE_DATA_NODE.add(getDataPathByKey(string));
            CACHE_VERSION_NODE.add(getVersionPathByKey(string));
            CACHE_ALL_NODE.add(getFullPathByKey(string));
            CACHE_ALL_NODE.add(getDataPathByKey(string));
            CACHE_ALL_NODE.add(getVersionPathByKey(string));
        }

        for (ZKSerial zkSerial : ZKSerial.values())
        {
            SERIAL_KEY.add(zkSerial.toString());
        }
        for (String string : SERIAL_KEY)
        {
            SERIAL_NODE.add(SERIAL_PATH + "/" + string);
        }
    }

    public static List<String> getSerialKey()
    {
        return SERIAL_KEY;
    }

    public static List<String> getSerialNode()
    {
        return SERIAL_NODE;
    }

    public static List<String> getCacheKey()
    {
        return CACHE_KEY;
    }

    public static List<String> getCacheDataNode()
    {
        return CACHE_DATA_NODE;
    }

    public static List<String> getCacheVersionNode()
    {
        return CACHE_VERSION_NODE;
    }

    public static List<String> getCacheAllNode()
    {
        return CACHE_ALL_NODE;
    }

    public static String getDataPathByKey(String key)
    {
        return CACHE_PATH + "/" + key + "/data";
    }

    public static String getVersionPathByKey(String key)
    {
        return CACHE_PATH + "/" + key + "/version";
    }

    public static String getFullPathByKey(String key)
    {
        return CACHE_PATH + "/" + key;
    }
}
