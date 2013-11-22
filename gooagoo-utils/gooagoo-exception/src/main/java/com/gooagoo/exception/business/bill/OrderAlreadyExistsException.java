package com.gooagoo.exception.business.bill;

import com.gooagoo.exception.GooagooException;

/**
 * 订单已存在,不可重复提交订单异常
 */
public class OrderAlreadyExistsException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public OrderAlreadyExistsException(String message)
    {
        super(message);
    }

}
