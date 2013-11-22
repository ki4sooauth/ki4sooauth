package com.gooagoo.exception.business.shop;

import com.gooagoo.exception.GooagooException;

/**
 * 商家竞拍金额不足异常
 *
 */
public class ShopBidAmountLackException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public ShopBidAmountLackException(String message)
    {
        super(message);
    }

}
