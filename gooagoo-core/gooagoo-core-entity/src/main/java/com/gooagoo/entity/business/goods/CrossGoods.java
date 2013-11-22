package com.gooagoo.entity.business.goods;

import java.io.Serializable;

/**
 * 商品详细信息表
 */

public class CrossGoods implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String goodsId;//商品编号，UUID

    private String goodsName;//商品名称

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private String goodsCategoryRoot;//品类编号（根节点）

    private String goodsCategoryLeaf;//品类编号（叶节点）

    private String goodsBrand;//品牌编号

    private String goodsSerial;//商品序列号（商品的唯一识别编码）

    private String itemSerial;//自定义序列号（商品细分的唯一识别编码）

    private String goodsImg;//商品图片URL，json串

    private Double price;//商品价格

    private String saleNums;//商品销量

    public String getGoodsId()
    {
        return this.goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getGoodsName()
    {
        return this.goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getGoodsCategoryRoot()
    {
        return this.goodsCategoryRoot;
    }

    public void setGoodsCategoryRoot(String goodsCategoryRoot)
    {
        this.goodsCategoryRoot = goodsCategoryRoot;
    }

    public String getGoodsCategoryLeaf()
    {
        return this.goodsCategoryLeaf;
    }

    public void setGoodsCategoryLeaf(String goodsCategoryLeaf)
    {
        this.goodsCategoryLeaf = goodsCategoryLeaf;
    }

    public String getGoodsBrand()
    {
        return this.goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand)
    {
        this.goodsBrand = goodsBrand;
    }

    public String getGoodsSerial()
    {
        return this.goodsSerial;
    }

    public void setGoodsSerial(String goodsSerial)
    {
        this.goodsSerial = goodsSerial;
    }

    public String getItemSerial()
    {
        return this.itemSerial;
    }

    public void setItemSerial(String itemSerial)
    {
        this.itemSerial = itemSerial;
    }

    public String getGoodsImg()
    {
        return this.goodsImg;
    }

    public void setGoodsImg(String goodsImg)
    {
        this.goodsImg = goodsImg;
    }

    public Double getPrice()
    {
        return this.price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public String getSaleNums()
    {
        return this.saleNums;
    }

    public void setSaleNums(String saleNums)
    {
        this.saleNums = saleNums;
    }

    @Override
    public String toString()
    {
        return "CrossGoods [goodsId=" + this.goodsId + ", goodsName=" + this.goodsName + ", shopId=" + this.shopId + ", shopEntityId=" + this.shopEntityId + ", goodsCategoryRoot=" + this.goodsCategoryRoot + ", goodsCategoryLeaf=" + this.goodsCategoryLeaf + ", goodsBrand=" + this.goodsBrand + ", goodsSerial=" + this.goodsSerial + ", itemSerial=" + this.itemSerial + ", goodsImg=" + this.goodsImg + ", price=" + this.price + ", saleNums=" + this.saleNums + "]";
    }

}
