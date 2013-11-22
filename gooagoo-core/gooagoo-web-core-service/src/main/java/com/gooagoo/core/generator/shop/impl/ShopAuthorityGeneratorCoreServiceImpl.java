package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.ShopAuthorityGeneratorCoreService;
import com.gooagoo.entity.generator.shop.ShopAuthority;
import com.gooagoo.entity.generator.shop.ShopAuthorityExample;
import com.gooagoo.entity.generator.shop.ShopAuthorityKey;
import com.gooagoo.dao.generator.shop.ShopAuthorityMapper;

@Service
public class ShopAuthorityGeneratorCoreServiceImpl implements ShopAuthorityGeneratorCoreService
{

    @Autowired
    private ShopAuthorityMapper shopAuthorityMapper;

    @Override
    public Integer countByExample(ShopAuthorityExample shopAuthorityExample) 
    {
        return this.shopAuthorityMapper.countByExample(shopAuthorityExample);
    }

    @Override
    public List<ShopAuthority> selectByExample(ShopAuthorityExample shopAuthorityExample) 
    {
        return this.shopAuthorityMapper.selectByExample(shopAuthorityExample);
    }

    @Override
    public ShopAuthority selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopAuthorityKey shopAuthorityKey = new ShopAuthorityKey();
        shopAuthorityKey.setIsDel("N");
        shopAuthorityKey.setAuthorityId(primaryKey);
        return this.shopAuthorityMapper.selectByPrimaryKey(shopAuthorityKey);
    }

    @Override
    public ShopAuthority selectByPrimaryKey(String primaryKey) 
    {
        ShopAuthorityKey shopAuthorityKey = new ShopAuthorityKey();
        shopAuthorityKey.setAuthorityId(primaryKey);
        return this.shopAuthorityMapper.selectByPrimaryKey(shopAuthorityKey);
    }

    @Override
    public boolean physicalDeleteByExample(ShopAuthorityExample shopAuthorityExample) 
    {
        return this.shopAuthorityMapper.deleteByExample(shopAuthorityExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopAuthorityKey shopAuthorityKey = new ShopAuthorityKey();
        shopAuthorityKey.setAuthorityId(primaryKey);
        return this.shopAuthorityMapper.deleteByPrimaryKey(shopAuthorityKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopAuthorityExample shopAuthorityExample) 
    {
        ShopAuthority shopAuthority = new ShopAuthority();
        shopAuthority.setIsDel("Y");
        return this.shopAuthorityMapper.updateByExampleSelective(shopAuthority,shopAuthorityExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopAuthority shopAuthority = new ShopAuthority();
        shopAuthority.setAuthorityId(primaryKey);
        shopAuthority.setIsDel("Y");
        return this.shopAuthorityMapper.updateByPrimaryKeySelective(shopAuthority) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopAuthority shopAuthority) 
    {
        return this.shopAuthorityMapper.insertSelective(shopAuthority) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopAuthority shopAuthority,ShopAuthorityExample shopAuthorityExample) 
    {
        return this.shopAuthorityMapper.updateByExampleSelective(shopAuthority,shopAuthorityExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopAuthority shopAuthority) 
    {
        return this.shopAuthorityMapper.updateByPrimaryKeySelective(shopAuthority) > 0 ? true : false;
    }

}
