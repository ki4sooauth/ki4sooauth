package com.gooagoo.exception.business.integral;

import com.gooagoo.exception.GooagooException;

/**
 * 超过兑换次数异常
 * @author frenn
 *
 */
public class ExceedConvertNumsException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public ExceedConvertNumsException(String message)
    {
        super(message);
    }

    public ExceedConvertNumsException()
    {
        super();
    }
}
