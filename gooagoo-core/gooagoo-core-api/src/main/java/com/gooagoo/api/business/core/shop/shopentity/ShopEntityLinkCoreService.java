package com.gooagoo.api.business.core.shop.shopentity;

import com.gooagoo.entity.generator.shop.ShopEntityLink;

public interface ShopEntityLinkCoreService
{
    /**
     * 修改实体店联系方式
     * @param shopEntityLink
     * @return true/false
     * @throws Exception
     */
    public boolean updateShopEntityLink(ShopEntityLink shopEntityLink) throws Exception;

}
