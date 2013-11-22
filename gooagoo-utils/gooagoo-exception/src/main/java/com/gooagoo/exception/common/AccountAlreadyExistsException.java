package com.gooagoo.exception.common;

import com.gooagoo.exception.GooagooException;

/**
 * 帐号已存在异常
 * @author YL
 *
 */
public class AccountAlreadyExistsException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public AccountAlreadyExistsException(String message)
    {
        super("帐号已存在" + message);
    }

}
