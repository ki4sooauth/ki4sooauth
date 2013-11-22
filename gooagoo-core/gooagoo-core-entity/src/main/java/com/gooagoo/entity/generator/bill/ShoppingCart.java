package com.gooagoo.entity.generator.bill;

import java.io.Serializable;
import java.util.Date;

/**
 * 购物车
 */

public class ShoppingCart implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

    private String userId;//用户编号

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private String goodsId;//商品编号

    private String goodsName;//商品名称

    private String goodsCategoryRoot;//品类编号（根节点）

    private String goodsCategoryLeaf;//品类编号（叶节点）

    private String goodsBrand;//品牌编号

    private String goodsSerial;//商品序列号（商品的唯一识别编码）

    private String itemSerial;//自定义序列号（商品细分的唯一识别编码）

    private Double price;//商品价格

    private String goodsImg;//商品主图地址

    private Integer goodsNum;//商品数量

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
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

    public Double getPrice()
    {
        return this.price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public String getGoodsImg()
    {
        return this.goodsImg;
    }

    public void setGoodsImg(String goodsImg)
    {
        this.goodsImg = goodsImg;
    }

    public Integer getGoodsNum()
    {
        return this.goodsNum;
    }

    public void setGoodsNum(Integer goodsNum)
    {
        this.goodsNum = goodsNum;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setCTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    @Override
    public String toString()
    {
        return this.id + "^" + this.userId + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.goodsId + "^" + this.goodsName + "^" + this.goodsCategoryRoot + "^" + this.goodsCategoryLeaf + "^" + this.goodsBrand + "^" + this.goodsSerial + "^" + this.itemSerial + "^" + this.price + "^" + this.goodsImg + "^" + this.goodsNum + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
