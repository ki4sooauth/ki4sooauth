package com.gooagoo.view.gus;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

/**
 * 商品
 * @author SPZ
 *
 */
public class UGoods implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String goodsId;//商品ID

    private String goodsName;//商品名称

    private String goodsLink;//商品链接

    private Image goodsImage;//商品图片

    private String shopId;//商家ID

    private String ShopName;//商家名称

    public String getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getGoodsName()
    {
        return goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public String getGoodsLink()
    {
        return goodsLink;
    }

    public void setGoodsLink(String goodsLink)
    {
        this.goodsLink = goodsLink;
    }

    public Image getGoodsImage()
    {
        return goodsImage;
    }

    public void setGoodsImage(Image goodsImage)
    {
        this.goodsImage = goodsImage;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopName()
    {
        return this.ShopName;
    }

    public void setShopName(String shopName)
    {
        this.ShopName = shopName;
    }

    @Override
    public String toString()
    {
        return "UGoods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsLink=" + goodsLink + ", goodsImage=" + goodsImage + ", shopId=" + shopId + ", ShopName=" + ShopName + "]";
    }

}
