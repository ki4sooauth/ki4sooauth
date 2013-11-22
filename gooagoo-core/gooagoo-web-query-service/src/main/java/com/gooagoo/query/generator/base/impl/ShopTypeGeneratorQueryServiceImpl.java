package com.gooagoo.query.generator.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.base.ShopTypeGeneratorQueryService;
import com.gooagoo.entity.generator.base.ShopType;
import com.gooagoo.entity.generator.base.ShopTypeExample;
import com.gooagoo.entity.generator.base.ShopTypeKey;
import com.gooagoo.dao.generator.base.ShopTypeMapper;

@Service
public class ShopTypeGeneratorQueryServiceImpl implements ShopTypeGeneratorQueryService
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

}
