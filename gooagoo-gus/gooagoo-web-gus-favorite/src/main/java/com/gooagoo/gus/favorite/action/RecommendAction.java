package com.gooagoo.gus.favorite.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;

/**
 * 推荐视图层Action
 * @author Jun
 *
 */
@Controller
@RequestMapping("/recommendation")
public class RecommendAction extends BaseAction
{
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("pageIndex", "1");
        request.setAttribute("pageSize", "6");
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_GOODSCOMMON_GETRECOMMENDATIONGOODSLIST);
        return "favorite/favorite_index";
    }
}
