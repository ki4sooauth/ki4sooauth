package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.ShopInvoiceInfoGeneratorCoreService;
import com.gooagoo.entity.generator.shop.ShopInvoiceInfo;
import com.gooagoo.entity.generator.shop.ShopInvoiceInfoExample;
import com.gooagoo.entity.generator.shop.ShopInvoiceInfoKey;
import com.gooagoo.dao.generator.shop.ShopInvoiceInfoMapper;

@Service
public class ShopInvoiceInfoGeneratorCoreServiceImpl implements ShopInvoiceInfoGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(ShopInvoiceInfoExample shopInvoiceInfoExample) 
    {
        return this.shopInvoiceInfoMapper.deleteByExample(shopInvoiceInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopInvoiceInfoKey shopInvoiceInfoKey = new ShopInvoiceInfoKey();
        shopInvoiceInfoKey.setShopEntityId(primaryKey);
        return this.shopInvoiceInfoMapper.deleteByPrimaryKey(shopInvoiceInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopInvoiceInfoExample shopInvoiceInfoExample) 
    {
        ShopInvoiceInfo shopInvoiceInfo = new ShopInvoiceInfo();
        shopInvoiceInfo.setIsDel("Y");
        return this.shopInvoiceInfoMapper.updateByExampleSelective(shopInvoiceInfo,shopInvoiceInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopInvoiceInfo shopInvoiceInfo = new ShopInvoiceInfo();
        shopInvoiceInfo.setShopEntityId(primaryKey);
        shopInvoiceInfo.setIsDel("Y");
        return this.shopInvoiceInfoMapper.updateByPrimaryKeySelective(shopInvoiceInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopInvoiceInfo shopInvoiceInfo) 
    {
        return this.shopInvoiceInfoMapper.insertSelective(shopInvoiceInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopInvoiceInfo shopInvoiceInfo,ShopInvoiceInfoExample shopInvoiceInfoExample) 
    {
        return this.shopInvoiceInfoMapper.updateByExampleSelective(shopInvoiceInfo,shopInvoiceInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopInvoiceInfo shopInvoiceInfo) 
    {
        return this.shopInvoiceInfoMapper.updateByPrimaryKeySelective(shopInvoiceInfo) > 0 ? true : false;
    }

}
