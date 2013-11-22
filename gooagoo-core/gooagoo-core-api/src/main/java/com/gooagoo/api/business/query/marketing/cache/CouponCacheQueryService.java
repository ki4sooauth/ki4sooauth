package com.gooagoo.api.business.query.marketing.cache;

import java.util.Map;

/**
 * 从缓存中查询优惠凭证相关信息
 */
public interface CouponCacheQueryService
{
    /**
     * 查询优惠凭证
     * @param couponId
     * @return 
     * @throws Exception
     */
    public Map<String, String> findCoupon(String couponId);

}
