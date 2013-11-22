package com.gooagoo.query.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.marketing.ShopIntegralGeneratorQueryService;
import com.gooagoo.entity.generator.marketing.ShopIntegral;
import com.gooagoo.entity.generator.marketing.ShopIntegralExample;
import com.gooagoo.entity.generator.marketing.ShopIntegralKey;
import com.gooagoo.dao.generator.marketing.ShopIntegralMapper;

@Service
public class ShopIntegralGeneratorQueryServiceImpl implements ShopIntegralGeneratorQueryService
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

}
