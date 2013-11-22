package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopEmailactiveCodeGeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopEmailactiveCode;
import com.gooagoo.entity.generator.shop.ShopEmailactiveCodeExample;
import com.gooagoo.entity.generator.shop.ShopEmailactiveCodeKey;
import com.gooagoo.dao.generator.shop.ShopEmailactiveCodeMapper;

@Service
public class ShopEmailactiveCodeGeneratorQueryServiceImpl implements ShopEmailactiveCodeGeneratorQueryService
{

    @Autowired
    private ShopEmailactiveCodeMapper shopEmailactiveCodeMapper;

    @Override
    public Integer countByExample(ShopEmailactiveCodeExample shopEmailactiveCodeExample) 
    {
        return this.shopEmailactiveCodeMapper.countByExample(shopEmailactiveCodeExample);
    }

    @Override
    public List<ShopEmailactiveCode> selectByExample(ShopEmailactiveCodeExample shopEmailactiveCodeExample) 
    {
        return this.shopEmailactiveCodeMapper.selectByExample(shopEmailactiveCodeExample);
    }

    @Override
    public ShopEmailactiveCode selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopEmailactiveCodeKey shopEmailactiveCodeKey = new ShopEmailactiveCodeKey();
        shopEmailactiveCodeKey.setIsDel("N");
        shopEmailactiveCodeKey.setId(primaryKey);
        return this.shopEmailactiveCodeMapper.selectByPrimaryKey(shopEmailactiveCodeKey);
    }

    @Override
    public ShopEmailactiveCode selectByPrimaryKey(String primaryKey) 
    {
        ShopEmailactiveCodeKey shopEmailactiveCodeKey = new ShopEmailactiveCodeKey();
        shopEmailactiveCodeKey.setId(primaryKey);
        return this.shopEmailactiveCodeMapper.selectByPrimaryKey(shopEmailactiveCodeKey);
    }

}
