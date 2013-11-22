package com.gooagoo.query.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.sys.NominateCouponGeneratorQueryService;
import com.gooagoo.entity.generator.sys.NominateCoupon;
import com.gooagoo.entity.generator.sys.NominateCouponExample;
import com.gooagoo.entity.generator.sys.NominateCouponKey;
import com.gooagoo.dao.generator.sys.NominateCouponMapper;

@Service
public class NominateCouponGeneratorQueryServiceImpl implements NominateCouponGeneratorQueryService
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

}
