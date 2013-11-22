package com.gooagoo.exception.business.card;

import com.gooagoo.exception.GooagooException;

/**
 * 基本卡已存在异常
 *
 */
public class BaseCardAlreadyExistsException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public BaseCardAlreadyExistsException(String message)
    {
        super(message);
    }

}
