package com.gooagoo.exception.business.shop;

import com.gooagoo.exception.GooagooException;

/**
 * 商家卡的发布状态不是已发布异常
 * @author YL
 *
 */
public class ShopCardStatusException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public ShopCardStatusException(String message)
    {
        super(message);
    }

}
