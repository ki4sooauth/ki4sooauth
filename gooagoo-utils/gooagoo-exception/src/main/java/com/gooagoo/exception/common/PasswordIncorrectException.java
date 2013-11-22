package com.gooagoo.exception.common;

import com.gooagoo.exception.GooagooException;

/**
 * 密码不正确
 * @author Administrator
 *
 */
public class PasswordIncorrectException extends GooagooException
{
    private static final long serialVersionUID = 1L;

    public PasswordIncorrectException(String message)
    {
        super("密码不正确" + message);
    }
}
