package com.gooagoo.view.gms.marketing;

import java.util.Date;
import java.io.Serializable;

/**
 * 优惠凭证发放号段对应表
 */

public class FCouponGrantInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

    private String couponId;//优惠凭证编号

    private String couponNo;//号段号码

    private String couponAudioId;//优惠凭证音频编号

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getCouponId()
    {
        return couponId;
    }

    public void setCouponId(String couponId)
    {
        this.couponId = couponId;
    }

    public String getCouponNo()
    {
        return couponNo;
    }

    public void setCouponNo(String couponNo)
    {
        this.couponNo = couponNo;
    }

    public String getCouponAudioId()
    {
        return couponAudioId;
    }

    public void setCouponAudioId(String couponAudioId)
    {
        this.couponAudioId = couponAudioId;
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

    public Date getCTimeStamp()
    {
        return cTimeStamp;
    }

    public void setCTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    public String toString()
    {
        return this.id + "^" + this.couponId + "^" + this.couponNo + "^" + this.couponAudioId + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
