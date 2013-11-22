package com.gooagoo.exception.business.card;

import com.gooagoo.exception.GooagooException;

/**
 * 会员卡过期异常
 *
 */
public class CardAlreadyOverdueException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public CardAlreadyOverdueException(String message)
    {
        super(message);
    }

}
