package com.gooagoo.authzserver.entity;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.entity.para.Parameter;
import com.google.gson.Gson;

public class InterfaceUtils
{

    /**
     * interface接口，收集传入参数
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Parameter collectParameter(HttpServletRequest request)
    {
        Parameter parameter = new Parameter(request.getParameterMap());
        return parameter;
    }

    /**
     * 传入参数打印
     * $
     * getLogMsg
     * InterfaceUtils
     * @param 
     * @param request
     * @param interfaceName
     * @return String
     */
    public static String getLogMsg(HttpServletRequest request, String interfaceName)
    {
        @SuppressWarnings("unchecked")
        Map<String, String[]> map = request.getParameterMap();
        StringBuffer Msg = new StringBuffer();
        Msg.append("接口" + interfaceName + "传入参数:【 ").append(new Gson().toJson(map)).append(" 】");
        return Msg.toString();
    }

}
