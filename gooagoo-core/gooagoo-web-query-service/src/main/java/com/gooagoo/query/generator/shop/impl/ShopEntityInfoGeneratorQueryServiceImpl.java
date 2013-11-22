package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopEntityInfoGeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfoExample;
import com.gooagoo.entity.generator.shop.ShopEntityInfoKey;
import com.gooagoo.dao.generator.shop.ShopEntityInfoMapper;

@Service
public class ShopEntityInfoGeneratorQueryServiceImpl implements ShopEntityInfoGeneratorQueryService
{

    @Autowired
    private ShopEntityInfoMapper shopEntityInfoMapper;

    @Override
    public Integer countByExample(ShopEntityInfoExample shopEntityInfoExample) 
    {
        return this.shopEntityInfoMapper.countByExample(shopEntityInfoExample);
    }

    @Override
    public List<ShopEntityInfo> selectByExample(ShopEntityInfoExample shopEntityInfoExample) 
    {
        return this.shopEntityInfoMapper.selectByExample(shopEntityInfoExample);
    }

    @Override
    public ShopEntityInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopEntityInfoKey shopEntityInfoKey = new ShopEntityInfoKey();
        shopEntityInfoKey.setIsDel("N");
        shopEntityInfoKey.setShopEntityId(primaryKey);
        return this.shopEntityInfoMapper.selectByPrimaryKey(shopEntityInfoKey);
    }

    @Override
    public ShopEntityInfo selectByPrimaryKey(String primaryKey) 
    {
        ShopEntityInfoKey shopEntityInfoKey = new ShopEntityInfoKey();
        shopEntityInfoKey.setShopEntityId(primaryKey);
        return this.shopEntityInfoMapper.selectByPrimaryKey(shopEntityInfoKey);
    }

}
