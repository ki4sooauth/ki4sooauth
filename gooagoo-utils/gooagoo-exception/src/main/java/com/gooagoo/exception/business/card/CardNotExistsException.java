package com.gooagoo.exception.business.card;

import com.gooagoo.exception.GooagooException;

/**
 * 会员卡不存在异常
 *
 */
public class CardNotExistsException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public CardNotExistsException(String message)
    {
        super(message);
    }

}
