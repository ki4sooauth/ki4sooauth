package com.gooagoo.query.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.bill.UserOrderCouponGeneratorQueryService;
import com.gooagoo.entity.generator.bill.UserOrderCoupon;
import com.gooagoo.entity.generator.bill.UserOrderCouponExample;
import com.gooagoo.entity.generator.bill.UserOrderCouponKey;
import com.gooagoo.dao.generator.bill.UserOrderCouponMapper;

@Service
public class UserOrderCouponGeneratorQueryServiceImpl implements UserOrderCouponGeneratorQueryService
{

    @Autowired
    private UserOrderCouponMapper userOrderCouponMapper;

    @Override
    public Integer countByExample(UserOrderCouponExample userOrderCouponExample) 
    {
        return this.userOrderCouponMapper.countByExample(userOrderCouponExample);
    }

    @Override
    public List<UserOrderCoupon> selectByExample(UserOrderCouponExample userOrderCouponExample) 
    {
        return this.userOrderCouponMapper.selectByExample(userOrderCouponExample);
    }

    @Override
    public UserOrderCoupon selectByPrimaryKey(String primaryKey) 
    {
        UserOrderCouponKey userOrderCouponKey = new UserOrderCouponKey();
        userOrderCouponKey.setUserOrderDetailId(primaryKey);
        return this.userOrderCouponMapper.selectByPrimaryKey(userOrderCouponKey);
    }

}
