package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.ShopToolListGeneratorCoreService;
import com.gooagoo.entity.generator.shop.ShopToolList;
import com.gooagoo.entity.generator.shop.ShopToolListExample;
import com.gooagoo.entity.generator.shop.ShopToolListKey;
import com.gooagoo.dao.generator.shop.ShopToolListMapper;

@Service
public class ShopToolListGeneratorCoreServiceImpl implements ShopToolListGeneratorCoreService
{

    @Autowired
    private ShopToolListMapper shopToolListMapper;

    @Override
    public Integer countByExample(ShopToolListExample shopToolListExample) 
    {
        return this.shopToolListMapper.countByExample(shopToolListExample);
    }

    @Override
    public List<ShopToolList> selectByExample(ShopToolListExample shopToolListExample) 
    {
        return this.shopToolListMapper.selectByExample(shopToolListExample);
    }

    @Override
    public ShopToolList selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopToolListKey shopToolListKey = new ShopToolListKey();
        shopToolListKey.setIsDel("N");
        shopToolListKey.setId(primaryKey);
        return this.shopToolListMapper.selectByPrimaryKey(shopToolListKey);
    }

    @Override
    public ShopToolList selectByPrimaryKey(String primaryKey) 
    {
        ShopToolListKey shopToolListKey = new ShopToolListKey();
        shopToolListKey.setId(primaryKey);
        return this.shopToolListMapper.selectByPrimaryKey(shopToolListKey);
    }

    @Override
    public boolean physicalDeleteByExample(ShopToolListExample shopToolListExample) 
    {
        return this.shopToolListMapper.deleteByExample(shopToolListExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopToolListKey shopToolListKey = new ShopToolListKey();
        shopToolListKey.setId(primaryKey);
        return this.shopToolListMapper.deleteByPrimaryKey(shopToolListKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopToolListExample shopToolListExample) 
    {
        ShopToolList shopToolList = new ShopToolList();
        shopToolList.setIsDel("Y");
        return this.shopToolListMapper.updateByExampleSelective(shopToolList,shopToolListExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopToolList shopToolList = new ShopToolList();
        shopToolList.setId(primaryKey);
        shopToolList.setIsDel("Y");
        return this.shopToolListMapper.updateByPrimaryKeySelective(shopToolList) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopToolList shopToolList) 
    {
        return this.shopToolListMapper.insertSelective(shopToolList) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopToolList shopToolList,ShopToolListExample shopToolListExample) 
    {
        return this.shopToolListMapper.updateByExampleSelective(shopToolList,shopToolListExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopToolList shopToolList) 
    {
        return this.shopToolListMapper.updateByPrimaryKeySelective(shopToolList) > 0 ? true : false;
    }

}
