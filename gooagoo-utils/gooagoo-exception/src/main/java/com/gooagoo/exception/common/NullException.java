package com.gooagoo.exception.common;

import com.gooagoo.exception.GooagooException;

/**
 * 空值异常
 * @author frenn
 *
 */
public class NullException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public NullException(String message)
    {
        super("值为空" + message);
    }

}
