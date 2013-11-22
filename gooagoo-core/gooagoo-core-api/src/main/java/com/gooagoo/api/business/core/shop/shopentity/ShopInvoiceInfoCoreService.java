package com.gooagoo.api.business.core.shop.shopentity;

import com.gooagoo.entity.generator.shop.ShopInvoiceInfo;

public interface ShopInvoiceInfoCoreService
{

    /**
     * 修改发票信息
     * @param shopInvoiceInfo
     * @return true/false
     * @throws Exception
     */
    public boolean upateShopInvoiceInfo(ShopInvoiceInfo shopInvoiceInfo) throws Exception;

}
