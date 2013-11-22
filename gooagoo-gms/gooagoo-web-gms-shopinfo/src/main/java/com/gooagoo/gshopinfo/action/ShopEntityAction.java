package com.gooagoo.gshopinfo.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.AreaCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FShopEntityInfo;
import com.gooagoo.view.gms.shopinfo.FShopInvoiceInfo;
import com.google.gson.Gson;

@Controller
@RequestMapping("/shopEntity")
public class ShopEntityAction extends BaseAction
{

    /**
     * 跳转编辑实体店信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        if (StringUtils.isNotBlank(shopEntityId))
        {
            TransData<FShopEntityInfo> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_GET_SHOP_ENTITY_INFO, request, FShopEntityInfo.class);
            FShopEntityInfo entityInfo = transData.getData();
            request.setAttribute("entityInfo", entityInfo);
        }
        ShopLoginInfo shopInfo = GMSUtil.getShopLoginInfoByWeb(request);
        request.setAttribute("shopStatus", shopInfo.getShopAndUserInfo().getShopStatus());
        return "shopEntity/index";
    }

    /**
     * 跳转编辑实体店信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=addform")
    public String addForm(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        this.isGeneral(request);
        request.setAttribute("editFlag", "add");

        return "shopEntity/shopEdit";
    }

    /**
     * 校验是否为总店
     * @param request
     */
    private boolean isGeneral(HttpServletRequest request)
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_SHOP_ENTITY_INFO, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FShopEntityInfo> pageModel = transData.getData();
        boolean flag = false;
        for (FShopEntityInfo entityInfo : pageModel.getResult())
        {
            if (entityInfo.getIsGeneral().equals("Y"))
            {
                flag = true;
                break;
            }
        }
        request.setAttribute("flag", flag);
        return flag;
    }

    /**
     * 跳转编辑实体店信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=updateform")
    public String updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        if (StringUtils.isNotBlank(shopEntityId))
        {
            TransData<FShopEntityInfo> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_GET_SHOP_ENTITY_INFO, request, FShopEntityInfo.class);
            FShopEntityInfo entityInfo = transData.getData();
            Map<String, String> listCity = AreaCache.getNext(entityInfo.getProvince());
            Map<String, String> listArea = AreaCache.getNext(entityInfo.getCity());

            request.setAttribute("listCity", listCity);
            request.setAttribute("listArea", listArea);
            request.setAttribute("entityInfo", entityInfo);
            request.setAttribute("editFlag", "update");
        }
        else
        {
            request.setAttribute("editFlag", "add");
        }
        ShopLoginInfo shopInfo = GMSUtil.getShopLoginInfoByWeb(request);
        request.setAttribute("shopStatus", shopInfo.getShopAndUserInfo().getShopStatus());

        this.isGeneral(request);

        return "shopEntity/shopEdit";
    }

    /**
     * 添加或修改实体店信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=savaOrUpdateEntity")
    public void savaOrUpdateEntity(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        if (org.springframework.util.StringUtils.hasText(shopEntityId))
        {
            GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_UPDATE_SHOP_ENTITY_INFO, request, response);
        }
        else
        {
            GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_ADD_SHOP_ENTITY_INFO, request, response);
        }
    }

    /**
     * 添加修改实体店联系方式信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=savaOrUpdateLink")
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String flag = ServletRequestUtils.getStringParameter(request, "editFlag", "");
        if ("add".equals(flag))
        {
            GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_ADD_SHOP_LINK, request, response);
        }
        else
        {
            GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_UPDATE_SHOP_LINK, request, response);
        }
    }

    /**
     * 修改实体店GPS信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=savaOrUpdateGps")
    public void updateGPSInfo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String flag = ServletRequestUtils.getStringParameter(request, "editFlag", "");
        if ("add".equals(flag))
        {
            GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_ADD_SHOP_GPS, request, response);
        }
        else
        {
            GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_UPDATE_SHOP_GPS, request, response);
        }
    }

    /**
     * 删除实体店信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_DEL_SHOP_ENTITY_INFO, request, response);
    }

    /**
     * 分页查询实体店信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=page")
    public String page(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_SHOP_ENTITY_INFO, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FShopEntityInfo> pageModel = transData.getData();
        request.setAttribute("pageModel", pageModel);
        if (pageModel != null)
        {   
        	ShopLoginInfo shopInfo = GMSUtil.getShopLoginInfoByWeb(request);
        	request.setAttribute("shopStatus", shopInfo.getShopAndUserInfo().getShopStatus());
        	request.setAttribute("isChain", shopInfo.getShopAndUserInfo().getShopIsChain());
            request.setAttribute("page_cur", pageModel.getPageIndex());
            request.setAttribute("page_start", pageModel.getPageStart(5));
            request.setAttribute("page_end", pageModel.getPageEnd(5));
        }
        return "shopEntity/tableList";
    }

    /**
     * 查询实体店详细信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=detail")
    public String detail(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<FShopEntityInfo> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_GET_SHOP_ENTITY_INFO, request, FShopEntityInfo.class);
        FShopEntityInfo entityInfo = transData.getData();
        request.setAttribute("entityInfo", entityInfo);
        return "shopEntity/detail";
    }

    /**
     * 查询小票信息列表
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=shopInviceList")
    public String shopInviceList(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<List> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_LIST_SHOP_INVOICE_INFO, request, List.class);
        List<FShopInvoiceInfo> invoiceList = transData.getData();
        request.setAttribute("invoiceList", invoiceList);
        return "shopEntity/invList";
    }

    /**
     * 添加小票信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=addShopInvoice")
    public void addShopInvice(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_ADD_SHOP_INVOICE_INFO, request, response);
    }

    /**
     * 添加小票信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=delShopInvoice")
    public void delShopInvice(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_DEL_SHOP_INVOICE_INFO, request, response);
    }

    /**
     * 获取区域名信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=getAreaInfo")
    public void getArea(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String parentId = ServletRequestUtils.getStringParameter(request, "parentId", "");
        if (StringUtils.isBlank(parentId))
        {
            parentId = "-1";
        }
        Map<String, String> next = AreaCache.getNext(parentId);
        ServletUtils.writeHtml(new Gson().toJson(next), response);
    }

}
