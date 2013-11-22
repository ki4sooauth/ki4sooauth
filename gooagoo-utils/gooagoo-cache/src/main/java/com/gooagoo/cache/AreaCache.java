package com.gooagoo.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 省市县缓存
 * @author frenn
 *
 */
public final class AreaCache
{
    protected static Map<String, String> self = new LinkedHashMap<String, String>();
    protected static Map<String, Map<String, String>> next = new LinkedHashMap<String, Map<String, String>>();

    public static String getSelf(String key)
    {
        return self.get(key);
    }

    public static Map<String, String> getNext(String key)
    {
        return next.get(key);
    }

    /**
     * 获取所有的省
     * 也可以用getNext("-1")
     * @return
     */
    public static Map<String, String> getProvince()
    {
        return next.get("-1");
    }
}
