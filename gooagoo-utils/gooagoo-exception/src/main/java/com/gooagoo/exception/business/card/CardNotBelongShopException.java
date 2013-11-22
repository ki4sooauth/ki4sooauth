package com.gooagoo.exception.business.card;

import com.gooagoo.exception.GooagooException;

/**
 * 会员卡不属于指定商家异常
 *
 */
public class CardNotBelongShopException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public CardNotBelongShopException(String message)
    {
        super(message);
    }

}
