package com.gooagoo.api.business.core.user.app;

import com.gooagoo.entity.generator.behave.UserFeedback;

public interface AppFeedbackCoreService

{
    /**
     * 手机APP产品意见反馈
     * @param favoriteInfo
     * @return true/false
     */
    public boolean appFeedback(UserFeedback userFeedback) throws Exception;

}
