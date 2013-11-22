package com.gooagoo.gapply.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.view.gms.apply.FOrderDetailAndPicInfo;
import com.gooagoo.view.gms.apply.FOrderInfo;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FShopEntityInfo;
import com.gooagoo.view.gms.shopinfo.GmsLoginInfo;

@Controller
@RequestMapping("/billInfo")
public class BillInfoAction extends BaseAction
{

    /**
     * 分页查询订单信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
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
        return "billInfo/index";
    }

    /**
     * 分页查询账单信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=page")
    public String page(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_APPLY_PAGE_BILL_INFO, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FOrderInfo> pageModel = transData.getData();
        request.setAttribute("pageModel", pageModel);
        if (pageModel != null)
        {
            request.setAttribute("page_cur", pageModel.getPageIndex());
            request.setAttribute("page_start", pageModel.getPageStart(5));
            request.setAttribute("page_end", pageModel.getPageEnd(5));
        }
        return "billInfo/list";
    }

    /**
     * 查询订单详细信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=detail")
    public String detail(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String orderid = ServletRequestUtils.getStringParameter(request, "orderId", "");
        request.setAttribute("orderid", orderid);
        return "billInfo/billInfo";
    }

    /**
     * 查询订单详细信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=mailDetail")
    public String mailDetail(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<FOrderInfo> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_APPLY_PAGE_BILL_INFO_DETAIL, request, FOrderInfo.class);
        FOrderInfo info = transData.getData();
        request.setAttribute("orderInfo", info);
        return "billInfo/mailDetail";
    }

    /**
     * 查询订单详细信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=orderGoodsDetail")
    public String orderGoodsDetail(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_APPLY_BILL_DETAIL_INFO, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FOrderDetailAndPicInfo> pageModel = transData.getData();

        if (pageModel.getResult() != null && pageModel.getResult().size() > 0)
        {
            request.setAttribute("pageModel", pageModel);
            request.setAttribute("orderDetailPic", pageModel.getResult().get(0).getPic().getPicUrl());
            request.setAttribute("orderid", pageModel.getResult().get(0).getDetailInfo().getOrderId());
        }
        if (pageModel != null)
        {
            request.setAttribute("page_cur", pageModel.getPageIndex());
            request.setAttribute("page_start", pageModel.getPageStart(5));
            request.setAttribute("page_end", pageModel.getPageEnd(5));
        }
        /*   @SuppressWarnings("rawtypes")
           TransData<PageModel> tranPic = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_APPLY_ORDER_DETAIL_PIC_INFO, request, PageModel.class);
           @SuppressWarnings("unchecked")
           PageModel<FOrderPic> dataPic = tranPic.getData();
           request.setAttribute("dataPic", dataPic);*/

        return "billInfo/billGoodsDetail";
    }
}
