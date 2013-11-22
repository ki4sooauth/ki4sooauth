package com.gooagoo.web.merchant.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;
import com.gooagoo.common.gus.utils.UrlDecode;
import com.gooagoo.view.gus.common.UrlInfo;

/**
 * 手机区域商品销量排行
 * @author  GUS
 *
 */
@Controller
@RequestMapping("/rank")
public class RankAction extends BaseAction
{

    @RequestMapping(params = "method=mobile")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        UrlInfo info = UrlDecode.decodeInfo(ServletRequestUtils.getRequiredStringParameter(request, "para"));
        request.setAttribute("positionId", info.getTypeId());

        return "/merchant/rank/index";
    }

    @RequestMapping(params = "method=contentRequest")
    public String contentRequest(HttpServletRequest request, HttpServletResponse response)
    {
        GusClientUtils.returnData(request, response, InterGusConstants.MERCHANT_MOBILE_GETPOSITIONMARKETINGRANK);

        return "/merchant/rank/content";
    }

}
