package com.gooagoo.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.MessageConst;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.SpringBeanUtils;
import com.gooagoo.entity.resultbase.transform.ResultRoot;
import com.gooagoo.exception.GooagooException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/crm")
public class CrmAction extends BaseAction
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
        String code = ServletRequestUtils.getStringParameter(request, "itype", "");//接口编码
        Object transData = null;
        ResultRoot resultRoot = null;
        try
        {
            Object bean = SpringBeanUtils.getBean(code);
            Method method = bean.getClass().getMethod("doService", HttpServletRequest.class);
            transData = method.invoke(bean, request);
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
                String err = MessageConst.MOBILE_COMMON_SYSTEM_EXCEPTION;
                resultRoot.setMsg(ExceptionCache.get(err));
                resultRoot.setMsgcode(err);
            }
            GooagooLog.error("接口处理异常，接口编码=" + code + ",异常信息信息为:" + e.getMessage(), e);
        }
        catch (Exception e)
        {
            resultRoot = new ResultRoot();
            resultRoot.setResult("false");
            String err = MessageConst.MOBILE_COMMON_SYSTEM_EXCEPTION;
            resultRoot.setMsg(ExceptionCache.get(err));
            resultRoot.setMsgcode(err);
            GooagooLog.error("接口处理异常，接口编码=" + code + ",异常信息信息为:" + e.getMessage(), e);
        }
        if (resultRoot != null)
        {
            transData = resultRoot;
        }

        transData = log(transData);
        ServletUtils.writeHtml(transData.toString(), response);
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
