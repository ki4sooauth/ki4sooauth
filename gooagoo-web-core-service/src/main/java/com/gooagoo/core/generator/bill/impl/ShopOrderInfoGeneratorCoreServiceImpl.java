package com.gooagoo.core.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.bill.ShopOrderInfoGeneratorCoreService;
import com.gooagoo.entity.generator.bill.ShopOrderInfo;
import com.gooagoo.entity.generator.bill.ShopOrderInfoExample;
import com.gooagoo.entity.generator.bill.ShopOrderInfoKey;
import com.gooagoo.dao.generator.bill.ShopOrderInfoMapper;

@Service
public class ShopOrderInfoGeneratorCoreServiceImpl implements ShopOrderInfoGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(ShopOrderInfoExample shopOrderInfoExample) 
    {
        return this.shopOrderInfoMapper.deleteByExample(shopOrderInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopOrderInfoKey shopOrderInfoKey = new ShopOrderInfoKey();
        shopOrderInfoKey.setShopOrderId(primaryKey);
        return this.shopOrderInfoMapper.deleteByPrimaryKey(shopOrderInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopOrderInfoExample shopOrderInfoExample) 
    {
        ShopOrderInfo shopOrderInfo = new ShopOrderInfo();
        shopOrderInfo.setIsDel("Y");
        return this.shopOrderInfoMapper.updateByExampleSelective(shopOrderInfo,shopOrderInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopOrderInfo shopOrderInfo = new ShopOrderInfo();
        shopOrderInfo.setShopOrderId(primaryKey);
        shopOrderInfo.setIsDel("Y");
        return this.shopOrderInfoMapper.updateByPrimaryKeySelective(shopOrderInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopOrderInfo shopOrderInfo) 
    {
        return this.shopOrderInfoMapper.insertSelective(shopOrderInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopOrderInfo shopOrderInfo,ShopOrderInfoExample shopOrderInfoExample) 
    {
        return this.shopOrderInfoMapper.updateByExampleSelective(shopOrderInfo,shopOrderInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopOrderInfo shopOrderInfo) 
    {
        return this.shopOrderInfoMapper.updateByPrimaryKeySelective(shopOrderInfo) > 0 ? true : false;
    }

}
