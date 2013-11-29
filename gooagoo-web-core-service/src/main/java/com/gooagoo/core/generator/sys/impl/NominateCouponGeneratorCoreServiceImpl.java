package com.gooagoo.core.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.sys.NominateCouponGeneratorCoreService;
import com.gooagoo.entity.generator.sys.NominateCoupon;
import com.gooagoo.entity.generator.sys.NominateCouponExample;
import com.gooagoo.entity.generator.sys.NominateCouponKey;
import com.gooagoo.dao.generator.sys.NominateCouponMapper;

@Service
public class NominateCouponGeneratorCoreServiceImpl implements NominateCouponGeneratorCoreService
{

    @Autowired
    private NominateCouponMapper nominateCouponMapper;

    @Override
    public Integer countByExample(NominateCouponExample nominateCouponExample) 
    {
        return this.nominateCouponMapper.countByExample(nominateCouponExample);
    }

    @Override
    public List<NominateCoupon> selectByExample(NominateCouponExample nominateCouponExample) 
    {
        return this.nominateCouponMapper.selectByExample(nominateCouponExample);
    }

    @Override
    public NominateCoupon selectUnDelByPrimaryKey(String primaryKey) 
    {
        NominateCouponKey nominateCouponKey = new NominateCouponKey();
        nominateCouponKey.setIsDel("N");
        nominateCouponKey.setId(primaryKey);
        return this.nominateCouponMapper.selectByPrimaryKey(nominateCouponKey);
    }

    @Override
    public NominateCoupon selectByPrimaryKey(String primaryKey) 
    {
        NominateCouponKey nominateCouponKey = new NominateCouponKey();
        nominateCouponKey.setId(primaryKey);
        return this.nominateCouponMapper.selectByPrimaryKey(nominateCouponKey);
    }

    @Override
    public boolean physicalDeleteByExample(NominateCouponExample nominateCouponExample) 
    {
        return this.nominateCouponMapper.deleteByExample(nominateCouponExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        NominateCouponKey nominateCouponKey = new NominateCouponKey();
        nominateCouponKey.setId(primaryKey);
        return this.nominateCouponMapper.deleteByPrimaryKey(nominateCouponKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(NominateCouponExample nominateCouponExample) 
    {
        NominateCoupon nominateCoupon = new NominateCoupon();
        nominateCoupon.setIsDel("Y");
        return this.nominateCouponMapper.updateByExampleSelective(nominateCoupon,nominateCouponExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        NominateCoupon nominateCoupon = new NominateCoupon();
        nominateCoupon.setId(primaryKey);
        nominateCoupon.setIsDel("Y");
        return this.nominateCouponMapper.updateByPrimaryKeySelective(nominateCoupon) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(NominateCoupon nominateCoupon) 
    {
        return this.nominateCouponMapper.insertSelective(nominateCoupon) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(NominateCoupon nominateCoupon,NominateCouponExample nominateCouponExample) 
    {
        return this.nominateCouponMapper.updateByExampleSelective(nominateCoupon,nominateCouponExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(NominateCoupon nominateCoupon) 
    {
        return this.nominateCouponMapper.updateByPrimaryKeySelective(nominateCoupon) > 0 ? true : false;
    }

}
