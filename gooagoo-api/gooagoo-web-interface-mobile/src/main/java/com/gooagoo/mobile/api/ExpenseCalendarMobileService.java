package com.gooagoo.mobile.api;

import com.gooagoo.mobile.entity.mobk01.transform.GetConsumeRecordByDateRoot;
import com.gooagoo.mobile.entity.mobk02.transform.GetConsumeRecordByMonthRoot;
import com.gooagoo.mobile.entity.mobk03.transform.BoughtGoodsRoot;

/**
 * 消费日历相关接口
 * 如果接口入参同时存在userId,sessionId,则需要先校验是否登录
 */
public interface ExpenseCalendarMobileService
{
    /**
     * mobk01:按日期查询用户消费记录 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param date 查询日期时间,格式：yyyy-mm-dd
     * @return
     * @throws Exception
     */
    public GetConsumeRecordByDateRoot getConsumeRecordByDate(String userId, String sessionId, String date) throws Exception;

    /**
     * mobk02:按月份查询用户消费信息记录 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param date 查询日期时间,格式：yyyy-mm
     * @return
     * @throws Exception
     */
    public GetConsumeRecordByMonthRoot getConsumeRecordByMonth(String userId, String sessionId, String date) throws Exception;

    /**
     * mobk03:已购买过的商品 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param shopType 商家类别，通过商铺类别查询时必填
     * @param shopEntityId 实体店编，通过卡查询时购过商品必填
     * @param pageIndex 页码
     * @param pageSize 每页信息显示条数
     * @return
     * @throws Exception
     */
    public BoughtGoodsRoot getBoughtGoodsInfo(String userId, String sessionId, String shopType, String shopEntityId, String pageIndex, String pageSize) throws Exception;
}
