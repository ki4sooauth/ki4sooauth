package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopUserRoleGeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopUserRole;
import com.gooagoo.entity.generator.shop.ShopUserRoleExample;
import com.gooagoo.entity.generator.shop.ShopUserRoleKey;
import com.gooagoo.dao.generator.shop.ShopUserRoleMapper;

@Service
public class ShopUserRoleGeneratorQueryServiceImpl implements ShopUserRoleGeneratorQueryService
{

    @Autowired
    private ShopUserRoleMapper shopUserRoleMapper;

    @Override
    public Integer countByExample(ShopUserRoleExample shopUserRoleExample) 
    {
        return this.shopUserRoleMapper.countByExample(shopUserRoleExample);
    }

    @Override
    public List<ShopUserRole> selectByExample(ShopUserRoleExample shopUserRoleExample) 
    {
        return this.shopUserRoleMapper.selectByExample(shopUserRoleExample);
    }

    @Override
    public ShopUserRole selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopUserRoleKey shopUserRoleKey = new ShopUserRoleKey();
        shopUserRoleKey.setIsDel("N");
        shopUserRoleKey.setSysUserRoleId(primaryKey);
        return this.shopUserRoleMapper.selectByPrimaryKey(shopUserRoleKey);
    }

    @Override
    public ShopUserRole selectByPrimaryKey(String primaryKey) 
    {
        ShopUserRoleKey shopUserRoleKey = new ShopUserRoleKey();
        shopUserRoleKey.setSysUserRoleId(primaryKey);
        return this.shopUserRoleMapper.selectByPrimaryKey(shopUserRoleKey);
    }

}
