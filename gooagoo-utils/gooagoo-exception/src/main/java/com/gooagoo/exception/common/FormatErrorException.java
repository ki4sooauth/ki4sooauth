package com.gooagoo.exception.common;

import com.gooagoo.exception.GooagooException;

/**
 * 格式不正确异常
 * @author frenn
 *
 */
public class FormatErrorException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public FormatErrorException(String message)
    {
        super("格式不正确" + message);
    }

}
