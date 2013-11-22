package com.gooagoo.exception.business.user;

import com.gooagoo.exception.GooagooException;

/**
 * 邮箱未激活异常
 */
public class EmailAlreadyActivedException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public EmailAlreadyActivedException(String message)
    {
        super(message);
    }

}
