package com.gooagoo.core.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.marketing.ShopIntegralGeneratorCoreService;
import com.gooagoo.entity.generator.marketing.ShopIntegral;
import com.gooagoo.entity.generator.marketing.ShopIntegralExample;
import com.gooagoo.entity.generator.marketing.ShopIntegralKey;
import com.gooagoo.dao.generator.marketing.ShopIntegralMapper;

@Service
public class ShopIntegralGeneratorCoreServiceImpl implements ShopIntegralGeneratorCoreService
{

    @Autowired
    private ShopIntegralMapper shopIntegralMapper;

    @Override
    public Integer countByExample(ShopIntegralExample shopIntegralExample) 
    {
        return this.shopIntegralMapper.countByExample(shopIntegralExample);
    }

    @Override
    public List<ShopIntegral> selectByExample(ShopIntegralExample shopIntegralExample) 
    {
        return this.shopIntegralMapper.selectByExample(shopIntegralExample);
    }

    @Override
    public ShopIntegral selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopIntegralKey shopIntegralKey = new ShopIntegralKey();
        shopIntegralKey.setIsDel("N");
        shopIntegralKey.setShopIntegralId(primaryKey);
        return this.shopIntegralMapper.selectByPrimaryKey(shopIntegralKey);
    }

    @Override
    public ShopIntegral selectByPrimaryKey(String primaryKey) 
    {
        ShopIntegralKey shopIntegralKey = new ShopIntegralKey();
        shopIntegralKey.setShopIntegralId(primaryKey);
        return this.shopIntegralMapper.selectByPrimaryKey(shopIntegralKey);
    }

    @Override
    public boolean physicalDeleteByExample(ShopIntegralExample shopIntegralExample) 
    {
        return this.shopIntegralMapper.deleteByExample(shopIntegralExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopIntegralKey shopIntegralKey = new ShopIntegralKey();
        shopIntegralKey.setShopIntegralId(primaryKey);
        return this.shopIntegralMapper.deleteByPrimaryKey(shopIntegralKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopIntegralExample shopIntegralExample) 
    {
        ShopIntegral shopIntegral = new ShopIntegral();
        shopIntegral.setIsDel("Y");
        return this.shopIntegralMapper.updateByExampleSelective(shopIntegral,shopIntegralExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopIntegral shopIntegral = new ShopIntegral();
        shopIntegral.setShopIntegralId(primaryKey);
        shopIntegral.setIsDel("Y");
        return this.shopIntegralMapper.updateByPrimaryKeySelective(shopIntegral) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopIntegral shopIntegral) 
    {
        return this.shopIntegralMapper.insertSelective(shopIntegral) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopIntegral shopIntegral,ShopIntegralExample shopIntegralExample) 
    {
        return this.shopIntegralMapper.updateByExampleSelective(shopIntegral,shopIntegralExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopIntegral shopIntegral) 
    {
        return this.shopIntegralMapper.updateByPrimaryKeySelective(shopIntegral) > 0 ? true : false;
    }

}
