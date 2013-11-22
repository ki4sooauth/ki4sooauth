package com.gooagoo.gshopinfo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FShopEntityInfo;
import com.gooagoo.view.gms.shopinfo.GmsLoginInfo;

public class UtilsShopEntity
{
    public static void shopEntity(HttpServletRequest request, HttpServletResponse response)
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_SHOP_ENTITY_INFO, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FShopEntityInfo> pageModel = transData.getData();
        if (pageModel != null)
        {
            request.setAttribute("entityList", pageModel.getResult());
            GmsLoginInfo gmsLoginInfo = GMSUtil.getGmsLoginInfoByWeb(request);
            request.setAttribute("gmsLoginInfo", gmsLoginInfo);
        }
    }
}
