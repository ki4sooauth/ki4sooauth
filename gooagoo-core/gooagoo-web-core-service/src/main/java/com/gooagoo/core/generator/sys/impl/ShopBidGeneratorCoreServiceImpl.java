package com.gooagoo.core.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.sys.ShopBidGeneratorCoreService;
import com.gooagoo.entity.generator.sys.ShopBid;
import com.gooagoo.entity.generator.sys.ShopBidExample;
import com.gooagoo.entity.generator.sys.ShopBidKey;
import com.gooagoo.dao.generator.sys.ShopBidMapper;

@Service
public class ShopBidGeneratorCoreServiceImpl implements ShopBidGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(ShopBidExample shopBidExample) 
    {
        return this.shopBidMapper.deleteByExample(shopBidExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopBidKey shopBidKey = new ShopBidKey();
        shopBidKey.setId(primaryKey);
        return this.shopBidMapper.deleteByPrimaryKey(shopBidKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopBidExample shopBidExample) 
    {
        ShopBid shopBid = new ShopBid();
        shopBid.setIsDel("Y");
        return this.shopBidMapper.updateByExampleSelective(shopBid,shopBidExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopBid shopBid = new ShopBid();
        shopBid.setId(primaryKey);
        shopBid.setIsDel("Y");
        return this.shopBidMapper.updateByPrimaryKeySelective(shopBid) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopBid shopBid) 
    {
        return this.shopBidMapper.insertSelective(shopBid) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopBid shopBid,ShopBidExample shopBidExample) 
    {
        return this.shopBidMapper.updateByExampleSelective(shopBid,shopBidExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopBid shopBid) 
    {
        return this.shopBidMapper.updateByPrimaryKeySelective(shopBid) > 0 ? true : false;
    }

}
