package com.gooagoo.api.business.core.shop.queue;

import com.gooagoo.exception.GooagooException;

/**
 * 餐桌管理
 */
public interface ShopQueueCoreService

{
    /**
     * 现场销号
     * @param shopEntityId 实体店编号
     * @param queueNo 排队号
     * @return true/false
     * @throws GooagooException
     */
    public boolean deleteQueueNo(String shopEntityId, String queueNo) throws Exception;
}
