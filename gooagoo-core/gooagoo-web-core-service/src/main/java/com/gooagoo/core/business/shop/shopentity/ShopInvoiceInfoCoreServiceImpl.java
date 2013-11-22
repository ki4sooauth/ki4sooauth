package com.gooagoo.core.business.shop.shopentity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.shop.shopentity.ShopInvoiceInfoCoreService;
import com.gooagoo.api.generator.core.shop.ShopInvoiceInfoGeneratorCoreService;
import com.gooagoo.entity.generator.shop.ShopInvoiceInfo;

@Service
public class ShopInvoiceInfoCoreServiceImpl implements ShopInvoiceInfoCoreService
{
    @Autowired
    private ShopInvoiceInfoGeneratorCoreService shopInvoiceInfoGeneratorCoreService;

    @Override
    public boolean upateShopInvoiceInfo(ShopInvoiceInfo shopInvoiceInfo) throws Exception
    {
        return this.shopInvoiceInfoGeneratorCoreService.updateByPrimaryKeySelective(shopInvoiceInfo);
    }

}
