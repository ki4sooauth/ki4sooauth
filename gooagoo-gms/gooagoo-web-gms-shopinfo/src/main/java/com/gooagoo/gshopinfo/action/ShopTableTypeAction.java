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
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FShopEntityInfo;
import com.gooagoo.view.gms.shopinfo.FShopTableType;

@Controller
@RequestMapping("shopTableType")
public class ShopTableTypeAction extends BaseAction
{
    /**
     * 跳转餐桌类型列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        UtilsShopEntity.shopEntity(request, response);
        return "shopTableType/index";
    }

    /**
     * 餐桌类型列表
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=page")
    public String page(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transdata = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_TABLE_TYPE_TTPAGE, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FShopTableType> pageModel = transdata.getData();
        request.setAttribute("pageModel", pageModel);
        if (pageModel != null)
        {
            request.setAttribute("page_cur", pageModel.getPageIndex());
            request.setAttribute("page_start", pageModel.getPageStart(5));
            request.setAttribute("page_end", pageModel.getPageEnd(5));
        }
        return "shopTableType/list";
    }

    /**
     * 餐桌类型添加
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=addDo")
    public void addDo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_TABLE_TYPE_ADD, request, response);
    }

    /**
     * 餐桌类型删除
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_TABLE_TYPE_DEL, request, response);
    }

    /**
     * 餐桌类型修改
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=updateDo")
    public void updateDo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_TABLE_TYPE_UP, request, response);
    }

    /**
     * 跳转餐桌类型add
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=add")
    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData2 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_SHOP_ENTITY_INFO, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FShopEntityInfo> pageModel = transData2.getData();
        ShopUtil.transferShopInfo(request);
        if (pageModel != null)
        {
            request.setAttribute("entityList", pageModel.getResult());
        }
        ShopLoginInfo gmsLoginInfo = GMSUtil.getShopLoginInfoByWeb(request);
        request.setAttribute("gmsLoginInfo", gmsLoginInfo.getShopAndUserInfo());
        return "shopTableType/add";
    }

    /**
     * 跳转餐桌类型edit
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=update")
    public String update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String typeId = ServletRequestUtils.getStringParameter(request, "id");
        if (StringUtils.hasText(typeId))
        {
            TransData<FShopTableType> transdata = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_TABLE_TYPE_GET, request, FShopTableType.class);
            FShopTableType fshopTableType = transdata.getData();
            request.setAttribute("tableType", fshopTableType);
        }

        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData2 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_SHOP_ENTITY_INFO, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FShopEntityInfo> pageModel = transData2.getData();
        ShopUtil.transferShopInfo(request);
        if (pageModel != null)
        {
            request.setAttribute("entityList", pageModel.getResult());
        }
        ShopLoginInfo gmsLoginInfo = GMSUtil.getShopLoginInfoByWeb(request);
        request.setAttribute("gmsLoginInfo", gmsLoginInfo.getShopAndUserInfo());

        return "shopTableType/edit";
    }
}
