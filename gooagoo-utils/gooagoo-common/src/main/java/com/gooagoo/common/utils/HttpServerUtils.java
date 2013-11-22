package com.gooagoo.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.log.GooagooLog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HttpServerUtils
{

    private final static String INTERFACE_SERIAL = "com.gooagoo.interface.serial";
    private final static String INTERFACE_CODE = "com.gooagoo.interface.code";
    private final static String INTERFACE_OBJ = "CType";
    private final static String INTERFACE_MET = "MType";
    private final static String SYS_SYSTEM_EXCEPTION = "S005";

    /**
     * 服务器端接收请求方法
     * @param request
     * @param response
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static TransData<Object> doService(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        log(request.getParameterMap(), "Server Receive:");

        String code = ServletRequestUtils.getStringParameter(request, INTERFACE_CODE, "");//接口编码
        String serial = ServletRequestUtils.getStringParameter(request, INTERFACE_SERIAL, "");//流水号
        String serviceName = ServletRequestUtils.getStringParameter(request, INTERFACE_OBJ, "");//具体接口对象名称（spring注入的名称）
        String methodName = ServletRequestUtils.getStringParameter(request, INTERFACE_MET, "");//具体接口调用的方法名

        TransData<Object> transData = null;
        try
        {
            Object bean = SpringBeanUtils.getBean(serviceName);
            Method method = bean.getClass().getMethod(methodName, HttpServletRequest.class);
            transData = (TransData<Object>) method.invoke(bean, request);
        }
        catch (InvocationTargetException e)
        {
            Throwable t = e.getTargetException();
            if (t.getClass().getName().indexOf("MessageException") > -1)
            {
                transData = new TransData<Object>(false, t.getMessage(), null);
                GooagooLog.error("MessageException:", t);
            }
            else
            {
                transData = new TransData<Object>(false, SYS_SYSTEM_EXCEPTION, null);
                GooagooLog.error("接口处理异常，serviceName=" + serviceName + ",methodName=" + methodName, e);
            }
        }
        catch (Exception e)
        {
            transData = new TransData<Object>(false, SYS_SYSTEM_EXCEPTION, null);
            GooagooLog.error("接口处理异常，serviceName=" + serviceName + ",methodName=" + methodName, e);
        }
        transData.getHead().setTradeCode(code);
        transData.getHead().setSerialNo(serial);
        transData.getHead().setTradeTime(TimeUtils.getCurrentDateTime());

        log(transData, "Server Send:");

        ServletUtils.writeOjbect(transData, response);

        return transData;
    }

    /**
     * 写日志
     * @param object
     * @param head
     */
    private static void log(Object object, String head)
    {
        if (object instanceof String)
        {
            GooagooLog.debug(head + object);
        }
        else
        {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
            String json = gson.toJson(object);
            GooagooLog.debug(head + json);
        }
    }
}
