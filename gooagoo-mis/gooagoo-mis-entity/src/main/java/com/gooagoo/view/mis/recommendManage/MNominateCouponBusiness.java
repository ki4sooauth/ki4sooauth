package com.gooagoo.view.mis.recommendManage;

import java.io.Serializable;
import java.util.Date;

/**
 * 推荐优惠券
 */
public class MNominateCouponBusiness implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;//推荐优惠券表自动编号
    private String shopId;//推荐优惠券表商家编号
    private String couponId;//推荐优惠券表优惠凭证编号
    private Date startTime;//推荐优惠券表起始时间
    private Date endTime;//推荐优惠券表结束时间
    private Date nominateCouponCTimeStamp;//推荐优惠券表更新时间
    private String shopName;//商家信息表商家名称
    private String couponName;//优惠券信息表优惠凭证名称
    private Date publishStartTime;//优惠券信息表优惠凭证发行开始日期
    private Date publishEndTime;//优惠券信息表优惠凭证发行截止日期
    private Date useStartTime;//优惠券信息表使用生效日期
    private Date useEndTime;//优惠券信息表使用截止日期
    private Integer amount;//优惠券信息表发放数量
    private Integer maxNumOwner;//优惠券信息表个人拥有数量
    private String publishStatus;//优惠券信息表状态
    private Date couponCTimeStamp;//优惠券信息表更新时间
    private String isNominate;//是否推荐（非数据库字段）Y-推荐，N-不推荐
    private String couponType;//优惠凭证类型

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

    public String getCouponId()
    {
        return this.couponId;
    }

    public void setCouponId(String couponId)
    {
        this.couponId = couponId;
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

    public Date getNominateCouponCTimeStamp()
    {
        return this.nominateCouponCTimeStamp;
    }

    public void setNominateCouponCTimeStamp(Date nominateCouponCTimeStamp)
    {
        this.nominateCouponCTimeStamp = nominateCouponCTimeStamp;
    }

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getCouponName()
    {
        return this.couponName;
    }

    public void setCouponName(String couponName)
    {
        this.couponName = couponName;
    }

    public Date getPublishStartTime()
    {
        return this.publishStartTime;
    }

    public void setPublishStartTime(Date publishStartTime)
    {
        this.publishStartTime = publishStartTime;
    }

    public Date getPublishEndTime()
    {
        return this.publishEndTime;
    }

    public void setPublishEndTime(Date publishEndTime)
    {
        this.publishEndTime = publishEndTime;
    }

    public Date getUseStartTime()
    {
        return this.useStartTime;
    }

    public void setUseStartTime(Date useStartTime)
    {
        this.useStartTime = useStartTime;
    }

    public Date getUseEndTime()
    {
        return this.useEndTime;
    }

    public void setUseEndTime(Date useEndTime)
    {
        this.useEndTime = useEndTime;
    }

    public Integer getAmount()
    {
        return this.amount;
    }

    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }

    public Integer getMaxNumOwner()
    {
        return this.maxNumOwner;
    }

    public void setMaxNumOwner(Integer maxNumOwner)
    {
        this.maxNumOwner = maxNumOwner;
    }

    public String getPublishStatus()
    {
        return this.publishStatus;
    }

    public void setPublishStatus(String publishStatus)
    {
        this.publishStatus = publishStatus;
    }

    public Date getCouponCTimeStamp()
    {
        return this.couponCTimeStamp;
    }

    public void setCouponCTimeStamp(Date couponCTimeStamp)
    {
        this.couponCTimeStamp = couponCTimeStamp;
    }

    public String getIsNominate()
    {
        return this.isNominate;
    }

    public void setIsNominate(String isNominate)
    {
        this.isNominate = isNominate;
    }

    public String getCouponType()
    {
        return couponType;
    }

    public void setCouponType(String couponType)
    {
        this.couponType = couponType;
    }

    @Override
    public String toString()
    {
        return "NominateCouponBusiness [id=" + this.id + ", shopId=" + this.shopId + ", couponId=" + this.couponId + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", nominateCouponCTimeStamp=" + this.nominateCouponCTimeStamp + ", shopName=" + this.shopName + ", couponName=" + this.couponName + ", publishStartTime=" + this.publishStartTime + ", publishEndTime=" + this.publishEndTime + ", useStartTime=" + this.useStartTime + ", useEndTime=" + this.useEndTime + ", amount=" + this.amount + ", maxNumOwner=" + this.maxNumOwner + ", publishStatus=" + this.publishStatus + ", couponCTimeStamp=" + this.couponCTimeStamp + ", isNominate=" + this.isNominate + "]";
    }

}
