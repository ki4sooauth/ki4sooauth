package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.ShopUserRoleGeneratorCoreService;
import com.gooagoo.entity.generator.shop.ShopUserRole;
import com.gooagoo.entity.generator.shop.ShopUserRoleExample;
import com.gooagoo.entity.generator.shop.ShopUserRoleKey;
import com.gooagoo.dao.generator.shop.ShopUserRoleMapper;

@Service
public class ShopUserRoleGeneratorCoreServiceImpl implements ShopUserRoleGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(ShopUserRoleExample shopUserRoleExample) 
    {
        return this.shopUserRoleMapper.deleteByExample(shopUserRoleExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopUserRoleKey shopUserRoleKey = new ShopUserRoleKey();
        shopUserRoleKey.setSysUserRoleId(primaryKey);
        return this.shopUserRoleMapper.deleteByPrimaryKey(shopUserRoleKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopUserRoleExample shopUserRoleExample) 
    {
        ShopUserRole shopUserRole = new ShopUserRole();
        shopUserRole.setIsDel("Y");
        return this.shopUserRoleMapper.updateByExampleSelective(shopUserRole,shopUserRoleExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopUserRole shopUserRole = new ShopUserRole();
        shopUserRole.setSysUserRoleId(primaryKey);
        shopUserRole.setIsDel("Y");
        return this.shopUserRoleMapper.updateByPrimaryKeySelective(shopUserRole) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopUserRole shopUserRole) 
    {
        return this.shopUserRoleMapper.insertSelective(shopUserRole) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopUserRole shopUserRole,ShopUserRoleExample shopUserRoleExample) 
    {
        return this.shopUserRoleMapper.updateByExampleSelective(shopUserRole,shopUserRoleExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopUserRole shopUserRole) 
    {
        return this.shopUserRoleMapper.updateByPrimaryKeySelective(shopUserRole) > 0 ? true : false;
    }

}
