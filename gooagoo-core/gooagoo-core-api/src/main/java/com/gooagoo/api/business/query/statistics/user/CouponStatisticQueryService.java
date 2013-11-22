package com.gooagoo.api.business.query.statistics.user;

import java.util.List;

import com.gooagoo.entity.generator.marketing.Coupon;

public interface CouponStatisticQueryService
{
    /**
     * 猜你喜欢的优惠凭证
     * @param account 用户编号
     * @return 优惠凭证列表
     * @throws Exception
     */
    public abstract List<Coupon> queryGuessYouTastes(String account) throws Exception;

}
