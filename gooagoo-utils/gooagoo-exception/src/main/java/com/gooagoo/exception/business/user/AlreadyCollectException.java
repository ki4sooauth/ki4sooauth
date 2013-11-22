package com.gooagoo.exception.business.user;

import com.gooagoo.exception.GooagooException;

/**
 * 已收藏异常
 * @author YL
 *
 */
public class AlreadyCollectException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public AlreadyCollectException(String message)
    {
        super("已收藏" + message);
    }

}
