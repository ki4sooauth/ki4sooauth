package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopAuthorityGeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopAuthority;
import com.gooagoo.entity.generator.shop.ShopAuthorityExample;
import com.gooagoo.entity.generator.shop.ShopAuthorityKey;
import com.gooagoo.dao.generator.shop.ShopAuthorityMapper;

@Service
public class ShopAuthorityGeneratorQueryServiceImpl implements ShopAuthorityGeneratorQueryService
{

    @Autowired
    private ShopAuthorityMapper shopAuthorityMapper;

    @Override
    public Integer countByExample(ShopAuthorityExample shopAuthorityExample) 
    {
        return this.shopAuthorityMapper.countByExample(shopAuthorityExample);
    }

    @Override
    public List<ShopAuthority> selectByExample(ShopAuthorityExample shopAuthorityExample) 
    {
        return this.shopAuthorityMapper.selectByExample(shopAuthorityExample);
    }

    @Override
    public ShopAuthority selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopAuthorityKey shopAuthorityKey = new ShopAuthorityKey();
        shopAuthorityKey.setIsDel("N");
        shopAuthorityKey.setAuthorityId(primaryKey);
        return this.shopAuthorityMapper.selectByPrimaryKey(shopAuthorityKey);
    }

    @Override
    public ShopAuthority selectByPrimaryKey(String primaryKey) 
    {
        ShopAuthorityKey shopAuthorityKey = new ShopAuthorityKey();
        shopAuthorityKey.setAuthorityId(primaryKey);
        return this.shopAuthorityMapper.selectByPrimaryKey(shopAuthorityKey);
    }

}
