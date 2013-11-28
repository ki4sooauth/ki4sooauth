package com.gooagoo.mobile.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.user.query.UserLoginQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.CommonMobileService;
import com.gooagoo.mobile.common.MessageConst;

@Service
public class CommonMobileServiceImpl implements CommonMobileService
{
    @Autowired
    private UserLoginQueryService userLoginQueryService;

    @Override
    public void checkLoginStatus(String userId, String sessionId) throws Exception
    {
        boolean LoginStatus = this.userLoginQueryService.checkLoginStatus(userId, sessionId);
        if (!LoginStatus)
        {
            GooagooLog.warn("用户userId=" + userId + " 的登录状态sessionId=" + sessionId + " 失效了");
            throw new MessageException(MessageConst.MOBILE_SET_PLEASE_LOGIN);
        }
    }

}
