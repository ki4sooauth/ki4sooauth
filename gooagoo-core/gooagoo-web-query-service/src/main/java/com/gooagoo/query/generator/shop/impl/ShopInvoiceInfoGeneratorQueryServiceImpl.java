package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopInvoiceInfoGeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopInvoiceInfo;
import com.gooagoo.entity.generator.shop.ShopInvoiceInfoExample;
import com.gooagoo.entity.generator.shop.ShopInvoiceInfoKey;
import com.gooagoo.dao.generator.shop.ShopInvoiceInfoMapper;

@Service
public class ShopInvoiceInfoGeneratorQueryServiceImpl implements ShopInvoiceInfoGeneratorQueryService
{

    @Autowired
    private ShopInvoiceInfoMapper shopInvoiceInfoMapper;

    @Override
    public Integer countByExample(ShopInvoiceInfoExample shopInvoiceInfoExample) 
    {
        return this.shopInvoiceInfoMapper.countByExample(shopInvoiceInfoExample);
    }

    @Override
    public List<ShopInvoiceInfo> selectByExample(ShopInvoiceInfoExample shopInvoiceInfoExample) 
    {
        return this.shopInvoiceInfoMapper.selectByExample(shopInvoiceInfoExample);
    }

    @Override
    public ShopInvoiceInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopInvoiceInfoKey shopInvoiceInfoKey = new ShopInvoiceInfoKey();
        shopInvoiceInfoKey.setIsDel("N");
        shopInvoiceInfoKey.setShopEntityId(primaryKey);
        return this.shopInvoiceInfoMapper.selectByPrimaryKey(shopInvoiceInfoKey);
    }

    @Override
    public ShopInvoiceInfo selectByPrimaryKey(String primaryKey) 
    {
        ShopInvoiceInfoKey shopInvoiceInfoKey = new ShopInvoiceInfoKey();
        shopInvoiceInfoKey.setShopEntityId(primaryKey);
        return this.shopInvoiceInfoMapper.selectByPrimaryKey(shopInvoiceInfoKey);
    }

}
