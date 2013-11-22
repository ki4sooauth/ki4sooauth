package com.gooagoo.view.gus.web.merchant.web;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

public class USimpleGoodsInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;//商品ID

    private String name;//商品名称

    private String webVisitUrl;//WEB端访问地址

    private Image imageUrl;//图片地址

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getWebVisitUrl()
    {
        return this.webVisitUrl;
    }

    public void setWebVisitUrl(String webVisitUrl)
    {
        this.webVisitUrl = webVisitUrl;
    }

    public Image getImageUrl()
    {
        return this.imageUrl;
    }

    public void setImageUrl(Image imageUrl)
    {
        this.imageUrl = imageUrl;
    }

}
