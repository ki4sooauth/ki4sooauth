package com.gooagoo.exception.business.bill;

import com.gooagoo.exception.GooagooException;

/**
 * 已添加购物车异常
 *
 */
public class AlreadyAddShoppingCartException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public AlreadyAddShoppingCartException(String message)
    {
        super(message);
    }

}
