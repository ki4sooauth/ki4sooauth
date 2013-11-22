package com.gooagoo.entity.business.marketing;

import java.io.Serializable;

public class TradeResponse implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopId;//商家编号

    private String shopName;//商家昵称

    private String type;//类型：G-商品、C-优惠券

    private String typeId;//类型ID：商品ID、优惠券ID

    private String typeName;//名称：商品名称、优惠券名称

    private String typeImageUrl;//图片地址：商品图片地址、优惠券图片地址

    private String shopIntegralId;//积分营销ID

    private Integer convertIntegralValue;//兑换积分值

    private Integer useableIntegralNumber;//可用积分

    private Integer convertCount;//被兑换次数

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getType()
    {
        return this.type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getTypeId()
    {
        return this.typeId;
    }

    public void setTypeId(String typeId)
    {
        this.typeId = typeId;
    }

    public String getTypeName()
    {
        return this.typeName;
    }

    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }

    public String getTypeImageUrl()
    {
        return this.typeImageUrl;
    }

    public void setTypeImageUrl(String typeImageUrl)
    {
        this.typeImageUrl = typeImageUrl;
    }

    public String getShopIntegralId()
    {
        return this.shopIntegralId;
    }

    public void setShopIntegralId(String shopIntegralId)
    {
        this.shopIntegralId = shopIntegralId;
    }

    public Integer getConvertIntegralValue()
    {
        return this.convertIntegralValue;
    }

    public void setConvertIntegralValue(Integer convertIntegralValue)
    {
        this.convertIntegralValue = convertIntegralValue;
    }

    public Integer getUseableIntegralNumber()
    {
        return this.useableIntegralNumber;
    }

    public void setUseableIntegralNumber(Integer useableIntegralNumber)
    {
        this.useableIntegralNumber = useableIntegralNumber;
    }

    public Integer getConvertCount()
    {
        return this.convertCount;
    }

    public void setConvertCount(Integer convertCount)
    {
        this.convertCount = convertCount;
    }

}
