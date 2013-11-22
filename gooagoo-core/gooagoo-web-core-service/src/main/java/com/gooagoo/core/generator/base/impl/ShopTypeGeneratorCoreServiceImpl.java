package com.gooagoo.core.generator.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.base.ShopTypeGeneratorCoreService;
import com.gooagoo.entity.generator.base.ShopType;
import com.gooagoo.entity.generator.base.ShopTypeExample;
import com.gooagoo.entity.generator.base.ShopTypeKey;
import com.gooagoo.dao.generator.base.ShopTypeMapper;

@Service
public class ShopTypeGeneratorCoreServiceImpl implements ShopTypeGeneratorCoreService
{

    @Autowired
    private ShopTypeMapper shopTypeMapper;

    @Override
    public Integer countByExample(ShopTypeExample shopTypeExample) 
    {
        return this.shopTypeMapper.countByExample(shopTypeExample);
    }

    @Override
    public List<ShopType> selectByExample(ShopTypeExample shopTypeExample) 
    {
        return this.shopTypeMapper.selectByExample(shopTypeExample);
    }

    @Override
    public ShopType selectUnDelByPrimaryKey(Integer primaryKey) 
    {
        ShopTypeKey shopTypeKey = new ShopTypeKey();
        shopTypeKey.setIsDel("N");
        shopTypeKey.setShopTypeId(primaryKey);
        return this.shopTypeMapper.selectByPrimaryKey(shopTypeKey);
    }

    @Override
    public ShopType selectByPrimaryKey(Integer primaryKey) 
    {
        ShopTypeKey shopTypeKey = new ShopTypeKey();
        shopTypeKey.setShopTypeId(primaryKey);
        return this.shopTypeMapper.selectByPrimaryKey(shopTypeKey);
    }

    @Override
    public boolean physicalDeleteByExample(ShopTypeExample shopTypeExample) 
    {
        return this.shopTypeMapper.deleteByExample(shopTypeExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(Integer primaryKey) 
    {
        ShopTypeKey shopTypeKey = new ShopTypeKey();
        shopTypeKey.setShopTypeId(primaryKey);
        return this.shopTypeMapper.deleteByPrimaryKey(shopTypeKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopTypeExample shopTypeExample) 
    {
        ShopType shopType = new ShopType();
        shopType.setIsDel("Y");
        return this.shopTypeMapper.updateByExampleSelective(shopType,shopTypeExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(Integer primaryKey) 
    {
        ShopType shopType = new ShopType();
        shopType.setShopTypeId(primaryKey);
        shopType.setIsDel("Y");
        return this.shopTypeMapper.updateByPrimaryKeySelective(shopType) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopType shopType) 
    {
        return this.shopTypeMapper.insertSelective(shopType) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopType shopType,ShopTypeExample shopTypeExample) 
    {
        return this.shopTypeMapper.updateByExampleSelective(shopType,shopTypeExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopType shopType) 
    {
        return this.shopTypeMapper.updateByPrimaryKeySelective(shopType) > 0 ? true : false;
    }

}
