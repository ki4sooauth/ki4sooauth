package com.gooagoo.exception;

/**
 * gooagoo平台异常，是所有自定义异常的父类
 * @author frenn
 *
 */
public class GooagooException extends Exception
{

    private static final long serialVersionUID = 1L;

    public GooagooException(String message)
    {
        super(message);
    }

    public GooagooException()
    {
        super();
    }
}
