package com.gooagoo.query.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.marketing.CouponGrantInfoGeneratorQueryService;
import com.gooagoo.entity.generator.marketing.CouponGrantInfo;
import com.gooagoo.entity.generator.marketing.CouponGrantInfoExample;
import com.gooagoo.entity.generator.marketing.CouponGrantInfoKey;
import com.gooagoo.dao.generator.marketing.CouponGrantInfoMapper;

@Service
public class CouponGrantInfoGeneratorQueryServiceImpl implements CouponGrantInfoGeneratorQueryService
{

    @Autowired
    private CouponGrantInfoMapper couponGrantInfoMapper;

    @Override
    public Integer countByExample(CouponGrantInfoExample couponGrantInfoExample) 
    {
        return this.couponGrantInfoMapper.countByExample(couponGrantInfoExample);
    }

    @Override
    public List<CouponGrantInfo> selectByExample(CouponGrantInfoExample couponGrantInfoExample) 
    {
        return this.couponGrantInfoMapper.selectByExample(couponGrantInfoExample);
    }

    @Override
    public CouponGrantInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        CouponGrantInfoKey couponGrantInfoKey = new CouponGrantInfoKey();
        couponGrantInfoKey.setIsDel("N");
        couponGrantInfoKey.setId(primaryKey);
        return this.couponGrantInfoMapper.selectByPrimaryKey(couponGrantInfoKey);
    }

    @Override
    public CouponGrantInfo selectByPrimaryKey(String primaryKey) 
    {
        CouponGrantInfoKey couponGrantInfoKey = new CouponGrantInfoKey();
        couponGrantInfoKey.setId(primaryKey);
        return this.couponGrantInfoMapper.selectByPrimaryKey(couponGrantInfoKey);
    }

}
