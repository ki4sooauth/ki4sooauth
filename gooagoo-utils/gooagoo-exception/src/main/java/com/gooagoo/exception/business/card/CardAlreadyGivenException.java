package com.gooagoo.exception.business.card;

import com.gooagoo.exception.GooagooException;

/**
 * 会员卡已被发放异常
 *
 */
public class CardAlreadyGivenException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public CardAlreadyGivenException(String message)
    {
        super(message);
    }

}
