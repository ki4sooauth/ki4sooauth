package com.gooagoo.core.business.shop.shopentity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.shop.shopentity.ShopGpsInfoCoreService;
import com.gooagoo.api.generator.core.shop.ShopGpsInfoGeneratorCoreService;
import com.gooagoo.entity.generator.shop.ShopGpsInfo;

@Service
public class ShopGpsInfoCoreServiceImpl implements ShopGpsInfoCoreService
{
    @Autowired
    private ShopGpsInfoGeneratorCoreService shopGpsInfoGeneratorCoreService;

    @Override
    public boolean updateShopGpsInfo(ShopGpsInfo shopGpsInfo) throws Exception
    {
        return this.shopGpsInfoGeneratorCoreService.updateByPrimaryKeySelective(shopGpsInfo);
    }

}
