package com.gooagoo.gus.shoppinglist.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;

/**
 * 用户购物清单视图层Action
 * @author Jun
 *
 */
@Controller
@RequestMapping("/shoppingList")
public class ShoppingListAction extends BaseAction
{

    /**
     * 购物清单首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        return "/shoppinglist/shoppinglist/shoppingList_index";
    }

    /**
     * 查询购物清单
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=findShoppingList")
    public String findShoppingList(HttpServletRequest request, HttpServletResponse response)
    {
        GusClientUtils.returnData(request, response, InterGusConstants.SHOPPINGLIST_SHOPPINGLIST_GETSHOPPINGLISTLIST);
        return "/shoppinglist/shoppinglist/shoppingList_shoppinglist";
    }

    /**
     * 查询单个购物清单
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=personalshoplist")
    public String personalshoplist(HttpServletRequest request, HttpServletResponse response)
    {
        GusClientUtils.returnData(request, response, InterGusConstants.SHOPPINGLIST_SHOPPINGLIST_GETSHOPPINGLISTINFO);
        return "/shoppinglist/shoppinglist/shoplist_personal";
    }

    /**
     * 查询购物清单中商品
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=getShoppingGoods")
    public String getShoppingGoods(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("shoppingListId", request.getParameter("shoppingListId"));
        GusClientUtils.returnData(request, response, InterGusConstants.SHOPPINGLIST_SHOPPINGLIST_GETSHOPPINGLISTGOODS);

        return "/shoppinglist/shoppinglist/shoppingList_goods";
    }

    /**
     * 购物清单添加商品页
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=addGoodsByHand")
    public String addGoodsByHand(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("shoppingListId", request.getParameter("shoppingListId"));
        return "/shoppinglist/shoppinglist/shoppingList_addgoodsbyhand";

    }

    /**
     * 购物清单添加商品页
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=addGoodsByQuery")
    public String addGoodsByQuery(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("shoppingListId", request.getParameter("shoppingListId"));
        return "/shoppinglist/shoppinglist/shoppingList_addgoodsbyquery";

    }

    /**
     * 添加购物清单页面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=addShoppingList")
    public String addShoppingList(HttpServletRequest request, HttpServletResponse response)
    {
        return "/shoppinglist/shoppinglist/shoppingList_add";
    }

    /**
     * 添加购物清单
     * @param request
     * @param response
     * @return
     * @throws IOException 
     * @throws Exception
     */
    @RequestMapping(params = "method=addShoppingListDo")
    public void addShoppingListDo(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.SHOPPINGLIST_SHOPPINGLIST_ADDSHOPPINGLIST);
    }

    /**
     * 删除购物清单
     * @param request
     * @param response
     * @return
     * @throws IOException 
     * @throws Exception
     */

    @RequestMapping(params = "method=delShppingList")
    public void delShppingList(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.SHOPPINGLIST_SHOPPINGLIST_DELETESHOPPINGLIST);
    }

    /**
     * 编辑购物清单页
     * @param request
     * @param response
     * @return
     * @throws Exception
     */

    @RequestMapping(params = "method=updateShppingList")
    public String updateShppingList(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("shopppingListId", request.getParameter("shoppingListId"));
        GusClientUtils.returnData(request, response, InterGusConstants.SHOPPINGLIST_SHOPPINGLIST_GETSHOPPINGLISTINFO);
        return "/shoppinglist/shoppinglist/shoppingList_edit";
    }

    /**
     * 编辑购物清单
     * @param request
     * @param response
     * @return
     * @throws IOException 
     * @throws Exception
     */

    @RequestMapping(params = "method=updateShppingListDo")
    public void updateShppingListDo(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.SHOPPINGLIST_SHOPPINGLIST_UPDATESHOPPINGLIST);
    }

    /**
     * 添加商品到购物清单
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=addGoodsForShoppingList")
    public void addGoodsForShoppingList(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.SHOPPINGLIST_SHOPPINGLIST_ADDTOSHOPPINGLIST);
    }

    /**
     * 删除购物清单中商品
     * @param request
     * @param response
     * @return
     * @throws IOException 
     * @throws Exception
     */

    @RequestMapping(params = "method=delGoodsForShoppingList")
    public void delGoodsForShoppingList(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.SHOPPINGLIST_SHOPPINGLIST_DELETESHOPPINGLISTGOODS);
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
