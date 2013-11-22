package com.gooagoo.mobile.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.behave.mobile.ProcessUserbehave;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.UserBehaveMobileService;
import com.gooagoo.mobile.common.MessageConst;

@Service
public class UserBehaveMobileServiceImpl implements UserBehaveMobileService
{
    @Autowired
    private ProcessUserbehave processUserbehave;

    @Override
    public boolean recordUserbehave(String userId, String behavior) throws Exception
    {
        GooagooLog.info("recordUserbehave-->入参:userId=" + userId + ",behavior=" + behavior);

        boolean bool = this.processUserbehave.processUserMobileBehave(behavior);
        if (!bool)
        {
            throw new MessageException(MessageConst.MOBILE_BEHAVE_TRACK_FAIL);
        }

        return bool;
    }
}
