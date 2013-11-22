package com.gooagoo.query.generator.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.base.ShopInterfaceNameGeneratorQueryService;
import com.gooagoo.entity.generator.base.ShopInterfaceName;
import com.gooagoo.entity.generator.base.ShopInterfaceNameExample;
import com.gooagoo.entity.generator.base.ShopInterfaceNameKey;
import com.gooagoo.dao.generator.base.ShopInterfaceNameMapper;

@Service
public class ShopInterfaceNameGeneratorQueryServiceImpl implements ShopInterfaceNameGeneratorQueryService
{

    @Autowired
    private ShopInterfaceNameMapper shopInterfaceNameMapper;

    @Override
    public Integer countByExample(ShopInterfaceNameExample shopInterfaceNameExample) 
    {
        return this.shopInterfaceNameMapper.countByExample(shopInterfaceNameExample);
    }

    @Override
    public List<ShopInterfaceName> selectByExample(ShopInterfaceNameExample shopInterfaceNameExample) 
    {
        return this.shopInterfaceNameMapper.selectByExample(shopInterfaceNameExample);
    }

    @Override
    public ShopInterfaceName selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopInterfaceNameKey shopInterfaceNameKey = new ShopInterfaceNameKey();
        shopInterfaceNameKey.setIsDel("N");
        shopInterfaceNameKey.setId(primaryKey);
        return this.shopInterfaceNameMapper.selectByPrimaryKey(shopInterfaceNameKey);
    }

    @Override
    public ShopInterfaceName selectByPrimaryKey(String primaryKey) 
    {
        ShopInterfaceNameKey shopInterfaceNameKey = new ShopInterfaceNameKey();
        shopInterfaceNameKey.setId(primaryKey);
        return this.shopInterfaceNameMapper.selectByPrimaryKey(shopInterfaceNameKey);
    }

}
