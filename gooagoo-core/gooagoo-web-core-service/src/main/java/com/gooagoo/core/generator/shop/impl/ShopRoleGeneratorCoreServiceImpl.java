package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.ShopRoleGeneratorCoreService;
import com.gooagoo.entity.generator.shop.ShopRole;
import com.gooagoo.entity.generator.shop.ShopRoleExample;
import com.gooagoo.entity.generator.shop.ShopRoleKey;
import com.gooagoo.dao.generator.shop.ShopRoleMapper;

@Service
public class ShopRoleGeneratorCoreServiceImpl implements ShopRoleGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(ShopRoleExample shopRoleExample) 
    {
        return this.shopRoleMapper.deleteByExample(shopRoleExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopRoleKey shopRoleKey = new ShopRoleKey();
        shopRoleKey.setRoleId(primaryKey);
        return this.shopRoleMapper.deleteByPrimaryKey(shopRoleKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopRoleExample shopRoleExample) 
    {
        ShopRole shopRole = new ShopRole();
        shopRole.setIsDel("Y");
        return this.shopRoleMapper.updateByExampleSelective(shopRole,shopRoleExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopRole shopRole = new ShopRole();
        shopRole.setRoleId(primaryKey);
        shopRole.setIsDel("Y");
        return this.shopRoleMapper.updateByPrimaryKeySelective(shopRole) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopRole shopRole) 
    {
        return this.shopRoleMapper.insertSelective(shopRole) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopRole shopRole,ShopRoleExample shopRoleExample) 
    {
        return this.shopRoleMapper.updateByExampleSelective(shopRole,shopRoleExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopRole shopRole) 
    {
        return this.shopRoleMapper.updateByPrimaryKeySelective(shopRole) > 0 ? true : false;
    }

}
