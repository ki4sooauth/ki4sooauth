package com.gooagoo.exception.business.shop;

import com.gooagoo.exception.GooagooException;

/**
 * 广告位不存在或已删除异常异常
 *
 */
public class ShopAdDeletedOrNotExistException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public ShopAdDeletedOrNotExistException(String message)
    {
        super(message);
    }

}
