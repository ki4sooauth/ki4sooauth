package com.gooagoo.common.utils;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * JSON数据转换工具类
 */
public class JsonUtils
{

    public final static Gson gson;

    static
    {
        gson = new Gson();
    }

    /**将object转换成json
     * @param Object
     * @return String json
     */
    public static String toJson(Object obj)
    {
        return gson.toJson(obj);
    }

    /**将json转换成Object
     * @param json
     * @param Class<T>
     * @return T
     */
    public static <T> T toObj(String json, Class<T> clazz)
    {
        return gson.fromJson(json, clazz);
    }

    /** 
     * json转换字符串数组
     * @param json
     * @param String[]
     * @return java数组 
     */
    public static String[] json2StringArray(String json)
    {
        return gson.fromJson(json, new TypeToken<String[]>()
        {
        }.getType());
    }

    /**将json转换成List<String>
     * @param json
     * @return List<String>
     */
    public static List<String> json2List(String json)
    {
        return gson.fromJson(json, new TypeToken<List<String>>()
        {
        }.getType());
    }

    /**将json转换成Map<String, String>
     * @param json
     * @return Map<String, String>
     */
    public static Map<String, String> json2Map(String json)
    {
        return gson.fromJson(json, new TypeToken<Map<String, String>>()
        {
        }.getType());
    }

    /**将json转换成指定泛型集合
     * @param json
     * @param typeToken<T>(Demo:new TypeToken<List<Map<String, String>>>(){})
     * @return 泛型集合
     */
    public static <T> T json2Genericity(String json, TypeToken<T> typeToken)
    {
        return gson.fromJson(json, typeToken.getType());
    }

}
