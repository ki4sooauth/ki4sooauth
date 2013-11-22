package com.gooagoo.cache;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.gooagoo.cache.entity.InterfaceBaseInfo;
import com.gooagoo.cache.log.CacheLog;

/**
 * 接口信息缓存
 * 如果部署在gooagoo平台，则缓存的是系统基础接口
 * 如果部署在商家端，则缓存的是分配给商家的基础接口
 * @author frenn
 *
 */
public class InterfaceCache
{

    private static Map<String, InterfaceBaseInfo> map = new LinkedHashMap<String, InterfaceBaseInfo>();

    /**
     * 重新加载数据
     */
    public static void reload(Map<String, List<String>> map2)
    {
        try
        {
            map.clear();
            for (Iterator<?> iterator = map2.entrySet().iterator(); iterator.hasNext();)
            {
                @SuppressWarnings("unchecked")
                Entry<String, List<String>> it = (Entry<String, List<String>>) iterator.next();
                InterfaceBaseInfo info = new InterfaceBaseInfo();
                info.setICode(it.getKey());
                info.setIName(it.getValue().get(0));
                info.setIUrl(it.getValue().get(1));
                info.setBehaveType(it.getValue().get(2));
                map.put(it.getKey(), info);
            }
        }
        catch (Exception e)
        {
            CacheLog.error("同步接口缓存异常", e);
        }
    }

    /**
     * 根据key值获取value
     * @param key
     * @return
     */
    public static InterfaceBaseInfo get(String key)
    {
        return map.get(key);
    }
}
