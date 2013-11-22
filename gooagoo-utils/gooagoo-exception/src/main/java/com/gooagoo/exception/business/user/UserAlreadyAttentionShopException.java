package com.gooagoo.exception.business.user;

import com.gooagoo.exception.GooagooException;

/**
 * 用户已关注商家异常
 */
public class UserAlreadyAttentionShopException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public UserAlreadyAttentionShopException(String message)
    {
        super("已收藏" + message);
    }

}
