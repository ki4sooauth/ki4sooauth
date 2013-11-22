package com.gooagoo.dao.generator.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.sys.NominateCoupon;
import com.gooagoo.entity.generator.sys.NominateCouponExample;
import com.gooagoo.entity.generator.sys.NominateCouponKey;

public interface NominateCouponMapper
{

    public Integer countByExample(NominateCouponExample nominateCouponExample);

    public List<NominateCoupon> selectByExample(NominateCouponExample nominateCouponExample);

    public NominateCoupon selectByPrimaryKey(NominateCouponKey nominateCouponKey);

    public Integer deleteByExample(NominateCouponExample nominateCouponExample);

    public Integer deleteByPrimaryKey(NominateCouponKey nominateCouponKey);

    public Integer insertSelective(NominateCoupon nominateCoupon);

    public Integer updateAllByExample(@Param("record") NominateCoupon nominateCoupon, @Param("example") NominateCouponExample nominateCouponExample);

    public Integer updateByExampleSelective(@Param("record") NominateCoupon nominateCoupon, @Param("example") NominateCouponExample nominateCouponExample);

    public Integer updateByPrimaryKeySelective(NominateCoupon nominateCoupon);

}
