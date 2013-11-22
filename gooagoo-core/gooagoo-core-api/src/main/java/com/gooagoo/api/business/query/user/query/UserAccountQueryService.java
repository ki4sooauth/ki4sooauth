package com.gooagoo.api.business.query.user.query;

import com.gooagoo.entity.casclient.personal.PersonalLoginInfo;

public interface UserAccountQueryService
{

    /**
     * 根据用户帐号类型和用户帐号获取用户userid
     * @param accountType   用户类型，参考字段表
     * @param account       用户帐号，如userid、mac地址、手机号码等
     * @return
     * @throws Exception
     */
    public String queryUserIdFromUserAccount(String accountType, String account) throws Exception;

    /**
     * 根据用户userid获取用户电子邮箱
     * @param userId    用户编号
     * @param shopId    商家编号，如为空值，则直接查询用户在购阿购平台的信息
     * @return
     * @throws Exception
     */
    public String queryEmailFromUserId(String userId, String shopId) throws Exception;

    /**
     * 根据用户userid获取用户手机号码
     * @param userId    用户编号
     * @param shopId    商家编号，如为空值，则直接查询用户在购阿购平台的信息
     * @return
     * @throws Exception
     */
    public String queryMobileFromUserId(String userId, String shopId) throws Exception;

    /**
     * 根据用户userid获取用户手机mac地址
     * @param userId    用户编号
     * @return
     * @throws Exception
     */
    public String queryMacFromUserId(String userId) throws Exception;

    /**
     * 获取用户登录信息
     * @param token    
     * @param resource    M-手机端，W-网站端
     * @param expireSecond 有效时间(单位:秒)
     * @return
     * @throws Exception
     */
    public PersonalLoginInfo queryPersonalLoginInfo(String token, String resource, Integer expireSecond) throws Exception;

    /**
     * 验证用户身份
     * @param userId 用户编号    
     * @param password 密码
     * @return
     * @throws Exception
     */
    public boolean checkUserIdentity(String userId, String password) throws Exception;
}
