package com.gooagoo.exception.business.user;

import com.gooagoo.exception.GooagooException;

/**
 * 用户已申请（会员卡等）异常
 */
public class UserAlreadyApplyException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public UserAlreadyApplyException(String message)
    {
        super("已申请" + message);
    }

}
