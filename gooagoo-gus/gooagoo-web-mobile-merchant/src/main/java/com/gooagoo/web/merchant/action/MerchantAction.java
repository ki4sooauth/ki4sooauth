package com.gooagoo.web.merchant.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.gus.utils.UrlDecode;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.view.gus.common.UrlInfo;

/**
 * 手机虚拟商家
 * @author GOOAGOO
 *
 */
@Controller
@RequestMapping("/merchant")
public class MerchantAction extends BaseAction
{

    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            String para = ServletRequestUtils.getRequiredStringParameter(request, "para");
            GooagooLog.info("手机虚拟商家请求参数：" + para);
            UrlInfo info = UrlDecode.decodeInfo(para);
            return "forward:/" + info.getAction() + ".do?method=mobile&para=" + para;
        }
        catch (Exception e)
        {
            GooagooLog.error("手机虚拟商家地址解析异常", e);
            return null;
        }
    }

}
