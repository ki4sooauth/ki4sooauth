package com.gooagoo.api.business.core.shop.table;

import com.gooagoo.entity.generator.shop.ShopTableInfo;

/***
 *  餐厅桌号信息管理 
 * @author Administrator
 *
 */

public interface TableCoreService
{

    /**
     * 新增餐厅桌号信息
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean addTable(ShopTableInfo shopTableInfo) throws Exception;

    /**
     * 编辑餐厅桌号信息
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean updateTable(ShopTableInfo shopTableInfo) throws Exception;

    /**
     *   删除餐厅桌号信
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean deleteTable(String parameter) throws Exception;

}
