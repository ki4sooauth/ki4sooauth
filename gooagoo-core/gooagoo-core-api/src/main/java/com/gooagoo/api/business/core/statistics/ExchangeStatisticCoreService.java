package com.gooagoo.api.business.core.statistics;

import java.util.Date;
import java.util.List;

public interface ExchangeStatisticCoreService
{

    /**
     * 查询营销兑换次数
     * @param couponId
     * @param userType
     * @param dateType
     * @param dateTime
     * @return
     */
    public abstract int marketingTimes(String marketingId);

    /**
     * 查询优惠凭证兑换次数
     * @param couponId
     * @param userType
     * @param dateType
     * @param dateTime
     * @return
     */
    public abstract int couponExchangeTimes(String couponId, String userType, String dateType, Date dateTime);

    /**
     * 查询优惠凭证兑换人群
     * @param couponId
     * @param userType
     * @param dateType
     * @param dateTime
     * @return
     */
    public abstract List<String> couponExchangePeople(String couponId, String userType, String dateType, Date dateTime);

    /**
     * 查询商品兑换次数
     * @param couponId
     * @param userType
     * @param dateType
     * @param dateTime
     * @return
     */
    public abstract int goodsExchangeTimes(String goodsId, String userType, String dateType, Date dateTime);

    /**
     * 查询商品兑换人群
     * @param couponId
     * @param userType
     * @param dateType
     * @param dateTime
     * @return
     */
    public abstract List<String> goodsExchangePeople(String goodsId, String userType, String dateType, Date dateTime);
}
