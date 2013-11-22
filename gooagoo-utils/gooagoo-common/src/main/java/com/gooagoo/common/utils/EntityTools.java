package com.gooagoo.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import com.gooagoo.common.log.GooagooLog;

public class EntityTools
{
    /**
     * 在两个类之间 将相同名称的字段赋值
     * @param fromObject 源对象
     * @param toClass 目标类
     * @return 目标对象
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    public static <T> T copyValue(Object fromObject, Class<T> toClass) throws InstantiationException, IllegalAccessException
    {
        Class<? extends Object> fromClass = fromObject.getClass(); //传入类的所有字段
        Field[] fromFields = fromClass.getDeclaredFields();
        Field[] arrToFields = toClass.getDeclaredFields();
        Map<String, Field> toFields = new HashMap<String, Field>();
        for (Field field : arrToFields)
        {
            toFields.put(field.getName(), field); //为了少几次循环放map里
        }

        T obj = toClass.newInstance(); //返回对象
        for (Field fromField : fromFields)
        {
            if (!Modifier.isFinal(fromField.getModifiers()))
            {
                fromField.setAccessible(true); //让字段可访问 有没有get、set方法都行
                Field toField = toFields.get(fromField.getName());
                if (toField != null)
                {
                    try
                    {
                        toField.setAccessible(true);
                        toField.set(obj, fromField.get(fromObject));
                        toField.setAccessible(false);
                    }
                    catch (Exception e)
                    {
                        GooagooLog.debug(e.getMessage());//这个是debug级别的 因为个别字段类型不匹配无法赋值
                    }
                }
                fromField.setAccessible(false);
            }
        }
        return obj;
    }

    /**
     * 在两个类之间 将相同名称的字段赋值
     * @param fromObject 源对象
     * @param toObject 目标对象
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    public static void copyValue(Object fromObject, Object toObject) throws IllegalArgumentException, IllegalAccessException
    {
        Class<? extends Object> fromClass = fromObject.getClass(); //传入类的所有字段
        Class<? extends Object> toClass = toObject.getClass(); //传入类的所有字段

        Field[] fromFields = fromClass.getDeclaredFields();
        Field[] arrToFields = toClass.getDeclaredFields();
        Map<String, Field> toFields = new HashMap<String, Field>();
        for (Field field : arrToFields)
        {
            toFields.put(field.getName(), field); //为了少几次循环放map里
        }

        for (Field fromField : fromFields)
        {
            if (!Modifier.isFinal(fromField.getModifiers()))
            {
                fromField.setAccessible(true); //让字段可访问 有没有get、set方法都行
                Field toField = toFields.get(fromField.getName());
                if (toField != null)
                {
                    toField.setAccessible(true);
                    toField.set(toObject, fromField.get(fromObject));
                    toField.setAccessible(false);
                }
                fromField.setAccessible(false);
            }
        }
    }
}
