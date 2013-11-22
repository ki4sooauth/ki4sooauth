package com.gooagoo.api.business.query.statistics;

import java.util.Date;
import java.util.List;

public interface ShopEntityPeopleStatisticsQueryService
{

    /**
     * 查询指定实体店店内人数(当前时刻)
     * @param shopEntityId 实体店id
     * @param dateType 时间类型
     * @param userType 用户类型
     * @param dateTime 时间
     * @return   返回实体店人数信息
     */
    public abstract int findEntityPeopleNum(String shopEntityId, String userType);

    /**
     * 查询指定实体店店内 群(当前时刻)
     * @param shopEntityId 实体店id
     * @param dateType 时间类型
     * @param userType 用户类型
     * @param dateTime 时间
     * @return   
     */
    public abstract List<String> findEntityPeople(String shopEntityId, String userType);

    /**
     * 查询实体店指定区域内人数(当前时刻)
     * @param areaId 区域id
     * @param dateType 时间类型
     * @param userType 用户类型
     * @param dateTime 时间
     * @return   返回实体店人数信息
     */
    public abstract int findEntityAreaPeopleNum(String areaId, String userType);

    /**
     * 查询实体店指定区域内人群(当前时刻)
     * @param areaId 区域id
     * @param dateType 时间类型
     * @param userType 用户类型
     * @param dateTime 时间
     * @return   返回实体店人数信息
     */
    public abstract List<String> findEntityAreaPeople(String areaId, String userType);

    /**
     * 查询到达实体店人数
     * @param shopEntityId 区域id
     * @param dateType 时间类型
     * @param userType 用户类型
     * @param dateTime 时间
     * @return   返回实体店人数信息
     */
    public abstract int findArriveEntityPeopleNum(String shopEntityId, String dateType, String userType, Date dateTime);

    /**
     * 查询到达实体店次数
     * @param shopEntityId 区域id
     * @param dateType 时间类型
     * @param userType 用户类型
     * @param dateTime 时间
     * @return   返回实体店人数信息
     */
    public abstract int findArriveEntityTimes(String shopEntityId, String dateType, String userType, Date dateTime);

    /**
     * 查询到达实体店人群
     * @param shopEntityId 区域id
     * @param dateType 时间类型
     * @param userType 用户类型
     * @param dateTime 时间
     * @return   返回实体店人数信息
     */
    public abstract List<String> findArriveEntityPeople(String shopEntityId, String dateType, String userType, Date dateTime);

    /**
     * 查询到达指定区域人数
     * @param areaId 区域id
     * @param dateType 时间类型
     * @param userType 用户类型
     * @param dateTime 时间
     * @return   返回实体店人数信息
     */
    public abstract int findArriveEntityAreaPeopleNum(String areaId, String dateType, String userType, Date dateTime);

    /**
     * 查询到达指定区域次数
     * @param areaId 区域id
     * @param dateType 时间类型
     * @param userType 用户类型
     * @param dateTime 时间
     * @return   返回实体店人数信息
     */
    public abstract int findArriveEntityAreaTimes(String areaId, String dateType, String userType, Date dateTime);

    /**
     * 查询到达指定区域人群
     * @param areaId 区域id
     * @param dateType 时间类型
     * @param userType 用户类型
     * @param dateTime 时间
     * @return   
     */
    public abstract List<String> findArriveEntityAreaPeople(String areaId, String dateType, String userType, Date dateTime);
}
