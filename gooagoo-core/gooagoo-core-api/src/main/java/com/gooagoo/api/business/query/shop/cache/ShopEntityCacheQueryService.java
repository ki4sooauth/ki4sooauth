package com.gooagoo.api.business.query.shop.cache;

import java.util.Map;

/**
 * 从缓存中查询实体店相关信息
 */
public interface ShopEntityCacheQueryService
{
    /**
     * 查询实体店信息
     * @param shopEntityId
     * @return
     * @throws Exceptions
     */
    public Map<String, String> findShopEntityInfo(String shopEntityId) throws Exception;

}
