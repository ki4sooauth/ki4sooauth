package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.ShopUserInfoGeneratorCoreService;
import com.gooagoo.entity.generator.shop.ShopUserInfo;
import com.gooagoo.entity.generator.shop.ShopUserInfoExample;
import com.gooagoo.entity.generator.shop.ShopUserInfoKey;
import com.gooagoo.dao.generator.shop.ShopUserInfoMapper;

@Service
public class ShopUserInfoGeneratorCoreServiceImpl implements ShopUserInfoGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(ShopUserInfoExample shopUserInfoExample) 
    {
        return this.shopUserInfoMapper.deleteByExample(shopUserInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopUserInfoKey shopUserInfoKey = new ShopUserInfoKey();
        shopUserInfoKey.setUserId(primaryKey);
        return this.shopUserInfoMapper.deleteByPrimaryKey(shopUserInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopUserInfoExample shopUserInfoExample) 
    {
        ShopUserInfo shopUserInfo = new ShopUserInfo();
        shopUserInfo.setIsDel("Y");
        return this.shopUserInfoMapper.updateByExampleSelective(shopUserInfo,shopUserInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopUserInfo shopUserInfo = new ShopUserInfo();
        shopUserInfo.setUserId(primaryKey);
        shopUserInfo.setIsDel("Y");
        return this.shopUserInfoMapper.updateByPrimaryKeySelective(shopUserInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopUserInfo shopUserInfo) 
    {
        return this.shopUserInfoMapper.insertSelective(shopUserInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopUserInfo shopUserInfo,ShopUserInfoExample shopUserInfoExample) 
    {
        return this.shopUserInfoMapper.updateByExampleSelective(shopUserInfo,shopUserInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopUserInfo shopUserInfo) 
    {
        return this.shopUserInfoMapper.updateByPrimaryKeySelective(shopUserInfo) > 0 ? true : false;
    }

}
