package com.gooagoo.exception.business.integral;

import com.gooagoo.exception.GooagooException;

/**
 * 积分不足异常
 * @author frenn
 *
 */
public class IntegralNotEnoughException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public IntegralNotEnoughException(String message)
    {
        super(message);
    }

    public IntegralNotEnoughException()
    {
        super();
    }
}
