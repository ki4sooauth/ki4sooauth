package com.gooagoo.exception.business.user;

import com.gooagoo.exception.GooagooException;

/**
 * 密保卡不存在异常
 */
public class SecurityCardIsNotExistException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public SecurityCardIsNotExistException(String message)
    {
        super("密保卡不存在" + message);
    }

}
