package com.gooagoo.api.business.query.marketing.qualitygoods;

import com.gooagoo.entity.business.marketing.QualityGoodsForPlace;

public interface QualityGoodsQueryService
{
    /**
     * 精品推荐(吆喝广场、收藏广场)
     * mobc05,mobb08
     * @param userId
     * @param shopId
     * @param keyword
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    public QualityGoodsForPlace findQualityGoodsForPlace(String userId, String shopId, String keyword, Integer pageIndex, Integer pageSize) throws Exception;

}
