package com.gooagoo.common.gus.utils;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gooagoo.common.log.GooagooLog;

/**
 * COOKIE工具类
 * @author GUS
 *
 */
public class CookieUtils
{

    /**
     * 设置cookie
     * @param cookieName
     * @param cookieValue
     * @param expiryTime
     * @param response
     */
    public static void setCookie(String cookieName, String cookieValue, Integer expiryTime, HttpServletResponse response)
    {
        try
        {
            Cookie cookie = new Cookie(cookieName, URLEncoder.encode(cookieValue, "UTF-8"));
            cookie.setDomain(".gooagoo.com");
            cookie.setPath("/");
            if (expiryTime != null)
            {
                cookie.setMaxAge(expiryTime);
            }
            response.addCookie(cookie);
        }
        catch (Exception e)
        {
            GooagooLog.error("设置cookie异常", e);
        }
    }

    /**
     * 获取cookie
     * @param cookieName
     * @param request
     * @return
     */
    public static String getCookie(String cookieName, HttpServletRequest request)
    {
        try
        {
            Cookie[] cookies = request.getCookies();
            if (cookies == null || cookies.length == 0)
            {
                return null;
            }
            for (Cookie cookie : cookies)
            {
                if (cookieName.equals(cookie.getName()))
                {
                    return URLDecoder.decode(cookie.getValue(), "UTF-8");
                }
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("获取cookie异常", e);
        }
        return null;
    }
}
