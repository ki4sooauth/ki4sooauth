package com.gooagoo.exception.business.shop;

import com.gooagoo.exception.GooagooException;

/**
 * 商家竞拍时间无效异常
 *
 */
public class ShopBidTimeInvalidException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public ShopBidTimeInvalidException(String message)
    {
        super(message);
    }

}
