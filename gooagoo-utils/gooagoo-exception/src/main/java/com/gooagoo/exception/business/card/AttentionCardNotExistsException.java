package com.gooagoo.exception.business.card;

import com.gooagoo.exception.GooagooException;

/**
 * 关注卡不存在异常
 *
 */
public class AttentionCardNotExistsException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public AttentionCardNotExistsException(String message)
    {
        super(message);
    }

}