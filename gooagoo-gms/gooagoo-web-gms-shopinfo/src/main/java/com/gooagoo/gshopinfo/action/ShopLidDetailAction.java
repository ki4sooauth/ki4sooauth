package com.gooagoo.gshopinfo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FShopLidDetail;

@Controller
@RequestMapping("/shopLidDetail")
public class ShopLidDetailAction extends BaseAction
{

    /**
     * 分页查询营销中心用户信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        UtilsShopEntity.shopEntity(request, response);
        return "equipmentManager/lid/index";
    }

    @RequestMapping(params = "method=getLidDetail")
    public String getShopLidDetail(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<FShopLidDetail> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_GET_LID_DETAIL, request, FShopLidDetail.class);
        FShopLidDetail lidDetail = transData.getData();
        request.setAttribute("lidDetail", lidDetail);
        return "equipmentManager/lid/edit";
    }

    /**
     * 分页查询lib分配表信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=pageLidDetail")
    public String pageShopLidDetail(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_LID_DETAIL, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FShopLidDetail> pageModel = transData.getData();
        FShopLidDetail fShopLidDetail = ServletUtils.objectMethod(FShopLidDetail.class, request);
        request.setAttribute("condition", fShopLidDetail);
        request.setAttribute("pageModel", pageModel);
        if (pageModel != null)
        {
            request.setAttribute("page_cur", pageModel.getPageIndex());
            request.setAttribute("page_start", pageModel.getPageStart(5));
            request.setAttribute("page_end", pageModel.getPageEnd(5));
        }
        return "equipmentManager/lid/list";
    }

    /**
     * 修改lib分配表信息
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=updateLidDetail")
    public void updateShopLidDetail(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_UPDATE_LID_DETAIL, request, response);
    }
}
