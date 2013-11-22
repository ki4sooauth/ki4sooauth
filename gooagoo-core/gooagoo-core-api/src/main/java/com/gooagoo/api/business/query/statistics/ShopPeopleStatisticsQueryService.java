package com.gooagoo.api.business.query.statistics;

import java.util.Date;
import java.util.List;

public interface ShopPeopleStatisticsQueryService
{
    /**
     * 查询商家所有实体店店内人数(当前时刻)
     *  @param shopId  商家id
     * @param dateType 统计时间类型
     * @param userType 用户类型
     * @param dateTime  时间
     * @return  返回所有人数
     */
    public abstract int findAllEntityPeopleNum(String shopId, String userType);

    /**
     * 查询商家所有实体店店内人群(当前时刻)
     * @param shopId 商家id
     * @param dateType 统计时间类型
     * @param userType  用户类型
     * @param dateTime   时间
     * @return   返回用户id/mac信息
     */
    public abstract List<String> findAllEntityPeople(String shopId, String userType);

    /**
     * 查询到达商家人数
     * @param shopId 商家id
     * @param dateType 统计时间类型
     * @param userType  用户类型
     * @param dateTime   时间
     * @return   返回用户id/mac信息
     */
    public abstract int findArriveShopPeopleNum(String shopId, String dateType, String userType, Date dateTime);

    /**
     * 查询到达商家次数
     * @param shopId 商家id
     * @param dateType 统计时间类型
     * @param userType  用户类型
     * @param dateTime   时间
     * @return   返回用户id/mac信息
     */
    public abstract int findArriveShopTimes(String shopId, String dateType, String userType, Date dateTime);

    /**
     * 查询到达商家人群
     * @param shopId 商家id
     * @param dateType 统计时间类型
     * @param userType  用户类型
     * @param dateTime   时间
     * @return   返回用户id/mac信息
     */
    public abstract List<String> findArriveShopPeople(String shopId, String dateType, String userType, Date dateTime);

    /***
     * 查询商家新增用户人数
     * @param shopId 商家id
     * @param userType 用户类型
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 返回指定时间段内商家的新增用户
     */
    public abstract int findShopAddPeopleNum(String shopId, String userType, Date startTime, Date endTime);

    /***
     * 查询商家新增用户人群
     * @param shopId 商家id
     * @param userType 用户类型
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 返回指定时间段内商家的新增用户
     */
    public abstract List<String> findShopAddPeople(String shopId, String userType, Date startTime, Date endTime);

    /**
     * 查询商家用户人数
     * @param shopId 商家id
     * @param dateType 统计时间类型
     * @param userType  用户类型
     * @param dateTime   时间
     * @return   返回用户id/mac信息
     */
    public abstract int findShopUserNum(String shopId, String userType, Date dateTime);

    /**
     * 查询商家用户人群
     * @param shopId 商家id
     * @param dateType 统计时间类型
     * @param userType  用户类型
     * @param dateTime   时间
     * @return   返回用户id/mac信息
     */
    public abstract List<String> findShopPeople(String shopId, String userType, Date dateTime);

}
