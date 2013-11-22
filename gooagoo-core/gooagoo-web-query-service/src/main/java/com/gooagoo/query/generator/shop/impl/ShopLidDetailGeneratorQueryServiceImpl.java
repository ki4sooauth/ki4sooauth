package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopLidDetailGeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopLidDetail;
import com.gooagoo.entity.generator.shop.ShopLidDetailExample;
import com.gooagoo.entity.generator.shop.ShopLidDetailKey;
import com.gooagoo.dao.generator.shop.ShopLidDetailMapper;

@Service
public class ShopLidDetailGeneratorQueryServiceImpl implements ShopLidDetailGeneratorQueryService
{

    @Autowired
    private ShopLidDetailMapper shopLidDetailMapper;

    @Override
    public Integer countByExample(ShopLidDetailExample shopLidDetailExample) 
    {
        return this.shopLidDetailMapper.countByExample(shopLidDetailExample);
    }

    @Override
    public List<ShopLidDetail> selectByExample(ShopLidDetailExample shopLidDetailExample) 
    {
        return this.shopLidDetailMapper.selectByExample(shopLidDetailExample);
    }

    @Override
    public ShopLidDetail selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopLidDetailKey shopLidDetailKey = new ShopLidDetailKey();
        shopLidDetailKey.setIsDel("N");
        shopLidDetailKey.setLid(primaryKey);
        return this.shopLidDetailMapper.selectByPrimaryKey(shopLidDetailKey);
    }

    @Override
    public ShopLidDetail selectByPrimaryKey(String primaryKey) 
    {
        ShopLidDetailKey shopLidDetailKey = new ShopLidDetailKey();
        shopLidDetailKey.setLid(primaryKey);
        return this.shopLidDetailMapper.selectByPrimaryKey(shopLidDetailKey);
    }

}
