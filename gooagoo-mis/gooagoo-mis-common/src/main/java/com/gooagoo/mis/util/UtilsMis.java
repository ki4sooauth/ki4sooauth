package com.gooagoo.mis.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.TimeUtils;

/**
 * 公共工具类
 * @author Administrator
 *
 */
public class UtilsMis
{
    /**
     * 将新对象中不为null的字段值更新到原对象-只支持一层属性的更新
     * @param oldObj原对象
     * @param newObj新对象
     * @return 
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static Object freshObject(Object oldObj, Object newObj) throws IllegalArgumentException, IllegalAccessException
    {
        if (oldObj != null && newObj != null)
        {
            Field[] fields = newObj.getClass().getDeclaredFields();
            for (Field field : fields)
            {
                field.setAccessible(true);
                Object value = field.get(newObj);
                if (value != null && !Modifier.isFinal(field.getModifiers()))
                {
                    field.set(oldObj, value);
                }
            }
        }
        return newObj;
    }

    /**
     * 创建TransData对象
     * @param success 是否成功
     * @param resultCode  默认错误编码（例如删除操作没有抛异常，但返回结果为false时所需要制定的错误编码）
     * @param t
     * @return
     * @throws Exception
     */
    public static <T> TransData<T> toTransData(Boolean success, String resultCode, T t) throws Exception
    {
        TransData<T> transData = new TransData<T>();
        transData.getHead().setHeadData(success, resultCode);
        transData.setData(t);

        return transData;
    }

    /**
     * 返回boolean类型接口结果
     * @param result
     * @param successRC 成功结果编码
     * @param failRC 失败结果编码
     * @return
     */
    public static TransData<Object> getBooleanResult(Boolean result, String successRC, String failRC)
    {
        String rc = null;
        if (result)
        {
            rc = successRC;
        }
        else
        {
            rc = failRC;
        }
        return new TransData<Object>(result, rc, null);
    }

    /**
     * 返回boolean类型接口结果
     * @param result
     * @param successRC 成功结果编码
     * @param failRC 失败结果编码
     * @return
     */
    public static TransData<Object> getBooleanResult(Boolean result, String successRC, String failRC, String operateId)
    {
        String rc = null;
        if (result)
        {
            rc = successRC;
        }
        else
        {
            rc = failRC;
        }
        return new TransData<Object>(result, rc, null, operateId);
    }

    /**
     * 获取当前用户的操作IP
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request)
    {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getRemoteAddr();
        }
        if (ip.indexOf(",") != -1)
        {
            ip = ip.substring(0, ip.indexOf(","));
        }
        return ip.trim();
    };

    /**
     * 将时间设置凌晨0时
     * @param date
     * @return
     * @throws Exception 
     */
    public static Date getEarlyMorning(Date date) throws Exception
    {
        if (date == null)
        {
            return null;
        }
        String dateStr = TimeUtils.convertDateToString(date, "yyyy-MM-dd");
        dateStr = dateStr + " 00:00:00";

        Date nd = TimeUtils.convertStringToDate(dateStr);

        return nd;
    }

    /**
     * 将时间设置成晚上24时
     * @param date
     * @return
     * @throws Exception 
     */
    public static Date getMidNight(Date date) throws Exception
    {
        if (date == null)
        {
            return null;
        }
        String dateStr = TimeUtils.convertDateToString(date, "yyyy-MM-dd");
        dateStr = dateStr + " 23:59:59";

        Date nd = TimeUtils.convertStringToDate(dateStr);

        return nd;
    }
}
