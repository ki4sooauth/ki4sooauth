package com.gooagoo.gapply.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.view.gms.apply.FBillInvoiceLog;
import com.gooagoo.view.gms.apply.FBillPayApplication;
import com.gooagoo.view.gms.apply.FOrderInfo;
import com.gooagoo.view.gms.apply.FShopLog;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FShopEntityInfo;
import com.gooagoo.view.gms.shopinfo.GmsLoginInfo;

@Controller
@RequestMapping("/clerk")
public class ClerkAction extends BaseAction
{

    /**
     * 店员服务情况-查询
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return "clerk/index";
    }

    /**
     * 店员服务情况-查询订单
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=pageOrder")
    public String orderInfo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData1 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_SHOP_ENTITY_INFO, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FShopEntityInfo> pageModel1 = transData1.getData();
        if (pageModel1 != null)
        {
            request.setAttribute("entityList", pageModel1.getResult());
            GmsLoginInfo gmsLoginInfo = GMSUtil.getGmsLoginInfoByWeb(request);
            request.setAttribute("gmsLoginInfo", gmsLoginInfo);
        }

        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_APPLY_CLERK_ORDER_INFO, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FOrderInfo> pageModel = transData.getData();
        request.setAttribute("pageModel", pageModel);
        if (pageModel != null)
        {
            request.setAttribute("page_cur", pageModel.getPageIndex());
            request.setAttribute("page_start", pageModel.getPageStart(5));
            request.setAttribute("page_end", pageModel.getPageEnd(5));
        }
        return "clerk/orderlist";
    }

    /**
     * 店员服务情况-开发票
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=pageInvoice")
    public String pageInvoice(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_APPLY_CLERK_INVOICE_LOG, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FBillInvoiceLog> pageModel = transData.getData();
        request.setAttribute("pageModel", pageModel);
        if (pageModel != null)
        {
            request.setAttribute("page_cur", pageModel.getPageIndex());
            request.setAttribute("page_start", pageModel.getPageStart(5));
            request.setAttribute("page_end", pageModel.getPageEnd(5));
        }
        return "clerk/invoiceList";
    }

    /**
     * 店员服务情况-申请结账
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=pageBillPay")
    public String pageBillPay(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_APPLY_CLERK_PAY_APPLICATION, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FBillPayApplication> pageModel = transData.getData();
        request.setAttribute("pageModel", pageModel);
        if (pageModel != null)
        {
            request.setAttribute("page_cur", pageModel.getPageIndex());
            request.setAttribute("page_start", pageModel.getPageStart(5));
            request.setAttribute("page_end", pageModel.getPageEnd(5));
        }
        return "clerk/billPayList";
    }

    /**
     * 店员服务情况-刷卡
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=pageCreditCard")
    public String pageShopLog(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_APPLY_CLERK_CREDIT_CARD, request, PageModel.class);
        PageModel<FShopLog> pageModel = transData.getData();
        request.setAttribute("pageModel", pageModel);
        if (pageModel != null)
        {
            request.setAttribute("page_cur", pageModel.getPageIndex());
            request.setAttribute("page_start", pageModel.getPageStart(5));
            request.setAttribute("page_end", pageModel.getPageEnd(5));
        }
        return "clerk/creditCardList";
    }
}
