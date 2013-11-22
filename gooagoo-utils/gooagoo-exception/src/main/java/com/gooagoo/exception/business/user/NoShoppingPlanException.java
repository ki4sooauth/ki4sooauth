package com.gooagoo.exception.business.user;

import com.gooagoo.exception.GooagooException;

/**
 * 没有购物清单异常
 *
 */
public class NoShoppingPlanException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public NoShoppingPlanException(String message)
    {
        super("没有购物清单" + message);
    }

}
