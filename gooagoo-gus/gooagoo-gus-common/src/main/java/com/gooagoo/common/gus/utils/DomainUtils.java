package com.gooagoo.common.gus.utils;

import com.gooagoo.common.utils.UrlUtils;

/**
 * 域名工具类
 * @author GUS
 *
 */
public class DomainUtils
{

    private static String DOMAIN_USERCENTER = "";

    private static String DOMAIN_PASSPORT = "";

    private static String DOMAIN_USERTEMP = "";

    private static String DOMAIN_HTML = "";

    static
    {
        DOMAIN_USERCENTER = "http://www." + UrlUtils.getBASE_HOST();
        DOMAIN_PASSPORT = "http://passport." + UrlUtils.getBASE_HOST();
        DOMAIN_USERTEMP = "http://user.temp." + UrlUtils.getBASE_HOST();
        DOMAIN_HTML = "http://html." + UrlUtils.getBASE_HOST();
    }

    /**
     * 个人中心域名
     * @return
     */
    public static String getUserCenterDomain()
    {
        return DOMAIN_USERCENTER;
    }

    /**
     * 身份验证系统域名
     * @return
     */
    public static String getPassportDomain()
    {
        return DOMAIN_PASSPORT;
    }

    /**
     * 用户模板系统域名
     * @return
     */
    public static String getUserTempDomain()
    {
        return DOMAIN_USERTEMP;
    }

    /**
     * 静态资源域名
     * @return
     */
    public static String getHtmlDomain()
    {
        return DOMAIN_HTML;
    }

}
