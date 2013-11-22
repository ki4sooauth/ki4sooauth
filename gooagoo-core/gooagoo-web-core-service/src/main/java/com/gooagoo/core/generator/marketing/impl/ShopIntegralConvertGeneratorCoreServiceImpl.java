package com.gooagoo.core.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.marketing.ShopIntegralConvertGeneratorCoreService;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvert;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvertExample;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvertKey;
import com.gooagoo.dao.generator.marketing.ShopIntegralConvertMapper;

@Service
public class ShopIntegralConvertGeneratorCoreServiceImpl implements ShopIntegralConvertGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(ShopIntegralConvertExample shopIntegralConvertExample) 
    {
        return this.shopIntegralConvertMapper.deleteByExample(shopIntegralConvertExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopIntegralConvertKey shopIntegralConvertKey = new ShopIntegralConvertKey();
        shopIntegralConvertKey.setShopIntegralConvertId(primaryKey);
        return this.shopIntegralConvertMapper.deleteByPrimaryKey(shopIntegralConvertKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopIntegralConvertExample shopIntegralConvertExample) 
    {
        ShopIntegralConvert shopIntegralConvert = new ShopIntegralConvert();
        shopIntegralConvert.setIsDel("Y");
        return this.shopIntegralConvertMapper.updateByExampleSelective(shopIntegralConvert,shopIntegralConvertExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopIntegralConvert shopIntegralConvert = new ShopIntegralConvert();
        shopIntegralConvert.setShopIntegralConvertId(primaryKey);
        shopIntegralConvert.setIsDel("Y");
        return this.shopIntegralConvertMapper.updateByPrimaryKeySelective(shopIntegralConvert) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopIntegralConvert shopIntegralConvert) 
    {
        return this.shopIntegralConvertMapper.insertSelective(shopIntegralConvert) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopIntegralConvert shopIntegralConvert,ShopIntegralConvertExample shopIntegralConvertExample) 
    {
        return this.shopIntegralConvertMapper.updateByExampleSelective(shopIntegralConvert,shopIntegralConvertExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopIntegralConvert shopIntegralConvert) 
    {
        return this.shopIntegralConvertMapper.updateByPrimaryKeySelective(shopIntegralConvert) > 0 ? true : false;
    }

}
