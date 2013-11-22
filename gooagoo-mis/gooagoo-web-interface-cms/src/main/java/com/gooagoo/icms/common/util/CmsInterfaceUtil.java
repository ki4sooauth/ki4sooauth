package com.gooagoo.icms.common.util;

import javax.servlet.http.HttpServletRequest;

public class CmsInterfaceUtil
{

    /**
     * 接口层获取登录者的商家编号
     * @param request
     * @return
     */
    public static String getShopIdByInterface(HttpServletRequest request)
    {
        String objIdConstant = CMSServiceUtil.getCasFitlerUserObjIdConstant();
        String shopId = request.getParameter(objIdConstant);
        return shopId;
    }

    /**
     * 接口层获取登录Token
     * @param request
     * @return
     */
    public static String getShopLoginTokenByInterface(HttpServletRequest request)
    {
        String tokenConstant = CMSServiceUtil.getCasFitlerUserTokenConstant();
        String token = request.getParameter(tokenConstant);

        return token;
    }
}
