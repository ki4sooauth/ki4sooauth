package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.ShopTableInfoGeneratorCoreService;
import com.gooagoo.entity.generator.shop.ShopTableInfo;
import com.gooagoo.entity.generator.shop.ShopTableInfoExample;
import com.gooagoo.entity.generator.shop.ShopTableInfoKey;
import com.gooagoo.dao.generator.shop.ShopTableInfoMapper;

@Service
public class ShopTableInfoGeneratorCoreServiceImpl implements ShopTableInfoGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(ShopTableInfoExample shopTableInfoExample) 
    {
        return this.shopTableInfoMapper.deleteByExample(shopTableInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopTableInfoKey shopTableInfoKey = new ShopTableInfoKey();
        shopTableInfoKey.setId(primaryKey);
        return this.shopTableInfoMapper.deleteByPrimaryKey(shopTableInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopTableInfoExample shopTableInfoExample) 
    {
        ShopTableInfo shopTableInfo = new ShopTableInfo();
        shopTableInfo.setIsDel("Y");
        return this.shopTableInfoMapper.updateByExampleSelective(shopTableInfo,shopTableInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopTableInfo shopTableInfo = new ShopTableInfo();
        shopTableInfo.setId(primaryKey);
        shopTableInfo.setIsDel("Y");
        return this.shopTableInfoMapper.updateByPrimaryKeySelective(shopTableInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopTableInfo shopTableInfo) 
    {
        return this.shopTableInfoMapper.insertSelective(shopTableInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopTableInfo shopTableInfo,ShopTableInfoExample shopTableInfoExample) 
    {
        return this.shopTableInfoMapper.updateByExampleSelective(shopTableInfo,shopTableInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopTableInfo shopTableInfo) 
    {
        return this.shopTableInfoMapper.updateByPrimaryKeySelective(shopTableInfo) > 0 ? true : false;
    }

}
