package com.gooagoo.api.business.query.goods.query;

import com.gooagoo.entity.business.goods.ShopGoodsDetailInfo;

/**
 * 商家查询商品
 */
public interface ShopGoodsQueryService
{

    /**
     * 根据商品Id查询商品详情
     * @param goodsId 商品编号
     */
    public ShopGoodsDetailInfo findGoodsDetail(String goodsId) throws Exception;

}
