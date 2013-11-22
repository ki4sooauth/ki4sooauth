package com.gooagoo.api.business.core.statistics;

import java.util.Date;
import java.util.List;

public interface ConsumeStatisticCoreService
{

    /**
     * 查询消费次数
     * @param shopId 商家id/实体店id
     * @param dateType 时间类型
     * @param userType 时间
     * @param dateTime 用户类型
     * @return
     */
    public abstract int consumeTimes(String shopId, String dateType, String userType, Date dateTime);

    /**
     * 查询消费人群
     * @param shopId 商家id/实体店id
     * @param dateType 时间类型
     * @param userType 时间
     * @param dateTime 用户类型
     * @return
     */
    public abstract List<String> consumePeople(String shopId, String dateType, String userType, Date dateTime);

    /**
     * 查询消费金额
     * @param shopId 商家id/实体店id
     * @param dateType 时间类型
     * @param userType 时间
     * @param dateTime 用户类型
     * @return
     */
    public abstract double consumeAmount(String shopId, String dateType, String userType, Date dateTime);

    /**
     * 查询消费金额人群
     * @param shopId 商家id/实体店id
     * @param dateType 时间类型
     * @param userType 时间
     * @param dateTime 用户类型
     * @return
     */
    public abstract List<String> consumeAmountPeople(String shopId, String dateType, String userType, Date dateTime);
}
