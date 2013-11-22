package com.gooagoo.cache.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.gooagoo.cache.entity.DicImageCache;
import com.gooagoo.cache.log.CacheLog;

public class CacheUtils
{
    public static void loadMap(Map<String, List<String>> map, Map<String, String> self, Map<String, Map<String, String>> next)
    {
        self.clear();
        next.clear();
        for (Iterator<?> iterator = map.entrySet().iterator(); iterator.hasNext();)
        {
            @SuppressWarnings("unchecked")
            Entry<String, List<String>> it = (Entry<String, List<String>>) iterator.next();
            List<String> list = it.getValue();
            self.put(it.getKey(), list.get(0));
            if (!next.containsKey(list.get(1)))
            {
                next.put(list.get(1), new LinkedHashMap<String, String>());
            }
            next.get(list.get(1)).put(it.getKey(), list.get(0));
        }
    }

    public static void load(Map<String, List<String>> map, Map<String, DicImageCache> self, Map<String, List<DicImageCache>> next)
    {
        self.clear();
        next.clear();
        for (Iterator<?> iterator = map.entrySet().iterator(); iterator.hasNext();)
        {
            @SuppressWarnings("unchecked")
            Entry<String, List<String>> it = (Entry<String, List<String>>) iterator.next();
            List<String> list = it.getValue();
            DicImageCache cache2 = new DicImageCache();
            cache2.setId(it.getKey());
            cache2.setName(list.get(1));
            cache2.setFrontPic(list.get(2));
            cache2.setBackPic(list.get(3));
            cache2.setParentId(list.get(0));

            self.put(it.getKey(), cache2);
            if (!next.containsKey(list.get(0)))
            {
                next.put(list.get(0), new ArrayList<DicImageCache>());
            }
            next.get(list.get(0)).add(cache2);
        }
    }

    /**
     * 反序列化
     * @param bytes
     * @return
     */
    public static Object unserialize(byte[] bytes)
    {
        ObjectInputStream ois = null;
        ByteArrayInputStream bais = null;
        try
        {
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            return ois.readObject();
        }
        catch (Exception e)
        {
            CacheLog.error("反序列化异常", e);
            return null;
        }
        finally
        {
            if (ois != null)
            {
                try
                {
                    ois.close();
                }
                catch (IOException e)
                {
                    CacheLog.error("反序列化关闭ois异常", e);
                }
            }
            if (bais != null)
            {
                try
                {
                    bais.close();
                }
                catch (IOException e)
                {
                    CacheLog.error("反序列化关闭bais异常", e);
                }
            }
        }
    }
}
