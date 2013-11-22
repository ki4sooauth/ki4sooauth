package com.gooagoo.query.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.bill.ShopOrderInfoGeneratorQueryService;
import com.gooagoo.entity.generator.bill.ShopOrderInfo;
import com.gooagoo.entity.generator.bill.ShopOrderInfoExample;
import com.gooagoo.entity.generator.bill.ShopOrderInfoKey;
import com.gooagoo.dao.generator.bill.ShopOrderInfoMapper;

@Service
public class ShopOrderInfoGeneratorQueryServiceImpl implements ShopOrderInfoGeneratorQueryService
{

    @Autowired
    private ShopOrderInfoMapper shopOrderInfoMapper;

    @Override
    public Integer countByExample(ShopOrderInfoExample shopOrderInfoExample) 
    {
        return this.shopOrderInfoMapper.countByExample(shopOrderInfoExample);
    }

    @Override
    public List<ShopOrderInfo> selectByExample(ShopOrderInfoExample shopOrderInfoExample) 
    {
        return this.shopOrderInfoMapper.selectByExample(shopOrderInfoExample);
    }

    @Override
    public ShopOrderInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopOrderInfoKey shopOrderInfoKey = new ShopOrderInfoKey();
        shopOrderInfoKey.setIsDel("N");
        shopOrderInfoKey.setShopOrderId(primaryKey);
        return this.shopOrderInfoMapper.selectByPrimaryKey(shopOrderInfoKey);
    }

    @Override
    public ShopOrderInfo selectByPrimaryKey(String primaryKey) 
    {
        ShopOrderInfoKey shopOrderInfoKey = new ShopOrderInfoKey();
        shopOrderInfoKey.setShopOrderId(primaryKey);
        return this.shopOrderInfoMapper.selectByPrimaryKey(shopOrderInfoKey);
    }

}
