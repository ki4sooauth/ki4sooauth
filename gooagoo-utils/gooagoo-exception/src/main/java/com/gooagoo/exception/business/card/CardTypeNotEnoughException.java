package com.gooagoo.exception.business.card;

import com.gooagoo.exception.GooagooException;

/**
 * 会员卡类型不够异常
 *
 */
public class CardTypeNotEnoughException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public CardTypeNotEnoughException(String message)
    {
        super(message);
    }

}
