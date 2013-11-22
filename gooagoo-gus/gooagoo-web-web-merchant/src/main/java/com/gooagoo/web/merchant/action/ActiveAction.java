package com.gooagoo.web.merchant.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;

/**
 * 网站活动
 * @author  GOOAGOO
 *
 */
@Controller
@RequestMapping("/active")
public class ActiveAction extends BaseAction
{

    @RequestMapping(params = "method=contentRequest")
    public void contentRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GusClientUtils.returnJson2(request, response, InterGusConstants.MERCHANT_WEB_GETACTIVEDATA);
    }

    @RequestMapping(params = "method=favoriteActiveRequest")
    public void favoriteActiveRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GusClientUtils.returnJson2(request, response, InterGusConstants.MERCHANT_WEB_FAVORITEACTIVE);
    }

}
