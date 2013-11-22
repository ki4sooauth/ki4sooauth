package com.gooagoo.gus.coupon.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;

@Controller
@RequestMapping("/coupon")
public class CouponAction extends BaseAction
{

    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        return "/coupon/index";
    }

    @RequestMapping(params = "method=showCoupon")
    public String showCoupon(HttpServletRequest request, HttpServletResponse response)
    {
        if (request.getParameter("shopId") != null && !"".equals(request.getParameter("shopId")))
        {
            request.setAttribute("shopId", request.getParameter("shopId"));
        }
        return "/coupon/coupon";
    }

    //商品类型列表
    @RequestMapping(params = "method=shopType")
    public String shopType(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_SHOPTYPECOMMON_GETSHOPTYPELIST);
        return "/coupon/shoptypelist/shoptypelist";
    }

    //商家列表
    @RequestMapping(params = "method=shopListRequest")
    public String shopListRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_SHOPCOMMON_GETSHOPLIST);
        return "/coupon/shoplist/shoplist";
    }

    // 获取优惠凭证列表
    @RequestMapping(params = "method=couponListRequest")
    public String couponListRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COUPON_GETCOUPONLIST);
        return "/coupon/couponlist/couponlistO";
    }

    //  收藏优惠凭证
    @RequestMapping(params = "method=favoriteCouponRequest")
    public void favoriteCouponRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.COUPON_FAVORITECOUPON);
    }

    /**
     * 广告请求
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=adRequest")
    public void adRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.COMMON_ADCOMMON_GETADINFO);
    }

}
