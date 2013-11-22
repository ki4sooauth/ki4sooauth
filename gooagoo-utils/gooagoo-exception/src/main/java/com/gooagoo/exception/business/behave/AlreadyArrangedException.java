package com.gooagoo.exception.business.behave;

import com.gooagoo.exception.GooagooException;

/**
 * 已排号异常
 *
 */
public class AlreadyArrangedException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public AlreadyArrangedException(String message)
    {
        super(message);
    }

}
