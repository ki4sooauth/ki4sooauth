package com.gooagoo.trans.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.SpringBeanUtils;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.trans.common.BehaveUtil;
import com.gooagoo.trans.common.MessageConst;
import com.gooagoo.trans.entity.resultbase.transform.ResultRoot;
import com.gooagoo.trans.entity.transdata.GtsTransData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/trans")
public class TransAction extends BaseAction
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
            if (!StringUtils.hasText(code))
            {
                GooagooLog.warn("未获取到接口编码");
                return;
            }
            Object bean = SpringBeanUtils.getBean(code);
            Method method = bean.getClass().getMethod("doItrans", HttpServletRequest.class);
            transData = method.invoke(bean, request);
        }
        catch (InvocationTargetException e)
        {
            Throwable t = e.getTargetException();
            if (t instanceof GooagooException)
            {
                resultRoot = new ResultRoot();
                resultRoot.setResult("false");
                resultRoot.setMsg(t.getMessage());
            }
            else
            {
                resultRoot = new ResultRoot();
                resultRoot.setResult("false");
                resultRoot.setMsg(ExceptionCache.get(MessageConst.TRANS_COMMON_SYSTEM_EXCEPTION));
            }
            GooagooLog.error("接口处理异常，接口编码=" + code, e);
        }
        catch (Exception e)
        {
            resultRoot = new ResultRoot();
            resultRoot.setResult("false");
            resultRoot.setMsg(ExceptionCache.get(MessageConst.TRANS_COMMON_SYSTEM_EXCEPTION));
            GooagooLog.error("接口处理异常，接口编码=" + code, e);
        }
        GtsTransData gtsTransData = null;
        if (resultRoot != null)
        {
            gtsTransData = new GtsTransData();
            gtsTransData.setResultJson(resultRoot.toJson());
            transData = gtsTransData;
        }
        transData = log(transData);
        if (gtsTransData == null)
        {
            gtsTransData = JsonUtils.toObj(transData.toString(), GtsTransData.class);
        }

        BehaveUtil.sendShopLog(request, gtsTransData);
        ServletUtils.writeHtml(gtsTransData.getResultJson(), response);
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