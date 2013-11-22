package com.gooagoo.api.business.core.statistics;

import java.util.Date;
import java.util.List;

public interface InteractiveCoreService
{
    /**
     * 查询手机互动人数
     * @param shopId 商家id
     * @param dateType 时间类型
     * @param userType 用户类型
     * @param dateTime 时间
     * @return   返回实体店人数信息
     */
    public abstract int findPhoneInterPeopleNum(String shopId, String dateType, String userType, Date dateTime);

    /**
     * 查询手机互动次数
     * @param shopId 商家id
     * @param dateType 时间类型
     * @param userType 用户类型
     * @param dateTime 时间
     * @return   返回实体店人数信息
     */
    public abstract int findPhoneInterTimes(String shopId, String dateType, String userType, Date dateTime);

    /**
     * 查询手机互动人群
     * @param shopId 商家id
     * @param dateType 时间类型
     * @param userType 用户类型
     * @param dateTime 时间
     * @return   返回实体店人数信息
     */
    public abstract List<String> findPhoneInterPeople(String shopId, String dateType, String userType, Date dateTime);

    /**
     * 查询网站互动人数
     * @param shopId 商家id
     * @param dateType 时间类型
     * @param userType 用户类型
     * @param dateTime 时间
     * @return   返回实体店人数信息
     */
    public abstract int findWebInterPeopleNum(String shopId, String dateType, String userType, Date dateTime);

    /**
     * 查询网站互动次数
     * @param shopId 商家id
     * @param dateType 时间类型
     * @param userType 用户类型
     * @param dateTime 时间
     * @return   返回实体店人数信息
     */
    public abstract int findWebInterTimes(String shopId, String dateType, String userType, Date dateTime);

    /**
     * 查询网站互动人群
     * @param shopId 商家id
     * @param dateType 时间类型
     * @param userType 用户类型
     * @param dateTime 时间
     * @return   返回实体店人数信息
     */
    public abstract List<String> findWebInterPeople(String shopId, String dateType, String userType, Date dateTime);
}
