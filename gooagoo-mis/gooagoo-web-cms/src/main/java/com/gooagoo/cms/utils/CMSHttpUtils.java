package com.gooagoo.cms.utils;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.cache.InterfaceCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.HttpClientUtils;

public class CMSHttpUtils
{

    /**
     * web层通过此方法调用interface层
     * 会同时传递Parametert和Attribute中的参数
     * 如果Parametert和Attribute参数重名则接收端会以数组的形式全都取到
     * @param code
     * @param request
     * @param clazz GResponse对象内集合的类型
     * @return GResponse对象
     */
    @SuppressWarnings("unchecked")
    public static <T> TransData<T> transfer(String code, HttpServletRequest request, Class<T> clazz)
    {
        String url = InterfaceCache.get(code).getIUrl();
        return HttpClientUtils.transfer(code, url, request, clazz);
    }
}
