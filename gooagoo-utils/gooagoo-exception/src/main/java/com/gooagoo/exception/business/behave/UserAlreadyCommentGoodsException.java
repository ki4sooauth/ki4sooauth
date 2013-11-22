package com.gooagoo.exception.business.behave;

import com.gooagoo.exception.GooagooException;

/**
 * 用户已评论商品异常
 */
public class UserAlreadyCommentGoodsException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public UserAlreadyCommentGoodsException(String message)
    {
        super(message);
    }

}
