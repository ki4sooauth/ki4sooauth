package com.gooagoo.gshopinfo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FDeviceWifisensor;

/**
 * 商家wifisensor设备管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/wifisensor")
public class WifisensorAction extends BaseAction
{
    /**
     * Wifisensor信息查询
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        UtilsShopEntity.shopEntity(request, response);
        return "equipmentManager/wifisensor/index";
    }

    /**
     * wifiSensot 分页信息查询
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=page")
    public String page(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transdata = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_WIFI_SENSOR, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FDeviceWifisensor> pageModel = transdata.getData();
        request.setAttribute("pageModel", pageModel);
        request.setAttribute("page_cur", pageModel.getPageIndex());
        request.setAttribute("page_start", pageModel.getPageStart(5));
        request.setAttribute("page_end", pageModel.getPageEnd(5));
        return "equipmentManager/wifisensor/list";
    }

    @RequestMapping(params = "method=detail")
    public String wifisensorDetail(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<FDeviceWifisensor> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_WIFI_SENSOR_DETAIL, request, FDeviceWifisensor.class);
        FDeviceWifisensor wifisensorDetail = transData.getData();
        request.setAttribute("wifisensorDetail", wifisensorDetail);
        return "equipmentManager/wifisensor/edit";
    }

    /**
     * 修改
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=updata")
    public void updatewifisensor(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_UPDATE_WIFI_SENSOR, request, response);
    }

}
