package com.gooagoo.api.business.query.user.query;

import com.gooagoo.entity.business.user.UserDetailInfo;

/**
 * 用户
 */
public interface UserQueryService
{

    /**
     * 查询个人信息
     * mobf06
     * @param userId
     * @throws Exception
     */
    public UserDetailInfo findUserInfo(String userId) throws Exception;

}
