package com.gooagoo.cms.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.cache.InterfaceCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.HttpClientUtils;

public class HttpMisUtils
{
    /**
     * http客户端请求
     * @param code 接口编码
     * @param request
     * @param dataClass T->class
     * @throws IOException
     */
    public static <T> TransData<T> transfer(String code, HttpServletRequest request, Class<T> dataClass)
    {

        String url = InterfaceCache.get(code).getIUrl();
        return HttpClientUtils.transfer(code, url, request, dataClass);
    }

}
