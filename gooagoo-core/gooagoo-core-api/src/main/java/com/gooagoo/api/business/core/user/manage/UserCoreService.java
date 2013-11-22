package com.gooagoo.api.business.core.user.manage;

import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserProfile;
import com.gooagoo.exception.common.AccountAlreadyExistsException;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

public interface UserCoreService

{
    /**
     * 修改个人信息
     * @param userInfo 个人信息
     * @return true/false
     * @throws Exception
     */
    public boolean updateUserInfo(UserInfo userInfo) throws Exception;

    /**
     * * 修改头像
     * @param userLoginRedisKey redis存储个人登录信息key
     * @param userId
     * @param url
     * @return true/false
     * @throws NullException
     * @throws OperateFailException
     */
    public boolean updateUserHead(String userLoginRedisKey, String userId, String url) throws Exception;

    /**
     * * 修改用户辅助信息
     * @param userLoginRedisKey redis存储个人登录信息key
     * @param userProfile
     * @return true/false
     * @throws FormatErrorException
     * @throws NullException
     * @throws OperateFailException
     */
    public boolean updateUserProfile(String userLoginRedisKey, UserProfile userProfile) throws Exception;

    /**
     * 修改用户名
     * @param userLoginRedisKey redis存储个人登录信息key
     * @param userId
     * @param account
     * @return
     * @throws NullException
     * @throws OperateFailException
     * @throws AccountAlreadyExistsException
     */
    public boolean updateUserAccount(String userLoginRedisKey, String userId, String account) throws Exception;

    /**
     * 修改用户邮箱地址
     * 适用于用户绑定邮箱地址
     * @param userLoginRedisKey redis存储个人登录信息key
     * @param userId
     * @param email
     * @param activeCode
     * @return
     * @throws Exception
     */
    public boolean updateEmail(String userLoginRedisKey, String userId, String email, String activeCode) throws Exception;

    /**
     * 修改用户手机号码
     * 适用于用户绑定手机号码
     * @param userLoginRedisKey redis存储个人登录信息key
     * @param userId
     * @param mobile
     * @param mobileActiveCode
     * @param activeCode
     * @return
     * @throws Exception
     */
    public boolean updateMobile(String userLoginRedisKey, String userId, String mobile, String mobileActiveCode, String activeCode) throws Exception;
}
