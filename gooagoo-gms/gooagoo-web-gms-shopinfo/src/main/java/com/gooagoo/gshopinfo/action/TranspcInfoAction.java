package com.gooagoo.gshopinfo.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FTranspcInfo;

/**
 * 转发器设备管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/transpcInfo")
public class TranspcInfoAction extends BaseAction
{
    /**
     * 转发器分页查询
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        UtilsShopEntity.shopEntity(request, response);
        return "equipmentManager/transpcInfo/index";
    }

    /**
     * 跳转编辑页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=form")
    public String form(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<FTranspcInfo> transData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SHOP_INFO_GET_FTRANSPCINFO, request, FTranspcInfo.class);
        FTranspcInfo transpcInfo = transData.getData();
        String deviceCh = SysdictionaryCache.get("s_device_type", transpcInfo.getDeviceType());
        transpcInfo.setTypeNameCh(deviceCh);
        Map<String, String> deviceStatus = SysdictionaryCache.get("device_status");
        request.setAttribute("transpcInfo", transpcInfo);
        request.setAttribute("deviceStatus", deviceStatus);
        return "equipmentManager/transpcInfo/edit";
    }

    /**
     * 分页查询转发器设备信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=page")
    public String page(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_TRANSINFO, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FTranspcInfo> pageModel = transData.getData();
        if (null != pageModel && null != pageModel.getResult())
        {
            for (FTranspcInfo ftranspcInfo : pageModel.getResult())
            {
                String string = SysdictionaryCache.get("s_device_type", ftranspcInfo.getDeviceType());
                ftranspcInfo.setTypeNameCh(string);
                String billParse = SysdictionaryCache.get("bill_parse", ftranspcInfo.getBillParse());
                ftranspcInfo.setBillParseName(billParse);
                String stService = SysdictionaryCache.get("st_service", ftranspcInfo.getStService());
                ftranspcInfo.setStServiceName(stService);
            }
        }

        FTranspcInfo ftranspcInfo = ServletUtils.objectMethod(FTranspcInfo.class, request);
        request.setAttribute("condition", ftranspcInfo);
        request.setAttribute("pageModel", pageModel);
        if (pageModel != null)
        {
            request.setAttribute("page_cur", pageModel.getPageIndex());
            request.setAttribute("page_start", pageModel.getPageStart(5));
            request.setAttribute("page_end", pageModel.getPageEnd(5));
        }
        return "equipmentManager/transpcInfo/list";
    }

    /**
     * 分页查询转发器设备信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=update")
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_UPDATE_FTRANSPCINFO, request, response);
    }
}
