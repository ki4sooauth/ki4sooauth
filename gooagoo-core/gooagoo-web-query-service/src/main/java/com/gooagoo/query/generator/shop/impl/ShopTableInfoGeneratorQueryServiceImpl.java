package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopTableInfoGeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopTableInfo;
import com.gooagoo.entity.generator.shop.ShopTableInfoExample;
import com.gooagoo.entity.generator.shop.ShopTableInfoKey;
import com.gooagoo.dao.generator.shop.ShopTableInfoMapper;

@Service
public class ShopTableInfoGeneratorQueryServiceImpl implements ShopTableInfoGeneratorQueryService
{

    @Autowired
    private ShopTableInfoMapper shopTableInfoMapper;

    @Override
    public Integer countByExample(ShopTableInfoExample shopTableInfoExample) 
    {
        return this.shopTableInfoMapper.countByExample(shopTableInfoExample);
    }

    @Override
    public List<ShopTableInfo> selectByExample(ShopTableInfoExample shopTableInfoExample) 
    {
        return this.shopTableInfoMapper.selectByExample(shopTableInfoExample);
    }

    @Override
    public ShopTableInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopTableInfoKey shopTableInfoKey = new ShopTableInfoKey();
        shopTableInfoKey.setIsDel("N");
        shopTableInfoKey.setId(primaryKey);
        return this.shopTableInfoMapper.selectByPrimaryKey(shopTableInfoKey);
    }

    @Override
    public ShopTableInfo selectByPrimaryKey(String primaryKey) 
    {
        ShopTableInfoKey shopTableInfoKey = new ShopTableInfoKey();
        shopTableInfoKey.setId(primaryKey);
        return this.shopTableInfoMapper.selectByPrimaryKey(shopTableInfoKey);
    }

}
