package com.gooagoo.gus.shoppinglist.action;

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
import com.google.gson.Gson;

@Controller
@RequestMapping("/purchased")
public class PurchasedGoodsAction extends BaseAction
{
    /**
     * 已购商品首页
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        int currentYear = ca.get(Calendar.YEAR);//获取年份
        request.setAttribute("currentYear", currentYear);
        request.setAttribute("startYear", currentYear - 1);

        Calendar Date = Calendar.getInstance();
        request.setAttribute("end", sdf.format(Date.getTime()));
        Date.set(Calendar.MONTH, Date.get(Calendar.MONTH) - 1);
        request.setAttribute("start", sdf.format(Date.getTime()));
        return "/shoppinglist/purchased/purchased_index";
    }

    @RequestMapping(params = "method=billShopInfo")
    public void billShopInfo(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<Object> transData = GusClientUtils.transfer(request, InterGusConstants.COMMON_SHOPCOMMON_GETSHOPLIST);
        String result = new Gson().toJson(transData.getData());
        ServletUtils.writeHtml(result, response);

    }

    @RequestMapping(params = "method=billShopTypeInfo")
    public void billShopTypeInfo(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<Object> transData = GusClientUtils.transfer(request, InterGusConstants.COMMON_SHOPTYPECOMMON_GETSHOPTYPELIST);
        String result = new Gson().toJson(transData.getData());
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 已购商品展示页
     * @param request
     * @param response
     * @return
     * @throws ServletRequestBindingException 
     * @throws Exception
     */
    @RequestMapping(params = "method=findGoods")
    public String findGoods(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException
    {
        TransData<Object> ShoppingListBill_goods = GusClientUtils.transfer(request, InterGusConstants.SHOPPINGLIST_PURCHASEDGOODS_GETPURCHASEDGOODSLIST);
        request.setAttribute("goods", ShoppingListBill_goods.getData());
        request.setAttribute("message", ExceptionCache.get(ShoppingListBill_goods.getHead().getResultCode()));
        Integer num = ServletRequestUtils.getIntParameter(request, "num");
        if (num == 1)
        {
            return "/shoppinglist/purchased/purchased_table";
        }
        else
        {
            return "/shoppinglist/purchased/purchased_table2";
        }
    }
}
