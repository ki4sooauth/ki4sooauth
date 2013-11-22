package com.gooagoo.igms.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.entity.casclient.shop.ShopLoginInfo;

public class RelationServiceUtil
{
    /**
     * 获取排序内容（为空时按创建时间倒序）
     * @param request
     * @return
     */
    public static String getOrderByOnDefault(HttpServletRequest request)
    {
        String orderBy = request.getParameter("orderBy");
        if (orderBy == null)
        {
            orderBy = " c_time_stamp desc ";
        }
        return orderBy;
    }

    /**
     * 获取实体店Id
     * @param request
     * @param shopInfo
     * @return
     */
    public static String getShopEntityId(HttpServletRequest request, ShopLoginInfo shopInfo)
    {
        String entityId = shopInfo.getShopAndUserInfo().getUserShopEntityId();
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", null);
        if(StringUtils.hasText(shopEntityId)){
        	entityId = shopEntityId;
        }else if (!StringUtils.hasText(entityId))
        {
            entityId = ServletRequestUtils.getStringParameter(request, "entityId", null);
        }
        return entityId;
    }
}
