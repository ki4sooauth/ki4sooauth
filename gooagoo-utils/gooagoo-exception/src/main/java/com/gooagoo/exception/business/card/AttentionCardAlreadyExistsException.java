package com.gooagoo.exception.business.card;

import com.gooagoo.exception.GooagooException;

/**
 * 关注卡已存在异常
 *
 */
public class AttentionCardAlreadyExistsException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public AttentionCardAlreadyExistsException(String message)
    {
        super(message);
    }

}
