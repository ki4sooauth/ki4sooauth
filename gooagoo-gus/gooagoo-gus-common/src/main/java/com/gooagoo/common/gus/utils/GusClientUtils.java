package com.gooagoo.common.gus.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.cache.InterfaceCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.HttpClientUtils;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gus.common.Ajax;
import com.google.gson.Gson;

/**
 * GUS调用接口工具类
 * @author GUS
 *
 */
public class GusClientUtils
{

    /**
     * 接口调用
     * <br>
     * 适用于将接口返回数据放到request中
     * <br>
     * 数据存放详细如下：
     * <br>
     * request.setAttribute("isSuccess", transData.getHead().isSuccess())
     * <br>
     * request.setAttribute("message", ExceptionCache.get(transData.getHead().getResultCode()))
     * <br>
     * request.setAttribute("data", transData.getData())
     * @param request
     * @param response
     * @param interfaceCode
     */
    public static void returnData(HttpServletRequest request, HttpServletResponse response, String interfaceCode)
    {
        TransData<Object> transData = HttpClientUtils.transfer(interfaceCode, convertCode2Url(interfaceCode), request, Object.class);
        request.setAttribute("isSuccess", transData.getHead().isSuccess());
        request.setAttribute("message", ExceptionCache.get(transData.getHead().getResultCode()));//提示信息
        if (transData.getHead().isSuccess())
        {
            request.setAttribute("data", transData.getData());
        }
    }

    /**
     * 接口调用
     * <br>
     * 适用于将接口返回数据通过json格式写入流中
     * <br>
     * 数据存放详细如下：
     * <br>
     * Ajax ajax = new Ajax()
     * <br>
     * ajax.setSuccess(transData.getHead().isSuccess())
     * <br>
     * ajax.setMessage(ExceptionCache.get(transData.getHead().getResultCode()))
     * <br>
     * ajax.setData(transData.getData())
     * @param request
     * @param response
     * @param interfaceCode
     * @throws IOException
     */
    public static void returnJson1(HttpServletRequest request, HttpServletResponse response, String interfaceCode) throws IOException
    {
        TransData<Object> transData = HttpClientUtils.transfer(interfaceCode, convertCode2Url(interfaceCode), request, Object.class);
        Ajax ajax = new Ajax();
        ajax.setSuccess(transData.getHead().isSuccess());
        ajax.setMessage(ExceptionCache.get(transData.getHead().getResultCode()));//提示信息
        ajax.setData(transData.getData());//交互数据
        ServletUtils.writeHtml(new Gson().toJson(ajax), response);
    }

    /**
     * 接口调用
     * <br>
     * 适用于将接口返回数据通过json格式写入流中，跨域ajax请求
     * <br>
     * 数据存放详细如下：
     * <br>
     * Ajax ajax = new Ajax()
     * <br>
     * ajax.setSuccess(transData.getHead().isSuccess())
     * <br>
     * ajax.setMessage(ExceptionCache.get(transData.getHead().getResultCode()))
     * <br>
     * ajax.setData(transData.getData())
     * @param request
     * @param response
     * @param interfaceCode
     * @throws IOException
     */
    public static void returnJson2(HttpServletRequest request, HttpServletResponse response, String interfaceCode) throws Exception
    {
        TransData<Object> transData = HttpClientUtils.transfer(interfaceCode, convertCode2Url(interfaceCode), request, Object.class);
        Ajax ajax = new Ajax();
        ajax.setSuccess(transData.getHead().isSuccess());
        ajax.setMessage(ExceptionCache.get(transData.getHead().getResultCode()));//提示信息
        ajax.setData(transData.getData());//交互数据
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String jsonpCallback = ServletRequestUtils.getStringParameter(request, "jsonpCallback");
        out.write(jsonpCallback + "(" + new Gson().toJson(ajax) + ")");
        out.flush();
        out.close();
    }

    /**
     * 接口调用
     * <br>
     * 适用于定制化处理接口调用返回的数据
     * @param request
     * @param interfaceCode
     * @return
     */
    public static TransData<Object> transfer(HttpServletRequest request, String interfaceCode)
    {
        TransData<Object> transData = HttpClientUtils.transfer(interfaceCode, convertCode2Url(interfaceCode), request, Object.class);

        return transData;
    }

    /**
     * 接口编码转地址
     * @param interfaceCode
     * @return
     */
    private static String convertCode2Url(String interfaceCode)
    {
        return InterfaceCache.get(interfaceCode).getIUrl();
    }

}
