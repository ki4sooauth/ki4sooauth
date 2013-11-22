package com.gooagoo.api.business.core.statistics.user;

import java.util.List;

import com.gooagoo.entity.business.goods.CrossGoods;

public interface GoodsStatisticCoreService
{
    /**
     * 猜你喜欢的商品
     * @param account 用户编号
     * @return 商品列表
     * @throws Exception
     */
    public abstract List<CrossGoods> queryGuessYouTastes(String account) throws Exception;

    /**
     * 热评商品
     * @return 商品列表
     * @throws Exception
     */
    public abstract List<CrossGoods> queryHotComments() throws Exception;

    /**
     * 热卖商品
     * @return 商品列表
     * @throws Exception
     */
    public abstract List<CrossGoods> queryHotSales() throws Exception;

    /**
     * 商品评论次数
     * @param key=hotComment
     * @param goodsId
     * @return Double
     * @throws Exception
     */
    public Double findCommentNum(String key, String goodsId) throws Exception;

}
