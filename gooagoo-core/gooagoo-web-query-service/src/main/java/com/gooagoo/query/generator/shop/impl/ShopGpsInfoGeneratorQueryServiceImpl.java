package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopGpsInfoGeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopGpsInfo;
import com.gooagoo.entity.generator.shop.ShopGpsInfoExample;
import com.gooagoo.entity.generator.shop.ShopGpsInfoKey;
import com.gooagoo.dao.generator.shop.ShopGpsInfoMapper;

@Service
public class ShopGpsInfoGeneratorQueryServiceImpl implements ShopGpsInfoGeneratorQueryService
{

    @Autowired
    private ShopGpsInfoMapper shopGpsInfoMapper;

    @Override
    public Integer countByExample(ShopGpsInfoExample shopGpsInfoExample) 
    {
        return this.shopGpsInfoMapper.countByExample(shopGpsInfoExample);
    }

    @Override
    public List<ShopGpsInfo> selectByExample(ShopGpsInfoExample shopGpsInfoExample) 
    {
        return this.shopGpsInfoMapper.selectByExample(shopGpsInfoExample);
    }

    @Override
    public ShopGpsInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopGpsInfoKey shopGpsInfoKey = new ShopGpsInfoKey();
        shopGpsInfoKey.setIsDel("N");
        shopGpsInfoKey.setShopEntityId(primaryKey);
        return this.shopGpsInfoMapper.selectByPrimaryKey(shopGpsInfoKey);
    }

    @Override
    public ShopGpsInfo selectByPrimaryKey(String primaryKey) 
    {
        ShopGpsInfoKey shopGpsInfoKey = new ShopGpsInfoKey();
        shopGpsInfoKey.setShopEntityId(primaryKey);
        return this.shopGpsInfoMapper.selectByPrimaryKey(shopGpsInfoKey);
    }

}
