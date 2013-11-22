package com.gooagoo.web.merchant.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;

/**
 * 网站商品
 * @author GOOAGOO
 *
 */
@Controller
@RequestMapping("/goods")
public class GoodsAction extends BaseAction
{

    @RequestMapping(params = "method=contentRequest")
    public void contentRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GusClientUtils.returnJson2(request, response, InterGusConstants.MERCHANT_WEB_GETGOODSDATA);
    }

    @RequestMapping(params = "method=goodsCommentListRequest")
    public void goodsCommentListRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GusClientUtils.returnJson2(request, response, InterGusConstants.MERCHANT_WEB_GETGOODSCOMMENTDATA);
    }

    @RequestMapping(params = "method=favoriteGoodsRequest")
    public void favoriteGoodsRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GusClientUtils.returnJson2(request, response, InterGusConstants.MERCHANT_WEB_FAVORITEGOODS);
    }

    @RequestMapping(params = "method=addShoppingListRequest")
    public void addShoppingListRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GusClientUtils.returnJson2(request, response, InterGusConstants.MERCHANT_WEB_ADDTOSHOPPINGLIST);
    }

    /**
     * 商品兑换请求
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=goodsConvertRequest")
    public String goodsConvertRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("shopIntegralId", ServletRequestUtils.getStringParameter(request, "shopIntegralId"));
        request.setAttribute("shopId", ServletRequestUtils.getStringParameter(request, "shopId"));
        GusClientUtils.returnData(request, response, InterGusConstants.MERCHANT_WEB_GETSHIPPINGADDRESSLIST);

        return "/merchant/goods/shippingAddress/shippingAddress";
    }

    /**
     * 处理积分兑换
     * 
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=convertRequest")
    public void convertRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GusClientUtils.returnJson2(request, response, InterGusConstants.MERCHANT_WEB_INTEGRALCONVERT);
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

        return "/merchant/goods/shippingAddress/provincelist";
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

        return "/merchant/goods/shippingAddress/citylist";
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

        return "/merchant/goods/shippingAddress/arealist";
    }

}
