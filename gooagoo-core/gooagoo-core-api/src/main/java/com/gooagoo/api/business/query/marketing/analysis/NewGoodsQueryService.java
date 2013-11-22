package com.gooagoo.api.business.query.marketing.analysis;

import java.util.List;

import com.gooagoo.entity.business.marketing.analysis.NewGoods;

public interface NewGoodsQueryService
{
    /**
     * 最新上架（分页，根据个人定制）redis
     * @param userId
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<NewGoods> newGoods(String userId, Integer pageIndex, Integer pageSize) throws Exception;

}
