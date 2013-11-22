package com.gooagoo.exception.business.user;

import com.gooagoo.exception.GooagooException;

/**
 * 密保卡已绑定异常
 */
public class SecurityCardAlreadyBindException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public SecurityCardAlreadyBindException(String message)
    {
        super("密保卡已绑定" + message);
    }

}
