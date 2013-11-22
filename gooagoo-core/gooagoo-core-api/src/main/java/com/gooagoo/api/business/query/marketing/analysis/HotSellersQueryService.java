package com.gooagoo.api.business.query.marketing.analysis;

import java.util.List;

import com.gooagoo.entity.business.marketing.analysis.HotSellerGoods;

public interface HotSellersQueryService
{
    /**
     * 热卖商品（分页，根据个人定制）redis
     * @param userId
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<HotSellerGoods> hotSeller(String userId, Integer pageIndex, Integer pageSize) throws Exception;

}
