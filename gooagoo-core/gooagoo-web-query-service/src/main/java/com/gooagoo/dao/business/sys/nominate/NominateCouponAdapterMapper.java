package com.gooagoo.dao.business.sys.nominate;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.business.system.nominate.NominateCouponBusiness;

/**
 * 推荐优惠凭证
 * @author Administrator
 *
 */
public interface NominateCouponAdapterMapper
{
    /**
     * 条件查询推荐优惠凭证
     * @param nominateCouponBusiness
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<NominateCouponBusiness> findNominateCouponBusiness(@Param("nominateCouponBusiness") NominateCouponBusiness nominateCouponBusiness, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    /**
     * 条件查询推荐优惠凭证(count)
     * @param nominateCouponBusiness
     * @return
     */
    public int countNominateCouponBusiness(@Param("nominateCouponBusiness") NominateCouponBusiness nominateCouponBusiness);

    /**
     * 单独查询推荐优惠凭证
     * @param nominateCouponBusiness
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<NominateCouponBusiness> findNominateCoupon(@Param("nominateCouponBusiness") NominateCouponBusiness nominateCouponBusiness, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    /**
     * 条件查询推荐优惠凭证(count)
     * @param nominateCouponBusiness
     * @return
     */
    public int countNominateCoupon(@Param("nominateCouponBusiness") NominateCouponBusiness nominateCouponBusiness);

}
