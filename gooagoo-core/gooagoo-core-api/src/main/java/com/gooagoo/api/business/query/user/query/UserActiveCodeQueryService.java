package com.gooagoo.api.business.query.user.query;

public interface UserActiveCodeQueryService

{

    /**
     * 校验邮箱激活码
     * <br>
     * 适用于个人用户找回密码
     * @param activeCode
     * @return
     * @throws Exception
     */
    public boolean checkEmailActiveCode(String activeCode) throws Exception;

    /**
     * 校验邮箱验证码
     * <br>
     * 适用于个人用户绑定手机时的身份验证
     * @param userId
     * @param activeCode
     * @return
     * @throws Exception
     */
    public boolean checkActiveCodeForBindMobile(String userId, String activeCode) throws Exception;

    /**
     * 校验手机验证码
     * @param activeCode
     * @param mobile
     * @return
     * @throws Exception
     */
    public boolean checkMobileActiveCode(String activeCode, String mobile) throws Exception;

    /**
     * 校验验证码
     * @param token
     * @param activeCode
     * @return
     * @throws Exception
     */
    public boolean checkActiveCode(String token, String activeCode) throws Exception;

}
