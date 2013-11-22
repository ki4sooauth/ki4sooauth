package com.gooagoo.api.business.core.user.manage;

public interface UserActiveCodeCoreService
{

    /**
     * 获取邮箱激活码
     * <br>
     * 适用于个人用户找回密码
     * @param email
     * @return
     * @throws Exception
     */
    public String getEmailActiveCode(String email) throws Exception;

    /**
     * 获取邮箱激活码
     * <br>
     * 适用于个人用户绑定手机时的身份验证
     * @param userId
     * @param email
     * @param mobile
     * @return
     * @throws Exception
     */
    public String getEmailActiveCodeForBindMobile(String userId, String email, String mobile) throws Exception;

    /**
     * 获取邮箱验证码
     * <br>
     * 适用于个人用户绑定邮箱时的绑定确认
     * @param userId
     * @param email
     * @param mobileActiveCode
     * @return
     * @throws Exception
     */
    public String getEmailActiveCodeForBindEmail(String userId, String email, String mobileActiveCode) throws Exception;

    /**
     * 获取手机验证码
     * @param mobile
     * @return
     * @throws Exception
     */
    public String getMobileActiveCode(String mobile) throws Exception;

    /**
     * 使用手机验证码
     * <br>
     * 适用于个人用户找回密码
     * @param activeCode
     * @param mobile
     * @return
     * @throws Exception
     */
    public boolean updateMobileActiveCode(String activeCode, String mobile) throws Exception;

    /**
     * 获取验证码
     * @param activeCode
     * @param expireSecond 有效时间(单位:秒)
     * @return
     * @throws Exception
     */
    public String getActiveCode(String activeCode, Integer expireSecond) throws Exception;
}
