package com.gooagoo.api.business.core.system.resource.recommend;

import com.gooagoo.entity.generator.sys.NominateCoupon;

/**
 *  推荐优惠凭证管理
 */
public interface RecommendCouponCoreService

{

    /**
     * 新增推荐优惠凭证
     * @param nominateCoupon
     * @return
     * @throws Exception
     */
    public boolean addRecommendCoupon(NominateCoupon nominateCoupon) throws Exception;

    /**
     * 编辑推荐优惠凭证
     * @param nominateCoupon
     * @return
     * @throws Exception
     */
    public boolean updateRecommendCoupon(NominateCoupon nominateCoupon) throws Exception;

    /**
     * 删除推荐优惠凭证
     * @param id
     * @return
     * @throws Exception
     */
    public boolean delRecommendCoupon(String id) throws Exception;

}
