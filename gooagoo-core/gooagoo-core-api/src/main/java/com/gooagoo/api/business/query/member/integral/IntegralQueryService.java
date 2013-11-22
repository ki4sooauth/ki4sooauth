package com.gooagoo.api.business.query.member.integral;

import java.util.Date;
import java.util.List;

import com.gooagoo.entity.business.member.IntegralConvertDetail;
import com.gooagoo.entity.generator.marketing.ShopIntegral;

public interface IntegralQueryService
{
    /**
     * 5.1.7. 会员查询会员积分
     * @param userId
     * @param shopId
     * @return String 用户在此商家积分(没有则返回null)
     * @throws Exception
     */
    public String findIntegral(String userId, String shopId) throws Exception;

    /**
     * 查询兑换记录列表（分页、排序）
     * @param userId
     * @param shopId
     * @param startConvertTime
     * @param endConvertTime
     * @param integralTradeType
     * @param pageIndex
     * @param pageSize
     * @param orderBy
     * @return
     * @throws Exception
     */
    public List<IntegralConvertDetail> findIntegralExchange(String userId, String shopId, Date startConvertTime, Date endConvertTime, String integralTradeType, Integer pageIndex, Integer pageSize, String orderBy) throws Exception;

    /**
     * 查询兑换积分信息
     * @param shopIntegralId 积分营销编号
     * @param integralTradeId 积分兑换对象编号
     */
    public ShopIntegral findConvertShopIntegral(String shopIntegralId, String integralTradeId) throws Exception;

}
