package com.gooagoo.query.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.bill.ShopOrderPicGeneratorQueryService;
import com.gooagoo.entity.generator.bill.ShopOrderPic;
import com.gooagoo.entity.generator.bill.ShopOrderPicExample;
import com.gooagoo.entity.generator.bill.ShopOrderPicKey;
import com.gooagoo.dao.generator.bill.ShopOrderPicMapper;

@Service
public class ShopOrderPicGeneratorQueryServiceImpl implements ShopOrderPicGeneratorQueryService
{

    @Autowired
    private ShopOrderPicMapper shopOrderPicMapper;

    @Override
    public Integer countByExample(ShopOrderPicExample shopOrderPicExample) 
    {
        return this.shopOrderPicMapper.countByExample(shopOrderPicExample);
    }

    @Override
    public List<ShopOrderPic> selectByExample(ShopOrderPicExample shopOrderPicExample) 
    {
        return this.shopOrderPicMapper.selectByExample(shopOrderPicExample);
    }

    @Override
    public ShopOrderPic selectByPrimaryKey(String primaryKey) 
    {
        ShopOrderPicKey shopOrderPicKey = new ShopOrderPicKey();
        shopOrderPicKey.setShopOrderDetailId(primaryKey);
        return this.shopOrderPicMapper.selectByPrimaryKey(shopOrderPicKey);
    }

}
