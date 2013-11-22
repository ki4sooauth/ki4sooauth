package com.gooagoo.dao.generator.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.bill.UserOrderCoupon;
import com.gooagoo.entity.generator.bill.UserOrderCouponExample;
import com.gooagoo.entity.generator.bill.UserOrderCouponKey;

public interface UserOrderCouponMapper
{

    public Integer countByExample(UserOrderCouponExample userOrderCouponExample);

    public List<UserOrderCoupon> selectByExample(UserOrderCouponExample userOrderCouponExample);

    public UserOrderCoupon selectByPrimaryKey(UserOrderCouponKey userOrderCouponKey);

    public Integer deleteByExample(UserOrderCouponExample userOrderCouponExample);

    public Integer deleteByPrimaryKey(UserOrderCouponKey userOrderCouponKey);

    public Integer insertSelective(UserOrderCoupon userOrderCoupon);

    public Integer updateAllByExample(@Param("record") UserOrderCoupon userOrderCoupon, @Param("example") UserOrderCouponExample userOrderCouponExample);

    public Integer updateByExampleSelective(@Param("record") UserOrderCoupon userOrderCoupon, @Param("example") UserOrderCouponExample userOrderCouponExample);

    public Integer updateByPrimaryKeySelective(UserOrderCoupon userOrderCoupon);

}
