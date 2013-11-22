package com.gooagoo.view.gus.web.mall;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

public class UExchangeRecord implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String exchangeTime;//兑换时间

    private String shopId;//商家id

    private String shopName;//商家名字

    private String type;//兑换类型

    private String typeVisitUrl;//访问地址：商品、优惠凭证

    private String typeName;//名称：商品、优惠凭证名称

    private Image typeImage;//图片：商品、优惠凭证图片

    private Integer integralValue;//兑换积分

    private String deliveryStatus;//发货状态

    private String consigneeName;//收货人姓名

    private String consigneePhone;//收货人电话

    private String consigneeZipCode;//邮政编码

    private String consigneeAddress;//收货人地址

    public String getExchangeTime()
    {
        return exchangeTime;
    }

    public void setExchangeTime(String exchangeTime)
    {
        this.exchangeTime = exchangeTime;
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
        return shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getTypeVisitUrl()
    {
        return typeVisitUrl;
    }

    public void setTypeVisitUrl(String typeVisitUrl)
    {
        this.typeVisitUrl = typeVisitUrl;
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

    public Integer getIntegralValue()
    {
        return integralValue;
    }

    public void setIntegralValue(Integer integralValue)
    {
        this.integralValue = integralValue;
    }

    public String getDeliveryStatus()
    {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus)
    {
        this.deliveryStatus = deliveryStatus;
    }

    public String getConsigneeName()
    {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName)
    {
        this.consigneeName = consigneeName;
    }

    public String getConsigneePhone()
    {
        return consigneePhone;
    }

    public void setConsigneePhone(String consigneePhone)
    {
        this.consigneePhone = consigneePhone;
    }

    public String getConsigneeZipCode()
    {
        return consigneeZipCode;
    }

    public void setConsigneeZipCode(String consigneeZipCode)
    {
        this.consigneeZipCode = consigneeZipCode;
    }

    public String getConsigneeAddress()
    {
        return consigneeAddress;
    }

    public void setConsigneeAddress(String consigneeAddress)
    {
        this.consigneeAddress = consigneeAddress;
    }

}
