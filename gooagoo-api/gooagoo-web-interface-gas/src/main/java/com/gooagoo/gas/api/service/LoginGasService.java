package com.gooagoo.gas.api.service;

import com.gooagoo.exception.common.AccountIsLockedException;
import com.gooagoo.exception.common.AccountNotExistException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.PasswordIncorrectException;
import com.gooagoo.gas.entity.gasa01.transform.LoginRoot;

/**
 * 店员登录接口
 */
public interface LoginGasService
{
    /**
     * 接口gasa01:店员登录
     * @param mac  店员助理mac地址
     * @param shopUserId 店员助理登录账号
     * @param password   店员助理登录密码
     * @return
     * @throws Exception
     * @throws NullException
     * @throws AccountNotExistException
     * @throws PasswordIncorrectException
     * @throws AccountIsLockedException
     */
    public LoginRoot Login(String mac, String shopUserId, String password) throws Exception;

}
