package com.gooagoo.exception.business.card;

import com.gooagoo.exception.GooagooException;

/**
 * 基本卡不存在异常
 *
 */
public class BaseCardNotExistsException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public BaseCardNotExistsException(String message)
    {
        super(message);
    }

}
