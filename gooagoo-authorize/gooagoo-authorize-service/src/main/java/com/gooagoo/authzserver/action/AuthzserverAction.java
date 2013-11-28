package com.gooagoo.authzserver.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.authzserver.OAuthParam;
import com.gooagoo.authzserver.entity.IssuerTransData;
import com.gooagoo.authzserver.entity.ResultRoot;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.SpringBeanUtils;
import com.gooagoo.exception.GooagooException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/authorize")
public class AuthzserverAction extends BaseAction
{

    /**
     * 接口服务入口
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping
    public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        Map<?, ?> parameterMap = request.getParameterMap();
        Gson gson = new Gson();
        log("Server Receive:" + gson.toJson(parameterMap));
        //itype 作为接口名参数
        String itype = null;
        String authorizationcode = ServletRequestUtils.getStringParameter(request, OAuthParam.OAUTH_RESPONSE_TYPE, "");//接口编码
        String accesstoken = ServletRequestUtils.getStringParameter(request, OAuthParam.OAUTH_GRANT_TYPE, "");
        if (!StringUtils.isBlank(authorizationcode))
        {
            if (authorizationcode == "code")
            {
                itype = authorizationcode;
            }
        }
        if (!StringUtils.isBlank(accesstoken))
        {
            if (accesstoken == "authorization_code")
            {
                itype = accesstoken;
            }
        }
        Object IssuerData = null;
        ResultRoot resultRoot = null;
        try
        {
            if (!StringUtils.isBlank(itype))
            {
                Object bean = SpringBeanUtils.getBean(itype);
                Method method = bean.getClass().getMethod("doIAuthIssuer", HttpServletRequest.class);
                IssuerData = method.invoke(bean, request);
            }
        }
        catch (InvocationTargetException e)
        {
            Throwable t = e.getTargetException();
            if (t instanceof GooagooException)
            {
                t.printStackTrace();
                resultRoot = new ResultRoot();
                resultRoot.setResult("false");
                resultRoot.setMsg(t.getMessage());
            }
            else
            {
                resultRoot = new ResultRoot();
                resultRoot.setResult("false");
            }
            GooagooLog.error("接口处理异常，接口编码=" + itype + ",异常信息信息为:" + e.getMessage(), e);
        }
        catch (Exception e)
        {
            resultRoot = new ResultRoot();
            resultRoot.setResult("false");
            GooagooLog.error("接口处理异常，接口编码=" + itype + ",异常信息信息为:" + e.getMessage(), e);
        }
        IssuerTransData mobileTransData = null;
        if (resultRoot != null)
        {
            mobileTransData = new IssuerTransData();
            mobileTransData.setResultJson(resultRoot.toJson());
            IssuerData = mobileTransData;
        }
        if (mobileTransData == null)
        {
            mobileTransData = JsonUtils.toObj(IssuerData.toString(), IssuerTransData.class);
        }

        IssuerData = log(IssuerData);

        ServletUtils.writeHtml(mobileTransData.getResultJson(), response);
    }

    /**
     * 写日志
     * @param object
     * @param head
     */
    private static String log(Object object)
    {
        String result = null;
        if (object instanceof String)
        {
            GooagooLog.debug(object);
            result = (String) object;
        }
        else
        {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
            String json = gson.toJson(object);
            GooagooLog.debug(json);
            result = json;
        }
        return result;
    }
}
