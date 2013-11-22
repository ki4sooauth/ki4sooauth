package com.gooagoo.dao.generator.marketing;

import java.util.List;

import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.CouponExample;
import com.gooagoo.entity.generator.marketing.CouponKey;

public interface CouponMapper
{

    public Integer countByExample(CouponExample couponExample);

    public List<Coupon> selectByExample(CouponExample couponExample);

    public Coupon selectByPrimaryKey(CouponKey couponKey);

}
