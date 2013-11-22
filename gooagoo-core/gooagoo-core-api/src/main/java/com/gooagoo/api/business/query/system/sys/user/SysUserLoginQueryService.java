package com.gooagoo.api.business.query.system.sys.user;

import com.gooagoo.entity.casclient.mis.MisLoginInfo;

public interface SysUserLoginQueryService
{

    /**
     * MIS用户登录
     * @param account 账户
     * @param password 密码
     * @param expireSecond 有效时间(单位:秒)
     * @return MisLoginInfo
     * @throws Exception
     */
    public MisLoginInfo login(String account, String password, Integer expireSecond) throws Exception;

    /**
     * 根据token值获取mis用户登录信息
     * @param token
     * @param expireSecond 有效时间(单位:秒)
     * @return MisLoginInfo
     * @throws Exception
     */
    public MisLoginInfo getLoginInfoByToken(String token, Integer expireSecond) throws Exception;

    /**
     * MIS用户退出登录
     * @param token redis主键
     * @param type 类型:0-GUS，1-GMS，2-MIS用户
     * @return MisLoginInfo
     * @throws Exception
     */
    public boolean quitLogin(String token, String type) throws Exception;

}
