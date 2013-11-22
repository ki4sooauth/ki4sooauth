package com.gooagoo.common.gms.utils;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;

public class ShopUtil
{
    /** 
     * 向页面传送 商家信息
     * @param request  
     */
    public static void transferShopInfo(HttpServletRequest request)
    {
        ShopLoginInfo shopLoginInfo = GMSUtil.getShopLoginInfoByWeb(request);
        if (shopLoginInfo != null)
        {
            GooagooLog.debug("com.gooagoo.entity.casclient.shop.ShopLoginInfo 获取成功 ");
            request.setAttribute("shopId", shopLoginInfo.getShopAndUserInfo().getShopId());
            request.setAttribute("entityId", shopLoginInfo.getShopAndUserInfo().getUserShopEntityId());
        }
        else
        {
            GooagooLog.debug("com.gooagoo.entity.casclient.shop.ShopLoginInfo 获取为 null ");
        }
    }

    public static String getShopId(HttpServletRequest request)
    {
        String shopId = GMSUtil.getShopIdByWeb(request);
        return shopId;
    }

    public static String getShopEntityId(HttpServletRequest request)
    {
        ShopLoginInfo shopLoginInfo = GMSUtil.getShopLoginInfoByWeb(request);
        if (shopLoginInfo != null)
        {
            return shopLoginInfo.getShopAndUserInfo().getUserShopEntityId();
        }
        else
        {
            return null;
        }
    }
}
