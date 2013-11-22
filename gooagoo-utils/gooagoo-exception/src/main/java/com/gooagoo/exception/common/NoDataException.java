package com.gooagoo.exception.common;

import com.gooagoo.exception.GooagooException;

/**
 * 没有数据
 * @author frenn
 *
 */
public class NoDataException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public NoDataException(String message)
    {
        super("未查询到数据" + message);
    }
}
