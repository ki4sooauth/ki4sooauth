package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.ShopLidInfoGeneratorCoreService;
import com.gooagoo.entity.generator.shop.ShopLidInfo;
import com.gooagoo.entity.generator.shop.ShopLidInfoExample;
import com.gooagoo.entity.generator.shop.ShopLidInfoKey;
import com.gooagoo.dao.generator.shop.ShopLidInfoMapper;

@Service
public class ShopLidInfoGeneratorCoreServiceImpl implements ShopLidInfoGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(ShopLidInfoExample shopLidInfoExample) 
    {
        return this.shopLidInfoMapper.deleteByExample(shopLidInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopLidInfoKey shopLidInfoKey = new ShopLidInfoKey();
        shopLidInfoKey.setLidBase(primaryKey);
        return this.shopLidInfoMapper.deleteByPrimaryKey(shopLidInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopLidInfoExample shopLidInfoExample) 
    {
        ShopLidInfo shopLidInfo = new ShopLidInfo();
        shopLidInfo.setIsDel("Y");
        return this.shopLidInfoMapper.updateByExampleSelective(shopLidInfo,shopLidInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopLidInfo shopLidInfo = new ShopLidInfo();
        shopLidInfo.setLidBase(primaryKey);
        shopLidInfo.setIsDel("Y");
        return this.shopLidInfoMapper.updateByPrimaryKeySelective(shopLidInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopLidInfo shopLidInfo) 
    {
        return this.shopLidInfoMapper.insertSelective(shopLidInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopLidInfo shopLidInfo,ShopLidInfoExample shopLidInfoExample) 
    {
        return this.shopLidInfoMapper.updateByExampleSelective(shopLidInfo,shopLidInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopLidInfo shopLidInfo) 
    {
        return this.shopLidInfoMapper.updateByPrimaryKeySelective(shopLidInfo) > 0 ? true : false;
    }

}
