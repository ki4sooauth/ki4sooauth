package com.gooagoo.api.business.core.shop.table;

import com.gooagoo.entity.generator.shop.ShopTableTypeManage;

public interface TableTypeCoreService
{
    /**
     * 添加餐桌类型
     * @param shopTableTypeManage
     * @return true/false
     * @throws Exception
     */
    public boolean addShopTableTypeManage(ShopTableTypeManage shopTableTypeManage) throws Exception;

    /**
     * 修改餐桌类型
     * @param shopTableTypeManage
     * @return true/false
     * @throws Exception
     */
    public boolean updateShopTableTypeManage(ShopTableTypeManage shopTableTypeManage) throws Exception;

    /**
     * 删除餐桌类型
     * @param Id
     * @return true/false
     * @throws Exception
     */
    public boolean deleteShopTableTypeManage(String Id) throws Exception;

}
