package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopLidInfoGeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopLidInfo;
import com.gooagoo.entity.generator.shop.ShopLidInfoExample;
import com.gooagoo.entity.generator.shop.ShopLidInfoKey;
import com.gooagoo.dao.generator.shop.ShopLidInfoMapper;

@Service
public class ShopLidInfoGeneratorQueryServiceImpl implements ShopLidInfoGeneratorQueryService
{

    @Autowired
    private ShopLidInfoMapper shopLidInfoMapper;

    @Override
    public Integer countByExample(ShopLidInfoExample shopLidInfoExample) 
    {
        return this.shopLidInfoMapper.countByExample(shopLidInfoExample);
    }

    @Override
    public List<ShopLidInfo> selectByExample(ShopLidInfoExample shopLidInfoExample) 
    {
        return this.shopLidInfoMapper.selectByExample(shopLidInfoExample);
    }

    @Override
    public ShopLidInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopLidInfoKey shopLidInfoKey = new ShopLidInfoKey();
        shopLidInfoKey.setIsDel("N");
        shopLidInfoKey.setLidBase(primaryKey);
        return this.shopLidInfoMapper.selectByPrimaryKey(shopLidInfoKey);
    }

    @Override
    public ShopLidInfo selectByPrimaryKey(String primaryKey) 
    {
        ShopLidInfoKey shopLidInfoKey = new ShopLidInfoKey();
        shopLidInfoKey.setLidBase(primaryKey);
        return this.shopLidInfoMapper.selectByPrimaryKey(shopLidInfoKey);
    }

}
