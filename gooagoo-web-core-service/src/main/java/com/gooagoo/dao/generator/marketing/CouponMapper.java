package com.gooagoo.dao.generator.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.CouponExample;
import com.gooagoo.entity.generator.marketing.CouponKey;

public interface CouponMapper
{

    public Integer countByExample(CouponExample couponExample);

    public List<Coupon> selectByExample(CouponExample couponExample);

    public Coupon selectByPrimaryKey(CouponKey couponKey);

    public Integer deleteByExample(CouponExample couponExample);

    public Integer deleteByPrimaryKey(CouponKey couponKey);

    public Integer insertSelective(Coupon coupon);

    public Integer updateAllByExample(@Param("record") Coupon coupon, @Param("example") CouponExample couponExample);

    public Integer updateByExampleSelective(@Param("record") Coupon coupon, @Param("example") CouponExample couponExample);

    public Integer updateByPrimaryKeySelective(Coupon coupon);

}
