package com.gooagoo.gus.favorite.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;

/**
 * 值得收藏视图层Action
 * @author Jun
 *
 */
@Controller
@RequestMapping("/meritfavorite")
public class MeritFavoriteAction extends BaseAction
{
    /**
     * 值得收藏首页
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        return "favorite/meritfavorite/meritfavorite_index";
    }

    /**
     * 值得收藏_查询精品收藏商品
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=findGoods")
    public String findGoods(HttpServletRequest request, HttpServletResponse response)
    {
        GusClientUtils.returnData(request, response, InterGusConstants.FAVORITE_MERITFAVORITE_GETMERITFAVORITEGOODSLIST);
        return "favorite/meritfavorite/meritfavorite_goods";
    }

    /**
     * 值得收藏_查询活动
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=findActivity")
    public String findActivity(HttpServletRequest request, HttpServletResponse response)
    {
        GusClientUtils.returnData(request, response, InterGusConstants.FAVORITE_MERITFAVORITE_GETMERITFAVORITEACTIVITYLIST);
        return "favorite/meritfavorite/meritfavorite_activity";
    }

    /**
     * 值得收藏_查询优惠凭证
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=findCoupon")
    public String findCoupon(HttpServletRequest request, HttpServletResponse response)
    {
        GusClientUtils.returnData(request, response, InterGusConstants.FAVORITE_MERITFAVORITE_GETMERITFAVORITECOUPONLIST);
        return "favorite/meritfavorite/meritfavorite_coupon";
    }

    /**
     * 值得收藏_收藏商品
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=favoriteGoodsDo")
    public void favoriteDo(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        request.setAttribute("source", "W");
        GusClientUtils.returnJson1(request, response, InterGusConstants.FAVORITE_MERITFAVORITE_FAVORITEGOODS);
    }

    /**
     * 值得收藏_收藏活动
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=favoriteActivityDo")
    public void favoriteActivityDo(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        request.setAttribute("source", "W");
        GusClientUtils.returnJson1(request, response, InterGusConstants.FAVORITE_MERITFAVORITE_FAVORITEACTIVITY);
    }

    /**
     * 值得收藏_收藏优惠凭证
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=favoriteCouponDo")
    public void favoriteCouponDo(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        request.setAttribute("source", "W");
        GusClientUtils.returnJson1(request, response, InterGusConstants.FAVORITE_MERITFAVORITE_FAVORITECOUPON);
    }

}
