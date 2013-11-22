package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.ShopRoleAuthority2GeneratorCoreService;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority2;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority2Example;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority2Key;
import com.gooagoo.dao.generator.shop.ShopRoleAuthority2Mapper;

@Service
public class ShopRoleAuthority2GeneratorCoreServiceImpl implements ShopRoleAuthority2GeneratorCoreService
{

    @Autowired
    private ShopRoleAuthority2Mapper shopRoleAuthority2Mapper;

    @Override
    public Integer countByExample(ShopRoleAuthority2Example shopRoleAuthority2Example) 
    {
        return this.shopRoleAuthority2Mapper.countByExample(shopRoleAuthority2Example);
    }

    @Override
    public List<ShopRoleAuthority2> selectByExample(ShopRoleAuthority2Example shopRoleAuthority2Example) 
    {
        return this.shopRoleAuthority2Mapper.selectByExample(shopRoleAuthority2Example);
    }

    @Override
    public ShopRoleAuthority2 selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopRoleAuthority2Key shopRoleAuthority2Key = new ShopRoleAuthority2Key();
        shopRoleAuthority2Key.setIsDel("N");
        shopRoleAuthority2Key.setId(primaryKey);
        return this.shopRoleAuthority2Mapper.selectByPrimaryKey(shopRoleAuthority2Key);
    }

    @Override
    public ShopRoleAuthority2 selectByPrimaryKey(String primaryKey) 
    {
        ShopRoleAuthority2Key shopRoleAuthority2Key = new ShopRoleAuthority2Key();
        shopRoleAuthority2Key.setId(primaryKey);
        return this.shopRoleAuthority2Mapper.selectByPrimaryKey(shopRoleAuthority2Key);
    }

    @Override
    public boolean physicalDeleteByExample(ShopRoleAuthority2Example shopRoleAuthority2Example) 
    {
        return this.shopRoleAuthority2Mapper.deleteByExample(shopRoleAuthority2Example) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopRoleAuthority2Key shopRoleAuthority2Key = new ShopRoleAuthority2Key();
        shopRoleAuthority2Key.setId(primaryKey);
        return this.shopRoleAuthority2Mapper.deleteByPrimaryKey(shopRoleAuthority2Key) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopRoleAuthority2Example shopRoleAuthority2Example) 
    {
        ShopRoleAuthority2 shopRoleAuthority2 = new ShopRoleAuthority2();
        shopRoleAuthority2.setIsDel("Y");
        return this.shopRoleAuthority2Mapper.updateByExampleSelective(shopRoleAuthority2,shopRoleAuthority2Example) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopRoleAuthority2 shopRoleAuthority2 = new ShopRoleAuthority2();
        shopRoleAuthority2.setId(primaryKey);
        shopRoleAuthority2.setIsDel("Y");
        return this.shopRoleAuthority2Mapper.updateByPrimaryKeySelective(shopRoleAuthority2) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopRoleAuthority2 shopRoleAuthority2) 
    {
        return this.shopRoleAuthority2Mapper.insertSelective(shopRoleAuthority2) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopRoleAuthority2 shopRoleAuthority2,ShopRoleAuthority2Example shopRoleAuthority2Example) 
    {
        return this.shopRoleAuthority2Mapper.updateByExampleSelective(shopRoleAuthority2,shopRoleAuthority2Example) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopRoleAuthority2 shopRoleAuthority2) 
    {
        return this.shopRoleAuthority2Mapper.updateByPrimaryKeySelective(shopRoleAuthority2) > 0 ? true : false;
    }

}
