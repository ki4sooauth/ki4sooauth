package com.gooagoo.api.business.core.shop.shopentity;

import com.gooagoo.entity.generator.shop.ShopEntityInfo;

/**
 * 
实体店管理 
 *
 */
public interface ShopentityCoreService
{

    /**
     *  新增实体店(同时添加一条发票、gps、联系方式信息)
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean addShopEntityInfo(ShopEntityInfo shopEntityInfo) throws Exception;

    /**
     * 编辑实体店
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean updateShopEntityInfo(ShopEntityInfo shopEntityInfo) throws Exception;

    /**
     *     删除实体店
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean deleteShopEntityInfo(String shopEntityId) throws Exception;

}
