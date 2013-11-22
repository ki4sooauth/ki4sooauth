package com.gooagoo.entity.generator.marketing;

import java.io.Serializable;
import java.util.Date;

/**
 * 积分兑换信息
 */

public class ShopIntegralConvert implements Serializable
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

    private String consigneeId;//收货人信息编号，关联收货人信息的主键

    private String deliveryStatus;//取货状态，0-用户未收到货物，1-商家已拣货，2-商家已发货，3-用户已收取货物

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getShopIntegralConvertId()
    {
        return this.shopIntegralConvertId;
    }

    public void setShopIntegralConvertId(String shopIntegralConvertId)
    {
        this.shopIntegralConvertId = shopIntegralConvertId;
    }

    public String getShopIntegralId()
    {
        return this.shopIntegralId;
    }

    public void setShopIntegralId(String shopIntegralId)
    {
        this.shopIntegralId = shopIntegralId;
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

    public String getIntegralTradeType()
    {
        return this.integralTradeType;
    }

    public void setIntegralTradeType(String integralTradeType)
    {
        this.integralTradeType = integralTradeType;
    }

    public String getIntegralTradeId()
    {
        return this.integralTradeId;
    }

    public void setIntegralTradeId(String integralTradeId)
    {
        this.integralTradeId = integralTradeId;
    }

    public Integer getTradeIntegralValue()
    {
        return this.tradeIntegralValue;
    }

    public void setTradeIntegralValue(Integer tradeIntegralValue)
    {
        this.tradeIntegralValue = tradeIntegralValue;
    }

    public String getInfoSource()
    {
        return this.infoSource;
    }

    public void setInfoSource(String infoSource)
    {
        this.infoSource = infoSource;
    }

    public Date getConvertTime()
    {
        return this.convertTime;
    }

    public void setConvertTime(Date convertTime)
    {
        this.convertTime = convertTime;
    }

    public String getConsigneeId()
    {
        return this.consigneeId;
    }

    public void setConsigneeId(String consigneeId)
    {
        this.consigneeId = consigneeId;
    }

    public String getDeliveryStatus()
    {
        return this.deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus)
    {
        this.deliveryStatus = deliveryStatus;
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
        return this.shopIntegralConvertId + "^" + this.shopIntegralId + "^" + this.userId + "^" + this.shopId + "^" + this.integralTradeType + "^" + this.integralTradeId + "^" + this.tradeIntegralValue + "^" + this.infoSource + "^" + this.convertTime + "^" + this.consigneeId + "^" + this.deliveryStatus + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
