package com.gooagoo.mis.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.mis.constants.RedisServerConstantsMis;
import com.gooagoo.redis.data.RedisObjectDao;
import com.gooagoo.redis.data.RedisStringDao;
import com.gooagoo.view.mis.common.MMisLoginInfo;

/**
 * redis操作工具类
 * @author qiyibing
 *
 */
public class RedisUtilMis
{
    //验证码cookie名称
    private static final String COOKIE_VERIFYCODE = "jss";
    //登录信息cookie名称
    private static final String COOKIE_LOGIN_INFO = "loginSuc";
    //模板信息cookie名称
    private static final String COOKIE_TEMPLATE_INFO = "tem";
    //后台domain
    private static final String COOKIE_MIS_DOMAIN = ".mis.gooagoo.com";
    //后台path
    private static final String COOKIE_MIS_PTAH = "/";

    /**
     * 设置登录信息cookie
     * @param MMisLoginInfo
     * @param res
     */
    public static void setMisLoginInfo(MMisLoginInfo MMisLoginInfo, HttpServletResponse res)
    {
        try
        {
            String uuid = UUID.getUUID();
            RedisObjectDao redis = new RedisObjectDao(RedisServerConstantsMis.login_mis);
            redis.set(uuid, MMisLoginInfo);

            Cookie cookie = new Cookie(COOKIE_LOGIN_INFO, uuid);
            cookie.setDomain(COOKIE_MIS_DOMAIN);
            cookie.setPath(COOKIE_MIS_PTAH);
            res.addCookie(cookie);
        }
        catch (Exception e)
        {
            GooagooLog.error("设置cookie出错:", e);
        }
    }

    /**
     * 获取登录信息
     * @param req
     * @return
     */
    public static MMisLoginInfo getMisLoginInfo(HttpServletRequest req)
    {
        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length != 0)
        {
            String token = null;
            for (Cookie cookie : cookies)
            {
                if (COOKIE_LOGIN_INFO.equals(cookie.getName()))
                {
                    token = cookie.getValue();
                    break;
                }
            }
            if (StringUtils.isNotEmpty(token))
            {
                RedisObjectDao redis = new RedisObjectDao(RedisServerConstantsMis.login_mis);
                return redis.getGenerics(token, MMisLoginInfo.class);
            }
            else
            {
                return null;
            }

        }
        else
        {
            GooagooLog.warn("没有获取到cookie");
            return null;
        }
    }

    /**
     * 删除登录信息
     * @param req
     * @return
     */
    public static void delMisLoginInfo(HttpServletRequest req, HttpServletResponse res)
    {
        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length != 0)
        {
            String token = null;
            for (Cookie cookie : cookies)
            {
                if (COOKIE_LOGIN_INFO.equals(cookie.getName()))
                {
                    token = cookie.getValue();
                    GooagooLog.info("登录信息cookie已清除");
                }
                else
                {
                    cookie.setDomain(COOKIE_MIS_DOMAIN);
                    cookie.setPath(COOKIE_MIS_PTAH);
                    res.addCookie(cookie);
                }
            }

            if (StringUtils.isNotEmpty(token))
            {
                RedisObjectDao redis = new RedisObjectDao(RedisServerConstantsMis.login_mis);
                redis.set(token, null);
            }
        }
    }

    /**
     * 设置验证码
     * @param verifyCode
     * @param res
     */
    public static void setVerifyCode(String verifyCode, HttpServletResponse res)
    {
        String key = UUID.getUUID();
        RedisStringDao redisWrite = new RedisStringDao(RedisServerConstantsMis.login_verification);
        redisWrite.set(key, 120, verifyCode);

        Cookie cookie = new Cookie(COOKIE_VERIFYCODE, key);
        cookie.setDomain(COOKIE_MIS_DOMAIN);
        cookie.setPath(COOKIE_MIS_PTAH);
        res.addCookie(cookie);
    }

    /**
     * 获取验证码
     * @param req
     * @return
     */
    public static String getVerifyCode(HttpServletRequest req)
    {
        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length != 0)
        {
            String token = null;
            for (Cookie cookie : cookies)
            {
                if (COOKIE_VERIFYCODE.equals(cookie.getName()))
                {
                    token = cookie.getValue();
                    break;
                }
            }
            if (StringUtils.isNotEmpty(token))
            {
                RedisStringDao redis = new RedisStringDao(RedisServerConstantsMis.login_verification);
                return redis.get(token);
            }
            else
            {
                return null;
            }
        }
        else
        {
            GooagooLog.warn("没有获取到cookie");
            return null;
        }
    }

    /**
     * 删除验证码
     * @param req
     * @return
     */
    public static void delVerifyCode(HttpServletRequest req, HttpServletResponse res)
    {
        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length != 0)
        {
            String token = null;
            for (Cookie cookie : cookies)
            {
                if (COOKIE_VERIFYCODE.equals(cookie.getName()))
                {
                    token = cookie.getValue();
                    GooagooLog.info("验证码信息cookie已被清除");
                }
                else
                {
                    cookie.setDomain(COOKIE_MIS_DOMAIN);
                    cookie.setPath(COOKIE_MIS_PTAH);
                    res.addCookie(cookie);
                }
            }

            if (StringUtils.isNotEmpty(token))
            {
                RedisObjectDao redis = new RedisObjectDao(RedisServerConstantsMis.login_verification);
                redis.set(token, null);
            }
        }
    }

    /**
     * 设置模板信息cookie
     * @param MMisLoginInfo
     * @param res
     */
    public static void setMTemplate(MMisLoginInfo MMisLoginInfo, HttpServletResponse res)
    {
        try
        {
            String uuid = UUID.getUUID();
            RedisObjectDao redis = new RedisObjectDao(RedisServerConstantsMis.login_mis);
            redis.set(uuid, MMisLoginInfo);

            Cookie cookie = new Cookie(COOKIE_TEMPLATE_INFO, uuid);
            cookie.setDomain(COOKIE_MIS_DOMAIN);
            cookie.setPath(COOKIE_MIS_PTAH);
            res.addCookie(cookie);
        }
        catch (Exception e)
        {
            GooagooLog.error("设置cookie出错:", e);
        }
    }

    /**
     * 获取模板信息
     * @param req
     * @return
     */
    public static MMisLoginInfo getMTemplate(HttpServletRequest req)
    {
        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length != 0)
        {
            String token = null;
            for (Cookie cookie : cookies)
            {
                if (COOKIE_TEMPLATE_INFO.equals(cookie.getName()))
                {
                    token = cookie.getValue();
                    break;
                }
            }
            if (StringUtils.isNotEmpty(token))
            {
                RedisObjectDao redis = new RedisObjectDao(RedisServerConstantsMis.login_mis);
                return redis.getGenerics(token, MMisLoginInfo.class);
            }
            else
            {
                return null;
            }

        }
        else
        {
            GooagooLog.warn("没有获取到cookie");
            return null;
        }
    }

}
