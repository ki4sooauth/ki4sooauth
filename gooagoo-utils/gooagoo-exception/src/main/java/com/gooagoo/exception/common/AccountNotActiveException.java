package com.gooagoo.exception.common;

import com.gooagoo.exception.GooagooException;

/**
 * 帐号未激活
 * @author Administrator
 *
 */
public class AccountNotActiveException extends GooagooException
{
    private static final long serialVersionUID = 1L;

    public AccountNotActiveException(String message)
    {
        super("帐号未激活" + message);
    }
}
