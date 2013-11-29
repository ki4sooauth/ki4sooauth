package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.ShopWifiinfoGeneratorCoreService;
import com.gooagoo.entity.generator.shop.ShopWifiinfo;
import com.gooagoo.entity.generator.shop.ShopWifiinfoExample;
import com.gooagoo.entity.generator.shop.ShopWifiinfoKey;
import com.gooagoo.dao.generator.shop.ShopWifiinfoMapper;

@Service
public class ShopWifiinfoGeneratorCoreServiceImpl implements ShopWifiinfoGeneratorCoreService
{

    @Autowired
    private ShopWifiinfoMapper shopWifiinfoMapper;

    @Override
    public Integer countByExample(ShopWifiinfoExample shopWifiinfoExample) 
    {
        return this.shopWifiinfoMapper.countByExample(shopWifiinfoExample);
    }

    @Override
    public List<ShopWifiinfo> selectByExample(ShopWifiinfoExample shopWifiinfoExample) 
    {
        return this.shopWifiinfoMapper.selectByExample(shopWifiinfoExample);
    }

    @Override
    public ShopWifiinfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopWifiinfoKey shopWifiinfoKey = new ShopWifiinfoKey();
        shopWifiinfoKey.setIsDel("N");
        shopWifiinfoKey.setWifiInfoId(primaryKey);
        return this.shopWifiinfoMapper.selectByPrimaryKey(shopWifiinfoKey);
    }

    @Override
    public ShopWifiinfo selectByPrimaryKey(String primaryKey) 
    {
        ShopWifiinfoKey shopWifiinfoKey = new ShopWifiinfoKey();
        shopWifiinfoKey.setWifiInfoId(primaryKey);
        return this.shopWifiinfoMapper.selectByPrimaryKey(shopWifiinfoKey);
    }

    @Override
    public boolean physicalDeleteByExample(ShopWifiinfoExample shopWifiinfoExample) 
    {
        return this.shopWifiinfoMapper.deleteByExample(shopWifiinfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopWifiinfoKey shopWifiinfoKey = new ShopWifiinfoKey();
        shopWifiinfoKey.setWifiInfoId(primaryKey);
        return this.shopWifiinfoMapper.deleteByPrimaryKey(shopWifiinfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopWifiinfoExample shopWifiinfoExample) 
    {
        ShopWifiinfo shopWifiinfo = new ShopWifiinfo();
        shopWifiinfo.setIsDel("Y");
        return this.shopWifiinfoMapper.updateByExampleSelective(shopWifiinfo,shopWifiinfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopWifiinfo shopWifiinfo = new ShopWifiinfo();
        shopWifiinfo.setWifiInfoId(primaryKey);
        shopWifiinfo.setIsDel("Y");
        return this.shopWifiinfoMapper.updateByPrimaryKeySelective(shopWifiinfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopWifiinfo shopWifiinfo) 
    {
        return this.shopWifiinfoMapper.insertSelective(shopWifiinfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopWifiinfo shopWifiinfo,ShopWifiinfoExample shopWifiinfoExample) 
    {
        return this.shopWifiinfoMapper.updateByExampleSelective(shopWifiinfo,shopWifiinfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopWifiinfo shopWifiinfo) 
    {
        return this.shopWifiinfoMapper.updateByPrimaryKeySelective(shopWifiinfo) > 0 ? true : false;
    }

}
