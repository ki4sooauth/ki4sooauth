package com.gooagoo.cache;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.gooagoo.cache.log.CacheLog;

public class SysdictionaryCache
{
    private static Map<String, Map<String, String>> map = new LinkedHashMap<String, Map<String, String>>();

    public static void reload(Map<String, List<String>> map2)
    {
        try
        {
            map.clear();
            for (Iterator<?> iterator = map2.entrySet().iterator(); iterator.hasNext();)
            {
                @SuppressWarnings("unchecked")
                Entry<String, List<String>> it = (Entry<String, List<String>>) iterator.next();
                String type = it.getValue().get(0);
                if (!map.containsKey(type))
                {
                    map.put(type, new LinkedHashMap<String, String>());
                }
                map.get(type).put(it.getValue().get(1), it.getValue().get(2));
            }
        }
        catch (Exception e)
        {
            CacheLog.error("同步字典表缓存异常", e);
        }
    }

    public static String get(String dictionaryType, String englishName)
    {
        Map<String, String> first = map.get(dictionaryType);
        if (first != null)
        {
            return first.get(englishName);
        }
        return null;
    }

    public static Map<String, String> get(String dictionaryType)
    {
        return map.get(dictionaryType);
    }
}
