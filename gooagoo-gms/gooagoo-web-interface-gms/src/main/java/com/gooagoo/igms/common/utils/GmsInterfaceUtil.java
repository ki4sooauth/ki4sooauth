package com.gooagoo.igms.common.utils;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.gms.utils.GMSServiceUtil;

public class GmsInterfaceUtil
{

    /**
     * 接口层获取登录者的商家编号
     * @param request
     * @return
     */
    public static String getShopIdByInterface(HttpServletRequest request)
    {
        String objIdConstant = GMSServiceUtil.getCasFitlerUserObjIdConstant();
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
        String tokenConstant = GMSServiceUtil.getCasFitlerUserTokenConstant();
        String token = request.getParameter(tokenConstant);

        return token;
    }
}
