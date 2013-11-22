package com.gooagoo.exception.business.user;

import com.gooagoo.exception.GooagooException;

/**
 * 商家无关注卡异常
 */
public class ShopNotExistAttentionCardException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public ShopNotExistAttentionCardException(String message)
    {
        super("已收藏" + message);
    }

}
