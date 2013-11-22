package com.gooagoo.api.business.query.marketing.analysis;

import java.util.List;
import java.util.Map;

import com.gooagoo.entity.business.marketing.analysis.GuessYouLikeActivity;
import com.gooagoo.entity.business.marketing.analysis.GuessYouLikeCoupon;
import com.gooagoo.entity.business.marketing.analysis.GuessYouLikeGoods;

public interface GuessYouLikeQueryService
{
    /**
     * 猜你喜欢（活动）分页
     * @param userId
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<GuessYouLikeActivity> guessYouLikeActivity(String userId, Integer pageIndex, Integer pageSize) throws Exception;

    /**
     * 猜你喜欢（优惠券）分页
     * @param userId
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    public Map<String, List<GuessYouLikeCoupon>> guessYouLikeCoupon(String userId, Integer pageIndex, Integer pageSize) throws Exception;

    /**
     * 猜你喜欢（商品）分页
     * @param userId
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<GuessYouLikeGoods> guessYouLikeGoods(String userId, Integer pageIndex, Integer pageSize) throws Exception;

}
