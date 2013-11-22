package com.gooagoo.exception.business.user;

import com.gooagoo.exception.GooagooException;

/**
 * 已过期异常
 *
 */
public class AlreadyOverdueException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public AlreadyOverdueException(String message)
    {
        super(message);
    }

}
