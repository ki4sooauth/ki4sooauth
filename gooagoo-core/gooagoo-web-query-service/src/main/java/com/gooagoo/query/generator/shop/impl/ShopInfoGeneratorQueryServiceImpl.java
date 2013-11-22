package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopInfoExample;
import com.gooagoo.entity.generator.shop.ShopInfoKey;
import com.gooagoo.dao.generator.shop.ShopInfoMapper;

@Service
public class ShopInfoGeneratorQueryServiceImpl implements ShopInfoGeneratorQueryService
{

    @Autowired
    private ShopInfoMapper shopInfoMapper;

    @Override
    public Integer countByExample(ShopInfoExample shopInfoExample) 
    {
        return this.shopInfoMapper.countByExample(shopInfoExample);
    }

    @Override
    public List<ShopInfo> selectByExample(ShopInfoExample shopInfoExample) 
    {
        return this.shopInfoMapper.selectByExample(shopInfoExample);
    }

    @Override
    public ShopInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopInfoKey shopInfoKey = new ShopInfoKey();
        shopInfoKey.setIsDel("N");
        shopInfoKey.setShopId(primaryKey);
        return this.shopInfoMapper.selectByPrimaryKey(shopInfoKey);
    }

    @Override
    public ShopInfo selectByPrimaryKey(String primaryKey) 
    {
        ShopInfoKey shopInfoKey = new ShopInfoKey();
        shopInfoKey.setShopId(primaryKey);
        return this.shopInfoMapper.selectByPrimaryKey(shopInfoKey);
    }

}
