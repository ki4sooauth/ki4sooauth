package com.gooagoo.view.gus.web.merchant.mobile;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

public class UMall implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String type;//类型

    private String typeId;//ID：商品ID、优惠券ID

    private String typeName;//名称：商品名称、优惠券名称

    private Image typeImage;//图片地址：商品图片地址、优惠券图片地址

    private String typeVisitUrl;//访问地址：商品访问地址、优惠券访问地址

    private String shopIntegralId;//积分商城id

    private Integer convertIntegralValue;//兑换积分值

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getTypeId()
    {
        return typeId;
    }

    public void setTypeId(String typeId)
    {
        this.typeId = typeId;
    }

    public String getTypeName()
    {
        return typeName;
    }

    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }

    public Image getTypeImage()
    {
        return typeImage;
    }

    public void setTypeImage(Image typeImage)
    {
        this.typeImage = typeImage;
    }

    public String getTypeVisitUrl()
    {
        return typeVisitUrl;
    }

    public void setTypeVisitUrl(String typeVisitUrl)
    {
        this.typeVisitUrl = typeVisitUrl;
    }

    public String getShopIntegralId()
    {
        return shopIntegralId;
    }

    public void setShopIntegralId(String shopIntegralId)
    {
        this.shopIntegralId = shopIntegralId;
    }

    public Integer getConvertIntegralValue()
    {
        return convertIntegralValue;
    }

    public void setConvertIntegralValue(Integer convertIntegralValue)
    {
        this.convertIntegralValue = convertIntegralValue;
    }

}
