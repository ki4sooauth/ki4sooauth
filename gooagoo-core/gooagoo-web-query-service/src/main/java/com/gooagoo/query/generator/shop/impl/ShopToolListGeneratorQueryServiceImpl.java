package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopToolListGeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopToolList;
import com.gooagoo.entity.generator.shop.ShopToolListExample;
import com.gooagoo.entity.generator.shop.ShopToolListKey;
import com.gooagoo.dao.generator.shop.ShopToolListMapper;

@Service
public class ShopToolListGeneratorQueryServiceImpl implements ShopToolListGeneratorQueryService
{

    @Autowired
    private ShopToolListMapper shopToolListMapper;

    @Override
    public Integer countByExample(ShopToolListExample shopToolListExample) 
    {
        return this.shopToolListMapper.countByExample(shopToolListExample);
    }

    @Override
    public List<ShopToolList> selectByExample(ShopToolListExample shopToolListExample) 
    {
        return this.shopToolListMapper.selectByExample(shopToolListExample);
    }

    @Override
    public ShopToolList selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopToolListKey shopToolListKey = new ShopToolListKey();
        shopToolListKey.setIsDel("N");
        shopToolListKey.setId(primaryKey);
        return this.shopToolListMapper.selectByPrimaryKey(shopToolListKey);
    }

    @Override
    public ShopToolList selectByPrimaryKey(String primaryKey) 
    {
        ShopToolListKey shopToolListKey = new ShopToolListKey();
        shopToolListKey.setId(primaryKey);
        return this.shopToolListMapper.selectByPrimaryKey(shopToolListKey);
    }

}
