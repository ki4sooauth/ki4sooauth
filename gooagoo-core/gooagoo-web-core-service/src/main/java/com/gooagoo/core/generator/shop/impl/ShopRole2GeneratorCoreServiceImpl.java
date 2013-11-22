package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.ShopRole2GeneratorCoreService;
import com.gooagoo.entity.generator.shop.ShopRole2;
import com.gooagoo.entity.generator.shop.ShopRole2Example;
import com.gooagoo.entity.generator.shop.ShopRole2Key;
import com.gooagoo.dao.generator.shop.ShopRole2Mapper;

@Service
public class ShopRole2GeneratorCoreServiceImpl implements ShopRole2GeneratorCoreService
{

    @Autowired
    private ShopRole2Mapper shopRole2Mapper;

    @Override
    public Integer countByExample(ShopRole2Example shopRole2Example) 
    {
        return this.shopRole2Mapper.countByExample(shopRole2Example);
    }

    @Override
    public List<ShopRole2> selectByExample(ShopRole2Example shopRole2Example) 
    {
        return this.shopRole2Mapper.selectByExample(shopRole2Example);
    }

    @Override
    public ShopRole2 selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopRole2Key shopRole2Key = new ShopRole2Key();
        shopRole2Key.setIsDel("N");
        shopRole2Key.setRoleId(primaryKey);
        return this.shopRole2Mapper.selectByPrimaryKey(shopRole2Key);
    }

    @Override
    public ShopRole2 selectByPrimaryKey(String primaryKey) 
    {
        ShopRole2Key shopRole2Key = new ShopRole2Key();
        shopRole2Key.setRoleId(primaryKey);
        return this.shopRole2Mapper.selectByPrimaryKey(shopRole2Key);
    }

    @Override
    public boolean physicalDeleteByExample(ShopRole2Example shopRole2Example) 
    {
        return this.shopRole2Mapper.deleteByExample(shopRole2Example) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopRole2Key shopRole2Key = new ShopRole2Key();
        shopRole2Key.setRoleId(primaryKey);
        return this.shopRole2Mapper.deleteByPrimaryKey(shopRole2Key) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopRole2Example shopRole2Example) 
    {
        ShopRole2 shopRole2 = new ShopRole2();
        shopRole2.setIsDel("Y");
        return this.shopRole2Mapper.updateByExampleSelective(shopRole2,shopRole2Example) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopRole2 shopRole2 = new ShopRole2();
        shopRole2.setRoleId(primaryKey);
        shopRole2.setIsDel("Y");
        return this.shopRole2Mapper.updateByPrimaryKeySelective(shopRole2) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopRole2 shopRole2) 
    {
        return this.shopRole2Mapper.insertSelective(shopRole2) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopRole2 shopRole2,ShopRole2Example shopRole2Example) 
    {
        return this.shopRole2Mapper.updateByExampleSelective(shopRole2,shopRole2Example) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopRole2 shopRole2) 
    {
        return this.shopRole2Mapper.updateByPrimaryKeySelective(shopRole2) > 0 ? true : false;
    }

}
