package com.gooagoo.gus.favorite.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;
import com.gooagoo.view.gus.common.PageModel;
import com.gooagoo.view.gus.web.favorite.UFavoriteActivity;
import com.gooagoo.view.gus.web.favorite.UFavoriteCoupon;
import com.gooagoo.view.gus.web.favorite.UFavoriteGoods;

/**
 * 用户收藏视图层Action
 * @author Jun
 *
 */
@Controller
@RequestMapping("/favorite")
public class FavoriteAction extends BaseAction
{
    /**
     * 收藏首页
     * @param request infotype;//收藏类型，A-活动，G-商品，C-优惠券，P-其他
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        this.getTime(request, response);
        request.setAttribute("pageIndex", "1");
        request.setAttribute("pageSize", "5");
        TransData<Object> coupon = GusClientUtils.transfer(request, InterGusConstants.COMMON_COUPONCOMMON_GETRECOMMENDATIONCOUPONLIST);
        TransData<Object> activity = GusClientUtils.transfer(request, InterGusConstants.COMMON_ACTIVECOMMON_GETRECOMMENDATIONACTIVITYLIST);
        TransData<Object> goods = GusClientUtils.transfer(request, InterGusConstants.COMMON_GOODSCOMMON_GETRECOMMENDATIONGOODSLIST);
        request.setAttribute("recommendationGoodsList", goods.getData());
        request.setAttribute("recommendActivityResponseList", activity.getData());
        request.setAttribute("RecommendCouponResponseList", coupon.getData());
        request.setAttribute("pageIndex", "2");
        request.setAttribute("messageC", ExceptionCache.get(coupon.getHead().getResultCode()));
        request.setAttribute("messageA", ExceptionCache.get(activity.getHead().getResultCode()));
        request.setAttribute("messageG", ExceptionCache.get(goods.getHead().getResultCode()));
        return "favorite/favorite_index";
    }

    /**
     * 单个店家收藏首页
     * @param request infotype;//收藏类型，A-活动，G-商品，C-优惠券，P-其他
     * @param response
     * @return
     */
    @RequestMapping(params = "method=shopIndex")
    public String shopIndex(HttpServletRequest request, HttpServletResponse response)
    {
        this.getTime(request, response);
        request.setAttribute("shopId", request.getParameter("shopId"));
        return "favorite/favorite_shopIndex";
    }

    /**
     * 查询收藏商品
     * @param request
     * @param response*
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(params = "method=findFavoriteGoods")
    public String findFavoriteGoods(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<Object> goods = GusClientUtils.transfer(request, InterGusConstants.FAVORITE_FAVORITE_GETFAVORITEGOODSLIST);
        TransData<Object> guessLikeGoods = GusClientUtils.transfer(request, InterGusConstants.COMMON_GOODSCOMMON_GETGUESSLIKEGOODSLIST);
        if (goods.getHead().isSuccess())
        {
            PageModel<UFavoriteGoods> pm = (PageModel<UFavoriteGoods>) goods.getData();
            if (pm != null)
            {
                request.setAttribute("data", pm.getResult());
                request.setAttribute("count", pm.getResult().size());
            }
            request.setAttribute("pageModel", pm);
        }
        request.setAttribute("guess_recommendationGoodsList", guessLikeGoods.getData());
        request.setAttribute("message", ExceptionCache.get(goods.getHead().getResultCode()));
        return "favorite/favorite_goods";
    }

    /**
     * 查询收藏活动
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(params = "method=findFavoriteActivity")
    public String findFavoriteActivity(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("shopId", request.getParameter("shopId"));
        TransData<Object> activity = GusClientUtils.transfer(request, InterGusConstants.FAVORITE_FAVORITE_GETFAVORITEACTIVITYLIST);
        TransData<Object> guessLikeActivity = GusClientUtils.transfer(request, InterGusConstants.COMMON_ACTIVECOMMON_GETGUESSLIKEACTIVELIST);
        if (activity.getHead().isSuccess())
        {
            PageModel<UFavoriteActivity> pm = (PageModel<UFavoriteActivity>) activity.getData();
            if (pm != null)
            {
                request.setAttribute("data", pm.getResult());
                request.setAttribute("count", pm.getResult().size());
            }
            request.setAttribute("pageModel", pm);
        }
        request.setAttribute("guess_recommendationActivityList", guessLikeActivity.getData());
        request.setAttribute("message", ExceptionCache.get(activity.getHead().getResultCode()));
        return "favorite/favorite_activity";
    }

    /**
     * 查询收藏优惠凭证
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(params = "method=findFavoriteCoupon")
    public String findFavoriteCoupon(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("shopId", request.getParameter("shopId"));
        TransData<Object> coupon = GusClientUtils.transfer(request, InterGusConstants.FAVORITE_FAVORITE_GETFAVORITECOUPONLIST);
        TransData<Object> guessLikeCoupon = GusClientUtils.transfer(request, InterGusConstants.COMMON_COUPONCOMMON_GETGUESSLIKEACOUPONLIST);
        if (coupon.getHead().isSuccess())
        {
            PageModel<UFavoriteCoupon> pm = (PageModel<UFavoriteCoupon>) coupon.getData();
            if (pm != null)
            {
                request.setAttribute("data", pm.getResult());
                request.setAttribute("count", pm.getResult().size());
            }
            request.setAttribute("pageModel", pm);
        }

        request.setAttribute("guess_recommendationCouponList", guessLikeCoupon.getData());
        request.setAttribute("message", ExceptionCache.get(coupon.getHead().getResultCode()));
        return "favorite/favorite_coupon";
    }

    /**
     * 取消收藏
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=delFavorite")
    public void delFavorite(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        request.setAttribute("favoriteIds", request.getParameter("favoriteIds"));
        request.setAttribute("type", request.getParameter("type"));
        GusClientUtils.returnJson1(request, response, InterGusConstants.FAVORITE_FAVORITE_DELETEFAVORITE);
    }

    @RequestMapping(params = "method=favoiteshopType")
    public String favoiteshopType(HttpServletRequest request, HttpServletResponse response)
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_SHOPTYPECOMMON_GETSHOPTYPELIST);
        return "favorite/favorite_shopType";
    }

    @RequestMapping(params = "method=favoiteshopTypeA")
    public String favoiteshopTypeA(HttpServletRequest request, HttpServletResponse response)
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_SHOPTYPECOMMON_GETSHOPTYPELIST);
        return "favorite/favorite_shopTypeA";
    }

    @RequestMapping(params = "method=favoiteshopTypeG")
    public String favoiteshopTypeG(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_SHOPTYPECOMMON_GETSHOPTYPELIST);
        return "favorite/favorite_shopTypeG";
    }

    @RequestMapping(params = "method=favoiteShopInfo")
    public String favoiteShopInfo(HttpServletRequest request, HttpServletResponse response)
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_SHOPCOMMON_GETSHOPLIST);
        return "favorite/favorite_shopInfo";
    }

    @RequestMapping(params = "method=favoiteShopInfoA")
    public String favoiteShopInfoA(HttpServletRequest request, HttpServletResponse response)
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_SHOPCOMMON_GETSHOPLIST);
        return "favorite/favorite_shopInfoA";
    }

    @RequestMapping(params = "method=favoiteShopInfoG")
    public String favoiteShopInfoG(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_SHOPCOMMON_GETSHOPLIST);
        return "favorite/favorite_shopInfoG";
    }

    private void getTime(HttpServletRequest request, HttpServletResponse response)
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
    }

    /**
     * 更多推荐首页
     * @param request infotype;
     * @param response
     * @return
     */
    @RequestMapping(params = "method=moreRecommend")
    public String moreRecommend(HttpServletRequest request, HttpServletResponse response)
    {
        return "favorite/recommend_index";
    }

    /**
     * 更多商品推荐
     * @param request infotype;
     * @param response
     * @return
     */
    @RequestMapping(params = "method=moreGoodsRecommend")
    public String moreGoodsRecommend(HttpServletRequest request, HttpServletResponse response)
    {
        this.getTime(request, response);
        request.setAttribute("pageIndex", request.getParameter("pageIndex"));
        request.setAttribute("pageSize", request.getParameter("pageSize"));
        TransData<Object> goods = GusClientUtils.transfer(request, InterGusConstants.COMMON_GOODSCOMMON_GETRECOMMENDATIONGOODSLIST);
        request.setAttribute("recommendationGoodsList", goods.getData());
        return "favorite/recommend_goods";
    }

    /**
     * 更多活动推荐
     * @param request infotype;
     * @param response
     * @return
     */
    @RequestMapping(params = "method=moreActivityRecommend")
    public String moreActivityRecommend(HttpServletRequest request, HttpServletResponse response)
    {
        this.getTime(request, response);
        request.setAttribute("pageIndex", "1");
        request.setAttribute("pageSize", "5");
        TransData<Object> activity = GusClientUtils.transfer(request, InterGusConstants.COMMON_ACTIVECOMMON_GETRECOMMENDATIONACTIVITYLIST);
        request.setAttribute("recommendActivityResponseList", activity.getData());
        return "favorite/recommend_activity";
    }

    /**
     * 更多优惠凭证推荐
     * @param request infotype;
     * @param response
     * @return
     */
    @RequestMapping(params = "method=moreCouponRecommend")
    public String moreCouponRecommend(HttpServletRequest request, HttpServletResponse response)
    {
        this.getTime(request, response);
        request.setAttribute("pageIndex", "1");
        request.setAttribute("pageSize", "5");
        TransData<Object> coupon = GusClientUtils.transfer(request, InterGusConstants.COMMON_COUPONCOMMON_GETRECOMMENDATIONCOUPONLIST);
        request.setAttribute("RecommendCouponResponseList", coupon.getData());
        return "favorite/recommend_coupon";
    }

}
