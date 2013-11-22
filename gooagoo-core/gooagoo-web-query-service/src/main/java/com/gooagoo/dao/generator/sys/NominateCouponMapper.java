package com.gooagoo.dao.generator.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.NominateCoupon;
import com.gooagoo.entity.generator.sys.NominateCouponExample;
import com.gooagoo.entity.generator.sys.NominateCouponKey;

public interface NominateCouponMapper
{

    public Integer countByExample(NominateCouponExample nominateCouponExample);

    public List<NominateCoupon> selectByExample(NominateCouponExample nominateCouponExample);

    public NominateCoupon selectByPrimaryKey(NominateCouponKey nominateCouponKey);

}
