package com.gooagoo.gshopinfo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.ShopTypeCache;
import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.cache.entity.DicImageCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gms.shopinfo.FShopInfo;
import com.google.gson.Gson;

@Controller
@RequestMapping("/shopInfo")
public class ShopInfoAction extends BaseAction
{

    /**
     * 跳转首页
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<FShopInfo> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_GET_SHOP_INFO, request, FShopInfo.class);
        FShopInfo shopInfo = transData.getData();
        request.setAttribute("shopInfo", shopInfo);
        return "shopAccountInfo/index";
    }

    /**
     * 查询账户信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=getShopInfo")
    public String getShopInfo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<FShopInfo> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_GET_SHOP_INFO, request, FShopInfo.class);
        FShopInfo shopInfo = transData.getData();
        if (null != shopInfo)
        {
            String styleCh = SysdictionaryCache.get("service_style", shopInfo.getServiceStyle());
            shopInfo.setServiceStyleCh(styleCh);
            String shopstatus = SysdictionaryCache.get("shop_status", shopInfo.getShopStatus());
            shopInfo.setShopStatusch(shopstatus);
            DicImageCache shopTypeLeafCh = ShopTypeCache.getSelf(shopInfo.getShopTypeLeaf().toString());
            GooagooLog.debug("查询商家基本类型 shopTypeLeaf:" + shopTypeLeafCh);
            if (null != shopTypeLeafCh)
            {
                shopInfo.setShopTypeLeafCh(shopTypeLeafCh.getName());
            }
        }
        request.setAttribute("shopInfo", shopInfo);
        List<DicImageCache> next = ShopTypeCache.getNext("-1");
        request.setAttribute("shopType", next);
        List<DicImageCache> shopTypeLeaf = ShopTypeCache.getNext(shopInfo.getShopTypeRoot().toString());
        request.setAttribute("shopTypeLeaf", shopTypeLeaf);
        return "shopAccountInfo/shopInfo";
    }

    /**
     * 修改店铺信息
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=updateShopInfo")
    public void updateUserInfo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_UPDATE_SHOP_INFO, request, response);
    }

    /**
     * 修改营业状态
     * @param request
     * @param responsenormalBusiness
     * @throws Exception
     */
    @RequestMapping(params = "method=updateBusiness")
    public void updateBusiness(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_UPDATE_BUSINESS_STATUS, request, response);
    }

    /**
     * 修改商家基本信息
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=updateShopInfos")
    public void updateUserInfos(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_UPDATE_SHOP_INFOS, request, response);
    }

    /**
     * 获取商家类型
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=getShopType")
    public void getShopType(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String parentId = ServletRequestUtils.getStringParameter(request, "parentId", "");
        if (org.apache.commons.lang.StringUtils.isBlank(parentId))
        {
            parentId = "-1";
        }
        List<DicImageCache> next = ShopTypeCache.getNext(parentId);
        ServletUtils.writeHtml(new Gson().toJson(next), response);
    }
}
