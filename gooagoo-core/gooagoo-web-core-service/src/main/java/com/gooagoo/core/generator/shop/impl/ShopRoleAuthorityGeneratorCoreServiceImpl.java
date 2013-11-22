package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.ShopRoleAuthorityGeneratorCoreService;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority;
import com.gooagoo.entity.generator.shop.ShopRoleAuthorityExample;
import com.gooagoo.entity.generator.shop.ShopRoleAuthorityKey;
import com.gooagoo.dao.generator.shop.ShopRoleAuthorityMapper;

@Service
public class ShopRoleAuthorityGeneratorCoreServiceImpl implements ShopRoleAuthorityGeneratorCoreService
{

    @Autowired
    private ShopRoleAuthorityMapper shopRoleAuthorityMapper;

    @Override
    public Integer countByExample(ShopRoleAuthorityExample shopRoleAuthorityExample) 
    {
        return this.shopRoleAuthorityMapper.countByExample(shopRoleAuthorityExample);
    }

    @Override
    public List<ShopRoleAuthority> selectByExample(ShopRoleAuthorityExample shopRoleAuthorityExample) 
    {
        return this.shopRoleAuthorityMapper.selectByExample(shopRoleAuthorityExample);
    }

    @Override
    public ShopRoleAuthority selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopRoleAuthorityKey shopRoleAuthorityKey = new ShopRoleAuthorityKey();
        shopRoleAuthorityKey.setIsDel("N");
        shopRoleAuthorityKey.setSysRoleAuthorityId(primaryKey);
        return this.shopRoleAuthorityMapper.selectByPrimaryKey(shopRoleAuthorityKey);
    }

    @Override
    public ShopRoleAuthority selectByPrimaryKey(String primaryKey) 
    {
        ShopRoleAuthorityKey shopRoleAuthorityKey = new ShopRoleAuthorityKey();
        shopRoleAuthorityKey.setSysRoleAuthorityId(primaryKey);
        return this.shopRoleAuthorityMapper.selectByPrimaryKey(shopRoleAuthorityKey);
    }

    @Override
    public boolean physicalDeleteByExample(ShopRoleAuthorityExample shopRoleAuthorityExample) 
    {
        return this.shopRoleAuthorityMapper.deleteByExample(shopRoleAuthorityExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopRoleAuthorityKey shopRoleAuthorityKey = new ShopRoleAuthorityKey();
        shopRoleAuthorityKey.setSysRoleAuthorityId(primaryKey);
        return this.shopRoleAuthorityMapper.deleteByPrimaryKey(shopRoleAuthorityKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopRoleAuthorityExample shopRoleAuthorityExample) 
    {
        ShopRoleAuthority shopRoleAuthority = new ShopRoleAuthority();
        shopRoleAuthority.setIsDel("Y");
        return this.shopRoleAuthorityMapper.updateByExampleSelective(shopRoleAuthority,shopRoleAuthorityExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopRoleAuthority shopRoleAuthority = new ShopRoleAuthority();
        shopRoleAuthority.setSysRoleAuthorityId(primaryKey);
        shopRoleAuthority.setIsDel("Y");
        return this.shopRoleAuthorityMapper.updateByPrimaryKeySelective(shopRoleAuthority) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopRoleAuthority shopRoleAuthority) 
    {
        return this.shopRoleAuthorityMapper.insertSelective(shopRoleAuthority) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopRoleAuthority shopRoleAuthority,ShopRoleAuthorityExample shopRoleAuthorityExample) 
    {
        return this.shopRoleAuthorityMapper.updateByExampleSelective(shopRoleAuthority,shopRoleAuthorityExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopRoleAuthority shopRoleAuthority) 
    {
        return this.shopRoleAuthorityMapper.updateByPrimaryKeySelective(shopRoleAuthority) > 0 ? true : false;
    }

}
