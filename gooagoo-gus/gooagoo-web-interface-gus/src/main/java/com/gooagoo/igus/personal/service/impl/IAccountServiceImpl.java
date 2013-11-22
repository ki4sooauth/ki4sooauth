package com.gooagoo.igus.personal.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.user.manage.UserCoreService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.igus.personal.service.IAccountService;
import com.gooagoo.igus.utils.MessageAnnotation;

@Service("iAccountService")
public class IAccountServiceImpl implements IAccountService
{

    @Autowired
    private UserCoreService userCoreService;

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_ACCOUNT_SETACCOUNT)
    public TransData<Object> setAccount(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String account = ServletRequestUtils.getStringParameter(request, "account");
            String token = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_TOKEN);
            if (!this.userCoreService.updateUserAccount(token, userId, account))
            {
                GooagooLog.info("设置用户名：设置用户（" + userId + "）名（" + account + "）失败");
                return new TransData<Object>(false, MessageConst.PERSONAL_IACCOUNT_SETACCOUNT_FALL, null);
            }
            transData = new TransData<Object>(true, MessageConst.PERSONAL_IACCOUNT_SETACCOUNT_SUCCESS, account);
        }
        catch (Exception e)
        {
            GooagooLog.error("设置用户名：设置用户名异常", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_IACCOUNT_SETACCOUNT_FALL, null);
        }

        return transData;
    }

}
