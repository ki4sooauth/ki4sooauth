package com.gooagoo.exception.common;

import com.gooagoo.exception.GooagooException;

/**
 * 帐号被锁定
 * @author Administrator
 *
 */
public class AccountIsLockedException extends GooagooException
{
    private static final long serialVersionUID = 1L;

    public AccountIsLockedException(String message)
    {
        super("帐号已被锁定" + message);
    }
}
