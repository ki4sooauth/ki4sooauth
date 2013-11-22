package com.gooagoo.igus.personal.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.user.manage.UserPasswordCoreService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.exception.common.PasswordIncorrectException;
import com.gooagoo.igus.personal.service.IPasswordService;
import com.gooagoo.igus.utils.MessageAnnotation;

@Service("iPasswordService")
public class IPasswordServiceImpl implements IPasswordService
{

    @Autowired
    private UserPasswordCoreService userPasswordCoreService;

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_PASSWORD_UPDATEPASSWORD)
    public TransData<Object> updatePassword(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String oldPassword = ServletRequestUtils.getStringParameter(request, "oldPassword");
            String newPassword = ServletRequestUtils.getStringParameter(request, "newPassword");
            String rePassword = ServletRequestUtils.getStringParameter(request, "newPasswordRe");
            String key = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_TOKEN);
            if (!newPassword.equals(rePassword))
            {
                return new TransData<Object>(false, MessageConst.PERSONAL_IPASSWORD_UPDATEPASSWORD_TWODIFFERENT, null);
            }
            if (!this.userPasswordCoreService.updatePassword(key, userId, oldPassword, newPassword))
            {
                GooagooLog.info("修改密码：修改密码失败");
                transData = new TransData<Object>(false, MessageConst.PERSONAL_IPASSWORD_UPDATEPASSWORD_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.PERSONAL_IPASSWORD_UPDATEPASSWORD_SUCCESS, null);
        }
        catch (PasswordIncorrectException e)
        {
            GooagooLog.error("修改密码：密码不正确异常", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_IPASSWORD_UPDATEPASSWORD_OLDPASSWORDERROR, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("修改密码：修改失败", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_IPASSWORD_UPDATEPASSWORD_FAIL, null);
        }
        return transData;
    }

}
