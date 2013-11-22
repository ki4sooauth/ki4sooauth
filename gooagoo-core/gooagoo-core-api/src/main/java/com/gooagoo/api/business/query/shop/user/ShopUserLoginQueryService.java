package com.gooagoo.api.business.query.shop.user;

import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.exception.common.AccountIsLockedException;
import com.gooagoo.exception.common.AccountNotExistException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.PasswordIncorrectException;

public interface ShopUserLoginQueryService

{
    /**
     * 商家用户登录
     * @param account 商家用户账户
     * @param password 密码
     * @param expireSecond 有效时间(单位:秒)
     * @return
     * @throws NullException
     * @throws AccountNotExistException
     * @throws PasswordIncorrectException
     * @throws AccountIsLockedException
     */
    public ShopLoginInfo login(String account, String password, Integer expireSecond) throws Exception;

    /**
     * 获取用户登录信息
     * @param token
     * @param expireSecond 有效时间(单位:秒)
     * @return
     * @throws Exception
     */
    public ShopLoginInfo queryShopDetailInfo(String token, Integer expireSecond) throws Exception;

}
