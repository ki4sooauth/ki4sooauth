package com.gooagoo.api.business.query.user.favorite.calendar;

import java.util.List;

import com.gooagoo.entity.business.user.favorite.calendar.ConsumelistBusiness;

public interface CalendarQueryService
{
    /**
     * mobk01:按日期查询用户消费记录 
     * @param userId 用户编号
     * @param date 查询日期时间,格式：yyyy-mm-dd
     * @return 消费记录信息(当日订单、账单、活动、购物清单 数目)
     * @throws Exception
     */
    public ConsumelistBusiness findCalendarByDate(String userId, String date) throws Exception;

    /**
     * mobk02:按月份查询用户消费信息记录 
     * @param userId 用户编号
     * @param date 查询日期时间,格式：yyyy-mm
     * @return 有订单，账单，购物清单三者之一的日期（格式:dd）
     * @throws Exception
     */
    public List<String> findCalendarByMonth(String userId, String date) throws Exception;

}
