package com.gooagoo.api.business.core.statistics;

import java.util.Date;
import java.util.List;

public interface BrowseStatisticCoreService
{

    /**
     * 查询商家服务工具营销信息浏览次数
     * @param shopId
     * @param toolId
     * @param userType
     *@param dateType
     * @param dateTime
     * @return
     */
    public abstract int toolBrowsTimes(String shopId, String toolId, String userType, String dateType, Date dateTime);

    /**
     * 查询商家服务工具营销信息浏览人群
     * @param shopId
     * @param toolId
     * @param userType
     *@param dateType
     * @param dateTime
     * @return
     */
    public abstract List<String> toolsBrowsPeople(String shopId, String toolId, String userType, String dateType, Date dateTime);

    /**
     * 查询优惠凭证浏览次数
     * @param couponId 
     * @param userType
     * @param dateType
     * @param dateTime
     * @param channel
     * @param source
     * @return
     */
    public abstract int couponBrowsTimes(String couponId, String userType, String dateType, Date dateTime, String channel, String source);

    /**
     * 查询优惠凭证浏览人群
     * @param couponId 
     * @param userType
     * @param dateType
     * @param dateTime
     * @param channel
     * @param source
     * @return
     */
    public abstract List<String> couponBrowsPeople(String couponId, String userType, String dateType, Date dateTime, String channel, String source);

    /**
     * 查询活动浏览次数
     * @param activityId 
     * @param userType
     * @param dateType
     * @param dateTime
     * @param channel
     * @param source
     * @return
     */
    public abstract int activityBrowsTimes(String activityId, String userType, String dateType, Date dateTime, String channel, String source);

    /**
     * 查询活动浏览人群
    * @param activityId 
     * @param userType
     * @param dateType
     * @param dateTime
     * @param channel
     * @param source
     * @return
     */
    public abstract List<String> activityBrowsPoeple(String activityId, String userType, String dateType, Date dateTime, String channel, String source);

    /**
     * 查询商品浏览次数
     * @param shopId 商家id或实体店id
     * @param goodsSerialNo 商品序列号
     * @param dateType  时间类型
     * @param userType  用户类型
     * @param channel   渠道
     * @param dateTime 时间
     * @param source 来源
     * @return
     */
    public abstract int goodsBrowsTimes(String shopId, String goodsSerialNo, String dateType, String userType, String channel, Date dateTime, String source);

    /**
     * 查询商品浏览人群
     * @param shopId 商家id或实体店id
      * @param goodsSerialNo 商品序列号
      * @param dateType  时间类型
      * @param userType  用户类型
      * @param channel   渠道
      * @param dateTime 时间
      * @param source 来源
     * @return
     */
    public abstract List<String> goodsBrowsPoeple(String shopId, String goodsSerialNo, String dateType, String userType, String channel, Date dateTime, String source);

    /**
     * 查询品类浏览次数
     * @param shopId  实体店id或商家id
     * @param categorySerialNo 品类序列号
     * @param dateType 时间类型
     * @param userType 用户类型
     * @param channel 渠道
     * @param dateTime 时间
     * @param source 来源
     * @return
     */
    public abstract int categoryBrowsTimes(String shopId, String categorySerialNo, String dateType, String userType, String channel, Date dateTime, String source);

    /**
     * 查询品类浏览人群
    * @param shopId  实体店id或商家id
      * @param categorySerialNo 品类序列号
      * @param dateType 时间类型
      * @param userType 用户类型
      * @param channel 渠道
      * @param dateTime 时间
      *  @param source 来源
     * @return
     */
    public abstract List<String> categoryBrowsPoeple(String shopId, String categorySerialNo, String dateType, String userType, String channel, Date dateTime, String source);

    /**
     * 查询品牌浏览次数
     * @param shopId  实体店id或商家id
     * @param brandId 品牌id
     * @param dateType 时间类型
     * @param userType 用户类型
     * @param channel 渠道
     * @param dateTime 时间
     * @param source 来源
     * @return
     */
    public abstract int brandBrowsTimes(String shopId, String categorySerialNo, String dateType, String userType, String channel, Date dateTime, String source);

    /**
     * 查询品牌浏览人群
    * @param shopId  实体店id或商家id
      * @param brandId 品牌id
      * @param dateType 时间类型
      * @param userType 用户类型
      * @param channel 渠道
      * @param dateTime 时间
      * @param source 来源
      * @return
     */
    public abstract List<String> brandBrowsPoeple(String shopId, String brandId, String dateType, String userType, String channel, Date dateTime, String source);

    /**
     * 查询吆喝浏览次数
     * @param cryoutId
     * @param dateType
     * @param userType
     * @param source
     * @param dateTime
     * @return
     */
    public abstract int cryoutBrowsTimes(String cryoutId, String dateType, String userType, String source, Date dateTime);

    /**
     * 查询吆喝浏览人群
     * @param cryoutId
     * @param dateType
     * @param userType
     * @param source
     * @param dateTime
     * @return
     */
    public abstract List<String> cryoutBrowsPeople(String cryoutId, String dateType, String userType, String source, Date dateTime);

    /**
     * 查询通知浏览次数
     * @param noticeId
     * @param dateType
     * @param userType
     * @param source
     * @param dateTime
     * @return
     */
    public abstract int noticeBrowsTimes(String noticeId, String dateType, String userType, String source, Date dateTime);

    /**
     * 查询通知浏览人群
     * @param noticeId
     * @param dateType
     * @param userType
     * @param source
     * @param dateTime
     * @return
     */
    public abstract List<String> noticeBrowsPeople(String noticeId, String dateType, String userType, String source, Date dateTime);

    /**
     * 查询购好奇浏览次数
     * @param purchaseId 购好奇id
     * @param dateType 
     * @param userType
     * @param dateTime
     * @return
     */
    public abstract int purchaseAndcuriosityBrowsTimes(String purchaseId, String dateType, String userType, Date dateTime);

    /**
     * 查询购好奇浏览人群
     * @param noticeId
     * @param dateType
     * @param userType
     * @param source
     * @param dateTime
     * @return
     */
    public abstract List<String> purchaseAndcuriosityBrowsPeople(String purchaseId, String dateType, String userType, Date dateTime);
}
