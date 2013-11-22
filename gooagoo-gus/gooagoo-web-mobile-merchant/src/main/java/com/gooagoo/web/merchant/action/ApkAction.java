package com.gooagoo.web.merchant.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;

/**
 * 手机活动
 * @author  GOOAGOO
 *
 */
@Controller
@RequestMapping("/apk")
public class ApkAction extends BaseAction
{

    @RequestMapping(params = "method=download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<Object> transData = GusClientUtils.transfer(request, InterGusConstants.COMMON_IGUS001);
        if (transData.getHead().isSuccess() && StringUtils.isNotBlank((String) transData.getData()))
        {
            response.sendRedirect((String) transData.getData());
        }
    }

    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<Object> transData = GusClientUtils.transfer(request, InterGusConstants.COMMON_IGUS001);
        if (transData.getHead().isSuccess() && StringUtils.isNotBlank((String) transData.getData()))
        {
            request.setAttribute("downloadurl", transData.getData());
        }
        return "/merchant/apk/index";
    }

}
