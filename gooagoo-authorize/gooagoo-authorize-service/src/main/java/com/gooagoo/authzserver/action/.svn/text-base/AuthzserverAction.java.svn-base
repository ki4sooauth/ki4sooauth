package com.gooagoo.authzserver.action;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.authzserver.entity.InterfaceUtils;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.SpringBeanUtils;
import com.gooagoo.entity.business.auth.CodeResponse;
import com.google.gson.Gson;

@Controller
@RequestMapping("/authorize")
public class AuthzserverAction extends BaseAction
{
    /**
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping
    public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String code = ServletRequestUtils.getStringParameter(request, "appMethod", "").toLowerCase();//接口编码
        String state = ServletRequestUtils.getStringParameter(request, "state", "");
        GooagooLog.info(InterfaceUtils.getLogMsg(request, code));
        Object resultData = null;
        if (StringUtils.hasText(code))
        {
            try
            {
                Object bean = SpringBeanUtils.getBean(code);
                Method method = bean.getClass().getMethod("doIAuthIssuer", HttpServletRequest.class);
                resultData = method.invoke(bean, request);
                GooagooLog.info("CRM返回数据:" + resultData);
            }
            catch (Exception e)
            {
                //resultData = ExceptionMessageUtils.getGooagooExceptionMessage(e, resultData);
            }
        }
        else
        {
            GooagooLog.warn("调用接口异常，接口编码不能为空");
            //resultData = new ErrorMessage(ErrorConstants.CRM_CALL_INTERFACE_EXCEPTION, ExceptionCache.get(ErrorConstants.CRM_CALL_INTERFACE_EXCEPTION));
        }
        if (code.equals("authorization_code"))
        {
            ServletUtils.writeHtml(new Gson().toJson(resultData), response);
        }
        if (code.equals("code"))
        {
            CodeResponse codeResponse = (CodeResponse) resultData;
            ServletUtils.writeOjbect(codeResponse, response);
        }
    }
}
