package com.gooagoo.entity.generator.behave;

import java.io.Serializable;

/**
 * 收藏信息
 */

public class FavoriteInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String favoriteId;//'收藏编号，UUID，对于优惠凭证，只有16位，前14位表示优惠凭证音频编号，后2位固定为01，表示刷优惠凭证',

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getFavoriteId()
    {
        return favoriteId;
    }

    public void setFavoriteId(String favoriteId)
    {
        this.favoriteId = favoriteId;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

}
