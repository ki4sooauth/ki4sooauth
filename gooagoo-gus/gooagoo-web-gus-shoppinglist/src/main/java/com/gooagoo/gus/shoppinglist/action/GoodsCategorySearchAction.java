package com.gooagoo.gus.shoppinglist.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;

@Controller
@RequestMapping("/goodsCategorySearch")
public class GoodsCategorySearchAction extends BaseAction
{
    /**
     * 根据商品类别查询页
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=index")
    public String goodsCategorySearch(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("parentId", "-1");
        request.setAttribute("shoppingListId", request.getParameter("shoppingListId"));
        GusClientUtils.returnData(request, response, InterGusConstants.SHOPPINGLIST_SHOPPINGLIST_GETSHOPPINGLISTGOODSTYPELIST);
        return "/shoppinglist/shoppinglist/goods_category_search";
    }

    /**
     * 商品类别
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=findCategory")
    public String findCategory(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("parentId", request.getParameter("parentId"));
        request.setAttribute("shoppingListId", request.getParameter("shoppingListId"));
        GusClientUtils.returnData(request, response, InterGusConstants.SHOPPINGLIST_SHOPPINGLIST_GETSHOPPINGLISTGOODSTYPELIST);
        return "/shoppinglist/shoppinglist/goods_category_table";
    }
}
