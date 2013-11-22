package com.gooagoo.common.utils;

import java.util.Iterator;
import java.util.Map;

import org.springframework.util.StringUtils;

public class CollectionQueryUtils
{
    /**
     * 过滤Map集合中空值元素
     * @param map
     */
    public static void filterNullValue4Map(Map<String, String> map)
    {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, String> entry = iterator.next();
            if (!StringUtils.hasText(entry.getValue()))
            {
                iterator.remove();
            }
        }
    }
}
