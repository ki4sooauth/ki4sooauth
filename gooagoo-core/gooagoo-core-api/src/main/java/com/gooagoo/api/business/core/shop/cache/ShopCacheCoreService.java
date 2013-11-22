package com.gooagoo.api.business.core.shop.cache;

import java.util.Map;

import com.gooagoo.entity.generator.base.ShopType;

/**
 * 从缓存中查询商家用户相关信息
 */
public interface ShopCacheCoreService
{
    /**
     * 查询商家信息
     * @param shopId
     * @return
     * @throws Exceptions
     */
    public Map<String, String> findShopInfo(String shopId) throws Exception;

    /**
     * 查询商家类型
     * @param shopTypeId
     * @return
     * @throws Exception
     */
    public ShopType findShopCategory(String shopTypeId) throws Exception;

}
