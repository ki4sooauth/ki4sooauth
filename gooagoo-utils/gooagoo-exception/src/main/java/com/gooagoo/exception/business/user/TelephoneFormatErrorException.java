package com.gooagoo.exception.business.user;

import com.gooagoo.exception.common.FormatErrorException;

/**
 * 密码格式不正确异常
 * @author frenn
 *
 */
public class TelephoneFormatErrorException extends FormatErrorException
{

    private static final long serialVersionUID = 1L;

    public TelephoneFormatErrorException(String message)
    {
        super("联系电话格式不正确" + message);
    }

}
