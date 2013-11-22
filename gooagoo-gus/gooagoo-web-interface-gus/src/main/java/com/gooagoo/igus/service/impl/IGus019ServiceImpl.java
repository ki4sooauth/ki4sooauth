package com.gooagoo.igus.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.user.manage.UserActiveCodeCoreService;
import com.gooagoo.cache.PassportConfigCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.igus.service.IGusService;

/**
 * 设置随机验证码
 * @author SPZ
 *
 */
@Service("igus019Service")
public class IGus019ServiceImpl implements IGusService
{

    @Autowired
    private UserActiveCodeCoreService userActiveCodeCoreService;

    @Override
    public TransData<Object> service(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String verifyCode = ServletRequestUtils.getStringParameter(request, "verifyCode");
            String redisKey = this.userActiveCodeCoreService.getActiveCode(verifyCode, Integer.valueOf(PassportConfigCache.get("verifyTimeOut")));
            if (StringUtils.isBlank(redisKey))
            {
                GooagooLog.error("设置随机验证码：设置随机验证码（" + verifyCode + "）返回的redisKey（" + redisKey + "）为空", null);
                return new TransData<Object>(false, null, null);//TODO 设置随机验证码失败
            }
            transData = new TransData<Object>(true, null, redisKey);
        }
        catch (Exception e)
        {
            GooagooLog.error("设置随机验证码：设置随机验证码异常", e);
            transData = new TransData<Object>(false, null, null);//TODO 系统异常
        }
        return transData;
    }

}
