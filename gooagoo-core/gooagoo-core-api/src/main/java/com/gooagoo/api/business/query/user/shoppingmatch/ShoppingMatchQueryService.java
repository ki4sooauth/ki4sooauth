package com.gooagoo.api.business.query.user.shoppingmatch;

import java.util.List;

import com.gooagoo.entity.business.goods.ShopGoodsDetailInfo;
import com.gooagoo.entity.business.user.shoppingmatch.PositionInfo;

/**
 * 购物匹配
 */
public interface ShoppingMatchQueryService
{

    /**
     * 购物匹配（主动）
     * mobd08
     * @param userid
     * @param mac
     * @param keyword
     * @return List<Position>
     */
    public List<PositionInfo> shoppingMatch(String userid, String mac, String keyword) throws Exception;

    /**
     * 查询用户“购物清单”在当前区域内匹配的商品信息列表
     * mobd02
     * @param goodsids 多个商品编号用逗号分隔
     * @return List<ShopGoodsDetailInfo>
     * @throws Exception
     */
    public List<ShopGoodsDetailInfo> getMatchgoodslistInfo(String goodsids) throws Exception;

}
