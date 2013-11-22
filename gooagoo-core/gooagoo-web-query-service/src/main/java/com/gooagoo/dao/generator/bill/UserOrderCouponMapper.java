package com.gooagoo.dao.generator.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.UserOrderCoupon;
import com.gooagoo.entity.generator.bill.UserOrderCouponExample;
import com.gooagoo.entity.generator.bill.UserOrderCouponKey;

public interface UserOrderCouponMapper
{

    public Integer countByExample(UserOrderCouponExample userOrderCouponExample);

    public List<UserOrderCoupon> selectByExample(UserOrderCouponExample userOrderCouponExample);

    public UserOrderCoupon selectByPrimaryKey(UserOrderCouponKey userOrderCouponKey);

}
