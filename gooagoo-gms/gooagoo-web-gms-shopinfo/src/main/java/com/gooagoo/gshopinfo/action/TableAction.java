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
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FShopEntityInfo;
import com.gooagoo.view.gms.shopinfo.FShopTableType;
import com.gooagoo.view.gms.shopinfo.FTableInfo;

/**
 * 桌号查询
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/tableInfo")
public class TableAction extends BaseAction
{
    /**
     * 删除桌号信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=delete")
    public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_DEl_TABLE_INFO, request, response);
        return null;
    }

    /**
     * 分页查询桌号信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transdata = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_TABLE_TYPE_TTPAGE, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FShopTableType> pageModel = transdata.getData();
        if (pageModel != null)
        {
            request.setAttribute("pageModel", pageModel.getResult());
        }
        UtilsShopEntity.shopEntity(request, response);
        return "tableCode/index";
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
        @SuppressWarnings({ "unchecked", "rawtypes" })
        TransData<PageModel> transdataTableType = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_TABLE_TYPE_TTPAGE, request, PageModel.class);
        PageModel<FShopEntityInfo> pageModel = transData2.getData();
        ShopUtil.transferShopInfo(request);
        //        GmsLoginInfo shopInfo = GMSUtil.getShopInfo(request);
        //        request.setAttribute("gmsLoginInfo", shopInfo);
        PageModel<FShopTableType> tableInto = transdataTableType.getData();
        request.setAttribute("tableType1", tableInto.getResult());
        request.setAttribute("entityList", pageModel.getResult());
        return "tableCode/edit";
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
        String tableId = ServletRequestUtils.getStringParameter(request, "tableId", "");
        if (StringUtils.hasText(tableId))
        {
            TransData<FTableInfo> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_GET_TABLE_INFO, request, FTableInfo.class);
            FTableInfo tableInfo = transData.getData();
            request.setAttribute("tableInfo", tableInfo);
        }
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData2 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_SHOP_ENTITY_INFO, request, PageModel.class);
        @SuppressWarnings({ "unchecked", "rawtypes" })
        TransData<PageModel> transdataTableType = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_TABLE_TYPE_TTPAGE, request, PageModel.class);
        PageModel<FShopEntityInfo> pageModel = transData2.getData();
        ShopUtil.transferShopInfo(request);
        PageModel<FShopTableType> tableInto = transdataTableType.getData();
        request.setAttribute("tableType1", tableInto.getResult());
        request.setAttribute("entityList", pageModel.getResult());
        return "tableCode/edit";
    }

    /**
     * 分页查询桌号信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=page")
    public String page(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_TABLE_INFO, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FTableInfo> model = transData.getData();
        FTableInfo ftableInfo = ServletUtils.objectMethod(FTableInfo.class, request);
        request.setAttribute("condition", ftableInfo);
        request.setAttribute("pageModel", model);
        if (model != null)
        {
            request.setAttribute("page_cur", model.getPageIndex());
            request.setAttribute("page_start", model.getPageStart(5));
            request.setAttribute("page_end", model.getPageEnd(5));
        }
        return "tableCode/tableList";
    }

    /**
     * 编辑桌号信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=saveOrUpdate")
    public void saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String tableId = ServletRequestUtils.getStringParameter(request, "id", "");
        if (StringUtils.hasText(tableId))
        {
            GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_UPDATE_TABLE_INFO, request, response);
        }
        else
        {
            GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_ADD_TABLE_INFO, request, response);
        }
    }

    /**
     * 查询桌号详细信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=getTableTwoCodeInfo")
    public String getTableTwoCodeInfo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String tableId = ServletRequestUtils.getStringParameter(request, "tableId", "");
        if (StringUtils.hasText(tableId))
        {
            TransData<FTableInfo> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_GET_TABLE_INFO, request, FTableInfo.class);
            FTableInfo tableInfo = transData.getData();
            request.setAttribute("tableInfo", tableInfo);
        }
        return "tableCode/twoDimCode";
    }

    /**
     * 分页查询桌号二维码信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=toCodeIndex")
    public String toCodeIndex(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return "tableCode/printCodeIndex";
    }

    /**
     * 分页查询桌号二维码信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=pageTwoDimCode")
    public String pageTwoDimCode(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_TABLE_INFO, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FTableInfo> model = transData.getData();
        request.setAttribute("pageModel", model);
        request.setAttribute("page_cur", model.getPageIndex());
        request.setAttribute("page_start", model.getPageStart(5));
        request.setAttribute("page_end", model.getPageEnd(5));
        return "tableCode/codeList";
    }

}
