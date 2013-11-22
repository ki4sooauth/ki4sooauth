package com.gooagoo.exception.common;

import com.gooagoo.exception.GooagooException;

/**
 * 密保卡不存在
 * @author Administrator
 *
 */
public class SecurityCardNotExistException extends GooagooException
{
    private static final long serialVersionUID = 1L;

    public SecurityCardNotExistException(String message)
    {
        super("帐号不存在" + message);
    }
}
