package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopUserInfoGeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopUserInfo;
import com.gooagoo.entity.generator.shop.ShopUserInfoExample;
import com.gooagoo.entity.generator.shop.ShopUserInfoKey;
import com.gooagoo.dao.generator.shop.ShopUserInfoMapper;

@Service
public class ShopUserInfoGeneratorQueryServiceImpl implements ShopUserInfoGeneratorQueryService
{

    @Autowired
    private ShopUserInfoMapper shopUserInfoMapper;

    @Override
    public Integer countByExample(ShopUserInfoExample shopUserInfoExample) 
    {
        return this.shopUserInfoMapper.countByExample(shopUserInfoExample);
    }

    @Override
    public List<ShopUserInfo> selectByExample(ShopUserInfoExample shopUserInfoExample) 
    {
        return this.shopUserInfoMapper.selectByExample(shopUserInfoExample);
    }

    @Override
    public ShopUserInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopUserInfoKey shopUserInfoKey = new ShopUserInfoKey();
        shopUserInfoKey.setIsDel("N");
        shopUserInfoKey.setUserId(primaryKey);
        return this.shopUserInfoMapper.selectByPrimaryKey(shopUserInfoKey);
    }

    @Override
    public ShopUserInfo selectByPrimaryKey(String primaryKey) 
    {
        ShopUserInfoKey shopUserInfoKey = new ShopUserInfoKey();
        shopUserInfoKey.setUserId(primaryKey);
        return this.shopUserInfoMapper.selectByPrimaryKey(shopUserInfoKey);
    }

}
