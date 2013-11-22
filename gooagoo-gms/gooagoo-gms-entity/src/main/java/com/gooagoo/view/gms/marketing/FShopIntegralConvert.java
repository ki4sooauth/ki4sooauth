package com.gooagoo.view.gms.marketing;

import java.io.Serializable;
import java.util.Date;

public class FShopIntegralConvert implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String shopIntegralConvertId;//积分兑换信息编号，UUID

    private String shopIntegralId;//积分营销编号

    private String userId;//用户编号

    private String shopId;//商家编号

    private String integralTradeType;//积分兑换类型，参考通用字典表的integral_trade_type

    private String integralTradeId;//积分兑换对象编号，为商品的编号或者优惠凭证的编号

    private Integer tradeIntegralValue;//兑换积分值

    private String infoSource;//信息来源，参考通用字典表的info_source

    private Date convertTime;//兑换时间

    private String address;//收货地址，仅用于兑换商品时

    private String name;//收货人，仅用于兑换商品时

    private String telephone;//联系电话，仅用于兑换商品时

    private String postcode;//邮政编码，仅用于兑换商品时

    private String isDelivery;//是否发货，Y-已发货，N-未发货

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getShopIntegralConvertId()
    {
        return shopIntegralConvertId;
    }

    public void setShopIntegralConvertId(String shopIntegralConvertId)
    {
        this.shopIntegralConvertId = shopIntegralConvertId;
    }

    public String getShopIntegralId()
    {
        return shopIntegralId;
    }

    public void setShopIntegralId(String shopIntegralId)
    {
        this.shopIntegralId = shopIntegralId;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getIntegralTradeType()
    {
        return integralTradeType;
    }

    public void setIntegralTradeType(String integralTradeType)
    {
        this.integralTradeType = integralTradeType;
    }

    public String getIntegralTradeId()
    {
        return integralTradeId;
    }

    public void setIntegralTradeId(String integralTradeId)
    {
        this.integralTradeId = integralTradeId;
    }

    public Integer getTradeIntegralValue()
    {
        return tradeIntegralValue;
    }

    public void setTradeIntegralValue(Integer tradeIntegralValue)
    {
        this.tradeIntegralValue = tradeIntegralValue;
    }

    public String getInfoSource()
    {
        return infoSource;
    }

    public void setInfoSource(String infoSource)
    {
        this.infoSource = infoSource;
    }

    public Date getConvertTime()
    {
        return convertTime;
    }

    public void setConvertTime(Date convertTime)
    {
        this.convertTime = convertTime;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public String getIsDelivery()
    {
        return isDelivery;
    }

    public void setIsDelivery(String isDelivery)
    {
        this.isDelivery = isDelivery;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getcTimeStamp()
    {
        return cTimeStamp;
    }

    public void setcTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

}
