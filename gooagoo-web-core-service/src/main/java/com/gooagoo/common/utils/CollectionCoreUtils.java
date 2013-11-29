package com.gooagoo.common.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

public class CollectionCoreUtils
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

    /**
     * List分页查询
     * @param list
     * @param pageIndex 分页页数(start by 1)
     * @param pageSize 分页大小
     * @return
     */
    public static <T> List<T> pageList(List<T> list, Integer pageIndex, Integer pageSize)
    {
        if (pageIndex != null && pageSize != null)
        {
            pageIndex = (pageIndex - 1) * pageSize;
            if (pageIndex >= list.size())
            {
                return null;
            }
            pageSize = pageIndex + pageSize > list.size() ? list.size() : pageIndex + pageSize;
            return list.subList(pageIndex, pageSize);
        }
        else
        {
            return list;
        }
    }

}
