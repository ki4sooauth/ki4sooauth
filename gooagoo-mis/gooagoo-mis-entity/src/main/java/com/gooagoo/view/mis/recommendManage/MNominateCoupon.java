package com.gooagoo.view.mis.recommendManage;

import java.io.Serializable;
import java.util.Date;

/**
 * 推荐优惠凭证
 * @author Administrator
 *
 */
public class MNominateCoupon implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String id;// 自动编号，UUID
    private String shopId;// 商家编号
    private String couponId;// 优惠凭证编号，UUID
    private String couponName;// 优惠凭证名称
    private String couponUrl;// 优惠凭证图片URL
    private Date startTime;// 起始时间
    private Date endTime;// 结束时间
    private String isDel;// 是否删除，Y-已删除，N-未删除
    private Date createTime;// 创建时间
    private Date cTimeStamp;// 最后一次修改时间

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getCouponId()
    {
        return couponId;
    }

    public void setCouponId(String couponId)
    {
        this.couponId = couponId;
    }

    public String getCouponName()
    {
        return couponName;
    }

    public void setCouponName(String couponName)
    {
        this.couponName = couponName;
    }

    public String getCouponUrl()
    {
        return couponUrl;
    }

    public void setCouponUrl(String couponUrl)
    {
        this.couponUrl = couponUrl;
    }

    public Date getStartTime()
    {
        return startTime;
    }

    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }

    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
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
