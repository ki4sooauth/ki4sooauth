package com.gooagoo.gus.favorite.common;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@SuppressWarnings("unchecked")
public class JsonUtil
{

    public static <T> T jsonToBean(String json, Class<T> clazz)
    {
        JSONObject jsonObject = JSONObject.fromObject(json);
        return (T) JSONObject.toBean(jsonObject, clazz);
    }

    @SuppressWarnings("deprecation")
    public static <T> List<T> jsonToList(String json, Class<T> clazz)
    {
        System.out.println("json:" + json);
        JSONArray arry = JSONArray.fromObject(json);
        return JSONArray.toList(arry, clazz);
    }

    public static <T> T[] jsonToArray(String json, Class<T> clazz)
    {
        JSONArray arry = JSONArray.fromObject(json);
        return (T[]) JSONArray.toArray(arry, clazz);
    }

    public static String listToJson(List<?> list)
    {
        return JSONSerializer.toJSON(list).toString();
    }
}