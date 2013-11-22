package com.gooagoo.cache;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import com.gooagoo.cache.log.CacheLog;
import com.gooagoo.cache.utils.CacheUtils;
import com.google.gson.Gson;

public class CacheLoad
{
    private final static Gson gson = new Gson();

    @SuppressWarnings("unchecked")
    public static void load(String key, Object object)
    {
        try
        {
            CacheLog.debug("加载数据" + key + "=====" + gson.toJson(object));

            if ("areaCache".equals(key))
            {
                CacheUtils.loadMap((Map<String, List<String>>) object, AreaCache.self, AreaCache.next);
            }
            else if ("qualitySquareGoodsTypeCache".equals(key))
            {
                CacheUtils.load((Map<String, List<String>>) object, QualitySquareGoodsTypeCache.self, QualitySquareGoodsTypeCache.next);
            }
            else if ("shoppingListCache".equals(key))
            {
                CacheUtils.load((Map<String, List<String>>) object, ShoppingListCache.self, ShoppingListCache.next);
            }
            else if ("shopTypeCache".equals(key))
            {
                CacheUtils.load((Map<String, List<String>>) object, ShopTypeCache.self, ShopTypeCache.next);
            }
            else if ("interfaceCache".equals(key))
            {
                InterfaceCache.reload((Map<String, List<String>>) object);
            }
            else if ("sysdictionaryCache".equals(key))
            {
                SysdictionaryCache.reload((Map<String, List<String>>) object);
            }
            else if ("emailCache".equals(key))
            {
                EmailCache.map.clear();
                EmailCache.map.putAll((Map<String, String>) object);
            }
            else if ("exceptionCache".equals(key))
            {
                ExceptionCache.map.clear();
                ExceptionCache.map.putAll((Map<String, String>) object);
            }
            else if ("mobileConfigCache".equals(key))
            {
                MobileConfigCache.map.clear();
                MobileConfigCache.map.putAll((Map<String, String>) object);
            }
            else if ("gmsConfigCache".equals(key))
            {
                GmsConfigCache.map.clear();
                GmsConfigCache.map.putAll((Map<String, String>) object);
            }
            else if ("uploadConfigCache".equals(key))
            {
                UploadConfigCache.map.clear();
                UploadConfigCache.map.putAll((Map<String, String>) object);
            }
            else if ("misConfigCache".equals(key))
            {
                MisConfigCache.map.clear();
                MisConfigCache.map.putAll((Map<String, String>) object);
            }
            else if ("passportConfigCache".equals(key))
            {
                PassportConfigCache.map.clear();
                PassportConfigCache.map.putAll((Map<String, String>) object);
            }
            else if ("gusConfigCache".equals(key))
            {
                GusConfigCache.map.clear();
                GusConfigCache.map.putAll((Map<String, String>) object);
            }
            else
            {
                CacheLog.warn("不支持的类型：" + key);
                return;
            }
        }
        catch (Exception e)
        {
            CacheLog.error("加载数据异常", e);
        }
    }

    public static void load(String path, byte[] content) throws UnsupportedEncodingException
    {
        load(getKey(path), CacheUtils.unserialize(content));
    }

    private static String getKey(String path)
    {
        if (path == null || !path.endsWith("/data") || !path.startsWith("/root/cache/"))
        {
            return null;
        }
        else
        {
            return path.replaceAll("/root/cache/", "").replaceAll("/data", "");
        }
    }
}
