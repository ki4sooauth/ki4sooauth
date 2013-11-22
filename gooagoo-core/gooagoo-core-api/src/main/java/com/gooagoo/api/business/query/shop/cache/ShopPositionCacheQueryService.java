package com.gooagoo.api.business.query.shop.cache;

import java.util.Map;

public interface ShopPositionCacheQueryService
{
    /**
     * 查询位置信息
     * @param positionId
     * @return
     * @throws Exception
     */
    public Map<String, String> findPosition(String positionId) throws Exception;
}
