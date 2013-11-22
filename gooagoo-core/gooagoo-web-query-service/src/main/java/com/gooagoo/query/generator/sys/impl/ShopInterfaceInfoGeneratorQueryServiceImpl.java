package com.gooagoo.query.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.sys.ShopInterfaceInfoGeneratorQueryService;
import com.gooagoo.entity.generator.sys.ShopInterfaceInfo;
import com.gooagoo.entity.generator.sys.ShopInterfaceInfoExample;
import com.gooagoo.entity.generator.sys.ShopInterfaceInfoKey;
import com.gooagoo.dao.generator.sys.ShopInterfaceInfoMapper;

@Service
public class ShopInterfaceInfoGeneratorQueryServiceImpl implements ShopInterfaceInfoGeneratorQueryService
{

    @Autowired
    private ShopInterfaceInfoMapper shopInterfaceInfoMapper;

    @Override
    public Integer countByExample(ShopInterfaceInfoExample shopInterfaceInfoExample) 
    {
        return this.shopInterfaceInfoMapper.countByExample(shopInterfaceInfoExample);
    }

    @Override
    public List<ShopInterfaceInfo> selectByExample(ShopInterfaceInfoExample shopInterfaceInfoExample) 
    {
        return this.shopInterfaceInfoMapper.selectByExample(shopInterfaceInfoExample);
    }

    @Override
    public ShopInterfaceInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopInterfaceInfoKey shopInterfaceInfoKey = new ShopInterfaceInfoKey();
        shopInterfaceInfoKey.setIsDel("N");
        shopInterfaceInfoKey.setId(primaryKey);
        return this.shopInterfaceInfoMapper.selectByPrimaryKey(shopInterfaceInfoKey);
    }

    @Override
    public ShopInterfaceInfo selectByPrimaryKey(String primaryKey) 
    {
        ShopInterfaceInfoKey shopInterfaceInfoKey = new ShopInterfaceInfoKey();
        shopInterfaceInfoKey.setId(primaryKey);
        return this.shopInterfaceInfoMapper.selectByPrimaryKey(shopInterfaceInfoKey);
    }

}
