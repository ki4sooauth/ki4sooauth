package com.gooagoo.core.generator.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.base.ShopInterfaceNameGeneratorCoreService;
import com.gooagoo.entity.generator.base.ShopInterfaceName;
import com.gooagoo.entity.generator.base.ShopInterfaceNameExample;
import com.gooagoo.entity.generator.base.ShopInterfaceNameKey;
import com.gooagoo.dao.generator.base.ShopInterfaceNameMapper;

@Service
public class ShopInterfaceNameGeneratorCoreServiceImpl implements ShopInterfaceNameGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(ShopInterfaceNameExample shopInterfaceNameExample) 
    {
        return this.shopInterfaceNameMapper.deleteByExample(shopInterfaceNameExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopInterfaceNameKey shopInterfaceNameKey = new ShopInterfaceNameKey();
        shopInterfaceNameKey.setId(primaryKey);
        return this.shopInterfaceNameMapper.deleteByPrimaryKey(shopInterfaceNameKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopInterfaceNameExample shopInterfaceNameExample) 
    {
        ShopInterfaceName shopInterfaceName = new ShopInterfaceName();
        shopInterfaceName.setIsDel("Y");
        return this.shopInterfaceNameMapper.updateByExampleSelective(shopInterfaceName,shopInterfaceNameExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopInterfaceName shopInterfaceName = new ShopInterfaceName();
        shopInterfaceName.setId(primaryKey);
        shopInterfaceName.setIsDel("Y");
        return this.shopInterfaceNameMapper.updateByPrimaryKeySelective(shopInterfaceName) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopInterfaceName shopInterfaceName) 
    {
        return this.shopInterfaceNameMapper.insertSelective(shopInterfaceName) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopInterfaceName shopInterfaceName,ShopInterfaceNameExample shopInterfaceNameExample) 
    {
        return this.shopInterfaceNameMapper.updateByExampleSelective(shopInterfaceName,shopInterfaceNameExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopInterfaceName shopInterfaceName) 
    {
        return this.shopInterfaceNameMapper.updateByPrimaryKeySelective(shopInterfaceName) > 0 ? true : false;
    }

}
