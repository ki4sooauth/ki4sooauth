package com.gooagoo.exception.business.user;

import com.gooagoo.exception.GooagooException;

/**
 * 用户已是商家会员异常
 */
public class UserAlreadyShopMemberException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public UserAlreadyShopMemberException(String message)
    {
        super("已收藏" + message);
    }

}
