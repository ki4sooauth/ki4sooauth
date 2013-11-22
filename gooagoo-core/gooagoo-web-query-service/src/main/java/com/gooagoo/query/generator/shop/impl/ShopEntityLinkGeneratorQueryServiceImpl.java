package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopEntityLinkGeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopEntityLink;
import com.gooagoo.entity.generator.shop.ShopEntityLinkExample;
import com.gooagoo.entity.generator.shop.ShopEntityLinkKey;
import com.gooagoo.dao.generator.shop.ShopEntityLinkMapper;

@Service
public class ShopEntityLinkGeneratorQueryServiceImpl implements ShopEntityLinkGeneratorQueryService
{

    @Autowired
    private ShopEntityLinkMapper shopEntityLinkMapper;

    @Override
    public Integer countByExample(ShopEntityLinkExample shopEntityLinkExample) 
    {
        return this.shopEntityLinkMapper.countByExample(shopEntityLinkExample);
    }

    @Override
    public List<ShopEntityLink> selectByExample(ShopEntityLinkExample shopEntityLinkExample) 
    {
        return this.shopEntityLinkMapper.selectByExample(shopEntityLinkExample);
    }

    @Override
    public ShopEntityLink selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopEntityLinkKey shopEntityLinkKey = new ShopEntityLinkKey();
        shopEntityLinkKey.setIsDel("N");
        shopEntityLinkKey.setShopEntityId(primaryKey);
        return this.shopEntityLinkMapper.selectByPrimaryKey(shopEntityLinkKey);
    }

    @Override
    public ShopEntityLink selectByPrimaryKey(String primaryKey) 
    {
        ShopEntityLinkKey shopEntityLinkKey = new ShopEntityLinkKey();
        shopEntityLinkKey.setShopEntityId(primaryKey);
        return this.shopEntityLinkMapper.selectByPrimaryKey(shopEntityLinkKey);
    }

}
