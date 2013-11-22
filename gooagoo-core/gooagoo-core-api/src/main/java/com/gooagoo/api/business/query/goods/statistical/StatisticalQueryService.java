package com.gooagoo.api.business.query.goods.statistical;

import java.util.Date;
import java.util.List;

import com.gooagoo.entity.business.goods.GoodsSalesRanking;

/***
 * 商品统计分析
 *
 */
public interface StatisticalQueryService
{

    /**
     * 2.1.12. 统计已购商品数量
     * @param userId
     * @param shopId
     * @param begin
     * @param end
     * @param goodsName
     * @return
     * @throws Exception
     */
    public Integer purchasedGoods(String userId, String shopId, Date begin, Date end, String goodsName) throws Exception;

    /**
     * 品类销售排行查询
     * @param keyword 品类-暂不支持
     * @param positionId
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<GoodsSalesRanking> salesRanking(String shopId, String categoryId, String keyword, String positionId, Integer pageIndex, Integer pageSize) throws Exception;

}
