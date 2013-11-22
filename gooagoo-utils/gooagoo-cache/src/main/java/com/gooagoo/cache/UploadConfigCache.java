package com.gooagoo.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class UploadConfigCache
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

    /**
     * 获取文件上传连接地址
     * @return
     */
    public static String getFileUploadUrl()
    {
        return map.get("fileupload.server.url");
    }

}
