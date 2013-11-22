package com.gooagoo.api.protecteds.core.user;

import com.gooagoo.entity.generator.user.UserInfo;

public interface UserProtectedCoreService

{
    /**
     * 校验用户状态是否正常
     * <br>
     * 包括用户ID是否为空，用户是否存在，用户是否已激活，用户状态是否正常
     * <br>
     * 只有用户已激活且状态正常才返回true
     * @param userId
     * @return
     */
    public boolean checkUserStatus(String userId);

    /**
     * 获取状态正常的用户信息
     * <br>
     * 状态正常的条件：用户存在、未删除、已激活、状态正常
     * <br>
     * 只有满足上述条件才返回UserInfo对象，否则返回NULL
     * @param userId
     * @return
     */
    public UserInfo getNormalUserInfo(String userId);

}
