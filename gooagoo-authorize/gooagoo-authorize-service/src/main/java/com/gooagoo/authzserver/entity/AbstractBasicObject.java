package com.gooagoo.authzserver.entity;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import com.gooagoo.authzserver.exception.ValidationException;
import com.gooagoo.common.log.GooagooLog;

/**
 * 所有接口请求入参的基类
 */
public abstract class AbstractBasicObject
{
    /**
     * 请求对象属性初始化
     * @param request
     * @throws ValidationException
     * @throws UnsupportedEncodingException 
     */
    @SuppressWarnings("unchecked")
    public void init(HttpServletRequest request) throws ValidationException, UnsupportedEncodingException
    {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameters = request.getParameterMap();
        try
        {
            BeanUtils.populate(this, parameters);
        }
        catch (IllegalAccessException e)
        {
            GooagooLog.error("从ServletRequest往请求对象中拷贝属性出错【" + this.getClass().getName() + "】", e);
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            GooagooLog.error("从ServletRequest往请求对象中拷贝属性出错【" + this.getClass().getName() + "】", e);
            e.printStackTrace();
        }
        this.check();
    }

    /**
     * 验证入参是否合法，不合法抛出验证异常
     * @throws ValidationException
     */
    public abstract void check() throws ValidationException;
}
