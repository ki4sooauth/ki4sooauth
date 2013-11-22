package com.gooagoo.exception.business.behave;

import com.gooagoo.exception.GooagooException;

/**
 * 无需排号异常(已有空闲餐桌无需排号)
 *
 */
public class NotNeedArrangeException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public NotNeedArrangeException(String message)
    {
        super(message);
    }

}
