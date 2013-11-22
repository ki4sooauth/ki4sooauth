package com.gooagoo.query.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.marketing.ShopIntegralConvertGeneratorQueryService;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvert;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvertExample;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvertKey;
import com.gooagoo.dao.generator.marketing.ShopIntegralConvertMapper;

@Service
public class ShopIntegralConvertGeneratorQueryServiceImpl implements ShopIntegralConvertGeneratorQueryService
{

    @Autowired
    private ShopIntegralConvertMapper shopIntegralConvertMapper;

    @Override
    public Integer countByExample(ShopIntegralConvertExample shopIntegralConvertExample) 
    {
        return this.shopIntegralConvertMapper.countByExample(shopIntegralConvertExample);
    }

    @Override
    public List<ShopIntegralConvert> selectByExample(ShopIntegralConvertExample shopIntegralConvertExample) 
    {
        return this.shopIntegralConvertMapper.selectByExample(shopIntegralConvertExample);
    }

    @Override
    public ShopIntegralConvert selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopIntegralConvertKey shopIntegralConvertKey = new ShopIntegralConvertKey();
        shopIntegralConvertKey.setIsDel("N");
        shopIntegralConvertKey.setShopIntegralConvertId(primaryKey);
        return this.shopIntegralConvertMapper.selectByPrimaryKey(shopIntegralConvertKey);
    }

    @Override
    public ShopIntegralConvert selectByPrimaryKey(String primaryKey) 
    {
        ShopIntegralConvertKey shopIntegralConvertKey = new ShopIntegralConvertKey();
        shopIntegralConvertKey.setShopIntegralConvertId(primaryKey);
        return this.shopIntegralConvertMapper.selectByPrimaryKey(shopIntegralConvertKey);
    }

}
