package com.gooagoo.gus.bill.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gus.common.PageModel;
import com.gooagoo.view.gus.web.bill.UOrderInfo;
import com.google.gson.Gson;

@Controller
@RequestMapping("/electricBill")
public class ElectricBillAction extends BaseAction
{

    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        this.getTime(request, response);

        return "bill/index";
    }

    @RequestMapping(params = "method=shopbill")
    public String shopbill(HttpServletRequest request, HttpServletResponse response)
    {
        this.getTime(request, response);
        String shopId = request.getParameter("shopId");
        request.setAttribute("shopId", shopId);

        return "bill/electricbill/shopbill/index";
    }

    @RequestMapping(params = "method=personalbill")
    public String personalbill(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException
    {
        String billId = ServletRequestUtils.getStringParameter(request, "billId");
        request.setAttribute("billId", billId);
        return "bill/electricbill/detailbill/bill_personal";
    }

    @RequestMapping(params = "method=showCouponPic")
    public String showCouponPic(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException
    {
        String id = ServletRequestUtils.getStringParameter(request, "id");
        request.setAttribute("id", id);
        return "bill/electricbill/couponPic";
    }

    //根据账单id查询账单详细(这个从日历跳进来的);
    @RequestMapping(params = "method=detailbill")
    public String detailbill(HttpServletRequest request, HttpServletResponse response)
    {
        GusClientUtils.returnData(request, response, InterGusConstants.BILL_ELECTRICBILL_GETELECTRICBILLDETAIL);
        return "bill/electricbill/detailbill/bill_detail";
    }

    //根据账单id查询账单详细
    @RequestMapping(params = "method=detailElectricBill")
    public String detailElectricBill(HttpServletRequest request, HttpServletResponse response)
    {
        GusClientUtils.returnData(request, response, InterGusConstants.BILL_ELECTRICBILL_GETELECTRICBILLDETAIL);
        return "bill/electricbill/electricBillDetail";
    }

    /**
     * 电子帐单列表
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(params = "method=electricBillListRequest")
    public String electricBillListRequest(HttpServletRequest request, HttpServletResponse response)
    {
        //        GusClientUtils.returnData(request, response, InterGusConstants.BILL_ELECTRICBILL_GETELECTRICBILLLIST);
        TransData<Object> pageModel = GusClientUtils.transfer(request, InterGusConstants.BILL_ELECTRICBILL_GETELECTRICBILLLIST);
        PageModel<UOrderInfo> pm = (PageModel<UOrderInfo>) pageModel.getData();
        if (pm != null)
        {
            request.setAttribute("data", pm.getResult());
            request.setAttribute("pageModel", pm);
        }
        request.setAttribute("message", ExceptionCache.get(pageModel.getHead().getResultCode()));
        return "bill/electricbill/electricBill"; //电子帐单页面
    }

    /**
     * 收藏商品
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=favoriteGoodsRequest")
    public void favoriteGoodsRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.BILL_ELECTRICBILL_FAVORITEGOODS);
    }

    /**
     * 加入购物清单
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=addShoppingListRequest")
    public void addShoppingListRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.BILL_ELECTRICBILL_ADDTOSHOPPINGLIST);

    }

    /**
     * 评论商品
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=commentGoodsRequest")
    public void commentGoodsRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.BILL_ELECTRICBILL_COMMENTGOODS);
    }

    @RequestMapping(params = "method=deleteElectricBill")
    public void deleteElectricBillRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.BILL_ELECTRICBILL_DELETEELECTRICBILL);
    }

    @RequestMapping(params = "method=billShopInfo")
    public void billShopInfo(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<Object> transData = GusClientUtils.transfer(request, InterGusConstants.COMMON_SHOPCOMMON_GETSHOPLIST);
        String result = new Gson().toJson(transData.getData());
        ServletUtils.writeHtml(result, response);
    }

    @RequestMapping(params = "method=billShopType")
    public void billShopType(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<Object> transData = GusClientUtils.transfer(request, InterGusConstants.COMMON_SHOPTYPECOMMON_GETSHOPTYPELIST);
        String result = new Gson().toJson(transData.getData());
        ServletUtils.writeHtml(result, response);
    }

    private void getTime(HttpServletRequest request, HttpServletResponse response)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        int currentYear = ca.get(Calendar.YEAR);//获取年份
        request.setAttribute("currentYear", currentYear);
        request.setAttribute("startYear", currentYear - 1);

        Calendar billDate = Calendar.getInstance();
        request.setAttribute("billEnd", sdf.format(billDate.getTime()));
        billDate.set(Calendar.MONTH, billDate.get(Calendar.MONTH) - 1);
        request.setAttribute("billStart", sdf.format(billDate.getTime()));
    }
}
