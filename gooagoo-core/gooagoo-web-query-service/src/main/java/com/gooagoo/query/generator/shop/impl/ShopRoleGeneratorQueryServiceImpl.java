package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopRoleGeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopRole;
import com.gooagoo.entity.generator.shop.ShopRoleExample;
import com.gooagoo.entity.generator.shop.ShopRoleKey;
import com.gooagoo.dao.generator.shop.ShopRoleMapper;

@Service
public class ShopRoleGeneratorQueryServiceImpl implements ShopRoleGeneratorQueryService
{

    @Autowired
    private ShopRoleMapper shopRoleMapper;

    @Override
    public Integer countByExample(ShopRoleExample shopRoleExample) 
    {
        return this.shopRoleMapper.countByExample(shopRoleExample);
    }

    @Override
    public List<ShopRole> selectByExample(ShopRoleExample shopRoleExample) 
    {
        return this.shopRoleMapper.selectByExample(shopRoleExample);
    }

    @Override
    public ShopRole selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopRoleKey shopRoleKey = new ShopRoleKey();
        shopRoleKey.setIsDel("N");
        shopRoleKey.setRoleId(primaryKey);
        return this.shopRoleMapper.selectByPrimaryKey(shopRoleKey);
    }

    @Override
    public ShopRole selectByPrimaryKey(String primaryKey) 
    {
        ShopRoleKey shopRoleKey = new ShopRoleKey();
        shopRoleKey.setRoleId(primaryKey);
        return this.shopRoleMapper.selectByPrimaryKey(shopRoleKey);
    }

}
