package com.gooagoo.api.business.query.marketing.shopintegral;

import java.util.List;

import com.gooagoo.entity.business.marketing.TradeRequest;
import com.gooagoo.entity.business.marketing.TradeResponse;

public interface ShopIntegralQueryService
{

    /**
     *  6.3.1. 兑换物品列表（分页、排序）
     * @param TradeRequest
     * @return
     */
    public List<TradeResponse> findTradeList(TradeRequest tradeRequest) throws Exception;

    /**
     *  6.3.3. 积分兑换信息列表查询
     * @param String
     * @return
     */
    public boolean findShopIntegralConvert(String parameter) throws Exception;

    /**
     * 积分特批列表查询
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean findIntegralSpecialApproval(String parameter) throws Exception;

}
