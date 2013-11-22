package com.gooagoo.api.business.query.system.nominate;

import java.util.List;

import com.gooagoo.entity.business.system.nominate.NominateCouponBusiness;

public interface NominateCouponQueryService
{

    /**
     * 查询推荐优惠凭证
     * @param nominateCouponBusiness
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<NominateCouponBusiness> findNominateCouponBusiness(NominateCouponBusiness nominateCouponBusiness, Integer pageIndex, Integer pageSize);

    /**
     * 查询推荐优惠凭证(count)
     * @param nominateCouponBusiness
     * @return
     */
    public int countNominateCouponBusiness(NominateCouponBusiness nominateCouponBusiness);

    /**
     * 单独查询推荐优惠凭证
     * @param nominateCouponBusiness
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<NominateCouponBusiness> findNominateCoupon(NominateCouponBusiness nominateCouponBusiness, Integer pageIndex, Integer pageSize);

    /**
     * 查询推荐优惠凭证(count)
     * @param nominateCouponBusiness
     * @return
     */
    public int countNominateCoupon(NominateCouponBusiness nominateCouponBusiness);

}
