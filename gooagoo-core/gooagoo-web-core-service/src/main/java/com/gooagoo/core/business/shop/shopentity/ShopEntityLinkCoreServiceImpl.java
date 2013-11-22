package com.gooagoo.core.business.shop.shopentity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.shop.shopentity.ShopEntityLinkCoreService;
import com.gooagoo.api.generator.core.shop.ShopEntityLinkGeneratorCoreService;
import com.gooagoo.entity.generator.shop.ShopEntityLink;

@Service
public class ShopEntityLinkCoreServiceImpl implements ShopEntityLinkCoreService
{
    @Autowired
    private ShopEntityLinkGeneratorCoreService shopEntityLinkGeneratorCoreService;

    @Override
    public boolean updateShopEntityLink(ShopEntityLink shopEntityLink) throws Exception
    {
        return this.shopEntityLinkGeneratorCoreService.updateByPrimaryKeySelective(shopEntityLink);
    }

}
