package com.gooagoo.query.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.sys.ShopBidGeneratorQueryService;
import com.gooagoo.entity.generator.sys.ShopBid;
import com.gooagoo.entity.generator.sys.ShopBidExample;
import com.gooagoo.entity.generator.sys.ShopBidKey;
import com.gooagoo.dao.generator.sys.ShopBidMapper;

@Service
public class ShopBidGeneratorQueryServiceImpl implements ShopBidGeneratorQueryService
{

    @Autowired
    private ShopBidMapper shopBidMapper;

    @Override
    public Integer countByExample(ShopBidExample shopBidExample) 
    {
        return this.shopBidMapper.countByExample(shopBidExample);
    }

    @Override
    public List<ShopBid> selectByExample(ShopBidExample shopBidExample) 
    {
        return this.shopBidMapper.selectByExample(shopBidExample);
    }

    @Override
    public ShopBid selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopBidKey shopBidKey = new ShopBidKey();
        shopBidKey.setIsDel("N");
        shopBidKey.setId(primaryKey);
        return this.shopBidMapper.selectByPrimaryKey(shopBidKey);
    }

    @Override
    public ShopBid selectByPrimaryKey(String primaryKey) 
    {
        ShopBidKey shopBidKey = new ShopBidKey();
        shopBidKey.setId(primaryKey);
        return this.shopBidMapper.selectByPrimaryKey(shopBidKey);
    }

}
