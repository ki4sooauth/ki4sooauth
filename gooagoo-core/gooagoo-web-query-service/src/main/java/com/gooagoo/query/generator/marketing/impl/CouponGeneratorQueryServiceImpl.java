package com.gooagoo.query.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.marketing.CouponGeneratorQueryService;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.CouponExample;
import com.gooagoo.entity.generator.marketing.CouponKey;
import com.gooagoo.dao.generator.marketing.CouponMapper;

@Service
public class CouponGeneratorQueryServiceImpl implements CouponGeneratorQueryService
{

    @Autowired
    private CouponMapper couponMapper;

    @Override
    public Integer countByExample(CouponExample couponExample) 
    {
        return this.couponMapper.countByExample(couponExample);
    }

    @Override
    public List<Coupon> selectByExample(CouponExample couponExample) 
    {
        return this.couponMapper.selectByExample(couponExample);
    }

    @Override
    public Coupon selectUnDelByPrimaryKey(String primaryKey) 
    {
        CouponKey couponKey = new CouponKey();
        couponKey.setIsDel("N");
        couponKey.setCouponId(primaryKey);
        return this.couponMapper.selectByPrimaryKey(couponKey);
    }

    @Override
    public Coupon selectByPrimaryKey(String primaryKey) 
    {
        CouponKey couponKey = new CouponKey();
        couponKey.setCouponId(primaryKey);
        return this.couponMapper.selectByPrimaryKey(couponKey);
    }

}
