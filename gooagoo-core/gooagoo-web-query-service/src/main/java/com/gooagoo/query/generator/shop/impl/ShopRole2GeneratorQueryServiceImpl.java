package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopRole2GeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopRole2;
import com.gooagoo.entity.generator.shop.ShopRole2Example;
import com.gooagoo.entity.generator.shop.ShopRole2Key;
import com.gooagoo.dao.generator.shop.ShopRole2Mapper;

@Service
public class ShopRole2GeneratorQueryServiceImpl implements ShopRole2GeneratorQueryService
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

}
