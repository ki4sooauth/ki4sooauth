package com.gooagoo.cache;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.gooagoo.cache.entity.DicImageCache;

public class QualitySquareGoodsTypeCache
{
    protected static Map<String, DicImageCache> self = new LinkedHashMap<String, DicImageCache>();
    protected static Map<String, List<DicImageCache>> next = new LinkedHashMap<String, List<DicImageCache>>();

    public static DicImageCache getSelf(String key)
    {
        return self.get(key);
    }

    public static List<DicImageCache> getNext(String key)
    {
        return next.get(key);
    }
}
