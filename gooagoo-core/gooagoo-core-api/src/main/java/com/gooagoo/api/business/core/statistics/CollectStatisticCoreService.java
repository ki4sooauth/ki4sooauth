package com.gooagoo.api.business.core.statistics;

import java.util.Date;
import java.util.List;

public interface CollectStatisticCoreService
{

    /**
     * 查询优惠凭证收藏次数
     * 
     * @param couponId
     * @param userType
     * @param dateType
     * @param dateTime
     * @param channel
     * @param source
     * @return
     */
    public abstract int couponCollectTimes(String couponId, String userType, String dateType, Date dateTime, String channel, String source);

    /**
     * 查询优惠凭证收藏人群
     * 
     * @param couponId
     * @param userType
     * @param dateType
     * @param dateTime
     * @param channel
     * @param source
     * @return
     */
    public abstract List<String> couponCollectPeople(String couponId, String userType, String dateType, Date dateTime, String channel, String source);

    /**
     * 查询活动收藏次数
     * 
     * @param activityId
     * @param userType
     * @param dateType
     * @param dateTime
     * @param channel
     * @param source
     * @return
     */
    public abstract int activityCollectTimes(String activityId, String userType, String dateType, Date dateTime, String channel, String source);

    /**
     * 查询活动收藏人群
     * 
     * @param activityId
     * @param userType
     * @param dateType
     * @param dateTime
     * @param channel
     * @param source
     * @return
     */
    public abstract List<String> activityCollectPoeple(String activityId, String userType, String dateType, Date dateTime, String channel, String source);

    /**
     * 查询商品收藏次数
     * 
     * @param shopId 商家id或实体店id
     * @param goodsSerialNo 商品序列号
     * @param dateType时间类型
     * @param userType 用户类型
     * @param channel 渠道
     * @param source 来源
     * @param dateTime 时间
     * @return
     */
    public abstract int goodsCollectTimes(String shopId, String goodsSerialNo, String dateType, String userType, String channel, String source, Date dateTime);

    /**
     * 查询商品收藏人群
     * 
     * @param shopId 商家id或实体店id
     * @param goodsSerialNo  商品序列号
     * @param dateType  时间类型
     * @param userType  用户类型
     * @param channel 渠道
     * @param source 来源
     * @param dateTime 时间
     * @return
     */
    public abstract List<String> goodsCollectPoeple(String shopId, String goodsSerialNo, String dateType, String userType, String channel, String source, Date dateTime);

    /**
     * 查询品类收藏次数
     * 
     * @param shopId  实体店id或商家id
     * @param categorySerialNo 品类序列号
     * @param dateType  时间类型
     * @param userType 用户类型
     * @param channel  渠道
     * @param source  来源
     * @param dateTime 时间
     * @return
     */
    public abstract int categoryCollectTimes(String shopId, String categorySerialNo, String dateType, String userType, String channel, String source, Date dateTime);

    /**
     * 查询品类收藏人群
    * @param shopId  实体店id或商家id
     * @param categorySerialNo 品类序列号
     * @param dateType  时间类型
     * @param userType 用户类型
     * @param channel  渠道
     * @param source  来源
     * @param dateTime 时间
     * @return
     */
    public abstract List<String> categoryCollectPoeple(String shopId, String categorySerialNo, String dateType, String userType, String channel, String source, Date dateTime);

    /**
     * 查询品牌收藏次数
     * 
     * @param shopId实体店id或商家id
     * @param brandId品牌id
     * @param dateType 时间类型
     * @param userType用户类型
     * @param channel渠道
     * @param source来源
     * @param dateTime 时间
     * @return
     */
    public abstract int brandCollectTimes(String shopId, String categorySerialNo, String dateType, String userType, String channel, String source, Date dateTime);

    /**
     * 查询品类收藏人群
    * @param shopId实体店id或商家id
     * @param brandId品牌id
     * @param dateType 时间类型
     * @param userType用户类型
     * @param channel渠道
     * @param source来源
     * @param dateTime 时间
     * @return
     */
    public abstract List<String> brandCollectPoeple(String shopId, String brandId, String dateType, String userType, String channel, String source, Date dateTime);

}
