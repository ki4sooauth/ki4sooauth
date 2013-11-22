package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopInvoiceInfo;
import com.gooagoo.entity.generator.shop.ShopInvoiceInfoExample;
import com.gooagoo.entity.generator.shop.ShopInvoiceInfoKey;

public interface ShopInvoiceInfoMapper
{

    public Integer countByExample(ShopInvoiceInfoExample shopInvoiceInfoExample);

    public List<ShopInvoiceInfo> selectByExample(ShopInvoiceInfoExample shopInvoiceInfoExample);

    public ShopInvoiceInfo selectByPrimaryKey(ShopInvoiceInfoKey shopInvoiceInfoKey);

}
