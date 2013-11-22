package com.gooagoo.view.gus;

import java.io.Serializable;

/**
 * 广告
 * @author SPZ
 *
 */
public class UAdvertisement implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String bidId;//竞拍编号

    private String imgUrl;//图片地址

    private String linkUrl;//链接地址

    private String shopId;//商家编号

    public String getBidId()
    {
        return bidId;
    }

    public void setBidId(String bidId)
    {
        this.bidId = bidId;
    }

    public String getImgUrl()
    {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getLinkUrl()
    {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl)
    {
        this.linkUrl = linkUrl;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    @Override
    public String toString()
    {
        return "Advertisement [bidId=" + bidId + ", imgUrl=" + imgUrl + ", linkUrl=" + linkUrl + ", shopId=" + shopId + "]";
    }

}
