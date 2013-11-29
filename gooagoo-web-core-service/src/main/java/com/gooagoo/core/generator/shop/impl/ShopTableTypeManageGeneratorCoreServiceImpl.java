package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.ShopTableTypeManageGeneratorCoreService;
import com.gooagoo.entity.generator.shop.ShopTableTypeManage;
import com.gooagoo.entity.generator.shop.ShopTableTypeManageExample;
import com.gooagoo.entity.generator.shop.ShopTableTypeManageKey;
import com.gooagoo.dao.generator.shop.ShopTableTypeManageMapper;

@Service
public class ShopTableTypeManageGeneratorCoreServiceImpl implements ShopTableTypeManageGeneratorCoreService
{

    @Autowired
    private ShopTableTypeManageMapper shopTableTypeManageMapper;

    @Override
    public Integer countByExample(ShopTableTypeManageExample shopTableTypeManageExample) 
    {
        return this.shopTableTypeManageMapper.countByExample(shopTableTypeManageExample);
    }

    @Override
    public List<ShopTableTypeManage> selectByExample(ShopTableTypeManageExample shopTableTypeManageExample) 
    {
        return this.shopTableTypeManageMapper.selectByExample(shopTableTypeManageExample);
    }

    @Override
    public ShopTableTypeManage selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopTableTypeManageKey shopTableTypeManageKey = new ShopTableTypeManageKey();
        shopTableTypeManageKey.setIsDel("N");
        shopTableTypeManageKey.setTableTypeCode(primaryKey);
        return this.shopTableTypeManageMapper.selectByPrimaryKey(shopTableTypeManageKey);
    }

    @Override
    public ShopTableTypeManage selectByPrimaryKey(String primaryKey) 
    {
        ShopTableTypeManageKey shopTableTypeManageKey = new ShopTableTypeManageKey();
        shopTableTypeManageKey.setTableTypeCode(primaryKey);
        return this.shopTableTypeManageMapper.selectByPrimaryKey(shopTableTypeManageKey);
    }

    @Override
    public boolean physicalDeleteByExample(ShopTableTypeManageExample shopTableTypeManageExample) 
    {
        return this.shopTableTypeManageMapper.deleteByExample(shopTableTypeManageExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopTableTypeManageKey shopTableTypeManageKey = new ShopTableTypeManageKey();
        shopTableTypeManageKey.setTableTypeCode(primaryKey);
        return this.shopTableTypeManageMapper.deleteByPrimaryKey(shopTableTypeManageKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopTableTypeManageExample shopTableTypeManageExample) 
    {
        ShopTableTypeManage shopTableTypeManage = new ShopTableTypeManage();
        shopTableTypeManage.setIsDel("Y");
        return this.shopTableTypeManageMapper.updateByExampleSelective(shopTableTypeManage,shopTableTypeManageExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopTableTypeManage shopTableTypeManage = new ShopTableTypeManage();
        shopTableTypeManage.setTableTypeCode(primaryKey);
        shopTableTypeManage.setIsDel("Y");
        return this.shopTableTypeManageMapper.updateByPrimaryKeySelective(shopTableTypeManage) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopTableTypeManage shopTableTypeManage) 
    {
        return this.shopTableTypeManageMapper.insertSelective(shopTableTypeManage) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopTableTypeManage shopTableTypeManage,ShopTableTypeManageExample shopTableTypeManageExample) 
    {
        return this.shopTableTypeManageMapper.updateByExampleSelective(shopTableTypeManage,shopTableTypeManageExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopTableTypeManage shopTableTypeManage) 
    {
        return this.shopTableTypeManageMapper.updateByPrimaryKeySelective(shopTableTypeManage) > 0 ? true : false;
    }

}
