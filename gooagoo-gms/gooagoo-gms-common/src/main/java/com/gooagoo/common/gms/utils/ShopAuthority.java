package com.gooagoo.common.gms.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.casclient.shop.ShopAuth;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.google.gson.Gson;

public class ShopAuthority
{
    /**
     * 核查用户是否有访问权限
     * @param request
     * @return
     */
    public static boolean checkAuthID(HttpServletRequest request, String authorityID)
    {
        ShopLoginInfo shopInfo = GMSUtil.getShopLoginInfoByWeb(request);
        if (shopInfo != null && shopInfo.getShopAuthList() != null)
        {
            for (Iterator<ShopAuth> iterator = shopInfo.getShopAuthList().iterator(); iterator.hasNext();)
            {
                ShopAuth sa = iterator.next();
                if (sa.getAuthorityId().equals(authorityID))
                {
                    return sa.isUserOwn();
                }
            }
        }
        return false;
    }

    /**
     * 核查用户是否有访问指定url的权限，并初始化filterParentAuthCode
     * @param shopInfo 登录信息
     * @param url 访问路径
     * @param filterParentAuthCode 访问权限的父级权限编码
     * @return
     */
    public static boolean checkAuthUrl(ShopLoginInfo shopInfo, String url, Map<String, String> data)
    {
        List<ShopAuth> authList = shopInfo.getShopAuthList();
        for (Iterator<ShopAuth> iterator = authList.iterator(); iterator.hasNext();)
        {
            ShopAuth shopAuth = iterator.next();
            String note = shopAuth.getNote();
            String link = shopAuth.getLink();
            if (!StringUtils.hasText(url))
            {
                GooagooLog.warn("url=" + url);
                return false;
            }
            if (StringUtils.hasText(link) && link.endsWith(url))
            {
                GooagooLog.debug("link:url=" + url + ",auth=" + new Gson().toJson(shopAuth));
                data.put(GMSConstant.MAP_KEY_AUTH_CODE, shopAuth.getParentAuthorityId());
                return shopAuth.isUserOwn();
            }
            if (StringUtils.hasText(note) && ("," + note + ",").indexOf("," + url + ",") > -1)
            {
                GooagooLog.debug("note:url=" + url + ",auth=" + new Gson().toJson(shopAuth));
                data.put(GMSConstant.MAP_KEY_AUTH_CODE, shopAuth.getParentAuthorityId());
                return shopAuth.isUserOwn();
            }
        }
        return true;

    }

    /**
     * 获取用户的访问路径（参数只截取method）
     * @param request
     * @return
     */
    public static String getRequestUrl(HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        String query = request.getQueryString();
        if (!StringUtils.hasText(query))
        {
            if (!StringUtils.hasText(requestURI))
            {
                return request.getRequestURL().toString();
            }
            if (requestURI.endsWith("/"))
            {
                requestURI = requestURI.substring(0, requestURI.length() - 1);
            }
            return requestURI;
        }
        String[] paras = query.split("&");
        String para = "";
        for (int i = 0; i < paras.length; i++)
        {
            if (paras[i].startsWith("method="))
            {
                para = paras[i];
                break;
            }
        }
        if (StringUtils.hasText(para))
        {
            para = "?" + para;
        }
        else
        {
            query = "";
        }
        String url = requestURI + para;
        return url;
    }
}
