package com.gooagoo.exception.business.card;

import com.gooagoo.exception.GooagooException;

/**
 * 发卡失败异常
 *
 */
public class GiveCardFailException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public GiveCardFailException(String message)
    {
        super(message);
    }

}
