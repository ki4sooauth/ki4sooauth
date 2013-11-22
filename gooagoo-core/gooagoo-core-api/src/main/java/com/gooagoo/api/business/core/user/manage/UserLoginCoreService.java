package com.gooagoo.api.business.core.user.manage;

import com.gooagoo.entity.casclient.personal.PersonalLoginInfo;
import com.gooagoo.entity.generator.user.UserMobileInfo;

public interface UserLoginCoreService

{
    /**
     * 个人用户登录
     * @param account 用户账户（phone/email）
     * @param password 密码
     * @param userMobileInfo
     * @param expireSecond 有效时间(单位:秒)
     * @return
     * @throws Exception
     */
    public PersonalLoginInfo login(String account, String password, UserMobileInfo userMobileInfo, Integer expireSecond) throws Exception;

    /**
     * 更新用户登录的客户端信息(缓存)
     * @param token
     * @param clientInfoJson
     * @return
     * @throws Exception
     */
    public boolean updateClientInfo(String token, String clientInfoJson) throws Exception;

}
