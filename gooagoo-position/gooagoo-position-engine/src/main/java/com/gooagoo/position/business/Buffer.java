package com.gooagoo.position.business;

import java.util.ArrayList;
import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import com.gooagoo.position.entity.MacPosition;

/**
 * 定位信息缓冲池
 * 实测每秒处理740000条以下数据量比较稳定(PC机)
 * 每秒数据量小于740000时查询速度大于插入速度,大于此数据量时查询速度小于插入速度且下降的很厉害
 * @author 王宇
 *
 */
public class Buffer
{
    private static Cache cache;
    static
    {
        CacheManager manager = CacheManager.create();
        manager.addCache("buffer");
        cache = manager.getCache("buffer");
    }

    public static void put(String key, Object value)
    {
        Element element = new Element(key, value);
        cache.put(element);
    }

    @SuppressWarnings("unchecked")
    public static List<MacPosition> get()
    {
        List<MacPosition> objects = new ArrayList<MacPosition>();
        List<String> keys = cache.getKeys();
        for (String key : keys)
        {
            Element element = cache.get(key);
            if (element != null)
            {
                cache.remove(element.getKey());
                objects.add((MacPosition) element.getValue());
            }
        }
        return objects;
    }

    /**
     * 缓存中的对象个数
     * @return
     */
    public static int count()
    {
        return cache.getSize();
    }

    /*public static void main(String[] args)
    {
        List<MacPosition> l = new ArrayList<MacPosition>();
        for (int i = 0; i < 740000; i++)
        {
            MacPosition position = new MacPosition();
            position.setMac(UUID.getUUID());
            position.setDevice("device");
            position.setX(23);
            position.setY(33);
            position.setType('t');
            l.add(position);
        }
        long start = System.currentTimeMillis();
        for (MacPosition macPosition : l)
        {
            Buffer.put(macPosition.getMac(), macPosition);
        }
        long midd = System.currentTimeMillis();
        System.out.println(midd - start);
        List<MacPosition> list = Buffer.get();
        long end = System.currentTimeMillis();
        System.out.println(end - midd);
    }*/
}
