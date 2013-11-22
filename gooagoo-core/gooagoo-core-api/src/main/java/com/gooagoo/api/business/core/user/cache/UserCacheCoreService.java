package com.gooagoo.api.business.core.user.cache;

import java.util.Map;

/**
 * 从缓存中查询用户相关信息
 */
public interface UserCacheCoreService
{

    /**
     * 根据mac查UserId
     * @param mac
     * @return UserId
     * @throws Exception
     */
    public String findUserIdByMac(String mac) throws Exception;

    /**
     * 查询用户信息
     * @param UserId_ShopId
     * @return
     * @throws Exception
     */
    public Map<String, String> findUserInfo(String userId) throws Exception;

}
