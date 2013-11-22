package com.gooagoo.exception.business.card;

import com.gooagoo.exception.GooagooException;

/**
 * 物理卡已被转换异常
 *
 */
public class CardAlreadyConvertedException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public CardAlreadyConvertedException(String message)
    {
        super(message);
    }

}
