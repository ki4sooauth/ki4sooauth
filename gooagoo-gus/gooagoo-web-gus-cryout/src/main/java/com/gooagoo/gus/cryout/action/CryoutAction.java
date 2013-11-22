package com.gooagoo.gus.cryout.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;

@Controller
@RequestMapping("/cryout")
public class CryoutAction extends BaseAction
{

    /**
     * 吆喝首页
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        return "/cryout/cryout/index";
    }

    /**
     * 获取感兴趣商家列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=interestedShopListRequest")
    public String interestedShopListRequest(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("pageIndex", 1);
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_SHOPCOMMON_GETRECOMMENDATIONSHOPLIST);

        return "/cryout/cryout/interestedshoplist";
    }

    /**
     * 关注商家
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=attentionShop")
    public void attentionShop(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.CRYOUT_CRYOUT_ATTENTION);
    }

    /**
     * 获取吆喝列表
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=cryoutListRequest")
    public String cryoutListRequest(HttpServletRequest request, HttpServletResponse response)
    {
        String loadType = request.getParameter("loadType");//加载类型：1-首次加载，2-追加加载（分页）
        GusClientUtils.returnData(request, response, InterGusConstants.CRYOUT_CRYOUT_GETCRYOUTLIST);
        if ("1".equals(loadType))
        {
            return "/cryout/cryout/cryoutlist";
        }
        else if ("2".equals(loadType))
        {
            return "/cryout/cryout/morecryoutlist";
        }

        return null;
    }

    /**
     * 统计最新吆喝数量
     * 
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(params = "method=countNewCryoutRequest")
    public String countNewCryoutRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnData(request, response, InterGusConstants.CRYOUT_CRYOUT_COUNTNEWCRYOUT);
        return "/cryout/cryout/cryoutcount";
    }

    /**
     * 吆喝商品加入购物清单
     * 
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=addShoppingListRequest")
    public void addShoppingListRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.CRYOUT_CRYOUT_ADDTOSHOPPINGLIST);
    }

    /**
     * 收藏吆喝关联商品
     * 
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=favoriteGoodsRequest")
    public void favoriteGoodsRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.CRYOUT_CRYOUT_FAVORITEGOODS);
    }

    /**
     * 收藏吆喝关联活动
     * 
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=favoriteActiveRequest")
    public void favoriteActiveRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.CRYOUT_CRYOUT_FAVORITEACTIVE);
    }

    /**
     * 收藏吆喝关联优惠凭证
     * 
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=favoriteCouponRequest")
    public void favoriteCouponRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.CRYOUT_CRYOUT_FAVORITECOUPON);
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
