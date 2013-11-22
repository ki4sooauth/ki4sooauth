package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopTableTypeManageGeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopTableTypeManage;
import com.gooagoo.entity.generator.shop.ShopTableTypeManageExample;
import com.gooagoo.entity.generator.shop.ShopTableTypeManageKey;
import com.gooagoo.dao.generator.shop.ShopTableTypeManageMapper;

@Service
public class ShopTableTypeManageGeneratorQueryServiceImpl implements ShopTableTypeManageGeneratorQueryService
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

}
