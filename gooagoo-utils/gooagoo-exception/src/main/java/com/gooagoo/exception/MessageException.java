package com.gooagoo.exception;

/**
 * gooagoo平台自定义编码异常
 * @author Administrator
 *
 */

public class MessageException extends Exception
{
    private static final long serialVersionUID = 1L;

    public MessageException(String message)
    {
        super(message);
    }
}
