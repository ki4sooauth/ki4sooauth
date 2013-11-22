package com.gooagoo.exception.common;

import com.gooagoo.exception.GooagooException;

/**
 * 帐号已停用异常
 * @author Administrator
 *
 */
public class AccountAlreadyDisabledException extends GooagooException
{
    private static final long serialVersionUID = 1L;

    public AccountAlreadyDisabledException(String message)
    {
        super(message);
    }
}
