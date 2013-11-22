package com.gooagoo.api.business.core.goods.cache;

import java.util.Map;

/**
 * 从缓存中查询商品相关信息
 */
public interface GoodsCacheCoreService
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

    /**
     * 接口gtsc26: 平台查询博立协议的沽清列表
     * @param shopEntityId
     * @param itemSerialList json (例:["54654", "524541"])
     * @return
     * @throws Exception
     */
    public boolean addExhaustedGoods(String shopEntityId, String itemSerialList) throws Exception;

}
