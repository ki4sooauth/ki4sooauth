package com.gooagoo.exception.business.user;

import com.gooagoo.exception.common.FormatErrorException;

/**
 * 邮箱格式不正确
 * @author frenn
 *
 */
public class EmailFormatErrorException extends FormatErrorException
{

    private static final long serialVersionUID = 1L;

    public EmailFormatErrorException(String message)
    {
        super("邮箱格式不正确" + message);
    }

}
