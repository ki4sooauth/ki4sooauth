package com.gooagoo.core.business.system.resource.recommend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.system.resource.recommend.RecommendCouponCoreService;
import com.gooagoo.api.generator.core.sys.NominateCouponGeneratorCoreService;
import com.gooagoo.entity.generator.sys.NominateCoupon;

@Service
public class RecommendCouponCoreServiceImpl implements RecommendCouponCoreService

{

    @Autowired
    private NominateCouponGeneratorCoreService nominateCouponGeneratorCoreService;

    @Override
    public boolean addRecommendCoupon(NominateCoupon nominateCoupon) throws Exception
    {
        nominateCoupon.setIsDel("N");
        return this.nominateCouponGeneratorCoreService.insertSelective(nominateCoupon);
    }

    @Override
    public boolean delRecommendCoupon(String id) throws Exception
    {
        NominateCoupon nominateCoupon = new NominateCoupon();
        nominateCoupon.setId(id);
        nominateCoupon.setIsDel("Y");
        return this.nominateCouponGeneratorCoreService.updateByPrimaryKeySelective(nominateCoupon);
    }

    @Override
    public boolean updateRecommendCoupon(NominateCoupon nominateCoupon) throws Exception
    {
        return this.nominateCouponGeneratorCoreService.updateByPrimaryKeySelective(nominateCoupon);
    }

}
