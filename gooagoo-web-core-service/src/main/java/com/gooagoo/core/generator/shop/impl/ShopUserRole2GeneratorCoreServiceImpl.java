package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.ShopUserRole2GeneratorCoreService;
import com.gooagoo.entity.generator.shop.ShopUserRole2;
import com.gooagoo.entity.generator.shop.ShopUserRole2Example;
import com.gooagoo.entity.generator.shop.ShopUserRole2Key;
import com.gooagoo.dao.generator.shop.ShopUserRole2Mapper;

@Service
public class ShopUserRole2GeneratorCoreServiceImpl implements ShopUserRole2GeneratorCoreService
{

    @Autowired
    private ShopUserRole2Mapper shopUserRole2Mapper;

    @Override
    public Integer countByExample(ShopUserRole2Example shopUserRole2Example) 
    {
        return this.shopUserRole2Mapper.countByExample(shopUserRole2Example);
    }

    @Override
    public List<ShopUserRole2> selectByExample(ShopUserRole2Example shopUserRole2Example) 
    {
        return this.shopUserRole2Mapper.selectByExample(shopUserRole2Example);
    }

    @Override
    public ShopUserRole2 selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopUserRole2Key shopUserRole2Key = new ShopUserRole2Key();
        shopUserRole2Key.setIsDel("N");
        shopUserRole2Key.setShopId(primaryKey);
        return this.shopUserRole2Mapper.selectByPrimaryKey(shopUserRole2Key);
    }

    @Override
    public ShopUserRole2 selectByPrimaryKey(String primaryKey) 
    {
        ShopUserRole2Key shopUserRole2Key = new ShopUserRole2Key();
        shopUserRole2Key.setShopId(primaryKey);
        return this.shopUserRole2Mapper.selectByPrimaryKey(shopUserRole2Key);
    }

    @Override
    public boolean physicalDeleteByExample(ShopUserRole2Example shopUserRole2Example) 
    {
        return this.shopUserRole2Mapper.deleteByExample(shopUserRole2Example) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopUserRole2Key shopUserRole2Key = new ShopUserRole2Key();
        shopUserRole2Key.setShopId(primaryKey);
        return this.shopUserRole2Mapper.deleteByPrimaryKey(shopUserRole2Key) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopUserRole2Example shopUserRole2Example) 
    {
        ShopUserRole2 shopUserRole2 = new ShopUserRole2();
        shopUserRole2.setIsDel("Y");
        return this.shopUserRole2Mapper.updateByExampleSelective(shopUserRole2,shopUserRole2Example) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopUserRole2 shopUserRole2 = new ShopUserRole2();
        shopUserRole2.setShopId(primaryKey);
        shopUserRole2.setIsDel("Y");
        return this.shopUserRole2Mapper.updateByPrimaryKeySelective(shopUserRole2) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopUserRole2 shopUserRole2) 
    {
        return this.shopUserRole2Mapper.insertSelective(shopUserRole2) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopUserRole2 shopUserRole2,ShopUserRole2Example shopUserRole2Example) 
    {
        return this.shopUserRole2Mapper.updateByExampleSelective(shopUserRole2,shopUserRole2Example) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopUserRole2 shopUserRole2) 
    {
        return this.shopUserRole2Mapper.updateByPrimaryKeySelective(shopUserRole2) > 0 ? true : false;
    }

}
