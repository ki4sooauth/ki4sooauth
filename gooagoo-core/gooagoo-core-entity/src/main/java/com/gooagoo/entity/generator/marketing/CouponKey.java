package com.gooagoo.entity.generator.marketing;

import java.io.Serializable;

/**
 * 优惠凭证
 */

public class CouponKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String couponId;//优惠凭证编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getCouponId()
    {
        return couponId;
    }

    public void setCouponId(String couponId)
    {
        this.couponId = couponId;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

}
