package com.gooagoo.exception.common;

import com.gooagoo.exception.GooagooException;

/**
 * 帐号不存在
 * @author Administrator
 *
 */
public class AccountNotExistException extends GooagooException
{
    private static final long serialVersionUID = 1L;

    public AccountNotExistException(String message)
    {
        super("帐号不存在" + message);
    }
}
