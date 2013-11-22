package com.gooagoo.common.gms.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.gooagoo.common.utils.TimeUtils;

public class RULEServletUtils
{
    /**
     * 自动将http请求的参数注入到对象中
     * @param clazz
     * @param request
     * @return
     * @throws Exception
     */
    public static <T> T objectMethod(Class<T> clazz, String type, String ac, HttpServletRequest request) throws Exception
    {
        String pre = type + "_" + ac + "_";
        return setValue(request, clazz, pre, "", true);
    }

    private static <T> T setValue(HttpServletRequest request, Class<T> clazz, String pre, String fieldName, boolean nullValue) throws Exception
    {
        Field[] fields = clazz.getDeclaredFields();
        T obj = clazz.newInstance();
        for (Field field : fields)
        {
            if (Modifier.isFinal(field.getModifiers()))
            {
                continue;
            }
            field.setAccessible(true);
            try
            {
                String typeName = field.getType().getName();
                String strValue = null;
                strValue = request.getParameter(pre + fieldName + field.getName());
                if ("".equals(strValue) && nullValue)
                {
                    strValue = null;
                }
                else if (strValue == null && !nullValue)
                {
                    strValue = "";
                }
                if ("java.lang.String".equals(typeName))
                {
                    field.set(obj, strValue);
                }
                else if ((("java.lang.Integer".equals(typeName) || "int".equals(typeName))) && StringUtils.hasText(strValue))
                {
                    int value = Integer.valueOf(strValue);
                    field.set(obj, value);
                }
                else if ((("java.lang.Double".equals(typeName) || "double".equals(typeName))) && StringUtils.hasText(strValue))
                {
                    double value = Double.valueOf(strValue);
                    field.set(obj, value);
                }
                else if ("java.util.Date".equals(typeName))
                {
                    Date value = TimeUtils.convertStringToDate(strValue);
                    field.set(obj, value);
                }
                else if ("java.util.List".equals(typeName))
                {
                    String type = getGenericsType(field.getGenericType());

                    List list = new ArrayList();
                    for (String value : request.getParameterValues(field.getName()))
                    {
                        try
                        {
                            if ("java.lang.String".equals(type))
                            {
                                list.add(value);
                            }
                            else if ("java.lang.Integer".equals(type) || "int".equals(typeName))
                            {
                                list.add(Integer.valueOf(value));
                            }
                            else if ("java.util.Date".equals(type))
                            {
                                list.add(TimeUtils.convertStringToDate(value));
                            }
                        }
                        catch (Exception e)
                        {
                            // 单个参数数据类型可能会错误，不影响后续业务流程
                        }
                    }
                    field.set(obj, list);
                }
                else if (!typeName.startsWith("java") && typeName.indexOf(".") != -1) //不是jdk内部类，不是基本数据类型
                {
                    field.set(obj, setValue(request, field.getType(), pre, field.getName() + ".", nullValue));
                }
            }
            catch (Exception e)
            {
                // 单个参数数据类型可能会错误，不影响后续业务流程
            }
            field.setAccessible(false);
        }
        return obj;
    }

    /**
     * 取得泛型的实际类型
     * @param type
     * @return
     */
    private static String getGenericsType(Type type)
    {
        String fieldType = type.toString();
        if (fieldType.indexOf("java.util.List<") == 0)
        {
            //不要把new String去掉，虽然运行结果是一样的,会影响垃圾回收
            return new String(type.toString().substring(15, type.toString().length() - 1));
        }
        else
        {
            return type.toString();
        }
    }
}
