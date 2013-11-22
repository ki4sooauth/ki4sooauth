package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopRoleAuthority2GeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority2;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority2Example;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority2Key;
import com.gooagoo.dao.generator.shop.ShopRoleAuthority2Mapper;

@Service
public class ShopRoleAuthority2GeneratorQueryServiceImpl implements ShopRoleAuthority2GeneratorQueryService
{

    @Autowired
    private ShopRoleAuthority2Mapper shopRoleAuthority2Mapper;

    @Override
    public Integer countByExample(ShopRoleAuthority2Example shopRoleAuthority2Example) 
    {
        return this.shopRoleAuthority2Mapper.countByExample(shopRoleAuthority2Example);
    }

    @Override
    public List<ShopRoleAuthority2> selectByExample(ShopRoleAuthority2Example shopRoleAuthority2Example) 
    {
        return this.shopRoleAuthority2Mapper.selectByExample(shopRoleAuthority2Example);
    }

    @Override
    public ShopRoleAuthority2 selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopRoleAuthority2Key shopRoleAuthority2Key = new ShopRoleAuthority2Key();
        shopRoleAuthority2Key.setIsDel("N");
        shopRoleAuthority2Key.setId(primaryKey);
        return this.shopRoleAuthority2Mapper.selectByPrimaryKey(shopRoleAuthority2Key);
    }

    @Override
    public ShopRoleAuthority2 selectByPrimaryKey(String primaryKey) 
    {
        ShopRoleAuthority2Key shopRoleAuthority2Key = new ShopRoleAuthority2Key();
        shopRoleAuthority2Key.setId(primaryKey);
        return this.shopRoleAuthority2Mapper.selectByPrimaryKey(shopRoleAuthority2Key);
    }

}
