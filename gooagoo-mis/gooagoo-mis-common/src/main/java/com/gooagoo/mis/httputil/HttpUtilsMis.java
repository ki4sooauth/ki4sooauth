package com.gooagoo.mis.httputil;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.cache.InterfaceCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.HttpClientUtils;
import com.gooagoo.entity.casclient.mis.MisLoginInfo;

/**
 * 公共工具类
 * @author Administrator
 *
 */
public class HttpUtilsMis
{
    /**
     * web层通过此方法调用interface层（公用）
     * 会同时传递Parametert和Attribute中的参数
     * 如果Parametert和Attribute参数重名则接收端会以数组的形式全都取到
     * @param code
     * @param request
     * @param clazz GResponse对象内集合的类型
     * @return GResponse对象
     */
    public static <T> TransData<T> transfer(String code, HttpServletRequest request, Class<T> clazz)
    {
        String url = InterfaceCache.get(code).getIUrl();
        return HttpClientUtils.transfer(code, url, request, clazz);
    }

    /**
     * http客户端请求(平台管理系统调用该接口)
     * @param code 接口编码
     * @param request
     * @param dataClass T->class
     * @throws IOException
     */
    public static <T> TransData<T> transferMis(String code, HttpServletRequest request, Class<T> dataClass)
    {
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        request.setAttribute("userid", MMisLoginInfo.getLoginId());
        String url = InterfaceCache.get(code).getIUrl();
        return HttpClientUtils.transfer(code, url, request, dataClass);
    }

}
