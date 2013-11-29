package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.ShopEmailactiveCodeGeneratorCoreService;
import com.gooagoo.entity.generator.shop.ShopEmailactiveCode;
import com.gooagoo.entity.generator.shop.ShopEmailactiveCodeExample;
import com.gooagoo.entity.generator.shop.ShopEmailactiveCodeKey;
import com.gooagoo.dao.generator.shop.ShopEmailactiveCodeMapper;

@Service
public class ShopEmailactiveCodeGeneratorCoreServiceImpl implements ShopEmailactiveCodeGeneratorCoreService
{

    @Autowired
    private ShopEmailactiveCodeMapper shopEmailactiveCodeMapper;

    @Override
    public Integer countByExample(ShopEmailactiveCodeExample shopEmailactiveCodeExample) 
    {
        return this.shopEmailactiveCodeMapper.countByExample(shopEmailactiveCodeExample);
    }

    @Override
    public List<ShopEmailactiveCode> selectByExample(ShopEmailactiveCodeExample shopEmailactiveCodeExample) 
    {
        return this.shopEmailactiveCodeMapper.selectByExample(shopEmailactiveCodeExample);
    }

    @Override
    public ShopEmailactiveCode selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopEmailactiveCodeKey shopEmailactiveCodeKey = new ShopEmailactiveCodeKey();
        shopEmailactiveCodeKey.setIsDel("N");
        shopEmailactiveCodeKey.setId(primaryKey);
        return this.shopEmailactiveCodeMapper.selectByPrimaryKey(shopEmailactiveCodeKey);
    }

    @Override
    public ShopEmailactiveCode selectByPrimaryKey(String primaryKey) 
    {
        ShopEmailactiveCodeKey shopEmailactiveCodeKey = new ShopEmailactiveCodeKey();
        shopEmailactiveCodeKey.setId(primaryKey);
        return this.shopEmailactiveCodeMapper.selectByPrimaryKey(shopEmailactiveCodeKey);
    }

    @Override
    public boolean physicalDeleteByExample(ShopEmailactiveCodeExample shopEmailactiveCodeExample) 
    {
        return this.shopEmailactiveCodeMapper.deleteByExample(shopEmailactiveCodeExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopEmailactiveCodeKey shopEmailactiveCodeKey = new ShopEmailactiveCodeKey();
        shopEmailactiveCodeKey.setId(primaryKey);
        return this.shopEmailactiveCodeMapper.deleteByPrimaryKey(shopEmailactiveCodeKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopEmailactiveCodeExample shopEmailactiveCodeExample) 
    {
        ShopEmailactiveCode shopEmailactiveCode = new ShopEmailactiveCode();
        shopEmailactiveCode.setIsDel("Y");
        return this.shopEmailactiveCodeMapper.updateByExampleSelective(shopEmailactiveCode,shopEmailactiveCodeExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopEmailactiveCode shopEmailactiveCode = new ShopEmailactiveCode();
        shopEmailactiveCode.setId(primaryKey);
        shopEmailactiveCode.setIsDel("Y");
        return this.shopEmailactiveCodeMapper.updateByPrimaryKeySelective(shopEmailactiveCode) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopEmailactiveCode shopEmailactiveCode) 
    {
        return this.shopEmailactiveCodeMapper.insertSelective(shopEmailactiveCode) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopEmailactiveCode shopEmailactiveCode,ShopEmailactiveCodeExample shopEmailactiveCodeExample) 
    {
        return this.shopEmailactiveCodeMapper.updateByExampleSelective(shopEmailactiveCode,shopEmailactiveCodeExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopEmailactiveCode shopEmailactiveCode) 
    {
        return this.shopEmailactiveCodeMapper.updateByPrimaryKeySelective(shopEmailactiveCode) > 0 ? true : false;
    }

}
