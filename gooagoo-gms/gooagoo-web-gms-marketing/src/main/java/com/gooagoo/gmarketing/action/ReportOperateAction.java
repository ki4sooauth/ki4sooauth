package com.gooagoo.gmarketing.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.log.GooagooLog;

@Controller
@RequestMapping("/reportOperate")
public class ReportOperateAction extends BaseAction
{
    /**
     * 导入Excel页面
     * @param request
     * @param response
     */
    @RequestMapping(params = "method=importExcelPage")
    public String importExcelPage(HttpServletRequest request, HttpServletResponse response)
    {
        String url = ServletRequestUtils.getStringParameter(request, "url", "");
        String couponId = ServletRequestUtils.getStringParameter(request, "couponId", "");
        if (couponId != null)
        {
            request.setAttribute("coupon_Id", couponId);
            request.setAttribute("url", url + "&id=" + couponId);
        }
        else
        {
            GooagooLog.info("导入excel时，优惠凭证ID不能为空");
        }

        return "/upload/reportOperate";
    }
}
