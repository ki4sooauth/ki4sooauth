package com.gooagoo.exception.business.card;

import com.gooagoo.exception.GooagooException;

/**
 * 会员卡不属于指定用户异常
 *
 */
public class CardNotBelongUserException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public CardNotBelongUserException(String message)
    {
        super(message);
    }

}
