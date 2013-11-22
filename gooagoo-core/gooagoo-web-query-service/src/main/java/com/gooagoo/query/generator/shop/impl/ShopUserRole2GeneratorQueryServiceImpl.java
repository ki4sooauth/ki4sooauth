package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopUserRole2GeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopUserRole2;
import com.gooagoo.entity.generator.shop.ShopUserRole2Example;
import com.gooagoo.entity.generator.shop.ShopUserRole2Key;
import com.gooagoo.dao.generator.shop.ShopUserRole2Mapper;

@Service
public class ShopUserRole2GeneratorQueryServiceImpl implements ShopUserRole2GeneratorQueryService
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

}
