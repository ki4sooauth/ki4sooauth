package com.gooagoo.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 提示信息缓存
 * @author frenn
 *
 */
public class ExceptionCache
{

    protected static Map<String, String> map = new LinkedHashMap<String, String>();

    /**
     * 根据key值获取value
     * @param key
     * @return
     */
    public static String get(String key)
    {
        return map.get(key);
    }
}
