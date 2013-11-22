package com.gooagoo.gus.mall.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;

@Controller
@RequestMapping("/mall")
public class MallAction extends BaseAction
{

    /**
     * 首页
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        return "/mall/mall/all/index";
    }

    /**
     * 跳转页
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=shop")
    public String shop(HttpServletRequest request, HttpServletResponse response)
    {
        String shopId = request.getParameter("shopId");
        if (StringUtils.isBlank(shopId))
        {
            return "redirect:/index";
        }
        request.setAttribute("shopId", shopId);
        return "/mall/mall/single/index";
    }

    /**
     * 获取商家类型列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=shopTypeListRequest")
    public String shopTypeListRequest(HttpServletRequest request, HttpServletResponse response)
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_SHOPTYPECOMMON_GETSHOPTYPELIST);

        return "/mall/mall/shoptypelist";
    }

    /**
     * 获取商家列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=shopByShopTypeIdRequest")
    public String shopByShopTypeIdRequest(HttpServletRequest request, HttpServletResponse response)
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_SHOPCOMMON_GETSHOPLIST);

        return "/mall/mall/shoplist";
    }

    /**
     * 获取积分兑换物列表
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=convertThingListRequest")
    public String convertThingListRequest(HttpServletRequest request, HttpServletResponse response)
    {
        String type = request.getParameter("type");
        GusClientUtils.returnData(request, response, InterGusConstants.MALL_MALL_GETCONVERTTHINGLIST);
        if ("G".equals(type))
        {
            return "/mall/mall/goodslist";
        }
        else if ("C".equals(type))
        {
            return "/mall/mall/couponlist";
        }

        return null;
    }

    /**
     * 处理积分兑换
     * 
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=convertRequest")
    public void convertRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.MALL_MALL_INTEGRALCONVERT);
    }

    /**
     * 收货地址请求
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(params = "method=shippingAddressRequest")
    public String shippingAddressRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("shopIntegralId", ServletRequestUtils.getStringParameter(request, "shopIntegralId"));
        request.setAttribute("shopId", ServletRequestUtils.getStringParameter(request, "shopId"));
        GusClientUtils.returnData(request, response, InterGusConstants.MALL_MALL_GETSHIPPINGADDRESSLIST);

        return "/mall/mall/shippingAddress/shippingAddress";
    }

    /**
     * 获取省列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=provinceListRequest")
    public String provinceListRequest(HttpServletRequest request, HttpServletResponse response)
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_PROVINCECOMMON_GETPROVINCELIST);

        return "/mall/mall/shippingAddress/provincelist";
    }

    /**
     * 获取市列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=cityListRequest")
    public String cityListRequest(HttpServletRequest request, HttpServletResponse response)
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_CITYCOMMON_GETCITYLIST);

        return "/mall/mall/shippingAddress/citylist";
    }

    /**
     * 获取市列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=areaListRequest")
    public String areaListRequest(HttpServletRequest request, HttpServletResponse response)
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_AREACOMMON_GETAREALIST);

        return "/mall/mall/shippingAddress/arealist";
    }

}
