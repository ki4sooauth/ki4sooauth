package com.gooagoo.gshopinfo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.gms.utils.ShopUtil;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FShopEntityInfo;
import com.gooagoo.view.gms.shopinfo.FWifiInfo;

/**
 * wifi设备管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/wifi")
public class WifiAction extends BaseAction
{
    /**
     * 分页查询wifi信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        UtilsShopEntity.shopEntity(request, response);
        return "equipmentManager/wifiinfo/index";
    }

    /**
     * 删除wifi设备
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_DEL_WIFI_INFO, request, response);
    }

    /**
     * 跳转编辑页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=addform")
    public String addForm(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData2 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_SHOP_ENTITY_INFO, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FShopEntityInfo> pageModel = transData2.getData();
        ShopUtil.transferShopInfo(request);
        //        GmsLoginInfo shopInfo = GMSUtil.getShopInfo(request);
        //        request.setAttribute("gmsLoginInfo", shopInfo);
        request.setAttribute("entityList", pageModel.getResult());
        return "equipmentManager/wifiinfo/edit";
    }

    /**
     * 跳转编辑页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=updateform")
    public String updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String wifiId = ServletRequestUtils.getStringParameter(request, "wifiInfoId", "");
        if (StringUtils.hasText(wifiId))
        {
            TransData<FWifiInfo> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_GET_WIFI_INFO, request, FWifiInfo.class);
            FWifiInfo wifiInfo = transData.getData();
            request.setAttribute("wifiInfo", wifiInfo);
        }
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData2 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_SHOP_ENTITY_INFO, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FShopEntityInfo> pageModel = transData2.getData();
        ShopUtil.transferShopInfo(request);
        //        GmsLoginInfo shopInfo = GMSUtil.getShopInfo(request);
        //        request.setAttribute("gmsLoginInfo", shopInfo);
        request.setAttribute("entityList", pageModel.getResult());
        return "equipmentManager/wifiinfo/edit";
    }

    /**
     * 分页查询wifi设备信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=page")
    public String page(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_WIFI_INFO, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FWifiInfo> pageModel = transData.getData();
        request.setAttribute("pageModel", pageModel);
        if (pageModel != null)
        {
            request.setAttribute("page_cur", pageModel.getPageIndex());
            request.setAttribute("page_start", pageModel.getPageStart(5));
            request.setAttribute("page_end", pageModel.getPageEnd(5));
        }
        return "equipmentManager/wifiinfo/list";
    }

    /**
     * 编辑wifi设备信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=saveOrUpdate")
    public void saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String wifiId = ServletRequestUtils.getStringParameter(request, "wifiId", "");
        if (StringUtils.hasText(wifiId))
        {
            GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_UPDATE_WIFI_INFO, request, response);
        }
        else
        {
            GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_ADD_WIFI_INFO, request, response);
        }
    }
}
