package com.gooagoo.entity.generator.member;

import java.io.Serializable;
import java.util.Date;

/**
 * 积分明细表
 */

public class IntegralDetailInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String integralId;//积分明细编号，UUID

    private String userId;//用户编号

    private String shopId;//商家编号

    private Integer integralNumber;//积分数量

    private String integralSource;//积分来源，参考通用字典表的integral_source

    private Date integralCreateTime;//积分产生时间

    private String note;//备注，描述特批人员及特批原因；如果是行为产生的，则记录行为编号

    private String isFreez;//是否冻结，N-未冻结，Y-已冻结

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

    public Date getIntegralCreateTime()
    {
        return this.integralCreateTime;
    }

    public void setIntegralCreateTime(Date integralCreateTime)
    {
        this.integralCreateTime = integralCreateTime;
    }

    public String getNote()
    {
        return this.note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public String getIsFreez()
    {
        return this.isFreez;
    }

    public void setIsFreez(String isFreez)
    {
        this.isFreez = isFreez;
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
        return this.integralId + "^" + this.userId + "^" + this.shopId + "^" + this.integralNumber + "^" + this.integralSource + "^" + this.integralCreateTime + "^" + this.note + "^" + this.isFreez + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
