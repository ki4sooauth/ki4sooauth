package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopPositionGeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopPosition;
import com.gooagoo.entity.generator.shop.ShopPositionExample;
import com.gooagoo.entity.generator.shop.ShopPositionKey;
import com.gooagoo.dao.generator.shop.ShopPositionMapper;

@Service
public class ShopPositionGeneratorQueryServiceImpl implements ShopPositionGeneratorQueryService
{

    @Autowired
    private ShopPositionMapper shopPositionMapper;

    @Override
    public Integer countByExample(ShopPositionExample shopPositionExample) 
    {
        return this.shopPositionMapper.countByExample(shopPositionExample);
    }

    @Override
    public List<ShopPosition> selectByExample(ShopPositionExample shopPositionExample) 
    {
        return this.shopPositionMapper.selectByExample(shopPositionExample);
    }

    @Override
    public ShopPosition selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopPositionKey shopPositionKey = new ShopPositionKey();
        shopPositionKey.setIsDel("N");
        shopPositionKey.setPositionId(primaryKey);
        return this.shopPositionMapper.selectByPrimaryKey(shopPositionKey);
    }

    @Override
    public ShopPosition selectByPrimaryKey(String primaryKey) 
    {
        ShopPositionKey shopPositionKey = new ShopPositionKey();
        shopPositionKey.setPositionId(primaryKey);
        return this.shopPositionMapper.selectByPrimaryKey(shopPositionKey);
    }

}
