package com.gooagoo.exception.business.card;

import com.gooagoo.exception.GooagooException;

/**
 * 会员卡名称已存在异常
 *
 */
public class CardNameAlreadyExistsException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public CardNameAlreadyExistsException(String message)
    {
        super(message);
    }

}
