package com.gooagoo.entity.generator.marketing;

import java.io.Serializable;
import java.util.Date;

/**
 * 积分商城
 */

public class ShopIntegral implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopIntegralId;//积分营销编号，UUID

    private String shopId;//商家编号

    private String integralTradeType;//积分兑换类型，参考通用字典表的integral_trade_type

    private String integralTradeId;//积分兑换对象编号，为商品的编号或者优惠凭证的编号

    private Integer tradeIntegralValue;//兑换积分值

    private Date tradeStartTime;//允许兑换开始时间

    private Date tradeEndTime;//允许兑换结束时间

    private Integer convertNums;//兑换次数

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getShopIntegralId()
    {
        return this.shopIntegralId;
    }

    public void setShopIntegralId(String shopIntegralId)
    {
        this.shopIntegralId = shopIntegralId;
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

    public Date getTradeStartTime()
    {
        return this.tradeStartTime;
    }

    public void setTradeStartTime(Date tradeStartTime)
    {
        this.tradeStartTime = tradeStartTime;
    }

    public Date getTradeEndTime()
    {
        return this.tradeEndTime;
    }

    public void setTradeEndTime(Date tradeEndTime)
    {
        this.tradeEndTime = tradeEndTime;
    }

    public Integer getConvertNums()
    {
        return this.convertNums;
    }

    public void setConvertNums(Integer convertNums)
    {
        this.convertNums = convertNums;
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
        return this.shopIntegralId + "^" + this.shopId + "^" + this.integralTradeType + "^" + this.integralTradeId + "^" + this.tradeIntegralValue + "^" + this.tradeStartTime + "^" + this.tradeEndTime + "^" + this.convertNums + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
