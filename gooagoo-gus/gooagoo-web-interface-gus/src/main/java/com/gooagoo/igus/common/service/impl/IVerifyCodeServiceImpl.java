package com.gooagoo.igus.common.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.user.manage.UserActiveCodeCoreService;
import com.gooagoo.api.business.query.user.query.UserActiveCodeQueryService;
import com.gooagoo.cache.PassportConfigCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.igus.common.service.IVerifyCodeService;
import com.gooagoo.igus.utils.MessageAnnotation;

@Service("iVerifyCodeService")
public class IVerifyCodeServiceImpl implements IVerifyCodeService
{

    @Autowired
    private UserActiveCodeCoreService userActiveCodeCoreService;

    @Autowired
    private UserActiveCodeQueryService userActiveCodeQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.COMMON_VERIFYCODECOMMON_GETVERIFYCODE)
    public TransData<Object> getVerifyCode(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String verifyCode = ServletRequestUtils.getStringParameter(request, "verifyCode");
            String token = this.userActiveCodeCoreService.getActiveCode(verifyCode, Integer.valueOf(PassportConfigCache.get("verifyTimeOut")));
            if (StringUtils.isBlank(token))
            {
                GooagooLog.info("获取随机验证码：存储验证码（" + verifyCode + "）返回的TOKEN（" + token + "）为空");
                return new TransData<Object>(false, MessageConst.COMMON_IVERIFYCODE_GETVERIFYCODE_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_IVERIFYCODE_GETVERIFYCODE_SUCCESS, token);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取随机验证码：获取随机验证码异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_IVERIFYCODE_GETVERIFYCODE_FAIL, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.COMMON_VERIFYCODECOMMON_CHECKVERIFYCODE)
    public TransData<Object> checkVerifyCode(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String token = ServletRequestUtils.getStringParameter(request, "token");
            String verifyCode = ServletRequestUtils.getStringParameter(request, "verifyCode");
            if (!this.userActiveCodeQueryService.checkActiveCode(token, verifyCode))
            {
                GooagooLog.info("获取随机验证码：TOKEN值（" + token + "）对应的验证码（" + verifyCode + "）不正确");
                return new TransData<Object>(false, MessageConst.COMMON_IVERIFYCODE_CHECKVERIFYCODE_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_IVERIFYCODE_CHECKVERIFYCODE_SUCCESS, true);
        }
        catch (Exception e)
        {
            GooagooLog.error("校验随机验证码：校验随机验证码异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_IVERIFYCODE_CHECKVERIFYCODE_FAIL, null);
        }

        return transData;
    }

}
