package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.ShopLidDetailGeneratorCoreService;
import com.gooagoo.entity.generator.shop.ShopLidDetail;
import com.gooagoo.entity.generator.shop.ShopLidDetailExample;
import com.gooagoo.entity.generator.shop.ShopLidDetailKey;
import com.gooagoo.dao.generator.shop.ShopLidDetailMapper;

@Service
public class ShopLidDetailGeneratorCoreServiceImpl implements ShopLidDetailGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(ShopLidDetailExample shopLidDetailExample) 
    {
        return this.shopLidDetailMapper.deleteByExample(shopLidDetailExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopLidDetailKey shopLidDetailKey = new ShopLidDetailKey();
        shopLidDetailKey.setLid(primaryKey);
        return this.shopLidDetailMapper.deleteByPrimaryKey(shopLidDetailKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopLidDetailExample shopLidDetailExample) 
    {
        ShopLidDetail shopLidDetail = new ShopLidDetail();
        shopLidDetail.setIsDel("Y");
        return this.shopLidDetailMapper.updateByExampleSelective(shopLidDetail,shopLidDetailExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopLidDetail shopLidDetail = new ShopLidDetail();
        shopLidDetail.setLid(primaryKey);
        shopLidDetail.setIsDel("Y");
        return this.shopLidDetailMapper.updateByPrimaryKeySelective(shopLidDetail) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopLidDetail shopLidDetail) 
    {
        return this.shopLidDetailMapper.insertSelective(shopLidDetail) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopLidDetail shopLidDetail,ShopLidDetailExample shopLidDetailExample) 
    {
        return this.shopLidDetailMapper.updateByExampleSelective(shopLidDetail,shopLidDetailExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopLidDetail shopLidDetail) 
    {
        return this.shopLidDetailMapper.updateByPrimaryKeySelective(shopLidDetail) > 0 ? true : false;
    }

}
