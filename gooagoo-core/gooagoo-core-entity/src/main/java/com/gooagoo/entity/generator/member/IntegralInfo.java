package com.gooagoo.entity.generator.member;

import java.io.Serializable;
import java.util.Date;

/**
 * 积分汇总表，通过对积分详细表的数据分析得出
 */

public class IntegralInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String integralId;//积分编号，UUID

    private String shopId;//商家编号

    private String userId;//用户编号

    private Integer historyTotalIntegral;//历史总积分，用于会员卡的升级

    private Integer useableIntegralNumber;//可用积分，用于兑换商品或优惠凭证

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getIntegralId()
    {
        return this.integralId;
    }

    public void setIntegralId(String integralId)
    {
        this.integralId = integralId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public Integer getHistoryTotalIntegral()
    {
        return this.historyTotalIntegral;
    }

    public void setHistoryTotalIntegral(Integer historyTotalIntegral)
    {
        this.historyTotalIntegral = historyTotalIntegral;
    }

    public Integer getUseableIntegralNumber()
    {
        return this.useableIntegralNumber;
    }

    public void setUseableIntegralNumber(Integer useableIntegralNumber)
    {
        this.useableIntegralNumber = useableIntegralNumber;
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
        return this.integralId + "^" + this.shopId + "^" + this.userId + "^" + this.historyTotalIntegral + "^" + this.useableIntegralNumber + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
