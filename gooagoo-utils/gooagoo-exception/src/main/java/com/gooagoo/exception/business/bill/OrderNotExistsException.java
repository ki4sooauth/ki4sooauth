package com.gooagoo.exception.business.bill;

import com.gooagoo.exception.GooagooException;

/**
 * 订单不存在异常
 */
public class OrderNotExistsException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public OrderNotExistsException(String message)
    {
        super(message);
    }

}
