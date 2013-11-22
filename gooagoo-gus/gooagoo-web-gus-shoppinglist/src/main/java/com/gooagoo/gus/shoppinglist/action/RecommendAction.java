package com.gooagoo.gus.shoppinglist.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;

/**
 * 推荐视图层Action
 *
 */
@Controller
@RequestMapping("/recommendation")
public class RecommendAction extends BaseAction
{
    /**
     * 查询热卖商品
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=hotSale")
    public String hotSale(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("pageIndex", "1");
        request.setAttribute("pageSize", "7");
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_GOODSCOMMON_GETHOTSALEGOODSLIST);
        return "/shoppinglist/shoppinglist/recommend/hotSale_goods";
    }

    /**
     * 查询最新商品
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=newest")
    public String newest(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("pageIndex", "1");
        request.setAttribute("pageSize", "7");
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_GOODSCOMMON_GETNEWESTGOODSLIST);
        return "/shoppinglist/shoppinglist/recommend/newest_goods";
    }

    /**
     * 查询热评商品
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=testimonials")
    public String testimonials(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("pageIndex", "1");
        request.setAttribute("pageSize", "7");
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_GOODSCOMMON_GETHOTCOMMENTGOODSLIST);
        return "/shoppinglist/shoppinglist/recommend/testimonials_goods";
    }

    /**
     *查询猜您喜欢
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=guesslike")
    public String guesslike(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("pageIndex", "1");
        request.setAttribute("pageSize", "7");
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_GOODSCOMMON_GETGUESSLIKEGOODSLIST);
        return "/shoppinglist/shoppinglist/recommend/guesslike_goods";
    }

}
