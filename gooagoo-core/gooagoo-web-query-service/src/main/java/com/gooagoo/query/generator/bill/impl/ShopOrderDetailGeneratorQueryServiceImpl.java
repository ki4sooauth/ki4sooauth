package com.gooagoo.query.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.bill.ShopOrderDetailGeneratorQueryService;
import com.gooagoo.entity.generator.bill.ShopOrderDetail;
import com.gooagoo.entity.generator.bill.ShopOrderDetailExample;
import com.gooagoo.entity.generator.bill.ShopOrderDetailKey;
import com.gooagoo.dao.generator.bill.ShopOrderDetailMapper;

@Service
public class ShopOrderDetailGeneratorQueryServiceImpl implements ShopOrderDetailGeneratorQueryService
{

    @Autowired
    private ShopOrderDetailMapper shopOrderDetailMapper;

    @Override
    public Integer countByExample(ShopOrderDetailExample shopOrderDetailExample) 
    {
        return this.shopOrderDetailMapper.countByExample(shopOrderDetailExample);
    }

    @Override
    public List<ShopOrderDetail> selectByExample(ShopOrderDetailExample shopOrderDetailExample) 
    {
        return this.shopOrderDetailMapper.selectByExample(shopOrderDetailExample);
    }

    @Override
    public ShopOrderDetail selectByPrimaryKey(String primaryKey) 
    {
        ShopOrderDetailKey shopOrderDetailKey = new ShopOrderDetailKey();
        shopOrderDetailKey.setShopOrderDetailId(primaryKey);
        return this.shopOrderDetailMapper.selectByPrimaryKey(shopOrderDetailKey);
    }

}
