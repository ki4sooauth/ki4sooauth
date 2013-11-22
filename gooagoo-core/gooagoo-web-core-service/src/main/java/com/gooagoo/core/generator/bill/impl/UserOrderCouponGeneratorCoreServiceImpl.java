package com.gooagoo.core.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.bill.UserOrderCouponGeneratorCoreService;
import com.gooagoo.entity.generator.bill.UserOrderCoupon;
import com.gooagoo.entity.generator.bill.UserOrderCouponExample;
import com.gooagoo.entity.generator.bill.UserOrderCouponKey;
import com.gooagoo.dao.generator.bill.UserOrderCouponMapper;

@Service
public class UserOrderCouponGeneratorCoreServiceImpl implements UserOrderCouponGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(UserOrderCouponExample userOrderCouponExample) 
    {
        return this.userOrderCouponMapper.deleteByExample(userOrderCouponExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        UserOrderCouponKey userOrderCouponKey = new UserOrderCouponKey();
        userOrderCouponKey.setUserOrderDetailId(primaryKey);
        return this.userOrderCouponMapper.deleteByPrimaryKey(userOrderCouponKey) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(UserOrderCoupon userOrderCoupon) 
    {
        return this.userOrderCouponMapper.insertSelective(userOrderCoupon) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(UserOrderCoupon userOrderCoupon,UserOrderCouponExample userOrderCouponExample) 
    {
        return this.userOrderCouponMapper.updateByExampleSelective(userOrderCoupon,userOrderCouponExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(UserOrderCoupon userOrderCoupon) 
    {
        return this.userOrderCouponMapper.updateByPrimaryKeySelective(userOrderCoupon) > 0 ? true : false;
    }

}
