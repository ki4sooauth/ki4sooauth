package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopRoleAuthorityGeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority;
import com.gooagoo.entity.generator.shop.ShopRoleAuthorityExample;
import com.gooagoo.entity.generator.shop.ShopRoleAuthorityKey;
import com.gooagoo.dao.generator.shop.ShopRoleAuthorityMapper;

@Service
public class ShopRoleAuthorityGeneratorQueryServiceImpl implements ShopRoleAuthorityGeneratorQueryService
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

}
