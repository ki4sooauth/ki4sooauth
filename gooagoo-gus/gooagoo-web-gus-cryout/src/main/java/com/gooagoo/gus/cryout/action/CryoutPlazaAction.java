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
@RequestMapping("/cryoutPlaza")
public class CryoutPlazaAction extends BaseAction
{

    /**
     * 吆喝广场首页
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        return "/cryout/cryoutplaza/index";
    }

    /**
     * 获取吆喝列表首次加载，还是第二次加载
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=cryoutListRequest")
    public String cryoutListRequest(HttpServletRequest request, HttpServletResponse response)
    {
        String loadType = request.getParameter("loadType");//加载类型：1-首次加载，2-追加加载（分页）
        GusClientUtils.returnData(request, response, InterGusConstants.CRYOUT_CRYOUTPLAZA_GETCRYOUTLIST);
        if ("1".equals(loadType))
        {
            return "/cryout/cryoutplaza/cryoutlist";
        }
        else if ("2".equals(loadType))
        {
            return "/cryout/cryoutplaza/morecryoutlist";
        }

        return null;
    }

    /**
     * 获取吆喝列表
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=moreCryoutListRequest")
    public String moreCryoutListRequest(HttpServletRequest request, HttpServletResponse response)
    {
        GusClientUtils.returnData(request, response, InterGusConstants.CRYOUT_CRYOUTPLAZA_GETCRYOUTLIST);
        return "/cryout/cryoutplaza/morecryoutlist";
    }

    /**
     * 获取商家类型列表
     * 
     * @param request
     * @param response
     * @return
     * @throws InterruptedException
     */
    @RequestMapping(params = "method=shopTypeListRequest")
    public String shopTypeListRequest(HttpServletRequest request, HttpServletResponse response) throws InterruptedException
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_SHOPTYPECOMMON_GETSHOPTYPELIST);
        return "/cryout/cryoutplaza/shoptypelist";
    }

    /**
     * 根据商家类型编号(shopTypeId)获取商家 
     * 
     * @param request
     * @param response
     * @return
     * @throws InterruptedException
     */
    @RequestMapping(params = "method=shopByShopTypeIdRequest")
    public String shopByShopTypeIdRequest(HttpServletRequest request, HttpServletResponse response) throws InterruptedException
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_SHOPCOMMON_GETSHOPLIST);
        return "/cryout/cryoutplaza/shoplist";
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
        GusClientUtils.returnJson1(request, response, InterGusConstants.CRYOUT_CRYOUTPLAZA_ADDTOSHOPPINGLIST);
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
        GusClientUtils.returnJson1(request, response, InterGusConstants.CRYOUT_CRYOUTPLAZA_FAVORITEGOODS);
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
        GusClientUtils.returnJson1(request, response, InterGusConstants.CRYOUT_CRYOUTPLAZA_FAVORITEACTIVE);
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
        GusClientUtils.returnJson1(request, response, InterGusConstants.CRYOUT_CRYOUTPLAZA_FAVORITECOUPON);
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
