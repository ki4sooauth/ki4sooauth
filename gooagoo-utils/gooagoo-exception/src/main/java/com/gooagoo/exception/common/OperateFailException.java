package com.gooagoo.exception.common;

import com.gooagoo.exception.GooagooException;

/**
 * 操作失败异常（增删改操作）
 * @author frenn
 *
 */
public class OperateFailException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public OperateFailException(String message)
    {
        super("操作失败" + message);
    }

}
