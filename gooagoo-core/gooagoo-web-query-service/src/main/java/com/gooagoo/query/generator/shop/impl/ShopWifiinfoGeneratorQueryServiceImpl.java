package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopWifiinfoGeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopWifiinfo;
import com.gooagoo.entity.generator.shop.ShopWifiinfoExample;
import com.gooagoo.entity.generator.shop.ShopWifiinfoKey;
import com.gooagoo.dao.generator.shop.ShopWifiinfoMapper;

@Service
public class ShopWifiinfoGeneratorQueryServiceImpl implements ShopWifiinfoGeneratorQueryService
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

}
