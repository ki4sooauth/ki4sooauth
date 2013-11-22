package com.gooagoo.api.business.query.user.queue;

import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.business.log.ShopLog;

/**
 * 排号
 */
public interface QueueQueryService
{

    /**
     * 刷新排号状态
     * @throws Exception
     */
    public void RefreshQueueNo() throws Exception;

    /**
     * 获取排号记录
     * @throws Exception
     */
    public void findQueueRecord() throws Exception;

    /**
     * 销号提醒（店员助理接口 gasj05）
     * @param shopLog 商家日志
     * @return String 手机推送消息
     * @throws Exception
     */
    public String removeQueueNo(ShopLog shopLog) throws Exception;

    /**
     * 排号提醒（店员助理接口 gasj02）
     * @param behaveLog 用户行为日志
     * @return String 手机推送消息
     * @throws Exception
     */
    public String getQueueNo(BehaveLog behaveLog) throws Exception;

}
