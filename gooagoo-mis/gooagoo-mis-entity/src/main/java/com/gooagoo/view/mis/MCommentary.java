package com.gooagoo.view.mis;

import java.io.Serializable;

/**
 * 用户评论信息
 * @author Administrator
 *
 */
public class MCommentary implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String userId;
    private String shopId;

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

}
