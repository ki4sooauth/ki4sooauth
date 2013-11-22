package com.gooagoo.exception.business.shop;

import com.gooagoo.exception.GooagooException;

/**
 * 餐桌状态不是空闲异常
 * @author YL
 *
 */
public class TableStateNotFreeException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public TableStateNotFreeException(String message)
    {
        super(message);
    }

}
