package com.gooagoo.api.business.core.shop.table;

/***
 *  餐桌开台/清台管理
 * @author Administrator
 *
 */

public interface TableStatusCoreService
{

    /**
     * 餐桌开台管理
     * @param shopEntityId 实体店编号
     * @param tableName 桌号
     * @param peopleNums 就餐人数
     * @return
     * @throws Exception
     */
    public boolean openTable(String shopEntityId, String tableName, String peopleNums) throws Exception;

    /**
     * 餐桌清台管理
     * @param shopEntityId 实体店编号
     * @param tableName 桌号
     * @return
     * @throws Exception
     */
    public boolean clearTable(String shopEntityId, String tableName) throws Exception;

}
