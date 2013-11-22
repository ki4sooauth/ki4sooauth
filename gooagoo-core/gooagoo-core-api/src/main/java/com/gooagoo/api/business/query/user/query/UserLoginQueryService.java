package com.gooagoo.api.business.query.user.query;

public interface UserLoginQueryService
{

    /**
     * 校验手机用户是否登录
     * @param userId
     * @param sessionId
     * @return
     * @throws Exception
     */
    public boolean checkLoginStatus(String userId, String sessionId) throws Exception;

}
