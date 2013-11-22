package com.gooagoo.view.gus.web.common;

import java.io.Serializable;

public class UAdInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String bidId;//竞拍编号

    private String imgUrl;//图片地址

    private String linkUrl;//链接地址

    private String shopId;//商家编号

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getBidId()
    {
        return this.bidId;
    }

    public void setBidId(String bidId)
    {
        this.bidId = bidId;
    }

    public String getImgUrl()
    {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getLinkUrl()
    {
        return this.linkUrl;
    }

    public void setLinkUrl(String linkUrl)
    {
        this.linkUrl = linkUrl;
    }

}
