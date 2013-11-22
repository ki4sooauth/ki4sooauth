package com.gooagoo.entity.business.user.account.integral;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户消费档案
 *
 */
public class IntegralRecord implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String userId; //用户编号
    private String shopId; //商家编号
    private Integer hisIntegral;//历史积分
    private Integer usableIntegral;//可用积分
    private Integer integralNumber; //积分数量
    private String integralSource; //积分来源
    private Date createTime;//时间
    private String note;//备注

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

    public Integer getHisIntegral()
    {
        return this.hisIntegral;
    }

    public void setHisIntegral(Integer hisIntegral)
    {
        this.hisIntegral = hisIntegral;
    }

    public Integer getUsableIntegral()
    {
        return this.usableIntegral;
    }

    public void setUsableIntegral(Integer usableIntegral)
    {
        this.usableIntegral = usableIntegral;
    }

    public Integer getIntegralNumber()
    {
        return this.integralNumber;
    }

    public void setIntegralNumber(Integer integralNumber)
    {
        this.integralNumber = integralNumber;
    }

    public String getIntegralSource()
    {
        return this.integralSource;
    }

    public void setIntegralSource(String integralSource)
    {
        this.integralSource = integralSource;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public String getNote()
    {
        return this.note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

}
