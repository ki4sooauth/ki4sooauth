package com.gooagoo.api.business.core.shop.shopentity;

import com.gooagoo.entity.generator.shop.ShopGpsInfo;

public interface ShopGpsInfoCoreService
{

    /**
     * 修改gps信息
     * @param shopGpsInfo
     * @return true/false
     * @throws Exception
     */
    public boolean updateShopGpsInfo(ShopGpsInfo shopGpsInfo) throws Exception;

}
