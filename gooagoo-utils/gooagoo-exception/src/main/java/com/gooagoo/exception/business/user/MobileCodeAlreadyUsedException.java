package com.gooagoo.exception.business.user;

import com.gooagoo.exception.GooagooException;

/**
 * 手机验证码已使用异常
 *
 */
public class MobileCodeAlreadyUsedException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public MobileCodeAlreadyUsedException(String message)
    {
        super(message);
    }

}
