package com.gooagoo.entity.generator.sys;

import java.io.Serializable;
import java.util.Date;

/**
 * 推荐优惠凭证。gooagoo平台向客户推荐优惠凭证，在我的收藏中展示推荐的优惠凭证信息。
 */

public class NominateCoupon implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

    private String shopId;//商家编号

    private String couponId;//优惠凭证编号，UUID

    private Date startTime;//起始时间

    private Date endTime;//结束时间

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

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
        return this.id + "^" + this.shopId + "^" + this.couponId + "^" + this.startTime + "^" + this.endTime + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
