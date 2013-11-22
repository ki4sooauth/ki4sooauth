package com.gooagoo.exception.business.user;

import com.gooagoo.exception.common.FormatErrorException;

/**
 * 手机号格式不正确异常
 * @author frenn
 *
 */
public class PhoneFormatErrorException extends FormatErrorException
{

    private static final long serialVersionUID = 1L;

    public PhoneFormatErrorException(String message)
    {
        super("手机号格式不正确" + message);
    }

}
