package com.gooagoo.exception.business.shop;

import com.gooagoo.exception.GooagooException;

/**
 * 餐桌不存在异常
 * @author YL
 *
 */
public class TableNotExistException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public TableNotExistException(String message)
    {
        super(message);
    }

}
