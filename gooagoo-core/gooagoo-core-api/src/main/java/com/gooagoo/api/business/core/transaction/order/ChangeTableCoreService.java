package com.gooagoo.api.business.core.transaction.order;

import com.gooagoo.exception.business.shop.TableStateNotFreeException;

public interface ChangeTableCoreService
{

    /**
     * 餐桌换台管理
     * @param shopEntityId 实体店编号
     * @param tableNameFrom 换台桌号
     * @param tableNameTo 换到桌号
     * @return
     * @throws TableStateNotFreeException
     */
    public boolean exchangeTable(String shopEntityId, String tableNameFrom, String tableNameTo) throws Exception;

    /**
     * 餐桌并台管理
     * @param shopEntityId 实体店编号
     * @param tableNameFrom 并台桌号
     * @param tableNameTo 并到桌号
     * @return
     * @throws Exception
     */
    public boolean mergeTable(String shopEntityId, String tableNameFrom, String tableNameTo) throws Exception;

}
