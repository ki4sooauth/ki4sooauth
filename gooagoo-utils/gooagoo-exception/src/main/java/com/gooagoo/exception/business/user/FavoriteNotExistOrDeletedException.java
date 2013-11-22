package com.gooagoo.exception.business.user;

import com.gooagoo.exception.GooagooException;

/**
 * 收藏信息不存在或已删除异常
 */
public class FavoriteNotExistOrDeletedException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public FavoriteNotExistOrDeletedException(String message)
    {
        super(message);
    }

}
