package com.gooagoo.core.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.marketing.CouponGrantInfoGeneratorCoreService;
import com.gooagoo.entity.generator.marketing.CouponGrantInfo;
import com.gooagoo.entity.generator.marketing.CouponGrantInfoExample;
import com.gooagoo.entity.generator.marketing.CouponGrantInfoKey;
import com.gooagoo.dao.generator.marketing.CouponGrantInfoMapper;

@Service
public class CouponGrantInfoGeneratorCoreServiceImpl implements CouponGrantInfoGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(CouponGrantInfoExample couponGrantInfoExample) 
    {
        return this.couponGrantInfoMapper.deleteByExample(couponGrantInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        CouponGrantInfoKey couponGrantInfoKey = new CouponGrantInfoKey();
        couponGrantInfoKey.setId(primaryKey);
        return this.couponGrantInfoMapper.deleteByPrimaryKey(couponGrantInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(CouponGrantInfoExample couponGrantInfoExample) 
    {
        CouponGrantInfo couponGrantInfo = new CouponGrantInfo();
        couponGrantInfo.setIsDel("Y");
        return this.couponGrantInfoMapper.updateByExampleSelective(couponGrantInfo,couponGrantInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        CouponGrantInfo couponGrantInfo = new CouponGrantInfo();
        couponGrantInfo.setId(primaryKey);
        couponGrantInfo.setIsDel("Y");
        return this.couponGrantInfoMapper.updateByPrimaryKeySelective(couponGrantInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(CouponGrantInfo couponGrantInfo) 
    {
        return this.couponGrantInfoMapper.insertSelective(couponGrantInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(CouponGrantInfo couponGrantInfo,CouponGrantInfoExample couponGrantInfoExample) 
    {
        return this.couponGrantInfoMapper.updateByExampleSelective(couponGrantInfo,couponGrantInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(CouponGrantInfo couponGrantInfo) 
    {
        return this.couponGrantInfoMapper.updateByPrimaryKeySelective(couponGrantInfo) > 0 ? true : false;
    }

}
