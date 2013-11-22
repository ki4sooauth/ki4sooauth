package com.gooagoo.api.business.query.marketing.analysis;

import java.util.List;

import com.gooagoo.entity.business.marketing.analysis.HotCommentGoods;

public interface HotCommentQueryService
{
    /**
     * 热品商品（分页，根据个人定制）redis
     * @param userId
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<HotCommentGoods> hotComment(String userId, Integer pageIndex, Integer pageSize) throws Exception;

}
