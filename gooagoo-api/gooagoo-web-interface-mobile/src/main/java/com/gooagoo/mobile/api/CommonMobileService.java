package com.gooagoo.mobile.api;

/**
 * 手机公用相关接口
 */
public interface CommonMobileService
{
    /**
     * 手机用户登录状态校验
     * @param userId
     * @param sessionId
     * @throws Exception
     */
    public void checkLoginStatus(String userId, String sessionId) throws Exception;
}
