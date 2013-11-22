package com.gooagoo.query.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.sys.ShopAdGeneratorQueryService;
import com.gooagoo.entity.generator.sys.ShopAd;
import com.gooagoo.entity.generator.sys.ShopAdExample;
import com.gooagoo.entity.generator.sys.ShopAdKey;
import com.gooagoo.dao.generator.sys.ShopAdMapper;

@Service
public class ShopAdGeneratorQueryServiceImpl implements ShopAdGeneratorQueryService
{

    @Autowired
    private ShopAdMapper shopAdMapper;

    @Override
    public Integer countByExample(ShopAdExample shopAdExample) 
    {
        return this.shopAdMapper.countByExample(shopAdExample);
    }

    @Override
    public List<ShopAd> selectByExample(ShopAdExample shopAdExample) 
    {
        return this.shopAdMapper.selectByExample(shopAdExample);
    }

    @Override
    public ShopAd selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopAdKey shopAdKey = new ShopAdKey();
        shopAdKey.setIsDel("N");
        shopAdKey.setAdCode(primaryKey);
        return this.shopAdMapper.selectByPrimaryKey(shopAdKey);
    }

    @Override
    public ShopAd selectByPrimaryKey(String primaryKey) 
    {
        ShopAdKey shopAdKey = new ShopAdKey();
        shopAdKey.setAdCode(primaryKey);
        return this.shopAdMapper.selectByPrimaryKey(shopAdKey);
    }

}
