package com.gooagoo.entity.business.system.nominate;

import java.io.Serializable;
import java.util.Date;

/**
 * 推荐商品
 */
public class NominateGoodsBusiness implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;//推荐商品表自动编号
    private String shopId;//推荐商品表商家编号
    private String shopEntityId;//推荐商品表实体店编号
    private String goodsId;//推荐商品表商品编号
    private Date startTime;//推荐商品表起始时间
    private Date endTime;//推荐商品表结束时间
    private Date nominateGoodsCTimeStamp;//推荐商品表更新时间
    private String goodsName;//商品信息表商品名称
    private String goodsSerial;//商品信息表商品序列号
    private String itemSerial;//商品信息表自定义序列号
    private String publishStatus;//商品信息表状态
    private Double price;//商品信息表商品价格
    private Date goodsBaseInfoCTimeStamp;//商品信息表商品更新时间
    private String isNominate;//是否推荐（非数据库字段）Y-推荐，N-不推荐
    private String shopName;//商家信息表商家名称
    private String shopEntityName;//实体店基本信息表实体店名称

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
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

    public Date getStartTime()
    {
        return this.startTime;
    }

    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getEndTime()
    {
        return this.endTime;
    }

    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getNominateGoodsCTimeStamp()
    {
        return this.nominateGoodsCTimeStamp;
    }

    public void setNominateGoodsCTimeStamp(Date nominateGoodsCTimeStamp)
    {
        this.nominateGoodsCTimeStamp = nominateGoodsCTimeStamp;
    }

    public String getGoodsName()
    {
        return this.goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
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

    public String getPublishStatus()
    {
        return this.publishStatus;
    }

    public void setPublishStatus(String publishStatus)
    {
        this.publishStatus = publishStatus;
    }

    public Double getPrice()
    {
        return this.price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Date getGoodsBaseInfoCTimeStamp()
    {
        return this.goodsBaseInfoCTimeStamp;
    }

    public void setGoodsBaseInfoCTimeStamp(Date goodsBaseInfoCTimeStamp)
    {
        this.goodsBaseInfoCTimeStamp = goodsBaseInfoCTimeStamp;
    }

    public String getIsNominate()
    {
        return this.isNominate;
    }

    public void setIsNominate(String isNominate)
    {
        this.isNominate = isNominate;
    }

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getShopEntityName()
    {
        return this.shopEntityName;
    }

    public void setShopEntityName(String shopEntityName)
    {
        this.shopEntityName = shopEntityName;
    }

    @Override
    public String toString()
    {
        return "NominateGoodsBusiness [id=" + this.id + ", shopId=" + this.shopId + ", shopEntityId=" + this.shopEntityId + ", goodsId=" + this.goodsId + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", nominateGoodsCTimeStamp=" + this.nominateGoodsCTimeStamp + ", goodsName=" + this.goodsName + ", goodsSerial=" + this.goodsSerial + ", itemSerial=" + this.itemSerial + ", publishStatus=" + this.publishStatus + ", price=" + this.price + ", goodsBaseInfoCTimeStamp=" + this.goodsBaseInfoCTimeStamp + ", isNominate=" + this.isNominate + ", shopName=" + this.shopName + ", shopEntityName=" + this.shopEntityName + "]";
    }

}
