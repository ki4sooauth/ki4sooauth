package com.gooagoo.igus.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.user.query.UserActiveCodeQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.igus.service.IGusService;

/**
 * 校验随机验证码
 * @author SPZ
 *
 */
@Service("igus020Service")
public class IGus020ServiceImpl implements IGusService
{

    @Autowired
    private UserActiveCodeQueryService userActiveCodeQueryService;

    @Override
    public TransData<Object> service(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String redisKey = ServletRequestUtils.getStringParameter(request, "redisKey");
            String verifyCode = ServletRequestUtils.getStringParameter(request, "verifyCode");
            if (!this.userActiveCodeQueryService.checkActiveCode(redisKey, verifyCode))
            {
                GooagooLog.error("校验随机验证码：随机验证码（redisKey=" + redisKey + "&verifyCode=" + verifyCode + "）不正确", null);
                return new TransData<Object>(false, null, null);//TODO 随机验证码不正确
            }
            transData = new TransData<Object>(true, null, true);
        }
        catch (Exception e)
        {
            GooagooLog.error("校验随机验证码：校验随机验证码异常", e);
            transData = new TransData<Object>(false, null, null);//TODO 系统异常
        }
        return transData;
    }

}
