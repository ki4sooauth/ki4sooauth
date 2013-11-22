package com.gooagoo.exception.business.member;

import com.gooagoo.exception.GooagooException;

/**
 * 商家会员不存在异常
 *
 */
public class ShopMemberNotExistsException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public ShopMemberNotExistsException(String message)
    {
        super(message);
    }

}
