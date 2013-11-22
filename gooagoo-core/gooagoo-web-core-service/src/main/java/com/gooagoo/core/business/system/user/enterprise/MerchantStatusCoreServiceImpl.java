package com.gooagoo.core.business.system.user.enterprise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.system.user.enterprise.MerchantStatusCoreService;
import com.gooagoo.api.generator.core.shop.ShopInfoGeneratorCoreService;
import com.gooagoo.entity.generator.shop.ShopInfo;

@Service
public class MerchantStatusCoreServiceImpl implements MerchantStatusCoreService

{

    @Autowired
    private ShopInfoGeneratorCoreService shopInfoGeneratorCoreService;

    @Override
    public boolean updateMerchantStatus(String shopId, String shopStatus, String note) throws Exception
    {
        ShopInfo shopInfo = new ShopInfo();
        shopInfo.setShopId(shopId);
        shopInfo.setShopStatus(shopStatus);
        shopInfo.setNote(note);
        return this.shopInfoGeneratorCoreService.updateByPrimaryKeySelective(shopInfo);
    }

}
