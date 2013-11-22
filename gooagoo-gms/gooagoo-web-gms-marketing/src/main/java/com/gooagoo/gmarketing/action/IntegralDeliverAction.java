package com.gooagoo.gmarketing.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.marketing.FShopIntegralConvert;

/**
 * 积分兑换
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/integralDeliver")
public class IntegralDeliverAction extends BaseAction
{

    /**
     * 主页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        String shopIntegralId = ServletRequestUtils.getStringParameter(request, "shopIntegralId", "");
        request.setAttribute("shopIntegralId", shopIntegralId);
        return "integralDeliver/index";
    }

    /**
     * 积分发放列表
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=list")
    public String list(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<PageModel> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_INTEGRALDELIVER_PAGE, request, PageModel.class);
        PageModel<FShopIntegralConvert> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));

        }
        return "integralDeliver/integralDeliver_list";
    }

    /**
     * 积分发放
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=deliver")
    public void deliver(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String integralConvertId = ServletRequestUtils.getStringParameter(request, "id", "");
        if (StringUtils.hasText(integralConvertId))
        {
            GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_INTEGRALDELIVER_DELIVER, request, response);
        }
    }

}
