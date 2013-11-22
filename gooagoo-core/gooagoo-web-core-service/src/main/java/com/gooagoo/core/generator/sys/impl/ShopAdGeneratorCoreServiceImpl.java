package com.gooagoo.core.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.sys.ShopAdGeneratorCoreService;
import com.gooagoo.entity.generator.sys.ShopAd;
import com.gooagoo.entity.generator.sys.ShopAdExample;
import com.gooagoo.entity.generator.sys.ShopAdKey;
import com.gooagoo.dao.generator.sys.ShopAdMapper;

@Service
public class ShopAdGeneratorCoreServiceImpl implements ShopAdGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(ShopAdExample shopAdExample) 
    {
        return this.shopAdMapper.deleteByExample(shopAdExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopAdKey shopAdKey = new ShopAdKey();
        shopAdKey.setAdCode(primaryKey);
        return this.shopAdMapper.deleteByPrimaryKey(shopAdKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopAdExample shopAdExample) 
    {
        ShopAd shopAd = new ShopAd();
        shopAd.setIsDel("Y");
        return this.shopAdMapper.updateByExampleSelective(shopAd,shopAdExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopAd shopAd = new ShopAd();
        shopAd.setAdCode(primaryKey);
        shopAd.setIsDel("Y");
        return this.shopAdMapper.updateByPrimaryKeySelective(shopAd) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopAd shopAd) 
    {
        return this.shopAdMapper.insertSelective(shopAd) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopAd shopAd,ShopAdExample shopAdExample) 
    {
        return this.shopAdMapper.updateByExampleSelective(shopAd,shopAdExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopAd shopAd) 
    {
        return this.shopAdMapper.updateByPrimaryKeySelective(shopAd) > 0 ? true : false;
    }

}
