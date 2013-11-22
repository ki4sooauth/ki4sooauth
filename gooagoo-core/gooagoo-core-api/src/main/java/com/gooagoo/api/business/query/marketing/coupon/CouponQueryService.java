package com.gooagoo.api.business.query.marketing.coupon;

import com.gooagoo.entity.business.marketing.CouponDetail;

/**
 * 优惠凭证管理
 */
public interface CouponQueryService
{

    /**
     *     6.1.5. 优惠凭证详情
     * @param couponId
     * @return true/false
     * @throws Exception
     */
    public CouponDetail findCouponDetail(String couponId) throws Exception;

}
