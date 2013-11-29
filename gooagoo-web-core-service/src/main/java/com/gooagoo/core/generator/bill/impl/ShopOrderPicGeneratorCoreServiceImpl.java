package com.gooagoo.core.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.bill.ShopOrderPicGeneratorCoreService;
import com.gooagoo.entity.generator.bill.ShopOrderPic;
import com.gooagoo.entity.generator.bill.ShopOrderPicExample;
import com.gooagoo.entity.generator.bill.ShopOrderPicKey;
import com.gooagoo.dao.generator.bill.ShopOrderPicMapper;

@Service
public class ShopOrderPicGeneratorCoreServiceImpl implements ShopOrderPicGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(ShopOrderPicExample shopOrderPicExample) 
    {
        return this.shopOrderPicMapper.deleteByExample(shopOrderPicExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopOrderPicKey shopOrderPicKey = new ShopOrderPicKey();
        shopOrderPicKey.setShopOrderDetailId(primaryKey);
        return this.shopOrderPicMapper.deleteByPrimaryKey(shopOrderPicKey) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopOrderPic shopOrderPic) 
    {
        return this.shopOrderPicMapper.insertSelective(shopOrderPic) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopOrderPic shopOrderPic,ShopOrderPicExample shopOrderPicExample) 
    {
        return this.shopOrderPicMapper.updateByExampleSelective(shopOrderPic,shopOrderPicExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopOrderPic shopOrderPic) 
    {
        return this.shopOrderPicMapper.updateByPrimaryKeySelective(shopOrderPic) > 0 ? true : false;
    }

}
