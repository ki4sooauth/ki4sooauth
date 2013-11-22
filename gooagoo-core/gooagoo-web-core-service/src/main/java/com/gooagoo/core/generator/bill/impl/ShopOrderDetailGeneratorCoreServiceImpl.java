package com.gooagoo.core.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.bill.ShopOrderDetailGeneratorCoreService;
import com.gooagoo.entity.generator.bill.ShopOrderDetail;
import com.gooagoo.entity.generator.bill.ShopOrderDetailExample;
import com.gooagoo.entity.generator.bill.ShopOrderDetailKey;
import com.gooagoo.dao.generator.bill.ShopOrderDetailMapper;

@Service
public class ShopOrderDetailGeneratorCoreServiceImpl implements ShopOrderDetailGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(ShopOrderDetailExample shopOrderDetailExample) 
    {
        return this.shopOrderDetailMapper.deleteByExample(shopOrderDetailExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopOrderDetailKey shopOrderDetailKey = new ShopOrderDetailKey();
        shopOrderDetailKey.setShopOrderDetailId(primaryKey);
        return this.shopOrderDetailMapper.deleteByPrimaryKey(shopOrderDetailKey) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopOrderDetail shopOrderDetail) 
    {
        return this.shopOrderDetailMapper.insertSelective(shopOrderDetail) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopOrderDetail shopOrderDetail,ShopOrderDetailExample shopOrderDetailExample) 
    {
        return this.shopOrderDetailMapper.updateByExampleSelective(shopOrderDetail,shopOrderDetailExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopOrderDetail shopOrderDetail) 
    {
        return this.shopOrderDetailMapper.updateByPrimaryKeySelective(shopOrderDetail) > 0 ? true : false;
    }

}
