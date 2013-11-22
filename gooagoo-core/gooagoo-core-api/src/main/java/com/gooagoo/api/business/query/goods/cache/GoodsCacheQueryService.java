package com.gooagoo.api.business.query.goods.cache;

import java.util.Map;

/**
 * 从缓存中查询商品相关信息
 */
public interface GoodsCacheQueryService
{
    /**
     * 查询商品信息
     * @param UserId_ShopId
     * @return
     * @throws Exception
     */
    public Map<String, String> findGoodsInfo(String goodsId);

    /**
     * 查询商品品类
     * @param shopEntityId
     * @param categoryId
     * @return
     * @throws Exception
     */
    public Map<String, String> findGoodsCategory(String shopEntityId, String categoryId) throws Exception;

}
