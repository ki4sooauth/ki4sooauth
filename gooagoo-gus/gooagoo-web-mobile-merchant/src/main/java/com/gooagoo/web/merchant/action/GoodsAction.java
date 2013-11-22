package com.gooagoo.web.merchant.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;

/**
 * 手机商品
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
        GusClientUtils.returnJson2(request, response, InterGusConstants.MERCHANT_MOBILE_GETGOODSDATA);
    }

    @RequestMapping(params = "method=mapDataRequest")
    public void mapDataRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GusClientUtils.returnJson2(request, response, InterGusConstants.COMMON_IGUS002);
    }

    @RequestMapping(params = "method=goodsCommentListRequest")
    public void goodsCommentListRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GusClientUtils.returnJson2(request, response, InterGusConstants.MERCHANT_MOBILE_GETGOODSCOMMENTLIST);
    }

    @RequestMapping(params = "method=favoriteGoodsRequest")
    public void favoriteGoodsRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GusClientUtils.returnJson2(request, response, InterGusConstants.MERCHANT_MOBILE_FAVORITEGOODS);
    }

    @RequestMapping(params = "method=addShoppingCartRequest")
    public void addShoppingCartRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GusClientUtils.returnJson2(request, response, InterGusConstants.COMMON_IGUS003);
    }

}
