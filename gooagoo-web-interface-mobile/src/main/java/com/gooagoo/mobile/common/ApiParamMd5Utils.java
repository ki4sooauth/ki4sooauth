package com.gooagoo.mobile.common;

import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.entity.para.Parameter;

/**
 * 接口入参数加密防止篡改
 * 加密规则:
 * 收到客服端调用API时需要对请求参数进行签名验证
 * (1)根据参数名称（除签名和图片）将所有请求参数按照字母先后顺序排序:key + value .... key + value
 * (2)系统同时支持MD5和HMAC两种加密方式(暂时使用md5加密)
       md5：将secret 拼接到参数字符串头、尾进行md5加密后，再转化成大写，格式是：byte2hex(md5(secretkey1value1key2value2...secret))
       hmac：采用hmac的md5方式，secret只在头部的签名后再转化成大写，格式 是：byte2hex (hmac(key1value1key2value2..., secret))
 */
public class ApiParamMd5Utils
{
    private final static String secret = "gooagoo";

    private final static String secretSign = "secret";

    /**
    * 新的md5签名，首尾放secret。
    * @param secret 分配给您的APP_SECRET
    */
    public static String md5Signature(TreeMap<String, String> params)
    {
        String result = null;
        StringBuffer orgin = getBeforeSign(params, new StringBuffer(secret));
        if (orgin == null)
        {
            return result;
        }
        orgin.append(secret);
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            result = byte2hex(md.digest(orgin.toString().getBytes("utf-8")));
        }
        catch (Exception e)
        {
            throw new java.lang.RuntimeException("sign error !");
        }
        return result;
    }

    /**
    * 二行制转字符串
    */
    private static String byte2hex(byte[] b)
    {
        StringBuffer hs = new StringBuffer();
        String stmp = "";
        for (int n = 0; n < b.length; n++)
        {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
            {
                hs.append("0").append(stmp);
            }
            else
            {
                hs.append(stmp);
            }
        }
        return hs.toString().toUpperCase();
    }

    /**
    * 添加参数的封装方法
    */
    private static StringBuffer getBeforeSign(TreeMap<String, String> params, StringBuffer orgin)
    {
        if (params == null)
        {
            return null;
        }
        Map<String, String> treeMap = new TreeMap<String, String>();
        treeMap.putAll(params);
        Iterator<String> iter = treeMap.keySet().iterator();
        while (iter.hasNext())
        {
            String name = iter.next();
            orgin.append(name).append(params.get(name));
        }
        return orgin;
    }

    @SuppressWarnings("unchecked")
    public static void checkParameter(HttpServletRequest request) throws Exception
    {
        Map<String, String[]> map = request.getParameterMap();
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        TreeMap<String, String> params = new TreeMap<String, String>();
        Parameter parameter = InterfaceUtils.collectParameter(request);
        while (it.hasNext())
        {
            String key = it.next();
            if (secretSign.equals(key))
            {
                params.put(key, parameter.getString(key));
            }

        }

        if (!parameter.getString(secretSign).equals(md5Signature(params)))
        {
            throw new Exception("");
        }
    }

}
